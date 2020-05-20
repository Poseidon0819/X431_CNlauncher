package com.baidu.mapapi.map;

import android.graphics.Point;
import android.view.ViewGroup;
import com.baidu.mapapi.model.LatLng;

/* loaded from: classes.dex */
public final class MapViewLayoutParams extends ViewGroup.LayoutParams {
    public static final int ALIGN_BOTTOM = 16;
    public static final int ALIGN_CENTER_HORIZONTAL = 4;
    public static final int ALIGN_CENTER_VERTICAL = 32;
    public static final int ALIGN_LEFT = 1;
    public static final int ALIGN_RIGHT = 2;
    public static final int ALIGN_TOP = 8;

    /* renamed from: a */
    LatLng f5137a;

    /* renamed from: b */
    Point f5138b;

    /* renamed from: c */
    ELayoutMode f5139c;

    /* renamed from: d */
    float f5140d;

    /* renamed from: e */
    float f5141e;

    /* renamed from: f */
    int f5142f;

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a */
        private int f5143a;

        /* renamed from: b */
        private int f5144b;

        /* renamed from: c */
        private LatLng f5145c;

        /* renamed from: d */
        private Point f5146d;

        /* renamed from: e */
        private ELayoutMode f5147e = ELayoutMode.absoluteMode;

        /* renamed from: f */
        private int f5148f = 4;

        /* renamed from: g */
        private int f5149g = 16;

        /* renamed from: h */
        private int f5150h;

        public final Builder align(int i, int i2) {
            if (i == 1 || i == 2 || i == 4) {
                this.f5148f = i;
            }
            if (i2 == 8 || i2 == 16 || i2 == 32) {
                this.f5149g = i2;
            }
            return this;
        }

        public final MapViewLayoutParams build() {
            boolean z = true;
            if (this.f5147e != ELayoutMode.mapMode ? this.f5147e != ELayoutMode.absoluteMode || this.f5146d != null : this.f5145c != null) {
                z = false;
            }
            if (z) {
                throw new IllegalStateException("if it is map mode, you must supply position info; else if it is absolute mode, you must supply the point info");
            }
            return new MapViewLayoutParams(this.f5143a, this.f5144b, this.f5145c, this.f5146d, this.f5147e, this.f5148f, this.f5149g, this.f5150h);
        }

        public final Builder height(int i) {
            this.f5144b = i;
            return this;
        }

        public final Builder layoutMode(ELayoutMode eLayoutMode) {
            this.f5147e = eLayoutMode;
            return this;
        }

        public final Builder point(Point point) {
            this.f5146d = point;
            return this;
        }

        public final Builder position(LatLng latLng) {
            this.f5145c = latLng;
            return this;
        }

        public final Builder width(int i) {
            this.f5143a = i;
            return this;
        }

        public final Builder yOffset(int i) {
            this.f5150h = i;
            return this;
        }
    }

    /* loaded from: classes.dex */
    public enum ELayoutMode {
        mapMode,
        absoluteMode
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    MapViewLayoutParams(int r1, int r2, com.baidu.mapapi.model.LatLng r3, android.graphics.Point r4, com.baidu.mapapi.map.MapViewLayoutParams.ELayoutMode r5, int r6, int r7, int r8) {
        /*
            r0 = this;
            r0.<init>(r1, r2)
            r0.f5137a = r3
            r0.f5138b = r4
            r0.f5139c = r5
            r1 = 4
            r2 = 0
            r3 = 1065353216(0x3f800000, float:1.0)
            r4 = 1056964608(0x3f000000, float:0.5)
            if (r6 == r1) goto L14
            switch(r6) {
                case 1: goto L1a;
                case 2: goto L17;
                default: goto L14;
            }
        L14:
            r0.f5140d = r4
            goto L1c
        L17:
            r0.f5140d = r3
            goto L1c
        L1a:
            r0.f5140d = r2
        L1c:
            r1 = 8
            if (r7 == r1) goto L2e
            r1 = 16
            if (r7 == r1) goto L28
            r1 = 32
            if (r7 == r1) goto L2b
        L28:
            r0.f5141e = r3
            goto L30
        L2b:
            r0.f5141e = r4
            goto L30
        L2e:
            r0.f5141e = r2
        L30:
            r0.f5142f = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapapi.map.MapViewLayoutParams.<init>(int, int, com.baidu.mapapi.model.LatLng, android.graphics.Point, com.baidu.mapapi.map.MapViewLayoutParams$ELayoutMode, int, int, int):void");
    }
}
