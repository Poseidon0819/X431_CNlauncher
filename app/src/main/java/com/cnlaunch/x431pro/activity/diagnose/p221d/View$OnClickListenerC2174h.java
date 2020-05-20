package com.cnlaunch.x431pro.activity.diagnose.p221d;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.cnlaunch.diagnosemodule.bean.BasicButtonBean;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.x431pro.p210a.DataStreamConfiguration;
import com.cnlaunch.x431pro.utils.PathUtils;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ActiveTestFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.h */
/* loaded from: classes.dex */
public final class View$OnClickListenerC2174h implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ArrayList f12332a;

    /* renamed from: b */
    final /* synthetic */ TextView f12333b;

    /* renamed from: c */
    final /* synthetic */ Button f12334c;

    /* renamed from: d */
    final /* synthetic */ ActiveTestFragment f12335d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2174h(ActiveTestFragment activeTestFragment, ArrayList arrayList, TextView textView, Button button) {
        this.f12335d = activeTestFragment;
        this.f12332a = arrayList;
        this.f12333b = textView;
        this.f12334c = button;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        z = this.f12335d.f11857I;
        if (z) {
            return;
        }
        int i = 1;
        if (this.f12335d.f12357d.mo7083i().getDiagnoseStatue() == 1 ? !DataStreamConfiguration.f10580f : !PathUtils.m4866a(DiagnoseConstants.DIAGNOSE_LIB_PATH)) {
            i = 0;
        }
        while (true) {
            if (i >= this.f12332a.size()) {
                i = 0;
                break;
            } else if (((BasicButtonBean) this.f12332a.get(i)).getTitle().equals(this.f12333b.getText())) {
                this.f12335d.f11852D = i;
                break;
            } else {
                i++;
            }
        }
        this.f12335d.f12357d.mo7082j();
        this.f12335d.f12357d.mo7093a("9", ActiveTestFragment.m7324c(i), 3);
        ActiveTestFragment.m7314i(this.f12335d);
        this.f12334c.setEnabled(false);
    }
}
