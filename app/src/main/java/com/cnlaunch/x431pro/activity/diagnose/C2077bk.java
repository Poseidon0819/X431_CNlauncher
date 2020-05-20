package com.cnlaunch.x431pro.activity.diagnose;

import android.content.Context;
import android.text.TextUtils;
import com.cnlaunch.diagnosemodule.bean.BasicSoftIDBean;
import com.cnlaunch.x431pro.activity.diagnose.DiagnoseActivity;
import com.cnlaunch.x431pro.widget.p290a.View$OnClickListenerC2884z;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DiagnoseActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.bk */
/* loaded from: classes.dex */
public final class C2077bk implements DiagnoseActivity.InterfaceC2009a {

    /* renamed from: a */
    final /* synthetic */ ArrayList f11549a;

    /* renamed from: b */
    final /* synthetic */ String f11550b;

    /* renamed from: c */
    final /* synthetic */ DiagnoseActivity f11551c;

    @Override // com.cnlaunch.x431pro.activity.diagnose.DiagnoseActivity.InterfaceC2009a
    /* renamed from: b */
    public final void mo7040b() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2077bk(DiagnoseActivity diagnoseActivity, ArrayList arrayList, String str) {
        this.f11551c = diagnoseActivity;
        this.f11549a = arrayList;
        this.f11550b = str;
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.DiagnoseActivity.InterfaceC2009a
    /* renamed from: a */
    public final void mo7041a() {
        View$OnClickListenerC2884z view$OnClickListenerC2884z;
        Context context;
        View$OnClickListenerC2884z view$OnClickListenerC2884z2;
        View$OnClickListenerC2884z view$OnClickListenerC2884z3;
        View$OnClickListenerC2884z view$OnClickListenerC2884z4;
        ArrayList arrayList = new ArrayList();
        String str = "";
        for (int i = 0; i < this.f11549a.size(); i++) {
            BasicSoftIDBean basicSoftIDBean = (BasicSoftIDBean) this.f11549a.get(i);
            if (basicSoftIDBean != null) {
                if (this.f11550b.equals("96")) {
                    String softID = basicSoftIDBean.getSoftID();
                    if (!TextUtils.isEmpty(softID)) {
                        str = softID.substring(softID.length() - 2);
                        arrayList.add(softID.substring(0, softID.length() - 2));
                    }
                } else {
                    arrayList.add(basicSoftIDBean.getSoftID());
                }
            }
        }
        view$OnClickListenerC2884z = this.f11551c.f11111bh;
        if (view$OnClickListenerC2884z != null) {
            view$OnClickListenerC2884z4 = this.f11551c.f11111bh;
            view$OnClickListenerC2884z4.dismiss();
        }
        DiagnoseActivity diagnoseActivity = this.f11551c;
        context = diagnoseActivity.f11019H;
        diagnoseActivity.f11111bh = new View$OnClickListenerC2884z(context, this.f11551c.mo7083i().getSerialNum(), this.f11551c.mo7083i().getSoftPackageid(), arrayList);
        if (this.f11550b.equals("96")) {
            view$OnClickListenerC2884z3 = this.f11551c.f11111bh;
            view$OnClickListenerC2884z3.f16470a = str;
        }
        view$OnClickListenerC2884z2 = this.f11551c.f11111bh;
        view$OnClickListenerC2884z2.show();
    }
}
