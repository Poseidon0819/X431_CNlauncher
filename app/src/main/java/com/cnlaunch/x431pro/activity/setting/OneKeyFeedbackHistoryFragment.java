package com.cnlaunch.x431pro.activity.setting;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.p181j.DealDiagMessageHandler;
import com.cnlaunch.x431pro.activity.BaseFragment;
import com.cnlaunch.x431pro.activity.diagnose.p219b.CarIconManager;
import com.cnlaunch.x431pro.activity.setting.p234a.OneKeyFeedbackHistoryAdapter;
import com.cnlaunch.x431pro.activity.setting.p235b.DiagLogHistoryInfoManager;
import com.cnlaunch.x431pro.activity.setting.p235b.OnQueryHistoryInfoListener;
import com.cnlaunch.x431pro.module.p263h.p265b.DiagLogHistoryInfo;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.utils.C2787z;
import com.cnlaunch.x431pro.utils.p283db.SerialNumber;
import com.cnlaunch.x431pro.utils.p283db.SerialNumberDao;
import com.cnlaunch.x431pro.utils.p283db.p284a.DBManager;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.cnlaunch.x431pro.widget.p290a.LoginDialog;
import com.cnlaunch.x431pro.widget.p290a.SpinnerPopupWindow;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.activity.setting.af */
/* loaded from: classes.dex */
public class OneKeyFeedbackHistoryFragment extends BaseFragment implements View.OnClickListener, OnQueryHistoryInfoListener {

    /* renamed from: f */
    private PreferencesManager f14558f;

    /* renamed from: g */
    private SerialNumberDao f14559g;

    /* renamed from: h */
    private TextView f14560h;

    /* renamed from: i */
    private List<SerialNumber> f14561i;

    /* renamed from: j */
    private String f14562j;

    /* renamed from: k */
    private String f14563k;

    /* renamed from: n */
    private ListView f14566n;

    /* renamed from: o */
    private OneKeyFeedbackHistoryAdapter f14567o;

    /* renamed from: p */
    private List<DiagLogHistoryInfo> f14568p;

    /* renamed from: a */
    private final String f14553a = OneKeyFeedbackHistoryFragment.class.getSimpleName();

    /* renamed from: b */
    private final int f14554b = 1;

    /* renamed from: c */
    private final int f14555c = 2;

    /* renamed from: d */
    private final int f14556d = 3;

    /* renamed from: e */
    private Handler f14557e = null;

    /* renamed from: l */
    private boolean f14564l = false;

    /* renamed from: m */
    private LoginDialog f14565m = null;

    /* renamed from: q */
    private final int f14569q = 2104;

