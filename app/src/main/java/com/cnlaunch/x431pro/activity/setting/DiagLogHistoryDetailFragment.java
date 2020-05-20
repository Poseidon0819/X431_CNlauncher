package com.cnlaunch.x431pro.activity.setting;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.x431pro.activity.BaseFragment;
import com.cnlaunch.x431pro.module.p263h.p264a.SettingAction;
import com.cnlaunch.x431pro.module.p263h.p265b.DiagLogHistoryDetailInfo;
import com.cnlaunch.x431pro.module.p263h.p265b.DiagLogHistoryDetailResponse;
import com.cnlaunch.x431pro.module.p263h.p265b.DiagLogHistoryInfo;
import com.cnlaunch.x431pro.module.p263h.p265b.DiagnosticLogCategoryInfo;
import com.cnlaunch.x431pro.module.p263h.p265b.DiagnosticLogCategoryResponse;
import com.cnlaunch.x431pro.utils.C2787z;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.ifoer.expedition.pro.R;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.activity.setting.i */
/* loaded from: classes.dex */
public class DiagLogHistoryDetailFragment extends BaseFragment {

    /* renamed from: a */
    private DiagLogHistoryInfo f14799a;

    /* renamed from: b */
    private DiagLogHistoryDetailInfo f14800b;

    /* renamed from: c */
    private LinearLayout f14801c;

    /* renamed from: d */
    private TextView f14802d;

    /* renamed from: e */
    private TextView f14803e;

    /* renamed from: f */
    private TextView f14804f;

    /* renamed from: g */
    private TextView f14805g;

    /* renamed from: h */
    private TextView f14806h;

    /* renamed from: i */
    private TextView f14807i;

    /* renamed from: j */
    private TextView f14808j;

    /* renamed from: k */
    private TextView f14809k;

    /* renamed from: l */
    private TextView f14810l;

    /* renamed from: m */
    private TextView f14811m;

    /* renamed from: n */
    private TextView f14812n;

    /* renamed from: o */
    private TextView f14813o;

    /* renamed from: p */
    private final int f14814p = 2104;

    /* renamed from: q */
    private final int f14815q = 2105;

    /* renamed from: r */
    private String f14816r;

