package com.artifex.mupdflib;

import com.artifex.mupdflib.MuPDFCore;

/* loaded from: classes.dex */
public abstract class MuPDFCancellableTaskDefinition<Params, Result> implements CancellableTaskDefinition<Params, Result> {
    private MuPDFCore.Cookie cookie;

    public abstract Result doInBackground(MuPDFCore.Cookie cookie, Params... paramsArr);

    public MuPDFCancellableTaskDefinition(MuPDFCore muPDFCore) {
        muPDFCore.getClass();
        this.cookie = new MuPDFCore.Cookie();
    }

    @Override // com.artifex.mupdflib.CancellableTaskDefinition
    public void doCancel() {
        MuPDFCore.Cookie cookie = this.cookie;
        if (cookie == null) {
            return;
        }
        cookie.abort();
    }

    @Override // com.artifex.mupdflib.CancellableTaskDefinition
    public void doCleanup() {
        MuPDFCore.Cookie cookie = this.cookie;
        if (cookie == null) {
            return;
        }
        cookie.destroy();
        this.cookie = null;
    }

    @Override // com.artifex.mupdflib.CancellableTaskDefinition
    public final Result doInBackground(Params... paramsArr) {
        return doInBackground(this.cookie, paramsArr);
    }
}
