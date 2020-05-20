package com.cnlaunch.p169im.p170a;

import android.view.View;
import com.cnlaunch.p169im.p173d.GoloHandler;

/* compiled from: SelectAdapter.java */
/* renamed from: com.cnlaunch.im.a.w */
/* loaded from: classes.dex */
final class View$OnClickListenerC1696w implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f9039a;

    /* renamed from: b */
    final /* synthetic */ SelectAdapter f9040b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1696w(SelectAdapter selectAdapter, int i) {
        this.f9040b = selectAdapter;
        this.f9039a = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        GoloHandler goloHandler;
        int intValue = this.f9040b.getItem(this.f9039a).get("what").intValue();
        goloHandler = this.f9040b.f9037b;
        goloHandler.obtainMessage(intValue).sendToTarget();
    }
}
