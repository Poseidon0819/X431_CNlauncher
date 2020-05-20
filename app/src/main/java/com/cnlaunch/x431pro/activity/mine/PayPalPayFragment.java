package com.cnlaunch.x431pro.activity.mine;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.x431pro.activity.BaseWebFragment;
import com.ifoer.expedition.pro.R;
import com.mopub.common.MoPubBrowser;

/* renamed from: com.cnlaunch.x431pro.activity.mine.bm */
/* loaded from: classes.dex */
public class PayPalPayFragment extends BaseWebFragment {

    /* renamed from: c */
    private String f13936c = "";

    @Override // com.cnlaunch.x431pro.activity.BaseWebFragment, com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setTitle(R.string.mine_pap_pal_pay);
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Bundle bundle = getBundle();
        if (bundle != null) {
            this.f13936c = bundle.getString(MoPubBrowser.DESTINATION_URL_KEY);
            NLog.m9456a("PayPalPayFragment", "URL: " + this.f13936c);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseWebFragment
    /* renamed from: a */
    public final void mo5836a(WebView webView) {
        webView.loadUrl(this.f13936c);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.x431pro.activity.golo.p225b.OnGoloKeyDownListener
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.f12969a.canGoBack()) {
            this.f12969a.goBack();
            return true;
        } else if (i == 4) {
            keyEvent.getAction();
            return false;
        } else {
            return false;
        }
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }
}
