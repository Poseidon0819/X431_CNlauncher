package com.cnlaunch.physics.p204j;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.XmlResourceParser;
import android.hardware.usb.UsbAccessory;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbInterface;
import android.hardware.usb.UsbManager;
import android.hardware.usb.UsbRequest;
import com.cnlaunch.p117b.C1411a;
import com.cnlaunch.physics.p205k.C1856n;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.xmlpull.p398v1.XmlPullParserException;

/* renamed from: com.cnlaunch.physics.j.d */
/* loaded from: classes.dex */
public final class DPUUsbDriver {

    /* renamed from: a */
    List<C1851b> f9993a;

    /* renamed from: j */
    private Context f10002j;

    /* renamed from: l */
    private List<C1851b> f10004l;

    /* renamed from: m */
    private List<C1851b> f10005m;

    /* renamed from: x */
    private String f10016x;

    /* renamed from: k */
    private PendingIntent f10003k = null;

    /* renamed from: b */
    boolean f9994b = false;

    /* renamed from: n */
    private Integer f10006n = -8;

    /* renamed from: c */
    UsbManager f9995c = null;

    /* renamed from: o */
    private UsbAccessory[] f10007o = null;

    /* renamed from: d */
    UsbDeviceConnection f9996d = null;

    /* renamed from: e */
    UsbDevice f9997e = null;

    /* renamed from: p */
    private HashMap<String, UsbDevice> f10008p = null;

    /* renamed from: q */
    private UsbInterface[] f10009q = null;

    /* renamed from: r */
    private int f10010r = -1;

    /* renamed from: s */
    private int f10011s = -1;

    /* renamed from: t */
    private int f10012t = -1;

    /* renamed from: u */
    private C1850a f10013u = null;

    /* renamed from: f */
    C1850a f9998f = null;

    /* renamed from: v */
    private C1850a f10014v = null;

    /* renamed from: w */
    private String f10015w = null;

    /* renamed from: g */
    int f9999g = -1;

    /* renamed from: h */
    int f10000h = -1;

    /* renamed from: i */
    UsbRequest f10001i = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DPUUsbDriver.java */
    /* renamed from: com.cnlaunch.physics.j.d$b */
    /* loaded from: classes.dex */
    public class C1851b {

        /* renamed from: a */
        int f10020a;

        /* renamed from: b */
        int f10021b;

        private C1851b() {
        }

        /* synthetic */ C1851b(DPUUsbDriver dPUUsbDriver, byte b) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DPUUsbDriver.java */
    /* renamed from: com.cnlaunch.physics.j.d$a */
    /* loaded from: classes.dex */
    public class C1850a {

        /* renamed from: a */
        UsbEndpoint f10017a;

        /* renamed from: b */
        int f10018b;

        private C1850a() {
        }

        /* synthetic */ C1850a(DPUUsbDriver dPUUsbDriver, byte b) {
            this();
        }
    }

    public DPUUsbDriver(Context context, String str) {
        this.f10002j = null;
        this.f10016x = "";
        this.f10002j = context;
        if (str != null && !str.isEmpty()) {
            this.f10016x = str;
        }
        try {
            if (this.f9993a == null) {
                this.f9993a = new ArrayList();
            } else {
                this.f9993a.clear();
            }
            m8229a(this.f9993a, C1411a.C1413b.filter_device);
            if (this.f10004l == null) {
                this.f10004l = new ArrayList();
            } else {
                this.f10004l.clear();
            }
            m8229a(this.f10004l, C1411a.C1413b.stand_alone_chip_device);
            if (this.f10005m == null) {
                this.f10005m = new ArrayList();
            } else {
                this.f10005m.clear();
            }
            m8229a(this.f10005m, C1411a.C1413b.stand_alone_chip_ethernet_device);
        } catch (Exception e) {
            e.printStackTrace();
        }
        m8233a();
    }

