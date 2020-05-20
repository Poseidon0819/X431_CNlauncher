package com.cnlaunch.x431pro.module.p261g;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment;
import com.cnlaunch.x431pro.activity.diagnose.p221d.FaultCodeFragment;
import com.cnlaunch.x431pro.activity.diagnose.p221d.SpeciaFunctionFragment;
import com.cnlaunch.x431pro.activity.diagnose.p221d.SystemStatusCodeFragment;
import com.cnlaunch.x431pro.module.p261g.WebSearchUtil;

/* compiled from: WebSearchUtil.java */
/* renamed from: com.cnlaunch.x431pro.module.g.b */
/* loaded from: classes.dex */
public final class C2730b implements WebSearchUtil.InterfaceC2728a {

    /* renamed from: a */
    final /* synthetic */ BaseDiagnoseFragment f15536a;

    public C2730b(BaseDiagnoseFragment baseDiagnoseFragment) {
        this.f15536a = baseDiagnoseFragment;
    }

    @Override // com.cnlaunch.x431pro.module.p261g.WebSearchUtil.InterfaceC2728a
    /* renamed from: a */
    public final void mo5330a(String str) {
        BaseDiagnoseFragment baseDiagnoseFragment = this.f15536a;
        if (baseDiagnoseFragment instanceof SystemStatusCodeFragment) {
            DiagnoseConstants.FAULTCODE_REFRESH = false;
        } else if (baseDiagnoseFragment instanceof FaultCodeFragment) {
            DiagnoseConstants.FAULTCODE_REFRESH = false;
        } else if (baseDiagnoseFragment instanceof SpeciaFunctionFragment) {
            DiagnoseConstants.SPECIAFUNCTIONCODE_REFRESH = false;
        }
        BaseDiagnoseFragment baseDiagnoseFragment2 = this.f15536a;
        Activity activity = baseDiagnoseFragment2.getActivity();
        if (activity == null || str == null) {
            return;
        }
        if (WebSearchUtil.m5333a()) {
            C2731c c2731c = new C2731c(baseDiagnoseFragment2);
            String m5332a = WebSearchUtil.m5332a(activity, str);
            try {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.addCategory("android.intent.category.BROWSABLE");
                intent.setData(Uri.parse(m5332a));
                activity.startActivity(intent);
                return;
            } catch (Exception e) {
                e.printStackTrace();
                e.getMessage();
                c2731c.mo5329a(str);
                return;
            }
        }
        WebSearchUtil.m5331a(baseDiagnoseFragment2, str);
    }
}
