package com.cnlaunch.x431pro.widget.staggeredgridview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.p012v4.p019d.SparseArrayCompat;
import android.support.p012v4.view.MotionEventCompat;
import android.support.p012v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.Scroller;
import com.mopub.nativeads.MoPubNativeAdPositioning;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.mina.proxy.handlers.http.ntlm.NTLMConstants;

@SuppressLint({"WrongCall"})
/* loaded from: classes.dex */
public abstract class ExtendableListView extends AbsListView {

    /* renamed from: A */
    private int f16816A;

    /* renamed from: B */
    private int f16817B;

    /* renamed from: C */
    private C2969h f16818C;

    /* renamed from: D */
    private C2962a f16819D;

    /* renamed from: E */
    private int f16820E;

    /* renamed from: F */
    private RunnableC2966e f16821F;

    /* renamed from: G */
    private RunnableC2968g f16822G;

    /* renamed from: H */
    private Runnable f16823H;

    /* renamed from: I */
    private RunnableC2963b f16824I;

    /* renamed from: J */
    private ArrayList<C2965d> f16825J;

    /* renamed from: K */
    private ArrayList<C2965d> f16826K;

    /* renamed from: L */
    private AbsListView.OnScrollListener f16827L;

    /* renamed from: M */
    private ListSavedState f16828M;

    /* renamed from: a */
    ListAdapter f16829a;

    /* renamed from: b */
    protected int f16830b;

    /* renamed from: c */
    final boolean[] f16831c;

    /* renamed from: d */
    protected boolean f16832d;

    /* renamed from: e */
    protected int f16833e;

    /* renamed from: f */
    protected int f16834f;

    /* renamed from: g */
    long f16835g;

    /* renamed from: h */
    long f16836h;

    /* renamed from: i */
    boolean f16837i;

    /* renamed from: j */
    private int f16838j;

    /* renamed from: k */
    private int f16839k;

    /* renamed from: l */
    private int f16840l;

    /* renamed from: m */
    private VelocityTracker f16841m;

    /* renamed from: n */
    private int f16842n;

    /* renamed from: o */
    private int f16843o;

    /* renamed from: p */
    private int f16844p;

    /* renamed from: q */
    private boolean f16845q;

    /* renamed from: r */
    private int f16846r;

    /* renamed from: s */
    private int f16847s;

    /* renamed from: t */
    private int f16848t;

    /* renamed from: u */
    private int f16849u;

    /* renamed from: v */
    private int f16850v;

    /* renamed from: w */
    private int f16851w;

    /* renamed from: x */
    private boolean f16852x;

    /* renamed from: y */
    private boolean f16853y;

    /* renamed from: z */
    private boolean f16854z;

    /* renamed from: com.cnlaunch.x431pro.widget.staggeredgridview.ExtendableListView$d */
    /* loaded from: classes.dex */
    public class C2965d {

        /* renamed from: a */
        public View f16864a;

        /* renamed from: b */
        public Object f16865b;

        /* renamed from: c */
        public boolean f16866c;
    }