    /* renamed from: h */
    private int m8220h() {
        UsbManager usbManager;
        int m8223e = m8223e();
        if (-12 == m8223e || -8 == m8223e) {
            return m8223e;
        }
        UsbDevice usbDevice = this.f9997e;
        if (usbDevice == null || (usbManager = this.f9995c) == null) {
            return -4;
        }
        if (!usbManager.hasPermission(usbDevice)) {
            this.f9995c.requestPermission(this.f9997e, this.f10003k);
            if (this.f9995c.hasPermission(this.f9997e)) {
                return 0;
            }
            C1856n.m8127b("DPUUSBDriver", "getPermisson() -> Get device access permission failed!");
            return -17;
        } else if (this.f9994b) {
            C1856n.m8127b("DPUUSBDriver", "getPermisson() -> Get device access permission success!");
            return 0;
        } else {
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final int m8233a() {
        if (this.f9995c == null) {
            this.f9995c = (UsbManager) this.f10002j.getSystemService("usb");
            if (this.f9995c != null) {
                this.f10003k = PendingIntent.getBroadcast(this.f10002j.getApplicationContext(), 0, new Intent(this.f10016x), 0);
            } else {
                C1856n.m8127b("DPUUSBDriver", "USBDriver() -> Get UsbManager serveice failed");
                return -3;
            }
        }
        return 0;
    }

    /* renamed from: b */
    public final int m8227b() {
        int i;
        int i2;
        int m8223e = m8223e();
        if (this.f9995c == null) {
            m8233a();
            if (this.f9995c == null) {
                return -4;
            }
        }
        int i3 = this.f10000h;
        if (-1 != i3 && -1 != (i2 = this.f9999g)) {
            i = m8231a(i3, i2);
        } else {
            int size = this.f9993a.size();
            if (size > 0) {
                int i4 = m8223e;
                int i5 = 0;
                while (true) {
                    if (i5 >= size) {
                        i = i4;
                        break;
                    }
                    C1851b c1851b = this.f9993a.get(i5);
                    int m8231a = m8231a(c1851b.f10020a, c1851b.f10021b);
                    if (m8231a == 0) {
                        this.f10000h = c1851b.f10020a;
                        this.f9999g = c1851b.f10021b;
                        i = m8231a;
                        break;
                    }
                    i5++;
                    i4 = m8231a;
                }
            } else {
                return -23;
            }
        }
        if (i != 0) {
            return i;
        }
        int m8216l = m8216l();
        if (m8216l != 0) {
            return m8216l;
        }
        m8232a(-15);
        return 0;
    }

    /* renamed from: c */
    public final int m8225c() {
        if (-7 == m8223e()) {
            if (this.f9994b) {
                C1856n.m8127b("DPUUSBDriver", "open() -> device is already running");
            }
            return 0;
        }
        if (this.f9995c == null) {
            m8233a();
            if (this.f9995c == null) {
                C1856n.m8127b("DPUUSBDriver", "open() -> no usbManager");
                return -4;
            }
        }
        int m8227b = m8227b();
        if (m8227b != 0) {
            return m8227b;
        }
        int m8220h = m8220h();
        if (m8220h != 0) {
            return m8220h;
        }
        this.f9996d = this.f9995c.openDevice(this.f9997e);
        if (this.f9996d != null) {
            if (this.f9994b) {
                C1856n.m8127b("DPUUSBDriver", "open() -> open device successed!");
            }
            if (!m8218j()) {
                C1856n.m8127b("DPUUSBDriver", "open() -> Try to access device failed!");
                return -19;
            }
            this.f10001i = new UsbRequest();
            this.f10001i.initialize(this.f9996d, this.f9998f.f10017a);
            m8232a(-7);
            return 0;
        }
        m8232a(-6);
        C1856n.m8127b("DPUUSBDriver", "open() -> open device failed!");
        return -6;
    }

    /* renamed from: d */
    public final void m8224d() {
        UsbDeviceConnection usbDeviceConnection;
        String str;
        String str2;
        if (this.f9997e == null || (usbDeviceConnection = this.f9996d) == null || this.f9995c == null) {
            m8219i();
            C1856n.m8127b("DPUUSBDriver", "close() -> no usbManager or device not opened");
            return;
        }
        synchronized (usbDeviceConnection) {
            try {
                m8217k();
                this.f9996d.close();
                m8217k();
                m8232a(-8);
            } catch (Exception e) {
                e.printStackTrace();
                m8232a(-8);
                if (this.f9994b) {
                    str = "DPUUSBDriver";
                    str2 = "Device [" + String.format("0x%x", Integer.valueOf(this.f10000h)) + "," + String.format("0x%x", Integer.valueOf(this.f9999g)) + "] Closed!";
                }
            }
            if (this.f9994b) {
                str = "DPUUSBDriver";
                str2 = "Device [" + String.format("0x%x", Integer.valueOf(this.f10000h)) + "," + String.format("0x%x", Integer.valueOf(this.f9999g)) + "] Closed!";
                C1856n.m8127b(str, str2);
            }
        }
        m8219i();
    }

    /* renamed from: i */
    private void m8219i() {
        this.f10009q = null;
        this.f10008p = null;
        this.f9998f = null;
        this.f10014v = null;
        this.f10013u = null;
        this.f10009q = null;
        this.f9997e = null;
        this.f10007o = null;
        this.f9996d = null;
        this.f10001i = null;
        this.f10000h = -1;
        this.f9999g = -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0040, code lost:
        if (r5 >= 0) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0042, code lost:
        com.cnlaunch.physics.p205k.C1856n.m8127b("DPUUSBDriver", "read() --> read result: ".concat(java.lang.String.valueOf(r5)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:?, code lost:
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:?, code lost:
        return r5;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0055 -> B:28:0x0056). Please submit an issue!!! */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int m8228a(byte[] r5, int r6) {
        /*
            r4 = this;
            if (r5 == 0) goto L8c
            int r0 = r5.length
            if (r0 == 0) goto L8c
            if (r6 != 0) goto L9
            goto L8c
        L9:
            int r0 = r4.m8223e()
            r1 = -7
            if (r1 == r0) goto L20
            java.lang.String r5 = "DPUUSBDriver"
            java.lang.String r6 = "read() --> device status error! error: "
            java.lang.String r1 = java.lang.String.valueOf(r0)
            java.lang.String r6 = r6.concat(r1)
            com.cnlaunch.physics.p205k.C1856n.m8127b(r5, r6)
            return r0
        L20:
            android.hardware.usb.UsbManager r0 = r4.f9995c
            if (r0 == 0) goto L83
            android.hardware.usb.UsbDeviceConnection r0 = r4.f9996d
            if (r0 == 0) goto L83
            com.cnlaunch.physics.j.d$a r0 = r4.f9998f
            android.hardware.usb.UsbEndpoint r0 = r0.f10017a
            if (r0 != 0) goto L2f
            goto L83
        L2f:
            r0 = 0
            com.cnlaunch.physics.j.d$a r1 = r4.f9998f     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
            android.hardware.usb.UsbEndpoint r1 = r1.f10017a     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
            monitor-enter(r1)     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
            android.hardware.usb.UsbDeviceConnection r2 = r4.f9996d     // Catch: java.lang.Throwable -> L55
            com.cnlaunch.physics.j.d$a r3 = r4.f9998f     // Catch: java.lang.Throwable -> L55
            android.hardware.usb.UsbEndpoint r3 = r3.f10017a     // Catch: java.lang.Throwable -> L55
            int r5 = r2.bulkTransfer(r3, r5, r6, r0)     // Catch: java.lang.Throwable -> L55
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L52
            if (r5 >= 0) goto L70
            java.lang.String r6 = "DPUUSBDriver"
            java.lang.String r0 = "read() --> read result: "
            java.lang.String r1 = java.lang.String.valueOf(r5)
            java.lang.String r0 = r0.concat(r1)
            com.cnlaunch.physics.p205k.C1856n.m8127b(r6, r0)
            goto L70
        L52:
            r6 = move-exception
            r0 = r5
            goto L56
        L55:
            r6 = move-exception
        L56:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L55
            throw r6     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
        L58:
            r5 = move-exception
            goto L71
        L5a:
            r5 = move-exception
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L58
            if (r0 >= 0) goto L6f
            java.lang.String r5 = "DPUUSBDriver"
            java.lang.String r6 = "read() --> read result: "
            java.lang.String r1 = java.lang.String.valueOf(r0)
            java.lang.String r6 = r6.concat(r1)
            com.cnlaunch.physics.p205k.C1856n.m8127b(r5, r6)
        L6f:
            r5 = r0
        L70:
            return r5
        L71:
            if (r0 >= 0) goto L82
            java.lang.String r6 = java.lang.String.valueOf(r0)
            java.lang.String r0 = "read() --> read result: "
            java.lang.String r6 = r0.concat(r6)
            java.lang.String r0 = "DPUUSBDriver"
            com.cnlaunch.physics.p205k.C1856n.m8127b(r0, r6)
        L82:
            throw r5
        L83:
            java.lang.String r5 = "DPUUSBDriver"
            java.lang.String r6 = "read() -> No USBDriver object's instance!"
            com.cnlaunch.physics.p205k.C1856n.m8127b(r5, r6)
            r5 = -4
            return r5
        L8c:
            java.lang.String r5 = "DPUUSBDriver"
            java.lang.String r6 = "read() --> param error!"
            com.cnlaunch.physics.p205k.C1856n.m8127b(r5, r6)
            r5 = -16
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.physics.p204j.DPUUsbDriver.m8228a(byte[], int):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0040, code lost:
        if (r5 >= 0) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0042, code lost:
        com.cnlaunch.physics.p205k.C1856n.m8127b("DPUUSBDriver", "write() -> write result: ".concat(java.lang.String.valueOf(r5)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:?, code lost:
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:?, code lost:
        return r5;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0055 -> B:28:0x0056). Please submit an issue!!! */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int m8226b(byte[] r5, int r6) {
        /*
            r4 = this;
            if (r5 == 0) goto L8c
            int r0 = r5.length
            if (r0 == 0) goto L8c
            if (r6 != 0) goto L9
            goto L8c
        L9:
            int r0 = r4.m8223e()
            r1 = -7
            if (r1 == r0) goto L20
            java.lang.String r5 = "DPUUSBDriver"
            java.lang.String r6 = "write() --> device status error! error: "
            java.lang.String r1 = java.lang.String.valueOf(r0)
            java.lang.String r6 = r6.concat(r1)
            com.cnlaunch.physics.p205k.C1856n.m8127b(r5, r6)
            return r0
        L20:
            android.hardware.usb.UsbManager r0 = r4.f9995c
            if (r0 == 0) goto L83
            android.hardware.usb.UsbDeviceConnection r0 = r4.f9996d
            if (r0 == 0) goto L83
            com.cnlaunch.physics.j.d$a r0 = r4.f10014v
            android.hardware.usb.UsbEndpoint r0 = r0.f10017a
            if (r0 != 0) goto L2f
            goto L83
        L2f:
            r0 = 0
            com.cnlaunch.physics.j.d$a r1 = r4.f10014v     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
            android.hardware.usb.UsbEndpoint r1 = r1.f10017a     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
            monitor-enter(r1)     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
            android.hardware.usb.UsbDeviceConnection r2 = r4.f9996d     // Catch: java.lang.Throwable -> L55
            com.cnlaunch.physics.j.d$a r3 = r4.f10014v     // Catch: java.lang.Throwable -> L55
            android.hardware.usb.UsbEndpoint r3 = r3.f10017a     // Catch: java.lang.Throwable -> L55
            int r5 = r2.bulkTransfer(r3, r5, r6, r0)     // Catch: java.lang.Throwable -> L55
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L52
            if (r5 >= 0) goto L70
            java.lang.String r6 = "DPUUSBDriver"
            java.lang.String r0 = "write() -> write result: "
            java.lang.String r1 = java.lang.String.valueOf(r5)
            java.lang.String r0 = r0.concat(r1)
            com.cnlaunch.physics.p205k.C1856n.m8127b(r6, r0)
            goto L70
        L52:
            r6 = move-exception
            r0 = r5
            goto L56
        L55:
            r6 = move-exception
        L56:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L55
            throw r6     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
        L58:
            r5 = move-exception
            goto L71
        L5a:
            r5 = move-exception
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L58
            if (r0 >= 0) goto L6f
            java.lang.String r5 = "DPUUSBDriver"
            java.lang.String r6 = "write() -> write result: "
            java.lang.String r1 = java.lang.String.valueOf(r0)
            java.lang.String r6 = r6.concat(r1)
            com.cnlaunch.physics.p205k.C1856n.m8127b(r5, r6)
        L6f:
            r5 = r0
        L70:
            return r5
        L71:
            if (r0 >= 0) goto L82
            java.lang.String r6 = java.lang.String.valueOf(r0)
            java.lang.String r0 = "write() -> write result: "
            java.lang.String r6 = r0.concat(r6)
            java.lang.String r0 = "DPUUSBDriver"
            com.cnlaunch.physics.p205k.C1856n.m8127b(r0, r6)
        L82:
            throw r5
        L83:
            java.lang.String r5 = "DPUUSBDriver"
            java.lang.String r6 = "write() -> No USBDriver object's instance"
            com.cnlaunch.physics.p205k.C1856n.m8127b(r5, r6)
            r5 = -4
            return r5
        L8c:
            java.lang.String r5 = "DPUUSBDriver"
            java.lang.String r6 = "write() --> param error!"
            com.cnlaunch.physics.p205k.C1856n.m8127b(r5, r6)
            r5 = -16
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.physics.p204j.DPUUsbDriver.m8226b(byte[], int):int");
    }

    /* renamed from: j */
    private boolean m8218j() {
        UsbDeviceConnection usbDeviceConnection = this.f9996d;
        if (usbDeviceConnection != null) {
            UsbInterface[] usbInterfaceArr = this.f10009q;
            int i = this.f10011s;
            if (usbInterfaceArr[i] != null) {
                boolean claimInterface = usbDeviceConnection.claimInterface(usbInterfaceArr[i], true);
                if (claimInterface) {
                    return claimInterface;
                }
                C1856n.m8127b("DPUUSBDriver", "exclusiveAccess() -> Try to exclusive access device failed!");
                return claimInterface;
            }
        }
        return false;
    }

    /* renamed from: k */
    private boolean m8217k() {
        UsbDeviceConnection usbDeviceConnection = this.f9996d;
        if (usbDeviceConnection != null) {
            UsbInterface[] usbInterfaceArr = this.f10009q;
            int i = this.f10011s;
            if (usbInterfaceArr[i] != null) {
                return usbDeviceConnection.releaseInterface(usbInterfaceArr[i]);
            }
        }
        return false;
    }

    /* renamed from: a */
    private int m8231a(int i, int i2) {
        this.f10008p = this.f9995c.getDeviceList();
        HashMap<String, UsbDevice> hashMap = this.f10008p;
        if (hashMap == null || hashMap.size() <= 0) {
            C1856n.m8127b("DPUUSBDriver", "deviceEnumerate() -> Not detected USB device(0x" + Integer.toHexString(i) + ", 0x" + Integer.toHexString(i2) + ")!");
            return -13;
        }
        for (UsbDevice usbDevice : this.f10008p.values()) {
            if (usbDevice != null && i == usbDevice.getVendorId() && i2 == usbDevice.getProductId()) {
                this.f10010r = usbDevice.getDeviceId();
                this.f9997e = usbDevice;
                this.f10015w = this.f9997e.getDeviceName();
                if (this.f9994b) {
                    C1856n.m8127b("DPUUSBDriver", "deviceEnumerate() -> Get USB device success, VID: 0x" + Integer.toHexString(this.f9997e.getVendorId()) + ", PID: 0x" + Integer.toHexString(this.f9997e.getProductId()));
                    return 0;
                }
                return 0;
            }
        }
        return -14;
    }

    /* renamed from: l */
    private int m8216l() {
        this.f9998f = null;
        this.f10014v = null;
        this.f10013u = null;
        int interfaceCount = this.f9997e.getInterfaceCount();
        if (this.f10009q == null) {
            this.f10009q = new UsbInterface[interfaceCount];
        }
        if (this.f9994b) {
            C1856n.m8127b("DPUUSBDriver", "getSpecifiedDevice() -> Interface count: ".concat(String.valueOf(interfaceCount)));
        }
        int i = 0;
        for (int i2 = 0; i2 < interfaceCount; i2++) {
            UsbInterface usbInterface = this.f9997e.getInterface(i2);
            if (usbInterface != null) {
                this.f10009q[i2] = usbInterface;
                i = usbInterface.getEndpointCount();
                for (int i3 = 0; i3 < i; i3++) {
                    UsbEndpoint endpoint = usbInterface.getEndpoint(i3);
                    if (endpoint != null) {
                        int type = endpoint.getType();
                        int direction = endpoint.getDirection();
                        if (2 == type) {
                            if (128 == direction) {
                                if (this.f9998f == null) {
                                    this.f9998f = new C1850a(this, (byte) 0);
                                    C1850a c1850a = this.f9998f;
                                    c1850a.f10017a = endpoint;
                                    c1850a.f10018b = i2;
                                    this.f10011s = i2;
                                }
                                if (this.f9994b) {
                                    C1856n.m8127b("DPUUSBDriver", "getSpecifiedDevice() -> ep-IN, dir: " + direction + "\nep size: " + endpoint.getMaxPacketSize());
                                }
                            } else if (direction == 0) {
                                if (this.f10014v == null) {
                                    this.f10014v = new C1850a(this, (byte) 0);
                                    C1850a c1850a2 = this.f10014v;
                                    c1850a2.f10017a = endpoint;
                                    c1850a2.f10018b = i2;
                                }
                                if (this.f9994b) {
                                    C1856n.m8127b("DPUUSBDriver", "getSpecifiedDevice() -> ep-OUT, dir: " + direction + "\nep size: " + endpoint.getMaxPacketSize());
                                }
                            }
                        } else if (3 == type) {
                            if (this.f10013u == null && 128 == direction) {
                                this.f10013u = new C1850a(this, (byte) 0);
                                C1850a c1850a3 = this.f10013u;
                                c1850a3.f10017a = endpoint;
                                c1850a3.f10018b = i2;
                                this.f10012t = i2;
                            }
                            if (this.f9994b) {
                                C1856n.m8127b("DPUUSBDriver", "getSpecifiedDevice() -> ep-interrupt, dir: " + direction + "\nep size: " + endpoint.getMaxPacketSize());
                            }
                        }
                    }
                }
            }
        }
        if (i == 0) {
            C1856n.m8127b("DPUUSBDriver", "getSpecifiedDevice() -> No any ep!");
            return -22;
        } else if (this.f9998f == null) {
            C1856n.m8127b("DPUUSBDriver", "getSpecifiedDevice() -> No any IN-ep!");
            return -20;
        } else if (this.f10014v == null) {
            C1856n.m8127b("DPUUSBDriver", "getSpecifiedDevice() -> No any OUT-ep!");
            return -21;
        } else {
            return 0;
        }
    }

    /* renamed from: e */
    public final int m8223e() {
        int intValue;
        synchronized (this.f10006n) {
            intValue = this.f10006n.intValue();
        }
        return intValue;
    }

    /* renamed from: a */
    public final void m8232a(int i) {
        synchronized (this.f10006n) {
            this.f10006n = Integer.valueOf(i);
        }
    }

    /* renamed from: a */
    private int m8229a(List<C1851b> list, int i) throws XmlPullParserException, IOException {
        XmlResourceParser xml = this.f10002j.getResources().getXml(i);
        if (xml == null) {
            C1851b c1851b = new C1851b(this, (byte) 0);
            c1851b.f10020a = 1155;
            c1851b.f10021b = 26214;
            list.add(c1851b);
            C1856n.m8127b("DPUUSBDriver", "GetUsbId() -> Load res/xml/***_device.xml file failed! set default VID: 0x" + Integer.toHexString(1155) + ", PID: 0x" + Integer.toHexString(26214));
            return -23;
        }
        for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
            if (eventType == 2 && xml.getName().equals("usb-device")) {
                int attributeIntValue = xml.getAttributeIntValue(null, "vendor-id", -1);
                int attributeIntValue2 = xml.getAttributeIntValue(null, "product-id", -1);
                if (-1 != attributeIntValue && -1 != attributeIntValue2) {
                    C1851b c1851b2 = new C1851b(this, (byte) 0);
                    c1851b2.f10020a = attributeIntValue;
                    c1851b2.f10021b = attributeIntValue2;
                    list.add(c1851b2);
                    C1856n.m8126c("DPUUSBDriver", "GetUsbId() -> Support USB device, VID: 0x" + Integer.toHexString(c1851b2.f10020a) + " PID: 0x" + Integer.toHexString(c1851b2.f10021b));
                }
            }
        }
        xml.close();
        if (list.size() <= 0) {
            C1851b c1851b3 = new C1851b(this, (byte) 0);
            C1856n.m8127b("DPUUSBDriver", "GetSupportUsbId() -> Read res/xml/***_device.xml file failed! set default VID: 0x" + Integer.toHexString(1155) + ", PID: 0x" + Integer.toHexString(26214));
            c1851b3.f10020a = 1155;
            c1851b3.f10021b = 26214;
            list.add(c1851b3);
            return -23;
        }
        return 0;
    }

    /* renamed from: a */
    public final boolean m8230a(Intent intent) {
        UsbDevice usbDevice = (UsbDevice) intent.getParcelableExtra("device");
        if (usbDevice == null) {
            return false;
        }
        if (-1 != this.f10000h && -1 != this.f9999g) {
            if (usbDevice.getVendorId() == this.f10000h && usbDevice.getProductId() == this.f9999g) {
                return true;
            }
            C1856n.m8127b("DPUUSBDriver", "Device error VendorId =" + usbDevice.getVendorId() + " ProductId=" + usbDevice.getProductId());
            return false;
        }
        int size = this.f9993a.size();
        if (size <= 0) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (this.f9993a.get(i).f10020a == usbDevice.getVendorId() && this.f9993a.get(i).f10021b == usbDevice.getProductId()) {
                C1856n.m8127b("DPUUSBDriver", "Device [" + String.format("0x%x", Integer.valueOf(this.f9993a.get(i).f10020a)) + "," + String.format("0x%x", Integer.valueOf(this.f9993a.get(i).f10021b)) + "] Attached!");
                this.f10000h = usbDevice.getVendorId();
                this.f9999g = usbDevice.getProductId();
                return true;
            }
        }
        return false;
    }

    /* renamed from: f */
    public final boolean m8222f() {
        int size = this.f10004l.size();
        if (size <= 0) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (this.f10004l.get(i).f10020a == this.f10000h && this.f10004l.get(i).f10021b == this.f9999g) {
                C1856n.m8127b("DPUUSBDriver", "Device [" + String.format("0x%x", Integer.valueOf(this.f10004l.get(i).f10020a)) + "," + String.format("0x%x", Integer.valueOf(this.f10004l.get(i).f10021b)) + "] Attached!");
                return true;
            }
        }
        return false;
    }

    /* renamed from: g */
    public final boolean m8221g() {
        int size = this.f10005m.size();
        if (size <= 0) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (this.f10005m.get(i).f10020a == this.f10000h && this.f10005m.get(i).f10021b == this.f9999g) {
                C1856n.m8127b("DPUUSBDriver", "Device [" + String.format("0x%x", Integer.valueOf(this.f10005m.get(i).f10020a)) + "," + String.format("0x%x", Integer.valueOf(this.f10005m.get(i).f10021b)) + "] Attached!");
                return true;
            }
        }
        return false;
    }
}
