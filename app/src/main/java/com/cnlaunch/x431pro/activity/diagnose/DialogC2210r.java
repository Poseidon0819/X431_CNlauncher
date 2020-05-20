package com.cnlaunch.x431pro.activity.diagnose;

import android.content.Context;
import android.view.View;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.x431pro.activity.MainActivity;
import com.cnlaunch.x431pro.widget.p290a.MessageDialog;
import com.ifoer.expedition.pro.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CarIconFragmentForAll.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.r */
/* loaded from: classes.dex */
public final class DialogC2210r extends MessageDialog {

    /* renamed from: a */
    final /* synthetic */ CarIconFragmentForAll f12484a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialogC2210r(CarIconFragmentForAll carIconFragmentForAll, Context context) {
        super(context);
        this.f12484a = carIconFragmentForAll;
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.BaseDialog
    /* renamed from: a */
    public final void mo4579a(View view, int i) {
        Context context;
        context = this.f12484a.mContext;
        PreferencesManager.m9595a(context).m9589a("remind_update_time", System.currentTimeMillis());
        super.mo4579a(view, i);
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.BaseDialog
    /* renamed from: b */
    public final void mo4577b(View view, int i) {
        Context context;
        MainActivity mainActivity;
        MainActivity mainActivity2;
        context = this.f12484a.mContext;
        PreferencesManager.m9595a(context).m9589a("remind_update_time", System.currentTimeMillis());
        mainActivity = this.f12484a.mainActivity;
        if (mainActivity != null) {
            mainActivity2 = this.f12484a.mainActivity;
            mainActivity2.m7894b(R.id.btn_upgrade);
        }
        super.mo4577b(view, i);
    }
}
