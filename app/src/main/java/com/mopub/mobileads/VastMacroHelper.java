package com.mopub.mobileads;

import android.text.TextUtils;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class VastMacroHelper {

    /* renamed from: a */
    private final List<String> f20408a;

    /* renamed from: b */
    private final Map<VastMacro, String> f20409b;

    public VastMacroHelper(List<String> list) {
        Preconditions.checkNotNull(list, "uris cannot be null");
        this.f20408a = list;
        this.f20409b = new HashMap();
        this.f20409b.put(VastMacro.CACHEBUSTING, String.format(Locale.US, "%08d", Long.valueOf(Math.round(Math.random() * 1.0E8d))));
    }

    public List<String> getUris() {
        VastMacro[] values;
        ArrayList arrayList = new ArrayList();
        for (String str : this.f20408a) {
            if (!TextUtils.isEmpty(str)) {
                for (VastMacro vastMacro : VastMacro.values()) {
                    String str2 = this.f20409b.get(vastMacro);
                    if (str2 == null) {
                        str2 = "";
                    }
                    str = str.replaceAll("\\[" + vastMacro.name() + "\\]", str2);
                }
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public VastMacroHelper withErrorCode(VastErrorCode vastErrorCode) {
        if (vastErrorCode != null) {
            this.f20409b.put(VastMacro.ERRORCODE, vastErrorCode.getErrorCode());
        }
        return this;
    }

    public VastMacroHelper withContentPlayHead(Integer num) {
        if (num != null) {
            int intValue = num.intValue();
            long j = intValue;
            String format = String.format("%02d:%02d:%02d.%03d", Long.valueOf(TimeUnit.MILLISECONDS.toHours(j)), Long.valueOf(TimeUnit.MILLISECONDS.toMinutes(j) % TimeUnit.HOURS.toMinutes(1L)), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j) % TimeUnit.MINUTES.toSeconds(1L)), Integer.valueOf(intValue % 1000));
            if (!TextUtils.isEmpty(format)) {
                this.f20409b.put(VastMacro.CONTENTPLAYHEAD, format);
            }
        }
        return this;
    }

    public VastMacroHelper withAssetUri(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                str = URLEncoder.encode(str, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                MoPubLog.m2489w("Failed to encode url", e);
            }
            this.f20409b.put(VastMacro.ASSETURI, str);
        }
        return this;
    }
}