    /* renamed from: a */
    public void mo4325a() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4322a(int i, boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public void mo4314b(int i, int i2) {
    }

    /* renamed from: b */
    protected boolean mo4316b() {
        return false;
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView
    public View getSelectedView() {
        return null;
    }

    @Override // android.widget.AbsListView, android.view.View
    protected void onFocusChanged(boolean z, int i, Rect rect) {
    }

    @Override // android.widget.AbsListView, android.view.View
    public void onWindowFocusChanged(boolean z) {
    }

    /* renamed from: d */
    static /* synthetic */ int m4363d(ExtendableListView extendableListView) {
        extendableListView.f16838j = 0;
        return 0;
    }

    /* renamed from: g */
    static /* synthetic */ boolean m4351g(ExtendableListView extendableListView) {
        extendableListView.f16854z = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.cnlaunch.x431pro.widget.staggeredgridview.ExtendableListView$b */
    /* loaded from: classes.dex */
    public class RunnableC2963b extends C2970i implements Runnable {
        private RunnableC2963b() {
            super(ExtendableListView.this, (byte) 0);
        }

        /* synthetic */ RunnableC2963b(ExtendableListView extendableListView, byte b) {
            this();
        }

        @Override // java.lang.Runnable
        public final void run() {
            boolean z;
            View childAt = ExtendableListView.this.getChildAt(ExtendableListView.this.f16849u);
            if (childAt != null) {
                int i = ExtendableListView.this.f16849u;
                long itemId = ExtendableListView.this.f16829a.getItemId(ExtendableListView.this.f16849u + ExtendableListView.this.f16830b);
                if (!m4326b() || ExtendableListView.this.f16854z) {
                    z = false;
                } else {
                    ExtendableListView extendableListView = ExtendableListView.this;
                    z = ExtendableListView.m4380a(extendableListView, childAt, i + extendableListView.f16830b, itemId);
                }
                if (z) {
                    ExtendableListView.this.f16839k = 0;
                    ExtendableListView.this.setPressed(false);
                    childAt.setPressed(false);
                    return;
                }
                ExtendableListView.this.f16839k = 5;
            }
        }
    }

    public ExtendableListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f16840l = 0;
        this.f16841m = null;
        this.f16851w = -1;
        this.f16853y = false;
        this.f16831c = new boolean[1];
        this.f16835g = Long.MIN_VALUE;
        this.f16837i = false;
        setWillNotDraw(false);
        setClipToPadding(false);
        setFocusableInTouchMode(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f16842n = viewConfiguration.getScaledTouchSlop();
        this.f16843o = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f16844p = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f16818C = new C2969h();
        this.f16819D = new C2962a();
        this.f16825J = new ArrayList<>();
        this.f16826K = new ArrayList<>();
        this.f16838j = 0;
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ListAdapter listAdapter = this.f16829a;
        if (listAdapter != null) {
            this.f16854z = true;
            this.f16817B = this.f16816A;
            this.f16816A = listAdapter.getCount();
        }
        this.f16852x = true;
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f16818C.m4334a();
        RunnableC2966e runnableC2966e = this.f16821F;
        if (runnableC2966e != null) {
            removeCallbacks(runnableC2966e);
        }
        this.f16852x = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.AbsListView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        mo4323a(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4323a(int i, int i2) {
        if (getChildCount() > 0) {
            m4350h();
            this.f16818C.m4334a();
            this.f16854z = true;
            m4370c();
        }
    }

    @Override // android.widget.AdapterView
    public ListAdapter getAdapter() {
        return this.f16829a;
    }

    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        ListAdapter listAdapter2 = this.f16829a;
        if (listAdapter2 != null) {
            listAdapter2.unregisterDataSetObserver(this.f16819D);
        }
        if (this.f16825J.size() > 0 || this.f16826K.size() > 0) {
            this.f16829a = new HeaderViewListAdapter(this.f16825J, this.f16826K, listAdapter);
        } else {
            this.f16829a = listAdapter;
        }
        this.f16854z = true;
        ListAdapter listAdapter3 = this.f16829a;
        this.f16816A = listAdapter3 != null ? listAdapter3.getCount() : 0;
        ListAdapter listAdapter4 = this.f16829a;
        if (listAdapter4 != null) {
            listAdapter4.registerDataSetObserver(this.f16819D);
            C2969h c2969h = this.f16818C;
            int viewTypeCount = this.f16829a.getViewTypeCount();
            if (viewTypeCount <= 0) {
                throw new IllegalArgumentException("Can't have a viewTypeCount < 1");
            }
            ArrayList<View>[] arrayListArr = new ArrayList[viewTypeCount];
            for (int i = 0; i < viewTypeCount; i++) {
                arrayListArr[i] = new ArrayList<>();
            }
            c2969h.f16877b = viewTypeCount;
            c2969h.f16878c = arrayListArr[0];
            c2969h.f16876a = arrayListArr;
        }
        requestLayout();
    }

    @Override // android.widget.AdapterView
    public int getCount() {
        return this.f16816A;
    }

    @Override // android.widget.AdapterView
    public void setSelection(int i) {
        if (i >= 0) {
            this.f16838j = 2;
            this.f16834f = getListPaddingTop();
            this.f16830b = 0;
            if (this.f16837i) {
                this.f16833e = i;
                this.f16835g = this.f16829a.getItemId(i);
            }
            requestLayout();
        }
    }

    public int getHeaderViewsCount() {
        return this.f16825J.size();
    }

    public int getFooterViewsCount() {
        return this.f16826K.size();
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z) {
        super.setClipToPadding(z);
        this.f16832d = z;
    }

    @Override // android.widget.AbsListView, android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.f16853y || this.f16845q) {
            return;
        }
        super.requestLayout();
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.f16829a == null) {
            return;
        }
        if (z) {
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                getChildAt(i5).forceLayout();
            }
            C2969h c2969h = this.f16818C;
            if (c2969h.f16877b == 1) {
                ArrayList<View> arrayList = c2969h.f16878c;
                int size = arrayList.size();
                for (int i6 = 0; i6 < size; i6++) {
                    arrayList.get(i6).forceLayout();
                }
            } else {
                int i7 = c2969h.f16877b;
                for (int i8 = 0; i8 < i7; i8++) {
                    ArrayList<View> arrayList2 = c2969h.f16876a[i8];
                    int size2 = arrayList2.size();
                    for (int i9 = 0; i9 < size2; i9++) {
                        arrayList2.get(i9).forceLayout();
                    }
                }
            }
            if (c2969h.f16879d != null) {
                int m14841a = c2969h.f16879d.m14841a();
                for (int i10 = 0; i10 < m14841a; i10++) {
                    c2969h.f16879d.m14831e(i10).forceLayout();
                }
            }
        }
        this.f16845q = true;
        layoutChildren();
        this.f16845q = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.AbsListView
    public void layoutChildren() {
        if (this.f16853y) {
            return;
        }
        this.f16853y = true;
        try {
            super.layoutChildren();
            invalidate();
            if (this.f16829a == null) {
                m4344j();
                m4347i();
                return;
            }
            int listPaddingTop = getListPaddingTop();
            int childCount = getChildCount();
            View childAt = this.f16838j == 0 ? getChildAt(0) : null;
            boolean z = this.f16854z;
            if (z) {
                handleDataChanged();
            }
            if (this.f16816A == 0) {
                m4344j();
                m4347i();
            } else if (this.f16816A != this.f16829a.getCount()) {
                throw new IllegalStateException("The content of the adapter has changed but ExtendableListView did not receive a notification. Make sure the content of your adapter is not modified from a background thread, but only from the UI thread. [in ExtendableListView(" + getId() + ", " + getClass() + ") with Adapter(" + this.f16829a.getClass() + ")]");
            } else {
                int i = this.f16830b;
                C2969h c2969h = this.f16818C;
                if (z) {
                    for (int i2 = 0; i2 < childCount; i2++) {
                        c2969h.m4331a(getChildAt(i2), i + i2);
                    }
                } else {
                    c2969h.m4332a(childCount, i);
                }
                detachAllViewsFromParent();
                c2969h.m4330b();
                switch (this.f16838j) {
                    case 1:
                        this.f16830b = 0;
                        mo4325a();
                        m4365d();
                        m4339l(listPaddingTop);
                        m4365d();
                        break;
                    case 2:
                        m4359e(this.f16833e, this.f16834f);
                        break;
                    default:
                        if (childCount == 0) {
                            m4339l(listPaddingTop);
                            break;
                        } else if (this.f16830b < this.f16816A) {
                            int i3 = this.f16830b;
                            if (childAt != null) {
                                listPaddingTop = childAt.getTop();
                            }
                            m4359e(i3, listPaddingTop);
                            break;
                        } else {
                            m4359e(0, listPaddingTop);
                            break;
                        }
                }
                c2969h.m4328c();
                this.f16854z = false;
                this.f16837i = false;
                this.f16838j = 0;
                m4347i();
            }
        } finally {
            this.f16853y = false;
        }
    }

    @Override // android.widget.AbsListView
    protected void handleDataChanged() {
        super.handleDataChanged();
        int i = this.f16816A;
        if (i > 0 && this.f16837i) {
            this.f16837i = false;
            this.f16828M = null;
            this.f16838j = 2;
            this.f16833e = Math.min(Math.max(0, this.f16833e), i - 1);
            return;
        }
        this.f16838j = 1;
        this.f16837i = false;
        this.f16828M = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.AbsListView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        this.f16820E = i;
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        View childAt;
        if (!isEnabled()) {
            return isClickable() || isLongClickable();
        }
        m4355f();
        this.f16841m.addMovement(motionEvent);
        if (m4360e()) {
            int action = motionEvent.getAction() & 255;
            if (action != 6) {
                switch (action) {
                    case 0:
                        int x = (int) motionEvent.getX();
                        int y = (int) motionEvent.getY();
                        int pointToPosition = pointToPosition(x, y);
                        this.f16841m.clear();
                        this.f16851w = MotionEventCompat.m14411b(motionEvent, 0);
                        if (this.f16839k != 2 && !this.f16854z && pointToPosition >= 0 && getAdapter().isEnabled(pointToPosition)) {
                            this.f16839k = 3;
                            if (this.f16823H == null) {
                                this.f16823H = new RunnableC2964c();
                            }
                            postDelayed(this.f16823H, ViewConfiguration.getTapTimeout());
                            if (motionEvent.getEdgeFlags() != 0 && pointToPosition < 0) {
                                z = false;
                                break;
                            }
                        } else if (this.f16839k == 2) {
                            this.f16839k = 1;
                            this.f16848t = 0;
                            pointToPosition = m4343j(y);
                        }
                        this.f16847s = x;
                        this.f16846r = y;
                        this.f16849u = pointToPosition;
                        this.f16850v = NTLMConstants.FLAG_NEGOTIATE_56_BIT_ENCRYPTION;
                        z = true;
                        break;
                    case 1:
                        int i = this.f16839k;
                        if (i != 1) {
                            switch (i) {
                                case 3:
                                case 4:
                                case 5:
                                    int i2 = this.f16849u;
                                    if (i2 >= 0 && (childAt = getChildAt(i2)) != null && !childAt.hasFocusable()) {
                                        if (this.f16839k != 3) {
                                            childAt.setPressed(false);
                                        }
                                        if (this.f16822G == null) {
                                            invalidate();
                                            this.f16822G = new RunnableC2968g(this, (byte) 0);
                                        }
                                        RunnableC2968g runnableC2968g = this.f16822G;
                                        runnableC2968g.f16874a = i2;
                                        runnableC2968g.m4327a();
                                        int i3 = this.f16839k;
                                        if (i3 == 3 || i3 == 4) {
                                            Handler handler = getHandler();
                                            if (handler != null) {
                                                handler.removeCallbacks(this.f16839k == 3 ? this.f16823H : this.f16824I);
                                            }
                                            this.f16838j = 0;
                                            if (!this.f16854z && i2 >= 0 && this.f16829a.isEnabled(i2)) {
                                                this.f16839k = 4;
                                                layoutChildren();
                                                childAt.setPressed(true);
                                                setPressed(true);
                                                postDelayed(new RunnableC2973b(this, childAt, runnableC2968g), ViewConfiguration.getPressedStateDuration());
                                                break;
                                            } else {
                                                this.f16839k = 0;
                                                break;
                                            }
                                        } else if (!this.f16854z && i2 >= 0 && this.f16829a.isEnabled(i2)) {
                                            post(runnableC2968g);
                                        }
                                    }
                                    this.f16839k = 0;
                                    break;
                                default:
                                    setPressed(false);
                                    invalidate();
                                    Handler handler2 = getHandler();
                                    if (handler2 != null) {
                                        handler2.removeCallbacks(this.f16824I);
                                    }
                                    m4353g();
                                    this.f16851w = -1;
                                    break;
                            }
                        } else {
                            if (m4360e()) {
                                if (!(this.f16830b == 0 && getFirstChildTop() >= getListPaddingTop() && this.f16830b + getChildCount() < this.f16816A && getLastChildBottom() <= getHeight() - getListPaddingBottom())) {
                                    this.f16841m.computeCurrentVelocity(1000, this.f16843o);
                                    float yVelocity = this.f16841m.getYVelocity(this.f16851w);
                                    if (Math.abs(yVelocity) > this.f16844p) {
                                        if (this.f16821F == null) {
                                            this.f16821F = new RunnableC2966e();
                                        }
                                        RunnableC2966e runnableC2966e = this.f16821F;
                                        int i4 = (int) (-yVelocity);
                                        int i5 = i4 < 0 ? MoPubNativeAdPositioning.MoPubClientPositioning.NO_REPEAT : 0;
                                        runnableC2966e.f16868b = i5;
                                        runnableC2966e.f16867a.forceFinished(true);
                                        runnableC2966e.f16867a.fling(0, i5, 0, i4, 0, MoPubNativeAdPositioning.MoPubClientPositioning.NO_REPEAT, 0, MoPubNativeAdPositioning.MoPubClientPositioning.NO_REPEAT);
                                        ExtendableListView.this.f16839k = 2;
                                        ViewCompat.m14640a(ExtendableListView.this, runnableC2966e);
                                        this.f16839k = 2;
                                        this.f16846r = 0;
                                        invalidate();
                                    }
                                }
                            }
                            m4350h();
                            m4353g();
                            this.f16839k = 0;
                        }
                        z = true;
                        break;
                    case 2:
                        int m14413a = MotionEventCompat.m14413a(motionEvent, this.f16851w);
                        if (m14413a < 0) {
                            Log.e("ExtendableListView", "onTouchMove could not find pointer with id " + this.f16851w + " - did ExtendableListView receive an inconsistent event stream?");
                            z = false;
                            break;
                        } else {
                            int m14409d = (int) MotionEventCompat.m14409d(motionEvent, m14413a);
                            if (this.f16854z) {
                                layoutChildren();
                            }
                            int i6 = this.f16839k;
                            if (i6 != 1) {
                                switch (i6) {
                                    case 3:
                                    case 4:
                                    case 5:
                                        m4349h(m14409d);
                                        break;
                                }
                            } else {
                                m4346i(m14409d);
                            }
                            z = true;
                            break;
                        }
                    case 3:
                        this.f16839k = 0;
                        setPressed(false);
                        invalidate();
                        Handler handler3 = getHandler();
                        if (handler3 != null) {
                            handler3.removeCallbacks(this.f16824I);
                        }
                        m4353g();
                        this.f16851w = -1;
                        z = true;
                        break;
                    default:
                        z = false;
                        break;
                }
            } else {
                m4385a(motionEvent);
                int i7 = this.f16847s;
                int i8 = this.f16846r;
                int pointToPosition2 = pointToPosition(i7, i8);
                if (pointToPosition2 >= 0) {
                    this.f16849u = pointToPosition2;
                }
                this.f16850v = i8;
                z = true;
            }
            switch (this.f16839k) {
                case 0:
                    m4352g(0);
                    break;
                case 1:
                    m4352g(1);
                    break;
                case 2:
                    m4352g(2);
                    break;
            }
            return z;
        }
        return false;
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.f16852x) {
            int i = action & 255;
            if (i != 6) {
                switch (i) {
                    case 0:
                        int i2 = this.f16839k;
                        int x = (int) motionEvent.getX();
                        int y = (int) motionEvent.getY();
                        this.f16851w = motionEvent.getPointerId(0);
                        int m4343j = m4343j(y);
                        if (i2 != 2 && m4343j >= 0) {
                            this.f16847s = x;
                            this.f16846r = y;
                            this.f16849u = m4343j;
                            this.f16839k = 3;
                        }
                        this.f16850v = NTLMConstants.FLAG_NEGOTIATE_56_BIT_ENCRYPTION;
                        VelocityTracker velocityTracker = this.f16841m;
                        if (velocityTracker == null) {
                            this.f16841m = VelocityTracker.obtain();
                        } else {
                            velocityTracker.clear();
                        }
                        this.f16841m.addMovement(motionEvent);
                        if (i2 == 2) {
                            return true;
                        }
                        break;
                    case 1:
                    case 3:
                        this.f16839k = 0;
                        this.f16851w = -1;
                        m4353g();
                        m4352g(0);
                        break;
                    case 2:
                        if (this.f16839k == 3) {
                            int findPointerIndex = motionEvent.findPointerIndex(this.f16851w);
                            if (findPointerIndex == -1) {
                                this.f16851w = motionEvent.getPointerId(0);
                                findPointerIndex = 0;
                            }
                            m4355f();
                            this.f16841m.addMovement(motionEvent);
                            if (m4349h((int) motionEvent.getY(findPointerIndex))) {
                                return true;
                            }
                        }
                        break;
                }
            } else {
                m4385a(motionEvent);
            }
            return false;
        }
        return false;
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            m4353g();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    /* renamed from: com.cnlaunch.x431pro.widget.staggeredgridview.ExtendableListView$c */
    /* loaded from: classes.dex */
    final class RunnableC2964c implements Runnable {
        RunnableC2964c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (ExtendableListView.this.f16839k == 3) {
                ExtendableListView.this.f16839k = 4;
                ExtendableListView extendableListView = ExtendableListView.this;
                View childAt = extendableListView.getChildAt(extendableListView.f16849u);
                if (childAt == null || childAt.hasFocusable()) {
                    return;
                }
                ExtendableListView.m4363d(ExtendableListView.this);
                if (ExtendableListView.this.f16854z) {
                    ExtendableListView.this.f16839k = 5;
                    return;
                }
                ExtendableListView.this.layoutChildren();
                childAt.setPressed(true);
                ExtendableListView.this.setPressed(true);
                int longPressTimeout = ViewConfiguration.getLongPressTimeout();
                if (ExtendableListView.this.isLongClickable()) {
                    if (ExtendableListView.this.f16824I == null) {
                        ExtendableListView extendableListView2 = ExtendableListView.this;
                        extendableListView2.f16824I = new RunnableC2963b(extendableListView2, (byte) 0);
                    }
                    ExtendableListView.this.f16824I.m4327a();
                    ExtendableListView extendableListView3 = ExtendableListView.this;
                    extendableListView3.postDelayed(extendableListView3.f16824I, longPressTimeout);
                    return;
                }
                ExtendableListView.this.f16839k = 5;
            }
        }
    }

