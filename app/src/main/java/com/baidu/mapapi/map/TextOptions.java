package com.baidu.mapapi.map;

import android.graphics.Typeface;
import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;

/* loaded from: classes.dex */
public final class TextOptions extends OverlayOptions {
    public static final int ALIGN_BOTTOM = 16;
    public static final int ALIGN_CENTER_HORIZONTAL = 4;
    public static final int ALIGN_CENTER_VERTICAL = 32;
    public static final int ALIGN_LEFT = 1;
    public static final int ALIGN_RIGHT = 2;
    public static final int ALIGN_TOP = 8;

    /* renamed from: a */
    int f5276a;

    /* renamed from: c */
    Bundle f5278c;

    /* renamed from: d */
    private String f5279d;

    /* renamed from: e */
    private LatLng f5280e;

    /* renamed from: f */
    private int f5281f;

    /* renamed from: i */
    private Typeface f5284i;

    /* renamed from: l */
    private float f5287l;

    /* renamed from: g */
    private int f5282g = -16777216;

    /* renamed from: h */
    private int f5283h = 12;

    /* renamed from: j */
    private int f5285j = 4;

    /* renamed from: k */
    private int f5286k = 32;

    /* renamed from: b */
    boolean f5277b = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.mapapi.map.OverlayOptions
    /* renamed from: a */
    public final Overlay mo11137a() {
        Text text = new Text();
        text.f5203x = this.f5277b;
        text.f5202w = this.f5276a;
        text.f5204y = this.f5278c;
        text.f5266a = this.f5279d;
        text.f5267b = this.f5280e;
        text.f5268c = this.f5281f;
        text.f5269d = this.f5282g;
        text.f5270e = this.f5283h;
        text.f5271f = this.f5284i;
        text.f5272g = this.f5285j;
        text.f5273h = this.f5286k;
        text.f5274i = this.f5287l;
        return text;
    }

    public final TextOptions align(int i, int i2) {
        this.f5285j = i;
        this.f5286k = i2;
        return this;
    }

    public final TextOptions bgColor(int i) {
        this.f5281f = i;
        return this;
    }

    public final TextOptions extraInfo(Bundle bundle) {
        this.f5278c = bundle;
        return this;
    }

    public final TextOptions fontColor(int i) {
        this.f5282g = i;
        return this;
    }

    public final TextOptions fontSize(int i) {
        this.f5283h = i;
        return this;
    }

    public final float getAlignX() {
        return this.f5285j;
    }

    public final float getAlignY() {
        return this.f5286k;
    }

    public final int getBgColor() {
        return this.f5281f;
    }

    public final Bundle getExtraInfo() {
        return this.f5278c;
    }

    public final int getFontColor() {
        return this.f5282g;
    }

    public final int getFontSize() {
        return this.f5283h;
    }

    public final LatLng getPosition() {
        return this.f5280e;
    }

    public final float getRotate() {
        return this.f5287l;
    }

    public final String getText() {
        return this.f5279d;
    }

    public final Typeface getTypeface() {
        return this.f5284i;
    }

    public final int getZIndex() {
        return this.f5276a;
    }

    public final boolean isVisible() {
        return this.f5277b;
    }

    public final TextOptions position(LatLng latLng) {
        if (latLng != null) {
            this.f5280e = latLng;
            return this;
        }
        throw new IllegalArgumentException("position can not be null");
    }

    public final TextOptions rotate(float f) {
        this.f5287l = f;
        return this;
    }

    public final TextOptions text(String str) {
        if (str == null || str.equals("")) {
            throw new IllegalArgumentException("text can not be null or empty");
        }
        this.f5279d = str;
        return this;
    }

    public final TextOptions typeface(Typeface typeface) {
        this.f5284i = typeface;
        return this;
    }

    public final TextOptions visible(boolean z) {
        this.f5277b = z;
        return this;
    }

    public final TextOptions zIndex(int i) {
        this.f5276a = i;
        return this;
    }
}
