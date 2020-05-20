package com.cnlaunch.wifiprinter;

import android.view.View;
import com.cnlaunch.wifiprinter.C1900at;
import com.cnlaunch.wifiprinter.FragmentC1934u;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PrintTestTwo.java */
/* renamed from: com.cnlaunch.wifiprinter.ac */
/* loaded from: classes.dex */
public final class View$OnClickListenerC1881ac implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FragmentC1934u f10354a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1881ac(FragmentC1934u fragmentC1934u) {
        this.f10354a = fragmentC1934u;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f10354a.f10530x.clear();
        if (this.f10354a.f10520n != null) {
            this.f10354a.f10520n.notifyDataSetChanged();
        }
        FragmentC1934u.f10505k.setVisibility(0);
        this.f10354a.f10522p.setEnabled(false);
        this.f10354a.f10522p.setTextColor(this.f10354a.f10519m.getResources().getColor(C1900at.C1902b.hui1));
        FragmentC1934u fragmentC1934u = this.f10354a;
        new FragmentC1934u.C1937c(fragmentC1934u.f10519m).start();
    }
}
