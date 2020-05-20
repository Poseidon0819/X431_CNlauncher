package com.cnlaunch.x431pro.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Vibrator;
import android.support.p012v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.x431pro.activity.diagnose.p218a.DragGridBaseAdapter;
import java.io.PrintStream;

/* loaded from: classes.dex */
public class DragGridView extends GridView {

    /* renamed from: a */
    private static final String f15962a = "DragGridView";

    /* renamed from: A */
    private ViewPager f15963A;

    /* renamed from: B */
    private View f15964B;

    /* renamed from: C */
    private View f15965C;

    /* renamed from: D */
    private boolean f15966D;

    /* renamed from: E */
    private int f15967E;

    /* renamed from: F */
    private Context f15968F;

    /* renamed from: G */
    private Handler f15969G;

    /* renamed from: H */
    private Runnable f15970H;

    /* renamed from: I */
    private Runnable f15971I;

    /* renamed from: b */
    private long f15972b;

    /* renamed from: c */
    private boolean f15973c;

    /* renamed from: d */
    private int f15974d;

    /* renamed from: e */
    private int f15975e;

    /* renamed from: f */
    private int f15976f;

    /* renamed from: g */
    private int f15977g;

    /* renamed from: h */
    private int f15978h;

    /* renamed from: i */
    private View f15979i;

    /* renamed from: j */
    private ImageView f15980j;

    /* renamed from: k */
    private Vibrator f15981k;

    /* renamed from: l */
    private WindowManager f15982l;

    /* renamed from: m */
    private WindowManager.LayoutParams f15983m;

    /* renamed from: n */
    private Bitmap f15984n;

    /* renamed from: o */
    private int f15985o;

    /* renamed from: p */
    private int f15986p;

    /* renamed from: q */
    private int f15987q;

    /* renamed from: r */
    private int f15988r;

    /* renamed from: s */
    private int f15989s;

    /* renamed from: t */
    private int f15990t;

    /* renamed from: u */
    private int f15991u;

    /* renamed from: v */
    private boolean f15992v;

    /* renamed from: w */
    private DragGridBaseAdapter f15993w;

    /* renamed from: x */
    private int f15994x;

    /* renamed from: y */
    private int f15995y;

    /* renamed from: z */
    private int f15996z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ boolean m4795a(DragGridView dragGridView) {
        dragGridView.f15973c = true;
        return true;
    }

