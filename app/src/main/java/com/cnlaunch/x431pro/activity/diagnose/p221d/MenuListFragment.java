package com.cnlaunch.x431pro.activity.diagnose.p221d;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.cnlaunch.diagnosemodule.bean.BasicMenuBean;
import com.cnlaunch.diagnosemodule.utils.ByteHexHelper;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.diagnosemodule.utils.FeedbackUtil;
import com.cnlaunch.x431pro.activity.diagnose.p218a.MenuListAdapter;
import com.cnlaunch.x431pro.activity.diagnose.p222e.IFragmentCallback;
import com.cnlaunch.x431pro.p210a.C1947h;
import com.cnlaunch.x431pro.utils.PathUtils;
import com.cnlaunch.x431pro.utils.p288h.PrintDataUtils;
import com.cnlaunch.x431pro.widget.button.IconButton;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;

/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.ay */
/* loaded from: classes.dex */
public final class MenuListFragment extends BaseDiagnoseFragment implements AdapterView.OnItemClickListener {

    /* renamed from: j */
    private String f12060j;

    /* renamed from: k */
    private String f12061k;

    /* renamed from: l */
    private String f12062l;

    /* renamed from: n */
    private ListView f12064n;

    /* renamed from: m */
    private MenuListAdapter f12063m = null;

    /* renamed from: o */
    private ArrayList<BasicMenuBean> f12065o = null;

    /* renamed from: a */
    int f12058a = 0;

    /* renamed from: p */
    private boolean f12066p = false;

    /* renamed from: q */
    private int f12067q = 0;

    /* renamed from: b */
    int f12059b = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ boolean m7212a(MenuListFragment menuListFragment) {
        menuListFragment.f12066p = true;
        return true;
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f12064n = (ListView) getActivity().findViewById(R.id.list_menu);
        ArrayList<BasicMenuBean> arrayList = this.f12065o;
        if (arrayList != null && arrayList.size() > 0) {
            this.f12063m = new MenuListAdapter(this.f12065o, getActivity());
            this.f12063m.f11389a = this.f12357d;
            MenuListAdapter menuListAdapter = this.f12063m;
            menuListAdapter.f11390b = this.f12058a;
            menuListAdapter.f11391c = this.f12059b;
            menuListAdapter.f11392d = this.f12060j;
            this.f12064n.setAdapter((ListAdapter) menuListAdapter);
            this.f12064n.setSelection(this.f12058a);
            if (this.f12356c) {
                this.f12064n.setOnItemClickListener(this);
            }
        }
        IconButton iconButton = (IconButton) getActivity().findViewById(R.id.btn_help);
        if (!this.f12060j.equals(DiagnoseConstants.UI_TYPE_IDHELP_MENU) && !this.f12060j.equals(DiagnoseConstants.UI_TYPE_HELP_MENU)) {
            iconButton.setVisibility(8);
        }
        new C2135az(this).start();
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, android.app.Fragment
    public final void onAttach(Activity activity) {
        super.onAttach(activity);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f12065o = (ArrayList) arguments.getSerializable("MenuList");
            this.f12058a = arguments.getInt("FirstItem");
            this.f12059b = arguments.getInt("FirstItemForDiag");
            this.f12060j = arguments.getString("MenuType");
            this.f12062l = arguments.getString("MenuTitle");
            this.f12061k = arguments.getString("MenuHelp");
        }
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.x431pro.activity.golo.p225b.OnGoloKeyDownListener
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.f12066p) {
            if (i == 4) {
                if (this.f12357d.mo7083i().getDiagnoseStatue() != 0) {
                    this.f12357d.mo7093a((String) null, (String) null, 5);
                } else if (!this.f12357d.mo7083i().isDatastreamRecord()) {
                    this.f12357d.mo7085f(0);
                }
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment
    /* renamed from: f */
    public final boolean mo7118f() {
        return this.f12060j.equals(DiagnoseConstants.UI_TYPE_IDHELP_MENU) || this.f12060j.equals(DiagnoseConstants.UI_TYPE_HELP_MENU);
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment
    /* renamed from: e */
    public final String mo7119e() {
        return this.f12061k;
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public final View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_menu, viewGroup, false);
    }

    @Override // android.app.Fragment
    public final void onResume() {
        super.onResume();
        this.f12064n.requestFocus();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f12067q = i;
        if (this.f12067q != C1947h.f10559k) {
            C1947h.f10559k = -2;
        }
        this.f12357d.mo7083i().setMenuSelectIndex(this.f12067q);
        this.f12066p = false;
        new C2137ba(this).start();
        if (!this.f12060j.equals(DiagnoseConstants.UI_TYPE_MENU_AND_HELP_BTN_ID) && !this.f12060j.equals(DiagnoseConstants.UI_TYPE_FILE_MENU_AND_HELP_BTN)) {
            this.f12357d.mo7082j();
            if (this.f12357d.mo7083i().getDiagnoseStatue() < 2) {
                this.f12357d.mo7093a(FeedbackUtil.getMenuListType(), String.valueOf(i), 17);
                return;
            }
            this.f12357d.mo7093a(FeedbackUtil.getMenuListType(), ByteHexHelper.intToHexBytes(String.valueOf(i)) + ByteHexHelper.intToHexBytes(String.valueOf(this.f12059b)), 3);
            return;
        }
        IFragmentCallback iFragmentCallback = this.f12357d;
        iFragmentCallback.mo7093a(DiagnoseConstants.FEEDBACK_SPT_MENU_AND_HELP_BTN_ID, "0" + ByteHexHelper.intToTwoHexString(i) + ByteHexHelper.intToTwoHexString(this.f12059b), 3);
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment
    /* renamed from: b */
    public final String mo7102b() {
        return (!PathUtils.m4856c(DiagnoseConstants.DIAGNOSE_LIB_PATH) || TextUtils.isEmpty(this.f12062l)) ? getString(R.string.fragment_title_diagnosemenu) : this.f12062l;
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment
    /* renamed from: c */
    public final String mo7100c() {
        ArrayList<BasicMenuBean> arrayList = this.f12065o;
        if (arrayList == null || arrayList.size() == 0) {
            return super.mo7100c();
        }
        return PrintDataUtils.m4933a(getActivity(), this.f12065o);
    }
}
