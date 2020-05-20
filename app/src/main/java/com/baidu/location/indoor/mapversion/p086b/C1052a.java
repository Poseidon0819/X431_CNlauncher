package com.baidu.location.indoor.mapversion.p086b;

import android.content.Context;
import com.baidu.location.BDLocation;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.util.HashMap;

/* renamed from: com.baidu.location.indoor.mapversion.b.a */
/* loaded from: classes.dex */
public class C1052a {

    /* renamed from: a */
    private static C1052a f4833a;

    /* renamed from: b */
    private InterfaceC1056c f4834b;

    /* renamed from: c */
    private String f4835c;

    /* renamed from: e */
    private String f4837e;

    /* renamed from: f */
    private C1055b f4838f;

    /* renamed from: d */
    private boolean f4836d = false;

    /* renamed from: g */
    private String f4839g = CoordinateType.GCJ02;

    /* renamed from: h */
    private HashMap<String, C1057d> f4840h = new HashMap<>();

    /* renamed from: com.baidu.location.indoor.mapversion.b.a$a */
    /* loaded from: classes.dex */
    public static class C1054a {

        /* renamed from: a */
        public double f4843a;

        /* renamed from: b */
        public double f4844b;

        /* renamed from: c */
        public double f4845c;

        /* renamed from: d */
        public double f4846d;

        /* renamed from: e */
        public double f4847e;

        /* renamed from: f */
        public double f4848f;

        /* renamed from: g */
        public double f4849g;

        /* renamed from: h */
        public double f4850h;

        public C1054a(String str) {
            m11280a(str);
        }

        /* renamed from: a */
        public void m11280a(String str) {
            String[] split = str.trim().split("\\|");
            this.f4843a = Double.valueOf(split[0]).doubleValue();
            this.f4844b = Double.valueOf(split[1]).doubleValue();
            this.f4845c = Double.valueOf(split[2]).doubleValue();
            this.f4846d = Double.valueOf(split[3]).doubleValue();
            this.f4847e = Double.valueOf(split[4]).doubleValue();
            this.f4848f = Double.valueOf(split[5]).doubleValue();
            this.f4849g = Double.valueOf(split[6]).doubleValue();
            this.f4850h = Double.valueOf(split[7]).doubleValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.location.indoor.mapversion.b.a$b */
    /* loaded from: classes.dex */
    public class C1055b extends Thread {

        /* renamed from: b */
        private String f4852b;

        /* renamed from: c */
        private String f4853c;

        public C1055b(String str, String str2) {
            this.f4852b = str;
            this.f4853c = str2;
        }

        /* JADX WARN: Removed duplicated region for block: B:31:0x0113 A[Catch: Exception -> 0x011d, TRY_LEAVE, TryCatch #0 {Exception -> 0x011d, blocks: (B:3:0x0001, B:5:0x0012, B:8:0x001b, B:12:0x0059, B:14:0x0070, B:15:0x0090, B:17:0x0096, B:18:0x009a, B:20:0x00aa, B:29:0x010b, B:31:0x0113, B:21:0x00c3, B:24:0x00ce, B:27:0x00fa, B:11:0x0057, B:7:0x0018), top: B:37:0x0001 }] */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 295
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.indoor.mapversion.p086b.C1052a.C1055b.run():void");
        }
    }

    /* renamed from: com.baidu.location.indoor.mapversion.b.a$c */
    /* loaded from: classes.dex */
    public interface InterfaceC1056c {
        /* renamed from: a */
        void mo11279a(boolean z, String str);
    }

    /* renamed from: com.baidu.location.indoor.mapversion.b.a$d */
    /* loaded from: classes.dex */
    public static class C1057d implements Serializable {

        /* renamed from: a */
        public String f4854a;

        /* renamed from: b */
        public String f4855b;

        /* renamed from: c */
        public C1054a f4856c;

        /* renamed from: e */
        public C1054a f4858e;

        /* renamed from: g */
        public short[][] f4860g;

        /* renamed from: d */
        public C1054a f4857d;

        /* renamed from: f */
        public C1054a f4859f = this.f4857d;

        /* renamed from: h */
        private String f4861h = CoordinateType.GCJ02;

        public C1057d(String str) {
            this.f4854a = str;
        }

        /* renamed from: a */
        public double m11277a(double d) {
            return (d + this.f4859f.f4846d) * this.f4859f.f4845c;
        }

        /* renamed from: a */
        public C1054a m11278a() {
            return this.f4859f;
        }

        /* renamed from: a */
        public void m11276a(String str) {
            C1054a c1054a;
            if (str != null) {
                this.f4861h = str.toLowerCase();
                if (this.f4861h.startsWith(CoordinateType.WGS84)) {
                    c1054a = this.f4856c;
                } else if (!this.f4861h.startsWith(BDLocation.BDLOCATION_GCJ02_TO_BD09)) {
                    if (this.f4861h.startsWith(CoordinateType.GCJ02)) {
                        this.f4859f = this.f4857d;
                        return;
                    }
                    return;
                } else {
                    c1054a = this.f4858e;
                }
                this.f4859f = c1054a;
            }
        }

        /* renamed from: b */
        public double m11275b(double d) {
            return (d + this.f4859f.f4848f) * this.f4859f.f4847e;
        }

