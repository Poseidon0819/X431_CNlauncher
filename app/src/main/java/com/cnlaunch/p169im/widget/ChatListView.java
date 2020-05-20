package com.cnlaunch.p169im.widget;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;
import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceConstant;
import com.cnlaunch.p169im.p173d.GoloHandler;
import com.ifoer.expedition.pro.R;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfBoolean;

/* renamed from: com.cnlaunch.im.widget.ChatListView */
/* loaded from: classes.dex */
public class ChatListView extends ListView implements AbsListView.OnScrollListener {

    /* renamed from: a */
    public View f9317a;

    /* renamed from: b */
    public int f9318b;

    /* renamed from: c */
    public int f9319c;

    /* renamed from: d */
    private final int f9320d;

    /* renamed from: e */
    private final int f9321e;

    /* renamed from: f */
    private final int f9322f;

    /* renamed from: g */
    private final int f9323g;

    /* renamed from: h */
    private View f9324h;

    /* renamed from: i */
    private boolean f9325i;

    /* renamed from: j */
    private double f9326j;

    /* renamed from: k */
    private double f9327k;

    /* renamed from: l */
    private float f9328l;

    /* renamed from: m */
    private boolean f9329m;

    /* renamed from: n */
    private boolean f9330n;

    /* renamed from: o */
    private GoloHandler f9331o;

    /* renamed from: p */
    private float f9332p;

    /* renamed from: q */
    private float f9333q;

