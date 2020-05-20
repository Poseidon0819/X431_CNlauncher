package com.artifex.mupdflib;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Scroller;
import com.itextpdf.text.pdf.ColumnText;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import org.apache.mina.proxy.handlers.http.ntlm.NTLMConstants;

/* loaded from: classes.dex */
public class ReaderView extends AdapterView<Adapter> implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, ScaleGestureDetector.OnScaleGestureListener, Runnable {
    private static final int FLING_MARGIN = 100;
    private static final int GAP = 20;
    private static final float MAX_SCALE = 4.0f;
    private static final float MIN_SCALE = 0.97f;
    private static final int MOVING_DIAGONALLY = 0;
    private static final int MOVING_DOWN = 4;
    private static final int MOVING_LEFT = 1;
    private static final int MOVING_RIGHT = 2;
    private static final int MOVING_UP = 3;
    private static final float REFLOW_SCALE_FACTOR = 0.5f;
    private static long lastOnClickTime;
    private static int lastOnClickType;
    private boolean HORIZONTAL_SCROLLING;
    int height;
    private Adapter mAdapter;
    private final SparseArray<View> mChildViews;
    public int mCurrent;
    private final GestureDetector mGestureDetector;
    private float mLastScaleFocusX;
    private float mLastScaleFocusY;
    private boolean mReflow;
    private boolean mReflowChanged;
    private boolean mResetLayout;
    private float mScale;
    private final ScaleGestureDetector mScaleGestureDetector;
    private boolean mScaling;
    private final Scroller mScroller;
    private int mScrollerLastX;
    private int mScrollerLastY;
    private final Stepper mStepper;
    private boolean mUserInteracting;
    private final LinkedList<View> mViewCache;
    private int mXScroll;
    private int mYScroll;
    private boolean memAlert;
    int width;

    /* loaded from: classes.dex */
    public static abstract class ViewMapper {
        public abstract void applyToView(View view);
    }

    @Override // android.widget.AdapterView
    public View getSelectedView() {
        return null;
    }

    public void movingLeft(int i) {
    }

    public void movingRight() {
    }

    protected void onChildSetup(int i, View view) {
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
    }

    protected void onMoveOffChild(int i) {
    }

    protected void onMoveToChild(int i) {
    }

    protected void onNotInUse(View view) {
    }

    protected void onScaleChild(View view, Float f) {
    }

    protected void onSettle(View view) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    protected void onUnsettle(View view) {
    }

    public ReaderView(Context context) {
        super(context);
        this.HORIZONTAL_SCROLLING = false;
        this.mChildViews = new SparseArray<>(3);
        this.mViewCache = new LinkedList<>();
        this.mScale = MIN_SCALE;
        this.mReflow = false;
        this.mReflowChanged = false;
        this.memAlert = false;
        this.width = 0;
        this.height = 0;
        if (isInEditMode()) {
            this.mGestureDetector = null;
            this.mScaleGestureDetector = null;
            this.mScroller = null;
            this.mStepper = null;
            return;
        }
        this.mGestureDetector = new GestureDetector(this);
        this.mScaleGestureDetector = new ScaleGestureDetector(context, this);
        this.mScroller = new Scroller(context);
        this.mStepper = new Stepper(this, this);
    }

