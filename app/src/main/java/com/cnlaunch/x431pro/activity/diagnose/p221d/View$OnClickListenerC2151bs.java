package com.cnlaunch.x431pro.activity.diagnose.p221d;

import android.view.View;
import com.cnlaunch.x431pro.widget.button.IconButton;
import com.ifoer.expedition.pro.R;

/* compiled from: SpeciaDatastreamFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.bs */
/* loaded from: classes.dex */
final class View$OnClickListenerC2151bs implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SpeciaDatastreamFragment f12185a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2151bs(SpeciaDatastreamFragment speciaDatastreamFragment) {
        this.f12185a = speciaDatastreamFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        IconButton iconButton;
        IconButton iconButton2;
        iconButton = this.f12185a.f12177v;
        iconButton.setEnabled(true);
        iconButton2 = this.f12185a.f12177v;
        iconButton2.setText(R.string.btn_record);
        this.f12185a.m7184h();
    }
}
