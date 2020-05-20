package com.cnlaunch.golo3.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cnlaunch.golo3.p165g.GoloLog;
import com.cnlaunch.p132e.p133a.C1464a;

/* renamed from: com.cnlaunch.golo3.view.a */
/* loaded from: classes.dex */
public class GoloProgressDialog {

    /* renamed from: a */
    public static Dialog f8518a;

    /* renamed from: a */
    public static void m9105a(Context context, String str) {
        if (((Activity) context).isFinishing()) {
            return;
        }
        Dialog dialog = f8518a;
        if (dialog != null && dialog.isShowing()) {
            try {
                f8518a.dismiss();
            } catch (Exception unused) {
            }
            f8518a = null;
        }
        Dialog dialog2 = new Dialog(context, C1464a.C1471g.dialog_normal_Dim);
        f8518a = dialog2;
        dialog2.show();
        View inflate = LayoutInflater.from(context).inflate(C1464a.C1469e.loading_layout, (ViewGroup) null);
        f8518a.setContentView(inflate);
        f8518a.setCanceledOnTouchOutside(false);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ((TextView) inflate.findViewById(C1464a.C1468d.tv_progress)).setText(str);
    }

    /* renamed from: a */
    public static boolean m9106a() {
        Dialog dialog = f8518a;
        if (dialog == null || !dialog.isShowing()) {
            return false;
        }
        try {
            f8518a.dismiss();
            return true;
        } catch (Exception e) {
            String simpleName = GoloProgressDialog.class.getSimpleName();
            GoloLog.m9130b(simpleName, "dismiss this progressDialog Error." + e.getMessage());
            return false;
        }
    }
}
