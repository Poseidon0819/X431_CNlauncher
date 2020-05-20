package com.ifoer.expedition.cto;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import com.cnlaunch.diagnosemodule.DiagnoseBusiness;
import com.cnlaunch.diagnosemodule.bean.PageInteractiveData;
import com.cnlaunch.diagnosemodule.service.DiagnoseService;
import com.cnlaunch.diagnosemodule.utils.AndroidToLan;
import com.cnlaunch.diagnosemodule.utils.ByteHexHelper;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.diagnosemodule.utils.DiagnoseLogUtil;
import com.cnlaunch.diagnosemodule.utils.LocalSocketClient;
import com.cnlaunch.diagnosemodule.utils.OrderMontage;
import com.cnlaunch.diagnosemodule.utils.StorageUtil;
import com.cnlaunch.p120d.p130d.SystemPropertiesInvoke;
import com.cnlaunch.p182k.RJ45LinkManager;
import com.cnlaunch.p182k.TCPHandler;
import com.cnlaunch.p182k.TCPSocketController;
import com.cnlaunch.p182k.UDPController;
import com.cnlaunch.physics.p205k.C1856n;
import com.cnlaunch.physics.p205k.Tools;
import com.ifoer.expedition.ndk.StdJni;
import com.ifoer.expedition.ndk.VINStdJni;
import com.mopub.mobileads.VastExtensionXmlManager;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
public class CToJavaImplements {
    public static final int CLIENT_SetEthNetAttr = 2;
    public static final int CLIENT_SetEthNetState = 3;
    public static final int CLIENT_SetWifiState = 4;
    public static final int ETHERNET_TYPE = 1;
    public static final int MOBILE_TYPE = 3;
    public static final int NONNET_TYPE = -1;
    public static final int PADIII_SUPPORT_LAN_DHCP = 6;
    public static final int SERVICE_Established = 0;
    public static final int SERVICE_SetEthNetAttr = 1;
    public static final int SERVICE_SetEthNetState = 5;
    public static final int SERVICE_SetWifiState = 6;
    public static final int SMARTBOX_TYPE = 5;
    private static final String TAG = "CToJavaImplements";
    public static final int UNKOWNNET_TYPE = 4;
    public static final int WIFI_TYPE = 2;
    private static boolean isLaunchTCP = false;
    private static boolean mBound;
    private static ServiceConnection mConnection;
    private static Messenger mMessenger;
    private static Messenger mService;
    private static String mVehicleSdPath;
    public static int returnValue;
    public static final Condition setEthNetCondition;
    public static final Lock setEthNetWaitLock;
    private static Thread thread;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void getGGPname(String str) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void notifyError(int i) {
    }

