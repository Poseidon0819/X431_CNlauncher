package com.cnlaunch.x431pro.activity.golousa;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p130d.MD5Utils;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.p169im.IMActivity;
import com.cnlaunch.p169im.IMPresenter;
import com.cnlaunch.x431pro.activity.BaseFragment;
import com.cnlaunch.x431pro.p210a.CommonTools;
import com.cnlaunch.x431pro.p210a.LoginTools;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.utils.C2778n;
import com.cnlaunch.x431pro.utils.C2787z;
import com.ifoer.expedition.pro.R;
import java.io.File;
import org.apache.mina.proxy.handlers.http.ntlm.NTLMConstants;

/* renamed from: com.cnlaunch.x431pro.activity.golousa.a */
/* loaded from: classes.dex */
public class GoloUSAFragment extends BaseFragment implements View.OnClickListener {

    /* renamed from: n */
    private static boolean f12695n = false;

    /* renamed from: c */
    private RadioButton f12698c;

    /* renamed from: d */
    private RadioButton f12699d;

    /* renamed from: e */
    private TextView f12700e;

    /* renamed from: f */
    private PreferencesManager f12701f;

    /* renamed from: g */
    private ProgressDialog f12702g;

    /* renamed from: h */
    private ProgressBar f12703h;

    /* renamed from: i */
    private TextView f12704i;

    /* renamed from: j */
    private String f12705j;

    /* renamed from: k */
    private double f12706k;

    /* renamed from: l */
    private double f12707l;

    /* renamed from: m */
    private String f12708m;

    /* renamed from: b */
    private final String f12697b = GoloUSAFragment.class.getSimpleName();

    /* renamed from: a */
    BroadcastReceiver f12696a = new C2246b(this);

    /* renamed from: o */
    private final Handler f12709o = new HandlerC2247c(this);

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_golo_usa, viewGroup, false);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f12698c = (RadioButton) getActivity().findViewById(R.id.layout_business);
        this.f12698c.setOnClickListener(this);
        this.f12699d = (RadioButton) getActivity().findViewById(R.id.layout_friends);
        this.f12699d.setOnClickListener(this);
        if (!C2744aa.m5141j()) {
            getActivity().findViewById(R.id.container).setVisibility(8);
            getActivity().findViewById(R.id.dividerLine).setVisibility(8);
            this.f12699d.setText(getActivity().getResources().getString(R.string.my_friends));
        }
        this.f12700e = (TextView) getActivity().findViewById(R.id.friend_no_read);
        this.f12701f = PreferencesManager.m9595a(this.mContext);
        getActivity().registerReceiver(this.f12696a, new IntentFilter("refreshtip"));
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        m6948b();
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        getActivity().unregisterReceiver(this.f12696a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m6948b() {
        if (TextUtils.isEmpty(PreferencesManager.m9595a(this.mContext).m9584b("user_id", ""))) {
            return;
        }
        int m8794c = IMPresenter.m8804a(getActivity()).m8794c();
        if (m8794c > 0) {
            this.f12700e.setVisibility(0);
            this.f12700e.setText(String.valueOf(m8794c));
            return;
        }
        this.f12700e.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.layout_business) {
            if (!LoginTools.m7946a(this.mContext)) {
                NToast.m9450a(this.mContext, (int) R.string.login_tip);
                return;
            }
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.layout_sellerapp_install, (ViewGroup) null);
            this.f12702g = new ProgressDialog(this.mContext, R.style.DiagnoseProgressDialogTheme);
            this.f12702g.show();
            this.f12702g.setContentView(inflate);
            this.f12702g.setCancelable(false);
            this.f12702g.setOnKeyListener(new DialogInterface$OnKeyListenerC2248d(this));
            this.f12704i = (TextView) inflate.findViewById(R.id.tv_downlaod_sellerapp_ratio);
            this.f12703h = (ProgressBar) inflate.findViewById(R.id.downlaod_sellerapp_progress);
            boolean z = true;
            if (C2744aa.m5185a(this.mContext, C2744aa.m5138k(this.mContext))) {
                if (this.f12702g.isShowing()) {
                    this.f12702g.dismiss();
                }
                Intent intent = new Intent();
                intent.addFlags(NTLMConstants.FLAG_UNIDENTIFIED_11);
                intent.setComponent(new ComponentName(C2744aa.m5138k(this.mContext), "com.cnlaunch.golo3.activity.WelcomeActivity"));
                intent.setAction("android.intent.action.VIEW");
                String m9591a = PreferencesManager.m9595a(this.mContext).m9591a("login_username");
                String m9591a2 = PreferencesManager.m9595a(this.mContext).m9591a("login_password");
                MD5Utils.m9460a(m9591a2);
                Bundle bundle = new Bundle();
                bundle.putString("username", m9591a);
                bundle.putString("password", m9591a2);
                bundle.putBoolean("launch_from_pro", true);
                bundle.putString("packageName", C2744aa.m5171b(this.mContext));
                intent.putExtras(bundle);
                startActivity(intent);
                return;
            }
            String m9584b = PreferencesManager.m9595a(this.mContext).m9584b("golo_seller_app_path", "");
            z = (C2787z.m4821a(m9584b) || !new File(m9584b).exists()) ? false : false;
            if (z) {
                m6950a(m9584b);
            }
            if (z) {
                if (this.f12702g.isShowing()) {
                    this.f12702g.dismiss();
                    return;
                }
                return;
            }
            m6944c();
        } else if (id == R.id.layout_friends && CommonTools.m7969a(getActivity())) {
            IMPresenter.m8804a(getActivity()).m8791d(IMActivity.class.getName());
        }
    }

    /* renamed from: c */
    private void m6944c() {
        new Thread(new RunnableC2249e(this)).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6950a(String str) {
        if (C2787z.m4821a(str) || !new File(str).exists()) {
            m6944c();
            return;
        }
        String m9591a = PreferencesManager.m9595a(this.mContext).m9591a("login_username");
        String m9591a2 = PreferencesManager.m9595a(this.mContext).m9591a("login_password");
        MD5Utils.m9460a(m9591a2);
        Bundle bundle = new Bundle();
        bundle.putString("username", m9591a);
        bundle.putString("password", m9591a2);
        bundle.putBoolean("launch_from_pro", true);
        bundle.putString("packageName", C2744aa.m5171b(this.mContext));
        C2778n.m4915a(this.mContext, str, bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m6952a(GoloUSAFragment goloUSAFragment, int i) {
        Message message2 = new Message();
        message2.what = i;
        goloUSAFragment.f12709o.sendMessage(message2);
    }
}
