package com.unionpay;

import java.util.Comparator;
import org.json.JSONObject;

/* renamed from: com.unionpay.i */
/* loaded from: classes2.dex */
final class C4142i implements Comparator {

    /* renamed from: a */
    String f22091a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4142i(String str) {
        this.f22091a = "";
        this.f22091a = str;
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        long optLong = ((JSONObject) obj).optLong(this.f22091a);
        long optLong2 = ((JSONObject) obj2).optLong(this.f22091a);
        if (optLong < optLong2) {
            return -1;
        }
        return optLong > optLong2 ? 1 : 0;
    }
}
