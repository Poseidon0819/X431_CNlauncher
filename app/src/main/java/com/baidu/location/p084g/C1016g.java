package com.baidu.location.p084g;

import android.content.Context;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.text.TextUtils;
import com.baidu.android.bbalbs.common.p077a.C0859b;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.ServiceC1002f;
import com.baidu.location.p079b.C0939c;
import com.baidu.location.p082e.C0986a;
import com.baidu.location.p082e.C0987b;
import com.baidu.location.p082e.C0991d;
import com.baidu.location.p082e.C0997e;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.Locale;
import org.apache.mina.proxy.handlers.http.ntlm.NTLMConstants;

/* renamed from: com.baidu.location.g.g */
/* loaded from: classes.dex */
public class C1016g {

    /* renamed from: A */
    public static float f4537A = 2.3f;

    /* renamed from: B */
    public static float f4538B = 3.8f;

    /* renamed from: C */
    public static int f4539C = 3;

    /* renamed from: D */
    public static int f4540D = 10;

    /* renamed from: E */
    public static int f4541E = 2;

    /* renamed from: F */
    public static int f4542F = 7;

    /* renamed from: G */
    public static int f4543G = 20;

    /* renamed from: H */
    public static int f4544H = 70;

    /* renamed from: I */
    public static int f4545I = 120;

    /* renamed from: J */
    public static float f4546J = 2.0f;

    /* renamed from: K */
    public static float f4547K = 10.0f;

    /* renamed from: L */
    public static float f4548L = 50.0f;

    /* renamed from: M */
    public static float f4549M = 200.0f;

    /* renamed from: N */
    public static int f4550N = 16;

    /* renamed from: O */
    public static float f4551O = 0.9f;

    /* renamed from: P */
    public static int f4552P = 10000;

    /* renamed from: Q */
    public static float f4553Q = 0.5f;

    /* renamed from: R */
    public static float f4554R = 0.0f;

    /* renamed from: S */
    public static float f4555S = 0.1f;

    /* renamed from: T */
    public static int f4556T = 30;

    /* renamed from: U */
    public static int f4557U = 100;

    /* renamed from: V */
    public static int f4558V = 0;

    /* renamed from: W */
    public static int f4559W = 0;

    /* renamed from: X */
    public static int f4560X = 0;

    /* renamed from: Y */
    public static int f4561Y = 420000;

    /* renamed from: Z */
    public static boolean f4562Z = true;

    /* renamed from: a */
    public static boolean f4563a = false;

    /* renamed from: aA */
    private static String f4564aA = "http://loc.map.baidu.com/iofd.php";

    /* renamed from: aB */
    private static String f4565aB = "http://loc.map.baidu.com/wloc";

    /* renamed from: aa */
    public static boolean f4566aa = true;

    /* renamed from: ab */
    public static int f4567ab = 20;

    /* renamed from: ac */
    public static int f4568ac = 300;

    /* renamed from: ad */
    public static int f4569ad = 1000;

    /* renamed from: ae */
    public static int f4570ae = Integer.MAX_VALUE;

    /* renamed from: af */
    public static long f4571af = 900000;

    /* renamed from: ag */
    public static long f4572ag = 420000;

    /* renamed from: ah */
    public static long f4573ah = 180000;

    /* renamed from: ai */
    public static long f4574ai = 0;

    /* renamed from: aj */
    public static long f4575aj = 15;

    /* renamed from: ak */
    public static long f4576ak = 300000;

    /* renamed from: al */
    public static int f4577al = 1000;

    /* renamed from: am */
    public static int f4578am = 0;

    /* renamed from: an */
    public static int f4579an = 30000;

    /* renamed from: ao */
    public static int f4580ao = 30000;

    /* renamed from: ap */
    public static float f4581ap = 10.0f;

    /* renamed from: aq */
    public static float f4582aq = 6.0f;

    /* renamed from: ar */
    public static float f4583ar = 10.0f;

    /* renamed from: as */
    public static int f4584as = 60;