    /* renamed from: a */
    private void m4385a(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() & 65280) >> 8;
        if (motionEvent.getPointerId(action) == this.f16851w) {
            int i = action == 0 ? 1 : 0;
            this.f16847s = (int) motionEvent.getX(i);
            this.f16846r = (int) motionEvent.getY(i);
            this.f16851w = motionEvent.getPointerId(i);
            m4353g();
        }
    }

    /* renamed from: h */
    private boolean m4349h(int i) {
        int i2 = i - this.f16846r;
        int abs = Math.abs(i2);
        int i3 = this.f16842n;
        if (abs > i3) {
            this.f16839k = 1;
            if (i2 <= 0) {
                i3 = -i3;
            }
            this.f16848t = i3;
            Handler handler = getHandler();
            if (handler != null) {
                handler.removeCallbacks(this.f16824I);
            }
            setPressed(false);
            View childAt = getChildAt(this.f16849u - this.f16830b);
            if (childAt != null) {
                childAt.setPressed(false);
            }
            ViewParent parent = getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            m4346i(i);
            return true;
        }
        return false;
    }

    /* renamed from: i */
    private void m4346i(int i) {
        int childCount;
        ViewParent parent;
        int i2 = i - this.f16846r;
        int i3 = i2 - this.f16848t;
        int i4 = this.f16850v;
        if (i4 != Integer.MIN_VALUE) {
            i3 = i - i4;
        }
        if (this.f16839k != 1 || i == this.f16850v) {
            return;
        }
        if (Math.abs(i2) > this.f16842n && (parent = getParent()) != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        int i5 = this.f16849u;
        if (i5 >= 0) {
            childCount = i5 - this.f16830b;
        } else {
            childCount = getChildCount() / 2;
        }
        if (i3 != 0) {
            m4341k(i3);
        }
        if (getChildAt(childCount) != null) {
            this.f16846r = i;
        }
        this.f16850v = i;
    }

    /* renamed from: j */
    private int m4343j(int i) {
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i2 = 0; i2 < childCount; i2++) {
                if (i <= getChildAt(i2).getBottom()) {
                    return this.f16830b + i2;
                }
            }
            return -1;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public boolean m4341k(int i) {
        int i2;
        int i3;
        int min;
        int i4;
        int i5;
        boolean z;
        if (m4360e()) {
            int highestChildTop = getHighestChildTop();
            int lowestChildBottom = getLowestChildBottom();
            if (this.f16832d) {
                i2 = getListPaddingTop();
                i3 = getListPaddingBottom();
            } else {
                i2 = 0;
                i3 = 0;
            }
            int height = getHeight();
            int firstChildTop = i2 - getFirstChildTop();
            int lastChildBottom = getLastChildBottom() - (height - i3);
            int listPaddingBottom = (height - getListPaddingBottom()) - getListPaddingTop();
            if (i < 0) {
                min = Math.max(-(listPaddingBottom - 1), i);
            } else {
                min = Math.min(listPaddingBottom - 1, i);
            }
            int i6 = this.f16830b;
            int listPaddingTop = getListPaddingTop();
            int listPaddingBottom2 = height - getListPaddingBottom();
            int childCount = getChildCount();
            boolean z2 = i6 == 0 && highestChildTop >= listPaddingTop && min >= 0;
            boolean z3 = i6 + childCount == this.f16816A && lowestChildBottom <= listPaddingBottom2 && min <= 0;
            if (z2) {
                return min != 0;
            } else if (z3) {
                return min != 0;
            } else {
                boolean z4 = min < 0;
                int headerViewsCount = getHeaderViewsCount();
                int footerViewsCount = this.f16816A - getFooterViewsCount();
                if (z4) {
                    int i7 = -min;
                    if (this.f16832d) {
                        i7 += getListPaddingTop();
                    }
                    i5 = 0;
                    for (int i8 = 0; i8 < childCount; i8++) {
                        View childAt = getChildAt(i8);
                        if (childAt.getBottom() >= i7) {
                            break;
                        }
                        i5++;
                        int i9 = i6 + i8;
                        if (i9 >= headerViewsCount && i9 < footerViewsCount) {
                            this.f16818C.m4331a(childAt, i9);
                        }
                    }
                    i4 = 0;
                } else {
                    int i10 = height - min;
                    if (this.f16832d) {
                        i10 -= getListPaddingBottom();
                    }
                    i4 = 0;
                    i5 = 0;
                    for (int i11 = childCount - 1; i11 >= 0; i11--) {
                        View childAt2 = getChildAt(i11);
                        if (childAt2.getTop() <= i10) {
                            break;
                        }
                        i5++;
                        int i12 = i6 + i11;
                        if (i12 >= headerViewsCount && i12 < footerViewsCount) {
                            this.f16818C.m4331a(childAt2, i12);
                        }
                        i4 = i11;
                    }
                }
                this.f16853y = true;
                if (i5 > 0) {
                    detachViewsFromParent(i4, i5);
                    this.f16818C.m4330b();
                    mo4314b(i4, i5);
                }
                if (!awakenScrollBars()) {
                    invalidate();
                }
                mo4304f(min);
                if (z4) {
                    this.f16830b += i5;
                }
                int abs = Math.abs(min);
                if (firstChildTop < abs || lastChildBottom < abs) {
                    m4371b(z4);
                    z = false;
                } else {
                    z = false;
                }
                this.f16853y = z;
                m4347i();
                return z;
            }
        }
        return true;
    }

    /* renamed from: b */
    private void m4371b(boolean z) {
        int childCount = getChildCount();
        if (z) {
            int i = this.f16830b + childCount;
            m4369c(i, mo4315b(i));
        } else {
            int i2 = this.f16830b - 1;
            m4364d(i2, mo4313c(i2));
        }
        mo4317a(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4317a(boolean z) {
        if (z) {
            m4337m(getChildCount());
            return;
        }
        int childCount = getChildCount();
        if (this.f16830b != 0 || childCount <= 0) {
            return;
        }
        int highestChildTop = getHighestChildTop();
        int listPaddingTop = getListPaddingTop();
        int top = (getTop() - getBottom()) - getListPaddingBottom();
        int i = highestChildTop - listPaddingTop;
        int lowestChildBottom = getLowestChildBottom();
        int i2 = (this.f16830b + childCount) - 1;
        if (i > 0) {
            int i3 = this.f16816A;
            if (i2 >= i3 - 1 && lowestChildBottom <= top) {
                if (i2 == i3 - 1) {
                    m4365d();
                    return;
                }
                return;
            }
            if (i2 == this.f16816A - 1) {
                i = Math.min(i, lowestChildBottom - top);
            }
            mo4304f(-i);
            if (i2 < this.f16816A - 1) {
                int i4 = i2 + 1;
                m4369c(i4, mo4310d(i4));
                m4365d();
            }
        }
    }

    /* renamed from: c */
    private View m4369c(int i, int i2) {
        int height = getHeight();
        if (this.f16832d) {
            height -= getListPaddingBottom();
        }
        while (i2 < height && i < this.f16816A) {
            m4387a(i, i2, true);
            i++;
            i2 = mo4310d(i);
        }
        return null;
    }

    /* renamed from: d */
    private View m4364d(int i, int i2) {
        int listPaddingTop = this.f16832d ? getListPaddingTop() : 0;
        while (true) {
            if ((i2 > listPaddingTop || mo4316b()) && i >= 0) {
                m4387a(i, i2, false);
                i--;
                i2 = mo4307e(i);
            }
        }
        this.f16830b = i + 1;
        return null;
    }

    /* renamed from: l */
    private View m4339l(int i) {
        this.f16830b = Math.min(this.f16830b, this.f16816A - 1);
        if (this.f16830b < 0) {
            this.f16830b = 0;
        }
        return m4369c(this.f16830b, i);
    }

    /* renamed from: e */
    private View m4359e(int i, int i2) {
        m4387a(i, i2, true);
        this.f16830b = i;
        int i3 = i - 1;
        int mo4307e = mo4307e(i3);
        int i4 = i + 1;
        int mo4310d = mo4310d(i4);
        m4364d(i3, mo4307e);
        m4365d();
        m4369c(i4, mo4310d);
        int childCount = getChildCount();
        if (childCount > 0) {
            m4337m(childCount);
            return null;
        }
        return null;
    }

    /* renamed from: a */
    private View m4387a(int i, int i2, boolean z) {
        View m4333a;
        mo4322a(i, z);
        if (!this.f16854z && (m4333a = this.f16818C.m4333a(i)) != null) {
            m4384a(m4333a, i, i2, z, true);
            return m4333a;
        }
        View m4386a = m4386a(i, this.f16831c);
        m4384a(m4386a, i, i2, z, this.f16831c[0]);
        return m4386a;
    }

    /* renamed from: a */
    private void m4384a(View view, int i, int i2, boolean z, boolean z2) {
        C2967f mo4321a;
        boolean isSelected = view.isSelected();
        int i3 = this.f16839k;
        boolean z3 = i3 > 3 && i3 <= 0 && this.f16849u == i;
        boolean z4 = z3 != view.isPressed();
        boolean z5 = !z2 || isSelected || view.isLayoutRequested();
        int itemViewType = this.f16829a.getItemViewType(i);
        if (itemViewType == -2) {
            mo4321a = m4375b(view);
        } else {
            mo4321a = mo4321a(view);
        }
        mo4321a.f16873d = itemViewType;
        mo4321a.f16871b = i;
        if (z2 || (mo4321a.f16870a && mo4321a.f16873d == -2)) {
            attachViewToParent(view, z ? -1 : 0, mo4321a);
        } else {
            if (mo4321a.f16873d == -2) {
                mo4321a.f16870a = true;
            }
            addViewInLayout(view, z ? -1 : 0, mo4321a, true);
        }
        if (isSelected) {
            view.setSelected(false);
        }
        if (z4) {
            view.setPressed(z3);
        }
        if (z5) {
            mo4318a(view, mo4321a);
        } else {
            cleanupLayoutState(view);
        }
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = z ? i2 : i2 - measuredHeight;
        int mo4324a = mo4324a(i);
        if (z5) {
            mo4319a(view, i, z, mo4324a, i4, mo4324a + measuredWidth, i4 + measuredHeight);
        } else {
            mo4320a(view, i, z, mo4324a, i4);
        }
    }

    /* renamed from: a */
    protected C2967f mo4321a(View view) {
        return m4375b(view);
    }

    /* renamed from: b */
    private static C2967f m4375b(View view) {
        C2967f c2967f;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            c2967f = null;
        } else if (layoutParams instanceof C2967f) {
            c2967f = (C2967f) layoutParams;
        } else {
            c2967f = new C2967f(layoutParams);
        }
        return c2967f == null ? new C2967f() : c2967f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4318a(View view, C2967f c2967f) {
        int makeMeasureSpec;
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(this.f16820E, getListPaddingLeft() + getListPaddingRight(), c2967f.width);
        int i = c2967f.height;
        if (i > 0) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i, NTLMConstants.FLAG_NEGOTIATE_KEY_EXCHANGE);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(childMeasureSpec, makeMeasureSpec);
    }

    /* renamed from: a */
    private View m4386a(int i, boolean[] zArr) {
        zArr[0] = false;
        View m4329b = this.f16818C.m4329b(i);
        if (m4329b != null) {
            View view = this.f16829a.getView(i, m4329b, this);
            if (view != m4329b) {
                this.f16818C.m4331a(m4329b, i);
                return view;
            }
            zArr[0] = true;
            return view;
        }
        return this.f16829a.getView(i, null, this);
    }

    /* renamed from: m */
    private void m4337m(int i) {
        if ((this.f16830b + i) - 1 != this.f16816A - 1 || i <= 0) {
            return;
        }
        int bottom = ((getBottom() - getTop()) - getListPaddingBottom()) - getLowestChildBottom();
        int highestChildTop = getHighestChildTop();
        if (bottom > 0) {
            if (this.f16830b > 0 || highestChildTop < getListPaddingTop()) {
                if (this.f16830b == 0) {
                    bottom = Math.min(bottom, getListPaddingTop() - highestChildTop);
                }
                mo4304f(bottom);
                int i2 = this.f16830b;
                if (i2 > 0) {
                    int i3 = i2 - 1;
                    m4364d(i3, mo4307e(i3));
                    m4365d();
                }
            }
        }
    }

    /* renamed from: d */
    private void m4365d() {
        if (getChildCount() > 0) {
            int highestChildTop = getHighestChildTop() - getListPaddingTop();
            if (highestChildTop < 0) {
                highestChildTop = 0;
            }
            if (highestChildTop != 0) {
                mo4304f(-highestChildTop);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4319a(View view, int i, boolean z, int i2, int i3, int i4, int i5) {
        view.layout(i2, i3, i4, i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4320a(View view, int i, boolean z, int i2, int i3) {
        view.offsetLeftAndRight(i2 - view.getLeft());
        view.offsetTopAndBottom(i3 - view.getTop());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public int mo4324a(int i) {
        return getListPaddingLeft();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public int mo4315b(int i) {
        int childCount = getChildCount();
        return childCount > 0 ? getChildAt(childCount - 1).getBottom() : this.f16832d ? getListPaddingTop() : 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public int mo4313c(int i) {
        return getChildCount() > 0 ? getChildAt(0).getTop() : getHeight() - (this.f16832d ? getListPaddingBottom() : 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: d */
    public int mo4310d(int i) {
        int childCount = getChildCount();
        if (childCount > 0) {
            return getChildAt(childCount - 1).getBottom();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: e */
    public int mo4307e(int i) {
        int childCount = getChildCount();
        if (childCount != 0 && childCount > 0) {
            return getChildAt(0).getTop();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getFirstChildTop() {
        if (m4360e()) {
            return getChildAt(0).getTop();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getHighestChildTop() {
        if (m4360e()) {
            return getChildAt(0).getTop();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getLastChildBottom() {
        if (m4360e()) {
            return getChildAt(getChildCount() - 1).getBottom();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getLowestChildBottom() {
        if (m4360e()) {
            return getChildAt(getChildCount() - 1).getBottom();
        }
        return 0;
    }

    /* renamed from: e */
    private boolean m4360e() {
        return getChildCount() > 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: f */
    public void mo4304f(int i) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            getChildAt(i2).offsetTopAndBottom(i);
        }
    }

    @Override // android.widget.AdapterView
    public int getFirstVisiblePosition() {
        return Math.max(0, this.f16830b - getHeaderViewsCount());
    }

    @Override // android.widget.AdapterView
    public int getLastVisiblePosition() {
        ListAdapter listAdapter;
        return Math.min((this.f16830b + getChildCount()) - 1, this.f16829a != null ? listAdapter.getCount() - 1 : 0);
    }

    /* renamed from: f */
    private void m4355f() {
        if (this.f16841m == null) {
            this.f16841m = VelocityTracker.obtain();
        }
    }

    /* renamed from: g */
    private void m4353g() {
        VelocityTracker velocityTracker = this.f16841m;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f16841m = null;
        }
    }

    /* renamed from: h */
    private void m4350h() {
        RunnableC2966e runnableC2966e = this.f16821F;
        if (runnableC2966e != null) {
            runnableC2966e.m4336a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.cnlaunch.x431pro.widget.staggeredgridview.ExtendableListView$e */
    /* loaded from: classes.dex */
    public class RunnableC2966e implements Runnable {

        /* renamed from: a */
        final Scroller f16867a;

        /* renamed from: b */
        int f16868b;

        RunnableC2966e() {
            this.f16867a = new Scroller(ExtendableListView.this.getContext());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m4336a() {
            this.f16868b = 0;
            ExtendableListView.this.f16839k = 0;
            ExtendableListView.this.m4352g(0);
            ExtendableListView.this.removeCallbacks(this);
            this.f16867a.forceFinished(true);
        }

        @Override // java.lang.Runnable
        public final void run() {
            int max;
            if (ExtendableListView.this.f16839k != 2) {
                return;
            }
            if (ExtendableListView.this.f16816A == 0 || ExtendableListView.this.getChildCount() == 0) {
                m4336a();
                return;
            }
            Scroller scroller = this.f16867a;
            boolean computeScrollOffset = scroller.computeScrollOffset();
            int currY = scroller.getCurrY();
            int i = this.f16868b - currY;
            if (i > 0) {
                ExtendableListView extendableListView = ExtendableListView.this;
                extendableListView.f16849u = extendableListView.f16830b;
                max = Math.min(((ExtendableListView.this.getHeight() - ExtendableListView.this.getPaddingBottom()) - ExtendableListView.this.getPaddingTop()) - 1, i);
            } else {
                ExtendableListView extendableListView2 = ExtendableListView.this;
                extendableListView2.f16849u = extendableListView2.f16830b + (ExtendableListView.this.getChildCount() - 1);
                max = Math.max(-(((ExtendableListView.this.getHeight() - ExtendableListView.this.getPaddingBottom()) - ExtendableListView.this.getPaddingTop()) - 1), i);
            }
            boolean m4341k = ExtendableListView.this.m4341k(max);
            if (computeScrollOffset && !m4341k) {
                ExtendableListView.this.invalidate();
                this.f16868b = currY;
                ViewCompat.m14640a(ExtendableListView.this, this);
                return;
            }
            m4336a();
        }
    }

    @Override // android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        super.setOnScrollListener(onScrollListener);
        this.f16827L = onScrollListener;
    }

    /* renamed from: g */
    final void m4352g(int i) {
        if (i != this.f16840l) {
            this.f16840l = i;
            AbsListView.OnScrollListener onScrollListener = this.f16827L;
            if (onScrollListener != null) {
                onScrollListener.onScrollStateChanged(this, i);
            }
        }
    }

    /* renamed from: i */
    private void m4347i() {
        AbsListView.OnScrollListener onScrollListener = this.f16827L;
        if (onScrollListener != null) {
            onScrollListener.onScroll(this, this.f16830b, getChildCount(), this.f16816A);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.cnlaunch.x431pro.widget.staggeredgridview.ExtendableListView$a */
    /* loaded from: classes.dex */
    public class C2962a extends DataSetObserver {

        /* renamed from: b */
        private Parcelable f16861b = null;

        C2962a() {
        }

        @Override // android.database.DataSetObserver
        public final void onChanged() {
            ExtendableListView.m4351g(ExtendableListView.this);
            ExtendableListView extendableListView = ExtendableListView.this;
            extendableListView.f16817B = extendableListView.f16816A;
            ExtendableListView extendableListView2 = ExtendableListView.this;
            extendableListView2.f16816A = extendableListView2.getAdapter().getCount();
            C2969h c2969h = ExtendableListView.this.f16818C;
            if (c2969h.f16879d != null) {
                c2969h.f16879d.m14838b();
            }
            if (ExtendableListView.this.getAdapter().hasStableIds() && this.f16861b != null && ExtendableListView.this.f16817B == 0 && ExtendableListView.this.f16816A > 0) {
                ExtendableListView.this.onRestoreInstanceState(this.f16861b);
                this.f16861b = null;
            } else {
                ExtendableListView.this.m4370c();
            }
            ExtendableListView.m4342j(ExtendableListView.this);
            ExtendableListView.this.requestLayout();
        }

        @Override // android.database.DataSetObserver
        public final void onInvalidated() {
            ExtendableListView.m4351g(ExtendableListView.this);
            if (ExtendableListView.this.getAdapter().hasStableIds()) {
                this.f16861b = ExtendableListView.this.onSaveInstanceState();
            }
            ExtendableListView extendableListView = ExtendableListView.this;
            extendableListView.f16817B = extendableListView.f16816A;
            ExtendableListView.this.f16816A = 0;
            ExtendableListView extendableListView2 = ExtendableListView.this;
            extendableListView2.f16837i = false;
            ExtendableListView.m4342j(extendableListView2);
            ExtendableListView.this.requestLayout();
        }
    }

    /* renamed from: com.cnlaunch.x431pro.widget.staggeredgridview.ExtendableListView$f */
    /* loaded from: classes.dex */
    public static class C2967f extends AbsListView.LayoutParams {

        /* renamed from: a */
        boolean f16870a;

        /* renamed from: b */
        int f16871b;

        /* renamed from: c */
        long f16872c;

        /* renamed from: d */
        int f16873d;

        public C2967f(int i) {
            super(i, -2);
            this.f16872c = -1L;
        }

        public C2967f() {
            super(-1, -2);
            this.f16872c = -1L;
            this.f16873d = 0;
        }

        public C2967f(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f16872c = -1L;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.cnlaunch.x431pro.widget.staggeredgridview.ExtendableListView$h */
    /* loaded from: classes.dex */
    public class C2969h {

        /* renamed from: a */
        ArrayList<View>[] f16876a;

        /* renamed from: b */
        int f16877b;

        /* renamed from: c */
        ArrayList<View> f16878c;

        /* renamed from: d */
        SparseArrayCompat<View> f16879d;

        /* renamed from: f */
        private int f16881f;

        /* renamed from: g */
        private View[] f16882g = new View[0];

        /* renamed from: h */
        private ArrayList<View> f16883h;

        C2969h() {
        }

        /* renamed from: a */
        final void m4334a() {
            int i = this.f16877b;
            if (i == 1) {
                ArrayList<View> arrayList = this.f16878c;
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ExtendableListView.this.removeDetachedView(arrayList.remove((size - 1) - i2), false);
                }
            } else {
                for (int i3 = 0; i3 < i; i3++) {
                    ArrayList<View> arrayList2 = this.f16876a[i3];
                    int size2 = arrayList2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ExtendableListView.this.removeDetachedView(arrayList2.remove((size2 - 1) - i4), false);
                    }
                }
            }
            SparseArrayCompat<View> sparseArrayCompat = this.f16879d;
            if (sparseArrayCompat != null) {
                sparseArrayCompat.m14838b();
            }
        }

        /* renamed from: a */
        final void m4332a(int i, int i2) {
            if (this.f16882g.length < i) {
                this.f16882g = new View[i];
            }
            this.f16881f = i2;
            View[] viewArr = this.f16882g;
            for (int i3 = 0; i3 < i; i3++) {
                View childAt = ExtendableListView.this.getChildAt(i3);
                C2967f c2967f = (C2967f) childAt.getLayoutParams();
                if (c2967f != null && c2967f.f16873d != -2) {
                    viewArr[i3] = childAt;
                }
            }
        }

        /* renamed from: a */
        final View m4333a(int i) {
            int i2 = i - this.f16881f;
            View[] viewArr = this.f16882g;
            if (i2 < 0 || i2 >= viewArr.length) {
                return null;
            }
            View view = viewArr[i2];
            viewArr[i2] = null;
            return view;
        }

        /* renamed from: b */
        final View m4329b(int i) {
            if (this.f16877b == 1) {
                return ExtendableListView.m4376a(this.f16878c, i);
            }
            int itemViewType = ExtendableListView.this.f16829a.getItemViewType(i);
            if (itemViewType >= 0) {
                ArrayList<View>[] arrayListArr = this.f16876a;
                if (itemViewType < arrayListArr.length) {
                    return ExtendableListView.m4376a(arrayListArr[itemViewType], i);
                }
                return null;
            }
            return null;
        }

        /* renamed from: a */
        final void m4331a(View view, int i) {
            C2967f c2967f = (C2967f) view.getLayoutParams();
            if (c2967f == null) {
                return;
            }
            c2967f.f16871b = i;
            int i2 = c2967f.f16873d;
            boolean m14629d = ViewCompat.m14629d(view);
            if ((i2 >= 0) && !m14629d) {
                if (this.f16877b == 1) {
                    this.f16878c.add(view);
                    return;
                } else {
                    this.f16876a[i2].add(view);
                    return;
                }
            }
            if (i2 != -2 || m14629d) {
                if (this.f16883h == null) {
                    this.f16883h = new ArrayList<>();
                }
                this.f16883h.add(view);
            }
            if (m14629d) {
                if (this.f16879d == null) {
                    this.f16879d = new SparseArrayCompat<>();
                }
                this.f16879d.m14839a(i, view);
            }
        }

        /* renamed from: b */
        final void m4330b() {
            ArrayList<View> arrayList = this.f16883h;
            if (arrayList == null) {
                return;
            }
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ExtendableListView.this.removeDetachedView(this.f16883h.get(i), false);
            }
            this.f16883h.clear();
        }

        /* renamed from: c */
        final void m4328c() {
            View[] viewArr = this.f16882g;
            int i = 0;
            boolean z = this.f16877b > 1;
            ArrayList<View> arrayList = this.f16878c;
            for (int length = viewArr.length - 1; length >= 0; length--) {
                View view = viewArr[length];
                if (view != null) {
                    C2967f c2967f = (C2967f) view.getLayoutParams();
                    viewArr[length] = null;
                    boolean m14629d = ViewCompat.m14629d(view);
                    int i2 = c2967f.f16873d;
                    if (!(i2 >= 0) || m14629d) {
                        if (i2 != -2 || m14629d) {
                            ExtendableListView.this.removeDetachedView(view, false);
                        }
                        if (m14629d) {
                            if (this.f16879d == null) {
                                this.f16879d = new SparseArrayCompat<>();
                            }
                            this.f16879d.m14839a(this.f16881f + length, view);
                        }
                    } else {
                        if (z) {
                            arrayList = this.f16876a[i2];
                        }
                        c2967f.f16871b = this.f16881f + length;
                        arrayList.add(view);
                    }
                }
            }
            int length2 = this.f16882g.length;
            int i3 = this.f16877b;
            ArrayList<View>[] arrayListArr = this.f16876a;
            for (int i4 = 0; i4 < i3; i4++) {
                ArrayList<View> arrayList2 = arrayListArr[i4];
                int size = arrayList2.size();
                int i5 = size - length2;
                int i6 = size - 1;
                int i7 = 0;
                while (i7 < i5) {
                    ExtendableListView.this.removeDetachedView(arrayList2.remove(i6), false);
                    i7++;
                    i6--;
                }
            }
            if (this.f16879d != null) {
                while (i < this.f16879d.m14841a()) {
                    if (!ViewCompat.m14629d(this.f16879d.m14831e(i))) {
                        this.f16879d.m14834c(i);
                        i--;
                    }
                    i++;
                }
            }
        }
    }

    /* renamed from: a */
    static View m4376a(ArrayList<View> arrayList, int i) {
        int size = arrayList.size();
        if (size > 0) {
            for (int i2 = 0; i2 < size; i2++) {
                View view = arrayList.get(i2);
                if (((C2967f) view.getLayoutParams()).f16871b == i) {
                    arrayList.remove(i2);
                    return view;
                }
            }
            return arrayList.remove(size - 1);
        }
        return null;
    }

    /* renamed from: c */
    final void m4370c() {
        if (getChildCount() > 0) {
            this.f16837i = true;
            this.f16836h = getHeight();
            View childAt = getChildAt(0);
            ListAdapter adapter = getAdapter();
            int i = this.f16830b;
            if (i >= 0 && i < adapter.getCount()) {
                this.f16835g = adapter.getItemId(this.f16830b);
            } else {
                this.f16835g = -1L;
            }
            if (childAt != null) {
                this.f16834f = childAt.getTop();
            }
            this.f16833e = this.f16830b;
        }
    }

    /* renamed from: j */
    private void m4344j() {
        m4377a(this.f16825J);
        m4377a(this.f16826K);
        removeAllViewsInLayout();
        this.f16830b = 0;
        this.f16854z = false;
        this.f16818C.m4334a();
        this.f16837i = false;
        this.f16828M = null;
        this.f16838j = 0;
        invalidate();
    }

    /* renamed from: a */
    private static void m4377a(ArrayList<C2965d> arrayList) {
        if (arrayList == null) {
            return;
        }
        Iterator<C2965d> it = arrayList.iterator();
        while (it.hasNext()) {
            ViewGroup.LayoutParams layoutParams = it.next().f16864a.getLayoutParams();
            if (layoutParams instanceof C2967f) {
                ((C2967f) layoutParams).f16870a = false;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class ListSavedState extends ClassLoaderSavedState {
        public static final Parcelable.Creator<ListSavedState> CREATOR = new C2974c();

        /* renamed from: c */
        protected long f16855c;

        /* renamed from: d */
        protected long f16856d;

        /* renamed from: e */
        protected int f16857e;

        /* renamed from: f */
        protected int f16858f;

        /* renamed from: g */
        protected int f16859g;

        public ListSavedState(Parcelable parcelable) {
            super(parcelable, AbsListView.class.getClassLoader());
        }

        public ListSavedState(Parcel parcel) {
            super(parcel);
            this.f16855c = parcel.readLong();
            this.f16856d = parcel.readLong();
            this.f16857e = parcel.readInt();
            this.f16858f = parcel.readInt();
            this.f16859g = parcel.readInt();
        }

        @Override // com.cnlaunch.x431pro.widget.staggeredgridview.ClassLoaderSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeLong(this.f16855c);
            parcel.writeLong(this.f16856d);
            parcel.writeInt(this.f16857e);
            parcel.writeInt(this.f16858f);
            parcel.writeInt(this.f16859g);
        }

        public String toString() {
            return "ExtendableListView.ListSavedState{" + Integer.toHexString(System.identityHashCode(this)) + " selectedId=" + this.f16855c + " firstId=" + this.f16856d + " viewTop=" + this.f16857e + " position=" + this.f16858f + " height=" + this.f16859g + "}";
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public Parcelable onSaveInstanceState() {
        ListSavedState listSavedState = new ListSavedState(super.onSaveInstanceState());
        ListSavedState listSavedState2 = this.f16828M;
        if (listSavedState2 != null) {
            listSavedState.f16855c = listSavedState2.f16855c;
            listSavedState.f16856d = this.f16828M.f16856d;
            listSavedState.f16857e = this.f16828M.f16857e;
            listSavedState.f16858f = this.f16828M.f16858f;
            listSavedState.f16859g = this.f16828M.f16859g;
            return listSavedState;
        }
        boolean z = getChildCount() > 0 && this.f16816A > 0;
        listSavedState.f16855c = getSelectedItemId();
        listSavedState.f16859g = getHeight();
        if (z && this.f16830b > 0) {
            listSavedState.f16857e = getChildAt(0).getTop();
            int i = this.f16830b;
            int i2 = this.f16816A;
            if (i >= i2) {
                i = i2 - 1;
            }
            listSavedState.f16858f = i;
            listSavedState.f16856d = this.f16829a.getItemId(i);
        } else {
            listSavedState.f16857e = 0;
            listSavedState.f16856d = -1L;
            listSavedState.f16858f = 0;
        }
        return listSavedState;
    }

    @Override // android.widget.AbsListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        ListSavedState listSavedState = (ListSavedState) parcelable;
        super.onRestoreInstanceState(listSavedState.f16814b);
        this.f16854z = true;
        this.f16836h = listSavedState.f16859g;
        if (listSavedState.f16856d >= 0) {
            this.f16837i = true;
            this.f16828M = listSavedState;
            this.f16835g = listSavedState.f16856d;
            this.f16833e = listSavedState.f16858f;
            this.f16834f = listSavedState.f16857e;
        }
        requestLayout();
    }

    /* renamed from: com.cnlaunch.x431pro.widget.staggeredgridview.ExtendableListView$g */
    /* loaded from: classes.dex */
    class RunnableC2968g extends C2970i implements Runnable {

        /* renamed from: a */
        int f16874a;

        private RunnableC2968g() {
            super(ExtendableListView.this, (byte) 0);
        }

        /* synthetic */ RunnableC2968g(ExtendableListView extendableListView, byte b) {
            this();
        }

        @Override // java.lang.Runnable
        public final void run() {
            View childAt;
            if (ExtendableListView.this.f16854z) {
                return;
            }
            ListAdapter listAdapter = ExtendableListView.this.f16829a;
            int i = this.f16874a;
            if (listAdapter == null || ExtendableListView.this.f16816A <= 0 || i == -1 || i >= listAdapter.getCount() || !m4326b() || (childAt = ExtendableListView.this.getChildAt(i)) == null) {
                return;
            }
            int i2 = i + ExtendableListView.this.f16830b;
            ExtendableListView.this.performItemClick(childAt, i2, listAdapter.getItemId(i2));
        }
    }

    /* renamed from: com.cnlaunch.x431pro.widget.staggeredgridview.ExtendableListView$i */
    /* loaded from: classes.dex */
    class C2970i {

        /* renamed from: a */
        private int f16884a;

        private C2970i() {
        }

        /* synthetic */ C2970i(ExtendableListView extendableListView, byte b) {
            this();
        }

        /* renamed from: a */
        public final void m4327a() {
            this.f16884a = ExtendableListView.this.getWindowAttachCount();
        }

        /* renamed from: b */
        public final boolean m4326b() {
            return ExtendableListView.this.hasWindowFocus() && ExtendableListView.this.getWindowAttachCount() == this.f16884a;
        }
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    protected /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new C2967f();
    }

    /* renamed from: a */
    static /* synthetic */ boolean m4380a(ExtendableListView extendableListView, View view, int i, long j) {
        AdapterView.OnItemLongClickListener onItemLongClickListener = extendableListView.getOnItemLongClickListener();
        boolean onItemLongClick = onItemLongClickListener != null ? onItemLongClickListener.onItemLongClick(extendableListView, view, i, j) : false;
        if (onItemLongClick) {
            extendableListView.performHapticFeedback(0);
        }
        return onItemLongClick;
    }

    /* renamed from: j */
    static /* synthetic */ void m4342j(ExtendableListView extendableListView) {
        boolean z = extendableListView.getAdapter() == null || extendableListView.getAdapter().isEmpty();
        if (extendableListView.isInFilterMode()) {
            z = false;
        }
        View emptyView = extendableListView.getEmptyView();
        if (z) {
            if (emptyView != null) {
                emptyView.setVisibility(0);
                extendableListView.setVisibility(8);
            } else {
                extendableListView.setVisibility(0);
            }
            if (extendableListView.f16854z) {
                extendableListView.onLayout(false, extendableListView.getLeft(), extendableListView.getTop(), extendableListView.getRight(), extendableListView.getBottom());
                return;
            }
            return;
        }
        if (emptyView != null) {
            emptyView.setVisibility(8);
        }
        extendableListView.setVisibility(0);
    }
}
