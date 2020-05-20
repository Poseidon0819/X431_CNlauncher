package com.launch.p353a.p358e;

import android.support.p012v4.view.ViewPager;
import android.view.View;
import com.itextpdf.text.pdf.ColumnText;

/* renamed from: com.launch.a.e.b */
/* loaded from: classes.dex */
public final class DepthPageTransformer implements ViewPager.InterfaceC0177f {
    @Override // android.support.p012v4.view.ViewPager.InterfaceC0177f
    /* renamed from: a */
    public final void mo2697a(View view, float f) {
        int width = view.getWidth();
        if (f >= -1.0f) {
            if (f <= ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
                view.setAlpha(1.0f);
                view.setTranslationX(ColumnText.GLOBAL_SPACE_CHAR_RATIO);
                view.setScaleX(1.0f);
                view.setScaleY(1.0f);
                return;
            } else if (f <= 1.0f) {
                view.setAlpha(1.0f - f);
                view.setTranslationX(width * (-f));
                float abs = ((1.0f - Math.abs(f)) * ColumnText.GLOBAL_SPACE_CHAR_RATIO) + 1.0f;
                view.setScaleX(abs);
                view.setScaleY(abs);
                return;
            }
        }
        view.setAlpha(ColumnText.GLOBAL_SPACE_CHAR_RATIO);
    }
}
