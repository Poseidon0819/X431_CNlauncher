package com.baidu.mapsdkvi;

import android.net.NetworkInfo;

/* renamed from: com.baidu.mapsdkvi.b */
/* loaded from: classes.dex */
public class C1317b {

    /* renamed from: a */
    public String f6453a;

    /* renamed from: b */
    public int f6454b;

    /* renamed from: c */
    public int f6455c;

    /* renamed from: com.baidu.mapsdkvi.b$1 */
    /* loaded from: classes.dex */
    /* synthetic */ class C13181 {

        /* renamed from: a */
        static final /* synthetic */ int[] f6456a = new int[NetworkInfo.State.values().length];

        static {
            try {
                f6456a[NetworkInfo.State.CONNECTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6456a[NetworkInfo.State.CONNECTING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6456a[NetworkInfo.State.DISCONNECTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6456a[NetworkInfo.State.DISCONNECTING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f6456a[NetworkInfo.State.SUSPENDED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public C1317b(NetworkInfo networkInfo) {
        int i;
        this.f6453a = networkInfo.getTypeName();
        this.f6454b = networkInfo.getType();
        switch (C13181.f6456a[networkInfo.getState().ordinal()]) {
            case 1:
                i = 2;
                break;
            case 2:
                i = 1;
                break;
            default:
                i = 0;
                break;
        }
        this.f6455c = i;
    }
}
