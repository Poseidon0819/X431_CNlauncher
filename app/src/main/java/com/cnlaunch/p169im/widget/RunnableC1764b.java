package com.cnlaunch.p169im.widget;

import com.cnlaunch.p169im.widget.ImageTouchView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ImageTouchView.java */
/* renamed from: com.cnlaunch.im.widget.b */
/* loaded from: classes.dex */
public final class RunnableC1764b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Integer[] f9415a;

    /* renamed from: b */
    final /* synthetic */ ImageTouchView.AsyncTaskC1760c f9416b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1764b(ImageTouchView.AsyncTaskC1760c asyncTaskC1760c, Integer[] numArr) {
        this.f9416b = asyncTaskC1760c;
        this.f9415a = numArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ImageTouchView.this.setFrame(this.f9415a[0].intValue(), this.f9415a[1].intValue(), this.f9415a[2].intValue(), this.f9415a[3].intValue());
    }
}
