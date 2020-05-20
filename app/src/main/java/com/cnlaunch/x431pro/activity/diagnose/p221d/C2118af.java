package com.cnlaunch.x431pro.activity.diagnose.p221d;

import android.view.View;
import android.widget.LinearLayout;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.activity.diagnose.p220c.BottomActionBar;
import com.cnlaunch.x431pro.widget.button.IconButton;
import com.cnlaunch.x431pro.widget.button.IconRadioButton;
import com.ifoer.expedition.pro.R;

/* compiled from: DataStreamShowFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.af */
/* loaded from: classes.dex */
final class C2118af extends BottomActionBar.AbstractC2090a {

    /* renamed from: c */
    final /* synthetic */ DataStreamShowFragment f11973c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2118af(DataStreamShowFragment dataStreamShowFragment, View view) {
        super(view);
        this.f11973c = dataStreamShowFragment;
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.BottomActionBar.AbstractC2090a
    /* renamed from: a */
    public final boolean mo6367a() {
        IconButton iconButton;
        IconButton iconButton2;
        IconButton iconButton3;
        IconButton iconButton4;
        IconButton iconButton5;
        IconButton iconButton6;
        View view;
        IconButton iconButton7;
        IconRadioButton iconRadioButton;
        LinearLayout linearLayout;
        if (this.f11973c.f11904S.contains("1")) {
            this.f11973c.m7286b("graph_combine");
            this.f11973c.f12358e.setVisibility(0);
            this.f11973c.f11932aj = 2;
            iconButton = this.f11973c.f11888C;
            iconButton.setVisibility(8);
            iconButton2 = this.f11973c.f11887B;
            iconButton2.setVisibility(8);
            iconButton3 = this.f11973c.f11895J;
            iconButton3.setVisibility(8);
            iconButton4 = this.f11973c.f11891F;
            iconButton4.setVisibility(0);
            iconButton5 = this.f11973c.f11892G;
            iconButton5.setVisibility(8);
            iconButton6 = this.f11973c.f11894I;
            iconButton6.setVisibility(0);
            view = this.f11973c.f11899N;
            view.setVisibility(0);
            iconButton7 = this.f11973c.f11889D;
            iconButton7.setVisibility(8);
            iconRadioButton = this.f11973c.f11956u;
            iconRadioButton.setVisibility(8);
            if (this.f11973c.f11900O.equals(DiagnoseConstants.UI_TYPE_VW_DATASTREAM)) {
                linearLayout = this.f11973c.f11898M;
                linearLayout.setVisibility(0);
                return true;
            }
            return true;
        }
        NToast.m9444c(this.f11973c.getActivity(), (int) R.string.toast_need_one_item);
        return false;
    }
}
