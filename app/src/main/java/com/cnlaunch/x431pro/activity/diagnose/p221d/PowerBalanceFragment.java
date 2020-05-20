package com.cnlaunch.x431pro.activity.diagnose.p221d;

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

/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.bk */
/* loaded from: classes.dex */
public class PowerBalanceFragment extends BaseDataStreamShowingFragment implements ICallKeyDownFragment {

    /* renamed from: e */
    private ICallKeyDownFragment f12101e;

    /* renamed from: o */
    private ArrayList<BasicDataStreamBean> f12111o;

    /* renamed from: p */
    private ArrayList<BasicDataStreamBean> f12112p;

    /* renamed from: f */
    private RelativeLayout f12102f = null;

    /* renamed from: g */
    private LinearLayout f12103g = null;

    /* renamed from: h */
    private C2146a[] f12104h = null;

    /* renamed from: i */
    private int f12105i = 0;

    /* renamed from: j */
    private boolean f12106j = false;

    /* renamed from: k */
    private int f12107k = 0;

    /* renamed from: l */
    private int f12108l = 0;

    /* renamed from: m */
    private int f12109m = 0;

    /* renamed from: n */
    private int f12110n = 0;

    /* renamed from: q */
    private DataStreamGraphicalView f12113q = null;

    /* renamed from: r */
    private DataStreamGraphicalView f12114r = null;

    /* renamed from: s */
    private SpecialDataStreamChart f12115s = null;

    /* renamed from: t */
    private SpecialDataStreamChart f12116t = null;

    /* renamed from: u */
    private DataStreamSeriesRenderer f12117u = null;

    /* renamed from: v */
    private List<XYSeries> f12118v = null;

    /* renamed from: w */
    private boolean f12119w = true;

    /* renamed from: x */
    private int f12120x = 0;

    /* renamed from: y */
    private int f12121y = 0;

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.ICallKeyDownFragment
    /* renamed from: d */
    public final void mo6298d() {
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.x431pro.activity.golo.p225b.OnGoloKeyDownListener
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PowerBalanceFragment.java */
    /* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.bk$a */
    /* loaded from: classes.dex */
    public class C2146a {

        /* renamed from: a */
        TextView f12122a;

        /* renamed from: b */
        TextView f12123b;

        /* renamed from: c */
        ProgressbarGraduation f12124c;

        private C2146a() {
        }

        /* synthetic */ C2146a(PowerBalanceFragment powerBalanceFragment, byte b) {
            this();
        }
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDataStreamShowingFragment, android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f12106j = arguments.getBoolean("Limit");
            this.f12107k = arguments.getInt("FirstMin");
            this.f12108l = arguments.getInt("FirstMax");
            this.f12109m = arguments.getInt("FirstCount");
            this.f12110n = arguments.getInt("SecondCount");
            this.f12111o = (ArrayList) arguments.getSerializable("FirstDataList");
            this.f12112p = (ArrayList) arguments.getSerializable("SecondDataList");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0147  */
    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDataStreamShowingFragment, com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onActivityCreated(android.os.Bundle r17) {
        /*
            Method dump skipped, instructions count: 838
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.x431pro.activity.diagnose.p221d.PowerBalanceFragment.onActivityCreated(android.os.Bundle):void");
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDataStreamShowingFragment, android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        DataStreamSeriesRenderer dataStreamSeriesRenderer = this.f12117u;
        if (dataStreamSeriesRenderer != null) {
            if (dataStreamSeriesRenderer.getParentViewBitmap() != null) {
                this.f12117u.getParentViewBitmap().recycle();
            }
            this.f12117u.setParentViewBitmap(null);
            this.f12117u = null;
        }
        DataStreamGraphicalView dataStreamGraphicalView = this.f12113q;
        if (dataStreamGraphicalView != null) {
            dataStreamGraphicalView.setBitmap(null);
            this.f12113q = null;
        }
        SpecialDataStreamChart specialDataStreamChart = this.f12116t;
        if (specialDataStreamChart != null) {
            specialDataStreamChart.stopRefreshTimer();
        }
        this.f12116t = null;
        this.f12115s = null;
        System.gc();
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
        m7195c();
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
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.x431pro.activity.diagnose.p221d.PowerBalanceFragment.mo6296a(long, java.util.List, java.util.List, com.cnlaunch.x431pro.module.d.b.s):void");
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDataStreamShowingFragment, com.cnlaunch.x431pro.activity.diagnose.p220c.DataStreamObserver
    /* renamed from: a */
    public final void mo6301a(List<BasicDataStreamBean> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        int size = list.size();
        if (this.f12104h != null) {
            for (int i = 0; i < size; i++) {
                BasicDataStreamBean basicDataStreamBean = list.get(i);
                m7196a(i, basicDataStreamBean.getTitle(), basicDataStreamBean.getSrcValue(), basicDataStreamBean.getSrcValue());
            }
        }
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.ICallKeyDownFragment
    /* renamed from: a */
    public final void mo6302a(ICallKeyDownFragment iCallKeyDownFragment) {
        this.f12101e = iCallKeyDownFragment;
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.ICallKeyDownFragment
    /* renamed from: a */
    public final boolean mo6304a(int i, KeyEvent keyEvent) {
        return onKeyDown(i, keyEvent);
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.ICallKeyDownFragment
    /* renamed from: a */
    public final void mo6305a() {
        m7195c();
    }

    /* renamed from: c */
    private void m7195c() {
        DataStreamSeriesRenderer dataStreamSeriesRenderer;
        if (this.f12113q == null || (dataStreamSeriesRenderer = this.f12117u) == null || this.f12118v == null) {
            return;
        }
        synchronized (dataStreamSeriesRenderer) {
            if (this.f12118v != null) {
                this.f12118v.clear();
            }
            this.f12113q.setBitmap(null);
            this.f12113q.m9673a();
            if (this.f12114r != null) {
                this.f12114r.m9673a();
                this.f12116t.startTimer();
            }
        }
        for (int i = 0; i < this.f12110n; i++) {
            m7196a(i, "", "0", "0");
        }
    }

    /* renamed from: a */
    private void m7196a(int i, String str, String str2, String str3) {
        C2146a[] c2146aArr = this.f12104h;
        if (c2146aArr == null || c2146aArr[i] == null) {
            return;
        }
        if (str != null && !str.isEmpty() && !"".equals(str)) {
            this.f12104h[i].f12122a.setText(str);
        }
        if (str2 != null && !str2.isEmpty()) {
            this.f12104h[i].f12123b.setText(str2);
        }
        if (str3 == null || str3.isEmpty()) {
            return;
        }
        this.f12104h[i].f12124c.setProgress(Float.valueOf(str3).floatValue());
    }

    /* renamed from: e */
    private int m7194e() {
        DataStreamGraphicalView dataStreamGraphicalView = this.f12114r;
        if (dataStreamGraphicalView != null) {
            return dataStreamGraphicalView.getHeight();
        }
        return 0;
    }

    /* renamed from: f */
    private int m7193f() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }
}
