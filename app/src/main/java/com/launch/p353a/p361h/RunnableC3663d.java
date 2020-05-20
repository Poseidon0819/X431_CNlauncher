package com.launch.p353a.p361h;

import android.content.Context;
import android.util.Log;
import com.launch.p353a.p356c.BaseHttp;
import com.launch.p353a.p362i.IHttpFinishedListener;

/* compiled from: HttpUtils.java */
/* renamed from: com.launch.a.h.d */
/* loaded from: classes.dex */
public final class RunnableC3663d extends BaseHttp implements Runnable {

    /* renamed from: f */
    public IHttpFinishedListener f19959f = null;

    /* renamed from: g */
    private Context f19960g;

    public RunnableC3663d(Context context) {
        this.f19960g = null;
        this.f19960g = context;
    }

    /* renamed from: a */
    public final void m2655a() {
        try {
            if (this.f19960g == null) {
                Log.e("activity context", "context is null!!");
            } else if (!NetWorkUtils.m2651a(this.f19960g)) {
                if (this.f19959f != null) {
                    this.f19959f.mo2649a("The network is not available", -1);
                }
            } else {
                new Thread(this).start();
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:136:0x023a A[Catch: all -> 0x0262, TRY_LEAVE, TryCatch #1 {all -> 0x0262, blocks: (B:134:0x0233, B:136:0x023a), top: B:176:0x0233 }] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0261 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x024c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0267 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0245 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:184:0x026e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:186:0x027a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0258 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 644
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.launch.p353a.p361h.RunnableC3663d.run():void");
    }
}
