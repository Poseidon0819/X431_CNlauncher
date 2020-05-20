package com.cnlaunch.physics.serialport;

import android.content.Context;
import android.os.Build;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.physics.LinkParameters;
import com.cnlaunch.physics.p205k.C1856n;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Locale;

/* loaded from: classes.dex */
public class SerialPort {
    public static final int CLOSE = 0;
    public static final int OPEN = 3;
    private static final String TAG = "SerialPort";
    private Context mContext;
    public FileDescriptor mFd;
    private FileInputStream mFileInputStream;
    private FileOutputStream mFileOutputStream;
    private LinkParameters.C1852a mSerialPortParameters;
    private int state;

    private static native FileDescriptor open(String str, int i, int i2);

    private static native int serialPortCheck();

    public native void close();

    public native int getReadBufferByte();

    public native void tcflush();

    public SerialPort(Context context) {
        this(context, null);
    }

    public SerialPort(Context context, LinkParameters.C1852a c1852a) {
        this.mContext = context;
        this.mSerialPortParameters = c1852a;
        this.state = 0;
        setState(0);
    }

    public void openSerialPort() {
        C1856n.m8125d(TAG, "open Serial Port");
        try {
            try {
                if (this.mSerialPortParameters != null) {
                    if (C1856n.f10135a) {
                        C1856n.m8130a(TAG, this.mSerialPortParameters.toString());
                    }
                    openSerialPort(this.mSerialPortParameters.f10026a, this.mSerialPortParameters.f10027b, 0);
                } else {
                    String m9584b = PreferencesManager.m9595a(this.mContext).m9584b("productType", "");
                    C1856n.m8130a(TAG, "productType = ".concat(String.valueOf(m9584b)));
                    if (m9584b.toUpperCase(Locale.ENGLISH).contains("X431AIT")) {
                        if (m9584b.toUpperCase(Locale.ENGLISH).contains("X431AITGOLOX")) {
                            if (C1856n.f10135a) {
                                C1856n.m8130a(TAG, "X431AITGOLOX uart open........................>");
                                C1856n.m8130a(TAG, "CTGOLOXTools.DEVICE_NAME=/dev/ttyMT1");
                                C1856n.m8130a(TAG, "CTGOLOXTools.BAUD_RATE=115200");
                            }
                            openSerialPort("/dev/ttyMT1", 115200, 0);
                        } else if (m9584b.toUpperCase(Locale.ENGLISH).contains("X431AITYIXIN")) {
                            String m9591a = PreferencesManager.m9595a(this.mContext).m9591a("dynamic_serial_port");
                            if (C1856n.f10135a) {
                                C1856n.m8130a(TAG, "X431AITYIXIN uart open........................>");
                                C1856n.m8130a(TAG, "X431AITYIXIN.DEVICE_NAME=".concat(String.valueOf(m9591a)));
                                C1856n.m8130a(TAG, "X431AITYIXIN.BAUD_RATE=115200");
                            }
                            openSerialPort(m9591a, 115200, 0);
                        } else if (m9584b.toUpperCase(Locale.ENGLISH).contains("X431AIT2GENERAL")) {
                            if (C1856n.f10135a) {
                                C1856n.m8130a(TAG, "X431AIT2GENERAL uart open........................>");
                                C1856n.m8130a(TAG, "X431AIT2GENERAL.DEVICE_NAME=/dev/ttyMT1");
                                C1856n.m8130a(TAG, "X431AIT2GENERAL.BAUD_RATE=115200");
                            }
                            openSerialPort("/dev/ttyMT1", 115200, 0);
                        } else {
                            openSerialPort("/dev/ttyHSL1", 115200, 0);
                        }
                    } else if (m9584b.toUpperCase(Locale.ENGLISH).contains("HTT")) {
                        if (!Build.MODEL.toUpperCase(Locale.ENGLISH).contains("HTT-2") && !m9584b.toUpperCase(Locale.ENGLISH).contains("HTT-2")) {
                            openSerialPort("/dev/ttyHSL1", 115200, 0);
                        }
                        openSerialPort("/dev/ttyMSM3", 115200, 0);
                    } else if (m9584b.toUpperCase(Locale.ENGLISH).contains("GEAR")) {
                        C1856n.m8125d("CRP", "<Gear uart open........................>");
                        openSerialPort("/dev/ttyMT1", 115200, 0);
                    } else if (m9584b.toUpperCase(Locale.ENGLISH).contains("MAXLITE")) {
                        C1856n.m8130a(TAG, "MAXLITE uart open........................>");
                        C1856n.m8130a(TAG, "MAXLITE.DEVICE_NAME=/dev/ttyMT1");
                        C1856n.m8130a(TAG, "MAXLITE.BAUD_RATE=115200");
                        openSerialPort("/dev/ttyMT1", 115200, 0);
                    } else if (m9584b.toUpperCase(Locale.ENGLISH).contains("PROLITE")) {
                        C1856n.m8130a(TAG, "PROLITE uart open........................>");
                        C1856n.m8130a(TAG, "PROLITE.DEVICE_NAME=/dev/ttyMT1");
                        C1856n.m8130a(TAG, "PROLITE.BAUD_RATE=115200");
                        openSerialPort("/dev/ttyMT1", 115200, 0);
                    } else {
                        try {
                            C1856n.m8130a(TAG, "open Serial Port by qualcomm chip default serial devices");
                            openSerialPort("/dev/ttyHSL1", 115200, 0);
                        } catch (IOException unused) {
                            C1856n.m8130a(TAG, "open Serial Port by mtk chip default serial devices");
                            openSerialPort("/dev/ttyMT0", 115200, 0);
                        }
                    }
                }
                setState(3);
            } catch (IOException e) {
                e.printStackTrace();
                setState(0);
            }
        } catch (SecurityException e2) {
            e2.printStackTrace();
            setState(0);
        }
    }

