package com.cnlaunch.golo3.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Scroller;
import android.widget.TextView;
import com.cnlaunch.golo3.widget.KJListViewFooter;
import com.cnlaunch.golo3.widget.KJListViewHeader;
import com.itextpdf.text.pdf.ColumnText;

/* loaded from: classes.dex */
public class KJListView extends ListView implements AbsListView.OnScrollListener {

    /* renamed from: a */
    private AbsListView.OnScrollListener f8778a;

    /* renamed from: b */
    private KJRefreshListener f8779b;

    /* renamed from: c */
    private KJListViewHeader f8780c;

    /* renamed from: d */
    private TextView f8781d;

    /* renamed from: e */
    private RelativeLayout f8782e;

    /* renamed from: f */
    private KJListViewFooter f8783f;

    /* renamed from: g */
    private RelativeLayout f8784g;

    /* renamed from: h */
    private float f8785h;

    /* renamed from: i */
    private int f8786i;

    /* renamed from: j */
    private int f8787j;

    /* renamed from: k */
    private boolean f8788k;

    /* renamed from: l */
    private boolean f8789l;

    /* renamed from: m */
    private boolean f8790m;

    /* renamed from: n */
    private boolean f8791n;

    /* renamed from: o */
    private boolean f8792o;

    /* renamed from: p */
    private boolean f8793p;

    /* renamed from: q */
    private Scroller f8794q;

    /* renamed from: r */
    private int f8795r;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* renamed from: com.cnlaunch.golo3.widget.KJListView$a */
    /* loaded from: classes.dex */
    public static final class EnumC1658a {
        public static final int SCROLLBACK_HEADER$b77840f = 1;
        public static final int SCROLLBACK_FOOTER$b77840f = 2;

        /* renamed from: a */
        private static final /* synthetic */ int[] f8796a = {SCROLLBACK_HEADER$b77840f, SCROLLBACK_FOOTER$b77840f};

        public static int[] values$b4d18b7() {
            return (int[]) f8796a.clone();
        }
    }

