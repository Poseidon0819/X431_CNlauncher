package com.baidu.mapapi.map;

/* loaded from: classes.dex */
public class MyLocationData {
    public final float accuracy;
    public final float direction;
    public final double latitude;
    public final double longitude;
    public final int satellitesNum;
    public final float speed;

    /* loaded from: classes.dex */
    public static class Builder {

        /* renamed from: a */
        private double f5195a;

        /* renamed from: b */
        private double f5196b;

        /* renamed from: c */
        private float f5197c;

        /* renamed from: d */
        private float f5198d;

        /* renamed from: e */
        private float f5199e;

        /* renamed from: f */
        private int f5200f;

        public Builder accuracy(float f) {
            this.f5199e = f;
            return this;
        }

        public MyLocationData build() {
            return new MyLocationData(this.f5195a, this.f5196b, this.f5197c, this.f5198d, this.f5199e, this.f5200f);
        }

        public Builder direction(float f) {
            this.f5198d = f;
            return this;
        }

        public Builder latitude(double d) {
            this.f5195a = d;
            return this;
        }

        public Builder longitude(double d) {
            this.f5196b = d;
            return this;
        }

        public Builder satellitesNum(int i) {
            this.f5200f = i;
            return this;
        }

        public Builder speed(float f) {
            this.f5197c = f;
            return this;
        }
    }

    MyLocationData(double d, double d2, float f, float f2, float f3, int i) {
        this.latitude = d;
        this.longitude = d2;
        this.speed = f;
        this.direction = f2;
        this.accuracy = f3;
        this.satellitesNum = i;
    }
}
