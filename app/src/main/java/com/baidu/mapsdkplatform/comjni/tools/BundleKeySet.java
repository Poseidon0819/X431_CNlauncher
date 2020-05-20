package com.baidu.mapsdkplatform.comjni.tools;

import android.os.Bundle;

/* loaded from: classes.dex */
public class BundleKeySet {
    public String[] getBundleKeys(Bundle bundle) {
        String[] strArr = null;
        if (bundle == null) {
            return null;
        }
        if (!bundle.isEmpty()) {
            strArr = new String[bundle.size()];
            int i = 0;
            for (String str : bundle.keySet()) {
                strArr[i] = str.toString();
                i++;
            }
        }
        return strArr;
    }
}
