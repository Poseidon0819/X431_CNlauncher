package com.unionpay.mobile.android.resource;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import com.itextpdf.text.html.HtmlTags;
import com.unionpay.mobile.android.utils.C4387h;
import com.unionpay.mobile.android.utils.C4390k;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* renamed from: com.unionpay.mobile.android.resource.c */
/* loaded from: classes2.dex */
public final class C4342c {

    /* renamed from: c */
    private static C4342c f23015c;

    /* renamed from: a */
    private HashMap<Integer, WeakReference<Drawable.ConstantState>> f23016a = new HashMap<>();

    /* renamed from: b */
    private Context f23017b;

    private C4342c(Context context) {
        this.f23017b = null;
        this.f23017b = context;
    }

    /* renamed from: a */
    public static C4342c m1036a(Context context) {
        if (f23015c == null) {
            f23015c = new C4342c(context);
        }
        return f23015c;
    }

    /* renamed from: a */
    public final Drawable m1037a(int i, int i2, int i3) {
        Drawable m852a;
        Drawable drawable;
        Drawable ninePatchDrawable;
        if (i < 0) {
            return null;
        }
        WeakReference<Drawable.ConstantState> weakReference = this.f23016a.get(Integer.valueOf(i));
        if (weakReference != null) {
            Drawable.ConstantState constantState = weakReference.get();
            if (constantState != null) {
                return constantState.newDrawable();
            }
            this.f23016a.remove(Integer.valueOf(i));
        }
        int i4 = (i / 1000) * 1000;
        int i5 = i - i4;
        if (i4 == 2000) {
            int[] iArr = C4341b.f23007a[i5];
            m852a = C4387h.m852a(m1037a(iArr[0], i2, i3), m1037a(iArr[1], i2, i3), m1037a(iArr[2], i2, i3), m1037a(iArr[3], i2, i3));
        } else if (i4 != 3000) {
            m852a = i4 != 4000 ? null : C4387h.m855a(C4341b.f23012f[i5], C4341b.f23013g[i5], C4341b.f23014h[i5]);
        } else {
            int i6 = C4341b.f23011e[i5];
            int[] iArr2 = C4341b.f23010d[i5];
            float[] fArr = C4341b.f23008b[i5];
            float[] fArr2 = C4341b.f23009c[i5];
            m852a = C4387h.m853a(i6, iArr2, fArr, fArr2[0], fArr2[1], fArr2[2], fArr2[3]);
        }
        if (m852a == null) {
            InputStream resourceAsStream = C4340a.class.getClassLoader().getResourceAsStream("assets/data.bin");
            DataInputStream dataInputStream = new DataInputStream(resourceAsStream);
            int i7 = (i - 1000) * 8;
            int i8 = i7;
            while (true) {
                long j = i8;
                try {
                    long skip = dataInputStream.skip(j);
                    if (skip >= j) {
                        break;
                    }
                    i8 = (int) (j - skip);
                } catch (IOException e) {
                    e.printStackTrace();
                    drawable = null;
                }
            }
            int readInt = dataInputStream.readInt();
            int readInt2 = dataInputStream.readInt();
            int i9 = readInt - (i7 + 8);
            while (true) {
                long j2 = i9;
                long skip2 = dataInputStream.skip(j2);
                if (skip2 >= j2) {
                    break;
                }
                i9 = (int) (j2 - skip2);
            }
            dataInputStream.mark(readInt2);
            Bitmap decodeStream = BitmapFactory.decodeStream(dataInputStream);
            Rect rect = new Rect();
            if (decodeStream.getNinePatchChunk() == null) {
                if (-1 != i3 && -1 != i2) {
                    Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeStream, i2, i3, true);
                    if (createScaledBitmap != decodeStream) {
                        decodeStream.recycle();
                    }
                    drawable = new BitmapDrawable(this.f23017b.getResources(), createScaledBitmap);
                } else if (-1 != i3 && -1 == i2) {
                    int width = (int) ((decodeStream.getWidth() / decodeStream.getHeight()) * i3);
                    C4390k.m838a(HtmlTags.IMG, "w=" + width + ",h=" + i3);
                    Bitmap createScaledBitmap2 = Bitmap.createScaledBitmap(decodeStream, width, i3, true);
                    if (createScaledBitmap2 != decodeStream) {
                        decodeStream.recycle();
                    }
                    drawable = new BitmapDrawable(this.f23017b.getResources(), createScaledBitmap2);
                } else if (-1 == i2 || -1 != i3) {
                    ninePatchDrawable = new BitmapDrawable(this.f23017b.getResources(), decodeStream);
                } else {
                    Bitmap createScaledBitmap3 = Bitmap.createScaledBitmap(decodeStream, i2, (int) ((decodeStream.getHeight() / decodeStream.getWidth()) * i2), true);
                    if (createScaledBitmap3 != decodeStream) {
                        decodeStream.recycle();
                    }
                    drawable = new BitmapDrawable(this.f23017b.getResources(), createScaledBitmap3);
                }
                dataInputStream.close();
                resourceAsStream.close();
            } else {
                ninePatchDrawable = new NinePatchDrawable(this.f23017b.getResources(), decodeStream, decodeStream.getNinePatchChunk(), rect, null);
            }
            drawable = ninePatchDrawable;
            dataInputStream.close();
            resourceAsStream.close();
        } else {
            drawable = m852a;
        }
        if (drawable != null) {
            this.f23016a.put(Integer.valueOf(i), new WeakReference<>(drawable.getConstantState()));
        }
        return drawable;
    }

    /* renamed from: a */
    public final void m1038a() {
        for (WeakReference<Drawable.ConstantState> weakReference : this.f23016a.values()) {
            Drawable.ConstantState constantState = weakReference.get();
            if (constantState != null) {
                Drawable newDrawable = constantState.newDrawable();
                if (newDrawable instanceof BitmapDrawable) {
                    ((BitmapDrawable) newDrawable).getBitmap().recycle();
                }
            }
        }
        this.f23016a.clear();
        f23015c = null;
    }
}