    /* renamed from: at */
    public static int f4585at = 70;

    /* renamed from: au */
    public static int f4586au = 6;

    /* renamed from: av */
    private static String f4587av = "http://loc.map.baidu.com/sdk.php";

    /* renamed from: aw */
    private static String f4588aw = "http://loc.map.baidu.com/user_err.php";

    /* renamed from: ax */
    private static String f4589ax = "http://loc.map.baidu.com/oqur.php";

    /* renamed from: ay */
    private static String f4590ay = "http://loc.map.baidu.com/tcu.php";

    /* renamed from: az */
    private static String f4591az = "http://loc.map.baidu.com/rtbu.php";

    /* renamed from: b */
    public static boolean f4592b = false;

    /* renamed from: c */
    public static boolean f4593c = false;

    /* renamed from: d */
    public static int f4594d = 0;

    /* renamed from: e */
    public static String f4595e = "http://loc.map.baidu.com/sdk_ep.php";

    /* renamed from: f */
    public static String f4596f = "https://loc.map.baidu.com/sdk.php";

    /* renamed from: g */
    public static String f4597g = "no";

    /* renamed from: h */
    public static boolean f4598h = false;

    /* renamed from: i */
    public static boolean f4599i = false;

    /* renamed from: j */
    public static boolean f4600j = false;

    /* renamed from: k */
    public static boolean f4601k = false;

    /* renamed from: l */
    public static boolean f4602l = false;

    /* renamed from: m */
    public static String f4603m = "gcj02";

    /* renamed from: n */
    public static String f4604n = "";

    /* renamed from: o */
    public static boolean f4605o = true;

    /* renamed from: p */
    public static int f4606p = 3;

    /* renamed from: q */
    public static double f4607q = 0.0d;

    /* renamed from: r */
    public static double f4608r = 0.0d;

    /* renamed from: s */
    public static double f4609s = 0.0d;

    /* renamed from: t */
    public static double f4610t = 0.0d;

    /* renamed from: u */
    public static int f4611u = 0;

    /* renamed from: v */
    public static byte[] f4612v = null;

    /* renamed from: w */
    public static boolean f4613w = false;

    /* renamed from: x */
    public static int f4614x = 0;

    /* renamed from: y */
    public static float f4615y = 1.1f;

    /* renamed from: z */
    public static float f4616z = 2.2f;

    /* renamed from: a */
    public static int m11563a(String str, String str2, String str3) {
        int indexOf;
        int length;
        int indexOf2;
        String substring;
        if (str != null && !str.equals("") && (indexOf = str.indexOf(str2)) != -1 && (indexOf2 = str.indexOf(str3, (length = indexOf + str2.length()))) != -1 && (substring = str.substring(length, indexOf2)) != null && !substring.equals("")) {
            try {
                return Integer.parseInt(substring);
            } catch (NumberFormatException unused) {
            }
        }
        return NTLMConstants.FLAG_NEGOTIATE_56_BIT_ENCRYPTION;
    }

