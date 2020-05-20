package com.baidu.location.p078a;

import android.app.ActivityManager;
import android.content.Context;
import android.location.Location;
import android.os.Environment;
import android.os.Handler;
import com.baidu.location.Jni;
import com.baidu.location.ServiceC1002f;
import com.baidu.location.p079b.C0939c;
import com.baidu.location.p082e.C0987b;
import com.baidu.location.p082e.C0990c;
import com.baidu.location.p084g.AbstractC1011e;
import com.baidu.location.p084g.C1006b;
import com.baidu.location.p084g.C1015f;
import com.baidu.location.p084g.C1016g;
import com.baidu.mapapi.UIMsg;
import com.itextpdf.text.pdf.ColumnText;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpPostHC4;
import org.apache.mina.proxy.handlers.http.HttpProxyConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.location.a.d */
/* loaded from: classes.dex */
public class C0900d {

    /* renamed from: f */
    public static String f3905f = "0";

    /* renamed from: j */
    private static C0900d f3906j;

    /* renamed from: I */
    private Handler f3915I;

    /* renamed from: k */
    private int f3929k = 1;

    /* renamed from: l */
    private double f3930l = 0.699999988079071d;

    /* renamed from: m */
    private String f3931m = "3G|4G";

    /* renamed from: n */
    private int f3932n = 1;

    /* renamed from: o */
    private int f3933o = 307200;

    /* renamed from: p */
    private int f3934p = 15;

    /* renamed from: q */
    private int f3935q = 1;

    /* renamed from: r */
    private double f3936r = 3.5d;

    /* renamed from: s */
    private double f3937s = 3.0d;

    /* renamed from: t */
    private double f3938t = 0.5d;

    /* renamed from: u */
    private int f3939u = 300;

    /* renamed from: v */
    private int f3940v = 60;

    /* renamed from: w */
    private int f3941w = 0;

    /* renamed from: x */
    private int f3942x = 60;

    /* renamed from: y */
    private int f3943y = 0;

    /* renamed from: z */
    private long f3944z = 0;

    /* renamed from: A */
    private C0903a f3907A = null;

    /* renamed from: B */
    private boolean f3908B = false;

    /* renamed from: C */
    private boolean f3909C = false;

    /* renamed from: D */
    private int f3910D = 0;

    /* renamed from: E */
    private float f3911E = ColumnText.GLOBAL_SPACE_CHAR_RATIO;

    /* renamed from: F */
    private float f3912F = ColumnText.GLOBAL_SPACE_CHAR_RATIO;

    /* renamed from: G */
    private long f3913G = 0;

    /* renamed from: H */
    private int f3914H = UIMsg.d_ResultType.SHORT_URL;

    /* renamed from: a */
    long f3921a = 0;

    /* renamed from: b */
    Location f3922b = null;

    /* renamed from: c */
    Location f3923c = null;

    /* renamed from: d */
    StringBuilder f3924d = null;

    /* renamed from: e */
    long f3925e = 0;

    /* renamed from: J */
    private byte[] f3916J = new byte[4];

    /* renamed from: K */
    private byte[] f3917K = null;

    /* renamed from: L */
    private int f3918L = 0;

    /* renamed from: M */
    private List<Byte> f3919M = null;

    /* renamed from: N */
    private boolean f3920N = false;

    /* renamed from: g */
    int f3926g = 0;

    /* renamed from: h */
    double f3927h = 116.22345545d;

    /* renamed from: i */
    double f3928i = 40.245667323d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.location.a.d$a */
    /* loaded from: classes.dex */
    public class C0903a extends AbstractC1011e {

        /* renamed from: a */
        String f3948a = null;

        public C0903a() {
            this.f4525k = new HashMap();
        }

        @Override // com.baidu.location.p084g.AbstractC1011e
        /* renamed from: a */
        public void mo11391a() {
            this.f4522h = "http://loc.map.baidu.com/cc.php";
            String encode = Jni.encode(this.f3948a);
            this.f3948a = null;
            this.f4525k.put("q", encode);
        }

        /* renamed from: a */
        public void m12179a(String str) {
            this.f3948a = str;
            m11573e();
        }

        @Override // com.baidu.location.p084g.AbstractC1011e
        /* renamed from: a */
        public void mo11388a(boolean z) {
            if (z && this.f4524j != null) {
                try {
                    JSONObject jSONObject = new JSONObject(this.f4524j);
                    jSONObject.put("prod", C1006b.f4490d);
                    jSONObject.put("uptime", System.currentTimeMillis());
                    C0900d.this.m12186e(jSONObject.toString());
                } catch (Exception unused) {
                }
            }
            if (this.f4525k != null) {
                this.f4525k.clear();
            }
        }
    }

