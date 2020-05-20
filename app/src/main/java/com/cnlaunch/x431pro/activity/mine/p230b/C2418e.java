package com.cnlaunch.x431pro.activity.mine.p230b;

import android.view.View;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.activity.diagnose.p220c.BottomActionBar;
import com.cnlaunch.x431pro.widget.button.IconRadioButton;
import com.ifoer.expedition.pro.R;

/* compiled from: DataStreamReplayFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.b.e */
/* loaded from: classes.dex */
final class C2418e extends BottomActionBar.AbstractC2090a {

    /* renamed from: c */
    final /* synthetic */ DataStreamReplayFragment f13785c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2418e(DataStreamReplayFragment dataStreamReplayFragment, View view) {
        super(view);
        this.f13785c = dataStreamReplayFragment;
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.BottomActionBar.AbstractC2090a
    /* renamed from: a */
    public final boolean mo6367a() {
        IconRadioButton iconRadioButton;
        IconRadioButton iconRadioButton2;
        IconRadioButton iconRadioButton3;
        if (this.f13785c.f13769o.contains("1")) {
            this.f13785c.f13750V = 1;
            iconRadioButton = this.f13785c.f13751W;
            iconRadioButton.setChecked(true);
            iconRadioButton2 = this.f13785c.f13752X;
            iconRadioButton2.setChecked(false);
            iconRadioButton3 = this.f13785c.f13753Y;
            iconRadioButton3.setChecked(false);
            return true;
        }
        NToast.m9450a(this.f13785c.getActivity(), (int) R.string.toast_need_one_item);
        return false;
    }
}
