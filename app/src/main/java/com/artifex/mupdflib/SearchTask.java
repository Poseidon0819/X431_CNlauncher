package com.artifex.mupdflib;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.RectF;
import android.os.Handler;
import android.widget.TextView;
import java.lang.reflect.Field;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

/* loaded from: classes.dex */
public abstract class SearchTask {
    private static final int SEARCH_PROGRESS_DELAY = 200;
    public static ProgressDialogX progressDialog;
    private final AlertDialog.Builder mAlertBuilder;
    private final Context mContext;
    private final MuPDFCore mCore;
    private MuPDFReaderView mDocView;
    private final Handler mHandler = new Handler();
    private AsyncTask<Void, Integer, SearchTaskResult> mSearchTask;

    protected abstract void onTextFound(SearchTaskResult searchTaskResult);

    public SearchTask(Context context, MuPDFCore muPDFCore, MuPDFReaderView muPDFReaderView) {
        this.mDocView = muPDFReaderView;
        this.mContext = context;
        this.mCore = muPDFCore;
        this.mAlertBuilder = new AlertDialog.Builder(context, 3);
    }

    public void stop() {
        AsyncTask<Void, Integer, SearchTaskResult> asyncTask = this.mSearchTask;
        if (asyncTask != null) {
            asyncTask.cancel(true);
            this.mSearchTask = null;
        }
    }

    public ProgressDialogX getProgressDialog() {
        return progressDialog;
    }

    public void cancelProgressDialog() {
        progressDialog.cancel();
    }

    /* renamed from: go */
    public void m12507go(final String str, final int i, final int i2, int i3) {
        if (this.mCore == null) {
            return;
        }
        if (i3 != -1) {
            i2 = i3 + i;
        }
        ProgressDialogX progressDialogX = new ProgressDialogX(this.mContext);
        progressDialog = progressDialogX;
        progressDialogX.setProgressStyle(1);
        progressDialog.setTitle(this.mContext.getString(C0835R.string.searching_));
        progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.artifex.mupdflib.SearchTask.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                SearchTask.this.stop();
            }
        });
        progressDialog.setMax(this.mCore.countPages());
        this.mSearchTask = new AsyncTask<Void, Integer, SearchTaskResult>() { // from class: com.artifex.mupdflib.SearchTask.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.artifex.mupdflib.AsyncTask
            public SearchTaskResult doInBackground(Void... voidArr) {
                int i4 = i2;
                if (i4 == SearchTask.this.mCore.countPages() - 1) {
                    publishProgress(Integer.valueOf(i4));
                    int i5 = SearchTask.this.mCore.getDisplayPages() == 2 ? (i4 * 2) - 1 : i4;
                    RectF[] searchPage = SearchTask.this.mCore.searchPage(i5, str);
                    RectF[] searchPage2 = SearchTask.this.mCore.getDisplayPages() == 2 ? SearchTask.this.mCore.searchPage(i5 + 1, str) : null;
                    if ((searchPage != null && searchPage.length > 0) || (searchPage2 != null && searchPage2.length > 0)) {
                        return new SearchTaskResult(str, i4, searchPage, searchPage2);
                    }
                } else {
                    while (i4 >= 0 && i4 < SearchTask.this.mCore.countPages() && !isCancelled()) {
                        publishProgress(Integer.valueOf(i4));
                        int i6 = SearchTask.this.mCore.getDisplayPages() == 2 ? (i4 * 2) - 1 : i4;
                        RectF[] searchPage3 = SearchTask.this.mCore.searchPage(i6, str);
                        RectF[] searchPage4 = SearchTask.this.mCore.getDisplayPages() == 2 ? SearchTask.this.mCore.searchPage(i6 + 1, str) : null;
                        if ((searchPage3 != null && searchPage3.length > 0) || (searchPage4 != null && searchPage4.length > 0)) {
                            return new SearchTaskResult(str, i4, searchPage3, searchPage4);
                        }
                        i4 += i;
                    }
                }
                return null;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.artifex.mupdflib.AsyncTask
            public void onPostExecute(SearchTaskResult searchTaskResult) {
                SearchTask.progressDialog.cancel();
                if (searchTaskResult == null) {
                    if (SearchTask.this.mDocView != null && SearchTaskResult.get() != null && SearchTaskResult.get().txt != null && !"".equals(SearchTaskResult.get().txt) && !MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR.equals(SearchTaskResult.get().txt)) {
                        SearchTask.this.onTextFound(new SearchTaskResult("", SearchTask.this.mDocView.getDisplayedViewIndex() == SearchTask.this.mCore.countPages() - 1 ? SearchTask.this.mDocView.getDisplayedViewIndex() : SearchTask.this.mDocView.getDisplayedViewIndex() + 1, new RectF[0], new RectF[0]));
                    }
                    SearchTask.this.mAlertBuilder.setMessage(C0835R.string.text_not_found);
                    AlertDialog create = SearchTask.this.mAlertBuilder.create();
                    create.setButton(-1, SearchTask.this.mContext.getString(C0835R.string.dismiss), (DialogInterface.OnClickListener) null);
                    create.show();
                    create.getButton(-1).setTextColor(-16777216);
                    create.getButton(-1).setTextSize(2, 18.0f);
                    try {
                        Field declaredField = AlertDialog.class.getDeclaredField("mAlert");
                        declaredField.setAccessible(true);
                        Object obj = declaredField.get(create);
                        Field declaredField2 = obj.getClass().getDeclaredField("mMessageView");
                        declaredField2.setAccessible(true);
                        TextView textView = (TextView) declaredField2.get(obj);
                        textView.setTextColor(-16777216);
                        textView.setTextSize(20.0f);
                        return;
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                        return;
                    } catch (NoSuchFieldException e2) {
                        e2.printStackTrace();
                        return;
                    }
                }
                SearchTask.this.onTextFound(searchTaskResult);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.artifex.mupdflib.AsyncTask
            public void onCancelled() {
                SearchTask.progressDialog.cancel();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.artifex.mupdflib.AsyncTask
            public void onProgressUpdate(Integer... numArr) {
                SearchTask.progressDialog.setProgress(numArr[0].intValue());
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.artifex.mupdflib.AsyncTask
            public void onPreExecute() {
                super.onPreExecute();
                SearchTask.this.mHandler.postDelayed(new Runnable() { // from class: com.artifex.mupdflib.SearchTask.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (SearchTask.progressDialog.isCancelled()) {
                            return;
                        }
                        SearchTask.progressDialog.show();
                        SearchTask.progressDialog.setProgress(i2);
                    }
                }, 200L);
            }
        };
        this.mSearchTask.execute(new Void[0]);
    }
}
