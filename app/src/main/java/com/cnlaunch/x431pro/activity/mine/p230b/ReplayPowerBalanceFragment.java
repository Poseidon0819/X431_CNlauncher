package com.cnlaunch.x431pro.activity.mine.p230b;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cnlaunch.diagnosemodule.bean.BasicDataStreamBean;
import com.cnlaunch.p112a.DataStreamGraphicalView;
import com.cnlaunch.p112a.p113a.SpecialDataStreamChart;
import com.cnlaunch.p112a.p114b.XYSeries;
import com.cnlaunch.p112a.p115c.DataStreamSeriesRenderer;
import com.cnlaunch.x431pro.activity.diagnose.p220c.ICallKeyDownFragment;
import com.cnlaunch.x431pro.widget.progress.ProgressbarGraduation;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.activity.mine.b.u */
/* loaded from: classes.dex */
public class ReplayPowerBalanceFragment extends BaseDataStreamReplayFragment implements ICallKeyDownFragment {

    /* renamed from: c */
    private ICallKeyDownFragment f13880c;

    /* renamed from: m */
    private ArrayList<BasicDataStreamBean> f13890m;

    /* renamed from: n */
    private ArrayList<BasicDataStreamBean> f13891n;

    /* renamed from: d */
    private RelativeLayout f13881d = null;

    /* renamed from: e */
    private LinearLayout f13882e = null;

    /* renamed from: f */
    private C2430a[] f13883f = null;

    /* renamed from: g */
    private int f13884g = 0;

    /* renamed from: h */
    private boolean f13885h = false;

    /* renamed from: i */
    private int f13886i = 0;

    /* renamed from: j */
    private int f13887j = 0;

    /* renamed from: k */
    private int f13888k = 0;

    /* renamed from: l */
    private int f13889l = 0;

    /* renamed from: o */
    private DataStreamGraphicalView f13892o = null;

    /* renamed from: p */
    private DataStreamGraphicalView f13893p = null;

    /* renamed from: q */
    private SpecialDataStreamChart f13894q = null;

    /* renamed from: r */
    private SpecialDataStreamChart f13895r = null;

    /* renamed from: s */
    private DataStreamSeriesRenderer f13896s = null;

    /* renamed from: t */
    private List<XYSeries> f13897t = null;

    /* renamed from: u */
    private boolean f13898u = true;

    /* renamed from: v */
    private int f13899v = 0;

