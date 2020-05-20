package com.cnlaunch.x431pro.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.p169im.p178h.GoloTipObServer;
import com.cnlaunch.x431pro.module.rtu.HomeStartActivity;
import com.cnlaunch.x431pro.utils.PathUtils;
import com.ifoer.expedition.pro.R;

/* compiled from: MainActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.q */
/* loaded from: classes.dex */
final class HandlerC2512q extends Handler {

    /* renamed from: a */
    final /* synthetic */ MainActivity f14451a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC2512q(MainActivity mainActivity) {
        this.f14451a = mainActivity;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message2) {
        ProgressDialog progressDialog;
        ProgressDialog progressDialog2;
        ProgressDialog progressDialog3;
        ProgressDialog progressDialog4;
        String str;
        double d;
        double d2;
        ProgressBar progressBar;
        TextView textView;
        ProgressBar progressBar2;
        ProgressDialog progressDialog5;
        ProgressDialog progressDialog6;
        ProgressDialog progressDialog7;
        GoloTipObServer goloTipObServer;
        RadioButton radioButton;
        GoloTipObServer goloTipObServer2;
        GoloTipObServer goloTipObServer3;
        GoloTipObServer goloTipObServer4;
        RadioButton radioButton2;
        GoloTipObServer goloTipObServer5;
        if (message2.what == 15) {
            NLog.m9452b(this.f14451a.f10738d, "isUSAProject isFirstRun launch HomeStartActivity ");
            Intent intent = new Intent(this.f14451a.f10736a, HomeStartActivity.class);
            intent.setFlags(67108864);
            this.f14451a.startActivityForResult(intent, 15);
        } else if (message2.what == 100) {
            if (message2.arg1 <= 0) {
                goloTipObServer4 = this.f14451a.f10734X;
                if (goloTipObServer4 != null) {
                    goloTipObServer5 = this.f14451a.f10734X;
                    goloTipObServer5.f9282a = false;
                }
                Drawable drawable = this.f14451a.getResources().getDrawable(R.drawable.select_btn_golo);
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = drawable.getIntrinsicHeight();
                Rect rect = new Rect(0, 0, intrinsicWidth, intrinsicHeight);
                String str2 = this.f14451a.f10738d;
                Log.i(str2, "rightL:" + intrinsicWidth + "bottomL:" + intrinsicHeight);
                drawable.setBounds(rect);
                radioButton2 = this.f14451a.f10743i;
                radioButton2.setCompoundDrawables(drawable, null, null, null);
                return;
            }
            goloTipObServer = this.f14451a.f10734X;
            if (goloTipObServer != null) {
                goloTipObServer2 = this.f14451a.f10734X;
                if (goloTipObServer2.f9282a) {
                    return;
                }
                goloTipObServer3 = this.f14451a.f10734X;
                goloTipObServer3.f9282a = true;
            }
            Drawable drawable2 = this.f14451a.getResources().getDrawable(R.drawable.select_btn_golo);
            drawable2.setBounds(new Rect(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight()));
            Drawable drawable3 = this.f14451a.getResources().getDrawable(R.drawable.msg_new);
            int dimension = (int) this.f14451a.f10736a.getResources().getDimension(R.dimen.golo_right_icon_width);
            int dimension2 = (int) this.f14451a.f10736a.getResources().getDimension(R.dimen.golo_right_icon_height);
            Rect rect2 = new Rect(0, 0, dimension, dimension2);
            String str3 = this.f14451a.f10738d;
            Log.i(str3, "rightR:" + dimension + "bottomR:" + dimension2);
            drawable3.setBounds(rect2);
            radioButton = this.f14451a.f10743i;
            radioButton.setCompoundDrawables(drawable2, null, drawable3, null);
        } else if (message2.what == 111) {
            progressDialog5 = this.f14451a.f10716E;
            if (progressDialog5 != null) {
                progressDialog6 = this.f14451a.f10716E;
                if (progressDialog6.isShowing()) {
                    progressDialog7 = this.f14451a.f10716E;
                    progressDialog7.dismiss();
                }
            }
            NToast.m9450a(this.f14451a.f10736a, (int) R.string.download_sellerapp_failed_toast);
        } else if (message2.what == 110) {
            this.f14451a.f10719H = (String) message2.obj;
            new Thread(new RunnableC2704v(this.f14451a)).start();
        } else if (message2.what == 112) {
            progressBar2 = this.f14451a.f10717F;
            progressBar2.setMax(100);
        } else if (message2.what == 113) {
            d = this.f14451a.f10721J;
            d2 = this.f14451a.f10720I;
            int i = (int) ((d * 100.0d) / d2);
            progressBar = this.f14451a.f10717F;
            progressBar.setProgress(i);
            textView = this.f14451a.f10718G;
            textView.setText(i + "%");
        } else if (message2.what == 114) {
            progressDialog4 = this.f14451a.f10716E;
            progressDialog4.dismiss();
            StringBuilder sb = new StringBuilder();
            sb.append(PathUtils.m4852e());
            sb.append("/");
            str = this.f14451a.f10722K;
            sb.append(str);
            String sb2 = sb.toString();
            PreferencesManager.m9595a(this.f14451a.f10736a).m9588a("golo_seller_app_path", sb2);
            this.f14451a.m7888b(sb2);
        } else if (message2.what == 115) {
            progressDialog = this.f14451a.f10716E;
            if (progressDialog != null) {
                progressDialog2 = this.f14451a.f10716E;
                if (progressDialog2.isShowing()) {
                    progressDialog3 = this.f14451a.f10716E;
                    progressDialog3.dismiss();
                }
            }
        }
    }
}
