package com.cnlaunch.golo3.view.selectimg.clip;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ClipImageActivity.java */
/* renamed from: com.cnlaunch.golo3.view.selectimg.clip.d */
/* loaded from: classes.dex */
public final class RunnableC1641d implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ClipImageActivity f8673a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1641d(ClipImageActivity clipImageActivity) {
        this.f8673a = clipImageActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ClipImageView clipImageView;
        clipImageView = this.f8673a.f8634z;
        clipImageView.setImageBitmap(null);
    }
}
