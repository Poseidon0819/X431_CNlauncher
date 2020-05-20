package com.cnlaunch.x431pro.activity.mine;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.support.p012v4.view.ViewPager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.activity.BaseFragment;
import com.cnlaunch.x431pro.activity.diagnose.p218a.ViewPagerAdapter;
import com.cnlaunch.x431pro.activity.mine.p229a.MyReportAdapter;
import com.cnlaunch.x431pro.activity.mine.p229a.NewLocalReportAdapter;
import com.cnlaunch.x431pro.activity.mine.p229a.RemoteReportAdapter;
import com.cnlaunch.x431pro.activity.share.ShareActivity;
import com.cnlaunch.x431pro.module.p252d.p254b.DiagReportOrHistoryInfo;
import com.cnlaunch.x431pro.module.p255e.p257b.ReportFileInfo;
import com.cnlaunch.x431pro.module.report.p276a.ReportAction;
import com.cnlaunch.x431pro.module.report.p277b.DownLoadReportInfo;
import com.cnlaunch.x431pro.module.report.p277b.DownLoadReportResponse;
import com.cnlaunch.x431pro.p210a.ApplicationTheme;
import com.cnlaunch.x431pro.p210a.LoginTools;
import com.cnlaunch.x431pro.utils.C2778n;
import com.cnlaunch.x431pro.utils.PathUtils;
import com.cnlaunch.x431pro.utils.p282d.C2752f;
import com.cnlaunch.x431pro.utils.p285e.ZipFileUtils;
import com.cnlaunch.x431pro.widget.PagerSlidingTabStrip;
import com.cnlaunch.x431pro.widget.button.IconButton;
import com.cnlaunch.x431pro.widget.button.IconRadioButton;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.cnlaunch.x431pro.widget.pulltorefresh.PullToRefreshBase;
import com.cnlaunch.x431pro.widget.pulltorefresh.PullToRefreshListView;
import com.ifoer.expedition.pro.R;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@SuppressLint({"HandlerLeak"})
/* renamed from: com.cnlaunch.x431pro.activity.mine.cm */
/* loaded from: classes.dex */
public class ReportPagersFragment extends BaseFragment implements ViewPager.InterfaceC0176e, View.OnClickListener {

    /* renamed from: C */
    private String f14068C;

    /* renamed from: D */
    private String f14069D;

    /* renamed from: E */
    private String f14070E;

    /* renamed from: a */
    private List<DiagReportOrHistoryInfo> f14077a;

    /* renamed from: c */
    private List<ReportFileInfo> f14079c;

    /* renamed from: d */
    private List<ReportFileInfo> f14080d;

    /* renamed from: e */
    private List<DiagReportOrHistoryInfo> f14081e;

    /* renamed from: h */
    private IconRadioButton f14084h;

    /* renamed from: i */
    private IconButton f14085i;

    /* renamed from: j */
    private IconButton f14086j;

    /* renamed from: k */
    private IconButton f14087k;

    /* renamed from: l */
    private IconButton f14088l;

    /* renamed from: o */
    private Collection<File> f14091o;

    /* renamed from: s */
    private RemoteReportAdapter f14095s;

    /* renamed from: t */
    private NewLocalReportAdapter f14096t;

    /* renamed from: u */
    private MyReportAdapter f14097u;

    /* renamed from: v */
    private PullToRefreshListView f14098v;

    /* renamed from: w */
    private PullToRefreshListView f14099w;

    /* renamed from: x */
    private PullToRefreshListView f14100x;

    /* renamed from: y */
    private PagerSlidingTabStrip f14101y;

    /* renamed from: z */
    private View f14102z;

    /* renamed from: b */
    private ArrayList<DownLoadReportInfo> f14078b = null;

    /* renamed from: f */
    private int f14082f = 0;

    /* renamed from: g */
    private int f14083g = 1;

    /* renamed from: m */
    private int f14089m = 0;

    /* renamed from: n */
    private int f14090n = 9999;

    /* renamed from: p */
    private ViewPager f14092p = null;

    /* renamed from: q */
    private C2462a f14093q = null;

    /* renamed from: r */
    private ArrayList<View> f14094r = new ArrayList<>();

    /* renamed from: A */
    private boolean f14066A = true;

    /* renamed from: B */
    private String[] f14067B = null;

    /* renamed from: F */
    private int f14071F = -1;

    /* renamed from: G */
    private String f14072G = "";

    /* renamed from: H */
    private String f14073H = "";

