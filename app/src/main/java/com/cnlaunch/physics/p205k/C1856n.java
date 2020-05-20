package com.cnlaunch.physics.p205k;

import android.os.Environment;
import android.util.Log;
import com.itextpdf.text.html.HtmlTags;
import com.p297e.p298a.p306b.ImageLoader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: MLog.java */
/* renamed from: com.cnlaunch.physics.k.n */
/* loaded from: classes.dex */
public final class C1856n {

    /* renamed from: a */
    public static boolean f10135a = false;

    /* renamed from: b */
    private static boolean f10136b = false;

    /* renamed from: c */
    private static Boolean f10137c = Boolean.FALSE;

    /* renamed from: d */
    private static String f10138d = Environment.getExternalStorageDirectory().getPath() + "/cnlaunch/mlog.txt";

    /* renamed from: e */
    private static SimpleDateFormat f10139e = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");

    /* renamed from: a */
    public static void m8130a(String str, String str2) {
        if (f10136b) {
            Log.d(str, str2);
            m8129a(ImageLoader.f17144a, str, str2);
        }
    }

    /* renamed from: b */
    public static void m8127b(String str, String str2) {
        if (f10136b) {
            Log.e(str, str2);
            m8129a("e", str, str2);
        }
    }

    /* renamed from: c */
    public static void m8126c(String str, String str2) {
        if (f10136b) {
            Log.w(str, str2);
            m8129a("w", str, str2);
        }
    }

    /* renamed from: d */
    public static void m8125d(String str, String str2) {
        if (f10136b) {
            Log.i(str, str2);
            m8129a(HtmlTags.f19629I, str, str2);
        }
    }

    /* renamed from: a */
    public static void m8128a(boolean z) {
        f10136b = z;
        f10135a = z;
    }

    /* renamed from: a */
    private static void m8129a(String str, String str2, String str3) {
        if (f10137c.booleanValue()) {
            Date date = new Date();
            m8131a(new File(f10138d), f10139e.format(date) + "    " + str + "    " + str2 + "    " + str3);
        }
    }

    /* renamed from: a */
    private static void m8131a(File file, String str) {
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(str);
            bufferedWriter.newLine();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
