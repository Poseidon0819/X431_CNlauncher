package com.unionpay.mobile.android.nocard.views;

import android.view.View;
import com.unionpay.mobile.android.nocard.views.C4223bd;
import com.unionpay.mobile.android.utils.C4394o;

/* renamed from: com.unionpay.mobile.android.nocard.views.bg */
/* loaded from: classes2.dex */
final class View$OnClickListenerC4227bg implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f22623a;

    /* renamed from: b */
    final /* synthetic */ String f22624b;

    /* renamed from: c */
    final /* synthetic */ String f22625c;

    /* renamed from: d */
    final /* synthetic */ C4223bd.C4224a f22626d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC4227bg(C4223bd.C4224a c4224a, int i, String str, String str2) {
        this.f22626d = c4224a;
        this.f22623a = i;
        this.f22624b = str;
        this.f22625c = str2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String[] strArr = C4394o.f23206i;
        Object[] objArr = {Integer.valueOf(this.f22623a), this.f22624b};
        C4223bd.this.m1420a("", this.f22625c);
    }
}
