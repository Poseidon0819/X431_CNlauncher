package com.cnlaunch.p120d.p125c.p127b;

import android.text.TextUtils;
import com.cnlaunch.p120d.p125c.p128c.AsyncHttpResponseHandler;
import com.cnlaunch.p120d.p125c.p128c.BreakpointHttpResponseHandler;
import com.cnlaunch.p120d.p130d.NLog;
import java.io.File;
import org.apache.http.Header;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DownloadManager.java */
/* renamed from: com.cnlaunch.d.c.b.c */
/* loaded from: classes.dex */
public final class C1422c extends BreakpointHttpResponseHandler {

    /* renamed from: a */
    final /* synthetic */ DownloadParam f7074a;

    /* renamed from: b */
    final /* synthetic */ DownloadManager f7075b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1422c(DownloadManager downloadManager, DownloadParam downloadParam, DownloadParam downloadParam2) {
        super(downloadParam);
        this.f7075b = downloadManager;
        this.f7074a = downloadParam2;
    }

    @Override // com.cnlaunch.p120d.p125c.p128c.AsyncHttpResponseHandler
    /* renamed from: a */
    public final void mo9529a(int i, int i2) {
        DownLoadCallback downLoadCallback;
        DownLoadCallback downLoadCallback2;
        DownLoadCallback downLoadCallback3;
        DownLoadCallback downLoadCallback4;
        super.mo9529a(i, i2);
        downLoadCallback = this.f7075b.f7053a;
        if (downLoadCallback != null) {
            downLoadCallback4 = this.f7075b.f7053a;
            downLoadCallback4.m9568b(((BreakpointHttpResponseHandler) this).f7115f, i, i2);
        }
        downLoadCallback2 = this.f7075b.f7054b;
        if (downLoadCallback2 != null) {
            downLoadCallback3 = this.f7075b.f7054b;
            downLoadCallback3.m9568b(((BreakpointHttpResponseHandler) this).f7115f, i, i2);
        }
    }

    @Override // com.cnlaunch.p120d.p125c.p128c.BreakpointHttpResponseHandler
    /* renamed from: a */
    public final void mo9518a(File file) {
        DownLoadCallback downLoadCallback;
        DownLoadCallback downLoadCallback2;
        String str;
        DownLoadCallback downLoadCallback3;
        String str2;
        DownLoadCallback downLoadCallback4;
        downLoadCallback = this.f7075b.f7053a;
        if (downLoadCallback != null && file != null) {
            str2 = this.f7075b.f7057f;
            NLog.m9456a(str2, "onSuccess: " + ((BreakpointHttpResponseHandler) this).f7115f);
            downLoadCallback4 = this.f7075b.f7053a;
            downLoadCallback4.m9567c(((BreakpointHttpResponseHandler) this).f7115f, file.getPath());
        }
        downLoadCallback2 = this.f7075b.f7054b;
        if (downLoadCallback2 == null || file == null) {
            return;
        }
        str = this.f7075b.f7057f;
        NLog.m9456a(str, "onSuccess: " + ((BreakpointHttpResponseHandler) this).f7115f);
        downLoadCallback3 = this.f7075b.f7054b;
        downLoadCallback3.m9567c(((BreakpointHttpResponseHandler) this).f7115f, file.getPath());
    }

    @Override // com.cnlaunch.p120d.p125c.p128c.BreakpointHttpResponseHandler
    /* renamed from: a */
    public final void mo9517a(File file, Header[] headerArr) {
        DownLoadCallback downLoadCallback;
        DownLoadCallback downLoadCallback2;
        String str;
        DownLoadCallback downLoadCallback3;
        String str2;
        DownLoadCallback downLoadCallback4;
        downLoadCallback = this.f7075b.f7053a;
        if (downLoadCallback != null && file != null && this.f7074a != null) {
            str2 = this.f7075b.f7057f;
            NLog.m9456a(str2, "onSuccess: " + ((BreakpointHttpResponseHandler) this).f7115f);
            downLoadCallback4 = this.f7075b.f7053a;
            downLoadCallback4.sendMessage(downLoadCallback4.obtainMessage(9, new Object[]{((BreakpointHttpResponseHandler) this).f7115f, file.getPath(), headerArr, this.f7074a}));
        }
        downLoadCallback2 = this.f7075b.f7054b;
        if (downLoadCallback2 == null || file == null || this.f7074a == null) {
            return;
        }
        str = this.f7075b.f7057f;
        NLog.m9456a(str, "onSuccess: " + ((BreakpointHttpResponseHandler) this).f7115f);
        downLoadCallback3 = this.f7075b.f7054b;
        downLoadCallback3.sendMessage(downLoadCallback3.obtainMessage(8, new Object[]{((BreakpointHttpResponseHandler) this).f7115f, file.getPath(), headerArr}));
    }