    /* renamed from: w */
    private int f13900w = 0;

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.ICallKeyDownFragment
    /* renamed from: d */
    public final void mo6298d() {
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.x431pro.activity.golo.p225b.OnGoloKeyDownListener
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReplayPowerBalanceFragment.java */
    /* renamed from: com.cnlaunch.x431pro.activity.mine.b.u$a */
    /* loaded from: classes.dex */
    public class C2430a {

        /* renamed from: a */
        TextView f13901a;

        /* renamed from: b */
        TextView f13902b;

        /* renamed from: c */
        ProgressbarGraduation f13903c;

        private C2430a() {
        }

        /* synthetic */ C2430a(ReplayPowerBalanceFragment replayPowerBalanceFragment, byte b) {
            this();
        }
    }

    @Override // com.cnlaunch.x431pro.activity.mine.p230b.BaseDataStreamReplayFragment, android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f13885h = arguments.getBoolean("Limit");
            this.f13886i = arguments.getInt("FirstMin");
            this.f13887j = arguments.getInt("FirstMax");
            this.f13888k = arguments.getInt("FirstCount");
            this.f13889l = arguments.getInt("SecondCount");
            this.f13890m = (ArrayList) arguments.getSerializable("FirstDataList");
            this.f13891n = (ArrayList) arguments.getSerializable("SecondDataList");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0147  */
    @Override // com.cnlaunch.x431pro.activity.mine.p230b.BaseDataStreamReplayFragment, com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onActivityCreated(android.os.Bundle r17) {
        /*
            Method dump skipped, instructions count: 838
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.x431pro.activity.mine.p230b.ReplayPowerBalanceFragment.onActivityCreated(android.os.Bundle):void");
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_powerbalance_show, viewGroup, false);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // com.cnlaunch.x431pro.activity.mine.p230b.BaseDataStreamReplayFragment, android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        DataStreamSeriesRenderer dataStreamSeriesRenderer = this.f13896s;
        if (dataStreamSeriesRenderer != null) {
            if (dataStreamSeriesRenderer.getParentViewBitmap() != null) {
                this.f13896s.getParentViewBitmap().recycle();
            }
            this.f13896s.setParentViewBitmap(null);
            this.f13896s = null;
        }
        DataStreamGraphicalView dataStreamGraphicalView = this.f13892o;
        if (dataStreamGraphicalView != null) {
            dataStreamGraphicalView.setBitmap(null);
            this.f13892o = null;
        }
        SpecialDataStreamChart specialDataStreamChart = this.f13895r;
        if (specialDataStreamChart != null) {
            specialDataStreamChart.stopRefreshTimer();
        }
        this.f13895r = null;
        this.f13894q = null;
        System.gc();
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x0129 A[Catch: all -> 0x0135, TryCatch #1 {, blocks: (B:26:0x003d, B:28:0x004c, B:31:0x0050, B:32:0x0087, B:34:0x008d, B:35:0x00aa, B:36:0x00af, B:38:0x00b8, B:42:0x00c2, B:44:0x00ce, B:45:0x00d0, B:47:0x00d4, B:48:0x00d6, B:50:0x00db, B:53:0x00e0, B:55:0x00e8, B:57:0x0106, B:60:0x0120, B:62:0x0129, B:63:0x0133, B:58:0x010c, B:59:0x0112, B:41:0x00bf), top: B:74:0x003d, inners: #0 }] */
    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.DataStreamObserver
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void mo6296a(long r7, java.util.List<java.util.ArrayList<com.cnlaunch.diagnosemodule.bean.BasicDataStreamBean>> r9, java.util.List<com.cnlaunch.diagnosemodule.bean.BasicDataStreamBean> r10, com.cnlaunch.x431pro.module.p252d.p254b.SerializableMap r11) {
        /*
            Method dump skipped, instructions count: 322
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.x431pro.activity.mine.p230b.ReplayPowerBalanceFragment.mo6296a(long, java.util.List, java.util.List, com.cnlaunch.x431pro.module.d.b.s):void");
    }

    @Override // com.cnlaunch.x431pro.activity.mine.p230b.BaseDataStreamReplayFragment, com.cnlaunch.x431pro.activity.diagnose.p220c.DataStreamObserver
    /* renamed from: a */
    public final void mo6301a(List<BasicDataStreamBean> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        int size = list.size();
        if (this.f13883f != null) {
            for (int i = 0; i < size; i++) {
                BasicDataStreamBean basicDataStreamBean = list.get(i);
                m6303a(i, basicDataStreamBean.getTitle(), basicDataStreamBean.getSrcValue(), basicDataStreamBean.getSrcValue());
            }
        }
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.ICallKeyDownFragment
    /* renamed from: a */
    public final void mo6302a(ICallKeyDownFragment iCallKeyDownFragment) {
        this.f13880c = iCallKeyDownFragment;
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.ICallKeyDownFragment
    /* renamed from: a */
    public final boolean mo6304a(int i, KeyEvent keyEvent) {
        return onKeyDown(i, keyEvent);
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.ICallKeyDownFragment
    /* renamed from: a */
    public final void mo6305a() {
        m6300b();
    }

    /* renamed from: b */
    private void m6300b() {
        DataStreamSeriesRenderer dataStreamSeriesRenderer;
        if (this.f13892o == null || (dataStreamSeriesRenderer = this.f13896s) == null || this.f13897t == null) {
            return;
        }
        synchronized (dataStreamSeriesRenderer) {
            if (this.f13897t != null) {
                this.f13897t.clear();
            }
            this.f13892o.setBitmap(null);
            this.f13892o.m9673a();
            if (this.f13893p != null) {
                this.f13893p.m9673a();
                this.f13895r.startTimer();
            }
        }
        for (int i = 0; i < this.f13889l; i++) {
            m6303a(i, "", "0", "0");
        }
    }

    /* renamed from: a */
    private void m6303a(int i, String str, String str2, String str3) {
        C2430a[] c2430aArr = this.f13883f;
        if (c2430aArr == null || c2430aArr[i] == null) {
            return;
        }
        if (str != null && !str.isEmpty() && !"".equals(str)) {
            this.f13883f[i].f13901a.setText(str);
        }
        if (str2 != null && !str2.isEmpty()) {
            this.f13883f[i].f13902b.setText(str2);
        }
        if (str3 == null || str3.isEmpty()) {
            return;
        }
        this.f13883f[i].f13903c.setProgress(Float.valueOf(str3).floatValue());
    }

    /* renamed from: c */
    private int m6299c() {
        DataStreamGraphicalView dataStreamGraphicalView = this.f13893p;
        if (dataStreamGraphicalView != null) {
            return dataStreamGraphicalView.getHeight();
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    /* renamed from: e */
    private int m6297e() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }
}
