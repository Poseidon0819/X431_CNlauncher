package com.mopub.mobileads;

import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.util.XmlUtils;
import org.w3c.dom.Node;

/* loaded from: classes.dex */
public class VideoViewabilityTrackerXmlManager {
    public static final String PERCENT_VIEWABLE = "percentViewable";
    public static final String VIEWABLE_PLAYTIME = "viewablePlaytime";

    /* renamed from: a */
    final Node f20497a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public VideoViewabilityTrackerXmlManager(Node node) {
        Preconditions.checkNotNull(node);
        this.f20497a = node;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0045  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Integer m2317a() {
        /*
            r6 = this;
            org.w3c.dom.Node r0 = r6.f20497a
            java.lang.String r1 = "viewablePlaytime"
            java.lang.String r0 = com.mopub.mobileads.util.XmlUtils.getAttributeValue(r0, r1)
            r1 = 0
            if (r0 != 0) goto Lc
            return r1
        Lc:
            boolean r2 = com.mopub.common.util.Strings.isAbsoluteTracker(r0)
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L27
            java.lang.Integer r0 = com.mopub.common.util.Strings.parseAbsoluteOffset(r0)     // Catch: java.lang.NumberFormatException -> L19
            goto L43
        L19:
            java.lang.String r2 = "Invalid VAST viewablePlaytime format for \"HH:MM:SS[.mmm]\": %s:"
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r4[r3] = r0
            java.lang.String r0 = java.lang.String.format(r2, r4)
            com.mopub.common.logging.MoPubLog.m2498d(r0)
            goto L42
        L27:
            float r2 = java.lang.Float.parseFloat(r0)     // Catch: java.lang.NumberFormatException -> L35
            r5 = 1148846080(0x447a0000, float:1000.0)
            float r2 = r2 * r5
            int r2 = (int) r2     // Catch: java.lang.NumberFormatException -> L35
            java.lang.Integer r0 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.NumberFormatException -> L35
            goto L43
        L35:
            java.lang.String r2 = "Invalid VAST viewablePlaytime format for \"SS[.mmm]\": %s:"
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r4[r3] = r0
            java.lang.String r0 = java.lang.String.format(r2, r4)
            com.mopub.common.logging.MoPubLog.m2498d(r0)
        L42:
            r0 = r1
        L43:
            if (r0 == 0) goto L4d
            int r2 = r0.intValue()
            if (r2 >= 0) goto L4c
            goto L4d
        L4c:
            return r0
        L4d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mopub.mobileads.VideoViewabilityTrackerXmlManager.m2317a():java.lang.Integer");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public final Integer m2316b() {
        Integer num;
        String attributeValue = XmlUtils.getAttributeValue(this.f20497a, PERCENT_VIEWABLE);
        if (attributeValue == null) {
            return null;
        }
        try {
            num = Integer.valueOf((int) Float.parseFloat(attributeValue.replace("%", "")));
        } catch (NumberFormatException unused) {
            MoPubLog.m2498d(String.format("Invalid VAST percentViewable format for \"d{1,3}%%\": %s:", attributeValue));
            num = null;
        }
        if (num == null || num.intValue() < 0 || num.intValue() > 100) {
            return null;
        }
        return num;
    }
}
