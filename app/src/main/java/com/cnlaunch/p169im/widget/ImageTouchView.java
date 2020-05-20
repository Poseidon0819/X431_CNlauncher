package com.cnlaunch.p169im.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.widget.ImageView;
import com.cnlaunch.p169im.GoloApplication;
import com.itextpdf.text.pdf.ColumnText;

/* renamed from: com.cnlaunch.im.widget.ImageTouchView */
/* loaded from: classes.dex */
public class ImageTouchView extends ImageView {

    /* renamed from: A */
    private boolean f9353A;

    /* renamed from: B */
    private boolean f9354B;

    /* renamed from: C */
    private InterfaceC1758a f9355C;

    /* renamed from: D */
    private float f9356D;

    /* renamed from: E */
    private float f9357E;

    /* renamed from: F */
    private Runnable f9358F;

    /* renamed from: G */
    private AsyncTaskC1760c f9359G;

    /* renamed from: a */
    private Activity f9360a;

    /* renamed from: b */
    private int f9361b;

    /* renamed from: c */
    private int f9362c;

    /* renamed from: d */
    private int f9363d;

    /* renamed from: e */
    private int f9364e;

    /* renamed from: f */
    private int f9365f;

    /* renamed from: g */
    private int f9366g;

    /* renamed from: h */
    private int f9367h;

    /* renamed from: i */
    private int f9368i;

    /* renamed from: j */
    private int f9369j;

    /* renamed from: k */
    private int f9370k;

    /* renamed from: l */
    private int f9371l;

    /* renamed from: m */
    private int f9372m;

    /* renamed from: n */
    private int f9373n;

    /* renamed from: o */
    private int f9374o;

    /* renamed from: p */
    private int f9375p;

    /* renamed from: q */
    private int f9376q;

    /* renamed from: r */
    private float f9377r;

    /* renamed from: s */
    private float f9378s;

    /* renamed from: t */
    private long f9379t;

    /* renamed from: u */
    private long f9380u;

    /* renamed from: v */
    private float f9381v;

    /* renamed from: w */
    private boolean f9382w;

    /* renamed from: x */
    private boolean f9383x;

    /* renamed from: y */
    private int f9384y;

    /* renamed from: z */
    private boolean f9385z;

    /* renamed from: com.cnlaunch.im.widget.ImageTouchView$a */
    /* loaded from: classes.dex */
    public interface InterfaceC1758a {
        /* renamed from: a */
        void mo8689a();
    }

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* renamed from: com.cnlaunch.im.widget.ImageTouchView$b */
    /* loaded from: classes.dex */
    static final class EnumC1759b {
        public static final int NONE$361f8b6c = 1;
        public static final int DRAG$361f8b6c = 2;
        public static final int ZOOM$361f8b6c = 3;

        /* renamed from: a */
        private static final /* synthetic */ int[] f9386a = {NONE$361f8b6c, DRAG$361f8b6c, ZOOM$361f8b6c};

        public static int[] values$2fbebef2() {
            return (int[]) f9386a.clone();
        }
    }

    public void setmActivity(Activity activity) {
        this.f9360a = activity;
    }

    public void setScreen_W(int i) {
        this.f9361b = i;
    }

    public void setScreen_H(int i) {
        this.f9362c = i;
    }

