package com.cnlaunch.x431pro.widget.staggeredgridview;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.cnlaunch.x431pro.widget.staggeredgridview.ExtendableListView;
import com.ifoer.expedition.p348a.C3592a;
import com.mopub.nativeads.MoPubNativeAdPositioning;
import java.util.Arrays;
import org.apache.mina.proxy.handlers.http.ntlm.NTLMConstants;

/* loaded from: classes.dex */
public class StaggeredGridView extends ExtendableListView {

    /* renamed from: j */
    private int f16886j;

    /* renamed from: k */
    private int f16887k;

    /* renamed from: l */
    private int f16888l;

    /* renamed from: m */
    private boolean f16889m;

    /* renamed from: n */
    private int f16890n;

    /* renamed from: o */
    private int f16891o;

    /* renamed from: p */
    private SparseArray<GridItemRecord> f16892p;

    /* renamed from: q */
    private int f16893q;

    /* renamed from: r */
    private int f16894r;

    /* renamed from: s */
    private int f16895s;

    /* renamed from: t */
    private int f16896t;

    /* renamed from: u */
    private int[] f16897u;

    /* renamed from: v */
    private int[] f16898v;

    /* renamed from: w */
    private int[] f16899w;

    /* renamed from: x */
    private int f16900x;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class GridItemRecord implements Parcelable {
        public static final Parcelable.Creator<GridItemRecord> CREATOR = new C2975e();

        /* renamed from: a */
        int f16901a;

        /* renamed from: b */
        double f16902b;

        /* renamed from: c */
        boolean f16903c;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ GridItemRecord(Parcel parcel, byte b) {
            this(parcel);
        }

        GridItemRecord() {
        }

        private GridItemRecord(Parcel parcel) {
            this.f16901a = parcel.readInt();
            this.f16902b = parcel.readDouble();
            this.f16903c = parcel.readByte() == 1;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f16901a);
            parcel.writeDouble(this.f16902b);
            parcel.writeByte(this.f16903c ? (byte) 1 : (byte) 0);
        }

