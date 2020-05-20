package com.cnlaunch.physics.p205k;

import android.util.Log;
import com.baidu.mapapi.UIMsg;
import com.cnlaunch.physics.p199e.IPhysics;
import java.io.OutputStream;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.cnlaunch.physics.k.k */
/* loaded from: classes.dex */
public final class DownloadBinWriteByte implements Runnable {

    /* renamed from: a */
    public static int f10118a = 8000;

    /* renamed from: b */
    private OutputStream f10119b;

    /* renamed from: c */
    private byte[] f10120c;

    /* renamed from: d */
    private String f10121d = "WriteByteData";

    /* renamed from: e */
    private Timer f10122e;

    /* renamed from: f */
    private IPhysics f10123f;

    /* renamed from: g */
    private Bridge f10124g;

    public DownloadBinWriteByte(Bridge bridge, byte[] bArr, IPhysics iPhysics) {
        this.f10123f = null;
        this.f10120c = bArr;
        this.f10123f = iPhysics;
        f10118a = UIMsg.d_ResultType.SHORT_URL;
        this.f10124g = bridge;
    }

    public DownloadBinWriteByte(Bridge bridge, byte[] bArr, IPhysics iPhysics, byte b) {
        this.f10123f = null;
        this.f10120c = bArr;
        this.f10123f = iPhysics;
        this.f10124g = bridge;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f10119b = this.f10123f.getOutputStream();
            this.f10119b.write(this.f10120c);
            this.f10122e = null;
            this.f10122e = new Timer();
            this.f10122e.schedule(new C1855a(), f10118a);
            this.f10124g.m8202a();
        } catch (Exception e) {
            Log.e(this.f10121d, "Exception during write", e);
        }
    }

    /* compiled from: DownloadBinWriteByte.java */
    /* renamed from: com.cnlaunch.physics.k.k$a */
    /* loaded from: classes.dex */
    class C1855a extends TimerTask {
        C1855a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
            DownloadBinWriteByte.this.f10124g.m8201b();
        }
    }
}
