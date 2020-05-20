package com.cnlaunch.diagnosemodule.utils;

import android.content.Context;
import android.net.LocalSocket;
import android.net.LocalSocketAddress;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.system.OsConstants;
import android.util.Log;
import com.cnlaunch.diagnosemodule.service.DiagnoseService;
import com.cnlaunch.physics.p205k.C1856n;
import com.cnlaunch.translate.TranslateManager;
import com.mopub.mobileads.VastExtensionXmlManager;
import java.io.BufferedReader;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
public class LocalSocketClient extends Thread {
    private static LocalSocket Client = null;
    public static final int LOCAL_SOCKET_STATE_TYPE_BROKEN_PIPE = 2;
    public static final int LOCAL_SOCKET_STATE_TYPE_CONNECT_FAIL = 1;
    private static final String TAG = "LocalSocketClient";
    public static final Lock commandWaitLock;
    private static final String name = "com.cnlaunch.diagnose.localsocket";
    public static final Condition notReceiverCommand;
    private Context mContext;
    private static ConcurrentLinkedQueue<DiagnoseRequestCommand> mCommandQueue = new ConcurrentLinkedQueue<>();
    private static boolean isFlashCode = false;
    private static String mBluetoothCommand = "";
    private int timeout = TranslateManager.TIME_OUT;
    private boolean isStop = false;

    static {
        ReentrantLock reentrantLock = new ReentrantLock();
        commandWaitLock = reentrantLock;
        notReceiverCommand = reentrantLock.newCondition();
    }

    public static synchronized String getBluetoothCommand() {
        String str;
        synchronized (LocalSocketClient.class) {
            str = mBluetoothCommand;
        }
        return str;
    }

    public static synchronized void setBluetoothCommand(String str) {
        synchronized (LocalSocketClient.class) {
            mBluetoothCommand = str;
        }
    }

    public static synchronized void setFlashCode(boolean z) {
        synchronized (LocalSocketClient.class) {
            isFlashCode = z;
        }
    }

    private static synchronized boolean getFlashCode() {
        boolean z;
        synchronized (LocalSocketClient.class) {
            z = isFlashCode;
        }
        return z;
    }

