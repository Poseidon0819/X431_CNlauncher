package com.cnlaunch.p120d.p125c.p128c;

import android.content.Context;
import android.text.TextUtils;
import com.cnlaunch.p120d.p125c.p127b.DownloadParam;
import com.cnlaunch.p120d.p130d.MD5Utils;
import java.io.File;
import java.io.RandomAccessFile;
import org.apache.http.Header;

/* renamed from: com.cnlaunch.d.c.c.d */
/* loaded from: classes.dex */
public class BreakpointHttpResponseHandler extends AsyncHttpResponseHandler {

    /* renamed from: b */
    private long f7112b;

    /* renamed from: d */
    public Context f7113d;

    /* renamed from: e */
    public String f7114e;

    /* renamed from: f */
    public String f7115f;

    /* renamed from: g */
    public File f7116g;

    /* renamed from: h */
    public File f7117h;

    /* renamed from: i */
    long f7118i;

    /* renamed from: k */
    public C1426i f7120k;

    /* renamed from: l */
    boolean f7121l;

    /* renamed from: m */
    public String f7122m;

    /* renamed from: n */
    public int f7123n;

    /* renamed from: o */
    public String f7124o;

    /* renamed from: p */
    private long f7125p;

    /* renamed from: q */
    private RandomAccessFile f7126q;

    /* renamed from: r */
    private int f7127r;

    /* renamed from: t */
    private String f7129t;

    /* renamed from: a */
    private final String f7111a = BreakpointHttpResponseHandler.class.getSimpleName();

    /* renamed from: j */
    public boolean f7119j = false;

    /* renamed from: s */
    private long f7128s = 0;

    /* renamed from: a */
    public void mo9518a(File file) {
    }

    /* renamed from: a */
    public void mo9517a(File file, Header[] headerArr) {
    }

