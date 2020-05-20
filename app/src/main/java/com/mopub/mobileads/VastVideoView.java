package com.mopub.mobileads;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Build;
import android.widget.ImageView;
import android.widget.VideoView;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.AsyncTasks;
import com.mopub.common.util.Streams;
import java.io.File;
import java.io.FileInputStream;

/* loaded from: classes.dex */
public class VastVideoView extends VideoView {

    /* renamed from: a */
    private VastVideoBlurLastVideoFrameTask f20450a;

    /* renamed from: b */
    private MediaMetadataRetriever f20451b;

    /* renamed from: c */
    private int f20452c;

    public VastVideoView(Context context) {
        super(context);
        Preconditions.checkNotNull(context, "context cannot be null");
        this.f20451b = Build.VERSION.SDK_INT >= 10 ? new MediaMetadataRetriever() : null;
    }

    public void prepareBlurredLastVideoFrame(ImageView imageView, String str) {
        MediaMetadataRetriever mediaMetadataRetriever = this.f20451b;
        if (mediaMetadataRetriever != null) {
            this.f20450a = new VastVideoBlurLastVideoFrameTask(mediaMetadataRetriever, imageView, getDuration());
            try {
                AsyncTasks.safeExecuteOnExecutor(this.f20450a, str);
            } catch (Exception e) {
                MoPubLog.m2497d("Failed to blur last video frame", e);
            }
        }
    }

    public void onDestroy() {
        VastVideoBlurLastVideoFrameTask vastVideoBlurLastVideoFrameTask = this.f20450a;
        if (vastVideoBlurLastVideoFrameTask == null || vastVideoBlurLastVideoFrameTask.getStatus() == AsyncTask.Status.FINISHED) {
            return;
        }
        this.f20450a.cancel(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final boolean m2368a(MediaPlayer mediaPlayer, int i, int i2, String str) {
        FileInputStream fileInputStream;
        if (Build.VERSION.SDK_INT >= 16 || i != 1 || i2 != Integer.MIN_VALUE || this.f20452c > 0) {
            return false;
        }
        FileInputStream fileInputStream2 = null;
        try {
            mediaPlayer.reset();
            fileInputStream = new FileInputStream(new File(str));
        } catch (Exception unused) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            mediaPlayer.setDataSource(fileInputStream.getFD());
            mediaPlayer.prepareAsync();
            start();
            Streams.closeStream(fileInputStream);
            this.f20452c++;
            return true;
        } catch (Exception unused2) {
            fileInputStream2 = fileInputStream;
            Streams.closeStream(fileInputStream2);
            this.f20452c++;
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            Streams.closeStream(fileInputStream2);
            this.f20452c++;
            throw th;
        }
    }

    public void onResume() {
        this.f20452c = 0;
    }

    @VisibleForTesting
    @Deprecated
    void setMediaMetadataRetriever(MediaMetadataRetriever mediaMetadataRetriever) {
        this.f20451b = mediaMetadataRetriever;
    }

    @VisibleForTesting
    @Deprecated
    VastVideoBlurLastVideoFrameTask getBlurLastVideoFrameTask() {
        return this.f20450a;
    }

    @VisibleForTesting
    @Deprecated
    void setBlurLastVideoFrameTask(VastVideoBlurLastVideoFrameTask vastVideoBlurLastVideoFrameTask) {
        this.f20450a = vastVideoBlurLastVideoFrameTask;
    }

    @VisibleForTesting
    @Deprecated
    int getVideoRetries() {
        return this.f20452c;
    }
}
