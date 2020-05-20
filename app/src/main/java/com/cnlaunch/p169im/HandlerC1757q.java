package com.cnlaunch.p169im;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Message;
import android.view.SurfaceView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.ifoer.expedition.pro.R;
import message.model.MessageObj;

/* compiled from: ShowVideoActivity.java */
/* renamed from: com.cnlaunch.im.q */
/* loaded from: classes.dex */
final class HandlerC1757q extends Handler {

    /* renamed from: a */
    final /* synthetic */ ShowVideoActivity f9314a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC1757q(ShowVideoActivity showVideoActivity) {
        this.f9314a = showVideoActivity;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message2) {
        boolean z;
        ProgressDialog progressDialog;
        ProgressDialog progressDialog2;
        ProgressDialog progressDialog3;
        boolean z2;
        ProgressDialog progressDialog4;
        ProgressDialog progressDialog5;
        ProgressDialog progressDialog6;
        boolean z3;
        ProgressDialog progressDialog7;
        ProgressDialog progressDialog8;
        SharedPreferences sharedPreferences;
        MessageObj messageObj;
        String str;
        String str2;
        SurfaceView surfaceView;
        ImageView imageView;
        SurfaceView surfaceView2;
        super.handleMessage(message2);
        int i = message2.what;
        if (i != 16) {
            switch (i) {
                case 0:
                    z = this.f9314a.f8903n;
                    if (z) {
                        progressDialog = this.f9314a.f8898i;
                        progressDialog.show();
                        progressDialog2 = this.f9314a.f8898i;
                        progressDialog2.setContentView(R.layout.downloading_layout);
                        progressDialog3 = this.f9314a.f8898i;
                        ProgressBar progressBar = (ProgressBar) progressDialog3.findViewById(R.id.download_progress);
                        progressBar.setMax(100);
                        progressBar.setProgress(0);
                        return;
                    }
                    return;
                case 1:
                    z2 = this.f9314a.f8903n;
                    if (z2) {
                        progressDialog4 = this.f9314a.f8898i;
                        if (progressDialog4 != null) {
                            int i2 = (message2.arg2 * 100) / message2.arg1;
                            progressDialog5 = this.f9314a.f8898i;
                            ProgressBar progressBar2 = (ProgressBar) progressDialog5.findViewById(R.id.download_progress);
                            if (progressBar2 != null) {
                                progressBar2.setProgress(i2);
                            }
                            progressDialog6 = this.f9314a.f8898i;
                            ((TextView) progressDialog6.findViewById(R.id.download_progress_text)).setText(i2 + "%");
                            return;
                        }
                        return;
                    }
                    return;
                case 2:
                    z3 = this.f9314a.f8903n;
                    if (z3) {
                        progressDialog7 = this.f9314a.f8898i;
                        if (progressDialog7 != null) {
                            progressDialog8 = this.f9314a.f8898i;
                            progressDialog8.dismiss();
                            this.f9314a.f8896g = message2.obj.toString();
                            this.f9314a.m8936c();
                            sharedPreferences = this.f9314a.f8902m;
                            SharedPreferences.Editor edit = sharedPreferences.edit();
                            messageObj = this.f9314a.f8899j;
                            String str3 = messageObj.f24084a;
                            str = this.f9314a.f8896g;
                            edit.putString(str3, str).commit();
                            ShowVideoActivity.m8942a(this.f9314a);
                            str2 = this.f9314a.f8896g;
                            BitmapDrawable bitmapDrawable = new BitmapDrawable(ShowVideoActivity.m8939a(str2));
                            surfaceView = this.f9314a.f8894e;
                            if (surfaceView != null) {
                                surfaceView2 = this.f9314a.f8894e;
                                surfaceView2.setBackgroundDrawable(bitmapDrawable);
                            }
                            imageView = this.f9314a.f8901l;
                            imageView.setVisibility(0);
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        ShowVideoActivity.m8926l(this.f9314a);
    }
}
