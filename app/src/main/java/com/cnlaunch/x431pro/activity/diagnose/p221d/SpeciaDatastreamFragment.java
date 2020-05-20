package com.cnlaunch.x431pro.activity.diagnose.p221d;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import com.cnlaunch.diagnosemodule.bean.BasicDataStreamBean;
import com.cnlaunch.diagnosemodule.utils.CopyFile;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.mycar.jni.JniX431FileTest;
import com.cnlaunch.mycar.jni.RANGE_STRING;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.activity.MainActivity;
import com.cnlaunch.x431pro.activity.diagnose.p220c.BottomActionBar;
import com.cnlaunch.x431pro.activity.diagnose.p220c.DataStreamManager;
import com.cnlaunch.x431pro.activity.diagnose.p220c.ICallKeyDownFragment;
import com.cnlaunch.x431pro.activity.diagnose.p220c.IDataStreamSelectionRecorder;
import com.cnlaunch.x431pro.activity.diagnose.p220c.IDataStreamSelector;
import com.cnlaunch.x431pro.activity.diagnose.p220c.X431DataStreamManager;
import com.cnlaunch.x431pro.activity.diagnose.p222e.OnDiagnoseDataUpdateListenter;
import com.cnlaunch.x431pro.activity.diagnose.p222e.TabListener;
import com.cnlaunch.x431pro.utils.PathUtils;
import com.cnlaunch.x431pro.utils.p281c.DateStyle;
import com.cnlaunch.x431pro.utils.p281c.DateUtils;
import com.cnlaunch.x431pro.utils.p285e.FileUtils;
import com.cnlaunch.x431pro.utils.p288h.PrintDataUtils;
import com.cnlaunch.x431pro.widget.button.IconButton;
import com.cnlaunch.x431pro.widget.p290a.MessageDialog;
import com.ifoer.expedition.pro.R;
import com.mopub.volley.BuildConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.bq */
/* loaded from: classes.dex */
public final class SpeciaDatastreamFragment extends BaseDiagnoseFragment implements View.OnClickListener, ICallKeyDownFragment, IDataStreamSelectionRecorder {

    /* renamed from: D */
    private Chronometer f12155D;

    /* renamed from: E */
    private String f12156E;

    /* renamed from: F */
    private String f12157F;

    /* renamed from: G */
    private long f12158G;

    /* renamed from: a */
    private long f12163a;

    /* renamed from: j */
    private ICallKeyDownFragment f12165j;

    /* renamed from: k */
    private ArrayList<BasicDataStreamBean> f12166k;

    /* renamed from: l */
    private ArrayList<BasicDataStreamBean> f12167l;

    /* renamed from: o */
    private int f12170o;

    /* renamed from: p */
    private int f12171p;

    /* renamed from: q */
    private int f12172q;

    /* renamed from: r */
    private int f12173r;

    /* renamed from: s */
    private DataStreamManager f12174s;

    /* renamed from: t */
    private Button f12175t;

    /* renamed from: u */
    private IconButton f12176u;

    /* renamed from: v */
    private IconButton f12177v;

    /* renamed from: w */
    private IconButton f12178w;

    /* renamed from: y */
    private BottomActionBar f12180y;

    /* renamed from: z */
    private View f12181z;

    /* renamed from: b */
    private long f12164b = 0;

    /* renamed from: m */
    private String f12168m = null;

    /* renamed from: n */
    private boolean f12169n = false;

    /* renamed from: x */
    private BottomActionBar.AbstractC2090a f12179x = null;

    /* renamed from: A */
    private Bundle f12152A = new Bundle();

    /* renamed from: B */
    private Button f12153B = null;

    /* renamed from: C */
    private JniX431FileTest f12154C = null;

    /* renamed from: H */
    private long f12159H = 0;

    /* renamed from: I */
    private long f12160I = 0;

    /* renamed from: J */
    private ArrayList<RANGE_STRING> f12161J = new ArrayList<>();

