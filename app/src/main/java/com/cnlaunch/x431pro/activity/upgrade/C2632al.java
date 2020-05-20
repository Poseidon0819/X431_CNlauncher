package com.cnlaunch.x431pro.activity.upgrade;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.x431pro.activity.login.LoginFunction;
import com.cnlaunch.x431pro.activity.upgrade.p238a.UpgradeAdapter;
import com.cnlaunch.x431pro.module.p269j.p271b.X431PadDtoSoft;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.ifoer.expedition.pro.R;
import java.util.List;

/* compiled from: UpgradeFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.upgrade.al */
/* loaded from: classes.dex */
final class C2632al extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ UpgradeFragment f15129a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2632al(UpgradeFragment upgradeFragment) {
        this.f15129a = upgradeFragment;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        UpgradeAdapter upgradeAdapter;
        UpgradeAdapter upgradeAdapter2;
        List list;
        TextView textView;
        TextView textView2;
        List list2;
        List list3;
        boolean z;
        Context context2;
        Handler handler;
        Handler handler2;
        boolean z2;
        UpgradeAdapter upgradeAdapter3;
        UpgradeAdapter upgradeAdapter4;
        String str;
        boolean z3;
        Context context3;
        Context context4;
        Context context5;
        TextView textView3;
        TextView textView4;
        String action = intent.getAction();
        if (action.equalsIgnoreCase("login_change_serialno")) {
            this.f15129a.m5754h();
            list = this.f15129a.f15115u;
            if (list.size() > 1) {
                context5 = this.f15129a.mContext;
                Drawable drawable = context5.getResources().getDrawable(R.drawable.down_red_arrow);
                drawable.setBounds(0, 0, 19, 11);
                textView3 = this.f15129a.f15072F;
                textView3.setCompoundDrawables(null, null, drawable, null);
                textView4 = this.f15129a.f15072F;
                textView4.setOnClickListener(this.f15129a);
            } else {
                textView = this.f15129a.f15072F;
                textView.setCompoundDrawables(null, null, null, null);
                textView2 = this.f15129a.f15072F;
                textView2.setOnClickListener(null);
            }
            list2 = this.f15129a.f15115u;
            if (list2.size() == 0) {
                list3 = this.f15129a.f15115u;
                if (list3.size() == 0) {
                    if (this.f15129a.isVisible() && !LoginFunction.m6569f()) {
                        context2 = this.f15129a.mContext;
                        if (PreferencesManager.m9595a(context2).m9583b("iSGetSerialNumberFailed", false)) {
                            handler = this.f15129a.f15109o;
                            Message obtainMessage = handler.obtainMessage(7, 0, 0);
                            handler2 = this.f15129a.f15109o;
                            handler2.sendMessage(obtainMessage);
                        }
                    }
                    z = this.f15129a.f15077K;
                    if (z) {
                        UpgradeFragment.m5749k(this.f15129a);
                        UpgradeFragment.m5745o(this.f15129a);
                        UpgradeFragment.m5744p(this.f15129a);
                        this.f15129a.m5762d();
                        return;
                    }
                    return;
                }
                return;
            }
            if (this.f15129a.isVisible()) {
                z3 = this.f15129a.f15077K;
                if (z3) {
                    context3 = this.f15129a.mContext;
                    context4 = this.f15129a.mContext;
                    LoadDialog.m4684a(context3, context4.getString(R.string.refresh_txt));
                }
            }
            z2 = this.f15129a.f15077K;
            if (z2) {
                UpgradeFragment.m5749k(this.f15129a);
                upgradeAdapter3 = this.f15129a.f15112r;
                upgradeAdapter3.m5807a((List<X431PadDtoSoft>) null);
                upgradeAdapter4 = this.f15129a.f15112r;
                upgradeAdapter4.notifyDataSetChanged();
                this.f15129a.request(2101);
                str = this.f15129a.f15097c;
                NLog.m9456a(str, "BroadcastReceiver: REQ_QUERYLATESTPUBLICSOFTS_CODE");
            }
        } else if (action.equalsIgnoreCase("softs_added")) {
            UpgradeFragment.m5749k(this.f15129a);
            upgradeAdapter = this.f15129a.f15112r;
            upgradeAdapter.m5807a((List<X431PadDtoSoft>) null);
            upgradeAdapter2 = this.f15129a.f15112r;
            upgradeAdapter2.notifyDataSetChanged();
            this.f15129a.request(2101);
        } else if (action.equalsIgnoreCase("logout")) {
            this.f15129a.f15091Y = false;
            UpgradeFragment.m5749k(this.f15129a);
            UpgradeFragment.m5745o(this.f15129a);
            UpgradeFragment.m5744p(this.f15129a);
            this.f15129a.m5762d();
        }
    }
}
