package com.artifex.mupdflib;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.p012v4.p019d.LongSparseArray;
import android.support.p012v4.p019d.SparseArrayCompat;
import android.support.p012v4.view.AccessibilityDelegateCompat;
import android.support.p012v4.view.KeyEventCompat;
import android.support.p012v4.view.MotionEventCompat;
import android.support.p012v4.view.VelocityTrackerCompat;
import android.support.p012v4.view.ViewCompat;
import android.support.p012v4.view.p021a.AccessibilityNodeInfoCompat;
import android.support.p012v4.widget.EdgeEffectCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.ContextMenu;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AdapterView;
import android.widget.Checkable;
import android.widget.ListAdapter;
import android.widget.Scroller;
import com.itextpdf.text.pdf.ColumnText;
import com.mopub.nativeads.MoPubNativeAdPositioning;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.mina.proxy.handlers.http.ntlm.NTLMConstants;

/* loaded from: classes.dex */
public class TwoWayView extends AdapterView<ListAdapter> implements ViewTreeObserver.OnTouchModeChangeListener {
    private static final int CHECK_POSITION_SEARCH_DISTANCE = 20;
    private static final int INVALID_POINTER = -1;
    private static final int LAYOUT_FORCE_BOTTOM = 3;
    private static final int LAYOUT_FORCE_TOP = 1;
    private static final int LAYOUT_MOVE_SELECTION = 6;
    private static final int LAYOUT_NORMAL = 0;
    private static final int LAYOUT_SET_SELECTION = 2;
    private static final int LAYOUT_SPECIFIC = 4;
    private static final int LAYOUT_SYNC = 5;
    private static final String LOGTAG = "TwoWayView";
    private static final float MAX_SCROLL_FACTOR = 0.33f;
    private static final int MIN_SCROLL_PREVIEW_PIXELS = 10;
    private static final int NO_POSITION = -1;
    public static final int[] STATE_NOTHING = {0};
    private static final int SYNC_FIRST_POSITION = 1;
    private static final int SYNC_MAX_DURATION_MILLIS = 100;
    private static final int SYNC_SELECTED_POSITION = 0;
    private static final int TOUCH_MODE_DONE_WAITING = 2;
    private static final int TOUCH_MODE_DOWN = 0;
    private static final int TOUCH_MODE_DRAGGING = 3;
    private static final int TOUCH_MODE_FLINGING = 4;
    private static final int TOUCH_MODE_OFF = 1;
    private static final int TOUCH_MODE_ON = 0;
    private static final int TOUCH_MODE_OVERSCROLL = 5;
    private static final int TOUCH_MODE_REST = -1;
    private static final int TOUCH_MODE_TAP = 1;
    private static final int TOUCH_MODE_UNKNOWN = -1;
    private ListItemAccessibilityDelegate mAccessibilityDelegate;
    private int mActivePointerId;
    private ListAdapter mAdapter;
    private boolean mAreAllItemsSelectable;
    private final ArrowScrollFocusResult mArrowScrollFocusResult;
    private boolean mBlockLayoutRequests;
    private SparseBooleanArray mCheckStates;
    LongSparseArray<Integer> mCheckedIdStates;
    private int mCheckedItemCount;
    private ChoiceMode mChoiceMode;
    private final Context mContext;
    private ContextMenu.ContextMenuInfo mContextMenuInfo;
    private boolean mDataChanged;
    private AdapterDataSetObserver mDataSetObserver;
    private boolean mDesiredFocusableInTouchModeState;
    private boolean mDesiredFocusableState;
    private boolean mDrawSelectorOnTop;
    private View mEmptyView;
    private EdgeEffectCompat mEndEdge;
    private int mFirstPosition;
    private final int mFlingVelocity;
    private boolean mHasStableIds;
    private boolean mInLayout;
    private boolean mIsAttached;
    private boolean mIsChildViewEnabled;
    final boolean[] mIsScrap;
    private boolean mIsVertical;
    private int mItemCount;
    private int mItemMargin;
    private boolean mItemsCanFocus;
    private int mLastAccessibilityScrollEventFromIndex;
    private int mLastAccessibilityScrollEventToIndex;
    private int mLastScrollState;
    private int mLastTouchMode;
    private float mLastTouchPos;
    private int mLayoutMode;
    private final int mMaximumVelocity;
    private int mMotionPosition;
    private boolean mNeedSync;
    private int mNextSelectedPosition;
    private long mNextSelectedRowId;
    private int mOldItemCount;
    private int mOldSelectedPosition;
    private long mOldSelectedRowId;
    private OnScrollListener mOnScrollListener;
    private int mOverScroll;
    private final int mOverscrollDistance;
    private CheckForKeyLongPress mPendingCheckForKeyLongPress;
    private CheckForLongPress mPendingCheckForLongPress;
    private CheckForTap mPendingCheckForTap;
    private SavedState mPendingSync;
    private PerformClick mPerformClick;
    private Runnable mPositionScrollAfterLayout;
    private PositionScroller mPositionScroller;
    private final RecycleBin mRecycler;
    private int mResurrectToPosition;
    private final Scroller mScroller;
    private int mSelectedPosition;
    private long mSelectedRowId;
    private int mSelectedStart;
    private SelectionNotifier mSelectionNotifier;
    private Drawable mSelector;
    private int mSelectorPosition;
    private final Rect mSelectorRect;
    private int mSpecificStart;
    private EdgeEffectCompat mStartEdge;
    private int mSyncMode;
    private int mSyncPosition;
    private long mSyncRowId;
    private long mSyncSize;
    private final Rect mTempRect;
    private Rect mTouchFrame;
    private int mTouchMode;
    private Runnable mTouchModeReset;
    private float mTouchRemainderPos;
    private final int mTouchSlop;
    private VelocityTracker mVelocityTracker;

    /* loaded from: classes.dex */
    public enum ChoiceMode {
        NONE,
        SINGLE,
        MULTIPLE
    }

    /* loaded from: classes.dex */
    public interface OnScrollListener {
        public static final int SCROLL_STATE_FLING = 2;
        public static final int SCROLL_STATE_IDLE = 0;
        public static final int SCROLL_STATE_TOUCH_SCROLL = 1;

        void onScroll(TwoWayView twoWayView, int i, int i2, int i3);

        void onScrollStateChanged(TwoWayView twoWayView, int i);
    }

    /* loaded from: classes.dex */
    public enum Orientation {
        HORIZONTAL,
        VERTICAL
    }

    /* loaded from: classes.dex */
    public interface RecyclerListener {
        void onMovedToScrapHeap(View view);
    }

    private int getMinSelectionPixel(int i, int i2, int i3) {
        return i3 > 0 ? i + i2 : i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    protected boolean recycleOnMeasure() {
        return true;
    }

    public TwoWayView(Context context) {
        this(context, null);
    }

    public TwoWayView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TwoWayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIsScrap = new boolean[1];
        this.mContext = context;
        this.mLayoutMode = 0;
        this.mTouchMode = -1;
        this.mLastTouchMode = -1;
        this.mLastScrollState = 0;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mOverscrollDistance = getScaledOverscrollDistance(viewConfiguration);
        this.mScroller = new Scroller(context);
        this.mIsVertical = true;
        this.mTempRect = new Rect();
        this.mArrowScrollFocusResult = new ArrowScrollFocusResult();
        this.mSelectorPosition = -1;
        this.mSelectorRect = new Rect();
        this.mResurrectToPosition = -1;
        this.mNextSelectedPosition = -1;
        this.mNextSelectedRowId = Long.MIN_VALUE;
        this.mSelectedPosition = -1;
        this.mSelectedRowId = Long.MIN_VALUE;
        this.mOldSelectedPosition = -1;
        this.mOldSelectedRowId = Long.MIN_VALUE;
        this.mChoiceMode = ChoiceMode.NONE;
        this.mRecycler = new RecycleBin();
        this.mAreAllItemsSelectable = true;
        setClickable(true);
        setFocusableInTouchMode(true);
        setWillNotDraw(false);
        setAlwaysDrawnWithCacheEnabled(false);
        setWillNotDraw(false);
        setClipToPadding(false);
        ViewCompat.m14636b(this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0835R.styleable.TwoWayView, i, 0);
        this.mDrawSelectorOnTop = obtainStyledAttributes.getBoolean(C0835R.styleable.TwoWayView_android_drawSelectorOnTop, false);
        Drawable drawable = obtainStyledAttributes.getDrawable(C0835R.styleable.TwoWayView_android_listSelector);
        if (drawable != null) {
            setSelector(drawable);
        }
        int i2 = obtainStyledAttributes.getInt(C0835R.styleable.TwoWayView_android_orientation, -1);
        if (i2 >= 0) {
            setOrientation(Orientation.values()[i2]);
        }
        int i3 = obtainStyledAttributes.getInt(C0835R.styleable.TwoWayView_android_choiceMode, -1);
        if (i3 >= 0) {
            setChoiceMode(ChoiceMode.values()[i3]);
        }
        obtainStyledAttributes.recycle();
    }

    public void setOrientation(Orientation orientation) {
        boolean z = orientation == Orientation.VERTICAL;
        if (this.mIsVertical == z) {
            return;
        }
        this.mIsVertical = z;
        resetState();
        this.mRecycler.clear();
        requestLayout();
    }

    public Orientation getOrientation() {
        return this.mIsVertical ? Orientation.VERTICAL : Orientation.HORIZONTAL;
    }

    public void setItemMargin(int i) {
        if (this.mItemMargin == i) {
            return;
        }
        this.mItemMargin = i;
        requestLayout();
    }

    public int getItemMargin() {
        return this.mItemMargin;
    }

    public void setItemsCanFocus(boolean z) {
        this.mItemsCanFocus = z;
        if (z) {
            return;
        }
        setDescendantFocusability(393216);
    }

    public boolean getItemsCanFocus() {
        return this.mItemsCanFocus;
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.mOnScrollListener = onScrollListener;
        invokeOnItemScrollListener();
    }

    public void setRecyclerListener(RecyclerListener recyclerListener) {
        this.mRecycler.mRecyclerListener = recyclerListener;
    }

    public void setDrawSelectorOnTop(boolean z) {
        this.mDrawSelectorOnTop = z;
    }

    public void setSelector(int i) {
        setSelector(getResources().getDrawable(i));
    }