    /* renamed from: r */
    private BroadcastReceiver f14570r = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: i */
    public static /* synthetic */ List m6015i(OneKeyFeedbackHistoryFragment oneKeyFeedbackHistoryFragment) {
        oneKeyFeedbackHistoryFragment.f14568p = null;
        return null;
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onDestroy() {
        if (this.f14570r != null && this.mContext != null) {
            this.mContext.unregisterReceiver(this.f14570r);
            this.f14570r = null;
            NLog.m9456a(this.f14553a, "onDestroy: unregisterReceiver:SNChangedBroadcast");
        }
        super.onDestroy();
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        NLog.m9456a(this.f14553a, "onDestroyView");
        if (this.f14570r != null && this.mContext != null) {
            this.mContext.unregisterReceiver(this.f14570r);
            this.f14570r = null;
            NLog.m9456a(this.f14553a, "onDestroyView: unregisterReceiver:SNChangedBroadcast");
        }
        super.onDestroyView();
    }

    @Override // android.app.Fragment
    public void onDetach() {
        DiagLogHistoryInfoManager.m5973a(this.mContext).m5968b(this);
        super.onDetach();
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        DiagLogHistoryInfoManager.m5973a(this.mContext).f14637a = true;
        setTitle(R.string.diagloghistory_tittle);
        setLeftImage(this.mContext.getResources().getDrawable(R.drawable.select_btn_menu_two));
        this.f14566n = (ListView) getActivity().findViewById(R.id.lv_onekey_feedback_history);
        this.f14560h = (TextView) getActivity().findViewById(R.id.tv_history_serialNo);
        ((TextView) getActivity().findViewById(R.id.tv_history_inprocess)).setText("■" + getResources().getString(R.string.diagloghistory_inprocess));
        ((TextView) getActivity().findViewById(R.id.tv_history_done)).setText("■" + getResources().getString(R.string.diagloghistory_done));
        ((TextView) getActivity().findViewById(R.id.tv_history_pending)).setText("■" + getResources().getString(R.string.diagloghistory_pending));
        this.f14567o = new OneKeyFeedbackHistoryAdapter(getActivity());
        this.f14566n.setAdapter((ListAdapter) this.f14567o);
        this.f14566n.setOnItemClickListener(new C2522ag(this));
        this.f14558f = PreferencesManager.m9595a(this.mContext);
        this.f14559g = DBManager.m5036a(this.mContext).f15794a.f15798a;
        this.f14562j = this.f14558f.m9591a("user_id");
        this.f14557e = new HandlerC2524ai(this);
        IntentFilter intentFilter = new IntentFilter("login_change_serialno");
        this.f14570r = new C2523ah(this);
        this.mContext.registerReceiver(this.f14570r, intentFilter);
        DiagLogHistoryInfoManager.m5973a(this.mContext).m5971a(this);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.setting_onekey_feedback_history, viewGroup, false);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        m6029a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6029a() {
        m6025b();
        m6023c();
        this.f14568p = null;
        OneKeyFeedbackHistoryAdapter oneKeyFeedbackHistoryAdapter = this.f14567o;
        oneKeyFeedbackHistoryAdapter.f14538a = null;
        oneKeyFeedbackHistoryAdapter.notifyDataSetChanged();
        if (this.f14564l && m6021d() && this.f14561i.size() != 0) {
            LoadDialog.m4686a(this.mContext);
            DiagLogHistoryInfoManager.m5973a(this.mContext).m5970a(this.f14563k);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != R.id.tv_history_serialNo) {
            return;
        }
        m6025b();
        if (this.f14561i.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (SerialNumber serialNumber : this.f14561i) {
            arrayList.add(serialNumber.f15834d);
        }
        SpinnerPopupWindow spinnerPopupWindow = new SpinnerPopupWindow(this.mContext);
        spinnerPopupWindow.f16384c = this.f14560h.getWidth();
        spinnerPopupWindow.f16383b = new C2527al(this, arrayList);
        spinnerPopupWindow.m4581b(this.f14560h, arrayList);
    }

    /* renamed from: b */
    private void m6025b() {
        if (this.f14559g == null) {
            this.f14559g = DBManager.m5036a(this.mContext).f15794a.f15798a;
        }
        if (this.f14558f == null) {
            this.f14558f = PreferencesManager.m9595a(this.mContext);
        }
        String m9591a = this.f14558f.m9591a("serialNo");
        if (TextUtils.isEmpty(m9591a)) {
            m9591a = this.f14558f.m9591a("carSerialNo");
            String m9591a2 = this.f14558f.m9591a("heavydutySerialNo");
            if (TextUtils.isEmpty(m9591a)) {
                m9591a = m9591a2;
            }
            this.f14558f.m9588a("serialNo", m9591a);
        }
        String m9591a3 = this.f14558f.m9591a("user_id");
        if (!m9591a.equals(this.f14563k) || !m9591a3.equals(this.f14562j)) {
            this.f14564l = true;
        }
        this.f14563k = m9591a;
        this.f14562j = m9591a3;
        List<SerialNumber> loadAll = this.f14559g.loadAll();
        this.f14561i = new ArrayList();
        for (SerialNumber serialNumber : loadAll) {
            if (C2744aa.m5168b(serialNumber.f15834d, this.mContext) || C2744aa.m5177a(serialNumber.f15834d, this.mContext) || C2744aa.m5161c(serialNumber.f15834d, this.mContext)) {
                if (serialNumber.f15832b.booleanValue()) {
                    this.f14561i.add(serialNumber);
                }
            }
        }
        if (this.f14561i.size() == 0) {
            this.f14563k = "";
        }
        m6023c();
    }

    /* renamed from: c */
    private void m6023c() {
        DealDiagMessageHandler.m8673a().f9427c = null;
        this.f14557e.sendMessage(this.f14557e.obtainMessage(1, 0, 0));
    }

    /* renamed from: d */
    private boolean m6021d() {
        String m9591a = PreferencesManager.m9595a(this.mContext).m9591a("user_id");
        String m9591a2 = PreferencesManager.m9595a(this.mContext).m9591a("token");
        Log.d("weizewei", "user_id== " + m9591a + "token  " + m9591a2);
        boolean z = (m9591a == null || m9591a2 == null || (m9591a2 != null && (m9591a2.isEmpty() || m9591a2.equals("null"))) || (m9591a != null && (m9591a.isEmpty() || m9591a2.equals("null")))) ? false : true;
        if (!z) {
            if (PreferencesManager.m9595a(this.mContext).m9583b("isconflict", false)) {
                Log.d("weizewei", "isconflict ");
                this.f14557e.sendMessage(this.f14557e.obtainMessage(2, 0, 0));
            } else {
                Log.d("weizewei", "isconflict 22222");
                this.f14557e.sendMessage(this.f14557e.obtainMessage(3, 0, 0));
            }
        }
        return z;
    }

    @Override // com.cnlaunch.x431pro.activity.setting.p235b.OnQueryHistoryInfoListener
    /* renamed from: a */
    public final void mo5964a(List<DiagLogHistoryInfo> list) {
        LoadDialog.m4681b(this.mContext);
        this.f14568p = list;
        OneKeyFeedbackHistoryAdapter oneKeyFeedbackHistoryAdapter = this.f14567o;
        oneKeyFeedbackHistoryAdapter.f14538a = this.f14568p;
        oneKeyFeedbackHistoryAdapter.notifyDataSetChanged();
        for (int i = 0; i < this.f14568p.size(); i++) {
            DiagLogHistoryInfo diagLogHistoryInfo = this.f14568p.get(i);
            if (diagLogHistoryInfo.getReaded() < diagLogHistoryInfo.getCurrentState()) {
                this.f14566n.setSelection(i);
                return;
            }
        }
    }

    @Override // com.cnlaunch.x431pro.activity.setting.p235b.OnQueryHistoryInfoListener
    /* renamed from: a */
    public final void mo5966a(int i, int i2, String str) {
        LoadDialog.m4681b(this.mContext);
        if (-1 == i) {
            this.f14557e.sendMessage(this.f14557e.obtainMessage(2, 0, 0));
        } else if (-100 == i) {
            onFailure(2104, i2, str);
        } else if (C2787z.m4821a(str)) {
        } else {
            NToast.m9449a(this.mContext, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m6026a(OneKeyFeedbackHistoryFragment oneKeyFeedbackHistoryFragment, String str) {
        oneKeyFeedbackHistoryFragment.f14563k = str;
        oneKeyFeedbackHistoryFragment.f14558f.m9588a("serialNo", oneKeyFeedbackHistoryFragment.f14563k);
        if (C2744aa.m5168b(str, oneKeyFeedbackHistoryFragment.mContext) && !str.equals(oneKeyFeedbackHistoryFragment.f14558f.m9591a("carSerialNo"))) {
            oneKeyFeedbackHistoryFragment.f14558f.m9588a("carSerialNo", str);
            if (C2744aa.m5161c(oneKeyFeedbackHistoryFragment.f14558f.m9591a("heavydutySerialNo"), oneKeyFeedbackHistoryFragment.mContext)) {
                oneKeyFeedbackHistoryFragment.f14558f.m9588a("heavydutySerialNo", "");
            }
            oneKeyFeedbackHistoryFragment.f14558f.m9588a("carAndHeavydutySerialNo", "");
            CarIconManager.m7471a(oneKeyFeedbackHistoryFragment.mContext).m7474a();
        } else if (C2744aa.m5177a(str, oneKeyFeedbackHistoryFragment.mContext) && !str.equals(oneKeyFeedbackHistoryFragment.f14558f.m9591a("heavydutySerialNo"))) {
            oneKeyFeedbackHistoryFragment.f14558f.m9588a("heavydutySerialNo", str);
            if (C2744aa.m5161c(oneKeyFeedbackHistoryFragment.f14558f.m9591a("carSerialNo"), oneKeyFeedbackHistoryFragment.mContext)) {
                oneKeyFeedbackHistoryFragment.f14558f.m9588a("carSerialNo", "");
            }
            oneKeyFeedbackHistoryFragment.f14558f.m9588a("carAndHeavydutySerialNo", "");
            CarIconManager.m7471a(oneKeyFeedbackHistoryFragment.mContext).m7474a();
        } else if (C2744aa.m5161c(str, oneKeyFeedbackHistoryFragment.mContext) && !str.equals(oneKeyFeedbackHistoryFragment.f14558f.m9591a("carAndHeavydutySerialNo"))) {
            oneKeyFeedbackHistoryFragment.f14558f.m9588a("carAndHeavydutySerialNo", str);
            oneKeyFeedbackHistoryFragment.f14558f.m9588a("heavydutySerialNo", str);
            oneKeyFeedbackHistoryFragment.f14558f.m9588a("carSerialNo", str);
            CarIconManager.m7471a(oneKeyFeedbackHistoryFragment.mContext).m7474a();
        }
        oneKeyFeedbackHistoryFragment.m6023c();
    }
}
