package com.cnlaunch.x431pro.activity.mine;

import android.content.Context;
import android.view.View;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.ifoer.expedition.pro.R;

/* compiled from: PayTypeFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.bo */
/* loaded from: classes.dex */
final class View$OnClickListenerC2441bo implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PayTypeFragment f13948a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2441bo(PayTypeFragment payTypeFragment) {
        this.f13948a = payTypeFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Context context;
        context = this.f13948a.mContext;
        LoadDialog.m4680b(context, this.f13948a.getString(R.string.refresh_txt));
        this.f13948a.request(1003);
    }
}
