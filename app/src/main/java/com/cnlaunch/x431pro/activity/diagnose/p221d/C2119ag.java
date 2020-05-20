package com.cnlaunch.x431pro.activity.diagnose.p221d;

import android.view.View;
import android.widget.LinearLayout;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.activity.diagnose.p220c.BottomActionBar;
import com.cnlaunch.x431pro.p210a.DataStreamConfiguration;
import com.cnlaunch.x431pro.widget.button.IconButton;
import com.cnlaunch.x431pro.widget.button.IconRadioButton;
import com.ifoer.expedition.pro.R;

/* compiled from: DataStreamShowFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.ag */
/* loaded from: classes.dex */
final class C2119ag extends BottomActionBar.AbstractC2090a {

    /* renamed from: c */
    final /* synthetic */ DataStreamShowFragment f11974c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2119ag(DataStreamShowFragment dataStreamShowFragment, View view) {
        super(view);
        this.f11974c = dataStreamShowFragment;
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.BottomActionBar.AbstractC2090a
    /* renamed from: a */
    public final boolean mo6367a() {
        IconButton iconButton;
        IconButton iconButton2;
        IconButton iconButton3;
        IconButton iconButton4;
        IconButton iconButton5;
        View view;
        IconButton iconButton6;
        IconButton iconButton7;
        IconButton iconButton8;
        IconRadioButton iconRadioButton;
        LinearLayout linearLayout;
        if (this.f11974c.f11904S.contains("1")) {
            this.f11974c.m7286b("graph_multiple");
            this.f11974c.f11932aj = 1;
            this.f11974c.f12358e.setVisibility(0);
            iconButton = this.f11974c.f11891F;
            iconButton.setVisibility(8);
            iconButton2 = this.f11974c.f11892G;
            iconButton2.setVisibility(DataStreamConfiguration.m7955d() == 1 ? 0 : 8);
            iconButton3 = this.f11974c.f11894I;
            iconButton3.setVisibility(0);
            iconButton4 = this.f11974c.f11887B;
            iconButton4.setVisibility(DataStreamConfiguration.m7955d() == 1 ? 8 : 0);
            iconButton5 = this.f11974c.f11895J;
            iconButton5.setVisibility(8);
            view = this.f11974c.f11899N;
            view.setVisibility(0);
            iconButton6 = this.f11974c.f11889D;
            iconButton6.setVisibility(8);
            iconButton7 = this.f11974c.f11888C;
            iconButton7.setVisibility(8);
            iconButton8 = this.f11974c.f11888C;
            iconButton8.setEnabled(false);
            iconRadioButton = this.f11974c.f11956u;
            iconRadioButton.setVisibility(8);
            if (this.f11974c.f11900O.equals(DiagnoseConstants.UI_TYPE_VW_DATASTREAM)) {
                linearLayout = this.f11974c.f11898M;
                linearLayout.setVisibility(0);
            }
            return true;
        }
        NToast.m9444c(this.f11974c.getActivity(), (int) R.string.toast_need_one_item);
        return false;
    }
}
