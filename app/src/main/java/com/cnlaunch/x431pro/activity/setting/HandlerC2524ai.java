package com.cnlaunch.x431pro.activity.setting;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.x431pro.activity.setting.p234a.OneKeyFeedbackHistoryAdapter;
import com.cnlaunch.x431pro.widget.p290a.LoginDialog;
import com.cnlaunch.x431pro.widget.p290a.MessageDialog;
import com.ifoer.expedition.pro.R;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OneKeyFeedbackHistoryFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.setting.ai */
/* loaded from: classes.dex */
public final class HandlerC2524ai extends Handler {

    /* renamed from: a */
    final /* synthetic */ OneKeyFeedbackHistoryFragment f14573a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC2524ai(OneKeyFeedbackHistoryFragment oneKeyFeedbackHistoryFragment) {
        this.f14573a = oneKeyFeedbackHistoryFragment;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message2) {
        TextView textView;
        String str;
        List list;
        TextView textView2;
        TextView textView3;
        Context context;
        TextView textView4;
        TextView textView5;
        OneKeyFeedbackHistoryAdapter oneKeyFeedbackHistoryAdapter;
        OneKeyFeedbackHistoryAdapter oneKeyFeedbackHistoryAdapter2;
        TextView textView6;
        String str2;
        Context context2;
        Context context3;
        Context context4;
        Context context5;
        Context context6;
        Context context7;
        Context context8;
        OneKeyFeedbackHistoryAdapter oneKeyFeedbackHistoryAdapter3;
        OneKeyFeedbackHistoryAdapter oneKeyFeedbackHistoryAdapter4;
        TextView textView7;
        String str3;
        LoginDialog loginDialog;
        LoginDialog loginDialog2;
        Context context9;
        switch (message2.what) {
            case 1:
                textView = this.f14573a.f14560h;
                str = this.f14573a.f14563k;
                textView.setText(str);
                list = this.f14573a.f14561i;
                if (list.size() > 1) {
                    context = this.f14573a.mContext;
                    Drawable drawable = context.getResources().getDrawable(R.drawable.down_red_arrow);
                    drawable.setBounds(0, 0, 19, 11);
                    textView4 = this.f14573a.f14560h;
                    textView4.setCompoundDrawables(null, null, drawable, null);
                    textView5 = this.f14573a.f14560h;
                    textView5.setOnClickListener(this.f14573a);
                    return;
                }
                textView2 = this.f14573a.f14560h;
                textView2.setCompoundDrawables(null, null, null, null);
                textView3 = this.f14573a.f14560h;
                textView3.setOnClickListener(null);
                return;
            case 2:
                OneKeyFeedbackHistoryFragment.m6015i(this.f14573a);
                oneKeyFeedbackHistoryAdapter = this.f14573a.f14567o;
                oneKeyFeedbackHistoryAdapter.f14538a = null;
                oneKeyFeedbackHistoryAdapter2 = this.f14573a.f14567o;
                oneKeyFeedbackHistoryAdapter2.notifyDataSetChanged();
                textView6 = this.f14573a.f14560h;
                str2 = this.f14573a.f14563k;
                textView6.setText(str2);
                this.f14573a.f14565m = null;
                context2 = this.f14573a.mContext;
                if (context2 != null) {
                    context4 = this.f14573a.mContext;
                    context4.sendBroadcast(new Intent("logout"));
                    context5 = this.f14573a.mContext;
                    PreferencesManager.m9595a(context5).m9588a("token", "");
                    context6 = this.f14573a.mContext;
                    PreferencesManager.m9595a(context6).m9587a("isconflict", true);
                    context7 = this.f14573a.mContext;
                    PreferencesManager.m9595a(context7).m9588a("login_state", "0");
                    context8 = this.f14573a.mContext;
                    PreferencesManager.m9595a(context8).m9588a("if_auto_login", "0");
                }
                context3 = this.f14573a.mContext;
                MessageDialog messageDialog = new MessageDialog(context3, (int) R.string.login_conflict_dialog_title, (int) R.string.login_conflict_dialog_content);
                messageDialog.m4719a(R.string.btn_confirm, true, new View$OnClickListenerC2525aj(this));
                messageDialog.m4717b(R.string.btn_canlce, true, null);
                if (this.f14573a.isVisible()) {
                    messageDialog.show();
                    return;
                }
                return;
            case 3:
                OneKeyFeedbackHistoryFragment.m6015i(this.f14573a);
                oneKeyFeedbackHistoryAdapter3 = this.f14573a.f14567o;
                oneKeyFeedbackHistoryAdapter3.f14538a = null;
                oneKeyFeedbackHistoryAdapter4 = this.f14573a.f14567o;
                oneKeyFeedbackHistoryAdapter4.notifyDataSetChanged();
                textView7 = this.f14573a.f14560h;
                str3 = this.f14573a.f14563k;
                textView7.setText(str3);
                if (this.f14573a.isVisible()) {
                    loginDialog = this.f14573a.f14565m;
                    if (loginDialog != null) {
                        loginDialog2 = this.f14573a.f14565m;
                        loginDialog2.show();
                        return;
                    }
                    OneKeyFeedbackHistoryFragment oneKeyFeedbackHistoryFragment = this.f14573a;
                    context9 = oneKeyFeedbackHistoryFragment.mContext;
                    oneKeyFeedbackHistoryFragment.f14565m = new C2526ak(this, context9).m6572d();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
