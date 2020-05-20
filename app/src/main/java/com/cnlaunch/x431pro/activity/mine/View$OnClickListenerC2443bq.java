package com.cnlaunch.x431pro.activity.mine;

import android.content.Context;
import android.view.View;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.ifoer.expedition.pro.R;

/* compiled from: PayTypeFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.bq */
/* loaded from: classes.dex */
final class View$OnClickListenerC2443bq implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PayTypeFragment f13950a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2443bq(PayTypeFragment payTypeFragment) {
        this.f13950a = payTypeFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Context context;
        context = this.f13950a.mContext;
        LoadDialog.m4680b(context, this.f13950a.getString(R.string.string_loading));
        this.f13950a.request(1004);
    }
}
