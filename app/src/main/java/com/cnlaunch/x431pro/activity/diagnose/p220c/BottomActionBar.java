package com.cnlaunch.x431pro.activity.diagnose.p220c;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.view.View;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.cnlaunch.x431pro.activity.diagnose.c.a */
/* loaded from: classes.dex */
public final class BottomActionBar implements View.OnClickListener {

    /* renamed from: b */
    private Activity f11706b;

    /* renamed from: d */
    private AbstractC2090a f11708d;

    /* renamed from: c */
    private Map<View, AbstractC2090a> f11707c = new HashMap();

    /* renamed from: a */
    public View f11705a = null;

    /* compiled from: BottomActionBar.java */
    /* renamed from: com.cnlaunch.x431pro.activity.diagnose.c.a$b */
    /* loaded from: classes.dex */
    public interface InterfaceC2091b {
        /* renamed from: a */
        void mo7071a();

        /* renamed from: a */
        void mo7070a(FragmentTransaction fragmentTransaction);

        /* renamed from: b */
        void mo7069b(FragmentTransaction fragmentTransaction);

        /* renamed from: c */
        void mo7068c(FragmentTransaction fragmentTransaction);

        /* renamed from: d */
        void mo7067d(FragmentTransaction fragmentTransaction);
    }

    public BottomActionBar(Activity activity) {
        this.f11706b = activity;
    }

    /* renamed from: a */
    public final void m7421a(AbstractC2090a abstractC2090a) {
        this.f11707c.put(abstractC2090a.f11709a, abstractC2090a);
        abstractC2090a.f11709a.setOnClickListener(this);
    }

    /* renamed from: b */
    public final void m7420b(AbstractC2090a abstractC2090a) {
        if (this.f11705a == abstractC2090a.f11709a) {
            this.f11705a = null;
        }
        this.f11707c.remove(abstractC2090a.f11709a);
    }

    /* compiled from: BottomActionBar.java */
    /* renamed from: com.cnlaunch.x431pro.activity.diagnose.c.a$a */
    /* loaded from: classes.dex */
    public static abstract class AbstractC2090a {

        /* renamed from: a */
        View f11709a;

        /* renamed from: b */
        public InterfaceC2091b f11710b;

        /* renamed from: a */
        public abstract boolean mo6367a();

        public AbstractC2090a(View view) {
            this.f11709a = view;
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        synchronized (this.f11707c) {
            AbstractC2090a abstractC2090a = this.f11707c.get(view);
            if (abstractC2090a.mo6367a()) {
                this.f11705a = view;
                FragmentTransaction disallowAddToBackStack = this.f11706b.getFragmentManager().beginTransaction().disallowAddToBackStack();
                if (this.f11708d == abstractC2090a) {
                    if (this.f11708d != null) {
                        this.f11708d.f11710b.mo7068c(disallowAddToBackStack);
                    }
                } else {
                    if (this.f11708d != null) {
                        this.f11708d.f11710b.mo7069b(disallowAddToBackStack);
                    }
                    this.f11708d = abstractC2090a;
                    if (this.f11708d != null) {
                        this.f11708d.f11710b.mo7070a(disallowAddToBackStack);
                    }
                }
                if (!disallowAddToBackStack.isEmpty()) {
                    disallowAddToBackStack.commitAllowingStateLoss();
                }
            }
        }
    }
}
