package com.cnlaunch.x431pro.activity.golo.others;

import android.util.Log;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p169im.p178h.GoloOBManager;
import com.cnlaunch.x431pro.module.golo.model.RemoteSendResponse;

/* compiled from: RemoteDiagCMDListener.java */
/* renamed from: com.cnlaunch.x431pro.activity.golo.others.l */
/* loaded from: classes.dex */
public final class RunnableC2245l implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f12692a;

    /* renamed from: b */
    final /* synthetic */ String f12693b;

    /* renamed from: c */
    final /* synthetic */ RemoteDiagCMDListener f12694c;

    public RunnableC2245l(RemoteDiagCMDListener remoteDiagCMDListener, int i, String str) {
        this.f12694c = remoteDiagCMDListener;
        this.f12692a = i;
        this.f12693b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.f12692a;
        RemoteSendResponse remoteSendResponse = null;
        if (i == 2) {
            RemoteDiagCMDListener remoteDiagCMDListener = this.f12694c;
            try {
                remoteSendResponse = remoteDiagCMDListener.f12688a.m5316b(remoteDiagCMDListener.mo6956a(), this.f12693b);
            } catch (C1425f e) {
                e.printStackTrace();
            }
            if (remoteSendResponse == null) {
                Log.i("Sanda", "sendCancelCmd r is null");
            } else if (remoteSendResponse.getCode() == 0) {
                GoloOBManager.m8721a().m8717b();
            } else {
                Log.i("Sanda", "result[0]:" + remoteSendResponse.getCode());
            }
        } else if (i == 3) {
            RemoteDiagCMDListener remoteDiagCMDListener2 = this.f12694c;
            try {
                remoteSendResponse = remoteDiagCMDListener2.f12688a.m5317a(remoteDiagCMDListener2.mo6956a(), this.f12693b);
            } catch (C1425f e2) {
                e2.printStackTrace();
            }
            if (remoteSendResponse == null) {
                Log.i("Sanda", "r is null");
            } else if (remoteSendResponse.getCode() == 0) {
                GoloOBManager.m8721a().m8717b();
            } else {
                Log.i("Sanda", "result[0]:" + remoteSendResponse.getCode());
            }
        } else if (i == 1) {
            RemoteDiagCMDListener remoteDiagCMDListener3 = this.f12694c;
            try {
                remoteSendResponse = remoteDiagCMDListener3.f12688a.m5315c(remoteDiagCMDListener3.mo6956a(), this.f12693b);
            } catch (C1425f e3) {
                e3.printStackTrace();
            }
            if (remoteSendResponse == null) {
                Log.i("Sanda", "r is null");
            } else if (remoteSendResponse.getCode() == 0) {
                GoloOBManager.m8721a().m8717b();
            } else {
                Log.i("Sanda", "result[0]:" + remoteSendResponse.getCode());
            }
        } else if (i == 4) {
            RemoteDiagCMDListener remoteDiagCMDListener4 = this.f12694c;
            try {
                remoteSendResponse = remoteDiagCMDListener4.f12688a.m5314d(remoteDiagCMDListener4.mo6956a(), this.f12693b);
            } catch (C1425f e4) {
                e4.printStackTrace();
            }
            if (remoteSendResponse == null) {
                Log.i("Sanda", "r is null");
            } else if (remoteSendResponse.getCode() == 0) {
                GoloOBManager.m8721a().m8717b();
            } else {
                Log.i("Sanda", "result[0]:" + remoteSendResponse.getCode());
            }
        } else if (i == 5) {
            RemoteDiagCMDListener remoteDiagCMDListener5 = this.f12694c;
            try {
                remoteSendResponse = remoteDiagCMDListener5.f12688a.m5311i(this.f12693b);
            } catch (C1425f e5) {
                e5.printStackTrace();
            }
            if (remoteSendResponse == null) {
                Log.i("Sanda", "r is null");
            } else if (remoteSendResponse.getCode() == 0) {
                GoloOBManager.m8721a().m8717b();
            } else {
                Log.i("Sanda", "result[0]:" + remoteSendResponse.getCode());
            }
        }
    }
}
