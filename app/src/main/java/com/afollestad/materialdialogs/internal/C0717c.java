package com.afollestad.materialdialogs.internal;

import android.support.p023v7.widget.RecyclerView;
import android.view.ViewGroup;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MDRootLayout.java */
/* renamed from: com.afollestad.materialdialogs.internal.c */
/* loaded from: classes.dex */
public final class C0717c extends RecyclerView.AbstractC0469k {

    /* renamed from: a */
    final /* synthetic */ ViewGroup f3471a;

    /* renamed from: b */
    final /* synthetic */ boolean f3472b;

    /* renamed from: c */
    final /* synthetic */ boolean f3473c;

    /* renamed from: d */
    final /* synthetic */ MDRootLayout f3474d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0717c(MDRootLayout mDRootLayout, ViewGroup viewGroup, boolean z, boolean z2) {
        this.f3474d = mDRootLayout;
        this.f3471a = viewGroup;
        this.f3472b = z;
        this.f3473c = z2;
    }

    @Override // android.support.p023v7.widget.RecyclerView.AbstractC0469k
    /* renamed from: a */
    public final void mo12558a(RecyclerView recyclerView, int i, int i2) {
        MDButton[] mDButtonArr;
        super.mo12558a(recyclerView, i, i2);
        mDButtonArr = this.f3474d.f3446a;
        int length = mDButtonArr.length;
        boolean z = false;
        int i3 = 0;
        while (true) {
            if (i3 < length) {
                MDButton mDButton = mDButtonArr[i3];
                if (mDButton != null && mDButton.getVisibility() != 8) {
                    z = true;
                    break;
                }
                i3++;
            } else {
                break;
            }
        }
        MDRootLayout.m12563a(this.f3474d, this.f3471a, this.f3472b, this.f3473c, z);
        this.f3474d.invalidate();
    }
}
