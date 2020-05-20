package com.alipay.sdk.auth;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import com.alipay.sdk.p074d.C0752a;

/* renamed from: com.alipay.sdk.auth.h */
/* loaded from: classes.dex */
public final class C0745h {

    /* renamed from: a */
    private static C0752a f3539a;

    /* renamed from: b */
    private static String f3540b;

    /* renamed from: a */
    public static void m12531a(Activity activity, String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            activity.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
        }
    }
}
