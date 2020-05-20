package com.mopub.common;

import android.content.Context;
import android.os.AsyncTask;
import com.mopub.common.DiskLruCache;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.DeviceUtils;
import com.mopub.common.util.Streams;
import com.mopub.common.util.Utils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class CacheService {

    /* renamed from: a */
    private static DiskLruCache f19983a;

    /* loaded from: classes.dex */
    public interface DiskLruCacheGetListener {
        void onComplete(String str, byte[] bArr);
    }

    public static boolean initializeDiskCache(Context context) {
        if (context == null) {
            return false;
        }
        if (f19983a == null) {
            File diskCacheDirectory = getDiskCacheDirectory(context);
            if (diskCacheDirectory == null) {
                return false;
            }
            try {
                f19983a = DiskLruCache.open(diskCacheDirectory, 1, 1, DeviceUtils.diskCacheSizeBytes(diskCacheDirectory));
            } catch (IOException e) {
                MoPubLog.m2497d("Unable to create DiskLruCache", e);
                return false;
            }
        }
        return true;
    }

    public static void initialize(Context context) {
        initializeDiskCache(context);
    }

    public static String createValidDiskCacheKey(String str) {
        return Utils.sha1(str);
    }

    public static File getDiskCacheDirectory(Context context) {
        File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            return null;
        }
        String path = cacheDir.getPath();
        return new File(path + File.separator + "mopub-cache");
    }

    public static boolean containsKeyDiskCache(String str) {
        DiskLruCache diskLruCache = f19983a;
        if (diskLruCache == null) {
            return false;
        }
        try {
            return diskLruCache.get(createValidDiskCacheKey(str)) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String getFilePathDiskCache(String str) {
        if (f19983a == null) {
            return null;
        }
        return f19983a.getDirectory() + File.separator + createValidDiskCacheKey(str) + ".0";
    }

    public static byte[] getFromDiskCache(String str) {
        DiskLruCache.Snapshot snapshot;
        byte[] bArr;
        DiskLruCache diskLruCache = f19983a;
        DiskLruCache.Snapshot snapshot2 = null;
        byte[] bArr2 = null;
        snapshot2 = null;
        try {
            if (diskLruCache == null) {
                return null;
            }
            try {
                snapshot = diskLruCache.get(createValidDiskCacheKey(str));
                if (snapshot == null) {
                    if (snapshot != null) {
                        snapshot.close();
                    }
                    return null;
                }
                try {
                    InputStream inputStream = snapshot.getInputStream(0);
                    if (inputStream != null) {
                        bArr2 = new byte[(int) snapshot.getLength(0)];
                        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                        try {
                            Streams.readStream(bufferedInputStream, bArr2);
                            Streams.closeStream(bufferedInputStream);
                        } catch (Throwable th) {
                            Streams.closeStream(bufferedInputStream);
                            throw th;
                        }
                    }
                    if (snapshot != null) {
                        snapshot.close();
                    }
                    return bArr2;
                } catch (Exception e) {
                    e = e;
                    snapshot2 = snapshot;
                    bArr = null;
                    MoPubLog.m2497d("Unable to get from DiskLruCache", e);
                    if (snapshot2 != null) {
                        snapshot2.close();
                        return bArr;
                    }
                    return bArr;
                } catch (Throwable th2) {
                    th = th2;
                    if (snapshot != null) {
                        snapshot.close();
                    }
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                bArr = null;
            }
        } catch (Throwable th3) {
            th = th3;
            snapshot = snapshot2;
        }
    }

    public static void getFromDiskCacheAsync(String str, DiskLruCacheGetListener diskLruCacheGetListener) {
        new AsyncTaskC3675a(str, diskLruCacheGetListener).execute(new Void[0]);
    }

    public static boolean putToDiskCache(String str, byte[] bArr) {
        return putToDiskCache(str, new ByteArrayInputStream(bArr));
    }

    public static boolean putToDiskCache(String str, InputStream inputStream) {
        DiskLruCache diskLruCache = f19983a;
        if (diskLruCache == null) {
            return false;
        }
        DiskLruCache.Editor editor = null;
        try {
            editor = diskLruCache.edit(createValidDiskCacheKey(str));
            if (editor == null) {
                return false;
            }
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(editor.newOutputStream(0));
            Streams.copyContent(inputStream, bufferedOutputStream);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            f19983a.flush();
            editor.commit();
            return true;
        } catch (Exception e) {
            MoPubLog.m2497d("Unable to put to DiskLruCache", e);
            if (editor != null) {
                try {
                    editor.abort();
                } catch (IOException unused) {
                }
            }
            return false;
        }
    }

    public static void putToDiskCacheAsync(String str, byte[] bArr) {
        new AsyncTaskC3676b(str, bArr).execute(new Void[0]);
    }

    /* renamed from: com.mopub.common.CacheService$a */
    /* loaded from: classes.dex */
    static class AsyncTaskC3675a extends AsyncTask<Void, Void, byte[]> {

        /* renamed from: a */
        private final DiskLruCacheGetListener f19984a;

        /* renamed from: b */
        private final String f19985b;

        @Override // android.os.AsyncTask
        protected final /* synthetic */ void onPostExecute(byte[] bArr) {
            byte[] bArr2 = bArr;
            if (isCancelled()) {
                onCancelled();
                return;
            }
            DiskLruCacheGetListener diskLruCacheGetListener = this.f19984a;
            if (diskLruCacheGetListener != null) {
                diskLruCacheGetListener.onComplete(this.f19985b, bArr2);
            }
        }

        AsyncTaskC3675a(String str, DiskLruCacheGetListener diskLruCacheGetListener) {
            this.f19984a = diskLruCacheGetListener;
            this.f19985b = str;
        }

        @Override // android.os.AsyncTask
        protected final void onCancelled() {
            DiskLruCacheGetListener diskLruCacheGetListener = this.f19984a;
            if (diskLruCacheGetListener != null) {
                diskLruCacheGetListener.onComplete(this.f19985b, null);
            }
        }

        @Override // android.os.AsyncTask
        protected final /* synthetic */ byte[] doInBackground(Void[] voidArr) {
            return CacheService.getFromDiskCache(this.f19985b);
        }
    }

    /* renamed from: com.mopub.common.CacheService$b */
    /* loaded from: classes.dex */
    static class AsyncTaskC3676b extends AsyncTask<Void, Void, Void> {

        /* renamed from: a */
        private final String f19986a;

        /* renamed from: b */
        private final byte[] f19987b;

        AsyncTaskC3676b(String str, byte[] bArr) {
            this.f19986a = str;
            this.f19987b = bArr;
        }

        @Override // android.os.AsyncTask
        protected final /* synthetic */ Void doInBackground(Void[] voidArr) {
            CacheService.putToDiskCache(this.f19986a, this.f19987b);
            return null;
        }
    }

    @VisibleForTesting
    @Deprecated
    public static void clearAndNullCaches() {
        DiskLruCache diskLruCache = f19983a;
        if (diskLruCache != null) {
            try {
                diskLruCache.delete();
                f19983a = null;
            } catch (IOException unused) {
                f19983a = null;
            }
        }
    }

    @VisibleForTesting
    @Deprecated
    public static DiskLruCache getDiskLruCache() {
        return f19983a;
    }
}
