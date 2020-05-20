package com.cnlaunch.physics.p195b;

import android.text.TextUtils;
import com.cnlaunch.physics.DPUHardwareInformation;
import com.cnlaunch.physics.DeviceFactoryManager;
import com.cnlaunch.physics.p195b.p196a.Analysis;
import com.cnlaunch.physics.p195b.p196a.MyFactory;
import com.cnlaunch.physics.p197c.AnalysisData;
import com.cnlaunch.physics.p197c.DPUHardwareInfo;
import com.cnlaunch.physics.p197c.DPUSoftInfo;
import com.cnlaunch.physics.p199e.IPhysics;
import com.cnlaunch.physics.p201g.OnDownloadBinListener;
import com.cnlaunch.physics.p205k.Bridge;
import com.cnlaunch.physics.p205k.ByteHexHelper;
import com.cnlaunch.physics.p205k.C1856n;
import com.cnlaunch.physics.p205k.DeviceProperties;
import com.cnlaunch.physics.p205k.DeviceUtils;
import com.cnlaunch.physics.p205k.DownloadBinWriteByte;
import com.cnlaunch.physics.p205k.Tools;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

/* renamed from: com.cnlaunch.physics.b.a */
/* loaded from: classes.dex */
public final class DownloadBinUpdate {

    /* renamed from: a */
    IPhysics f9805a;

    /* renamed from: b */
    OnDownloadBinListener f9806b;

    /* renamed from: c */
    public RunnableC1830a f9807c;

    /* renamed from: d */
    public RunnableC1831b f9808d;

    /* renamed from: e */
    public boolean f9809e;

    /* renamed from: f */
    private RunnableC1832c f9810f;

    public DownloadBinUpdate(OnDownloadBinListener onDownloadBinListener, IPhysics iPhysics) {
        this.f9805a = null;
        this.f9805a = iPhysics;
        this.f9806b = onDownloadBinListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DownloadBinUpdate.java */
    /* renamed from: com.cnlaunch.physics.b.a$c */
    /* loaded from: classes.dex */
    public class RunnableC1832c implements Runnable {

        /* renamed from: a */
        String f9815a;

        /* renamed from: b */
        String f9816b;

        /* renamed from: c */
        boolean f9817c = false;

        public RunnableC1832c(String str, String str2) {
            this.f9815a = str;
            this.f9816b = str2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (Tools.m8114a() && !Tools.m8101b()) {
                    Thread.sleep(2000L);
                    DownloadBinUpdate.this.m8375a(this.f9815a);
                } else if (DeviceUtils.m8149a().f10116a) {
                    DownloadBinUpdate.this.m8367b(this.f9815a, this.f9816b);
                    DeviceUtils.m8149a().f10116a = false;
                } else {
                    DownloadBinUpdate.this.m8373a(this.f9815a, this.f9816b, this.f9817c);
                }
            } catch (Exception unused) {
                DownloadBinUpdate.this.f9806b.mo6135a(6, 0L, 0L);
            }
        }
    }

    /* compiled from: DownloadBinUpdate.java */
    /* renamed from: com.cnlaunch.physics.b.a$a */
    /* loaded from: classes.dex */
    public class RunnableC1830a implements Runnable {

        /* renamed from: b */
        private String f9812b;

        /* renamed from: c */
        private String f9813c;

