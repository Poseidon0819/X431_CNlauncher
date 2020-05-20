package com.artifex.mupdflib;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

/* loaded from: classes.dex */
public class CancellableAsyncTask<Params, Result> {
    private final AsyncTask<Params, Void, Result> asyncTask;
    private final CancellableTaskDefinition<Params, Result> ourTask;

    public void onPostExecute(Result result) {
    }

    public void onPreExecute() {
    }

    public CancellableAsyncTask(final CancellableTaskDefinition<Params, Result> cancellableTaskDefinition) {
        if (cancellableTaskDefinition == null) {
            throw new IllegalArgumentException();
        }
        this.ourTask = cancellableTaskDefinition;
        this.asyncTask = new AsyncTask<Params, Void, Result>() { // from class: com.artifex.mupdflib.CancellableAsyncTask.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.artifex.mupdflib.AsyncTask
            public Result doInBackground(Params... paramsArr) {
                return (Result) cancellableTaskDefinition.doInBackground(paramsArr);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.artifex.mupdflib.AsyncTask
            public void onPreExecute() {
                CancellableAsyncTask.this.onPreExecute();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.artifex.mupdflib.AsyncTask
            public void onPostExecute(Result result) {
                CancellableAsyncTask.this.onPostExecute(result);
                cancellableTaskDefinition.doCleanup();
            }
        };
    }

    public void cancelAndWait() {
        this.asyncTask.cancel(true);
        this.ourTask.doCancel();
        try {
            this.asyncTask.get();
        } catch (InterruptedException | CancellationException | ExecutionException unused) {
        }
        this.ourTask.doCleanup();
    }

    public void execute(Params... paramsArr) {
        this.asyncTask.execute(paramsArr);
    }
}
