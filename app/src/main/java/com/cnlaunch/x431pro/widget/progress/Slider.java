package com.cnlaunch.x431pro.widget.progress;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.ifoer.expedition.pro.R;
import com.itextpdf.text.pdf.ColumnText;
import com.p294d.p295a.ViewHelper;
import com.p294d.p295a.p296a.AnimatorProxy;

/* loaded from: classes.dex */
public class Slider extends CustomView {

    /* renamed from: e */
    int f16615e;

    /* renamed from: f */
    C2918a f16616f;

    /* renamed from: g */
    DialogC2920c f16617g;

    /* renamed from: h */
    boolean f16618h;

    /* renamed from: i */
    boolean f16619i;

    /* renamed from: j */
    int f16620j;

    /* renamed from: k */
    int f16621k;

    /* renamed from: l */
    int f16622l;

    /* renamed from: m */
    InterfaceC2921d f16623m;

    /* renamed from: n */
    boolean f16624n;

    /* renamed from: com.cnlaunch.x431pro.widget.progress.Slider$d */
    /* loaded from: classes.dex */
    public interface InterfaceC2921d {
        /* renamed from: a */
        void mo4476a(int i);
    }

    public Slider(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16615e = Color.parseColor("#4CAF50");
        this.f16618h = false;
        this.f16619i = false;
        this.f16620j = 0;
        this.f16621k = 100;
        this.f16622l = 0;
        this.f16624n = false;
        setAttributes(attributeSet);
    }

