package com.baidu.mapsdkplatform.comapi.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapsdkplatform.comapi.commonutils.C1190a;

/* renamed from: com.baidu.mapsdkplatform.comapi.map.H */
/* loaded from: classes.dex */
public class View$OnTouchListenerC1204H extends LinearLayout implements View.OnTouchListener {

    /* renamed from: a */
    private ImageView f5928a;

    /* renamed from: b */
    private ImageView f5929b;

    /* renamed from: c */
    private Context f5930c;

    /* renamed from: d */
    private Bitmap f5931d;

    /* renamed from: e */
    private Bitmap f5932e;

    /* renamed from: f */
    private Bitmap f5933f;

    /* renamed from: g */
    private Bitmap f5934g;

    /* renamed from: h */
    private Bitmap f5935h;

    /* renamed from: i */
    private Bitmap f5936i;

    /* renamed from: j */
    private Bitmap f5937j;

    /* renamed from: k */
    private Bitmap f5938k;

    /* renamed from: l */
    private int f5939l;

    /* renamed from: m */
    private boolean f5940m;

    /* renamed from: n */
    private boolean f5941n;

    @Deprecated
    public View$OnTouchListenerC1204H(Context context) {
        super(context);
        this.f5940m = false;
        this.f5941n = false;
        this.f5930c = context;
        m10762c();
        if (this.f5931d == null || this.f5932e == null || this.f5933f == null || this.f5934g == null) {
            return;
        }
        this.f5928a = new ImageView(this.f5930c);
        this.f5929b = new ImageView(this.f5930c);
        this.f5928a.setImageBitmap(this.f5931d);
        this.f5929b.setImageBitmap(this.f5933f);
        this.f5939l = m10770a(this.f5933f.getHeight() / 6);
        m10768a(this.f5928a, "main_topbtn_up.9.png");
        m10768a(this.f5929b, "main_bottombtn_up.9.png");
        this.f5928a.setId(0);
        this.f5929b.setId(1);
        this.f5928a.setClickable(true);
        this.f5929b.setClickable(true);
        this.f5928a.setOnTouchListener(this);
        this.f5929b.setOnTouchListener(this);
        setOrientation(1);
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(this.f5928a);
        addView(this.f5929b);
        this.f5941n = true;
    }

    public View$OnTouchListenerC1204H(Context context, boolean z) {
        super(context);
        this.f5940m = false;
        this.f5941n = false;
        this.f5930c = context;
        this.f5940m = z;
        this.f5928a = new ImageView(this.f5930c);
        this.f5929b = new ImageView(this.f5930c);
        if (z) {
            m10761d();
            if (this.f5935h == null || this.f5936i == null || this.f5937j == null || this.f5938k == null) {
                return;
            }
            this.f5928a.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            this.f5929b.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            this.f5928a.setImageBitmap(this.f5935h);
            this.f5929b.setImageBitmap(this.f5937j);
            setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            setOrientation(0);
        } else {
            m10762c();
            Bitmap bitmap = this.f5931d;
            if (bitmap == null || this.f5932e == null || this.f5933f == null || this.f5934g == null) {
                return;
            }
            this.f5928a.setImageBitmap(bitmap);
            this.f5929b.setImageBitmap(this.f5933f);
            this.f5939l = m10770a(this.f5933f.getHeight() / 6);
            m10768a(this.f5928a, "main_topbtn_up.9.png");
            m10768a(this.f5929b, "main_bottombtn_up.9.png");
            setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            setOrientation(1);
        }
        this.f5928a.setId(0);
        this.f5929b.setId(1);
        this.f5928a.setClickable(true);
        this.f5929b.setClickable(true);
        this.f5928a.setOnTouchListener(this);
        this.f5929b.setOnTouchListener(this);
        addView(this.f5928a);
        addView(this.f5929b);
        this.f5941n = true;
    }

    /* renamed from: a */
    private int m10770a(int i) {
        return (int) ((this.f5930c.getResources().getDisplayMetrics().density * i) + 0.5f);
    }

    /* renamed from: a */
    private Bitmap m10767a(String str) {
        Matrix matrix = new Matrix();
        int densityDpi = SysOSUtil.getDensityDpi();
        float f = densityDpi > 480 ? 1.8f : (densityDpi <= 320 || densityDpi > 480) ? 1.2f : 1.5f;
        matrix.postScale(f, f);
        Bitmap m10820a = C1190a.m10820a(str, this.f5930c);
        return Bitmap.createBitmap(m10820a, 0, 0, m10820a.getWidth(), m10820a.getHeight(), matrix, true);
    }

    /* renamed from: a */
    private void m10768a(View view, String str) {
        Bitmap m10820a = C1190a.m10820a(str, this.f5930c);
        byte[] ninePatchChunk = m10820a.getNinePatchChunk();
        NinePatch.isNinePatchChunk(ninePatchChunk);
        view.setBackgroundDrawable(new NinePatchDrawable(m10820a, ninePatchChunk, new Rect(), null));
        int i = this.f5939l;
        view.setPadding(i, i, i, i);
    }

