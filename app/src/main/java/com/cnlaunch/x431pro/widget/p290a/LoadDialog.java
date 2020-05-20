package com.cnlaunch.x431pro.widget.p290a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;
import com.cnlaunch.x431pro.utils.C2787z;
import com.cnlaunch.x431pro.widget.progress.ProgressBarCircularIndeterminate;
import com.ifoer.expedition.pro.R;

/* renamed from: com.cnlaunch.x431pro.widget.a.ay */
/* loaded from: classes.dex */
public final class LoadDialog extends Dialog {

    /* renamed from: a */
    private static LoadDialog f16250a;

    private LoadDialog(Context context, boolean z, String str) {
        super(context);
        getContext().setTheme(16974129);
        setContentView(R.layout.layout_dialog_loading);
        setCancelable(!z);
        TextView textView = (TextView) findViewById(16908299);
        if (!C2787z.m4821a(str)) {
            textView.setText(str);
        }
        getWindow().getDecorView().getBackground().setAlpha(0);
    }

    private LoadDialog(Context context, String str) {
        super(context);
        getContext().setTheme(16974129);
        setContentView(R.layout.layout_dialog_loading_without_title);
        setCancelable(true);
        ProgressBarCircularIndeterminate progressBarCircularIndeterminate = (ProgressBarCircularIndeterminate) findViewById(R.id.loading_progress);
        if (progressBarCircularIndeterminate != null) {
            progressBarCircularIndeterminate.setBackgroundColor(Color.parseColor("#FFFFFF"));
        }
        TextView textView = (TextView) findViewById(R.id.f24501message);
        if (!C2787z.m4821a(str)) {
            textView.setText(str);
        }
        getWindow().getDecorView().getBackground().setAlpha(0);
    }

    private LoadDialog(Context context, String str, DialogInterface.OnCancelListener onCancelListener) {
        super(context);
        getContext().setTheme(16974129);
        setContentView(R.layout.layout_dialog_loading);
        setCancelable(true);
        TextView textView = (TextView) findViewById(16908299);
        if (!C2787z.m4821a(str)) {
            textView.setText(str);
        }
        setOnCancelListener(onCancelListener);
        getWindow().getDecorView().getBackground().setAlpha(0);
    }

    @Override // android.app.Dialog
    protected final void onCreate(Bundle bundle) {
        setCanceledOnTouchOutside(false);
    }

    /* renamed from: a */
    public static void m4686a(Context context) {
        m4682a(context, (String) null, false);
    }

    /* renamed from: a */
    public static void m4684a(Context context, String str) {
        m4682a(context, str, false);
    }

    /* renamed from: b */
    public static void m4680b(Context context, String str) {
        m4679c(context, str);
    }

    /* renamed from: c */
    public static void m4679c(Context context, String str) {
        if (context == null) {
            return;
        }
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            f16250a = null;
            return;
        }
        LoadDialog loadDialog = f16250a;
        if (loadDialog == null || !loadDialog.isShowing()) {
            LoadDialog loadDialog2 = new LoadDialog(context, str);
            f16250a = loadDialog2;
            loadDialog2.show();
        }
    }

    /* renamed from: a */
    public static void m4685a(Context context, int i) {
        m4682a(context, context.getResources().getString(i), false);
    }

    /* renamed from: a */
    public static void m4682a(Context context, String str, boolean z) {
        if (context == null) {
            return;
        }
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            f16250a = null;
            return;
        }
        LoadDialog loadDialog = f16250a;
        if (loadDialog == null || !loadDialog.isShowing()) {
            LoadDialog loadDialog2 = new LoadDialog(context, z, str);
            f16250a = loadDialog2;
            loadDialog2.show();
        }
    }

    /* renamed from: a */
    public static void m4683a(Context context, String str, DialogInterface.OnCancelListener onCancelListener) {
        if (context == null) {
            return;
        }
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            f16250a = null;
            return;
        }
        LoadDialog loadDialog = f16250a;
        if (loadDialog == null || !loadDialog.isShowing()) {
            LoadDialog loadDialog2 = new LoadDialog(context, str, onCancelListener);
            f16250a = loadDialog2;
            loadDialog2.show();
        }
    }

    /* renamed from: b */
    public static void m4681b(Context context) {
        try {
            if (context == null) {
                f16250a = null;
            } else if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
                f16250a = null;
            } else if (f16250a == null || !f16250a.isShowing()) {
            } else {
                Context context2 = f16250a.getContext();
                if (context2 != null && (context2 instanceof Activity) && ((Activity) context2).isFinishing()) {
                    f16250a = null;
                    return;
                }
                f16250a.dismiss();
                f16250a = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            f16250a = null;
        }
    }
}
