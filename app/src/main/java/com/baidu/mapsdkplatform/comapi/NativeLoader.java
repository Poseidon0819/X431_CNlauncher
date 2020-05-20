package com.baidu.mapsdkplatform.comapi;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: classes.dex */
public class NativeLoader {

    /* renamed from: a */
    private static final String f5805a = "NativeLoader";

    /* renamed from: b */
    private static Context f5806b;

    /* renamed from: e */
    private static NativeLoader f5809e;

    /* renamed from: c */
    private static final Set<String> f5807c = new HashSet();

    /* renamed from: d */
    private static final Set<String> f5808d = new HashSet();

    /* renamed from: f */
    private static EnumC1170a f5810f = EnumC1170a.ARMEABI;

    /* renamed from: g */
    private static boolean f5811g = false;

    /* renamed from: h */
    private static String f5812h = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.mapsdkplatform.comapi.NativeLoader$a */
    /* loaded from: classes.dex */
    public enum EnumC1170a {
        ARMEABI("armeabi"),
        ARMV7("armeabi-v7a"),
        ARM64("arm64-v8a"),
        X86("x86"),
        X86_64("x86_64");
        

        /* renamed from: f */
        private String f5820f;

        EnumC1170a(String str) {
            this.f5820f = str;
        }

        /* renamed from: a */
        public final String m10863a() {
            return this.f5820f;
        }
    }

    private NativeLoader() {
    }

    @TargetApi(8)
    /* renamed from: a */
    private String m10879a() {
        return 8 <= Build.VERSION.SDK_INT ? f5806b.getPackageCodePath() : "";
    }

    /* renamed from: a */
    private String m10878a(EnumC1170a enumC1170a) {
        return "lib/" + enumC1170a.m10863a() + "/";
    }

