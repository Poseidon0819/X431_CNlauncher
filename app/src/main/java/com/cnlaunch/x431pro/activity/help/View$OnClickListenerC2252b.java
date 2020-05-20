package com.cnlaunch.x431pro.activity.help;

import android.view.View;
import android.widget.TextView;
import com.ifoer.expedition.pro.R;

/* compiled from: FAQlistAdapter.java */
/* renamed from: com.cnlaunch.x431pro.activity.help.b */
/* loaded from: classes.dex */
final class View$OnClickListenerC2252b implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ TextView f12740a;

    /* renamed from: b */
    final /* synthetic */ TextView f12741b;

    /* renamed from: c */
    final /* synthetic */ String f12742c;

    /* renamed from: d */
    final /* synthetic */ FAQlistAdapter f12743d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2252b(FAQlistAdapter fAQlistAdapter, TextView textView, TextView textView2, String str) {
        this.f12743d = fAQlistAdapter;
        this.f12740a = textView;
        this.f12741b = textView2;
        this.f12742c = str;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.f12740a.isShown()) {
            this.f12743d.f12735g = "";
            this.f12740a.setVisibility(8);
            this.f12741b.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.close_item, 0);
        } else {
            this.f12743d.f12735g = this.f12742c;
            this.f12740a.setVisibility(0);
            this.f12741b.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.open_item, 0);
        }
        HelpOperatInfo.m6909a(HelpStringConstant.f12811l, this.f12743d.f12735g);
        if (this.f12743d.f12737i == null) {
            FAQlistAdapter fAQlistAdapter = this.f12743d;
            fAQlistAdapter.f12737i = this.f12741b;
            fAQlistAdapter.f12738j = this.f12740a;
        } else if (this.f12743d.f12737i != this.f12741b) {
            this.f12743d.f12737i.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.close_item, 0);
            this.f12743d.f12738j.setVisibility(8);
            FAQlistAdapter fAQlistAdapter2 = this.f12743d;
            fAQlistAdapter2.f12737i = this.f12741b;
            fAQlistAdapter2.f12738j = this.f12740a;
        }
    }
}
