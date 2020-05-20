package com.cnlaunch.x431pro.activity.diagnose.p221d;

import android.view.View;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.x431pro.activity.diagnose.p220c.BottomActionBar;
import com.cnlaunch.x431pro.widget.button.IconButton;

/* compiled from: ActiveTestFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.d */
/* loaded from: classes.dex */
final class C2170d extends BottomActionBar.AbstractC2090a {

    /* renamed from: c */
    final /* synthetic */ ActiveTestFragment f12325c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2170d(ActiveTestFragment activeTestFragment, View view) {
        super(view);
        this.f12325c = activeTestFragment;
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.BottomActionBar.AbstractC2090a
    /* renamed from: a */
    public final boolean mo6367a() {
        IconButton iconButton;
        IconButton iconButton2;
        IconButton iconButton3;
        IconButton iconButton4;
        IconButton iconButton5;
        if (this.f12325c.f11864m.equals(DiagnoseConstants.UI_TYPE_FIXED_ITEM_ACTIVE_TEST)) {
            iconButton2 = this.f12325c.f11870s;
            iconButton2.setVisibility(8);
            iconButton3 = this.f12325c.f11869r;
            iconButton3.setVisibility(0);
            iconButton4 = this.f12325c.f11868q;
            iconButton4.setVisibility(8);
            iconButton5 = this.f12325c.f11871t;
            iconButton5.setVisibility(8);
        }
        iconButton = this.f12325c.f11868q;
        iconButton.setVisibility(8);
        ActiveTestFragment.m7318f(this.f12325c);
        return true;
    }
}
