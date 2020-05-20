package com.artifex.mupdflib;

import android.app.ProgressDialog;
import android.content.Context;

/* compiled from: SearchTask.java */
/* loaded from: classes.dex */
class ProgressDialogX extends ProgressDialog {
    private boolean mCancelled;

    public ProgressDialogX(Context context) {
        super(context);
        this.mCancelled = false;
    }

    public boolean isCancelled() {
        return this.mCancelled;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        this.mCancelled = true;
        super.cancel();
    }
}
