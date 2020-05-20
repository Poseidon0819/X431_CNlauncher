package com.cnlaunch.physics.serialport;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.cnlaunch.p117b.C1411a;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p169im.p174db.MessageDao;
import com.cnlaunch.physics.DeviceFactoryManager;
import com.cnlaunch.physics.LinkParameters;
import com.cnlaunch.physics.TPMSModuleControl;
import com.cnlaunch.physics.p199e.IAssitsPhysics;
import com.cnlaunch.physics.p199e.IAssitsPhysicsMatcher;
import com.cnlaunch.physics.p199e.IPhysics;
import com.cnlaunch.physics.p200f.PhysicsInputStreamWrapper;
import com.cnlaunch.physics.p200f.PhysicsOutputStreamWrapper;
import com.cnlaunch.physics.p205k.C1856n;
import com.cnlaunch.physics.p205k.Tools;
import com.cnlaunch.physics.p205k.p207b.ReadByteDataStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Locale;

/* loaded from: classes.dex */
public class SerialPortManager implements IAssitsPhysics, IPhysics {
    private static final String TAG = "SerialPortManager";
    private static String mReadData = "";
    private boolean isFix;
    private Context mContext;
    private DeviceFactoryManager mDeviceFactoryManager;
    private String mProductType;
    private String mSerialNo;
    private boolean commandWait = true;
    private Handler mHandler = new HandlerC1862a(this, Looper.getMainLooper());
    private ReadByteDataStream mReadByteDataStreamThread = null;
    private RunnableC1860a mHTTSerialPortCheckRunnable = null;
    private RunnableC1861b mProLiteSerialPortCheckRunnable = null;
    private int mState = 0;
    private SerialPort serialPort = null;
    private boolean mIsTruckReset = false;
    private InputStream inputStream = null;
    private OutputStream outputStream = null;
    private LinkParameters.C1852a mSerialPortParameters = null;
    private IAssitsPhysicsMatcher mAssitsPhysicsMatcher = null;
    private boolean mIsRemoteClientDiagnoseMode = false;
    private boolean mIsSupportOneRequestMoreAnswerDiagnoseMode = false;

