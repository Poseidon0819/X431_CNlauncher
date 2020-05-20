package com.cnlaunch.x431pro.activity.diagnose.p222e;

import com.cnlaunch.diagnosemodule.bean.BasicButtonBean;
import com.cnlaunch.diagnosemodule.bean.BasicDataStreamBean;
import com.cnlaunch.diagnosemodule.bean.BasicFaultCodeBean;
import com.cnlaunch.diagnosemodule.bean.BasicSpeciaFunctionBean;
import com.cnlaunch.diagnosemodule.bean.BasicSystemStatusBean;
import java.util.ArrayList;

/* renamed from: com.cnlaunch.x431pro.activity.diagnose.e.d */
/* loaded from: classes.dex */
public interface OnDiagnoseDataUpdateListenter {
    /* renamed from: a */
    void mo7078a(ArrayList<BasicDataStreamBean> arrayList);

    /* renamed from: a */
    void mo7077a(ArrayList<BasicDataStreamBean> arrayList, ArrayList<BasicButtonBean> arrayList2);

    /* renamed from: a */
    void mo7076a(ArrayList<BasicSpeciaFunctionBean> arrayList, ArrayList<ArrayList<BasicSpeciaFunctionBean>> arrayList2, ArrayList<BasicButtonBean> arrayList3);

    /* renamed from: a */
    void mo7075a(ArrayList<BasicSystemStatusBean> arrayList, boolean z);

    /* renamed from: a_ */
    void mo7074a_(String str);

    /* renamed from: b */
    void mo7073b(ArrayList<BasicFaultCodeBean> arrayList);

    /* renamed from: b */
    void mo7072b(ArrayList<BasicDataStreamBean> arrayList, ArrayList<BasicDataStreamBean> arrayList2);
}
