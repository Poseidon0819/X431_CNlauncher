package com.cnlaunch.x431pro.module.cloud.p248b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import com.cnlaunch.p169im.IMPresenter;
import com.cnlaunch.x431pro.activity.diagnose.p222e.IFragmentCallback;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.cnlaunch.x431pro.widget.p290a.MessageDialog;

/* renamed from: com.cnlaunch.x431pro.module.cloud.b.a */
/* loaded from: classes.dex */
public class WebRemoteHandler {

    /* renamed from: a */
    public static WebRemoteHandler f15481a;

    /* renamed from: b */
    public Context f15482b;

    /* renamed from: c */
    public HandlerC2716a f15483c = new HandlerC2716a(this, (byte) 0);

    /* renamed from: d */
    Bundle f15484d = null;

    /* renamed from: e */
    public IFragmentCallback f15485e = null;

    /* renamed from: f */
    public boolean f15486f = false;

    /* renamed from: a */
    public static WebRemoteHandler m5419a() {
        if (f15481a == null) {
            synchronized (WebRemoteHandler.class) {
                if (f15481a == null) {
                    f15481a = new WebRemoteHandler();
                }
            }
        }
        return f15481a;
    }

    /* renamed from: b */
    public final void m5417b() {
        IMPresenter.m8804a(this.f15482b).m8806a();
    }

    /* compiled from: WebRemoteHandler.java */
    @SuppressLint({"HandlerLeak"})
    /* renamed from: com.cnlaunch.x431pro.module.cloud.b.a$a */
    /* loaded from: classes.dex */
    public class HandlerC2716a extends Handler {

        /* renamed from: a */
        MessageDialog f15487a;

        private HandlerC2716a() {
            this.f15487a = null;
        }

        /* synthetic */ HandlerC2716a(WebRemoteHandler webRemoteHandler, byte b) {
            this();
        }

        /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block
            	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:817)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:160)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
            	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:856)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:160)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
            	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:856)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:160)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
            	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:730)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
            	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:730)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
            	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:730)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
            */
        @Override // android.os.Handler
        public final void handleMessage(android.os.Message r12) {
            /*
                Method dump skipped, instructions count: 382
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.x431pro.module.cloud.p248b.WebRemoteHandler.HandlerC2716a.handleMessage(android.os.Message):void");
        }

        /* renamed from: a */
        private void m5415a(int i) {
            LoadDialog.m4681b(WebRemoteHandler.this.f15482b);
            MessageDialog messageDialog = this.f15487a;
            if (messageDialog != null && messageDialog.isShowing()) {
                this.f15487a.dismiss();
                this.f15487a = null;
            }
            this.f15487a = new MessageDialog(WebRemoteHandler.this.f15482b);
            this.f15487a.m4671a(i);
        }
    }
}
