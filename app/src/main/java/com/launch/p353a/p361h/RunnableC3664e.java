package com.launch.p353a.p361h;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.util.Log;
import com.launch.p353a.p356c.BaseHttp;
import com.launch.p353a.p362i.IHttpFinishedListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: ImageLoader.java */
/* renamed from: com.launch.a.h.e */
/* loaded from: classes.dex */
public final class RunnableC3664e extends BaseHttp implements Runnable {

    /* renamed from: f */
    public IHttpFinishedListener f19961f;

    /* renamed from: h */
    private Context f19963h;

    /* renamed from: g */
    Bitmap f19962g = null;

    /* renamed from: i */
    private Handler f19964i = new HandlerC3665f(this);

    public RunnableC3664e(Context context) {
        this.f19963h = null;
        this.f19963h = context;
    }

    /* renamed from: a */
    public final void m2654a() {
        try {
            if (this.f19963h == null) {
                Log.e("activity context", "context is null!!");
            } else if (!NetWorkUtils.m2651a(this.f19963h)) {
                if (this.f19961f != null) {
                    this.f19961f.mo2649a("The network is not available", -1);
                }
            } else {
                new Thread(this).start();
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    private static long m2652a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4096];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return j;
            }
            outputStream.write(bArr, 0, read);
            j += read;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:110:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x012f A[Catch: all -> 0x0146, TRY_LEAVE, TryCatch #4 {all -> 0x0146, blocks: (B:75:0x0128, B:77:0x012f), top: B:99:0x0128 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x014c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x013a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 343
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.launch.p353a.p361h.RunnableC3664e.run():void");
    }
}
