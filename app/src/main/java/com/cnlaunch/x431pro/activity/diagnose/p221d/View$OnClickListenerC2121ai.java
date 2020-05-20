package com.cnlaunch.x431pro.activity.diagnose.p221d;

import android.view.View;
import com.cnlaunch.x431pro.widget.button.IconButton;
import com.cnlaunch.x431pro.widget.button.IconRadioButton;
import com.ifoer.expedition.pro.R;

/* compiled from: DataStreamShowFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.ai */
/* loaded from: classes.dex */
final class View$OnClickListenerC2121ai implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ DataStreamShowFragment f11976a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2121ai(DataStreamShowFragment dataStreamShowFragment) {
        this.f11976a = dataStreamShowFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        IconButton iconButton;
        IconRadioButton iconRadioButton;
        IconButton iconButton2;
        iconButton = this.f11976a.f11893H;
        iconButton.setEnabled(true);
        iconRadioButton = this.f11976a.f11956u;
        iconRadioButton.setEnabled(true);
        iconButton2 = this.f11976a.f11893H;
        iconButton2.setText(R.string.btn_record);
        this.f11976a.m7278i();
        CombinedGraphFragment.m7110a(false);
        GraphGridFragment.m7230c(false);
    }
}
