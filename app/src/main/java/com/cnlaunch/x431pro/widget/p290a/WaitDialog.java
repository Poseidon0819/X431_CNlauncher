package com.cnlaunch.x431pro.widget.p290a;

import android.app.Dialog;
import android.content.Context;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.cnlaunch.x431pro.utils.C2787z;
import com.cnlaunch.x431pro.widget.progress.ProgressBarCircularIndeterminate;
import com.ifoer.expedition.pro.R;

/* renamed from: com.cnlaunch.x431pro.widget.a.cy */
/* loaded from: classes.dex */
public class WaitDialog extends Dialog {

    /* renamed from: b */
    public ProgressBar f16396b;

    public WaitDialog(Context context, String str) {
        super(context);
        getContext().setTheme(16974129);
        setContentView(R.layout.layout_dialog_loading);
        TextView textView = (TextView) findViewById(16908299);
        if (!C2787z.m4821a(str)) {
            textView.setText(str);
        }
        getWindow().getDecorView().getBackground().setAlpha(0);
    }

    public WaitDialog(Context context, int i) {
        super(context);
        getContext().setTheme(16974129);
        setContentView(R.layout.layout_dialog_loading);
        ((TextView) findViewById(16908299)).setText(i);
        getWindow().getDecorView().getBackground().setAlpha(0);
    }

    public WaitDialog(Context context, boolean z, String str) {
        super(context);
        getContext().setTheme(16974129);
        setContentView(R.layout.layout_dialog_loading);
        setCancelable(z);
        ((TextView) findViewById(16908299)).setText(str);
        this.f16396b = (ProgressBar) findViewById(R.id.horizontal_progress);
        this.f16396b.setVisibility(0);
        ((ProgressBarCircularIndeterminate) findViewById(R.id.loading_progress)).setVisibility(8);
        getWindow().getDecorView().getBackground().setAlpha(0);
    }
}
