package com.cnlaunch.x431pro.activity.diagnose.p221d;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextPaint;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.cnlaunch.diagnosemodule.bean.BasicButtonBean;
import com.cnlaunch.diagnosemodule.bean.BasicDataStreamBean;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.p120d.p130d.p131a.LangManager;
import com.cnlaunch.x431pro.activity.diagnose.p220c.BottomActionBar;
import com.cnlaunch.x431pro.activity.diagnose.p220c.DataStreamManager;
import com.cnlaunch.x431pro.activity.diagnose.p220c.ICallKeyDownFragment;
import com.cnlaunch.x431pro.activity.diagnose.p220c.IDataStreamSelectionRecorder;
import com.cnlaunch.x431pro.activity.diagnose.p220c.IDataStreamSelector;
import com.cnlaunch.x431pro.activity.diagnose.p220c.X431DataStreamManager;
import com.cnlaunch.x431pro.activity.diagnose.p222e.OnDiagnoseDataUpdateListenter;
import com.cnlaunch.x431pro.activity.diagnose.p222e.TabListener;
import com.cnlaunch.x431pro.module.p252d.p254b.SerializableMap;
import com.cnlaunch.x431pro.p210a.DataStreamConfiguration;
import com.cnlaunch.x431pro.utils.PathUtils;
import com.cnlaunch.x431pro.utils.p282d.TranslationUtil;
import com.cnlaunch.x431pro.utils.p288h.PrintDataUtils;
import com.cnlaunch.x431pro.widget.button.IconButton;
import com.cnlaunch.x431pro.widget.button.IconRadioButton;
import com.cnlaunch.x431pro.widget.p290a.SpinnerPopupWindow;
import com.cnlaunch.x431pro.widget.p290a.WaitDialog;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.a */
/* loaded from: classes.dex */
public final class ActiveTestFragment extends BaseDiagnoseFragment implements View.OnClickListener, ICallKeyDownFragment, IDataStreamSelectionRecorder {

    /* renamed from: A */
    private ProgressBar f11849A;

    /* renamed from: B */
    private Handler f11850B;

    /* renamed from: C */
    private SerializableMap f11851C;

    /* renamed from: J */
    private boolean f11858J;

    /* renamed from: j */
    private ArrayList<BasicDataStreamBean> f11861j;

    /* renamed from: k */
    private ArrayList<BasicButtonBean> f11862k;

    /* renamed from: o */
    private DataStreamManager f11866o;

    /* renamed from: p */
    private IconRadioButton f11867p;

    /* renamed from: q */
    private IconButton f11868q;

    /* renamed from: r */
    private IconButton f11869r;

    /* renamed from: s */
    private IconButton f11870s;

    /* renamed from: t */
    private IconButton f11871t;

    /* renamed from: u */
    private SpinnerPopupWindow f11872u;

    /* renamed from: v */
    private ICallKeyDownFragment f11873v;

    /* renamed from: x */
    private BottomActionBar f11875x;

    /* renamed from: z */
    private WaitDialog f11877z;

    /* renamed from: b */
    private Bundle f11860b = new Bundle();

    /* renamed from: l */
    private String f11863l = "";

    /* renamed from: m */
    private String f11864m = "";

    /* renamed from: n */
    private String f11865n = null;

    /* renamed from: w */
    private BottomActionBar.AbstractC2090a f11874w = null;

    /* renamed from: y */
    private int f11876y = -1;

    /* renamed from: D */
    private int f11852D = -1;

    /* renamed from: E */
    private final int f11853E = 121212;

    /* renamed from: F */
    private final int f11854F = 10086;

    /* renamed from: G */
    private final int f11855G = 131313;

    /* renamed from: H */
    private ArrayList<TextView> f11856H = new ArrayList<>();

    /* renamed from: I */
    private boolean f11857I = false;

