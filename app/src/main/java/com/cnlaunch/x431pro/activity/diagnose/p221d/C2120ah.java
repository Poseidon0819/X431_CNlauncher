package com.cnlaunch.x431pro.activity.diagnose.p221d;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p130d.p131a.LangManager;
import com.cnlaunch.x431pro.activity.diagnose.p220c.BottomActionBar;
import com.cnlaunch.x431pro.widget.button.IconButton;
import com.cnlaunch.x431pro.widget.button.IconRadioButton;

/* compiled from: DataStreamShowFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.ah */
/* loaded from: classes.dex */
final class C2120ah extends BottomActionBar.AbstractC2090a {

    /* renamed from: c */
    final /* synthetic */ DataStreamShowFragment f11975c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2120ah(DataStreamShowFragment dataStreamShowFragment, View view) {
        super(view);
        this.f11975c = dataStreamShowFragment;
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
        IconButton iconButton8;
        IconRadioButton iconRadioButton;
        LinearLayout linearLayout;
        IconRadioButton iconRadioButton2;
        IconRadioButton iconRadioButton3;
        this.f11975c.m7286b("graph_vaule");
        this.f11975c.f12358e.setVisibility(0);
        this.f11975c.f11932aj = 0;
        iconButton = this.f11975c.f11888C;
        iconButton.setVisibility(8);
        iconButton2 = this.f11975c.f11894I;
        iconButton2.setVisibility(8);
        iconButton3 = this.f11975c.f11892G;
        iconButton3.setVisibility(8);
        iconButton4 = this.f11975c.f11887B;
        iconButton4.setVisibility(8);
        iconButton5 = this.f11975c.f11895J;
        iconButton5.setVisibility(8);
        iconButton6 = this.f11975c.f11891F;
        iconButton6.setVisibility(0);
        view = this.f11975c.f11899N;
        view.setVisibility(0);
        iconButton7 = this.f11975c.f11889D;
        iconButton7.setVisibility(0);
        iconButton8 = this.f11975c.f11889D;
        iconButton8.setEnabled(this.f11975c.f12356c);
        if (this.f11975c.f12357d.mo7083i().getDiagnoseStatue() <= 1 || !PreferencesManager.m9595a((Context) this.f11975c.getActivity()).m9583b("is_provides_translation", false)) {
            iconRadioButton = this.f11975c.f11956u;
            iconRadioButton.setVisibility(8);
        } else {
            String m9469a = LangManager.m9469a();
            LangManager.m9466b();
            if (m9469a.equalsIgnoreCase("ZH") || m9469a.equalsIgnoreCase("TW") || m9469a.equalsIgnoreCase("HK") || m9469a.equalsIgnoreCase("EN") || m9469a.equalsIgnoreCase("CN")) {
                iconRadioButton2 = this.f11975c.f11956u;
                iconRadioButton2.setVisibility(8);
            } else {
                iconRadioButton3 = this.f11975c.f11956u;
                iconRadioButton3.setVisibility(0);
            }
        }
        if (this.f11975c.f11900O.equals(DiagnoseConstants.UI_TYPE_VW_DATASTREAM)) {
            linearLayout = this.f11975c.f11898M;
            linearLayout.setVisibility(0);
        }
        return true;
    }
}
