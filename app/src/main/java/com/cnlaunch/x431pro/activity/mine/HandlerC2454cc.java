package com.cnlaunch.x431pro.activity.mine;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.cnlaunch.x431pro.module.p255e.p257b.ProductUpgradeDTO;
import com.cnlaunch.x431pro.module.p255e.p257b.ProductUpgradeResult;
import com.cnlaunch.x431pro.widget.p290a.MessageDialog;
import com.ifoer.expedition.pro.R;
import org.apache.mina.proxy.handlers.http.HttpProxyConstants;

/* compiled from: PinCardPayFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.cc */
/* loaded from: classes.dex */
final class HandlerC2454cc extends Handler {

    /* renamed from: a */
    final /* synthetic */ PinCardPayFragment f14029a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC2454cc(PinCardPayFragment pinCardPayFragment) {
        this.f14029a = pinCardPayFragment;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message2) {
        MessageDialog messageDialog;
        Context context;
        Context context2;
        Context context3;
        Context context4;
        switch (message2.what) {
            case 100:
                ProductUpgradeResult productUpgradeResult = (ProductUpgradeResult) message2.obj;
                ProductUpgradeDTO productUpgradeInfo = productUpgradeResult.getProductUpgradeInfo();
                if (productUpgradeResult.getCode() != 0 || productUpgradeInfo == null) {
                    context = this.f14029a.mContext;
                    messageDialog = new MessageDialog(context);
                    if (!TextUtils.isEmpty(productUpgradeResult.getMessage())) {
                        messageDialog.m4669a(this.f14029a.getResources().getString(R.string.mine_pin_card_charge_result_tip_title), productUpgradeResult.getMessage());
                        return;
                    }
                } else {
                    String serialNo = productUpgradeInfo.getSerialNo();
                    String freeEndTime = productUpgradeInfo.getFreeEndTime();
                    context2 = this.f14029a.mContext;
                    MessageDialog messageDialog2 = new MessageDialog(context2);
                    messageDialog2.setOnDismissListener(new DialogInterface$OnDismissListenerC2455cd(this));
                    messageDialog2.m4669a(this.f14029a.getString(R.string.mine_pin_card_charge_result_tip_title), this.f14029a.getString(R.string.mine_sn, new Object[]{serialNo}) + HttpProxyConstants.CRLF + this.f14029a.getString(R.string.mine_expiration_date, new Object[]{freeEndTime}));
                    return;
                }
                break;
            case 101:
                if (-1 == message2.arg1) {
                    context4 = this.f14029a.mContext;
                    MessageDialog messageDialog3 = new MessageDialog(context4, (int) R.string.login_conflict_dialog_title, (int) R.string.login_conflict_dialog_content);
                    messageDialog3.m4713f(2);
                    messageDialog3.m4719a(R.string.btn_confirm, true, new View$OnClickListenerC2456ce(this));
                    messageDialog3.m4717b(R.string.btn_canlce, true, null);
                    if (this.f14029a.isVisible()) {
                        messageDialog3.show();
                        return;
                    }
                    return;
                }
                context3 = this.f14029a.mContext;
                messageDialog = new MessageDialog(context3);
                if (message2.obj instanceof String) {
                    messageDialog.m4669a(this.f14029a.getResources().getString(R.string.mine_pin_card_charge_result_tip_title), (String) message2.obj);
                    return;
                }
                break;
            default:
                return;
        }
        messageDialog.m4670a(R.string.mine_pin_card_charge_result_tip_title, R.string.mine_pin_card_charge_fail);
    }
}
