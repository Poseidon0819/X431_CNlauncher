package com.baidu.location.p078a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Handler;
import com.baidu.location.Jni;
import com.baidu.location.ServiceC1002f;
import com.baidu.location.p081d.C0969d;
import com.baidu.location.p082e.C0987b;
import com.baidu.location.p082e.C0990c;
import com.baidu.location.p082e.C0998f;
import com.baidu.location.p084g.AbstractC1011e;
import com.baidu.location.p084g.C1006b;
import com.baidu.location.p084g.C1007c;
import com.baidu.location.p084g.C1015f;
import com.baidu.location.p084g.C1016g;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

/* renamed from: com.baidu.location.a.m */
/* loaded from: classes.dex */
public class C0925m extends AbstractC1011e {

    /* renamed from: p */
    private static C0925m f4074p;

    /* renamed from: a */
    String f4075a = null;

    /* renamed from: b */
    String f4076b = null;

    /* renamed from: c */
    String f4077c = null;

    /* renamed from: d */
    String f4078d = null;

    /* renamed from: e */
    int f4079e = 1;

    /* renamed from: f */
    Handler f4080f;

    private C0925m() {
        this.f4080f = null;
        this.f4080f = new Handler();
    }

    /* renamed from: a */
    public static void m12068a(File file, File file2) throws IOException {
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream;
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream = null;
        }
        try {
            byte[] bArr = new byte[5120];
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read == -1) {
                    bufferedOutputStream.flush();
                    file.delete();
                    bufferedInputStream.close();
                    bufferedOutputStream.close();
                    return;
                }
                bufferedOutputStream.write(bArr, 0, read);
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedOutputStream2 = bufferedOutputStream;
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            if (bufferedOutputStream2 != null) {
                bufferedOutputStream2.close();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public boolean m12071a(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || activeNetworkInfo.getType() != 0) {
                return false;
            }
            String m11705a = C0990c.m11705a(C0987b.m11732a().m11716e());
            if (m11705a.equals("3G")) {
                return true;
            }
            return m11705a.equals("4G");
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m12067a(String str, String str2) {
        File file = new File(C1016g.m11549h() + File.separator + "tmp");
        if (file.exists()) {
            file.delete();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[4096];
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            }
            httpURLConnection.disconnect();
            fileOutputStream.close();
            bufferedInputStream.close();
            if (file.length() < 10240) {
                file.delete();
                return false;
            }
            file.renameTo(new File(C1016g.m11549h() + File.separator + str2));
            return true;
        } catch (Exception unused) {
            file.delete();
            return false;
        }
    }

    /* renamed from: b */
    public static C0925m m12066b() {
        if (f4074p == null) {
            f4074p = new C0925m();
        }
        return f4074p;
    }

    /* renamed from: f */
    private Handler m12062f() {
        return this.f4080f;
    }

