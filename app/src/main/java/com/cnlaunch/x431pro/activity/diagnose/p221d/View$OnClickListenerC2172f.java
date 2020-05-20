package com.cnlaunch.x431pro.activity.diagnose.p221d;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.cnlaunch.diagnosemodule.bean.BasicButtonBean;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.x431pro.p210a.DataStreamConfiguration;
import com.cnlaunch.x431pro.utils.PathUtils;
import com.cnlaunch.x431pro.widget.p290a.SpinnerPopupWindow;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ActiveTestFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.f */
/* loaded from: classes.dex */
public final class View$OnClickListenerC2172f implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ArrayList f12327a;

    /* renamed from: b */
    final /* synthetic */ TextView f12328b;

    /* renamed from: c */
    final /* synthetic */ ActiveTestFragment f12329c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2172f(ActiveTestFragment activeTestFragment, ArrayList arrayList, TextView textView) {
        this.f12329c = activeTestFragment;
        this.f12327a = arrayList;
        this.f12328b = textView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i;
        SpinnerPopupWindow spinnerPopupWindow;
        SpinnerPopupWindow spinnerPopupWindow2;
        SpinnerPopupWindow spinnerPopupWindow3;
        SpinnerPopupWindow spinnerPopupWindow4;
        Context context;
        ArrayList arrayList = new ArrayList();
        if (this.f12329c.f12357d.mo7083i().getDiagnoseStatue() != 1) {
            for (i = PathUtils.m4866a(DiagnoseConstants.DIAGNOSE_LIB_PATH) ? 1 : 0; i < this.f12327a.size(); i++) {
                arrayList.add(((BasicButtonBean) this.f12327a.get(i)).getTitle());
            }
        } else {
            for (i = DataStreamConfiguration.f10580f ? 1 : 0; i < this.f12327a.size(); i++) {
                arrayList.add(((BasicButtonBean) this.f12327a.get(i)).getTitle());
            }
        }
        spinnerPopupWindow = this.f12329c.f11872u;
        if (spinnerPopupWindow == null) {
            ActiveTestFragment activeTestFragment = this.f12329c;
            context = activeTestFragment.mContext;
            activeTestFragment.f11872u = new SpinnerPopupWindow(context);
        }
        spinnerPopupWindow2 = this.f12329c.f11872u;
        spinnerPopupWindow2.f16384c = this.f12328b.getWidth();
        spinnerPopupWindow3 = this.f12329c.f11872u;
        spinnerPopupWindow3.f16383b = new C2173g(this, arrayList);
        spinnerPopupWindow4 = this.f12329c.f11872u;
        spinnerPopupWindow4.m4582a(this.f12328b, arrayList);
    }
}