    public void setSelector(Drawable drawable) {
        Drawable drawable2 = this.mSelector;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.mSelector);
        }
        this.mSelector = drawable;
        drawable.getPadding(new Rect());
        drawable.setCallback(this);
        updateSelectorState();
    }

    public Drawable getSelector() {
        return this.mSelector;
    }

    @Override // android.widget.AdapterView
    public int getSelectedItemPosition() {
        return this.mNextSelectedPosition;
    }

    @Override // android.widget.AdapterView
    public long getSelectedItemId() {
        return this.mNextSelectedRowId;
    }

    public int getCheckedItemCount() {
        return this.mCheckedItemCount;
    }

    public boolean isItemChecked(int i) {
        SparseBooleanArray sparseBooleanArray;
        if (this.mChoiceMode != ChoiceMode.NONE || (sparseBooleanArray = this.mCheckStates) == null) {
            return false;
        }
        return sparseBooleanArray.get(i);
    }

    public int getCheckedItemPosition() {
        SparseBooleanArray sparseBooleanArray;
        if (this.mChoiceMode == ChoiceMode.SINGLE && (sparseBooleanArray = this.mCheckStates) != null && sparseBooleanArray.size() == 1) {
            return this.mCheckStates.keyAt(0);
        }
        return -1;
    }

    public SparseBooleanArray getCheckedItemPositions() {
        if (this.mChoiceMode != ChoiceMode.NONE) {
            return this.mCheckStates;
        }
        return null;
    }

    public long[] getCheckedItemIds() {
        LongSparseArray<Integer> longSparseArray;
        if (this.mChoiceMode == ChoiceMode.NONE || (longSparseArray = this.mCheckedIdStates) == null || this.mAdapter == null) {
            return new long[0];
        }
        int m14874b = longSparseArray.m14874b();
        long[] jArr = new long[m14874b];
        for (int i = 0; i < m14874b; i++) {
            jArr[i] = longSparseArray.m14873b(i);
        }
        return jArr;
    }

    public void setItemChecked(int i, boolean z) {
        if (this.mChoiceMode == ChoiceMode.NONE) {
            return;
        }
        if (this.mChoiceMode == ChoiceMode.MULTIPLE) {
            boolean z2 = this.mCheckStates.get(i);
            this.mCheckStates.put(i, z);
            if (this.mCheckedIdStates != null && this.mAdapter.hasStableIds()) {
                if (z) {
                    this.mCheckedIdStates.m14875a(this.mAdapter.getItemId(i), Integer.valueOf(i));
                } else {
                    this.mCheckedIdStates.m14872b(this.mAdapter.getItemId(i));
                }
            }
            if (z2 != z) {
                if (z) {
                    this.mCheckedItemCount++;
                } else {
                    this.mCheckedItemCount--;
                }
            }
        } else {
            boolean z3 = this.mCheckedIdStates != null && this.mAdapter.hasStableIds();
            if (z || isItemChecked(i)) {
                this.mCheckStates.clear();
                if (z3) {
                    this.mCheckedIdStates.m14871c();
                }
            }
            if (z) {
                this.mCheckStates.put(i, true);
                if (z3) {
                    this.mCheckedIdStates.m14875a(this.mAdapter.getItemId(i), Integer.valueOf(i));
                }
                this.mCheckedItemCount = 1;
            } else if (this.mCheckStates.size() == 0 || !this.mCheckStates.valueAt(0)) {
                this.mCheckedItemCount = 0;
            }
        }
        if (this.mInLayout || this.mBlockLayoutRequests) {
            return;
        }
        this.mDataChanged = true;
        rememberSyncState();
        requestLayout();
    }

    public void clearChoices() {
        SparseBooleanArray sparseBooleanArray = this.mCheckStates;
        if (sparseBooleanArray != null) {
            sparseBooleanArray.clear();
        }
        LongSparseArray<Integer> longSparseArray = this.mCheckedIdStates;
        if (longSparseArray != null) {
            longSparseArray.m14871c();
        }
        this.mCheckedItemCount = 0;
    }

    public ChoiceMode getChoiceMode() {
        return this.mChoiceMode;
    }

    public void setChoiceMode(ChoiceMode choiceMode) {
        ListAdapter listAdapter;
        this.mChoiceMode = choiceMode;
        if (this.mChoiceMode != ChoiceMode.NONE) {
            if (this.mCheckStates == null) {
                this.mCheckStates = new SparseBooleanArray();
            }
            if (this.mCheckedIdStates == null && (listAdapter = this.mAdapter) != null && listAdapter.hasStableIds()) {
                this.mCheckedIdStates = new LongSparseArray<>();
            }
        }
    }

    @Override // android.widget.AdapterView
    public ListAdapter getAdapter() {
        return this.mAdapter;
    }

    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        AdapterDataSetObserver adapterDataSetObserver;
        ListAdapter listAdapter2 = this.mAdapter;
        if (listAdapter2 != null && (adapterDataSetObserver = this.mDataSetObserver) != null) {
            listAdapter2.unregisterDataSetObserver(adapterDataSetObserver);
        }
        resetState();
        this.mRecycler.clear();
        this.mAdapter = listAdapter;
        this.mDataChanged = true;
        this.mOldSelectedPosition = -1;
        this.mOldSelectedRowId = Long.MIN_VALUE;
        SparseBooleanArray sparseBooleanArray = this.mCheckStates;
        if (sparseBooleanArray != null) {
            sparseBooleanArray.clear();
        }
        LongSparseArray<Integer> longSparseArray = this.mCheckedIdStates;
        if (longSparseArray != null) {
            longSparseArray.m14871c();
        }
        if (this.mAdapter != null) {
            this.mOldItemCount = this.mItemCount;
            this.mItemCount = listAdapter.getCount();
            this.mDataSetObserver = new AdapterDataSetObserver();
            this.mAdapter.registerDataSetObserver(this.mDataSetObserver);
            this.mRecycler.setViewTypeCount(listAdapter.getViewTypeCount());
            this.mHasStableIds = listAdapter.hasStableIds();
            this.mAreAllItemsSelectable = listAdapter.areAllItemsEnabled();
            if (this.mChoiceMode != ChoiceMode.NONE && this.mHasStableIds && this.mCheckedIdStates == null) {
                this.mCheckedIdStates = new LongSparseArray<>();
            }
            int lookForSelectablePosition = lookForSelectablePosition(0);
            setSelectedPositionInt(lookForSelectablePosition);
            setNextSelectedPositionInt(lookForSelectablePosition);
            if (this.mItemCount == 0) {
                checkSelectionChanged();
            }
        } else {
            this.mItemCount = 0;
            this.mHasStableIds = false;
            this.mAreAllItemsSelectable = true;
            checkSelectionChanged();
        }
        checkFocus();
        requestLayout();
    }

    @Override // android.widget.AdapterView
    public int getFirstVisiblePosition() {
        return this.mFirstPosition;
    }

    @Override // android.widget.AdapterView
    public int getLastVisiblePosition() {
        return (this.mFirstPosition + getChildCount()) - 1;
    }

    @Override // android.widget.AdapterView
    public int getCount() {
        return this.mItemCount;
    }

    @Override // android.widget.AdapterView
    public int getPositionForView(View view) {
        while (true) {
            try {
                View view2 = (View) view.getParent();
                if (view2.equals(this)) {
                    break;
                }
                view = view2;
            } catch (ClassCastException unused) {
                return -1;
            }
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (getChildAt(i).equals(view)) {
                return this.mFirstPosition + i;
            }
        }
        return -1;
    }

    @Override // android.view.View
    public void getFocusedRect(Rect rect) {
        View selectedView = getSelectedView();
        if (selectedView != null && selectedView.getParent() == this) {
            selectedView.getFocusedRect(rect);
            offsetDescendantRectToMyCoords(selectedView, rect);
            return;
        }
        super.getFocusedRect(rect);
    }

    @Override // android.view.View
    protected void onFocusChanged(boolean z, int i, Rect rect) {
        ListAdapter listAdapter;
        super.onFocusChanged(z, i, rect);
        if (z && this.mSelectedPosition < 0 && !isInTouchMode()) {
            if (!this.mIsAttached && (listAdapter = this.mAdapter) != null) {
                this.mDataChanged = true;
                this.mOldItemCount = this.mItemCount;
                this.mItemCount = listAdapter.getCount();
            }
            resurrectSelection();
        }
        ListAdapter listAdapter2 = this.mAdapter;
        int i2 = -1;
        int i3 = 0;
        if (listAdapter2 != null && z && rect != null) {
            rect.offset(getScrollX(), getScrollY());
            if (listAdapter2.getCount() < getChildCount() + this.mFirstPosition) {
                this.mLayoutMode = 0;
                layoutChildren();
            }
            Rect rect2 = this.mTempRect;
            int childCount = getChildCount();
            int i4 = this.mFirstPosition;
            int i5 = 0;
            int i6 = MoPubNativeAdPositioning.MoPubClientPositioning.NO_REPEAT;
            while (i3 < childCount) {
                if (listAdapter2.isEnabled(i4 + i3)) {
                    View childAt = getChildAt(i3);
                    childAt.getDrawingRect(rect2);
                    offsetDescendantRectToMyCoords(childAt, rect2);
                    int distance = getDistance(rect, rect2, i);
                    if (distance < i6) {
                        i5 = getChildStartEdge(childAt);
                        i2 = i3;
                        i6 = distance;
                    }
                }
                i3++;
            }
            i3 = i5;
        }
        if (i2 >= 0) {
            setSelectionFromOffset(i2 + this.mFirstPosition, i3);
        } else {
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnTouchModeChangeListener(this);
        if (this.mAdapter != null && this.mDataSetObserver == null) {
            this.mDataSetObserver = new AdapterDataSetObserver();
            this.mAdapter.registerDataSetObserver(this.mDataSetObserver);
            this.mDataChanged = true;
            this.mOldItemCount = this.mItemCount;
            this.mItemCount = this.mAdapter.getCount();
        }
        this.mIsAttached = true;
    }

    @Override // android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mRecycler.clear();
        getViewTreeObserver().removeOnTouchModeChangeListener(this);
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter != null) {
            listAdapter.unregisterDataSetObserver(this.mDataSetObserver);
            this.mDataSetObserver = null;
        }
        PerformClick performClick = this.mPerformClick;
        if (performClick != null) {
            removeCallbacks(performClick);
        }
        Runnable runnable = this.mTouchModeReset;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.mTouchModeReset.run();
        }
        finishSmoothScrolling();
        this.mIsAttached = false;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        int i = !isInTouchMode();
        if (!z) {
            if (!this.mScroller.isFinished()) {
                finishSmoothScrolling();
                if (this.mOverScroll != 0) {
                    this.mOverScroll = 0;
                    finishEdgeGlows();
                    invalidate();
                }
            }
            if (i == 1) {
                this.mResurrectToPosition = this.mSelectedPosition;
            }
        } else {
            int i2 = this.mLastTouchMode;
            if (i != i2 && i2 != -1) {
                if (i == 1) {
                    resurrectSelection();
                } else {
                    hideSelector();
                    this.mLayoutMode = 0;
                    layoutChildren();
                }
            }
        }
        this.mLastTouchMode = i;
    }

    @Override // android.view.View
    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        boolean z3 = true;
        if (this.mIsVertical && this.mOverScroll != i2) {
            onScrollChanged(getScrollX(), i2, getScrollX(), this.mOverScroll);
            this.mOverScroll = i2;
        } else if (this.mIsVertical || this.mOverScroll == i) {
            z3 = false;
        } else {
            onScrollChanged(i, getScrollY(), this.mOverScroll, getScrollY());
            this.mOverScroll = i;
        }
        if (z3) {
            invalidate();
            awakenScrollbarsInternal();
        }
    }

    @TargetApi(9)
    private boolean overScrollByInternal(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        if (Build.VERSION.SDK_INT < 9) {
            return false;
        }
        return super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
    }

    @Override // android.view.View
    @TargetApi(9)
    public void setOverScrollMode(int i) {
        if (Build.VERSION.SDK_INT < 9) {
            return;
        }
        if (i != 2) {
            if (this.mStartEdge == null) {
                Context context = getContext();
                this.mStartEdge = new EdgeEffectCompat(context);
                this.mEndEdge = new EdgeEffectCompat(context);
            }
        } else {
            this.mStartEdge = null;
            this.mEndEdge = null;
        }
        super.setOverScrollMode(i);
    }

    public int pointToPosition(int i, int i2) {
        Rect rect = this.mTouchFrame;
        if (rect == null) {
            this.mTouchFrame = new Rect();
            rect = this.mTouchFrame;
        }
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() == 0) {
                childAt.getHitRect(rect);
                if (rect.contains(i, i2)) {
                    return this.mFirstPosition + childCount;
                }
            }
        }
        return -1;
    }

    @Override // android.view.View
    protected float getTopFadingEdgeStrength() {
        if (this.mIsVertical) {
            float topFadingEdgeStrength = super.getTopFadingEdgeStrength();
            if (getChildCount() == 0) {
                return topFadingEdgeStrength;
            }
            if (this.mFirstPosition > 0) {
                return 1.0f;
            }
            int top = getChildAt(0).getTop();
            int paddingTop = getPaddingTop();
            return top < paddingTop ? (-(top - paddingTop)) / getVerticalFadingEdgeLength() : topFadingEdgeStrength;
        }
        return ColumnText.GLOBAL_SPACE_CHAR_RATIO;
    }

    @Override // android.view.View
    protected float getBottomFadingEdgeStrength() {
        if (this.mIsVertical) {
            float bottomFadingEdgeStrength = super.getBottomFadingEdgeStrength();
            int childCount = getChildCount();
            if (childCount == 0) {
                return bottomFadingEdgeStrength;
            }
            if ((this.mFirstPosition + childCount) - 1 < this.mItemCount - 1) {
                return 1.0f;
            }
            int bottom = getChildAt(childCount - 1).getBottom();
            int paddingBottom = getPaddingBottom();
            int height = getHeight();
            return bottom > height - paddingBottom ? ((bottom - height) + paddingBottom) / getVerticalFadingEdgeLength() : bottomFadingEdgeStrength;
        }
        return ColumnText.GLOBAL_SPACE_CHAR_RATIO;
    }

    @Override // android.view.View
    protected float getLeftFadingEdgeStrength() {
        if (this.mIsVertical) {
            return ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        }
        float leftFadingEdgeStrength = super.getLeftFadingEdgeStrength();
        if (getChildCount() == 0) {
            return leftFadingEdgeStrength;
        }
        if (this.mFirstPosition > 0) {
            return 1.0f;
        }
        int left = getChildAt(0).getLeft();
        int paddingLeft = getPaddingLeft();
        return left < paddingLeft ? (-(left - paddingLeft)) / getHorizontalFadingEdgeLength() : leftFadingEdgeStrength;
    }

    @Override // android.view.View
    protected float getRightFadingEdgeStrength() {
        if (this.mIsVertical) {
            return ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        }
        float rightFadingEdgeStrength = super.getRightFadingEdgeStrength();
        int childCount = getChildCount();
        if (childCount == 0) {
            return rightFadingEdgeStrength;
        }
        if ((this.mFirstPosition + childCount) - 1 < this.mItemCount - 1) {
            return 1.0f;
        }
        int right = getChildAt(childCount - 1).getRight();
        int paddingRight = getPaddingRight();
        int width = getWidth();
        return right > width - paddingRight ? ((right - width) + paddingRight) / getHorizontalFadingEdgeLength() : rightFadingEdgeStrength;
    }

    @Override // android.view.View
    protected int computeVerticalScrollExtent() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return 0;
        }
        int i = childCount * 100;
        View childAt = getChildAt(0);
        int top = childAt.getTop();
        int height = childAt.getHeight();
        if (height > 0) {
            i += (top * 100) / height;
        }
        View childAt2 = getChildAt(childCount - 1);
        int bottom = childAt2.getBottom();
        int height2 = childAt2.getHeight();
        return height2 > 0 ? i - (((bottom - getHeight()) * 100) / height2) : i;
    }

    @Override // android.view.View
    protected int computeHorizontalScrollExtent() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return 0;
        }
        int i = childCount * 100;
        View childAt = getChildAt(0);
        int left = childAt.getLeft();
        int width = childAt.getWidth();
        if (width > 0) {
            i += (left * 100) / width;
        }
        View childAt2 = getChildAt(childCount - 1);
        int right = childAt2.getRight();
        int width2 = childAt2.getWidth();
        return width2 > 0 ? i - (((right - getWidth()) * 100) / width2) : i;
    }

    @Override // android.view.View
    protected int computeVerticalScrollOffset() {
        int i = this.mFirstPosition;
        int childCount = getChildCount();
        if (i < 0 || childCount == 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        int top = childAt.getTop();
        int height = childAt.getHeight();
        if (height > 0) {
            return Math.max((i * 100) - ((top * 100) / height), 0);
        }
        return 0;
    }

    @Override // android.view.View
    protected int computeHorizontalScrollOffset() {
        int i = this.mFirstPosition;
        int childCount = getChildCount();
        if (i < 0 || childCount == 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        int left = childAt.getLeft();
        int width = childAt.getWidth();
        if (width > 0) {
            return Math.max((i * 100) - ((left * 100) / width), 0);
        }
        return 0;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        int i;
        int max = Math.max(this.mItemCount * 100, 0);
        return (!this.mIsVertical || (i = this.mOverScroll) == 0) ? max : max + Math.abs((int) ((i / getHeight()) * this.mItemCount * 100.0f));
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        int i;
        int max = Math.max(this.mItemCount * 100, 0);
        return (this.mIsVertical || (i = this.mOverScroll) == 0) ? max : max + Math.abs((int) ((i / getWidth()) * this.mItemCount * 100.0f));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean showContextMenuForChild(View view) {
        int positionForView = getPositionForView(view);
        if (positionForView >= 0) {
            long itemId = this.mAdapter.getItemId(positionForView);
            AdapterView.OnItemLongClickListener onItemLongClickListener = getOnItemLongClickListener();
            boolean onItemLongClick = onItemLongClickListener != null ? onItemLongClickListener.onItemLongClick(this, view, positionForView, itemId) : false;
            if (onItemLongClick) {
                return onItemLongClick;
            }
            this.mContextMenuInfo = createContextMenuInfo(getChildAt(positionForView - this.mFirstPosition), positionForView, itemId);
            return super.showContextMenuForChild(view);
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            recycleVelocityTracker();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float m14410c;
        if (!this.mIsAttached || this.mAdapter == null) {
            return false;
        }
        switch (motionEvent.getAction() & 255) {
            case 0:
                initOrResetVelocityTracker();
                this.mVelocityTracker.addMovement(motionEvent);
                this.mScroller.abortAnimation();
                PositionScroller positionScroller = this.mPositionScroller;
                if (positionScroller != null) {
                    positionScroller.stop();
                }
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (this.mIsVertical) {
                    x = y;
                }
                this.mLastTouchPos = x;
                int findMotionRowOrColumn = findMotionRowOrColumn((int) this.mLastTouchPos);
                this.mActivePointerId = MotionEventCompat.m14411b(motionEvent, 0);
                this.mTouchRemainderPos = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
                if (this.mTouchMode != 4) {
                    if (findMotionRowOrColumn >= 0) {
                        this.mMotionPosition = findMotionRowOrColumn;
                        this.mTouchMode = 0;
                        break;
                    }
                } else {
                    return true;
                }
                break;
            case 1:
            case 3:
                this.mActivePointerId = -1;
                this.mTouchMode = -1;
                recycleVelocityTracker();
                reportScrollStateChange(0);
                break;
            case 2:
                if (this.mTouchMode == 0) {
                    initVelocityTrackerIfNotExists();
                    this.mVelocityTracker.addMovement(motionEvent);
                    int m14413a = MotionEventCompat.m14413a(motionEvent, this.mActivePointerId);
                    if (m14413a < 0) {
                        Log.e(LOGTAG, "onInterceptTouchEvent could not find pointer with id " + this.mActivePointerId + " - did TwoWayView receive an inconsistent event stream?");
                        return false;
                    }
                    if (this.mIsVertical) {
                        m14410c = MotionEventCompat.m14409d(motionEvent, m14413a);
                    } else {
                        m14410c = MotionEventCompat.m14410c(motionEvent, m14413a);
                    }
                    float f = (m14410c - this.mLastTouchPos) + this.mTouchRemainderPos;
                    int i = (int) f;
                    this.mTouchRemainderPos = f - i;
                    if (maybeStartScrolling(i)) {
                        return true;
                    }
                }
                break;
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        Drawable current;
        float m14666a;
        float m14410c;
        boolean z3 = false;
        if (!isEnabled()) {
            return isClickable() || isLongClickable();
        } else if (!this.mIsAttached || this.mAdapter == null) {
            return false;
        } else {
            initVelocityTrackerIfNotExists();
            this.mVelocityTracker.addMovement(motionEvent);
            switch (motionEvent.getAction() & 255) {
                case 0:
                    if (!this.mDataChanged) {
                        this.mVelocityTracker.clear();
                        this.mScroller.abortAnimation();
                        PositionScroller positionScroller = this.mPositionScroller;
                        if (positionScroller != null) {
                            positionScroller.stop();
                        }
                        float x = motionEvent.getX();
                        float y = motionEvent.getY();
                        this.mLastTouchPos = this.mIsVertical ? y : x;
                        int pointToPosition = pointToPosition((int) x, (int) y);
                        this.mActivePointerId = MotionEventCompat.m14411b(motionEvent, 0);
                        this.mTouchRemainderPos = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
                        if (!this.mDataChanged) {
                            if (this.mTouchMode == 4) {
                                this.mTouchMode = 3;
                                reportScrollStateChange(1);
                                pointToPosition = findMotionRowOrColumn((int) this.mLastTouchPos);
                            } else {
                                int i = this.mMotionPosition;
                                if (i >= 0 && this.mAdapter.isEnabled(i)) {
                                    this.mTouchMode = 0;
                                    triggerCheckForTap();
                                }
                            }
                            this.mMotionPosition = pointToPosition;
                            break;
                        }
                    }
                    break;
                case 1:
                    int i2 = this.mTouchMode;
                    if (i2 != 5) {
                        switch (i2) {
                            case 0:
                            case 1:
                            case 2:
                                int i3 = this.mMotionPosition;
                                final View childAt = getChildAt(i3 - this.mFirstPosition);
                                float x2 = motionEvent.getX();
                                float y2 = motionEvent.getY();
                                if (this.mIsVertical) {
                                    z2 = x2 > ((float) getPaddingLeft()) && x2 < ((float) (getWidth() - getPaddingRight()));
                                } else {
                                    z2 = y2 > ((float) getPaddingTop()) && y2 < ((float) (getHeight() - getPaddingBottom()));
                                }
                                if (childAt != null && !childAt.hasFocusable() && z2) {
                                    if (this.mTouchMode != 0) {
                                        childAt.setPressed(false);
                                    }
                                    if (this.mPerformClick == null) {
                                        this.mPerformClick = new PerformClick();
                                    }
                                    final PerformClick performClick = this.mPerformClick;
                                    performClick.mClickMotionPosition = i3;
                                    performClick.rememberWindowAttachCount();
                                    this.mResurrectToPosition = i3;
                                    int i4 = this.mTouchMode;
                                    if (i4 == 0 || i4 == 1) {
                                        if (this.mTouchMode == 0) {
                                            cancelCheckForTap();
                                        } else {
                                            cancelCheckForLongPress();
                                        }
                                        this.mLayoutMode = 0;
                                        if (!this.mDataChanged && this.mAdapter.isEnabled(i3)) {
                                            this.mTouchMode = 1;
                                            setPressed(true);
                                            positionSelector(this.mMotionPosition, childAt);
                                            childAt.setPressed(true);
                                            Drawable drawable = this.mSelector;
                                            if (drawable != null && (current = drawable.getCurrent()) != null && (current instanceof TransitionDrawable)) {
                                                ((TransitionDrawable) current).resetTransition();
                                            }
                                            Runnable runnable = this.mTouchModeReset;
                                            if (runnable != null) {
                                                removeCallbacks(runnable);
                                            }
                                            this.mTouchModeReset = new Runnable() { // from class: com.artifex.mupdflib.TwoWayView.1
                                                @Override // java.lang.Runnable
                                                public void run() {
                                                    TwoWayView.this.mTouchMode = -1;
                                                    TwoWayView.this.setPressed(false);
                                                    childAt.setPressed(false);
                                                    if (!TwoWayView.this.mDataChanged) {
                                                        performClick.run();
                                                    }
                                                    TwoWayView.this.mTouchModeReset = null;
                                                }
                                            };
                                            postDelayed(this.mTouchModeReset, ViewConfiguration.getPressedStateDuration());
                                        } else {
                                            this.mTouchMode = -1;
                                            updateSelectorState();
                                        }
                                    } else if (!this.mDataChanged && this.mAdapter.isEnabled(i3)) {
                                        performClick.run();
                                    }
                                }
                                this.mTouchMode = -1;
                                finishSmoothScrolling();
                                updateSelectorState();
                                z = false;
                                break;
                            case 3:
                                if (!contentFits()) {
                                    this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                                    if (this.mIsVertical) {
                                        m14666a = VelocityTrackerCompat.m14665b(this.mVelocityTracker, this.mActivePointerId);
                                    } else {
                                        m14666a = VelocityTrackerCompat.m14666a(this.mVelocityTracker, this.mActivePointerId);
                                    }
                                    if (Math.abs(m14666a) >= this.mFlingVelocity) {
                                        this.mTouchMode = 4;
                                        reportScrollStateChange(2);
                                        Scroller scroller = this.mScroller;
                                        int i5 = (int) (this.mIsVertical ? ColumnText.GLOBAL_SPACE_CHAR_RATIO : m14666a);
                                        if (!this.mIsVertical) {
                                            m14666a = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
                                        }
                                        scroller.fling(0, 0, i5, (int) m14666a, this.mIsVertical ? 0 : NTLMConstants.FLAG_NEGOTIATE_56_BIT_ENCRYPTION, this.mIsVertical ? 0 : MoPubNativeAdPositioning.MoPubClientPositioning.NO_REPEAT, this.mIsVertical ? NTLMConstants.FLAG_NEGOTIATE_56_BIT_ENCRYPTION : 0, this.mIsVertical ? MoPubNativeAdPositioning.MoPubClientPositioning.NO_REPEAT : 0);
                                        this.mLastTouchPos = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
                                        z = true;
                                        break;
                                    } else {
                                        this.mTouchMode = -1;
                                        reportScrollStateChange(0);
                                        z = false;
                                        break;
                                    }
                                }
                                break;
                            default:
                                z = false;
                                break;
                        }
                        cancelCheckForTap();
                        cancelCheckForLongPress();
                        setPressed(false);
                        EdgeEffectCompat edgeEffectCompat = this.mStartEdge;
                        z3 = (edgeEffectCompat != null || this.mEndEdge == null) ? z : z | edgeEffectCompat.m14254c() | this.mEndEdge.m14254c();
                        recycleVelocityTracker();
                        break;
                    }
                    this.mTouchMode = -1;
                    reportScrollStateChange(0);
                    z = false;
                    cancelCheckForTap();
                    cancelCheckForLongPress();
                    setPressed(false);
                    EdgeEffectCompat edgeEffectCompat2 = this.mStartEdge;
                    if (edgeEffectCompat2 != null) {
                    }
                    recycleVelocityTracker();
                    break;
                case 2:
                    int m14413a = MotionEventCompat.m14413a(motionEvent, this.mActivePointerId);
                    if (m14413a < 0) {
                        Log.e(LOGTAG, "onInterceptTouchEvent could not find pointer with id " + this.mActivePointerId + " - did TwoWayView receive an inconsistent event stream?");
                        return false;
                    }
                    if (this.mIsVertical) {
                        m14410c = MotionEventCompat.m14409d(motionEvent, m14413a);
                    } else {
                        m14410c = MotionEventCompat.m14410c(motionEvent, m14413a);
                    }
                    if (this.mDataChanged) {
                        layoutChildren();
                    }
                    float f = (m14410c - this.mLastTouchPos) + this.mTouchRemainderPos;
                    int i6 = (int) f;
                    this.mTouchRemainderPos = f - i6;
                    int i7 = this.mTouchMode;
                    if (i7 != 5) {
                        switch (i7) {
                            case 0:
                            case 1:
                            case 2:
                                maybeStartScrolling(i6);
                                break;
                        }
                    }
                    this.mLastTouchPos = m14410c;
                    maybeScroll(i6);
                    break;
                    break;
                case 3:
                    cancelCheckForTap();
                    this.mTouchMode = -1;
                    reportScrollStateChange(0);
                    setPressed(false);
                    View childAt2 = getChildAt(this.mMotionPosition - this.mFirstPosition);
                    if (childAt2 != null) {
                        childAt2.setPressed(false);
                    }
                    EdgeEffectCompat edgeEffectCompat3 = this.mStartEdge;
                    if (edgeEffectCompat3 != null && this.mEndEdge != null) {
                        z3 = edgeEffectCompat3.m14254c() | this.mEndEdge.m14254c();
                    }
                    recycleVelocityTracker();
                    break;
            }
            if (z3) {
                ViewCompat.m14626e(this);
            }
            return true;
        }
    }

    @Override // android.view.ViewTreeObserver.OnTouchModeChangeListener
    public void onTouchModeChanged(boolean z) {
        if (z) {
            hideSelector();
            if (getWidth() > 0 && getHeight() > 0 && getChildCount() > 0) {
                layoutChildren();
            }
            updateSelectorState();
        } else if (this.mTouchMode == 5) {
            finishSmoothScrolling();
            if (this.mOverScroll != 0) {
                this.mOverScroll = 0;
                finishEdgeGlows();
                invalidate();
            }
        }
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return handleKeyEvent(i, 1, keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        return handleKeyEvent(i, i2, keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return handleKeyEvent(i, 1, keyEvent);
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEvent(int i) {
        if (i == 4096) {
            int firstVisiblePosition = getFirstVisiblePosition();
            int lastVisiblePosition = getLastVisiblePosition();
            if (this.mLastAccessibilityScrollEventFromIndex == firstVisiblePosition && this.mLastAccessibilityScrollEventToIndex == lastVisiblePosition) {
                return;
            }
            this.mLastAccessibilityScrollEventFromIndex = firstVisiblePosition;
            this.mLastAccessibilityScrollEventToIndex = lastVisiblePosition;
        }
        super.sendAccessibilityEvent(i);
    }

    @Override // android.view.View
    @TargetApi(14)
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(TwoWayView.class.getName());
    }

    @Override // android.view.View
    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(TwoWayView.class.getName());
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = new AccessibilityNodeInfoCompat(accessibilityNodeInfo);
        if (isEnabled()) {
            if (getFirstVisiblePosition() > 0) {
                accessibilityNodeInfoCompat.m14713a(8192);
            }
            if (getLastVisiblePosition() < getCount() - 1) {
                accessibilityNodeInfoCompat.m14713a(4096);
            }
        }
    }

    @Override // android.view.View
    @TargetApi(16)
    public boolean performAccessibilityAction(int i, Bundle bundle) {
        if (super.performAccessibilityAction(i, bundle)) {
            return true;
        }
        if (i == 4096) {
            if (!isEnabled() || getLastVisiblePosition() >= getCount() - 1) {
                return false;
            }
            scrollListItemsBy(getAvailableSize());
            return true;
        } else if (i == 8192 && isEnabled() && this.mFirstPosition > 0) {
            scrollListItemsBy(-getAvailableSize());
            return true;
        } else {
            return false;
        }
    }

    private boolean isViewAncestorOf(View view, View view2) {
        if (view == view2) {
            return true;
        }
        ViewParent parent = view.getParent();
        return (parent instanceof ViewGroup) && isViewAncestorOf((View) parent, view2);
    }

    private void forceValidFocusDirection(int i) {
        if (this.mIsVertical && i != 33 && i != 130) {
            throw new IllegalArgumentException("Focus direction must be one of {View.FOCUS_UP, View.FOCUS_DOWN} for vertical orientation");
        }
        if (!this.mIsVertical && i != 17 && i != 66) {
            throw new IllegalArgumentException("Focus direction must be one of {View.FOCUS_LEFT, View.FOCUS_RIGHT} for vertical orientation");
        }
    }

    private void forceValidInnerFocusDirection(int i) {
        if (this.mIsVertical && i != 17 && i != 66) {
            throw new IllegalArgumentException("Direction must be one of {View.FOCUS_LEFT, View.FOCUS_RIGHT} for vertical orientation");
        }
        if (!this.mIsVertical && i != 33 && i != 130) {
            throw new IllegalArgumentException("direction must be one of {View.FOCUS_UP, View.FOCUS_DOWN} for horizontal orientation");
        }
    }

    boolean pageScroll(int i) {
        int max;
        boolean z;
        int lookForSelectablePosition;
        forceValidFocusDirection(i);
        if (i == 33 || i == 17) {
            max = Math.max(0, (this.mSelectedPosition - getChildCount()) - 1);
            z = false;
        } else if (i == 130 || i == 66) {
            max = Math.min(this.mItemCount - 1, (this.mSelectedPosition + getChildCount()) - 1);
            z = true;
        } else {
            max = -1;
            z = false;
        }
        if (max >= 0 && (lookForSelectablePosition = lookForSelectablePosition(max, z)) >= 0) {
            this.mLayoutMode = 4;
            this.mSpecificStart = getStartEdge() + getFadingEdgeLength();
            if (z && lookForSelectablePosition > this.mItemCount - getChildCount()) {
                this.mLayoutMode = 3;
            }
            if (!z && lookForSelectablePosition < getChildCount()) {
                this.mLayoutMode = 1;
            }
            setSelectionInt(lookForSelectablePosition);
            invokeOnItemScrollListener();
            if (!awakenScrollbarsInternal()) {
                invalidate();
            }
            return true;
        }
        return false;
    }

    boolean fullScroll(int i) {
        forceValidFocusDirection(i);
        boolean z = true;
        if (i == 33 || i == 17) {
            if (this.mSelectedPosition != 0) {
                int lookForSelectablePosition = lookForSelectablePosition(0, true);
                if (lookForSelectablePosition >= 0) {
                    this.mLayoutMode = 1;
                    setSelectionInt(lookForSelectablePosition);
                    invokeOnItemScrollListener();
                }
            }
            z = false;
        } else {
            if (i == 130 || i == 66) {
                int i2 = this.mSelectedPosition;
                int i3 = this.mItemCount;
                if (i2 < i3 - 1) {
                    int lookForSelectablePosition2 = lookForSelectablePosition(i3 - 1, true);
                    if (lookForSelectablePosition2 >= 0) {
                        this.mLayoutMode = 3;
                        setSelectionInt(lookForSelectablePosition2);
                        invokeOnItemScrollListener();
                    }
                }
            }
            z = false;
        }
        if (z && !awakenScrollbarsInternal()) {
            awakenScrollbarsInternal();
            invalidate();
        }
        return z;
    }

    private boolean handleFocusWithinItem(int i) {
        View selectedView;
        forceValidInnerFocusDirection(i);
        int childCount = getChildCount();
        if (!this.mItemsCanFocus || childCount <= 0 || this.mSelectedPosition == -1 || (selectedView = getSelectedView()) == null || !selectedView.hasFocus() || !(selectedView instanceof ViewGroup)) {
            return false;
        }
        View findFocus = selectedView.findFocus();
        View findNextFocus = FocusFinder.getInstance().findNextFocus((ViewGroup) selectedView, findFocus, i);
        if (findNextFocus != null) {
            findFocus.getFocusedRect(this.mTempRect);
            offsetDescendantRectToMyCoords(findFocus, this.mTempRect);
            offsetRectIntoDescendantCoords(findNextFocus, this.mTempRect);
            if (findNextFocus.requestFocus(i, this.mTempRect)) {
                return true;
            }
        }
        View findNextFocus2 = FocusFinder.getInstance().findNextFocus((ViewGroup) getRootView(), findFocus, i);
        if (findNextFocus2 != null) {
            return isViewAncestorOf(findNextFocus2, this);
        }
        return false;
    }

    private boolean arrowScroll(int i) {
        forceValidFocusDirection(i);
        try {
            this.mInLayout = true;
            boolean arrowScrollImpl = arrowScrollImpl(i);
            if (arrowScrollImpl) {
                playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
            }
            return arrowScrollImpl;
        } finally {
            this.mInLayout = false;
        }
    }

    private void handleNewSelectionChange(View view, int i, int i2, boolean z) {
        int i3;
        View view2;
        boolean z2;
        forceValidFocusDirection(i);
        if (i2 == -1) {
            throw new IllegalArgumentException("newSelectedPosition needs to be valid");
        }
        int i4 = this.mSelectedPosition;
        int i5 = this.mFirstPosition;
        int i6 = i4 - i5;
        int i7 = i2 - i5;
        boolean z3 = true;
        if (i == 33 || i == 17) {
            View childAt = getChildAt(i7);
            i3 = i6;
            i6 = i7;
            view2 = view;
            view = childAt;
            z2 = true;
        } else {
            i3 = i7;
            view2 = getChildAt(i7);
            z2 = false;
        }
        int childCount = getChildCount();
        if (view != null) {
            view.setSelected(!z && z2);
            measureAndAdjustDown(view, i6, childCount);
        }
        if (view2 != null) {
            view2.setSelected((z || z2) ? false : false);
            measureAndAdjustDown(view2, i3, childCount);
        }
    }

    private void measureAndAdjustDown(View view, int i, int i2) {
        int childSize = getChildSize(view);
        measureChild(view);
        if (getChildMeasuredSize(view) == childSize) {
            return;
        }
        relayoutMeasuredChild(view);
        int childMeasuredSize = getChildMeasuredSize(view) - childSize;
        while (true) {
            i++;
            if (i >= i2) {
                return;
            }
            getChildAt(i).offsetTopAndBottom(childMeasuredSize);
        }
    }

    private ArrowScrollFocusResult arrowScrollFocused(int i) {
        int max;
        View findNextFocusFromRect;
        forceValidFocusDirection(i);
        View selectedView = getSelectedView();
        boolean z = true;
        if (selectedView != null && selectedView.hasFocus()) {
            findNextFocusFromRect = FocusFinder.getInstance().findNextFocus(this, selectedView.findFocus(), i);
        } else {
            if (i == 130 || i == 66) {
                int startEdge = getStartEdge() + (this.mFirstPosition > 0 ? getArrowScrollPreviewLength() : 0);
                max = Math.max(selectedView != null ? getChildStartEdge(selectedView) : startEdge, startEdge);
            } else {
                int endEdge = getEndEdge() - ((this.mFirstPosition + getChildCount()) - 1 < this.mItemCount ? getArrowScrollPreviewLength() : 0);
                max = Math.min(selectedView != null ? getChildEndEdge(selectedView) : endEdge, endEdge);
            }
            int i2 = this.mIsVertical ? 0 : max;
            if (!this.mIsVertical) {
                max = 0;
            }
            this.mTempRect.set(i2, max, i2, max);
            findNextFocusFromRect = FocusFinder.getInstance().findNextFocusFromRect(this, this.mTempRect, i);
        }
        if (findNextFocusFromRect != null) {
            int positionOfNewFocus = positionOfNewFocus(findNextFocusFromRect);
            int i3 = this.mSelectedPosition;
            if (i3 != -1 && positionOfNewFocus != i3) {
                int lookForSelectablePositionOnScreen = lookForSelectablePositionOnScreen(i);
                boolean z2 = i == 130 || i == 66;
                if (i != 33 && i != 17) {
                    z = false;
                }
                if (lookForSelectablePositionOnScreen != -1 && ((z2 && lookForSelectablePositionOnScreen < positionOfNewFocus) || (z && lookForSelectablePositionOnScreen > positionOfNewFocus))) {
                    return null;
                }
            }
            int amountToScrollToNewFocus = amountToScrollToNewFocus(i, findNextFocusFromRect, positionOfNewFocus);
            int maxScrollAmount = getMaxScrollAmount();
            if (amountToScrollToNewFocus < maxScrollAmount) {
                findNextFocusFromRect.requestFocus(i);
                this.mArrowScrollFocusResult.populate(positionOfNewFocus, amountToScrollToNewFocus);
                return this.mArrowScrollFocusResult;
            } else if (distanceToView(findNextFocusFromRect) < maxScrollAmount) {
                findNextFocusFromRect.requestFocus(i);
                this.mArrowScrollFocusResult.populate(positionOfNewFocus, maxScrollAmount);
                return this.mArrowScrollFocusResult;
            }
        }
        return null;
    }

    public int getMaxScrollAmount() {
        return (int) (getSize() * MAX_SCROLL_FACTOR);
    }

    private int getArrowScrollPreviewLength() {
        return this.mItemMargin + Math.max(10, getFadingEdgeLength());
    }

    private int positionOfNewFocus(View view) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (isViewAncestorOf(view, getChildAt(i))) {
                return this.mFirstPosition + i;
            }
        }
        throw new IllegalArgumentException("newFocus is not a child of any of the children of the list!");
    }

    private boolean arrowScrollImpl(int i) {
        View focusedChild;
        forceValidFocusDirection(i);
        if (getChildCount() <= 0) {
            return false;
        }
        View selectedView = getSelectedView();
        int i2 = this.mSelectedPosition;
        int lookForSelectablePositionOnScreen = lookForSelectablePositionOnScreen(i);
        int amountToScroll = amountToScroll(i, lookForSelectablePositionOnScreen);
        ArrowScrollFocusResult arrowScrollFocused = this.mItemsCanFocus ? arrowScrollFocused(i) : null;
        if (arrowScrollFocused != null) {
            lookForSelectablePositionOnScreen = arrowScrollFocused.getSelectedPosition();
            amountToScroll = arrowScrollFocused.getAmountToScroll();
        }
        boolean z = arrowScrollFocused != null;
        if (lookForSelectablePositionOnScreen != -1) {
            handleNewSelectionChange(selectedView, i, lookForSelectablePositionOnScreen, arrowScrollFocused != null);
            setSelectedPositionInt(lookForSelectablePositionOnScreen);
            setNextSelectedPositionInt(lookForSelectablePositionOnScreen);
            selectedView = getSelectedView();
            if (this.mItemsCanFocus && arrowScrollFocused == null && (focusedChild = getFocusedChild()) != null) {
                focusedChild.clearFocus();
            }
            checkSelectionChanged();
            i2 = lookForSelectablePositionOnScreen;
            z = true;
        }
        if (amountToScroll > 0) {
            if (i != 33 && i != 17) {
                amountToScroll = -amountToScroll;
            }
            scrollListItemsBy(amountToScroll);
            z = true;
        }
        if (this.mItemsCanFocus && arrowScrollFocused == null && selectedView != null && selectedView.hasFocus()) {
            View findFocus = selectedView.findFocus();
            if (!isViewAncestorOf(findFocus, this) || distanceToView(findFocus) > 0) {
                findFocus.clearFocus();
            }
        }
        if (lookForSelectablePositionOnScreen == -1 && selectedView != null && !isViewAncestorOf(selectedView, this)) {
            hideSelector();
            this.mResurrectToPosition = -1;
            selectedView = null;
        }
        if (z) {
            if (selectedView != null) {
                positionSelector(i2, selectedView);
                this.mSelectedStart = getChildStartEdge(selectedView);
            }
            if (!awakenScrollbarsInternal()) {
                invalidate();
            }
            invokeOnItemScrollListener();
            return true;
        }
        return false;
    }

    private int amountToScroll(int i, int i2) {
        forceValidFocusDirection(i);
        int childCount = getChildCount();
        if (i == 130 || i == 66) {
            int endEdge = getEndEdge();
            int i3 = childCount - 1;
            int i4 = i2 != -1 ? i2 - this.mFirstPosition : i3;
            int i5 = this.mFirstPosition + i4;
            View childAt = getChildAt(i4);
            int arrowScrollPreviewLength = i5 < this.mItemCount + (-1) ? endEdge - getArrowScrollPreviewLength() : endEdge;
            int childStartEdge = getChildStartEdge(childAt);
            int childEndEdge = getChildEndEdge(childAt);
            if (childEndEdge <= arrowScrollPreviewLength) {
                return 0;
            }
            if (i2 == -1 || arrowScrollPreviewLength - childStartEdge < getMaxScrollAmount()) {
                int i6 = childEndEdge - arrowScrollPreviewLength;
                if (this.mFirstPosition + childCount == this.mItemCount) {
                    i6 = Math.min(i6, getChildEndEdge(getChildAt(i3)) - endEdge);
                }
                return Math.min(i6, getMaxScrollAmount());
            }
            return 0;
        }
        int startEdge = getStartEdge();
        int i7 = i2 != -1 ? i2 - this.mFirstPosition : 0;
        int i8 = this.mFirstPosition + i7;
        View childAt2 = getChildAt(i7);
        int arrowScrollPreviewLength2 = i8 > 0 ? getArrowScrollPreviewLength() + startEdge : startEdge;
        int childStartEdge2 = getChildStartEdge(childAt2);
        int childEndEdge2 = getChildEndEdge(childAt2);
        if (childStartEdge2 >= arrowScrollPreviewLength2) {
            return 0;
        }
        if (i2 == -1 || childEndEdge2 - arrowScrollPreviewLength2 < getMaxScrollAmount()) {
            int i9 = arrowScrollPreviewLength2 - childStartEdge2;
            if (this.mFirstPosition == 0) {
                i9 = Math.min(i9, startEdge - getChildStartEdge(getChildAt(0)));
            }
            return Math.min(i9, getMaxScrollAmount());
        }
        return 0;
    }

    private int amountToScrollToNewFocus(int i, View view, int i2) {
        forceValidFocusDirection(i);
        view.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        if (i == 33 || i == 17) {
            int startEdge = getStartEdge();
            int i3 = this.mIsVertical ? this.mTempRect.top : this.mTempRect.left;
            if (i3 < startEdge) {
                int i4 = startEdge - i3;
                return i2 > 0 ? i4 + getArrowScrollPreviewLength() : i4;
            }
            return 0;
        }
        int endEdge = getEndEdge();
        int i5 = this.mIsVertical ? this.mTempRect.bottom : this.mTempRect.right;
        if (i5 > endEdge) {
            int i6 = i5 - endEdge;
            return i2 < this.mItemCount + (-1) ? i6 + getArrowScrollPreviewLength() : i6;
        }
        return 0;
    }

    private int distanceToView(View view) {
        view.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        int startEdge = getStartEdge();
        int endEdge = getEndEdge();
        int i = this.mIsVertical ? this.mTempRect.top : this.mTempRect.left;
        int i2 = this.mIsVertical ? this.mTempRect.bottom : this.mTempRect.right;
        if (i2 < startEdge) {
            return startEdge - i2;
        }
        if (i > endEdge) {
            return i - endEdge;
        }
        return 0;
    }

    private boolean handleKeyScroll(KeyEvent keyEvent, int i, int i2) {
        if (KeyEventCompat.m14442a(keyEvent)) {
            boolean resurrectSelectionIfNeeded = resurrectSelectionIfNeeded();
            if (resurrectSelectionIfNeeded) {
                return resurrectSelectionIfNeeded;
            }
            boolean z = resurrectSelectionIfNeeded;
            while (true) {
                int i3 = i - 1;
                if (i <= 0 || !arrowScroll(i2)) {
                    return z;
                }
                i = i3;
                z = true;
            }
        } else if (KeyEventCompat.m14441a(keyEvent, 2)) {
            return resurrectSelectionIfNeeded() || fullScroll(i2);
        } else {
            return false;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0193 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0194  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean handleKeyEvent(int r9, int r10, android.view.KeyEvent r11) {
        /*
            Method dump skipped, instructions count: 518
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.artifex.mupdflib.TwoWayView.handleKeyEvent(int, int, android.view.KeyEvent):boolean");
    }

    private void initOrResetVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    private void initVelocityTrackerIfNotExists() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
    }

    private void recycleVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private void invokeOnItemScrollListener() {
        OnScrollListener onScrollListener = this.mOnScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScroll(this, this.mFirstPosition, getChildCount(), this.mItemCount);
        }
        onScrollChanged(0, 0, 0, 0);
    }

    private void reportScrollStateChange(int i) {
        OnScrollListener onScrollListener;
        if (i == this.mLastScrollState || (onScrollListener = this.mOnScrollListener) == null) {
            return;
        }
        this.mLastScrollState = i;
        onScrollListener.onScrollStateChanged(this, i);
    }

    private boolean maybeStartScrolling(int i) {
        boolean z = this.mOverScroll != 0;
        if (Math.abs(i) > this.mTouchSlop || z) {
            if (z) {
                this.mTouchMode = 5;
            } else {
                this.mTouchMode = 3;
            }
            ViewParent parent = getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            cancelCheckForLongPress();
            setPressed(false);
            View childAt = getChildAt(this.mMotionPosition - this.mFirstPosition);
            if (childAt != null) {
                childAt.setPressed(false);
            }
            reportScrollStateChange(1);
            return true;
        }
        return false;
    }

    private void maybeScroll(int i) {
        int i2 = this.mTouchMode;
        if (i2 == 3) {
            handleDragChange(i);
        } else if (i2 == 5) {
            handleOverScrollChange(i);
        }
    }

    private void handleDragChange(int i) {
        int childCount;
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        int i2 = this.mMotionPosition;
        if (i2 >= 0) {
            childCount = i2 - this.mFirstPosition;
        } else {
            childCount = getChildCount() / 2;
        }
        View childAt = getChildAt(childCount);
        int childStartEdge = childAt != null ? getChildStartEdge(childAt) : 0;
        boolean scrollListItemsBy = scrollListItemsBy(i);
        View childAt2 = getChildAt(childCount);
        if (childAt2 != null) {
            int childStartEdge2 = getChildStartEdge(childAt2);
            if (scrollListItemsBy) {
                updateOverScrollState(i, (-i) - (childStartEdge2 - childStartEdge));
            }
        }
    }

    private void updateOverScrollState(int i, int i2) {
        VelocityTracker velocityTracker;
        overScrollByInternal(this.mIsVertical ? 0 : i2, this.mIsVertical ? i2 : 0, this.mIsVertical ? 0 : this.mOverScroll, this.mIsVertical ? this.mOverScroll : 0, 0, 0, this.mIsVertical ? 0 : this.mOverscrollDistance, this.mIsVertical ? this.mOverscrollDistance : 0, true);
        if (Math.abs(this.mOverscrollDistance) == Math.abs(this.mOverScroll) && (velocityTracker = this.mVelocityTracker) != null) {
            velocityTracker.clear();
        }
        int m14652a = ViewCompat.m14652a((View) this);
        if (m14652a == 0 || (m14652a == 1 && !contentFits())) {
            this.mTouchMode = 5;
            float size = i2 / getSize();
            if (i > 0) {
                this.mStartEdge.m14260a(size);
                if (!this.mEndEdge.m14261a()) {
                    this.mEndEdge.m14254c();
                }
            } else if (i < 0) {
                this.mEndEdge.m14260a(size);
                if (!this.mStartEdge.m14261a()) {
                    this.mStartEdge.m14254c();
                }
            }
            if (i != 0) {
                ViewCompat.m14626e(this);
            }
        }
    }

    private void handleOverScrollChange(int i) {
        int i2;
        int i3 = this.mOverScroll;
        int i4 = i3 - i;
        int i5 = -i;
        if ((i4 >= 0 || i3 < 0) && (i4 <= 0 || i3 > 0)) {
            i2 = 0;
        } else {
            i5 = -i3;
            i2 = i + i5;
        }
        if (i5 != 0) {
            updateOverScrollState(i2, i5);
        }
        if (i2 != 0) {
            if (this.mOverScroll != 0) {
                this.mOverScroll = 0;
                ViewCompat.m14626e(this);
            }
            scrollListItemsBy(i2);
            this.mTouchMode = 3;
            this.mMotionPosition = findClosestMotionRowOrColumn((int) this.mLastTouchPos);
            this.mTouchRemainderPos = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        }
    }

    private static int getDistance(Rect rect, Rect rect2, int i) {
        int i2;
        int height;
        int i3;
        int height2;
        if (i == 17) {
            i2 = rect.left;
            height = rect.top + (rect.height() / 2);
            i3 = rect2.right;
            height2 = rect2.top + (rect2.height() / 2);
        } else if (i == 33) {
            i2 = rect.left + (rect.width() / 2);
            height = rect.top;
            i3 = rect2.left + (rect2.width() / 2);
            height2 = rect2.bottom;
        } else if (i == 66) {
            i2 = rect.right;
            height = rect.top + (rect.height() / 2);
            i3 = rect2.left;
            height2 = rect2.top + (rect2.height() / 2);
        } else if (i == 130) {
            i2 = rect.left + (rect.width() / 2);
            height = rect.bottom;
            i3 = rect2.left + (rect2.width() / 2);
            height2 = rect2.top;
        } else {
            switch (i) {
                case 1:
                case 2:
                    i2 = rect.right + (rect.width() / 2);
                    height = rect.top + (rect.height() / 2);
                    i3 = rect2.left + (rect2.width() / 2);
                    height2 = rect2.top + (rect2.height() / 2);
                    break;
                default:
                    throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT, FOCUS_FORWARD, FOCUS_BACKWARD}.");
            }
        }
        int i4 = i3 - i2;
        int i5 = height2 - height;
        return (i5 * i5) + (i4 * i4);
    }

    private int findMotionRowOrColumn(int i) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return -1;
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            if (i <= getChildEndEdge(getChildAt(i2))) {
                return this.mFirstPosition + i2;
            }
        }
        return -1;
    }

    private int findClosestMotionRowOrColumn(int i) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return -1;
        }
        int findMotionRowOrColumn = findMotionRowOrColumn(i);
        return findMotionRowOrColumn != -1 ? findMotionRowOrColumn : (this.mFirstPosition + childCount) - 1;
    }

    @TargetApi(9)
    private int getScaledOverscrollDistance(ViewConfiguration viewConfiguration) {
        if (Build.VERSION.SDK_INT < 9) {
            return 0;
        }
        return viewConfiguration.getScaledOverscrollDistance();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getStartEdge() {
        return this.mIsVertical ? getPaddingTop() : getPaddingLeft();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getEndEdge() {
        if (this.mIsVertical) {
            return getHeight() - getPaddingBottom();
        }
        return getWidth() - getPaddingRight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getSize() {
        return this.mIsVertical ? getHeight() : getWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getAvailableSize() {
        if (this.mIsVertical) {
            return (getHeight() - getPaddingBottom()) - getPaddingTop();
        }
        return (getWidth() - getPaddingRight()) - getPaddingLeft();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getChildStartEdge(View view) {
        return this.mIsVertical ? view.getTop() : view.getLeft();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getChildEndEdge(View view) {
        return this.mIsVertical ? view.getBottom() : view.getRight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getChildSize(View view) {
        return this.mIsVertical ? view.getHeight() : view.getWidth();
    }

    private int getChildMeasuredSize(View view) {
        return this.mIsVertical ? view.getMeasuredHeight() : view.getMeasuredWidth();
    }

    private int getFadingEdgeLength() {
        return this.mIsVertical ? getVerticalFadingEdgeLength() : getHorizontalFadingEdgeLength();
    }

    private int getMaxSelectionPixel(int i, int i2, int i3) {
        return i3 != this.mItemCount + (-1) ? i - i2 : i;
    }

    private boolean contentFits() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return true;
        }
        if (childCount != this.mItemCount) {
            return false;
        }
        return getChildStartEdge(getChildAt(0)) >= getStartEdge() && getChildEndEdge(getChildAt(childCount - 1)) <= getEndEdge();
    }

    private void triggerCheckForTap() {
        if (this.mPendingCheckForTap == null) {
            this.mPendingCheckForTap = new CheckForTap();
        }
        postDelayed(this.mPendingCheckForTap, ViewConfiguration.getTapTimeout());
    }

    private void cancelCheckForTap() {
        CheckForTap checkForTap = this.mPendingCheckForTap;
        if (checkForTap == null) {
            return;
        }
        removeCallbacks(checkForTap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void triggerCheckForLongPress() {
        if (this.mPendingCheckForLongPress == null) {
            this.mPendingCheckForLongPress = new CheckForLongPress();
        }
        this.mPendingCheckForLongPress.rememberWindowAttachCount();
        postDelayed(this.mPendingCheckForLongPress, ViewConfiguration.getLongPressTimeout());
    }

    private void cancelCheckForLongPress() {
        CheckForLongPress checkForLongPress = this.mPendingCheckForLongPress;
        if (checkForLongPress == null) {
            return;
        }
        removeCallbacks(checkForLongPress);
    }

    private boolean scrollListItemsBy(int i) {
        int min;
        int i2;
        int i3;
        int i4;
        int childCount = getChildCount();
        if (childCount == 0) {
            return true;
        }
        int childStartEdge = getChildStartEdge(getChildAt(0));
        int i5 = childCount - 1;
        int childEndEdge = getChildEndEdge(getChildAt(i5));
        int paddingTop = getPaddingTop();
        int paddingLeft = getPaddingLeft();
        if (!this.mIsVertical) {
            paddingTop = paddingLeft;
        }
        int i6 = paddingTop - childStartEdge;
        int endEdge = getEndEdge();
        int i7 = childEndEdge - endEdge;
        int availableSize = getAvailableSize();
        if (i < 0) {
            min = Math.max(-(availableSize - 1), i);
        } else {
            min = Math.min(availableSize - 1, i);
        }
        int i8 = this.mFirstPosition;
        boolean z = i8 == 0 && childStartEdge >= paddingTop && min >= 0;
        boolean z2 = i8 + childCount == this.mItemCount && childEndEdge <= endEdge && min <= 0;
        if (z || z2) {
            return min != 0;
        }
        boolean isInTouchMode = isInTouchMode();
        if (isInTouchMode) {
            hideSelector();
        }
        boolean z3 = min < 0;
        if (!z3) {
            int i9 = endEdge - min;
            i2 = 0;
            i3 = 0;
            while (i5 >= 0) {
                View childAt = getChildAt(i5);
                if (getChildStartEdge(childAt) <= i9) {
                    break;
                }
                i3++;
                this.mRecycler.addScrapView(childAt, i8 + i5);
                int i10 = i5;
                i5--;
                i2 = i10;
            }
        } else {
            int i11 = (-min) + paddingTop;
            int i12 = 0;
            for (int i13 = 0; i13 < childCount; i13++) {
                View childAt2 = getChildAt(i13);
                if (getChildEndEdge(childAt2) >= i11) {
                    break;
                }
                i12++;
                this.mRecycler.addScrapView(childAt2, i8 + i13);
            }
            i3 = i12;
            i2 = 0;
        }
        this.mBlockLayoutRequests = true;
        if (i3 > 0) {
            detachViewsFromParent(i2, i3);
        }
        if (!awakenScrollbarsInternal()) {
            invalidate();
        }
        offsetChildren(min);
        if (z3) {
            this.mFirstPosition += i3;
        }
        int abs = Math.abs(min);
        if (i6 < abs || i7 < abs) {
            fillGap(z3);
        }
        if (!isInTouchMode && (i4 = this.mSelectedPosition) != -1) {
            int i14 = i4 - this.mFirstPosition;
            if (i14 >= 0 && i14 < getChildCount()) {
                positionSelector(this.mSelectedPosition, getChildAt(i14));
            }
        } else {
            int i15 = this.mSelectorPosition;
            if (i15 != -1) {
                int i16 = i15 - this.mFirstPosition;
                if (i16 >= 0 && i16 < getChildCount()) {
                    positionSelector(-1, getChildAt(i16));
                }
            } else {
                this.mSelectorRect.setEmpty();
            }
        }
        this.mBlockLayoutRequests = false;
        invokeOnItemScrollListener();
        return false;
    }

    @TargetApi(14)
    private final float getCurrVelocity() {
        return Build.VERSION.SDK_INT >= 14 ? this.mScroller.getCurrVelocity() : ColumnText.GLOBAL_SPACE_CHAR_RATIO;
    }

    @TargetApi(5)
    private boolean awakenScrollbarsInternal() {
        return Build.VERSION.SDK_INT >= 5 && super.awakenScrollBars();
    }

    @Override // android.view.View
    public void computeScroll() {
        int currX;
        if (this.mScroller.computeScrollOffset()) {
            if (this.mIsVertical) {
                currX = this.mScroller.getCurrY();
            } else {
                currX = this.mScroller.getCurrX();
            }
            float f = currX;
            int i = (int) (f - this.mLastTouchPos);
            this.mLastTouchPos = f;
            boolean scrollListItemsBy = scrollListItemsBy(i);
            if (!scrollListItemsBy && !this.mScroller.isFinished()) {
                ViewCompat.m14626e(this);
                return;
            }
            if (scrollListItemsBy) {
                if (ViewCompat.m14652a((View) this) != 2) {
                    if ((i > 0 ? this.mStartEdge : this.mEndEdge).m14258a(Math.abs((int) getCurrVelocity()))) {
                        ViewCompat.m14626e(this);
                    }
                }
                finishSmoothScrolling();
            }
            this.mTouchMode = -1;
            reportScrollStateChange(0);
        }
    }

    private void finishEdgeGlows() {
        EdgeEffectCompat edgeEffectCompat = this.mStartEdge;
        if (edgeEffectCompat != null) {
            edgeEffectCompat.m14255b();
        }
        EdgeEffectCompat edgeEffectCompat2 = this.mEndEdge;
        if (edgeEffectCompat2 != null) {
            edgeEffectCompat2.m14255b();
        }
    }

    private boolean drawStartEdge(Canvas canvas) {
        if (this.mStartEdge.m14261a()) {
            return false;
        }
        if (this.mIsVertical) {
            return this.mStartEdge.m14256a(canvas);
        }
        int save = canvas.save();
        canvas.translate(ColumnText.GLOBAL_SPACE_CHAR_RATIO, getHeight());
        canvas.rotate(270.0f);
        boolean m14256a = this.mStartEdge.m14256a(canvas);
        canvas.restoreToCount(save);
        return m14256a;
    }

    private boolean drawEndEdge(Canvas canvas) {
        if (this.mEndEdge.m14261a()) {
            return false;
        }
        int save = canvas.save();
        int width = getWidth();
        int height = getHeight();
        if (this.mIsVertical) {
            canvas.translate(-width, height);
            canvas.rotate(180.0f, width, ColumnText.GLOBAL_SPACE_CHAR_RATIO);
        } else {
            canvas.translate(width, ColumnText.GLOBAL_SPACE_CHAR_RATIO);
            canvas.rotate(90.0f);
        }
        boolean m14256a = this.mEndEdge.m14256a(canvas);
        canvas.restoreToCount(save);
        return m14256a;
    }

    private void finishSmoothScrolling() {
        this.mTouchMode = -1;
        reportScrollStateChange(0);
        this.mScroller.abortAnimation();
        PositionScroller positionScroller = this.mPositionScroller;
        if (positionScroller != null) {
            positionScroller.stop();
        }
    }

    private void drawSelector(Canvas canvas) {
        if (this.mSelectorRect.isEmpty()) {
            return;
        }
        Drawable drawable = this.mSelector;
        drawable.setBounds(this.mSelectorRect);
        drawable.draw(canvas);
    }

    private void useDefaultSelector() {
        setSelector(getResources().getDrawable(17301602));
    }

    private boolean shouldShowSelector() {
        return (hasFocus() && !isInTouchMode()) || touchModeDrawsInPressedState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void positionSelector(int i, View view) {
        if (i != -1) {
            this.mSelectorPosition = i;
        }
        this.mSelectorRect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        boolean z = this.mIsChildViewEnabled;
        if (view.isEnabled() != z) {
            this.mIsChildViewEnabled = !z;
            if (getSelectedItemPosition() != -1) {
                refreshDrawableState();
            }
        }
    }

    private void hideSelector() {
        int i = this.mSelectedPosition;
        if (i != -1) {
            if (this.mLayoutMode != 4) {
                this.mResurrectToPosition = i;
            }
            int i2 = this.mNextSelectedPosition;
            if (i2 >= 0 && i2 != this.mSelectedPosition) {
                this.mResurrectToPosition = i2;
            }
            setSelectedPositionInt(-1);
            setNextSelectedPositionInt(-1);
            this.mSelectedStart = 0;
        }
    }

    private void setSelectedPositionInt(int i) {
        this.mSelectedPosition = i;
        this.mSelectedRowId = getItemIdAtPosition(i);
    }

    private void setSelectionInt(int i) {
        setNextSelectedPositionInt(i);
        int i2 = this.mSelectedPosition;
        boolean z = true;
        if (i2 < 0 || (i != i2 - 1 && i != i2 + 1)) {
            z = false;
        }
        layoutChildren();
        if (z) {
            awakenScrollbarsInternal();
        }
    }

    private void setNextSelectedPositionInt(int i) {
        this.mNextSelectedPosition = i;
        this.mNextSelectedRowId = getItemIdAtPosition(i);
        if (this.mNeedSync && this.mSyncMode == 0 && i >= 0) {
            this.mSyncPosition = i;
            this.mSyncRowId = this.mNextSelectedRowId;
        }
    }

    private boolean touchModeDrawsInPressedState() {
        switch (this.mTouchMode) {
            case 1:
            case 2:
                return true;
            default:
                return false;
        }
    }

    private void keyPressed() {
        if (isEnabled() && isClickable()) {
            Drawable drawable = this.mSelector;
            Rect rect = this.mSelectorRect;
            if (drawable != null) {
                if ((isFocused() || touchModeDrawsInPressedState()) && !rect.isEmpty()) {
                    View childAt = getChildAt(this.mSelectedPosition - this.mFirstPosition);
                    if (childAt != null) {
                        if (childAt.hasFocusable()) {
                            return;
                        }
                        childAt.setPressed(true);
                    }
                    setPressed(true);
                    boolean isLongClickable = isLongClickable();
                    Drawable current = drawable.getCurrent();
                    if (current != null && (current instanceof TransitionDrawable)) {
                        if (isLongClickable) {
                            ((TransitionDrawable) current).startTransition(ViewConfiguration.getLongPressTimeout());
                        } else {
                            ((TransitionDrawable) current).resetTransition();
                        }
                    }
                    if (!isLongClickable || this.mDataChanged) {
                        return;
                    }
                    if (this.mPendingCheckForKeyLongPress == null) {
                        this.mPendingCheckForKeyLongPress = new CheckForKeyLongPress();
                    }
                    this.mPendingCheckForKeyLongPress.rememberWindowAttachCount();
                    postDelayed(this.mPendingCheckForKeyLongPress, ViewConfiguration.getLongPressTimeout());
                }
            }
        }
    }

    private void updateSelectorState() {
        if (this.mSelector != null) {
            if (shouldShowSelector()) {
                this.mSelector.setState(getDrawableState());
            } else {
                this.mSelector.setState(STATE_NOTHING);
            }
        }
    }

    private void checkSelectionChanged() {
        if (this.mSelectedPosition == this.mOldSelectedPosition && this.mSelectedRowId == this.mOldSelectedRowId) {
            return;
        }
        selectionChanged();
        this.mOldSelectedPosition = this.mSelectedPosition;
        this.mOldSelectedRowId = this.mSelectedRowId;
    }

    private void selectionChanged() {
        if (getOnItemSelectedListener() == null) {
            return;
        }
        if (this.mInLayout || this.mBlockLayoutRequests) {
            if (this.mSelectionNotifier == null) {
                this.mSelectionNotifier = new SelectionNotifier();
            }
            post(this.mSelectionNotifier);
            return;
        }
        fireOnSelected();
        performAccessibilityActionsOnSelected();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fireOnSelected() {
        AdapterView.OnItemSelectedListener onItemSelectedListener = getOnItemSelectedListener();
        if (onItemSelectedListener == null) {
            return;
        }
        int selectedItemPosition = getSelectedItemPosition();
        if (selectedItemPosition >= 0) {
            onItemSelectedListener.onItemSelected(this, getSelectedView(), selectedItemPosition, this.mAdapter.getItemId(selectedItemPosition));
        } else {
            onItemSelectedListener.onNothingSelected(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void performAccessibilityActionsOnSelected() {
        if (getSelectedItemPosition() >= 0) {
            sendAccessibilityEvent(4);
        }
    }

    private int lookForSelectablePosition(int i) {
        return lookForSelectablePosition(i, true);
    }

    private int lookForSelectablePosition(int i, boolean z) {
        int min;
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter == null || isInTouchMode()) {
            return -1;
        }
        int i2 = this.mItemCount;
        if (this.mAreAllItemsSelectable) {
            if (i < 0 || i >= i2) {
                return -1;
            }
            return i;
        }
        if (z) {
            min = Math.max(0, i);
            while (min < i2 && !listAdapter.isEnabled(min)) {
                min++;
            }
        } else {
            min = Math.min(i, i2 - 1);
            while (min >= 0 && !listAdapter.isEnabled(min)) {
                min--;
            }
        }
        if (min < 0 || min >= i2) {
            return -1;
        }
        return min;
    }

    private int lookForSelectablePositionOnScreen(int i) {
        forceValidFocusDirection(i);
        int i2 = this.mFirstPosition;
        ListAdapter adapter = getAdapter();
        if (i == 130 || i == 66) {
            int i3 = this.mSelectedPosition;
            int i4 = i3 != -1 ? i3 + 1 : i2;
            if (i4 >= adapter.getCount()) {
                return -1;
            }
            if (i4 < i2) {
                i4 = i2;
            }
            int lastVisiblePosition = getLastVisiblePosition();
            while (i4 <= lastVisiblePosition) {
                if (adapter.isEnabled(i4) && getChildAt(i4 - i2).getVisibility() == 0) {
                    return i4;
                }
                i4++;
            }
        } else {
            int childCount = (getChildCount() + i2) - 1;
            int i5 = this.mSelectedPosition;
            int childCount2 = i5 != -1 ? i5 - 1 : (getChildCount() + i2) - 1;
            if (childCount2 < 0 || childCount2 >= adapter.getCount()) {
                return -1;
            }
            if (childCount2 <= childCount) {
                childCount = childCount2;
            }
            while (childCount >= i2) {
                if (adapter.isEnabled(childCount) && getChildAt(childCount - i2).getVisibility() == 0) {
                    return childCount;
                }
                childCount--;
            }
        }
        return -1;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        updateSelectorState();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i) {
        if (this.mIsChildViewEnabled) {
            return super.onCreateDrawableState(i);
        }
        int i2 = ENABLED_STATE_SET[0];
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        int length = onCreateDrawableState.length - 1;
        while (true) {
            if (length < 0) {
                length = -1;
                break;
            } else if (onCreateDrawableState[length] == i2) {
                break;
            } else {
                length--;
            }
        }
        if (length >= 0) {
            System.arraycopy(onCreateDrawableState, length + 1, onCreateDrawableState, length, (onCreateDrawableState.length - length) - 1);
        }
        return onCreateDrawableState;
    }

    @Override // android.widget.AdapterView, android.view.ViewGroup
    protected boolean canAnimate() {
        return super.canAnimate() && this.mItemCount > 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        boolean z = this.mDrawSelectorOnTop;
        if (!z) {
            drawSelector(canvas);
        }
        super.dispatchDraw(canvas);
        if (z) {
            drawSelector(canvas);
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        boolean drawStartEdge = this.mStartEdge != null ? false | drawStartEdge(canvas) : false;
        if (this.mEndEdge != null) {
            drawStartEdge |= drawEndEdge(canvas);
        }
        if (drawStartEdge) {
            ViewCompat.m14626e(this);
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.mInLayout || this.mBlockLayoutRequests) {
            return;
        }
        super.requestLayout();
    }

    @Override // android.widget.AdapterView
    public View getSelectedView() {
        int i;
        if (this.mItemCount <= 0 || (i = this.mSelectedPosition) < 0) {
            return null;
        }
        return getChildAt(i - this.mFirstPosition);
    }

    @Override // android.widget.AdapterView
    public void setSelection(int i) {
        setSelectionFromOffset(i, 0);
    }

    public void setSelectionFromOffset(int i, int i2) {
        if (this.mAdapter == null) {
            return;
        }
        if (!isInTouchMode()) {
            i = lookForSelectablePosition(i);
            if (i >= 0) {
                setNextSelectedPositionInt(i);
            }
        } else {
            this.mResurrectToPosition = i;
        }
        if (i >= 0) {
            this.mLayoutMode = 4;
            if (this.mIsVertical) {
                this.mSpecificStart = getPaddingTop() + i2;
            } else {
                this.mSpecificStart = getPaddingLeft() + i2;
            }
            if (this.mNeedSync) {
                this.mSyncPosition = i;
                this.mSyncRowId = this.mAdapter.getItemId(i);
            }
            requestLayout();
        }
    }

    public void scrollBy(int i) {
        scrollListItemsBy(-i);
    }

    public void smoothScrollToPosition(int i) {
        if (this.mPositionScroller == null) {
            this.mPositionScroller = new PositionScroller();
        }
        this.mPositionScroller.start(i);
    }

    public void smoothScrollToPositionFromOffset(int i, int i2, int i3) {
        if (this.mPositionScroller == null) {
            this.mPositionScroller = new PositionScroller();
        }
        this.mPositionScroller.startWithOffset(i, i2, i3);
    }

    public void smoothScrollToPositionFromOffset(int i, int i2) {
        if (this.mPositionScroller == null) {
            this.mPositionScroller = new PositionScroller();
        }
        this.mPositionScroller.startWithOffset(i, i2);
    }

    public void smoothScrollToPosition(int i, int i2) {
        if (this.mPositionScroller == null) {
            this.mPositionScroller = new PositionScroller();
        }
        this.mPositionScroller.start(i, i2);
    }

    public void smoothScrollBy(int i, int i2) {
        int i3 = this.mFirstPosition;
        int childCount = getChildCount();
        int i4 = i3 + childCount;
        int startEdge = getStartEdge();
        int endEdge = getEndEdge();
        if (i == 0 || this.mItemCount == 0 || childCount == 0 || ((i3 == 0 && getChildStartEdge(getChildAt(0)) == startEdge && i < 0) || (i4 == this.mItemCount && getChildEndEdge(getChildAt(childCount - 1)) == endEdge && i > 0))) {
            finishSmoothScrolling();
            return;
        }
        this.mScroller.startScroll(0, 0, this.mIsVertical ? 0 : -i, this.mIsVertical ? -i : 0, i2);
        this.mLastTouchPos = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.mTouchMode = 4;
        reportScrollStateChange(2);
        ViewCompat.m14626e(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        return (dispatchKeyEvent || getFocusedChild() == null || keyEvent.getAction() != 0) ? dispatchKeyEvent : onKeyDown(keyEvent.getKeyCode(), keyEvent);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        if (this.mSelector == null) {
            useDefaultSelector();
        }
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        ListAdapter listAdapter = this.mAdapter;
        int i6 = 0;
        this.mItemCount = listAdapter == null ? 0 : listAdapter.getCount();
        if (this.mItemCount <= 0 || !(mode == 0 || mode2 == 0)) {
            i3 = 0;
        } else {
            View obtainView = obtainView(0, this.mIsScrap);
            measureScrapChild(obtainView, 0, this.mIsVertical ? i : i2);
            i6 = obtainView.getMeasuredWidth();
            i3 = obtainView.getMeasuredHeight();
            if (recycleOnMeasure()) {
                this.mRecycler.addScrapView(obtainView, -1);
            }
        }
        if (mode == 0) {
            int paddingLeft = getPaddingLeft() + getPaddingRight() + i6;
            i4 = this.mIsVertical ? paddingLeft + getVerticalScrollbarWidth() : paddingLeft;
        } else {
            i4 = size;
        }
        if (mode2 == 0) {
            int paddingTop = getPaddingTop() + getPaddingBottom() + i3;
            i5 = !this.mIsVertical ? paddingTop + getHorizontalScrollbarHeight() : paddingTop;
        } else {
            i5 = size2;
        }
        int measureHeightOfChildren = (this.mIsVertical && mode2 == Integer.MIN_VALUE) ? measureHeightOfChildren(i, 0, -1, i5, -1) : i5;
        if (!this.mIsVertical && mode == Integer.MIN_VALUE) {
            i4 = measureWidthOfChildren(i2, 0, -1, i4, -1);
        }
        setMeasuredDimension(i4, measureHeightOfChildren);
    }

    @Override // android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.mInLayout = true;
        if (z) {
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                getChildAt(i5).forceLayout();
            }
            this.mRecycler.markChildrenDirty();
        }
        layoutChildren();
        this.mInLayout = false;
        int paddingLeft = ((i3 - i) - getPaddingLeft()) - getPaddingRight();
        int paddingTop = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
        EdgeEffectCompat edgeEffectCompat = this.mStartEdge;
        if (edgeEffectCompat == null || this.mEndEdge == null) {
            return;
        }
        if (this.mIsVertical) {
            edgeEffectCompat.m14257a(paddingLeft, paddingTop);
            this.mEndEdge.m14257a(paddingLeft, paddingTop);
            return;
        }
        edgeEffectCompat.m14257a(paddingTop, paddingLeft);
        this.mEndEdge.m14257a(paddingTop, paddingLeft);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x018d, code lost:
        r0 = getFocusedChild();
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0191, code lost:
        if (r0 == null) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0193, code lost:
        r0.clearFocus();
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0196, code lost:
        positionSelector(-1, r1);
     */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v25, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v28 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void layoutChildren() {
        /*
            Method dump skipped, instructions count: 618
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.artifex.mupdflib.TwoWayView.layoutChildren():void");
    }

    private void offsetChildren(int i) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (this.mIsVertical) {
                childAt.offsetTopAndBottom(i);
            } else {
                childAt.offsetLeftAndRight(i);
            }
        }
    }

    private View moveSelection(View view, View view2, int i, int i2, int i3) {
        View makeAndAddView;
        int fadingEdgeLength = getFadingEdgeLength();
        int i4 = this.mSelectedPosition;
        int childStartEdge = getChildStartEdge(view);
        int childEndEdge = getChildEndEdge(view);
        int minSelectionPixel = getMinSelectionPixel(i2, fadingEdgeLength, i4);
        int maxSelectionPixel = getMaxSelectionPixel(i3, fadingEdgeLength, i4);
        if (i > 0) {
            View makeAndAddView2 = makeAndAddView(i4 - 1, childStartEdge, true, false);
            int i5 = this.mItemMargin;
            makeAndAddView = makeAndAddView(i4, childEndEdge + i5, true, true);
            int childStartEdge2 = getChildStartEdge(makeAndAddView);
            int childEndEdge2 = getChildEndEdge(makeAndAddView);
            if (childEndEdge2 > i3) {
                int min = Math.min(Math.min(childStartEdge2 - minSelectionPixel, childEndEdge2 - maxSelectionPixel), (i3 - i2) / 2);
                if (this.mIsVertical) {
                    int i6 = -min;
                    makeAndAddView2.offsetTopAndBottom(i6);
                    makeAndAddView.offsetTopAndBottom(i6);
                } else {
                    int i7 = -min;
                    makeAndAddView2.offsetLeftAndRight(i7);
                    makeAndAddView.offsetLeftAndRight(i7);
                }
            }
            fillBefore(this.mSelectedPosition - 2, childStartEdge2 - i5);
            adjustViewsStartOrEnd();
            fillAfter(this.mSelectedPosition + 1, childEndEdge2 + i5);
        } else if (i < 0) {
            if (view2 != null) {
                makeAndAddView = makeAndAddView(i4, getChildStartEdge(view2), true, true);
            } else {
                makeAndAddView = makeAndAddView(i4, childStartEdge, false, true);
            }
            int childStartEdge3 = getChildStartEdge(makeAndAddView);
            int childEndEdge3 = getChildEndEdge(makeAndAddView);
            if (childStartEdge3 < minSelectionPixel) {
                int min2 = Math.min(Math.min(minSelectionPixel - childStartEdge3, maxSelectionPixel - childEndEdge3), (i3 - i2) / 2);
                if (this.mIsVertical) {
                    makeAndAddView.offsetTopAndBottom(min2);
                } else {
                    makeAndAddView.offsetLeftAndRight(min2);
                }
            }
            fillBeforeAndAfter(makeAndAddView, i4);
        } else {
            makeAndAddView = makeAndAddView(i4, childStartEdge, true, true);
            int childStartEdge4 = getChildStartEdge(makeAndAddView);
            int childEndEdge4 = getChildEndEdge(makeAndAddView);
            if (childStartEdge < i2 && childEndEdge4 < i2 + 20) {
                if (this.mIsVertical) {
                    makeAndAddView.offsetTopAndBottom(i2 - childStartEdge4);
                } else {
                    makeAndAddView.offsetLeftAndRight(i2 - childStartEdge4);
                }
            }
            fillBeforeAndAfter(makeAndAddView, i4);
        }
        return makeAndAddView;
    }

    void confirmCheckedPositionsById() {
        boolean z;
        this.mCheckStates.clear();
        int i = 0;
        while (i < this.mCheckedIdStates.m14874b()) {
            long m14873b = this.mCheckedIdStates.m14873b(i);
            int intValue = this.mCheckedIdStates.m14870c(i).intValue();
            if (m14873b != this.mAdapter.getItemId(intValue)) {
                int max = Math.max(0, intValue - 20);
                int min = Math.min(intValue + 20, this.mItemCount);
                while (true) {
                    if (max >= min) {
                        z = false;
                        break;
                    } else if (m14873b == this.mAdapter.getItemId(max)) {
                        this.mCheckStates.put(max, true);
                        LongSparseArray<Integer> longSparseArray = this.mCheckedIdStates;
                        Integer valueOf = Integer.valueOf(max);
                        if (longSparseArray.f519a) {
                            longSparseArray.m14878a();
                        }
                        longSparseArray.f520b[i] = valueOf;
                        z = true;
                    } else {
                        max++;
                    }
                }
                if (!z) {
                    this.mCheckedIdStates.m14872b(m14873b);
                    i--;
                    this.mCheckedItemCount--;
                }
            } else {
                this.mCheckStates.put(intValue, true);
            }
            i++;
        }
    }

    private void handleDataChanged() {
        ListAdapter listAdapter;
        if (this.mChoiceMode != ChoiceMode.NONE && (listAdapter = this.mAdapter) != null && listAdapter.hasStableIds()) {
            confirmCheckedPositionsById();
        }
        this.mRecycler.clearTransientStateViews();
        int i = this.mItemCount;
        if (i > 0) {
            if (this.mNeedSync) {
                this.mNeedSync = false;
                this.mPendingSync = null;
                switch (this.mSyncMode) {
                    case 1:
                        this.mLayoutMode = 5;
                        this.mSyncPosition = Math.min(Math.max(0, this.mSyncPosition), i - 1);
                        return;
                    case 0:
                        if (isInTouchMode()) {
                            this.mLayoutMode = 5;
                            this.mSyncPosition = Math.min(Math.max(0, this.mSyncPosition), i - 1);
                            return;
                        }
                        int findSyncPosition = findSyncPosition();
                        if (findSyncPosition >= 0 && lookForSelectablePosition(findSyncPosition, true) == findSyncPosition) {
                            this.mSyncPosition = findSyncPosition;
                            if (this.mSyncSize == getSize()) {
                                this.mLayoutMode = 5;
                            } else {
                                this.mLayoutMode = 2;
                            }
                            setNextSelectedPositionInt(findSyncPosition);
                            return;
                        }
                        break;
                }
            }
            if (!isInTouchMode()) {
                int selectedItemPosition = getSelectedItemPosition();
                int i2 = selectedItemPosition >= i ? i - 1 : selectedItemPosition;
                if (i2 < 0) {
                    i2 = 0;
                }
                int lookForSelectablePosition = lookForSelectablePosition(i2, true);
                if (lookForSelectablePosition >= 0) {
                    setNextSelectedPositionInt(lookForSelectablePosition);
                    return;
                }
                int lookForSelectablePosition2 = lookForSelectablePosition(i2, false);
                if (lookForSelectablePosition2 >= 0) {
                    setNextSelectedPositionInt(lookForSelectablePosition2);
                    return;
                }
            } else if (this.mResurrectToPosition >= 0) {
                return;
            }
        }
        this.mLayoutMode = 1;
        this.mSelectedPosition = -1;
        this.mSelectedRowId = Long.MIN_VALUE;
        this.mNextSelectedPosition = -1;
        this.mNextSelectedRowId = Long.MIN_VALUE;
        this.mNeedSync = false;
        this.mPendingSync = null;
        this.mSelectorPosition = -1;
        checkSelectionChanged();
    }

    private int reconcileSelectedPosition() {
        int i = this.mSelectedPosition;
        if (i < 0) {
            i = this.mResurrectToPosition;
        }
        return Math.min(Math.max(0, i), this.mItemCount - 1);
    }

    boolean resurrectSelection() {
        int i;
        int i2;
        boolean z;
        int childCount = getChildCount();
        if (childCount <= 0) {
            return false;
        }
        int startEdge = getStartEdge();
        int endEdge = getEndEdge();
        int i3 = this.mFirstPosition;
        int i4 = this.mResurrectToPosition;
        if (i4 >= i3 && i4 < i3 + childCount) {
            View childAt = getChildAt(i4 - i3);
            int childStartEdge = getChildStartEdge(childAt);
            int childEndEdge = getChildEndEdge(childAt);
            if (childStartEdge < startEdge) {
                i2 = startEdge + getFadingEdgeLength();
                i = i4;
                z = true;
            } else {
                i2 = childEndEdge > endEdge ? (endEdge - getChildMeasuredSize(childAt)) - getFadingEdgeLength() : childStartEdge;
                i = i4;
                z = true;
            }
        } else if (i4 >= i3) {
            int i5 = this.mItemCount;
            int i6 = i3 + childCount;
            int i7 = i6 - 1;
            int i8 = childCount - 1;
            int i9 = endEdge;
            int i10 = 0;
            int i11 = i8;
            while (true) {
                if (i11 < 0) {
                    i = i7;
                    i2 = i10;
                    z = false;
                    break;
                }
                View childAt2 = getChildAt(i11);
                int childStartEdge2 = getChildStartEdge(childAt2);
                int childEndEdge2 = getChildEndEdge(childAt2);
                if (i11 == i8) {
                    if (i6 < i5 || childEndEdge2 > i9) {
                        i9 -= getFadingEdgeLength();
                        i10 = childStartEdge2;
                    } else {
                        i10 = childStartEdge2;
                    }
                }
                if (childEndEdge2 <= i9) {
                    i = i3 + i11;
                    i2 = childStartEdge2;
                    z = false;
                    break;
                }
                i11--;
            }
        } else {
            int i12 = startEdge;
            int i13 = 0;
            int i14 = 0;
            while (true) {
                if (i13 >= childCount) {
                    i2 = i14;
                    i = i3;
                    z = true;
                    break;
                }
                int childStartEdge3 = getChildStartEdge(getChildAt(i13));
                if (i13 == 0) {
                    if (i3 > 0 || childStartEdge3 < i12) {
                        i12 += getFadingEdgeLength();
                        i14 = childStartEdge3;
                    } else {
                        i14 = childStartEdge3;
                    }
                }
                if (childStartEdge3 >= i12) {
                    i = i3 + i13;
                    i2 = childStartEdge3;
                    z = true;
                    break;
                }
                i13++;
            }
        }
        this.mResurrectToPosition = -1;
        finishSmoothScrolling();
        this.mTouchMode = -1;
        reportScrollStateChange(0);
        this.mSpecificStart = i2;
        int lookForSelectablePosition = lookForSelectablePosition(i, z);
        if (lookForSelectablePosition < i3 || lookForSelectablePosition > getLastVisiblePosition()) {
            lookForSelectablePosition = -1;
        } else {
            this.mLayoutMode = 4;
            updateSelectorState();
            setSelectionInt(lookForSelectablePosition);
            invokeOnItemScrollListener();
        }
        return lookForSelectablePosition >= 0;
    }

    boolean resurrectSelectionIfNeeded() {
        if (this.mSelectedPosition >= 0 || !resurrectSelection()) {
            return false;
        }
        updateSelectorState();
        return true;
    }

    private int getChildWidthMeasureSpec(LayoutParams layoutParams) {
        if (!this.mIsVertical && layoutParams.width == -2) {
            return View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        if (this.mIsVertical) {
            return View.MeasureSpec.makeMeasureSpec((getWidth() - getPaddingLeft()) - getPaddingRight(), NTLMConstants.FLAG_NEGOTIATE_KEY_EXCHANGE);
        }
        return View.MeasureSpec.makeMeasureSpec(layoutParams.width, NTLMConstants.FLAG_NEGOTIATE_KEY_EXCHANGE);
    }

    private int getChildHeightMeasureSpec(LayoutParams layoutParams) {
        if (this.mIsVertical && layoutParams.height == -2) {
            return View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        if (!this.mIsVertical) {
            return View.MeasureSpec.makeMeasureSpec((getHeight() - getPaddingTop()) - getPaddingBottom(), NTLMConstants.FLAG_NEGOTIATE_KEY_EXCHANGE);
        }
        return View.MeasureSpec.makeMeasureSpec(layoutParams.height, NTLMConstants.FLAG_NEGOTIATE_KEY_EXCHANGE);
    }

    private void measureChild(View view) {
        measureChild(view, (LayoutParams) view.getLayoutParams());
    }

    private void measureChild(View view, LayoutParams layoutParams) {
        view.measure(getChildWidthMeasureSpec(layoutParams), getChildHeightMeasureSpec(layoutParams));
    }

    private void relayoutMeasuredChild(View view) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int paddingLeft = getPaddingLeft();
        int top = view.getTop();
        view.layout(paddingLeft, top, measuredWidth + paddingLeft, measuredHeight + top);
    }

    private void measureScrapChild(View view, int i, int i2) {
        int childWidthMeasureSpec;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = generateDefaultLayoutParams();
            view.setLayoutParams(layoutParams);
        }
        layoutParams.viewType = this.mAdapter.getItemViewType(i);
        layoutParams.forceAdd = true;
        if (this.mIsVertical) {
            i2 = getChildHeightMeasureSpec(layoutParams);
            childWidthMeasureSpec = i2;
        } else {
            childWidthMeasureSpec = getChildWidthMeasureSpec(layoutParams);
        }
        view.measure(childWidthMeasureSpec, i2);
    }

    private int measureHeightOfChildren(int i, int i2, int i3, int i4, int i5) {
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter == null) {
            return paddingTop + paddingBottom;
        }
        int i6 = paddingTop + paddingBottom;
        int i7 = this.mItemMargin;
        int i8 = 0;
        if (i3 == -1) {
            i3 = listAdapter.getCount() - 1;
        }
        RecycleBin recycleBin = this.mRecycler;
        boolean recycleOnMeasure = recycleOnMeasure();
        boolean[] zArr = this.mIsScrap;
        while (i2 <= i3) {
            View obtainView = obtainView(i2, zArr);
            measureScrapChild(obtainView, i2, i);
            if (i2 > 0) {
                i6 += i7;
            }
            if (recycleOnMeasure) {
                recycleBin.addScrapView(obtainView, -1);
            }
            i6 += obtainView.getMeasuredHeight();
            if (i6 >= i4) {
                return (i5 < 0 || i2 <= i5 || i8 <= 0 || i6 == i4) ? i4 : i8;
            }
            if (i5 >= 0 && i2 >= i5) {
                i8 = i6;
            }
            i2++;
        }
        return i6;
    }

    private int measureWidthOfChildren(int i, int i2, int i3, int i4, int i5) {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter == null) {
            return paddingLeft + paddingRight;
        }
        int i6 = paddingLeft + paddingRight;
        int i7 = this.mItemMargin;
        int i8 = 0;
        if (i3 == -1) {
            i3 = listAdapter.getCount() - 1;
        }
        RecycleBin recycleBin = this.mRecycler;
        boolean recycleOnMeasure = recycleOnMeasure();
        boolean[] zArr = this.mIsScrap;
        while (i2 <= i3) {
            View obtainView = obtainView(i2, zArr);
            measureScrapChild(obtainView, i2, i);
            if (i2 > 0) {
                i6 += i7;
            }
            if (recycleOnMeasure) {
                recycleBin.addScrapView(obtainView, -1);
            }
            i6 += obtainView.getMeasuredWidth();
            if (i6 >= i4) {
                return (i5 < 0 || i2 <= i5 || i8 <= 0 || i6 == i4) ? i4 : i8;
            }
            if (i5 >= 0 && i2 >= i5) {
                i8 = i6;
            }
            i2++;
        }
        return i6;
    }

    private View makeAndAddView(int i, int i2, boolean z, boolean z2) {
        int i3;
        int paddingTop;
        View activeView;
        if (this.mIsVertical) {
            paddingTop = i2;
            i3 = getPaddingLeft();
        } else {
            i3 = i2;
            paddingTop = getPaddingTop();
        }
        if (!this.mDataChanged && (activeView = this.mRecycler.getActiveView(i)) != null) {
            setupChild(activeView, i, paddingTop, i3, z, z2, true);
            return activeView;
        }
        View obtainView = obtainView(i, this.mIsScrap);
        setupChild(obtainView, i, paddingTop, i3, z, z2, this.mIsScrap[0]);
        return obtainView;
    }

    @TargetApi(11)
    private void setupChild(View view, int i, int i2, int i3, boolean z, boolean z2, boolean z3) {
        SparseBooleanArray sparseBooleanArray;
        boolean z4 = z2 && shouldShowSelector();
        boolean z5 = z4 != view.isSelected();
        int i4 = this.mTouchMode;
        boolean z6 = i4 > 0 && i4 < 3 && this.mMotionPosition == i;
        boolean z7 = z6 != view.isPressed();
        boolean z8 = !z3 || z5 || view.isLayoutRequested();
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = generateDefaultLayoutParams();
        }
        layoutParams.viewType = this.mAdapter.getItemViewType(i);
        if (z3 && !layoutParams.forceAdd) {
            attachViewToParent(view, z ? -1 : 0, layoutParams);
        } else {
            layoutParams.forceAdd = false;
            addViewInLayout(view, z ? -1 : 0, layoutParams, true);
        }
        if (z5) {
            view.setSelected(z4);
        }
        if (z7) {
            view.setPressed(z6);
        }
        if (this.mChoiceMode != ChoiceMode.NONE && (sparseBooleanArray = this.mCheckStates) != null) {
            if (view instanceof Checkable) {
                ((Checkable) view).setChecked(sparseBooleanArray.get(i));
            } else if (Build.VERSION.SDK_INT >= 11) {
                view.setActivated(this.mCheckStates.get(i));
            }
        }
        if (z8) {
            measureChild(view, layoutParams);
        } else {
            cleanupLayoutState(view);
        }
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (this.mIsVertical && !z) {
            i2 -= measuredHeight;
        }
        if (!this.mIsVertical && !z) {
            i3 -= measuredWidth;
        }
        if (z8) {
            view.layout(i3, i2, measuredWidth + i3, measuredHeight + i2);
            return;
        }
        view.offsetLeftAndRight(i3 - view.getLeft());
        view.offsetTopAndBottom(i2 - view.getTop());
    }

    void fillGap(boolean z) {
        int childCount = getChildCount();
        if (z) {
            int startEdge = getStartEdge();
            int childEndEdge = getChildEndEdge(getChildAt(childCount - 1));
            if (childCount > 0) {
                startEdge = this.mItemMargin + childEndEdge;
            }
            fillAfter(this.mFirstPosition + childCount, startEdge);
            correctTooHigh(getChildCount());
            return;
        }
        int endEdge = getEndEdge();
        int childStartEdge = getChildStartEdge(getChildAt(0));
        if (childCount > 0) {
            endEdge = childStartEdge - this.mItemMargin;
        }
        fillBefore(this.mFirstPosition - 1, endEdge);
        correctTooLow(getChildCount());
    }

    private View fillBefore(int i, int i2) {
        int startEdge = getStartEdge();
        View view = null;
        while (true) {
            if (i2 <= startEdge || i < 0) {
                break;
            }
            boolean z = i == this.mSelectedPosition;
            View makeAndAddView = makeAndAddView(i, i2, false, z);
            int childStartEdge = getChildStartEdge(makeAndAddView) - this.mItemMargin;
            if (z) {
                view = makeAndAddView;
            }
            i--;
            i2 = childStartEdge;
        }
        this.mFirstPosition = i + 1;
        return view;
    }

    private View fillAfter(int i, int i2) {
        int endEdge = getEndEdge();
        View view = null;
        while (i2 < endEdge && i < this.mItemCount) {
            boolean z = i == this.mSelectedPosition;
            View makeAndAddView = makeAndAddView(i, i2, true, z);
            int childEndEdge = getChildEndEdge(makeAndAddView) + this.mItemMargin;
            if (z) {
                view = makeAndAddView;
            }
            i++;
            i2 = childEndEdge;
        }
        return view;
    }

    private View fillSpecific(int i, int i2) {
        boolean z = i == this.mSelectedPosition;
        View makeAndAddView = makeAndAddView(i, i2, true, z);
        this.mFirstPosition = i;
        View fillBefore = fillBefore(i - 1, getChildStartEdge(makeAndAddView) - this.mItemMargin);
        adjustViewsStartOrEnd();
        View fillAfter = fillAfter(i + 1, getChildEndEdge(makeAndAddView) + this.mItemMargin);
        int childCount = getChildCount();
        if (childCount > 0) {
            correctTooHigh(childCount);
        }
        return z ? makeAndAddView : fillBefore != null ? fillBefore : fillAfter;
    }

    private View fillFromOffset(int i) {
        this.mFirstPosition = Math.min(this.mFirstPosition, this.mSelectedPosition);
        this.mFirstPosition = Math.min(this.mFirstPosition, this.mItemCount - 1);
        if (this.mFirstPosition < 0) {
            this.mFirstPosition = 0;
        }
        return fillAfter(this.mFirstPosition, i);
    }

    private View fillFromMiddle(int i, int i2) {
        int i3 = i2 - i;
        int reconcileSelectedPosition = reconcileSelectedPosition();
        View makeAndAddView = makeAndAddView(reconcileSelectedPosition, i, true, true);
        this.mFirstPosition = reconcileSelectedPosition;
        if (this.mIsVertical) {
            int measuredHeight = makeAndAddView.getMeasuredHeight();
            if (measuredHeight <= i3) {
                makeAndAddView.offsetTopAndBottom((i3 - measuredHeight) / 2);
            }
        } else {
            int measuredWidth = makeAndAddView.getMeasuredWidth();
            if (measuredWidth <= i3) {
                makeAndAddView.offsetLeftAndRight((i3 - measuredWidth) / 2);
            }
        }
        fillBeforeAndAfter(makeAndAddView, reconcileSelectedPosition);
        correctTooHigh(getChildCount());
        return makeAndAddView;
    }

    private void fillBeforeAndAfter(View view, int i) {
        fillBefore(i - 1, getChildStartEdge(view) + this.mItemMargin);
        adjustViewsStartOrEnd();
        fillAfter(i + 1, getChildEndEdge(view) + this.mItemMargin);
    }

    private View fillFromSelection(int i, int i2, int i3) {
        int fadingEdgeLength = getFadingEdgeLength();
        int i4 = this.mSelectedPosition;
        int minSelectionPixel = getMinSelectionPixel(i2, fadingEdgeLength, i4);
        int maxSelectionPixel = getMaxSelectionPixel(i3, fadingEdgeLength, i4);
        View makeAndAddView = makeAndAddView(i4, i, true, true);
        int childStartEdge = getChildStartEdge(makeAndAddView);
        int childEndEdge = getChildEndEdge(makeAndAddView);
        if (childEndEdge > maxSelectionPixel) {
            makeAndAddView.offsetTopAndBottom(-Math.min(childStartEdge - minSelectionPixel, childEndEdge - maxSelectionPixel));
        } else if (childStartEdge < minSelectionPixel) {
            makeAndAddView.offsetTopAndBottom(Math.min(minSelectionPixel - childStartEdge, maxSelectionPixel - childEndEdge));
        }
        fillBeforeAndAfter(makeAndAddView, i4);
        correctTooHigh(getChildCount());
        return makeAndAddView;
    }

    private void correctTooHigh(int i) {
        if ((this.mFirstPosition + i) - 1 != this.mItemCount - 1 || i == 0) {
            return;
        }
        int childEndEdge = getChildEndEdge(getChildAt(i - 1));
        int startEdge = getStartEdge();
        int endEdge = getEndEdge() - childEndEdge;
        View childAt = getChildAt(0);
        int childStartEdge = getChildStartEdge(childAt);
        if (endEdge > 0) {
            if (this.mFirstPosition > 0 || childStartEdge < startEdge) {
                if (this.mFirstPosition == 0) {
                    endEdge = Math.min(endEdge, startEdge - childStartEdge);
                }
                offsetChildren(endEdge);
                if (this.mFirstPosition > 0) {
                    fillBefore(this.mFirstPosition - 1, getChildStartEdge(childAt) - this.mItemMargin);
                    adjustViewsStartOrEnd();
                }
            }
        }
    }

    private void correctTooLow(int i) {
        if (this.mFirstPosition != 0 || i == 0) {
            return;
        }
        int childStartEdge = getChildStartEdge(getChildAt(0));
        int startEdge = getStartEdge();
        int endEdge = getEndEdge();
        int i2 = childStartEdge - startEdge;
        View childAt = getChildAt(i - 1);
        int childEndEdge = getChildEndEdge(childAt);
        int i3 = (this.mFirstPosition + i) - 1;
        if (i2 > 0) {
            int i4 = this.mItemCount;
            if (i3 >= i4 - 1 && childEndEdge <= endEdge) {
                if (i3 == i4 - 1) {
                    adjustViewsStartOrEnd();
                    return;
                }
                return;
            }
            if (i3 == this.mItemCount - 1) {
                i2 = Math.min(i2, childEndEdge - endEdge);
            }
            offsetChildren(-i2);
            if (i3 < this.mItemCount - 1) {
                fillAfter(i3 + 1, getChildEndEdge(childAt) + this.mItemMargin);
                adjustViewsStartOrEnd();
            }
        }
    }

    private void adjustViewsStartOrEnd() {
        if (getChildCount() == 0) {
            return;
        }
        int childStartEdge = getChildStartEdge(getChildAt(0)) - getStartEdge();
        if (this.mItemMargin >= 0 || this.mFirstPosition != 0) {
            childStartEdge -= this.mItemMargin;
        }
        int i = childStartEdge >= 0 ? childStartEdge : 0;
        if (i != 0) {
            offsetChildren(-i);
        }
    }

    @TargetApi(14)
    private SparseBooleanArray cloneCheckStates() {
        if (this.mCheckStates == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 14) {
            return this.mCheckStates.clone();
        }
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        for (int i = 0; i < this.mCheckStates.size(); i++) {
            sparseBooleanArray.put(this.mCheckStates.keyAt(i), this.mCheckStates.valueAt(i));
        }
        return sparseBooleanArray;
    }

    private int findSyncPosition() {
        int i = this.mItemCount;
        if (i == 0) {
            return -1;
        }
        long j = this.mSyncRowId;
        if (j == Long.MIN_VALUE) {
            return -1;
        }
        int i2 = i - 1;
        int min = Math.min(i2, Math.max(0, this.mSyncPosition));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter == null) {
            return -1;
        }
        int i3 = min;
        int i4 = i3;
        boolean z = false;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (listAdapter.getItemId(min) != j) {
                boolean z2 = i3 == i2;
                boolean z3 = i4 == 0;
                if (z2 && z3) {
                    break;
                } else if (z3 || (z && !z2)) {
                    i3++;
                    min = i3;
                    z = false;
                } else if (z2 || (!z && !z3)) {
                    i4--;
                    min = i4;
                    z = true;
                }
            } else {
                return min;
            }
        }
        return -1;
    }

    @TargetApi(16)
    private View obtainView(int i, boolean[] zArr) {
        View view;
        zArr[0] = false;
        View transientStateView = this.mRecycler.getTransientStateView(i);
        if (transientStateView != null) {
            return transientStateView;
        }
        View scrapView = this.mRecycler.getScrapView(i);
        if (scrapView != null) {
            view = this.mAdapter.getView(i, scrapView, this);
            if (view != scrapView) {
                this.mRecycler.addScrapView(scrapView, i);
            } else {
                zArr[0] = true;
            }
        } else {
            view = this.mAdapter.getView(i, null, this);
        }
        if (ViewCompat.m14623f(view) == 0) {
            ViewCompat.m14630c(view, 1);
        }
        if (this.mHasStableIds) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
            } else if (!checkLayoutParams(layoutParams)) {
                layoutParams = generateLayoutParams((ViewGroup.LayoutParams) layoutParams);
            }
            layoutParams.f3565id = this.mAdapter.getItemId(i);
            view.setLayoutParams(layoutParams);
        }
        if (this.mAccessibilityDelegate == null) {
            this.mAccessibilityDelegate = new ListItemAccessibilityDelegate();
        }
        ViewCompat.m14642a(view, this.mAccessibilityDelegate);
        return view;
    }

    void resetState() {
        this.mScroller.forceFinished(true);
        removeAllViewsInLayout();
        this.mSelectedStart = 0;
        this.mFirstPosition = 0;
        this.mDataChanged = false;
        this.mNeedSync = false;
        this.mPendingSync = null;
        this.mOldSelectedPosition = -1;
        this.mOldSelectedRowId = Long.MIN_VALUE;
        this.mOverScroll = 0;
        setSelectedPositionInt(-1);
        setNextSelectedPositionInt(-1);
        this.mSelectorPosition = -1;
        this.mSelectorRect.setEmpty();
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rememberSyncState() {
        if (getChildCount() == 0) {
            return;
        }
        this.mNeedSync = true;
        int i = this.mSelectedPosition;
        if (i >= 0) {
            View childAt = getChildAt(i - this.mFirstPosition);
            this.mSyncRowId = this.mNextSelectedRowId;
            this.mSyncPosition = this.mNextSelectedPosition;
            if (childAt != null) {
                this.mSpecificStart = getChildStartEdge(childAt);
            }
            this.mSyncMode = 0;
            return;
        }
        View childAt2 = getChildAt(0);
        ListAdapter adapter = getAdapter();
        int i2 = this.mFirstPosition;
        if (i2 >= 0 && i2 < adapter.getCount()) {
            this.mSyncRowId = adapter.getItemId(this.mFirstPosition);
        } else {
            this.mSyncRowId = -1L;
        }
        this.mSyncPosition = this.mFirstPosition;
        if (childAt2 != null) {
            this.mSpecificStart = getChildStartEdge(childAt2);
        }
        this.mSyncMode = 1;
    }

    private ContextMenu.ContextMenuInfo createContextMenuInfo(View view, int i, long j) {
        return new AdapterView.AdapterContextMenuInfo(view, i, j);
    }

    @TargetApi(11)
    private void updateOnScreenCheckedViews() {
        int i = this.mFirstPosition;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            int i3 = i + i2;
            if (childAt instanceof Checkable) {
                ((Checkable) childAt).setChecked(this.mCheckStates.get(i3));
            } else if (Build.VERSION.SDK_INT >= 11) {
                childAt.setActivated(this.mCheckStates.get(i3));
            }
        }
    }

    @Override // android.widget.AdapterView
    public boolean performItemClick(View view, int i, long j) {
        boolean z = true;
        if (this.mChoiceMode == ChoiceMode.MULTIPLE) {
            boolean z2 = !this.mCheckStates.get(i, false);
            this.mCheckStates.put(i, z2);
            if (this.mCheckedIdStates != null && this.mAdapter.hasStableIds()) {
                if (z2) {
                    this.mCheckedIdStates.m14875a(this.mAdapter.getItemId(i), Integer.valueOf(i));
                } else {
                    this.mCheckedIdStates.m14872b(this.mAdapter.getItemId(i));
                }
            }
            if (z2) {
                this.mCheckedItemCount++;
            } else {
                this.mCheckedItemCount--;
            }
        } else if (this.mChoiceMode != ChoiceMode.SINGLE) {
            z = false;
        } else if (!this.mCheckStates.get(i, false)) {
            this.mCheckStates.clear();
            this.mCheckStates.put(i, true);
            if (this.mCheckedIdStates != null && this.mAdapter.hasStableIds()) {
                this.mCheckedIdStates.m14871c();
                this.mCheckedIdStates.m14875a(this.mAdapter.getItemId(i), Integer.valueOf(i));
            }
            this.mCheckedItemCount = 1;
        } else if (this.mCheckStates.size() == 0 || !this.mCheckStates.valueAt(0)) {
            this.mCheckedItemCount = 0;
        }
        if (z) {
            updateOnScreenCheckedViews();
        }
        return super.performItemClick(view, i, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean performLongPress(View view, int i, long j) {
        AdapterView.OnItemLongClickListener onItemLongClickListener = getOnItemLongClickListener();
        boolean onItemLongClick = onItemLongClickListener != null ? onItemLongClickListener.onItemLongClick(this, view, i, j) : false;
        if (!onItemLongClick) {
            this.mContextMenuInfo = createContextMenuInfo(view, i, j);
            onItemLongClick = super.showContextMenuForChild(this);
        }
        if (onItemLongClick) {
            performHapticFeedback(0);
        }
        return onItemLongClick;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        if (this.mIsVertical) {
            return new LayoutParams(-1, -2);
        }
        return new LayoutParams(-2, -1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.View
    protected ContextMenu.ContextMenuInfo getContextMenuInfo() {
        return this.mContextMenuInfo;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SavedState savedState2 = this.mPendingSync;
        if (savedState2 != null) {
            savedState.selectedId = savedState2.selectedId;
            savedState.firstId = this.mPendingSync.firstId;
            savedState.viewStart = this.mPendingSync.viewStart;
            savedState.position = this.mPendingSync.position;
            savedState.size = this.mPendingSync.size;
            return savedState;
        }
        boolean z = getChildCount() > 0 && this.mItemCount > 0;
        long selectedItemId = getSelectedItemId();
        savedState.selectedId = selectedItemId;
        savedState.size = getSize();
        if (selectedItemId >= 0) {
            savedState.viewStart = this.mSelectedStart;
            savedState.position = getSelectedItemPosition();
            savedState.firstId = -1L;
        } else if (z && this.mFirstPosition > 0) {
            savedState.viewStart = getChildStartEdge(getChildAt(0));
            int i = this.mFirstPosition;
            int i2 = this.mItemCount;
            if (i >= i2) {
                i = i2 - 1;
            }
            savedState.position = i;
            savedState.firstId = this.mAdapter.getItemId(i);
        } else {
            savedState.viewStart = 0;
            savedState.firstId = -1L;
            savedState.position = 0;
        }
        if (this.mCheckStates != null) {
            savedState.checkState = cloneCheckStates();
        }
        if (this.mCheckedIdStates != null) {
            LongSparseArray<Integer> longSparseArray = new LongSparseArray<>();
            int m14874b = this.mCheckedIdStates.m14874b();
            for (int i3 = 0; i3 < m14874b; i3++) {
                longSparseArray.m14875a(this.mCheckedIdStates.m14873b(i3), this.mCheckedIdStates.m14870c(i3));
            }
            savedState.checkIdState = longSparseArray;
        }
        savedState.checkedItemCount = this.mCheckedItemCount;
        return savedState;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mDataChanged = true;
        this.mSyncSize = savedState.size;
        if (savedState.selectedId >= 0) {
            this.mNeedSync = true;
            this.mPendingSync = savedState;
            this.mSyncRowId = savedState.selectedId;
            this.mSyncPosition = savedState.position;
            this.mSpecificStart = savedState.viewStart;
            this.mSyncMode = 0;
        } else if (savedState.firstId >= 0) {
            setSelectedPositionInt(-1);
            setNextSelectedPositionInt(-1);
            this.mSelectorPosition = -1;
            this.mNeedSync = true;
            this.mPendingSync = savedState;
            this.mSyncRowId = savedState.firstId;
            this.mSyncPosition = savedState.position;
            this.mSpecificStart = savedState.viewStart;
            this.mSyncMode = 1;
        }
        if (savedState.checkState != null) {
            this.mCheckStates = savedState.checkState;
        }
        if (savedState.checkIdState != null) {
            this.mCheckedIdStates = savedState.checkIdState;
        }
        this.mCheckedItemCount = savedState.checkedItemCount;
        requestLayout();
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends ViewGroup.LayoutParams {
        boolean forceAdd;

        /* renamed from: id */
        long f3565id;
        int scrappedFromPosition;
        int viewType;

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.f3565id = -1L;
            if (this.width == -1) {
                Log.w(TwoWayView.LOGTAG, "Constructing LayoutParams with width FILL_PARENT does not make much sense as the view might change orientation. Falling back to WRAP_CONTENT");
                this.width = -2;
            }
            if (this.height == -1) {
                Log.w(TwoWayView.LOGTAG, "Constructing LayoutParams with height FILL_PARENT does not make much sense as the view might change orientation. Falling back to WRAP_CONTENT");
                this.height = -2;
            }
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f3565id = -1L;
            if (this.width == -1) {
                Log.w(TwoWayView.LOGTAG, "Inflation setting LayoutParams width to MATCH_PARENT - does not make much sense as the view might change orientation. Falling back to WRAP_CONTENT");
                this.width = -1;
            }
            if (this.height == -1) {
                Log.w(TwoWayView.LOGTAG, "Inflation setting LayoutParams height to MATCH_PARENT - does not make much sense as the view might change orientation. Falling back to WRAP_CONTENT");
                this.height = -2;
            }
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f3565id = -1L;
            if (this.width == -1) {
                Log.w(TwoWayView.LOGTAG, "Constructing LayoutParams with width MATCH_PARENT - does not make much sense as the view might change orientation. Falling back to WRAP_CONTENT");
                this.width = -2;
            }
            if (this.height == -1) {
                Log.w(TwoWayView.LOGTAG, "Constructing LayoutParams with height MATCH_PARENT - does not make much sense as the view might change orientation. Falling back to WRAP_CONTENT");
                this.height = -2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class RecycleBin {
        private View[] mActiveViews = new View[0];
        private ArrayList<View> mCurrentScrap;
        private int mFirstActivePosition;
        private RecyclerListener mRecyclerListener;
        private ArrayList<View>[] mScrapViews;
        private SparseArrayCompat<View> mTransientStateViews;
        private int mViewTypeCount;

        public boolean shouldRecycleViewType(int i) {
            return i >= 0;
        }

        RecycleBin() {
        }

        public void setViewTypeCount(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("Can't have a viewTypeCount < 1");
            }
            ArrayList<View>[] arrayListArr = new ArrayList[i];
            for (int i2 = 0; i2 < i; i2++) {
                arrayListArr[i2] = new ArrayList<>();
            }
            this.mViewTypeCount = i;
            this.mCurrentScrap = arrayListArr[0];
            this.mScrapViews = arrayListArr;
        }

        public void markChildrenDirty() {
            int i = this.mViewTypeCount;
            if (i == 1) {
                ArrayList<View> arrayList = this.mCurrentScrap;
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.get(i2).forceLayout();
                }
            } else {
                for (int i3 = 0; i3 < i; i3++) {
                    Iterator<View> it = this.mScrapViews[i3].iterator();
                    while (it.hasNext()) {
                        it.next().forceLayout();
                    }
                }
            }
            SparseArrayCompat<View> sparseArrayCompat = this.mTransientStateViews;
            if (sparseArrayCompat != null) {
                int m14841a = sparseArrayCompat.m14841a();
                for (int i4 = 0; i4 < m14841a; i4++) {
                    this.mTransientStateViews.m14831e(i4).forceLayout();
                }
            }
        }

        void clear() {
            int i = this.mViewTypeCount;
            if (i == 1) {
                ArrayList<View> arrayList = this.mCurrentScrap;
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    TwoWayView.this.removeDetachedView(arrayList.remove((size - 1) - i2), false);
                }
            } else {
                for (int i3 = 0; i3 < i; i3++) {
                    ArrayList<View> arrayList2 = this.mScrapViews[i3];
                    int size2 = arrayList2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        TwoWayView.this.removeDetachedView(arrayList2.remove((size2 - 1) - i4), false);
                    }
                }
            }
            SparseArrayCompat<View> sparseArrayCompat = this.mTransientStateViews;
            if (sparseArrayCompat != null) {
                sparseArrayCompat.m14838b();
            }
        }

        void fillActiveViews(int i, int i2) {
            if (this.mActiveViews.length < i) {
                this.mActiveViews = new View[i];
            }
            this.mFirstActivePosition = i2;
            View[] viewArr = this.mActiveViews;
            for (int i3 = 0; i3 < i; i3++) {
                viewArr[i3] = TwoWayView.this.getChildAt(i3);
            }
        }

        View getActiveView(int i) {
            int i2 = i - this.mFirstActivePosition;
            View[] viewArr = this.mActiveViews;
            if (i2 < 0 || i2 >= viewArr.length) {
                return null;
            }
            View view = viewArr[i2];
            viewArr[i2] = null;
            return view;
        }

        View getTransientStateView(int i) {
            int m14830f;
            SparseArrayCompat<View> sparseArrayCompat = this.mTransientStateViews;
            if (sparseArrayCompat != null && (m14830f = sparseArrayCompat.m14830f(i)) >= 0) {
                View m14831e = this.mTransientStateViews.m14831e(m14830f);
                this.mTransientStateViews.m14834c(m14830f);
                return m14831e;
            }
            return null;
        }

        void clearTransientStateViews() {
            SparseArrayCompat<View> sparseArrayCompat = this.mTransientStateViews;
            if (sparseArrayCompat != null) {
                sparseArrayCompat.m14838b();
            }
        }

        View getScrapView(int i) {
            if (this.mViewTypeCount != 1) {
                int itemViewType = TwoWayView.this.mAdapter.getItemViewType(i);
                if (itemViewType >= 0) {
                    ArrayList<View>[] arrayListArr = this.mScrapViews;
                    if (itemViewType < arrayListArr.length) {
                        return retrieveFromScrap(arrayListArr[itemViewType], i);
                    }
                    return null;
                }
                return null;
            }
            return retrieveFromScrap(this.mCurrentScrap, i);
        }

        @TargetApi(14)
        void addScrapView(View view, int i) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (layoutParams == null) {
                return;
            }
            layoutParams.scrappedFromPosition = i;
            int i2 = layoutParams.viewType;
            boolean m14629d = ViewCompat.m14629d(view);
            if (!shouldRecycleViewType(i2) || m14629d) {
                if (m14629d) {
                    if (this.mTransientStateViews == null) {
                        this.mTransientStateViews = new SparseArrayCompat<>();
                    }
                    this.mTransientStateViews.m14839a(i, view);
                    return;
                }
                return;
            }
            if (this.mViewTypeCount == 1) {
                this.mCurrentScrap.add(view);
            } else {
                this.mScrapViews[i2].add(view);
            }
            if (Build.VERSION.SDK_INT >= 14) {
                view.setAccessibilityDelegate(null);
            }
            RecyclerListener recyclerListener = this.mRecyclerListener;
            if (recyclerListener != null) {
                recyclerListener.onMovedToScrapHeap(view);
            }
        }

        @TargetApi(14)
        void scrapActiveViews() {
            View[] viewArr = this.mActiveViews;
            boolean z = this.mViewTypeCount > 1;
            ArrayList<View> arrayList = this.mCurrentScrap;
            for (int length = viewArr.length - 1; length >= 0; length--) {
                View view = viewArr[length];
                if (view != null) {
                    LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                    int i = layoutParams.viewType;
                    viewArr[length] = null;
                    boolean m14629d = ViewCompat.m14629d(view);
                    if (shouldRecycleViewType(i) && !m14629d) {
                        if (z) {
                            arrayList = this.mScrapViews[i];
                        }
                        layoutParams.scrappedFromPosition = this.mFirstActivePosition + length;
                        arrayList.add(view);
                        if (Build.VERSION.SDK_INT >= 14) {
                            view.setAccessibilityDelegate(null);
                        }
                        RecyclerListener recyclerListener = this.mRecyclerListener;
                        if (recyclerListener != null) {
                            recyclerListener.onMovedToScrapHeap(view);
                        }
                    } else if (m14629d) {
                        TwoWayView.this.removeDetachedView(view, false);
                        if (this.mTransientStateViews == null) {
                            this.mTransientStateViews = new SparseArrayCompat<>();
                        }
                        this.mTransientStateViews.m14839a(this.mFirstActivePosition + length, view);
                    }
                }
            }
            pruneScrapViews();
        }

        private void pruneScrapViews() {
            int length = this.mActiveViews.length;
            int i = this.mViewTypeCount;
            ArrayList<View>[] arrayListArr = this.mScrapViews;
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                ArrayList<View> arrayList = arrayListArr[i3];
                int size = arrayList.size();
                int i4 = size - length;
                int i5 = size - 1;
                int i6 = 0;
                while (i6 < i4) {
                    TwoWayView.this.removeDetachedView(arrayList.remove(i5), false);
                    i6++;
                    i5--;
                }
            }
            if (this.mTransientStateViews != null) {
                while (i2 < this.mTransientStateViews.m14841a()) {
                    if (!ViewCompat.m14629d(this.mTransientStateViews.m14831e(i2))) {
                        this.mTransientStateViews.m14834c(i2);
                        i2--;
                    }
                    i2++;
                }
            }
        }

        void reclaimScrapViews(List<View> list) {
            int i = this.mViewTypeCount;
            if (i == 1) {
                list.addAll(this.mCurrentScrap);
                return;
            }
            ArrayList<View>[] arrayListArr = this.mScrapViews;
            for (int i2 = 0; i2 < i; i2++) {
                list.addAll(arrayListArr[i2]);
            }
        }

        View retrieveFromScrap(ArrayList<View> arrayList, int i) {
            int size = arrayList.size();
            if (size <= 0) {
                return null;
            }
            for (int i2 = 0; i2 < size; i2++) {
                View view = arrayList.get(i2);
                if (((LayoutParams) view.getLayoutParams()).scrappedFromPosition == i) {
                    arrayList.remove(i2);
                    return view;
                }
            }
            return arrayList.remove(size - 1);
        }
    }

    @Override // android.widget.AdapterView
    public void setEmptyView(View view) {
        super.setEmptyView(view);
        this.mEmptyView = view;
        updateEmptyStatus();
    }

    @Override // android.view.View
    public void setFocusable(boolean z) {
        ListAdapter adapter = getAdapter();
        boolean z2 = true;
        boolean z3 = adapter == null || adapter.getCount() == 0;
        this.mDesiredFocusableState = z;
        if (!z) {
            this.mDesiredFocusableInTouchModeState = false;
        }
        super.setFocusable((!z || z3) ? false : false);
    }

    @Override // android.widget.AdapterView, android.view.View
    public void setFocusableInTouchMode(boolean z) {
        ListAdapter adapter = getAdapter();
        boolean z2 = false;
        boolean z3 = adapter == null || adapter.getCount() == 0;
        this.mDesiredFocusableInTouchModeState = z;
        if (z) {
            this.mDesiredFocusableState = true;
        }
        if (z && !z3) {
            z2 = true;
        }
        super.setFocusableInTouchMode(z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkFocus() {
        ListAdapter adapter = getAdapter();
        boolean z = true;
        boolean z2 = adapter != null && adapter.getCount() > 0;
        super.setFocusableInTouchMode(z2 && this.mDesiredFocusableInTouchModeState);
        super.setFocusable((z2 && this.mDesiredFocusableState) ? false : false);
        if (this.mEmptyView != null) {
            updateEmptyStatus();
        }
    }

    private void updateEmptyStatus() {
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter == null || listAdapter.isEmpty()) {
            View view = this.mEmptyView;
            if (view != null) {
                view.setVisibility(0);
                setVisibility(8);
            } else {
                setVisibility(0);
            }
            if (this.mDataChanged) {
                layout(getLeft(), getTop(), getRight(), getBottom());
                return;
            }
            return;
        }
        View view2 = this.mEmptyView;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class AdapterDataSetObserver extends DataSetObserver {
        private Parcelable mInstanceState;

        private AdapterDataSetObserver() {
            this.mInstanceState = null;
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            TwoWayView.this.mDataChanged = true;
            TwoWayView twoWayView = TwoWayView.this;
            twoWayView.mOldItemCount = twoWayView.mItemCount;
            TwoWayView twoWayView2 = TwoWayView.this;
            twoWayView2.mItemCount = twoWayView2.getAdapter().getCount();
            if (!TwoWayView.this.mHasStableIds || this.mInstanceState == null || TwoWayView.this.mOldItemCount != 0 || TwoWayView.this.mItemCount <= 0) {
                TwoWayView.this.rememberSyncState();
            } else {
                TwoWayView.this.onRestoreInstanceState(this.mInstanceState);
                this.mInstanceState = null;
            }
            TwoWayView.this.checkFocus();
            TwoWayView.this.requestLayout();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            TwoWayView.this.mDataChanged = true;
            if (TwoWayView.this.mHasStableIds) {
                this.mInstanceState = TwoWayView.this.onSaveInstanceState();
            }
            TwoWayView twoWayView = TwoWayView.this;
            twoWayView.mOldItemCount = twoWayView.mItemCount;
            TwoWayView.this.mItemCount = 0;
            TwoWayView.this.mSelectedPosition = -1;
            TwoWayView.this.mSelectedRowId = Long.MIN_VALUE;
            TwoWayView.this.mNextSelectedPosition = -1;
            TwoWayView.this.mNextSelectedRowId = Long.MIN_VALUE;
            TwoWayView.this.mNeedSync = false;
            TwoWayView.this.checkFocus();
            TwoWayView.this.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.artifex.mupdflib.TwoWayView.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        LongSparseArray<Integer> checkIdState;
        SparseBooleanArray checkState;
        int checkedItemCount;
        long firstId;
        int position;
        long selectedId;
        int size;
        int viewStart;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.selectedId = parcel.readLong();
            this.firstId = parcel.readLong();
            this.viewStart = parcel.readInt();
            this.position = parcel.readInt();
            this.size = parcel.readInt();
            this.checkedItemCount = parcel.readInt();
            this.checkState = parcel.readSparseBooleanArray();
            int readInt = parcel.readInt();
            if (readInt > 0) {
                this.checkIdState = new LongSparseArray<>();
                for (int i = 0; i < readInt; i++) {
                    this.checkIdState.m14875a(parcel.readLong(), Integer.valueOf(parcel.readInt()));
                }
            }
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeLong(this.selectedId);
            parcel.writeLong(this.firstId);
            parcel.writeInt(this.viewStart);
            parcel.writeInt(this.position);
            parcel.writeInt(this.size);
            parcel.writeInt(this.checkedItemCount);
            parcel.writeSparseBooleanArray(this.checkState);
            LongSparseArray<Integer> longSparseArray = this.checkIdState;
            int m14874b = longSparseArray != null ? longSparseArray.m14874b() : 0;
            parcel.writeInt(m14874b);
            for (int i2 = 0; i2 < m14874b; i2++) {
                parcel.writeLong(this.checkIdState.m14873b(i2));
                parcel.writeInt(this.checkIdState.m14870c(i2).intValue());
            }
        }

        public String toString() {
            return "TwoWayView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " selectedId=" + this.selectedId + " firstId=" + this.firstId + " viewStart=" + this.viewStart + " size=" + this.size + " position=" + this.position + " checkState=" + this.checkState + "}";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class SelectionNotifier implements Runnable {
        private SelectionNotifier() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TwoWayView.this.mDataChanged) {
                if (TwoWayView.this.mAdapter != null) {
                    TwoWayView.this.post(this);
                    return;
                }
                return;
            }
            TwoWayView.this.fireOnSelected();
            TwoWayView.this.performAccessibilityActionsOnSelected();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class WindowRunnnable {
        private int mOriginalAttachCount;

        private WindowRunnnable() {
        }

        public void rememberWindowAttachCount() {
            this.mOriginalAttachCount = TwoWayView.this.getWindowAttachCount();
        }

        public boolean sameWindow() {
            return TwoWayView.this.hasWindowFocus() && TwoWayView.this.getWindowAttachCount() == this.mOriginalAttachCount;
        }
    }

    /* loaded from: classes.dex */
    class PerformClick extends WindowRunnnable implements Runnable {
        int mClickMotionPosition;

        private PerformClick() {
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            TwoWayView twoWayView;
            View childAt;
            if (TwoWayView.this.mDataChanged) {
                return;
            }
            ListAdapter listAdapter = TwoWayView.this.mAdapter;
            int i = this.mClickMotionPosition;
            if (listAdapter == null || TwoWayView.this.mItemCount <= 0 || i == -1 || i >= listAdapter.getCount() || !sameWindow() || (childAt = (twoWayView = TwoWayView.this).getChildAt(i - twoWayView.mFirstPosition)) == null) {
                return;
            }
            TwoWayView.this.performItemClick(childAt, i, listAdapter.getItemId(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class CheckForTap implements Runnable {
        private CheckForTap() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Drawable current;
            if (TwoWayView.this.mTouchMode != 0) {
                return;
            }
            TwoWayView.this.mTouchMode = 1;
            TwoWayView twoWayView = TwoWayView.this;
            View childAt = twoWayView.getChildAt(twoWayView.mMotionPosition - TwoWayView.this.mFirstPosition);
            if (childAt == null || childAt.hasFocusable()) {
                return;
            }
            TwoWayView.this.mLayoutMode = 0;
            if (TwoWayView.this.mDataChanged) {
                TwoWayView.this.mTouchMode = 2;
                return;
            }
            TwoWayView.this.setPressed(true);
            childAt.setPressed(true);
            TwoWayView.this.layoutChildren();
            TwoWayView twoWayView2 = TwoWayView.this;
            twoWayView2.positionSelector(twoWayView2.mMotionPosition, childAt);
            TwoWayView.this.refreshDrawableState();
            TwoWayView twoWayView3 = TwoWayView.this;
            twoWayView3.positionSelector(twoWayView3.mMotionPosition, childAt);
            TwoWayView.this.refreshDrawableState();
            boolean isLongClickable = TwoWayView.this.isLongClickable();
            if (TwoWayView.this.mSelector != null && (current = TwoWayView.this.mSelector.getCurrent()) != null && (current instanceof TransitionDrawable)) {
                if (isLongClickable) {
                    ((TransitionDrawable) current).startTransition(ViewConfiguration.getLongPressTimeout());
                } else {
                    ((TransitionDrawable) current).resetTransition();
                }
            }
            if (isLongClickable) {
                TwoWayView.this.triggerCheckForLongPress();
            } else {
                TwoWayView.this.mTouchMode = 2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class CheckForLongPress extends WindowRunnnable implements Runnable {
        private CheckForLongPress() {
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            int i = TwoWayView.this.mMotionPosition;
            TwoWayView twoWayView = TwoWayView.this;
            View childAt = twoWayView.getChildAt(i - twoWayView.mFirstPosition);
            if (childAt != null) {
                if ((!sameWindow() || TwoWayView.this.mDataChanged) ? false : TwoWayView.this.performLongPress(childAt, i, TwoWayView.this.mAdapter.getItemId(TwoWayView.this.mMotionPosition))) {
                    TwoWayView.this.mTouchMode = -1;
                    TwoWayView.this.setPressed(false);
                    childAt.setPressed(false);
                    return;
                }
                TwoWayView.this.mTouchMode = 2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class CheckForKeyLongPress extends WindowRunnnable implements Runnable {
        private CheckForKeyLongPress() {
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            if (!TwoWayView.this.isPressed() || TwoWayView.this.mSelectedPosition < 0) {
                return;
            }
            View childAt = TwoWayView.this.getChildAt(TwoWayView.this.mSelectedPosition - TwoWayView.this.mFirstPosition);
            if (!TwoWayView.this.mDataChanged) {
                if (sameWindow()) {
                    TwoWayView twoWayView = TwoWayView.this;
                    z = twoWayView.performLongPress(childAt, twoWayView.mSelectedPosition, TwoWayView.this.mSelectedRowId);
                } else {
                    z = false;
                }
                if (z) {
                    TwoWayView.this.setPressed(false);
                    childAt.setPressed(false);
                    return;
                }
                return;
            }
            TwoWayView.this.setPressed(false);
            if (childAt != null) {
                childAt.setPressed(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class ArrowScrollFocusResult {
        private int mAmountToScroll;
        private int mSelectedPosition;

        private ArrowScrollFocusResult() {
        }

        void populate(int i, int i2) {
            this.mSelectedPosition = i;
            this.mAmountToScroll = i2;
        }

        public int getSelectedPosition() {
            return this.mSelectedPosition;
        }

        public int getAmountToScroll() {
            return this.mAmountToScroll;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class ListItemAccessibilityDelegate extends AccessibilityDelegateCompat {
        private ListItemAccessibilityDelegate() {
        }

        @Override // android.support.p012v4.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            int positionForView = TwoWayView.this.getPositionForView(view);
            ListAdapter adapter = TwoWayView.this.getAdapter();
            if (positionForView == -1 || adapter == null || !TwoWayView.this.isEnabled() || !adapter.isEnabled(positionForView)) {
                return;
            }
            if (positionForView != TwoWayView.this.getSelectedItemPosition()) {
                accessibilityNodeInfoCompat.m14713a(4);
            } else {
                AccessibilityNodeInfoCompat.f737a.mo14682s(accessibilityNodeInfoCompat.f738b);
                accessibilityNodeInfoCompat.m14713a(8);
            }
            if (TwoWayView.this.isClickable()) {
                accessibilityNodeInfoCompat.m14713a(16);
                AccessibilityNodeInfoCompat.f737a.mo14685p(accessibilityNodeInfoCompat.f738b);
            }
            if (TwoWayView.this.isLongClickable()) {
                accessibilityNodeInfoCompat.m14713a(32);
                AccessibilityNodeInfoCompat.f737a.mo14684q(accessibilityNodeInfoCompat.f738b);
            }
        }

        @Override // android.support.p012v4.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            int positionForView = TwoWayView.this.getPositionForView(view);
            ListAdapter adapter = TwoWayView.this.getAdapter();
            if (positionForView == -1 || adapter == null || !TwoWayView.this.isEnabled() || !adapter.isEnabled(positionForView)) {
                return false;
            }
            long itemIdAtPosition = TwoWayView.this.getItemIdAtPosition(positionForView);
            if (i == 4) {
                if (TwoWayView.this.getSelectedItemPosition() != positionForView) {
                    TwoWayView.this.setSelection(positionForView);
                    return true;
                }
                return false;
            } else if (i != 8) {
                return i != 16 ? i == 32 && TwoWayView.this.isLongClickable() && TwoWayView.this.performLongPress(view, positionForView, itemIdAtPosition) : TwoWayView.this.isClickable() && TwoWayView.this.performItemClick(view, positionForView, itemIdAtPosition);
            } else if (TwoWayView.this.getSelectedItemPosition() == positionForView) {
                TwoWayView.this.setSelection(-1);
                return true;
            } else {
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class PositionScroller implements Runnable {
        private static final int MOVE_AFTER_BOUND = 3;
        private static final int MOVE_AFTER_POS = 1;
        private static final int MOVE_BEFORE_BOUND = 4;
        private static final int MOVE_BEFORE_POS = 2;
        private static final int MOVE_OFFSET = 5;
        private static final int SCROLL_DURATION = 200;
        private int mBoundPosition;
        private final int mExtraScroll;
        private int mLastSeenPosition;
        private int mMode;
        private int mOffsetFromStart;
        private int mScrollDuration;
        private int mTargetPosition;

        PositionScroller() {
            this.mExtraScroll = ViewConfiguration.get(TwoWayView.this.mContext).getScaledFadingEdgeLength();
        }

        void start(final int i) {
            int i2;
            stop();
            if (TwoWayView.this.mDataChanged) {
                TwoWayView.this.mPositionScrollAfterLayout = new Runnable() { // from class: com.artifex.mupdflib.TwoWayView.PositionScroller.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PositionScroller.this.start(i);
                    }
                };
                return;
            }
            int childCount = TwoWayView.this.getChildCount();
            if (childCount == 0) {
                return;
            }
            int i3 = TwoWayView.this.mFirstPosition;
            int i4 = (childCount + i3) - 1;
            int max = Math.max(0, Math.min(TwoWayView.this.getCount() - 1, i));
            if (max < i3) {
                i2 = (i3 - max) + 1;
                this.mMode = 2;
            } else if (max > i4) {
                i2 = (max - i4) + 1;
                this.mMode = 1;
            } else {
                scrollToVisible(max, -1, 200);
                return;
            }
            if (i2 > 0) {
                this.mScrollDuration = 200 / i2;
            } else {
                this.mScrollDuration = 200;
            }
            this.mTargetPosition = max;
            this.mBoundPosition = -1;
            this.mLastSeenPosition = -1;
            ViewCompat.m14640a(TwoWayView.this, this);
        }

        void start(final int i, final int i2) {
            int i3;
            stop();
            if (i2 != -1) {
                if (TwoWayView.this.mDataChanged) {
                    TwoWayView.this.mPositionScrollAfterLayout = new Runnable() { // from class: com.artifex.mupdflib.TwoWayView.PositionScroller.2
                        @Override // java.lang.Runnable
                        public void run() {
                            PositionScroller.this.start(i, i2);
                        }
                    };
                    return;
                }
                int childCount = TwoWayView.this.getChildCount();
                if (childCount == 0) {
                    return;
                }
                int i4 = TwoWayView.this.mFirstPosition;
                int i5 = (childCount + i4) - 1;
                int max = Math.max(0, Math.min(TwoWayView.this.getCount() - 1, i));
                if (max < i4) {
                    int i6 = i5 - i2;
                    if (i6 <= 0) {
                        return;
                    }
                    int i7 = (i4 - max) + 1;
                    i3 = i6 - 1;
                    if (i3 < i7) {
                        this.mMode = 4;
                    } else {
                        this.mMode = 2;
                        i3 = i7;
                    }
                } else if (max <= i5) {
                    scrollToVisible(max, i2, 200);
                    return;
                } else {
                    int i8 = i2 - i4;
                    if (i8 <= 0) {
                        return;
                    }
                    i3 = (max - i5) + 1;
                    int i9 = i8 - 1;
                    if (i9 < i3) {
                        this.mMode = 3;
                        i3 = i9;
                    } else {
                        this.mMode = 1;
                    }
                }
                if (i3 > 0) {
                    this.mScrollDuration = 200 / i3;
                } else {
                    this.mScrollDuration = 200;
                }
                this.mTargetPosition = max;
                this.mBoundPosition = i2;
                this.mLastSeenPosition = -1;
                ViewCompat.m14640a(TwoWayView.this, this);
                return;
            }
            start(i);
        }

        void startWithOffset(int i, int i2) {
            startWithOffset(i, i2, 200);
        }

        void startWithOffset(final int i, final int i2, final int i3) {
            int i4;
            stop();
            if (TwoWayView.this.mDataChanged) {
                TwoWayView.this.mPositionScrollAfterLayout = new Runnable() { // from class: com.artifex.mupdflib.TwoWayView.PositionScroller.3
                    @Override // java.lang.Runnable
                    public void run() {
                        PositionScroller.this.startWithOffset(i, i2, i3);
                    }
                };
                return;
            }
            int childCount = TwoWayView.this.getChildCount();
            if (childCount == 0) {
                return;
            }
            int startEdge = i2 + TwoWayView.this.getStartEdge();
            this.mTargetPosition = Math.max(0, Math.min(TwoWayView.this.getCount() - 1, i));
            this.mOffsetFromStart = startEdge;
            this.mBoundPosition = -1;
            this.mLastSeenPosition = -1;
            this.mMode = 5;
            int i5 = TwoWayView.this.mFirstPosition;
            int i6 = (i5 + childCount) - 1;
            int i7 = this.mTargetPosition;
            if (i7 < i5) {
                i4 = i5 - i7;
            } else if (i7 <= i6) {
                TwoWayView.this.smoothScrollBy(TwoWayView.this.getChildStartEdge(TwoWayView.this.getChildAt(i7 - i5)) - startEdge, i3);
                return;
            } else {
                i4 = i7 - i6;
            }
            float f = i4 / childCount;
            if (f >= 1.0f) {
                i3 = (int) (i3 / f);
            }
            this.mScrollDuration = i3;
            this.mLastSeenPosition = -1;
            ViewCompat.m14640a(TwoWayView.this, this);
        }

        void scrollToVisible(int i, int i2, int i3) {
            int childCount = TwoWayView.this.getChildCount();
            int i4 = TwoWayView.this.mFirstPosition;
            int i5 = (childCount + i4) - 1;
            int startEdge = TwoWayView.this.getStartEdge();
            int endEdge = TwoWayView.this.getEndEdge();
            if (i < i4 || i > i5) {
                Log.w(TwoWayView.LOGTAG, "scrollToVisible called with targetPosition " + i + " not visible [" + i4 + ", " + i5 + "]");
            }
            i2 = (i2 < i4 || i2 > i5) ? -1 : -1;
            View childAt = TwoWayView.this.getChildAt(i - i4);
            int childStartEdge = TwoWayView.this.getChildStartEdge(childAt);
            int childEndEdge = TwoWayView.this.getChildEndEdge(childAt);
            int i6 = childEndEdge > endEdge ? childEndEdge - endEdge : 0;
            if (childStartEdge < startEdge) {
                i6 = childStartEdge - startEdge;
            }
            if (i6 == 0) {
                return;
            }
            if (i2 >= 0) {
                View childAt2 = TwoWayView.this.getChildAt(i2 - i4);
                int childStartEdge2 = TwoWayView.this.getChildStartEdge(childAt2);
                int childEndEdge2 = TwoWayView.this.getChildEndEdge(childAt2);
                int abs = Math.abs(i6);
                if (i6 < 0 && childEndEdge2 + abs > endEdge) {
                    i6 = Math.max(0, childEndEdge2 - endEdge);
                } else if (i6 > 0 && childStartEdge2 - abs < startEdge) {
                    i6 = Math.min(0, childStartEdge2 - startEdge);
                }
            }
            TwoWayView.this.smoothScrollBy(i6, i3);
        }

        void stop() {
            TwoWayView.this.removeCallbacks(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            int childStartEdge;
            int availableSize = TwoWayView.this.getAvailableSize();
            int i = TwoWayView.this.mFirstPosition;
            int paddingTop = TwoWayView.this.mIsVertical ? TwoWayView.this.getPaddingTop() : TwoWayView.this.getPaddingLeft();
            int paddingBottom = TwoWayView.this.mIsVertical ? TwoWayView.this.getPaddingBottom() : TwoWayView.this.getPaddingRight();
            int i2 = 0;
            switch (this.mMode) {
                case 1:
                    int childCount = TwoWayView.this.getChildCount() - 1;
                    if (childCount < 0) {
                        return;
                    }
                    int i3 = i + childCount;
                    if (i3 == this.mLastSeenPosition) {
                        ViewCompat.m14640a(TwoWayView.this, this);
                        return;
                    }
                    View childAt = TwoWayView.this.getChildAt(childCount);
                    int childSize = TwoWayView.this.getChildSize(childAt);
                    int childStartEdge2 = availableSize - TwoWayView.this.getChildStartEdge(childAt);
                    if (i3 < TwoWayView.this.mItemCount - 1) {
                        paddingBottom = Math.max(paddingBottom, this.mExtraScroll);
                    }
                    TwoWayView.this.smoothScrollBy((childSize - childStartEdge2) + paddingBottom, this.mScrollDuration);
                    this.mLastSeenPosition = i3;
                    if (i3 < this.mTargetPosition) {
                        ViewCompat.m14640a(TwoWayView.this, this);
                        return;
                    }
                    return;
                case 2:
                    if (i == this.mLastSeenPosition) {
                        ViewCompat.m14640a(TwoWayView.this, this);
                        return;
                    }
                    View childAt2 = TwoWayView.this.getChildAt(0);
                    if (childAt2 == null) {
                        return;
                    }
                    int childStartEdge3 = TwoWayView.this.getChildStartEdge(childAt2);
                    if (i > 0) {
                        paddingTop = Math.max(this.mExtraScroll, paddingTop);
                    }
                    TwoWayView.this.smoothScrollBy(childStartEdge3 - paddingTop, this.mScrollDuration);
                    this.mLastSeenPosition = i;
                    if (i > this.mTargetPosition) {
                        ViewCompat.m14640a(TwoWayView.this, this);
                        return;
                    }
                    return;
                case 3:
                    int childCount2 = TwoWayView.this.getChildCount();
                    if (i == this.mBoundPosition || childCount2 <= 1 || childCount2 + i >= TwoWayView.this.mItemCount) {
                        return;
                    }
                    int i4 = i + 1;
                    if (i4 == this.mLastSeenPosition) {
                        ViewCompat.m14640a(TwoWayView.this, this);
                        return;
                    }
                    View childAt3 = TwoWayView.this.getChildAt(1);
                    int childSize2 = TwoWayView.this.getChildSize(childAt3);
                    int childStartEdge4 = TwoWayView.this.getChildStartEdge(childAt3);
                    int max = Math.max(paddingBottom, this.mExtraScroll);
                    if (i4 < this.mBoundPosition) {
                        TwoWayView.this.smoothScrollBy(Math.max(0, (childSize2 + childStartEdge4) - max), this.mScrollDuration);
                        this.mLastSeenPosition = i4;
                        ViewCompat.m14640a(TwoWayView.this, this);
                        return;
                    } else if (childSize2 > max) {
                        TwoWayView.this.smoothScrollBy(childSize2 - max, this.mScrollDuration);
                        return;
                    } else {
                        return;
                    }
                case 4:
                    int childCount3 = TwoWayView.this.getChildCount() - 2;
                    if (childCount3 < 0) {
                        return;
                    }
                    int i5 = i + childCount3;
                    if (i5 == this.mLastSeenPosition) {
                        ViewCompat.m14640a(TwoWayView.this, this);
                        return;
                    }
                    View childAt4 = TwoWayView.this.getChildAt(childCount3);
                    int childSize3 = TwoWayView.this.getChildSize(childAt4);
                    int childStartEdge5 = TwoWayView.this.getChildStartEdge(childAt4);
                    int i6 = availableSize - childStartEdge5;
                    int max2 = Math.max(paddingTop, this.mExtraScroll);
                    this.mLastSeenPosition = i5;
                    if (i5 > this.mBoundPosition) {
                        TwoWayView.this.smoothScrollBy(-(i6 - max2), this.mScrollDuration);
                        ViewCompat.m14640a(TwoWayView.this, this);
                        return;
                    }
                    int i7 = availableSize - max2;
                    int i8 = childStartEdge5 + childSize3;
                    if (i7 > i8) {
                        TwoWayView.this.smoothScrollBy(-(i7 - i8), this.mScrollDuration);
                        return;
                    }
                    return;
                case 5:
                    if (this.mLastSeenPosition == i) {
                        ViewCompat.m14640a(TwoWayView.this, this);
                        return;
                    }
                    this.mLastSeenPosition = i;
                    int childCount4 = TwoWayView.this.getChildCount();
                    int i9 = this.mTargetPosition;
                    int i10 = (i + childCount4) - 1;
                    if (i9 < i) {
                        i2 = (i - i9) + 1;
                    } else if (i9 > i10) {
                        i2 = i9 - i10;
                    }
                    float min = Math.min(Math.abs(i2 / childCount4), 1.0f);
                    if (i9 < i) {
                        TwoWayView.this.smoothScrollBy((int) ((-TwoWayView.this.getSize()) * min), (int) (this.mScrollDuration * min));
                        ViewCompat.m14640a(TwoWayView.this, this);
                        return;
                    } else if (i9 > i10) {
                        TwoWayView.this.smoothScrollBy((int) (TwoWayView.this.getSize() * min), (int) (this.mScrollDuration * min));
                        ViewCompat.m14640a(TwoWayView.this, this);
                        return;
                    } else {
                        TwoWayView.this.smoothScrollBy(TwoWayView.this.getChildStartEdge(TwoWayView.this.getChildAt(i9 - i)) - this.mOffsetFromStart, (int) (this.mScrollDuration * (Math.abs(childStartEdge) / TwoWayView.this.getSize())));
                        return;
                    }
                default:
                    return;
            }
        }
    }
}
