package com.cnlaunch.x431pro.activity.diagnose;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.text.method.ScrollingMovementMethod;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceConstant;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.p120d.p130d.p131a.LangManager;
import com.cnlaunch.physics.DeviceFactoryManager;
import com.cnlaunch.physics.p199e.IPhysics;
import com.cnlaunch.x431pro.activity.bluetooth.BluetoothActivity;
import com.cnlaunch.x431pro.activity.diagnose.p218a.SelectCarVerAdapter;
import com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment;
import com.cnlaunch.x431pro.activity.diagnose.p222e.OnDelectDataListenter;
import com.cnlaunch.x431pro.activity.info.PdfSearchFragment;
import com.cnlaunch.x431pro.activity.info.PdfViewFragment;
import com.cnlaunch.x431pro.activity.mine.MineActivity;
import com.cnlaunch.x431pro.module.p252d.p254b.CarVersionInfo;
import com.cnlaunch.x431pro.module.p252d.p254b.DiagnoseRunningInfo;
import com.cnlaunch.x431pro.p210a.C1947h;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.utils.C2787z;
import com.cnlaunch.x431pro.utils.PathUtils;
import com.cnlaunch.x431pro.utils.p280b.LanChaset;
import com.cnlaunch.x431pro.utils.p283db.CarVersion;
import com.cnlaunch.x431pro.utils.p285e.FileUtils;
import com.cnlaunch.x431pro.utils.p286f.CarIconUtils;
import com.cnlaunch.x431pro.utils.p289i.FixedThreadPool;
import com.cnlaunch.x431pro.widget.button.IconButton;
import com.cnlaunch.x431pro.widget.p290a.MessageDialog;
import com.ifoer.expedition.pro.R;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

@SuppressLint({"HandlerLeak"})
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.by */
/* loaded from: classes.dex */
public class SelectSoftVersionFragment extends BaseDiagnoseFragment implements AdapterView.OnItemClickListener, OnDelectDataListenter {

    /* renamed from: G */
    private static long f11671G = 0;

    /* renamed from: a */
    private static final String f11672a = "by";

    /* renamed from: A */
    private TextView f11673A;

    /* renamed from: B */
    private Context f11674B;

    /* renamed from: C */
    private PathUtils f11675C;

    /* renamed from: D */
    private CarIconUtils f11676D;

    /* renamed from: H */
    private String f11679H;

    /* renamed from: I */
    private boolean f11680I;

    /* renamed from: b */
    private ListView f11684b;

    /* renamed from: j */
    private SelectCarVerAdapter f11685j;

    /* renamed from: k */
    private IconButton f11686k;

    /* renamed from: l */
    private IconButton f11687l;

    /* renamed from: m */
    private IconButton f11688m;

    /* renamed from: n */
    private IconButton f11689n;

    /* renamed from: o */
    private IconButton f11690o;

    /* renamed from: p */
    private IconButton f11691p;

    /* renamed from: q */
    private IconButton f11692q;

    /* renamed from: r */
    private ArrayList<CarVersionInfo> f11693r;

    /* renamed from: s */
    private String f11694s;

    /* renamed from: t */
    private String f11695t;

    /* renamed from: u */
    private String f11696u;

    /* renamed from: v */
    private String f11697v;

    /* renamed from: w */
    private String f11698w;

    /* renamed from: z */
    private TextView f11701z;

    /* renamed from: x */
    private String f11699x = "";

    /* renamed from: y */
    private final int f11700y = HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_BAIDUMAP_NULL;

    /* renamed from: E */
    private long f11677E = 0;

    /* renamed from: F */
    private long f11678F = 0;

    /* renamed from: J */
    private boolean f11681J = false;

    /* renamed from: K */
    private Handler f11682K = new HandlerC2107ce(this);

    /* renamed from: L */
    private final BroadcastReceiver f11683L = new C2109cg(this);

