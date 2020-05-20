package com.cnlaunch.x431pro.activity.mine;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.cnlaunch.x431pro.module.p255e.p257b.CardConsumeListResult;
import com.cnlaunch.x431pro.module.p258f.p260b.UserOrderDTO;
import com.cnlaunch.x431pro.module.p258f.p260b.UserOrderListInfoResponse;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MyOrderFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.av */
/* loaded from: classes.dex */
final class HandlerC2410av extends Handler {

    /* renamed from: a */
    final /* synthetic */ MyOrderFragment f13708a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC2410av(MyOrderFragment myOrderFragment) {
        this.f13708a = myOrderFragment;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message2) {
        Context context;
        List list;
        List list2;
        Context context2;
        switch (message2.what) {
            case 100:
                if (1001 == message2.arg1) {
                    Object obj = message2.obj;
                    return;
                } else if (1002 == message2.arg1) {
                    CardConsumeListResult cardConsumeListResult = (CardConsumeListResult) message2.obj;
                    if (cardConsumeListResult.getCode() == 0) {
                        this.f13708a.f13698e = cardConsumeListResult.getCardConsumeRecordList();
                        MyOrderFragment.m6437a(this.f13708a);
                        MyOrderFragment.m6433b(this.f13708a);
                        return;
                    }
                    return;
                } else if (1003 == message2.arg1) {
                    UserOrderListInfoResponse userOrderListInfoResponse = (UserOrderListInfoResponse) message2.obj;
                    if (userOrderListInfoResponse.getCode() == 0) {
                        List<UserOrderDTO> orderList = userOrderListInfoResponse.getOrderList();
                        this.f13708a.f13699f = new ArrayList();
                        this.f13708a.f13700g = new ArrayList();
                        for (UserOrderDTO userOrderDTO : orderList) {
                            if (userOrderDTO.getStatus() == 0) {
                                list = this.f13708a.f13699f;
                                list.add(userOrderDTO);
                            } else if (userOrderDTO.getStatus() == 1) {
                                list2 = this.f13708a.f13700g;
                                list2.add(userOrderDTO);
                            }
                        }
                        MyOrderFragment.m6428e(this.f13708a);
                        MyOrderFragment.m6427f(this.f13708a);
                        MyOrderFragment.m6426g(this.f13708a);
                        MyOrderFragment.m6425h(this.f13708a);
                    }
                    context = this.f13708a.mContext;
                    LoadDialog.m4681b(context);
                    return;
                } else {
                    return;
                }
            case 101:
                if (1003 == message2.arg1) {
                    context2 = this.f13708a.mContext;
                    LoadDialog.m4681b(context2);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
