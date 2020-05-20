package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class SysUpdateObservable {

    /* renamed from: a */
    private static volatile SysUpdateObservable f6379a;

    /* renamed from: b */
    private List<SysUpdateObserver> f6380b;

    private SysUpdateObservable() {
        this.f6380b = null;
        this.f6380b = new ArrayList();
    }

    public static SysUpdateObservable getInstance() {
        if (f6379a == null) {
            synchronized (SysUpdateObservable.class) {
                if (f6379a == null) {
                    f6379a = new SysUpdateObservable();
                }
            }
        }
        return f6379a;
    }

    public void addObserver(SysUpdateObserver sysUpdateObserver) {
        this.f6380b.add(sysUpdateObserver);
    }

    public void init() {
        for (SysUpdateObserver sysUpdateObserver : this.f6380b) {
            if (sysUpdateObserver != null) {
                sysUpdateObserver.init();
            }
        }
    }

    public void updateNetworkInfo(Context context) {
        for (SysUpdateObserver sysUpdateObserver : this.f6380b) {
            if (sysUpdateObserver != null) {
                sysUpdateObserver.updateNetworkInfo(context);
            }
        }
    }

    public void updateNetworkProxy(Context context) {
        for (SysUpdateObserver sysUpdateObserver : this.f6380b) {
            if (sysUpdateObserver != null) {
                sysUpdateObserver.updateNetworkProxy(context);
            }
        }
    }

    public void updatePhoneInfo() {
        for (SysUpdateObserver sysUpdateObserver : this.f6380b) {
            if (sysUpdateObserver != null) {
                sysUpdateObserver.updatePhoneInfo();
            }
        }
    }
}
