package com.unionpay.tsmservice.p373mi;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.unionpay.tsmservice.p373mi.ITsmActivityCallback;

/* renamed from: com.unionpay.tsmservice.mi.a */
/* loaded from: classes2.dex */
public final class BinderC4525a extends ITsmActivityCallback.Stub {

    /* renamed from: a */
    private Context f23645a;

    public BinderC4525a(Context context) {
        this.f23645a = context;
    }

    @Override // com.unionpay.tsmservice.p373mi.ITsmActivityCallback
    public final void startActivity(String str, String str2, int i, Bundle bundle) {
        ComponentName componentName = new ComponentName(str, str2);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        if (i != -1) {
            intent.setFlags(i);
        }
        intent.setComponent(componentName);
        this.f23645a.startActivity(intent);
    }
}