    private C0900d() {
        this.f3915I = null;
        this.f3915I = new Handler();
    }

    /* renamed from: a */
    public static C0900d m12208a() {
        if (f3906j == null) {
            f3906j = new C0900d();
        }
        return f3906j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public String m12202a(File file, String str) {
        String uuid = UUID.randomUUID().toString();
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestMethod(HttpPostHC4.METHOD_NAME);
            httpURLConnection.setRequestProperty("Charset", "utf-8");
            httpURLConnection.setRequestProperty("connection", "close");
            httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, "multipart/form-data;boundary=" + uuid);
            if (file == null || !file.exists()) {
                return "0";
            }
            OutputStream outputStream = httpURLConnection.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("--");
            stringBuffer.append(uuid);
            stringBuffer.append(HttpProxyConstants.CRLF);
            stringBuffer.append("Content-Disposition: form-data; name=\"location_dat\"; filename=\"" + file.getName() + "\"" + HttpProxyConstants.CRLF);
            stringBuffer.append("Content-Type: application/octet-stream; charset=utf-8".concat(String.valueOf(HttpProxyConstants.CRLF)));
            stringBuffer.append(HttpProxyConstants.CRLF);
            dataOutputStream.write(stringBuffer.toString().getBytes());
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                dataOutputStream.write(bArr, 0, read);
            }
            fileInputStream.close();
            dataOutputStream.write(HttpProxyConstants.CRLF.getBytes());
            dataOutputStream.write(("--" + uuid + "--" + HttpProxyConstants.CRLF).getBytes());
            dataOutputStream.flush();
            dataOutputStream.close();
            int responseCode = httpURLConnection.getResponseCode();
            outputStream.close();
            httpURLConnection.disconnect();
            this.f3943y += 400;
            m12194c(this.f3943y);
            return responseCode == 200 ? "1" : "0";
        } catch (MalformedURLException | IOException unused) {
            return "0";
        }
    }

    /* renamed from: a */
    private boolean m12200a(String str, Context context) {
        boolean z = false;
        try {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.processName.equals(str)) {
                        int i = runningAppProcessInfo.importance;
                        if (i == 200 || i == 100) {
                            z = true;
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
        return z;
    }

    /* renamed from: a */
    private byte[] m12207a(int i) {
        return new byte[]{(byte) (i & 255), (byte) ((65280 & i) >> 8), (byte) ((16711680 & i) >> 16), (byte) ((i & (-16777216)) >> 24)};
    }

    /* renamed from: a */
    private byte[] m12201a(String str) {
        if (str == null) {
            return null;
        }
        byte[] bytes = str.getBytes();
        byte nextInt = (byte) new Random().nextInt(255);
        byte nextInt2 = (byte) new Random().nextInt(255);
        byte[] bArr = new byte[bytes.length + 2];
        int length = bytes.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            bArr[i2] = (byte) (bytes[i] ^ nextInt);
            i++;
            i2++;
        }
        bArr[i2] = nextInt;
        bArr[i2 + 1] = nextInt2;
        return bArr;
    }

    /* renamed from: b */
    private String m12196b(String str) {
        Calendar calendar = Calendar.getInstance();
        return String.format(str, Integer.valueOf(calendar.get(1)), Integer.valueOf(calendar.get(2) + 1), Integer.valueOf(calendar.get(5)));
    }

    /* renamed from: b */
    private void m12198b(int i) {
        byte[] m12207a = m12207a(i);
        for (int i2 = 0; i2 < 4; i2++) {
            this.f3919M.add(Byte.valueOf(m12207a[i2]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m12197b(Location location) {
        m12193c(location);
        m12183h();
    }

    /* renamed from: c */
    private void m12195c() {
        if (this.f3920N) {
            return;
        }
        this.f3920N = true;
        m12189d(C1006b.f4490d);
        m12181j();
        m12191d();
    }

    /* renamed from: c */
    private void m12194c(int i) {
        if (i == 0) {
            return;
        }
        try {
            File file = new File(C1015f.f4535a + "/grtcf.dat");
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
            randomAccessFile2.seek(8L);
            byte[] bytes2 = (m12196b("%d_%02d_%02d") + ":" + i).getBytes();
            randomAccessFile2.writeInt(bytes2.length);
            randomAccessFile2.write(bytes2);
            randomAccessFile2.close();
        } catch (Exception unused) {
        }
    }

    /* renamed from: c */
    private void m12193c(Location location) {
        if (System.currentTimeMillis() - this.f3921a < this.f3914H || location == null) {
            return;
        }
        if (location != null && location.hasSpeed() && location.getSpeed() > this.f3911E) {
            this.f3911E = location.getSpeed();
        }
        try {
            if (this.f3919M == null) {
                this.f3919M = new ArrayList();
                m12182i();
                m12190d(location);
            } else {
                m12187e(location);
            }
        } catch (Exception unused) {
        }
        this.f3918L++;
    }

    /* renamed from: c */
    private void m12192c(String str) {
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("on")) {
                    this.f3929k = jSONObject.getInt("on");
                }
                if (jSONObject.has("bash")) {
                    this.f3930l = jSONObject.getDouble("bash");
                }
                if (jSONObject.has("net")) {
                    this.f3931m = jSONObject.getString("net");
                }
                if (jSONObject.has("tcon")) {
                    this.f3932n = jSONObject.getInt("tcon");
                }
                if (jSONObject.has("tcsh")) {
                    this.f3933o = jSONObject.getInt("tcsh");
                }
                if (jSONObject.has("per")) {
                    this.f3934p = jSONObject.getInt("per");
                }
                if (jSONObject.has("chdron")) {
                    this.f3935q = jSONObject.getInt("chdron");
                }
                if (jSONObject.has("spsh")) {
                    this.f3936r = jSONObject.getDouble("spsh");
                }
                if (jSONObject.has("acsh")) {
                    this.f3937s = jSONObject.getDouble("acsh");
                }
                if (jSONObject.has("stspsh")) {
                    this.f3938t = jSONObject.getDouble("stspsh");
                }
                if (jSONObject.has("drstsh")) {
                    this.f3939u = jSONObject.getInt("drstsh");
                }
                if (jSONObject.has("stper")) {
                    this.f3940v = jSONObject.getInt("stper");
                }
                if (jSONObject.has("nondron")) {
                    this.f3941w = jSONObject.getInt("nondron");
                }
                if (jSONObject.has("nondrper")) {
                    this.f3942x = jSONObject.getInt("nondrper");
                }
                if (jSONObject.has("uptime")) {
                    this.f3944z = jSONObject.getLong("uptime");
                }
                m12180k();
            } catch (JSONException unused) {
            }
        }
    }

    /* renamed from: d */
    private void m12191d() {
        String[] split = "7.5.1".split("\\.");
        int length = split.length;
        byte[] bArr = this.f3916J;
        bArr[0] = 0;
        bArr[1] = 0;
        bArr[2] = 0;
        bArr[3] = 0;
        if (length >= 4) {
            length = 4;
        }
        for (int i = 0; i < length; i++) {
            try {
                this.f3916J[i] = (byte) (Integer.valueOf(split[i]).intValue() & 255);
            } catch (Exception unused) {
            }
        }
        this.f3917K = m12201a(C1006b.f4490d + ":" + C1006b.m11603a().f4496b);
    }

    /* renamed from: d */
    private void m12190d(Location location) {
        this.f3925e = System.currentTimeMillis();
        m12198b((int) (location.getTime() / 1000));
        m12198b((int) (location.getLongitude() * 1000000.0d));
        m12198b((int) (location.getLatitude() * 1000000.0d));
        int i = !location.hasBearing();
        int i2 = !location.hasSpeed();
        if (i > 0) {
            this.f3919M.add((byte) 32);
        } else {
            this.f3919M.add(Byte.valueOf((byte) (((byte) (((int) (location.getBearing() / 15.0f)) & 255)) & (-33))));
        }
        if (i2 > 0) {
            this.f3919M.add(Byte.MIN_VALUE);
        } else {
            double speed = location.getSpeed();
            Double.isNaN(speed);
            this.f3919M.add(Byte.valueOf((byte) (((byte) (((int) ((speed * 3.6d) / 4.0d)) & 255)) & Byte.MAX_VALUE)));
        }
        this.f3922b = location;
    }

    /* renamed from: d */
    private void m12189d(String str) {
        try {
            File file = new File(C1015f.f4535a + "/grtcf.dat");
            if (file.exists()) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(2L);
                int readInt = randomAccessFile.readInt();
                randomAccessFile.seek(8L);
                int readInt2 = randomAccessFile.readInt();
                byte[] bArr = new byte[readInt2];
                randomAccessFile.read(bArr, 0, readInt2);
                String str2 = new String(bArr);
                int i = 1;
                if (str2.contains(m12196b("%d_%02d_%02d")) && str2.contains(":")) {
                    try {
                        String[] split = str2.split(":");
                        if (split.length > 1) {
                            this.f3943y = Integer.valueOf(split[1]).intValue();
                        }
                    } catch (Exception unused) {
                    }
                }
                while (true) {
                    if (i > readInt) {
                        break;
                    }
                    randomAccessFile.seek(i * 2048);
                    int readInt3 = randomAccessFile.readInt();
                    byte[] bArr2 = new byte[readInt3];
                    randomAccessFile.read(bArr2, 0, readInt3);
                    String str3 = new String(bArr2);
                    if (str != null && str3.contains(str)) {
                        m12192c(str3);
                        break;
                    }
                    i++;
                }
                randomAccessFile.close();
            }
        } catch (Exception unused2) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0105, code lost:
        if (r8 > 0) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x011b, code lost:
        if (r8 > 0) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x011d, code lost:
        r2 = (byte) (r2 | Byte.MIN_VALUE);
     */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m12187e(android.location.Location r22) {
        /*
            Method dump skipped, instructions count: 346
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p078a.C0900d.m12187e(android.location.Location):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m12186e(String str) {
        try {
            File file = new File(C1015f.f4535a + "/grtcf.dat");
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
            randomAccessFile2.seek(2L);
            int readInt = randomAccessFile2.readInt();
            int i = 1;
            while (i <= readInt) {
                randomAccessFile2.seek(i * 2048);
                int readInt2 = randomAccessFile2.readInt();
                byte[] bArr = new byte[readInt2];
                randomAccessFile2.read(bArr, 0, readInt2);
                if (new String(bArr).contains(C1006b.f4490d)) {
                    break;
                }
                i++;
            }
            if (i >= readInt) {
                randomAccessFile2.seek(2L);
                randomAccessFile2.writeInt(i);
            }
            randomAccessFile2.seek(i * 2048);
            byte[] bytes2 = str.getBytes();
            randomAccessFile2.writeInt(bytes2.length);
            randomAccessFile2.write(bytes2);
            randomAccessFile2.close();
        } catch (Exception unused) {
        }
    }

    /* renamed from: e */
    private boolean m12188e() {
        RandomAccessFile randomAccessFile;
        FileChannel fileChannel = null;
        FileLock fileLock = null;
        fileChannel = null;
        RandomAccessFile randomAccessFile2 = null;
        boolean z = false;
        try {
            try {
                File file = new File(C1016g.m11550g() + File.separator + "gflk.dat");
                if (!file.exists()) {
                    file.createNewFile();
                }
                randomAccessFile = new RandomAccessFile(file, "rw");
                try {
                    FileChannel channel = randomAccessFile.getChannel();
                    try {
                        fileLock = channel.tryLock();
                    } catch (Exception unused) {
                        z = true;
                    } catch (Throwable th) {
                        th = th;
                        fileChannel = channel;
                        if (fileChannel != null) {
                            try {
                                fileChannel.close();
                            } catch (Exception unused2) {
                                throw th;
                            }
                        }
                        if (randomAccessFile != null) {
                            randomAccessFile.close();
                        }
                        throw th;
                    }
                    if (fileLock != null) {
                        fileLock.release();
                    }
                    if (channel != null) {
                        channel.close();
                    }
                    randomAccessFile.close();
                } catch (Exception unused3) {
                    randomAccessFile2 = randomAccessFile;
                    if (randomAccessFile2 != null) {
                        randomAccessFile2.close();
                    }
                    return z;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception unused4) {
            } catch (Throwable th3) {
                th = th3;
                randomAccessFile = null;
            }
        } catch (Exception unused5) {
        }
        return z;
    }

    /* renamed from: f */
    private boolean m12185f() {
        if (this.f3908B) {
            if (!this.f3909C) {
                if (this.f3911E < this.f3938t) {
                    this.f3909C = true;
                    this.f3910D = 0;
                    this.f3910D += this.f3934p;
                    return true;
                }
                return true;
            } else if (this.f3911E >= this.f3938t) {
                this.f3910D = 0;
                this.f3909C = false;
                return true;
            } else {
                this.f3910D += this.f3934p;
                if (this.f3910D <= this.f3939u || System.currentTimeMillis() - this.f3913G > this.f3940v * 1000) {
                    return true;
                }
            }
        } else if (this.f3911E >= this.f3936r || this.f3912F >= this.f3937s) {
            this.f3908B = true;
            return true;
        } else if (this.f3941w == 1 && System.currentTimeMillis() - this.f3913G > this.f3942x * 1000) {
            return true;
        }
        return false;
    }

    /* renamed from: g */
    private void m12184g() {
        this.f3919M = null;
        this.f3925e = 0L;
        this.f3918L = 0;
        this.f3922b = null;
        this.f3923c = null;
        this.f3911E = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.f3912F = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
    }

    /* JADX WARN: Type inference failed for: r0v22, types: [com.baidu.location.a.d$2] */
    /* renamed from: h */
    private void m12183h() {
        if (this.f3925e == 0 || System.currentTimeMillis() - this.f3925e < this.f3934p * 1000) {
            return;
        }
        if (ServiceC1002f.getServiceContext().getSharedPreferences("loc_navi_mode", 4).getBoolean("is_navi_on", false)) {
            m12184g();
        } else if (this.f3932n == 1 && !m12185f()) {
            m12184g();
        } else {
            if (C1006b.f4490d.equals("com.ubercab.driver")) {
                if (m12188e()) {
                    m12184g();
                    return;
                }
            } else if (!m12200a(C1006b.f4490d, ServiceC1002f.getServiceContext())) {
                m12184g();
                return;
            }
            List<Byte> list = this.f3919M;
            if (list != null) {
                int size = list.size();
                this.f3919M.set(0, Byte.valueOf((byte) (size & 255)));
                this.f3919M.set(1, Byte.valueOf((byte) ((65280 & size) >> 8)));
                this.f3919M.set(3, Byte.valueOf((byte) (this.f3918L & 255)));
                byte[] bArr = new byte[size];
                for (int i = 0; i < size; i++) {
                    bArr[i] = this.f3919M.get(i).byteValue();
                }
                if (Environment.getExternalStorageState().equals("mounted")) {
                    File file = new File(Environment.getExternalStorageDirectory(), "baidu/tempdata");
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    if (file.exists()) {
                        File file2 = new File(file, "intime.dat");
                        if (file2.exists()) {
                            file2.delete();
                        }
                        try {
                            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
                            bufferedOutputStream.write(bArr);
                            bufferedOutputStream.flush();
                            bufferedOutputStream.close();
                            new Thread() { // from class: com.baidu.location.a.d.2
                                @Override // java.lang.Thread, java.lang.Runnable
                                public void run() {
                                    C0900d.this.m12202a(new File(Environment.getExternalStorageDirectory() + "/baidu/tempdata", "intime.dat"), "http://itsdata.map.baidu.com/long-conn-gps/sdk.php");
                                }
                            }.start();
                        } catch (Exception unused) {
                        }
                    }
                }
                m12184g();
                this.f3913G = System.currentTimeMillis();
            }
        }
    }

    /* renamed from: i */
    private void m12182i() {
        List<Byte> list;
        byte b;
        this.f3919M.add((byte) 0);
        this.f3919M.add((byte) 0);
        if (f3905f.equals("0")) {
            list = this.f3919M;
            b = -82;
        } else {
            list = this.f3919M;
            b = -66;
        }
        list.add(Byte.valueOf(b));
        this.f3919M.add((byte) 0);
        this.f3919M.add(Byte.valueOf(this.f3916J[0]));
        this.f3919M.add(Byte.valueOf(this.f3916J[1]));
        this.f3919M.add(Byte.valueOf(this.f3916J[2]));
        this.f3919M.add(Byte.valueOf(this.f3916J[3]));
        int length = this.f3917K.length;
        this.f3919M.add(Byte.valueOf((byte) ((length + 1) & 255)));
        for (int i = 0; i < length; i++) {
            this.f3919M.add(Byte.valueOf(this.f3917K[i]));
        }
    }

    /* renamed from: j */
    private void m12181j() {
        if (System.currentTimeMillis() - this.f3944z > 86400000) {
            if (this.f3907A == null) {
                this.f3907A = new C0903a();
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(C1006b.m11603a().m11600a(false));
            stringBuffer.append(C0892a.m12261a().m12242f());
            this.f3907A.m12179a(stringBuffer.toString());
        }
        m12180k();
    }

    /* renamed from: k */
    private void m12180k() {
    }

    /* renamed from: a */
    public void m12206a(final Location location) {
        if (!this.f3920N) {
            m12195c();
        }
        boolean z = ((double) C0939c.m12005a().m11997f()) < this.f3930l * 100.0d;
        if (this.f3929k == 1 && z && this.f3931m.contains(C0990c.m11705a(C0987b.m11732a().m11716e()))) {
            if (this.f3932n != 1 || this.f3943y <= this.f3933o) {
                this.f3915I.post(new Runnable() { // from class: com.baidu.location.a.d.1
                    @Override // java.lang.Runnable
                    public void run() {
                        C0900d.this.m12197b(location);
                    }
                });
            }
        }
    }

    /* renamed from: b */
    public void m12199b() {
        if (this.f3920N) {
            this.f3920N = false;
            m12184g();
        }
    }
}
