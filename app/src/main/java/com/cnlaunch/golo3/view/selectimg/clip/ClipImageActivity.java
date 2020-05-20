package com.cnlaunch.golo3.view.selectimg.clip;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.ExifInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import com.cnlaunch.golo3.p161c.BaseActivity;
import com.cnlaunch.p132e.p133a.C1464a;
import com.itextpdf.text.pdf.codec.TIFFConstants;
import java.io.IOException;
import org.codehaus.jackson.org.objectweb.asm.Opcodes;

/* loaded from: classes.dex */
public class ClipImageActivity extends BaseActivity implements View.OnClickListener {

    /* renamed from: A */
    private TextView f8623A;

    /* renamed from: B */
    private TextView f8624B;

    /* renamed from: C */
    private String f8625C;

    /* renamed from: D */
    private String f8626D;

    /* renamed from: E */
    private int f8627E;

    /* renamed from: F */
    private int f8628F;

    /* renamed from: G */
    private int f8629G;

    /* renamed from: H */
    private int f8630H;

    /* renamed from: I */
    private int f8631I;

    /* renamed from: J */
    private ProgressDialog f8632J;

    /* renamed from: K */
    private Handler f8633K = new HandlerC1640c(this);

    /* renamed from: z */
    private ClipImageView f8634z;

    @Override // com.cnlaunch.golo3.p161c.BaseActivity, android.support.p012v4.app.FragmentActivity, android.support.p012v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    public void onCreate(Bundle bundle) {
        int intExtra = getIntent().getIntExtra("theme", 0);
        if (intExtra > 0) {
            setTheme(intExtra);
        }
        super.onCreate(bundle);
        setContentView(C1464a.C1469e.activity_clip_image);
        this.f8634z = (ClipImageView) findViewById(C1464a.C1468d.clip_image_view);
        this.f8623A = (TextView) findViewById(C1464a.C1468d.cancel);
        this.f8624B = (TextView) findViewById(C1464a.C1468d.clip);
        this.f8623A.setOnClickListener(this);
        this.f8624B.setOnClickListener(this);
        Intent intent = getIntent();
        C1636a c1636a = new C1636a();
        c1636a.f8635a = intent.getIntExtra("aspectX", 1);
        c1636a.f8636b = intent.getIntExtra("aspectY", 1);
        c1636a.f8637c = intent.getIntExtra("maxWidth", 0);
        c1636a.f8639e = intent.getStringExtra("tip");
        c1636a.f8638d = intent.getIntExtra("borderWidth", 0);
        c1636a.f8642h = intent.getBooleanExtra("isCircle", false);
        c1636a.f8640f = intent.getStringExtra("inputPath");
        c1636a.f8641g = intent.getStringExtra("outputPath");
        this.f8625C = c1636a.f8641g;
        this.f8626D = c1636a.f8640f;
        this.f8627E = c1636a.f8637c;
        ClipImageView clipImageView = this.f8634z;
        int i = c1636a.f8635a;
        int i2 = c1636a.f8636b;
        clipImageView.f8643a = i;
        clipImageView.f8644b = i2;
        this.f8634z.setTip(c1636a.f8639e);
        this.f8634z.setMaxOutputWidth(this.f8627E);
        if (c1636a.f8638d > 0) {
            this.f8634z.setmClipBorderWidth(c1636a.f8638d);
        }
        this.f8634z.setmDrawCircleFlag(c1636a.f8642h);
        this.f8634z.post(new RunnableC1638a(this));
        this.f8632J = new ProgressDialog(this);
        this.f8632J.setMessage(getString(C1464a.C1470f.imWait));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static int m9054b(int i, int i2) {
        int i3 = 1;
        for (int i4 = i / 2; i4 > i2; i4 /= 2) {
            i3 *= 2;
        }
        return i3;
    }

    /* renamed from: a */
    public static int m9055a(String str) {
        ExifInterface exifInterface;
        if (str != null) {
            try {
                exifInterface = new ExifInterface(str);
            } catch (IOException e) {
                e.printStackTrace();
                exifInterface = null;
            }
            if (exifInterface != null) {
                int attributeInt = exifInterface.getAttributeInt("Orientation", 1);
                if (attributeInt != 3) {
                    if (attributeInt != 6) {
                        if (attributeInt != 8) {
                            return 0;
                        }
                        return TIFFConstants.TIFFTAG_IMAGEDESCRIPTION;
                    }
                    return 90;
                }
                return Opcodes.GETFIELD;
            }
            return 0;
        }
        return 0;
    }

