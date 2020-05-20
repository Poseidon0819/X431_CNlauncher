package com.artifex.mupdflib;

import java.util.concurrent.RejectedExecutionException;

/* loaded from: classes.dex */
public abstract class SafeAsyncTask<Params, Progress, Result> extends AsyncTask<Params, Progress, Result> {
    public void safeExecute(Params... paramsArr) {
        try {
            execute(paramsArr);
        } catch (RejectedExecutionException unused) {
            onPreExecute();
            if (isCancelled()) {
                onCancelled();
            } else {
                onPostExecute(doInBackground(paramsArr));
            }
        }
    }
}
