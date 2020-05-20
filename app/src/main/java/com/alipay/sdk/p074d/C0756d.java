package com.alipay.sdk.p074d;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.text.TextUtils;

/* renamed from: com.alipay.sdk.d.d */
/* loaded from: classes.dex */
public final class C0756d {

    /* renamed from: a */
    private static boolean f3554a;

    static {
        f3554a = Build.VERSION.SDK_INT >= 11;
    }

    /* renamed from: a */
    public static Dialog m12508a(Context context, String str, String str2, String str3, DialogInterface.OnClickListener onClickListener, String str4, DialogInterface.OnClickListener onClickListener2) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        if (f3554a) {
            if (!TextUtils.isEmpty(str4)) {
                builder.setPositiveButton(str4, onClickListener2);
            }
            if (!TextUtils.isEmpty(str3)) {
                builder.setNegativeButton(str3, onClickListener);
            }
        } else {
            if (!TextUtils.isEmpty(str3)) {
                builder.setPositiveButton(str3, onClickListener);
            }
            if (!TextUtils.isEmpty(str4)) {
                builder.setNegativeButton(str4, onClickListener2);
            }
        }
        builder.setTitle(str);
        builder.setMessage(str2);
        AlertDialog create = builder.create();
        create.setCanceledOnTouchOutside(false);
        create.setOnKeyListener(new DialogInterface$OnKeyListenerC0757e());
        try {
            create.show();
        } catch (Throwable unused) {
        }
        return create;
    }
}