    /* renamed from: K */
    private int[] f12162K = null;

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.ICallKeyDownFragment
    /* renamed from: a */
    public final void mo6305a() {
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.IDataStreamSelectionRecorder
    /* renamed from: a */
    public final void mo6404a(IDataStreamSelector iDataStreamSelector) {
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.IDataStreamSelectionRecorder
    /* renamed from: a */
    public final void mo6399a(String str) {
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

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, android.app.Fragment
    public final void onAttach(Activity activity) {
        super.onAttach(activity);
        Bundle arguments = getArguments();
        ArrayList arrayList = new ArrayList();
        if (arguments != null) {
            this.f12168m = arguments.getString("Title");
            this.f12169n = arguments.getBoolean("Limit");
            this.f12170o = arguments.getInt("FirstMin");
            this.f12171p = arguments.getInt("FirstMax");
            this.f12172q = arguments.getInt("FirstCount");
            this.f12173r = arguments.getInt("SecondCount");
            this.f12166k = (ArrayList) arguments.getSerializable("FirstList");
            this.f12167l = (ArrayList) arguments.getSerializable("SecondList");
            m7180j();
        }
        if (this.f12174s == null) {
            this.f12174s = new X431DataStreamManager(arrayList);
            DataStreamManager dataStreamManager = this.f12174s;
            dataStreamManager.f11740a = true;
            ArrayList<BasicDataStreamBean> arrayList2 = this.f12166k;
            if (arrayList2 != null) {
                dataStreamManager.m7386a(arrayList2, this.f12167l);
            }
        }
        if (this.f12168m == null) {
            this.f12168m = getString(R.string.fragment_title_powerbalance);
        }
        this.f12357d.mo7083i().setSubTitle(this.f12168m);
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f12357d.mo7097a((OnDiagnoseDataUpdateListenter) this);
        this.f12155D = (Chronometer) getActivity().findViewById(R.id.chronometer_record_time);
        this.f12155D.setFormat("%s");
        this.f12177v = (IconButton) getActivity().findViewById(R.id.btn_record);
        this.f12178w = (IconButton) getActivity().findViewById(R.id.btn_clear);
        this.f12176u = (IconButton) getActivity().findViewById(R.id.btn_home);
        this.f12175t = (Button) getActivity().findViewById(R.id.btn_stop_record);
        this.f12181z = getActivity().findViewById(R.id.v_record);
        this.f12153B = (Button) getActivity().findViewById(R.id.btn_powerbalance);
        if (this.f12356c) {
            this.f12177v.setOnClickListener(this);
            this.f12178w.setOnClickListener(this);
            this.f12176u.setOnClickListener(this);
            this.f12175t.setOnClickListener(this);
        }
        if (this.f12357d.mo7083i().getDiagnoseStatue() == 0) {
            this.f12177v.setEnabled(false);
            this.f12178w.setEnabled(false);
        }
        this.f12180y = new BottomActionBar(getActivity());
        C2150br c2150br = new C2150br(this, this.f12153B);
        TabListener tabListener = new TabListener(getActivity(), PowerBalanceFragment.class, this.f12152A, new RunnableC2149a(), this);
        tabListener.f12429a = this;
        c2150br.f11710b = tabListener;
        this.f12179x = c2150br;
        this.f12180y.m7421a(this.f12179x);
        this.f12153B.performClick();
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public final void onDestroy() {
        this.f12174s.m7382c();
        if (this.f12357d.mo7083i().isDatastreamRecord()) {
            m7182i();
            this.f12357d.mo7083i().setDatastreamRecord(false);
        }
        try {
            if (this.f12179x != null) {
                this.f12179x.f11710b.mo7071a();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onDestroy();
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment
    /* renamed from: b */
    public final String mo7102b() {
        return this.f12168m;
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public final View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_speciadatastream_show, viewGroup, false);
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment
    /* renamed from: c */
    public final String mo7100c() {
        ArrayList<BasicDataStreamBean> arrayList = this.f12166k;
        if (arrayList == null || arrayList.size() == 0) {
            return super.mo7100c();
        }
        return PrintDataUtils.m4933a(getActivity(), this.f12166k);
    }

    /* compiled from: SpeciaDatastreamFragment.java */
    /* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.bq$a */
    /* loaded from: classes.dex */
    class RunnableC2149a implements Runnable {

        /* renamed from: b */
        private boolean f12183b = true;

        public RunnableC2149a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            SpeciaDatastreamFragment.this.f12152A.putBoolean("Limit", SpeciaDatastreamFragment.this.f12169n);
            SpeciaDatastreamFragment.this.f12152A.putInt("FirstMin", SpeciaDatastreamFragment.this.f12170o);
            SpeciaDatastreamFragment.this.f12152A.putInt("FirstMax", SpeciaDatastreamFragment.this.f12171p);
            SpeciaDatastreamFragment.this.f12152A.putInt("FirstCount", SpeciaDatastreamFragment.this.f12172q);
            SpeciaDatastreamFragment.this.f12152A.putInt("SecondCount", SpeciaDatastreamFragment.this.f12173r);
            SpeciaDatastreamFragment.this.f12152A.putSerializable("FirstDataList", SpeciaDatastreamFragment.this.f12166k);
            SpeciaDatastreamFragment.this.f12152A.putSerializable("SecondDataList", SpeciaDatastreamFragment.this.f12167l);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, android.view.View.OnClickListener
    public final void onClick(View view) {
        String str;
        String remoteSerialNum;
        super.onClick(view);
        int id = view.getId();
        if (id == R.id.btn_clear) {
            this.f12165j.mo6305a();
        } else if (id == R.id.btn_record) {
            if (this.f12357d.mo7083i().isDatastreamRecord()) {
                return;
            }
            if (FileUtils.m5027a() > 30) {
                new File(PathUtils.m4843m()).mkdirs();
                this.f12176u.setEnabled(false);
                this.f12177v.setEnabled(false);
                this.f12357d.mo7083i().setDatastreamRecord(true);
                this.f12357d.mo7087b(true);
                this.f12181z.setVisibility(0);
                this.f12155D.setBase(SystemClock.elapsedRealtime());
                this.f12155D.start();
                String upperCase = Locale.getDefault().getCountry().toUpperCase(Locale.getDefault());
                this.f12154C = new JniX431FileTest();
                this.f12158G = this.f12154C.init();
                this.f12156E = DateUtils.m5094a(DateStyle.f15729g).replace("-", "").replace(":", "").replace(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR, "");
                if (this.f12357d.mo7083i().getDiagnoseStatue() > 1) {
                    str = this.f12357d.mo7083i().getCarSoftName().toUpperCase(Locale.getDefault());
                    remoteSerialNum = this.f12357d.mo7083i().getSerialNum();
                } else {
                    str = "GOLO";
                    remoteSerialNum = this.f12357d.mo7081k().getRemoteSerialNum();
                }
                this.f12157F = str + "_" + remoteSerialNum + "_" + getString(R.string.fragment_title_powerbalance) + "_" + this.f12156E + ".x431";
                this.f12157F = this.f12157F.replace("/", "&");
                this.f12159H = this.f12154C.creatFile(this.f12157F, upperCase, BuildConfig.VERSION_NAME, remoteSerialNum, this.f12158G, PathUtils.m4843m());
                long j = this.f12159H;
                if (j != 0) {
                    this.f12160I = this.f12154C.writeNewGroup(j, str, this.f12156E);
                    return;
                }
                NToast.m9444c(getActivity(), (int) R.string.datastream_record_create_err);
                m7184h();
                return;
            }
            NToast.m9450a(this.mContext, (int) R.string.datastream_record_create_file_err);
        } else if (id == R.id.btn_stop_record && this.f12357d.mo7083i().isDatastreamRecord()) {
            if (this.f12154C.readGroupItemCount(this.f12160I) <= 0) {
                MessageDialog messageDialog = new MessageDialog(this.mContext);
                messageDialog.setTitle(R.string.common_title_tips);
                messageDialog.m4714e(R.string.toast_datastream_record_short);
                messageDialog.m4719a(R.string.confirm, true, null);
                messageDialog.m4717b(R.string.cancel, true, new View$OnClickListenerC2151bs(this));
                messageDialog.show();
                return;
            }
            this.f12177v.setEnabled(true);
            this.f12177v.setText(R.string.btn_record);
            m7182i();
        }
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, com.cnlaunch.x431pro.activity.diagnose.p222e.OnDiagnoseDataUpdateListenter
    /* renamed from: b */
    public final void mo7072b(ArrayList<BasicDataStreamBean> arrayList, ArrayList<BasicDataStreamBean> arrayList2) {
        DataStreamManager dataStreamManager = this.f12174s;
        if (dataStreamManager == null || arrayList == null || arrayList2 == null) {
            return;
        }
        dataStreamManager.m7386a(arrayList, arrayList2);
        this.f12166k = arrayList;
        this.f12167l = arrayList2;
        ArrayList<BasicDataStreamBean> arrayList3 = new ArrayList<>();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            arrayList3.add(arrayList.get(i));
        }
        int size2 = arrayList2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            arrayList3.add(arrayList2.get(i2));
        }
        if (this.f12357d.mo7083i().isDatastreamRecord()) {
            if (this.f12154C.readGroupItemCount(this.f12160I) == 0) {
                this.f12154C.writeTag(this.f12159H, 1);
                if (true == this.f12154C.writeDsBasics(this.f12160I, arrayList3, this.f12161J, this.f12162K)) {
                    this.f12357d.mo7083i().setDatastreamRecord(true);
                } else {
                    NToast.m9444c(getActivity(), (int) R.string.datastream_record_write_basicinfo_err);
                    m7182i();
                }
            }
            this.f12154C.writeDSDate(this.f12160I, arrayList3);
        }
    }

    /* renamed from: i */
    private void m7182i() {
        this.f12176u.setEnabled(true);
        this.f12177v.setEnabled(true);
        this.f12357d.mo7087b(false);
        this.f12357d.mo7083i().setDatastreamRecord(false);
        this.f12181z.setVisibility(8);
        this.f12155D.stop();
        if (this.f12154C.readGroupItemCount(this.f12160I) <= 0) {
            NToast.m9444c(getActivity(), (int) R.string.datastream_record_rec_short_fail);
            File file = new File(PathUtils.m4843m() + this.f12157F);
            if (file.exists()) {
                file.delete();
            }
        } else {
            this.f12154C.writeEndCloseFile(this.f12160I, this.f12156E, this.f12159H, this.f12158G, this.f12157F);
            CopyFile.CopySdcardFile(PathUtils.m4843m() + this.f12157F, PathUtils.m4855d() + this.f12157F);
            File file2 = new File(PathUtils.m4843m() + this.f12157F);
            if (file2.exists()) {
                file2.delete();
            }
            NToast.m9443c(getActivity(), getString(R.string.datastream_record_rec_success) + "\n" + this.f12157F);
        }
        this.f12154C = null;
    }

    /* renamed from: j */
    private void m7180j() {
        if (this.f12162K == null) {
            this.f12162K = new int[this.f12172q + this.f12167l.size()];
        }
        int i = 0;
        int i2 = 0;
        while (i < this.f12172q) {
            RANGE_STRING range_string = new RANGE_STRING();
            range_string.max = String.valueOf(this.f12171p);
            range_string.min = String.valueOf(this.f12170o);
            this.f12162K[i2] = 1;
            this.f12161J.add(range_string);
            i++;
            i2++;
        }
        int i3 = 0;
        while (i3 < this.f12167l.size()) {
            try {
                String[] split = this.f12167l.get(i3).getSrcUnit().split("\\|");
                RANGE_STRING range_string2 = new RANGE_STRING();
                if (split != null && 2 == split.length) {
                    if (split[0] != null && !split[0].isEmpty()) {
                        range_string2.min = split[0];
                    }
                    if (split[1] != null && !split[1].isEmpty()) {
                        range_string2.max = split[1];
                    }
                }
                int i4 = i2 + 1;
                this.f12162K[i2] = 3;
                this.f12161J.add(range_string2);
                i3++;
                i2 = i4;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.ICallKeyDownFragment
    /* renamed from: a */
    public final void mo6302a(ICallKeyDownFragment iCallKeyDownFragment) {
        this.f12165j = iCallKeyDownFragment;
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.x431pro.activity.golo.p225b.OnGoloKeyDownListener
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.f12357d.mo7083i().isDatastreamRecord()) {
                this.f12163a = new Date().getTime();
                if (this.f12163a - this.f12164b < 2000) {
                    return true;
                }
                NToast.m9444c(getActivity(), (int) R.string.toast_mustbe_stop_record);
                this.f12164b = new Date().getTime();
                return true;
            }
            if (!MainActivity.m7895b()) {
                this.f12357d.mo7093a(DiagnoseConstants.FEEDBACK_SPECIADATASTREAM, "7", 5);
            }
            return super.onKeyDown(i, keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m7184h() {
        this.f12357d.mo7087b(false);
        this.f12357d.mo7083i().setDatastreamRecord(false);
        this.f12181z.setVisibility(8);
        this.f12155D.stop();
        this.f12154C = null;
        this.f12176u.setEnabled(true);
        this.f12177v.setEnabled(true);
    }
}
