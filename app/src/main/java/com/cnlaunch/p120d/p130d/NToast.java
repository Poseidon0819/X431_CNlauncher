package com.cnlaunch.p120d.p130d;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.launch.p365b.C3671a;

/* renamed from: com.cnlaunch.d.d.d */
/* loaded from: classes.dex */
public final class NToast {

    /* renamed from: a */
    private static int f7237a;

    /* renamed from: b */
    private static Toast f7238b;

    /* renamed from: c */
    private static Toast f7239c;

    /* renamed from: a */
    public static void m9450a(Context context, int i) {
        if (context != null) {
            m9448a(context, context.getString(i), 0);
        }
    }

    /* renamed from: b */
    public static void m9447b(Context context, int i) {
        if (context != null) {
            m9448a(context, context.getString(i), 1);
        }
    }

    /* renamed from: c */
    public static void m9444c(Context context, int i) {
        if (context != null) {
            m9445b(context, context.getString(i), 0);
        }
    }

    /* renamed from: c */
    public static void m9443c(Context context, String str) {
        if (context != null) {
            m9445b(context, str, 0);
        }
    }

    /* renamed from: d */
    public static void m9442d(Context context, int i) {
        if (context != null) {
            m9445b(context, context.getString(i), 1);
        }
    }

    /* renamed from: d */
    public static void m9441d(Context context, String str) {
        if (context != null) {
            m9445b(context, str, 1);
        }
    }

    /* renamed from: a */
    private static void m9448a(Context context, String str, int i) {
        View inflate;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f7238b = new Toast(context);
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        int i2 = f7237a;
        if (i2 != 0) {
            inflate = layoutInflater.inflate(i2, (ViewGroup) null);
        } else {
            inflate = layoutInflater.inflate(C3671a.C3673b.layout_toast, (ViewGroup) null);
        }
        TextView textView = (TextView) inflate.findViewById(C3671a.C3672a.toast_message);
        if (textView != null) {
            textView.setText(str);
        }
        f7238b.setView(inflate);
        f7238b.setDuration(i);
        if (Build.MODEL != null && (Build.MODEL.contains("TB2-X30F") || Build.MODEL.contains("TOPDON") || Build.MODEL.contains("VCDS"))) {
            f7238b.setGravity(17, 0, -50);
        }
        f7238b.show();
    }

    /* renamed from: b */
    private static void m9445b(Context context, String str, int i) {
        View inflate;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Toast toast = new Toast(context);
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        int i2 = f7237a;
        if (i2 != 0) {
            inflate = layoutInflater.inflate(i2, (ViewGroup) null);
        } else {
            inflate = layoutInflater.inflate(C3671a.C3673b.layout_toast, (ViewGroup) null);
        }
        TextView textView = (TextView) inflate.findViewById(C3671a.C3672a.toast_message);
        if (textView != null) {
            textView.setText(str);
        }
        if (Build.MODEL != null && Build.MODEL.contains("TB2-X30F")) {
            toast.setGravity(17, 0, -50);
        } else {
            toast.setGravity(17, 0, 0);
        }
        toast.setView(inflate);
        toast.setDuration(i);
        toast.show();
    }

    /* renamed from: a */
    public static void m9449a(Context context, String str) {
        if (context != null) {
            m9448a(context, str, 0);
        }
    }

    /* renamed from: b */
    public static void m9446b(Context context, String str) {
        if (context != null) {
            m9448a(context, str, 1);
        }
    }
}
