package com.cnlaunch.x431pro.widget.p290a;

import android.content.Context;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.p120d.p121a.KeyConstant;
import com.cnlaunch.p120d.p121a.LruCacheManager;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p125c.p126a.AsyncTaskManager;
import com.cnlaunch.p120d.p125c.p126a.OnDataListener;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.p120d.p130d.p131a.Lang;
import com.cnlaunch.p120d.p130d.p131a.LangManager;
import com.cnlaunch.x431pro.activity.diagnose.DiagnoseActivity;
import com.cnlaunch.x431pro.activity.upgrade.AdapterClickListenter;
import com.cnlaunch.x431pro.activity.upgrade.p238a.DivisionSoftAdapter;
import com.cnlaunch.x431pro.module.config.ConfigDBManager;
import com.cnlaunch.x431pro.module.p269j.p270a.UpgradeAction;
import com.cnlaunch.x431pro.module.p269j.p271b.DivisionSoftDto;
import com.cnlaunch.x431pro.module.p269j.p271b.DownloadSoftDto;
import com.cnlaunch.x431pro.module.p269j.p271b.LatestDivisionSoftsResponse;
import com.cnlaunch.x431pro.utils.C2787z;
import com.cnlaunch.x431pro.utils.PathUtils;
import com.cnlaunch.x431pro.utils.p282d.DiagnoseUtils;
import com.cnlaunch.x431pro.utils.p285e.FileUtils;
import com.cnlaunch.x431pro.widget.button.IconButton;
import com.ifoer.expedition.pro.R;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: DivisionSoftUpgradeTipDialog.java */
/* renamed from: com.cnlaunch.x431pro.widget.a.z */
/* loaded from: classes.dex */
public final class View$OnClickListenerC2884z extends BaseDialog implements View.OnClickListener, OnDataListener {

    /* renamed from: a */
    public String f16470a;

    /* renamed from: b */
    private Context f16471b;

    /* renamed from: c */
    private ListView f16472c;

    /* renamed from: g */
    private TextView f16473g;

    /* renamed from: h */
    private LinearLayout f16474h;

    /* renamed from: i */
    private DivisionSoftAdapter f16475i;

    /* renamed from: j */
    private AsyncTaskManager f16476j;

    /* renamed from: k */
    private String f16477k;

    /* renamed from: l */
    private String f16478l;

    /* renamed from: m */
    private String f16479m;

    /* renamed from: n */
    private PreferencesManager f16480n;

    /* renamed from: o */
    private List<DivisionSoftDto> f16481o;

    /* renamed from: p */
    private IconButton f16482p;

    /* renamed from: q */
    private IconButton f16483q;

    /* renamed from: r */
    private List<String> f16484r;

    /* renamed from: s */
    private String f16485s;

    /* renamed from: t */
    private LinearLayout f16486t;

    /* renamed from: u */
    private boolean f16487u;

    /* renamed from: v */
    private AdapterClickListenter f16488v;

