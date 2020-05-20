package com.cnlaunch.x431pro.activity.mine.p230b;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cnlaunch.diagnosemodule.bean.BasicDataStreamBean;
import com.cnlaunch.diagnosemodule.bean.BasicSelectMenuBean;
import com.cnlaunch.mycar.jni.JniX431FileTest;
import com.cnlaunch.mycar.jni.RANGE_STRING;
import com.cnlaunch.mycar.jni.X431Integer;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.activity.BaseFragment;
import com.cnlaunch.x431pro.activity.diagnose.p218a.DatastreamSelectListAdapter;
import com.cnlaunch.x431pro.widget.button.IconButton;
import com.cnlaunch.x431pro.widget.button.IconRadioButton;
import com.cnlaunch.x431pro.widget.staggeredgridview.StaggeredGridView;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

@SuppressLint({"HandlerLeak"})
/* renamed from: com.cnlaunch.x431pro.activity.mine.b.k */
/* loaded from: classes.dex */
public class DiagnosisPlaybackFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {

    /* renamed from: d */
    private IconRadioButton f13797d;

    /* renamed from: e */
    private IconButton f13798e;

    /* renamed from: f */
    private IconButton f13799f;

    /* renamed from: g */
    private TextView f13800g;

    /* renamed from: h */
    private ProgressBar f13801h;

    /* renamed from: j */
    private long f13803j;

    /* renamed from: k */
    private long f13804k;

    /* renamed from: l */
    private long f13805l;

    /* renamed from: m */
    private int f13806m;

    /* renamed from: n */
    private JniX431FileTest f13807n;

    /* renamed from: o */
    private int f13808o;

    /* renamed from: p */
    private long f13809p;

    /* renamed from: q */
    private String[] f13810q;

    /* renamed from: r */
    private String[] f13811r;

    /* renamed from: s */
    private String[] f13812s;

    /* renamed from: u */
    private StaggeredGridView f13814u;

    /* renamed from: v */
    private DatastreamSelectListAdapter f13815v;

    /* renamed from: i */
    private String f13802i = "";

    /* renamed from: t */
    private ArrayList<BasicSelectMenuBean> f13813t = new ArrayList<>();

    /* renamed from: w */
    private ArrayList<ArrayList<BasicDataStreamBean>> f13816w = new ArrayList<>();

    /* renamed from: x */
    private ArrayList<ArrayList<BasicDataStreamBean>> f13817x = new ArrayList<>();

    /* renamed from: y */
    private int f13818y = 0;

    /* renamed from: z */
    private int f13819z = 9999;

    /* renamed from: A */
    private Thread f13791A = null;

    /* renamed from: a */
    X431Integer f13794a = new X431Integer(0);

    /* renamed from: B */
    private ArrayList<RANGE_STRING> f13792B = null;

    /* renamed from: C */
    private int[] f13793C = null;

    /* renamed from: b */
    Handler f13795b = new HandlerC2424l(this);

