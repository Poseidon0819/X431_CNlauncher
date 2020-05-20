package com.mopub.volley.toolbox;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import com.mopub.volley.Request;
import com.mopub.volley.RequestQueue;
import com.mopub.volley.Response;
import com.mopub.volley.VolleyError;
import java.util.HashMap;
import java.util.LinkedList;

/* loaded from: classes2.dex */
public class ImageLoader {

    /* renamed from: a */
    final ImageCache f21323a;

    /* renamed from: c */
    private final RequestQueue f21325c;

    /* renamed from: g */
    private Runnable f21329g;

    /* renamed from: d */
    private int f21326d = 100;

    /* renamed from: b */
    final HashMap<String, C3927a> f21324b = new HashMap<>();

    /* renamed from: e */
    private final HashMap<String, C3927a> f21327e = new HashMap<>();

    /* renamed from: f */
    private final Handler f21328f = new Handler(Looper.getMainLooper());

    /* loaded from: classes2.dex */
    public interface ImageCache {
        Bitmap getBitmap(String str);

        void putBitmap(String str, Bitmap bitmap);
    }

    /* loaded from: classes2.dex */
    public interface ImageListener extends Response.ErrorListener {
        void onResponse(ImageContainer imageContainer, boolean z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public static /* synthetic */ Runnable m1983c(ImageLoader imageLoader) {
        imageLoader.f21329g = null;
        return null;
    }

    public ImageLoader(RequestQueue requestQueue, ImageCache imageCache) {
        this.f21325c = requestQueue;
        this.f21323a = imageCache;
    }

    public static ImageListener getImageListener(ImageView imageView, int i, int i2) {
        return new C3929b(i2, imageView, i);
    }

    public boolean isCached(String str, int i, int i2) {
        m1988a();
        return this.f21323a.getBitmap(m1986a(str, i, i2)) != null;
    }

    public ImageContainer get(String str, ImageListener imageListener) {
        return get(str, imageListener, 0, 0);
    }

    public ImageContainer get(String str, ImageListener imageListener, int i, int i2) {
        m1988a();
        String m1986a = m1986a(str, i, i2);
        Bitmap bitmap = this.f21323a.getBitmap(m1986a);
        if (bitmap != null) {
            ImageContainer imageContainer = new ImageContainer(bitmap, str, null, null);
            imageListener.onResponse(imageContainer, true);
            return imageContainer;
        }
        ImageContainer imageContainer2 = new ImageContainer(null, str, m1986a, imageListener);
        imageListener.onResponse(imageContainer2, true);
        C3927a c3927a = this.f21324b.get(m1986a);
        if (c3927a != null) {
            c3927a.addContainer(imageContainer2);
            return imageContainer2;
        }
        ImageRequest imageRequest = new ImageRequest(str, new C3930c(this, m1986a), i, i2, Bitmap.Config.RGB_565, new C3931d(this, m1986a));
        this.f21325c.add(imageRequest);
        this.f21324b.put(m1986a, new C3927a(imageRequest, imageContainer2));
        return imageContainer2;
    }

    public void setBatchedResponseDelay(int i) {
        this.f21326d = i;
    }

    /* loaded from: classes2.dex */
    public class ImageContainer {

        /* renamed from: b */
        private Bitmap f21331b;

        /* renamed from: c */
        private final ImageListener f21332c;

        /* renamed from: d */
        private final String f21333d;

        /* renamed from: e */
        private final String f21334e;

        public ImageContainer(Bitmap bitmap, String str, String str2, ImageListener imageListener) {
            this.f21331b = bitmap;
            this.f21334e = str;
            this.f21333d = str2;
            this.f21332c = imageListener;
        }

        public void cancelRequest() {
            if (this.f21332c == null) {
                return;
            }
            C3927a c3927a = (C3927a) ImageLoader.this.f21324b.get(this.f21333d);
            if (c3927a == null) {
                C3927a c3927a2 = (C3927a) ImageLoader.this.f21327e.get(this.f21333d);
                if (c3927a2 != null) {
                    c3927a2.removeContainerAndCancelIfNecessary(this);
                    if (c3927a2.f21336b.size() == 0) {
                        ImageLoader.this.f21327e.remove(this.f21333d);
                    }
                }
            } else if (c3927a.removeContainerAndCancelIfNecessary(this)) {
                ImageLoader.this.f21324b.remove(this.f21333d);
            }
        }

        public Bitmap getBitmap() {
            return this.f21331b;
        }

        public String getRequestUrl() {
            return this.f21334e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mopub.volley.toolbox.ImageLoader$a */
    /* loaded from: classes2.dex */
    public class C3927a {

        /* renamed from: a */
        Bitmap f21335a;

        /* renamed from: b */
        final LinkedList<ImageContainer> f21336b = new LinkedList<>();

        /* renamed from: d */
        private final Request<?> f21338d;

        /* renamed from: e */
        private VolleyError f21339e;

        public C3927a(Request<?> request, ImageContainer imageContainer) {
            this.f21338d = request;
            this.f21336b.add(imageContainer);
        }

        public final void setError(VolleyError volleyError) {
            this.f21339e = volleyError;
        }

        public final VolleyError getError() {
            return this.f21339e;
        }

        public final void addContainer(ImageContainer imageContainer) {
            this.f21336b.add(imageContainer);
        }

        public final boolean removeContainerAndCancelIfNecessary(ImageContainer imageContainer) {
            this.f21336b.remove(imageContainer);
            if (this.f21336b.size() == 0) {
                this.f21338d.cancel();
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m1985a(String str, C3927a c3927a) {
        this.f21327e.put(str, c3927a);
        if (this.f21329g == null) {
            this.f21329g = new RunnableC3932e(this);
            this.f21328f.postDelayed(this.f21329g, this.f21326d);
        }
    }

    /* renamed from: a */
    private static void m1988a() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("ImageLoader must be invoked from the main thread.");
        }
    }

    /* renamed from: a */
    private static String m1986a(String str, int i, int i2) {
        StringBuilder sb = new StringBuilder(str.length() + 12);
        sb.append("#W");
        sb.append(i);
        sb.append("#H");
        sb.append(i2);
        sb.append(str);
        return sb.toString();
    }
}
