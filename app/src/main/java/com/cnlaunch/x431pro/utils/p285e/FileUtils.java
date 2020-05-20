package com.cnlaunch.x431pro.utils.p285e;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.x431pro.module.p263h.p265b.FormFile;
import com.cnlaunch.x431pro.utils.C2778n;
import com.cnlaunch.x431pro.utils.C2787z;
import com.cnlaunch.x431pro.utils.PathUtils;
import com.cnlaunch.x431pro.utils.p285e.IniFile;
import com.unionpay.tsmservice.data.Constant;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import org.apache.http.HttpException;
import org.apache.http.client.methods.HttpPostHC4;
import org.apache.http.util.EncodingUtils;
import org.apache.mina.proxy.handlers.http.HttpProxyConstants;

/* renamed from: com.cnlaunch.x431pro.utils.e.a */
/* loaded from: classes.dex */
public class FileUtils {

    /* renamed from: a */
    private static final String f15851a = "a";

    /* renamed from: a */
    public static boolean m5017a(String str) {
        return new File(str).exists();
    }

    /* renamed from: a */
    public static boolean m5023a(Bitmap bitmap, String str) {
        FileOutputStream fileOutputStream;
        if (bitmap == null) {
            return false;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                File file = new File(str);
                if (file.exists() || file.createNewFile()) {
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.PNG;
                        String lowerCase = str.toLowerCase(Locale.getDefault());
                        if (".jpg".endsWith(lowerCase)) {
                            compressFormat = Bitmap.CompressFormat.JPEG;
                        } else if (".png".endsWith(lowerCase)) {
                            compressFormat = Bitmap.CompressFormat.PNG;
                        }
                        bitmap.compress(compressFormat, 100, fileOutputStream);
                        fileOutputStream.flush();
                        try {
                            fileOutputStream.close();
                            return true;
                        } catch (IOException e) {
                            e.printStackTrace();
                            return true;
                        }
                    } catch (IOException e2) {
                        e = e2;
                        fileOutputStream2 = fileOutputStream;
                        e.printStackTrace();
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
                return false;
            } catch (IOException e5) {
                e = e5;
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
        }
    }

    /* renamed from: a */
    public static boolean m5016a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return m5007a(str.getBytes("UTF-8"), str2);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: a */
    private static boolean m5007a(byte[] bArr, String str) {
        if (bArr == null) {
            return false;
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(new File(str));
                    try {
                        fileOutputStream2.write(bArr);
                        fileOutputStream2.flush();
                        try {
                            fileOutputStream2.close();
                            return true;
                        } catch (IOException e) {
                            e.printStackTrace();
                            return true;
                        }
                    } catch (FileNotFoundException e2) {
                        e = e2;
                        fileOutputStream = fileOutputStream2;
                        e.printStackTrace();
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                            return false;
                        }
                        return false;
                    } catch (IOException e3) {
                        e = e3;
                        fileOutputStream = fileOutputStream2;
                        e.printStackTrace();
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                            return false;
                        }
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (FileNotFoundException e5) {
                    e = e5;
                } catch (IOException e6) {
                    e = e6;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e7) {
            e7.printStackTrace();
            return false;
        }
    }

    /* renamed from: a */
    private static boolean m5018a(InputStream inputStream, String str) {
        FileOutputStream fileOutputStream;
        File file = new File(str);
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if (inputStream != null) {
                    try {
                        fileOutputStream = new FileOutputStream(file);
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int read = inputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, read);
                            }
                            NLog.m9451c(f15851a, "saveFile file success. ".concat(String.valueOf(str)));
                            fileOutputStream2 = fileOutputStream;
                        } catch (FileNotFoundException e) {
                            e = e;
                            fileOutputStream2 = fileOutputStream;
                            e.printStackTrace();
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                }
                            }
                            if (fileOutputStream2 != null) {
                                try {
                                    fileOutputStream2.flush();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                }
                            }
                            if (fileOutputStream2 != null) {
                                fileOutputStream2.close();
                            }
                            return false;
                        } catch (IOException e4) {
                            e = e4;
                            fileOutputStream2 = fileOutputStream;
                            e.printStackTrace();
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e5) {
                                    e5.printStackTrace();
                                }
                            }
                            if (fileOutputStream2 != null) {
                                try {
                                    fileOutputStream2.flush();
                                } catch (IOException e6) {
                                    e6.printStackTrace();
                                }
                            }
                            if (fileOutputStream2 != null) {
                                fileOutputStream2.close();
                            }
                            return false;
                        } catch (Throwable th) {
                            th = th;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e7) {
                                    e7.printStackTrace();
                                }
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.flush();
                                } catch (IOException e8) {
                                    e8.printStackTrace();
                                }
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e9) {
                                    e9.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (FileNotFoundException e10) {
                        e = e10;
                    } catch (IOException e11) {
                        e = e11;
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e12) {
                        e12.printStackTrace();
                    }
                }
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.flush();
                    } catch (IOException e13) {
                        e13.printStackTrace();
                    }
                }
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
            }
        } catch (IOException e14) {
            e14.printStackTrace();
        }
        return false;
    }

    /* renamed from: b */
    public static String m5005b(String str) {
        StringBuilder sb = new StringBuilder();
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, "UTF-8"));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
            }
            bufferedReader.close();
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return sb.toString();
    }

    /* renamed from: b */
    public static String m5004b(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, str2));
            String str3 = "\n";
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine + str3);
                str3 = "";
            }
            bufferedReader.close();
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v13, types: [java.lang.String] */
    /* renamed from: c */
    public static String m5002c(String str) {
        String str2 = "";
        FileInputStream fileInputStream = null;
        try {
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(str);
                try {
                    byte[] bArr = new byte[fileInputStream2.available()];
                    fileInputStream2.read(bArr);
                    ?? r1 = "UTF-8";
                    str2 = EncodingUtils.getString(bArr, "UTF-8");
                    fileInputStream2.close();
                    fileInputStream = r1;
                } catch (FileNotFoundException e2) {
                    e = e2;
                    fileInputStream = fileInputStream2;
                    e.printStackTrace();
                    if (fileInputStream != null) {
                        fileInputStream.close();
                        fileInputStream = fileInputStream;
                    }
                    return str2;
                } catch (IOException e3) {
                    e = e3;
                    fileInputStream = fileInputStream2;
                    e.printStackTrace();
                    if (fileInputStream != null) {
                        fileInputStream.close();
                        fileInputStream = fileInputStream;
                    }
                    return str2;
                } catch (Exception e4) {
                    e = e4;
                    fileInputStream = fileInputStream2;
                    e.printStackTrace();
                    if (fileInputStream != null) {
                        fileInputStream.close();
                        fileInputStream = fileInputStream;
                    }
                    return str2;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException e6) {
                e = e6;
            } catch (IOException e7) {
                e = e7;
            } catch (Exception e8) {
                e = e8;
            }
            return str2;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: a */
    private static InputStream m5025a(Context context, String str) {
        try {
            return context.getResources().getAssets().open(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: c */
    public static synchronized String m5001c(String str, String str2) {
        synchronized (FileUtils.class) {
            String str3 = Constant.CASH_LOAD_SUCCESS;
            File file = new File(str);
            if (!file.exists()) {
                return "File does not exist";
            }
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    ZipFile zipFile = new ZipFile(file);
                    Enumeration<? extends ZipEntry> entries = zipFile.entries();
                    while (entries.hasMoreElements()) {
                        ZipEntry nextElement = entries.nextElement();
                        if (nextElement.isDirectory()) {
                            String name = nextElement.getName();
                            String substring = name.substring(0, name.length() - 1);
                            new File(str2 + substring).mkdirs();
                        } else {
                            File file2 = new File(str2 + nextElement.getName());
                            file2.getParentFile().mkdirs();
                            file2.createNewFile();
                            InputStream inputStream = zipFile.getInputStream(nextElement);
                            FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                            try {
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int read = inputStream.read(bArr, 0, 1024);
                                    if (read == -1) {
                                        break;
                                    }
                                    fileOutputStream2.write(bArr, 0, read);
                                }
                                inputStream.close();
                                fileOutputStream2.close();
                            } catch (ZipException unused) {
                                fileOutputStream = fileOutputStream2;
                                str3 = "fail";
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e) {
                                        e = e;
                                        e.printStackTrace();
                                        return str3;
                                    }
                                }
                                return str3;
                            } catch (IOException unused2) {
                                fileOutputStream = fileOutputStream2;
                                str3 = "fail";
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e2) {
                                        e = e2;
                                        e.printStackTrace();
                                        return str3;
                                    }
                                }
                                return str3;
                            } catch (Exception e3) {
                                e = e3;
                                fileOutputStream = fileOutputStream2;
                                e.printStackTrace();
                                str3 = "fail";
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e4) {
                                        e = e4;
                                        e.printStackTrace();
                                        return str3;
                                    }
                                }
                                return str3;
                            } catch (Throwable th) {
                                th = th;
                                fileOutputStream = fileOutputStream2;
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e5) {
                                        e5.printStackTrace();
                                    }
                                }
                                throw th;
                            }
                        }
                    }
                    zipFile.close();
                } catch (ZipException unused3) {
                } catch (IOException unused4) {
                } catch (Exception e6) {
                    e = e6;
                }
                return str3;
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    /* renamed from: a */
    public static synchronized String m5015a(String str, String str2, UnZipListener unZipListener) {
        Throwable th;
        IOException iOException;
        int i;
        synchronized (FileUtils.class) {
            String str3 = Constant.CASH_LOAD_SUCCESS;
            unZipListener.mo4527a();
            File file = new File(str);
            FileOutputStream fileOutputStream = null;
            if (!file.exists()) {
                unZipListener.mo4525a(-1, (Throwable) null);
                unZipListener.mo4524b();
                return "File does not exist";
            }
            File file2 = new File(str2);
            if (!file2.exists()) {
                file2.mkdir();
            }
            byte[] bArr = new byte[1048576];
            int i2 = 1;
            try {
                try {
                    ZipFile zipFile = new ZipFile(file);
                    Enumeration<? extends ZipEntry> entries = zipFile.entries();
                    int size = zipFile.size();
                    int i3 = 0;
                    while (entries.hasMoreElements()) {
                        ZipEntry nextElement = entries.nextElement();
                        if (nextElement.isDirectory()) {
                            String name = nextElement.getName();
                            String substring = name.substring(0, name.length() - i2);
                            new File(str2 + substring).mkdirs();
                            i = 1;
                        } else {
                            File file3 = new File(str2 + nextElement.getName());
                            file3.getParentFile().mkdirs();
                            file3.createNewFile();
                            InputStream inputStream = zipFile.getInputStream(nextElement);
                            FileOutputStream fileOutputStream2 = new FileOutputStream(file3);
                            while (true) {
                                try {
                                    int read = inputStream.read(bArr, 0, 1048576);
                                    if (read == -1) {
                                        break;
                                    }
                                    fileOutputStream2.write(bArr, 0, read);
                                } catch (ZipException e) {
                                    e = e;
                                    fileOutputStream = fileOutputStream2;
                                    e.printStackTrace();
                                    str3 = e.getMessage();
                                    unZipListener.mo4525a(-2, e);
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                        } catch (IOException e2) {
                                            iOException = e2;
                                            iOException.printStackTrace();
                                            unZipListener.mo4524b();
                                            return str3;
                                        }
                                    }
                                    unZipListener.mo4524b();
                                    return str3;
                                } catch (IOException e3) {
                                    e = e3;
                                    fileOutputStream = fileOutputStream2;
                                    e.printStackTrace();
                                    String str4 = f15851a;
                                    NLog.m9451c(str4, "unZipEx Error: " + e.getMessage());
                                    str3 = e.getMessage();
                                    unZipListener.mo4525a(-3, e);
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                        } catch (IOException e4) {
                                            iOException = e4;
                                            iOException.printStackTrace();
                                            unZipListener.mo4524b();
                                            return str3;
                                        }
                                    }
                                    unZipListener.mo4524b();
                                    return str3;
                                } catch (Exception e5) {
                                    e = e5;
                                    fileOutputStream = fileOutputStream2;
                                    e.printStackTrace();
                                    str3 = e.getMessage();
                                    unZipListener.mo4525a(-4, e);
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                        } catch (IOException e6) {
                                            iOException = e6;
                                            iOException.printStackTrace();
                                            unZipListener.mo4524b();
                                            return str3;
                                        }
                                    }
                                    unZipListener.mo4524b();
                                    return str3;
                                } catch (Throwable th2) {
                                    th = th2;
                                    fileOutputStream = fileOutputStream2;
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                        } catch (IOException e7) {
                                            e7.printStackTrace();
                                        }
                                    }
                                    throw th;
                                }
                            }
                            inputStream.close();
                            fileOutputStream2.close();
                            i = 1;
                        }
                        i3 += i;
                        unZipListener.mo4526a(i3, size);
                        i2 = 1;
                    }
                    zipFile.close();
                } catch (ZipException e8) {
                    e = e8;
                    fileOutputStream = null;
                } catch (IOException e9) {
                    e = e9;
                    fileOutputStream = null;
                } catch (Exception e10) {
                    e = e10;
                    fileOutputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = null;
                }
                unZipListener.mo4524b();
                return str3;
            } catch (Throwable th4) {
                th = th4;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x0113 A[Catch: IOException -> 0x0117, TRY_ENTER, TRY_LEAVE, TryCatch #2 {IOException -> 0x0117, blocks: (B:51:0x0113, B:59:0x0147, B:65:0x015a), top: B:79:0x0035 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0147 A[Catch: IOException -> 0x0117, TRY_ENTER, TRY_LEAVE, TryCatch #2 {IOException -> 0x0117, blocks: (B:51:0x0113, B:59:0x0147, B:65:0x015a), top: B:79:0x0035 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x015a A[Catch: IOException -> 0x0117, TRY_ENTER, TRY_LEAVE, TryCatch #2 {IOException -> 0x0117, blocks: (B:51:0x0113, B:59:0x0147, B:65:0x015a), top: B:79:0x0035 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m5013a(java.lang.String r16, java.lang.String r17, com.cnlaunch.x431pro.utils.p285e.UnZipListener r18, java.lang.String[] r19) {
        /*
            Method dump skipped, instructions count: 368
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.x431pro.utils.p285e.FileUtils.m5013a(java.lang.String, java.lang.String, com.cnlaunch.x431pro.utils.e.c, java.lang.String[]):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:83:0x014a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized java.lang.String m5014a(java.lang.String r16, java.lang.String r17, com.cnlaunch.x431pro.utils.p285e.UnZipListener r18, java.lang.String r19) {
        /*
            Method dump skipped, instructions count: 344
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.x431pro.utils.p285e.FileUtils.m5014a(java.lang.String, java.lang.String, com.cnlaunch.x431pro.utils.e.c, java.lang.String):java.lang.String");
    }

    /* renamed from: d */
    public static boolean m5000d(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                return file.delete();
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: a */
    private static String m5009a(String str, String... strArr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 0; i++) {
            sb.append(strArr[0]);
            sb.append(File.separator);
        }
        File file = new File(sb.toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        sb.append(str);
        return sb.toString();
    }

    /* renamed from: a */
    public static void m5026a(Context context) {
        List asList = Arrays.asList("HelpDocSource", "images", "sounds", "webkit", "icon", "TTFSource", "cnlaunchScanner.apk");
        String m9591a = PreferencesManager.m9595a(context).m9591a("new_car_prefix");
        if (C2778n.m4920a()) {
            m5024a(context, asList, PathUtils.m4870a(context), "");
            String m4857c = PathUtils.m4857c(context, m9591a);
            try {
                if (C2778n.m4920a()) {
                    for (String str : Arrays.asList(context.getResources().getAssets().list(""))) {
                        if (str.equals("StdCfg.ini")) {
                            String m5009a = m5009a(str, m4857c);
                            String str2 = TextUtils.isEmpty("") ? str : "" + File.separator + str;
                            if (str.contains(".")) {
                                InputStream m5025a = m5025a(context, str2);
                                if (m5017a(m5009a)) {
                                    try {
                                        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(new File(m5009a)));
                                        if (!m5025a.equals(bufferedInputStream)) {
                                            m5018a(m5025a, m5009a);
                                        } else {
                                            NLog.m9451c(f15851a, " file is equal. ".concat(String.valueOf(m5009a)));
                                        }
                                        bufferedInputStream.close();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                } else if (m5025a != null) {
                                    m5018a(m5025a, m5009a);
                                }
                            }
                        }
                    }
                    return;
                }
                return;
            } catch (IOException e2) {
                e2.printStackTrace();
                return;
            }
        }
        NLog.m9451c(f15851a, "SD Card is Unavailable.");
    }

    /* renamed from: a */
    private static void m5024a(Context context, List<String> list, String str, String str2) {
        try {
            if (C2778n.m4920a()) {
                for (String str3 : Arrays.asList(context.getResources().getAssets().list(str2))) {
                    if (!list.contains(str3)) {
                        String m5009a = m5009a(str3, str);
                        String str4 = TextUtils.isEmpty(str2) ? str3 : str2 + File.separator + str3;
                        if (str3.contains(".")) {
                            InputStream m5025a = m5025a(context, str4);
                            if (m5017a(m5009a)) {
                                if (str3.equals("StdCfg.ini") || str3.equalsIgnoreCase("agreenment_ja.pdf") || str3.equalsIgnoreCase("quickstart_en.pdf") || str3.equalsIgnoreCase("quickstart_cn.pdf") || str3.equalsIgnoreCase("user_manual_cn.pdf") || str3.equalsIgnoreCase("user_manual_en.pdf")) {
                                    try {
                                        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(new File(m5009a)));
                                        if (!m5025a.equals(bufferedInputStream)) {
                                            m5018a(m5025a, m5009a);
                                        } else {
                                            NLog.m9451c(f15851a, " file is equal. ".concat(String.valueOf(m5009a)));
                                        }
                                        bufferedInputStream.close();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            } else if (m5025a != null) {
                                m5018a(m5025a, m5009a);
                            }
                        } else {
                            m5024a(context, list, m5009a, str4);
                        }
                    }
                }
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: e */
    public static List<String> m4998e(String str) {
        String[] list;
        ArrayList arrayList = new ArrayList();
        File file = new File(str);
        if (file.exists() && (list = file.list()) != null) {
            for (String str2 : list) {
                if (TextUtils.isDigitsOnly(str2)) {
                    arrayList.add(str2);
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0096 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v9, types: [java.io.BufferedReader] */
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.Map<java.lang.String, java.util.Properties> m4996f(java.lang.String r6) {
        /*
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            r1 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L67 java.io.IOException -> L74 java.io.FileNotFoundException -> L81
            r2.<init>(r6)     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L67 java.io.IOException -> L74 java.io.FileNotFoundException -> L81
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L67 java.io.IOException -> L74 java.io.FileNotFoundException -> L81
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L67 java.io.IOException -> L74 java.io.FileNotFoundException -> L81
            java.lang.String r4 = "UTF-8"
            r3.<init>(r2, r4)     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L67 java.io.IOException -> L74 java.io.FileNotFoundException -> L81
            r6.<init>(r3)     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L67 java.io.IOException -> L74 java.io.FileNotFoundException -> L81
        L17:
            java.lang.String r2 = r6.readLine()     // Catch: java.lang.Exception -> L5e java.io.IOException -> L60 java.io.FileNotFoundException -> L62 java.lang.Throwable -> L93
            if (r2 == 0) goto L5a
            java.lang.String r2 = r2.trim()     // Catch: java.lang.Exception -> L5e java.io.IOException -> L60 java.io.FileNotFoundException -> L62 java.lang.Throwable -> L93
            java.lang.String r3 = "\\[.*\\]"
            boolean r3 = r2.matches(r3)     // Catch: java.lang.Exception -> L5e java.io.IOException -> L60 java.io.FileNotFoundException -> L62 java.lang.Throwable -> L93
            if (r3 == 0) goto L3b
            java.lang.String r1 = "\\[(.*)\\]"
            java.lang.String r3 = "$1"
            java.lang.String r1 = r2.replaceFirst(r1, r3)     // Catch: java.lang.Exception -> L5e java.io.IOException -> L60 java.io.FileNotFoundException -> L62 java.lang.Throwable -> L93
            java.util.Properties r2 = new java.util.Properties     // Catch: java.lang.Exception -> L5e java.io.IOException -> L60 java.io.FileNotFoundException -> L62 java.lang.Throwable -> L93
            r2.<init>()     // Catch: java.lang.Exception -> L5e java.io.IOException -> L60 java.io.FileNotFoundException -> L62 java.lang.Throwable -> L93
            r0.put(r1, r2)     // Catch: java.lang.Exception -> L5e java.io.IOException -> L60 java.io.FileNotFoundException -> L62 java.lang.Throwable -> L93
            r1 = r2
            goto L17
        L3b:
            java.lang.String r3 = ".*=.*"
            boolean r3 = r2.matches(r3)     // Catch: java.lang.Exception -> L5e java.io.IOException -> L60 java.io.FileNotFoundException -> L62 java.lang.Throwable -> L93
            if (r3 == 0) goto L17
            if (r1 == 0) goto L17
            r3 = 61
            int r3 = r2.indexOf(r3)     // Catch: java.lang.Exception -> L5e java.io.IOException -> L60 java.io.FileNotFoundException -> L62 java.lang.Throwable -> L93
            r4 = 0
            java.lang.String r4 = r2.substring(r4, r3)     // Catch: java.lang.Exception -> L5e java.io.IOException -> L60 java.io.FileNotFoundException -> L62 java.lang.Throwable -> L93
            int r3 = r3 + 1
            java.lang.String r2 = r2.substring(r3)     // Catch: java.lang.Exception -> L5e java.io.IOException -> L60 java.io.FileNotFoundException -> L62 java.lang.Throwable -> L93
            r1.setProperty(r4, r2)     // Catch: java.lang.Exception -> L5e java.io.IOException -> L60 java.io.FileNotFoundException -> L62 java.lang.Throwable -> L93
            goto L17
        L5a:
            r6.close()     // Catch: java.io.IOException -> L8e
            goto L92
        L5e:
            r1 = move-exception
            goto L6b
        L60:
            r1 = move-exception
            goto L78
        L62:
            r1 = move-exception
            goto L85
        L64:
            r0 = move-exception
            r6 = r1
            goto L94
        L67:
            r6 = move-exception
            r5 = r1
            r1 = r6
            r6 = r5
        L6b:
            com.cnlaunch.p120d.p130d.NLog.m9455a(r1)     // Catch: java.lang.Throwable -> L93
            if (r6 == 0) goto L92
            r6.close()     // Catch: java.io.IOException -> L8e
            goto L92
        L74:
            r6 = move-exception
            r5 = r1
            r1 = r6
            r6 = r5
        L78:
            com.cnlaunch.p120d.p130d.NLog.m9455a(r1)     // Catch: java.lang.Throwable -> L93
            if (r6 == 0) goto L92
            r6.close()     // Catch: java.io.IOException -> L8e
            goto L92
        L81:
            r6 = move-exception
            r5 = r1
            r1 = r6
            r6 = r5
        L85:
            com.cnlaunch.p120d.p130d.NLog.m9455a(r1)     // Catch: java.lang.Throwable -> L93
            if (r6 == 0) goto L92
            r6.close()     // Catch: java.io.IOException -> L8e
            goto L92
        L8e:
            r6 = move-exception
            com.cnlaunch.p120d.p130d.NLog.m9455a(r6)
        L92:
            return r0
        L93:
            r0 = move-exception
        L94:
            if (r6 == 0) goto L9e
            r6.close()     // Catch: java.io.IOException -> L9a
            goto L9e
        L9a:
            r6 = move-exception
            com.cnlaunch.p120d.p130d.NLog.m9455a(r6)
        L9e:
            throw r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.x431pro.utils.p285e.FileUtils.m4996f(java.lang.String):java.util.Map");
    }

    /* renamed from: a */
    public static String m5008a(Map<String, Properties> map, String str, String str2) {
        Properties properties;
        String m4804o = C2787z.m4804o((map == null || (properties = map.get(str)) == null) ? null : properties.getProperty(str2));
        return !TextUtils.isEmpty(m4804o) ? m4804o : "";
    }

    /* renamed from: a */
    public static String m5010a(String str, Map<String, String> map, FormFile[] formFileArr) throws Exception {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        int i = 0;
        try {
            try {
                httpURLConnection.setConnectTimeout(30000);
                httpURLConnection.setRequestMethod(HttpPostHC4.METHOD_NAME);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestProperty("connection", "Keep-Alive");
                httpURLConnection.setRequestProperty("Charsert", "UTF-8");
                httpURLConnection.setRequestProperty("Content-type", "multipart/form-data;boundary=---------------------------7da2137580612\r\n");
                httpURLConnection.connect();
                OutputStream outputStream = httpURLConnection.getOutputStream();
                StringBuilder sb = new StringBuilder();
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    sb.append("--");
                    sb.append("---------------------------7da2137580612");
                    sb.append(HttpProxyConstants.CRLF);
                    sb.append("Content-Disposition: form-data; name=\"" + entry.getKey() + "\"\r\n\r\n");
                    sb.append(entry.getValue());
                    sb.append(HttpProxyConstants.CRLF);
                }
                outputStream.write(sb.toString().getBytes("UTF-8"));
                for (FormFile formFile : formFileArr) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("--");
                    sb2.append("---------------------------7da2137580612");
                    sb2.append(HttpProxyConstants.CRLF);
                    sb2.append("Content-Disposition: form-data;name=\"" + formFile.f15556d + "\";filename=\"" + formFile.f15555c + "\"\r\n");
                    StringBuilder sb3 = new StringBuilder("Content-Type: ");
                    sb3.append(formFile.f15557e);
                    sb3.append("\r\n\r\n");
                    sb2.append(sb3.toString());
                    outputStream.write(sb2.toString().getBytes("UTF-8"));
                    if (formFile.f15554b != null) {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = formFile.f15554b.read(bArr, 0, 1024);
                            if (read == -1) {
                                break;
                            }
                            outputStream.write(bArr, 0, read);
                        }
                        formFile.f15554b.close();
                    } else {
                        outputStream.write(formFile.f15553a, 0, formFile.f15553a.length);
                    }
                    outputStream.write(HttpProxyConstants.CRLF.getBytes("UTF-8"));
                }
                outputStream.write("-----------------------------7da2137580612--\r\n".getBytes("UTF-8"));
                outputStream.flush();
                outputStream.close();
                NLog.m9456a(f15851a, "开始接收返回数据");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "UTF-8"));
                NLog.m9456a(f15851a, "数据已经返回");
                String m5021a = m5021a(bufferedReader);
                NLog.m9456a(f15851a, "截取前返回的数据是".concat(String.valueOf(m5021a)));
                NLog.m9456a("hxm", "接收返回的的数据是".concat(String.valueOf(m5021a)));
                return m5021a;
            } catch (RuntimeException e) {
                e.printStackTrace();
                throw new HttpException("parse the return data exception");
            } catch (Exception e2) {
                NLog.m9456a(f15851a, "传文件返回结果解析异常" + e2.getMessage());
                throw new HttpException("parse the return data exception");
            }
        } finally {
            httpURLConnection.disconnect();
            int length = formFileArr.length;
            while (i < length) {
                InputStream inputStream = formFileArr[i].f15554b;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception unused) {
                    }
                }
                i++;
            }
        }
    }

    /* renamed from: a */
    private static String m5021a(BufferedReader bufferedReader) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                NLog.m9456a(f15851a, "处理返回数据".concat(String.valueOf(readLine)));
                sb.append(readLine + "/n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static String m5011a(String str, Map<String, String> map, FormFile formFile) throws Exception {
        return m5010a(str, map, new FormFile[]{formFile});
    }

    /* renamed from: a */
    public static void m5020a(File file) {
        if (file.exists()) {
            if (file.isFile()) {
                file.delete();
                return;
            }
            File[] listFiles = file.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                file.delete();
                return;
            }
            for (File file2 : listFiles) {
                m5020a(file2);
            }
            file.delete();
        }
    }

    /* renamed from: g */
    public static void m4995g(String str) {
        File file = new File(str);
        File file2 = new File(file.getAbsolutePath() + System.currentTimeMillis());
        file.renameTo(file2);
        m5020a(file2);
    }

    /* renamed from: a */
    public static long m5027a() {
        StatFs statFs = new StatFs(PathUtils.m4871a());
        return ((statFs.getAvailableBlocks() * statFs.getBlockSize()) / 1024) / 1024;
    }

    /* renamed from: h */
    public static long m4994h(String str) {
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        long blockSize = statFs.getBlockSize();
        long availableBlocks = statFs.getAvailableBlocks();
        if (str.equalsIgnoreCase("B")) {
            return availableBlocks * blockSize;
        }
        if (str.equalsIgnoreCase("KB")) {
            return (availableBlocks * blockSize) / 1024;
        }
        return ((availableBlocks * blockSize) / 1024) / 1024;
    }

    /* renamed from: d */
    public static File m4999d(String str, String str2) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(str + File.separator + str2);
        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return file2;
    }

    /* renamed from: a */
    public static void m5012a(String str, String str2, String str3, String str4) {
        try {
            File file = new File(str);
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (Exception unused) {
                    return;
                }
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(("[" + str2 + "]\n" + str3 + "=" + str4 + "\n").getBytes("UTF-8"));
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: i */
    public static List<String> m4993i(String str) {
        NLog.m9456a(f15851a, "getAllLocalSerialList.sdPath=".concat(String.valueOf(str)));
        new ArrayList();
        List<String> m4998e = m4998e(str);
        if (!TextUtils.isEmpty(str) && !str.contains(PathUtils.f15921a)) {
            List<String> m4998e2 = m4998e(PathUtils.m4863a(str, PathUtils.f15921a));
            HashSet hashSet = new HashSet();
            hashSet.addAll(m4998e);
            hashSet.addAll(m4998e2);
            m4998e.clear();
            m4998e.addAll(hashSet);
        }
        NLog.m9456a(f15851a, "getAllLocalSerialList.list=".concat(String.valueOf(m4998e)));
        return m4998e;
    }

    /* renamed from: j */
    public static void m4992j(String str) {
        File[] listFiles;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        File file = new File(str);
        if (!file.exists() || (listFiles = file.listFiles()) == null) {
            return;
        }
        for (File file2 : listFiles) {
            if (file2.isFile() && file2.getName().equalsIgnoreCase("ICON.INI")) {
                file2.delete();
            }
        }
    }

    /* renamed from: k */
    public static boolean m4991k(String str) {
        File[] listFiles;
        File file = new File(str);
        if (!file.exists() || (listFiles = file.listFiles()) == null || listFiles.length == 0) {
            return true;
        }
        for (File file2 : listFiles) {
            String name = file2.getName();
            if (!name.startsWith("V") || !TextUtils.isDigitsOnly(name.replace("V", "").replace(".", ""))) {
                if (file2.isDirectory()) {
                    m4991k(file2.getAbsolutePath());
                } else if (file2.getName().endsWith(".PNG")) {
                    file2.delete();
                }
            }
        }
        return true;
    }

    /* renamed from: a */
    public static boolean m5019a(File file, String str) {
        String str2;
        if (str == null) {
            NLog.m9451c("sarah", "Rename: null parameter");
            return false;
        }
        String path = file.getPath();
        int lastIndexOf = path.lastIndexOf(47);
        String substring = lastIndexOf != -1 ? path.substring(0, lastIndexOf) : "";
        if (substring.endsWith(File.separator)) {
            str2 = substring + str;
        } else {
            str2 = substring + File.separator + str;
        }
        if (path.endsWith(str2)) {
            return true;
        }
        NLog.m9456a("sarah", "Rename---oldPath = " + path + " rootPath = " + substring + "  newPath = " + str2);
        try {
            File file2 = new File(str2);
            if (file2.exists()) {
                return false;
            }
            while (file2.exists()) {
                file2 = new File(str2);
            }
            boolean renameTo = new File(path).renameTo(file2);
            Object[] objArr = new Object[1];
            StringBuilder sb = new StringBuilder("Rename---改名成功？ ");
            sb.append(renameTo ? "yes!" : "no!");
            objArr[0] = sb.toString();
            NLog.m9452b("sarah", objArr);
            return renameTo;
        } catch (SecurityException e) {
            NLog.m9451c("sarah", "Fail to rename file," + e.toString());
            return false;
        }
    }

    /* renamed from: e */
    public static String m4997e(String str, String str2) {
        Object m4987a;
        NLog.m9456a("yhx", "getDivisionNo enter,divisionSoftPackage=".concat(String.valueOf(str2)));
        try {
            File file = new File(str);
            return (!file.exists() || (m4987a = new IniFile(file).m4987a("DIV_INFO", str2)) == null) ? "" : m4987a.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: b */
    public static void m5003b(String str, String str2, String str3, String str4) {
        NLog.m9456a("yhx", "writeOrUpdateDivisionIni enter,key=" + str3 + ",value=" + str4);
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.createNewFile();
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                fileOutputStream.write(("[" + str2 + "]\n" + str3 + "=" + str4 + "\n").getBytes("UTF-8"));
                fileOutputStream.flush();
                fileOutputStream.close();
                return;
            }
            IniFile iniFile = new IniFile(file);
            IniFile.C2764a c2764a = iniFile.f15852a.get(str2);
            if (c2764a == null) {
                c2764a = new IniFile.C2764a();
            }
            c2764a.f15856a = str2;
            c2764a.m4985a(str3, str4);
            iniFile.f15852a.put(str2, c2764a);
            try {
                iniFile.m4988a(new BufferedWriter(new FileWriter(iniFile.f15853b)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: l */
    public static void m4990l(String str) {
        File file = new File(str);
        if (file.exists()) {
            String str2 = file.getParentFile().getAbsolutePath() + File.separator + "Division";
            File file2 = new File(str2);
            if (file2.exists()) {
                m5020a(file2);
                NLog.m9456a("yhx", "deleteDivisions enter, divisionFilePath=".concat(String.valueOf(str2)));
            }
        }
    }

    /* renamed from: a */
    public static String m5022a(IniFile iniFile, String str, String str2) {
        NLog.m9456a("yhx", "getVciCategory enter,serialNo=".concat(String.valueOf(str2)));
        String str3 = "";
        try {
            Object m4987a = iniFile.m4987a(str, str2);
            if (m4987a != null) {
                str3 = m4987a.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        NLog.m9456a("yhx", "getVciCategory exit,result=".concat(String.valueOf(str3)));
        return str3;
    }

    /* renamed from: b */
    public static boolean m5006b(File file) {
        boolean z;
        NLog.m9456a("yhx", "createFileSafely enter,file=" + file.getAbsolutePath());
        if (!file.exists()) {
            File file2 = new File(file.getParent() + File.separator + System.currentTimeMillis());
            if (!file2.exists() && file2.mkdirs()) {
                z = file2.renameTo(file);
                NLog.m9456a("yhx", "createFileSafely.renameresult=".concat(String.valueOf(z)));
                file2.delete();
                NLog.m9456a("yhx", "createFileSafely exit,result=".concat(String.valueOf(z)));
                return z;
            }
        }
        z = false;
        NLog.m9456a("yhx", "createFileSafely exit,result=".concat(String.valueOf(z)));
        return z;
    }
}