    /* renamed from: a */
    public static Object m11570a(Context context, String str) {
        if (context == null) {
            return null;
        }
        try {
            return context.getApplicationContext().getSystemService(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: a */
    public static Object m11565a(Object obj, String str, Object... objArr) throws Exception {
        Class<?> cls = obj.getClass();
        Class<?>[] clsArr = new Class[objArr.length];
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            clsArr[i] = objArr[i].getClass();
            if (clsArr[i] == Integer.class) {
                clsArr[i] = Integer.TYPE;
            }
        }
        Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
        if (!declaredMethod.isAccessible()) {
            declaredMethod.setAccessible(true);
        }
        return declaredMethod.invoke(obj, objArr);
    }

    /* renamed from: a */
    public static String m11572a() {
        Calendar calendar = Calendar.getInstance();
        int i = calendar.get(5);
        return String.format(Locale.CHINA, "%d-%02d-%02d %02d:%02d:%02d", Integer.valueOf(calendar.get(1)), Integer.valueOf(calendar.get(2) + 1), Integer.valueOf(i), Integer.valueOf(calendar.get(11)), Integer.valueOf(calendar.get(12)), Integer.valueOf(calendar.get(13)));
    }

    /* renamed from: a */
    public static String m11568a(C0986a c0986a, C0997e c0997e, Location location, String str, int i) {
        return m11567a(c0986a, c0997e, location, str, i, false);
    }

    /* renamed from: a */
    public static String m11567a(C0986a c0986a, C0997e c0997e, Location location, String str, int i, boolean z) {
        String m11727a;
        String m11723b;
        StringBuffer stringBuffer = new StringBuffer(1024);
        if (c0986a != null && (m11723b = C0987b.m11732a().m11723b(c0986a)) != null) {
            stringBuffer.append(m11723b);
        }
        if (c0997e != null) {
            String m11658b = i == 0 ? z ? c0997e.m11658b() : c0997e.m11654c() : c0997e.m11651d();
            if (m11658b != null) {
                stringBuffer.append(m11658b);
            }
        }
        if (location != null) {
            String m11687b = (f4594d == 0 || i == 0) ? C0991d.m11687b(location) : C0991d.m11679c(location);
            if (m11687b != null) {
                stringBuffer.append(m11687b);
            }
        }
        String m11600a = C1006b.m11603a().m11600a(i == 0);
        if (m11600a != null) {
            stringBuffer.append(m11600a);
        }
        if (str != null) {
            stringBuffer.append(str);
        }
        String m11999d = C0939c.m12005a().m11999d();
        if (!TextUtils.isEmpty(m11999d)) {
            stringBuffer.append("&bc=");
            stringBuffer.append(m11999d);
        }
        if (c0986a != null && (m11727a = C0987b.m11732a().m11727a(c0986a)) != null && m11727a.length() + stringBuffer.length() < 750) {
            stringBuffer.append(m11727a);
        }
        String stringBuffer2 = stringBuffer.toString();
        if (location != null && c0997e != null) {
            try {
                float speed = location.getSpeed();
                int i2 = f4594d;
                int m11646h = c0997e.m11646h();
                int m11664a = c0997e.m11664a();
                boolean m11645i = c0997e.m11645i();
                if (speed < f4582aq && ((i2 == 1 || i2 == 0) && (m11646h < f4584as || m11645i))) {
                    f4606p = 1;
                } else if (speed < f4583ar && ((i2 == 1 || i2 == 0 || i2 == 3) && (m11646h < f4585at || m11664a > f4586au))) {
                    f4606p = 2;
                }
            } catch (Exception unused) {
                f4606p = 3;
            }
            return stringBuffer2;
        }
        f4606p = 3;
        return stringBuffer2;
    }

    /* renamed from: a */
    public static String m11566a(File file, String str) {
        if (!file.isFile()) {
            return null;
        }
        byte[] bArr = new byte[1024];
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            FileInputStream fileInputStream = new FileInputStream(file);
            while (true) {
                int read = fileInputStream.read(bArr, 0, 1024);
                if (read == -1) {
                    fileInputStream.close();
                    return new BigInteger(1, messageDigest.digest()).toString(16);
                }
                messageDigest.update(bArr, 0, read);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static String m11564a(String str) {
        return Jni.en1(f4604n + ";" + str);
    }

    /* renamed from: a */
    public static boolean m11571a(Context context) {
        NetworkInfo[] allNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null && (allNetworkInfo = connectivityManager.getAllNetworkInfo()) != null) {
            for (NetworkInfo networkInfo : allNetworkInfo) {
                if (networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m11569a(BDLocation bDLocation) {
        int locType = bDLocation.getLocType();
        return (locType > 100 && locType < 200) || locType == 62;
    }

    /* renamed from: b */
    public static int m11561b(Context context) {
        try {
            return Settings.System.getInt(context.getContentResolver(), "airplane_mode_on", 0);
        } catch (Exception unused) {
            return 2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0017 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0016 A[RETURN] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int m11560b(android.content.Context r4, java.lang.String r5) {
        /*
            r0 = 0
            r1 = 1
            int r2 = android.os.Process.myPid()     // Catch: java.lang.Exception -> L13
            int r3 = android.os.Process.myUid()     // Catch: java.lang.Exception -> L13
            int r4 = r4.checkPermission(r5, r2, r3)     // Catch: java.lang.Exception -> L13
            if (r4 != 0) goto L11
            goto L13
        L11:
            r4 = 0
            goto L14
        L13:
            r4 = 1
        L14:
            if (r4 != 0) goto L17
            return r0
        L17:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p084g.C1016g.m11560b(android.content.Context, java.lang.String):int");
    }

    /* renamed from: b */
    public static int m11559b(Object obj, String str, Object... objArr) throws Exception {
        Class<?> cls = obj.getClass();
        Class<?>[] clsArr = new Class[objArr.length];
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            clsArr[i] = objArr[i].getClass();
            if (clsArr[i] == Integer.class) {
                clsArr[i] = Integer.TYPE;
            }
        }
        Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
        if (!declaredMethod.isAccessible()) {
            declaredMethod.setAccessible(true);
        }
        return ((Integer) declaredMethod.invoke(obj, objArr)).intValue();
    }

    /* renamed from: b */
    public static String m11562b() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress() && (nextElement instanceof Inet4Address)) {
                        byte[] address = nextElement.getAddress();
                        String str = "";
                        for (byte b : address) {
                            String hexString = Integer.toHexString(b & 255);
                            if (hexString.length() == 1) {
                                hexString = "0".concat(String.valueOf(hexString));
                            }
                            str = str + hexString;
                        }
                        return str;
                    }
                }
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: b */
    public static boolean m11558b(String str, String str2, String str3) {
        try {
            PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(C0859b.m12432a(str3.getBytes())));
            Signature signature = Signature.getInstance("SHA1WithRSA");
            signature.initVerify(generatePublic);
            signature.update(str.getBytes());
            return signature.verify(C0859b.m12432a(str2.getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: c */
    public static int m11556c(Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                return Settings.Secure.getInt(context.getContentResolver(), "location_mode", -1);
            } catch (Exception unused) {
                return -1;
            }
        }
        return -2;
    }

    /* renamed from: c */
    public static String m11557c() {
        return f4587av;
    }

    /* renamed from: d */
    public static String m11555d() {
        return f4590ay;
    }

    /* renamed from: d */
    public static String m11554d(Context context) {
        int m11560b = m11560b(context, "android.permission.ACCESS_COARSE_LOCATION");
        int m11560b2 = m11560b(context, "android.permission.ACCESS_FINE_LOCATION");
        int m11560b3 = m11560b(context, "android.permission.READ_PHONE_STATE");
        return "&per=" + m11560b + "|" + m11560b2 + "|" + m11560b3;
    }

    /* renamed from: e */
    public static String m11553e() {
        return "https://daup.map.baidu.com/cltr/rcvr";
    }

    /* renamed from: e */
    public static String m11552e(Context context) {
        int i = -1;
        if (context != null) {
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                    i = activeNetworkInfo.getType();
                }
            } catch (Exception unused) {
            }
        }
        return "&netc=".concat(String.valueOf(i));
    }

    /* renamed from: f */
    public static String m11551f() {
        try {
            if (Environment.getExternalStorageState().equals("mounted")) {
                String path = Environment.getExternalStorageDirectory().getPath();
                File file = new File(path + "/baidu/tempdata");
                if (!file.exists()) {
                    file.mkdirs();
                }
                return path;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    /* renamed from: g */
    public static String m11550g() {
        String m11551f = m11551f();
        if (m11551f == null) {
            return null;
        }
        return m11551f + "/baidu/tempdata";
    }

    /* renamed from: h */
    public static String m11549h() {
        try {
            File file = new File(ServiceC1002f.getServiceContext().getFilesDir() + File.separator + "lldt");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file.getAbsolutePath();
        } catch (Exception unused) {
            return null;
        }
    }
}
