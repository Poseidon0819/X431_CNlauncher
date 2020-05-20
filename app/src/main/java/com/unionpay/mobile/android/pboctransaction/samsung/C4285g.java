package com.unionpay.mobile.android.pboctransaction.samsung;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.unionpay.mobile.android.model.C4172a;
import com.unionpay.mobile.android.pboctransaction.samsung.C4283f;
import com.unionpay.mobile.android.utils.C4390k;
import com.unionpay.tsmservice.data.AppStatus;
import com.unionpay.tsmservice.data.Constant;
import com.unionpay.tsmservice.data.SeAppListItem;
import com.unionpay.tsmservice.data.VirtualCardInfo;
import com.unionpay.tsmservice.result.GetSeAppListResult;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.pboctransaction.samsung.g */
/* loaded from: classes2.dex */
public final class C4285g implements Handler.Callback {

    /* renamed from: a */
    final /* synthetic */ C4283f f22818a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4285g(C4283f c4283f) {
        this.f22818a = c4283f;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message2) {
        Handler handler;
        Handler handler2;
        Handler handler3;
        boolean z;
        String str;
        String str2;
        C4283f.InterfaceC4284a interfaceC4284a;
        Handler handler4;
        Handler handler5;
        Handler handler6;
        Handler handler7;
        int i;
        Handler handler8;
        Object obj;
        Handler handler9;
        Handler handler10;
        Handler handler11;
        Handler handler12;
        int i2 = message2.what;
        if (i2 == 1) {
            handler = this.f22818a.f22788G;
            handler.removeMessages(4);
            C4390k.m836c("uppay", "msg error");
            C4283f.m1266a(this.f22818a, message2.arg1, (String) message2.obj);
        } else if (i2 != 1000) {
            if (i2 != 1018) {
                switch (i2) {
                    case 3:
                        C4390k.m836c("uppay-spay", "send apdu time out");
                        C4283f.m1257c(this.f22818a);
                        break;
                    case 4:
                        C4390k.m836c("uppay", "timeout");
                        C4283f.m1266a(this.f22818a, message2.arg1, "");
                        break;
                    default:
                        switch (i2) {
                            case 1011:
                                C4390k.m836c("uppay", "channel success");
                                Bundle bundle = (Bundle) message2.obj;
                                this.f22818a.f22810s = bundle.getString(Constant.KEY_CHANNEL);
                                this.f22818a.f22811t = bundle.getString("apdu");
                                break;
                            case 1012:
                                C4390k.m836c("uppay", "apdu success version 3.3.1");
                                handler4 = this.f22818a.f22788G;
                                handler4.removeMessages(3);
                                this.f22818a.f22813v = (String) message2.obj;
                                break;
                            case 1013:
                                C4390k.m836c("uppay", "close channel success");
                                this.f22818a.f22815x = Constant.CASH_LOAD_SUCCESS;
                                break;
                            case 1014:
                                handler5 = this.f22818a.f22788G;
                                handler5.removeMessages(4);
                                C4390k.m836c("uppay", "list success");
                                handler6 = this.f22818a.f22806o;
                                if (handler6 != null) {
                                    ArrayList arrayList = new ArrayList();
                                    SeAppListItem[] seAppList = ((GetSeAppListResult) message2.obj).getSeAppList();
                                    if (seAppList != null && seAppList.length > 0) {
                                        arrayList = new ArrayList();
                                        for (int i3 = 0; i3 < seAppList.length; i3++) {
                                            if (seAppList[i3] != null && seAppList[i3].getAppDetail() != null && seAppList[i3].getAppDetail().getAppID() != null) {
                                                String appAid = seAppList[i3].getAppDetail().getAppID().getAppAid();
                                                if (!(appAid == null || appAid.length() <= 16 || AppStatus.APPLY.equalsIgnoreCase(appAid.substring(14, 16)))) {
                                                    arrayList.add(new C4172a(1, seAppList[i3].getAppDetail().getAppID().getAppAid(), "", seAppList[i3].getAppDetail().getMpan(), 1));
                                                }
                                            }
                                        }
                                    }
                                    handler7 = this.f22818a.f22788G;
                                    i = 8;
                                    obj = arrayList;
                                    handler8 = handler7;
                                    Message obtainMessage = handler8.obtainMessage(i, obj);
                                    handler9 = this.f22818a.f22806o;
                                    handler9.sendMessage(obtainMessage);
                                    break;
                                }
                                break;
                            case 1015:
                                handler10 = this.f22818a.f22788G;
                                handler10.removeMessages(4);
                                C4390k.m836c("uppay-spay", "get spay list call back");
                                VirtualCardInfo virtualCardInfo = (VirtualCardInfo) message2.obj;
                                Object c4172a = new C4172a(32, virtualCardInfo.getAppID().getAppAid(), "", virtualCardInfo.getCardNo(), 1);
                                handler11 = this.f22818a.f22806o;
                                i = 2000;
                                obj = c4172a;
                                handler8 = handler11;
                                Message obtainMessage2 = handler8.obtainMessage(i, obj);
                                handler9 = this.f22818a.f22806o;
                                handler9.sendMessage(obtainMessage2);
                                break;
                            case 1016:
                                handler12 = this.f22818a.f22788G;
                                handler12.removeMessages(4);
                                str = "uppay-spay";
                                str2 = "check spay support";
                                break;
                        }
                }
            } else {
                handler3 = this.f22818a.f22788G;
                handler3.removeMessages(4);
                this.f22818a.f22786E = ((Bundle) message2.obj).getBoolean("KEY_SUCCESS_VENDOR");
                StringBuilder sb = new StringBuilder("mIsVendorStateReady: ");
                z = this.f22818a.f22786E;
                sb.append(z);
                C4390k.m836c("uppay-spay", sb.toString());
                str = "uppay-spay";
                str2 = "get vendor pay status";
            }
            C4390k.m836c(str, str2);
            interfaceC4284a = this.f22818a.f22804m;
            interfaceC4284a.mo1214a(true);
        } else {
            handler2 = this.f22818a.f22788G;
            handler2.removeMessages(4);
            C4390k.m836c("uppay", "init success");
            this.f22818a.m1262a(true);
            this.f22818a.f22799h = true;
        }
        return false;
    }
}
