package com.mopub.common;

import android.graphics.Point;
import android.net.Uri;
import android.text.TextUtils;
import com.mopub.network.Networking;
import com.mopub.network.PlayServicesUrlRewriter;

/* loaded from: classes.dex */
public abstract class BaseUrlGenerator {

    /* renamed from: a */
    private boolean f19981a;

    /* renamed from: e */
    protected StringBuilder f19982e;

    public abstract String generateUrlString(String str);

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final void m2609a(String str, String str2) {
        StringBuilder sb = new StringBuilder(Networking.getScheme());
        sb.append("://");
        sb.append(str);
        sb.append(str2);
        this.f19982e = sb;
        this.f19981a = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public final void m2604b(String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        StringBuilder sb = this.f19982e;
        if (this.f19981a) {
            this.f19981a = false;
            str3 = "?";
        } else {
            str3 = "&";
        }
        sb.append(str3);
        this.f19982e.append(str);
        this.f19982e.append("=");
        this.f19982e.append(Uri.encode(str2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final void m2610a(String str) {
        m2604b("v", str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public final void m2605b(String str) {
        m2604b("av", str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final void m2608a(boolean z) {
        m2604b("android_perms_ext_storage", z ? "1" : "0");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final void m2607a(String... strArr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            sb.append(strArr[i]);
            sb.append(",");
        }
        sb.append(strArr[2]);
        m2604b("dn", sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public final void m2606b() {
        m2604b("udid", PlayServicesUrlRewriter.UDID_TEMPLATE);
        m2604b("dnt", PlayServicesUrlRewriter.DO_NOT_TRACK_TEMPLATE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final void m2611a(Point point) {
        StringBuilder sb = new StringBuilder();
        sb.append(point.x);
        m2604b("w", sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(point.y);
        m2604b("h", sb2.toString());
    }
}
