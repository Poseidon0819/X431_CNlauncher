package com.cnlaunch.x431pro.activity.diagnose.p218a;

import android.view.View;

/* compiled from: FaultCodeShowListAdapter.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.a.k */
/* loaded from: classes.dex */
final class View$OnClickListenerC2023k implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f11351a;

    /* renamed from: b */
    final /* synthetic */ FaultCodeShowListAdapter f11352b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2023k(FaultCodeShowListAdapter faultCodeShowListAdapter, int i) {
        this.f11352b = faultCodeShowListAdapter;
        this.f11351a = i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x006c, code lost:
        if (android.text.TextUtils.isEmpty(r0.replace(org.codehaus.jackson.util.MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR, "")) == false) goto L22;
     */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onClick(android.view.View r5) {
        /*
            r4 = this;
            com.cnlaunch.x431pro.activity.diagnose.a.i r5 = r4.f11352b
            com.cnlaunch.x431pro.activity.diagnose.d.am r5 = com.cnlaunch.x431pro.activity.diagnose.p218a.FaultCodeShowListAdapter.m7498a(r5)
            if (r5 == 0) goto L87
            com.cnlaunch.x431pro.activity.diagnose.a.i r5 = r4.f11352b
            com.cnlaunch.x431pro.activity.diagnose.d.am r5 = com.cnlaunch.x431pro.activity.diagnose.p218a.FaultCodeShowListAdapter.m7498a(r5)
            int r0 = r4.f11351a
            java.lang.String r1 = r5.f11994b
            java.lang.String r2 = "730"
            boolean r1 = r1.equals(r2)
            r2 = 3
            if (r1 == 0) goto L2d
            boolean r1 = com.cnlaunch.x431pro.utils.C2778n.m4905b()
            if (r1 != 0) goto L87
            java.lang.String r0 = com.cnlaunch.diagnosemodule.utils.ByteHexHelper.intToTwoHexString(r0)
            com.cnlaunch.x431pro.activity.diagnose.e.a r5 = r5.f12357d
            java.lang.String r1 = "58"
            r5.mo7093a(r1, r0, r2)
            return
        L2d:
            java.lang.String r1 = r5.f11994b
            java.lang.String r3 = "740"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L4b
            boolean r1 = com.cnlaunch.x431pro.utils.C2778n.m4905b()
            if (r1 != 0) goto L87
            int r0 = r0 + 1
            java.lang.String r0 = com.cnlaunch.diagnosemodule.utils.ByteHexHelper.intToTwoHexString(r0)
            com.cnlaunch.x431pro.activity.diagnose.e.a r5 = r5.f12357d
            java.lang.String r1 = "71"
            r5.mo7093a(r1, r0, r2)
            return
        L4b:
            r1 = 2131691138(0x7f0f0682, float:1.901134E38)
            java.lang.String r1 = r5.getString(r1)
            if (r0 < 0) goto L6f
            java.util.ArrayList<com.cnlaunch.diagnosemodule.bean.BasicFaultCodeBean> r2 = r5.f11993a
            java.lang.Object r0 = r2.get(r0)
            com.cnlaunch.diagnosemodule.bean.BasicFaultCodeBean r0 = (com.cnlaunch.diagnosemodule.bean.BasicFaultCodeBean) r0
            java.lang.String r0 = r0.getHelp()
            java.lang.String r2 = " "
            java.lang.String r3 = ""
            java.lang.String r2 = r0.replace(r2, r3)
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L6f
            goto L70
        L6f:
            r0 = r1
        L70:
            com.cnlaunch.x431pro.widget.a.bd r1 = new com.cnlaunch.x431pro.widget.a.bd
            android.app.Activity r2 = r5.getActivity()
            r1.<init>(r2)
            r5.f11997l = r1
            com.cnlaunch.x431pro.widget.a.bd r1 = r5.f11997l
            r2 = 2131690869(0x7f0f0575, float:1.9010794E38)
            java.lang.String r5 = r5.getString(r2)
            r1.m4669a(r5, r0)
        L87:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.x431pro.activity.diagnose.p218a.View$OnClickListenerC2023k.onClick(android.view.View):void");
    }
}
