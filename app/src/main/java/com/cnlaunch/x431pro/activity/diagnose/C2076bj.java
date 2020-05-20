package com.cnlaunch.x431pro.activity.diagnose;

import com.cnlaunch.diagnosemodule.bean.BasicQueryWebSiteBean;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.x431pro.activity.diagnose.DiagnoseActivity;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DiagnoseActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.bj */
/* loaded from: classes.dex */
public final class C2076bj implements DiagnoseActivity.InterfaceC2009a {

    /* renamed from: a */
    final /* synthetic */ ArrayList f11547a;

    /* renamed from: b */
    final /* synthetic */ DiagnoseActivity f11548b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2076bj(DiagnoseActivity diagnoseActivity, ArrayList arrayList) {
        this.f11548b = diagnoseActivity;
        this.f11547a = arrayList;
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.DiagnoseActivity.InterfaceC2009a
    /* renamed from: a */
    public final void mo7041a() {
        BasicQueryWebSiteBean basicQueryWebSiteBean = (BasicQueryWebSiteBean) this.f11547a.get(0);
        this.f11548b.f11114bk = basicQueryWebSiteBean.getTitle();
        this.f11548b.f11115bl = basicQueryWebSiteBean.getValue();
        this.f11548b.m7739c(60004);
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.DiagnoseActivity.InterfaceC2009a
    /* renamed from: b */
    public final void mo7040b() {
        this.f11548b.mo7089a(DiagnoseConstants.FEEDBACK_SPT_TRANS_DIAG_INFO_EX, new byte[]{0, 0, 2, 0, 1});
    }
}
