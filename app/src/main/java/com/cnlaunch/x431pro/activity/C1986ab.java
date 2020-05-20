package com.cnlaunch.x431pro.activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RadioButton;
import android.widget.TextView;
import com.cnlaunch.defend.DefendService;
import com.cnlaunch.golo3.p165g.GoloActivityManager;
import com.cnlaunch.p120d.p121a.ActivityPageManager;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p169im.IMActivity;
import com.cnlaunch.p169im.p173d.NoticeMessageHandler;
import com.cnlaunch.p169im.p176f.IMManager;
import com.cnlaunch.x431pro.activity.login.LoginFunction;
import com.cnlaunch.x431pro.module.history.model.VehicleInfo;
import com.cnlaunch.x431pro.module.p242ad.AdUtil;
import com.cnlaunch.x431pro.module.p252d.p254b.RemoteDiagRunningInfo;
import com.cnlaunch.x431pro.p210a.CommonTools;
import com.cnlaunch.x431pro.p210a.LoginTools;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.ifoer.expedition.pro.R;
import message.model.ChatRoom;

/* compiled from: MainActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.ab */
/* loaded from: classes.dex */
final class C1986ab extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ MainActivity f10881a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1986ab(MainActivity mainActivity) {
        this.f10881a = mainActivity;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        TextView textView6;
        RadioButton radioButton;
        RadioButton radioButton2;
        RadioButton radioButton3;
        String action = intent.getAction();
        if (action.equalsIgnoreCase("show_update")) {
            this.f10881a.m7894b(R.id.btn_upgrade);
        } else if (action.equalsIgnoreCase("show_remotediag")) {
            this.f10881a.m7894b(R.id.btn_diagnose);
            Bundle extras = intent.getExtras();
            RemoteDiagRunningInfo remoteDiagRunningInfo = new RemoteDiagRunningInfo();
            remoteDiagRunningInfo.setInfo(extras);
            Intent intent2 = new Intent("LaunchRemoteDiag");
            intent2.putExtra("RemoteDiagInfo", remoteDiagRunningInfo);
            this.f10881a.sendBroadcast(intent2);
        } else if (action.equalsIgnoreCase("show_cloud_diag")) {
            this.f10881a.m7894b(R.id.btn_diagnose);
            MainActivity.m7867j();
            Bundle extras2 = intent.getExtras();
            if (extras2 != null && extras2.containsKey("HISTORY_FLAG")) {
                VehicleInfo vehicleInfo = (VehicleInfo) extras2.getParcelable("VehicleInfo");
                vehicleInfo.setSysInfo(extras2.getParcelableArrayList("CloudSystemInfo"));
                C2744aa.m5188a((Activity) this.f10881a, vehicleInfo, true);
                return;
            }
            Intent intent3 = new Intent("LaunchCloudDiag");
            intent3.putExtra("VIN", extras2.getString("VIN"));
            intent3.putExtra("package_id", extras2.getString("package_id"));
            this.f10881a.sendBroadcast(intent3);
        } else if (action.equalsIgnoreCase("web_remote_diag")) {
            MainActivity.m7865k();
            this.f10881a.m7894b(R.id.btn_diagnose);
            Bundle extras3 = intent.getExtras();
            Intent intent4 = new Intent("LaunchWebRemoteDiag");
            intent4.putExtra("package_id", extras3.getString("package_id"));
            this.f10881a.sendBroadcast(intent4);
        } else if (action.equalsIgnoreCase("show_Setting")) {
            this.f10881a.f10751r = MainActivity.m7871h();
            MainActivity.m7885c((int) R.id.btn_setting);
            radioButton3 = this.f10881a.f10746l;
            radioButton3.setChecked(true);
        } else if (action.equalsIgnoreCase("show_PrintSetting")) {
            this.f10881a.f10751r = MainActivity.m7871h();
            MainActivity.m7885c((int) R.id.btn_setting);
            radioButton2 = this.f10881a.f10746l;
            radioButton2.setChecked(true);
            this.f10881a.sendBroadcast(new Intent("replace_printSetFragmet"));
        } else if (action.equalsIgnoreCase("show_golo_chatroom")) {
            this.f10881a.mo7897a(IMActivity.class.getName());
            this.f10881a.sendBroadcast(new Intent("showTabSubjectFragment"));
        } else if (action.equalsIgnoreCase("show_verication")) {
            NoticeMessageHandler.m8785a();
            if (MainActivity.m7895b()) {
                return;
            }
            this.f10881a.mo7897a(IMActivity.class.getName());
            this.f10881a.sendBroadcast(new Intent("friend_verication"));
        } else if (action.equalsIgnoreCase("show_golo_message")) {
            NoticeMessageHandler.m8785a();
            if (MainActivity.m7895b()) {
                return;
            }
            this.f10881a.mo7897a(IMActivity.class.getName());
            Intent intent5 = new Intent("ShowMessageFragment");
            intent5.putExtra("ChatRoom", (ChatRoom) intent.getExtras().get("ChatRoom"));
            this.f10881a.sendBroadcast(intent5);
        } else if (action.equalsIgnoreCase("Golo_Notification")) {
            NoticeMessageHandler.m8785a();
            if (MainActivity.m7895b()) {
                return;
            }
            if (intent.getExtras().getBoolean("isGolo")) {
                radioButton = this.f10881a.f10743i;
                radioButton.performClick();
                return;
            }
            this.f10881a.mo7897a(IMActivity.class.getName());
            Intent intent6 = new Intent("showSubFragment");
            intent6.putExtra("subtype", intent.getExtras().getInt("subtype"));
            intent6.putExtra("isGolo", intent.getExtras().getBoolean("isGolo"));
            this.f10881a.sendBroadcast(intent6);
        } else if (action.equalsIgnoreCase("defend_is_enable")) {
            MainActivity mainActivity = this.f10881a;
            mainActivity.startService(new Intent(mainActivity, DefendService.class));
        } else if (action.equalsIgnoreCase("golo_is_enable")) {
            if (LoginTools.m7946a(this.f10881a.f10736a) && IMManager.m8732a()) {
                new LoginFunction(this.f10881a.f10736a).m6592a();
            }
        } else if (action.equals("unupgradeSoftNumChanged")) {
            MainActivity mainActivity2 = this.f10881a;
            mainActivity2.f10715D = (TextView) mainActivity2.findViewById(R.id.upgrade_num_tip);
            int m9585b = PreferencesManager.m9595a(this.f10881a.f10736a).m9585b("unupdateSoftwareNum", 0) + PreferencesManager.m9595a(this.f10881a.f10736a).m9585b("unupdateSoftwareNumForHeavyduty", 0);
            textView4 = this.f10881a.f10715D;
            textView4.setText(String.valueOf(m9585b));
            if (m9585b != 0) {
                textView6 = this.f10881a.f10715D;
                textView6.setVisibility(0);
                return;
            }
            textView5 = this.f10881a.f10715D;
            textView5.setVisibility(8);
        } else if (action.equals("notifyShopStatisticsChanged")) {
            int m9585b2 = PreferencesManager.m9595a(this.f10881a.f10736a).m9585b("shopStatistics", 0);
            MainActivity mainActivity3 = this.f10881a;
            mainActivity3.f10723L = (TextView) mainActivity3.findViewById(R.id.seller_message_count_tip);
            String valueOf = String.valueOf(m9585b2);
            if (m9585b2 == 0 || TextUtils.isEmpty(valueOf)) {
                textView = this.f10881a.f10723L;
                textView.setVisibility(8);
                return;
            }
            textView2 = this.f10881a.f10723L;
            textView2.setVisibility(0);
            textView3 = this.f10881a.f10723L;
            textView3.setText(valueOf);
        } else if (action.equals("mineMessageNumChanged")) {
            this.f10881a.m7859n();
            this.f10881a.sendBroadcast(new Intent("refreshtip"));
        } else if (action.equalsIgnoreCase("show_repairinfo")) {
            this.f10881a.m7894b(R.id.btn_info);
        } else if (action.equalsIgnoreCase("android.intent.action.LOCALE_CHANGED")) {
            GoloActivityManager.m9138a();
            Context unused = this.f10881a.f10736a;
            GoloActivityManager.m9136b();
            ActivityPageManager.m9634a();
            ActivityPageManager.m9632a(this.f10881a.f10736a);
            Runtime.getRuntime().exit(0);
        } else if ("android.intent.action.SCREEN_ON".equals(action) && CommonTools.m7966b(this.f10881a.f10736a)) {
            try {
                AdUtil.m5431a().m5430a(this.f10881a.getLocalActivityManager().getCurrentActivity());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
