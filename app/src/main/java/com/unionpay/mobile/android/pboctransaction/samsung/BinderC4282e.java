package com.unionpay.mobile.android.pboctransaction.samsung;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.unionpay.mobile.android.utils.C4390k;
import com.unionpay.tsmservice.ITsmCallback;
import com.unionpay.tsmservice.data.Constant;
import com.unionpay.tsmservice.data.VirtualCardInfo;
import com.unionpay.tsmservice.result.CheckSSamsungPayResult;
import com.unionpay.tsmservice.result.GetCardInfoBySpayResult;
import com.unionpay.tsmservice.result.GetSeAppListResult;
import com.unionpay.tsmservice.result.InitResult;
import com.unionpay.tsmservice.result.OpenChannelResult;
import com.unionpay.tsmservice.result.SendApduResult;
import com.unionpay.tsmservice.result.VendorPayStatusResult;

/* renamed from: com.unionpay.mobile.android.pboctransaction.samsung.e */
/* loaded from: classes2.dex */
public final class BinderC4282e extends ITsmCallback.Stub {

    /* renamed from: a */
    private int f22780a;

    /* renamed from: b */
    private Handler f22781b;

    public BinderC4282e(int i, Handler handler) {
        this.f22780a = i;
        this.f22781b = handler;
    }

    @Override // com.unionpay.tsmservice.ITsmCallback
    public final void onError(String str, String str2) throws RemoteException {
        Handler handler;
        Message obtain;
        Log.e("uppay", "errorCode:" + str + ", errorDesc:" + str2);
        if ("1003700023".equals(str) && this.f22780a == 1018) {
            C4390k.m836c("uppay", "error 100370023 from get vendor pay status");
            Bundle bundle = new Bundle();
            bundle.putBoolean("KEY_SUCCESS_VENDOR", false);
            handler = this.f22781b;
            obtain = Message.obtain(handler, 1018, bundle);
        } else {
            handler = this.f22781b;
            obtain = Message.obtain(handler, 1, this.f22780a, 0, str);
        }
        handler.sendMessage(obtain);
    }

    @Override // com.unionpay.tsmservice.ITsmCallback
    public final void onResult(Bundle bundle) throws RemoteException {
        int i = this.f22780a;
        if (i == 1000) {
            bundle.setClassLoader(InitResult.class.getClassLoader());
            Handler handler = this.f22781b;
            handler.sendMessage(Message.obtain(handler, 1000, bundle));
        } else if (i == 1018) {
            C4390k.m836c("uppay-spay", "get vendor pay status callback");
            bundle.setClassLoader(VendorPayStatusResult.class.getClassLoader());
            Bundle vendorPayStatusResult = ((VendorPayStatusResult) bundle.get("result")).getVendorPayStatusResult();
            vendorPayStatusResult.putBoolean("KEY_SUCCESS_VENDOR", true);
            Handler handler2 = this.f22781b;
            handler2.sendMessage(Message.obtain(handler2, 1018, vendorPayStatusResult));
            C4390k.m836c("unpay", "result vendorPayStatusResult max card num reached:" + vendorPayStatusResult.getBoolean(Constant.KEY_MAX_CARD_NUM_REACHED));
        } else {
            switch (i) {
                case 1011:
                    bundle.setClassLoader(OpenChannelResult.class.getClassLoader());
                    OpenChannelResult openChannelResult = (OpenChannelResult) bundle.get("result");
                    String channel = openChannelResult.getChannel();
                    String outHexApdu = openChannelResult.getOutHexApdu();
                    Bundle bundle2 = new Bundle();
                    bundle2.putString(Constant.KEY_CHANNEL, channel);
                    bundle2.putString("apdu", outHexApdu);
                    Handler handler3 = this.f22781b;
                    handler3.sendMessage(Message.obtain(handler3, 1011, bundle2));
                    return;
                case 1012:
                    bundle.setClassLoader(SendApduResult.class.getClassLoader());
                    String outHexApdu2 = ((SendApduResult) bundle.get("result")).getOutHexApdu();
                    Handler handler4 = this.f22781b;
                    handler4.sendMessage(Message.obtain(handler4, 1012, outHexApdu2));
                    return;
                case 1013:
                    Handler handler5 = this.f22781b;
                    handler5.sendMessage(Message.obtain(handler5, 1013, ""));
                    return;
                case 1014:
                    bundle.setClassLoader(GetSeAppListResult.class.getClassLoader());
                    Handler handler6 = this.f22781b;
                    handler6.sendMessage(Message.obtain(handler6, 1014, (GetSeAppListResult) bundle.get("result")));
                    return;
                case 1015:
                    bundle.setClassLoader(GetCardInfoBySpayResult.class.getClassLoader());
                    VirtualCardInfo virtualCardInfo = ((GetCardInfoBySpayResult) bundle.get("result")).getVirtualCardInfo();
                    Handler handler7 = this.f22781b;
                    handler7.sendMessage(Message.obtain(handler7, 1015, virtualCardInfo));
                    return;
                case 1016:
                    C4390k.m836c("uppay-spay", "check spay support callback");
                    bundle.setClassLoader(CheckSSamsungPayResult.class.getClassLoader());
                    bundle.get("result");
                    Handler handler8 = this.f22781b;
                    handler8.sendMessage(Message.obtain(handler8, 1016, ""));
                    return;
                default:
                    return;
            }
        }
    }
}