    @Override // com.cnlaunch.golo3.p161c.BaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == C1464a.C1468d.cancel) {
            onBackPressed();
        }
        if (id == C1464a.C1468d.clip) {
            if (this.f8625C != null) {
                this.f8632J.show();
                new AsyncTaskC1639b(this).execute(new Void[0]);
                return;
            }
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(10)
    /* renamed from: c */
    public Bitmap m9051c() {
        Rect rect;
        if (this.f8629G <= 1) {
            return this.f8634z.m9038b();
        }
        float[] clipMatrixValues = this.f8634z.getClipMatrixValues();
        float f = clipMatrixValues[0];
        float f2 = clipMatrixValues[2];
        float f3 = clipMatrixValues[5];
        Rect clipBorder = this.f8634z.getClipBorder();
        float f4 = (((-f2) + clipBorder.left) / f) * this.f8629G;
        float f5 = (((-f3) + clipBorder.top) / f) * this.f8629G;
        float width = (clipBorder.width() / f) * this.f8629G;
        RectF rectF = new RectF(f4, f5, f4 + width, ((clipBorder.height() / f) * this.f8629G) + f5);
        int i = this.f8628F;
        if (i == 90) {
            rect = new Rect((int) rectF.top, (int) (this.f8631I - rectF.right), (int) rectF.bottom, (int) (this.f8631I - rectF.left));
        } else if (i == 180) {
            rect = new Rect((int) (this.f8630H - rectF.right), (int) (this.f8631I - rectF.bottom), (int) (this.f8630H - rectF.left), (int) (this.f8631I - rectF.top));
        } else if (i == 270) {
            rect = new Rect((int) (this.f8630H - rectF.bottom), (int) rectF.left, (int) (this.f8630H - rectF.top), (int) rectF.right);
        } else {
            rect = new Rect((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        Matrix matrix = new Matrix();
        matrix.setRotate(this.f8628F);
        int i2 = this.f8627E;
        if (i2 > 0 && width > i2) {
            options.inSampleSize = m9054b((int) width, i2);
            float f6 = this.f8627E / (width / options.inSampleSize);
            matrix.postScale(f6, f6);
        }
        BitmapRegionDecoder bitmapRegionDecoder = null;
        try {
            try {
                bitmapRegionDecoder = BitmapRegionDecoder.newInstance(this.f8626D, false);
                Bitmap decodeRegion = bitmapRegionDecoder.decodeRegion(rect, options);
                this.f8634z.post(new RunnableC1641d(this));
                Bitmap createBitmap = Bitmap.createBitmap(decodeRegion, 0, 0, decodeRegion.getWidth(), decodeRegion.getHeight(), matrix, false);
                if (bitmapRegionDecoder != null && !bitmapRegionDecoder.isRecycled()) {
                    bitmapRegionDecoder.recycle();
                }
                return createBitmap;
            } catch (Exception e) {
                e.printStackTrace();
                Bitmap m9038b = this.f8634z.m9038b();
                if (bitmapRegionDecoder != null && !bitmapRegionDecoder.isRecycled()) {
                    bitmapRegionDecoder.recycle();
                }
                return m9038b;
            }
        } catch (Throwable th) {
            if (bitmapRegionDecoder != null && !bitmapRegionDecoder.isRecycled()) {
                bitmapRegionDecoder.recycle();
            }
            throw th;
        }
    }

    @Override // android.support.p012v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        setResult(0, getIntent());
        super.onBackPressed();
    }

    /* renamed from: com.cnlaunch.golo3.view.selectimg.clip.ClipImageActivity$a */
    /* loaded from: classes.dex */
    public static class C1636a {

        /* renamed from: a */
        int f8635a;

        /* renamed from: b */
        int f8636b;

        /* renamed from: c */
        int f8637c;

        /* renamed from: d */
        int f8638d;

        /* renamed from: e */
        String f8639e;

        /* renamed from: f */
        String f8640f;

        /* renamed from: g */
        String f8641g;

        /* renamed from: h */
        boolean f8642h;

        C1636a() {
        }
    }
}
