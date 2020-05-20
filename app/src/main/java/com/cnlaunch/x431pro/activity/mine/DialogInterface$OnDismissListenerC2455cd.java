package com.cnlaunch.x431pro.activity.mine;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.cnlaunch.x431pro.activity.MainActivity;

/* compiled from: PinCardPayFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.cd */
/* loaded from: classes.dex */
final class DialogInterface$OnDismissListenerC2455cd implements DialogInterface.OnDismissListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC2454cc f14030a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DialogInterface$OnDismissListenerC2455cd(HandlerC2454cc handlerC2454cc) {
        this.f14030a = handlerC2454cc;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        Context context;
        MainActivity mainActivity;
        context = this.f14030a.f14029a.mContext;
        context.sendBroadcast(new Intent("BROADCAST_ACTION_PIN_CARD_PAY_SUCCESSFULLY"));
        mainActivity = this.f14030a.f14029a.mainActivity;
        if (mainActivity == null) {
            this.f14030a.f14029a.getActivity().finish();
            return;
        }
        this.f14030a.f14029a.getFragmentManager().popBackStack();
        this.f14030a.f14029a.getFragmentManager().popBackStack();
    }
}
