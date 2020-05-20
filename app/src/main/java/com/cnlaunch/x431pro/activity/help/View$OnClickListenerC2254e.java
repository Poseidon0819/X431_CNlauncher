package com.cnlaunch.x431pro.activity.help;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ifoer.expedition.pro.R;

/* compiled from: FunctionListAdapter.java */
/* renamed from: com.cnlaunch.x431pro.activity.help.e */
/* loaded from: classes.dex */
final class View$OnClickListenerC2254e implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ LinearLayout f12755a;

    /* renamed from: b */
    final /* synthetic */ TextView f12756b;

    /* renamed from: c */
    final /* synthetic */ String f12757c;

    /* renamed from: d */
    final /* synthetic */ FunctionListAdapter f12758d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2254e(FunctionListAdapter functionListAdapter, LinearLayout linearLayout, TextView textView, String str) {
        this.f12758d = functionListAdapter;
        this.f12755a = linearLayout;
        this.f12756b = textView;
        this.f12757c = str;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.f12755a.isShown()) {
            this.f12758d.f12750g = "";
            HelpOperatInfo.m6909a(HelpStringConstant.f12812m, this.f12758d.f12750g);
            this.f12755a.setVisibility(8);
            this.f12756b.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.close_item, 0);
        } else {
            this.f12758d.f12750g = this.f12757c;
            HelpOperatInfo.m6909a(HelpStringConstant.f12812m, this.f12758d.f12750g);
            this.f12755a.setVisibility(0);
            this.f12756b.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.open_item, 0);
        }
        if (this.f12758d.f12745b == null) {
            FunctionListAdapter functionListAdapter = this.f12758d;
            functionListAdapter.f12745b = this.f12755a;
            functionListAdapter.f12746c = this.f12756b;
        } else if (this.f12758d.f12745b != this.f12755a) {
            this.f12758d.f12745b.setVisibility(8);
            this.f12758d.f12746c.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.close_item, 0);
            FunctionListAdapter functionListAdapter2 = this.f12758d;
            functionListAdapter2.f12745b = this.f12755a;
            functionListAdapter2.f12746c = this.f12756b;
        }
    }
}
