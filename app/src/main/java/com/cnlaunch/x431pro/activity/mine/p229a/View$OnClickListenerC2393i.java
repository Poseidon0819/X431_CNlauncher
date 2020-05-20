package com.cnlaunch.x431pro.activity.mine.p229a;

import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.physics.p197c.DPUHardwareInfo;
import com.cnlaunch.physics.p197c.DPUSoftInfo;
import com.cnlaunch.physics.p205k.DeviceUtils;
import com.cnlaunch.x431pro.activity.mine.SerialNumberFragment;
import com.cnlaunch.x431pro.activity.mine.p229a.SerialNoAdapter;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.utils.PathUtils;
import com.cnlaunch.x431pro.utils.p283db.SerialNumber;
import com.cnlaunch.x431pro.utils.p283db.p284a.DBManager;
import com.cnlaunch.x431pro.widget.p290a.ConnectorInfoPopupWindow;
import com.ifoer.expedition.pro.R;
import java.util.List;

/* compiled from: SerialNoAdapter.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.a.i */
/* loaded from: classes.dex */
final class View$OnClickListenerC2393i implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SerialNoAdapter.C2392a f13612a;

    /* renamed from: b */
    final /* synthetic */ int f13613b;

    /* renamed from: c */
    final /* synthetic */ SerialNoAdapter f13614c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2393i(SerialNoAdapter serialNoAdapter, SerialNoAdapter.C2392a c2392a, int i) {
        this.f13614c = serialNoAdapter;
        this.f13612a = c2392a;
        this.f13613b = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        SerialNumberFragment serialNumberFragment;
        List list;
        String string;
        serialNumberFragment = this.f13614c.f13603e;
        RelativeLayout relativeLayout = this.f13612a.f13610d;
        list = this.f13614c.f13602d;
        SerialNumber serialNumber = (SerialNumber) list.get(this.f13613b);
        serialNumberFragment.f14135c = relativeLayout;
        serialNumberFragment.f14136d = new ConnectorInfoPopupWindow(serialNumberFragment.mContext);
        serialNumberFragment.f14136d.f16269d.setWidth(serialNumberFragment.f14135c.getWidth());
        serialNumberFragment.f14138f = serialNumber;
        DeviceUtils.m8149a();
        String m8148a = DeviceUtils.m8148a(serialNumber.f15834d);
        if (TextUtils.isEmpty(m8148a)) {
            serialNumberFragment.f14137e = serialNumberFragment.f14134b.m9584b("login_state", "0");
            if (serialNumberFragment.f14137e == null || !serialNumberFragment.f14137e.equals("1")) {
                serialNumberFragment.f14136d.m4672a(serialNumberFragment.f14135c, "");
            } else {
                serialNumberFragment.f14136d.m4672a(serialNumberFragment.f14135c, "");
                serialNumberFragment.request(2203);
            }
        } else {
            serialNumberFragment.f14136d.m4672a(serialNumberFragment.f14135c, m8148a);
        }
        String str = serialNumber.f15834d;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (C2744aa.m5168b(str, serialNumberFragment.mContext) || C2744aa.m5161c(str, serialNumberFragment.mContext) || str.startsWith(serialNumberFragment.f14139g)) {
            DeviceUtils.m8149a();
            DPUHardwareInfo m8147a = DeviceUtils.m8147a(str, PathUtils.m4858c());
            DeviceUtils.m8149a();
            DPUSoftInfo m8142b = DeviceUtils.m8142b(str, PathUtils.m4858c());
            if (m8147a != null && m8142b != null && str.equals(m8147a.f9856g)) {
                ConnectorInfoPopupWindow connectorInfoPopupWindow = serialNumberFragment.f14136d;
                View view2 = serialNumberFragment.f14135c;
                if (view2 != null && m8147a != null) {
                    TextView textView = connectorInfoPopupWindow.f16266a;
                    textView.setText(connectorInfoPopupWindow.f16270e.getResources().getString(R.string.mine_tv_snkey) + m8147a.f9856g + "\n" + connectorInfoPopupWindow.f16270e.getResources().getString(R.string.mine_decice_type) + m8147a.f9859j + "\n" + connectorInfoPopupWindow.f16270e.getResources().getString(R.string.mine_pcb_version) + m8147a.f9857h);
                    int[] iArr = new int[2];
                    view2.getLocationOnScreen(iArr);
                    connectorInfoPopupWindow.f16269d.getContentView().measure(0, 0);
                    connectorInfoPopupWindow.f16269d.showAsDropDown(view2, 0, (iArr[1] + view2.getHeight()) + connectorInfoPopupWindow.f16269d.getContentView().getMeasuredHeight() > ConnectorInfoPopupWindow.m4673a(connectorInfoPopupWindow.f16270e) ? ((-2) - view2.getHeight()) - connectorInfoPopupWindow.f16269d.getContentView().getMeasuredHeight() : 0);
                }
                ConnectorInfoPopupWindow connectorInfoPopupWindow2 = serialNumberFragment.f14136d;
                View view3 = serialNumberFragment.f14135c;
                if (view3 != null && m8142b != null) {
                    TextView textView2 = connectorInfoPopupWindow2.f16267b;
                    textView2.setText(connectorInfoPopupWindow2.f16270e.getResources().getString(R.string.mine_download_version) + m8142b.f9866g);
                    int[] iArr2 = new int[2];
                    view3.getLocationOnScreen(iArr2);
                    connectorInfoPopupWindow2.f16269d.getContentView().measure(0, 0);
                    connectorInfoPopupWindow2.f16269d.showAsDropDown(view3, 0, (iArr2[1] + view3.getHeight()) + connectorInfoPopupWindow2.f16269d.getContentView().getMeasuredHeight() > ConnectorInfoPopupWindow.m4673a(connectorInfoPopupWindow2.f16270e) ? (-view3.getHeight()) - connectorInfoPopupWindow2.f16269d.getContentView().getMeasuredHeight() : 0);
                }
            }
        } else if (C2744aa.m5177a(str, serialNumberFragment.mContext)) {
            DeviceUtils.m8149a();
            String m8140d = DeviceUtils.m8140d(str, PathUtils.m4858c());
            NLog.m9456a(SerialNumberFragment.f14115a, "downloadVersion=".concat(String.valueOf(m8140d)));
            if (!TextUtils.isEmpty(m8140d)) {
                ConnectorInfoPopupWindow connectorInfoPopupWindow3 = serialNumberFragment.f14136d;
                View view4 = serialNumberFragment.f14135c;
                if (view4 != null) {
                    TextView textView3 = connectorInfoPopupWindow3.f16267b;
                    textView3.setText(connectorInfoPopupWindow3.f16270e.getResources().getString(R.string.mine_download_version) + m8140d);
                    int[] iArr3 = new int[2];
                    view4.getLocationOnScreen(iArr3);
                    connectorInfoPopupWindow3.f16269d.getContentView().measure(0, 0);
                    connectorInfoPopupWindow3.f16269d.showAsDropDown(view4, 0, (iArr3[1] + view4.getHeight()) + connectorInfoPopupWindow3.f16269d.getContentView().getMeasuredHeight() > ConnectorInfoPopupWindow.m4673a(connectorInfoPopupWindow3.f16270e) ? (-view4.getHeight()) - connectorInfoPopupWindow3.f16269d.getContentView().getMeasuredHeight() : 0);
                }
            }
        }
        String m5045c = DBManager.m5036a(serialNumberFragment.mContext).f15794a.f15798a.m5045c(str);
        ConnectorInfoPopupWindow connectorInfoPopupWindow4 = serialNumberFragment.f14136d;
        View view5 = serialNumberFragment.f14135c;
        if (view5 == null || TextUtils.isEmpty(m5045c)) {
            return;
        }
        if ("1".equals(m5045c)) {
            string = connectorInfoPopupWindow4.f16270e.getResources().getString(R.string.state_unforbidden);
        } else if ("2".equals(m5045c)) {
            string = connectorInfoPopupWindow4.f16270e.getResources().getString(R.string.state_forbidden);
        } else {
            string = connectorInfoPopupWindow4.f16270e.getResources().getString(R.string.state_normal);
        }
        if (TextUtils.isEmpty(string)) {
            return;
        }
        TextView textView4 = connectorInfoPopupWindow4.f16268c;
        textView4.setText(connectorInfoPopupWindow4.f16270e.getResources().getString(R.string.mine_serialno_state) + string);
        int[] iArr4 = new int[2];
        view5.getLocationOnScreen(iArr4);
        connectorInfoPopupWindow4.f16269d.getContentView().measure(0, 0);
        connectorInfoPopupWindow4.f16269d.showAsDropDown(view5, 0, (iArr4[1] + view5.getHeight()) + connectorInfoPopupWindow4.f16269d.getContentView().getMeasuredHeight() > ConnectorInfoPopupWindow.m4673a(connectorInfoPopupWindow4.f16270e) ? (-view5.getHeight()) - connectorInfoPopupWindow4.f16269d.getContentView().getMeasuredHeight() : 0);
    }
}