    /* renamed from: s */
    private String f14817s;

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.setting_onekey_feedback_history_detail, viewGroup, false);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setTitle(R.string.diagloghistorydetail_tittle);
        setLeftImage(this.mContext.getResources().getDrawable(R.drawable.select_btn_menu));
        this.f14799a = (DiagLogHistoryInfo) getBundle().getSerializable("diagLogHistoryInfo");
        this.f14801c = (LinearLayout) getActivity().findViewById(R.id.ll_detail_title);
        this.f14802d = (TextView) getActivity().findViewById(R.id.tv_history_detail_car_name);
        this.f14803e = (TextView) getActivity().findViewById(R.id.tv_history_detail_date);
        this.f14804f = (TextView) getActivity().findViewById(R.id.tv_history_detail_currentState);
        this.f14809k = (TextView) getActivity().findViewById(R.id.tv_detail_num);
        this.f14805g = (TextView) getActivity().findViewById(R.id.tv_history_detail_remark);
        this.f14806h = (TextView) getActivity().findViewById(R.id.tv_history_detail_wrongemssage);
        this.f14807i = (TextView) getActivity().findViewById(R.id.tv_history_detail_solution);
        this.f14808j = (TextView) getActivity().findViewById(R.id.tv_history_detail_way);
        this.f14810l = (TextView) getActivity().findViewById(R.id.tv_make);
        this.f14811m = (TextView) getActivity().findViewById(R.id.tv_model);
        this.f14812n = (TextView) getActivity().findViewById(R.id.tv_year);
        this.f14813o = (TextView) getActivity().findViewById(R.id.tv_vin);
        DiagLogHistoryInfo diagLogHistoryInfo = this.f14799a;
        if (diagLogHistoryInfo != null) {
            this.f14816r = diagLogHistoryInfo.getSerialNo();
            if (this.f14799a.getCurrentState() == 2) {
                this.f14804f.setText(R.string.diagloghistory_done);
                this.f14801c.setBackgroundResource(R.color.dark_gray);
                this.f14802d.setTextColor(getResources().getColor(R.color.white));
                this.f14803e.setTextColor(getResources().getColor(R.color.white));
                this.f14804f.setTextColor(getResources().getColor(R.color.white));
            } else if (this.f14799a.getCurrentState() == 0) {
                this.f14804f.setText(R.string.diagloghistory_pending);
                this.f14801c.setBackgroundResource(R.color.orange_yellow);
                this.f14802d.setTextColor(-65536);
                this.f14803e.setTextColor(-65536);
                this.f14804f.setTextColor(-65536);
            } else {
                this.f14804f.setText(R.string.diagloghistory_inprocess);
                this.f14801c.setBackgroundResource(R.color.water_blue);
                this.f14802d.setTextColor(getResources().getColor(R.color.dark_blue));
                this.f14803e.setTextColor(getResources().getColor(R.color.dark_blue));
                this.f14804f.setTextColor(getResources().getColor(R.color.dark_blue));
            }
            String replace = this.f14799a.getLogName().replace(this.f14816r, "");
            String substring = replace.substring(0, replace.length() - 18);
            this.f14817s = this.f14799a.getLogId();
            TextView textView = this.f14809k;
            textView.setText("：" + this.f14816r);
            this.f14802d.setText(substring);
            this.f14803e.setText(this.f14799a.getFeedbackTime());
            this.f14805g.setText(this.f14799a.getInputContent());
            LoadDialog.m4686a(this.mContext);
            request(2104);
            request(2105);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public Object doInBackground(int i) throws C1425f {
        switch (i) {
            case 2104:
                return new SettingAction(this.mContext).m5308a(this.f14817s);
            case 2105:
                return new SettingAction(this.mContext).m5304g(this.f14817s);
            default:
                return super.doInBackground(i);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onSuccess(int i, Object obj) {
        List<DiagnosticLogCategoryInfo> diagLogCategoryDTOList;
        super.onSuccess(i, obj);
        switch (i) {
            case 2104:
                LoadDialog.m4681b(this.mContext);
                if (obj != null) {
                    this.f14800b = ((DiagLogHistoryDetailResponse) obj).getDiagLogDetailDTO();
                    DiagLogHistoryDetailInfo diagLogHistoryDetailInfo = this.f14800b;
                    if (diagLogHistoryDetailInfo != null) {
                        this.f14806h.setText(diagLogHistoryDetailInfo.getErrorMessage());
                        if (!TextUtils.isEmpty(this.f14800b.getSolution())) {
                            this.f14807i.setText(this.f14800b.getSolution());
                        }
                        this.f14808j.setText(this.f14800b.getUserOperatePath());
                        return;
                    }
                    return;
                }
                return;
            case 2105:
                LoadDialog.m4681b(this.mContext);
                if (obj == null || (diagLogCategoryDTOList = ((DiagnosticLogCategoryResponse) obj).getDiagLogCategoryDTOList()) == null || diagLogCategoryDTOList.size() <= 0) {
                    return;
                }
                m5915a(this.f14810l, diagLogCategoryDTOList.get(0).getMake());
                m5915a(this.f14811m, diagLogCategoryDTOList.get(0).getModel());
                m5915a(this.f14812n, diagLogCategoryDTOList.get(0).getYear());
                m5915a(this.f14813o, diagLogCategoryDTOList.get(0).getVin());
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    private static void m5915a(TextView textView, String str) {
        String charSequence = textView.getText().toString();
        if (C2787z.m4821a(str)) {
            str = "--";
        }
        textView.setText(charSequence + str);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onFailure(int i, int i2, Object obj) {
        super.onFailure(i, i2, obj);
        if (i != 2104) {
            return;
        }
        LoadDialog.m4681b(this.mContext);
    }
}
