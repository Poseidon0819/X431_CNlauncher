package com.cnlaunch.p169im;

import android.content.DialogInterface;
import java.io.File;

/* compiled from: ShowVideoActivity.java */
/* renamed from: com.cnlaunch.im.o */
/* loaded from: classes.dex */
final class DialogInterface$OnCancelListenerC1755o implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ ShowVideoActivity f9312a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DialogInterface$OnCancelListenerC1755o(ShowVideoActivity showVideoActivity) {
        this.f9312a = showVideoActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        String str;
        ShowVideoActivity.m8942a(this.f9312a);
        str = this.f9312a.f8904o;
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
    }
}