    /* renamed from: c */
    Runnable f13796c = new RunnableC2428p(this);

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Bundle bundle2 = getBundle();
        if (bundle2 != null) {
            this.f13802i = bundle2.getString("report_name");
        } else {
            this.f13802i = getArguments().getString("report_name");
        }
        setTitle(R.string.report_title_datalist);
        int i = getResources().getDisplayMetrics().widthPixels;
        this.f13801h = (ProgressBar) getActivity().findViewById(R.id.progress_palyback_load);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f13801h.getLayoutParams();
        layoutParams.width = i / 3;
        layoutParams.height = -2;
        this.f13801h.setLayoutParams(layoutParams);
        this.f13800g = (TextView) getActivity().findViewById(R.id.tv_playback_get_hint);
        this.f13797d = (IconRadioButton) getActivity().findViewById(R.id.btn_selectall);
        this.f13797d.setOnClickListener(this);
        this.f13797d.setChecked(false);
        this.f13797d.setEnabled(false);
        this.f13798e = (IconButton) getActivity().findViewById(R.id.btn_confirm);
        this.f13798e.setOnClickListener(this);
        this.f13798e.setEnabled(false);
        this.f13799f = (IconButton) getActivity().findViewById(R.id.btn_delete);
        this.f13799f.setOnClickListener(this);
        this.f13814u = (StaggeredGridView) getActivity().findViewById(R.id.gridview_select);
        this.f13814u.setOnItemClickListener(this);
        if (this.f13817x.size() == 0) {
            this.f13791A = null;
            this.f13791A = new Thread(this.f13796c);
            this.f13791A.start();
            return;
        }
        this.f13795b.sendEmptyMessage(1);
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f13813t.clear();
        this.f13816w.clear();
        this.f13817x.clear();
        this.f13813t = null;
        this.f13816w = null;
        this.f13817x = null;
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.diagnosisplayback_fragment, viewGroup, false);
    }

    @Override // android.app.Fragment
    public void onStop() {
        Thread thread = this.f13791A;
        if (thread != null) {
            thread.interrupt();
            this.f13791A = null;
        }
        super.onStop();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id != R.id.btn_confirm) {
            if (id != R.id.btn_delete) {
                return;
            }
            new C2429q(this).m4610a(getActivity(), R.string.dialog_title_default, R.string.mine_dialog_content_delreport, true);
            return;
        }
        ArrayList<ArrayList<BasicDataStreamBean>> arrayList = this.f13817x;
        ArrayList<ArrayList<BasicDataStreamBean>> arrayList2 = new ArrayList<>();
        if (this.f13815v.m7502g() == 0) {
            NToast.m9447b(getActivity(), (int) R.string.toast_need_one_item);
        } else {
            String m7505d = this.f13815v.m7505d();
            for (int i = 0; i < arrayList.size(); i++) {
                ArrayList<BasicDataStreamBean> arrayList3 = new ArrayList<>();
                for (int i2 = 0; i2 < arrayList.get(i).size(); i2++) {
                    if (arrayList.get(i) != null && arrayList.get(i).size() > 0 && Character.valueOf(m7505d.charAt(i2)).toString().equals("1") && arrayList.get(i).get(i2) != null) {
                        arrayList3.add(arrayList.get(i).get(i2));
                    }
                }
                if (arrayList3.size() > 0) {
                    arrayList2.add(arrayList3);
                }
            }
        }
        this.f13816w = arrayList2;
        if (this.f13816w.size() == 0) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable("DataStreamAll", this.f13816w);
        bundle.putInt("DataStreamCount", this.f13816w.get(0).size());
        bundle.putString("DataStreamShow_Type", "");
        bundle.putString("ReportPath", this.f13802i);
        bundle.putBoolean("isVoltage", 4 == this.f13794a.mValue);
        replaceFragment(DataStreamReplayFragment.class.getName(), bundle);
        this.f13797d.setChecked(false);
        this.f13818y = 0;
        this.f13815v.m7506c();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (adapterView.getId() == R.id.gridview_select && 1 != this.f13794a.mValue) {
            this.f13818y += this.f13815v.m7512a(i) ? 1 : -1;
            if (this.f13818y > this.f13819z) {
                NToast.m9449a(this.mContext, String.format(getString(R.string.toast_replay_datastream_check), Integer.valueOf(this.f13819z)));
                DatastreamSelectListAdapter datastreamSelectListAdapter = this.f13815v;
                datastreamSelectListAdapter.f11309b.get(i).setCheck(false);
                datastreamSelectListAdapter.notifyDataSetChanged();
                this.f13818y--;
            }
            Message message2 = new Message();
            message2.what = 4;
            if (this.f13813t.size() == this.f13815v.m7502g()) {
                message2.arg1 = 1;
            } else {
                message2.arg1 = 0;
            }
            this.f13795b.sendMessage(message2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: h */
    public static /* synthetic */ void m6339h(DiagnosisPlaybackFragment diagnosisPlaybackFragment) {
        String[] strArr;
        ArrayList<RANGE_STRING> arrayList;
        RANGE_STRING range_string;
        int parseFloat;
        int parseFloat2;
        int i;
        int i2;
        ArrayList<ArrayList<BasicDataStreamBean>> arrayList2 = diagnosisPlaybackFragment.f13817x;
        if (arrayList2 == null || arrayList2.size() <= 0 || (strArr = diagnosisPlaybackFragment.f13811r) == null || strArr.length <= 0 || (arrayList = diagnosisPlaybackFragment.f13792B) == null || arrayList.size() <= 0) {
            diagnosisPlaybackFragment.replaceFragment(DataStreamReplayFragment.class.getName(), (Bundle) null);
            return;
        }
        int length = diagnosisPlaybackFragment.f13811r.length;
        try {
            int i3 = 0;
            RANGE_STRING range_string2 = diagnosisPlaybackFragment.f13792B.get(0);
            if (range_string2 != null) {
                try {
                    parseFloat = Integer.parseInt(range_string2.min);
                    parseFloat2 = Integer.parseInt(range_string2.max);
                } catch (Exception unused) {
                    parseFloat = (int) Float.parseFloat(range_string.min);
                    parseFloat2 = (int) Float.parseFloat(range_string.max);
                }
            } else {
                parseFloat2 = 0;
                parseFloat = 0;
            }
            if (diagnosisPlaybackFragment.f13793C == null || diagnosisPlaybackFragment.f13793C.length <= 0) {
                int i4 = 0;
                int i5 = 0;
                while (i3 < length) {
                    if (diagnosisPlaybackFragment.f13811r[i3].equals(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR)) {
                        i4++;
                    } else if (diagnosisPlaybackFragment.f13811r[i3].contains("|")) {
                        i5++;
                    }
                    i3++;
                }
                i = i4;
                i2 = i5;
            } else {
                i = 0;
                i2 = 0;
                while (i3 < diagnosisPlaybackFragment.f13793C.length) {
                    if (1 == diagnosisPlaybackFragment.f13793C[i3]) {
                        i++;
                    } else if (3 == diagnosisPlaybackFragment.f13793C[i3]) {
                        i2++;
                    }
                    i3++;
                }
            }
            diagnosisPlaybackFragment.bundle.putString("ReportPath", diagnosisPlaybackFragment.f13802i);
            diagnosisPlaybackFragment.bundle.putInt("EnginePowerBalance", 1);
            diagnosisPlaybackFragment.bundle.putBoolean("Limit", true);
            diagnosisPlaybackFragment.bundle.putInt("FirstMin", parseFloat);
            diagnosisPlaybackFragment.bundle.putInt("FirstMax", parseFloat2);
            diagnosisPlaybackFragment.bundle.putInt("FirstCount", i);
            diagnosisPlaybackFragment.bundle.putInt("SecondCount", i2);
            diagnosisPlaybackFragment.bundle.putSerializable("FirstDataList", diagnosisPlaybackFragment.f13817x);
            diagnosisPlaybackFragment.bundle.putSerializable("SecondDataList", null);
            diagnosisPlaybackFragment.replaceFragment(DataStreamReplayFragment.class.getName(), diagnosisPlaybackFragment.bundle);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
