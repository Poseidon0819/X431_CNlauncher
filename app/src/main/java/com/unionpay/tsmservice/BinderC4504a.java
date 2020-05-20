package com.unionpay.tsmservice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.unionpay.tsmservice.ITsmActivityCallback;

/* renamed from: com.unionpay.tsmservice.a */
/* loaded from: classes2.dex */
public final class BinderC4504a extends ITsmActivityCallback.Stub {

    /* renamed from: a */
    private Context f23598a;

    public BinderC4504a(Context context) {
        this.f23598a = context;
    }

    @Override // com.unionpay.tsmservice.ITsmActivityCallback
    public final void startActivity(String str, String str2, int i, Bundle bundle) throws RemoteException {
        ComponentName componentName = new ComponentName(str, str2);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        if (i != -1) {
            intent.setFlags(i);
        }
        intent.setComponent(componentName);
        this.f23598a.startActivity(intent);
    }
}
