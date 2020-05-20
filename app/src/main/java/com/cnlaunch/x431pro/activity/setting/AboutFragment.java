package com.cnlaunch.x431pro.activity.setting;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.activity.BaseFragment;
import com.cnlaunch.x431pro.activity.GDApplication;
import com.cnlaunch.x431pro.activity.login.p228a.AgreementWebFragment;
import com.cnlaunch.x431pro.activity.upgrade.p240c.ApkUpgradeAndDownloadLogic;
import com.cnlaunch.x431pro.module.config.ConfigDBManager;
import com.cnlaunch.x431pro.module.p269j.p271b.LatestApkVersionInfo;
import com.cnlaunch.x431pro.utils.ApkUpgradeUtils;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.utils.C2778n;
import com.cnlaunch.x431pro.utils.C2787z;
import com.cnlaunch.x431pro.utils.PathUtils;
import com.cnlaunch.x431pro.widget.p290a.InputIccidDialog;
import com.cnlaunch.x431pro.widget.p290a.MessageDialog;
import com.cnlaunch.x431pro.widget.p290a.View$OnClickListenerC2842bz;
import com.google.gson.Gson;
import com.ifoer.expedition.pro.R;
import java.io.File;
import java.util.Locale;
import org.vudroid.pdfdroid.PDFManager;

/* renamed from: com.cnlaunch.x431pro.activity.setting.a */
/* loaded from: classes.dex */
public class AboutFragment extends BaseFragment implements View.OnClickListener {

    /* renamed from: a */
    protected ConfigDBManager f14490a;

    /* renamed from: b */
    private RelativeLayout f14491b;

    /* renamed from: c */
    private RelativeLayout f14492c;

    /* renamed from: d */
    private RelativeLayout f14493d;

    /* renamed from: e */
    private RelativeLayout f14494e;

    /* renamed from: f */
    private RelativeLayout f14495f;

    /* renamed from: g */
    private LinearLayout f14496g;

    /* renamed from: h */
    private TextView f14497h;

    /* renamed from: i */
    private TextView f14498i;

    /* renamed from: j */
    private TextView f14499j;

    /* renamed from: k */
    private TextView f14500k;

    /* renamed from: l */
    private String f14501l;

    /* renamed from: m */
    private String f14502m;

    /* renamed from: n */
    private String f14503n;

    /* renamed from: o */
    private PackageInfo f14504o;

    /* renamed from: p */
    private MessageDialog f14505p;

    /* renamed from: q */
    private MessageDialog f14506q;

    /* renamed from: r */
    private ImageView f14507r;

    /* renamed from: s */
    private int f14508s;

    /* renamed from: t */
    private RelativeLayout f14509t;

    /* renamed from: u */
    private RelativeLayout f14510u;

    /* renamed from: v */
    private boolean f14511v;

    /* renamed from: w */
    private ApkUpgradeUtils f14512w;