    @Override // com.cnlaunch.p120d.p125c.p128c.AsyncHttpResponseHandler
    /* renamed from: a */
    public final void mo9530a() {
        String str;
        str = this.f7075b.f7057f;
        NLog.m9456a(str, "onFinish: " + ((BreakpointHttpResponseHandler) this).f7115f);
        this.f7075b.m9546c(this);
    }

    @Override // com.cnlaunch.p120d.p125c.p128c.AsyncHttpResponseHandler
    /* renamed from: b */
    public final void mo9522b() {
        DownLoadCallback downLoadCallback;
        DownLoadCallback downLoadCallback2;
        String str;
        DownLoadCallback unused;
        DownLoadCallback unused2;
        downLoadCallback = this.f7075b.f7053a;
        if (downLoadCallback != null) {
            unused = this.f7075b.f7053a;
        }
        downLoadCallback2 = this.f7075b.f7054b;
        if (downLoadCallback2 != null) {
            unused2 = this.f7075b.f7054b;
        }
        str = this.f7075b.f7057f;
        NLog.m9456a(str, "onStart: " + ((BreakpointHttpResponseHandler) this).f7115f);
    }

    @Override // com.cnlaunch.p120d.p125c.p128c.BreakpointHttpResponseHandler, com.cnlaunch.p120d.p125c.p128c.AsyncHttpResponseHandler
    /* renamed from: a */
    public final void mo9515a(Header[] headerArr, byte[] bArr, Throwable th) {
        String str;
        boolean z;
        String str2;
        boolean z2;
        DownLoadCallback downLoadCallback;
        DownLoadCallback downLoadCallback2;
        DownLoadCallback downLoadCallback3;
        DownLoadCallback downLoadCallback4;
        DownLoadCallback downLoadCallback5;
        DownloadParam downloadParam;
        String message2 = th != null ? th.getMessage() : "";
        str = this.f7075b.f7057f;
        NLog.m9456a(str, "onFailure: " + ((BreakpointHttpResponseHandler) this).f7115f);
        if (TextUtils.isEmpty(message2)) {
            message2 = "onFailure";
        }
        z = this.f7075b.f7069r;
        if (z && (downloadParam = this.f7074a) != null && downloadParam.f7087l == 3) {
            message2 = "TooMuchFailure";
        }
        if (((BreakpointHttpResponseHandler) this).f7115f != null) {
            downLoadCallback3 = this.f7075b.f7053a;
            if (downLoadCallback3 != null && this.f7074a != null) {
                downLoadCallback4 = this.f7075b.f7053a;
                downLoadCallback4.sendMessage(downLoadCallback4.obtainMessage(12, new Object[]{((BreakpointHttpResponseHandler) this).f7115f, message2, this.f7074a, headerArr}));
                downLoadCallback5 = this.f7075b.f7053a;
                downLoadCallback5.m9571a(((BreakpointHttpResponseHandler) this).f7115f, message2, headerArr);
            }
        }
        str2 = this.f7075b.f7057f;
        NLog.m9456a(str2, "onFailure: " + ((BreakpointHttpResponseHandler) this).f7115f);
        if (TextUtils.isEmpty(message2)) {
            message2 = "onFailure";
        }
        if (((BreakpointHttpResponseHandler) this).f7115f != null) {
            downLoadCallback = this.f7075b.f7054b;
            if (downLoadCallback != null) {
                downLoadCallback2 = this.f7075b.f7054b;
                downLoadCallback2.m9571a(((BreakpointHttpResponseHandler) this).f7115f, message2, headerArr);
            }
        }
        this.f7075b.m9560a((AsyncHttpResponseHandler) this);
        z2 = this.f7075b.f7069r;
        if (!z2 || this.f7074a == null || "TooMuchFailure".equals(message2) || "Stop".equals(message2) || "ENOSPC".equals(message2) || "ETIMEDOUT".equals(message2)) {
            return;
        }
        if (message2 == null || !message2.contains("UnknownHostException")) {
            if ((message2 == null || !message2.contains("645")) && !"Token is invalid!".equals(message2)) {
                this.f7074a.f7087l++;
            }
        }
    }

