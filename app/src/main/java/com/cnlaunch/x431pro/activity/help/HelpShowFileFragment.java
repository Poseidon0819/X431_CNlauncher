package com.cnlaunch.x431pro.activity.help;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.activity.BaseFragment;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;
import java.util.Locale;

/* renamed from: com.cnlaunch.x431pro.activity.help.j */
/* loaded from: classes.dex */
public class HelpShowFileFragment extends BaseFragment {

    /* renamed from: a */
    WebView f12793a = null;

    /* renamed from: b */
    String f12794b = "";

    /* renamed from: c */
    String f12795c = "";

    /* renamed from: d */
    String f12796d = "";

    /* renamed from: e */
    private HelpDocManger f12797e = null;

    /* renamed from: f */
    private HandlerC2259a f12798f = null;

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setTitle(R.string.tab_menu_help);
        this.f12793a = (WebView) getActivity().findViewById(R.id.WebViewHelpDoc);
        if (!this.f12796d.isEmpty()) {
            m6906a(this.f12796d);
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f12794b = arguments.getString(HelpStringConstant.f12801b);
            this.f12795c = arguments.getString(HelpStringConstant.f12800a);
            if (this.f12795c == null || this.f12794b == null) {
                return;
            }
            this.f12797e = new HelpDocManger(getActivity().getAssets(), HelpStringConstant.f12806g, Locale.getDefault().getLanguage());
            this.f12798f = new HandlerC2259a(this, (byte) 0);
            this.f12797e.m6924a(this.f12798f);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public void setBundle(Bundle bundle) {
        super.setBundle(bundle);
        this.f12796d = bundle.getString(HelpStringConstant.f12802c);
    }

    /* compiled from: HelpShowFileFragment.java */
    @SuppressLint({"HandlerLeak"})
    /* renamed from: com.cnlaunch.x431pro.activity.help.j$a */
    /* loaded from: classes.dex */
    class HandlerC2259a extends Handler {
        private HandlerC2259a() {
        }

        /* synthetic */ HandlerC2259a(HelpShowFileFragment helpShowFileFragment, byte b) {
            this();
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message2) {
            super.handleMessage(message2);
            if (message2.what == 0) {
                ArrayList parcelableArrayList = message2.getData().getParcelableArrayList(HelpStringConstant.f12804e);
                for (int i = 0; i < parcelableArrayList.size(); i++) {
                    String str = ((HelpFileInfo) parcelableArrayList.get(i)).f12718a;
                    String str2 = ((HelpFileInfo) parcelableArrayList.get(i)).f12720c;
                    if (str.equals(HelpShowFileFragment.this.f12794b) && str2.equals(HelpShowFileFragment.this.f12795c)) {
                        HelpShowFileFragment.this.m6906a(((HelpFileInfo) parcelableArrayList.get(i)).f12721d);
                        return;
                    }
                }
                NToast.m9449a(HelpShowFileFragment.this.getActivity(), "can't find help file!");
                HelpShowFileFragment.this.getActivity().finish();
            } else if (message2.what == 3) {
                HelpShowFileFragment.this.m6906a(message2.getData().getString(HelpStringConstant.f12802c));
            }
        }
    }

    /* renamed from: a */
    public final void m6906a(String str) {
        if (this.f12793a == null) {
            this.f12793a = (WebView) getActivity().findViewById(R.id.WebViewHelpDoc);
        }
        this.f12793a.loadUrl("file:///android_asset/".concat(String.valueOf(str)));
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.show_help_html_file_view, viewGroup, false);
    }
}
