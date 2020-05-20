package com.unionpay.mobile.android.utils;

import android.content.res.ColorStateList;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import com.itextpdf.text.pdf.ColumnText;
import java.util.Arrays;

/* renamed from: com.unionpay.mobile.android.utils.h */
/* loaded from: classes2.dex */
public final class C4387h {

    /* renamed from: a */
    private static final int[] f23184a = {16842910};

    /* renamed from: b */
    private static final int[] f23185b = {16842908};

    /* renamed from: c */
    private static final int[] f23186c = {-16842910};

    /* renamed from: d */
    private static final int[] f23187d = {16842910, 16842919};

    /* renamed from: e */
    private static final int[] f23188e = {16842910, 16842908};

    /* renamed from: f */
    private static final int[] f23189f = {16842910, 16842912};

    /* renamed from: a */
    public static ColorStateList m856a(int i, int i2) {
        return m854a(i, i2, i2, i);
    }

    /* renamed from: a */
    public static ColorStateList m854a(int i, int i2, int i3, int i4) {
        return new ColorStateList(new int[][]{new int[]{16842919, 16842910}, new int[]{16842910, 16842908}, new int[]{16842910}, new int[]{16842908}, new int[]{16842909}, new int[0]}, new int[]{i2, i3, i, i3, i4, i4});
    }

    /* renamed from: a */
    public static Drawable m853a(int i, int[] iArr, float[] fArr, float f, float f2, float f3, float f4) {
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(m857a(i, 18.0f), null, null));
        shapeDrawable.getPaint().setShader(new LinearGradient(f, f2, f3, f4, iArr, fArr, Shader.TileMode.CLAMP));
        return shapeDrawable;
    }

    /* renamed from: a */
    public static Drawable m852a(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(f23187d, drawable2);
        stateListDrawable.addState(f23188e, drawable2);
        if (drawable4 != null) {
            stateListDrawable.addState(f23189f, drawable4);
        }
        stateListDrawable.addState(f23184a, drawable);
        stateListDrawable.addState(f23185b, drawable2);
        if (drawable3 != null) {
            stateListDrawable.addState(f23186c, drawable3);
        }
        return stateListDrawable;
    }

    /* renamed from: a */
    public static ShapeDrawable m855a(int i, int i2, float f) {
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(m857a(i2, f), null, null));
        shapeDrawable.getPaint().setStrokeWidth(1.0f);
        shapeDrawable.getPaint().setColor(i);
        shapeDrawable.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
        return shapeDrawable;
    }

    /* renamed from: a */
    private static float[] m857a(int i, float f) {
        float[] fArr = new float[8];
        Arrays.fill(fArr, (float) ColumnText.GLOBAL_SPACE_CHAR_RATIO);
        if (i == 0) {
            return fArr;
        }
        if ((i & 1) != 0) {
            fArr[1] = f;
            fArr[0] = f;
        }
        if ((i & 2) != 0) {
            fArr[3] = f;
            fArr[2] = f;
        }
        if ((i & 4) != 0) {
            fArr[5] = f;
            fArr[4] = f;
        }
        if ((i & 8) != 0) {
            fArr[7] = f;
            fArr[6] = f;
        }
        return fArr;
    }
}