    /* renamed from: x */
    private Handler f14513x = new HandlerC2541b(this);

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        LatestApkVersionInfo latestApkVersionInfo;
        super.onActivityCreated(bundle);
        setTitle(R.string.setting_about_txt);
        setLeftImage(this.mContext.getResources().getDrawable(R.drawable.select_btn_menu_two));
        this.f14491b = (RelativeLayout) getActivity().findViewById(R.id.rl_about_version);
        this.f14491b.setOnClickListener(this);
        this.f14493d = (RelativeLayout) getActivity().findViewById(R.id.rl_about_statment);
        this.f14493d.setOnClickListener(this);
        this.f14494e = (RelativeLayout) getActivity().findViewById(R.id.rl_about_guide);
        this.f14494e.setOnClickListener(this);
        this.f14495f = (RelativeLayout) getActivity().findViewById(R.id.rl_about_agreement);
        this.f14495f.setOnClickListener(this);
        if (Locale.getDefault().getLanguage().equalsIgnoreCase("ja")) {
            this.f14495f.setVisibility(0);
        } else {
            this.f14494e.setVisibility(8);
            this.f14495f.setVisibility(8);
        }
        this.f14507r = (ImageView) getActivity().findViewById(R.id.img_set_about);
        this.f14507r.setOnClickListener(this);
        this.f14497h = (TextView) getActivity().findViewById(R.id.tv_set_about_headtext);
        this.f14502m = getResources().getString(R.string.app_name);
        this.f14503n = getResources().getString(R.string.statement_content_txt);
        try {
            this.f14504o = getActivity().getPackageManager().getPackageInfo(getActivity().getPackageName(), 0);
            this.f14501l = this.f14504o.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        PreferencesManager.m9595a(this.mContext).m9591a("productType");
        TextView textView = this.f14497h;
        textView.setText(this.f14502m + " V" + this.f14501l);
        this.f14505p = new MessageDialog(getActivity());
        this.f14506q = new MessageDialog(getActivity());
        this.f14509t = (RelativeLayout) this.mContentView.findViewById(R.id.rl_argeement);
        this.f14509t.setOnClickListener(this);
        this.f14510u = (RelativeLayout) this.mContentView.findViewById(R.id.rl_privacy);
        this.f14510u.setOnClickListener(this);
        this.f14498i = (TextView) this.mContentView.findViewById(R.id.latest_version_no);
        this.f14492c = (RelativeLayout) this.mContentView.findViewById(R.id.rl_updated);
        this.f14496g = (LinearLayout) this.mContentView.findViewById(R.id.rl_auto_download);
        this.f14499j = (TextView) this.mContentView.findViewById(R.id.auto_download_value);
        this.f14500k = (TextView) this.mContentView.findViewById(R.id.update_tip);
        this.f14492c.setOnClickListener(this);
        this.f14496g.setOnClickListener(this);
        if (TextUtils.isEmpty(PreferencesManager.m9595a(this.mContext).m9591a("apk_soft_name"))) {
            this.f14496g.setVisibility(8);
            this.f14492c.setVisibility(8);
        } else {
            this.f14496g.setVisibility(0);
            this.f14492c.setVisibility(0);
        }
        this.f14512w = ApkUpgradeUtils.m5111a(this.mContext);
        this.f14512w.f15718c = this.f14513x;
        this.f14511v = PreferencesManager.m9595a(this.mContext).m9583b("has_new_apk_version", false);
        NLog.m9456a("yhx", "aboutFragment.isHasNewVersion=" + this.f14511v);
        if (this.f14511v) {
            this.f14500k.setVisibility(0);
            String m9591a = PreferencesManager.m9595a(this.mContext).m9591a("apk_soft_info");
            if (TextUtils.isEmpty(m9591a) || (latestApkVersionInfo = (LatestApkVersionInfo) new Gson().fromJson(m9591a, (Class<Object>) LatestApkVersionInfo.class)) == null || TextUtils.isEmpty(latestApkVersionInfo.getVersionNo())) {
                return;
            }
            ApkUpgradeAndDownloadLogic.m5636a(this.mContext);
            boolean m5627b = ApkUpgradeAndDownloadLogic.m5627b(latestApkVersionInfo.getVersionDetailId());
            NLog.m9456a("yhx", "aboutFragment.isApkDownloading=".concat(String.valueOf(m5627b)));
            if (!C2778n.m4917a(this.mContext) || m5627b) {
                return;
            }
            this.f14512w.m5108a(true);
            return;
        }
        this.f14500k.setVisibility(8);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.setting_about_info, viewGroup, false);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        if (PreferencesManager.m9595a(this.mContext).m9585b("auto_download_select", 0) == 0) {
            this.f14499j.setText(R.string.auto_wifi_download);
        } else {
            this.f14499j.setText(R.string.close_auto_download);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LatestApkVersionInfo latestApkVersionInfo;
        int id = view.getId();
        boolean z = false;
        if (id == R.id.img_set_about) {
            if (C2744aa.m5126q(this.mContext) || GDApplication.m7911a()) {
                if (C2744aa.m5119u()) {
                    this.f14508s++;
                } else {
                    this.f14508s = 0;
                }
                if (this.f14508s >= 2) {
                    this.f14508s = 0;
                    InputIccidDialog inputIccidDialog = new InputIccidDialog(this.mContext);
                    inputIccidDialog.m4713f(2);
                    inputIccidDialog.show();
                }
            }
        } else if (id == R.id.rl_privacy) {
            m6034a(1);
        } else if (id == R.id.rl_updated) {
            if (C2778n.m4917a(this.mContext)) {
                if (this.f14511v) {
                    String m9591a = PreferencesManager.m9595a(this.mContext).m9591a("apk_soft_info");
                    if (!TextUtils.isEmpty(m9591a) && (latestApkVersionInfo = (LatestApkVersionInfo) new Gson().fromJson(m9591a, (Class<Object>) LatestApkVersionInfo.class)) != null && !TextUtils.isEmpty(latestApkVersionInfo.getVersionNo())) {
                        ApkUpgradeAndDownloadLogic.m5636a(this.mContext);
                        z = ApkUpgradeAndDownloadLogic.m5627b(latestApkVersionInfo.getVersionDetailId());
                    }
                    if (!z) {
                        this.f14512w.m5108a(true);
                        return;
                    } else {
                        NToast.m9450a(this.mContext, (int) R.string.downloading_the_apk);
                        return;
                    }
                }
                NToast.m9450a(this.mContext, (int) R.string.is_the_latest_apk);
                return;
            }
            NToast.m9450a(this.mContext, (int) R.string.common_network_unavailable);
        } else {
            switch (id) {
                case R.id.rl_about_agreement /* 2131297758 */:
                    try {
                        String m6032a = m6032a("agreenment_ja.pdf");
                        if (m6032a.equals("")) {
                            return;
                        }
                        PDFManager.open(getActivity().getApplicationContext(), m6032a);
                        return;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return;
                    }
                case R.id.rl_about_guide /* 2131297759 */:
                    try {
                        String m6032a2 = m6032a("user_guide_ja.pdf");
                        if (m6032a2.equals("")) {
                            return;
                        }
                        PDFManager.open(getActivity().getApplicationContext(), m6032a2);
                        return;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return;
                    }
                case R.id.rl_about_statment /* 2131297760 */:
                    this.f14502m = getResources().getString(R.string.app_name);
                    this.f14503n = getResources().getString(R.string.statement_content_txt);
                    if (this.f14506q == null) {
                        this.f14506q = new MessageDialog(getActivity());
                    }
                    this.f14506q.setTitle(R.string.statement_title_txt);
                    this.f14506q.m4715c(String.format(this.f14503n, this.f14502m));
                    this.f14506q.m4719a(R.string.statement_btn_txt, true, null);
                    this.f14506q.m4709j();
                    this.f14506q.show();
                    return;
                case R.id.rl_about_version /* 2131297761 */:
                    if (this.f14505p == null) {
                        this.f14505p = new MessageDialog(getActivity());
                    }
                    this.f14505p.setTitle(R.string.version_imformation);
                    this.f14505p.m4715c(getActivity().getResources().getString(R.string.now_ver_is) + " V" + this.f14501l);
                    this.f14505p.m4719a(17039370, true, null);
                    this.f14505p.m4709j();
                    this.f14505p.show();
                    return;
                case R.id.rl_argeement /* 2131297762 */:
                    m6034a(0);
                    return;
                case R.id.rl_auto_download /* 2131297763 */:
                    DialogC2557c dialogC2557c = new DialogC2557c(this, this.mContext);
                    dialogC2557c.m4719a(R.string.btn_confirm, true, new View$OnClickListenerC2842bz(dialogC2557c));
                    dialogC2557c.setCanceledOnTouchOutside(false);
                    dialogC2557c.show();
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: a */
    private void m6034a(int i) {
        String string;
        if (C2744aa.m5119u()) {
            return;
        }
        if (this.f14490a == null) {
            this.f14490a = ConfigDBManager.m5398a(this.mContext);
        }
        String str = "";
        String m9591a = PreferencesManager.m9595a(this.mContext).m9591a("agreement_cus");
        if (i == 0) {
            try {
                if (!TextUtils.isEmpty(m9591a) && "mkat".equals(m9591a)) {
                    str = this.f14490a.m5396a("agreement_all");
                } else if (C2744aa.m5160d()) {
                    str = this.f14490a.m5396a("agreement_eu");
                } else if (C2744aa.m5144h(this.mContext)) {
                    str = this.f14490a.m5396a("agreement_cn");
                } else {
                    str = this.f14490a.m5396a("agreement_all");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (C2787z.m4821a(str)) {
                str = "https://cnzdmycar.x431.com/static/agree/agreemen.html";
            }
            string = getString(R.string.service_agreement);
        } else {
            try {
                if (!TextUtils.isEmpty(m9591a) && "mkat".equals(m9591a)) {
                    str = this.f14490a.m5396a("privacy_policy_all");
                } else if (C2744aa.m5160d()) {
                    str = this.f14490a.m5396a("privacy_policy_eu");
                } else if (C2744aa.m5144h(this.mContext)) {
                    str = this.f14490a.m5396a("privacy_policy_cn");
                } else {
                    str = this.f14490a.m5396a("privacy_policy_all");
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (C2787z.m4821a(str)) {
                str = "https://cnzdmycar.x431.com/static/agree/privacy_policy.html";
            }
            string = getString(R.string.privacy_policy);
        }
        Bundle bundle = new Bundle();
        bundle.putString("title", string);
        bundle.putString("urlkey", str);
        replaceFragment(AgreementWebFragment.class.getName(), bundle);
    }

    /* renamed from: a */
    private String m6032a(String str) {
        String str2 = PathUtils.m4870a(getActivity()) + str;
        return new File(str2).exists() ? str2 : "";
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        MessageDialog messageDialog = this.f14505p;
        if (messageDialog != null) {
            messageDialog.dismiss();
        }
        MessageDialog messageDialog2 = this.f14506q;
        if (messageDialog2 != null) {
            messageDialog2.dismiss();
        }
    }
}
