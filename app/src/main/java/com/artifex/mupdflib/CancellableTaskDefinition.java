package com.artifex.mupdflib;

/* loaded from: classes.dex */
public interface CancellableTaskDefinition<Params, Result> {
    void doCancel();

    void doCleanup();

    Result doInBackground(Params... paramsArr);
}