    public static void setMaxWaitTime(int i) {
        LocalSocket localSocket = Client;
        if (localSocket != null) {
            try {
                localSocket.setSoTimeout(i);
                if (Build.VERSION.SDK_INT == 24) {
                    if (C1856n.f10135a) {
                        C1856n.m8130a(TAG, "android 7.0 setSoTimeout plus");
                    }
                    try {
                        Class.forName("android.system.Os").getMethod("setsockoptTimeval", FileDescriptor.class, Integer.TYPE, Integer.TYPE, Class.forName("android.system.StructTimeval")).invoke(null, Client.getFileDescriptor(), Integer.valueOf(OsConstants.SOL_SOCKET), Integer.valueOf(OsConstants.SO_RCVTIMEO), Class.forName("android.system.StructTimeval").getMethod("fromMillis", Long.TYPE).invoke(null, Integer.valueOf(i)));
                    } catch (Exception e) {
                        Log.e(TAG, "Platform error: " + e.toString());
                    }
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        connect();
        if (Client == null) {
            C1856n.m8130a(TAG, "连接服务器失败");
            sendLocalSocketStateMessage(1);
            return;
        }
        byte[] bArr = new byte[1024];
        while (!getStopFlag()) {
            if (!mCommandQueue.isEmpty()) {
                DiagnoseRequestCommand poll = mCommandQueue.poll();
                if (poll.getCommandType() == 1) {
                    try {
                        if (Client.getInputStream().available() > 0) {
                            int read = Client.getInputStream().read(bArr);
                            while (read == 1024 && Client.getInputStream().available() > 0) {
                                Client.getInputStream().read(bArr);
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    send(poll.getCommand());
                    String recv = recv();
                    commandWaitLock.lock();
                    try {
                        setBluetoothCommand(recv);
                        notReceiverCommand.signal();
                    } finally {
                    }
                } else if (poll.getCommandType() == 2) {
                    try {
                        if (Client.getInputStream().available() > 0) {
                            int read2 = Client.getInputStream().read(bArr);
                            while (read2 == 1024 && Client.getInputStream().available() > 0) {
                                Client.getInputStream().read(bArr);
                            }
                        }
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    send(poll.getCommand());
                    if (C1856n.f10135a) {
                        C1856n.m8130a(TAG, " send end DiagnoseRequestCommand.COMMAND_TYPE_ONE_TO_MORE");
                    }
                }
            } else if (getFlashCode()) {
                setFlashCode(false);
                String recv2 = recv();
                commandWaitLock.lock();
                try {
                    setBluetoothCommand(recv2);
                    notReceiverCommand.signal();
                } finally {
                }
            } else {
                try {
                    Thread.sleep(5L);
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
            }
        }
        try {
            if (Client == null || !Client.isConnected()) {
                return;
            }
            Client.close();
        } catch (IOException e4) {
            e4.printStackTrace();
        }
    }

    private synchronized boolean getStopFlag() {
        return this.isStop;
    }

    public synchronized void stopThread() {
        try {
            if (Client != null && Client.isConnected()) {
                Client.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.isStop = true;
        mCommandQueue.clear();
    }

    public void connect() {
        try {
            Client = new LocalSocket();
            LocalSocketAddress localSocketAddress = new LocalSocketAddress(name);
            if (!Client.isBound()) {
                C1856n.m8130a(TAG, "Client not bound");
            } else {
                C1856n.m8130a(TAG, "Client had bound");
            }
            Client.connect(localSocketAddress);
            Client.setSoTimeout(this.timeout);
            Client.setReceiveBufferSize(32768);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void send(byte[] bArr) {
        try {
            Client.getOutputStream().write(bArr);
            Client.getOutputStream().flush();
        } catch (IOException e) {
            e.printStackTrace();
            if (e.getMessage().toLowerCase().contains("Broken pipe")) {
                sendLocalSocketStateMessage(2);
            }
        }
    }

    public String recv() {
        try {
            return new BufferedReader(new InputStreamReader(Client.getInputStream())).readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void offerLogPackage(DiagnoseRequestCommand diagnoseRequestCommand) {
        mCommandQueue.offer(diagnoseRequestCommand);
    }

    /* loaded from: classes.dex */
    public static class DiagnoseRequestCommand {
        public static final byte COMMAND_TYPE_ONE_TO_MORE = 2;
        public static final byte COMMAND_TYPE_ONE_TO_ONE = 1;
        private byte[] mCommand;
        private byte mCommandType;

        public DiagnoseRequestCommand() {
            this.mCommand = null;
            setCommandType((byte) 1);
        }

        public DiagnoseRequestCommand(byte[] bArr, byte b) {
            setCommand(bArr);
            setCommandType(b);
        }

        public byte[] getCommand() {
            return this.mCommand;
        }

        public void setCommand(byte[] bArr) {
            this.mCommand = bArr;
        }

        public byte getCommandType() {
            return this.mCommandType;
        }

        public void setCommandType(byte b) {
            this.mCommandType = b;
        }
    }

    public void setContext(Context context) {
        this.mContext = context;
    }

    private void sendLocalSocketStateMessage(int i) {
        Message obtain = Message.obtain((Handler) null, 105);
        Bundle bundle = new Bundle();
        bundle.putInt(VastExtensionXmlManager.TYPE, i);
        obtain.setData(bundle);
        if (C1856n.f10135a) {
            C1856n.m8125d(TAG, "sendLocalSocketStateMessage type =".concat(String.valueOf(i)));
        }
        DiagnoseService.sendClientMessage(this.mContext, obtain);
    }
}
