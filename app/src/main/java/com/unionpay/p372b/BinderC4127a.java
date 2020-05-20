package com.unionpay.p372b;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.baidu.mapapi.UIMsg;
import com.unionpay.tsmservice.ITsmCallback;
import com.unionpay.tsmservice.result.VendorPayStatusResult;
import com.unionpay.utils.C4652j;

/* renamed from: com.unionpay.b.a */
/* loaded from: classes2.dex */
public final class BinderC4127a extends ITsmCallback.Stub {

    /* renamed from: a */
    private int f22054a = UIMsg.m_AppUI.MSG_APP_SAVESCREEN;

    /* renamed from: b */
    private Handler f22055b;

    public BinderC4127a(Handler handler) {
        this.f22055b = handler;
    }

    @Override // com.unionpay.tsmservice.ITsmCallback
    public final void onError(String str, String str2) {
        C4652j.m432b("uppay", "errorCode:" + str + ", errorDesc:" + str2);
        Handler handler = this.f22055b;
        int i = this.f22054a;
        handler.sendMessage(Message.obtain(handler, 1, i, 0, str + str2));
    }

    @Override // com.unionpay.tsmservice.ITsmCallback
    public final void onResult(Bundle bundle) {
        if (this.f22054a != 4000) {
            return;
        }
        C4652j.m432b("uppay-spay", "query vendor pay status callback");
        bundle.setClassLoader(VendorPayStatusResult.class.getClassLoader());
        Bundle vendorPayStatusResult = ((VendorPayStatusResult) bundle.get("result")).getVendorPayStatusResult();
        Handler handler = this.f22055b;
        handler.sendMessage(Message.obtain(handler, UIMsg.m_AppUI.MSG_APP_SAVESCREEN, vendorPayStatusResult));
    }
}
