package com.baidu.mapapi.map;

import android.graphics.Typeface;
import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.map.EnumC1214h;
import p033c.p034a.p035a.p036a.p037a.p038a.C0598a;

/* loaded from: classes.dex */
public final class Text extends Overlay {

    /* renamed from: k */
    private static final String f5265k = "Text";

    /* renamed from: a */
    String f5266a;

    /* renamed from: b */
    LatLng f5267b;

    /* renamed from: c */
    int f5268c;

    /* renamed from: d */
    int f5269d;

    /* renamed from: e */
    int f5270e;

    /* renamed from: f */
    Typeface f5271f;

    /* renamed from: g */
    int f5272g;

    /* renamed from: h */
    int f5273h;

    /* renamed from: i */
    float f5274i;

    /* renamed from: j */
    int f5275j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Text() {
        this.type = EnumC1214h.text;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.mapapi.map.Overlay
    /* renamed from: a */
    public final Bundle mo11139a() {
        Typeface typeface = this.f5271f;
        if (typeface != null) {
            C0598a.m12977a(typeface.hashCode());
        }
        return super.mo11139a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x009c  */
    @Override // com.baidu.mapapi.map.Overlay
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.os.Bundle mo11138a(android.os.Bundle r6) {
        /*
            r5 = this;
            super.mo11138a(r6)
            com.baidu.mapapi.model.LatLng r0 = r5.f5267b
            if (r0 == 0) goto Lb1
            java.lang.String r0 = "text"
            java.lang.String r1 = r5.f5266a
            r6.putString(r0, r1)
            com.baidu.mapapi.model.LatLng r0 = r5.f5267b
            com.baidu.mapapi.model.inner.GeoPoint r0 = com.baidu.mapapi.model.CoordUtil.ll2mc(r0)
            java.lang.String r1 = "location_x"
            double r2 = r0.getLongitudeE6()
            r6.putDouble(r1, r2)
            java.lang.String r1 = "location_y"
            double r2 = r0.getLatitudeE6()
            r6.putDouble(r1, r2)
            int r0 = r5.f5269d
            int r1 = r0 >>> 24
            int r2 = r0 >> 16
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r3 = r0 >> 8
            r3 = r3 & 255(0xff, float:3.57E-43)
            r0 = r0 & 255(0xff, float:3.57E-43)
            int r0 = android.graphics.Color.argb(r1, r0, r3, r2)
            java.lang.String r1 = "font_color"
            r6.putInt(r1, r0)
            int r0 = r5.f5268c
            int r1 = r0 >>> 24
            int r2 = r0 >> 16
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r3 = r0 >> 8
            r3 = r3 & 255(0xff, float:3.57E-43)
            r0 = r0 & 255(0xff, float:3.57E-43)
            int r0 = android.graphics.Color.argb(r1, r0, r3, r2)
            java.lang.String r1 = "bg_color"
            r6.putInt(r1, r0)
            java.lang.String r0 = "font_size"
            int r1 = r5.f5270e
            r6.putInt(r0, r1)
            android.graphics.Typeface r0 = r5.f5271f
            if (r0 == 0) goto L73
            int r0 = r0.hashCode()
            android.graphics.Typeface r1 = r5.f5271f
            p033c.p034a.p035a.p036a.p037a.p038a.C0598a.m12976a(r0, r1)
            java.lang.String r0 = "type_face"
            android.graphics.Typeface r1 = r5.f5271f
            int r1 = r1.hashCode()
            r6.putInt(r0, r1)
        L73:
            int r0 = r5.f5272g
            r1 = 4
            r2 = 1065353216(0x3f800000, float:1.0)
            r3 = 0
            r4 = 1056964608(0x3f000000, float:0.5)
            if (r0 == r1) goto L80
            switch(r0) {
                case 1: goto L86;
                case 2: goto L83;
                default: goto L80;
            }
        L80:
            r0 = 1056964608(0x3f000000, float:0.5)
            goto L87
        L83:
            r0 = 1065353216(0x3f800000, float:1.0)
            goto L87
        L86:
            r0 = 0
        L87:
            java.lang.String r1 = "align_x"
            r6.putFloat(r1, r0)
            int r0 = r5.f5273h
            r1 = 8
            if (r0 == r1) goto L9c
            r1 = 16
            if (r0 == r1) goto L99
            r1 = 32
            goto L9d
        L99:
            r4 = 1065353216(0x3f800000, float:1.0)
            goto L9d
        L9c:
            r4 = 0
        L9d:
            java.lang.String r0 = "align_y"
            r6.putFloat(r0, r4)
            java.lang.String r0 = "rotate"
            float r1 = r5.f5274i
            r6.putFloat(r0, r1)
            java.lang.String r0 = "update"
            int r1 = r5.f5275j
            r6.putInt(r0, r1)
            return r6
        Lb1:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "when you add a text overlay, you must provide text and the position info."
            r6.<init>(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapapi.map.Text.mo11138a(android.os.Bundle):android.os.Bundle");
    }

    public final float getAlignX() {
        return this.f5272g;
    }

    public final float getAlignY() {
        return this.f5273h;
    }

    public final int getBgColor() {
        return this.f5268c;
    }

    public final int getFontColor() {
        return this.f5269d;
    }

    public final int getFontSize() {
        return this.f5270e;
    }

    public final LatLng getPosition() {
        return this.f5267b;
    }

    public final float getRotate() {
        return this.f5274i;
    }

    public final String getText() {
        return this.f5266a;
    }

    public final Typeface getTypeface() {
        return this.f5271f;
    }

    public final void setAlign(int i, int i2) {
        this.f5272g = i;
        this.f5273h = i2;
        this.f5275j = 1;
        this.listener.mo11151b(this);
    }

    public final void setBgColor(int i) {
        this.f5268c = i;
        this.f5275j = 1;
        this.listener.mo11151b(this);
    }

    public final void setFontColor(int i) {
        this.f5269d = i;
        this.f5275j = 1;
        this.listener.mo11151b(this);
    }

    public final void setFontSize(int i) {
        this.f5270e = i;
        this.f5275j = 1;
        this.listener.mo11151b(this);
    }

    public final void setPosition(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("position can not be null");
        }
        this.f5267b = latLng;
        this.f5275j = 1;
        this.listener.mo11151b(this);
    }

    public final void setRotate(float f) {
        this.f5274i = f;
        this.f5275j = 1;
        this.listener.mo11151b(this);
    }

    public final void setText(String str) {
        if (str == null || str.equals("")) {
            throw new IllegalArgumentException("text can not be null or empty");
        }
        this.f5266a = str;
        this.f5275j = 1;
        this.listener.mo11151b(this);
    }

    public final void setTypeface(Typeface typeface) {
        this.f5271f = typeface;
        this.f5275j = 1;
        this.listener.mo11151b(this);
    }
}
