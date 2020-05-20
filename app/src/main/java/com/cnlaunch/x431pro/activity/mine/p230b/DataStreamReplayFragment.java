package com.cnlaunch.x431pro.activity.mine.p230b;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.mapapi.UIMsg;
import com.cnlaunch.diagnosemodule.bean.BasicDataStreamBean;
import com.cnlaunch.mycar.jni.JniX431FileTest;
import com.cnlaunch.x431pro.activity.BaseFragment;
import com.cnlaunch.x431pro.activity.diagnose.p220c.BottomActionBar;
import com.cnlaunch.x431pro.activity.diagnose.p220c.ICallKeyDownFragment;
import com.cnlaunch.x431pro.activity.diagnose.p220c.IDataStreamSelectionRecorder;
import com.cnlaunch.x431pro.activity.diagnose.p220c.IDataStreamSelector;
import com.cnlaunch.x431pro.activity.diagnose.p220c.ReplayDataStreamManager;
import com.cnlaunch.x431pro.activity.diagnose.p220c.X431ReplayDataStreamManager;
import com.cnlaunch.x431pro.activity.diagnose.p222e.TabListener;
import com.cnlaunch.x431pro.p210a.FragmentKeyDownListener;
import com.cnlaunch.x431pro.widget.button.IconButton;
import com.cnlaunch.x431pro.widget.button.IconRadioButton;
import com.cnlaunch.x431pro.widget.progress.Slider;
import com.ifoer.expedition.pro.R;
import com.itextpdf.text.pdf.codec.TIFFConstants;
import com.mopub.nativeads.MoPubNativeAdPositioning;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import org.apache.mina.proxy.handlers.http.ntlm.NTLMConstants;

@SuppressLint({"HandlerLeak"})
/* renamed from: com.cnlaunch.x431pro.activity.mine.b.b */
/* loaded from: classes.dex */
public class DataStreamReplayFragment extends BaseFragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, FragmentKeyDownListener.InterfaceC1949a, ICallKeyDownFragment, IDataStreamSelectionRecorder {

    /* renamed from: A */
    private long f13729A;

    /* renamed from: B */
    private int f13730B;

    /* renamed from: C */
    private int f13731C;

    /* renamed from: I */
    private int f13737I;

    /* renamed from: J */
    private int f13738J;

    /* renamed from: K */
    private int f13739K;

    /* renamed from: L */
    private int f13740L;

    /* renamed from: M */
    private boolean f13741M;

    /* renamed from: N */
    private int f13742N;

    /* renamed from: O */
    private int f13743O;

    /* renamed from: P */
    private int f13744P;

    /* renamed from: Q */
    private int f13745Q;

    /* renamed from: R */
    private ArrayList<BasicDataStreamBean> f13746R;

    /* renamed from: S */
    private ArrayList<BasicDataStreamBean> f13747S;

    /* renamed from: T */
    private FragmentKeyDownListener f13748T;

    /* renamed from: U */
    private boolean f13749U;

    /* renamed from: V */
    private int f13750V;

    /* renamed from: W */
    private IconRadioButton f13751W;

    /* renamed from: X */
    private IconRadioButton f13752X;

    /* renamed from: Y */
    private IconRadioButton f13753Y;

    /* renamed from: Z */
    private Handler f13754Z;

    /* renamed from: a */
    ICallKeyDownFragment f13755a;

    /* renamed from: b */
    private IconRadioButton f13756b;

    /* renamed from: c */
    private IconButton f13757c;

    /* renamed from: d */
    private IconButton f13758d;

    /* renamed from: e */
    private Button f13759e;

    /* renamed from: f */
    private Button f13760f;

    /* renamed from: g */
    private Button f13761g;

    /* renamed from: h */
    private Button f13762h;

    /* renamed from: i */
    private TextView f13763i;

    /* renamed from: j */
    private TextView f13764j;

    /* renamed from: k */
    private Slider f13765k;

    /* renamed from: l */
    private String f13766l;

    /* renamed from: m */
    private int f13767m;

    /* renamed from: p */
    private ReplayDataStreamManager f13770p;

    /* renamed from: q */
    private IDataStreamSelector f13771q;

