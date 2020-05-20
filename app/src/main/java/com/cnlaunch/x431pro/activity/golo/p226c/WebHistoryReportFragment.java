package com.cnlaunch.x431pro.activity.golo.p226c;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import com.cnlaunch.x431pro.activity.BaseWebFragment;
import com.cnlaunch.x431pro.activity.golo.p225b.OnGoloKeyDownListener;
import com.cnlaunch.x431pro.activity.golo.p225b.onGoloDataListenter;

/* renamed from: com.cnlaunch.x431pro.activity.golo.c.a */
/* loaded from: classes.dex */
public final class WebHistoryReportFragment extends BaseWebFragment implements OnGoloKeyDownListener {

    /* renamed from: c */
    private String f12572c = "";

    /* renamed from: d */
    private int f12573d = -1;

    /* renamed from: e */
    private onGoloDataListenter f12574e = null;

    @Override // android.app.Fragment
    public final void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.f12574e = (onGoloDataListenter) activity;
        } catch (Exception unused) {
            this.f12574e = null;
        }
        Bundle bundle = getBundle();
        if (bundle != null) {
            this.f12572c = bundle.getString("urlkey");
            this.f12573d = bundle.getInt("flag", -1);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseWebFragment, com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // android.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.x431pro.activity.golo.p225b.OnGoloKeyDownListener
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (!this.f12969a.canGoBack()) {
                return this.f12574e != null;
            }
            this.f12969a.goBack();
            return true;
        }
        return false;
    }

    @Override // com.cnlaunch.x431pro.activity.BaseWebFragment
    /* renamed from: a */
    public final void mo5836a(WebView webView) {
        webView.loadUrl(this.f12572c);
    }
}
