package com.cnlaunch.x431pro.activity.setting;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.p131a.Lang;
import com.cnlaunch.p120d.p130d.p131a.LangManager;
import com.cnlaunch.x431pro.activity.BaseFragment;
import com.cnlaunch.x431pro.activity.setting.p234a.DiagsoftRewardAdapter;
import com.cnlaunch.x431pro.module.p263h.p264a.SettingAction;
import com.cnlaunch.x431pro.module.p263h.p265b.DiagSoftRewardRecordInfo;
import com.cnlaunch.x431pro.module.p263h.p265b.DiagSoftRewardRecordResponse;
import com.cnlaunch.x431pro.module.p269j.p270a.UpgradeAction;
import com.cnlaunch.x431pro.module.p269j.p271b.LatestDiagSoftsResponse;
import com.cnlaunch.x431pro.module.p269j.p271b.X431PadDtoSoft;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.ifoer.expedition.pro.R;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.activity.setting.x */
/* loaded from: classes.dex */
public class DiagsoftRewardFragment extends BaseFragment {

    /* renamed from: a */
    LinearLayout f14907a;

    /* renamed from: b */
    TextView f14908b;

    /* renamed from: c */
    ListView f14909c;

    /* renamed from: k */
    private UpgradeAction f14917k;

    /* renamed from: l */
    private String f14918l;

    /* renamed from: m */
    private String f14919m;

    /* renamed from: n */
    private String f14920n;

    /* renamed from: o */
    private String f14921o;

    /* renamed from: p */
    private PreferencesManager f14922p;

    /* renamed from: q */
    private DiagsoftRewardAdapter f14923q;

    /* renamed from: d */
    private final int f14910d = 2104;

    /* renamed from: e */
    private final int f14911e = 2103;

    /* renamed from: f */
    private final int f14912f = 401;

    /* renamed from: g */
    private final int f14913g = 822;

    /* renamed from: h */
    private final int f14914h = 658;

    /* renamed from: i */
    private final int f14915i = 653;

    /* renamed from: j */
    private final int f14916j = 405;

    /* renamed from: r */
    private boolean f14924r = false;

    /* renamed from: s */
    private int f14925s = 0;

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_diagsoft_reward, viewGroup, false);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        this.f14922p = PreferencesManager.m9595a(this.mContext);
        this.f14918l = this.f14922p.m9584b("serialNo", "");
        this.f14917k = new UpgradeAction(this.mContext);
        if (LangManager.m9469a().equalsIgnoreCase("zh")) {
            if (LangManager.m9466b().equalsIgnoreCase("TW")) {
                this.f14919m = LangManager.m9467a(Lang.f7198G);
                this.f14920n = LangManager.m9467a(Lang.f7203a);
            } else if (LangManager.m9466b().equalsIgnoreCase("HK")) {
                this.f14919m = LangManager.m9467a(Lang.f7197F);
                this.f14920n = LangManager.m9467a(Lang.f7203a);
            } else {
                this.f14919m = LangManager.m9467a(Lang.f7199H);
                this.f14920n = this.f14919m;
            }
        } else {
            this.f14919m = LangManager.m9467a(LangManager.m9469a());
            this.f14920n = LangManager.m9467a(Lang.f7203a);
        }
        if (TextUtils.isEmpty(this.f14918l)) {
            String m9591a = this.f14922p.m9591a("carSerialNo");
            String m9591a2 = this.f14922p.m9591a("heavydutySerialNo");
            if (!TextUtils.isEmpty(m9591a)) {
                this.f14918l = m9591a;
            } else {
                this.f14918l = m9591a2;
            }
            this.f14922p.m9588a("serialNo", this.f14918l);
        }
        this.f14921o = this.f14922p.m9591a("user_id");
        this.f14923q = new DiagsoftRewardAdapter(getActivity(), this);
        setTitle(R.string.setting_reward_check_title);
        setLeftImage(this.mContext.getResources().getDrawable(R.drawable.select_btn_menu_two));
        this.f14909c = (ListView) getActivity().findViewById(R.id.lv_reward_soft);
        this.f14909c.setAdapter((ListAdapter) this.f14923q);
        this.f14907a = (LinearLayout) getActivity().findViewById(R.id.ll_reward_tips);
        this.f14908b = (TextView) getActivity().findViewById(R.id.tv_free_end_date);
        this.f14907a.setVisibility(8);
        this.f14908b.setVisibility(8);
        request(2104);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public void request(int i) {
        super.request(i);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onFailure(int i, int i2, Object obj) {
        super.onFailure(i, i2, obj);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onSuccess(int i, Object obj) {
        switch (i) {
            case 2103:
                LoadDialog.m4681b(this.mContext);
                if (obj != null) {
                    List<X431PadDtoSoft> x431PadSoftList = ((LatestDiagSoftsResponse) obj).getX431PadSoftList();
                    if (this.f14924r) {
                        this.f14907a.setVisibility(0);
                        this.f14908b.setVisibility(0);
                    }
                    DiagsoftRewardAdapter diagsoftRewardAdapter = this.f14923q;
                    diagsoftRewardAdapter.f14515b = this.f14924r;
                    diagsoftRewardAdapter.f14516c = this.f14925s;
                    diagsoftRewardAdapter.f14514a = x431PadSoftList;
                    diagsoftRewardAdapter.notifyDataSetChanged();
                    break;
                }
                break;
            case 2104:
                LoadDialog.m4681b(this.mContext);
                if (obj != null) {
                    DiagSoftRewardRecordResponse diagSoftRewardRecordResponse = (DiagSoftRewardRecordResponse) obj;
                    if (isSuccess(diagSoftRewardRecordResponse.getCode())) {
                        DiagSoftRewardRecordInfo diagSoftRewardRecordDTO = diagSoftRewardRecordResponse.getDiagSoftRewardRecordDTO();
                        if (diagSoftRewardRecordDTO != null) {
                            this.f14925s = diagSoftRewardRecordDTO.getMonth().intValue();
                            this.f14924r = true;
                        }
                    } else if (405 == diagSoftRewardRecordResponse.getCode()) {
                        this.f14925s = 0;
                        this.f14924r = false;
                    } else {
                        this.f14924r = false;
                        this.f14925s = 0;
                    }
                    LoadDialog.m4684a(this.mContext, this.mContext.getString(R.string.refresh_txt));
                    request(2103);
                    break;
                }
                break;
        }
        super.onSuccess(i, obj);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public Object doInBackground(int i) throws C1425f {
        switch (i) {
            case 2103:
                return this.f14917k.m5281a(this.f14921o, this.f14918l, this.f14919m, this.f14920n);
            case 2104:
                SettingAction settingAction = new SettingAction(this.mContext);
                this.f14918l = PreferencesManager.m9595a(this.mContext).m9584b("serialNo", "");
                return settingAction.m5305b(this.f14918l, "112");
            default:
                return super.doInBackground(i);
        }
    }
}
