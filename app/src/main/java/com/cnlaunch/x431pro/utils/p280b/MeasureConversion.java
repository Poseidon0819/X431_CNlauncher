package com.cnlaunch.x431pro.utils.p280b;

import com.cnlaunch.diagnosemodule.bean.BasicDataStreamBean;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.utils.b.b */
/* loaded from: classes.dex */
public final class MeasureConversion {

    /* renamed from: a */
    public static final int[] f15720a = {1, 10, 100, 1000, 10000};

    /* renamed from: a */
    public static List<BasicDataStreamBean> m5099a(int i, List<BasicDataStreamBean> list) {
        BasicDataStreamBean.currconversionType = i;
        return list;
    }
}