    /* renamed from: d */
    private static synchronized boolean m7434d() {
        synchronized (SelectSoftVersionFragment.class) {
            long currentTimeMillis = System.currentTimeMillis();
            if (Math.abs(currentTimeMillis - f11671G) < 1000) {
                return true;
            }
            f11671G = currentTimeMillis;
            return false;
        }
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Bundle arguments = getArguments();
        if (arguments != null) {
            if (LangManager.m9469a().equalsIgnoreCase("zh")) {
                this.f11694s = arguments.getString("carname_zh");
            } else {
                this.f11694s = arguments.getString("carname");
            }
            this.f11697v = arguments.getString("softpackageid");
            this.f11695t = arguments.getString("areaId");
        }
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment
    /* renamed from: c */
    public final String mo7100c() {
        return this.f11696u;
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f11674B = getActivity();
        this.mContext.registerReceiver(this.f11683L, new IntentFilter());
        FixedThreadPool.m4928a().m4927a(new RunnableC2088bz(this));
        this.f11675C = new PathUtils(this.f11674B);
        this.f11676D = new CarIconUtils(this.f11674B);
        this.f11698w = PreferencesManager.m9595a((Context) getActivity()).m9591a("serialNo");
        List<CarVersion> m4954d = this.f11676D.m4954d(this.f11698w, this.f11697v);
        setTitle(R.string.fragment_title_selectcarver);
        this.f11693r = m7438a(m4954d);
        this.f11684b = (ListView) getActivity().findViewById(R.id.lv_carver);
        this.f11685j = new SelectCarVerAdapter(getActivity(), this.f11693r, this.f11694s, this);
        this.f11684b.setAdapter((ListAdapter) this.f11685j);
        this.f11684b.setOnItemClickListener(this);
        this.f11701z = (TextView) getActivity().findViewById(R.id.tv_ini_text);
        this.f11673A = (TextView) getActivity().findViewById(R.id.tv_ini_title);
        this.f11701z.setMovementMethod(new ScrollingMovementMethod());
        this.f11679H = this.f11675C.m4859b(this.f11698w, this.f11697v, this.f11693r.get(0).getVersion());
        ArrayList<CarVersionInfo> arrayList = this.f11693r;
        if (arrayList != null && !arrayList.isEmpty()) {
            this.f11679H = this.f11675C.m4859b(this.f11698w, this.f11697v, this.f11693r.get(0).getVersion());
        }
        this.f11680I = PathUtils.m4860b(this.f11679H);
        if (this.f11680I) {
            this.f11688m.setVisibility(0);
            this.f11689n.setVisibility(0);
            this.f11690o.setVisibility(0);
            this.f11691p.setVisibility(0);
            this.f11692q.setVisibility(8);
        } else {
            this.f11688m.setVisibility(8);
            this.f11689n.setVisibility(8);
            this.f11690o.setVisibility(8);
            this.f11691p.setVisibility(8);
            this.f11692q.setVisibility(8);
        }
        request(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_BAIDUMAP_NULL, false);
        this.f11682K.obtainMessage(1).sendToTarget();
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_select_carver, viewGroup, false);
        this.f11687l = (IconButton) inflate.findViewById(R.id.btn_confirm);
        this.f11686k = (IconButton) inflate.findViewById(R.id.btn_check_bluetooth);
        this.f11688m = (IconButton) inflate.findViewById(R.id.btn_measurableCar);
        this.f11689n = (IconButton) inflate.findViewById(R.id.btn_updateInstructions);
        this.f11690o = (IconButton) inflate.findViewById(R.id.btn_softwareIntroduction);
        this.f11691p = (IconButton) inflate.findViewById(R.id.btn_attentions);
        this.f11692q = (IconButton) inflate.findViewById(R.id.btn_flashcodehelp);
        this.f11687l.setOnClickListener(this);
        this.f11686k.setOnClickListener(this);
        this.f11688m.setOnClickListener(this);
        this.f11689n.setOnClickListener(this);
        this.f11690o.setOnClickListener(this);
        this.f11691p.setOnClickListener(this);
        this.f11692q.setOnClickListener(this);
        return inflate;
    }

