package com.unionpay.mobile.android.pboctransaction.sdapdu;

import com.unionpay.mobile.android.utils.C4390k;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class NativeSDWriter {
    public NativeSDWriter() {
        C4288b.m1243a();
    }

    private native boolean closeSD();

    private native boolean openSD(ArrayList<String> arrayList);

    private native String writeApdu(String str);

    /* renamed from: a */
    public final String m1246a(String str) {
        C4390k.m836c("uppay", "[====>]".concat(String.valueOf(str)));
        String writeApdu = writeApdu(str);
        C4390k.m836c("uppay", "[<====]".concat(String.valueOf(writeApdu)));
        return writeApdu;
    }

    /* renamed from: a */
    public final boolean m1247a() {
        C4390k.m836c("uppay", "close()");
        return closeSD();
    }

    /* renamed from: a */
    public final boolean m1245a(ArrayList<String> arrayList) {
        boolean openSD = openSD(arrayList);
        C4390k.m836c("uppay", "open(), ret=".concat(String.valueOf(openSD)));
        return openSD;
    }
}
