package com.baidu.mapapi.map;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import com.itextpdf.text.pdf.ColumnText;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes.dex */
public final class BitmapDescriptor {

    /* renamed from: a */
    Bitmap f4982a;

    /* renamed from: b */
    private Bundle f4983b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BitmapDescriptor(Bitmap bitmap) {
        if (bitmap != null) {
            this.f4982a = m11218a(bitmap, bitmap.getWidth(), bitmap.getHeight());
        }
    }

    /* renamed from: a */
    private Bitmap m11218a(Bitmap bitmap, int i, int i2) {
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        canvas.drawBitmap(bitmap, ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, paint);
        return createBitmap;
    }

    /* renamed from: a */
    final byte[] m11219a() {
        ByteBuffer allocate = ByteBuffer.allocate(this.f4982a.getWidth() * this.f4982a.getHeight() * 4);
        this.f4982a.copyPixelsToBuffer(allocate);
        return allocate.array();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public final Bundle m11217b() {
        if (this.f4982a != null) {
            if (this.f4983b == null) {
                Bundle bundle = new Bundle();
                bundle.putInt("image_width", this.f4982a.getWidth());
                bundle.putInt("image_height", this.f4982a.getHeight());
                byte[] m11219a = m11219a();
                bundle.putByteArray("image_data", m11219a);
                MessageDigest messageDigest = null;
                try {
                    messageDigest = MessageDigest.getInstance("MD5");
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }
                messageDigest.update(m11219a, 0, m11219a.length);
                byte[] digest = messageDigest.digest();
                StringBuilder sb = new StringBuilder("");
                for (byte b : digest) {
                    sb.append(Integer.toString((b & 255) + 256, 16).substring(1));
                }
                bundle.putString("image_hashcode", sb.toString());
                this.f4983b = bundle;
            }
            return this.f4983b;
        }
        throw new IllegalStateException("the bitmap has been recycled! you can not use it again");
    }

    public final Bitmap getBitmap() {
        return this.f4982a;
    }

    public final void recycle() {
        Bitmap bitmap = this.f4982a;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        this.f4982a.recycle();
        this.f4982a = null;
    }
}