    public KJListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8785h = -1.0f;
        this.f8786i = 50;
        this.f8788k = true;
        this.f8789l = false;
        this.f8790m = false;
        this.f8791n = false;
        this.f8792o = false;
        this.f8793p = false;
        this.f8794q = new Scroller(context, new DecelerateInterpolator());
        super.setOnScrollListener(this);
        this.f8780c = new KJListViewHeader(context);
        this.f8782e = this.f8780c.f8841b;
        this.f8781d = this.f8780c.f8842c;
        addHeaderView(this.f8780c);
        this.f8780c.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver$OnGlobalLayoutListenerC1664a(this));
        this.f8783f = new KJListViewFooter(context);
        this.f8784g = this.f8783f.f8834b;
    }

    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        if (!this.f8792o) {
            this.f8792o = true;
            addFooterView(this.f8783f);
        }
        super.setAdapter(listAdapter);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f8785h == -1.0f) {
            this.f8785h = motionEvent.getRawY();
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f8785h = motionEvent.getRawY();
        } else if (action == 2) {
            try {
                float rawY = motionEvent.getRawY() - this.f8785h;
                this.f8785h = motionEvent.getRawY();
                if (getFirstVisiblePosition() != 0 || (this.f8780c.getVisibleHeight() <= 0 && rawY <= ColumnText.GLOBAL_SPACE_CHAR_RATIO)) {
                    if (getLastVisiblePosition() == this.f8787j - 1 && (this.f8783f.getBottomMargin() > 0 || rawY < ColumnText.GLOBAL_SPACE_CHAR_RATIO)) {
                        int bottomMargin = this.f8783f.getBottomMargin() + ((int) ((-rawY) / 1.8f));
                        if (this.f8790m && !this.f8791n) {
                            if (bottomMargin > 50) {
                                this.f8783f.setState(KJListViewFooter.EnumC1666a.STATE_READY);
                                this.f8793p = true;
                            } else {
                                this.f8783f.setState(KJListViewFooter.EnumC1666a.STATE_NORMAL);
                            }
                        }
                        this.f8783f.setBottomMargin(bottomMargin);
                    }
                } else {
                    this.f8780c.setVisibleHeight(((int) (rawY / 1.8f)) + this.f8780c.getVisibleHeight());
                    if (this.f8788k && !this.f8789l) {
                        if (this.f8780c.getVisibleHeight() > this.f8786i) {
                            this.f8780c.setState(KJListViewHeader.EnumC1667a.STATE_READY);
                            this.f8793p = false;
                        } else {
                            this.f8780c.setState(KJListViewHeader.EnumC1667a.STATE_NORMAL);
                        }
                    }
                    setSelection(0);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            this.f8785h = -1.0f;
            if (getFirstVisiblePosition() == 0) {
                if (this.f8793p) {
                    if (this.f8790m && this.f8783f.getBottomMargin() > 50) {
                        m8980c();
                    }
                    m8982b();
                } else if (this.f8780c.f8840a == KJListViewHeader.EnumC1667a.STATE_REFRESHING) {
                    m8985a();
                } else {
                    if (this.f8788k && this.f8780c.getVisibleHeight() > this.f8786i) {
                        this.f8789l = true;
                        this.f8780c.setState(KJListViewHeader.EnumC1667a.STATE_REFRESHING);
                        if (this.f8779b != null) {
                            KJListViewFooter.EnumC1666a enumC1666a = KJListViewFooter.EnumC1666a.STATE_LOADING;
                        }
                    }
                    m8985a();
                }
            } else if (getLastVisiblePosition() <= this.f8787j) {
                if (this.f8790m && this.f8783f.getBottomMargin() > 50) {
                    m8980c();
                }
                m8982b();
            }
        }
        try {
            return super.onTouchEvent(motionEvent);
        } catch (Exception e2) {
            e2.printStackTrace();
            return true;
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.f8794q.computeScrollOffset()) {
            if (this.f8795r == EnumC1658a.SCROLLBACK_HEADER$b77840f) {
                this.f8780c.setVisibleHeight(this.f8794q.getCurrY());
            } else {
                this.f8783f.setBottomMargin(this.f8794q.getCurrY());
            }
            postInvalidate();
        }
        super.computeScroll();
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        AbsListView.OnScrollListener onScrollListener = this.f8778a;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(absListView, i);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        this.f8787j = i3;
        AbsListView.OnScrollListener onScrollListener = this.f8778a;
        if (onScrollListener != null) {
            onScrollListener.onScroll(absListView, i, i2, i3);
        }
    }

    @Override // android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.f8778a = onScrollListener;
    }

    /* renamed from: a */
    private void m8985a() {
        int i;
        int visibleHeight = this.f8780c.getVisibleHeight();
        if (visibleHeight <= 0) {
            return;
        }
        if (!this.f8789l || visibleHeight > this.f8786i) {
            int i2 = 0;
            if (this.f8789l && visibleHeight > (i = this.f8786i)) {
                i2 = i;
            }
            this.f8795r = EnumC1658a.SCROLLBACK_HEADER$b77840f;
            this.f8794q.startScroll(0, visibleHeight, 0, i2 - visibleHeight, 400);
            invalidate();
        }
    }

    /* renamed from: b */
    private void m8982b() {
        int bottomMargin = this.f8783f.getBottomMargin();
        if (bottomMargin > 0) {
            this.f8795r = EnumC1658a.SCROLLBACK_FOOTER$b77840f;
            this.f8794q.startScroll(0, bottomMargin, 0, -bottomMargin, 400);
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m8980c() {
        this.f8791n = true;
        this.f8783f.setState(KJListViewFooter.EnumC1666a.STATE_LOADING);
        if (this.f8779b == null || this.f8780c.f8840a == KJListViewHeader.EnumC1667a.STATE_REFRESHING) {
            return;
        }
        this.f8793p = false;
    }

    public RelativeLayout getHeadView() {
        return this.f8782e;
    }

    public RelativeLayout getFooterView() {
        return this.f8784g;
    }

    public void setOnRefreshListener(KJRefreshListener kJRefreshListener) {
        this.f8779b = kJRefreshListener;
    }

    public void setHeaderHeight(int i) {
        this.f8786i = i;
    }

    public void setNormalText(String str) {
        this.f8780c.setNormal(str);
    }

    public void setReady(String str) {
        this.f8780c.setReady(str);
    }

    public void setRefreshingText(String str) {
        this.f8780c.setRefreshing(str);
    }

    public void setLoadMoreText(String str) {
        this.f8783f.setRefreshing(str);
    }

    public void setLoadMoreTextFist(String str) {
        this.f8783f.setLoadMoreText(str);
    }

    public void setRefreshTime(String str) {
        this.f8781d.setText(str);
    }

    public void setPullRefreshEnable(boolean z) {
        this.f8788k = z;
        if (!this.f8788k) {
            this.f8782e.setVisibility(8);
        } else {
            this.f8782e.setVisibility(0);
        }
    }

    public void setPullLoadEnable(boolean z) {
        this.f8790m = z;
        if (!this.f8790m) {
            KJListViewFooter kJListViewFooter = this.f8783f;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) kJListViewFooter.f8834b.getLayoutParams();
            layoutParams.height = 0;
            kJListViewFooter.f8834b.setLayoutParams(layoutParams);
            this.f8783f.setOnClickListener(null);
            this.f8784g.setVisibility(8);
            return;
        }
        this.f8791n = false;
        this.f8784g.setVisibility(0);
        KJListViewFooter kJListViewFooter2 = this.f8783f;
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) kJListViewFooter2.f8834b.getLayoutParams();
        layoutParams2.height = -2;
        kJListViewFooter2.f8834b.setLayoutParams(layoutParams2);
        this.f8783f.setState(KJListViewFooter.EnumC1666a.STATE_NORMAL);
        this.f8783f.setOnClickListener(new View$OnClickListenerC1665b(this));
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }
}
