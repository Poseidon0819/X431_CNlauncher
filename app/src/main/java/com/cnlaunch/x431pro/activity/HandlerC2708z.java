package com.cnlaunch.x431pro.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.cnlaunch.x431pro.activity.login.CompleteUserInfoActivity;
import com.cnlaunch.x431pro.activity.login.LoginFunction;
import com.cnlaunch.x431pro.module.p272k.p274b.UserBaseInfo;
import com.cnlaunch.x431pro.module.p272k.p274b.ZipcodeInfoResponse;
import com.cnlaunch.x431pro.utils.C2787z;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.cnlaunch.x431pro.widget.p290a.MessageDialog;
import com.ifoer.expedition.pro.R;

/* compiled from: MainActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.z */
/* loaded from: classes.dex */
final class HandlerC2708z extends Handler {

    /* renamed from: a */
    final /* synthetic */ MainActivity f15438a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC2708z(MainActivity mainActivity) {
        this.f15438a = mainActivity;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message2) {
        switch (message2.what) {
            case 1:
                LoadDialog.m4684a(this.f15438a.f10736a, this.f15438a.f10736a.getResources().getString(R.string.get_sn_tips));
                return;
            case 2:
                LoadDialog.m4681b(this.f15438a.f10736a);
                this.f15438a.sendBroadcast(new Intent("mineMessageNumChanged"));
                this.f15438a.sendBroadcast(new Intent("refreshtip"));
                return;
            case 3:
                new LoginFunction(this.f15438a.f10736a).m6586a((ZipcodeInfoResponse) message2.getData().getSerializable("ZIPINFO"));
                return;
            case 4:
                String string = message2.getData().getString("FAILEDTIPS");
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                new MessageDialog(this.f15438a.f10736a).m4669a(this.f15438a.getString(R.string.add_zipcode_failed), string);
                return;
            case 5:
                UserBaseInfo userBaseInfo = (UserBaseInfo) message2.getData().getSerializable("USERBASEINFO");
                String email = userBaseInfo.getEmail();
                String mobile = userBaseInfo.getMobile();
                if (C2787z.m4821a(email) || C2787z.m4821a(mobile)) {
                    new LoginFunction(this.f15438a.f10736a).m6585a(userBaseInfo);
                    return;
                }
                return;
            case 6:
                UserBaseInfo userBaseInfo2 = (UserBaseInfo) message2.getData().getSerializable("USERBASEINFO");
                if (C2787z.m4821a(userBaseInfo2.getCompany())) {
                    Intent intent = new Intent(this.f15438a.f10736a, CompleteUserInfoActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("USERBASEINFO", userBaseInfo2);
                    intent.putExtras(bundle);
                    this.f15438a.f10736a.startActivity(intent);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
