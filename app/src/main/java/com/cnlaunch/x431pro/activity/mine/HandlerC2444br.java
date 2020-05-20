package com.cnlaunch.x431pro.activity.mine;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.TextView;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.module.p255e.p257b.ProductUpgradeDTO;
import com.cnlaunch.x431pro.module.p255e.p257b.ProductUpgradeResult;
import com.cnlaunch.x431pro.module.p258f.p260b.ConfigPriceResponse;
import com.cnlaunch.x431pro.module.p258f.p260b.OrderCreateResponse;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.cnlaunch.x431pro.widget.p290a.MessageDialog;
import com.ifoer.expedition.pro.R;
import com.mopub.common.MoPubBrowser;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PayTypeFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.br */
/* loaded from: classes.dex */
public final class HandlerC2444br extends Handler {

    /* renamed from: a */
    final /* synthetic */ PayTypeFragment f13951a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC2444br(PayTypeFragment payTypeFragment) {
        this.f13951a = payTypeFragment;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message2) {
        Context context;
        Context context2;
        String str;
        String str2;
        Context context3;
        Context context4;
        ProductUpgradeDTO productUpgradeInfo;
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        TextView textView6;
        Context context5;
        Context context6;
        Context context7;
        switch (message2.what) {
            case 100:
                if (1001 == message2.arg1) {
                    ConfigPriceResponse configPriceResponse = (ConfigPriceResponse) message2.obj;
                    if (configPriceResponse != null) {
                        textView2 = this.f13951a.f13938b;
                        textView2.setText(this.f13951a.getString(R.string.mine_software_name, new Object[]{configPriceResponse.getSoftConfName()}));
                        if (configPriceResponse.getCurrencyName().equalsIgnoreCase("RMB")) {
                            textView5 = this.f13951a.f13940d;
                            PayTypeFragment payTypeFragment = this.f13951a;
                            textView5.setText(payTypeFragment.getString(R.string.mine_pay_pal_fee, new Object[]{"￥" + String.valueOf(configPriceResponse.getPrice())}));
                            textView6 = this.f13951a.f13941e;
                            PayTypeFragment payTypeFragment2 = this.f13951a;
                            textView6.setText(payTypeFragment2.getString(R.string.mine_pay_pal_fee, new Object[]{"￥" + String.valueOf(configPriceResponse.getPrice())}));
                            return;
                        }
                        textView3 = this.f13951a.f13940d;
                        PayTypeFragment payTypeFragment3 = this.f13951a;
                        textView3.setText(payTypeFragment3.getString(R.string.mine_pay_pal_fee, new Object[]{"US$" + String.valueOf(configPriceResponse.getPrice())}));
                        textView4 = this.f13951a.f13941e;
                        PayTypeFragment payTypeFragment4 = this.f13951a;
                        textView4.setText(payTypeFragment4.getString(R.string.mine_pay_pal_fee, new Object[]{"US$" + String.valueOf(configPriceResponse.getPrice())}));
                        return;
                    }
                    return;
                } else if (1002 == message2.arg1) {
                    ProductUpgradeResult productUpgradeResult = (ProductUpgradeResult) message2.obj;
                    if (productUpgradeResult != null && (productUpgradeInfo = productUpgradeResult.getProductUpgradeInfo()) != null) {
                        textView = this.f13951a.f13939c;
                        textView.setText(this.f13951a.getString(R.string.mine_expiration_date, new Object[]{productUpgradeInfo.getFreeEndTime()}));
                    }
                    context4 = this.f13951a.mContext;
                    LoadDialog.m4681b(context4);
                    return;
                } else if (1003 == message2.arg1) {
                    context2 = this.f13951a.mContext;
                    LoadDialog.m4681b(context2);
                    str = this.f13951a.f13945i;
                    if (TextUtils.isEmpty(str)) {
                        context3 = this.f13951a.mContext;
                        NToast.m9450a(context3, (int) R.string.mine_error_paypal);
                        return;
                    }
                    Bundle bundle = new Bundle();
                    str2 = this.f13951a.f13945i;
                    bundle.putString(MoPubBrowser.DESTINATION_URL_KEY, str2);
                    this.f13951a.addFragment(PayPalPayFragment.class.getName(), bundle);
                    return;
                } else if (1004 == message2.arg1) {
                    context = this.f13951a.mContext;
                    LoadDialog.m4681b(context);
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("order_sn", ((OrderCreateResponse) message2.obj).getOrdersn());
                    this.f13951a.addFragment(FragmentC2499z.class.getName(), bundle2);
                    return;
                } else {
                    return;
                }
            case 101:
                if (1002 == message2.arg1 || 1003 == message2.arg1) {
                    context5 = this.f13951a.mContext;
                    LoadDialog.m4681b(context5);
                }
                if (-1 == message2.arg2) {
                    context7 = this.f13951a.mContext;
                    MessageDialog messageDialog = new MessageDialog(context7, (int) R.string.login_conflict_dialog_title, (int) R.string.login_conflict_dialog_content);
                    messageDialog.m4713f(2);
                    messageDialog.m4719a(R.string.btn_confirm, true, new View$OnClickListenerC2445bs(this));
                    messageDialog.m4717b(R.string.btn_canlce, true, null);
                    if (this.f13951a.isVisible()) {
                        messageDialog.show();
                        return;
                    }
                    return;
                } else if (message2.arg2 == 0 || message2.obj == null || !(message2.obj instanceof String)) {
                    return;
                } else {
                    if (message2.arg2 == 1004019 && C2744aa.m5166c()) {
                        return;
                    }
                    context6 = this.f13951a.mContext;
                    NToast.m9449a(context6, (String) message2.obj);
                    return;
                }
            default:
                return;
        }
    }
}
