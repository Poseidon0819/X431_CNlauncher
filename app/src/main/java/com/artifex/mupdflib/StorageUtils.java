package com.artifex.mupdflib;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.io.IOException;
import org.jivesoftware.smackx.bytestreams.ibb.packet.DataPacketExtension;

/* loaded from: classes.dex */
public final class StorageUtils {
    private StorageUtils() {
    }

    public static File getCacheDirectory(Context context) {
        File externalCacheDir = Environment.getExternalStorageState().equals("mounted") ? getExternalCacheDir(context) : null;
        return externalCacheDir == null ? context.getCacheDir() : externalCacheDir;
    }

    public static File getFilesDirectory(Context context) {
        File externalFilesDir = Environment.getExternalStorageState().equals("mounted") ? getExternalFilesDir(context) : null;
        return externalFilesDir == null ? context.getFilesDir() : externalFilesDir;
    }

    public static File getCacheSubDirectory(Context context, String str) {
        File file = new File(getCacheDirectory(context), str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File getFilesSubDirectory(Context context, String str) {
        File file = new File(getFilesDirectory(context), str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private static File getExternalCacheDir(Context context) {
        File file = new File(new File(new File(new File(Environment.getExternalStorageDirectory(), "Android"), DataPacketExtension.ELEMENT_NAME), context.getPackageName()), "cache");
        if (!file.exists()) {
            if (!file.mkdirs()) {
                return null;
            }
            try {
                new File(file, ".nomedia").createNewFile();
            } catch (IOException unused) {
                return null;
            }
        }
        return file;
    }

    private static File getExternalFilesDir(Context context) {
        File file = new File(new File(new File(new File(Environment.getExternalStorageDirectory(), "Android"), DataPacketExtension.ELEMENT_NAME), context.getPackageName()), "files");
        if (!file.exists()) {
            if (!file.mkdirs()) {
                return null;
            }
            try {
                new File(file, ".nomedia").createNewFile();
            } catch (IOException unused) {
                return null;
            }
        }
        return file;
    }
}