        public String toString() {
            return "GridItemRecord.ListSavedState{" + Integer.toHexString(System.identityHashCode(this)) + " column:" + this.f16901a + " heightRatio:" + this.f16902b + " isHeaderFooter:" + this.f16903c + "}";
        }
    }

    public StaggeredGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, (byte) 0);
    }

    private StaggeredGridView(Context context, AttributeSet attributeSet, byte b) {
        super(context, attributeSet);
        this.f16890n = 1;
        this.f16891o = 2;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C3592a.C3593a.StaggeredGridView, 0, 0);
            this.f16886j = obtainStyledAttributes.getInteger(0, 0);
            int i = this.f16886j;
            if (i > 0) {
                this.f16890n = i;
                this.f16891o = i;
            } else {
                this.f16890n = obtainStyledAttributes.getInteger(2, 1);
                this.f16891o = obtainStyledAttributes.getInteger(1, 2);
            }
            this.f16887k = obtainStyledAttributes.getDimensionPixelSize(7, 0);
            this.f16893q = obtainStyledAttributes.getDimensionPixelSize(4, 0);
            this.f16894r = obtainStyledAttributes.getDimensionPixelSize(5, 0);
            this.f16895s = obtainStyledAttributes.getDimensionPixelSize(6, 0);
            this.f16896t = obtainStyledAttributes.getDimensionPixelSize(3, 0);
            obtainStyledAttributes.recycle();
        }
        this.f16886j = 0;
        this.f16897u = new int[0];
        this.f16898v = new int[0];
        this.f16899w = new int[0];
        this.f16892p = new SparseArray<>();
    }

    public int getRowPaddingLeft() {
        return getListPaddingLeft() + this.f16893q;
    }

    public int getRowPaddingRight() {
        return getListPaddingRight() + this.f16894r;
    }

    public int getRowPaddingTop() {
        return getListPaddingTop() + this.f16895s;
    }

    public int getRowPaddingBottom() {
        return getListPaddingBottom() + this.f16896t;
    }

    public void setColumnCountPortrait(int i) {
        this.f16890n = i;
        mo4323a(getWidth(), getHeight());
        m4308e();
    }

    public void setColumnCountLandscape(int i) {
        this.f16891o = i;
        mo4323a(getWidth(), getHeight());
        m4308e();
    }

    public void setColumnCount(int i) {
        this.f16890n = i;
        this.f16891o = i;
        mo4323a(getWidth(), getHeight());
        m4308e();
    }

    /* renamed from: d */
    private boolean m4311d() {
        return getResources().getConfiguration().orientation == 2;
    }

    @Override // com.cnlaunch.x431pro.widget.staggeredgridview.ExtendableListView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f16886j <= 0) {
            this.f16886j = m4311d() ? this.f16891o : this.f16890n;
        }
        this.f16888l = m4296j(getMeasuredWidth());
        int[] iArr = this.f16897u;
        if (iArr == null || iArr.length != this.f16886j) {
            this.f16897u = new int[this.f16886j];
            m4301h();
        }
        int[] iArr2 = this.f16898v;
        if (iArr2 == null || iArr2.length != this.f16886j) {
            this.f16898v = new int[this.f16886j];
            m4299i();
        }
        int[] iArr3 = this.f16899w;
        if (iArr3 == null || iArr3.length != this.f16886j) {
            this.f16899w = new int[this.f16886j];
            m4297j();
        }
    }

    @Override // com.cnlaunch.x431pro.widget.staggeredgridview.ExtendableListView
    /* renamed from: a */
    protected final void mo4318a(View view, ExtendableListView.C2967f c2967f) {
        int makeMeasureSpec;
        int i = c2967f.f16873d;
        int i2 = c2967f.f16871b;
        if (i == -2 || i == -1) {
            super.mo4318a(view, c2967f);
        } else {
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.f16888l, NTLMConstants.FLAG_NEGOTIATE_KEY_EXCHANGE);
            if (c2967f.height > 0) {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(c2967f.height, NTLMConstants.FLAG_NEGOTIATE_KEY_EXCHANGE);
            } else {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(-2, 0);
            }
            view.measure(makeMeasureSpec2, makeMeasureSpec);
        }
        int measuredHeight = view.getMeasuredHeight();
        GridItemRecord m4294l = m4294l(i2);
        double d = measuredHeight;
        double d2 = this.f16888l;
        Double.isNaN(d);
        Double.isNaN(d2);
        m4294l.f16902b = d / d2;
    }

    public int getColumnWidth() {
        return this.f16888l;
    }

    @Override // com.cnlaunch.x431pro.widget.staggeredgridview.ExtendableListView
    /* renamed from: a */
    public final void mo4325a() {
        int i = this.f16886j;
        if (i > 0) {
            if (this.f16897u == null) {
                this.f16897u = new int[i];
            }
            if (this.f16898v == null) {
                this.f16898v = new int[this.f16886j];
            }
            m4302g();
            this.f16892p.clear();
            this.f16889m = false;
            this.f16900x = 0;
            setSelection(0);
        }
    }

    @Override // com.cnlaunch.x431pro.widget.staggeredgridview.ExtendableListView
    /* renamed from: a */
    protected final void mo4322a(int i, boolean z) {
        super.mo4322a(i, z);
        if (m4292n(i)) {
            setPositionIsHeaderFooter(i);
            return;
        }
        int m4293m = m4293m(i);
        int i2 = this.f16886j;
        if (m4293m < 0 || m4293m >= i2) {
            if (z) {
                m4293m = getHighestPositionedBottomColumn();
            } else {
                m4293m = getLowestPositionedTopColumn();
            }
        }
        m4303f(i, m4293m);
    }

    /* renamed from: e */
    private void m4308e() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt != null) {
                childAt.requestLayout();
            }
        }
    }

    @Override // com.cnlaunch.x431pro.widget.staggeredgridview.ExtendableListView
    /* renamed from: a */
    protected final void mo4319a(View view, int i, boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        int measuredHeight;
        int measuredHeight2;
        int i7;
        if (m4292n(i)) {
            if (z) {
                int lowestPositionedBottom = getLowestPositionedBottom();
                measuredHeight2 = lowestPositionedBottom;
                i7 = view.getMeasuredHeight() + lowestPositionedBottom;
            } else {
                int highestPositionedTop = getHighestPositionedTop();
                measuredHeight2 = highestPositionedTop - view.getMeasuredHeight();
                i7 = highestPositionedTop;
            }
            for (int i8 = 0; i8 < this.f16886j; i8++) {
                m4312c(i8, measuredHeight2);
                m4309d(i8, i7);
            }
            super.mo4319a(view, i, z, i2, measuredHeight2, i4, i7);
            return;
        }
        int m4293m = m4293m(i);
        int m4300h = m4300h(i);
        int childBottomMargin = getChildBottomMargin();
        int i9 = m4300h + childBottomMargin;
        if (z) {
            measuredHeight = this.f16898v[m4293m];
            i6 = view.getMeasuredHeight() + i9 + measuredHeight;
        } else {
            i6 = this.f16897u[m4293m];
            measuredHeight = i6 - (view.getMeasuredHeight() + i9);
        }
        ((C2971a) view.getLayoutParams()).f16907e = m4293m;
        m4309d(m4293m, i6);
        m4312c(m4293m, measuredHeight);
        view.layout(i2, measuredHeight + m4300h, i4, i6 - childBottomMargin);
    }

    @Override // com.cnlaunch.x431pro.widget.staggeredgridview.ExtendableListView
    /* renamed from: a */
    protected final void mo4320a(View view, int i, boolean z, int i2, int i3) {
        int i4;
        int measuredHeight;
        int highestPositionedTop;
        int measuredHeight2;
        if (m4292n(i)) {
            if (z) {
                int lowestPositionedBottom = getLowestPositionedBottom();
                highestPositionedTop = view.getMeasuredHeight() + lowestPositionedBottom;
                measuredHeight2 = lowestPositionedBottom;
            } else {
                highestPositionedTop = getHighestPositionedTop();
                measuredHeight2 = highestPositionedTop - view.getMeasuredHeight();
            }
            for (int i5 = 0; i5 < this.f16886j; i5++) {
                m4312c(i5, measuredHeight2);
                m4309d(i5, highestPositionedTop);
            }
            super.mo4320a(view, i, z, i2, measuredHeight2);
            return;
        }
        int m4293m = m4293m(i);
        int m4300h = m4300h(i);
        int childBottomMargin = getChildBottomMargin() + m4300h;
        if (z) {
            measuredHeight = this.f16898v[m4293m];
            i4 = view.getMeasuredHeight() + childBottomMargin + measuredHeight;
        } else {
            i4 = this.f16897u[m4293m];
            measuredHeight = i4 - (view.getMeasuredHeight() + childBottomMargin);
        }
        ((C2971a) view.getLayoutParams()).f16907e = m4293m;
        m4309d(m4293m, i4);
        m4312c(m4293m, measuredHeight);
        super.mo4320a(view, i, z, i2, measuredHeight + m4300h);
    }

    /* renamed from: h */
    private int m4300h(int i) {
        if (i < getHeaderViewsCount() + this.f16886j) {
            return this.f16887k;
        }
        return 0;
    }

    private int getChildBottomMargin() {
        return this.f16887k;
    }

    @Override // com.cnlaunch.x431pro.widget.staggeredgridview.ExtendableListView
    /* renamed from: a */
    protected final ExtendableListView.C2967f mo4321a(View view) {
        C2971a c2971a;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            c2971a = null;
        } else if (layoutParams instanceof C2971a) {
            c2971a = (C2971a) layoutParams;
        } else {
            c2971a = new C2971a(layoutParams);
        }
        return c2971a == null ? new C2971a(this.f16888l) : c2971a;
    }

    /* renamed from: c */
    private void m4312c(int i, int i2) {
        int[] iArr = this.f16897u;
        if (i2 < iArr[i]) {
            iArr[i] = i2;
        }
    }

    /* renamed from: d */
    private void m4309d(int i, int i2) {
        int[] iArr = this.f16898v;
        if (i2 > iArr[i]) {
            iArr[i] = i2;
        }
    }

    @Override // com.cnlaunch.x431pro.widget.staggeredgridview.ExtendableListView
    /* renamed from: a */
    protected final int mo4324a(int i) {
        if (m4292n(i)) {
            return super.mo4324a(i);
        }
        return this.f16899w[m4293m(i)];
    }

    @Override // com.cnlaunch.x431pro.widget.staggeredgridview.ExtendableListView
    /* renamed from: b */
    protected final int mo4315b(int i) {
        if (m4292n(i)) {
            return super.mo4315b(i);
        }
        int m4293m = m4293m(i);
        if (m4293m == -1) {
            return getHighestPositionedBottom();
        }
        return this.f16898v[m4293m];
    }

    @Override // com.cnlaunch.x431pro.widget.staggeredgridview.ExtendableListView
    /* renamed from: d */
    protected final int mo4310d(int i) {
        if (m4292n(i)) {
            return super.mo4310d(i);
        }
        return getHighestPositionedBottom();
    }

    @Override // com.cnlaunch.x431pro.widget.staggeredgridview.ExtendableListView
    /* renamed from: c */
    protected final int mo4313c(int i) {
        if (m4292n(i)) {
            return super.mo4313c(i);
        }
        int m4293m = m4293m(i);
        if (m4293m == -1) {
            return getLowestPositionedTop();
        }
        return this.f16897u[m4293m];
    }

    @Override // com.cnlaunch.x431pro.widget.staggeredgridview.ExtendableListView
    /* renamed from: e */
    protected final int mo4307e(int i) {
        if (m4292n(i)) {
            return super.mo4307e(i);
        }
        return getLowestPositionedTop();
    }

    @Override // com.cnlaunch.x431pro.widget.staggeredgridview.ExtendableListView
    protected int getLastChildBottom() {
        if (m4292n(this.f16830b + (getChildCount() - 1))) {
            return super.getLastChildBottom();
        }
        return getHighestPositionedBottom();
    }

    @Override // com.cnlaunch.x431pro.widget.staggeredgridview.ExtendableListView
    protected int getFirstChildTop() {
        if (m4292n(this.f16830b)) {
            return super.getFirstChildTop();
        }
        return getLowestPositionedTop();
    }

    @Override // com.cnlaunch.x431pro.widget.staggeredgridview.ExtendableListView
    protected int getHighestChildTop() {
        if (m4292n(this.f16830b)) {
            return super.getHighestChildTop();
        }
        return getHighestPositionedTop();
    }

    @Override // com.cnlaunch.x431pro.widget.staggeredgridview.ExtendableListView
    protected int getLowestChildBottom() {
        if (m4292n(this.f16830b + (getChildCount() - 1))) {
            return super.getLowestChildBottom();
        }
        return getLowestPositionedBottom();
    }

    @Override // com.cnlaunch.x431pro.widget.staggeredgridview.ExtendableListView
    /* renamed from: f */
    protected final void mo4304f(int i) {
        super.mo4304f(i);
        m4298i(i);
        this.f16900x += i;
    }

    public int getDistanceToTop() {
        return this.f16900x;
    }

    /* renamed from: i */
    private void m4298i(int i) {
        if (i != 0) {
            for (int i2 = 0; i2 < this.f16886j; i2++) {
                m4306e(i, i2);
            }
        }
    }

    /* renamed from: e */
    private void m4306e(int i, int i2) {
        if (i != 0) {
            int[] iArr = this.f16897u;
            iArr[i2] = iArr[i2] + i;
            int[] iArr2 = this.f16898v;
            iArr2[i2] = iArr2[i2] + i;
        }
    }

    @Override // com.cnlaunch.x431pro.widget.staggeredgridview.ExtendableListView
    /* renamed from: a */
    protected final void mo4317a(boolean z) {
        super.mo4317a(z);
        if (z || this.f16830b != getHeaderViewsCount()) {
            return;
        }
        int[] highestNonHeaderTops = getHighestNonHeaderTops();
        int i = MoPubNativeAdPositioning.MoPubClientPositioning.NO_REPEAT;
        boolean z2 = true;
        int i2 = -1;
        for (int i3 = 0; i3 < highestNonHeaderTops.length; i3++) {
            if (z2 && i3 > 0 && highestNonHeaderTops[i3] != i) {
                z2 = false;
            }
            if (highestNonHeaderTops[i3] < i) {
                i = highestNonHeaderTops[i3];
                i2 = i3;
            }
        }
        if (z2) {
            return;
        }
        for (int i4 = 0; i4 < highestNonHeaderTops.length; i4++) {
            if (i4 != i2) {
                int i5 = i - highestNonHeaderTops[i4];
                int childCount = getChildCount();
                for (int i6 = 0; i6 < childCount; i6++) {
                    View childAt = getChildAt(i6);
                    if (childAt != null && childAt.getLayoutParams() != null && (childAt.getLayoutParams() instanceof C2971a) && ((C2971a) childAt.getLayoutParams()).f16907e == i4) {
                        childAt.offsetTopAndBottom(i5);
                    }
                }
                m4306e(i5, i4);
            }
        }
        invalidate();
    }

    private int[] getHighestNonHeaderTops() {
        int[] iArr = new int[this.f16886j];
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt != null && childAt.getLayoutParams() != null && (childAt.getLayoutParams() instanceof C2971a)) {
                    C2971a c2971a = (C2971a) childAt.getLayoutParams();
                    if (c2971a.f16873d != -2 && childAt.getTop() < iArr[c2971a.f16907e]) {
                        iArr[c2971a.f16907e] = childAt.getTop();
                    }
                }
            }
        }
        return iArr;
    }

    @Override // com.cnlaunch.x431pro.widget.staggeredgridview.ExtendableListView
    /* renamed from: b */
    protected final void mo4314b(int i, int i2) {
        super.mo4314b(i, i2);
        Arrays.fill(this.f16897u, (int) MoPubNativeAdPositioning.MoPubClientPositioning.NO_REPEAT);
        Arrays.fill(this.f16898v, 0);
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if (childAt != null) {
                ExtendableListView.C2967f c2967f = (ExtendableListView.C2967f) childAt.getLayoutParams();
                if (c2967f.f16873d != -2 && (c2967f instanceof C2971a)) {
                    C2971a c2971a = (C2971a) c2967f;
                    int i4 = c2971a.f16907e;
                    int i5 = c2971a.f16871b;
                    int top = childAt.getTop();
                    int[] iArr = this.f16897u;
                    if (top < iArr[i4]) {
                        iArr[i4] = top - m4300h(i5);
                    }
                    int bottom = childAt.getBottom();
                    int[] iArr2 = this.f16898v;
                    if (bottom > iArr2[i4]) {
                        iArr2[i4] = bottom + getChildBottomMargin();
                    }
                } else {
                    int top2 = childAt.getTop();
                    int bottom2 = childAt.getBottom();
                    for (int i6 = 0; i6 < this.f16886j; i6++) {
                        int[] iArr3 = this.f16897u;
                        if (top2 < iArr3[i6]) {
                            iArr3[i6] = top2;
                        }
                        int[] iArr4 = this.f16898v;
                        if (bottom2 > iArr4[i6]) {
                            iArr4[i6] = bottom2;
                        }
                    }
                }
            }
        }
    }

    @Override // com.cnlaunch.x431pro.widget.staggeredgridview.ExtendableListView
    /* renamed from: b */
    protected final boolean mo4316b() {
        return getLowestPositionedTop() > (this.f16832d ? getRowPaddingTop() : 0);
    }

    @Override // com.cnlaunch.x431pro.widget.staggeredgridview.ExtendableListView, android.widget.AbsListView, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        mo4323a(i, i2);
    }

    @Override // com.cnlaunch.x431pro.widget.staggeredgridview.ExtendableListView
    /* renamed from: a */
    protected final void mo4323a(int i, int i2) {
        super.mo4323a(i, i2);
        int i3 = m4311d() ? this.f16891o : this.f16890n;
        if (this.f16886j != i3) {
            this.f16886j = i3;
            this.f16888l = m4296j(i);
            int i4 = this.f16886j;
            this.f16897u = new int[i4];
            this.f16898v = new int[i4];
            this.f16899w = new int[i4];
            this.f16900x = 0;
            m4302g();
            m4297j();
            if (getCount() > 0 && this.f16892p.size() > 0) {
                m4305f();
            }
            requestLayout();
        }
    }

    /* renamed from: j */
    private int m4296j(int i) {
        int rowPaddingLeft = i - (getRowPaddingLeft() + getRowPaddingRight());
        int i2 = this.f16887k;
        int i3 = this.f16886j;
        return (rowPaddingLeft - (i2 * (i3 + 1))) / i3;
    }

    /* renamed from: k */
    private int m4295k(int i) {
        int rowPaddingLeft = getRowPaddingLeft();
        int i2 = this.f16887k;
        return rowPaddingLeft + i2 + ((i2 + this.f16888l) * i);
    }

    /* renamed from: f */
    private void m4305f() {
        int min = Math.min(this.f16833e, getCount() - 1);
        SparseArray sparseArray = new SparseArray(min);
        for (int i = 0; i < min; i++) {
            GridItemRecord gridItemRecord = this.f16892p.get(i);
            if (gridItemRecord == null) {
                break;
            }
            Log.d("StaggeredGridView", "onColumnSync:" + i + " ratio:" + gridItemRecord.f16902b);
            sparseArray.append(i, Double.valueOf(gridItemRecord.f16902b));
        }
        this.f16892p.clear();
        for (int i2 = 0; i2 < min; i2++) {
            Double d = (Double) sparseArray.get(i2);
            if (d == null) {
                break;
            }
            GridItemRecord m4294l = m4294l(i2);
            double d2 = this.f16888l;
            double doubleValue = d.doubleValue();
            Double.isNaN(d2);
            int i3 = (int) (d2 * doubleValue);
            m4294l.f16902b = d.doubleValue();
            if (m4292n(i2)) {
                int lowestPositionedBottom = getLowestPositionedBottom();
                int i4 = i3 + lowestPositionedBottom;
                for (int i5 = 0; i5 < this.f16886j; i5++) {
                    this.f16897u[i5] = lowestPositionedBottom;
                    this.f16898v[i5] = i4;
                }
            } else {
                int highestPositionedBottomColumn = getHighestPositionedBottomColumn();
                int i6 = this.f16898v[highestPositionedBottomColumn];
                int m4300h = i3 + i6 + m4300h(i2) + getChildBottomMargin();
                this.f16897u[highestPositionedBottomColumn] = i6;
                this.f16898v[highestPositionedBottomColumn] = m4300h;
                m4294l.f16901a = highestPositionedBottomColumn;
            }
        }
        int highestPositionedBottomColumn2 = getHighestPositionedBottomColumn();
        m4303f(min, highestPositionedBottomColumn2);
        int i7 = -this.f16898v[highestPositionedBottomColumn2];
        m4298i(this.f16834f + i7);
        this.f16900x = i7;
        System.arraycopy(this.f16898v, 0, this.f16897u, 0, this.f16886j);
    }

    /* renamed from: f */
    private void m4303f(int i, int i2) {
        m4294l(i).f16901a = i2;
    }

    private void setPositionIsHeaderFooter(int i) {
        m4294l(i).f16903c = true;
    }

    /* renamed from: l */
    private GridItemRecord m4294l(int i) {
        GridItemRecord gridItemRecord = this.f16892p.get(i, null);
        if (gridItemRecord == null) {
            GridItemRecord gridItemRecord2 = new GridItemRecord();
            this.f16892p.append(i, gridItemRecord2);
            return gridItemRecord2;
        }
        return gridItemRecord;
    }

    /* renamed from: m */
    private int m4293m(int i) {
        GridItemRecord gridItemRecord = this.f16892p.get(i, null);
        if (gridItemRecord != null) {
            return gridItemRecord.f16901a;
        }
        return -1;
    }

    /* renamed from: n */
    private boolean m4292n(int i) {
        return this.f16829a.getItemViewType(i) == -2;
    }

    /* renamed from: g */
    private void m4302g() {
        m4301h();
        m4299i();
    }

    /* renamed from: h */
    private void m4301h() {
        Arrays.fill(this.f16897u, getPaddingTop() + this.f16895s);
    }

    /* renamed from: i */
    private void m4299i() {
        Arrays.fill(this.f16898v, getPaddingTop() + this.f16895s);
    }

    /* renamed from: j */
    private void m4297j() {
        for (int i = 0; i < this.f16886j; i++) {
            this.f16899w[i] = m4295k(i);
        }
    }

    private int getHighestPositionedBottom() {
        return this.f16898v[getHighestPositionedBottomColumn()];
    }

    private int getHighestPositionedBottomColumn() {
        int i = 0;
        int i2 = MoPubNativeAdPositioning.MoPubClientPositioning.NO_REPEAT;
        for (int i3 = 0; i3 < this.f16886j; i3++) {
            int i4 = this.f16898v[i3];
            if (i4 < i2) {
                i = i3;
                i2 = i4;
            }
        }
        return i;
    }

    private int getLowestPositionedBottom() {
        return this.f16898v[getLowestPositionedBottomColumn()];
    }

    private int getLowestPositionedBottomColumn() {
        int i = 0;
        int i2 = NTLMConstants.FLAG_NEGOTIATE_56_BIT_ENCRYPTION;
        for (int i3 = 0; i3 < this.f16886j; i3++) {
            int i4 = this.f16898v[i3];
            if (i4 > i2) {
                i = i3;
                i2 = i4;
            }
        }
        return i;
    }

    private int getLowestPositionedTop() {
        return this.f16897u[getLowestPositionedTopColumn()];
    }

    private int getLowestPositionedTopColumn() {
        int i = 0;
        int i2 = NTLMConstants.FLAG_NEGOTIATE_56_BIT_ENCRYPTION;
        for (int i3 = 0; i3 < this.f16886j; i3++) {
            int i4 = this.f16897u[i3];
            if (i4 > i2) {
                i = i3;
                i2 = i4;
            }
        }
        return i;
    }

    private int getHighestPositionedTop() {
        return this.f16897u[getHighestPositionedTopColumn()];
    }

    private int getHighestPositionedTopColumn() {
        int i = 0;
        int i2 = MoPubNativeAdPositioning.MoPubClientPositioning.NO_REPEAT;
        for (int i3 = 0; i3 < this.f16886j; i3++) {
            int i4 = this.f16897u[i3];
            if (i4 < i2) {
                i = i3;
                i2 = i4;
            }
        }
        return i;
    }

    /* renamed from: com.cnlaunch.x431pro.widget.staggeredgridview.StaggeredGridView$a */
    /* loaded from: classes.dex */
    public static class C2971a extends ExtendableListView.C2967f {

        /* renamed from: e */
        int f16907e;

        public C2971a(int i) {
            super(i);
            m4291a();
        }

        public C2971a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            m4291a();
        }

        /* renamed from: a */
        private void m4291a() {
            if (this.width != -1) {
                this.width = -1;
            }
            if (this.height == -1) {
                this.height = -2;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class GridListSavedState extends ExtendableListView.ListSavedState {
        public static final Parcelable.Creator<GridListSavedState> CREATOR = new C2976f();

        /* renamed from: h */
        int f16904h;

        /* renamed from: i */
        int[] f16905i;

        /* renamed from: j */
        SparseArray f16906j;

        public GridListSavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public GridListSavedState(Parcel parcel) {
            super(parcel);
            this.f16904h = parcel.readInt();
            int i = this.f16904h;
            this.f16905i = new int[i < 0 ? 0 : i];
            parcel.readIntArray(this.f16905i);
            this.f16906j = parcel.readSparseArray(GridItemRecord.class.getClassLoader());
        }

        @Override // com.cnlaunch.x431pro.widget.staggeredgridview.ExtendableListView.ListSavedState, com.cnlaunch.x431pro.widget.staggeredgridview.ClassLoaderSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f16904h);
            parcel.writeIntArray(this.f16905i);
            parcel.writeSparseArray(this.f16906j);
        }

        @Override // com.cnlaunch.x431pro.widget.staggeredgridview.ExtendableListView.ListSavedState
        public String toString() {
            return "StaggeredGridView.GridListSavedState{" + Integer.toHexString(System.identityHashCode(this)) + "}";
        }
    }

    @Override // com.cnlaunch.x431pro.widget.staggeredgridview.ExtendableListView, android.widget.AbsListView, android.view.View
    public Parcelable onSaveInstanceState() {
        ExtendableListView.ListSavedState listSavedState = (ExtendableListView.ListSavedState) super.onSaveInstanceState();
        GridListSavedState gridListSavedState = new GridListSavedState(listSavedState.f16814b);
        gridListSavedState.f16855c = listSavedState.f16855c;
        gridListSavedState.f16856d = listSavedState.f16856d;
        gridListSavedState.f16857e = listSavedState.f16857e;
        gridListSavedState.f16858f = listSavedState.f16858f;
        gridListSavedState.f16859g = listSavedState.f16859g;
        if ((getChildCount() > 0 && getCount() > 0) && this.f16830b > 0) {
            gridListSavedState.f16904h = this.f16886j;
            gridListSavedState.f16905i = this.f16897u;
            gridListSavedState.f16906j = this.f16892p;
        } else {
            int i = this.f16886j;
            if (i < 0) {
                i = 0;
            }
            gridListSavedState.f16904h = i;
            gridListSavedState.f16905i = new int[gridListSavedState.f16904h];
            gridListSavedState.f16906j = new SparseArray();
        }
        return gridListSavedState;
    }

    @Override // com.cnlaunch.x431pro.widget.staggeredgridview.ExtendableListView, android.widget.AbsListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        GridListSavedState gridListSavedState = (GridListSavedState) parcelable;
        this.f16886j = gridListSavedState.f16904h;
        this.f16897u = gridListSavedState.f16905i;
        this.f16898v = new int[this.f16886j];
        this.f16892p = gridListSavedState.f16906j;
        this.f16889m = true;
        super.onRestoreInstanceState(gridListSavedState);
    }

    @Override // com.cnlaunch.x431pro.widget.staggeredgridview.ExtendableListView, android.widget.AbsListView
    protected void layoutChildren() {
        if (!this.f16889m) {
            Arrays.fill(this.f16898v, 0);
        } else {
            this.f16889m = false;
        }
        System.arraycopy(this.f16897u, 0, this.f16898v, 0, this.f16886j);
        super.layoutChildren();
    }
}
