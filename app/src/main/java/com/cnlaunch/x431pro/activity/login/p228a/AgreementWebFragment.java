package com.cnlaunch.x431pro.activity.login.p228a;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.p120d.p130d.p131a.Lang;
import com.cnlaunch.p120d.p130d.p131a.LangManager;
import com.cnlaunch.x431pro.activity.ActivityC2004c;
import com.cnlaunch.x431pro.activity.BaseWebFragment;
import com.cnlaunch.x431pro.utils.C2778n;
import com.cnlaunch.x431pro.utils.C2787z;
import com.ifoer.expedition.pro.R;

/* renamed from: com.cnlaunch.x431pro.activity.login.a.a */
/* loaded from: classes.dex */
public class AgreementWebFragment extends BaseWebFragment {

    /* renamed from: c */
    private String f13356c;

    /* renamed from: d */
    private String f13357d;

    /* renamed from: e */
    private boolean f13358e;

    /* renamed from: f */
    private String f13359f;

    @Override // com.cnlaunch.x431pro.activity.BaseWebFragment, com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Bundle bundle2 = getBundle();
        if (bundle2 != null) {
            this.f13356c = bundle2.getString("urlkey");
            this.f13357d = bundle2.getString("title");
            this.f13358e = bundle2.getBoolean("ifHideLogin");
        } else {
            this.f13356c = getArguments().getString("urlkey");
            this.f13357d = getArguments().getString("title");
            this.f13358e = getArguments().getBoolean("ifHideLogin");
        }
        String m9591a = PreferencesManager.m9595a(this.mContext).m9591a("agreement_cus");
        if (!TextUtils.isEmpty(m9591a) && "mkat".equals(m9591a)) {
            this.f13359f = "1001";
        } else if (LangManager.m9469a().equalsIgnoreCase("zh")) {
            if (LangManager.m9466b().equalsIgnoreCase("TW")) {
                this.f13359f = LangManager.m9467a(Lang.f7198G);
            } else if (LangManager.m9466b().equalsIgnoreCase("HK")) {
                this.f13359f = LangManager.m9467a(Lang.f7197F);
            } else {
                this.f13359f = LangManager.m9467a(Lang.f7199H);
            }
        } else {
            this.f13359f = LangManager.m9467a(LangManager.m9469a());
        }
        StringBuilder sb = new StringBuilder(this.f13356c);
        sb.append("?lanId=" + this.f13359f);
        if (!C2787z.m4821a(m9591a)) {
            sb.append("&cus=");
            sb.append(m9591a);
        }
        this.f13356c = sb.toString();
        Log.i("anqi", "rul==" + this.f13356c);
        super.onActivityCreated(bundle);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        setTitle(this.f13357d);
        if (this.f13358e) {
            ((ActivityC2004c) getActivity()).m7740c();
            ((ActivityC2004c) getActivity()).m7737d(8);
            ((ActivityC2004c) getActivity()).f10988x = false;
            ((ActivityC2004c) getActivity()).m7735e(8);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseWebFragment
    /* renamed from: a */
    public final void mo5836a(WebView webView) {
        if (!C2778n.m4917a(this.mContext)) {
            this.f12970b.obtainMessage(1).sendToTarget();
            NToast.m9450a(this.mContext, (int) R.string.common_network_unavailable);
            return;
        }
        webView.loadUrl(this.f13356c);
    }
}
