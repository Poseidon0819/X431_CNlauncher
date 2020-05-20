package com.cnlaunch.x431pro.activity.diagnose.p221d;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.cnlaunch.diagnosemodule.bean.BasicCombineMenuBean;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.diagnosemodule.utils.FeedbackUtil;
import com.cnlaunch.x431pro.activity.diagnose.p218a.CombineMenuShowListAdapter;
import com.cnlaunch.x431pro.activity.diagnose.p222e.IFragmentCallback;
import com.cnlaunch.x431pro.widget.button.IconButton;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;

/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.t */
/* loaded from: classes.dex */
public final class CombineMenuFragment extends BaseDiagnoseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {

    /* renamed from: k */
    private IconButton f12380k;

    /* renamed from: l */
    private IconButton f12381l;

    /* renamed from: m */
    private IconButton f12382m;

    /* renamed from: n */
    private ArrayList<BasicCombineMenuBean> f12383n;

    /* renamed from: o */
    private CombineMenuShowListAdapter f12384o;

    /* renamed from: j */
    private ListView f12379j = null;

    /* renamed from: a */
    int f12377a = 0;

    /* renamed from: b */
    int f12378b = 0;

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, android.app.Fragment
    public final void onAttach(Activity activity) {
        super.onAttach(activity);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f12383n = (ArrayList) arguments.getSerializable("CombineMenuList");
            this.f12377a = arguments.getInt("FirstItem");
            this.f12378b = arguments.getInt("ConfirmBtnState");
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public final View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_combinemenu_show, viewGroup, false);
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f12379j = (ListView) getActivity().findViewById(R.id.listview_combinemenu);
        this.f12381l = (IconButton) getActivity().findViewById(R.id.bt_combine_sure);
        this.f12380k = (IconButton) getActivity().findViewById(R.id.bt_combine_clear);
        this.f12382m = (IconButton) getActivity().findViewById(R.id.bt_combine_back);
        if (this.f12378b == 1) {
            this.f12381l.setEnabled(true);
        } else {
            this.f12381l.setEnabled(false);
        }
        if (this.f12356c) {
            this.f12379j.setOnItemClickListener(this);
            this.f12381l.setOnClickListener(this);
            this.f12380k.setOnClickListener(this);
            this.f12382m.setOnClickListener(this);
        }
        ArrayList<BasicCombineMenuBean> arrayList = this.f12383n;
        if (arrayList != null) {
            this.f12384o = new CombineMenuShowListAdapter(arrayList, getActivity());
            this.f12379j.setAdapter((ListAdapter) this.f12384o);
        }
    }

    @Override // android.app.Fragment
    public final void onResume() {
        super.onResume();
        this.f12379j.requestFocus();
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, android.view.View.OnClickListener
    public final void onClick(View view) {
        Object valueOf;
        Object valueOf2;
        Object valueOf3;
        super.onClick(view);
        int id = view.getId();
        if (id == R.id.bt_combine_sure) {
            IFragmentCallback iFragmentCallback = this.f12357d;
            StringBuilder sb = new StringBuilder("0000");
            int i = this.f12377a;
            if (i < 10) {
                valueOf3 = "0" + this.f12377a;
            } else {
                valueOf3 = Integer.valueOf(i);
            }
            sb.append(valueOf3);
            iFragmentCallback.mo7093a(DiagnoseConstants.FEEDBACK_COMBINATION_MENU, sb.toString(), 3);
        } else if (id == R.id.bt_combine_clear) {
            IFragmentCallback iFragmentCallback2 = this.f12357d;
            StringBuilder sb2 = new StringBuilder("0001");
            int i2 = this.f12377a;
            if (i2 < 10) {
                valueOf2 = "0" + this.f12377a;
            } else {
                valueOf2 = Integer.valueOf(i2);
            }
            sb2.append(valueOf2);
            iFragmentCallback2.mo7093a(DiagnoseConstants.FEEDBACK_COMBINATION_MENU, sb2.toString(), 3);
        } else if (id == R.id.bt_combine_back) {
            IFragmentCallback iFragmentCallback3 = this.f12357d;
            StringBuilder sb3 = new StringBuilder("0002");
            int i3 = this.f12377a;
            if (i3 < 10) {
                valueOf = "0" + this.f12377a;
            } else {
                valueOf = Integer.valueOf(i3);
            }
            sb3.append(valueOf);
            iFragmentCallback3.mo7093a(DiagnoseConstants.FEEDBACK_COMBINATION_MENU, sb3.toString(), 3);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment
    /* renamed from: b */
    public final String mo7102b() {
        return getString(R.string.fragment_title_combinemenu);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f12357d.mo7093a(DiagnoseConstants.FEEDBACK_COMBINATION_MENU, FeedbackUtil.getCombineMenuFeedbackCmd(i, this.f12377a), 3);
    }
}
