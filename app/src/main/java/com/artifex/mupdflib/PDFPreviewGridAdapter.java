package com.artifex.mupdflib;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class PDFPreviewGridAdapter extends BaseAdapter {
    private static final String TAG = "PDFPreviewGridAdapter";
    private int currentlyViewing;
    private Context mContext;
    private MuPDFCore mCore;
    private Bitmap mLoadingBitmap;
    private String mPath;
    private int mPosition;
    private Point mPreviewSize;

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public PDFPreviewGridAdapter(Context context, MuPDFCore muPDFCore, int i) {
        this.mContext = context;
        this.mCore = muPDFCore;
        this.mPosition = i;
        File file = new File(StorageUtils.getCacheSubDirectory(this.mContext, "previews2"), MD5.MD5Hash(new File(muPDFCore.getFileName()).getName()));
        if (!file.exists()) {
            file.mkdirs();
        }
        this.mPath = file.toString() + File.separator;
        setPreviewSize();
        this.mLoadingBitmap = Bitmap.createBitmap(this.mPreviewSize.x, this.mPreviewSize.y, Bitmap.Config.RGB_565);
        new Canvas(this.mLoadingBitmap).drawColor(-1);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mCore.countSinglePages();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.mCore.getDisplayPages() == 1) {
            return i;
        }
        if (i > 0) {
            return (i + 1) / 2;
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(C0835R.layout.preview_grid_item, viewGroup, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.previewPageProgress.setVisibility(0);
        viewHolder.previewPageImageView.setOnClickListener(new View.OnClickListener() { // from class: com.artifex.mupdflib.PDFPreviewGridAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ((Activity) PDFPreviewGridAdapter.this.mContext).setResult(i);
                ((Activity) PDFPreviewGridAdapter.this.mContext).finish();
            }
        });
        viewHolder.previewGridItemRelativeLayout.setBackgroundColor(0);
        drawPageImageView(viewHolder, i);
        return view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class ViewHolder {
        RelativeLayout previewGridItemRelativeLayout;
        ImageView previewPageImageView;
        ProgressBar previewPageProgress;

        ViewHolder(View view) {
            this.previewPageImageView = null;
            this.previewPageProgress = null;
            this.previewGridItemRelativeLayout = null;
            this.previewPageImageView = (ImageView) view.findViewById(C0835R.C0836id.preview_grid_image);
            this.previewPageProgress = (ProgressBar) view.findViewById(C0835R.C0836id.preview_grid_image_progressbar);
            this.previewGridItemRelativeLayout = (RelativeLayout) view.findViewById(C0835R.C0836id.PreviewGridItemRelativeLayout);
        }
    }

    private void drawPageImageView(ViewHolder viewHolder, int i) {
        if (cancelPotentialWork(viewHolder, i)) {
            BitmapWorkerTask bitmapWorkerTask = new BitmapWorkerTask(viewHolder, i);
            viewHolder.previewPageImageView.setImageDrawable(new AsyncDrawable(this.mContext.getResources(), this.mLoadingBitmap, bitmapWorkerTask));
            bitmapWorkerTask.execute(new Integer[0]);
        }
    }

    public static boolean cancelPotentialWork(ViewHolder viewHolder, int i) {
        BitmapWorkerTask bitmapWorkerTask = getBitmapWorkerTask(viewHolder.previewPageImageView);
        if (bitmapWorkerTask != null) {
            if (bitmapWorkerTask.position == i) {
                return false;
            }
            bitmapWorkerTask.cancel(true);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class BitmapWorkerTask extends AsyncTask<Integer, Void, Bitmap> {
        private int position;
        private final WeakReference<ViewHolder> viewHolderReference;

        public BitmapWorkerTask(ViewHolder viewHolder, int i) {
            this.viewHolderReference = new WeakReference<>(viewHolder);
            this.position = i;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.artifex.mupdflib.AsyncTask
        public Bitmap doInBackground(Integer... numArr) {
            PDFPreviewGridAdapter.this.setPreviewSize();
            return PDFPreviewGridAdapter.this.getCachedBitmap(this.position);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.artifex.mupdflib.AsyncTask
        public void onPostExecute(Bitmap bitmap) {
            ViewHolder viewHolder;
            if (isCancelled()) {
                bitmap = null;
            }
            WeakReference<ViewHolder> weakReference = this.viewHolderReference;
            if (weakReference == null || bitmap == null || (viewHolder = weakReference.get()) == null || this != PDFPreviewGridAdapter.getBitmapWorkerTask(viewHolder.previewPageImageView) || viewHolder == null) {
                return;
            }
            viewHolder.previewPageImageView.setImageBitmap(bitmap);
            viewHolder.previewPageProgress.setVisibility(8);
            if (PDFPreviewGridAdapter.this.mPosition == this.position) {
                viewHolder.previewGridItemRelativeLayout.setBackgroundColor(PDFPreviewGridAdapter.this.mContext.getResources().getColor(C0835R.color.thumbnail_selected_background));
            } else {
                viewHolder.previewGridItemRelativeLayout.setBackgroundColor(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap getCachedBitmap(int i) {
        String str = this.mPath + i;
        File file = new File(str);
        try {
            if (file.exists() && file.canRead()) {
                Log.d(TAG, "page " + i + " found in cache");
                return BitmapFactory.decodeFile(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
            file.delete();
        }
        Bitmap createBitmap = Bitmap.createBitmap(this.mPreviewSize.x, this.mPreviewSize.y, Bitmap.Config.ARGB_8888);
        this.mCore.drawSinglePage(i, createBitmap, this.mPreviewSize.x, this.mPreviewSize.y);
        Bitmap copy = createBitmap.copy(Bitmap.Config.RGB_565, true);
        if (copy == null) {
            throw new RuntimeException("bitmap copy failed");
        }
        createBitmap.recycle();
        try {
            copy.compress(Bitmap.CompressFormat.JPEG, 70, new FileOutputStream(file));
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            file.delete();
        }
        return copy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPreviewSize() {
        if (this.mPreviewSize == null) {
            this.mPreviewSize = new Point();
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(C0835R.dimen.preview_height);
            PointF singlePageSize = this.mCore.getSinglePageSize(0);
            float f = singlePageSize.y / singlePageSize.x;
            Point point = this.mPreviewSize;
            point.x = (int) (dimensionPixelSize / f);
            point.y = dimensionPixelSize;
        }
    }

    public int getCurrentlyViewing() {
        return this.currentlyViewing;
    }

    public void setCurrentlyViewing(int i) {
        this.currentlyViewing = i;
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class AsyncDrawable extends BitmapDrawable {
        private final WeakReference<BitmapWorkerTask> bitmapWorkerTaskReference;

        public AsyncDrawable(Resources resources, Bitmap bitmap, BitmapWorkerTask bitmapWorkerTask) {
            super(resources, bitmap);
            this.bitmapWorkerTaskReference = new WeakReference<>(bitmapWorkerTask);
        }

        public BitmapWorkerTask getBitmapWorkerTask() {
            return this.bitmapWorkerTaskReference.get();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static BitmapWorkerTask getBitmapWorkerTask(ImageView imageView) {
        if (imageView != null) {
            Drawable drawable = imageView.getDrawable();
            if (drawable instanceof AsyncDrawable) {
                return ((AsyncDrawable) drawable).getBitmapWorkerTask();
            }
            return null;
        }
        return null;
    }
}
