package com.unionpay;

import android.os.Bundle;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.c */
/* loaded from: classes2.dex */
public final class C4135c implements UPQuerySEPayInfoCallback {
    @Override // com.unionpay.UPQuerySEPayInfoCallback
    public final void onError(String str, String str2, String str3, String str4) {
        String unused = UPPayAssistEx.f21980A = str2;
        UPPayAssistEx.m1652s();
    }

    @Override // com.unionpay.UPQuerySEPayInfoCallback
    public final void onResult(String str, String str2, int i, Bundle bundle) {
        String unused = UPPayAssistEx.f21980A = str2;
        UPPayAssistEx.m1652s();
    }
}