    public ImageTouchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9369j = -1;
        this.f9370k = -1;
        this.f9371l = -1;
        this.f9372m = -1;
        this.f9382w = true;
        this.f9383x = false;
        this.f9384y = EnumC1759b.NONE$361f8b6c;
        this.f9385z = false;
        this.f9353A = false;
        this.f9354B = false;
        this.f9356D = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.f9357E = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.f9360a = (Activity) getContext();
        WindowManager windowManager = (WindowManager) GoloApplication.f8909b.getSystemService("window");
        this.f9361b = windowManager.getDefaultDisplay().getWidth();
        this.f9362c = windowManager.getDefaultDisplay().getHeight();
        this.f9358F = new RunnableC1763a(this);
    }

    public void setOnImageTouchListener(InterfaceC1758a interfaceC1758a) {
        this.f9355C = interfaceC1758a;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (bitmap == null) {
            return;
        }
        int i = this.f9361b;
        this.f9363d = i * 3;
        this.f9364e = i / 2;
        m8698a(0, 0, i, this.f9362c);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f9369j == -1) {
            this.f9369j = i2;
            this.f9372m = i;
            this.f9371l = i4;
            this.f9370k = i3;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterfaceC1758a interfaceC1758a;
        try {
            this.f9357E = motionEvent.getX();
            this.f9380u = System.currentTimeMillis();
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.f9379t = System.currentTimeMillis();
                    postDelayed(this.f9358F, ViewConfiguration.getLongPressTimeout());
                    try {
                        this.f9384y = EnumC1759b.DRAG$361f8b6c;
                        this.f9356D = (int) motionEvent.getX();
                        this.f9375p = (int) motionEvent.getRawX();
                        this.f9376q = (int) motionEvent.getRawY();
                        this.f9373n = (int) motionEvent.getX();
                        this.f9374o = this.f9376q - getTop();
                        break;
                    } catch (IllegalArgumentException e) {
                        e.printStackTrace();
                        break;
                    }
                case 1:
                    removeCallbacks(this.f9358F);
                    if (this.f9384y == EnumC1759b.DRAG$361f8b6c) {
                        if (Math.abs(this.f9357E - this.f9356D) < 3.0f && this.f9380u - this.f9379t < ViewConfiguration.getTapTimeout() && (interfaceC1758a = this.f9355C) != null) {
                            interfaceC1758a.mo8689a();
                            break;
                        } else if (!this.f9382w) {
                            this.f9382w = true;
                        }
                    }
                    this.f9384y = EnumC1759b.NONE$361f8b6c;
                    break;
                case 2:
                    if ((this.f9357E < this.f9356D && getRight() > this.f9361b) || (this.f9357E > this.f9356D && getLeft() < 0)) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                    } else {
                        getParent().requestDisallowInterceptTouchEvent(false);
                    }
                    if (this.f9384y == EnumC1759b.DRAG$361f8b6c) {
                        int i = this.f9375p;
                        int i2 = i - this.f9373n;
                        int width = (i + getWidth()) - this.f9373n;
                        int i3 = this.f9376q;
                        int i4 = this.f9374o;
                        int i5 = i3 - i4;
                        int height = (i3 - i4) + getHeight();
                        if (Math.abs(this.f9357E - this.f9356D) > 3.0f) {
                            removeCallbacks(this.f9358F);
                        }
                        if (this.f9385z) {
                            if (i5 >= 0) {
                                height = getHeight();
                                i5 = 0;
                            }
                            int i6 = this.f9362c;
                            if (height <= i6) {
                                i5 = i6 - getHeight();
                                height = this.f9362c;
                            }
                        } else {
                            i5 = getTop();
                            height = getBottom();
                        }
                        this.f9375p = (int) motionEvent.getRawX();
                        this.f9376q = (int) motionEvent.getRawY();
                        int i7 = this.f9361b;
                        double d = i7;
                        Double.isNaN(d);
                        if (width <= d / 1.5d) {
                            this.f9382w = false;
                            this.f9383x = true;
                        } else if (i2 >= i7 / 3) {
                            this.f9382w = false;
                            this.f9383x = false;
                        } else {
                            this.f9382w = true;
                        }
                        m8698a(i2, i5, width, height);
                        break;
                    } else if (this.f9384y == EnumC1759b.ZOOM$361f8b6c) {
                        this.f9378s = m8697a(motionEvent);
                        float f = this.f9378s - this.f9377r;
                        if (Math.abs(f) > 5.0f) {
                            this.f9381v = this.f9378s / this.f9377r;
                            double d2 = f;
                            if (d2 < 0.0d) {
                                double d3 = this.f9381v;
                                Double.isNaN(d3);
                                this.f9381v = (float) (d3 * 0.9d);
                            } else if (d2 > 0.0d) {
                                double d4 = this.f9381v;
                                Double.isNaN(d4);
                                this.f9381v = (float) (d4 * 1.1d);
                            }
                            setScale(this.f9381v);
                            this.f9377r = this.f9378s;
                            break;
                        }
                    }
                    break;
                case 3:
                case 4:
                default:
                    removeCallbacks(this.f9358F);
                    break;
                case 5:
                    removeCallbacks(this.f9358F);
                    if (motionEvent.getPointerCount() == 2) {
                        this.f9384y = EnumC1759b.ZOOM$361f8b6c;
                        this.f9377r = m8697a(motionEvent);
                        break;
                    }
                    break;
                case 6:
                    this.f9384y = EnumC1759b.NONE$361f8b6c;
                    if (this.f9354B) {
                        this.f9359G = new AsyncTaskC1760c(this.f9361b, getWidth(), getHeight());
                        AsyncTaskC1760c asyncTaskC1760c = this.f9359G;
                        int left = getLeft();
                        int top = getTop();
                        int right = getRight();
                        int bottom = getBottom();
                        asyncTaskC1760c.f9387a = left;
                        asyncTaskC1760c.f9388b = top;
                        asyncTaskC1760c.f9389c = right;
                        asyncTaskC1760c.f9390d = bottom;
                        this.f9359G.execute(new Void[0]);
                        this.f9354B = false;
                        break;
                    }
                    break;
            }
            return true;
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return true;
        }
    }

    /* renamed from: a */
    private static float m8697a(MotionEvent motionEvent) {
        try {
            float x = motionEvent.getX(0) - motionEvent.getX(1);
            float y = motionEvent.getY(0) - motionEvent.getY(1);
            return (float) Math.sqrt((x * x) + (y * y));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        }
    }

    /* renamed from: a */
    private void m8698a(int i, int i2, int i3, int i4) {
        layout(i, i2, i3, i4);
    }

    void setScale(float f) {
        float f2 = 1.0f - f;
        int width = ((int) (getWidth() * Math.abs(f2))) / 4;
        int height = ((int) (getHeight() * Math.abs(f2))) / 4;
        if (f > 1.0f && getWidth() <= this.f9363d) {
            this.f9368i = getLeft() - width;
            this.f9365f = getTop() - height;
            this.f9366g = getRight() + width;
            this.f9367h = getBottom() + height;
            setFrame(this.f9368i, this.f9365f, this.f9366g, this.f9367h);
            if (this.f9365f <= 0 && this.f9367h >= this.f9362c) {
                this.f9385z = true;
            } else {
                this.f9385z = false;
            }
            if (this.f9368i <= 0 && this.f9366g >= this.f9361b) {
                this.f9353A = true;
            } else {
                this.f9353A = false;
            }
        } else if (f >= 1.0f || getWidth() < this.f9364e) {
        } else {
            this.f9368i = getLeft() + width;
            this.f9365f = getTop() + height;
            this.f9366g = getRight() - width;
            this.f9367h = getBottom() - height;
            if (this.f9385z && this.f9365f > 0) {
                this.f9365f = 0;
                this.f9367h = getBottom() - (height * 2);
                int i = this.f9367h;
                int i2 = this.f9362c;
                if (i < i2) {
                    this.f9367h = i2;
                    this.f9385z = false;
                }
            }
            if (this.f9385z) {
                int i3 = this.f9367h;
                int i4 = this.f9362c;
                if (i3 < i4) {
                    this.f9367h = i4;
                    this.f9365f = getTop() + (height * 2);
                    if (this.f9365f > 0) {
                        this.f9365f = 0;
                        this.f9385z = false;
                    }
                }
            }
            if (this.f9353A && this.f9368i >= 0) {
                this.f9368i = 0;
                this.f9366g = getRight() - (width * 2);
                int i5 = this.f9366g;
                int i6 = this.f9361b;
                if (i5 <= i6) {
                    this.f9366g = i6;
                    this.f9353A = false;
                }
            }
            if (this.f9353A) {
                int i7 = this.f9366g;
                int i8 = this.f9361b;
                if (i7 <= i8) {
                    this.f9366g = i8;
                    this.f9368i = getLeft() + (width * 2);
                    if (this.f9368i >= 0) {
                        this.f9368i = 0;
                        this.f9353A = false;
                    }
                }
            }
            if (this.f9353A || this.f9385z) {
                setFrame(this.f9368i, this.f9365f, this.f9366g, this.f9367h);
                return;
            }
            setFrame(this.f9368i, this.f9365f, this.f9366g, this.f9367h);
            this.f9354B = true;
        }
    }

    /* renamed from: com.cnlaunch.im.widget.ImageTouchView$c */
    /* loaded from: classes.dex */
    class AsyncTaskC1760c extends AsyncTask<Void, Integer, Void> {

        /* renamed from: a */
        int f9387a;

        /* renamed from: b */
        int f9388b;

        /* renamed from: c */
        int f9389c;

        /* renamed from: d */
        int f9390d;

        /* renamed from: f */
        private int f9392f;

        /* renamed from: g */
        private int f9393g;

        /* renamed from: h */
        private int f9394h;

        /* renamed from: i */
        private float f9395i;

        /* renamed from: j */
        private float f9396j = 8.0f;

        /* renamed from: k */
        private float f9397k;

        /* renamed from: l */
        private float f9398l;

        @Override // android.os.AsyncTask
        protected final /* synthetic */ Void doInBackground(Void[] voidArr) {
            return m8688a();
        }

        public AsyncTaskC1760c(int i, int i2, int i3) {
            this.f9392f = i;
            this.f9393g = i2;
            this.f9394h = i3;
            this.f9395i = i3 / i2;
            float f = this.f9396j;
            this.f9397k = f;
            this.f9398l = this.f9395i * f;
        }

        /* renamed from: a */
        private Void m8688a() {
            while (true) {
                int i = this.f9393g;
                if (i > this.f9392f) {
                    return null;
                }
                float f = this.f9397k;
                this.f9387a = (int) (this.f9387a - f);
                float f2 = this.f9398l;
                this.f9388b = (int) (this.f9388b - f2);
                this.f9389c = (int) (this.f9389c + f);
                this.f9390d = (int) (this.f9390d + f2);
                this.f9393g = (int) (i + (f * 2.0f));
                this.f9387a = Math.max(this.f9387a, ImageTouchView.this.f9372m);
                this.f9388b = Math.max(this.f9388b, ImageTouchView.this.f9369j);
                this.f9389c = Math.min(this.f9389c, ImageTouchView.this.f9370k);
                this.f9390d = Math.min(this.f9390d, ImageTouchView.this.f9371l);
                Log.e("jj", "top=" + this.f9388b + ",bottom=" + this.f9390d + ",left=" + this.f9387a + ",right=" + this.f9389c);
                onProgressUpdate(Integer.valueOf(this.f9387a), Integer.valueOf(this.f9388b), Integer.valueOf(this.f9389c), Integer.valueOf(this.f9390d));
                try {
                    Thread.sleep(10L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            ImageTouchView.this.f9360a.runOnUiThread(new RunnableC1764b(this, numArr));
        }
    }
}
