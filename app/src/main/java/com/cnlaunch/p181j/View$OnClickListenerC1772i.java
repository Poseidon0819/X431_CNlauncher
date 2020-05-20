package com.cnlaunch.p181j;

import android.view.View;
import com.cnlaunch.diagnosemodule.wiget.NToast;
import com.cnlaunch.x431pro.activity.MainActivity;
import com.ifoer.expedition.pro.R;

/* compiled from: DealDiagMessageHandler.java */
/* renamed from: com.cnlaunch.j.i */
/* loaded from: classes.dex */
public final class View$OnClickListenerC1772i implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ DealDiagMessageHandler f9446a;

    public View$OnClickListenerC1772i(DealDiagMessageHandler dealDiagMessageHandler) {
        this.f9446a = dealDiagMessageHandler;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String str;
        this.f9446a.f9431g.dismiss();
        if (MainActivity.m7907a()) {
            NToast.longToast(this.f9446a.f9429e, (int) R.string.tip_must_stop_diag_before, 17);
            this.f9446a.f9430f.m8681c();
            return;
        }
        DealDiagMessageHandler m8673a = DealDiagMessageHandler.m8673a();
        str = this.f9446a.f9432h;
        m8673a.m8664b(str);
    }
}
