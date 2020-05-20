package com.cnlaunch.x431pro.activity.diagnose.p221d;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.cnlaunch.diagnosemodule.bean.BasicHTMLDialogBean;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.x431pro.utils.PathUtils;
import com.cnlaunch.x431pro.utils.p285e.FileUtils;
import com.cnlaunch.x431pro.widget.button.IconButton;
import com.ifoer.expedition.pro.R;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.jivesoftware.smackx.bytestreams.ibb.packet.DataPacketExtension;

/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.bm */
/* loaded from: classes.dex */
public final class ShowHtmlDataFragment extends BaseDiagnoseFragment {

    /* renamed from: a */
    private WebView f12132a;

    /* renamed from: b */
    private String f12133b = "";

    /* renamed from: j */
    private BasicHTMLDialogBean f12134j;

    /* renamed from: k */
    private String f12135k;

    /* renamed from: l */
    private IconButton f12136l;

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, android.app.Fragment
    public final void onAttach(Activity activity) {
        super.onAttach(activity);
        Bundle arguments = getArguments();
        if (arguments == null || !arguments.containsKey(DataPacketExtension.ELEMENT_NAME)) {
            return;
        }
        this.f12134j = (BasicHTMLDialogBean) arguments.getSerializable(DataPacketExtension.ELEMENT_NAME);
        BasicHTMLDialogBean basicHTMLDialogBean = this.f12134j;
        if (basicHTMLDialogBean != null) {
            this.f12133b = TextUtils.isEmpty(basicHTMLDialogBean.getStrTitle()) ? "" : this.f12134j.getStrTitle();
        }
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment
    /* renamed from: b */
    public final String mo7102b() {
        return this.f12133b;
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        String str;
        super.onActivityCreated(bundle);
        this.f12132a = (WebView) getActivity().findViewById(R.id.webview);
        if (this.f12134j != null) {
            String str2 = "";
            for (int i = 0; i < this.f12134j.getArrayListContext().size(); i++) {
                str2 = str2 + this.f12134j.getArrayListContext().get(i);
            }
            str = str2;
        } else {
            str = "";
        }
        this.f12132a.getSettings().setTextSize(WebSettings.TextSize.LARGER);
        if (Build.VERSION.SDK_INT > 16) {
            this.f12132a.getSettings().setAllowUniversalAccessFromFileURLs(true);
            this.f12132a.getSettings().setAllowFileAccessFromFileURLs(true);
        }
        this.f12132a.getSettings().setAllowFileAccess(true);
        this.f12132a.clearFormData();
        this.f12135k = PathUtils.m4863a(PathUtils.m4858c(), "temp") + (new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(System.currentTimeMillis())) + ".html");
        if (FileUtils.m5016a(str, this.f12135k)) {
            this.f12132a.loadUrl("file://" + this.f12135k);
        } else {
            this.f12132a.loadDataWithBaseURL(null, str, "text/html", "utf-8", null);
        }
        this.f12136l = (IconButton) getActivity().findViewById(R.id.btn_confirm);
        this.f12136l.setOnClickListener(this);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public final View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_show_html_data, viewGroup, false);
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public final void onDestroy() {
        FileUtils.m5000d(this.f12135k);
        super.onDestroy();
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.x431pro.activity.golo.p225b.OnGoloKeyDownListener
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.f12132a.canGoBack()) {
            this.f12132a.goBack();
            return true;
        } else if (i == 4) {
            this.f12357d.mo7093a(DiagnoseConstants.FEEDBACK_SPT_TRANS_DIAG_INFO_EX, "00000100", 3);
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view.getId() != R.id.btn_confirm) {
            return;
        }
        this.f12357d.mo7093a(DiagnoseConstants.FEEDBACK_SPT_TRANS_DIAG_INFO_EX, "00000100", 3);
    }
}
