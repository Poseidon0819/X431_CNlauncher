package com.cnlaunch.diagnosemodule.wiget;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.cnlaunch.diagnosemodule.C1444R;

/* loaded from: classes.dex */
public class NToast {
    public static void shortToast(Context context, int i) {
        showToast(context, context.getString(i), 0);
    }

    public static void shortToast(Context context, String str) {
        showToast(context, str, 0);
    }

    public static void longToast(Context context, int i) {
        showToast(context, context.getString(i), 1);
    }

    public static void longToast(Context context, String str) {
        showToast(context, str, 1);
    }

    public static void shortToast(Context context, int i, int i2) {
        showToast(context, context.getString(i), 0, i2);
    }

    public static void shortToast(Context context, String str, int i) {
        showToast(context, str, 0, i);
    }

    public static void longToast(Context context, int i, int i2) {
        showToast(context, context.getString(i), 1, i2);
    }

    public static void longToast(Context context, String str, int i) {
        showToast(context, str, 1, i);
    }

    public static void showToast(Context context, String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Toast toast = new Toast(context);
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(C1444R.layout.layout_toast, (ViewGroup) null);
        ((TextView) inflate.findViewById(C1444R.C1445id.toast_message)).setText(str);
        toast.setView(inflate);
        if (Build.MODEL != null && (Build.MODEL.contains("TB2-X30F") || Build.MODEL.contains("TOPDON") || Build.MODEL.contains("VCDS"))) {
            toast.setGravity(17, 0, -50);
        }
        toast.setDuration(i);
        toast.show();
    }

    public static void showToast(Context context, String str, int i, int i2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Toast toast = new Toast(context);
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(C1444R.layout.layout_toast, (ViewGroup) null);
        ((TextView) inflate.findViewById(C1444R.C1445id.toast_message)).setText(str);
        if (Build.MODEL != null && Build.MODEL.contains("TB2-X30F")) {
            toast.setGravity(17, 0, -50);
        } else {
            toast.setGravity(i2, 0, 0);
        }
        toast.setView(inflate);
        toast.setDuration(i);
        toast.show();
    }
}