    @Override // com.cnlaunch.p120d.p125c.p128c.AsyncHttpResponseHandler
    /* renamed from: a */
    public final void mo9524a(Throwable th) {
        String str;
        boolean z;
        String str2;
        boolean z2;
        DownLoadCallback downLoadCallback;
        DownLoadCallback downLoadCallback2;
        DownLoadCallback downLoadCallback3;
        DownLoadCallback downLoadCallback4;
        DownLoadCallback downLoadCallback5;
        DownloadParam downloadParam;
        String message2 = th != null ? th.getMessage() : "";
        str = this.f7075b.f7057f;
        NLog.m9456a(str, "onFailure: " + ((BreakpointHttpResponseHandler) this).f7115f);
        if (TextUtils.isEmpty(message2)) {
            message2 = "onFailure";
        }
        z = this.f7075b.f7069r;
        if (z && (downloadParam = this.f7074a) != null && downloadParam.f7087l == 3) {
            message2 = "TooMuchFailure";
        }
        if (((BreakpointHttpResponseHandler) this).f7115f != null) {
            downLoadCallback3 = this.f7075b.f7053a;
            if (downLoadCallback3 != null && this.f7074a != null) {
                downLoadCallback4 = this.f7075b.f7053a;
                downLoadCallback4.sendMessage(downLoadCallback4.obtainMessage(10, new Object[]{((BreakpointHttpResponseHandler) this).f7115f, message2, this.f7074a}));
                downLoadCallback5 = this.f7075b.f7053a;
                downLoadCallback5.m9566d(((BreakpointHttpResponseHandler) this).f7115f, message2);
            }
        }
        str2 = this.f7075b.f7057f;
        NLog.m9456a(str2, "onFailure: " + ((BreakpointHttpResponseHandler) this).f7115f);
        if (TextUtils.isEmpty(message2)) {
            message2 = "onFailure";
        }
        if (((BreakpointHttpResponseHandler) this).f7115f != null) {
            downLoadCallback = this.f7075b.f7054b;
            if (downLoadCallback != null) {
                downLoadCallback2 = this.f7075b.f7054b;
                downLoadCallback2.m9566d(((BreakpointHttpResponseHandler) this).f7115f, message2);
            }
        }
        this.f7075b.m9560a((AsyncHttpResponseHandler) this);
        z2 = this.f7075b.f7069r;
        if (!z2 || this.f7074a == null || "TooMuchFailure".equals(message2) || "Stop".equals(message2) || "ENOSPC".equals(message2) || "ETIMEDOUT".equals(message2)) {
            return;
        }
        if (message2 == null || !message2.contains("UnknownHostException")) {
            if ((message2 == null || !message2.contains("645")) && !"Token is invalid!".equals(message2)) {
                this.f7074a.f7087l++;
            }
        }
    }

    @Override // com.cnlaunch.p120d.p125c.p128c.AsyncHttpResponseHandler
    /* renamed from: a */
    public final void mo9528a(int i, int i2, String str, String str2) {
        DownLoadCallback downLoadCallback;
        DownLoadCallback downLoadCallback2;
        DownLoadCallback downLoadCallback3;
        DownLoadCallback downLoadCallback4;
        super.mo9528a(i, i2, str, str2);
        downLoadCallback = this.f7075b.f7053a;
        if (downLoadCallback != null) {
            downLoadCallback4 = this.f7075b.f7053a;
            downLoadCallback4.m9569b(i, i2, str, str2);
        }
        downLoadCallback2 = this.f7075b.f7054b;
        if (downLoadCallback2 != null) {
            downLoadCallback3 = this.f7075b.f7054b;
            downLoadCallback3.m9569b(i, i2, str, str2);
        }
    }
}
