package com.afollestad.materialdialogs.p069a;

import android.content.Context;
import android.content.res.TypedArray;

/* renamed from: com.afollestad.materialdialogs.a.a */
/* loaded from: classes.dex */
public final class DialogUtils {
    /* renamed from: a */
    public static int m12575a(Context context, int i) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i});
        try {
            return obtainStyledAttributes.getColor(0, 0);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }
}