    /* renamed from: I */
    private String f14074I = "";

    /* renamed from: J */
    private String f14075J = "";

    /* renamed from: K */
    private Handler f14076K = new HandlerC2464co(this);

    @Override // android.support.p012v4.view.ViewPager.InterfaceC0176e
    /* renamed from: a */
    public final void mo1773a(int i, float f, int i2) {
    }

    @Override // android.support.p012v4.view.ViewPager.InterfaceC0176e
    /* renamed from: a_ */
    public final void mo1772a_(int i) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: r */
    public static /* synthetic */ int m6201r(ReportPagersFragment reportPagersFragment) {
        int i = reportPagersFragment.f14083g;
        reportPagersFragment.f14083g = i + 1;
        return i;
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (getBundle() == null) {
            setBundle(new Bundle());
        }
        this.f14077a = C2752f.m5072a(this.mContext, this.f14071F, this.f14072G, this.f14073H, this.f14074I, this.f14075J);
        this.f14079c = m6225a(PathUtils.m4855d(), 2);
        this.f14070E = PathUtils.m4855d() + "/";
        setTitle(R.string.mine_myreport_title);
        setLeftImage(this.mContext.getResources().getDrawable(R.drawable.select_btn_menu_two));
        this.f14102z = getActivity().findViewById(R.id.linear_button);
        this.f14087k = (IconButton) getActivity().findViewById(R.id.btn_more);
        this.f14084h = (IconRadioButton) getActivity().findViewById(R.id.btn_selectall);
        this.f14085i = (IconButton) getActivity().findViewById(R.id.iv_share_report);
        this.f14088l = (IconButton) getActivity().findViewById(R.id.btn_rename);
        this.f14086j = (IconButton) getActivity().findViewById(R.id.btn_delete);
        this.f14087k.setOnClickListener(new View$OnClickListenerC2468cs(this));
        this.f14084h.setOnClickListener(this);
        this.f14084h.setChecked(false);
        this.f14084h.setOnClickListener(new View$OnClickListenerC2469ct(this));
        this.f14085i.setOnClickListener(this);
        this.f14086j.setOnClickListener(this);
        this.f14088l.setOnClickListener(this);
        if (LoginTools.m7946a(this.mContext) && this.f14078b == null) {
            this.f14095s = new RemoteReportAdapter(this.mContext, this.f14078b);
        }
        this.f14076K.obtainMessage(1, 0).sendToTarget();
        this.f14092p = (ViewPager) getActivity().findViewById(R.id.pager);
        LayoutInflater layoutInflater = getActivity().getLayoutInflater();
        this.f14094r = new ArrayList<>();
        this.f14094r.add(layoutInflater.inflate(R.layout.item_golo_viewpage, (ViewGroup) null));
        this.f14094r.add(layoutInflater.inflate(R.layout.item_golo_viewpage, (ViewGroup) null));
        this.f14094r.add(layoutInflater.inflate(R.layout.item_golo_viewpage, (ViewGroup) null));
        this.f14096t = new NewLocalReportAdapter(getActivity(), this.f14077a, this.f14076K);
        this.f14098v = (PullToRefreshListView) this.f14094r.get(0);
        this.f14098v.setAdapter(this.f14096t);
        this.f14098v.setOnItemClickListener(new C2463cn(this));
        this.f14098v.setMode(PullToRefreshBase.EnumC2933b.DISABLED);
        this.f14095s = new RemoteReportAdapter(this.mContext, this.f14078b);
        this.f14100x = (PullToRefreshListView) this.f14094r.get(1);
        this.f14100x.setAdapter(this.f14095s);
        this.f14100x.setOnItemClickListener(new C2465cp(this));
        this.f14100x.setOnRefreshListener(new C2466cq(this));
        this.f14100x.setMode(PullToRefreshBase.EnumC2933b.PULL_FROM_START);
        this.f14097u = new MyReportAdapter(getActivity(), this.f14079c, this.f14076K);
        this.f14099w = (PullToRefreshListView) this.f14094r.get(2);
        this.f14099w.setAdapter(this.f14097u);
        this.f14099w.setOnItemClickListener(new C2467cr(this));
        this.f14099w.setMode(PullToRefreshBase.EnumC2933b.DISABLED);
        this.f14093q = new C2462a(this.f14094r, getString(R.string.mine_tv_diagnosis_report), getString(R.string.mine_tv_remote_diagnosis), getString(R.string.mine_tv_diagnosis_playback));
        this.f14092p.setAdapter(this.f14093q);
        this.f14101y = (PagerSlidingTabStrip) getActivity().findViewById(R.id.tabs);
        this.f14101y.setShouldExpand(true);
        this.f14101y.setViewPager(this.f14092p);
        this.f14101y.setOnPageChangeListener(this);
        this.f14101y.setTextColorResource(ApplicationTheme.m7972d(getActivity()));
        this.f14101y.setIndicatorColorResource(ApplicationTheme.m7972d(getActivity()));
        this.f14101y.setTextSize(getResources().getInteger(R.integer.report_tip_title_textsize));
        if (LoginTools.m7946a(this.mContext) && C2778n.m4917a(this.mContext) && this.f14066A) {
            this.f14066A = false;
            request(30001);
        }
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        ViewPager viewPager = this.f14092p;
        if (viewPager != null) {
            viewPager.requestFocus();
        }
        List<DiagReportOrHistoryInfo> m5072a = C2752f.m5072a(this.mContext, this.f14071F, this.f14072G, this.f14073H, this.f14074I, this.f14075J);
        if (m5072a.size() != this.f14077a.size()) {
            this.f14077a = m5072a;
            this.f14096t = new NewLocalReportAdapter(getActivity(), this.f14077a, this.f14076K);
            this.f14098v = (PullToRefreshListView) this.f14094r.get(0);
            this.f14098v.setAdapter(this.f14096t);
            this.f14096t.notifyDataSetChanged();
            int i = this.f14082f;
            if (i == 0) {
                this.f14076K.obtainMessage(1, Integer.valueOf(i)).sendToTarget();
            }
        }
        m6225a(PathUtils.m4855d(), 0);
        if (m6225a(PathUtils.m4855d(), 2).size() != this.f14079c.size()) {
            this.f14079c = m6225a(PathUtils.m4855d(), 2);
            this.f14097u = new MyReportAdapter(getActivity(), this.f14079c, this.f14076K);
            this.f14099w = (PullToRefreshListView) this.f14094r.get(2);
            this.f14099w.setAdapter(this.f14097u);
            this.f14097u.notifyDataSetChanged();
            int i2 = this.f14082f;
            if (2 == i2) {
                this.f14076K.obtainMessage(1, Integer.valueOf(i2)).sendToTarget();
            }
        }
        if (m6229a() == 0) {
            ((MineActivity) getActivity()).m7732g().setTouchModeAbove(1);
        } else {
            ((MineActivity) getActivity()).m7732g().setTouchModeAbove(2);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.mine_fragment_report, viewGroup, false);
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
        ((MineActivity) getActivity()).m7732g().setTouchModeAbove(1);
    }