    protected void setAttributes(AttributeSet attributeSet) {
        setBackgroundResource(R.drawable.background_transparent);
        setMinimumHeight(C2923c.m4475a(48.0f, getResources()));
        setMinimumWidth(C2923c.m4475a(80.0f, getResources()));
        int attributeResourceValue = attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "background", -1);
        if (attributeResourceValue != -1) {
            setBackgroundColor(getResources().getColor(attributeResourceValue));
        } else {
            int attributeIntValue = attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "background", -1);
            if (attributeIntValue != -1) {
                setBackgroundColor(attributeIntValue);
            }
        }
        this.f16618h = attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res-auto", "showNumberIndicator", false);
        this.f16622l = attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res-auto", "min", 0);
        this.f16621k = attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res-auto", "max", 0);
        this.f16620j = attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res-auto", "value", this.f16622l);
        this.f16616f = new C2918a(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(C2923c.m4475a(20.0f, getResources()), C2923c.m4475a(20.0f, getResources()));
        layoutParams.addRule(15, -1);
        this.f16616f.setLayoutParams(layoutParams);
        addView(this.f16616f);
        if (this.f16618h) {
            this.f16617g = new DialogC2920c(getContext());
        }
    }

    @Override // android.view.View
    public void invalidate() {
        this.f16616f.invalidate();
        super.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.cnlaunch.x431pro.widget.progress.CustomView, android.view.View
    public void onDraw(Canvas canvas) {
        float y;
        super.onDraw(canvas);
        if (!this.f16624n) {
            ViewHelper.m4283a(this.f16616f, (getHeight() / 2) - (this.f16616f.getWidth() / 2));
            C2918a c2918a = this.f16616f;
            c2918a.f16625a = ViewHelper.m4284a(c2918a);
            this.f16616f.f16626b = (getWidth() - (getHeight() / 2)) - (this.f16616f.getWidth() / 2);
            this.f16616f.f16627c = (getWidth() / 2) - (this.f16616f.getWidth() / 2);
            this.f16624n = true;
        }
        if (this.f16620j == this.f16622l) {
            Bitmap createBitmap = Bitmap.createBitmap(canvas.getWidth(), canvas.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(createBitmap);
            Paint paint = new Paint();
            paint.setColor(Color.parseColor("#B0B0B0"));
            paint.setStrokeWidth(C2923c.m4475a(2.0f, getResources()));
            canvas2.drawLine(getHeight() / 2, getHeight() / 2, getWidth() - (getHeight() / 2), getHeight() / 2, paint);
            Paint paint2 = new Paint();
            paint2.setColor(getResources().getColor(17170445));
            paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            float m4284a = ViewHelper.m4284a(this.f16616f) + (this.f16616f.getWidth() / 2);
            C2918a c2918a2 = this.f16616f;
            if (AnimatorProxy.f16965a) {
                AnimatorProxy m4278a = AnimatorProxy.m4278a(c2918a2);
                View view = m4278a.f16967b.get();
                if (view == null) {
                    y = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
                } else {
                    y = m4278a.f16968c + view.getTop();
                }
            } else {
                y = c2918a2.getY();
            }
            canvas2.drawCircle(m4284a, y + (this.f16616f.getHeight() / 2), this.f16616f.getWidth() / 2, paint2);
            canvas.drawBitmap(createBitmap, ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, new Paint());
        } else {
            Paint paint3 = new Paint();
            paint3.setColor(Color.parseColor("#B0B0B0"));
            paint3.setStrokeWidth(C2923c.m4475a(2.0f, getResources()));
            canvas.drawLine(getHeight() / 2, getHeight() / 2, getWidth() - (getHeight() / 2), getHeight() / 2, paint3);
            paint3.setColor(this.f16615e);
            float f = this.f16616f.f16626b - this.f16616f.f16625a;
            int i = this.f16621k;
            int i2 = this.f16622l;
            canvas.drawLine(getHeight() / 2, getHeight() / 2, ((this.f16620j - i2) * (f / (i - i2))) + (getHeight() / 2), getHeight() / 2, paint3);
        }
        if (this.f16619i && !this.f16618h) {
            Paint paint4 = new Paint();
            paint4.setColor(this.f16615e);
            paint4.setAntiAlias(true);
            canvas.drawCircle(ViewHelper.m4284a(this.f16616f) + (this.f16616f.getWidth() / 2), getHeight() / 2, getHeight() / 3, paint4);
        }
        invalidate();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x;
        this.f16642c = true;
        if (isEnabled()) {
            if (motionEvent.getAction() == 0 || motionEvent.getAction() == 2) {
                DialogC2920c dialogC2920c = this.f16617g;
                if (dialogC2920c != null && !dialogC2920c.isShowing()) {
                    this.f16617g.show();
                }
                if (motionEvent.getX() <= getWidth() && motionEvent.getX() >= ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
                    this.f16619i = true;
                    float f = (this.f16616f.f16626b - this.f16616f.f16625a) / (this.f16621k - this.f16622l);
                    if (motionEvent.getX() > this.f16616f.f16626b) {
                        x = this.f16621k;
                    } else if (motionEvent.getX() < this.f16616f.f16625a) {
                        x = this.f16622l;
                    } else {
                        x = ((int) ((motionEvent.getX() - this.f16616f.f16625a) / f)) + this.f16622l;
                    }
                    if (this.f16620j != x) {
                        this.f16620j = x;
                        InterfaceC2921d interfaceC2921d = this.f16623m;
                        if (interfaceC2921d != null) {
                            interfaceC2921d.mo4476a(x);
                        }
                    }
                    float x2 = motionEvent.getX();
                    if (x2 < this.f16616f.f16625a) {
                        x2 = this.f16616f.f16625a;
                    }
                    if (x2 > this.f16616f.f16626b) {
                        x2 = this.f16616f.f16626b;
                    }
                    ViewHelper.m4283a(this.f16616f, x2);
                    this.f16616f.m4477a();
                    DialogC2920c dialogC2920c2 = this.f16617g;
                    if (dialogC2920c2 != null) {
                        dialogC2920c2.f16637a.f16629a = x2;
                        this.f16617g.f16637a.f16632d = C2923c.m4474a(this) - (getHeight() / 2);
                        this.f16617g.f16637a.f16633e = getHeight() / 2;
                        this.f16617g.f16638b.setText("");
                    }
                } else {
                    this.f16619i = false;
                    this.f16642c = false;
                    DialogC2920c dialogC2920c3 = this.f16617g;
                    if (dialogC2920c3 != null) {
                        dialogC2920c3.dismiss();
                    }
                }
            } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                DialogC2920c dialogC2920c4 = this.f16617g;
                if (dialogC2920c4 != null) {
                    dialogC2920c4.dismiss();
                }
                this.f16642c = false;
                this.f16619i = false;
            }
        }
        return true;
    }

    public InterfaceC2921d getOnValueChangedListener() {
        return this.f16623m;
    }

    public void setOnValueChangedListener(InterfaceC2921d interfaceC2921d) {
        this.f16623m = interfaceC2921d;
    }

    public int getValue() {
        return this.f16620j;
    }

    public void setValue(int i) {
        if (!this.f16624n) {
            post(new RunnableC2922b(this, i));
            return;
        }
        this.f16620j = i;
        ViewHelper.m4283a(this.f16616f, ((i * ((this.f16616f.f16626b - this.f16616f.f16625a) / this.f16621k)) + (getHeight() / 2)) - (this.f16616f.getWidth() / 2));
        this.f16616f.m4477a();
    }

    public int getMax() {
        return this.f16621k;
    }

    public void setMax(int i) {
        this.f16621k = i;
    }

    public int getMin() {
        return this.f16622l;
    }

    public void setMin(int i) {
        this.f16622l = i;
    }

    public void setShowNumberIndicator(boolean z) {
        this.f16618h = z;
        this.f16617g = z ? new DialogC2920c(getContext()) : null;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.f16615e = i;
        if (isEnabled()) {
            this.f16641b = this.f16615e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.cnlaunch.x431pro.widget.progress.Slider$a */
    /* loaded from: classes.dex */
    public class C2918a extends View {

        /* renamed from: a */
        float f16625a;

        /* renamed from: b */
        float f16626b;

        /* renamed from: c */
        float f16627c;

        public C2918a(Context context) {
            super(context);
            setBackgroundResource(R.drawable.background_switch_ball_uncheck);
        }

        /* renamed from: a */
        public final void m4477a() {
            if (Slider.this.f16620j != Slider.this.f16622l) {
                setBackgroundResource(R.drawable.background_checkbox);
                ((GradientDrawable) ((LayerDrawable) getBackground()).findDrawableByLayerId(R.id.shape_bacground)).setColor(Slider.this.f16615e);
                return;
            }
            setBackgroundResource(R.drawable.background_switch_ball_uncheck);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.cnlaunch.x431pro.widget.progress.Slider$c */
    /* loaded from: classes.dex */
    public class DialogC2920c extends Dialog {

        /* renamed from: a */
        C2919b f16637a;

        /* renamed from: b */
        TextView f16638b;

        @Override // android.app.Dialog
        public final void onBackPressed() {
        }

        public DialogC2920c(Context context) {
            super(context, 16973839);
        }

        @Override // android.app.Dialog
        protected final void onCreate(Bundle bundle) {
            requestWindowFeature(1);
            super.onCreate(bundle);
            setContentView(R.layout.number_indicator_spinner);
            setCanceledOnTouchOutside(false);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.number_indicator_spinner_content);
            this.f16637a = new C2919b(getContext());
            relativeLayout.addView(this.f16637a);
            this.f16638b = new TextView(getContext());
            this.f16638b.setTextColor(-1);
            this.f16638b.setGravity(17);
            relativeLayout.addView(this.f16638b);
            this.f16637a.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        }

        @Override // android.app.Dialog, android.content.DialogInterface
        public final void dismiss() {
            super.dismiss();
            C2919b c2919b = this.f16637a;
            c2919b.f16630b = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
            c2919b.f16631c = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
            c2919b.f16634f = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.cnlaunch.x431pro.widget.progress.Slider$b */
    /* loaded from: classes.dex */
    public class C2919b extends RelativeLayout {

        /* renamed from: a */
        float f16629a;

        /* renamed from: b */
        float f16630b;

        /* renamed from: c */
        float f16631c;

        /* renamed from: d */
        float f16632d;

        /* renamed from: e */
        float f16633e;

        /* renamed from: f */
        boolean f16634f;

        /* renamed from: g */
        boolean f16635g;

        public C2919b(Context context) {
            super(context);
            this.f16629a = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
            this.f16630b = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
            this.f16631c = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
            this.f16632d = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
            this.f16633e = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
            this.f16634f = true;
            this.f16635g = false;
            setBackgroundColor(getResources().getColor(17170445));
        }

        @Override // android.view.View
        protected final void onDraw(Canvas canvas) {
            View view;
            super.onDraw(canvas);
            if (!this.f16635g) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) Slider.this.f16617g.f16638b.getLayoutParams();
                float f = this.f16633e;
                layoutParams.height = ((int) f) * 2;
                layoutParams.width = ((int) f) * 2;
                Slider.this.f16617g.f16638b.setLayoutParams(layoutParams);
            }
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setColor(Slider.this.f16615e);
            if (this.f16634f) {
                if (this.f16630b == ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
                    this.f16630b = this.f16632d + (this.f16633e * 2.0f);
                }
                this.f16630b -= C2923c.m4475a(6.0f, getResources());
                this.f16631c += C2923c.m4475a(2.0f, getResources());
            }
            canvas.drawCircle(ViewHelper.m4284a(Slider.this.f16616f) + C2923c.m4473b((View) Slider.this.f16616f.getParent()) + (Slider.this.f16616f.getWidth() / 2), this.f16630b, this.f16631c, paint);
            if (this.f16634f && this.f16631c >= this.f16633e) {
                this.f16634f = false;
            }
            if (!this.f16634f) {
                ViewHelper.m4283a(Slider.this.f16617g.f16638b, ((ViewHelper.m4284a(Slider.this.f16616f) + C2923c.m4473b((View) Slider.this.f16616f.getParent())) + (Slider.this.f16616f.getWidth() / 2)) - this.f16631c);
                TextView textView = Slider.this.f16617g.f16638b;
                float f2 = this.f16630b - this.f16631c;
                if (AnimatorProxy.f16965a) {
                    AnimatorProxy m4278a = AnimatorProxy.m4278a(textView);
                    if (m4278a.f16967b.get() != null) {
                        float top = f2 - view.getTop();
                        if (m4278a.f16968c != top) {
                            m4278a.m4277b();
                            m4278a.f16968c = top;
                            m4278a.m4275c();
                        }
                    }
                } else {
                    textView.setY(f2);
                }
                TextView textView2 = Slider.this.f16617g.f16638b;
                StringBuilder sb = new StringBuilder();
                sb.append(Slider.this.f16620j);
                textView2.setText(sb.toString());
            }
            invalidate();
        }
    }
}
