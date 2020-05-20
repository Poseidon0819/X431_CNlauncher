package com.artifex.mupdflib;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Base64;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import org.apache.mina.proxy.handlers.http.ntlm.NTLMConstants;

/* loaded from: classes.dex */
public class PrintDialogActivity extends Activity {
    private static final String CLOSE_POST_MESSAGE_NAME = "cp-dialog-on-close";
    private static final String CONTENT_TRANSFER_ENCODING = "base64";
    private static final String JS_INTERFACE = "AndroidPrintDialog";
    private static final String PRINT_DIALOG_URL = "https://www.google.com/cloudprint/dialog.html";
    private static final int ZXING_SCAN_REQUEST = 65743;
    private static final String ZXING_URL = "http://zxing.appspot.com";
    Intent cloudPrintIntent;
    private WebView dialogWebView;
    private int resultCode;

    @Override // android.app.Activity
    @SuppressLint({"NewApi"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().addFlags(NTLMConstants.FLAG_NEGOTIATE_56_BIT_ENCRYPTION);
            getWindow().setStatusBarColor(getResources().getColor(C0835R.color.actionbar_background_dark));
            getWindow().setNavigationBarColor(getResources().getColor(C0835R.color.actionbar_background_dark));
        }
        this.resultCode = -1;
        setContentView(C0835R.layout.print_dialog);
        this.dialogWebView = (WebView) findViewById(C0835R.C0836id.webview);
        this.cloudPrintIntent = getIntent();
        this.dialogWebView.getSettings().setJavaScriptEnabled(true);
        this.dialogWebView.setWebViewClient(new PrintDialogWebClient());
        this.dialogWebView.addJavascriptInterface(new PrintDialogJavaScriptInterface(), JS_INTERFACE);
        this.dialogWebView.loadUrl(PRINT_DIALOG_URL);
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == ZXING_SCAN_REQUEST && i2 == -1) {
            this.dialogWebView.loadUrl(intent.getStringExtra("SCAN_RESULT"));
        }
    }

    /* loaded from: classes.dex */
    final class PrintDialogJavaScriptInterface {
        public final String getEncoding() {
            return PrintDialogActivity.CONTENT_TRANSFER_ENCODING;
        }

        PrintDialogJavaScriptInterface() {
        }

        public final String getType() {
            return PrintDialogActivity.this.cloudPrintIntent.getType();
        }

        public final String getTitle() {
            return PrintDialogActivity.this.cloudPrintIntent.getExtras().getString("title");
        }

        public final String getContent() {
            try {
                InputStream openInputStream = PrintDialogActivity.this.getContentResolver().openInputStream(PrintDialogActivity.this.cloudPrintIntent.getData());
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[4096];
                for (int read = openInputStream.read(bArr); read >= 0; read = openInputStream.read(bArr)) {
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                openInputStream.close();
                byteArrayOutputStream.flush();
                return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
            } catch (Throwable th) {
                PrintDialogActivity.this.resultCode = 0;
                PrintDialogActivity printDialogActivity = PrintDialogActivity.this;
                printDialogActivity.setResult(printDialogActivity.resultCode);
                PrintDialogActivity.this.finish();
                th.printStackTrace();
                return "";
            }
        }

        public final void onPostMessage(String str) {
            if (str.startsWith(PrintDialogActivity.CLOSE_POST_MESSAGE_NAME)) {
                PrintDialogActivity printDialogActivity = PrintDialogActivity.this;
                printDialogActivity.setResult(printDialogActivity.resultCode);
                PrintDialogActivity.this.finish();
            }
        }
    }

    /* loaded from: classes.dex */
    final class PrintDialogWebClient extends WebViewClient {
        private PrintDialogWebClient() {
        }

        @Override // android.webkit.WebViewClient
        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str.startsWith(PrintDialogActivity.ZXING_URL)) {
                Intent intent = new Intent("com.google.zxing.client.android.SCAN");
                intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
                try {
                    PrintDialogActivity.this.startActivityForResult(intent, PrintDialogActivity.ZXING_SCAN_REQUEST);
                    return false;
                } catch (ActivityNotFoundException unused) {
                }
            }
            webView.loadUrl(str);
            return false;
        }

        @Override // android.webkit.WebViewClient
        public final void onPageFinished(WebView webView, String str) {
            if (PrintDialogActivity.PRINT_DIALOG_URL.equals(str)) {
                webView.loadUrl("javascript:printDialog.setPrintDocument(printDialog.createPrintDocument(window.AndroidPrintDialog.getType(),window.AndroidPrintDialog.getTitle(),window.AndroidPrintDialog.getContent(),window.AndroidPrintDialog.getEncoding()))");
                webView.loadUrl("javascript:window.addEventListener('message',function(evt){window.AndroidPrintDialog.onPostMessage(evt.data)}, false)");
            }
        }
    }
}
