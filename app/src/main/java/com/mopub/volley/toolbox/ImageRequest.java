package com.mopub.volley.toolbox;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.mopub.volley.DefaultRetryPolicy;
import com.mopub.volley.NetworkResponse;
import com.mopub.volley.ParseError;
import com.mopub.volley.Request;
import com.mopub.volley.Response;
import com.mopub.volley.VolleyLog;

/* loaded from: classes2.dex */
public class ImageRequest extends Request<Bitmap> {

    /* renamed from: e */
    private static final Object f21340e = new Object();

    /* renamed from: a */
    private final Response.Listener<Bitmap> f21341a;

    /* renamed from: b */
    private final Bitmap.Config f21342b;

    /* renamed from: c */
    private final int f21343c;

    /* renamed from: d */
    private final int f21344d;

    @Override // com.mopub.volley.Request
    public /* synthetic */ void deliverResponse(Bitmap bitmap) {
        this.f21341a.onResponse(bitmap);
    }

    public ImageRequest(String str, Response.Listener<Bitmap> listener, int i, int i2, Bitmap.Config config, Response.ErrorListener errorListener) {
        super(0, str, errorListener);
        setRetryPolicy(new DefaultRetryPolicy(1000, 2, 2.0f));
        this.f21341a = listener;
        this.f21342b = config;
        this.f21343c = i;
        this.f21344d = i2;
    }

    @Override // com.mopub.volley.Request
    public Request.Priority getPriority() {
        return Request.Priority.LOW;
    }

    /* renamed from: a */
    private static int m1980a(int i, int i2, int i3, int i4) {
        if (i == 0 && i2 == 0) {
            return i3;
        }
        if (i == 0) {
            double d = i2;
            double d2 = i4;
            Double.isNaN(d);
            Double.isNaN(d2);
            double d3 = i3;
            Double.isNaN(d3);
            return (int) (d3 * (d / d2));
        } else if (i2 == 0) {
            return i;
        } else {
            double d4 = i4;
            double d5 = i3;
            Double.isNaN(d4);
            Double.isNaN(d5);
            double d6 = d4 / d5;
            double d7 = i;
            Double.isNaN(d7);
            double d8 = i2;
            if (d7 * d6 > d8) {
                Double.isNaN(d8);
                return (int) (d8 / d6);
            }
            return i;
        }
    }

    @Override // com.mopub.volley.Request
    public final Response<Bitmap> parseNetworkResponse(NetworkResponse networkResponse) {
        Bitmap decodeByteArray;
        Response<Bitmap> success;
        synchronized (f21340e) {
            try {
                try {
                    byte[] bArr = networkResponse.data;
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    if (this.f21343c == 0 && this.f21344d == 0) {
                        options.inPreferredConfig = this.f21342b;
                        decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                    } else {
                        options.inJustDecodeBounds = true;
                        BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                        int i = options.outWidth;
                        int i2 = options.outHeight;
                        int m1980a = m1980a(this.f21343c, this.f21344d, i, i2);
                        int m1980a2 = m1980a(this.f21344d, this.f21343c, i2, i);
                        options.inJustDecodeBounds = false;
                        options.inSampleSize = m1979b(i, i2, m1980a, m1980a2);
                        decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                        if (decodeByteArray != null && (decodeByteArray.getWidth() > m1980a || decodeByteArray.getHeight() > m1980a2)) {
                            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeByteArray, m1980a, m1980a2, true);
                            decodeByteArray.recycle();
                            decodeByteArray = createScaledBitmap;
                        }
                    }
                    if (decodeByteArray == null) {
                        success = Response.error(new ParseError(networkResponse));
                    } else {
                        success = Response.success(decodeByteArray, HttpHeaderParser.parseCacheHeaders(networkResponse));
                    }
                } catch (OutOfMemoryError e) {
                    VolleyLog.m2012e("Caught OOM for %d byte image, url=%s", Integer.valueOf(networkResponse.data.length), getUrl());
                    return Response.error(new ParseError(e));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return success;
    }

    /* renamed from: b */
    private static int m1979b(int i, int i2, int i3, int i4) {
        double d = i;
        double d2 = i3;
        Double.isNaN(d);
        Double.isNaN(d2);
        double d3 = i2;
        double d4 = i4;
        Double.isNaN(d3);
        Double.isNaN(d4);
        double min = Math.min(d / d2, d3 / d4);
        float f = 1.0f;
        while (true) {
            float f2 = 2.0f * f;
            if (f2 > min) {
                return (int) f;
            }
            f = f2;
        }
    }
}