    /* renamed from: t */
    private Timer f13774t;

    /* renamed from: u */
    private RelativeLayout f13775u;

    /* renamed from: x */
    private JniX431FileTest f13778x;

    /* renamed from: y */
    private long f13779y;

    /* renamed from: z */
    private long f13780z;

    /* renamed from: n */
    private ArrayList<BasicDataStreamBean> f13768n = new ArrayList<>();

    /* renamed from: o */
    private String f13769o = "";

    /* renamed from: r */
    private Bundle f13772r = new Bundle();

    /* renamed from: s */
    private ArrayList<ArrayList<BasicDataStreamBean>> f13773s = null;

    /* renamed from: v */
    private ArrayList<ArrayList<BasicDataStreamBean>> f13776v = new ArrayList<>();

    /* renamed from: w */
    private String f13777w = "";

    /* renamed from: D */
    private boolean f13732D = false;

    /* renamed from: E */
    private boolean f13733E = true;

    /* renamed from: F */
    private boolean f13734F = true;

    /* renamed from: G */
    private int f13735G = 0;

    /* renamed from: H */
    private int[] f13736H = {1000, UIMsg.d_ResultType.SHORT_URL, TIFFConstants.TIFFTAG_INKNAMES, 125};

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.ICallKeyDownFragment
    /* renamed from: a */
    public final void mo6305a() {
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.ICallKeyDownFragment
    /* renamed from: a */
    public final boolean mo6304a(int i, KeyEvent keyEvent) {
        return false;
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.IDataStreamSelectionRecorder
    /* renamed from: b */
    public final void mo6396b(int i) {
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.ICallKeyDownFragment
    /* renamed from: d */
    public final void mo6298d() {
    }

    public DataStreamReplayFragment() {
        int[] iArr = this.f13736H;
        this.f13737I = iArr[0];
        this.f13738J = 1;
        this.f13739K = iArr.length;
        this.f13740L = 0;
        this.f13741M = false;
        this.f13742N = NTLMConstants.FLAG_NEGOTIATE_56_BIT_ENCRYPTION;
        this.f13743O = MoPubNativeAdPositioning.MoPubClientPositioning.NO_REPEAT;
        this.f13744P = 0;
        this.f13745Q = 0;
        this.f13746R = null;
        this.f13747S = null;
        this.f13748T = null;
        this.f13750V = 0;
        this.f13754Z = new HandlerC2423j(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: l */
    public static /* synthetic */ int m6382l(DataStreamReplayFragment dataStreamReplayFragment) {
        int i = dataStreamReplayFragment.f13735G;
        dataStreamReplayFragment.f13735G = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: z */
    public static /* synthetic */ boolean m6368z(DataStreamReplayFragment dataStreamReplayFragment) {
        dataStreamReplayFragment.f13732D = false;
        return false;
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        ArrayList<BasicDataStreamBean> arrayList;
        super.onAttach(activity);
        try {
            this.f13748T = (FragmentKeyDownListener) activity;
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        Bundle bundle = getBundle();
        if (bundle != null) {
            if (bundle.containsKey("EnginePowerBalance")) {
                this.f13740L = 1;
                this.f13777w = bundle.getString("ReportPath");
                this.f13741M = bundle.getBoolean("Limit");
                this.f13742N = bundle.getInt("FirstMin");
                this.f13743O = bundle.getInt("FirstMax");
                this.f13744P = bundle.getInt("FirstCount");
                this.f13745Q = bundle.getInt("SecondCount");
                this.f13773s = (ArrayList) bundle.getSerializable("FirstDataList");
            } else {
                this.f13777w = bundle.getString("ReportPath");
                this.f13767m = bundle.getInt("DataStreamCount");
                this.f13766l = bundle.getString("DataStreamShow_Type");
                this.f13773s = (ArrayList) bundle.get("DataStreamAll");
                this.f13749U = bundle.getBoolean("isVoltage", false);
            }
        }
        ArrayList<ArrayList<BasicDataStreamBean>> arrayList2 = this.f13773s;
        if (arrayList2 != null && arrayList2.size() > 0) {
            this.f13768n.addAll(this.f13773s.get(0));
        }
        ArrayList<ArrayList> arrayList3 = new ArrayList();
        if (1 == this.f13740L) {
            if (this.f13770p == null) {
                this.f13770p = new X431ReplayDataStreamManager(arrayList3);
            }
            ArrayList<BasicDataStreamBean> arrayList4 = this.f13768n;
            if (arrayList4 != null) {
                this.f13770p.f11780a = true;
                m6398a(arrayList4);
                ArrayList<BasicDataStreamBean> arrayList5 = this.f13746R;
                if (arrayList5 == null || arrayList5.size() != this.f13744P || (arrayList = this.f13747S) == null || arrayList.size() != this.f13745Q) {
                    return;
                }
                this.f13770p.m7353a(this.f13746R, this.f13747S);
                return;
            }
            return;
        }
        for (ArrayList arrayList6 : arrayList3) {
            Iterator it = arrayList6.iterator();
            while (it.hasNext()) {
                ((BasicDataStreamBean) it.next()).doConversion();
            }
        }
        if (this.f13768n != null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < this.f13768n.size(); i++) {
                arrayList3.add(new ArrayList());
                sb.append("1");
            }
            this.f13769o = sb.toString();
        }
        this.f13770p = new X431ReplayDataStreamManager(arrayList3);
        ArrayList<BasicDataStreamBean> arrayList7 = this.f13768n;
        if (arrayList7 != null) {
            this.f13770p.m7355a(arrayList7);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onDestroy() {
        Timer timer = this.f13774t;
        if (timer != null) {
            timer.cancel();
        }
        super.onDestroy();
        this.f13770p.m7349c();
        ArrayList<ArrayList<BasicDataStreamBean>> arrayList = this.f13773s;
        if (arrayList != null) {
            arrayList.clear();
        }
        ArrayList<BasicDataStreamBean> arrayList2 = this.f13768n;
        if (arrayList2 != null) {
            arrayList2.clear();
        }
        ArrayList<BasicDataStreamBean> arrayList3 = this.f13746R;
        if (arrayList3 != null) {
            arrayList3.clear();
        }
        if (this.f13746R != null) {
            this.f13747S.clear();
        }
        this.f13773s = null;
        this.f13768n = null;
        this.f13746R = null;
        this.f13747S = null;
        FragmentKeyDownListener fragmentKeyDownListener = this.f13748T;
        if (fragmentKeyDownListener != null) {
            fragmentKeyDownListener.mo6039a(null);
        }
        System.gc();
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        FragmentKeyDownListener fragmentKeyDownListener = this.f13748T;
        if (fragmentKeyDownListener != null) {
            fragmentKeyDownListener.mo6039a(this);
        }
        this.f13778x = new JniX431FileTest();
        this.f13779y = this.f13778x.init();
        this.f13780z = this.f13778x.openFile(this.f13777w, this.f13779y);
        this.f13729A = this.f13778x.readGroupId(this.f13780z);
        this.f13730B = this.f13778x.readGroupItemCount(this.f13729A);
        this.f13731C = this.f13778x.readGroupItemColCount(this.f13729A);
        this.f13778x.readEndCloseFile(this.f13780z, this.f13779y);
        this.f13756b = (IconRadioButton) getActivity().findViewById(R.id.btn_selectall);
        this.f13757c = (IconButton) getActivity().findViewById(R.id.btn_replay_frame);
        this.f13758d = (IconButton) getActivity().findViewById(R.id.btn_replay_normal);
        this.f13759e = (Button) getActivity().findViewById(R.id.btn_replay_stop);
        this.f13760f = (Button) getActivity().findViewById(R.id.btn_replay_play);
        this.f13761g = (Button) getActivity().findViewById(R.id.btn_fast_forward);
        this.f13762h = (Button) getActivity().findViewById(R.id.btn_fast_back);
        this.f13775u = (RelativeLayout) getActivity().findViewById(R.id.v_record);
        this.f13763i = (TextView) getActivity().findViewById(R.id.tv_time);
        this.f13764j = (TextView) getActivity().findViewById(R.id.tv_speed);
        this.f13765k = (Slider) getActivity().findViewById(R.id.pd_indeter);
        this.f13765k.setMax(this.f13730B - 1);
        this.f13765k.setOnValueChangedListener(new C2416c(this));
        this.f13765k.setOnTouchListener(new View$OnTouchListenerC2417d(this));
        this.f13757c.setOnClickListener(this);
        this.f13758d.setOnClickListener(this);
        this.f13759e.setOnClickListener(this);
        this.f13760f.setOnClickListener(this);
        this.f13761g.setOnClickListener(this);
        this.f13762h.setOnClickListener(this);
        this.f13756b.setOnCheckedChangeListener(this);
        this.f13754Z.obtainMessage(1, Integer.valueOf(this.f13735G)).sendToTarget();
        this.f13764j.setText(String.format(getString(R.string.replay_status_normal_play), Integer.valueOf(this.f13738J)));
        this.f13751W = (IconRadioButton) getActivity().findViewById(R.id.btn_graph);
        this.f13752X = (IconRadioButton) getActivity().findViewById(R.id.btn_combination);
        this.f13753Y = (IconRadioButton) getActivity().findViewById(R.id.btn_value);
        BottomActionBar bottomActionBar = new BottomActionBar(getActivity());
        C2418e c2418e = new C2418e(this, this.f13751W);
        if (this.f13749U) {
            c2418e.f11710b = new TabListener(getActivity(), ReplayVoltageFragment.class, this.f13772r, new RunnableC2415a(), this);
            this.f13752X.setEnabled(false);
            this.f13753Y.setEnabled(false);
        } else {
            c2418e.f11710b = new TabListener(getActivity(), ReplayGridFragment.class, this.f13772r, new RunnableC2415a(), this);
        }
        C2419f c2419f = new C2419f(this, this.f13752X);
        c2419f.f11710b = new TabListener(getActivity(), ReplayCombinedFragment.class, this.f13772r, new RunnableC2415a(), this);
        C2420g c2420g = new C2420g(this, this.f13753Y);
        c2420g.f11710b = new TabListener(getActivity(), ReplayListFragment.class, this.f13772r, new RunnableC2415a(), this);
        View findViewById = getActivity().findViewById(R.id.btn_powerBalance);
        if (1 == this.f13740L) {
            this.f13751W.setEnabled(false);
            this.f13752X.setEnabled(false);
            this.f13753Y.setEnabled(false);
            this.f13757c.setEnabled(false);
            this.f13757c.setVisibility(8);
            this.f13765k.setEnabled(false);
        }
        C2421h c2421h = new C2421h(this, findViewById);
        TabListener tabListener = new TabListener(getActivity(), ReplayPowerBalanceFragment.class, this.f13772r, new RunnableC2415a(), this);
        tabListener.f12429a = this;
        c2421h.f11710b = tabListener;
        bottomActionBar.m7421a(c2418e);
        bottomActionBar.m7421a(c2419f);
        bottomActionBar.m7421a(c2420g);
        if (1 == this.f13740L) {
            bottomActionBar.m7421a(c2421h);
            findViewById.performClick();
        } else if (this.f13749U) {
            this.f13751W.performClick();
        } else {
            this.f13753Y.performClick();
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_datastream_replay, viewGroup, false);
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_replay_frame) {
            this.f13734F = false;
            this.f13732D = false;
            m6392c();
            this.f13775u.setVisibility(0);
            this.f13758d.setVisibility(0);
            this.f13757c.setVisibility(8);
            this.f13760f.setVisibility(4);
            this.f13759e.setVisibility(8);
            this.f13761g.setBackgroundResource(R.drawable.btn_replay_next_frame);
            this.f13762h.setBackgroundResource(R.drawable.btn_replay_pre_frame);
            this.f13760f.setBackgroundResource(R.drawable.btn_replay_play);
            this.f13764j.setText(R.string.replay_status_frame_play);
            int i = this.f13735G;
            if (i == 0) {
                this.f13762h.setEnabled(false);
            } else if (i == this.f13730B - 1) {
                this.f13761g.setEnabled(false);
            }
        } else if (id == R.id.btn_replay_normal) {
            this.f13734F = true;
            m6392c();
            this.f13775u.setVisibility(0);
            this.f13758d.setVisibility(8);
            this.f13757c.setVisibility(0);
            this.f13760f.setVisibility(0);
            this.f13759e.setVisibility(0);
            this.f13761g.setBackgroundResource(R.drawable.btn_replay_fast_forward);
            this.f13762h.setBackgroundResource(R.drawable.btn_replay_fast_back);
            this.f13764j.setText(String.format(getString(R.string.replay_status_normal_play), Integer.valueOf(this.f13738J)));
            this.f13762h.setEnabled(true);
            this.f13761g.setEnabled(true);
        } else if (id == R.id.btn_fast_forward) {
            if (this.f13734F) {
                if (this.f13738J < this.f13739K) {
                    m6392c();
                    this.f13738J++;
                    this.f13737I = this.f13736H[this.f13738J - 1];
                    this.f13764j.setText(String.format(getString(R.string.replay_status_normal_play), Integer.valueOf(this.f13738J)));
                    if (this.f13732D) {
                        m6397b();
                        return;
                    }
                    return;
                }
                return;
            }
            if (this.f13735G > 0) {
                this.f13762h.setEnabled(true);
            }
            int i2 = this.f13735G;
            int i3 = this.f13730B;
            if (i2 >= i3 - 1) {
                if (i2 == i3 - 1) {
                    this.f13761g.setEnabled(false);
                    this.f13754Z.obtainMessage(1, Integer.valueOf(this.f13735G)).sendToTarget();
                    return;
                }
                return;
            }
            this.f13735G = i2 + 1;
            int i4 = this.f13735G;
            if (i4 > 0) {
                this.f13770p.m7354a(this.f13773s.subList(0, i4), this.f13735G);
            }
            this.f13754Z.obtainMessage(1, Integer.valueOf(this.f13735G)).sendToTarget();
        } else if (id != R.id.btn_fast_back) {
            if (id == R.id.btn_replay_play) {
                if (!this.f13732D) {
                    this.f13732D = true;
                    m6397b();
                    this.f13760f.setBackgroundResource(R.drawable.btn_replay_pause);
                    return;
                }
                this.f13732D = false;
                m6392c();
                this.f13760f.setBackgroundResource(R.drawable.btn_replay_play);
            } else if (id == R.id.btn_replay_stop) {
                this.f13732D = false;
                m6392c();
                this.f13735G = 0;
                if (1 == this.f13740L) {
                    this.f13754Z.obtainMessage(2).sendToTarget();
                }
                this.f13754Z.obtainMessage(1, Integer.valueOf(this.f13735G)).sendToTarget();
                this.f13760f.setBackgroundResource(R.drawable.btn_replay_play);
            }
        } else if (this.f13734F) {
            if (this.f13738J > 1) {
                m6392c();
                this.f13738J--;
                this.f13737I = this.f13736H[this.f13738J];
                this.f13764j.setText(String.format(getString(R.string.replay_status_normal_play), Integer.valueOf(this.f13738J)));
                if (this.f13732D) {
                    m6397b();
                }
            }
        } else {
            if (this.f13735G < this.f13730B - 1) {
                this.f13761g.setEnabled(true);
            }
            int i5 = this.f13735G;
            if (i5 > 0) {
                this.f13735G = i5 - 1;
                int i6 = this.f13735G;
                if (i6 > 0) {
                    this.f13770p.m7354a(this.f13773s.subList(0, i6), this.f13735G);
                }
                this.f13754Z.obtainMessage(1, Integer.valueOf(this.f13735G)).sendToTarget();
                return;
            }
            this.f13762h.setEnabled(false);
            this.f13754Z.obtainMessage(1, Integer.valueOf(this.f13735G)).sendToTarget();
        }
    }

    /* renamed from: b */
    private void m6397b() {
        if (this.f13774t == null) {
            this.f13774t = new Timer(true);
            this.f13774t.schedule(new C2422i(this), 0L, this.f13737I);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m6392c() {
        Timer timer = this.f13774t;
        if (timer != null) {
            timer.cancel();
            this.f13774t = null;
        }
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.IDataStreamSelectionRecorder
    /* renamed from: a */
    public final void mo6404a(IDataStreamSelector iDataStreamSelector) {
        this.f13771q = iDataStreamSelector;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        IDataStreamSelector iDataStreamSelector = this.f13771q;
        if (iDataStreamSelector != null) {
            iDataStreamSelector.mo6308a(z);
        }
    }

    /* compiled from: DataStreamReplayFragment.java */
    /* renamed from: com.cnlaunch.x431pro.activity.mine.b.b$a */
    /* loaded from: classes.dex */
    class RunnableC2415a implements Runnable {

        /* renamed from: b */
        private boolean f13782b = false;

        public RunnableC2415a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (1 == DataStreamReplayFragment.this.f13740L) {
                DataStreamReplayFragment.this.f13772r.putBoolean("Limit", DataStreamReplayFragment.this.f13741M);
                DataStreamReplayFragment.this.f13772r.putInt("FirstMin", DataStreamReplayFragment.this.f13742N);
                DataStreamReplayFragment.this.f13772r.putInt("FirstMax", DataStreamReplayFragment.this.f13743O);
                DataStreamReplayFragment.this.f13772r.putInt("FirstCount", DataStreamReplayFragment.this.f13744P);
                DataStreamReplayFragment.this.f13772r.putInt("SecondCount", DataStreamReplayFragment.this.f13745Q);
                DataStreamReplayFragment dataStreamReplayFragment = DataStreamReplayFragment.this;
                dataStreamReplayFragment.m6398a(dataStreamReplayFragment.f13768n);
                DataStreamReplayFragment.this.f13772r.putSerializable("FirstDataList", DataStreamReplayFragment.this.f13746R);
                DataStreamReplayFragment.this.f13772r.putSerializable("SecondDataList", DataStreamReplayFragment.this.f13747S);
                return;
            }
            DataStreamReplayFragment.this.f13772r.putString("DataStreamMask", DataStreamReplayFragment.this.f13769o);
            DataStreamReplayFragment.this.f13772r.putString("DataStreamShow_Type", DataStreamReplayFragment.this.f13766l);
            DataStreamReplayFragment.this.f13772r.putInt("DataStreamCount", DataStreamReplayFragment.this.f13767m);
            DataStreamReplayFragment.this.f13756b.setVisibility(this.f13782b ? 0 : 8);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.IDataStreamSelectionRecorder
    /* renamed from: a */
    public final void mo6399a(String str) {
        this.f13769o = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6398a(ArrayList<BasicDataStreamBean> arrayList) {
        int size;
        if (arrayList == null || arrayList.size() <= 0 || (size = arrayList.size()) != this.f13744P + this.f13745Q) {
            return;
        }
        if (this.f13746R == null) {
            this.f13746R = new ArrayList<>();
        }
        if (this.f13747S == null) {
            this.f13747S = new ArrayList<>();
        }
        this.f13746R.clear();
        this.f13747S.clear();
        for (int i = 0; i < size; i++) {
            BasicDataStreamBean basicDataStreamBean = arrayList.get(i);
            if (i < this.f13744P) {
                this.f13746R.add(basicDataStreamBean);
            } else {
                this.f13747S.add(basicDataStreamBean);
            }
        }
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.ICallKeyDownFragment
    /* renamed from: a */
    public final void mo6302a(ICallKeyDownFragment iCallKeyDownFragment) {
        this.f13755a = iCallKeyDownFragment;
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.x431pro.activity.golo.p225b.OnGoloKeyDownListener
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (1 == this.f13740L) {
            popBackStack();
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m6401a(DataStreamReplayFragment dataStreamReplayFragment, ArrayList arrayList) {
        if (1 == dataStreamReplayFragment.f13740L) {
            synchronized (dataStreamReplayFragment.f13746R) {
                dataStreamReplayFragment.m6398a(arrayList);
                if (dataStreamReplayFragment.f13746R != null && dataStreamReplayFragment.f13747S != null) {
                    dataStreamReplayFragment.f13770p.m7353a(dataStreamReplayFragment.f13746R, dataStreamReplayFragment.f13747S);
                }
            }
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((BasicDataStreamBean) it.next()).doConversion();
        }
        dataStreamReplayFragment.f13770p.m7355a(arrayList);
    }
}
