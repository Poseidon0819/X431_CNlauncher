package com.baidu.mapsdkplatform.comjni.map.basemap;

import android.os.Bundle;
import android.util.LongSparseArray;

/* loaded from: classes.dex */
public class BaseMapCallback {

    /* renamed from: a */
    private static LongSparseArray<InterfaceC1307b> f6433a = new LongSparseArray<>();

    public static int ReqLayerData(Bundle bundle, long j, int i, Bundle bundle2) {
        int size = f6433a.size();
        for (int i2 = 0; i2 < size; i2++) {
            InterfaceC1307b valueAt = f6433a.valueAt(i2);
            if (valueAt != null && valueAt.mo9984a(j)) {
                return valueAt.mo9983a(bundle, j, i, bundle2);
            }
        }
        return 0;
    }

    public static void addLayerDataInterface(long j, InterfaceC1307b interfaceC1307b) {
        f6433a.put(j, interfaceC1307b);
    }

    public static void removeLayerDataInterface(long j) {
        f6433a.remove(j);
    }
}
