package com.baidu.location.p084g;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.baidu.android.bbalbs.common.util.C0863b;
import com.baidu.android.bbalbs.common.util.CommonParam;
import com.baidu.location.ServiceC1002f;
import com.itextpdf.text.pdf.PdfContentParser;

/* renamed from: com.baidu.location.g.b */
/* loaded from: classes.dex */
public class C1006b {

    /* renamed from: d */
    public static String f4490d;

    /* renamed from: e */
    public static String f4491e;

    /* renamed from: f */
    public static String f4492f;

    /* renamed from: g */
    public static String f4493g;

    /* renamed from: h */
    private static C1006b f4494h;

    /* renamed from: a */
    public String f4495a = null;

    /* renamed from: b */
    public String f4496b = null;

    /* renamed from: c */
    public String f4497c = null;

    /* renamed from: i */
    private boolean f4498i = false;

    private C1006b() {
        if (ServiceC1002f.getServiceContext() != null) {
            m11602a(ServiceC1002f.getServiceContext());
        }
    }

    /* renamed from: a */
    public static C1006b m11603a() {
        if (f4494h == null) {
            f4494h = new C1006b();
        }
        return f4494h;
    }

    /* renamed from: a */
    public String m11600a(boolean z) {
        return m11599a(z, (String) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x011e  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String m11599a(boolean r6, java.lang.String r7) {
        /*
            Method dump skipped, instructions count: 314
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p084g.C1006b.m11599a(boolean, java.lang.String):java.lang.String");
    }

    /* renamed from: a */
    public void m11602a(Context context) {
        if (context == null || this.f4498i) {
            return;
        }
        try {
            this.f4495a = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (Exception unused) {
            this.f4495a = "NULL";
        }
        try {
            this.f4496b = CommonParam.m12426a(context);
        } catch (Exception unused2) {
            this.f4496b = null;
        }
        try {
            this.f4497c = C0863b.m12412b(context);
        } catch (Exception unused3) {
            this.f4497c = null;
        }
        try {
            f4490d = context.getPackageName();
        } catch (Exception unused4) {
            f4490d = null;
        }
        C1016g.f4604n = this.f4496b;
        this.f4498i = true;
    }

    /* renamed from: a */
    public void m11601a(String str, String str2) {
        f4491e = str;
        f4490d = str2;
    }

    /* renamed from: b */
    public String m11598b() {
        StringBuilder sb;
        String str;
        if (this.f4496b != null) {
            sb = new StringBuilder("v7.51|");
            str = this.f4496b;
        } else {
            sb = new StringBuilder("v7.51|");
            str = this.f4495a;
        }
        sb.append(str);
        sb.append("|");
        sb.append(Build.MODEL);
        return sb.toString();
    }

    /* renamed from: c */
    public String m11597c() {
        String str;
        StringBuffer stringBuffer = new StringBuffer((int) PdfContentParser.COMMAND_TYPE);
        if (this.f4496b != null) {
            stringBuffer.append("&cu=");
            str = this.f4496b;
        } else {
            stringBuffer.append("&im=");
            str = this.f4495a;
        }
        stringBuffer.append(str);
        try {
            stringBuffer.append("&mb=");
            stringBuffer.append(Build.MODEL);
        } catch (Exception unused) {
        }
        stringBuffer.append("&pack=");
        try {
            stringBuffer.append(f4490d);
        } catch (Exception unused2) {
        }
        stringBuffer.append("&sdk=");
        stringBuffer.append(7.51f);
        return stringBuffer.toString();
    }

    /* renamed from: d */
    public String m11596d() {
        if (f4490d != null) {
            return m11598b() + "|" + f4490d;
        }
        return m11598b();
    }

    /* renamed from: e */
    public String m11595e() {
        String str;
        StringBuffer stringBuffer = new StringBuffer();
        if (this.f4496b == null) {
            stringBuffer.append("&im=");
            str = this.f4495a;
        } else {
            stringBuffer.append("&cu=");
            str = this.f4496b;
        }
        stringBuffer.append(str);
        stringBuffer.append("&sdk=");
        stringBuffer.append(7.51f);
        stringBuffer.append("&mb=");
        stringBuffer.append(Build.MODEL);
        stringBuffer.append("&os=A");
        stringBuffer.append(Build.VERSION.SDK);
        stringBuffer.append("&prod=");
        stringBuffer.append(f4491e + ":" + f4490d);
        stringBuffer.append(C1016g.m11552e(ServiceC1002f.getServiceContext()));
        stringBuffer.append("&resid=");
        stringBuffer.append("12");
        return stringBuffer.toString();
    }
}
