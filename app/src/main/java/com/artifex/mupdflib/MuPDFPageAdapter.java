package com.artifex.mupdflib;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PointF;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.artifex.mupdflib.FilePicker;
import com.artifex.mupdflib.MuPDFCore;

/* loaded from: classes.dex */
public class MuPDFPageAdapter extends BaseAdapter {
    private MuPDFCore.Callback callback;
    private final Context mContext;
    private final MuPDFCore mCore;
    private MuPDFReaderView mDocView;
    private FilePicker.FilePickerSupport mFilePickerSupport;
    private final SparseArray<PointF> mPageSizes;
    private Bitmap mSharedHqBm;

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    public MuPDFPageAdapter(Context context, FilePicker.FilePickerSupport filePickerSupport, MuPDFCore muPDFCore) {
        this.mFilePickerSupport = null;
        this.mPageSizes = new SparseArray<>();
        this.mContext = context;
        this.mFilePickerSupport = filePickerSupport;
        this.mCore = muPDFCore;
    }

    public MuPDFPageAdapter(Context context, MuPDFCore muPDFCore, MuPDFReaderView muPDFReaderView, MuPDFCore.Callback callback) {
        this.mFilePickerSupport = null;
        this.mPageSizes = new SparseArray<>();
        this.mContext = context;
        this.mCore = muPDFCore;
        this.mDocView = muPDFReaderView;
        this.callback = callback;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mCore.countPages();
    }

    public void releaseBitmaps() {
        Bitmap bitmap = this.mSharedHqBm;
        if (bitmap != null) {
            bitmap.recycle();
        }
        this.mSharedHqBm = null;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        final MuPDFPageView muPDFPageView;
        if (view == null) {
            Bitmap bitmap = this.mSharedHqBm;
            if (bitmap == null || bitmap.getWidth() != viewGroup.getWidth() || this.mSharedHqBm.getHeight() != viewGroup.getHeight()) {
                this.mSharedHqBm = Bitmap.createBitmap(viewGroup.getWidth(), viewGroup.getHeight(), Bitmap.Config.ARGB_8888);
            }
            muPDFPageView = new MuPDFPageView(this.mContext, this.mFilePickerSupport, this.mCore, new Point(viewGroup.getWidth(), viewGroup.getHeight()), this.mSharedHqBm, this.mDocView, this.callback);
        } else {
            muPDFPageView = (MuPDFPageView) view;
        }
        PointF pointF = this.mPageSizes.get(i);
        if (pointF != null) {
            muPDFPageView.setPage(i, pointF);
        } else {
            muPDFPageView.blank(i);
            new AsyncTask<Void, Void, PointF>() { // from class: com.artifex.mupdflib.MuPDFPageAdapter.1
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.artifex.mupdflib.AsyncTask
                public PointF doInBackground(Void... voidArr) {
                    return MuPDFPageAdapter.this.mCore.getPageSize(i);
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.artifex.mupdflib.AsyncTask
                public void onPostExecute(PointF pointF2) {
                    super.onPostExecute((C07961) pointF2);
                    MuPDFPageAdapter.this.mPageSizes.put(i, pointF2);
                    int page = muPDFPageView.getPage();
                    int i2 = i;
                    if (page == i2) {
                        muPDFPageView.setPage(i2, pointF2);
                    }
                }
            }.execute(null);
        }
        return muPDFPageView;
    }
}