    public boolean getCommandStatus() {
        return false;
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public String getDeviceName() {
        return null;
    }

    public int getLinkMode() {
        return 2;
    }

    @Override // com.cnlaunch.physics.p199e.IAssitsPhysics
    public IPhysics getPhysics() {
        return this;
    }

    public void setCommandStatus(boolean z) {
    }

    public SerialPortManager(DeviceFactoryManager deviceFactoryManager, Context context, boolean z, String str) {
        this.mContext = context.getApplicationContext();
        this.isFix = z;
        this.mDeviceFactoryManager = deviceFactoryManager;
        this.mSerialNo = str;
        this.mProductType = PreferencesManager.m9595a(this.mContext).m9584b("productType", "");
    }

    protected void finalize() {
        try {
            C1856n.m8127b(TAG, "finalize SerialPortManager");
            this.mHandler = null;
            this.serialPort = null;
            this.mSerialPortParameters = null;
            this.mAssitsPhysicsMatcher = null;
            super.finalize();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public String getCommand() {
        C1856n.m8127b(TAG, "获取读取到的完整指令" + mReadData);
        return mReadData;
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public void setCommand(String str) {
        mReadData = str;
        this.mDeviceFactoryManager.m8298a(str);
    }

    public void setCommand(String str, boolean z) {
        if (z) {
            mReadData = str;
        } else {
            setCommand(str);
        }
    }

    public InputStream getInputStream() {
        if (this.inputStream == null) {
            this.inputStream = new PhysicsInputStreamWrapper(this.serialPort.getInputStream());
        }
        return this.inputStream;
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public OutputStream getOutputStream() {
        if (this.outputStream == null) {
            this.outputStream = new PhysicsOutputStreamWrapper(this.serialPort.getOutputStream(), this.mDeviceFactoryManager.f9916p);
        }
        return this.outputStream;
    }

    private void setState(int i) {
        this.mState = i;
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public int getState() {
        return this.mState;
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public synchronized boolean getCommand_wait() {
        return this.commandWait;
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public synchronized void setCommand_wait(boolean z) {
        this.commandWait = z;
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public Context getContext() {
        return this.mContext;
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public void closeDevice() {
        ReadByteDataStream readByteDataStream = this.mReadByteDataStreamThread;
        if (readByteDataStream != null) {
            readByteDataStream.m8195a();
            this.mReadByteDataStreamThread = null;
            if (this.mAssitsPhysicsMatcher == null) {
                this.mContext.sendBroadcast(new Intent("com.cnlaunch.intent.action.DIAG_UNCONNECTED"));
            }
        }
        RunnableC1860a runnableC1860a = this.mHTTSerialPortCheckRunnable;
        if (runnableC1860a != null) {
            runnableC1860a.m8083a();
            this.mHTTSerialPortCheckRunnable = null;
        }
        RunnableC1861b runnableC1861b = this.mProLiteSerialPortCheckRunnable;
        if (runnableC1861b != null) {
            runnableC1861b.m8081a();
            this.mProLiteSerialPortCheckRunnable = null;
        }
        SerialPort serialPort = this.serialPort;
        if (serialPort != null) {
            serialPort.close();
            this.serialPort = null;
        }
        this.mSerialPortParameters = null;
        this.mAssitsPhysicsMatcher = null;
        setState(0);
    }

    public int connect() {
        ReadByteDataStream readByteDataStream = this.mReadByteDataStreamThread;
        if (readByteDataStream != null) {
            readByteDataStream.m8195a();
            this.mReadByteDataStreamThread = null;
        }
        RunnableC1860a runnableC1860a = this.mHTTSerialPortCheckRunnable;
        if (runnableC1860a != null) {
            runnableC1860a.m8083a();
            this.mHTTSerialPortCheckRunnable = null;
        }
        RunnableC1861b runnableC1861b = this.mProLiteSerialPortCheckRunnable;
        if (runnableC1861b != null) {
            runnableC1861b.m8081a();
            this.mProLiteSerialPortCheckRunnable = null;
        }
        SerialPort serialPort = this.serialPort;
        if (serialPort != null) {
            serialPort.close();
            this.serialPort = null;
            if (C1856n.f10135a) {
                C1856n.m8130a(TAG, "先关闭打开的串口");
            }
        }
        this.serialPort = new SerialPort(this.mContext, this.mSerialPortParameters);
        this.serialPort.openSerialPort();
        if (this.serialPort.getState() == 3) {
            if (this.mProductType.toUpperCase(Locale.ENGLISH).contains("HTT") && SerialPort.httDiagnoseSerialPortCheck(this.mProductType) == 2) {
                connectionFailed(this.mContext.getString(C1411a.C1412a.msg_serialport_connect_state_fail_with_no_power));
                setState(3);
                return getState();
            }
            if (C1856n.f10135a) {
                C1856n.m8130a(TAG, "打开串口成功开启读取数据的线程 mProductType=" + this.mProductType + " isFix=" + this.isFix);
            }
            this.mReadByteDataStreamThread = new ReadByteDataStream(this, this.serialPort.getInputStream(), this.serialPort.getOutputStream());
            new Thread(this.mReadByteDataStreamThread).start();
            if (C1856n.f10135a) {
                C1856n.m8130a(TAG, "SerialPort connected success,starting transfer data ");
            }
            this.mHandler.sendEmptyMessage(0);
            setState(3);
            if (this.mProductType.toUpperCase(Locale.ENGLISH).contains("HTT")) {
                if (C1856n.f10135a) {
                    C1856n.m8130a(TAG, "打开串口成功开启HTT串口电压值状态读取数据线程");
                }
                this.mHTTSerialPortCheckRunnable = new RunnableC1860a();
                new Thread(this.mHTTSerialPortCheckRunnable).start();
            } else if (Tools.m8097c(this.mContext) && !this.isFix && !this.mDeviceFactoryManager.f9910j) {
                if (C1856n.f10135a) {
                    C1856n.m8130a(TAG, "打开串口成功开启串口电压值状态读取数据线程");
                }
                this.mProLiteSerialPortCheckRunnable = new RunnableC1861b();
                new Thread(this.mProLiteSerialPortCheckRunnable).start();
            }
            return getState();
        }
        setState(0);
        return getState();
    }

    public void clearTotalBuffer() {
        ReadByteDataStream readByteDataStream = this.mReadByteDataStreamThread;
        if (readByteDataStream != null) {
            if (readByteDataStream.f10080f != null) {
                readByteDataStream.f10080f.m8200a();
            }
            if (readByteDataStream.f10081g != null) {
                readByteDataStream.f10081g.m8200a();
            }
        }
    }

    private void connectionFailed() {
        connectionFailed(null);
    }

    private void connectionFailed(String str) {
        setState(0);
        if (this.mAssitsPhysicsMatcher == null) {
            Intent intent = new Intent("DPUDeviceConnectFail");
            intent.putExtra("is_connect_fail", true);
            intent.putExtra("isFix", this.isFix);
            if (str == null) {
                intent.putExtra(MessageDao.TABLENAME, this.mContext.getString(C1411a.C1412a.msg_serialport_connect_state_fail));
            } else {
                intent.putExtra(MessageDao.TABLENAME, str);
            }
            this.mContext.sendBroadcast(intent);
        }
    }

    public void setSerialNo(String str) {
        this.mSerialNo = str;
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public String getSerialNo() {
        return this.mSerialNo;
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public synchronized void setIsTruckReset(boolean z) {
        this.mIsTruckReset = z;
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public synchronized boolean isTruckReset() {
        return this.mIsTruckReset;
    }

    public void userInteractionWhenDPUConnected() {
        Handler handler = this.mHandler;
        if (handler != null) {
            this.mHandler.sendMessage(handler.obtainMessage(0, 0, 0));
        }
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public void setIsFix(boolean z) {
        this.isFix = z;
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public void physicalCloseDevice() {
        closeDevice();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.cnlaunch.physics.serialport.SerialPortManager$a */
    /* loaded from: classes.dex */
    public class RunnableC1860a implements Runnable {

        /* renamed from: a */
        boolean f10155a = false;

        public RunnableC1860a() {
        }

        /* renamed from: b */
        private synchronized boolean m8082b() {
            return this.f10155a;
        }

        /* renamed from: a */
        public final synchronized void m8083a() {
            this.f10155a = true;
        }

        @Override // java.lang.Runnable
        public final void run() {
            while (!m8082b()) {
                if (SerialPort.httDiagnoseSerialPortCheck(SerialPortManager.this.mProductType) == 2) {
                    SerialPortManager.this.mHandler.sendEmptyMessage(1);
                    return;
                }
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.cnlaunch.physics.serialport.SerialPortManager$b */
    /* loaded from: classes.dex */
    public class RunnableC1861b implements Runnable {

        /* renamed from: a */
        boolean f10157a = false;

        public RunnableC1861b() {
        }

        /* renamed from: b */
        private synchronized boolean m8080b() {
            return this.f10157a;
        }

        /* renamed from: a */
        public final synchronized void m8081a() {
            this.f10157a = true;
        }

        @Override // java.lang.Runnable
        public final void run() {
            while (!m8080b()) {
                if (!TPMSModuleControl.m8084a()) {
                    SerialPortManager.this.mHandler.sendEmptyMessage(1);
                    return;
                }
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void setIsRemoteClientDiagnoseMode(boolean z) {
        this.mIsRemoteClientDiagnoseMode = z;
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public boolean getIsRemoteClientDiagnoseMode() {
        return this.mIsRemoteClientDiagnoseMode;
    }

    public void setAssitsPhysicsMatcher(IAssitsPhysicsMatcher iAssitsPhysicsMatcher) {
        this.mAssitsPhysicsMatcher = iAssitsPhysicsMatcher;
    }

    @Override // com.cnlaunch.physics.p199e.IAssitsPhysics
    public IAssitsPhysicsMatcher getAssitsPhysicsMatcher() {
        return this.mAssitsPhysicsMatcher;
    }

    public void setIsSupportOneRequestMoreAnswerDiagnoseMode(boolean z) {
        this.mIsSupportOneRequestMoreAnswerDiagnoseMode = z;
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public boolean getIsSupportOneRequestMoreAnswerDiagnoseMode() {
        return this.mIsSupportOneRequestMoreAnswerDiagnoseMode;
    }

    public void setLinkParameters(LinkParameters linkParameters) {
        this.mSerialPortParameters = linkParameters.f10025a;
    }
}
