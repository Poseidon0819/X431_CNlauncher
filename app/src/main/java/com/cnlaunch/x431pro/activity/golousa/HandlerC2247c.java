package com.cnlaunch.x431pro.activity.golousa;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.utils.PathUtils;
import com.ifoer.expedition.pro.R;

/* compiled from: GoloUSAFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.golousa.c */
/* loaded from: classes.dex */
final class HandlerC2247c extends Handler {

    /* renamed from: a */
    final /* synthetic */ GoloUSAFragment f12711a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC2247c(GoloUSAFragment goloUSAFragment) {
        this.f12711a = goloUSAFragment;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message2) {
        ProgressDialog progressDialog;
        ProgressDialog progressDialog2;
        ProgressDialog progressDialog3;
        ProgressDialog progressDialog4;
        String str;
        Context context;
        double d;
        double d2;
        ProgressBar progressBar;
        TextView textView;
        ProgressBar progressBar2;
        ProgressDialog progressDialog5;
        Context context2;
        ProgressDialog progressDialog6;
        ProgressDialog progressDialog7;
        if (message2.what == 111) {
            progressDialog5 = this.f12711a.f12702g;
            if (progressDialog5 != null) {
                progressDialog6 = this.f12711a.f12702g;
                if (progressDialog6.isShowing()) {
                    progressDialog7 = this.f12711a.f12702g;
                    progressDialog7.dismiss();
                }
            }
            context2 = this.f12711a.mContext;
            NToast.m9450a(context2, (int) R.string.download_sellerapp_failed_toast);
        } else if (message2.what == 110) {
            this.f12711a.f12705j = (String) message2.obj;
            new Thread(new RunnableC2250f(this.f12711a)).start();
        } else if (message2.what == 112) {
            progressBar2 = this.f12711a.f12703h;
            progressBar2.setMax(100);
        } else if (message2.what == 113) {
            d = this.f12711a.f12707l;
            d2 = this.f12711a.f12706k;
            int i = (int) ((d * 100.0d) / d2);
            progressBar = this.f12711a.f12703h;
            progressBar.setProgress(i);
            textView = this.f12711a.f12704i;
            textView.setText(i + "%");
        } else if (message2.what == 114) {
            progressDialog4 = this.f12711a.f12702g;
            progressDialog4.dismiss();
            StringBuilder sb = new StringBuilder();
            sb.append(PathUtils.m4852e());
            sb.append("/");
            str = this.f12711a.f12708m;
            sb.append(str);
            String sb2 = sb.toString();
            context = this.f12711a.mContext;
            PreferencesManager.m9595a(context).m9588a("golo_seller_app_path", sb2);
            this.f12711a.m6950a(sb2);
        } else if (message2.what == 115) {
            progressDialog = this.f12711a.f12702g;
            if (progressDialog != null) {
                progressDialog2 = this.f12711a.f12702g;
                if (progressDialog2.isShowing()) {
                    progressDialog3 = this.f12711a.f12702g;
                    progressDialog3.dismiss();
                }
            }
        }
    }
}
