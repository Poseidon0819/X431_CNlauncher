package com.cnlaunch.x431pro.activity.help;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.webkit.WebView;
import com.cnlaunch.p120d.p130d.NToast;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;
import java.util.Locale;

/* loaded from: classes.dex */
public class HelpShowFileActivity extends Activity {

    /* renamed from: a */
    WebView f12722a = null;

    /* renamed from: b */
    String f12723b = "";

    /* renamed from: c */
    String f12724c = "";

    /* renamed from: d */
    String f12725d = "";

    /* renamed from: e */
    private HelpDocManger f12726e = null;

    /* renamed from: f */
    private HandlerC2251a f12727f = null;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.show_help_html_file_view);
        Bundle extras = getIntent().getExtras();
        this.f12725d = extras.getString(HelpStringConstant.f12802c);
        this.f12722a = (WebView) findViewById(R.id.WebViewHelpDoc);
        if (!this.f12725d.isEmpty()) {
            m6927a(this.f12725d);
        } else if (extras != null) {
            this.f12723b = extras.getString(HelpStringConstant.f12801b);
            this.f12724c = extras.getString(HelpStringConstant.f12800a);
            if (this.f12724c != null && this.f12723b != null) {
                this.f12726e = new HelpDocManger(getAssets(), HelpStringConstant.f12806g, Locale.getDefault().getLanguage());
                this.f12727f = new HandlerC2251a(this, (byte) 0);
                this.f12726e.m6924a(this.f12727f);
                return;
            }
            m6928a();
        }
    }

    @SuppressLint({"HandlerLeak"})
    /* renamed from: com.cnlaunch.x431pro.activity.help.HelpShowFileActivity$a */
    /* loaded from: classes.dex */
    class HandlerC2251a extends Handler {
        private HandlerC2251a() {
        }

        /* synthetic */ HandlerC2251a(HelpShowFileActivity helpShowFileActivity, byte b) {
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
                    if (str.equals(HelpShowFileActivity.this.f12723b) && str2.equals(HelpShowFileActivity.this.f12724c)) {
                        HelpShowFileActivity.this.m6927a(((HelpFileInfo) parcelableArrayList.get(i)).f12721d);
                        return;
                    }
                }
                HelpShowFileActivity.this.m6928a();
            } else if (message2.what == 3) {
                HelpShowFileActivity.this.m6927a(message2.getData().getString(HelpStringConstant.f12802c));
            }
        }
    }

    /* renamed from: a */
    public final void m6928a() {
        NToast.m9449a(this, "can't find help file!");
        finish();
    }

    /* renamed from: a */
    public final void m6927a(String str) {
        if (this.f12722a == null) {
            this.f12722a = (WebView) findViewById(R.id.WebViewHelpDoc);
        }
        this.f12722a.loadUrl("file:///android_asset/".concat(String.valueOf(str)));
    }
}
