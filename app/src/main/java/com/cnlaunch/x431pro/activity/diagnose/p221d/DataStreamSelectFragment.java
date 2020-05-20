package com.cnlaunch.x431pro.activity.diagnose.p221d;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.cnlaunch.diagnosemodule.bean.BasicSelectMenuBean;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.activity.diagnose.p218a.DatastreamSelectListAdapter;
import com.cnlaunch.x431pro.module.p252d.p254b.DiagnoseRunningInfo;
import com.cnlaunch.x431pro.utils.p288h.PrintDataUtils;
import com.cnlaunch.x431pro.widget.button.IconButton;
import com.cnlaunch.x431pro.widget.button.IconRadioButton;
import com.cnlaunch.x431pro.widget.staggeredgridview.StaggeredGridView;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;

/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.y */
/* loaded from: classes.dex */
public final class DataStreamSelectFragment extends BaseDiagnoseFragment implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    public TextView f12411a;

    /* renamed from: k */
    private IconButton f12414k;

    /* renamed from: l */
    private IconButton f12415l;

    /* renamed from: m */
    private IconButton f12416m;

    /* renamed from: n */
    private IconButton f12417n;

    /* renamed from: o */
    private TextView f12418o;

    /* renamed from: p */
    private IconRadioButton f12419p;

    /* renamed from: j */
    private StaggeredGridView f12413j = null;

    /* renamed from: b */
    public DatastreamSelectListAdapter f12412b = null;

    /* renamed from: q */
    private ArrayList<BasicSelectMenuBean> f12420q = null;

    /* renamed from: r */
    private boolean f12421r = false;

    /* renamed from: s */
    private boolean f12422s = false;

    /* renamed from: t */
    private String f12423t = "menu";

    /* renamed from: u */
    private int f12424u = 0;

    /* renamed from: v */
    private String f12425v = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ boolean m7103a(DataStreamSelectFragment dataStreamSelectFragment) {
        dataStreamSelectFragment.f12421r = true;
        return true;
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, android.app.Fragment
    public final void onAttach(Activity activity) {
        super.onAttach(activity);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f12420q = (ArrayList) arguments.getSerializable("DataStreamSelect");
            this.f12422s = arguments.getBoolean("CheckAll");
            this.f12425v = arguments.getString("IS_SORT");
        }
        this.f12357d.mo7083i().setSubTitle(getString(R.string.fragment_title_datastreamselect));
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f12423t = this.f12357d.mo7083i().getDataStreamSelectJumpType();
        this.f12424u = this.f12357d.mo7083i().getMenuSelectIndex();
        this.f12413j = (StaggeredGridView) getActivity().findViewById(R.id.gridview_select);
        ArrayList<BasicSelectMenuBean> arrayList = this.f12420q;
        if (arrayList != null && arrayList.size() != 0) {
            boolean m9583b = PreferencesManager.m9595a((Context) getActivity()).m9583b("is_sort", false);
            if (this.f12357d.mo7083i().getDiagnoseStatue() < 2) {
                m9583b = true;
            }
            String str = this.f12425v;
            if (str != null) {
                m9583b = Boolean.valueOf(str).booleanValue();
            }
            this.f12412b = new DatastreamSelectListAdapter(this.f12420q, "DataStream", getActivity(), !DiagnoseConstants.IS_SORT ? false : m9583b, this.f12422s, this.f12424u, this.f12423t);
            DatastreamSelectListAdapter datastreamSelectListAdapter = this.f12412b;
            datastreamSelectListAdapter.f11311d = this;
            this.f12413j.setAdapter((ListAdapter) datastreamSelectListAdapter);
        }
        this.f12415l = (IconButton) getActivity().findViewById(R.id.btn_pageunselectall);
        this.f12414k = (IconButton) getActivity().findViewById(R.id.btn_pageselectall);
        this.f12416m = (IconButton) getActivity().findViewById(R.id.btn_value_confirm);
        this.f12417n = (IconButton) getActivity().findViewById(R.id.btn_graph_confirm);
        this.f12419p = (IconRadioButton) getActivity().findViewById(R.id.btn_selectall);
        this.f12411a = (TextView) getActivity().findViewById(R.id.tv_sel_number_current);
        this.f12418o = (TextView) getActivity().findViewById(R.id.tv_datastream_number_total);
        TextView textView = this.f12418o;
        StringBuilder sb = new StringBuilder();
        ArrayList<BasicSelectMenuBean> arrayList2 = this.f12420q;
        sb.append(arrayList2 != null ? arrayList2.size() : 0);
        textView.setText(sb.toString());
        TextView textView2 = this.f12411a;
        StringBuilder sb2 = new StringBuilder();
        DatastreamSelectListAdapter datastreamSelectListAdapter2 = this.f12412b;
        sb2.append(datastreamSelectListAdapter2 != null ? datastreamSelectListAdapter2.m7504e() : 0);
        textView2.setText(sb2.toString());
        this.f12414k.setOnLongClickListener(new View$OnLongClickListenerC2184z(this));
        this.f12419p.setChecked(this.f12421r);
        if (this.f12356c) {
            this.f12413j.setOnItemClickListener(this);
            this.f12415l.setOnClickListener(this);
            this.f12414k.setOnClickListener(this);
            this.f12416m.setOnClickListener(this);
            this.f12417n.setOnClickListener(this);
            this.f12419p.setOnClickListener(this);
        }
        this.f12414k.setEnabled(this.f12356c);
        this.f12415l.setEnabled(this.f12356c);
        this.f12419p.setEnabled(this.f12356c);
        this.f12417n.setEnabled(this.f12356c);
        this.f12416m.setEnabled(this.f12356c);
        this.f12413j.setSelection(this.f12357d.mo7083i().getDatastreamSelectIndex());
        DatastreamSelectListAdapter datastreamSelectListAdapter3 = this.f12412b;
        if (datastreamSelectListAdapter3 != null) {
            datastreamSelectListAdapter3.f11308a = this.f12356c;
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public final View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_datastream_select, viewGroup, false);
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, android.view.View.OnClickListener
    public final void onClick(View view) {
        int i;
        super.onClick(view);
        int id = view.getId();
        if (id == R.id.btn_value_confirm) {
            DiagnoseRunningInfo mo7083i = this.f12357d.mo7083i();
            DatastreamSelectListAdapter datastreamSelectListAdapter = this.f12412b;
            if (datastreamSelectListAdapter.f11309b != null && datastreamSelectListAdapter.f11309b.size() > 0) {
                i = 0;
                while (true) {
                    if (i >= datastreamSelectListAdapter.f11309b.size()) {
                        i = 0;
                        break;
                    } else if (datastreamSelectListAdapter.f11309b.get(i).isCheck()) {
                        break;
                    } else {
                        i++;
                    }
                }
            } else {
                i = 0;
            }
            mo7083i.setDatastreamSelectIndex(i);
            this.f12357d.mo7083i().setDataStreamJumpType(0);
            int m7502g = this.f12412b.m7502g();
            this.f12357d.mo7083i().setDataStreamCount(m7502g);
            if (m7502g == 0) {
                NToast.m9447b(getActivity(), (int) R.string.toast_need_one_item);
                return;
            }
            this.f12357d.mo7082j();
            if (this.f12357d.mo7083i().getDiagnoseStatue() == 1) {
                this.f12357d.mo7093a("dataselect_count", String.valueOf(m7502g), 18);
            }
            ArrayList<String> m7503f = this.f12412b.m7503f();
            String m7505d = this.f12412b.m7505d();
            this.f12357d.mo7090a("3", m7503f);
            this.f12357d.mo7093a("3", m7505d, 3);
        } else if (id == R.id.btn_graph_confirm) {
            this.f12357d.mo7082j();
            this.f12357d.mo7083i().setDataStreamJumpType(1);
            int m7502g2 = this.f12412b.m7502g();
            this.f12357d.mo7083i().setDataStreamCount(m7502g2);
            if (m7502g2 == 0) {
                NToast.m9447b(getActivity(), (int) R.string.toast_need_one_item);
                return;
            }
            if (this.f12357d.mo7083i().getDiagnoseStatue() == 1) {
                this.f12357d.mo7093a("dataselect_count", String.valueOf(m7502g2), 18);
            }
            ArrayList<String> m7503f2 = this.f12412b.m7503f();
            String m7505d2 = this.f12412b.m7505d();
            this.f12357d.mo7090a("3", m7503f2);
            this.f12357d.mo7093a("3", m7505d2, 3);
        } else if (id == R.id.btn_selectall) {
            if (this.f12421r) {
                this.f12421r = false;
                this.f12412b.m7506c();
            } else {
                this.f12421r = true;
                this.f12412b.m7513a();
            }
            TextView textView = this.f12411a;
            StringBuilder sb = new StringBuilder();
            sb.append(this.f12412b.m7504e());
            textView.setText(sb.toString());
        } else if (id == R.id.btn_pageselectall) {
            this.f12412b.m7511a(this.f12413j.getFirstVisiblePosition(), this.f12413j.getLastVisiblePosition());
            TextView textView2 = this.f12411a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.f12412b.m7504e());
            textView2.setText(sb2.toString());
        } else if (id == R.id.btn_pageunselectall) {
            this.f12412b.m7508b();
            TextView textView3 = this.f12411a;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(this.f12412b.m7504e());
            textView3.setText(sb3.toString());
        }
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment
    /* renamed from: b */
    public final String mo7102b() {
        return getString(R.string.fragment_title_datastreamselect);
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment
    /* renamed from: c */
    public final String mo7100c() {
        ArrayList<BasicSelectMenuBean> arrayList = this.f12420q;
        if (arrayList == null || arrayList.size() == 0) {
            return super.mo7100c();
        }
        return PrintDataUtils.m4933a(getActivity(), this.f12420q);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.f12356c) {
            this.f12412b.m7512a(i);
            TextView textView = this.f12411a;
            StringBuilder sb = new StringBuilder();
            sb.append(this.f12412b.m7504e());
            textView.setText(sb.toString());
        }
    }
}
