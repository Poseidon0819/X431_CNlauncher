package com.cnlaunch.p120d.p125c.p126a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.itextpdf.text.pdf.PdfContentParser;

/* renamed from: com.cnlaunch.d.c.a.b */
/* loaded from: classes.dex */
public class BaseAsyncTask extends AsyncTask<Object, Integer, Object> {

    /* renamed from: b */
    private DownLoad f7042b;

    /* renamed from: c */
    private Context f7043c;

    /* renamed from: e */
    private boolean f7045e;

    /* renamed from: a */
    private final String f7041a = BaseAsyncTask.class.getSimpleName();

    /* renamed from: d */
    private int f7044d = -1;

    public BaseAsyncTask(DownLoad downLoad, Context context) {
        this.f7042b = null;
        this.f7042b = downLoad;
        this.f7043c = context;
    }

    @Override // android.os.AsyncTask
    protected Object doInBackground(Object... objArr) {
        NetworkInfo activeNetworkInfo;
        try {
            if (this.f7042b.f7050e == null) {
                throw new C1425f("BaseAsyncTask listener is not null.");
            }
            int i = -400;
            if (!this.f7042b.f7049d || ((activeNetworkInfo = ((ConnectivityManager) this.f7043c.getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isConnectedOrConnecting())) {
                Object doInBackground = this.f7042b.f7050e.doInBackground(this.f7042b.f7046a);
                DownLoad downLoad = this.f7042b;
                if (!this.f7045e) {
                    i = PdfContentParser.COMMAND_TYPE;
                }
                downLoad.f7047b = i;
                this.f7042b.f7048c = doInBackground;
            } else {
                this.f7042b.f7047b = -400;
            }
            return this.f7042b;
        } catch (Exception e) {
            e.printStackTrace();
            if (e instanceof C1425f) {
                if ("-300".equals(e.getMessage())) {
                    this.f7042b.f7047b = -300;
                } else {
                    this.f7042b.f7047b = -200;
                }
            } else if ("-300".equals(e.getMessage())) {
                this.f7042b.f7047b = -300;
            } else {
                this.f7042b.f7047b = -999;
            }
            DownLoad downLoad2 = this.f7042b;
            downLoad2.f7048c = e;
            return downLoad2;
        }
    }

    @Override // android.os.AsyncTask
    protected void onPostExecute(Object obj) {
        DownLoad downLoad = (DownLoad) obj;
        int i = downLoad.f7047b;
        if (i == -999 || i == -400 || i == -200) {
            downLoad.f7050e.onFailure(downLoad.f7046a, downLoad.f7047b, downLoad.f7048c);
        } else if (i == 200) {
            downLoad.f7050e.onSuccess(downLoad.f7046a, downLoad.f7048c);
        } else {
            downLoad.f7050e.onFailure(downLoad.f7046a, downLoad.f7047b, downLoad.f7048c);
        }
    }
}
