package com.mopub.common.util;

import com.mopub.nativeads.MoPubNativeAdPositioning;
import java.io.File;
import org.xbill.DNS.TTL;

/* loaded from: classes.dex */
public class Files {
    public static File createDirectory(String str) {
        if (str == null) {
            return null;
        }
        File file = new File(str);
        if ((file.exists() && file.isDirectory()) || (file.mkdirs() && file.isDirectory())) {
            return file;
        }
        return null;
    }

    public static int intLength(File file) {
        if (file == null) {
            return 0;
        }
        long length = file.length();
        return length < TTL.MAX_VALUE ? (int) length : MoPubNativeAdPositioning.MoPubClientPositioning.NO_REPEAT;
    }
}
