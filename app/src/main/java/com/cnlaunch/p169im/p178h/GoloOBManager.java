package com.cnlaunch.p169im.p178h;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.cnlaunch.im.h.c */
/* loaded from: classes.dex */
public final class GoloOBManager {

    /* renamed from: c */
    private static GoloOBManager f9278c;

    /* renamed from: a */
    public ArrayList<GoloObServer> f9279a;

    /* renamed from: b */
    public ArrayList<ConnectStatusObserver> f9280b;

    /* renamed from: d */
    private ArrayList<Object> f9281d;

    private GoloOBManager() {
        this.f9279a = null;
        this.f9281d = null;
        this.f9280b = null;
        this.f9279a = new ArrayList<>();
        this.f9281d = new ArrayList<>();
        this.f9280b = new ArrayList<>();
    }

    /* renamed from: a */
    public static GoloOBManager m8721a() {
        if (f9278c == null) {
            f9278c = new GoloOBManager();
        }
        return f9278c;
    }

    /* renamed from: a */
    public final synchronized void m8719a(ConnectStatusObserver connectStatusObserver) {
        if (this.f9280b == null) {
            Log.e("Sanda", "deleteObserver ConnectStatusObserver is NullPointerException!");
        } else {
            this.f9280b.remove(connectStatusObserver);
        }
    }

    /* renamed from: a */
    public final synchronized void m8718a(GoloObServer goloObServer) {
        if (this.f9279a == null) {
            Log.e("Sanda", "deleteObserver GoloObServer is NullPointerException!");
        } else {
            this.f9279a.remove(goloObServer);
        }
    }

    /* renamed from: b */
    public final synchronized void m8717b() {
        if (this.f9279a != null && this.f9279a.size() > 0) {
            Iterator<GoloObServer> it = this.f9279a.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    /* renamed from: c */
    public final synchronized void m8716c() {
        try {
            if (this.f9281d != null && this.f9281d.size() > 0) {
                Iterator<Object> it = this.f9281d.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
        } catch (Exception e) {
            Log.e("GoloOBManager", e.getMessage());
        }
    }

    /* renamed from: a */
    public final void m8720a(int i) {
        try {
            if (this.f9280b != null && this.f9280b.size() > 0) {
                Iterator<ConnectStatusObserver> it = this.f9280b.iterator();
                while (it.hasNext()) {
                    it.next().mo8722a(i);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
