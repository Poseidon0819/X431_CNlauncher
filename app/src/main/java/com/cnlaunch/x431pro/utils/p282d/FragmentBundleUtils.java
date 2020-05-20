package com.cnlaunch.x431pro.utils.p282d;

import android.os.Bundle;
import com.cnlaunch.diagnosemodule.bean.BasicButtonBean;
import com.cnlaunch.diagnosemodule.bean.BasicSpeciaFunctionBean;
import java.util.ArrayList;

/* renamed from: com.cnlaunch.x431pro.utils.d.e */
/* loaded from: classes.dex */
public final class FragmentBundleUtils {
    /* renamed from: a */
    public static Bundle m5074a(String str, ArrayList<BasicSpeciaFunctionBean> arrayList, ArrayList<ArrayList<BasicSpeciaFunctionBean>> arrayList2, ArrayList<BasicButtonBean> arrayList3, String str2, int i) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("SpeciaTitle", arrayList);
        bundle.putSerializable("SpeciaValue", arrayList2);
        bundle.putSerializable("SpeciaButton", arrayList3);
        bundle.putString("Specia_Type", str);
        bundle.putString("Specia_Title", str2);
        bundle.putInt("Specia_colums", i);
        return bundle;
    }
}
