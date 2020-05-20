package com.artifex.mupdflib;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.artifex.mupdflib.Annotation;
import com.artifex.mupdflib.MuPDFCore;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.mina.proxy.handlers.http.ntlm.NTLMConstants;

/* loaded from: classes.dex */
public abstract class PageView extends ViewGroup {
    private static final int BACKGROUND_COLOR = 0;
    private static final int BOX_COLOR = -12303105;
    private static final int HIGHLIGHT_COLOR = -2145029460;
    private static final int INK_COLOR = -65536;
    private static final float INK_THICKNESS = 10.0f;
    private static final int LINK_COLOR = 548172325;
    private static final int PROGRESS_DIALOG_DELAY = 200;
    private MuPDFCore.Callback callback;
    private ProgressBar mBusyIndicator;
    protected final Context mContext;
    private CancellableAsyncTask<Void, Void> mDrawEntire;
    private CancellableAsyncTask<Void, Void> mDrawPatch;
    protected ArrayList<ArrayList<PointF>> mDrawing;
    private ImageView mEntire;
    private Bitmap mEntireBm;
    private Matrix mEntireMat;
    private AsyncTask<Void, Void, LinkInfo[]> mGetLinkInfo;
    private AsyncTask<Void, Void, TextWord[][]> mGetText;
    private final Handler mHandler;
    private boolean mHighlightLinks;
    private boolean mIsBlank;
    private RectF mItemSelectBox;
    protected LinkInfo[] mLinks;
    protected int mPageNumber;
    private Point mParentSize;
    private ImageView mPatch;
    private Rect mPatchArea;
    private Bitmap mPatchBm;
    private Point mPatchViewSize;
    private RectF[] mSearchBoxes;
    private RectF[] mSearchBoxesPrim;
    private View mSearchView;
    private RectF mSelectBox;
    protected Point mSize;
    protected float mSourceScale;
    private TextWord[][] mText;

    protected abstract void addMarkup(PointF[] pointFArr, Annotation.Type type);

    protected abstract CancellableTaskDefinition<Void, Void> getDrawPageTask(Bitmap bitmap, int i, int i2, int i3, int i4, int i5, int i6);

    protected abstract LinkInfo[] getLinkInfo();

    protected abstract TextWord[][] getText();

    protected abstract CancellableTaskDefinition<Void, Void> getUpdatePageTask(Bitmap bitmap, int i, int i2, int i3, int i4, int i5, int i6);

    @Override // android.view.View
    public boolean isOpaque() {
        return true;
    }

    public abstract void scaleView();

    public PageView(Context context, Point point, Bitmap bitmap, MuPDFCore.Callback callback) {
        super(context);
        this.mHandler = new Handler();
        this.mContext = context;
        this.callback = callback;
        this.mParentSize = point;
        setBackgroundColor(0);
        try {
            this.mEntireBm = Bitmap.createBitmap(point.x, point.y, Bitmap.Config.ARGB_8888);
        } catch (OutOfMemoryError unused) {
            Log.d("MY_OOM_ERROR", "error");
        }
        this.mPatchBm = bitmap;
        this.mEntireMat = new Matrix();
    }

    private void reinit() {
        CancellableAsyncTask<Void, Void> cancellableAsyncTask = this.mDrawEntire;
        if (cancellableAsyncTask != null) {
            cancellableAsyncTask.cancelAndWait();
            this.mDrawEntire = null;
        }
        CancellableAsyncTask<Void, Void> cancellableAsyncTask2 = this.mDrawPatch;
        if (cancellableAsyncTask2 != null) {
            cancellableAsyncTask2.cancelAndWait();
            this.mDrawPatch = null;
        }
        AsyncTask<Void, Void, LinkInfo[]> asyncTask = this.mGetLinkInfo;
        if (asyncTask != null) {
            asyncTask.cancel(true);
            this.mGetLinkInfo = null;
        }
        AsyncTask<Void, Void, TextWord[][]> asyncTask2 = this.mGetText;
        if (asyncTask2 != null) {
            asyncTask2.cancel(true);
            this.mGetText = null;
        }
        this.mIsBlank = true;
        this.mPageNumber = 0;
        if (this.mSize == null) {
            this.mSize = this.mParentSize;
        }
        ImageView imageView = this.mEntire;
        if (imageView != null) {
            imageView.setImageBitmap(null);
            this.mEntire.invalidate();
        }
        ImageView imageView2 = this.mPatch;
        if (imageView2 != null) {
            imageView2.setImageBitmap(null);
            this.mPatch.invalidate();
        }
        this.mPatchViewSize = null;
        this.mPatchArea = null;
        this.mSearchBoxes = null;
        this.mSearchBoxesPrim = null;
        this.mLinks = null;
        this.mSelectBox = null;
        this.mText = null;
        this.mItemSelectBox = null;
    }