        /* renamed from: b */
        public void m11274b(String str) {
            String[] split = str.split("\\t");
            this.f4855b = split[1];
            this.f4856c = new C1054a(split[2]);
            this.f4858e = new C1054a(split[3]);
            this.f4857d = new C1054a(split[4]);
            this.f4859f = this.f4857d;
            this.f4860g = (short[][]) Array.newInstance(short.class, (int) this.f4859f.f4849g, (int) this.f4859f.f4850h);
            for (int i = 0; i < this.f4859f.f4849g; i++) {
                for (int i2 = 0; i2 < this.f4859f.f4850h; i2++) {
                    this.f4860g[i][i2] = (short) (split[5].charAt((((int) this.f4859f.f4850h) * i) + i2) - '0');
                }
            }
        }

        /* renamed from: c */
        public double m11273c(double d) {
            return (d / this.f4859f.f4845c) - this.f4859f.f4846d;
        }

        /* renamed from: d */
        public double m11272d(double d) {
            return (d / this.f4859f.f4847e) - this.f4859f.f4848f;
        }
    }

    private C1052a(Context context) {
        this.f4837e = "rn";
        this.f4837e = new File(context.getCacheDir(), this.f4837e).getAbsolutePath();
    }

    /* renamed from: a */
    public static C1052a m11304a() {
        return f4833a;
    }

    /* renamed from: a */
    public static C1052a m11303a(Context context) {
        if (f4833a == null) {
            f4833a = new C1052a(context);
        }
        return f4833a;
    }

    /* renamed from: a */
    public static String m11298a(File file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            MappedByteBuffer map = fileInputStream.getChannel().map(FileChannel.MapMode.READ_ONLY, 0L, file.length());
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(map);
            String bigInteger = new BigInteger(1, messageDigest.digest()).toString(16);
            fileInputStream.close();
            for (int length = 32 - bigInteger.length(); length > 0; length--) {
                bigInteger = "0".concat(String.valueOf(bigInteger));
            }
            return bigInteger;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public String m11295a(String str, String str2) {
        return m11286c(str) + "_" + str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m11289b(String str, String str2) {
        try {
            File file = new File(this.f4837e + "/" + m11295a(str, str2));
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public String m11286c(String str) {
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public boolean m11288c() {
        String str = this.f4835c;
        if (str == null) {
            return false;
        }
        File m11284e = m11284e(str);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (!C1058b.m11271a(m11284e, byteArrayOutputStream)) {
            return false;
        }
        this.f4840h.clear();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(byteArrayOutputStream.toByteArray())));
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    bufferedReader.close();
                    return true;
                }
                C1057d c1057d = new C1057d(this.f4835c);
                c1057d.m11274b(readLine);
                c1057d.m11276a(this.f4839g);
                this.f4840h.put(c1057d.f4855b.toLowerCase(), c1057d);
            } catch (IOException e) {
                e.printStackTrace();
                return true;
            }
        }
    }

    /* renamed from: d */
    private String m11285d(final String str) {
        File file = new File(this.f4837e);
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles(new FilenameFilter() { // from class: com.baidu.location.indoor.mapversion.b.a.1
                @Override // java.io.FilenameFilter
                public boolean accept(File file2, String str2) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(C1052a.this.m11286c(str));
                    sb.append("_");
                    return str2.startsWith(sb.toString());
                }
            });
            if (listFiles != null && listFiles.length == 1) {
                String[] split = listFiles[0].getName().split("_");
                if (split.length < 2) {
                    return null;
                }
                return split[1];
            }
            for (int i = 0; listFiles != null && i < listFiles.length; i++) {
                listFiles[i].delete();
            }
        }
        return null;
    }

    /* renamed from: e */
    private File m11284e(String str) {
        String m11285d = m11285d(str);
        return new File(this.f4837e + "/" + m11295a(str, m11285d));
    }

    /* renamed from: f */
    private boolean m11283f(String str) {
        File m11284e = m11284e(str);
        return m11284e.exists() && m11284e.length() > 0;
    }

    /* renamed from: g */
    private boolean m11282g(String str) {
        return System.currentTimeMillis() - m11284e(str).lastModified() > 1296000000;
    }

    /* renamed from: h */
    private void m11281h(String str) {
        if (this.f4836d) {
            return;
        }
        this.f4836d = true;
        this.f4838f = new C1055b(str, m11285d(str));
        this.f4838f.start();
    }

    /* renamed from: a */
    public void m11297a(String str) {
        this.f4839g = str;
    }

    /* renamed from: a */
    public void m11296a(String str, InterfaceC1056c interfaceC1056c) {
        String str2 = this.f4835c;
        if (str2 == null || !str.equals(str2)) {
            this.f4834b = interfaceC1056c;
            if (!m11283f(str) || m11282g(str)) {
                m11281h(str);
                return;
            }
            this.f4835c = str;
            m11288c();
            InterfaceC1056c interfaceC1056c2 = this.f4834b;
            if (interfaceC1056c2 != null) {
                interfaceC1056c2.mo11279a(true, "OK");
            }
        }
    }

    /* renamed from: b */
    public C1057d m11290b(String str) {
        return this.f4840h.get(str.toLowerCase());
    }

    /* renamed from: b */
    public void m11294b() {
        this.f4840h.clear();
        this.f4835c = null;
        this.f4836d = false;
    }
}