    /* renamed from: a */
    private void m10877a(InputStream inputStream, FileOutputStream fileOutputStream) throws IOException {
        byte[] bArr = new byte[4096];
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            } finally {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    Log.e(f5805a, "Close InputStream error", e);
                }
                try {
                    fileOutputStream.close();
                } catch (IOException e2) {
                    Log.e(f5805a, "Close OutputStream error", e2);
                }
            }
        }
        fileOutputStream.flush();
    }

    /* renamed from: a */
    private void m10873a(Throwable th) {
        Log.e(f5805a, "loadException", th);
        Iterator<String> it = f5808d.iterator();
        while (it.hasNext()) {
            String str = f5805a;
            Log.e(str, it.next() + " Failed to load.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m10872a(boolean z, String str) {
        f5811g = z;
        f5812h = str;
    }

    /* renamed from: a */
    private boolean m10876a(String str) {
        try {
            synchronized (f5807c) {
                if (f5807c.contains(str)) {
                    return true;
                }
                System.loadLibrary(str);
                synchronized (f5807c) {
                    f5807c.add(str);
                }
                return true;
            }
        } catch (Throwable unused) {
            return m10870b(str);
        }
    }

    /* renamed from: a */
    private boolean m10875a(String str, EnumC1170a enumC1170a) {
        ZipFile zipFile;
        File file = new File(m10871b(), str);
        if (!file.exists() || file.length() <= 0) {
            String str2 = m10878a(enumC1170a) + str;
            ZipFile zipFile2 = null;
            String m10879a = !f5811g ? m10879a() : f5812h;
            if (m10879a != null) {
                try {
                    if (!m10879a.isEmpty()) {
                        try {
                            zipFile = new ZipFile(m10879a);
                            try {
                                ZipEntry entry = zipFile.getEntry(str2);
                                if (entry == null) {
                                    try {
                                        zipFile.close();
                                    } catch (IOException e) {
                                        Log.e(f5805a, "Release file failed", e);
                                    }
                                    return false;
                                }
                                m10877a(zipFile.getInputStream(entry), new FileOutputStream(new File(m10871b(), str)));
                                try {
                                    zipFile.close();
                                } catch (IOException e2) {
                                    Log.e(f5805a, "Release file failed", e2);
                                }
                                return true;
                            } catch (Exception e3) {
                                e = e3;
                                zipFile2 = zipFile;
                                Log.e(f5805a, "Copy library file error", e);
                                if (zipFile2 != null) {
                                    try {
                                        zipFile2.close();
                                    } catch (IOException e4) {
                                        Log.e(f5805a, "Release file failed", e4);
                                    }
                                }
                                return false;
                            } catch (Throwable th) {
                                th = th;
                                if (zipFile != null) {
                                    try {
                                        zipFile.close();
                                    } catch (IOException e5) {
                                        Log.e(f5805a, "Release file failed", e5);
                                    }
                                }
                                throw th;
                            }
                        } catch (Exception e6) {
                            e = e6;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    zipFile = null;
                }
            }
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private boolean m10874a(String str, String str2) {
        return !m10875a(str2, EnumC1170a.ARMV7) ? m10869b(str, str2) : m10864f(str2, str);
    }

    /* renamed from: b */
    private String m10871b() {
        File file = new File(f5806b.getFilesDir(), "libs");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    /* renamed from: b */
    private boolean m10870b(String str) {
        boolean m10867c;
        String mapLibraryName = System.mapLibraryName(str);
        synchronized (f5807c) {
            if (f5807c.contains(str)) {
                return true;
            }
            switch (f5810f) {
                case ARM64:
                    m10867c = m10867c(str, mapLibraryName);
                    break;
                case ARMV7:
                    m10867c = m10874a(str, mapLibraryName);
                    break;
                case ARMEABI:
                    m10867c = m10869b(str, mapLibraryName);
                    break;
                case X86_64:
                    m10867c = m10865e(str, mapLibraryName);
                    break;
                case X86:
                    m10867c = m10866d(str, mapLibraryName);
                    break;
                default:
                    m10867c = false;
                    break;
            }
            synchronized (f5807c) {
                f5807c.add(str);
            }
            return m10867c;
        }
    }

    /* renamed from: b */
    private boolean m10869b(String str, String str2) {
        if (m10875a(str2, EnumC1170a.ARMEABI)) {
            return m10864f(str2, str);
        }
        String str3 = f5805a;
        Log.e(str3, "found lib" + str + ".so error");
        return false;
    }

    @TargetApi(21)
    /* renamed from: c */
    private static EnumC1170a m10868c() {
        String str = Build.VERSION.SDK_INT < 21 ? Build.CPU_ABI : Build.SUPPORTED_ABIS[0];
        if (str == null) {
            return EnumC1170a.ARMEABI;
        }
        if (str.contains("arm") && str.contains("v7")) {
            f5810f = EnumC1170a.ARMV7;
        }
        if (str.contains("arm") && str.contains(DiagnoseConstants.FEEDBACK_PARALLEL_SUB_MENU)) {
            f5810f = EnumC1170a.ARM64;
        }
        if (str.contains("x86")) {
            f5810f = str.contains(DiagnoseConstants.FEEDBACK_PARALLEL_SUB_MENU) ? EnumC1170a.X86_64 : EnumC1170a.X86;
        }
        return f5810f;
    }

    /* renamed from: c */
    private boolean m10867c(String str, String str2) {
        return !m10875a(str2, EnumC1170a.ARM64) ? m10874a(str, str2) : m10864f(str2, str);
    }

    /* renamed from: d */
    private boolean m10866d(String str, String str2) {
        return !m10875a(str2, EnumC1170a.X86) ? m10874a(str, str2) : m10864f(str2, str);
    }

    /* renamed from: e */
    private boolean m10865e(String str, String str2) {
        return !m10875a(str2, EnumC1170a.X86_64) ? m10866d(str, str2) : m10864f(str2, str);
    }

    /* renamed from: f */
    private boolean m10864f(String str, String str2) {
        try {
            System.load(new File(m10871b(), str).getAbsolutePath());
            synchronized (f5807c) {
                f5807c.add(str2);
            }
            return true;
        } catch (Throwable th) {
            synchronized (f5808d) {
                f5808d.add(str2);
                m10873a(th);
                return false;
            }
        }
    }

    public static synchronized NativeLoader getInstance() {
        NativeLoader nativeLoader;
        synchronized (NativeLoader.class) {
            if (f5809e == null) {
                f5809e = new NativeLoader();
                f5810f = m10868c();
            }
            nativeLoader = f5809e;
        }
        return nativeLoader;
    }

    public static void setContext(Context context) {
        f5806b = context;
    }

    public synchronized boolean loadLibrary(String str) {
        if (!f5811g) {
            return m10876a(str);
        } else if (f5812h == null || f5812h.isEmpty()) {
            Log.e(f5805a, "Given custom so file path is null, please check!");
            return false;
        } else {
            return m10870b(str);
        }
    }
}