        public RunnableC1830a(String str, String str2) {
            this.f9812b = str;
            this.f9813c = str2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (Tools.m8114a() && !Tools.m8101b()) {
                    if (DownloadBinUpdate.this.m8381a().equalsIgnoreCase("3f")) {
                        try {
                            Thread.sleep(1000L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        DownloadBinUpdate.this.f9806b.mo6134a(9, DownloadBinUpdate.m8380a(DownloadBinUpdate.this, this.f9812b));
                        return;
                    }
                    DownloadBinUpdate.this.f9806b.mo6134a(11, "");
                    return;
                }
                DownloadBinUpdate downloadBinUpdate = DownloadBinUpdate.this;
                String str = this.f9812b;
                String str2 = this.f9813c;
                String[] m8379a = DownloadBinUpdate.m8379a(downloadBinUpdate.f9805a);
                boolean z = true;
                if (m8379a == null) {
                    z = false;
                } else if (Tools.m8114a() && !Tools.m8101b()) {
                    if (m8379a != null && m8379a.length == 1) {
                        String[] strArr = {"", "", "", "", "", ""};
                        strArr[2] = m8379a[0];
                        DeviceUtils.m8149a();
                        DeviceUtils.m8144a(str, str2, strArr);
                    }
                } else if (m8379a != null && m8379a.length >= 5) {
                    DeviceUtils.m8149a();
                    DeviceUtils.m8144a(str, str2, m8379a);
                    if (DeviceFactoryManager.m8305a().f9903c == 2) {
                        DPUHardwareInformation.m8315a(str2).m8316a(new DPUHardwareInfo(m8379a));
                    }
                }
                if (!z) {
                    DownloadBinUpdate.this.f9806b.mo6134a(10, "");
                } else {
                    DownloadBinUpdate.this.f9806b.mo6134a(9, DownloadBinUpdate.m8380a(DownloadBinUpdate.this, this.f9812b));
                }
            } catch (Exception unused) {
                DownloadBinUpdate.this.f9806b.mo6134a(10, "");
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0227 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x021a  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final java.lang.String m8367b(java.lang.String r19, java.lang.String r20) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 644
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.physics.p195b.DownloadBinUpdate.m8367b(java.lang.String, java.lang.String):java.lang.String");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:42|43|44|45|(6:46|47|(1:1)(3:51|(5:131|132|(1:134)|135|136)(9:53|54|(1:56)|57|(1:59)(1:130)|60|(1:62)|63|(3:65|(2:66|(3:70|(3:124|125|126)(7:72|73|(1:75)|76|(1:78)|79|(2:84|85)(2:81|82))|83)(2:128|127))|(5:87|(1:89)|90|91|92)(1:94))(1:129))|93)|96|97|(2:99|100)(3:101|102|(2:104|105)(4:107|108|109|(2:111|112)(2:113|114))))|95|96|97|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0245, code lost:
        r5 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x024b, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0253, code lost:
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0265 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final java.lang.String m8373a(java.lang.String r20, java.lang.String r21, boolean r22) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 708
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.physics.p195b.DownloadBinUpdate.m8373a(java.lang.String, java.lang.String, boolean):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x010b  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final java.lang.String m8375a(java.lang.String r22) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 687
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.physics.p195b.DownloadBinUpdate.m8375a(java.lang.String):java.lang.String");
    }

    /* renamed from: b */
    private String m8371b() {
        String str = "";
        byte[] mo8323e = MyFactory.m8342a().mo8323e();
        if (mo8323e.length <= 0) {
            return "";
        }
        int i = 0;
        while (i < 3) {
            Tools.m8103a(mo8323e, this.f9805a);
            String command = this.f9805a.getCommand();
            if (!TextUtils.isEmpty(command)) {
                str = MyFactory.m8341b().mo8359a(MyFactory.m8341b().mo8357a(mo8323e, ByteHexHelper.m8183a(command), this.f9806b));
                if (str.length() > 0) {
                    break;
                }
                i++;
            } else {
                i++;
            }
        }
        return str;
    }

    /* renamed from: b */
    private boolean m8368b(String str) {
        byte[] mo8336a = MyFactory.m8342a().mo8336a(str);
        if (mo8336a.length <= 0) {
            return false;
        }
        int i = 0;
        while (i < 3) {
            Tools.m8103a(mo8336a, this.f9805a);
            String command = this.f9805a.getCommand();
            if (TextUtils.isEmpty(command)) {
                i++;
            } else {
                if (MyFactory.m8341b().mo8356b(MyFactory.m8341b().mo8357a(mo8336a, ByteHexHelper.m8183a(command), this.f9806b)).booleanValue()) {
                    return true;
                }
                i++;
            }
        }
        return false;
    }

    /* renamed from: a */
    static String[] m8379a(IPhysics iPhysics) {
        Boolean bool = Boolean.FALSE;
        byte[] mo8339a = MyFactory.m8342a().mo8339a();
        if (C1856n.f10135a) {
            C1856n.m8130a("DownloadBinUp", "DownloadBinUpdate.readDPUDeviceInfo2103().sendOrder = " + ByteHexHelper.m8180a(mo8339a));
        }
        if (mo8339a.length <= 0) {
            return null;
        }
        String[] strArr = null;
        byte[] bArr = mo8339a;
        Boolean bool2 = bool;
        int i = 0;
        while (i < 3) {
            if (i == 0 && !bool2.booleanValue()) {
                Tools.m8103a(bArr, iPhysics);
            } else {
                Tools.m8102a(bArr, iPhysics, 2000);
            }
            String command = iPhysics.getCommand();
            if (TextUtils.isEmpty(command)) {
                if (bool2.booleanValue()) {
                    i++;
                } else {
                    bArr = MyFactory.m8342a().mo8339a();
                    bool2 = Boolean.TRUE;
                    if (C1856n.f10135a) {
                        C1856n.m8130a("DownloadBinUp", "DownloadBinUpdate.readDPUDeviceInfo2103(). generate NewCounter sendOrder  = " + ByteHexHelper.m8180a(bArr));
                    }
                    i = 0;
                }
            } else {
                if (C1856n.f10135a) {
                    C1856n.m8130a("DownloadBinUp", "DownloadBinUpdate.readDPUDeviceInfo2103().backOrder = ".concat(String.valueOf(command)));
                }
                byte[] m8183a = ByteHexHelper.m8183a(command);
                Analysis m8341b = MyFactory.m8341b();
                AnalysisData mo8358a = m8341b.mo8358a(bArr, m8183a);
                if (mo8358a.f9843d.booleanValue()) {
                    strArr = m8341b.mo8348i(mo8358a);
                    if (strArr != null || bool2.booleanValue()) {
                        break;
                    }
                    bArr = MyFactory.m8342a().mo8339a();
                    bool2 = Boolean.TRUE;
                    if (C1856n.f10135a) {
                        C1856n.m8130a("DownloadBinUp", "DownloadBinUpdate.readDPUDeviceInfo2103(). generate NewCounter sendOrder  = " + ByteHexHelper.m8180a(bArr));
                    }
                    i = 0;
                } else if (bool2.booleanValue()) {
                    i++;
                } else {
                    bArr = MyFactory.m8342a().mo8339a();
                    bool2 = Boolean.TRUE;
                    if (C1856n.f10135a) {
                        C1856n.m8130a("DownloadBinUp", "DownloadBinUpdate.readDPUDeviceInfo2103(). generate NewCounter sendOrder  = " + ByteHexHelper.m8180a(bArr));
                        i = 0;
                    } else {
                        i = 0;
                    }
                }
            }
        }
        if (C1856n.f10135a) {
            C1856n.m8130a("DownloadBinUp", "DownloadBinUpdate.readDPUDeviceInfo2103().deviceinfo = ".concat(String.valueOf(strArr)));
        }
        return strArr;
    }

    /* renamed from: a */
    public final String m8381a() {
        byte[] mo8322f = MyFactory.m8342a().mo8322f();
        if (C1856n.f10135a) {
            C1856n.m8130a("DownloadBinUp", "sendOrder=" + ByteHexHelper.m8180a(mo8322f));
        }
        String str = "";
        int i = 0;
        while (i < 3) {
            if (mo8322f.length > 0) {
                this.f9805a.setCommand_wait(true);
                this.f9805a.setCommand("");
                OutputStream outputStream = this.f9805a.getOutputStream();
                try {
                    if (C1856n.f10135a) {
                        C1856n.m8130a("DownloadBinUp", "DownloadBinUpdate.resetDPU().outputStream.write(sendOrder)=" + ByteHexHelper.m8180a(mo8322f));
                    }
                    this.f9805a.setIsTruckReset(true);
                    outputStream.write(mo8322f);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                int i2 = 0;
                while (this.f9805a.getCommand_wait() && i2 < 40) {
                    i2++;
                    try {
                        Thread.sleep(250L);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
                String command = this.f9805a.getCommand();
                if (C1856n.f10135a) {
                    C1856n.m8130a("DownloadBinUp", "DownloadBinUpdate.resetDPU().backOrder=".concat(String.valueOf(command)));
                }
                this.f9805a.setIsTruckReset(false);
                if (command != null && command.equalsIgnoreCase("3f")) {
                    return command;
                }
                str = "";
                i++;
            } else {
                i++;
            }
        }
        return str;
    }

    /* renamed from: a */
    private boolean m8377a(File file) {
        byte[] mo8337a;
        if (file.getName().equalsIgnoreCase("DOWNLOAD103.bin")) {
            mo8337a = MyFactory.m8342a().mo8331b(file);
        } else {
            mo8337a = MyFactory.m8342a().mo8337a(file);
        }
        if (mo8337a.length <= 0) {
            return false;
        }
        int i = 0;
        while (i < 3) {
            Tools.m8102a(mo8337a, this.f9805a, 10000);
            String command = this.f9805a.getCommand();
            if (TextUtils.isEmpty(command)) {
                i++;
            } else {
                if (MyFactory.m8341b().mo8351f(MyFactory.m8341b().mo8357a(mo8337a, ByteHexHelper.m8183a(command), this.f9806b)).booleanValue()) {
                    return true;
                }
                i++;
            }
        }
        return false;
    }

    /* renamed from: a */
    private boolean m8372a(String str, boolean z) {
        byte[] mo8330b = MyFactory.m8342a().mo8330b(str);
        if (C1856n.f10135a) {
            C1856n.m8130a("DownloadBinUp", "sendUpdateFileMd5.sendOrder = " + ByteHexHelper.m8180a(mo8330b) + " isEncryptDownloadBin=" + z);
        }
        if (mo8330b.length <= 0) {
            return false;
        }
        int i = 0;
        while (i < 3) {
            if (z) {
                Tools.m8102a(mo8330b, this.f9805a, 30000);
            } else {
                Tools.m8103a(mo8330b, this.f9805a);
            }
            String command = this.f9805a.getCommand();
            if (TextUtils.isEmpty(command)) {
                i++;
            } else {
                if (C1856n.f10135a) {
                    C1856n.m8130a("DownloadBinUp", "sendUpdateFileMd5.backOrder = ".concat(String.valueOf(command)));
                }
                if (MyFactory.m8341b().mo8350g(MyFactory.m8341b().mo8357a(mo8330b, ByteHexHelper.m8183a(command), this.f9806b)).booleanValue()) {
                    return true;
                }
                i++;
            }
        }
        return false;
    }

    /* renamed from: c */
    private boolean m8364c(String str) {
        byte[] mo8326c = MyFactory.m8342a().mo8326c(str);
        if (mo8326c.length <= 0) {
            return false;
        }
        int i = 0;
        while (i < 3) {
            Tools.m8103a(mo8326c, this.f9805a);
            String command = this.f9805a.getCommand();
            if (C1856n.f10135a) {
                C1856n.m8127b("DownloadBinUp", " sendUpdateFileMd52414 backorder=".concat(String.valueOf(command)));
            }
            if (TextUtils.isEmpty(command)) {
                i++;
            } else {
                if (MyFactory.m8341b().mo8350g(MyFactory.m8341b().mo8357a(mo8326c, ByteHexHelper.m8183a(command), this.f9806b)).booleanValue()) {
                    return true;
                }
                i++;
            }
        }
        return false;
    }

    /* renamed from: c */
    private boolean m8366c() {
        byte[] mo8321g = MyFactory.m8342a().mo8321g();
        String str = "";
        for (int i = 0; i < 3; i++) {
            if (mo8321g.length > 0) {
                DownloadBinWriteByte downloadBinWriteByte = new DownloadBinWriteByte(new Bridge(), mo8321g, this.f9805a, (byte) 0);
                this.f9805a.setCommand("");
                Thread thread = new Thread(downloadBinWriteByte);
                thread.start();
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                str = this.f9805a.getCommand();
                if (C1856n.f10135a) {
                    C1856n.m8130a("DownloadBinUp", "sendUpdate() --> backOrder = ".concat(String.valueOf(str)));
                }
            }
            if (str.toLowerCase().equals("4f4b21")) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: d */
    private boolean m8363d() {
        byte[] mo8320h = MyFactory.m8342a().mo8320h();
        String str = "";
        for (int i = 0; i <= 0; i++) {
            if (mo8320h.length > 0) {
                DownloadBinWriteByte downloadBinWriteByte = new DownloadBinWriteByte(new Bridge(), mo8320h, this.f9805a);
                this.f9805a.setCommand("");
                Thread thread = new Thread(downloadBinWriteByte);
                thread.start();
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                str = this.f9805a.getCommand();
                if (C1856n.f10135a) {
                    C1856n.m8130a("DownloadBinUp", "setBautrate() --> backOrder = ".concat(String.valueOf(str)));
                }
            }
            if (str.toLowerCase().equals("55aa0007fff8630063")) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: e */
    private boolean m8362e() {
        byte[] mo8319i = MyFactory.m8342a().mo8319i();
        String str = "";
        for (int i = 0; i <= 0; i++) {
            if (mo8319i.length > 0) {
                DownloadBinWriteByte downloadBinWriteByte = new DownloadBinWriteByte(new Bridge(), mo8319i, this.f9805a);
                this.f9805a.setCommand("");
                Thread thread = new Thread(downloadBinWriteByte);
                thread.start();
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                str = this.f9805a.getCommand();
                if (C1856n.f10135a) {
                    C1856n.m8130a("DownloadBinUp", "setAddressAndSize() --> backOrder = ".concat(String.valueOf(str)));
                }
            }
            if (str.toLowerCase().equals("55aa0007fff8620062")) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private static void m8376a(File file, String str) throws IOException {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    fileOutputStream2.write(str.getBytes());
                    fileOutputStream2.close();
                } catch (Exception e) {
                    e = e;
                    fileOutputStream = fileOutputStream2;
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    /* renamed from: b */
    public static String[] m8370b(IPhysics iPhysics) {
        try {
            return m8379a(iPhysics);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* compiled from: DownloadBinUpdate.java */
    /* renamed from: com.cnlaunch.physics.b.a$b */
    /* loaded from: classes.dex */
    public class RunnableC1831b implements Runnable {
        public RunnableC1831b() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:29:0x0084, code lost:
            r8.f9814a.f9806b.mo6134a(10, "");
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x008d, code lost:
            return;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void run() {
            /*
                r8 = this;
                r0 = 10
                com.cnlaunch.physics.e r1 = com.cnlaunch.physics.DeviceFactoryManager.m8305a()     // Catch: java.lang.Exception -> La4
                java.lang.String r1 = r1.m8280e()     // Catch: java.lang.Exception -> La4
                if (r1 == 0) goto L98
                com.cnlaunch.physics.e r1 = com.cnlaunch.physics.DeviceFactoryManager.m8305a()     // Catch: java.lang.Exception -> La4
                java.lang.String r1 = r1.m8280e()     // Catch: java.lang.Exception -> La4
                java.lang.String r2 = "98454"
                boolean r1 = r1.contains(r2)     // Catch: java.lang.Exception -> La4
                if (r1 != 0) goto L98
                com.cnlaunch.physics.e r1 = com.cnlaunch.physics.DeviceFactoryManager.m8305a()     // Catch: java.lang.Exception -> La4
                java.lang.String r1 = r1.m8280e()     // Catch: java.lang.Exception -> La4
                java.lang.String r2 = "98649"
                boolean r1 = r1.contains(r2)     // Catch: java.lang.Exception -> La4
                if (r1 == 0) goto L2e
                goto L98
            L2e:
                com.cnlaunch.physics.b.a r1 = com.cnlaunch.physics.p195b.DownloadBinUpdate.this     // Catch: java.lang.Exception -> La4
                com.cnlaunch.physics.e.c r1 = r1.f9805a     // Catch: java.lang.Exception -> La4
                com.cnlaunch.physics.b.a.f r2 = com.cnlaunch.physics.p195b.p196a.MyFactory.m8342a()     // Catch: java.lang.Exception -> La4
                byte[] r2 = r2.mo8318j()     // Catch: java.lang.Exception -> La4
                int r3 = r2.length     // Catch: java.lang.Exception -> La4
                r4 = 0
                r5 = 0
                if (r3 > 0) goto L41
                r1 = r5
                goto L72
            L41:
                r3 = 0
            L42:
                r6 = 3
                if (r3 >= r6) goto L71
                com.cnlaunch.physics.p205k.Tools.m8103a(r2, r1)     // Catch: java.lang.Exception -> La4
                java.lang.String r6 = r1.getCommand()     // Catch: java.lang.Exception -> La4
                boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch: java.lang.Exception -> La4
                if (r7 == 0) goto L55
                int r3 = r3 + 1
                goto L42
            L55:
                byte[] r1 = com.cnlaunch.physics.p205k.ByteHexHelper.m8183a(r6)     // Catch: java.lang.Exception -> La4
                com.cnlaunch.physics.b.a.a r3 = com.cnlaunch.physics.p195b.p196a.MyFactory.m8341b()     // Catch: java.lang.Exception -> La4
                com.cnlaunch.physics.c.a r1 = r3.mo8358a(r2, r1)     // Catch: java.lang.Exception -> La4
                java.lang.Boolean r2 = r1.f9843d     // Catch: java.lang.Exception -> La4
                boolean r2 = r2.booleanValue()     // Catch: java.lang.Exception -> La4
                if (r2 == 0) goto L71
                java.util.ArrayList r1 = r3.mo8347j(r1)     // Catch: java.lang.Exception -> La4
                r1.size()     // Catch: java.lang.Exception -> La4
                goto L72
            L71:
                r1 = r5
            L72:
                if (r1 != 0) goto L75
                goto L82
            L75:
                int r2 = r1.size()     // Catch: java.lang.Exception -> La4
                if (r2 <= 0) goto L82
                java.lang.Object r1 = r1.get(r4)     // Catch: java.lang.Exception -> La4
                r5 = r1
                java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Exception -> La4
            L82:
                if (r5 != 0) goto L8e
                com.cnlaunch.physics.b.a r1 = com.cnlaunch.physics.p195b.DownloadBinUpdate.this     // Catch: java.lang.Exception -> La4
                com.cnlaunch.physics.g.b r1 = r1.f9806b     // Catch: java.lang.Exception -> La4
                java.lang.String r2 = ""
                r1.mo6134a(r0, r2)     // Catch: java.lang.Exception -> La4
                return
            L8e:
                com.cnlaunch.physics.b.a r1 = com.cnlaunch.physics.p195b.DownloadBinUpdate.this     // Catch: java.lang.Exception -> La4
                com.cnlaunch.physics.g.b r1 = r1.f9806b     // Catch: java.lang.Exception -> La4
                r2 = 18
                r1.mo6134a(r2, r5)     // Catch: java.lang.Exception -> La4
                return
            L98:
                com.cnlaunch.physics.b.a r1 = com.cnlaunch.physics.p195b.DownloadBinUpdate.this     // Catch: java.lang.Exception -> La4
                com.cnlaunch.physics.g.b r1 = r1.f9806b     // Catch: java.lang.Exception -> La4
                r2 = 19
                java.lang.String r3 = ""
                r1.mo6134a(r2, r3)     // Catch: java.lang.Exception -> La4
                return
            La4:
                com.cnlaunch.physics.b.a r1 = com.cnlaunch.physics.p195b.DownloadBinUpdate.this
                com.cnlaunch.physics.g.b r1 = r1.f9806b
                java.lang.String r2 = ""
                r1.mo6134a(r0, r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.physics.p195b.DownloadBinUpdate.RunnableC1831b.run():void");
        }
    }

    /* renamed from: a */
    public static String m8378a(IPhysics iPhysics, OnDownloadBinListener onDownloadBinListener) {
        byte[] mo8327c = MyFactory.m8342a().mo8327c();
        if (mo8327c.length <= 0) {
            return "";
        }
        int i = 0;
        while (i < 3) {
            Tools.m8103a(mo8327c, iPhysics);
            String command = iPhysics.getCommand();
            if (TextUtils.isEmpty(command)) {
                i++;
            } else {
                AnalysisData mo8357a = MyFactory.m8341b().mo8357a(mo8327c, ByteHexHelper.m8183a(command), onDownloadBinListener);
                if (mo8357a.f9843d.booleanValue()) {
                    return MyFactory.m8341b().mo8354c(mo8357a);
                }
                i++;
            }
        }
        return "";
    }

    /* renamed from: b */
    private static boolean m8369b(IPhysics iPhysics, OnDownloadBinListener onDownloadBinListener) {
        byte[] mo8325d = MyFactory.m8342a().mo8325d();
        if (mo8325d.length <= 0) {
            return false;
        }
        int i = 0;
        while (i < 3) {
            Tools.m8103a(mo8325d, iPhysics);
            String command = iPhysics.getCommand();
            if (TextUtils.isEmpty(command)) {
                i++;
            } else {
                if (MyFactory.m8341b().mo8352e(MyFactory.m8341b().mo8357a(mo8325d, ByteHexHelper.m8183a(command), onDownloadBinListener)).booleanValue()) {
                    return true;
                }
                i++;
            }
        }
        return false;
    }

    /* renamed from: c */
    public static Boolean m8365c(IPhysics iPhysics) {
        Boolean bool = Boolean.FALSE;
        byte[] mo8322f = MyFactory.m8342a().mo8322f();
        if (C1856n.f10135a) {
            C1856n.m8130a("DownloadBinUp", "DownloadBinUpdate.resetConnector2505.sendOrder = " + ByteHexHelper.m8180a(mo8322f));
        }
        if (mo8322f.length <= 0) {
            return bool;
        }
        try {
            iPhysics.getOutputStream().write(mo8322f);
        } catch (Exception e) {
            Boolean bool2 = Boolean.FALSE;
            e.printStackTrace();
        }
        try {
            Thread.sleep(200L);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        if (DeviceFactoryManager.m8305a().f9903c == 3) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    /* renamed from: a */
    public final void m8374a(String str, String str2) {
        if (C1856n.f10135a) {
            C1856n.m8127b("DownloadBinUp", "DownloadBinUpdate updateAsync isEncryptDownloadBin=false");
        }
        if (this.f9810f == null) {
            this.f9810f = new RunnableC1832c(str, str2);
        }
        this.f9809e = false;
        new Thread(this.f9810f).start();
    }

    /* renamed from: a */
    static /* synthetic */ String m8380a(DownloadBinUpdate downloadBinUpdate, String str) {
        ArrayList<String> arrayList;
        String str2;
        IPhysics iPhysics = downloadBinUpdate.f9805a;
        OnDownloadBinListener onDownloadBinListener = downloadBinUpdate.f9806b;
        Boolean bool = Boolean.FALSE;
        byte[] mo8332b = MyFactory.m8342a().mo8332b();
        if (C1856n.f10135a) {
            C1856n.m8130a("DownloadBinUp", "readDPUVersionInfo2105.sendOrder = " + ByteHexHelper.m8180a(mo8332b));
        }
        if (mo8332b.length <= 0) {
            arrayList = null;
        } else {
            Boolean bool2 = bool;
            int i = 0;
            while (true) {
                if (i >= 3) {
                    arrayList = null;
                    break;
                }
                Tools.m8102a(mo8332b, iPhysics, 2000);
                String command = iPhysics.getCommand();
                if (C1856n.f10135a) {
                    C1856n.m8130a("DownloadBinUp", "readDPUVersionInfo2105().backOrder=".concat(String.valueOf(command)));
                }
                if (TextUtils.isEmpty(command)) {
                    i++;
                } else {
                    byte[] m8183a = ByteHexHelper.m8183a(command);
                    Analysis m8341b = MyFactory.m8341b();
                    AnalysisData mo8357a = m8341b.mo8357a(mo8332b, m8183a, onDownloadBinListener);
                    if (mo8357a.f9843d.booleanValue()) {
                        arrayList = m8341b.mo8353d(mo8357a);
                        break;
                    } else if (bool2.booleanValue()) {
                        i++;
                    } else {
                        mo8332b = MyFactory.m8342a().mo8332b();
                        bool2 = Boolean.TRUE;
                        if (C1856n.f10135a) {
                            C1856n.m8130a("DownloadBinUp", "DownloadBinUpdate.readDPUVersionInfo2105(). generate NewCounter sendOrder  = " + ByteHexHelper.m8180a(mo8332b));
                            i = 0;
                        } else {
                            i = 0;
                        }
                    }
                }
            }
            if (C1856n.f10135a) {
                C1856n.m8130a("DownloadBinUp", "DownloadBinUpdate.readDPUVersionInfo2105(). generate NewCounter sendOrder  = " + ByteHexHelper.m8180a(mo8332b));
            }
        }
        if (arrayList == null || arrayList.isEmpty()) {
            return "";
        }
        if (Tools.m8114a() && !Tools.m8101b()) {
            str2 = arrayList.get(0).substring(6, 10);
            if (!str2.isEmpty() || str2.length() >= 4) {
                str2 = "V" + ByteHexHelper.m8168d(str2.substring(0, 2)) + "." + ByteHexHelper.m8168d(str2.substring(2, 4));
                DeviceUtils.m8149a();
                DeviceUtils.m8145a(str, (String) null, str2);
            }
        } else {
            String str3 = arrayList.get(1);
            if (C1856n.f10135a) {
                C1856n.m8130a("DownloadBinUp", "downloadBinVer000=".concat(String.valueOf(str3)));
            }
            DeviceUtils.m8149a();
            DPUSoftInfo dPUSoftInfo = new DPUSoftInfo(arrayList);
            DeviceProperties m8157a = DeviceProperties.m8157a(str, null);
            m8157a.f10112a.setProperty(DPUSoftInfo.f9860a, dPUSoftInfo.f9865f);
            m8157a.f10112a.setProperty(DPUSoftInfo.f9861b, dPUSoftInfo.f9866g);
            m8157a.f10112a.setProperty(DPUSoftInfo.f9862c, dPUSoftInfo.f9867h);
            m8157a.f10112a.setProperty(DPUSoftInfo.f9863d, dPUSoftInfo.f9868i);
            m8157a.f10112a.setProperty(DPUSoftInfo.f9864e, dPUSoftInfo.f9869j);
            m8157a.m8154c();
            str2 = str3;
        }
        if (C1856n.f10135a) {
            C1856n.m8130a("DownloadBinUp", "downloadBinVer=".concat(String.valueOf(str2)));
        }
        return str2;
    }
}
