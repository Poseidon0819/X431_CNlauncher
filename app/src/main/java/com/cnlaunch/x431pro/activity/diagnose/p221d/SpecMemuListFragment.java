package com.cnlaunch.x431pro.activity.diagnose.p221d;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.cnlaunch.diagnosemodule.bean.BasicMenuBean;
import com.cnlaunch.diagnosemodule.bean.BasicSpecMenuBean;
import com.cnlaunch.diagnosemodule.utils.ByteHexHelper;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.x431pro.activity.diagnose.p218a.MenuListAdapter;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;

/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.bn */
/* loaded from: classes.dex */
public final class SpecMemuListFragment extends BaseDiagnoseFragment implements AdapterView.OnItemClickListener {

    /* renamed from: k */
    private String f12140k;

    /* renamed from: l */
    private String f12141l;

    /* renamed from: o */
    private ListView f12144o;

    /* renamed from: p */
    private ListView f12145p;

    /* renamed from: m */
    private MenuListAdapter f12142m = null;

    /* renamed from: n */
    private MenuListAdapter f12143n = null;

    /* renamed from: q */
    private ArrayList<BasicMenuBean> f12146q = null;

    /* renamed from: r */
    private ArrayList<BasicSpecMenuBean> f12147r = null;

    /* renamed from: a */
    int f12137a = 0;

    /* renamed from: s */
    private boolean f12148s = false;

    /* renamed from: t */
    private int f12149t = 0;

    /* renamed from: b */
    int f12138b = 0;

    /* renamed from: j */
    int f12139j = 0;

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment
    /* renamed from: f */
    public final boolean mo7118f() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ boolean m7192a(SpecMemuListFragment specMemuListFragment) {
        specMemuListFragment.f12148s = true;
        return true;
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f12144o = (ListView) getActivity().findViewById(R.id.list_menu);
        ArrayList<BasicMenuBean> arrayList = this.f12146q;
        if (arrayList != null && arrayList.size() > 0) {
            this.f12142m = new MenuListAdapter(this.f12146q, getActivity());
            this.f12142m.f11389a = this.f12357d;
            MenuListAdapter menuListAdapter = this.f12142m;
            menuListAdapter.f11390b = this.f12137a;
            menuListAdapter.f11391c = this.f12138b;
            menuListAdapter.f11392d = this.f12140k;
            this.f12144o.setAdapter((ListAdapter) menuListAdapter);
            this.f12144o.setSelection(this.f12137a);
            if (this.f12356c) {
                this.f12144o.setOnItemClickListener(this);
            }
        }
        this.f12145p = (ListView) getActivity().findViewById(R.id.list_history_choice_menu);
        ArrayList<BasicSpecMenuBean> arrayList2 = this.f12147r;
        if (arrayList2 != null && arrayList2.size() > 0) {
            this.f12143n = new MenuListAdapter(this.f12147r, getActivity(), this.f12139j);
            this.f12142m.f11392d = this.f12140k;
            this.f12143n.f11389a = this.f12357d;
            this.f12145p.setAdapter((ListAdapter) this.f12143n);
            if (this.f12356c) {
                this.f12145p.setOnItemClickListener(this);
            }
        }
        new C2147bo(this).start();
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, android.app.Fragment
    public final void onAttach(Activity activity) {
        super.onAttach(activity);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f12146q = (ArrayList) arguments.getSerializable("MenuList");
            this.f12147r = (ArrayList) arguments.getSerializable("HistoryMenuList");
            this.f12137a = arguments.getInt("FirstItem");
            this.f12138b = arguments.getInt("FirstItemForDiag");
            this.f12149t = this.f12137a;
            this.f12140k = arguments.getString("MenuType");
            this.f12139j = arguments.getInt("Level");
        }
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.x431pro.activity.golo.p225b.OnGoloKeyDownListener
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.f12148s) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment
    /* renamed from: e */
    public final String mo7119e() {
        return this.f12141l;
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public final View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_spec_menu, viewGroup, false);
    }

    @Override // android.app.Fragment
    public final void onResume() {
        super.onResume();
        this.f12144o.requestFocus();
        this.f12144o.setSelection(this.f12149t);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f12149t = i;
        this.f12357d.mo7083i().setMenuSelectIndex(this.f12149t);
        this.f12148s = false;
        new C2148bp(this).start();
        if (adapterView == this.f12145p) {
            if (i == this.f12147r.size() - 1) {
                return;
            }
            this.f12357d.mo7093a(DiagnoseConstants.FEEDBACK_SPT_MENU2HD_ID, "00FFFF" + ByteHexHelper.intToTwoHexString(this.f12138b) + ByteHexHelper.intToTwoHexString(this.f12147r.get(i).getclickRetid()), 3);
            return;
        }
        this.f12357d.mo7093a(DiagnoseConstants.FEEDBACK_SPT_MENU2HD_ID, "00" + ByteHexHelper.intToTwoHexString(i) + ByteHexHelper.intToTwoHexString(this.f12138b) + ByteHexHelper.intToTwoHexString(this.f12139j), 3);
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment
    /* renamed from: b */
    public final String mo7102b() {
        return getString(R.string.fragment_title_diagnosemenu);
    }
}
