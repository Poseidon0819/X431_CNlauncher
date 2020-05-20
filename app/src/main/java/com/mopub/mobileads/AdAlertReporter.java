package com.mopub.mobileads;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Base64;
import android.view.View;
import android.widget.Toast;
import com.mopub.common.AdReport;
import com.mopub.common.util.DateAndTime;
import com.mopub.common.util.Intents;
import com.mopub.exceptions.IntentNotResolvableException;
import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* loaded from: classes.dex */
public class AdAlertReporter {

    /* renamed from: b */
    private final View f20263b;

    /* renamed from: c */
    private final Context f20264c;

    /* renamed from: e */
    private String f20266e;

    /* renamed from: f */
    private String f20267f;

    /* renamed from: a */
    private final String f20262a = new SimpleDateFormat("M/d/yy hh:mm:ss a z", Locale.US).format(DateAndTime.now());

    /* renamed from: d */
    private Intent f20265d = new Intent("android.intent.action.SENDTO");

    public AdAlertReporter(Context context, View view, AdReport adReport) {
        this.f20263b = view;
        this.f20264c = context;
        this.f20265d.setData(Uri.parse("mailto:creative-review@mopub.com"));
        View view2 = this.f20263b;
        Bitmap bitmap = null;
        if (view2 != null && view2.getRootView() != null) {
            View rootView = this.f20263b.getRootView();
            boolean isDrawingCacheEnabled = rootView.isDrawingCacheEnabled();
            rootView.setDrawingCacheEnabled(true);
            Bitmap drawingCache = rootView.getDrawingCache();
            if (drawingCache != null) {
                bitmap = Bitmap.createBitmap(drawingCache);
                rootView.setDrawingCacheEnabled(isDrawingCacheEnabled);
            }
        }
        String m2477a = m2477a(bitmap);
        this.f20266e = "";
        this.f20267f = "";
        if (adReport != null) {
            this.f20266e = adReport.toString();
            this.f20267f = adReport.getResponseString();
        }
        Intent intent = this.f20265d;
        intent.putExtra("android.intent.extra.SUBJECT", "New creative violation report - " + this.f20262a);
        m2476a(this.f20266e, this.f20267f, m2477a);
    }

    public void send() {
        try {
            Intents.startActivity(this.f20264c, this.f20265d);
        } catch (IntentNotResolvableException unused) {
            Toast.makeText(this.f20264c, "No email client available", 0).show();
        }
    }

    /* renamed from: a */
    private static String m2477a(Bitmap bitmap) {
        if (bitmap != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 25, byteArrayOutputStream);
                return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    /* renamed from: a */
    private void m2476a(String... strArr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append(strArr[i]);
            if (i != 2) {
                sb.append("\n=================\n");
            }
        }
        this.f20265d.putExtra("android.intent.extra.TEXT", sb.toString());
    }
}