    public void openSerialPort(String str, int i, int i2) throws SecurityException, IOException {
        this.mFd = open(str, i, i2);
        if (this.mFd == null) {
            C1856n.m8127b(TAG, "open Serial Port fail ");
            throw new IOException();
        }
        C1856n.m8127b(TAG, "open Serial Port success");
        tcflush();
        this.mFileInputStream = new FileInputStream(this.mFd);
        this.mFileOutputStream = new FileOutputStream(this.mFd);
    }

    public int getState() {
        return this.state;
    }

    public void setState(int i) {
        this.state = i;
    }

    public InputStream getInputStream() {
        return this.mFileInputStream;
    }

    public OutputStream getOutputStream() {
        return this.mFileOutputStream;
    }

    public static synchronized int httDiagnoseSerialPortCheck() {
        int httDiagnoseSerialPortCheck;
        synchronized (SerialPort.class) {
            httDiagnoseSerialPortCheck = httDiagnoseSerialPortCheck("HTT");
        }
        return httDiagnoseSerialPortCheck;
    }

    public static synchronized int httDiagnoseSerialPortCheck(String str) {
        synchronized (SerialPort.class) {
            if (!Build.MODEL.toUpperCase(Locale.ENGLISH).contains("HTT-2") && !str.toUpperCase(Locale.ENGLISH).contains("HTT-2")) {
                return serialPortCheck();
            }
            return htt2SerialPortCheck();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x005e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int htt2SerialPortCheck() {
        /*
            r0 = 1
            r1 = 0
            r2 = 0
            java.io.FileReader r3 = new java.io.FileReader     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L37 java.io.FileNotFoundException -> L49
            java.lang.String r4 = "/sys/devices/platform/soc/soc:gpio_keys/mes_status"
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L37 java.io.FileNotFoundException -> L49
            int r2 = r3.read()     // Catch: java.lang.Exception -> L31 java.io.FileNotFoundException -> L33 java.lang.Throwable -> L5b
            boolean r4 = com.cnlaunch.physics.p205k.C1856n.f10135a     // Catch: java.lang.Exception -> L31 java.io.FileNotFoundException -> L33 java.lang.Throwable -> L5b
            if (r4 == 0) goto L21
            java.lang.String r4 = "SerialPort"
            java.lang.String r5 = "htt2SerialPortCheck count ="
            java.lang.String r6 = java.lang.String.valueOf(r2)     // Catch: java.lang.Exception -> L31 java.io.FileNotFoundException -> L33 java.lang.Throwable -> L5b
            java.lang.String r5 = r5.concat(r6)     // Catch: java.lang.Exception -> L31 java.io.FileNotFoundException -> L33 java.lang.Throwable -> L5b
            com.cnlaunch.physics.p205k.C1856n.m8130a(r4, r5)     // Catch: java.lang.Exception -> L31 java.io.FileNotFoundException -> L33 java.lang.Throwable -> L5b
        L21:
            char r0 = (char) r2
            r2 = 49
            if (r0 != r2) goto L27
            goto L28
        L27:
            r1 = 2
        L28:
            r3.close()     // Catch: java.io.IOException -> L2c
            goto L30
        L2c:
            r0 = move-exception
            r0.printStackTrace()
        L30:
            return r1
        L31:
            r2 = move-exception
            goto L3b
        L33:
            r2 = move-exception
            goto L4d
        L35:
            r3 = r2
            goto L5c
        L37:
            r3 = move-exception
            r7 = r3
            r3 = r2
            r2 = r7
        L3b:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L5b
            if (r3 == 0) goto L48
            r3.close()     // Catch: java.io.IOException -> L44
            goto L48
        L44:
            r1 = move-exception
            r1.printStackTrace()
        L48:
            return r0
        L49:
            r3 = move-exception
            r7 = r3
            r3 = r2
            r2 = r7
        L4d:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L5b
            if (r3 == 0) goto L5a
            r3.close()     // Catch: java.io.IOException -> L56
            goto L5a
        L56:
            r1 = move-exception
            r1.printStackTrace()
        L5a:
            return r0
        L5b:
        L5c:
            if (r3 == 0) goto L66
            r3.close()     // Catch: java.io.IOException -> L62
            goto L66
        L62:
            r0 = move-exception
            r0.printStackTrace()
        L66:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.physics.serialport.SerialPort.htt2SerialPortCheck():int");
    }

    static {
        String property = System.getProperty("java.library.path");
        C1856n.m8130a("LibLoader", "Trying to load library serial_port from LD_PATH: " + property);
        try {
            System.loadLibrary("serial_port");
        } catch (UnsatisfiedLinkError e) {
            C1856n.m8127b("LibLoader", e.toString());
        }
    }
}