    static {
        ReentrantLock reentrantLock = new ReentrantLock();
        setEthNetWaitLock = reentrantLock;
        setEthNetCondition = reentrantLock.newCondition();
        mService = null;
        mConnection = null;
        thread = null;
        returnValue = -1;
        mVehicleSdPath = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setVehicleSdPath(String str) {
        mVehicleSdPath = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getVehicleSdPath() {
        return mVehicleSdPath;
    }

    static ServiceConnection getServiceConnection() {
        ServiceConnection serviceConnection = mConnection;
        if (serviceConnection != null) {
            return serviceConnection;
        }
        ServiceConnection serviceConnection2 = new ServiceConnection() { // from class: com.ifoer.expedition.cto.CToJavaImplements.1
            @Override // android.content.ServiceConnection
            public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                Messenger unused = CToJavaImplements.mService = new Messenger(iBinder);
                Message obtain = Message.obtain((Handler) null, 0);
                obtain.replyTo = CToJavaImplements.mMessenger;
                CToJavaImplements.sendServerMessage(obtain);
                boolean unused2 = CToJavaImplements.mBound = true;
            }

            @Override // android.content.ServiceConnection
            public final void onServiceDisconnected(ComponentName componentName) {
                Messenger unused = CToJavaImplements.mService = null;
                boolean unused2 = CToJavaImplements.mBound = false;
            }
        };
        mConnection = serviceConnection2;
        return serviceConnection2;
    }

    static void sendServerMessage(Message message2) {
        Messenger messenger = mService;
        if (messenger != null) {
            try {
                messenger.send(message2);
            } catch (DeadObjectException unused) {
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void SetMessageInfo(Messenger messenger) {
        mMessenger = messenger;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String GetEthernetIp(Context context) throws SocketException {
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        while (networkInterfaces.hasMoreElements()) {
            NetworkInterface nextElement = networkInterfaces.nextElement();
            if (nextElement.getName().toLowerCase().equals("eth0")) {
                Enumeration<InetAddress> inetAddresses = nextElement.getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement2 = inetAddresses.nextElement();
                    if (!nextElement2.isLoopbackAddress()) {
                        String str = nextElement2.getHostAddress().toString();
                        if (!str.contains("::")) {
                            return str;
                        }
                    }
                }
                continue;
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int GetNetWorkType(Context context) {
        if (Tools.m8094e(context, DiagnoseConstants.DEVICE_SERIALNO)) {
            return 5;
        }
        if (SystemPropertiesInvoke.m9431a("ro.support_lan_dhcp")) {
            if (C1856n.f10135a) {
                C1856n.m8130a(TAG, "ro.support_lan_dhcp is true");
                C1856n.m8130a(TAG, "com.bsk.broadcast.start.eth.service send");
            }
            context.sendBroadcast(new Intent("com.bsk.broadcast.start.eth.service"));
            return 6;
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return -1;
            }
            int type = activeNetworkInfo.getType();
            if (type == 9 && activeNetworkInfo.isAvailable() && activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED) {
                return 1;
            }
            if (type == 1 && activeNetworkInfo.isAvailable() && activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED) {
                return 2;
            }
            if (type == 0 && activeNetworkInfo.isAvailable()) {
                return activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED ? 3 : 4;
            }
            return 4;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getAvailableExternalStorage(Context context) {
        return StorageUtil.getAvailableExternalStorage(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean IsSetEthNetAttrSuccess() {
        return returnValue == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void UnBindEthService(Context context) {
        if (mBound) {
            context.unbindService(mConnection);
            mBound = false;
        }
        returnValue = -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void SetEthNetAttr(Context context, final String str, final String str2, final String str3) {
        returnValue = -1;
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.cnlaunch.ethernetservice", "com.cnlaunch.service.EtherNetService"));
        if (context.bindService(intent, getServiceConnection(), 1)) {
            Thread thread2 = new Thread(new Runnable() { // from class: com.ifoer.expedition.cto.CToJavaImplements.2
                @Override // java.lang.Runnable
                public final void run() {
                    Lock lock;
                    try {
                        CToJavaImplements.setEthNetWaitLock.lock();
                        try {
                            CToJavaImplements.setEthNetCondition.await(3000L, TimeUnit.MILLISECONDS);
                            lock = CToJavaImplements.setEthNetWaitLock;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            lock = CToJavaImplements.setEthNetWaitLock;
                        }
                        lock.unlock();
                        Bundle bundle = new Bundle();
                        bundle.putString("IP", str);
                        bundle.putString("NetMask", str2);
                        bundle.putString("GateWay", str3);
                        Message obtain = Message.obtain((Handler) null, 2);
                        obtain.replyTo = CToJavaImplements.mMessenger;
                        obtain.setData(bundle);
                        CToJavaImplements.sendServerMessage(obtain);
                        CToJavaImplements.setEthNetWaitLock.lock();
                        try {
                            CToJavaImplements.setEthNetCondition.await(3000L, TimeUnit.MILLISECONDS);
                            CToJavaImplements.setEthNetWaitLock.unlock();
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                            CToJavaImplements.setEthNetWaitLock.unlock();
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
            });
            thread = thread2;
            thread2.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void SetEthNetState(Context context, final boolean z) {
        returnValue = -1;
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.cnlaunch.ethernetservice", "com.cnlaunch.service.EtherNetService"));
        if (context.bindService(intent, getServiceConnection(), 1)) {
            Thread thread2 = new Thread(new Runnable() { // from class: com.ifoer.expedition.cto.CToJavaImplements.3
                @Override // java.lang.Runnable
                public final void run() {
                    Lock lock;
                    try {
                        CToJavaImplements.setEthNetWaitLock.lock();
                        try {
                            CToJavaImplements.setEthNetCondition.await(3000L, TimeUnit.MILLISECONDS);
                            lock = CToJavaImplements.setEthNetWaitLock;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            lock = CToJavaImplements.setEthNetWaitLock;
                        }
                        lock.unlock();
                        Bundle bundle = new Bundle();
                        bundle.putBoolean("State", z);
                        Message obtain = Message.obtain((Handler) null, 3);
                        obtain.replyTo = CToJavaImplements.mMessenger;
                        obtain.setData(bundle);
                        CToJavaImplements.sendServerMessage(obtain);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            });
            thread = thread2;
            thread2.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void SetWifiState(Context context, final boolean z) {
        returnValue = -1;
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.cnlaunch.ethernetservice", "com.cnlaunch.service.EtherNetService"));
        if (context.bindService(intent, getServiceConnection(), 1)) {
            Thread thread2 = new Thread(new Runnable() { // from class: com.ifoer.expedition.cto.CToJavaImplements.4
                @Override // java.lang.Runnable
                public final void run() {
                    Lock lock;
                    try {
                        CToJavaImplements.setEthNetWaitLock.lock();
                        try {
                            CToJavaImplements.setEthNetCondition.await(3000L, TimeUnit.MILLISECONDS);
                            lock = CToJavaImplements.setEthNetWaitLock;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            lock = CToJavaImplements.setEthNetWaitLock;
                        }
                        lock.unlock();
                        Bundle bundle = new Bundle();
                        bundle.putBoolean("State", z);
                        Message obtain = Message.obtain((Handler) null, 4);
                        obtain.replyTo = CToJavaImplements.mMessenger;
                        obtain.setData(bundle);
                        CToJavaImplements.sendServerMessage(obtain);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            });
            thread = thread2;
            thread2.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean GetWifiState(Context context) {
        return ((WifiManager) context.getSystemService("wifi")).getWifiState() == 3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int OpenTcpConnect(String str, int i) {
        if (C1856n.f10135a) {
            C1856n.m8130a(TAG, String.format("OpenTcpConnect ip=%s,port=%s", str, Integer.valueOf(i)));
        }
        RJ45LinkManager.m8645a().f9487a.m8638a(str, i, new TCPHandler() { // from class: com.ifoer.expedition.cto.CToJavaImplements.5
            @Override // com.cnlaunch.p182k.TCPHandler
            public final void connectFailed() {
                boolean unused = CToJavaImplements.isLaunchTCP = false;
            }

            @Override // com.cnlaunch.p182k.TCPHandler
            public final void socketTimeOut() {
                boolean unused = CToJavaImplements.isLaunchTCP = false;
            }

            @Override // com.cnlaunch.p182k.TCPHandler
            public final void connectSuccess() {
                boolean unused = CToJavaImplements.isLaunchTCP = true;
            }

            @Override // com.cnlaunch.p182k.TCPHandler
            public final void connectClosed() {
                boolean unused = CToJavaImplements.isLaunchTCP = false;
            }
        });
        return isLaunchTCP ? 0 : -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int CloseTcpConnect() {
        RJ45LinkManager.m8645a().f9487a.m8636b();
        isLaunchTCP = false;
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int SendDataByTcp(byte[] bArr, int i) {
        if (isLaunchTCP) {
            RJ45LinkManager.m8645a().f9487a.m8640a();
            byte[] bArr2 = new byte[bArr.length + 1];
            bArr2[0] = 0;
            System.arraycopy(bArr, 0, bArr2, 1, bArr.length);
            diagnoseLogRecordForTCPUDPData(bArr2, (byte) 9);
            return RJ45LinkManager.m8645a().f9487a.m8637a(bArr);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] ReceiveDataByTcp(byte[] bArr, int i, int i2) {
        if (!isLaunchTCP) {
            return new byte[0];
        }
        byte[] m8639a = RJ45LinkManager.m8645a().f9487a.m8639a(i2);
        if (m8639a != null && m8639a.length > 0) {
            byte[] bArr2 = new byte[m8639a.length + 1];
            bArr2[0] = 0;
            System.arraycopy(m8639a, 0, bArr2, 1, m8639a.length);
            diagnoseLogRecordForTCPUDPData(bArr2, (byte) 10);
        }
        return m8639a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] SendAndReceiveUdpData(byte[] bArr, int i, int i2, String str) {
        diagnoseLogRecordForTCPUDPData(bArr, (byte) 11);
        byte[] m8642a = RJ45LinkManager.m8645a().m8642a(i2, i, bArr, str);
        if (m8642a != null && m8642a.length > 0) {
            diagnoseLogRecordForTCPUDPData(m8642a, (byte) 12);
        }
        return m8642a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] ReceiveUdpData(int i, int i2) {
        byte[] m8643a = RJ45LinkManager.m8645a().m8643a(i2, i);
        if (m8643a != null && m8643a.length > 0) {
            diagnoseLogRecordForTCPUDPData(m8643a, (byte) 12);
        }
        return m8643a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String GetServerIP() {
        RJ45LinkManager.m8645a();
        return UDPController.f9506c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int GetServerPort() {
        RJ45LinkManager.m8645a();
        return UDPController.f9507d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void NotifyNotQuitCar(boolean z, Context context) {
        if (context != null) {
            DiagnoseService diagnoseService = context instanceof DiagnoseService ? (DiagnoseService) context : null;
            if (diagnoseService != null) {
                Message obtain = Message.obtain((Handler) null, 58);
                Bundle bundle = new Bundle();
                bundle.putBoolean("device_not_quit_car_key", z);
                obtain.setData(bundle);
                diagnoseService.sendClientMessage(obtain);
                try {
                    Thread.sleep(500L);
                    return;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return;
                }
            }
            return;
        }
        C1856n.m8130a(TAG, "NotifyNotQuitCar start context is null");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String GetAppVehicleVersionPath() {
        return DiagnoseConstants.APP_VEHICLE_VERSION_PATH;
    }

    public static int GetConnectorLinkMode(Context context) {
        int deviceLinkMode = DiagnoseService.getDeviceLinkMode();
        if (C1856n.f10135a) {
            C1856n.m8130a(TAG, "Get Connector Link Mode=".concat(String.valueOf(deviceLinkMode)));
        }
        return deviceLinkMode;
    }

    public static boolean GetConnectorReady(Context context) {
        boolean z;
        if (context != null) {
            DiagnoseService diagnoseService = context instanceof DiagnoseService ? (DiagnoseService) context : null;
            if (diagnoseService == null) {
                return false;
            }
            int i = 1;
            do {
                if (!diagnoseService.isReconnect()) {
                    if (i > 8) {
                        diagnoseService.setDeviceStatus(3);
                        return false;
                    }
                    i++;
                }
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (C1856n.f10135a) {
                    String str = TAG;
                    C1856n.m8130a(str, "Get Connector Ready is false diagnoseService.getDeviceStatus=" + diagnoseService.getDeviceStatus());
                }
                if (3 == diagnoseService.getDeviceStatus() || 1 == diagnoseService.getDeviceStatus()) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
            } while (!z);
            if (diagnoseService.isReconnect()) {
                diagnoseService.setIsReconnect(false);
            }
            if (C1856n.f10135a) {
                C1856n.m8130a(TAG, "Get Connector Ready is true");
            }
            return true;
        }
        return false;
    }

    public static void NotifyConnector(int i, Context context) {
        if (context != null) {
            DiagnoseService diagnoseService = context instanceof DiagnoseService ? (DiagnoseService) context : null;
            if (diagnoseService != null) {
                Message obtain = Message.obtain((Handler) null, 57);
                Bundle bundle = new Bundle();
                switch (i) {
                    case 0:
                        bundle.putString("device_information_key", "device_information_reset");
                        diagnoseService.setDeviceStatus(0);
                        break;
                    case 1:
                        bundle.putString("device_information_key", "device_information_change_device");
                        break;
                    case 2:
                        bundle.putString("device_information_key", "device_information_reconnect");
                        diagnoseService.setIsReconnect(true);
                        diagnoseService.setDeviceStatus(0);
                        break;
                }
                obtain.setData(bundle);
                diagnoseService.sendClientMessage(obtain);
                try {
                    Thread.sleep(500L);
                    return;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return;
                }
            }
            return;
        }
        C1856n.m8130a(TAG, "NotifyConnector start context is null");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] getProtData(byte[] bArr, DiagnoseBusiness diagnoseBusiness, Context context, boolean z) {
        byte[] byteMerger;
        DiagnoseLogUtil.getInstance().writeBytes(bArr, (byte) 1);
        DiagnoseConstants.OLD_DIAG_WAIT = true;
        DiagnoseConstants.DIAG_LIB_OLD = true;
        PageInteractiveData dataUtil = dataUtil(bArr);
        if (C1856n.f10135a) {
            String str = TAG;
            C1856n.m8130a(str, "getProtData databuffer=" + ByteHexHelper.bytesToHexString(bArr));
        }
        if (z) {
            C1856n.m8130a(TAG, "isVin state");
            if (dataUtil.getPackageType() == 26) {
                byteMerger = ByteHexHelper.byteMerger(feedbackData(new byte[0], dataUtil), new byte[]{0});
            } else if (dataUtil.getPackageType() == 10) {
                return feedbackData(new byte[0], dataUtil);
            } else {
                if (diagnoseBusiness == null) {
                    diagnoseBusiness = DiagnoseBusiness.getInstance(context);
                }
                diagnoseBusiness.forwardOldUIData(bArr);
                while (DiagnoseConstants.OLD_DIAG_WAIT) {
                    try {
                        Thread.sleep(50L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                byteMerger = ByteHexHelper.byteMerger(feedbackData(new byte[0], dataUtil), DiagnoseConstants.OLD_DIAG_FEEDBACK);
            }
        } else {
            if (diagnoseBusiness == null) {
                diagnoseBusiness = DiagnoseBusiness.getInstance(context);
            }
            diagnoseBusiness.forwardOldUIData(bArr);
            while (DiagnoseConstants.OLD_DIAG_WAIT) {
                try {
                    Thread.sleep(50L);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
            if (dataUtil.getPackageType() == 26) {
                byteMerger = ByteHexHelper.byteMerger(feedbackData(new byte[0], dataUtil), new byte[]{0});
            } else {
                byteMerger = ByteHexHelper.byteMerger(feedbackData(new byte[0], dataUtil), DiagnoseConstants.OLD_DIAG_FEEDBACK);
            }
        }
        DiagnoseLogUtil.getInstance().writeBytes(byteMerger, (byte) 2);
        DiagnoseConstants.OLD_DIAG_FEEDBACK = null;
        return byteMerger;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void Write(byte[] bArr, int i, Context context) {
        if (DiagnoseConstants.driviceConnStatus) {
            byte[] packingFullCommand = OrderMontage.packingFullCommand(bArr, new byte[]{39, 1});
            if (C1856n.f10135a) {
                String str = TAG;
                C1856n.m8130a(str, "Write  sendOrder=" + ByteHexHelper.bytesToHexString(packingFullCommand));
            }
            recordSendDataDiagnoseLog(packingFullCommand);
            LocalSocketClient.offerLogPackage(new LocalSocketClient.DiagnoseRequestCommand(packingFullCommand, (byte) 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] WriteAndRead(byte[] bArr, int i, byte[] bArr2, int i2, int i3, boolean z, boolean z2, StdJni stdJni, VINStdJni vINStdJni, CToJavaImplementsExtends cToJavaImplementsExtends, Context context) {
        String bluetoothCommand;
        C1856n.m8130a(TAG, "WriteAndRead in");
        if (!DiagnoseConstants.driviceConnStatus) {
            if (z2) {
                vINStdJni.setStateCode(-14);
            } else {
                stdJni.setStateCode(-14);
            }
            return new byte[0];
        }
        String str = "";
        if (z) {
            if (bArr.length > 0) {
                int i4 = i3 + 1000;
                LocalSocketClient.setMaxWaitTime(i4);
                LocalSocketClient.commandWaitLock.lock();
                LocalSocketClient.offerLogPackage(new LocalSocketClient.DiagnoseRequestCommand(bArr, (byte) 1));
                recordSendDataDiagnoseLog(bArr);
                C1856n.m8127b(TAG, "WriteAndRead wait read data maxWaitTime = " + i4);
                try {
                    LocalSocketClient.notReceiverCommand.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                str = LocalSocketClient.getBluetoothCommand();
                LocalSocketClient.commandWaitLock.unlock();
            }
            if (C1856n.f10135a) {
                C1856n.m8130a(TAG, "heavy  backOrder=".concat(String.valueOf(str)));
            }
            if (str == null || str.length() <= 0) {
                if (z2) {
                    vINStdJni.setStateCode(-14);
                } else {
                    stdJni.setStateCode(-14);
                }
                return new byte[0];
            }
            if (z2) {
                vINStdJni.setStateCode(0);
            } else {
                stdJni.setStateCode(0);
            }
            byte[] hexStringToBytes = ByteHexHelper.hexStringToBytes(str);
            recordReciveDataDiagnoseLog(hexStringToBytes);
            return hexStringToBytes;
        }
        byte[] packingFullCommand = OrderMontage.packingFullCommand(cToJavaImplementsExtends != null ? cToJavaImplementsExtends.writeAndReadSendBufferWrapper(bArr) : bArr, new byte[0]);
        byte b = packingFullCommand[6];
        if (cToJavaImplementsExtends.isNeedInterceptFor2505(bArr)) {
            recordSendDataDiagnoseLog(packingFullCommand);
            byte[] bArr3 = {85, -86, -8, -16, 0, 4, 0, 101, 5, 0, 108};
            bArr3[6] = b;
            byte b2 = 0;
            for (int i5 = 2; i5 < 10; i5++) {
                b2 = (byte) (b2 ^ bArr3[i5]);
            }
            bArr3[10] = b2;
            bluetoothCommand = ByteHexHelper.bytesToHexString(bArr3);
            if (C1856n.f10135a) {
                C1856n.m8130a("ykw", "拦截2505指令 ,并回给诊断软件:".concat(String.valueOf(bluetoothCommand)));
            }
        } else {
            LocalSocketClient.setMaxWaitTime(i3);
            LocalSocketClient.commandWaitLock.lock();
            LocalSocketClient.offerLogPackage(new LocalSocketClient.DiagnoseRequestCommand(packingFullCommand, (byte) 1));
            recordSendDataDiagnoseLog(packingFullCommand);
            if (C1856n.f10135a) {
                C1856n.m8130a(TAG, "WriteAndRead wait read data maxWaitTime = ".concat(String.valueOf(i3)));
            }
            try {
                LocalSocketClient.notReceiverCommand.await();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            bluetoothCommand = LocalSocketClient.getBluetoothCommand();
            LocalSocketClient.commandWaitLock.unlock();
        }
        if (C1856n.f10135a) {
            C1856n.m8130a(TAG, "backOrder=".concat(String.valueOf(bluetoothCommand)));
        }
        if (bluetoothCommand == null || bluetoothCommand.length() <= 0) {
            if (z2) {
                vINStdJni.setStateCode(-14);
            } else {
                stdJni.setStateCode(-14);
            }
            byte[] bArr4 = new byte[0];
            resumeLasttimeCounter();
            return bArr4;
        }
        byte[] hexStringToBytes2 = ByteHexHelper.hexStringToBytes(bluetoothCommand);
        if (b == hexStringToBytes2[6]) {
            if (packingFullCommand[7] == 33 && packingFullCommand[8] == 23 && hexStringToBytes2[7] == 97 && hexStringToBytes2[8] == 23 && hexStringToBytes2[9] != 0) {
                if (C1856n.f10135a) {
                    C1856n.m8130a(TAG, "2117 command is error");
                }
                Message obtain = Message.obtain((Handler) null, 106);
                Bundle bundle = new Bundle();
                bundle.putInt(VastExtensionXmlManager.TYPE, 1);
                obtain.setData(bundle);
                if (C1856n.f10135a) {
                    C1856n.m8125d(TAG, String.format("DiagnoseService.sendClientMessage  what=%d,type =%d", 106, 1));
                }
                DiagnoseService.sendClientMessage(context, obtain);
            }
            if (z2) {
                vINStdJni.setStateCode(0);
            } else {
                stdJni.setStateCode(0);
            }
            int i6 = (((hexStringToBytes2[4] & 255) * 256) + (hexStringToBytes2[5] & 255)) - 1;
            if (DiagnoseConstants.isVoltageShow) {
                Message obtain2 = Message.obtain((Handler) null, 108);
                int i7 = (i6 + 5) * 2;
                obtain2.arg1 = Integer.parseInt(bluetoothCommand.substring(i7, i7 + 4), 16);
                DiagnoseService.sendClientMessage(context, obtain2);
                i6 -= 2;
            }
            byte[] bArr5 = new byte[i6];
            int i8 = 0;
            for (int i9 = 7; i9 < i6 + 7; i9++) {
                bArr5[i8] = hexStringToBytes2[i9];
                i8++;
            }
            recordReciveDataDiagnoseLog(hexStringToBytes2);
            return bArr5;
        }
        if (z2) {
            vINStdJni.setStateCode(-14);
        } else {
            stdJni.setStateCode(-14);
        }
        byte[] bArr6 = new byte[0];
        resumeLasttimeCounter();
        return bArr6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] WriteAndRead2701(byte[] bArr, int i, byte[] bArr2, int i2, int i3, boolean z, boolean z2, StdJni stdJni, VINStdJni vINStdJni, Context context) {
        if (!DiagnoseConstants.driviceConnStatus) {
            if (z2) {
                vINStdJni.setStateCode(-14);
            } else {
                stdJni.setStateCode(-14);
            }
            return new byte[0];
        }
        String str = "";
        if (z) {
            byte[] smartBox2701ForHeavyduty = OrderMontage.smartBox2701ForHeavyduty(bArr);
            if (smartBox2701ForHeavyduty.length > 0) {
                int i4 = i3 + 1000;
                LocalSocketClient.setMaxWaitTime(i4);
                LocalSocketClient.commandWaitLock.lock();
                LocalSocketClient.offerLogPackage(new LocalSocketClient.DiagnoseRequestCommand(smartBox2701ForHeavyduty, (byte) 1));
                recordSendDataDiagnoseLog(smartBox2701ForHeavyduty);
                C1856n.m8127b(TAG, "WriteAndRead2701 wait read data maxWaitTime = " + i4);
                try {
                    LocalSocketClient.notReceiverCommand.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                str = LocalSocketClient.getBluetoothCommand();
                LocalSocketClient.commandWaitLock.unlock();
                if (C1856n.f10135a) {
                    C1856n.m8130a(TAG, "heavy backOrder=".concat(String.valueOf(str)));
                }
            }
            if (str == null || str.length() <= 0) {
                if (z2) {
                    vINStdJni.setStateCode(-14);
                } else {
                    stdJni.setStateCode(-14);
                }
                return new byte[0];
            }
            if (z2) {
                vINStdJni.setStateCode(0);
            } else {
                stdJni.setStateCode(0);
            }
            int intPackLength = ByteHexHelper.intPackLength(str.substring(4, 8)) - 5;
            byte[] bArr3 = new byte[intPackLength];
            byte[] hexStringToBytes = ByteHexHelper.hexStringToBytes(str);
            int i5 = 0;
            for (int i6 = 0; i6 < intPackLength; i6++) {
                bArr3[i5] = hexStringToBytes[i6 + 6];
                i5++;
            }
            recordReciveDataDiagnoseLog(hexStringToBytes);
            return bArr3;
        }
        byte[] packingFullCommand = OrderMontage.packingFullCommand(bArr, new byte[]{39, 1});
        byte b = packingFullCommand[6];
        LocalSocketClient.setMaxWaitTime(i3);
        LocalSocketClient.commandWaitLock.lock();
        LocalSocketClient.offerLogPackage(new LocalSocketClient.DiagnoseRequestCommand(packingFullCommand, (byte) 1));
        recordSendDataDiagnoseLog(packingFullCommand);
        C1856n.m8127b(TAG, "WriteAndRead2701 wait read data maxWaitTime = ".concat(String.valueOf(i3)));
        try {
            LocalSocketClient.notReceiverCommand.await();
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        String bluetoothCommand = LocalSocketClient.getBluetoothCommand();
        LocalSocketClient.commandWaitLock.unlock();
        if (C1856n.f10135a) {
            C1856n.m8130a(TAG, "backOrder=".concat(String.valueOf(bluetoothCommand)));
        }
        if (bluetoothCommand == null || bluetoothCommand.length() <= 0) {
            if (z2) {
                vINStdJni.setStateCode(-14);
            } else {
                stdJni.setStateCode(-14);
            }
            byte[] bArr4 = new byte[0];
            resumeLasttimeCounter();
            return bArr4;
        }
        byte[] hexStringToBytes2 = ByteHexHelper.hexStringToBytes(bluetoothCommand);
        if (b == hexStringToBytes2[6]) {
            if (z2) {
                vINStdJni.setStateCode(0);
            } else {
                stdJni.setStateCode(0);
            }
            int i7 = (((hexStringToBytes2[4] & 255) * 256) + (hexStringToBytes2[5] & 255)) - 3;
            if (DiagnoseConstants.isVoltageShow) {
                Message obtain = Message.obtain((Handler) null, 108);
                int i8 = (i7 + 7) * 2;
                obtain.arg1 = Integer.parseInt(bluetoothCommand.substring(i8, i8 + 4), 16);
                DiagnoseService.sendClientMessage(context, obtain);
                i7 -= 2;
            }
            byte[] bArr5 = new byte[i7];
            int i9 = 0;
            for (int i10 = 9; i10 < i7 + 9; i10++) {
                bArr5[i9] = hexStringToBytes2[i10];
                i9++;
            }
            recordReciveDataDiagnoseLog(hexStringToBytes2);
            return bArr5;
        }
        if (z2) {
            vINStdJni.setStateCode(-14);
        } else {
            stdJni.setStateCode(-14);
        }
        byte[] bArr6 = new byte[0];
        resumeLasttimeCounter();
        return bArr6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] ReceiveDataByTime(byte[] bArr, int i, int i2, boolean z, boolean z2, StdJni stdJni, VINStdJni vINStdJni, Context context) {
        if (!DiagnoseConstants.driviceConnStatus) {
            if (z2) {
                vINStdJni.setStateCode(-14);
            } else {
                stdJni.setStateCode(-14);
            }
            return new byte[0];
        }
        LocalSocketClient.setMaxWaitTime(i2);
        LocalSocketClient.setFlashCode(true);
        LocalSocketClient.commandWaitLock.lock();
        try {
            LocalSocketClient.notReceiverCommand.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String bluetoothCommand = LocalSocketClient.getBluetoothCommand();
        if (C1856n.f10135a) {
            C1856n.m8130a(TAG, "ReceiveDataByTime backOrder=".concat(String.valueOf(bluetoothCommand)));
        }
        LocalSocketClient.commandWaitLock.unlock();
        if (bluetoothCommand == null || bluetoothCommand.length() <= 0) {
            if (z2) {
                vINStdJni.setStateCode(-14);
            } else {
                stdJni.setStateCode(-14);
            }
            return new byte[0];
        }
        if (z2) {
            vINStdJni.setStateCode(0);
        } else {
            stdJni.setStateCode(0);
        }
        byte[] hexStringToBytes = ByteHexHelper.hexStringToBytes(bluetoothCommand);
        int i3 = (((hexStringToBytes[4] & 255) * 256) + (hexStringToBytes[5] & 255)) - 3;
        byte[] bArr2 = new byte[i3];
        int i4 = 0;
        for (int i5 = 9; i5 < i3 + 9; i5++) {
            bArr2[i4] = hexStringToBytes[i5];
            i4++;
        }
        recordReciveDataDiagnoseLog(hexStringToBytes);
        return bArr2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int GetLocalLanguage() {
        return AndroidToLan.languages(DiagnoseConstants.DIAGNOSE_LANGUAGE);
    }

    private static byte[] feedbackData(byte[] bArr, PageInteractiveData pageInteractiveData) {
        byte packageId = pageInteractiveData.getPackageId();
        byte intToHexByte = ByteHexHelper.intToHexByte(pageInteractiveData.getPackageType());
        byte[] hexStringToBytes = ByteHexHelper.hexStringToBytes(ByteHexHelper.packLength(bArr.length + 4));
        byte[] bArr2 = new byte[bArr.length + 4];
        int i = 0;
        bArr2[0] = hexStringToBytes[0];
        bArr2[1] = hexStringToBytes[1];
        bArr2[2] = packageId;
        bArr2[3] = intToHexByte;
        for (int i2 = 4; i2 < bArr.length + 4; i2++) {
            bArr2[i2] = bArr[i];
            i++;
        }
        return bArr2;
    }

    private static PageInteractiveData dataUtil(byte[] bArr) {
        PageInteractiveData pageInteractiveData = new PageInteractiveData();
        int length = bArr.length;
        if (length > 2) {
            int i = 0;
            int intPackLength = ByteHexHelper.intPackLength(new byte[]{bArr[0], bArr[1]});
            if (length >= intPackLength) {
                pageInteractiveData.setPackageId(bArr[2]);
                pageInteractiveData.setPackageType(ByteHexHelper.byteToInt(bArr[3]));
                byte[] bArr2 = new byte[intPackLength - 4];
                for (int i2 = 4; i2 < intPackLength; i2++) {
                    bArr2[i] = bArr[i2];
                    i++;
                }
                pageInteractiveData.setData(bArr2);
            }
        }
        return pageInteractiveData;
    }

    public static void recordSendDataDiagnoseLog(byte[] bArr) {
        int deviceLinkMode = DiagnoseService.getDeviceLinkMode();
        if (deviceLinkMode == 3 || deviceLinkMode == 4) {
            DiagnoseLogUtil.getInstance().writeBytes(bArr, (byte) 7);
        } else if (deviceLinkMode == 1) {
            DiagnoseLogUtil.getInstance().writeBytes(bArr, (byte) 13);
        } else if (deviceLinkMode == 2) {
            DiagnoseLogUtil.getInstance().writeBytes(bArr, (byte) 15);
        } else {
            DiagnoseLogUtil.getInstance().writeBytes(bArr, (byte) 3);
        }
    }

    public static void recordReciveDataDiagnoseLog(byte[] bArr) {
        int deviceLinkMode = DiagnoseService.getDeviceLinkMode();
        if (deviceLinkMode == 3 || deviceLinkMode == 4) {
            DiagnoseLogUtil.getInstance().writeBytes(bArr, (byte) 8);
        } else if (deviceLinkMode == 1) {
            DiagnoseLogUtil.getInstance().writeBytes(bArr, (byte) 14);
        } else if (deviceLinkMode == 2) {
            DiagnoseLogUtil.getInstance().writeBytes(bArr, (byte) 16);
        } else {
            DiagnoseLogUtil.getInstance().writeBytes(bArr, (byte) 4);
        }
    }

    static void resumeLasttimeCounter() {
        OrderMontage.resumeLasttimeCounter();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int openTcpConnectEx(String str, int i) {
        int i2;
        RJ45LinkManager m8645a = RJ45LinkManager.m8645a();
        TCPSocketController tCPSocketController = new TCPSocketController();
        if (tCPSocketController.m8638a(str, i, null)) {
            i2 = m8645a.f9488b.incrementAndGet();
            if (C1856n.f10135a) {
                C1856n.m8130a("RJ45LinkManager", "connectTCPLinkEx end tcpSocketControllerIndexAtomicInteger=" + m8645a.f9488b + " socketIndex=" + i2 + " RJ45LinkManager=" + m8645a.toString());
            }
            m8645a.f9489c.put(Integer.valueOf(i2), tCPSocketController);
        } else {
            i2 = -1;
        }
        if (C1856n.f10135a) {
            m8645a.m8641b();
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int closeTcpConnectEx(int i) {
        RJ45LinkManager m8645a = RJ45LinkManager.m8645a();
        TCPSocketController tCPSocketController = m8645a.f9489c.get(Integer.valueOf(i));
        if (tCPSocketController != null) {
            if (C1856n.f10135a) {
                C1856n.m8130a("RJ45LinkManager", "breakTCPLinkEx SocketIndex=" + i + " TCPSocketController=" + tCPSocketController.toString());
            }
            tCPSocketController.m8636b();
            m8645a.f9489c.remove(Integer.valueOf(i));
            return 0;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int sendDataByTcpEx(int i, byte[] bArr, int i2) {
        if (RJ45LinkManager.m8645a().m8644a(i)) {
            TCPSocketController tCPSocketController = RJ45LinkManager.m8645a().f9489c.get(Integer.valueOf(i));
            if (tCPSocketController != null) {
                tCPSocketController.m8640a();
            }
            byte[] bArr2 = new byte[bArr.length + 1];
            bArr2[0] = (byte) (i & 255);
            System.arraycopy(bArr, 0, bArr2, 1, bArr.length);
            diagnoseLogRecordForTCPUDPData(bArr2, (byte) 9);
            TCPSocketController tCPSocketController2 = RJ45LinkManager.m8645a().f9489c.get(Integer.valueOf(i));
            if (tCPSocketController2 != null) {
                return tCPSocketController2.m8637a(bArr);
            }
            return 0;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] receiveDataByTcpEx(int i, byte[] bArr, int i2, int i3) {
        byte[] bArr2;
        if (!RJ45LinkManager.m8645a().m8644a(i)) {
            return new byte[0];
        }
        TCPSocketController tCPSocketController = RJ45LinkManager.m8645a().f9489c.get(Integer.valueOf(i));
        if (tCPSocketController != null) {
            bArr2 = tCPSocketController.m8639a(i3);
        } else {
            bArr2 = new byte[0];
        }
        if (bArr2 != null && bArr2.length > 0) {
            byte[] bArr3 = new byte[bArr2.length + 1];
            bArr3[0] = (byte) (i & 255);
            System.arraycopy(bArr2, 0, bArr3, 1, bArr2.length);
            diagnoseLogRecordForTCPUDPData(bArr3, (byte) 10);
        }
        return bArr2;
    }

    private static void diagnoseLogRecordForTCPUDPData(byte[] bArr, byte b) {
        if (bArr.length >= 65535) {
            byte[] bArr2 = new byte[70];
            System.arraycopy(bArr, 0, bArr2, 0, 50);
            System.arraycopy(bArr, bArr.length - 20, bArr2, 50, 20);
            DiagnoseLogUtil.getInstance().writeBytes(bArr2, b);
            return;
        }
        DiagnoseLogUtil.getInstance().writeBytes(bArr, b);
    }

    private static void sendDisconnectStatus(Context context) {
        Message obtain = Message.obtain((Handler) null, 106);
        Bundle bundle = new Bundle();
        bundle.putInt(VastExtensionXmlManager.TYPE, 2);
        obtain.setData(bundle);
        if (C1856n.f10135a) {
            C1856n.m8125d(TAG, String.format("broadcastDisconnectStatus DiagnoseService.sendClientMessage  what=%d,type =%d", 106, 2));
        }
        DiagnoseService.sendClientMessage(context, obtain);
    }
}
