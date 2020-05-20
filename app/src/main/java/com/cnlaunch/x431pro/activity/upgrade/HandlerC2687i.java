package com.cnlaunch.x431pro.activity.upgrade;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.TextView;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.activity.upgrade.DownloadFragment;
import com.cnlaunch.x431pro.activity.upgrade.p238a.DownloadAdapter;
import com.cnlaunch.x431pro.module.p269j.p271b.DownloadSoftDto;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.widget.button.IconButton;
import com.cnlaunch.x431pro.widget.p290a.MessageDialog;
import com.ifoer.expedition.pro.R;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DownloadFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.upgrade.i */
/* loaded from: classes.dex */
public final class HandlerC2687i extends Handler {

    /* renamed from: a */
    final /* synthetic */ DownloadFragment f15414a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC2687i(DownloadFragment downloadFragment) {
        this.f15414a = downloadFragment;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message2) {
        Integer num;
        Integer num2;
        Integer num3;
        IconButton iconButton;
        IconButton iconButton2;
        IconButton iconButton3;
        IconButton iconButton4;
        IconButton iconButton5;
        TextView textView;
        Integer num4;
        Context context;
        Context context2;
        Context context3;
        Context context4;
        Context context5;
        Context context6;
        Context context7;
        Context context8;
        Context context9;
        Context context10;
        Context context11;
        Map map;
        Map map2;
        Map map3;
        Map map4;
        ThreadPoolExecutor threadPoolExecutor;
        Map map5;
        boolean z;
        Integer num5;
        Integer num6;
        Integer num7;
        Context context12;
        Context context13;
        Context context14;
        Context context15;
        Integer num8;
        Integer num9;
        Context context16;
        Context context17;
        Integer num10;
        Integer num11;
        Context context18;
        IconButton iconButton6;
        Context context19;
        IconButton iconButton7;
        IconButton iconButton8;
        Context context20;
        BroadcastReceiver broadcastReceiver;
        Context context21;
        Context context22;
        BroadcastReceiver broadcastReceiver2;
        IntentFilter intentFilter;
        Context context23;
        Context context24;
        Context context25;
        Context context26;
        Context context27;
        IconButton iconButton9;
        IconButton iconButton10;
        ThreadPoolExecutor threadPoolExecutor2;
        IconButton iconButton11;
        IconButton iconButton12;
        Context context28;
        DownloadAdapter downloadAdapter;
        IconButton iconButton13;
        Context context29;
        IconButton iconButton14;
        IconButton iconButton15;
        IconButton iconButton16;
        ThreadPoolExecutor threadPoolExecutor3;
        Context context30;
        IconButton iconButton17;
        IconButton iconButton18;
        IconButton iconButton19;
        DownloadAdapter downloadAdapter2;
        IconButton iconButton20;
        IconButton iconButton21;
        IconButton iconButton22;
        DownloadAdapter downloadAdapter3;
        int i;
        TextView textView2;
        TextView textView3;
        int i2;
        int i3;
        TextView textView4;
        switch (message2.what) {
            case 1:
                num = this.f15414a.f15355G;
                num.intValue();
                if (this.f15414a.getActivity() != null) {
                    num2 = this.f15414a.f15355G;
                    if (num2.intValue() >= this.f15414a.f15352D.size()) {
                        iconButton3 = this.f15414a.f15350B;
                        iconButton3.setText(R.string.down_retry_txt);
                        Drawable drawable = this.f15414a.getResources().getDrawable(R.drawable.select_btn_update_retry);
                        drawable.setBounds(0, 0, 50, 50);
                        iconButton4 = this.f15414a.f15350B;
                        iconButton4.setImage(drawable);
                        iconButton5 = this.f15414a.f15350B;
                        iconButton5.setEnabled(true);
                        return;
                    }
                    num3 = this.f15414a.f15356H;
                    if (num3.intValue() > 0) {
                        iconButton = this.f15414a.f15350B;
                        iconButton.setText(R.string.down_retry_txt);
                        Drawable drawable2 = this.f15414a.getResources().getDrawable(R.drawable.select_btn_update_retry);
                        drawable2.setBounds(0, 0, 50, 50);
                        iconButton2 = this.f15414a.f15350B;
                        iconButton2.setImage(drawable2);
                        return;
                    }
                    return;
                }
                return;
            case 2:
                textView = this.f15414a.f15404y;
                DownloadFragment downloadFragment = this.f15414a;
                num4 = downloadFragment.f15355G;
                textView.setText(downloadFragment.m5546a(String.valueOf(num4), String.valueOf(this.f15414a.f15352D.size())));
                if (!C2744aa.m5166c()) {
                    if (!TextUtils.isEmpty(this.f15414a.f15353E)) {
                        String str = this.f15414a.f15353E;
                        context8 = this.f15414a.mContext;
                        if (C2744aa.m5168b(str, context8)) {
                            context9 = this.f15414a.mContext;
                            int m9585b = PreferencesManager.m9595a(context9).m9585b("unupdateSoftwareNum", 0) - 1;
                            if (m9585b <= 0) {
                                m9585b = 0;
                            }
                            context10 = this.f15414a.mContext;
                            PreferencesManager.m9595a(context10).m9590a("unupdateSoftwareNum", m9585b);
                        }
                    }
                    if (!TextUtils.isEmpty(this.f15414a.f15353E)) {
                        String str2 = this.f15414a.f15353E;
                        context5 = this.f15414a.mContext;
                        if (C2744aa.m5177a(str2, context5)) {
                            context6 = this.f15414a.mContext;
                            int m9585b2 = PreferencesManager.m9595a(context6).m9585b("unupdateSoftwareNumForHeavyduty", 0) - 1;
                            if (m9585b2 <= 0) {
                                m9585b2 = 0;
                            }
                            context7 = this.f15414a.mContext;
                            PreferencesManager.m9595a(context7).m9590a("unupdateSoftwareNumForHeavyduty", m9585b2);
                        }
                    }
                    if (!TextUtils.isEmpty(this.f15414a.f15353E)) {
                        String str3 = this.f15414a.f15353E;
                        context = this.f15414a.mContext;
                        if (C2744aa.m5161c(str3, context)) {
                            context2 = this.f15414a.mContext;
                            int m9585b3 = PreferencesManager.m9595a(context2).m9585b("unupdateSoftwareNum", 0) - 1;
                            if (m9585b3 <= 0) {
                                m9585b3 = 0;
                            }
                            context3 = this.f15414a.mContext;
                            PreferencesManager.m9595a(context3).m9590a("unupdateSoftwareNum", m9585b3);
                            context4 = this.f15414a.mContext;
                            PreferencesManager.m9595a(context4).m9590a("unupdateSoftwareNumForHeavyduty", 0);
                        }
                    }
                } else {
                    DownloadFragment.m5473l(this.f15414a);
                }
                Intent intent = new Intent("unupgradeSoftNumChanged");
                context11 = this.f15414a.mContext;
                context11.sendBroadcast(intent);
                return;
            case 3:
                this.f15414a.f15401v.f7053a = null;
                this.f15414a.f15401v.m9549c();
                if (C2744aa.m5121t() || this.f15414a.f15365Q) {
                    map = this.f15414a.f15378ac;
                    if (!map.isEmpty()) {
                        this.f15414a.m5483g();
                        map2 = this.f15414a.f15378ac;
                        map3 = this.f15414a.f15378ac;
                        map4 = this.f15414a.f15378ac;
                        threadPoolExecutor = this.f15414a.f15362N;
                        threadPoolExecutor.submit(new DownloadFragment.RunnableC2684b((String) map2.get("fileName"), (String) map3.get("filePath"), (String) map4.get("softPackageID")));
                        map5 = this.f15414a.f15378ac;
                        map5.clear();
                        return;
                    }
                }
                z = this.f15414a.f15359K;
                if (z) {
                    num10 = this.f15414a.f15357I;
                    int intValue = num10.intValue();
                    num11 = this.f15414a.f15358J;
                    if (intValue < num11.intValue()) {
                        this.f15414a.m5483g();
                        return;
                    }
                }
                num5 = this.f15414a.f15356H;
                if (num5.intValue() > 0) {
                    num8 = this.f15414a.f15356H;
                    int intValue2 = num8.intValue();
                    num9 = this.f15414a.f15354F;
                    if (intValue2 < num9.intValue()) {
                        if (!this.f15414a.isVisible()) {
                            this.f15414a.m5483g();
                            context17 = this.f15414a.mContext;
                            NToast.m9450a(context17, (int) R.string.txt_update_failed_partly);
                            return;
                        }
                        context16 = this.f15414a.mContext;
                        new DialogC2688j(this, context16).m4670a(R.string.tab_menu_upgrade, R.string.txt_update_failed_partly);
                        return;
                    }
                }
                num6 = this.f15414a.f15356H;
                if (num6.intValue() <= 0) {
                    num7 = this.f15414a.f15355G;
                    if (num7.intValue() >= this.f15414a.f15352D.size()) {
                        if (!this.f15414a.isVisible()) {
                            this.f15414a.m5483g();
                            context13 = this.f15414a.mContext;
                            NToast.m9450a(context13, (int) R.string.txt_update_ok);
                            this.f15414a.f15363O.sendBroadcast(new Intent("refresh_softs"));
                            DownloadFragment.m5484f(this.f15414a);
                            return;
                        }
                        context12 = this.f15414a.mContext;
                        DialogC2690l dialogC2690l = new DialogC2690l(this, context12);
                        dialogC2690l.setTitle(R.string.tab_menu_upgrade);
                        dialogC2690l.m4714e(R.string.txt_update_ok);
                        dialogC2690l.setCancelable(true);
                        dialogC2690l.m4719a(R.string.common_confirm, true, new View$OnClickListenerC2663c(dialogC2690l));
                        dialogC2690l.m4717b(R.string.continue_update, true, new View$OnClickListenerC2681d(dialogC2690l));
                        dialogC2690l.m4713f(2);
                        dialogC2690l.show();
                        return;
                    }
                    return;
                } else if (!this.f15414a.isVisible()) {
                    this.f15414a.m5483g();
                    context15 = this.f15414a.mContext;
                    NToast.m9450a(context15, (int) R.string.txt_update_failed);
                    return;
                } else {
                    context14 = this.f15414a.mContext;
                    new DialogC2689k(this, context14).m4670a(R.string.tab_menu_upgrade, R.string.txt_update_failed);
                    return;
                }
            case 4:
                context18 = this.f15414a.mContext;
                if (context18 != null) {
                    context20 = this.f15414a.mContext;
                    broadcastReceiver = this.f15414a.f15366R;
                    context20.unregisterReceiver(broadcastReceiver);
                    context21 = this.f15414a.mContext;
                    context21.sendBroadcast(new Intent("logout"));
                    context22 = this.f15414a.mContext;
                    broadcastReceiver2 = this.f15414a.f15366R;
                    intentFilter = this.f15414a.f15367S;
                    context22.registerReceiver(broadcastReceiver2, intentFilter);
                    context23 = this.f15414a.mContext;
                    PreferencesManager.m9595a(context23).m9588a("token", "");
                    context24 = this.f15414a.mContext;
                    PreferencesManager.m9595a(context24).m9587a("isconflict", true);
                    context25 = this.f15414a.mContext;
                    PreferencesManager.m9595a(context25).m9588a("login_state", "0");
                    context26 = this.f15414a.mContext;
                    PreferencesManager.m9595a(context26).m9588a("if_auto_login", "0");
                }
                iconButton6 = this.f15414a.f15350B;
                iconButton6.setText(R.string.down_retry_txt);
                if (this.f15414a.getActivity() != null) {
                    Drawable drawable3 = this.f15414a.getResources().getDrawable(R.drawable.select_btn_update_retry);
                    drawable3.setBounds(0, 0, 50, 50);
                    iconButton7 = this.f15414a.f15350B;
                    iconButton7.setImage(drawable3);
                    iconButton8 = this.f15414a.f15350B;
                    iconButton8.setEnabled(true);
                }
                context19 = this.f15414a.mContext;
                MessageDialog messageDialog = new MessageDialog(context19, (int) R.string.login_conflict_dialog_title, (int) R.string.login_conflict_dialog_content);
                messageDialog.m4719a(R.string.btn_confirm, true, new View$OnClickListenerC2691m(this));
                messageDialog.m4717b(R.string.btn_canlce, true, null);
                messageDialog.show();
                return;
            case 5:
                context27 = this.f15414a.mContext;
                new C2692n(this, context27).m6572d();
                return;
            case 6:
                this.f15414a.m5491c();
                this.f15414a.f15356H = 0;
                iconButton9 = this.f15414a.f15350B;
                iconButton9.setText(R.string.down_stop_txt);
                Drawable drawable4 = this.f15414a.getResources().getDrawable(R.drawable.select_btn_update_stop);
                drawable4.setBounds(0, 0, 50, 50);
                iconButton10 = this.f15414a.f15350B;
                iconButton10.setImage(drawable4);
                this.f15414a.m5493b();
                return;
            case 7:
                this.f15414a.f15401v.f7053a = null;
                this.f15414a.f15401v.m9549c();
                threadPoolExecutor2 = this.f15414a.f15362N;
                threadPoolExecutor2.shutdownNow();
                iconButton11 = this.f15414a.f15350B;
                iconButton11.setText(R.string.down_continue_txt);
                Drawable drawable5 = this.f15414a.getResources().getDrawable(R.drawable.select_btn_update_download);
                drawable5.setBounds(0, 0, 50, 50);
                iconButton12 = this.f15414a.f15350B;
                iconButton12.setImage(drawable5);
                return;
            case 8:
                context28 = this.f15414a.mContext;
                new DialogC2693o(this, context28).m4670a(R.string.tab_menu_upgrade, R.string.txt_error_conflict_signature);
                return;
            case 9:
                downloadAdapter = this.f15414a.f15402w;
                downloadAdapter.notifyDataSetChanged();
                return;
            case 10:
                iconButton13 = this.f15414a.f15350B;
                iconButton13.setEnabled(message2.arg1 != 0);
                return;
            case 11:
                context29 = this.f15414a.mContext;
                DialogC2694p dialogC2694p = new DialogC2694p(this, context29);
                dialogC2694p.setTitle(R.string.tab_menu_upgrade);
                dialogC2694p.m4714e(R.string.txt_less_storage_space);
                dialogC2694p.setCancelable(true);
                dialogC2694p.m4719a(R.string.common_confirm, true, null);
                dialogC2694p.m4713f(2);
                dialogC2694p.show();
                iconButton14 = this.f15414a.f15350B;
                iconButton14.setText(R.string.down_retry_txt);
                if (this.f15414a.getActivity() != null) {
                    Drawable drawable6 = this.f15414a.getResources().getDrawable(R.drawable.select_btn_update_retry);
                    drawable6.setBounds(0, 0, 50, 50);
                    iconButton15 = this.f15414a.f15350B;
                    iconButton15.setImage(drawable6);
                    iconButton16 = this.f15414a.f15350B;
                    iconButton16.setEnabled(true);
                    return;
                }
                return;
            case 12:
                this.f15414a.f15401v.f7053a = null;
                this.f15414a.f15401v.m9549c();
                threadPoolExecutor3 = this.f15414a.f15362N;
                threadPoolExecutor3.shutdownNow();
                for (DownloadSoftDto downloadSoftDto : this.f15414a.f15352D) {
                    if (1 == downloadSoftDto.f15579e.intValue()) {
                        downloadSoftDto.f15578d = 100;
                        downloadSoftDto.f15579e = 3;
                        downloadAdapter2 = this.f15414a.f15402w;
                        downloadAdapter2.notifyDataSetChanged();
                    }
                }
                context30 = this.f15414a.mContext;
                new MessageDialog(context30).m4670a(R.string.tab_menu_upgrade, R.string.common_network_error);
                iconButton17 = this.f15414a.f15350B;
                iconButton17.setText(R.string.down_retry_txt);
                if (this.f15414a.getActivity() != null) {
                    Drawable drawable7 = this.f15414a.getResources().getDrawable(R.drawable.select_btn_update_retry);
                    drawable7.setBounds(0, 0, 50, 50);
                    iconButton18 = this.f15414a.f15350B;
                    iconButton18.setImage(drawable7);
                    iconButton19 = this.f15414a.f15350B;
                    iconButton19.setEnabled(true);
                    return;
                }
                return;
            case 13:
                for (DownloadSoftDto downloadSoftDto2 : this.f15414a.f15352D) {
                    if (1 == downloadSoftDto2.f15579e.intValue()) {
                        downloadSoftDto2.f15578d = 100;
                        downloadSoftDto2.f15579e = 3;
                        downloadAdapter3 = this.f15414a.f15402w;
                        downloadAdapter3.notifyDataSetChanged();
                    }
                }
                iconButton20 = this.f15414a.f15350B;
                iconButton20.setText(R.string.down_retry_txt);
                if (this.f15414a.getActivity() != null) {
                    Drawable drawable8 = this.f15414a.getResources().getDrawable(R.drawable.select_btn_update_retry);
                    drawable8.setBounds(0, 0, 50, 50);
                    iconButton21 = this.f15414a.f15350B;
                    iconButton21.setImage(drawable8);
                    iconButton22 = this.f15414a.f15350B;
                    iconButton22.setEnabled(true);
                    return;
                }
                return;
            case 14:
                this.f15414a.f15371W = message2.arg1;
                i = this.f15414a.f15371W;
                if (i < 20) {
                    i3 = this.f15414a.f15371W;
                    if (i3 > 0) {
                        textView4 = this.f15414a.f15368T;
                        textView4.setTextColor(-65536);
                        textView3 = this.f15414a.f15368T;
                        StringBuilder sb = new StringBuilder();
                        i2 = this.f15414a.f15371W;
                        sb.append(i2);
                        sb.append("KB/S");
                        textView3.setText(sb.toString());
                        return;
                    }
                }
                textView2 = this.f15414a.f15368T;
                textView2.setTextColor(-16777216);
                textView3 = this.f15414a.f15368T;
                StringBuilder sb2 = new StringBuilder();
                i2 = this.f15414a.f15371W;
                sb2.append(i2);
                sb2.append("KB/S");
                textView3.setText(sb2.toString());
                return;
            default:
                return;
        }
    }
}
