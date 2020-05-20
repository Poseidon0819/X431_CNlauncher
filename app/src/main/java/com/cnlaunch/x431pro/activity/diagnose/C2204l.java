package com.cnlaunch.x431pro.activity.diagnose;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.x431pro.activity.MainActivity;
import com.cnlaunch.x431pro.widget.MyViewPager;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.cnlaunch.x431pro.widget.p290a.MessageDialog;
import com.ifoer.expedition.pro.R;

/* compiled from: CarIconFragmentForAll.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.l */
/* loaded from: classes.dex */
final class C2204l extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ CarIconFragmentForAll f12478a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2204l(CarIconFragmentForAll carIconFragmentForAll) {
        this.f12478a = carIconFragmentForAll;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String str;
        MyViewPager myViewPager;
        String str2;
        int i;
        int i2;
        PopupWindow popupWindow;
        RadioButton radioButton;
        RadioButton radioButton2;
        RadioButton radioButton3;
        MessageDialog messageDialog;
        MessageDialog messageDialog2;
        MessageDialog messageDialog3;
        MessageDialog messageDialog4;
        Context context2;
        MessageDialog messageDialog5;
        MessageDialog messageDialog6;
        MessageDialog messageDialog7;
        Context context3;
        Context context4;
        Context context5;
        Context context6;
        Context context7;
        Context context8;
        Context context9;
        String str3;
        String str4;
        String str5;
        String str6;
        Context context10;
        Context context11;
        String action = intent.getAction();
        str = CarIconFragmentForAll.f11144b;
        NLog.m9456a(str, "action=".concat(String.valueOf(action)));
        if (action.equals("softs_updated")) {
            context8 = this.f12478a.mContext;
            String m9591a = PreferencesManager.m9595a(context8).m9591a("carSerialNo");
            context9 = this.f12478a.mContext;
            String m9591a2 = PreferencesManager.m9595a(context9).m9591a("heavydutySerialNo");
            str3 = this.f12478a.f11190aa;
            if (TextUtils.isEmpty(str3) || !TextUtils.isEmpty(m9591a)) {
                str4 = this.f12478a.f11190aa;
                if (m9591a.equals(str4)) {
                    str5 = this.f12478a.f11170Z;
                    if (TextUtils.isEmpty(str5) || !TextUtils.isEmpty(m9591a2)) {
                        str6 = this.f12478a.f11170Z;
                        if (m9591a2.equals(str6)) {
                            return;
                        }
                    }
                }
            }
            this.f12478a.m7544i();
            CarIconFragmentForAll.m7561c();
            this.f12478a.f11190aa = m9591a;
            this.f12478a.f11170Z = m9591a2;
            this.f12478a.request(10011, false);
            context10 = this.f12478a.mContext;
            PreferencesManager.m9595a(context10).m9587a("need_refresh", false);
            context11 = this.f12478a.mContext;
            LoadDialog.m4684a(context11, this.f12478a.getString(R.string.caricon_loading));
        } else if (action.equals("refresh_softs")) {
            if (MainActivity.m7871h() != R.id.btn_diagnose) {
                return;
            }
            CarIconFragmentForAll carIconFragmentForAll = this.f12478a;
            context3 = carIconFragmentForAll.mContext;
            carIconFragmentForAll.f11168X = PreferencesManager.m9595a(context3).m9591a("serialNo");
            CarIconFragmentForAll carIconFragmentForAll2 = this.f12478a;
            context4 = carIconFragmentForAll2.mContext;
            carIconFragmentForAll2.f11190aa = PreferencesManager.m9595a(context4).m9591a("carSerialNo");
            CarIconFragmentForAll carIconFragmentForAll3 = this.f12478a;
            context5 = carIconFragmentForAll3.mContext;
            carIconFragmentForAll3.f11170Z = PreferencesManager.m9595a(context5).m9591a("heavydutySerialNo");
            context6 = this.f12478a.mContext;
            PreferencesManager.m9595a(context6).m9587a("need_refresh", false);
            this.f12478a.m7544i();
            this.f12478a.request(10011, false);
            context7 = this.f12478a.mContext;
            LoadDialog.m4684a(context7, this.f12478a.getString(R.string.caricon_loading));
        } else if (action.equals("login")) {
            messageDialog4 = this.f12478a.f11203ao;
            if (messageDialog4 != null) {
                messageDialog5 = this.f12478a.f11203ao;
                if (messageDialog5.isShowing()) {
                    messageDialog6 = this.f12478a.f11203ao;
                    messageDialog6.cancel();
                    messageDialog7 = this.f12478a.f11203ao;
                    messageDialog7.dismiss();
                    CarIconFragmentForAll.m7538n(this.f12478a);
                }
            }
            this.f12478a.f11211aw = false;
            context2 = this.f12478a.mContext;
            PreferencesManager.m9595a(context2).m9590a("shopStatistics", 0);
            this.f12478a.request(2200);
        } else if (action.equals("LoginActivityKeyBack")) {
            messageDialog = this.f12478a.f11203ao;
            if (messageDialog != null) {
                messageDialog2 = this.f12478a.f11203ao;
                if (messageDialog2.isShowing()) {
                    return;
                }
                messageDialog3 = this.f12478a.f11203ao;
                messageDialog3.show();
            }
        } else if (action.equals("login_change_serialno")) {
            this.f12478a.f11211aw = true;
            CarIconFragmentForAll.m7536p(this.f12478a);
            this.f12478a.m7548g();
        } else if (action.equals("addedFavorites")) {
            CarIconFragmentForAll.m7534r(this.f12478a);
            str2 = CarIconFragmentForAll.f11144b;
            StringBuilder sb = new StringBuilder("newAddedFavorites=");
            i = this.f12478a.f11175aD;
            sb.append(i);
            NLog.m9456a(str2, sb.toString());
            CarIconFragmentForAll carIconFragmentForAll4 = this.f12478a;
            i2 = carIconFragmentForAll4.f11175aD;
            carIconFragmentForAll4.m7555d(i2);
            popupWindow = this.f12478a.f11176aE;
            radioButton = this.f12478a.f11198ai;
            radioButton2 = this.f12478a.f11198ai;
            radioButton3 = this.f12478a.f11198ai;
            popupWindow.showAsDropDown(radioButton, radioButton2.getWidth() - 15, -radioButton3.getHeight());
            this.f12478a.request(10010, false);
        } else if (action.equals("deletedFavorites")) {
            this.f12478a.request(10010, false);
        } else if (action.equals("stopDrag")) {
            myViewPager = this.f12478a.f11224l;
            myViewPager.setScrollable(false);
            ((DiagnoseActivity) this.f12478a.getActivity()).m7732g().setSlidingEnabled(true);
        }
    }
}