    public DragGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, (byte) 0);
    }

    private DragGridView(Context context, AttributeSet attributeSet, byte b) {
        super(context, attributeSet, 0);
        this.f15972b = 1000L;
        this.f15973c = false;
        this.f15979i = null;
        this.f15992v = true;
        this.f15966D = false;
        this.f15969G = new Handler();
        this.f15970H = new RunnableC2909h(this);
        this.f15971I = new RunnableC2910i(this);
        this.f15981k = (Vibrator) context.getSystemService("vibrator");
        this.f15982l = (WindowManager) context.getSystemService("window");
        this.f15989s = m4797a(context);
        this.f15968F = context;
    }

    public void setDragImage(int i) {
        NLog.m9456a(f15962a, "setDragImage enter.");
        this.f15967E = i;
        this.f15973c = true;
        this.f15981k.vibrate(50L);
        this.f15979i.setVisibility(4);
        m4796a(this.f15984n, this.f15974d, this.f15975e);
    }

    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
        if (listAdapter instanceof DragGridBaseAdapter) {
            this.f15993w = (DragGridBaseAdapter) listAdapter;
        } else {
            NLog.m9451c(f15962a, "the adapter must be implements DragGridAdapter");
        }
    }

    @Override // android.widget.GridView
    public void setNumColumns(int i) {
        super.setNumColumns(i);
        this.f15994x = i;
    }

    @Override // android.widget.GridView
    public void setColumnWidth(int i) {
        super.setColumnWidth(i);
        this.f15995y = i;
    }

    @Override // android.widget.GridView
    public void setHorizontalSpacing(int i) {
        super.setHorizontalSpacing(i);
        this.f15996z = i;
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void setDragResponseMS(long j) {
        this.f15972b = j;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f15974d = (int) motionEvent.getX();
            this.f15975e = (int) motionEvent.getY();
            this.f15978h = pointToPosition(this.f15974d, this.f15975e);
            int i = this.f15978h;
            if (i == -1) {
                return super.dispatchTouchEvent(motionEvent);
            }
            this.f15979i = getChildAt(i - getFirstVisiblePosition());
            String str = f15962a;
            NLog.m9456a(str, "mStartDragItemView init ok,mStartDragItemView=" + this.f15979i);
            this.f15985o = this.f15975e - this.f15979i.getTop();
            this.f15986p = this.f15974d - this.f15979i.getLeft();
            this.f15987q = (int) (motionEvent.getRawY() - this.f15975e);
            this.f15988r = (int) (motionEvent.getRawX() - this.f15974d);
            this.f15990t = getHeight() / 5;
            this.f15991u = (getHeight() * 4) / 5;
            this.f15979i.setDrawingCacheEnabled(true);
            this.f15984n = Bitmap.createBitmap(this.f15979i.getDrawingCache());
            this.f15979i.destroyDrawingCache();
        } else if (action == 2) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            View view = this.f15979i;
            if (view != null) {
                int left = view.getLeft();
                int top = view.getTop();
                if (x >= left && x <= left + view.getWidth() && y >= top) {
                    view.getHeight();
                }
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.f15973c && this.f15980j != null) {
            boolean z2 = false;
            switch (motionEvent.getAction()) {
                case 1:
                    m4793b();
                    this.f15973c = false;
                    break;
                case 2:
                    this.f15976f = (int) motionEvent.getX();
                    this.f15977g = (int) motionEvent.getY();
                    int i = this.f15976f;
                    int i2 = this.f15977g;
                    WindowManager.LayoutParams layoutParams = this.f15983m;
                    layoutParams.x = (i - this.f15986p) + this.f15988r;
                    layoutParams.y = ((i2 - this.f15985o) + this.f15987q) - this.f15989s;
                    this.f15982l.updateViewLayout(this.f15980j, layoutParams);
                    switch (this.f15967E) {
                        case 0:
                            float rawX = motionEvent.getRawX();
                            float rawY = motionEvent.getRawY();
                            View view = this.f15964B;
                            if (view != null) {
                                float x = view.getX();
                                float y = this.f15964B.getY();
                                int width = this.f15964B.getWidth();
                                int height = this.f15964B.getHeight();
                                String str = f15962a;
                                NLog.m9456a(str, "rowX=" + rawX + ",rowY=" + rawY + ",width=" + width + ",height=" + height + ",areaX=" + x + ",areaY=" + y);
                                if (rawX > x && rawX < x + width && rawY > y && rawY < y + height) {
                                    z2 = true;
                                }
                            }
                            PrintStream printStream = System.out;
                            printStream.println("isInDeleteArea=" + z2 + ",isAlreadyAdded=" + this.f15966D);
                            if (z2 && !this.f15966D) {
                                this.f15966D = true;
                                this.f15993w.mo7500a(this.f15978h);
                                break;
                            }
                            break;
                        case 1:
                            float rawX2 = motionEvent.getRawX();
                            float rawY2 = motionEvent.getRawY();
                            NLog.m9456a(f15962a, "onDeleteFavoritesItem enter.");
                            View view2 = this.f15965C;
                            if (view2 != null) {
                                float x2 = view2.getX();
                                float y2 = this.f15965C.getY();
                                int width2 = this.f15965C.getWidth();
                                int height2 = this.f15965C.getHeight();
                                String str2 = f15962a;
                                NLog.m9456a(str2, "isEnterDeleteArea.rowX=" + rawX2 + ",rowY=" + rawY2 + ",width=" + width2 + ",height=" + height2 + ",areaX=" + x2 + ",areaY=" + y2);
                                if (rawX2 > x2 && rawX2 < x2 + width2 && rawY2 > y2 && rawY2 < y2 + height2) {
                                    z = true;
                                    String str3 = f15962a;
                                    NLog.m9456a(str3, "isInDeleteArea=" + z + ",isAlreadyAdded=" + this.f15966D);
                                    if (z && !this.f15966D) {
                                        this.f15966D = true;
                                        this.f15993w.mo7499b(this.f15978h);
                                        break;
                                    }
                                }
                            }
                            z = false;
                            String str32 = f15962a;
                            NLog.m9456a(str32, "isInDeleteArea=" + z + ",isAlreadyAdded=" + this.f15966D);
                            if (z) {
                                this.f15966D = true;
                                this.f15993w.mo7499b(this.f15978h);
                            }
                            break;
                    }
                case 3:
                    m4793b();
                    this.f15973c = false;
                    break;
            }
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m4796a(Bitmap bitmap, int i, int i2) {
        this.f15983m = new WindowManager.LayoutParams();
        WindowManager.LayoutParams layoutParams = this.f15983m;
        layoutParams.format = -3;
        layoutParams.gravity = 51;
        layoutParams.x = (i - this.f15986p) + this.f15988r;
        layoutParams.y = ((i2 - this.f15985o) + this.f15987q) - this.f15989s;
        layoutParams.alpha = 0.55f;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.flags = 24;
        this.f15980j = new ImageView(getContext());
        this.f15980j.setImageBitmap(bitmap);
        this.f15982l.addView(this.f15980j, this.f15983m);
    }

    /* renamed from: a */
    private void m4798a() {
        ImageView imageView = this.f15980j;
        if (imageView != null) {
            this.f15982l.removeView(imageView);
            this.f15980j = null;
        }
    }

    /* renamed from: b */
    private void m4793b() {
        View childAt = getChildAt(this.f15978h - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setVisibility(0);
        }
        m4798a();
        this.f15966D = false;
        this.f15968F.sendBroadcast(new Intent("stopDrag"));
    }

    /* renamed from: a */
    private static int m4797a(Context context) {
        Rect rect = new Rect();
        ((Activity) context).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int i = rect.top;
        if (i == 0) {
            try {
                Class<?> cls = Class.forName("com.android.internal.R$dimen");
                return context.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
            } catch (Exception e) {
                e.printStackTrace();
                return i;
            }
        }
        return i;
    }

    public void setAddDestination(View view) {
        this.f15964B = view;
    }

    public boolean getIsDrag() {
        return this.f15973c;
    }

    public void setViewPager(ViewPager viewPager) {
        this.f15963A = viewPager;
    }

    public void setDeleteDestination(View view) {
        this.f15965C = view;
    }
}