    /* renamed from: a */
    public static ArrayList<ReportFileInfo> m6225a(String str, int i) {
        ArrayList<ReportFileInfo> arrayList = new ArrayList<>();
        File[] listFiles = new File(str).listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                String name = file.getName();
                String substring = name.substring(name.length() - 4, name.length());
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(file.lastModified());
                if (i == 0) {
                    if (substring.equalsIgnoreCase(".txt") || substring.equalsIgnoreCase(".jpg") || substring.equalsIgnoreCase(".pdf")) {
                        ReportFileInfo reportFileInfo = new ReportFileInfo();
                        reportFileInfo.setReportName(file.getName());
                        reportFileInfo.setReportTime(calendar.getTime());
                        arrayList.add(reportFileInfo);
                    }
                } else if (i == 2 && substring.equalsIgnoreCase("x431")) {
                    ReportFileInfo reportFileInfo2 = new ReportFileInfo();
                    reportFileInfo2.setReportName(file.getName());
                    reportFileInfo2.setReportTime(calendar.getTime());
                    arrayList.add(reportFileInfo2);
                }
            }
            Collections.sort(arrayList, new C2470cu());
        }
        return arrayList;
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public Object doInBackground(int i) throws C1425f {
        if (i != 100) {
            if (i == 30001) {
                String m9591a = PreferencesManager.m9595a(this.mContext).m9591a("user_id");
                if (TextUtils.isEmpty(m9591a)) {
                    return null;
                }
                return new ReportAction(this.mContext).m5220b(m9591a, this.f14083g);
            }
            return super.doInBackground(i);
        }
        try {
            Collection<File> collection = this.f14091o;
            ZipFileUtils.m4981a(collection, new File(PathUtils.m4855d() + "/SHARE_REPORT.zip"));
            return Boolean.TRUE;
        } catch (IOException e) {
            e.printStackTrace();
            return Boolean.FALSE;
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onSuccess(int i, Object obj) {
        if (i == 100) {
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString("FilePath", PathUtils.m4855d() + "/SHARE_REPORT.zip");
            intent.putExtras(bundle);
            intent.setClass(getActivity(), ShareActivity.class);
            getActivity().startActivity(intent);
            LoadDialog.m4681b(this.mContext);
        } else if (i == 30001) {
            this.f14100x.m4428i();
            if (obj != null) {
                DownLoadReportResponse downLoadReportResponse = (DownLoadReportResponse) obj;
                ArrayList<DownLoadReportInfo> arrayList = this.f14078b;
                int size = arrayList != null ? arrayList.size() : 0;
                ArrayList<DownLoadReportInfo> arrayList2 = new ArrayList<>();
                Iterator it = ((ArrayList) downLoadReportResponse.getData()).iterator();
                while (it.hasNext()) {
                    DownLoadReportInfo downLoadReportInfo = (DownLoadReportInfo) it.next();
                    if (downLoadReportInfo.getType() == 1) {
                        arrayList2.add(downLoadReportInfo);
                    }
                }
                this.f14078b = arrayList2;
                ArrayList<DownLoadReportInfo> arrayList3 = this.f14078b;
                if (size == (arrayList3 != null ? arrayList3.size() : 0) && size != 0) {
                    NToast.m9450a(getActivity(), (int) R.string.no_more_report);
                }
                RemoteReportAdapter remoteReportAdapter = this.f14095s;
                remoteReportAdapter.f13590a = this.f14078b;
                remoteReportAdapter.notifyDataSetChanged();
            }
        } else {
            super.onSuccess(i, obj);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onFailure(int i, int i2, Object obj) {
        if (i == 30001) {
            this.f14100x.m4428i();
        }
        super.onFailure(i, i2, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public List<ReportFileInfo> m6224a(List<ReportFileInfo> list) {
        int m6514a;
        String m6510b;
        ArrayList arrayList = new ArrayList();
        if (this.f14092p.getCurrentItem() == 0) {
            m6514a = this.f14096t.m6507a();
        } else {
            m6514a = this.f14097u.m6514a();
        }
        if (m6514a != 0) {
            if (this.f14092p.getCurrentItem() == 0) {
                m6510b = this.f14096t.m6503b();
            } else {
                m6510b = this.f14097u.m6510b();
            }
            ReportFileInfo reportFileInfo = null;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) != null) {
                    if (!Character.valueOf(m6510b.charAt(i)).toString().equals("1")) {
                        reportFileInfo = null;
                    } else if (list.get(i) != null) {
                        new ReportFileInfo();
                        reportFileInfo = list.get(i);
                    }
                }
                if (reportFileInfo != null) {
                    arrayList.add(reportFileInfo);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public List<DiagReportOrHistoryInfo> m6221b(List<DiagReportOrHistoryInfo> list) {
        int m6514a;
        ArrayList arrayList = new ArrayList();
        if (this.f14092p.getCurrentItem() == 0) {
            m6514a = this.f14096t.m6507a();
        } else {
            m6514a = this.f14097u.m6514a();
        }
        if (m6514a != 0) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) != null && list.get(i).isCheck()) {
                    arrayList.add(list.get(i));
                }
            }
        }
        return arrayList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int m6514a;
        if (m6229a() == 0) {
            m6514a = this.f14096t.m6507a();
        } else {
            m6514a = this.f14097u.m6514a();
        }
        int id = view.getId();
        if (id == R.id.btn_delete) {
            if (m6514a == 0) {
                NToast.m9447b(getActivity(), (int) R.string.toast_need_one_report);
                return;
            } else {
                new C2471cv(this).m4610a(getActivity(), R.string.dialog_title_default, R.string.mine_dialog_content_delreport, true);
                return;
            }
        }
        int i = 0;
        if (id == R.id.btn_rename) {
            if (m6514a == 0 || m6514a < 0) {
                NToast.m9447b(getActivity(), (int) R.string.toast_need_one_report);
            } else if (m6514a > 1) {
                NToast.m9447b(getActivity(), (int) R.string.toast_need_only_one_report);
            } else {
                if (m6229a() == 0) {
                    this.f14081e = m6221b(this.f14077a);
                    this.f14068C = this.f14081e.get(0).getPdfFileName();
                    i = this.f14068C.lastIndexOf("/") + 1;
                } else if (m6229a() == 2) {
                    this.f14080d = m6224a(this.f14079c);
                    this.f14068C = this.f14080d.get(0).getReportName();
                }
                int lastIndexOf = this.f14068C.lastIndexOf(".");
                String str = this.f14068C;
                this.f14069D = str.substring(lastIndexOf, str.length());
                this.f14068C = this.f14068C.substring(i, lastIndexOf);
                DialogC2472cw dialogC2472cw = new DialogC2472cw(this, this.mContext, getString(R.string.input_ds_record_file_name), this.f14068C);
                dialogC2472cw.m4713f(2);
                getString(R.string.input_ds_record_file_name);
                dialogC2472cw.m4703c();
            }
        } else if (id == R.id.iv_share_report) {
            if (m6514a == 0) {
                NToast.m9447b(getActivity(), (int) R.string.toast_need_one_report);
            } else if (m6514a == 1 && m6229a() == 0) {
                this.f14081e = m6221b(this.f14077a);
                String str2 = "";
                for (int i2 = 0; i2 < this.f14081e.size(); i2++) {
                    if (this.f14081e.get(i2).getPdfFileName() != null) {
                        str2 = this.f14081e.get(i2).getPdfFileName();
                    }
                }
                NLog.m9452b("sarah", "mReportPath:".concat(String.valueOf(str2)));
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("FilePath", str2);
                intent.putExtras(bundle);
                intent.setClass(getActivity(), ShareActivity.class);
                getActivity().startActivity(intent);
            } else {
                LoadDialog.m4686a(this.mContext);
                this.f14091o = new ArrayList();
                if (m6229a() == 0) {
                    this.f14081e = m6221b(this.f14077a);
                    for (int i3 = 0; i3 < this.f14081e.size(); i3++) {
                        if (this.f14081e.get(i3).getPdfFileName() != null) {
                            File file = new File(this.f14081e.get(i3).getPdfFileName());
                            if (file.exists()) {
                                this.f14091o.add(file);
                            }
                        }
                    }
                } else if (m6229a() == 2) {
                    this.f14080d = m6224a(this.f14079c);
                    for (int i4 = 0; i4 < this.f14080d.size(); i4++) {
                        if (this.f14080d.get(i4).getReportName() != null) {
                            this.f14091o.add(new File(PathUtils.m4855d() + "/" + this.f14080d.get(i4).getReportName()));
                        }
                    }
                }
                request(100, false);
            }
        }
    }

    /* compiled from: ReportPagersFragment.java */
    /* renamed from: com.cnlaunch.x431pro.activity.mine.cm$a */
    /* loaded from: classes.dex */
    public class C2462a extends ViewPagerAdapter {

        /* renamed from: c */
        private String[] f14104c;

        /* renamed from: d */
        private int f14105d;

        public C2462a(ArrayList<View> arrayList, String... strArr) {
            super(arrayList);
            this.f14104c = new String[0];
            this.f14105d = 0;
            this.f14104c = strArr;
        }

        @Override // android.support.p012v4.view.PagerAdapter
        /* renamed from: a */
        public final CharSequence mo5638a(int i) {
            String[] strArr = this.f14104c;
            return i > strArr.length ? "NULL TITLE" : strArr[i];
        }

        @Override // android.support.p012v4.view.PagerAdapter
        /* renamed from: b */
        public final void mo6192b() {
            this.f14105d = mo1771a();
            super.mo6192b();
        }

        @Override // com.cnlaunch.x431pro.activity.diagnose.p218a.ViewPagerAdapter, android.support.p012v4.view.PagerAdapter
        /* renamed from: a */
        public final int mo4480a(Object obj) {
            int i = this.f14105d;
            if (i > 0) {
                this.f14105d = i - 1;
                return -2;
            }
            return super.mo4480a(obj);
        }
    }

    @Override // android.support.p012v4.view.ViewPager.InterfaceC0176e
    /* renamed from: a */
    public final void mo1774a(int i) {
        try {
            this.f14092p.getChildAt(i).requestFocus();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (i == 0) {
            ((MineActivity) getActivity()).m7732g().setTouchModeAbove(1);
        } else {
            ((MineActivity) getActivity()).m7732g().setTouchModeAbove(2);
        }
        this.f14076K.obtainMessage(1, Integer.valueOf(i)).sendToTarget();
        this.f14082f = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public int m6229a() {
        ViewPager viewPager = this.f14092p;
        if (viewPager != null) {
            return viewPager.getCurrentItem();
        }
        return 0;
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }
}
