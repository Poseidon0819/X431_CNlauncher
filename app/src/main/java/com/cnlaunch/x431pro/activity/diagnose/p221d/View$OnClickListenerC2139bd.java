package com.cnlaunch.x431pro.activity.diagnose.p221d;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.cnlaunch.diagnosemodule.bean.BasicButtonBean;
import com.cnlaunch.x431pro.widget.p290a.SpinnerPopupWindow;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MulitInputFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.bd */
/* loaded from: classes.dex */
public final class View$OnClickListenerC2139bd implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ArrayList f12085a;

    /* renamed from: b */
    final /* synthetic */ TextView f12086b;

    /* renamed from: c */
    final /* synthetic */ MulitInputFragment f12087c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2139bd(MulitInputFragment mulitInputFragment, ArrayList arrayList, TextView textView) {
        this.f12087c = mulitInputFragment;
        this.f12085a = arrayList;
        this.f12086b = textView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        SpinnerPopupWindow spinnerPopupWindow;
        SpinnerPopupWindow spinnerPopupWindow2;
        SpinnerPopupWindow spinnerPopupWindow3;
        SpinnerPopupWindow spinnerPopupWindow4;
        Context context;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.f12085a.size(); i++) {
            arrayList.add(((BasicButtonBean) this.f12085a.get(i)).getTitle());
        }
        spinnerPopupWindow = this.f12087c.f12082q;
        if (spinnerPopupWindow == null) {
            MulitInputFragment mulitInputFragment = this.f12087c;
            context = mulitInputFragment.f12074b;
            mulitInputFragment.f12082q = new SpinnerPopupWindow(context);
        }
        spinnerPopupWindow2 = this.f12087c.f12082q;
        spinnerPopupWindow2.f16384c = this.f12086b.getWidth();
        spinnerPopupWindow3 = this.f12087c.f12082q;
        spinnerPopupWindow3.f16383b = new C2140be(this, arrayList);
        spinnerPopupWindow4 = this.f12087c.f12082q;
        spinnerPopupWindow4.m4581b(this.f12086b, arrayList);
    }
}