    /* renamed from: r */
    private float f9334r;

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    public ChatListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9320d = 1;
        this.f9321e = 2;
        this.f9322f = 3;
        this.f9323g = 4;
        this.f9325i = false;
        this.f9319c = 1;
        this.f9326j = 0.1d;
        this.f9327k = 0.0312d;
        this.f9330n = false;
        setOnScrollListener(this);
        setCacheColorHint(0);
        setDivider(null);
        this.f9317a = LayoutInflater.from(getContext()).inflate(R.layout.list_view_header_chat, (ViewGroup) null);
        this.f9324h = LayoutInflater.from(getContext()).inflate(R.layout.list_view_foot_chat, (ViewGroup) null);
        addHeaderView(this.f9317a);
        addFooterView(this.f9324h);
        setTranscriptMode(2);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int i, int i2) {
        if (!this.f9325i) {
            this.f9325i = true;
            int size = View.MeasureSpec.getSize(i);
            View view = this.f9317a;
            if (view != null) {
                double d = size;
                double d2 = this.f9326j;
                Double.isNaN(d);
                this.f9318b = (int) (d * d2);
                View findViewById = view.findViewById(R.id.chat_list_header_content);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) findViewById.getLayoutParams();
                marginLayoutParams.height = this.f9318b;
                findViewById.setLayoutParams(marginLayoutParams);
                this.f9317a.setPadding(0, -this.f9318b, 0, 0);
                this.f9324h.setPadding(0, 0, 0, -this.f9318b);
            }
            double d3 = this.f9327k;
            double d4 = size;
            Double.isNaN(d4);
            setDividerHeight((int) (d3 * d4));
        }
        super.onMeasure(i, i2);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f9330n) {
            if (this.f9319c != 4) {
                this.f9331o.obtainMessage(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_UNDEFINE_ERROR).sendToTarget();
                switch (motionEvent.getAction()) {
                    case 0:
                        int firstVisiblePosition = getFirstVisiblePosition();
                        if (!this.f9329m && firstVisiblePosition == 0) {
                            this.f9329m = true;
                            this.f9328l = motionEvent.getRawY();
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        this.f9329m = false;
                        if (this.f9319c == 3) {
                            this.f9319c = 4;
                            this.f9317a.setPadding(0, 0, 0, 0);
                            GoloHandler goloHandler = this.f9331o;
                            if (goloHandler != null) {
                                goloHandler.obtainMessage(100006).sendToTarget();
                                break;
                            }
                        } else {
                            this.f9319c = 1;
                            this.f9317a.setPadding(0, -this.f9318b, 0, 0);
                            this.f9324h.setPadding(0, -this.f9318b, 0, 0);
                            break;
                        }
                        break;
                    case 2:
                        int firstVisiblePosition2 = getFirstVisiblePosition();
                        if (!this.f9329m && firstVisiblePosition2 == 0) {
                            this.f9329m = true;
                            this.f9328l = motionEvent.getRawY();
                        } else if (this.f9329m && firstVisiblePosition2 == 0) {
                            float rawY = (motionEvent.getRawY() - this.f9328l) / 2.0f;
                            if (rawY > ColumnText.GLOBAL_SPACE_CHAR_RATIO && rawY < this.f9318b) {
                                this.f9319c = 2;
                            } else if (rawY > this.f9318b) {
                                this.f9319c = 3;
                            }
                            this.f9317a.setPadding(0, (int) (rawY - this.f9318b), 0, 0);
                        }
                        int lastVisiblePosition = getLastVisiblePosition();
                        if (!this.f9329m && lastVisiblePosition == getAdapter().getCount() - 1) {
                            this.f9329m = true;
                            this.f9328l = motionEvent.getRawY();
                            break;
                        } else if (this.f9329m && lastVisiblePosition == getAdapter().getCount() - 1) {
                            float rawY2 = (motionEvent.getRawY() - this.f9328l) / 2.0f;
                            if (rawY2 > ColumnText.GLOBAL_SPACE_CHAR_RATIO && rawY2 < this.f9318b) {
                                this.f9319c = 2;
                            } else if (rawY2 > this.f9318b) {
                                this.f9319c = 3;
                            }
                            this.f9324h.setPadding(0, 0, 0, (int) ((-rawY2) - this.f9318b));
                            break;
                        }
                        break;
                }
            }
        } else {
            switch (motionEvent.getAction() & 255) {
                case 0:
                    if (this.f9330n) {
                        this.f9332p = motionEvent.getX();
                        this.f9333q = motionEvent.getY();
                        StringBuilder sb = new StringBuilder();
                        sb.append(this.f9332p);
                        Log.i("downX", sb.toString());
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(this.f9333q);
                        Log.i("downY", sb2.toString());
                        break;
                    }
                    break;
                case 1:
                    if (this.f9330n) {
                        this.f9334r = motionEvent.getX();
                        float y = motionEvent.getY();
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(this.f9334r);
                        Log.i("cy_upX", sb3.toString());
                        Log.i("cy_upY", String.valueOf(y));
                        if (y - this.f9333q < ColumnText.GLOBAL_SPACE_CHAR_RATIO && this.f9334r - this.f9332p > ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
                            Log.i("dismisDialog", PdfBoolean.TRUE);
                            if (Math.sqrt(Math.pow(this.f9334r - y, 2.0d) + Math.pow(this.f9332p - this.f9333q, 2.0d)) > 10.0d) {
                                getContext().sendBroadcast(new Intent("stop_recording"));
                                this.f9330n = false;
                                break;
                            }
                        }
                    }
                    break;
                case 2:
                    if (this.f9330n) {
                        this.f9334r = motionEvent.getX();
                        float y2 = motionEvent.getY();
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(this.f9334r);
                        Log.i("cy_upX", sb4.toString());
                        Log.i("cy_upY", String.valueOf(y2));
                        if (y2 - this.f9333q < ColumnText.GLOBAL_SPACE_CHAR_RATIO && this.f9334r - this.f9332p > ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
                            Log.i("dismisDialog", PdfBoolean.TRUE);
                            if (Math.sqrt(Math.pow(this.f9334r - y2, 2.0d) + Math.pow(this.f9332p - this.f9333q, 2.0d)) > 10.0d) {
                                getContext().sendBroadcast(new Intent("stop_recording"));
                                this.f9330n = false;
                                break;
                            }
                        }
                    }
                    break;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setHandler(GoloHandler goloHandler) {
        this.f9331o = goloHandler;
    }

    public void setHeaderScale(Double d) {
        if (d.doubleValue() <= 0.0d || d.doubleValue() >= 1.0d) {
            return;
        }
        this.f9326j = d.doubleValue();
    }

    public void setDividerHeightScale(double d) {
        if (d <= 0.0d || d >= 1.0d) {
            return;
        }
        this.f9327k = d;
    }

    public void setRecording(boolean z) {
        this.f9330n = z;
    }
}