    /* renamed from: c */
    private void m10762c() {
        this.f5931d = m10767a("main_icon_zoomin.png");
        this.f5932e = m10767a("main_icon_zoomin_dis.png");
        this.f5933f = m10767a("main_icon_zoomout.png");
        this.f5934g = m10767a("main_icon_zoomout_dis.png");
    }

    /* renamed from: d */
    private void m10761d() {
        this.f5935h = m10767a("wear_zoom_in.png");
        this.f5936i = m10767a("wear_zoom_in_pressed.png");
        this.f5937j = m10767a("wear_zoon_out.png");
        this.f5938k = m10767a("wear_zoom_out_pressed.png");
    }

    /* renamed from: a */
    public void m10769a(View.OnClickListener onClickListener) {
        this.f5928a.setOnClickListener(onClickListener);
    }

    /* renamed from: a */
    public void m10766a(boolean z) {
        ImageView imageView;
        Bitmap bitmap;
        this.f5928a.setEnabled(z);
        if (z) {
            imageView = this.f5928a;
            bitmap = this.f5931d;
        } else {
            imageView = this.f5928a;
            bitmap = this.f5932e;
        }
        imageView.setImageBitmap(bitmap);
    }

    /* renamed from: a */
    public boolean m10771a() {
        return this.f5941n;
    }

    /* renamed from: b */
    public void m10765b() {
        Bitmap bitmap = this.f5931d;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f5931d.recycle();
            this.f5931d = null;
        }
        Bitmap bitmap2 = this.f5932e;
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            this.f5932e.recycle();
            this.f5932e = null;
        }
        Bitmap bitmap3 = this.f5933f;
        if (bitmap3 != null && !bitmap3.isRecycled()) {
            this.f5933f.recycle();
            this.f5933f = null;
        }
        Bitmap bitmap4 = this.f5934g;
        if (bitmap4 != null && !bitmap4.isRecycled()) {
            this.f5934g.recycle();
            this.f5934g = null;
        }
        Bitmap bitmap5 = this.f5935h;
        if (bitmap5 != null && !bitmap5.isRecycled()) {
            this.f5935h.recycle();
            this.f5935h = null;
        }
        Bitmap bitmap6 = this.f5936i;
        if (bitmap6 != null && !bitmap6.isRecycled()) {
            this.f5936i.recycle();
            this.f5936i = null;
        }
        Bitmap bitmap7 = this.f5937j;
        if (bitmap7 != null && !bitmap7.isRecycled()) {
            this.f5937j.recycle();
            this.f5937j = null;
        }
        Bitmap bitmap8 = this.f5938k;
        if (bitmap8 == null || bitmap8.isRecycled()) {
            return;
        }
        this.f5938k.recycle();
        this.f5938k = null;
    }

    /* renamed from: b */
    public void m10764b(View.OnClickListener onClickListener) {
        this.f5929b.setOnClickListener(onClickListener);
    }

    /* renamed from: b */
    public void m10763b(boolean z) {
        ImageView imageView;
        Bitmap bitmap;
        this.f5929b.setEnabled(z);
        if (z) {
            imageView = this.f5929b;
            bitmap = this.f5933f;
        } else {
            imageView = this.f5929b;
            bitmap = this.f5934g;
        }
        imageView.setImageBitmap(bitmap);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        ImageView imageView;
        Bitmap bitmap;
        ImageView imageView2;
        String str;
        if (view instanceof ImageView) {
            switch (((ImageView) view).getId()) {
                case 0:
                    if (motionEvent.getAction() == 0) {
                        if (this.f5940m) {
                            imageView = this.f5928a;
                            bitmap = this.f5936i;
                            imageView.setImageBitmap(bitmap);
                            return false;
                        }
                        imageView2 = this.f5928a;
                        str = "main_topbtn_down.9.png";
                        m10768a(imageView2, str);
                        return false;
                    } else if (motionEvent.getAction() == 1) {
                        if (this.f5940m) {
                            imageView = this.f5928a;
                            bitmap = this.f5935h;
                            imageView.setImageBitmap(bitmap);
                            return false;
                        }
                        imageView2 = this.f5928a;
                        str = "main_topbtn_up.9.png";
                        m10768a(imageView2, str);
                        return false;
                    } else {
                        return false;
                    }
                case 1:
                    if (motionEvent.getAction() == 0) {
                        if (this.f5940m) {
                            imageView = this.f5929b;
                            bitmap = this.f5938k;
                            imageView.setImageBitmap(bitmap);
                            return false;
                        }
                        imageView2 = this.f5929b;
                        str = "main_bottombtn_down.9.png";
                        m10768a(imageView2, str);
                        return false;
                    } else if (motionEvent.getAction() == 1) {
                        if (this.f5940m) {
                            imageView = this.f5929b;
                            bitmap = this.f5937j;
                            imageView.setImageBitmap(bitmap);
                            return false;
                        }
                        imageView2 = this.f5929b;
                        str = "main_bottombtn_up.9.png";
                        m10768a(imageView2, str);
                        return false;
                    } else {
                        return false;
                    }
                default:
                    return false;
            }
        }
        return false;
    }
}
