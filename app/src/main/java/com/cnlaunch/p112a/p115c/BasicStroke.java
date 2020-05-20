package com.cnlaunch.p112a.p115c;

import android.graphics.Paint;
import com.itextpdf.text.pdf.ColumnText;
import java.io.Serializable;

/* renamed from: com.cnlaunch.a.c.a */
/* loaded from: classes.dex */
public final class BasicStroke implements Serializable {
    private Paint.Cap mCap;
    private float[] mIntervals;
    private Paint.Join mJoin;
    private float mMiter;
    private float mPhase;
    public static final BasicStroke SOLID = new BasicStroke(Paint.Cap.BUTT, Paint.Join.MITER, 4.0f, null, ColumnText.GLOBAL_SPACE_CHAR_RATIO);
    public static final BasicStroke DASHED = new BasicStroke(Paint.Cap.ROUND, Paint.Join.BEVEL, 10.0f, new float[]{10.0f, 10.0f}, 1.0f);
    public static final BasicStroke DOTTED = new BasicStroke(Paint.Cap.ROUND, Paint.Join.BEVEL, 5.0f, new float[]{2.0f, 10.0f}, 1.0f);

    public BasicStroke(Paint.Cap cap, Paint.Join join, float f, float[] fArr, float f2) {
        this.mCap = cap;
        this.mJoin = join;
        this.mMiter = f;
        this.mIntervals = fArr;
    }

    public final Paint.Cap getCap() {
        return this.mCap;
    }

    public final Paint.Join getJoin() {
        return this.mJoin;
    }

    public final float getMiter() {
        return this.mMiter;
    }

    public final float[] getIntervals() {
        return this.mIntervals;
    }

    public final float getPhase() {
        return this.mPhase;
    }
}
