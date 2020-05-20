package com.afollestad.materialdialogs.internal;

import android.content.Context;
import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import java.util.Locale;

/* compiled from: AllCapsTransformationMethod.java */
/* renamed from: com.afollestad.materialdialogs.internal.a */
/* loaded from: classes.dex */
final class C0715a implements TransformationMethod {

    /* renamed from: a */
    private Locale f3466a;

    @Override // android.text.method.TransformationMethod
    public final void onFocusChanged(View view, CharSequence charSequence, boolean z, int i, Rect rect) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0715a(Context context) {
        this.f3466a = context.getResources().getConfiguration().locale;
    }

    @Override // android.text.method.TransformationMethod
    public final CharSequence getTransformation(CharSequence charSequence, View view) {
        if (charSequence != null) {
            return charSequence.toString().toUpperCase(this.f3466a);
        }
        return null;
    }
}
