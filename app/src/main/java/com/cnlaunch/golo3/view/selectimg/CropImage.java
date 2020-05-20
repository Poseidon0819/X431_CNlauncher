package com.cnlaunch.golo3.view.selectimg;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.os.Environment;
import android.os.Handler;
import com.cnlaunch.p132e.p133a.C1464a;
import com.itextpdf.text.pdf.ColumnText;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/* renamed from: com.cnlaunch.golo3.view.selectimg.a */
/* loaded from: classes.dex */
public final class CropImage {

    /* renamed from: a */
    public static final File f8555a = Environment.getExternalStorageDirectory();

    /* renamed from: b */
    public static final File f8556b = new File(f8555a, "weixin");

    /* renamed from: c */
    public boolean f8557c;

    /* renamed from: d */
    public boolean f8558d;

    /* renamed from: e */
    public HighlightView f8559e;

    /* renamed from: f */
    Context f8560f;

    /* renamed from: g */
    Handler f8561g;

    /* renamed from: h */
    CropImageView f8562h;

    /* renamed from: i */
    Bitmap f8563i;

    /* renamed from: j */
    Runnable f8564j = new RunnableC1647f(this);

    public CropImage(Context context, CropImageView cropImageView, Handler handler) {
        this.f8560f = context;
        this.f8562h = cropImageView;
        this.f8562h.setCropImage(this);
        this.f8561g = handler;
    }

    /* renamed from: a */
    public final void m9094a(float f) {
        if (((Activity) this.f8560f).isFinishing()) {
            return;
        }
        m9088a(this.f8560f.getResources().getString(C1464a.C1470f.imWait), new RunnableC1634b(this, f), this.f8561g);
    }

    /* renamed from: a */
    public static float m9089a(String str) {
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 1);
            if (attributeInt != 3) {
                if (attributeInt != 6) {
                    if (attributeInt != 8) {
                        return ColumnText.GLOBAL_SPACE_CHAR_RATIO;
                    }
                    return 270.0f;
                }
                return 90.0f;
            }
            return 180.0f;
        } catch (IOException e) {
            e.printStackTrace();
            return ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        }
    }

    /* renamed from: a */
    public static Bitmap m9093a(Bitmap bitmap, float f) {
        Matrix matrix = new Matrix();
        matrix.setRotate(f);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
    }

    /* renamed from: a */
    public static String m9092a(Bitmap bitmap, String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            } else {
                file.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(str);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            return str;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m9088a(String str, Runnable runnable, Handler handler) {
        new Thread(new RunnableC1624a(str, runnable, handler)).start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CropImage.java */
    /* renamed from: com.cnlaunch.golo3.view.selectimg.a$a */
    /* loaded from: classes.dex */
    public class RunnableC1624a implements Runnable {

        /* renamed from: a */
        Handler f8565a;

        /* renamed from: c */
        private String f8567c;

        /* renamed from: d */
        private Runnable f8568d;

        public RunnableC1624a(String str, Runnable runnable, Handler handler) {
            this.f8567c = str;
            this.f8568d = runnable;
            this.f8565a = handler;
        }

        @Override // java.lang.Runnable
        public final void run() {
            CountDownLatch countDownLatch = new CountDownLatch(1);
            this.f8565a.post(new RunnableC1649h(this, countDownLatch));
            try {
                countDownLatch.await();
                try {
                    this.f8568d.run();
                } finally {
                    Handler handler = this.f8565a;
                    handler.sendMessage(handler.obtainMessage(2001));
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
