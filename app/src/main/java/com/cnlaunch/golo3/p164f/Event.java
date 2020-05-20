package com.cnlaunch.golo3.p164f;

/* renamed from: com.cnlaunch.golo3.f.a */
/* loaded from: classes.dex */
public final class Event<Result> {

    /* renamed from: b */
    private int f8438b;

    /* renamed from: c */
    private String f8439c;

    /* renamed from: a */
    public Result f8437a = null;

    /* renamed from: d */
    private int f8440d = -1;

    public Event(String str) {
        this.f8438b = -1;
        this.f8439c = "";
        this.f8439c = str;
        this.f8438b = 0;
    }

    public final String toString() {
        return this.f8439c + ":" + this.f8438b;
    }
}
