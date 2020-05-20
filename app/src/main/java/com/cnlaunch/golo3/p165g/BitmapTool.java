package com.cnlaunch.golo3.p165g;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.media.ThumbnailUtils;
import android.util.Log;
import com.cnlaunch.golo3.p160b.ApplicationConfig;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* renamed from: com.cnlaunch.golo3.g.a */
/* loaded from: classes.dex */
public final class BitmapTool {

    /* renamed from: a */
    private static BitmapFactory.Options f8446a = new BitmapFactory.Options();

    /* renamed from: a */
    public static Bitmap m9152a(String str, int i) {
        ByteArrayOutputStream byteArrayOutputStream;
        while (str != null) {
            File file = new File(str);
            if (!file.exists()) {
                return null;
            }
            try {
                long length = file.length() / 1024;
                Log.i("jh", "source data size -------------------------".concat(String.valueOf(length)));
                Log.i("jh", "maxKb size--------------------------------".concat(String.valueOf(i)));
                if (length > i) {
                    if (f8446a.inSampleSize == 0) {
                        f8446a.inSampleSize = 2;
                    } else {
                        f8446a.inSampleSize *= 2;
                    }
                    Log.i("jh", "inSampleSize-------------------------" + f8446a.inSampleSize);
                    f8446a.inJustDecodeBounds = false;
                    Bitmap decodeFile = BitmapFactory.decodeFile(str, f8446a);
                    Log.i("jh", "bitmap is return-------------------------");
                    decodeFile.compress(Bitmap.CompressFormat.JPEG, 100, new ByteArrayOutputStream());
                    Log.i("jh", "zip source data size ---------------------" + (byteArrayOutputStream.toByteArray().length / 1000));
                    f8446a.inSampleSize = 0;
                    return decodeFile;
                }
                return BitmapFactory.decodeFile(str);
            } catch (Exception e) {
                Log.i("jh", "e---------------------------------".concat(String.valueOf(e)));
            }
        }
        return null;
    }

    /* renamed from: a */
    public static Bitmap m9153a(String str) {
        GoloLog.m9133a();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.outWidth = 100;
        options.outHeight = (options.outHeight * 100) / options.outWidth;
        try {
            long length = new File(str).length() / 1024;
            if (length > 400) {
                BitmapFactory.Options options2 = new BitmapFactory.Options();
                options2.inJustDecodeBounds = true;
                options2.inSampleSize = (int) (length / 400);
                options2.inJustDecodeBounds = false;
                options2.outHeight = options.outHeight;
                options2.outWidth = options.outWidth;
                Bitmap decodeFile = BitmapFactory.decodeFile(str, options2);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                decodeFile.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
                if (byteArrayOutputStream.toByteArray().length / 1024 > 400) {
                    for (int length2 = byteArrayOutputStream.toByteArray().length / 1024; length2 > 400; length2 = byteArrayOutputStream.toByteArray().length / 1024) {
                        StringBuilder sb = new StringBuilder("BitmapCreateAssignThumbBySize while len=");
                        sb.append(length2);
                        sb.append("//400");
                        GoloLog.m9133a();
                        options2.inSampleSize++;
                        byteArrayOutputStream.reset();
                        BitmapFactory.decodeFile(str, options2).compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
                    }
                    return BitmapFactory.decodeStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()), null, null);
                }
                return decodeFile;
            }
            return BitmapFactory.decodeFile(str);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    public static Bitmap m9155a(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f = 100.0f / (width > height ? width : height);
        float f2 = width;
        int i = (int) (f2 * f);
        float f3 = height;
        int i2 = (int) (f * f3);
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(1);
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        Matrix matrix = new Matrix();
        matrix.setScale(i / f2, i2 / f3);
        canvas.drawBitmap(bitmap, matrix, paint);
        return createBitmap;
    }

    /* renamed from: b */
    public static Bitmap m9150b(String str, int i) {
        Bitmap createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(str, 1);
        Bitmap decodeResource = BitmapFactory.decodeResource(ApplicationConfig.f7803b, i);
        int width = createVideoThumbnail.getWidth();
        int height = createVideoThumbnail.getHeight();
        int i2 = width < height ? width : height;
        int width2 = decodeResource.getWidth();
        int height2 = decodeResource.getHeight();
        float f = (i2 / 2.0f) / (width2 < height2 ? width2 : height2);
        Canvas canvas = new Canvas(createVideoThumbnail);
        Paint paint = new Paint(1);
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        Matrix matrix = new Matrix();
        matrix.setScale(f, f);
        matrix.postTranslate((width - (width2 * f)) / 2.0f, (height - (height2 * f)) / 2.0f);
        canvas.drawBitmap(decodeResource, matrix, paint);
        decodeResource.recycle();
        return createVideoThumbnail;
    }

    /* renamed from: a */
    public static void m9154a(Bitmap bitmap, File file) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        FileOutputStream fileOutputStream = null;
        try {
            try {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    fileOutputStream2.write(byteArray, 0, byteArray.length);
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                } catch (IOException e3) {
                    e = e3;
                    fileOutputStream = fileOutputStream2;
                    e.printStackTrace();
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e7) {
                            e7.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e8) {
                e = e8;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: a */
    public static Bitmap m9151a(String str, int i, int i2) {
        int i3;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        int i4 = options.outWidth;
        int i5 = options.outHeight;
        if (i4 > i5) {
            i3 = i4 / i;
        } else {
            i3 = i5 / i2;
        }
        int i6 = i3 > 1 ? i3 : 1;
        options.inJustDecodeBounds = false;
        options.inSampleSize = i6;
        try {
            return BitmapFactory.decodeFile(str, options);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
