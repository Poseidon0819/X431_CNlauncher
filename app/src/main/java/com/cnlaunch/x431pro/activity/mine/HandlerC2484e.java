package com.cnlaunch.x431pro.activity.mine;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.TextView;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.module.p255e.p257b.SysCardInfoDTO;
import com.cnlaunch.x431pro.module.p255e.p257b.SysCardInfoResult;
import com.cnlaunch.x431pro.widget.p290a.MessageDialog;
import com.ifoer.expedition.pro.R;

/* compiled from: CardStatusFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.e */
/* loaded from: classes.dex */
final class HandlerC2484e extends Handler {

    /* renamed from: a */
    final /* synthetic */ CardStatusFragment f14219a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC2484e(CardStatusFragment cardStatusFragment) {
        this.f14219a = cardStatusFragment;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message2) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        TextView textView6;
        TextView textView7;
        TextView textView8;
        TextView textView9;
        Handler handler;
        Handler handler2;
        Context context;
        Context context2;
        Context context3;
        switch (message2.what) {
            case 100:
                SysCardInfoDTO sysCardInfo = ((SysCardInfoResult) message2.obj).getSysCardInfo();
                if (sysCardInfo == null) {
                    handler = this.f14219a.f13726h;
                    Message obtainMessage = handler.obtainMessage(101, 0, -2);
                    handler2 = this.f14219a.f13726h;
                    handler2.sendMessage(obtainMessage);
                    return;
                }
                textView = this.f14219a.f13721c;
                textView.setText(sysCardInfo.getCardNo());
                textView2 = this.f14219a.f13722d;
                textView2.setText(sysCardInfo.getCardConfName());
                textView3 = this.f14219a.f13723e;
                textView3.setText(Integer.toString(sysCardInfo.getCardRechargeYear()));
                switch (sysCardInfo.getCardState()) {
                    case 0:
                        textView5 = this.f14219a.f13724f;
                        textView5.setText(R.string.mine_pin_card_status_0);
                        break;
                    case 1:
                        textView6 = this.f14219a.f13724f;
                        textView6.setText(R.string.mine_pin_card_status_1);
                        break;
                    case 2:
                        textView7 = this.f14219a.f13724f;
                        textView7.setText(R.string.mine_pin_card_status_2);
                        break;
                    case 3:
                        textView8 = this.f14219a.f13724f;
                        textView8.setText(R.string.mine_pin_card_status_3);
                        break;
                    case 4:
                        textView9 = this.f14219a.f13724f;
                        textView9.setText(R.string.mine_pin_card_status_4);
                        break;
                }
                if (TextUtils.isEmpty(sysCardInfo.getCardConsumeDate())) {
                    return;
                }
                textView4 = this.f14219a.f13725g;
                textView4.setText(sysCardInfo.getCardConsumeDate());
                return;
            case 101:
                if (-1 == message2.arg1) {
                    context3 = this.f14219a.mContext;
                    MessageDialog messageDialog = new MessageDialog(context3, (int) R.string.login_conflict_dialog_title, (int) R.string.login_conflict_dialog_content);
                    messageDialog.m4713f(2);
                    messageDialog.m4719a(R.string.btn_confirm, true, new View$OnClickListenerC2485f(this));
                    messageDialog.m4717b(R.string.btn_canlce, true, null);
                    if (this.f14219a.isVisible()) {
                        messageDialog.show();
                        return;
                    }
                    return;
                } else if (message2.arg1 != 0 || -2 != message2.arg2) {
                    context = this.f14219a.mContext;
                    NToast.m9450a(context, (int) R.string.mine_check_error);
                    return;
                } else {
                    context2 = this.f14219a.mContext;
                    NToast.m9450a(context2, (int) R.string.mine_check_error_no_exited);
                    return;
                }
            default:
                return;
        }
    }
}
