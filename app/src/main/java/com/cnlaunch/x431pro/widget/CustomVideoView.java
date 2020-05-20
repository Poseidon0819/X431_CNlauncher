package com.cnlaunch.x431pro.widget;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.VideoView;

/* loaded from: classes.dex */
public class CustomVideoView extends VideoView {

    /* renamed from: a */
    private int f15959a;

    /* renamed from: b */
    private int f15960b;

    public CustomVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.widget.VideoView, android.view.SurfaceView, android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(getDefaultSize(getVideoWidth(), i), getDefaultSize(getVideoHeight(), i2));
    }

    public int getVideoHeight() {
        return this.f15960b;
    }

    public void setVideoHeight(int i) {
        this.f15960b = i;
    }

    public int getVideoWidth() {
        return this.f15959a;
    }

    public void setVideoWidth(int i) {
        this.f15959a = i;
    }

    public void setVideoScale(Point point) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = point.y;
        layoutParams.width = point.x;
        setLayoutParams(layoutParams);
    }
}
