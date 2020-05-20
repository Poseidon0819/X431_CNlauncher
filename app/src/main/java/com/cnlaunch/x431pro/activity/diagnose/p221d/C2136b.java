package com.cnlaunch.x431pro.activity.diagnose.p221d;

import android.view.View;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.activity.diagnose.p220c.BottomActionBar;
import com.cnlaunch.x431pro.widget.button.IconButton;
import com.ifoer.expedition.pro.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ActiveTestFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.b */
/* loaded from: classes.dex */
public final class C2136b extends BottomActionBar.AbstractC2090a {

    /* renamed from: c */
    final /* synthetic */ ActiveTestFragment f12069c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2136b(ActiveTestFragment activeTestFragment, View view) {
        super(view);
        this.f12069c = activeTestFragment;
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.BottomActionBar.AbstractC2090a
    /* renamed from: a */
    public final boolean mo6367a() {
        IconButton iconButton;
        IconButton iconButton2;
        IconButton iconButton3;
        IconButton iconButton4;
        if (this.f12069c.f11863l.contains("1")) {
            iconButton = this.f12069c.f11870s;
            iconButton.setVisibility(8);
            iconButton2 = this.f12069c.f11869r;
            iconButton2.setVisibility(0);
            iconButton3 = this.f12069c.f11868q;
            iconButton3.setVisibility(0);
            iconButton4 = this.f12069c.f11871t;
            iconButton4.setVisibility(8);
            ActiveTestFragment.m7318f(this.f12069c);
            return true;
        }
        NToast.m9444c(this.f12069c.getActivity(), (int) R.string.toast_need_one_item);
        return false;
    }
}
