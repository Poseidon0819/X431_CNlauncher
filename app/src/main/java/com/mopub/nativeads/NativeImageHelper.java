package com.mopub.nativeads;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import com.mopub.common.Preconditions;
import com.mopub.network.Networking;
import com.mopub.volley.toolbox.ImageLoader;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public class NativeImageHelper {

    /* loaded from: classes2.dex */
    public interface ImageListener {
        void onImagesCached();

        void onImagesFailedToCache(NativeErrorCode nativeErrorCode);
    }

    public static void preCacheImages(Context context, List<String> list, ImageListener imageListener) {
        ImageLoader imageLoader = Networking.getImageLoader(context);
        AtomicInteger atomicInteger = new AtomicInteger(list.size());
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        C3868al c3868al = new C3868al(atomicInteger, atomicBoolean, imageListener);
        for (String str : list) {
            if (TextUtils.isEmpty(str)) {
                atomicBoolean.set(true);
                imageListener.onImagesFailedToCache(NativeErrorCode.IMAGE_DOWNLOAD_FAILURE);
                return;
            }
            imageLoader.get(str, c3868al);
        }
    }

    public static void loadImageView(String str, ImageView imageView) {
        if (Preconditions.NoThrow.checkNotNull(imageView, "Cannot load image into null ImageView")) {
            if (!Preconditions.NoThrow.checkNotNull(str, "Cannot load image with null url")) {
                imageView.setImageDrawable(null);
            } else {
                Networking.getImageLoader(imageView.getContext()).get(str, new C3869am(imageView));
            }
        }
    }
}
