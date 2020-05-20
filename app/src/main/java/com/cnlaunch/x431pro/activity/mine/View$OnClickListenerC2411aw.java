package com.cnlaunch.x431pro.activity.mine;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.cnlaunch.x431pro.module.p258f.p260b.UserOrderDTO;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.widget.p290a.MessageDialog;
import com.ifoer.expedition.pro.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MyOrderFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.aw */
/* loaded from: classes.dex */
public final class View$OnClickListenerC2411aw implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ UserOrderDTO f13709a;

    /* renamed from: b */
    final /* synthetic */ MyOrderFragment f13710b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2411aw(MyOrderFragment myOrderFragment, UserOrderDTO userOrderDTO) {
        this.f13710b = myOrderFragment;
        this.f13709a = userOrderDTO;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Context context;
        if (!C2744aa.m5166c()) {
            context = this.f13710b.mContext;
            MessageDialog messageDialog = new MessageDialog(context);
            messageDialog.setContentView(R.layout.select_payment_type);
            messageDialog.setCanceledOnTouchOutside(true);
            ((TextView) messageDialog.findViewById(R.id.paypal)).setOnClickListener(new View$OnClickListenerC2412ax(this, messageDialog));
            ((TextView) messageDialog.findViewById(R.id.credit_card)).setOnClickListener(new View$OnClickListenerC2413ay(this, messageDialog));
            messageDialog.show();
        } else if (C2744aa.m5166c()) {
            MyOrderFragment.m6435a(this.f13710b, this.f13709a.getOrdersn());
        }
    }
}