    public BreakpointHttpResponseHandler(DownloadParam downloadParam) {
        this.f7121l = false;
        try {
            this.f7113d = downloadParam.f7076a;
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.f7114e = downloadParam.f7079d;
        this.f7120k = downloadParam.f7077b;
        this.f7121l = downloadParam.f7083h;
        this.f7123n = downloadParam.f7084i;
        this.f7122m = downloadParam.f7085j;
        this.f7129t = downloadParam.f7086k;
        this.f7124o = downloadParam.f7088m;
        if (TextUtils.isEmpty(downloadParam.f7080e)) {
            String str = this.f7114e;
            StringBuilder sb = new StringBuilder(MD5Utils.m9460a(str));
            if (!TextUtils.isEmpty(str) && str.indexOf(".") > 0) {
                sb.append(str.substring(str.lastIndexOf("."), str.length()));
            }
            this.f7115f = sb.toString();
        } else {
            this.f7115f = downloadParam.f7080e;
        }
        this.f7117h = new File(downloadParam.f7081f, this.f7115f);
        String str2 = downloadParam.f7081f;
        this.f7116g = new File(str2, this.f7115f + ".download");
        if (this.f7121l) {
            if (this.f7116g.exists()) {
                this.f7118i = this.f7116g.length();
                return;
            } else {
                this.f7118i = 0L;
                return;
            }
        }
        this.f7118i = 0L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:130:0x0458, code lost:
        r15 = r4;
        r16 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x045d, code lost:
        if (r23.f7119j != false) goto L245;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x045f, code lost:
        mo9495b((int) r23.f7125p, (int) r23.f7112b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x0468, code lost:
        if (r12 <= 0) goto L219;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x046a, code lost:
        r23.f7126q.write(r11, 0, r12);
        com.cnlaunch.p120d.p130d.NLog.m9456a(r23.f7111a, "randomAccessFile.write 1: ".concat(java.lang.String.valueOf(r12)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x048e, code lost:
        com.cnlaunch.p120d.p130d.NLog.m9456a(r23.f7111a, "contentLength: " + r8 + ", downloadSize: " + r23.f7125p);
        r23.f7128s = java.lang.System.currentTimeMillis() - r6;
        m9521b((int) r23.f7125p, (int) (r23.f7128s / 1000), r23.f7122m, r23.f7115f);
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x04d0, code lost:
        if (java.lang.Thread.currentThread().isInterrupted() != false) goto L243;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x04d4, code lost:
        if (r23.f7119j != false) goto L243;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x04dc, code lost:
        if (r23.f7125p == r23.f7112b) goto L243;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x04e4, code lost:
        if (r23.f7112b == (-1)) goto L243;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x04e8, code lost:
        if (r23.f7121l == false) goto L241;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x04f1, code lost:
        if ((r23.f7125p - r23.f7118i) < r8) goto L241;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x04f3, code lost:
        r2 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x04fc, code lost:
        throw new java.io.IOException("Fail download. totalSize not eq downloadSize.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x04fd, code lost:
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x04fe, code lost:
        new java.lang.Thread(new com.cnlaunch.p120d.p125c.p128c.RunnableC1424e(r23, r16, r24, r25)).start();
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x0513, code lost:
        if (r23.f7126q == null) goto L238;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x0515, code lost:
        r23.f7126q.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x051a, code lost:
        r10 = r2;
        r9 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x051e, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x051f, code lost:
        r9 = r0;
        r9.printStackTrace();
        r10 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x052c, code lost:
        mo9499a(r15.getStatusCode(), r24.getAllHeaders(), "Stop".getBytes(), new org.apache.http.client.HttpResponseException(-1, "Stop"));
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x054c, code lost:
        throw new java.io.IOException("Stop");
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x054d, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x054e, code lost:
        r9 = r16;
        r5 = r24;
        r8 = r25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x0556, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x0557, code lost:
        r9 = r16;
        r5 = r24;
        r8 = r25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x055e, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x055f, code lost:
        r9 = r16;
        r5 = r24;
        r8 = r25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x0566, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x0567, code lost:
        r9 = r16;
        r5 = r24;
        r8 = r25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x0596, code lost:
        r2 = r9;
        r10 = null;
        r9 = r0;
        r5 = r5;
        r8 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x059b, code lost:
        r2 = r9;
        r10 = null;
        r9 = r0;
        r5 = r5;
        r8 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x05a0, code lost:
        r2 = r9;
        r10 = null;
        r9 = r0;
        r5 = r5;
        r8 = r8;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:220:0x05da A[Catch: IOException -> 0x0622, TRY_LEAVE, TryCatch #34 {IOException -> 0x0622, blocks: (B:218:0x05d6, B:220:0x05da, B:229:0x05f7, B:231:0x05fb, B:240:0x0618, B:242:0x061c), top: B:285:0x0297 }] */
    /* JADX WARN: Removed duplicated region for block: B:231:0x05fb A[Catch: IOException -> 0x0622, TRY_LEAVE, TryCatch #34 {IOException -> 0x0622, blocks: (B:218:0x05d6, B:220:0x05da, B:229:0x05f7, B:231:0x05fb, B:240:0x0618, B:242:0x061c), top: B:285:0x0297 }] */
    /* JADX WARN: Removed duplicated region for block: B:242:0x061c A[Catch: IOException -> 0x0622, TRY_LEAVE, TryCatch #34 {IOException -> 0x0622, blocks: (B:218:0x05d6, B:220:0x05da, B:229:0x05f7, B:231:0x05fb, B:240:0x0618, B:242:0x061c), top: B:285:0x0297 }] */
    /* JADX WARN: Removed duplicated region for block: B:248:0x0648  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x06f5 A[Catch: IOException -> 0x06fb, TRY_LEAVE, TryCatch #21 {IOException -> 0x06fb, blocks: (B:269:0x06f1, B:271:0x06f5), top: B:282:0x06f1 }] */
    /* JADX WARN: Removed duplicated region for block: B:325:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r10v36 */
    /* JADX WARN: Type inference failed for: r10v37 */
    /* JADX WARN: Type inference failed for: r10v38 */
    /* JADX WARN: Type inference failed for: r11v8, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r23v0, types: [com.cnlaunch.d.c.c.d] */
    /* JADX WARN: Type inference failed for: r2v63 */
    /* JADX WARN: Type inference failed for: r2v64 */
    /* JADX WARN: Type inference failed for: r2v72 */
    /* JADX WARN: Type inference failed for: r3v30, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v38 */
    /* JADX WARN: Type inference failed for: r5v39 */
    /* JADX WARN: Type inference failed for: r5v40 */
    /* JADX WARN: Type inference failed for: r5v41 */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v27, types: [long] */
    /* JADX WARN: Type inference failed for: r8v28 */
    /* JADX WARN: Type inference failed for: r8v29 */
    /* JADX WARN: Type inference failed for: r8v30 */
    /* JADX WARN: Type inference failed for: r8v32 */
    /* JADX WARN: Type inference failed for: r8v33 */
    /* JADX WARN: Type inference failed for: r8v34 */
    /* JADX WARN: Type inference failed for: r8v35 */
    /* JADX WARN: Type inference failed for: r8v36 */
    /* JADX WARN: Type inference failed for: r8v37 */
    /* JADX WARN: Type inference failed for: r8v38 */
    /* JADX WARN: Type inference failed for: r8v39 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v49 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v81 */
    /* JADX WARN: Type inference failed for: r8v84 */
    /* JADX WARN: Type inference failed for: r8v85 */
    /* JADX WARN: Type inference failed for: r8v86 */
    /* JADX WARN: Type inference failed for: r8v87 */
    /* JADX WARN: Type inference failed for: r8v88 */
    /* JADX WARN: Type inference failed for: r8v89 */
    /* JADX WARN: Type inference failed for: r8v90 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:245:0x0623 -> B:277:0x0627). Please submit an issue!!! */
    @Override // com.cnlaunch.p120d.p125c.p128c.AsyncHttpResponseHandler, com.cnlaunch.p120d.p125c.p128c.ResponseHandlerInterface
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void mo9497a(org.apache.http.client.methods.CloseableHttpResponse r24, org.apache.http.client.methods.HttpUriRequest r25) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1794
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.p120d.p125c.p128c.BreakpointHttpResponseHandler.mo9497a(org.apache.http.client.methods.CloseableHttpResponse, org.apache.http.client.methods.HttpUriRequest):void");
    }

    public String toString() {
        return "BreakpointHttpResponseHandler{fileName='" + this.f7115f + "', downLoadId='" + this.f7122m + "', softName='" + this.f7129t + "'}";
    }

    @Override // com.cnlaunch.p120d.p125c.p128c.AsyncHttpResponseHandler
    /* renamed from: a */
    public void mo9515a(Header[] headerArr, byte[] bArr, Throwable th) {
        mo9524a(th);
    }

    @Override // com.cnlaunch.p120d.p125c.p128c.AsyncHttpResponseHandler
    /* renamed from: a */
    public final void mo9516a(Header[] headerArr, byte[] bArr) {
        File file = this.f7117h;
        mo9518a(file);
        mo9517a(file, headerArr);
    }
}
