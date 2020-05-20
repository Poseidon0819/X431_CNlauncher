package com.cnlaunch.x431pro.activity.diagnose.p221d;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.cnlaunch.diagnosemodule.bean.BasicButtonBean;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MulitInputFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.bf */
/* loaded from: classes.dex */
public final class View$OnClickListenerC2141bf implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ArrayList f12090a;

    /* renamed from: b */
    final /* synthetic */ TextView f12091b;

    /* renamed from: c */
    final /* synthetic */ Button f12092c;

    /* renamed from: d */
    final /* synthetic */ MulitInputFragment f12093d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2141bf(MulitInputFragment mulitInputFragment, ArrayList arrayList, TextView textView, Button button) {
        this.f12093d = mulitInputFragment;
        this.f12090a = arrayList;
        this.f12091b = textView;
        this.f12092c = button;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = 0;
        while (true) {
            if (i >= this.f12090a.size()) {
                i = 0;
                break;
            } else if (((BasicButtonBean) this.f12090a.get(i)).getTitle().equals(this.f12091b.getText())) {
                break;
            } else {
                i++;
            }
        }
        MulitInputFragment.m7209a(this.f12093d, i);
        this.f12092c.setEnabled(false);
    }
}
