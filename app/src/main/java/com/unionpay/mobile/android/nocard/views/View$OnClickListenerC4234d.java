package com.unionpay.mobile.android.nocard.views;

import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.nocard.views.d */
/* loaded from: classes2.dex */
public final class View$OnClickListenerC4234d implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ boolean f22637a;

    /* renamed from: b */
    final /* synthetic */ AbstractC4219b f22638b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC4234d(AbstractC4219b abstractC4219b, boolean z) {
        this.f22638b = abstractC4219b;
        this.f22637a = z;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f22638b.m1407i();
        if (this.f22637a) {
            this.f22638b.m1406j();
        }
    }
}
