package com.cnlaunch.golo3.view.selectimg;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.RegionIterator;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.cnlaunch.golo3.view.selectimg.HighlightView;
import com.itextpdf.text.pdf.ColumnText;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class CropImageView extends ImageViewTouchBase {

    /* renamed from: a */
    public ArrayList<HighlightView> f8538a;

    /* renamed from: b */
    HighlightView f8539b;

    /* renamed from: c */
    float f8540c;

    /* renamed from: d */
    float f8541d;

    /* renamed from: e */
    int f8542e;

    /* renamed from: n */
    private CropImage f8543n;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.cnlaunch.golo3.view.selectimg.ImageViewTouchBase, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f8720h.f8736a != null) {
            Iterator<HighlightView> it = this.f8538a.iterator();
            while (it.hasNext()) {
                HighlightView next = it.next();
                next.f8704h.set(getImageMatrix());
                next.m9025b();
                if (next.f8698b) {
                    m9097c(next);
                }
            }
        }
    }

    public CropImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8538a = new ArrayList<>();
        this.f8539b = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.cnlaunch.golo3.view.selectimg.ImageViewTouchBase
    /* renamed from: a */
    public final void mo9021a(float f, float f2, float f3) {
        super.mo9021a(f, f2, f3);
        Iterator<HighlightView> it = this.f8538a.iterator();
        while (it.hasNext()) {
            HighlightView next = it.next();
            next.f8704h.set(getImageMatrix());
            next.m9025b();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.cnlaunch.golo3.view.selectimg.ImageViewTouchBase
    /* renamed from: a */
    public final void mo9022a(float f, float f2) {
        super.mo9022a(f, f2);
        for (int i = 0; i < this.f8538a.size(); i++) {
            HighlightView highlightView = this.f8538a.get(i);
            highlightView.f8704h.postTranslate(f, f2);
            highlightView.m9025b();
        }
    }

    /* renamed from: a */
    private void m9100a(MotionEvent motionEvent) {
        int i = 0;
        for (int i2 = 0; i2 < this.f8538a.size(); i2++) {
            HighlightView highlightView = this.f8538a.get(i2);
            highlightView.f8698b = false;
            highlightView.m9025b();
        }
        while (true) {
            if (i >= this.f8538a.size()) {
                break;
            }
            HighlightView highlightView2 = this.f8538a.get(i);
            if (highlightView2.m9028a(motionEvent.getX(), motionEvent.getY()) == 1) {
                i++;
            } else if (!highlightView2.f8698b) {
                highlightView2.f8698b = true;
                highlightView2.m9025b();
            }
        }
        invalidate();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        CropImage cropImage = this.f8543n;
        int i = 0;
        if (cropImage.f8558d) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (cropImage.f8557c) {
                    m9100a(motionEvent);
                    break;
                } else {
                    while (true) {
                        if (i >= this.f8538a.size()) {
                            break;
                        } else {
                            HighlightView highlightView = this.f8538a.get(i);
                            int m9028a = highlightView.m9028a(motionEvent.getX(), motionEvent.getY());
                            if (m9028a != 1) {
                                this.f8542e = m9028a;
                                this.f8539b = highlightView;
                                this.f8540c = motionEvent.getX();
                                this.f8541d = motionEvent.getY();
                                this.f8539b.m9027a(m9028a == 32 ? HighlightView.EnumC1651a.Move$20488b3f : HighlightView.EnumC1651a.Grow$20488b3f);
                                break;
                            } else {
                                i++;
                            }
                        }
                    }
                }
            case 1:
                if (cropImage.f8557c) {
                    for (int i2 = 0; i2 < this.f8538a.size(); i2++) {
                        HighlightView highlightView2 = this.f8538a.get(i2);
                        if (highlightView2.f8698b) {
                            cropImage.f8559e = highlightView2;
                            for (int i3 = 0; i3 < this.f8538a.size(); i3++) {
                                if (i3 != i2) {
                                    this.f8538a.get(i3).f8699c = true;
                                }
                            }
                            m9097c(highlightView2);
                            this.f8543n.f8557c = false;
                            return true;
                        }
                    }
                } else {
                    HighlightView highlightView3 = this.f8539b;
                    if (highlightView3 != null) {
                        m9097c(highlightView3);
                        this.f8539b.m9027a(HighlightView.EnumC1651a.None$20488b3f);
                    }
                }
                this.f8539b = null;
                break;
            case 2:
                if (cropImage.f8557c) {
                    m9100a(motionEvent);
                    break;
                } else {
                    HighlightView highlightView4 = this.f8539b;
                    if (highlightView4 != null) {
                        int i4 = this.f8542e;
                        float x = motionEvent.getX() - this.f8540c;
                        float y = motionEvent.getY() - this.f8541d;
                        Rect m9029a = highlightView4.m9029a();
                        if (i4 != 1) {
                            if (i4 == 32) {
                                float width = x * (highlightView4.f8703g.width() / m9029a.width());
                                float height = y * (highlightView4.f8703g.height() / m9029a.height());
                                Rect rect = new Rect(highlightView4.f8701e);
                                highlightView4.f8703g.offset(width, height);
                                highlightView4.f8703g.offset(Math.max((float) ColumnText.GLOBAL_SPACE_CHAR_RATIO, highlightView4.f8702f.left - highlightView4.f8703g.left), Math.max((float) ColumnText.GLOBAL_SPACE_CHAR_RATIO, highlightView4.f8702f.top - highlightView4.f8703g.top));
                                highlightView4.f8703g.offset(Math.min((float) ColumnText.GLOBAL_SPACE_CHAR_RATIO, highlightView4.f8702f.right - highlightView4.f8703g.right), Math.min((float) ColumnText.GLOBAL_SPACE_CHAR_RATIO, highlightView4.f8702f.bottom - highlightView4.f8703g.bottom));
                                highlightView4.f8701e = highlightView4.m9029a();
                                rect.union(highlightView4.f8701e);
                                rect.inset(-10, -10);
                                highlightView4.f8697a.invalidate();
                            } else {
                                if ((i4 & 6) == 0) {
                                    x = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
                                }
                                if ((i4 & 24) == 0) {
                                    y = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
                                }
                                float width2 = x * (highlightView4.f8703g.width() / m9029a.width());
                                float height2 = y * (highlightView4.f8703g.height() / m9029a.height());
                                float f = ((i4 & 2) != 0 ? -1 : 1) * width2;
                                float f2 = ((i4 & 8) == 0 ? 1 : -1) * height2;
                                if (highlightView4.f8705i) {
                                    if (f != ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
                                        f2 = f / highlightView4.f8706j;
                                    } else if (f2 != ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
                                        f = f2 * highlightView4.f8706j;
                                    }
                                }
                                RectF rectF = new RectF(highlightView4.f8703g);
                                if (f > ColumnText.GLOBAL_SPACE_CHAR_RATIO && rectF.width() + (f * 2.0f) > highlightView4.f8702f.width()) {
                                    f = (highlightView4.f8702f.width() - rectF.width()) / 2.0f;
                                    if (highlightView4.f8705i) {
                                        f2 = f / highlightView4.f8706j;
                                    }
                                }
                                if (f2 > ColumnText.GLOBAL_SPACE_CHAR_RATIO && rectF.height() + (f2 * 2.0f) > highlightView4.f8702f.height()) {
                                    f2 = (highlightView4.f8702f.height() - rectF.height()) / 2.0f;
                                    if (highlightView4.f8705i) {
                                        f = highlightView4.f8706j * f2;
                                    }
                                }
                                rectF.inset(-f, -f2);
                                if (rectF.width() >= 25.0f) {
                                    if (rectF.height() >= (highlightView4.f8705i ? 25.0f / highlightView4.f8706j : 25.0f)) {
                                        if (rectF.left < highlightView4.f8702f.left) {
                                            rectF.offset(highlightView4.f8702f.left - rectF.left, ColumnText.GLOBAL_SPACE_CHAR_RATIO);
                                        } else if (rectF.right > highlightView4.f8702f.right) {
                                            rectF.offset(-(rectF.right - highlightView4.f8702f.right), ColumnText.GLOBAL_SPACE_CHAR_RATIO);
                                        }
                                        if (rectF.top < highlightView4.f8702f.top) {
                                            rectF.offset(ColumnText.GLOBAL_SPACE_CHAR_RATIO, highlightView4.f8702f.top - rectF.top);
                                        } else if (rectF.bottom > highlightView4.f8702f.bottom) {
                                            rectF.offset(ColumnText.GLOBAL_SPACE_CHAR_RATIO, -(rectF.bottom - highlightView4.f8702f.bottom));
                                        }
                                        highlightView4.f8703g.set(rectF);
                                        highlightView4.f8701e = highlightView4.m9029a();
                                        highlightView4.f8697a.invalidate();
                                    }
                                }
                            }
                        }
                        this.f8540c = motionEvent.getX();
                        this.f8541d = motionEvent.getY();
                        m9098b(this.f8539b);
                        break;
                    }
                }
                break;
        }
        switch (motionEvent.getAction()) {
            case 1:
                m9023a();
                break;
            case 2:
                m9023a();
                break;
        }
        return true;
    }

    /* renamed from: b */
    private void m9098b(HighlightView highlightView) {
        Rect rect = highlightView.f8701e;
        int max = Math.max(0, getLeft() - rect.left);
        int min = Math.min(0, getRight() - rect.right);
        int max2 = Math.max(0, getTop() - rect.top);
        int min2 = Math.min(0, getBottom() - rect.bottom);
        if (max == 0) {
            max = min;
        }
        if (max2 != 0) {
            min2 = max2;
        }
        if (max == 0 && min2 == 0) {
            return;
        }
        m9016b(max, min2);
    }

    /* renamed from: c */
    private void m9097c(HighlightView highlightView) {
        Rect rect = highlightView.f8701e;
        float max = Math.max(1.0f, Math.min((getWidth() / rect.width()) * 0.6f, (getHeight() / rect.height()) * 0.6f) * getScale());
        if (Math.abs(max - getScale()) / max > 0.1d) {
            float[] fArr = {highlightView.f8703g.centerX(), highlightView.f8703g.centerY()};
            getImageMatrix().mapPoints(fArr);
            m9015b(max, fArr[0], fArr[1]);
        }
        m9098b(highlightView);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < this.f8538a.size(); i++) {
            HighlightView highlightView = this.f8538a.get(i);
            if (!highlightView.f8699c) {
                canvas.save();
                Path path = new Path();
                if (!highlightView.f8698b) {
                    highlightView.f8712p.setColor(-16777216);
                    canvas.drawRect(highlightView.f8701e, highlightView.f8712p);
                } else {
                    Rect rect = new Rect();
                    highlightView.f8697a.getDrawingRect(rect);
                    if (highlightView.f8707k) {
                        float width = highlightView.f8701e.width() / 2.0f;
                        path.addCircle(highlightView.f8701e.left + width, highlightView.f8701e.top + (highlightView.f8701e.height() / 2.0f), width, Path.Direction.CW);
                        highlightView.f8712p.setColor(-1112874);
                    } else {
                        path.addRect(new RectF(highlightView.f8701e), Path.Direction.CW);
                        highlightView.f8712p.setColor(-30208);
                    }
                    Region region = new Region();
                    region.set(rect);
                    region.op(highlightView.f8701e, Region.Op.DIFFERENCE);
                    RegionIterator regionIterator = new RegionIterator(region);
                    Rect rect2 = new Rect();
                    while (regionIterator.next(rect2)) {
                        canvas.drawRect(rect2, highlightView.f8698b ? highlightView.f8710n : highlightView.f8711o);
                    }
                    canvas.restore();
                    canvas.drawPath(path, highlightView.f8712p);
                    if (highlightView.f8700d == HighlightView.EnumC1651a.Grow$20488b3f && highlightView.f8707k) {
                        int intrinsicWidth = highlightView.f8708l.getIntrinsicWidth();
                        int intrinsicHeight = highlightView.f8708l.getIntrinsicHeight();
                        double cos = Math.cos(0.7853981633974483d);
                        double width2 = highlightView.f8701e.width();
                        Double.isNaN(width2);
                        int round = (int) Math.round(cos * (width2 / 2.0d));
                        int width3 = ((highlightView.f8701e.left + (highlightView.f8701e.width() / 2)) + round) - (intrinsicWidth / 2);
                        int height = ((highlightView.f8701e.top + (highlightView.f8701e.height() / 2)) - round) - (intrinsicHeight / 2);
                        highlightView.f8708l.setBounds(width3, height, highlightView.f8708l.getIntrinsicWidth() + width3, highlightView.f8708l.getIntrinsicHeight() + height);
                        highlightView.f8708l.draw(canvas);
                    }
                    if (!highlightView.f8707k) {
                        int i2 = highlightView.f8701e.left + 1;
                        int i3 = highlightView.f8701e.right + 1;
                        int i4 = highlightView.f8701e.top + 4;
                        int i5 = highlightView.f8701e.bottom + 3;
                        int intrinsicWidth2 = highlightView.f8708l.getIntrinsicWidth() / 2;
                        int intrinsicHeight2 = highlightView.f8708l.getIntrinsicHeight() / 2;
                        int i6 = i2 - intrinsicWidth2;
                        int i7 = i4 - intrinsicHeight2;
                        int i8 = i2 + intrinsicWidth2;
                        int i9 = i4 + intrinsicHeight2;
                        highlightView.f8709m.setBounds(i6, i7, i8, i9);
                        highlightView.f8709m.draw(canvas);
                        int i10 = i3 - intrinsicWidth2;
                        int i11 = i3 + intrinsicWidth2;
                        highlightView.f8708l.setBounds(i10, i7, i11, i9);
                        highlightView.f8708l.draw(canvas);
                        int i12 = i5 - intrinsicHeight2;
                        int i13 = i5 + intrinsicHeight2;
                        highlightView.f8708l.setBounds(i6, i12, i8, i13);
                        highlightView.f8708l.draw(canvas);
                        highlightView.f8709m.setBounds(i10, i12, i11, i13);
                        highlightView.f8709m.draw(canvas);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public final void m9099a(HighlightView highlightView) {
        this.f8538a.clear();
        this.f8538a.add(highlightView);
        invalidate();
    }

    public void setCropImage(CropImage cropImage) {
        this.f8543n = cropImage;
    }

    /* renamed from: a */
    public final void m9101a(Bitmap bitmap) {
        setImageBitmap(bitmap);
        setImageBitmapResetBase$1fdc9e65(bitmap);
        setImageMatrix(getImageViewMatrix());
        int m9012c = this.f8720h.m9012c();
        int m9013b = this.f8720h.m9013b();
        Rect rect = new Rect(0, 0, m9012c, m9013b);
        int min = (Math.min(m9012c, m9013b) * 4) / 5;
        int i = (m9012c - min) / 2;
        int i2 = (m9013b - min) / 2;
        RectF rectF = new RectF(i, i2, i + min, i2 + min);
        HighlightView highlightView = new HighlightView(this);
        highlightView.m9026a(getImageViewMatrix(), rect, rectF);
        highlightView.f8698b = true;
        m9099a(highlightView);
        m9097c(highlightView);
        highlightView.m9027a(HighlightView.EnumC1651a.None$20488b3f);
        m9023a();
        invalidate();
    }
}
