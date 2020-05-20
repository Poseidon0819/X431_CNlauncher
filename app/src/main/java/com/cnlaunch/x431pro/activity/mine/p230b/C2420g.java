package com.cnlaunch.x431pro.activity.mine.p230b;

import android.view.View;
import com.cnlaunch.x431pro.activity.diagnose.p220c.BottomActionBar;
import com.cnlaunch.x431pro.widget.button.IconRadioButton;

/* compiled from: DataStreamReplayFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.b.g */
/* loaded from: classes.dex */
final class C2420g extends BottomActionBar.AbstractC2090a {

    /* renamed from: c */
    final /* synthetic */ DataStreamReplayFragment f13787c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2420g(DataStreamReplayFragment dataStreamReplayFragment, View view) {
        super(view);
        this.f13787c = dataStreamReplayFragment;
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.BottomActionBar.AbstractC2090a
    /* renamed from: a */
    public final boolean mo6367a() {
        IconRadioButton iconRadioButton;
        IconRadioButton iconRadioButton2;
        IconRadioButton iconRadioButton3;
        this.f13787c.f13750V = 0;
        iconRadioButton = this.f13787c.f13751W;
        iconRadioButton.setChecked(false);
        iconRadioButton2 = this.f13787c.f13752X;
        iconRadioButton2.setChecked(false);
        iconRadioButton3 = this.f13787c.f13753Y;
        iconRadioButton3.setChecked(true);
        return true;
    }
}
