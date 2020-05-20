package com.cnlaunch.x431pro.activity.diagnose;

/* compiled from: OnlineHelpPDFFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.bq */
/* loaded from: classes.dex */
final class RunnableC2081bq implements Runnable {

    /* renamed from: a */
    final /* synthetic */ OnlineHelpPDFFragment f11573a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2081bq(OnlineHelpPDFFragment onlineHelpPDFFragment) {
        this.f11573a = onlineHelpPDFFragment;
    }

    @Override // java.lang.Runnable
    public final void run() {
        OnlineHelpPDFFragment onlineHelpPDFFragment = this.f11573a;
        if (onlineHelpPDFFragment.f11563a != null) {
            onlineHelpPDFFragment.f11563a.recycle();
            onlineHelpPDFFragment.f11563a = null;
        }
        if (onlineHelpPDFFragment.f11564b != null) {
            onlineHelpPDFFragment.f11564b.onFinishTemporaryDetach();
            onlineHelpPDFFragment.f11564b.destroyDrawingCache();
            onlineHelpPDFFragment.f11564b = null;
        }
        onlineHelpPDFFragment.f11565c = null;
        if (onlineHelpPDFFragment.f11566d != null) {
            onlineHelpPDFFragment.f11566d.removeEventListener(onlineHelpPDFFragment);
            onlineHelpPDFFragment.f11566d = null;
        }
        System.gc();
    }
}
