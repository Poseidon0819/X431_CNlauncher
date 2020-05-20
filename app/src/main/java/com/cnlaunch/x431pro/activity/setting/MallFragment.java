package com.cnlaunch.x431pro.activity.setting;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.webkit.WebView;
import com.cnlaunch.x431pro.activity.BaseWebFragment;
import com.cnlaunch.x431pro.p210a.FragmentKeyDownListener;
import com.cnlaunch.x431pro.utils.C2744aa;

/* renamed from: com.cnlaunch.x431pro.activity.setting.y */
/* loaded from: classes.dex */
public class MallFragment extends BaseWebFragment implements FragmentKeyDownListener.InterfaceC1949a {

    /* renamed from: c */
    private String f14926c;

    @Override // com.cnlaunch.x431pro.activity.BaseWebFragment, com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (getActivity() instanceof FragmentKeyDownListener) {
            ((FragmentKeyDownListener) getActivity()).mo6039a(this);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseWebFragment
    /* renamed from: a */
    public final void mo5836a(WebView webView) {
        this.f14926c = C2744aa.m5118u(this.mContext);
        webView.loadUrl(this.f14926c);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        if (TextUtils.isEmpty(this.f14926c) || this.f14926c.equals(C2744aa.m5118u(this.mContext))) {
            return;
        }
        mo5836a(this.f12969a);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.x431pro.activity.golo.p225b.OnGoloKeyDownListener
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 0) {
            if (this.f12969a.canGoBack()) {
                this.f12969a.goBack();
                return true;
            }
            return false;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
