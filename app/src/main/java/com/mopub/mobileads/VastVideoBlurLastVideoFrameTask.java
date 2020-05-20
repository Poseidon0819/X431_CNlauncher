package com.mopub.mobileads;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.AsyncTask;
import android.os.Build;
import android.widget.ImageView;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.ImageUtils;

/* loaded from: classes.dex */
public class VastVideoBlurLastVideoFrameTask extends AsyncTask<String, Void, Boolean> {

    /* renamed from: a */
    private final MediaMetadataRetriever f20417a;

    /* renamed from: b */
    private final ImageView f20418b;

    /* renamed from: c */
    private int f20419c;

    /* renamed from: d */
    private Bitmap f20420d;

    /* renamed from: e */
    private Bitmap f20421e;

    @Override // android.os.AsyncTask
    protected /* synthetic */ void onPostExecute(Boolean bool) {
        Boolean bool2 = bool;
        if (isCancelled()) {
            onCancelled();
        } else if (bool2 == null || !bool2.booleanValue()) {
        } else {
            this.f20418b.setImageBitmap(this.f20421e);
            ImageUtils.setImageViewAlpha(this.f20418b, 100);
        }
    }

    public VastVideoBlurLastVideoFrameTask(MediaMetadataRetriever mediaMetadataRetriever, ImageView imageView, int i) {
        this.f20417a = mediaMetadataRetriever;
        this.f20418b = imageView;
        this.f20419c = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public Boolean doInBackground(String... strArr) {
        if (Build.VERSION.SDK_INT >= 10) {
            if (strArr == null || strArr.length == 0 || strArr[0] == null) {
                return Boolean.FALSE;
            }
            try {
                this.f20417a.setDataSource(strArr[0]);
                this.f20420d = this.f20417a.getFrameAtTime((this.f20419c * 1000) - 200000, 3);
                if (this.f20420d == null) {
                    return Boolean.FALSE;
                }
                this.f20421e = ImageUtils.applyFastGaussianBlurToBitmap(this.f20420d, 4);
                return Boolean.TRUE;
            } catch (Exception e) {
                MoPubLog.m2497d("Failed to blur last video frame", e);
                return Boolean.FALSE;
            }
        }
        return Boolean.FALSE;
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        MoPubLog.m2498d("VastVideoBlurLastVideoFrameTask was cancelled.");
    }
}
