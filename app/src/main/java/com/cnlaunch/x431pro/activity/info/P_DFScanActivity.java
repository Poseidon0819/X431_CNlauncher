package com.cnlaunch.x431pro.activity.info;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.cnlaunch.x431pro.utils.PathUtils;
import com.ifoer.expedition.pro.R;
import com.itextpdf.text.Annotation;
import java.io.File;
import java.util.Locale;
import org.apache.mina.proxy.handlers.http.ntlm.NTLMConstants;
import org.vudroid.pdfdroid.PdfViewerActivity;

/* loaded from: classes.dex */
public class P_DFScanActivity extends Activity {

    /* renamed from: a */
    private Context f12851a;

    /* renamed from: b */
    private String f12852b;

    /* renamed from: c */
    private String f12853c;

    /* renamed from: d */
    private String f12854d;

    /* renamed from: e */
    private WebView f12855e;

    /* renamed from: f */
    private ProgressDialog f12856f;

    /* renamed from: g */
    private ProgressDialog f12857g;

    /* renamed from: h */
    private AsyncTaskC2268a f12858h;

    /* renamed from: i */
    private String f12859i;

    /* renamed from: j */
    private Handler f12860j = new HandlerC2283i(this);

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pdf_webview);
        this.f12855e = (WebView) findViewById(R.id.pdf_webView);
        this.f12851a = this;
        this.f12859i = PathUtils.m4845k();
        this.f12857g = new ProgressDialog(this);
        this.f12857g.setCancelable(true);
        this.f12857g.setCanceledOnTouchOutside(false);
        this.f12855e.setWebViewClient(new C2269b());
        this.f12855e.getSettings().setJavaScriptEnabled(true);
        this.f12855e.getSettings().setSupportZoom(true);
        this.f12855e.getSettings().setDomStorageEnabled(true);
        this.f12855e.getSettings().setAllowFileAccess(true);
        this.f12855e.getSettings().setUseWideViewPort(true);
        this.f12855e.getSettings().setBuiltInZoomControls(true);
        this.f12855e.requestFocus();
        this.f12855e.getSettings().setLoadWithOverviewMode(true);
        this.f12855e.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        Intent intent = getIntent();
        if (intent != null) {
            this.f12852b = intent.getStringExtra(Annotation.URL);
            if (TextUtils.isEmpty(this.f12852b)) {
                return;
            }
            this.f12853c = this.f12852b.hashCode() + "_" + Locale.getDefault().getLanguage() + ".pdf";
            File file = new File(this.f12859i, this.f12853c);
            if (file.exists()) {
                Intent intent2 = new Intent("org.vudroid.pdfdroid.PdfViewerActivity");
                intent2.addCategory("android.intent.category.BROWSABLE");
                intent2.addCategory("android.intent.category.DEFAULT");
                intent2.addFlags(NTLMConstants.FLAG_UNIDENTIFIED_11);
                intent2.setDataAndType(Uri.fromFile(new File(String.valueOf(file.getAbsolutePath()))), "application/pdf");
                this.f12851a.startActivity(intent2);
                finish();
                return;
            }
            m6872a();
        }
    }

    /* renamed from: a */
    public final void m6872a() {
        try {
            this.f12853c = this.f12852b.hashCode() + "_" + Locale.getDefault().getLanguage() + ".pdf";
            this.f12854d = this.f12852b.hashCode() + "_" + Locale.getDefault().getLanguage() + ".download";
            File file = new File(this.f12859i, this.f12853c);
            if (file.exists()) {
                Intent intent = new Intent(this.f12851a, PdfViewerActivity.class);
                intent.addCategory("android.intent.category.DEFAULT");
                intent.addFlags(NTLMConstants.FLAG_UNIDENTIFIED_11);
                intent.setDataAndType(Uri.fromFile(new File(String.valueOf(file.getAbsolutePath()))), "application/pdf");
                this.f12851a.startActivity(intent);
                finish();
                return;
            }
            this.f12856f = new ProgressDialog(this);
            this.f12856f.setCancelable(true);
            this.f12856f.setCanceledOnTouchOutside(false);
            this.f12856f.setProgressStyle(1);
            this.f12856f.setTitle(this.f12851a.getString(R.string.order_notic));
            ProgressDialog progressDialog = this.f12856f;
            progressDialog.setMessage(this.f12851a.getString(R.string.down_state_1) + "...");
            this.f12856f.setMax(100);
            this.f12856f.show();
            this.f12858h = new AsyncTaskC2268a(this.f12852b);
            this.f12858h.execute(new Void[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: com.cnlaunch.x431pro.activity.info.P_DFScanActivity$b */
    /* loaded from: classes.dex */
    class C2269b extends WebViewClient {
        @Override // android.webkit.WebViewClient
        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return true;
        }

        C2269b() {
        }

        @Override // android.webkit.WebViewClient
        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public final void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (P_DFScanActivity.this.f12857g == null || !P_DFScanActivity.this.f12857g.isShowing()) {
                return;
            }
            P_DFScanActivity.this.f12857g.dismiss();
        }

        @Override // android.webkit.WebViewClient
        public final void onReceivedError(WebView webView, int i, String str, String str2) {
            P_DFScanActivity.this.f12855e.setVisibility(8);
            if (P_DFScanActivity.this.f12857g != null && P_DFScanActivity.this.f12857g.isShowing()) {
                P_DFScanActivity.this.f12857g.dismiss();
            }
            P_DFScanActivity.this.m6872a();
        }

        @Override // android.webkit.WebViewClient
        public final void onLoadResource(WebView webView, String str) {
            super.onLoadResource(webView, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.cnlaunch.x431pro.activity.info.P_DFScanActivity$a */
    /* loaded from: classes.dex */
    public class AsyncTaskC2268a extends AsyncTask<Void, Integer, Object> {

        /* renamed from: b */
        private String f12862b;

        @Override // android.os.AsyncTask
        protected final /* synthetic */ Object doInBackground(Void[] voidArr) {
            return m6863a();
        }

        public AsyncTaskC2268a(String str) {
            this.f12862b = str;
        }

        /* JADX WARN: Not initialized variable reg: 7, insn: 0x00e3: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r7 I:??[OBJECT, ARRAY]), block:B:53:0x00e3 */
        /* JADX WARN: Removed duplicated region for block: B:61:0x00e6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private java.lang.Object m6863a() {
            /*
                Method dump skipped, instructions count: 240
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.x431pro.activity.info.P_DFScanActivity.AsyncTaskC2268a.m6863a():java.lang.Object");
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onProgressUpdate(Integer... numArr) {
            if (numArr != null) {
                P_DFScanActivity.this.f12856f.setProgress((numArr[0].intValue() * 100) / numArr[1].intValue());
            }
        }

        @Override // android.os.AsyncTask
        protected final void onPostExecute(Object obj) {
            try {
                if (P_DFScanActivity.this.f12856f != null && P_DFScanActivity.this.f12856f.isShowing()) {
                    P_DFScanActivity.this.f12856f.dismiss();
                }
                if (obj == null || P_DFScanActivity.this.f12851a == null) {
                    return;
                }
                Intent intent = new Intent(P_DFScanActivity.this.f12851a, PdfViewerActivity.class);
                intent.addCategory("android.intent.category.DEFAULT");
                intent.addFlags(NTLMConstants.FLAG_UNIDENTIFIED_11);
                intent.setDataAndType(Uri.fromFile(new File(String.valueOf(obj))), "application/pdf");
                P_DFScanActivity.this.f12851a.startActivity(intent);
                P_DFScanActivity.this.finish();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            AsyncTaskC2268a asyncTaskC2268a = this.f12858h;
            if (asyncTaskC2268a != null) {
                asyncTaskC2268a.cancel(true);
                this.f12858h = null;
                File file = new File(this.f12859i, this.f12854d);
                if (file.exists()) {
                    file.delete();
                }
            }
            finish();
            return true;
        }
        return false;
    }
}
