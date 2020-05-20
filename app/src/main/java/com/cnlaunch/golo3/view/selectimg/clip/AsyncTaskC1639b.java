package com.cnlaunch.golo3.view.selectimg.clip;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Handler;
import java.io.FileOutputStream;

/* compiled from: ClipImageActivity.java */
/* renamed from: com.cnlaunch.golo3.view.selectimg.clip.b */
/* loaded from: classes.dex */
final class AsyncTaskC1639b extends AsyncTask<Void, Void, Void> {

    /* renamed from: a */
    final /* synthetic */ ClipImageActivity f8671a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AsyncTaskC1639b(ClipImageActivity clipImageActivity) {
        this.f8671a = clipImageActivity;
    }

    @Override // android.os.AsyncTask
    protected final /* synthetic */ Void doInBackground(Void[] voidArr) {
        return m9031a();
    }

    /* renamed from: a */
    private Void m9031a() {
        Throwable th;
        FileOutputStream fileOutputStream;
        Handler handler;
        String str;
        Bitmap m9051c;
        try {
            try {
                str = this.f8671a.f8625C;
                fileOutputStream = new FileOutputStream(str);
            } catch (Exception unused) {
                fileOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                C1644g.m9030a(null);
                throw th;
            }
            try {
                m9051c = this.f8671a.m9051c();
                m9051c.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                if (!m9051c.isRecycled()) {
                    m9051c.recycle();
                }
                this.f8671a.setResult(-1, this.f8671a.getIntent());
            } catch (Exception unused2) {
                handler = this.f8671a.f8633K;
                handler.sendEmptyMessage(0);
                C1644g.m9030a(fileOutputStream);
                return null;
            }
            C1644g.m9030a(fileOutputStream);
            return null;
        } catch (Throwable th3) {
            th = th3;
            C1644g.m9030a(null);
            throw th;
        }
    }

    @Override // android.os.AsyncTask
    protected final /* synthetic */ void onPostExecute(Void r1) {
        ProgressDialog progressDialog;
        progressDialog = this.f8671a.f8632J;
        progressDialog.dismiss();
        this.f8671a.finish();
    }
}
