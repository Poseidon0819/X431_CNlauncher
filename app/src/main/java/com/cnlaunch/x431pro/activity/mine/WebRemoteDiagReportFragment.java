package com.cnlaunch.x431pro.activity.mine;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import com.cnlaunch.x431pro.activity.BaseWebFragment;
import com.cnlaunch.x431pro.p210a.FragmentKeyDownListener;

/* renamed from: com.cnlaunch.x431pro.activity.mine.dl */
/* loaded from: classes.dex */
public class WebRemoteDiagReportFragment extends BaseWebFragment implements FragmentKeyDownListener.InterfaceC1949a {

    /* renamed from: d */
    private String f14218d = "";

    /* renamed from: c */
    FragmentKeyDownListener f14217c = null;

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.f14217c = (FragmentKeyDownListener) activity;
        } catch (Exception unused) {
            this.f14217c = null;
        }
        Bundle bundle = getBundle();
        if (bundle != null) {
            this.f14218d = bundle.getString("urlkey");
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseWebFragment, com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        FragmentKeyDownListener fragmentKeyDownListener = this.f14217c;
        if (fragmentKeyDownListener != null) {
            fragmentKeyDownListener.mo6039a(this);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseWebFragment
    /* renamed from: a */
    public final void mo5836a(WebView webView) {
        webView.loadUrl(this.f14218d);
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        FragmentKeyDownListener fragmentKeyDownListener = this.f14217c;
        if (fragmentKeyDownListener != null) {
            fragmentKeyDownListener.mo6039a(null);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.x431pro.activity.golo.p225b.OnGoloKeyDownListener
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.f12969a.canGoBack()) {
            this.f12969a.goBack();
            return true;
        }
        return false;
    }
}
