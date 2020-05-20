package com.artifex.mupdflib;

import java.util.concurrent.Executor;

/* compiled from: MuPDFActivity.java */
/* loaded from: classes.dex */
class ThreadPerTaskExecutor implements Executor {
    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        new Thread(runnable).start();
    }
}