    /* renamed from: h */
    private boolean m7428h() {
        return !this.f11681J || Math.abs(System.currentTimeMillis() - this.f11678F) >= 10000;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ArrayList<CarVersionInfo> arrayList;
        if (m7428h() && (arrayList = this.f11693r) != null && arrayList.size() > 0) {
            DiagnoseConstants.DIAGNOSE_CURRENT_PATH = "";
            if (this.f11699x.equals(this.f11693r.get(i).getVersion())) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f11677E < 2000) {
                    this.f11681J = true;
                    m7436c(i);
                    return;
                }
                this.f11699x = "";
                this.f11677E = currentTimeMillis;
                return;
            }
            this.f11677E = System.currentTimeMillis();
            this.f11699x = this.f11693r.get(i).getVersion();
            this.f11685j.m7484a(i);
            this.f11682K.obtainMessage(1).sendToTarget();
        }
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        this.f11684b.requestFocus();
        this.f11698w = PreferencesManager.m9595a((Context) getActivity()).m9591a("serialNo");
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        int id = view.getId();
        int i = this.f11685j.f11414a;
        if (i == -1) {
            return;
        }
        if (id == R.id.btn_confirm) {
            if (!m7434d() && m7428h()) {
                this.f11681J = true;
                m7436c(i);
            }
        } else if (id == R.id.btn_check_bluetooth) {
            if (MineActivity.f13541n) {
                MessageDialog messageDialog = new MessageDialog(this.mContext, (int) R.string.dialog_title_default, (int) R.string.msg_forbid_diagnose_with_fireware_repair, false, (byte) 0);
                messageDialog.m4719a(R.string.btn_confirm, true, new View$OnClickListenerC2103ca(this));
                messageDialog.show();
                return;
            }
            int m8296a = DeviceFactoryManager.m8305a().m8296a(false, this.mContext, this.f11698w);
            if (m8296a != 0) {
                switch (m8296a) {
                    case 1:
                        NToast.m9450a(this.mContext, (int) R.string.connect_bluetooth_error_with_link_wifi_mode_tip_message);
                        return;
                    case 2:
                        NToast.m9450a(this.mContext, (int) R.string.connect_bluetooth_error_with_link_serialport_mode_tip_message);
                        return;
                    case 3:
                        NToast.m9450a(this.mContext, (int) R.string.connect_bluetooth_error_with_usb_tip_message);
                        return;
                    default:
                        return;
                }
            }
            String m4864a = this.f11675C.m4864a(this.f11698w, this.f11697v, this.f11693r.get(i).getVersion());
            if (m4864a == null || m4864a.length() == 0) {
                MessageDialog messageDialog2 = new MessageDialog(this.mContext, (int) R.string.dialog_title_default, (int) R.string.msg_get_vehicle_data_failed_with_connector_changed, false, (byte) 0);
                messageDialog2.m4719a(R.string.btn_confirm, true, new View$OnClickListenerC2104cb(this));
                messageDialog2.show();
                return;
            }
            m7433d(i);
            if (DiagnoseConstants.driviceConnStatus) {
                IPhysics iPhysics = DeviceFactoryManager.m8305a().f9901a;
                String deviceName = iPhysics.getDeviceName();
                if (iPhysics != null && deviceName != null && deviceName.equals(this.f11698w)) {
                    NToast.m9450a(this.mContext, (int) R.string.bluetooth_search_with_connected_state_message);
                    return;
                } else {
                    DeviceFactoryManager.m8305a().m8288c();
                    DiagnoseConstants.driviceConnStatus = false;
                }
            }
            Intent intent = new Intent();
            intent.setClass(this.mContext, BluetoothActivity.class);
            intent.putExtra("Lib_path", m4864a);
            intent.putExtra("Lib_language", this.f11693r.get(i).getLanguage());
            this.mContext.startActivity(intent);
        } else if (id == R.id.btn_measurableCar) {
            String str = this.f11679H + ("COVER_" + C2744aa.m5131o() + ".pdf");
            boolean exists = new File(str).exists();
            if (!exists && !C2744aa.m5131o().equalsIgnoreCase("EN")) {
                str = this.f11679H + "COVER_EN.pdf";
                exists = new File(str).exists();
            }
            if (!exists) {
                NToast.m9450a(this.mContext, (int) R.string.feature_nonsupport);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("file_path", str);
            replaceFragment(PdfSearchFragment.class.getName(), bundle);
            setTitle(R.string.text_measurabecar);
        } else if (id == R.id.btn_updateInstructions) {
            String str2 = this.f11679H + ("UPDATE_" + C2744aa.m5131o() + ".pdf");
            boolean exists2 = new File(str2).exists();
            if (!exists2 && !C2744aa.m5131o().equalsIgnoreCase("EN")) {
                str2 = this.f11679H + "UPDATE_EN.pdf";
                exists2 = new File(str2).exists();
            }
            if (!exists2) {
                NToast.m9450a(this.mContext, (int) R.string.feature_nonsupport);
                return;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString("file_path", str2);
            bundle2.putString("title", getResources().getString(R.string.text_updateinstruction));
            replaceFragment(PdfViewFragment.class.getName(), bundle2);
        } else if (id == R.id.btn_softwareIntroduction) {
            String str3 = this.f11679H + ("INTRODUCTION_" + C2744aa.m5131o() + ".pdf");
            boolean exists3 = new File(str3).exists();
            if (!exists3 && !C2744aa.m5131o().equalsIgnoreCase("EN")) {
                str3 = this.f11679H + "INTRODUCTION_EN.pdf";
                exists3 = new File(str3).exists();
            }
            if (!exists3) {
                NToast.m9450a(this.mContext, (int) R.string.feature_nonsupport);
                return;
            }
            Bundle bundle3 = new Bundle();
            bundle3.putString("file_path", str3);
            bundle3.putString("title", getResources().getString(R.string.text_softwareintroduction));
            replaceFragment(PdfViewFragment.class.getName(), bundle3);
        } else if (id == R.id.btn_attentions) {
            String str4 = this.f11679H + ("ATTENTION_" + C2744aa.m5131o() + ".pdf");
            boolean exists4 = new File(str4).exists();
            if (!exists4 && !C2744aa.m5131o().equalsIgnoreCase("EN")) {
                str4 = this.f11679H + "ATTENTION_EN.pdf";
                exists4 = new File(str4).exists();
            }
            if (!exists4) {
                NToast.m9450a(this.mContext, (int) R.string.feature_nonsupport);
                return;
            }
            Bundle bundle4 = new Bundle();
            bundle4.putString("file_path", str4);
            bundle4.putString("title", getResources().getString(R.string.text_attentions));
            replaceFragment(PdfViewFragment.class.getName(), bundle4);
        } else if (id == R.id.btn_flashcodehelp) {
            String str5 = this.f11679H + ("FLASHCODEHELP_" + C2744aa.m5131o() + ".pdf");
            boolean exists5 = new File(str5).exists();
            if (!exists5 && !C2744aa.m5131o().equalsIgnoreCase("EN")) {
                str5 = this.f11679H + "FLASHCODEHELP_EN.pdf";
                exists5 = new File(str5).exists();
            }
            if (!exists5) {
                NToast.m9450a(this.mContext, (int) R.string.feature_nonsupport);
                return;
            }
            Bundle bundle5 = new Bundle();
            bundle5.putString("file_path", str5);
            bundle5.putString("title", getResources().getString(R.string.text_flashcodehelp));
            replaceFragment(PdfViewFragment.class.getName(), bundle5);
        }
    }

    /* renamed from: c */
    private void m7436c(int i) {
        this.f11678F = System.currentTimeMillis();
        String version = this.f11693r.get(i).getVersion();
        String m4864a = this.f11675C.m4864a(this.f11698w, this.f11697v, version);
        String str = this.f11675C.m4859b(this.f11698w, this.f11697v, version) + File.separator + "APPDATA.INI";
        NLog.m9456a("yhx", "iniFileName=".concat(String.valueOf(str)));
        if (m4864a == null || m4864a.length() == 0) {
            MessageDialog messageDialog = new MessageDialog(this.mContext, (int) R.string.dialog_title_default, (int) R.string.msg_get_vehicle_data_failed_with_connector_changed, false, (byte) 0);
            messageDialog.m4719a(R.string.btn_confirm, true, new View$OnClickListenerC2105cc(this));
            messageDialog.show();
            return;
        }
        try {
            FileUtils.m5012a(str, "SOFT_NAME", "MAKE", this.f11697v);
            m7433d(i);
            NLog.m9456a(f11672a, "path=".concat(String.valueOf(m4864a)));
            m7439a(this.f11694s, m4864a, this.f11693r.get(i).getLanguage());
        } catch (Exception e) {
            NLog.m9455a(e);
        }
    }

    /* renamed from: a */
    private ArrayList<CarVersionInfo> m7438a(List<CarVersion> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList<CarVersionInfo> arrayList = new ArrayList<>();
        ArrayList<CarVersionInfo> arrayList2 = new ArrayList<>();
        for (CarVersion carVersion : list) {
            if (!C2787z.m4821a(carVersion.f15827c)) {
                CarVersionInfo carVersionInfo = new CarVersionInfo();
                carVersionInfo.setVersion(carVersion.f15828d);
                carVersionInfo.setLanguage(carVersion.f15830f);
                arrayList.add(carVersionInfo);
            }
        }
        if (arrayList.size() > 1) {
            Collections.sort(arrayList, new C2087a());
            Collections.reverse(arrayList);
            arrayList2.add(arrayList.get(0));
            return arrayList2;
        }
        return arrayList;
    }

    /* compiled from: SelectSoftVersionFragment.java */
    /* renamed from: com.cnlaunch.x431pro.activity.diagnose.by$a */
    /* loaded from: classes.dex */
    public class C2087a implements Comparator {
        public C2087a() {
        }

        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return ((CarVersionInfo) obj).getVersion().compareTo(((CarVersionInfo) obj2).getVersion());
        }
    }

    /* renamed from: a */
    private void m7439a(String str, String str2, String str3) {
        if (str.equalsIgnoreCase("Demo") || str.equalsIgnoreCase(getString(R.string.DEMO_zh)) || str.equalsIgnoreCase("演示程序") || str.equalsIgnoreCase("演示程序(商用)") || "HD_DEMO".equals(this.f11697v)) {
            if (PreferencesManager.m9595a(this.mContext).m9583b("tryFlag", false) && !C1947h.f10551c) {
                PreferencesManager.m9595a(this.mContext).m9589a("diagStartTime", Long.valueOf(System.currentTimeMillis()).longValue());
                C1947h.f10552d = true;
            }
            this.f12357d.mo7094a(str2, str3);
            return;
        }
        this.f12357d.mo7088b(str2, str3);
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment
    /* renamed from: b */
    public final String mo7102b() {
        return getString(R.string.fragment_title_selectcarver);
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p222e.OnDelectDataListenter
    /* renamed from: b */
    public final void mo7079b(int i) {
        String string = getString(R.string.dialog_content_delthissoftfile);
        new C2106cd(this, i).m4609a(getActivity(), getString(R.string.dialog_title_default), String.format(string, "[" + this.f11694s + " - " + this.f11693r.get(i).getVersion() + "]"));
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public Object doInBackground(int i) throws C1425f {
        String str;
        if (i == 10007) {
            if (this.f11693r == null) {
                return Boolean.FALSE;
            }
            String upperCase = Locale.getDefault().getCountry().toUpperCase(Locale.getDefault());
            for (int i2 = 0; i2 < this.f11693r.size(); i2++) {
                String m4859b = this.f11675C.m4859b(this.f11698w, this.f11697v, this.f11693r.get(i2).getVersion());
                String str2 = m4859b + File.separator + "INI_" + upperCase;
                String str3 = null;
                if (upperCase.equalsIgnoreCase("CN") || upperCase.equalsIgnoreCase("ZH")) {
                    if (FileUtils.m5017a(str2)) {
                        str3 = FileUtils.m5004b(str2, LanChaset.m5100a(upperCase));
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append(m4859b);
                        sb.append(File.separator);
                        sb.append(upperCase.equalsIgnoreCase("CN") ? "INI_ZH" : "INI_CN");
                        str2 = sb.toString();
                        if (FileUtils.m5017a(str2)) {
                            str3 = FileUtils.m5004b(str2, LanChaset.m5100a(upperCase));
                        }
                    }
                } else if (upperCase.equalsIgnoreCase("JP") || upperCase.equalsIgnoreCase("JA")) {
                    if (FileUtils.m5017a(str2)) {
                        str3 = FileUtils.m5004b(str2, LanChaset.m5100a(upperCase));
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(m4859b);
                        sb2.append(File.separator);
                        sb2.append(upperCase.equalsIgnoreCase("JP") ? "INI_JA" : "INI_JP");
                        str2 = sb2.toString();
                        if (FileUtils.m5017a(str2)) {
                            str3 = FileUtils.m5004b(str2, LanChaset.m5100a(upperCase));
                        }
                    }
                } else if (upperCase.equalsIgnoreCase("HK") || upperCase.equalsIgnoreCase("TW")) {
                    if (FileUtils.m5017a(str2)) {
                        str3 = FileUtils.m5004b(str2, LanChaset.m5100a(upperCase));
                    } else {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(m4859b);
                        sb3.append(File.separator);
                        sb3.append(upperCase.equalsIgnoreCase("HK") ? "INI_TW" : "INI_HK");
                        str2 = sb3.toString();
                        if (FileUtils.m5017a(str2)) {
                            str3 = FileUtils.m5004b(str2, LanChaset.m5100a(upperCase));
                        }
                    }
                } else if (upperCase.equalsIgnoreCase("PT") || upperCase.equalsIgnoreCase("BR")) {
                    if (FileUtils.m5017a(str2)) {
                        str3 = FileUtils.m5004b(str2, LanChaset.m5100a(upperCase));
                    } else {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(m4859b);
                        sb4.append(File.separator);
                        sb4.append(upperCase.equalsIgnoreCase("BR") ? "INI_PT" : "INI_BR");
                        str2 = sb4.toString();
                        if (FileUtils.m5017a(str2)) {
                            str3 = FileUtils.m5004b(str2, LanChaset.m5100a(upperCase));
                        }
                    }
                } else if (upperCase.equalsIgnoreCase("AR") || upperCase.equalsIgnoreCase("EG") || upperCase.equalsIgnoreCase("ARABIC")) {
                    if (FileUtils.m5017a(str2)) {
                        str3 = FileUtils.m5004b(str2, LanChaset.m5100a(upperCase));
                    } else {
                        str2 = m4859b + File.separator + "INI_AR";
                        if (FileUtils.m5017a(str2)) {
                            str3 = FileUtils.m5004b(str2, LanChaset.m5100a(upperCase));
                        } else {
                            str2 = m4859b + File.separator + "INI_EG";
                            if (FileUtils.m5017a(str2)) {
                                str3 = FileUtils.m5004b(str2, LanChaset.m5100a(upperCase));
                            } else {
                                str2 = m4859b + File.separator + "INI_ARABIC";
                                if (FileUtils.m5017a(str2)) {
                                    str3 = FileUtils.m5004b(str2, LanChaset.m5100a(upperCase));
                                }
                            }
                        }
                    }
                } else if (upperCase.equalsIgnoreCase("DA") || upperCase.equalsIgnoreCase("DK")) {
                    if (FileUtils.m5017a(str2)) {
                        str3 = FileUtils.m5004b(str2, LanChaset.m5100a(upperCase));
                    } else {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(m4859b);
                        sb5.append(File.separator);
                        sb5.append(upperCase.equalsIgnoreCase("DA") ? "INI_DK" : "INI_DA");
                        str2 = sb5.toString();
                        if (FileUtils.m5017a(str2)) {
                            str3 = FileUtils.m5004b(str2, LanChaset.m5100a(upperCase));
                        }
                    }
                } else if (upperCase.equalsIgnoreCase("FA") || upperCase.equalsIgnoreCase("IR")) {
                    if (FileUtils.m5017a(str2)) {
                        str3 = FileUtils.m5004b(str2, LanChaset.m5100a(upperCase));
                    } else {
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append(m4859b);
                        sb6.append(File.separator);
                        sb6.append(upperCase.equalsIgnoreCase("FA") ? "INI_IR" : "INI_FA");
                        str2 = sb6.toString();
                        if (FileUtils.m5017a(str2)) {
                            str3 = FileUtils.m5004b(str2, LanChaset.m5100a(upperCase));
                        }
                    }
                } else if (upperCase.equalsIgnoreCase("KO") || upperCase.equalsIgnoreCase("KR") || upperCase.equalsIgnoreCase("KOREAN")) {
                    if (FileUtils.m5017a(str2)) {
                        str3 = FileUtils.m5004b(str2, LanChaset.m5100a(upperCase));
                    } else {
                        str2 = m4859b + File.separator + "INI_KO";
                        if (FileUtils.m5017a(str2)) {
                            str3 = FileUtils.m5004b(str2, LanChaset.m5100a(upperCase));
                        } else {
                            str2 = m4859b + File.separator + "INI_KR";
                            if (FileUtils.m5017a(str2)) {
                                str3 = FileUtils.m5004b(str2, LanChaset.m5100a(upperCase));
                            } else {
                                str2 = m4859b + File.separator + "INI_KOREAN";
                                if (FileUtils.m5017a(str2)) {
                                    str3 = FileUtils.m5004b(str2, LanChaset.m5100a(upperCase));
                                }
                            }
                        }
                    }
                } else if (upperCase.equalsIgnoreCase("SV") || upperCase.equalsIgnoreCase("SE")) {
                    if (FileUtils.m5017a(str2)) {
                        str3 = FileUtils.m5004b(str2, LanChaset.m5100a(upperCase));
                    } else {
                        StringBuilder sb7 = new StringBuilder();
                        sb7.append(m4859b);
                        sb7.append(File.separator);
                        sb7.append(upperCase.equalsIgnoreCase("SV") ? "INI_SE" : "INI_SV");
                        str2 = sb7.toString();
                        if (FileUtils.m5017a(str2)) {
                            str3 = FileUtils.m5004b(str2, LanChaset.m5100a(upperCase));
                        }
                    }
                } else if (upperCase.equalsIgnoreCase("CS") || upperCase.equalsIgnoreCase("CZ")) {
                    if (FileUtils.m5017a(str2)) {
                        str3 = FileUtils.m5004b(str2, LanChaset.m5100a(upperCase));
                    } else {
                        StringBuilder sb8 = new StringBuilder();
                        sb8.append(m4859b);
                        sb8.append(File.separator);
                        sb8.append(upperCase.equalsIgnoreCase("CS") ? "INI_CZ" : "INI_CS");
                        str2 = sb8.toString();
                        if (FileUtils.m5017a(str2)) {
                            str3 = FileUtils.m5004b(str2, LanChaset.m5100a(upperCase));
                        }
                    }
                } else if (upperCase.equalsIgnoreCase("SR") || upperCase.equalsIgnoreCase("RS")) {
                    if (FileUtils.m5017a(str2)) {
                        str3 = FileUtils.m5004b(str2, LanChaset.m5100a(upperCase));
                    } else {
                        StringBuilder sb9 = new StringBuilder();
                        sb9.append(m4859b);
                        sb9.append(File.separator);
                        sb9.append(upperCase.equalsIgnoreCase("SR") ? "INI_RS" : "INI_SR");
                        str2 = sb9.toString();
                        if (FileUtils.m5017a(str2)) {
                            str3 = FileUtils.m5004b(str2, LanChaset.m5100a(upperCase));
                        }
                    }
                } else if (upperCase.equalsIgnoreCase("GR") || upperCase.equalsIgnoreCase("EL")) {
                    if (FileUtils.m5017a(str2)) {
                        str3 = FileUtils.m5004b(str2, LanChaset.m5100a(upperCase));
                    } else {
                        StringBuilder sb10 = new StringBuilder();
                        sb10.append(m4859b);
                        sb10.append(File.separator);
                        sb10.append(upperCase.equalsIgnoreCase("GR") ? "INI_EL" : "INI_GR");
                        str2 = sb10.toString();
                        if (FileUtils.m5017a(str2)) {
                            str3 = FileUtils.m5004b(str2, LanChaset.m5100a(upperCase));
                        }
                    }
                } else if (FileUtils.m5017a(str2)) {
                    str3 = FileUtils.m5004b(str2, LanChaset.m5100a(upperCase));
                }
                if (str3 == null) {
                    NLog.m9451c("Sanda", "Error: null get Second lan");
                    String upperCase2 = Locale.getDefault().getLanguage().toUpperCase(Locale.getDefault());
                    str = m4859b + File.separator + "INI_" + upperCase2;
                    if (FileUtils.m5017a(str)) {
                        str3 = FileUtils.m5004b(str, LanChaset.m5100a(upperCase2));
                    }
                } else {
                    str = str2;
                }
                if (str3 == null) {
                    NLog.m9451c("Sanda", "Error: null");
                    str = m4859b + File.separator + "INI_EN";
                    str3 = FileUtils.m5017a(str) ? FileUtils.m5004b(str, "GB2312") : MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
                }
                NLog.m9452b("Sanda", "lan=" + upperCase + " filepath=" + str);
                String[] split = str3.split("\n");
                if (split.length > 1) {
                    this.f11693r.get(i2).setIniTitle(split[0]);
                    this.f11693r.get(i2).setIniText(str3.replace(split[0], "    "));
                } else {
                    this.f11693r.get(i2).setIniTitle(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                    this.f11693r.get(i2).setIniText(str3);
                }
            }
            return Boolean.TRUE;
        }
        return super.doInBackground(i);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onSuccess(int i, Object obj) {
        if (i == 10007) {
            if (((Boolean) obj).booleanValue()) {
                this.f11682K.obtainMessage(0).sendToTarget();
                return;
            }
            return;
        }
        super.onSuccess(i, obj);
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onDestroy() {
        this.mContext.unregisterReceiver(this.f11683L);
        super.onDestroy();
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.x431pro.activity.golo.p225b.OnGoloKeyDownListener
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.f12357d.mo7085f(0);
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* renamed from: d */
    private void m7433d(int i) {
        DiagnoseRunningInfo mo7083i = this.f12357d.mo7083i();
        mo7083i.setCarSoftName(this.f11694s);
        mo7083i.setSerialNum(this.f11698w);
        mo7083i.setSoftPackageid(this.f11697v);
        mo7083i.setSoftVersion(this.f11693r.get(i).getVersion());
        mo7083i.setAreaID(this.f11695t);
        mo7083i.setSoftLan(Locale.getDefault().getCountry());
        this.f12357d.mo7095a(mo7083i);
    }
}