    public ReaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.HORIZONTAL_SCROLLING = false;
        this.mChildViews = new SparseArray<>(3);
        this.mViewCache = new LinkedList<>();
        this.mScale = MIN_SCALE;
        this.mReflow = false;
        this.mReflowChanged = false;
        this.memAlert = false;
        this.width = 0;
        this.height = 0;
        this.mGestureDetector = new GestureDetector(this);
        this.mScaleGestureDetector = new ScaleGestureDetector(context, this);
        this.mScroller = new Scroller(context);
        this.mStepper = new Stepper(this, this);
    }

    public ReaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.HORIZONTAL_SCROLLING = false;
        this.mChildViews = new SparseArray<>(3);
        this.mViewCache = new LinkedList<>();
        this.mScale = MIN_SCALE;
        this.mReflow = false;
        this.mReflowChanged = false;
        this.memAlert = false;
        this.width = 0;
        this.height = 0;
        this.mGestureDetector = new GestureDetector(this);
        this.mScaleGestureDetector = new ScaleGestureDetector(context, this);
        this.mScroller = new Scroller(context);
        this.mStepper = new Stepper(this, this);
    }

    public void setScaleByStart(float f) {
        this.mScale = f;
    }

    public int getDisplayedViewIndex() {
        return this.mCurrent;
    }

    public void setDisplayedViewIndex(int i) {
        if (i < 0 || i >= this.mAdapter.getCount()) {
            return;
        }
        onMoveOffChild(this.mCurrent);
        this.mCurrent = i;
        onMoveToChild(i);
        this.mResetLayout = true;
        requestLayout();
    }

    public void moveToNext() {
        View view = this.mChildViews.get(this.mCurrent + 1);
        movingLeft(-2);
        if (view != null) {
            slideViewOntoScreen(view);
        }
    }

    public void moveToPrevious(boolean z) {
        View view = this.mChildViews.get(this.mCurrent - 1);
        movingRight();
        if (view != null) {
            if (z) {
                slideViewOntoScreenPrevious(view);
            } else {
                slideViewOntoScreen(view);
            }
        }
    }

    private int smartAdvanceAmount(int i, int i2) {
        double d = i;
        Double.isNaN(d);
        int i3 = (int) ((0.9d * d) + 0.5d);
        int i4 = i2 % i3;
        int i5 = i2 / i3;
        if (i4 != 0) {
            float f = i5;
            double d2 = i4 / f;
            Double.isNaN(d);
            if (d2 <= 0.05d * d) {
                Double.isNaN(d2);
                i3 += (int) (d2 + 0.5d);
            } else {
                double d3 = (i3 - i4) / f;
                Double.isNaN(d);
                if (d3 <= d * 0.1d) {
                    Double.isNaN(d3);
                    i3 -= (int) (d3 + 0.5d);
                }
            }
        }
        return i3 > i2 ? i2 : i3;
    }

    public void smartMoveForwards() {
        int smartAdvanceAmount;
        int i;
        View view = this.mChildViews.get(this.mCurrent);
        if (view == null) {
            return;
        }
        int width = getWidth();
        int height = getHeight();
        int finalX = this.mScroller.getFinalX() - this.mScroller.getCurrX();
        int finalY = this.mScroller.getFinalY() - this.mScroller.getCurrY();
        int left = width - ((view.getLeft() + this.mXScroll) + finalX);
        int i2 = (-(view.getTop() + this.mYScroll + finalY)) + height;
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (i2 < measuredHeight) {
            smartAdvanceAmount = smartAdvanceAmount(height, measuredHeight - i2);
            width = 0;
        } else if (left + width > measuredWidth) {
            View view2 = this.mChildViews.get(this.mCurrent + 1);
            if (view2 == null) {
                return;
            }
            int i3 = -(view2.getTop() + this.mYScroll + finalY);
            int i4 = -(view2.getLeft() + this.mXScroll + finalX);
            int measuredWidth2 = view2.getMeasuredWidth();
            int measuredHeight2 = view2.getMeasuredHeight();
            int i5 = measuredHeight2 < height ? (measuredHeight2 - height) >> 1 : 0;
            if (measuredWidth2 < width) {
                i = (measuredWidth2 - width) >> 1;
            } else {
                int i6 = left % width;
                i = i6 + width > measuredWidth2 ? measuredWidth2 - width : i6;
            }
            width = i - i4;
            smartAdvanceAmount = i5 - i3;
        } else {
            smartAdvanceAmount = height - i2;
        }
        this.mScrollerLastY = 0;
        this.mScrollerLastX = 0;
        this.mScroller.startScroll(0, 0, finalX - width, finalY - smartAdvanceAmount, 400);
        this.mStepper.prod();
    }

    public void smartMoveBackwards() {
        int i;
        int i2;
        int i3;
        View view = this.mChildViews.get(this.mCurrent);
        if (view == null) {
            return;
        }
        int width = getWidth();
        int height = getHeight();
        int finalX = this.mScroller.getFinalX() - this.mScroller.getCurrX();
        int finalY = this.mScroller.getFinalY() - this.mScroller.getCurrY();
        int i4 = -(view.getLeft() + this.mXScroll + finalX);
        int i5 = -(view.getTop() + this.mYScroll + finalY);
        int measuredHeight = view.getMeasuredHeight();
        if (i5 > 0) {
            i = -smartAdvanceAmount(height, i5);
            i2 = 0;
        } else if (i4 < width) {
            View view2 = this.mChildViews.get(this.mCurrent - 1);
            if (view2 == null) {
                return;
            }
            int measuredWidth = view2.getMeasuredWidth();
            int measuredHeight2 = view2.getMeasuredHeight();
            int i6 = measuredHeight2 < height ? (measuredHeight2 - height) >> 1 : 0;
            int i7 = -(view2.getLeft() + this.mXScroll);
            int i8 = -(view2.getTop() + this.mYScroll);
            if (measuredWidth < width) {
                i3 = (measuredWidth - width) >> 1;
            } else {
                int i9 = i4 > 0 ? i4 % width : 0;
                if (i9 + width > measuredWidth) {
                    i9 = measuredWidth - width;
                }
                while ((width * 2) + i9 < measuredWidth) {
                    i9 += width;
                }
                i3 = i9;
            }
            i2 = i3 - i7;
            i = i6 - ((i8 - measuredHeight2) + height);
        } else {
            i2 = -width;
            i = (measuredHeight - height) + i5;
        }
        this.mScrollerLastY = 0;
        this.mScrollerLastX = 0;
        this.mScroller.startScroll(0, 0, finalX - i2, finalY - i, 400);
        this.mStepper.prod();
    }

    public void resetupChildren() {
        for (int i = 0; i < this.mChildViews.size(); i++) {
            onChildSetup(this.mChildViews.keyAt(i), this.mChildViews.valueAt(i));
        }
    }

    public void applyToChildren(ViewMapper viewMapper) {
        for (int i = 0; i < this.mChildViews.size(); i++) {
            viewMapper.applyToView(this.mChildViews.valueAt(i));
        }
    }

    public void refresh(boolean z) {
        this.mReflow = z;
        this.mReflowChanged = true;
        this.mResetLayout = true;
        this.mScale = MIN_SCALE;
        this.mYScroll = 0;
        this.mXScroll = 0;
        requestLayout();
    }

    public View getView(int i) {
        return this.mChildViews.get(i);
    }

    public View getDisplayedView() {
        return this.mChildViews.get(this.mCurrent);
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        if (!this.mScroller.isFinished()) {
            this.mScroller.computeScrollOffset();
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            this.mXScroll += currX - this.mScrollerLastX;
            this.mYScroll += currY - this.mScrollerLastY;
            this.mScrollerLastX = currX;
            this.mScrollerLastY = currY;
            requestLayout();
            this.mStepper.prod();
        } else if (this.mUserInteracting || (view = this.mChildViews.get(this.mCurrent)) == null) {
        } else {
            postSettle(view);
        }
    }

    public boolean onDown(MotionEvent motionEvent) {
        this.mScroller.forceFinished(true);
        return true;
    }

    public static boolean isFastClick() {
        return isFastClick(500L, 0);
    }

    public static synchronized boolean isFastClick(long j, int i) {
        synchronized (ReaderView.class) {
            long currentTimeMillis = System.currentTimeMillis();
            if (lastOnClickType != i) {
                lastOnClickType = i;
                lastOnClickTime = currentTimeMillis;
                return false;
            } else if (Math.abs(currentTimeMillis - lastOnClickTime) < j) {
                return true;
            } else {
                lastOnClickTime = currentTimeMillis;
                return false;
            }
        }
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        View view;
        View view2;
        if (isFastClick()) {
            return false;
        }
        if (!this.mScaling && (view = this.mChildViews.get(this.mCurrent)) != null) {
            Rect scrollBounds = getScrollBounds(view);
            switch (directionOfTravel(f, f2)) {
                case 1:
                    if (this.HORIZONTAL_SCROLLING && scrollBounds.left >= 0) {
                        View view3 = this.mChildViews.get(this.mCurrent + 1);
                        movingLeft(-2);
                        if (view3 != null) {
                            slideViewOntoScreen(view3);
                            return true;
                        }
                    }
                    break;
                case 2:
                    if (this.HORIZONTAL_SCROLLING && scrollBounds.right <= 0) {
                        View view4 = this.mChildViews.get(this.mCurrent - 1);
                        movingRight();
                        if (view4 != null) {
                            slideViewOntoScreen(view4);
                            return true;
                        }
                    }
                    break;
                case 3:
                    if (!this.HORIZONTAL_SCROLLING && scrollBounds.top >= 0) {
                        View view5 = this.mChildViews.get(this.mCurrent + 1);
                        if (scrollBounds.top < 0) {
                            movingLeft(-1);
                        } else {
                            movingLeft(-2);
                        }
                        if (view5 != null) {
                            slideViewOntoScreen(view5);
                            return true;
                        }
                    }
                    break;
                case 4:
                    if (!this.HORIZONTAL_SCROLLING && scrollBounds.bottom <= 0 && (view2 = this.mChildViews.get(this.mCurrent - 1)) != null) {
                        slideViewOntoScreen(view2);
                        return true;
                    }
                    break;
            }
            this.mScrollerLastY = 0;
            this.mScrollerLastX = 0;
            Rect rect = new Rect(scrollBounds);
            rect.inset(-100, -100);
            if (withinBoundsInDirectionOfTravel(scrollBounds, f, f2) && rect.contains(0, 0)) {
                this.mScroller.fling(0, 0, (int) f, (int) f2, scrollBounds.left, scrollBounds.right, scrollBounds.top, scrollBounds.bottom);
                this.mStepper.prod();
            }
        }
        return true;
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.mScaling) {
            return true;
        }
        this.mXScroll = (int) (this.mXScroll - f);
        this.mYScroll = (int) (this.mYScroll - f2);
        requestLayout();
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        float f = this.mScale;
        float f2 = this.mReflow ? REFLOW_SCALE_FACTOR : 1.0f;
        this.mScale = Math.min(Math.max(this.mScale * scaleGestureDetector.getScaleFactor(), MIN_SCALE * f2), f2 * MAX_SCALE);
        if (this.mReflow) {
            View view = this.mChildViews.get(this.mCurrent);
            if (view != null) {
                onScaleChild(view, Float.valueOf(this.mScale));
                return true;
            }
            return true;
        }
        float f3 = this.mScale / f;
        View view2 = this.mChildViews.get(this.mCurrent);
        if (view2 != null) {
            float focusX = scaleGestureDetector.getFocusX();
            float focusY = scaleGestureDetector.getFocusY();
            int left = ((int) focusX) - (view2.getLeft() + this.mXScroll);
            int top = view2.getTop();
            int i = this.mYScroll;
            float f4 = left;
            this.mXScroll = (int) (this.mXScroll + (f4 - (f4 * f3)));
            float f5 = ((int) focusY) - (top + i);
            this.mYScroll = (int) (i + (f5 - (f3 * f5)));
            float f6 = this.mLastScaleFocusX;
            if (f6 >= ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
                this.mXScroll = (int) (this.mXScroll + (focusX - f6));
            }
            float f7 = this.mLastScaleFocusY;
            if (f7 >= ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
                this.mYScroll = (int) (this.mYScroll + (focusY - f7));
            }
            this.mLastScaleFocusX = focusX;
            this.mLastScaleFocusY = focusY;
            requestLayout();
            return true;
        }
        return true;
    }

    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        this.mScaling = true;
        this.mYScroll = 0;
        this.mXScroll = 0;
        this.mLastScaleFocusY = -1.0f;
        this.mLastScaleFocusX = -1.0f;
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        if (this.mReflow) {
            applyToChildren(new ViewMapper() { // from class: com.artifex.mupdflib.ReaderView.1
                @Override // com.artifex.mupdflib.ReaderView.ViewMapper
                public void applyToView(View view) {
                    ReaderView readerView = ReaderView.this;
                    readerView.onScaleChild(view, Float.valueOf(readerView.mScale));
                }
            });
        }
        this.mScaling = false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.mScaleGestureDetector.onTouchEvent(motionEvent);
        this.mGestureDetector.onTouchEvent(motionEvent);
        if ((motionEvent.getAction() & 255) == 0) {
            this.mUserInteracting = true;
            onUnsettle(this.mChildViews.get(this.mCurrent));
        }
        if ((motionEvent.getAction() & 255) == 1) {
            this.mUserInteracting = false;
            View view = this.mChildViews.get(this.mCurrent);
            if (view != null) {
                if (this.mScroller.isFinished()) {
                    slideViewOntoScreen(view);
                }
                if (this.mScroller.isFinished()) {
                    postSettle(view);
                }
            }
        }
        return true;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            measureView(getChildAt(i3));
        }
    }

    @Override // android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        try {
            onLayout2(z, i, i2, i3, i4);
        } catch (OutOfMemoryError e) {
            System.out.println("Out of memory during layout");
            e.printStackTrace();
        }
    }

    private void onLayout2(boolean z, int i, int i2, int i3, int i4) {
        int left;
        int top;
        boolean z2;
        boolean z3;
        if (isInEditMode()) {
            return;
        }
        View view = this.mChildViews.get(this.mCurrent);
        if (!this.mResetLayout) {
            if (view != null) {
                Point subScreenSizeOffset = subScreenSizeOffset(view);
                if (this.HORIZONTAL_SCROLLING) {
                    z2 = (((view.getLeft() + view.getMeasuredWidth()) + subScreenSizeOffset.x) + 10) + this.mXScroll < getWidth() / 2;
                } else {
                    z2 = (((view.getTop() + view.getMeasuredHeight()) + subScreenSizeOffset.y) + 10) + this.mYScroll < getHeight() / 2;
                }
                if (z2 && this.mCurrent + 1 < this.mAdapter.getCount()) {
                    postUnsettle(view);
                    this.mStepper.prod();
                    onMoveOffChild(this.mCurrent);
                    this.mCurrent++;
                    onMoveToChild(this.mCurrent);
                }
                if (this.HORIZONTAL_SCROLLING) {
                    z3 = ((view.getLeft() - subScreenSizeOffset.x) + (-10)) + this.mXScroll >= getWidth() / 2;
                } else {
                    z3 = ((view.getTop() - subScreenSizeOffset.y) + (-10)) + this.mYScroll >= getHeight() / 2;
                }
                if (z3 && this.mCurrent > 0) {
                    postUnsettle(view);
                    this.mStepper.prod();
                    onMoveOffChild(this.mCurrent);
                    this.mCurrent--;
                    onMoveToChild(this.mCurrent);
                }
            }
            int size = this.mChildViews.size();
            int[] iArr = new int[size];
            for (int i5 = 0; i5 < size; i5++) {
                iArr[i5] = this.mChildViews.keyAt(i5);
            }
            for (int i6 = 0; i6 < size; i6++) {
                int i7 = iArr[i6];
                int i8 = this.mCurrent;
                if (i7 < i8 - 1 || i7 > i8 + 1) {
                    View view2 = this.mChildViews.get(i7);
                    onNotInUse(view2);
                    this.mViewCache.add(view2);
                    removeViewInLayout(view2);
                    this.mChildViews.remove(i7);
                }
            }
        } else {
            this.mResetLayout = false;
            this.mYScroll = 0;
            this.mXScroll = 0;
            int size2 = this.mChildViews.size();
            for (int i9 = 0; i9 < size2; i9++) {
                View valueAt = this.mChildViews.valueAt(i9);
                onNotInUse(valueAt);
                this.mViewCache.add(valueAt);
                removeViewInLayout(valueAt);
            }
            this.mChildViews.clear();
            if (this.mReflowChanged) {
                this.mReflowChanged = false;
                this.mViewCache.clear();
            }
            this.mStepper.prod();
        }
        boolean z4 = this.mChildViews.get(this.mCurrent) == null;
        View orCreateChild = getOrCreateChild(this.mCurrent);
        Point subScreenSizeOffset2 = subScreenSizeOffset(orCreateChild);
        if (z4) {
            left = subScreenSizeOffset2.x;
            top = subScreenSizeOffset2.y;
        } else {
            left = orCreateChild.getLeft() + this.mXScroll;
            top = orCreateChild.getTop() + this.mYScroll;
        }
        this.mYScroll = 0;
        this.mXScroll = 0;
        int measuredWidth = orCreateChild.getMeasuredWidth() + left;
        int measuredHeight = orCreateChild.getMeasuredHeight() + top;
        if (!this.mUserInteracting && this.mScroller.isFinished()) {
            Point correction = getCorrection(getScrollBounds(left, top, measuredWidth, measuredHeight));
            measuredWidth += correction.x;
            left += correction.x;
            top += correction.y;
            measuredHeight += correction.y;
        } else if (this.HORIZONTAL_SCROLLING && orCreateChild.getMeasuredHeight() <= getHeight()) {
            Point correction2 = getCorrection(getScrollBounds(left, top, measuredWidth, measuredHeight));
            top += correction2.y;
            measuredHeight += correction2.y;
        } else if (!this.HORIZONTAL_SCROLLING && orCreateChild.getMeasuredWidth() <= getWidth()) {
            Point correction3 = getCorrection(getScrollBounds(left, top, measuredWidth, measuredHeight));
            measuredWidth += correction3.x;
            left += correction3.x;
        }
        orCreateChild.layout(left, top, measuredWidth, measuredHeight);
        int i10 = this.mCurrent;
        if (i10 > 0) {
            View orCreateChild2 = getOrCreateChild(i10 - 1);
            Point subScreenSizeOffset3 = subScreenSizeOffset(orCreateChild2);
            if (this.HORIZONTAL_SCROLLING) {
                int i11 = subScreenSizeOffset3.x + 20 + subScreenSizeOffset2.x;
                int i12 = measuredHeight + top;
                orCreateChild2.layout((left - orCreateChild2.getMeasuredWidth()) - i11, (i12 - orCreateChild2.getMeasuredHeight()) / 2, left - i11, (i12 + orCreateChild2.getMeasuredHeight()) / 2);
            } else {
                int i13 = subScreenSizeOffset3.y + 20 + subScreenSizeOffset2.y;
                int i14 = left + measuredWidth;
                orCreateChild2.layout((i14 - orCreateChild2.getMeasuredWidth()) / 2, (top - orCreateChild2.getMeasuredHeight()) - i13, (i14 + orCreateChild2.getMeasuredWidth()) / 2, top - i13);
            }
        }
        if (this.mCurrent + 1 < this.mAdapter.getCount()) {
            View orCreateChild3 = getOrCreateChild(this.mCurrent + 1);
            Point subScreenSizeOffset4 = subScreenSizeOffset(orCreateChild3);
            if (this.HORIZONTAL_SCROLLING) {
                int i15 = subScreenSizeOffset2.x + 20 + subScreenSizeOffset4.x;
                int i16 = measuredHeight + top;
                orCreateChild3.layout(measuredWidth + i15, (i16 - orCreateChild3.getMeasuredHeight()) / 2, measuredWidth + orCreateChild3.getMeasuredWidth() + i15, (i16 + orCreateChild3.getMeasuredHeight()) / 2);
            } else {
                int i17 = left + measuredWidth;
                int i18 = measuredHeight + subScreenSizeOffset2.y + 20 + subScreenSizeOffset4.y;
                orCreateChild3.layout((i17 - orCreateChild3.getMeasuredWidth()) / 2, i18, (i17 + orCreateChild3.getMeasuredWidth()) / 2, orCreateChild3.getMeasuredHeight() + i18);
            }
        }
        invalidate();
    }

    @Override // android.widget.AdapterView
    public Adapter getAdapter() {
        return this.mAdapter;
    }

    @Override // android.widget.AdapterView
    public void setAdapter(Adapter adapter) {
        Adapter adapter2 = this.mAdapter;
        if (adapter2 != null && adapter != adapter2 && (adapter instanceof MuPDFPageAdapter)) {
            ((MuPDFPageAdapter) adapter).releaseBitmaps();
        }
        this.mAdapter = adapter;
        requestLayout();
    }

    @Override // android.widget.AdapterView
    public void setSelection(int i) {
        throw new UnsupportedOperationException(getContext().getString(C0835R.string.not_supported));
    }

    public void setScrollingDirectionHorizontal(boolean z) {
        this.HORIZONTAL_SCROLLING = z;
    }

    private View getCached() {
        if (this.mViewCache.size() == 0) {
            return null;
        }
        return this.mViewCache.removeFirst();
    }

    private View getOrCreateChild(int i) {
        View view = this.mChildViews.get(i);
        if (view == null) {
            View view2 = this.mAdapter.getView(i, getCached(), this);
            addAndMeasureChild(i, view2);
            onChildSetup(i, view2);
            onScaleChild(view2, Float.valueOf(this.mScale));
            return view2;
        }
        return view;
    }

    private void addAndMeasureChild(int i, View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-2, -2);
        }
        addViewInLayout(view, 0, layoutParams, true);
        this.mChildViews.append(i, view);
        measureView(view);
    }

    public void setWidth(int i) {
        this.width = i;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    private void measureView(View view) {
        view.measure(0, 0);
        if (!this.mReflow) {
            int i = this.width;
            if (i != 0) {
                float f = this.mScale;
                view.measure(((int) (i * 1.0f * f)) | NTLMConstants.FLAG_NEGOTIATE_KEY_EXCHANGE, 1073741824 | ((int) (this.height * 1.0f * f)));
                return;
            }
            view.measure(((int) (view.getMeasuredWidth() * 1.0f * this.mScale)) | NTLMConstants.FLAG_NEGOTIATE_KEY_EXCHANGE, 1073741824 | ((int) (view.getMeasuredHeight() * 1.0f * this.mScale)));
            return;
        }
        view.measure(view.getMeasuredWidth() | NTLMConstants.FLAG_NEGOTIATE_KEY_EXCHANGE, 1073741824 | view.getMeasuredHeight());
    }

    private Rect getScrollBounds(int i, int i2, int i3, int i4) {
        int width = getWidth() - i3;
        int i5 = -i;
        int height = getHeight() - i4;
        int i6 = -i2;
        if (width > i5) {
            width = (width + i5) / 2;
            i5 = width;
        }
        if (height > i6) {
            height = (height + i6) / 2;
            i6 = height;
        }
        return new Rect(width, height, i5, i6);
    }

    private Rect getScrollBounds(View view) {
        return getScrollBounds(view.getLeft() + this.mXScroll, view.getTop() + this.mYScroll, view.getLeft() + view.getMeasuredWidth() + this.mXScroll, view.getTop() + view.getMeasuredHeight() + this.mYScroll);
    }

    private Point getCorrection(Rect rect) {
        return new Point(Math.min(Math.max(0, rect.left), rect.right), Math.min(Math.max(0, rect.top), rect.bottom));
    }

    private void postSettle(final View view) {
        post(new Runnable() { // from class: com.artifex.mupdflib.ReaderView.2
            @Override // java.lang.Runnable
            public void run() {
                ReaderView.this.onSettle(view);
            }
        });
    }

    public void postSettle() {
        post(new Runnable() { // from class: com.artifex.mupdflib.ReaderView.3
            @Override // java.lang.Runnable
            public void run() {
                ReaderView.this.onSettle((View) ReaderView.this.mChildViews.get(ReaderView.this.mCurrent));
            }
        });
    }

    private void postUnsettle(final View view) {
        post(new Runnable() { // from class: com.artifex.mupdflib.ReaderView.4
            @Override // java.lang.Runnable
            public void run() {
                ReaderView.this.onUnsettle(view);
            }
        });
    }

    public void slideViewOntoScreenPrevious(View view) {
        Point correction = getCorrection(getScrollBounds(view));
        if (correction.x == 0 && correction.y == 0) {
            return;
        }
        this.mScrollerLastY = 0;
        this.mScrollerLastX = 0;
        this.mScroller.startScroll(0, 0, correction.x, view.getMeasuredHeight(), 400);
        this.mStepper.prod();
    }

    public void slideViewOntoScreen(View view) {
        Point correction = getCorrection(getScrollBounds(view));
        if (correction.x == 0 && correction.y == 0) {
            return;
        }
        this.mScrollerLastY = 0;
        this.mScrollerLastX = 0;
        this.mScroller.startScroll(0, 0, correction.x, correction.y, 400);
        this.mStepper.prod();
    }

    private Point subScreenSizeOffset(View view) {
        return new Point(Math.max((getWidth() - view.getMeasuredWidth()) / 2, 0), Math.max((getHeight() - view.getMeasuredHeight()) / 2, 0));
    }

    private static int directionOfTravel(float f, float f2) {
        if (Math.abs(f) > Math.abs(f2) * 2.0f) {
            return f > ColumnText.GLOBAL_SPACE_CHAR_RATIO ? 2 : 1;
        } else if (Math.abs(f2) > Math.abs(f) * 2.0f) {
            return f2 > ColumnText.GLOBAL_SPACE_CHAR_RATIO ? 4 : 3;
        } else {
            return 0;
        }
    }

    private static boolean withinBoundsInDirectionOfTravel(Rect rect, float f, float f2) {
        switch (directionOfTravel(f, f2)) {
            case 0:
                return rect.contains(0, 0);
            case 1:
                return rect.left <= 0;
            case 2:
                return rect.right >= 0;
            case 3:
                return rect.top <= 0;
            case 4:
                return rect.bottom >= 0;
            default:
                throw new NoSuchElementException();
        }
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        float f = this.mScale;
        this.mScale = (f == MIN_SCALE ? 2.0f : -2.0f) + f;
        if (this.mScale < 2.97f) {
            this.mScale = MIN_SCALE;
        }
        if (this.mScale > 2.97f) {
            this.mScale = 2.97f;
        }
        float f2 = this.mScale / f;
        View view = this.mChildViews.get(this.mCurrent);
        if (view != null) {
            int x = ((int) motionEvent.getX()) - (view.getLeft() + this.mXScroll);
            int top = view.getTop();
            int i = this.mYScroll;
            int y = ((int) motionEvent.getY()) - (top + i);
            float f3 = x;
            this.mXScroll = (int) (this.mXScroll + (f3 - (f3 * f2)));
            float f4 = y;
            this.mYScroll = (int) (i + (f4 - (f2 * f4)));
            requestLayout();
            return true;
        }
        return true;
    }
}
