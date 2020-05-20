package com.cnlaunch.wifiprinter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.cnlaunch.wifiprinter.C1900at;

/* renamed from: com.cnlaunch.wifiprinter.a */
/* loaded from: classes.dex */
public final class Constant {

    /* renamed from: a */
    public static boolean f10346a = false;

    /* renamed from: b */
    public static String f10347b = null;

    /* renamed from: c */
    public static boolean f10348c = false;

    /* renamed from: d */
    public static boolean f10349d = false;

    /* renamed from: e */
    public static int f10350e;

    /* renamed from: f */
    public static Context f10351f;

    /* renamed from: a */
    public static void m8033a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Toast toast = new Toast(context);
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(C1900at.C1906f.layout_toast, (ViewGroup) null);
        ((TextView) inflate.findViewById(C1900at.C1905e.toast_message)).setText(str);
        toast.setView(inflate);
        toast.setDuration(1);
        toast.show();
    }
}
