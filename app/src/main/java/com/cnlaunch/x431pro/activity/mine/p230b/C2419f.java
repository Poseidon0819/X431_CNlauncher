package com.cnlaunch.x431pro.activity.mine.p230b;

import android.view.View;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.activity.diagnose.p220c.BottomActionBar;
import com.cnlaunch.x431pro.widget.button.IconRadioButton;
import com.ifoer.expedition.pro.R;

/* compiled from: DataStreamReplayFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.b.f */
/* loaded from: classes.dex */
final class C2419f extends BottomActionBar.AbstractC2090a {

    /* renamed from: c */
    final /* synthetic */ DataStreamReplayFragment f13786c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2419f(DataStreamReplayFragment dataStreamReplayFragment, View view) {
        super(view);
        this.f13786c = dataStreamReplayFragment;
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.BottomActionBar.AbstractC2090a
    /* renamed from: a */
    public final boolean mo6367a() {
        IconRadioButton iconRadioButton;
        IconRadioButton iconRadioButton2;
        IconRadioButton iconRadioButton3;
        if (this.f13786c.f13769o.contains("1")) {
            this.f13786c.f13750V = 2;
            iconRadioButton = this.f13786c.f13751W;
            iconRadioButton.setChecked(false);
            iconRadioButton2 = this.f13786c.f13752X;
            iconRadioButton2.setChecked(true);
            iconRadioButton3 = this.f13786c.f13753Y;
            iconRadioButton3.setChecked(false);
            return true;
        }
        NToast.m9450a(this.f13786c.getActivity(), (int) R.string.toast_need_one_item);
        return false;
    }
}
