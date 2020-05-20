package com.cnlaunch.x431pro.activity.diagnose.p221d;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.cnlaunch.diagnosemodule.bean.BasicMenuBean;
import com.cnlaunch.diagnosemodule.utils.ByteHexHelper;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.x431pro.activity.diagnose.p218a.ResetCarIconAdapter;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.bl */
/* loaded from: classes.dex */
public final class ResetCarIconMenuFragment extends BaseDiagnoseFragment implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    private GridView f12126a = null;

    /* renamed from: b */
    private ResetCarIconAdapter f12127b = null;

    /* renamed from: j */
    private String f12128j = null;

    /* renamed from: k */
    private String f12129k = null;

    /* renamed from: l */
    private int f12130l = -1;

    /* renamed from: m */
    private List<BasicMenuBean> f12131m = null;

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, android.app.Fragment
    public final void onAttach(Activity activity) {
        super.onAttach(activity);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f12128j = arguments.getString("Title");
            this.f12129k = arguments.getString("Help");
            this.f12130l = arguments.getInt("FirstItem");
            this.f12131m = (ArrayList) arguments.getSerializable("CarIconList");
        }
        if (this.f12128j == null) {
            this.f12128j = getString(R.string.diagnose_reset_title);
        }
        this.f12357d.mo7083i().setSubTitle(this.f12128j);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public final View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_reset_cariconmenu, viewGroup, false);
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f12127b = new ResetCarIconAdapter(this.mContext);
        List<BasicMenuBean> list = this.f12131m;
        if (list != null) {
            if (list.get(0).getTitle() == null || "".equals(this.f12131m.get(0).getTitle())) {
                this.f12131m.remove(0);
            }
            this.f12127b.f11408a = this.f12131m;
        }
        this.f12126a = (GridView) getActivity().findViewById(R.id.carIconContainer);
        this.f12126a.setAdapter((ListAdapter) this.f12127b);
        this.f12126a.setOnItemClickListener(this);
        this.f12127b.notifyDataSetChanged();
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, android.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment
    /* renamed from: b */
    public final String mo7102b() {
        return this.f12128j;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f12357d.mo7093a(DiagnoseConstants.FEEDBACK_RESET_CARICON_MENU, ByteHexHelper.intToHexBytes(String.valueOf(i)) + ByteHexHelper.intToHexBytes(String.valueOf(this.f12130l)), 3);
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.x431pro.activity.golo.p225b.OnGoloKeyDownListener
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.f12357d.mo7093a(DiagnoseConstants.FEEDBACK_RESET_CARICON_MENU, "-1", 5);
            return super.onKeyDown(i, keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }
}