    /* renamed from: a */
    int f11859a = 0;

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.IDataStreamSelectionRecorder
    /* renamed from: a */
    public final void mo6404a(IDataStreamSelector iDataStreamSelector) {
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.ICallKeyDownFragment
    /* renamed from: d */
    public final void mo6298d() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: i */
    public static /* synthetic */ boolean m7314i(ActiveTestFragment activeTestFragment) {
        activeTestFragment.f11857I = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: r */
    public static /* synthetic */ boolean m7305r(ActiveTestFragment activeTestFragment) {
        activeTestFragment.f11858J = true;
        return true;
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, android.app.Fragment
    public final void onAttach(Activity activity) {
        super.onAttach(activity);
        Bundle arguments = getArguments();
        ArrayList arrayList = new ArrayList();
        if (arguments != null) {
            this.f11861j = (ArrayList) arguments.getSerializable("ActiveTestList");
            this.f11862k = (ArrayList) arguments.getSerializable("ActiveTestButton");
            this.f11864m = arguments.getString("ActiveTestType");
            this.f11865n = arguments.getString("ActiveTitle");
            if (this.f11861j != null) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < this.f11861j.size(); i++) {
                    arrayList.add(new ArrayList());
                    sb.append("1");
                }
                this.f11863l = sb.toString();
            }
        }
        this.f11866o = new X431DataStreamManager(arrayList);
        DataStreamManager dataStreamManager = this.f11866o;
        dataStreamManager.f11749k = "ACTIVITY_TEST";
        ArrayList<BasicDataStreamBean> arrayList2 = this.f11861j;
        if (arrayList2 != null) {
            dataStreamManager.m7387a(arrayList2);
        }
        if (this.f11865n == null) {
            this.f12357d.mo7083i().setSubTitle(getString(R.string.fragment_title_activetest));
        } else {
            this.f12357d.mo7083i().setSubTitle(this.f11865n);
        }
    }

    @Override // android.app.Fragment
    public final void onPause() {
        super.onPause();
        SpinnerPopupWindow spinnerPopupWindow = this.f11872u;
        if (spinnerPopupWindow != null) {
            spinnerPopupWindow.m4583a();
        }
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f12357d.mo7097a((OnDiagnoseDataUpdateListenter) this);
        this.f11868q = (IconButton) getActivity().findViewById(R.id.btn_value);
        this.f11869r = (IconButton) getActivity().findViewById(R.id.btn_active_test_graph);
        this.f11871t = (IconButton) getActivity().findViewById(R.id.btn_setMax_Min);
        this.f11870s = (IconButton) getActivity().findViewById(R.id.btn_active_combination);
        this.f11871t.setOnClickListener(this);
        this.f11867p = (IconRadioButton) getActivity().findViewById(R.id.btn_translation);
        if (this.f12356c) {
            this.f11867p.setOnClickListener(this);
        }
        if (this.f12357d.mo7083i().getDiagnoseStatue() > 1 && PreferencesManager.m9595a((Context) getActivity()).m9583b("is_provides_translation", false)) {
            String m9469a = LangManager.m9469a();
            LangManager.m9466b();
            if (m9469a.equalsIgnoreCase("ZH") || m9469a.equalsIgnoreCase("TW") || m9469a.equalsIgnoreCase("HK") || m9469a.equalsIgnoreCase("EN") || m9469a.equalsIgnoreCase("CN")) {
                this.f11867p.setVisibility(8);
            } else {
                this.f11867p.setVisibility(0);
            }
        } else {
            this.f11867p.setVisibility(8);
        }
        this.f11875x = new BottomActionBar(getActivity());
        C2158c c2158c = new C2158c(this, this.f11869r);
        TabListener tabListener = new TabListener(getActivity(), GraphGridFragment.class, this.f11860b, new RunnableC2111a(false), this);
        tabListener.f12429a = this;
        c2158c.f11710b = tabListener;
        C2170d c2170d = new C2170d(this, this.f11868q);
        c2170d.f11710b = new TabListener(getActivity(), ActiveTextListFragment.class, this.f11860b, new RunnableC2111a(true), this);
        if (this.f11864m.equals(DiagnoseConstants.UI_TYPE_FIXED_ITEM_ACTIVE_TEST)) {
            this.f11875x.m7421a(c2158c);
            m7316h();
            this.f11869r.setVisibility(0);
        } else {
            this.f11869r.setVisibility(8);
        }
        this.f11875x.m7421a(c2170d);
        this.f11868q.performClick();
        this.f11877z = new WaitDialog(getActivity(), false, getString(R.string.diag_tip_translating));
        this.f11877z.setCanceledOnTouchOutside(false);
        this.f11849A = this.f11877z.f16396b;
        this.f11850B = new HandlerC2175i(this);
        m7322c(this.f11862k);
    }

    @Override // android.app.Fragment
    public final void onResume() {
        super.onResume();
        DiagnoseConstants.ACTIVE_TEST_REFRESH = true;
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public final void onDestroy() {
        this.f11866o.m7382c();
        this.f12357d.mo7083i().setActiveTest(false);
        super.onDestroy();
    }

    /* renamed from: h */
    private void m7316h() {
        BottomActionBar.AbstractC2090a abstractC2090a = this.f11874w;
        if (abstractC2090a != null) {
            this.f11875x.m7420b(abstractC2090a);
        }
        this.f11874w = new C2136b(this, this.f11870s);
        this.f11874w.f11710b = new TabListener(getActivity(), CombinedGraphFragment.class, this.f11860b, new RunnableC2111a(false), this);
        this.f11875x.m7421a(this.f11874w);
    }

    /* renamed from: c */
    public static String m7324c(int i) {
        String hexString = Integer.toHexString(i);
        int length = hexString.length();
        while (length < 2) {
            hexString = "0".concat(String.valueOf(hexString));
            length = hexString.length();
        }
        return hexString;
    }

    /* renamed from: c */
    private void m7322c(ArrayList<BasicButtonBean> arrayList) {
        int i;
        if ((arrayList == null ? 0 : arrayList.size()) == 0) {
            getActivity().findViewById(R.id.group_btn).setVisibility(8);
            return;
        }
        getActivity().findViewById(R.id.group_btn).setVisibility(0);
        LinearLayout linearLayout = (LinearLayout) getActivity().findViewById(R.id.group_btn);
        LinearLayout linearLayout2 = (LinearLayout) getActivity().findViewById(R.id.group_btn2);
        int i2 = getResources().getDisplayMetrics().widthPixels;
        if (this.f12357d.mo7083i().getDiagnoseStatue() != 1) {
            if (arrayList.size() == 1 && PathUtils.m4866a(DiagnoseConstants.DIAGNOSE_LIB_PATH)) {
                getActivity().findViewById(R.id.group_btn).setVisibility(8);
                return;
            }
            if (arrayList.size() > 1 && PathUtils.m4866a(DiagnoseConstants.DIAGNOSE_LIB_PATH)) {
                i = 1;
            }
            i = 0;
        } else if (arrayList.size() == 1 && DataStreamConfiguration.f10580f) {
            getActivity().findViewById(R.id.group_btn).setVisibility(8);
            return;
        } else {
            if (arrayList.size() > 1 && DataStreamConfiguration.f10580f) {
                i = 1;
            }
            i = 0;
        }
        int i3 = 0;
        for (int i4 = i; i4 < arrayList.size(); i4++) {
            TextView textView = (TextView) LayoutInflater.from(this.mContext).inflate(R.layout.item_button_activetest, (ViewGroup) null).findViewById(R.id.tv_title);
            textView.setText(arrayList.get(i4).getTitle());
            TextPaint paint = textView.getPaint();
            i3 = (int) (i3 + paint.measureText(arrayList.get(i4).getTitle()) + 28.0f);
        }
        if (i2 > i3) {
            linearLayout.setVisibility(0);
            linearLayout2.setVisibility(8);
            linearLayout.removeAllViews();
            SpinnerPopupWindow spinnerPopupWindow = this.f11872u;
            if (spinnerPopupWindow != null) {
                spinnerPopupWindow.m4583a();
            }
            int size = (i2 - i3) / (arrayList.size() - i);
            this.f11856H.clear();
            while (i < arrayList.size()) {
                View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.item_button_activetest, (ViewGroup) null);
                TextView textView2 = (TextView) inflate.findViewById(R.id.tv_title);
                textView2.setId(i);
                textView2.setSingleLine(true);
                textView2.setText(arrayList.get(i).getTitle());
                textView2.setEnabled(this.f11857I ^ true);
                this.f11856H.add(textView2);
                if (this.f12357d.mo7083i().getDiagnoseStatue() == 0) {
                    textView2.setEnabled(false);
                } else {
                    textView2.setOnClickListener(new View$OnClickListenerC2171e(this));
                }
                TextPaint paint2 = textView2.getPaint();
                textView2.setWidth(((int) paint2.measureText(arrayList.get(i).getTitle())) + 28 + size);
                linearLayout.addView(inflate);
                i++;
            }
            return;
        }
        linearLayout.setVisibility(8);
        linearLayout2.setVisibility(0);
        TextView textView3 = (TextView) getActivity().findViewById(R.id.active_spinner);
        textView3.setVisibility(0);
        int i5 = this.f11852D;
        if (i5 != -1) {
            if (i5 > arrayList.size() - 1) {
                this.f11852D = -1;
                if (this.f12357d.mo7083i().getDiagnoseStatue() != 1) {
                    if (PathUtils.m4866a(DiagnoseConstants.DIAGNOSE_LIB_PATH)) {
                        textView3.setText(arrayList.get(1).getTitle());
                    } else {
                        textView3.setText(arrayList.get(0).getTitle());
                    }
                } else if (DataStreamConfiguration.f10580f) {
                    textView3.setText(arrayList.get(1).getTitle());
                } else {
                    textView3.setText(arrayList.get(0).getTitle());
                }
            } else {
                textView3.setText(arrayList.get(this.f11852D).getTitle());
            }
        } else if (this.f12357d.mo7083i().getDiagnoseStatue() != 1) {
            if (PathUtils.m4866a(DiagnoseConstants.DIAGNOSE_LIB_PATH)) {
                textView3.setText(arrayList.get(1).getTitle());
            } else {
                textView3.setText(arrayList.get(0).getTitle());
            }
        } else if (DataStreamConfiguration.f10580f) {
            textView3.setText(arrayList.get(1).getTitle());
        } else {
            textView3.setText(arrayList.get(0).getTitle());
        }
        textView3.setOnClickListener(new View$OnClickListenerC2172f(this, arrayList, textView3));
        Button button = (Button) getActivity().findViewById(R.id.active_ok);
        button.setVisibility(0);
        button.setEnabled(!this.f11857I);
        if (this.f12357d.mo7083i().getDiagnoseStatue() == 0) {
            button.setEnabled(false);
        } else {
            button.setOnClickListener(new View$OnClickListenerC2174h(this, arrayList, textView3, button));
        }
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        SpinnerPopupWindow spinnerPopupWindow = this.f11872u;
        if (spinnerPopupWindow != null) {
            spinnerPopupWindow.m4583a();
        }
        m7322c(this.f11862k);
    }

    /* renamed from: d */
    private boolean m7320d(ArrayList<BasicButtonBean> arrayList) {
        if (!this.f11857I && this.f11862k.size() == arrayList.size()) {
            for (int i = 0; i < this.f11862k.size(); i++) {
                if (!this.f11862k.get(i).getTitle().equals(arrayList.get(i).getTitle())) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment
    /* renamed from: b */
    public final String mo7102b() {
        return getString(R.string.fragment_title_activetest);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public final View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_activetest_show, viewGroup, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ActiveTestFragment.java */
    /* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.a$a */
    /* loaded from: classes.dex */
    public class RunnableC2111a implements Runnable {

        /* renamed from: b */
        private boolean f11879b;

        public RunnableC2111a(boolean z) {
            this.f11879b = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActiveTestFragment.this.f11860b.putString("DataStreamShow_Type", "ActiveTest");
            ActiveTestFragment.this.f11860b.putString("ActiveTestType", ActiveTestFragment.this.f11864m);
            ActiveTestFragment.this.f11860b.putString("DataStreamMask", ActiveTestFragment.this.f11863l);
            ActiveTestFragment.this.f11860b.putSerializable("ActiveValueList", ActiveTestFragment.this.f11861j);
            ActiveTestFragment.this.f11860b.putSerializable("ActiveButtonList", ActiveTestFragment.this.f11862k);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.IDataStreamSelectionRecorder
    /* renamed from: a */
    public final void mo6399a(String str) {
        this.f11863l = str;
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment
    /* renamed from: c */
    public final String mo7100c() {
        ArrayList<BasicDataStreamBean> arrayList = this.f11861j;
        if (arrayList == null || arrayList.size() == 0) {
            return super.mo7100c();
        }
        return PrintDataUtils.m4933a(getActivity(), this.f11861j);
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, android.view.View.OnClickListener
    public final void onClick(View view) {
        super.onClick(view);
        int id = view.getId();
        if (id == R.id.btn_setMax_Min) {
            this.f11873v.mo6305a();
        } else if (id == R.id.btn_translation) {
            if (!this.f11867p.isChecked()) {
                this.f11866o.m7388a((SerializableMap) null);
                this.f11866o.m7387a(this.f11861j);
                this.f11867p.setEnabled(true);
                return;
            }
            SerializableMap serializableMap = this.f11851C;
            if (serializableMap == null) {
                this.f11858J = false;
                this.f11849A.setProgress(0);
                this.f11877z.show();
                request(10086);
                this.f11867p.setEnabled(false);
                return;
            }
            this.f11866o.m7388a(serializableMap);
            this.f11866o.m7387a(this.f11861j);
            this.f11867p.setEnabled(true);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public final void onSuccess(int i, Object obj) {
        if (i == 10086) {
            this.f11877z.dismiss();
            this.f11866o.m7388a(this.f11851C);
            this.f11866o.m7387a(this.f11861j);
            this.f11867p.setEnabled(true);
        }
        super.onSuccess(i, obj);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public final void onFailure(int i, int i2, Object obj) {
        if (i == 10086) {
            this.f11877z.dismiss();
            this.f11867p.setChecked(false);
            this.f11867p.setEnabled(true);
        }
        super.onFailure(i, i2, obj);
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.ICallKeyDownFragment
    /* renamed from: a */
    public final boolean mo6304a(int i, KeyEvent keyEvent) {
        if (i == 1) {
            this.f11871t.setVisibility(8);
            this.f11871t.setEnabled(false);
        } else if (i == 0) {
            this.f11871t.setVisibility(0);
            this.f11871t.setEnabled(true);
        }
        return false;
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.IDataStreamSelectionRecorder
    /* renamed from: b */
    public final void mo6396b(int i) {
        this.f11876y = i;
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.ICallKeyDownFragment
    /* renamed from: a */
    public final void mo6302a(ICallKeyDownFragment iCallKeyDownFragment) {
        this.f11873v = iCallKeyDownFragment;
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.ICallKeyDownFragment
    /* renamed from: a */
    public final void mo6305a() {
        ICallKeyDownFragment iCallKeyDownFragment = this.f11873v;
        if (iCallKeyDownFragment != null) {
            iCallKeyDownFragment.mo6305a();
        }
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.x431pro.activity.golo.p225b.OnGoloKeyDownListener
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.f12357d.mo7083i().getDiagnoseStatue() != 1) {
                if (!PathUtils.m4866a(DiagnoseConstants.DIAGNOSE_LIB_PATH)) {
                    NToast.m9442d(this.mContext, (int) R.string.dialog_exit_function);
                    return true;
                }
                return super.onKeyDown(i, keyEvent);
            } else if (!DataStreamConfiguration.f10580f) {
                NToast.m9442d(this.mContext, (int) R.string.dialog_exit_function);
                return true;
            } else {
                return super.onKeyDown(i, keyEvent);
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, com.cnlaunch.x431pro.activity.diagnose.p222e.OnDiagnoseDataUpdateListenter
    /* renamed from: a */
    public final void mo7077a(ArrayList<BasicDataStreamBean> arrayList, ArrayList<BasicButtonBean> arrayList2) {
        boolean z;
        ICallKeyDownFragment iCallKeyDownFragment;
        if (this.f11861j.size() == arrayList.size()) {
            ArrayList arrayList3 = new ArrayList();
            for (int i = 0; i < this.f11861j.size(); i++) {
                arrayList3.add(this.f11861j.get(i).getTitle());
            }
            int i2 = 0;
            while (true) {
                if (i2 >= arrayList3.size()) {
                    z = true;
                    break;
                } else if (!arrayList3.contains(arrayList.get(i2).getTitle())) {
                    z = false;
                    break;
                } else {
                    i2++;
                }
            }
        } else {
            z = false;
        }
        if (!z) {
            this.f11867p.setChecked(false);
            this.f11851C = null;
            this.f11866o.m7388a((SerializableMap) null);
            ProgressBar progressBar = this.f11849A;
            if (progressBar != null) {
                progressBar.setProgress(0);
            }
        }
        if (this.f11861j.size() != arrayList.size() && (iCallKeyDownFragment = this.f11873v) != null) {
            iCallKeyDownFragment.mo6304a(1, null);
        }
        if (this.f11861j.size() != arrayList.size()) {
            this.f11861j = arrayList;
            this.f11868q.performClick();
            StringBuilder sb = new StringBuilder();
            for (int i3 = 0; i3 < this.f11861j.size(); i3++) {
                sb.append("1");
            }
            this.f11863l = sb.toString();
            if (this.f11864m.equals(DiagnoseConstants.UI_TYPE_FIXED_ITEM_ACTIVE_TEST)) {
                m7316h();
            } else {
                this.f11866o.m7387a(arrayList);
            }
        } else {
            this.f11866o.m7387a(arrayList);
        }
        this.f11861j = arrayList;
        if (m7320d(arrayList2)) {
            return;
        }
        if (this.f11857I) {
            this.f11857I = false;
        }
        this.f11862k = arrayList2;
        m7322c(arrayList2);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public final Object doInBackground(int i) throws C1425f {
        if (i == 10086) {
            NLog.m9452b("yuandong", "local lang： ".concat(String.valueOf(LangManager.m9469a())));
            Map<String, String> hashMap = new HashMap<>();
            this.f11859a = 0;
            for (int i2 = 0; i2 < this.f11861j.size() && !this.f11858J; i2++) {
                String title = this.f11861j.get(i2).getTitle();
                if (!"".equals(title) && !hashMap.containsKey(title)) {
                    TranslationUtil.C2754a.m5066a().m5067a(title.trim(), new C2176j(this, hashMap, title, i2));
                } else {
                    this.f11859a = ((i2 + 1) * 100) / this.f11861j.size();
                    this.f11850B.sendMessage(this.f11850B.obtainMessage(121212, this.f11859a, 0));
                }
            }
            if (!this.f11858J) {
                this.f11851C = new SerializableMap();
                this.f11851C.setMap(hashMap);
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public static /* synthetic */ void m7318f(ActiveTestFragment activeTestFragment) {
        ArrayList<BasicButtonBean> arrayList = activeTestFragment.f11862k;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        activeTestFragment.m7322c(activeTestFragment.f11862k);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: j */
    public static /* synthetic */ void m7313j(ActiveTestFragment activeTestFragment) {
        int size = activeTestFragment.f11856H.size();
        for (int i = 0; i < size; i++) {
            activeTestFragment.f11856H.get(i).setEnabled(false);
        }
    }
}
