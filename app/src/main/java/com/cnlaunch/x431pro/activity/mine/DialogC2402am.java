package com.cnlaunch.x431pro.activity.mine;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.cnlaunch.x431pro.widget.p290a.MessageDialog;

/* compiled from: MineFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.am */
/* loaded from: classes.dex */
final class DialogC2402am extends MessageDialog {

    /* renamed from: a */
    final /* synthetic */ Bundle f13672a;

    /* renamed from: b */
    final /* synthetic */ MineFragment f13673b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialogC2402am(MineFragment mineFragment, Context context, Bundle bundle) {
        super(context);
        this.f13673b = mineFragment;
        this.f13672a = bundle;
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.BaseDialog
    /* renamed from: a */
    public final void mo4579a(View view, int i) {
        this.f13673b.replaceFragment(ConnectorActivateFragment.class.getName(), this.f13672a, false);
        super.mo4579a(view, i);
    }
}
