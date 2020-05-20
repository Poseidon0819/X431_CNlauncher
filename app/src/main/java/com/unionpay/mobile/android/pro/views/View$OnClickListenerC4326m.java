package com.unionpay.mobile.android.pro.views;

import android.nfc.NfcAdapter;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.unionpay.mobile.android.widgets.C4449ay;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.pro.views.m */
/* loaded from: classes2.dex */
public final class View$OnClickListenerC4326m implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ boolean f22975a;

    /* renamed from: b */
    final /* synthetic */ C4324k f22976b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC4326m(C4324k c4324k, boolean z) {
        this.f22976b = c4324k;
        this.f22975a = z;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        FrameLayout frameLayout;
        LinearLayout linearLayout;
        C4449ay c4449ay;
        C4449ay c4449ay2;
        NfcAdapter nfcAdapter;
        this.f22976b.m1407i();
        if (this.f22975a) {
            this.f22976b.m1406j();
            return;
        }
        C4324k.m1151B(this.f22976b);
        frameLayout = this.f22976b.f22956S;
        frameLayout.removeAllViews();
        linearLayout = this.f22976b.f22938A;
        linearLayout.removeAllViews();
        c4449ay = this.f22976b.f22943F;
        c4449ay.setBackgroundColor(-16686660);
        c4449ay2 = this.f22976b.f22943F;
        c4449ay2.m682a(0);
        this.f22976b.mo1072c();
        C4324k c4324k = this.f22976b;
        nfcAdapter = c4324k.f22955R;
        c4324k.m1146a(nfcAdapter);
    }
}