    public View$OnClickListenerC2884z(Context context, String str, String str2, List<String> list) {
        super(context);
        this.f16487u = false;
        this.f16470a = "";
        this.f16488v = new C2806ac(this);
        this.f16471b = context;
        setTitle(R.string.division_soft_upgrade_title);
        this.f16479m = str;
        this.f16484r = list;
        this.f16485s = str2;
        this.f16487u = DiagnoseUtils.m5086a().m5075g().getDiagnoseStatue() == 1;
        NLog.m9456a("yhx", "softIdList=" + list + ",serialNo=" + str + ",softPackageId=" + str2);
        int integer = this.f16471b.getResources().getInteger(R.integer.bluetoothlist_width_size);
        int integer2 = this.f16471b.getResources().getInteger(R.integer.bluetoothlist_height_size);
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.flags = 2;
        attributes.dimAmount = 0.4f;
        window.setLayout((window.getWindowManager().getDefaultDisplay().getWidth() * integer) / 100, (window.getWindowManager().getDefaultDisplay().getHeight() * integer2) / 100);
        setCancelable(false);
        ((DiagnoseActivity) context).f11025O = this;
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.BaseDialog
    /* renamed from: a */
    public final View mo4517a() {
        View inflate = LayoutInflater.from(this.f16471b).inflate(R.layout.divisions_upgrade, (ViewGroup) null);
        this.f16472c = (ListView) inflate.findViewById(R.id.division_soft_list);
        this.f16472c.setOnItemClickListener(new DivisionSoftUpgradeTipDialog(this));
        this.f16482p = (IconButton) inflate.findViewById(R.id.checkBox_select_all);
        this.f16483q = (IconButton) inflate.findViewById(R.id.button_update);
        this.f16482p.setOnClickListener(this);
        this.f16483q.setOnClickListener(this);
        this.f16473g = (TextView) inflate.findViewById(R.id.failed_tip);
        this.f16474h = (LinearLayout) inflate.findViewById(R.id.lin_failed_info);
        this.f16474h.setVisibility(8);
        this.f16486t = (LinearLayout) inflate.findViewById(R.id.linear_button_bottom);
        m4712g();
        this.f16475i = new DivisionSoftAdapter(this.f16471b, this.f16488v);
        this.f16476j = AsyncTaskManager.m9574a(this.f16471b);
        this.f16480n = PreferencesManager.m9595a(this.f16471b);
        if (this.f16487u) {
            this.f16486t.setVisibility(8);
            this.f16472c.setVisibility(8);
            this.f16474h.setVisibility(0);
            this.f16473g.setText(R.string.retmote_get_division_info_notice);
            m4711h();
            m4719a(R.string.common_confirm, true, new View$OnClickListenerC2805ab(this));
        } else {
            this.f16476j.m9575a(100001, true, this);
        }
        return inflate;
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.BaseDialog, android.view.View.OnClickListener
    public final void onClick(View view) {
        super.onClick(view);
        boolean z = true;
        NLog.m9456a("yhx", "onClick enter.id=" + view.getId());
        int id = view.getId();
        if (id == R.id.button_update) {
            ArrayList arrayList = new ArrayList();
            List<DivisionSoftDto> list = this.f16481o;
            if (list != null && !list.isEmpty()) {
                for (DivisionSoftDto divisionSoftDto : this.f16481o) {
                    if (divisionSoftDto.isChecked()) {
                        arrayList.add(divisionSoftDto);
                        z = false;
                    }
                }
            }
            if (z) {
                NToast.m9450a(this.f16471b, (int) R.string.common_unselect_any);
                return;
            }
            LruCacheManager.m9599a().m9596a("downloadList", m4515a(arrayList));
            new DivisionSoftDownloadDialog(this.f16471b).show();
            dismiss();
        } else if (id == R.id.checkBox_select_all) {
            NLog.m9456a("yhx", "selectAllBtn onClick enter.");
            if (this.f16471b.getString(R.string.common_unselect).equals(this.f16482p.getText().toString())) {
                this.f16482p.setText(R.string.common_select);
                z = false;
            } else {
                this.f16482p.setText(R.string.common_unselect);
            }
            this.f16482p.setChecked(z);
            List<DivisionSoftDto> list2 = this.f16481o;
            if (list2 == null || list2.isEmpty()) {
                return;
            }
            for (DivisionSoftDto divisionSoftDto2 : this.f16481o) {
                if (!divisionSoftDto2.isMust()) {
                    divisionSoftDto2.setChecked(z);
                }
            }
            this.f16475i.notifyDataSetChanged();
        }
    }

    /* renamed from: a */
    private List<DownloadSoftDto> m4515a(List<DivisionSoftDto> list) {
        ArrayList arrayList = new ArrayList();
        if (list.size() > 0) {
            for (DivisionSoftDto divisionSoftDto : list) {
                if (divisionSoftDto.getState().intValue() != 4 && divisionSoftDto.isChecked()) {
                    DownloadSoftDto downloadSoftDto = new DownloadSoftDto();
                    downloadSoftDto.f15575a = divisionSoftDto.getSpfNameDesc();
                    downloadSoftDto.f15576b = "V" + divisionSoftDto.getvNum();
                    downloadSoftDto.f15580f = divisionSoftDto.getFileName();
                    downloadSoftDto.f15578d = divisionSoftDto.getProgress();
                    downloadSoftDto.f15579e = divisionSoftDto.getState();
                    downloadSoftDto.f15577c = divisionSoftDto.getType();
                    downloadSoftDto.f15581g = divisionSoftDto.getSpfId();
                    downloadSoftDto.f15583i = divisionSoftDto.getUrl();
                    downloadSoftDto.f15582h = divisionSoftDto.getFileSize();
                    downloadSoftDto.f15584j = divisionSoftDto.getSoftSubPackKey();
                    downloadSoftDto.f15586l = divisionSoftDto.getSoftPackageId();
                    downloadSoftDto.f15588n = divisionSoftDto.isMust();
                    downloadSoftDto.f15585k = this.f16470a;
                    arrayList.add(downloadSoftDto);
                }
            }
        }
        return arrayList;
    }

    @Override // com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public final void onSuccess(int i, Object obj) {
        if (i == 100001 && obj != null) {
            LatestDivisionSoftsResponse latestDivisionSoftsResponse = (LatestDivisionSoftsResponse) obj;
            if (latestDivisionSoftsResponse.isSuccess()) {
                List<DivisionSoftDto> diagSoftSubPackList = latestDivisionSoftsResponse.getDiagSoftSubPackList();
                if (diagSoftSubPackList != null && diagSoftSubPackList.size() > 0) {
                    String str = "";
                    try {
                        str = ConfigDBManager.m5398a(this.f16471b).m5396a(KeyConstant.f6917cK);
                    } catch (C1425f e) {
                        e.printStackTrace();
                    }
                    if (TextUtils.isEmpty(str)) {
                        str = "https://dlcenter.x431.com/diag/dlDiagSoftPack.action";
                    }
                    List<String> list = this.f16484r;
                    if (list != null && !list.isEmpty()) {
                        this.f16481o = new ArrayList();
                        for (DivisionSoftDto divisionSoftDto : diagSoftSubPackList) {
                            for (String str2 : this.f16484r) {
                                if (!TextUtils.isEmpty(divisionSoftDto.getSoftSubPackKey()) && divisionSoftDto.getSoftSubPackKey().equals(str2)) {
                                    String str3 = PathUtils.m4868a(this.f16471b, this.f16479m, divisionSoftDto.getSoftPackageId()) + File.separator + "Division.ini";
                                    String softSubPackKey = divisionSoftDto.getSoftSubPackKey();
                                    NLog.m9456a("yhx", "getDivisionSoftVersion enter,softPackageId=" + softSubPackKey + ",iniFileName=" + str3);
                                    String m4997e = FileUtils.m4997e(str3, softSubPackKey);
                                    if (!TextUtils.isEmpty(m4997e) && m4997e.compareToIgnoreCase("V00.00") == 0) {
                                        m4997e = "";
                                    }
                                    NLog.m9456a("yhx", "getDivisionSoftVersion exit,version=".concat(String.valueOf(m4997e)));
                                    divisionSoftDto.setMaxOldVersion(m4997e);
                                    divisionSoftDto.setMust(true);
                                    if (C2787z.m4820a(divisionSoftDto.getvNum(), m4997e)) {
                                        divisionSoftDto.setChecked(true);
                                    }
                                    divisionSoftDto.setType(4);
                                    divisionSoftDto.setUrl(str);
                                    this.f16481o.add(divisionSoftDto);
                                }
                            }
                        }
                    }
                }
                NLog.m9456a("yhx", "divisionSoftDtoList=" + this.f16481o);
                List<DivisionSoftDto> list2 = this.f16481o;
                if (list2 != null) {
                    synchronized (list2) {
                        Collections.sort(this.f16481o, new C2808ae(this));
                        Collections.sort(this.f16481o, new C2809af(this));
                    }
                }
                this.f16472c.setVisibility(0);
                this.f16474h.setVisibility(8);
                this.f16472c.setAdapter((ListAdapter) this.f16475i);
                this.f16475i.m5813a(this.f16481o);
                return;
            }
            this.f16486t.setVisibility(8);
            this.f16472c.setVisibility(8);
            this.f16474h.setVisibility(0);
            TextView textView = this.f16473g;
            int code = latestDivisionSoftsResponse.getCode();
            String string = this.f16471b.getString(R.string.get_division_info_failed);
            if (code == 1004021) {
                string = this.f16471b.getString(R.string.get_division_info_not_matched);
            }
            textView.setText(string);
            m4711h();
            m4719a(R.string.common_confirm, true, new View$OnClickListenerC2807ad(this));
        }
    }

    @Override // com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public final void onFailure(int i, int i2, Object obj) {
        this.f16486t.setVisibility(8);
        this.f16472c.setVisibility(8);
        this.f16474h.setVisibility(0);
        this.f16473g.setText(R.string.get_division_info_failed);
        m4711h();
        m4719a(R.string.common_confirm, true, new View$OnClickListenerC2810ag(this));
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 0) {
            if (!this.f16487u) {
                ((DiagnoseActivity) this.f16471b).mo7089a(DiagnoseConstants.FEEDBACK_SPT_TRANS_DIAG_INFO_EX, new byte[]{0, 0, 1, 1});
            }
            dismiss();
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public final Object doInBackground(int i) throws C1425f {
        if (i != 100001) {
            return null;
        }
        if (!TextUtils.isEmpty(this.f16485s) && this.f16485s.toUpperCase().contains("RESET") && !TextUtils.isEmpty(this.f16470a)) {
            this.f16477k = LangManager.m9467a(this.f16470a);
            this.f16478l = LangManager.m9467a(Lang.f7203a);
        } else if (LangManager.m9469a().equalsIgnoreCase("zh")) {
            if (LangManager.m9466b().equalsIgnoreCase("TW")) {
                this.f16477k = LangManager.m9467a(Lang.f7198G);
                this.f16478l = LangManager.m9467a(Lang.f7203a);
            } else if (LangManager.m9466b().equalsIgnoreCase("HK")) {
                this.f16477k = LangManager.m9467a(Lang.f7197F);
                this.f16478l = LangManager.m9467a(Lang.f7203a);
            } else {
                this.f16477k = LangManager.m9467a(Lang.f7199H);
                this.f16478l = this.f16477k;
            }
        } else {
            this.f16477k = LangManager.m9467a(LangManager.m9469a());
            this.f16478l = LangManager.m9467a(Lang.f7203a);
        }
        return new UpgradeAction(this.f16471b).m5276c(this.f16479m, this.f16485s, this.f16477k, this.f16478l);
    }
}
