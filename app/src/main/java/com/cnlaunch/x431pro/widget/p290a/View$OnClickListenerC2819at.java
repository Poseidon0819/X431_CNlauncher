package com.cnlaunch.x431pro.widget.p290a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.ifoer.expedition.pro.R;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InputReportInfoDialog.java */
/* renamed from: com.cnlaunch.x431pro.widget.a.at */
/* loaded from: classes.dex */
public final class View$OnClickListenerC2819at implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ InputReportInfoDialog f16193a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2819at(InputReportInfoDialog inputReportInfoDialog) {
        this.f16193a = inputReportInfoDialog;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Context context;
        TextView textView;
        Context context2;
        TextView textView2;
        TextView textView3;
        List<String> list;
        InputReportInfoDialog inputReportInfoDialog = this.f16193a;
        context = inputReportInfoDialog.f16179m;
        inputReportInfoDialog.f16174h = new SpinnerPopupWindow(context);
        SpinnerPopupWindow spinnerPopupWindow = this.f16193a.f16174h;
        textView = this.f16193a.f16184r;
        spinnerPopupWindow.f16384c = textView.getWidth();
        context2 = this.f16193a.f16179m;
        Drawable drawable = context2.getResources().getDrawable(R.drawable.arrow_top);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        textView2 = this.f16193a.f16184r;
        textView2.setCompoundDrawables(null, null, drawable, null);
        this.f16193a.f16174h.f16383b = new C2820au(this);
        SpinnerPopupWindow spinnerPopupWindow2 = this.f16193a.f16174h;
        textView3 = this.f16193a.f16184r;
        list = this.f16193a.f16169F;
        spinnerPopupWindow2.m4582a(textView3, list);
    }
}