    public void releaseResources() {
        reinit();
        ProgressBar progressBar = this.mBusyIndicator;
        if (progressBar != null) {
            removeView(progressBar);
            this.mBusyIndicator = null;
        }
    }

    public void releaseBitmaps() {
        reinit();
        Bitmap bitmap = this.mEntireBm;
        if (bitmap != null) {
            bitmap.recycle();
        }
        this.mEntireBm = null;
        Bitmap bitmap2 = this.mPatchBm;
        if (bitmap2 != null) {
            bitmap2.recycle();
        }
        this.mPatchBm = null;
    }

    public void blank(int i) {
        reinit();
        this.mPageNumber = i;
        if (this.mBusyIndicator == null) {
            this.mBusyIndicator = new ProgressBar(this.mContext);
            this.mBusyIndicator.setIndeterminate(true);
            addView(this.mBusyIndicator);
        }
        setBackgroundColor(0);
    }

    public void setPage(int i, PointF pointF) {
        CancellableAsyncTask<Void, Void> cancellableAsyncTask = this.mDrawEntire;
        if (cancellableAsyncTask != null) {
            cancellableAsyncTask.cancelAndWait();
            this.mDrawEntire = null;
        }
        this.mIsBlank = false;
        View view = this.mSearchView;
        if (view != null) {
            view.invalidate();
        }
        this.mPageNumber = i;
        if (this.mEntire == null) {
            this.mEntire = new OpaqueImageView(this.mContext);
            this.mEntire.setScaleType(ImageView.ScaleType.MATRIX);
            addView(this.mEntire);
        }
        this.mSourceScale = Math.min(this.mParentSize.x / pointF.x, this.mParentSize.y / pointF.y);
        this.mSize = new Point((int) (pointF.x * this.mSourceScale), (int) (pointF.y * this.mSourceScale));
        this.mEntire.setImageBitmap(null);
        this.mEntire.invalidate();
        this.mGetLinkInfo = new AsyncTask<Void, Void, LinkInfo[]>() { // from class: com.artifex.mupdflib.PageView.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.artifex.mupdflib.AsyncTask
            public LinkInfo[] doInBackground(Void... voidArr) {
                return PageView.this.getLinkInfo();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.artifex.mupdflib.AsyncTask
            public void onPostExecute(LinkInfo[] linkInfoArr) {
                PageView pageView = PageView.this;
                pageView.mLinks = linkInfoArr;
                if (pageView.mSearchView != null) {
                    PageView.this.mSearchView.invalidate();
                }
            }
        };
        this.mGetLinkInfo.execute(new Void[0]);
        this.mDrawEntire = new CancellableAsyncTask<Void, Void>(getDrawPageTask(this.mEntireBm, this.mSize.x, this.mSize.y, 0, 0, this.mSize.x, this.mSize.y)) { // from class: com.artifex.mupdflib.PageView.2
            @Override // com.artifex.mupdflib.CancellableAsyncTask
            public void onPreExecute() {
                PageView.this.setBackgroundColor(0);
                PageView.this.mEntire.setImageBitmap(null);
                PageView.this.mEntire.invalidate();
                if (PageView.this.mBusyIndicator == null) {
                    PageView pageView = PageView.this;
                    pageView.mBusyIndicator = new ProgressBar(pageView.mContext);
                    PageView.this.mBusyIndicator.setIndeterminate(true);
                    PageView pageView2 = PageView.this;
                    pageView2.addView(pageView2.mBusyIndicator);
                    PageView.this.mBusyIndicator.setVisibility(4);
                    PageView.this.mHandler.postDelayed(new Runnable() { // from class: com.artifex.mupdflib.PageView.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PageView.this.mBusyIndicator != null) {
                                PageView.this.mBusyIndicator.setVisibility(0);
                            }
                        }
                    }, 200L);
                }
            }

            @Override // com.artifex.mupdflib.CancellableAsyncTask
            public void onPostExecute(Void r2) {
                PageView.this.callback.changePage();
                PageView pageView = PageView.this;
                pageView.removeView(pageView.mBusyIndicator);
                PageView.this.mBusyIndicator = null;
                PageView.this.mEntire.setImageBitmap(PageView.this.mEntireBm);
                PageView.this.mEntire.invalidate();
                PageView.this.setBackgroundColor(0);
            }
        };
        this.mDrawEntire.execute(new Void[0]);
        if (this.mSearchView == null) {
            this.mSearchView = new View(this.mContext) { // from class: com.artifex.mupdflib.PageView.3
                @Override // android.view.View
                @SuppressLint({"DrawAllocation"})
                protected void onDraw(final Canvas canvas) {
                    LinkInfo[] linkInfoArr;
                    RectF[] rectFArr;
                    RectF[] rectFArr2;
                    super.onDraw(canvas);
                    final float width = (PageView.this.mSourceScale * getWidth()) / PageView.this.mSize.x;
                    final Paint paint = new Paint();
                    if (!PageView.this.mIsBlank && PageView.this.mSearchBoxes != null) {
                        paint.setColor(PageView.HIGHLIGHT_COLOR);
                        for (RectF rectF : PageView.this.mSearchBoxes) {
                            canvas.drawRect(rectF.left * width, rectF.top * width, rectF.right * width, rectF.bottom * width, paint);
                        }
                    }
                    int i2 = 2;
                    if (!PageView.this.mIsBlank && PageView.this.mSearchBoxesPrim != null) {
                        paint.setColor(PageView.HIGHLIGHT_COLOR);
                        for (RectF rectF2 : PageView.this.mSearchBoxesPrim) {
                            canvas.drawRect((rectF2.left * width) + (getWidth() / 2), rectF2.top * width, (rectF2.right * width) + (getWidth() / 2), rectF2.bottom * width, paint);
                        }
                    }
                    if (!PageView.this.mIsBlank && PageView.this.mLinks != null && PageView.this.mHighlightLinks) {
                        paint.setStrokeWidth(2.0f);
                        for (LinkInfo linkInfo : PageView.this.mLinks) {
                            RectF rectF3 = new RectF((linkInfo.rect.left - 2.0f) * width, (linkInfo.rect.top - 2.0f) * width, (linkInfo.rect.right + 2.0f) * width, (linkInfo.rect.bottom + 2.0f) * width);
                            paint.setStyle(Paint.Style.FILL);
                            paint.setColor(PageView.LINK_COLOR);
                            float f = 3.0f * width;
                            canvas.drawRoundRect(rectF3, f, f, paint);
                            paint.setStyle(Paint.Style.STROKE);
                            paint.setColor(PageView.HIGHLIGHT_COLOR);
                            canvas.drawRoundRect(rectF3, f, f, paint);
                        }
                    }
                    if (PageView.this.mSelectBox != null && PageView.this.mText != null) {
                        paint.setColor(PageView.HIGHLIGHT_COLOR);
                        PageView.this.processSelectedText(new TextProcessor() { // from class: com.artifex.mupdflib.PageView.3.1
                            RectF rect;

                            @Override // com.artifex.mupdflib.TextProcessor
                            public void onStartLine() {
                                this.rect = new RectF();
                            }

                            @Override // com.artifex.mupdflib.TextProcessor
                            public void onWord(TextWord textWord) {
                                this.rect.union(textWord);
                            }

                            @Override // com.artifex.mupdflib.TextProcessor
                            public void onEndLine() {
                                if (this.rect.isEmpty()) {
                                    return;
                                }
                                canvas.drawRect(width * this.rect.left, width * this.rect.top, width * this.rect.right, width * this.rect.bottom, paint);
                            }
                        });
                    }
                    if (PageView.this.mItemSelectBox != null) {
                        paint.setStyle(Paint.Style.STROKE);
                        paint.setColor(PageView.BOX_COLOR);
                        canvas.drawRect(PageView.this.mItemSelectBox.left * width, PageView.this.mItemSelectBox.top * width, PageView.this.mItemSelectBox.right * width, PageView.this.mItemSelectBox.bottom * width, paint);
                    }
                    if (PageView.this.mDrawing != null) {
                        Path path = new Path();
                        paint.setAntiAlias(true);
                        paint.setDither(true);
                        paint.setStrokeJoin(Paint.Join.ROUND);
                        paint.setStrokeCap(Paint.Cap.ROUND);
                        paint.setStyle(Paint.Style.FILL);
                        float f2 = PageView.INK_THICKNESS * width;
                        paint.setStrokeWidth(f2);
                        paint.setColor(PageView.INK_COLOR);
                        Iterator<ArrayList<PointF>> it = PageView.this.mDrawing.iterator();
                        while (it.hasNext()) {
                            ArrayList<PointF> next = it.next();
                            if (next.size() >= i2) {
                                Iterator<PointF> it2 = next.iterator();
                                PointF next2 = it2.next();
                                float f3 = next2.x * width;
                                float f4 = next2.y * width;
                                path.moveTo(f3, f4);
                                while (it2.hasNext()) {
                                    PointF next3 = it2.next();
                                    float f5 = next3.x * width;
                                    float f6 = next3.y * width;
                                    path.quadTo(f3, f4, (f5 + f3) / 2.0f, (f6 + f4) / 2.0f);
                                    f4 = f6;
                                    f3 = f5;
                                }
                                path.lineTo(f3, f4);
                                i2 = 2;
                            } else {
                                PointF pointF2 = next.get(0);
                                canvas.drawCircle(pointF2.x * width, pointF2.y * width, f2 / 2.0f, paint);
                                i2 = 2;
                            }
                        }
                        paint.setStyle(Paint.Style.STROKE);
                        canvas.drawPath(path, paint);
                    }
                }
            };
            addView(this.mSearchView);
        }
        requestLayout();
        scaleView();
    }

    public void setSearchBoxes(RectF[] rectFArr) {
        this.mSearchBoxes = rectFArr;
        View view = this.mSearchView;
        if (view != null) {
            view.invalidate();
        }
    }

    public void setSearchBoxesPrim(RectF[] rectFArr) {
        this.mSearchBoxesPrim = rectFArr;
        View view = this.mSearchView;
        if (view != null) {
            view.invalidate();
        }
    }

    public void setLinkHighlighting(boolean z) {
        this.mHighlightLinks = z;
        View view = this.mSearchView;
        if (view != null) {
            view.invalidate();
        }
    }

    public void deselectText() {
        this.mSelectBox = null;
        this.mSearchView.invalidate();
    }

    public void selectText(float f, float f2, float f3, float f4) {
        float width = (this.mSourceScale * getWidth()) / this.mSize.x;
        float left = (f - getLeft()) / width;
        float top = (f2 - getTop()) / width;
        float left2 = (f3 - getLeft()) / width;
        float top2 = (f4 - getTop()) / width;
        if (top <= top2) {
            this.mSelectBox = new RectF(left, top, left2, top2);
        } else {
            this.mSelectBox = new RectF(left2, top2, left, top);
        }
        this.mSearchView.invalidate();
        if (this.mGetText == null) {
            this.mGetText = new AsyncTask<Void, Void, TextWord[][]>() { // from class: com.artifex.mupdflib.PageView.4
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.artifex.mupdflib.AsyncTask
                public TextWord[][] doInBackground(Void... voidArr) {
                    return PageView.this.getText();
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.artifex.mupdflib.AsyncTask
                public void onPostExecute(TextWord[][] textWordArr) {
                    PageView.this.mText = textWordArr;
                    PageView.this.mSearchView.invalidate();
                }
            };
            this.mGetText.execute(new Void[0]);
        }
    }

    public void startDraw(float f, float f2) {
        float width = (this.mSourceScale * getWidth()) / this.mSize.x;
        float left = (f - getLeft()) / width;
        float top = (f2 - getTop()) / width;
        if (this.mDrawing == null) {
            this.mDrawing = new ArrayList<>();
        }
        ArrayList<PointF> arrayList = new ArrayList<>();
        arrayList.add(new PointF(left, top));
        this.mDrawing.add(arrayList);
        this.mSearchView.invalidate();
    }

    public void continueDraw(float f, float f2) {
        float width = (this.mSourceScale * getWidth()) / this.mSize.x;
        float left = (f - getLeft()) / width;
        float top = (f2 - getTop()) / width;
        ArrayList<ArrayList<PointF>> arrayList = this.mDrawing;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        ArrayList<ArrayList<PointF>> arrayList2 = this.mDrawing;
        arrayList2.get(arrayList2.size() - 1).add(new PointF(left, top));
        this.mSearchView.invalidate();
    }

    public void cancelDraw() {
        this.mDrawing = null;
        this.mSearchView.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PointF[][] getDraw() {
        ArrayList<ArrayList<PointF>> arrayList = this.mDrawing;
        if (arrayList == null) {
            return null;
        }
        PointF[][] pointFArr = new PointF[arrayList.size()];
        for (int i = 0; i < this.mDrawing.size(); i++) {
            ArrayList<PointF> arrayList2 = this.mDrawing.get(i);
            pointFArr[i] = (PointF[]) arrayList2.toArray(new PointF[arrayList2.size()]);
        }
        return pointFArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void processSelectedText(TextProcessor textProcessor) {
        new TextSelector(this.mText, this.mSelectBox).select(textProcessor);
    }

    public void setItemSelectBox(RectF rectF) {
        this.mItemSelectBox = rectF;
        View view = this.mSearchView;
        if (view != null) {
            view.invalidate();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        if (View.MeasureSpec.getMode(i) == 0) {
            i3 = this.mSize.x;
        } else {
            i3 = View.MeasureSpec.getSize(i);
        }
        if (View.MeasureSpec.getMode(i2) == 0) {
            i4 = this.mSize.y;
        } else {
            i4 = View.MeasureSpec.getSize(i2);
        }
        setMeasuredDimension(i3, i4);
        if (this.mBusyIndicator != null) {
            ProgressBar progressBar = this.mBusyIndicator;
            int min = (Math.min(this.mParentSize.x, this.mParentSize.y) / 2) | NTLMConstants.FLAG_NEGOTIATE_56_BIT_ENCRYPTION;
            progressBar.measure(min, min);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int i6 = i4 - i2;
        ImageView imageView = this.mEntire;
        if (imageView != null) {
            if (imageView.getWidth() != i5 || this.mEntire.getHeight() != i6) {
                this.mEntireMat.setScale(i5 / this.mSize.x, i6 / this.mSize.y);
                this.mEntire.setImageMatrix(this.mEntireMat);
                this.mEntire.invalidate();
            }
            this.mEntire.layout(0, 0, i5, i6);
        }
        View view = this.mSearchView;
        if (view != null) {
            view.layout(0, 0, i5, i6);
        }
        Point point = this.mPatchViewSize;
        if (point != null) {
            if (point.x != i5 || this.mPatchViewSize.y != i6) {
                this.mPatchViewSize = null;
                this.mPatchArea = null;
                ImageView imageView2 = this.mPatch;
                if (imageView2 != null) {
                    imageView2.setImageBitmap(null);
                    this.mPatch.invalidate();
                }
            } else {
                this.mPatch.layout(this.mPatchArea.left, this.mPatchArea.top, this.mPatchArea.right, this.mPatchArea.bottom);
            }
        }
        ProgressBar progressBar = this.mBusyIndicator;
        if (progressBar != null) {
            int measuredWidth = progressBar.getMeasuredWidth();
            int measuredHeight = this.mBusyIndicator.getMeasuredHeight();
            this.mBusyIndicator.layout((i5 - measuredWidth) / 2, (i6 - measuredHeight) / 2, (i5 + measuredWidth) / 2, (i6 + measuredHeight) / 2);
        }
    }

    public void updateHq(boolean z) {
        CancellableTaskDefinition<Void, Void> updatePageTask;
        Rect rect = new Rect(getLeft(), getTop(), getRight(), getBottom());
        if (rect.width() == this.mSize.x || rect.height() == this.mSize.y) {
            ImageView imageView = this.mPatch;
            if (imageView != null) {
                imageView.setImageBitmap(null);
                this.mPatch.invalidate();
                return;
            }
            return;
        }
        final Point point = new Point(rect.width(), rect.height());
        final Rect rect2 = new Rect(0, 0, this.mParentSize.x, this.mParentSize.y);
        if (rect2.intersect(rect)) {
            rect2.offset(-rect.left, -rect.top);
            boolean z2 = true;
            boolean z3 = rect2.equals(this.mPatchArea) && point.equals(this.mPatchViewSize);
            if (!z3 || z) {
                if (z3 && z) {
                    z2 = false;
                }
                CancellableAsyncTask<Void, Void> cancellableAsyncTask = this.mDrawPatch;
                if (cancellableAsyncTask != null) {
                    cancellableAsyncTask.cancelAndWait();
                    this.mDrawPatch = null;
                }
                if (this.mPatch == null) {
                    this.mPatch = new OpaqueImageView(this.mContext);
                    this.mPatch.setScaleType(ImageView.ScaleType.MATRIX);
                    addView(this.mPatch);
                    View view = this.mSearchView;
                    if (view != null) {
                        view.bringToFront();
                    }
                }
                if (z2) {
                    updatePageTask = getDrawPageTask(this.mPatchBm, point.x, point.y, rect2.left, rect2.top, rect2.width(), rect2.height());
                } else {
                    updatePageTask = getUpdatePageTask(this.mPatchBm, point.x, point.y, rect2.left, rect2.top, rect2.width(), rect2.height());
                }
                this.mDrawPatch = new CancellableAsyncTask<Void, Void>(updatePageTask) { // from class: com.artifex.mupdflib.PageView.5
                    @Override // com.artifex.mupdflib.CancellableAsyncTask
                    public void onPostExecute(Void r5) {
                        PageView.this.mPatchViewSize = point;
                        PageView.this.mPatchArea = rect2;
                        PageView.this.mPatch.setImageBitmap(PageView.this.mPatchBm);
                        PageView.this.mPatch.invalidate();
                        PageView.this.mPatch.layout(PageView.this.mPatchArea.left, PageView.this.mPatchArea.top, PageView.this.mPatchArea.right, PageView.this.mPatchArea.bottom);
                    }
                };
                this.mDrawPatch.execute(new Void[0]);
            }
        }
    }

    public void update() {
        CancellableAsyncTask<Void, Void> cancellableAsyncTask = this.mDrawEntire;
        if (cancellableAsyncTask != null) {
            cancellableAsyncTask.cancelAndWait();
            this.mDrawEntire = null;
        }
        CancellableAsyncTask<Void, Void> cancellableAsyncTask2 = this.mDrawPatch;
        if (cancellableAsyncTask2 != null) {
            cancellableAsyncTask2.cancelAndWait();
            this.mDrawPatch = null;
        }
        this.mDrawEntire = new CancellableAsyncTask<Void, Void>(getUpdatePageTask(this.mEntireBm, this.mSize.x, this.mSize.y, 0, 0, this.mSize.x, this.mSize.y)) { // from class: com.artifex.mupdflib.PageView.6
            @Override // com.artifex.mupdflib.CancellableAsyncTask
            public void onPostExecute(Void r2) {
                PageView.this.mEntire.setImageBitmap(PageView.this.mEntireBm);
                PageView.this.mEntire.invalidate();
            }
        };
        this.mDrawEntire.execute(new Void[0]);
        updateHq(true);
    }

    public void removeHq() {
        CancellableAsyncTask<Void, Void> cancellableAsyncTask = this.mDrawPatch;
        if (cancellableAsyncTask != null) {
            cancellableAsyncTask.cancelAndWait();
            this.mDrawPatch = null;
        }
        this.mPatchViewSize = null;
        this.mPatchArea = null;
        ImageView imageView = this.mPatch;
        if (imageView != null) {
            imageView.setImageBitmap(null);
            this.mPatch.invalidate();
        }
    }

    public int getPage() {
        return this.mPageNumber;
    }
}
