package com.unionpay.mobile.android.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.unionpay.mobile.android.net.C4180c;
import com.unionpay.mobile.android.net.C4181d;
import java.lang.ref.WeakReference;

/* renamed from: com.unionpay.mobile.android.utils.q */
/* loaded from: classes2.dex */
public final class RunnableC4396q implements Handler.Callback, Runnable {

    /* renamed from: a */
    private C4181d f23208a;

    /* renamed from: b */
    private Handler f23209b;

    /* renamed from: c */
    private WeakReference<InterfaceC4397a> f23210c;

    /* renamed from: d */
    private Context f23211d;

    /* renamed from: com.unionpay.mobile.android.utils.q$a */
    /* loaded from: classes2.dex */
    public interface InterfaceC4397a {
        /* renamed from: a */
        void mo831a(int i, byte[] bArr);
    }

    public RunnableC4396q(Context context, String str, InterfaceC4397a interfaceC4397a) {
        this.f23208a = null;
        this.f23209b = null;
        this.f23210c = null;
        this.f23208a = new C4181d(0, str, null);
        this.f23209b = new Handler(this);
        this.f23210c = new WeakReference<>(interfaceC4397a);
        this.f23211d = context;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message2) {
        WeakReference<InterfaceC4397a> weakReference;
        if (message2.what != 0 || (weakReference = this.f23210c) == null || weakReference.get() == null) {
            return true;
        }
        this.f23210c.get().mo831a(message2.arg1, message2.obj != null ? (byte[]) message2.obj : null);
        return true;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C4180c c4180c = new C4180c(this.f23208a, this.f23211d);
        int m1529a = c4180c.m1529a();
        Handler handler = this.f23209b;
        if (handler != null) {
            Message obtainMessage = handler.obtainMessage();
            obtainMessage.what = 0;
            obtainMessage.arg1 = m1529a;
            obtainMessage.obj = c4180c.m1528b();
            this.f23209b.sendMessage(obtainMessage);
        }
    }
}