    /* renamed from: g */
    private void m12061g() {
        try {
            File file = new File(C1016g.m11549h() + "/grtcfrsa.dat");
            if (!file.exists()) {
                File file2 = new File(C1015f.f4535a);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                if (!file.createNewFile()) {
                    return;
                }
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(2L);
                randomAccessFile.writeInt(0);
                randomAccessFile.seek(8L);
                byte[] bytes = "1980_01_01:0".getBytes();
                randomAccessFile.writeInt(bytes.length);
                randomAccessFile.write(bytes);
                randomAccessFile.seek(200L);
                randomAccessFile.writeBoolean(false);
                randomAccessFile.seek(800L);
                randomAccessFile.writeBoolean(false);
                randomAccessFile.close();
            }
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "rw");
            randomAccessFile2.seek(200L);
            randomAccessFile2.writeBoolean(true);
            if (this.f4079e == 1) {
                randomAccessFile2.writeBoolean(true);
            } else {
                randomAccessFile2.writeBoolean(false);
            }
            if (this.f4078d != null) {
                byte[] bytes2 = this.f4078d.getBytes();
                randomAccessFile2.writeInt(bytes2.length);
                randomAccessFile2.write(bytes2);
            } else if (Math.abs(ServiceC1002f.getFrameVersion() - 7.51f) < 1.0E-8f) {
                randomAccessFile2.writeInt(0);
            }
            randomAccessFile2.close();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.baidu.location.a.m$4] */
    /* renamed from: h */
    public void m12060h() {
        if (this.f4075a == null) {
            return;
        }
        new Thread() { // from class: com.baidu.location.a.m.4
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                if (C0925m.this.m12059i()) {
                    C0925m.this.m12058j();
                }
            }
        }.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public boolean m12059i() {
        if (this.f4077c == null) {
            return true;
        }
        if (new File(C1016g.m11549h() + File.separator + this.f4077c).exists()) {
            return true;
        }
        return m12067a("http://" + this.f4075a + "/" + this.f4077c, this.f4077c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m12058j() {
        if (this.f4076b == null) {
            return;
        }
        File file = new File(C1016g.m11549h() + File.separator + this.f4076b);
        if (file.exists()) {
            return;
        }
        if (m12067a("http://" + this.f4075a + "/" + this.f4076b, this.f4076b)) {
            String m11566a = C1016g.m11566a(file, "SHA-256");
            String str = this.f4078d;
            if (str == null || m11566a == null || !C1016g.m11558b(m11566a, str, "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCiP7BS5IjEOzrKGR9/Ww9oSDhdX1ir26VOsYjT1T6tk2XumRpkHRwZbrucDcNnvSB4QsqiEJnvTSRi7YMbh2H9sLMkcvHlMV5jAErNvnuskWfcvf7T2mq7EUZI/Hf4oVZhHV0hQJRFVdTcjWI6q2uaaKM3VMh+roDesiE7CR2biQIDAQAB")) {
                return;
            }
            File file2 = new File(C1016g.m11549h() + File.separator + ServiceC1002f.replaceFileName);
            if (file2.exists()) {
                file2.delete();
            }
            try {
                m12068a(file, file2);
            } catch (Exception unused) {
                file2.delete();
            }
        }
    }

    @Override // com.baidu.location.p084g.AbstractC1011e
    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public void mo11391a() {
        String str;
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append("&sdk=");
        stringBuffer.append(7.51f);
        stringBuffer.append("&fw=");
        stringBuffer.append(ServiceC1002f.getFrameVersion());
        stringBuffer.append("&suit=");
        stringBuffer.append(2);
        if (C1006b.m11603a().f4496b == null) {
            stringBuffer.append("&im=");
            str = C1006b.m11603a().f4495a;
        } else {
            stringBuffer.append("&cu=");
            str = C1006b.m11603a().f4496b;
        }
        stringBuffer.append(str);
        stringBuffer.append("&mb=");
        stringBuffer.append(Build.MODEL);
        stringBuffer.append("&sv=");
        String str2 = Build.VERSION.RELEASE;
        if (str2 != null && str2.length() > 10) {
            str2 = str2.substring(0, 10);
        }
        stringBuffer.append(str2);
        String str3 = null;
        try {
            if (Build.VERSION.SDK_INT > 20) {
                String[] strArr = Build.SUPPORTED_ABIS;
                String str4 = null;
                for (int i = 0; i < strArr.length; i++) {
                    str4 = i == 0 ? strArr[i] + ";" : str4 + strArr[i] + ";";
                }
                str3 = str4;
            } else {
                str3 = Build.CPU_ABI2;
            }
        } catch (Error | Exception unused) {
        }
        if (str3 != null) {
            stringBuffer.append("&cpuabi=");
            stringBuffer.append(str3);
        }
        stringBuffer.append("&pack=");
        stringBuffer.append(C1006b.f4490d);
        this.f4522h = C1016g.m11555d() + "?&it=" + Jni.en1(stringBuffer.toString());
    }

    @Override // com.baidu.location.p084g.AbstractC1011e
    /* renamed from: a */
    public void mo11388a(boolean z) {
        if (z) {
            try {
                JSONObject jSONObject = new JSONObject(this.f4524j);
                if ("up".equals(jSONObject.getString("res"))) {
                    this.f4075a = jSONObject.getString("upath");
                    if (jSONObject.has("u1")) {
                        this.f4076b = jSONObject.getString("u1");
                    }
                    if (jSONObject.has("u2")) {
                        this.f4077c = jSONObject.getString("u2");
                    }
                    if (jSONObject.has("u1_rsa")) {
                        this.f4078d = jSONObject.getString("u1_rsa");
                    }
                    m12062f().post(new Runnable() { // from class: com.baidu.location.a.m.3
                        @Override // java.lang.Runnable
                        public void run() {
                            C0925m.this.m12060h();
                        }
                    });
                }
                if (jSONObject.has("ison")) {
                    this.f4079e = jSONObject.getInt("ison");
                }
                m12061g();
            } catch (Exception unused) {
            }
        }
        C1007c.m11594a().m11591a(System.currentTimeMillis());
    }

    /* renamed from: c */
    public void m12064c() {
        if (System.currentTimeMillis() - C1007c.m11594a().m11590b() > 86400000) {
            m12062f().postDelayed(new Runnable() { // from class: com.baidu.location.a.m.1
                @Override // java.lang.Runnable
                public void run() {
                    if (C0998f.m11626j() || C0925m.this.m12071a(ServiceC1002f.getServiceContext())) {
                        C0925m.this.m11574d();
                    }
                }
            }, 10000L);
            m12062f().postDelayed(new Runnable() { // from class: com.baidu.location.a.m.2
                @Override // java.lang.Runnable
                public void run() {
                    if (C0998f.m11626j()) {
                        C0969d.m11810a().m11790m();
                    }
                }
            }, 5000L);
        }
    }
}
