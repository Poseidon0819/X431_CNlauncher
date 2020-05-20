package com.cnlaunch.x431pro.activity;

import message.p379b.XmppEvent;

/* compiled from: MainActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.w */
/* loaded from: classes.dex */
final /* synthetic */ class C2705w {

    /* renamed from: a */
    static final /* synthetic */ int[] f15435a = new int[XmppEvent.EnumC4723a.values().length];

    static {
        try {
            f15435a[XmppEvent.EnumC4723a.conflict.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f15435a[XmppEvent.EnumC4723a.service_stop.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f15435a[XmppEvent.EnumC4723a.relogin_failed.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f15435a[XmppEvent.EnumC4723a.ping_failed.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f15435a[XmppEvent.EnumC4723a.send_failed.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f15435a[XmppEvent.EnumC4723a.connect_error.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f15435a[XmppEvent.EnumC4723a.connect_successfully.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
    }
}
