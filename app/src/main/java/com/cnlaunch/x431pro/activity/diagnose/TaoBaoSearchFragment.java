package com.cnlaunch.x431pro.activity.diagnose;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import com.cnlaunch.x431pro.activity.BaseWebFragment;
import com.cnlaunch.x431pro.activity.diagnose.p222e.IFragmentCallback;
import com.cnlaunch.x431pro.activity.diagnose.p222e.OnKeyDownListenter;
import com.ifoer.expedition.pro.R;
import java.util.List;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

/* renamed from: com.cnlaunch.x431pro.activity.diagnose.ch */
/* loaded from: classes.dex */
public final class TaoBaoSearchFragment extends BaseWebFragment implements OnKeyDownListenter {

    /* renamed from: e */
    private List<String> f11839e;

    /* renamed from: c */
    private IFragmentCallback f11837c = null;

    /* renamed from: d */
    private String f11838d = "";

    /* renamed from: f */
    private String f11840f = "https://s.taobao.com/search?q=%s";

    @Override // com.cnlaunch.x431pro.activity.diagnose.p222e.OnKeyDownListenter
    /* renamed from: i_ */
    public final void mo6838i_() {
    }

    @Override // android.app.Fragment
    public final void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.f11837c = (IFragmentCallback) activity;
            Bundle bundle = getBundle();
            StringBuilder sb = new StringBuilder();
            if (bundle != null) {
                this.f11839e = bundle.getStringArrayList("taobaoKey");
                List<String> list = this.f11839e;
                if (list != null) {
                    for (String str : list) {
                        sb.append(str);
                        sb.append("  ");
                    }
                    this.f11838d = sb.toString().replaceAll("\\(|\\)|（|）", MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                }
            }
        } catch (ClassCastException unused) {
            throw new ClassCastException(activity.toString() + " must implement FragmentCallback.OnMenuOnClickListener");
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseWebFragment, com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setTitle(R.string.fittings_search);
        this.f11837c.mo7096a(this);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.x431pro.activity.golo.p225b.OnGoloKeyDownListener
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.f12969a.canGoBack()) {
            this.f12969a.goBack();
            return true;
        }
        return false;
    }

    @Override // com.cnlaunch.x431pro.activity.BaseWebFragment
    /* renamed from: a */
    public final void mo5836a(WebView webView) {
        webView.loadUrl(String.format(this.f11840f, this.f11838d));
    }
}
