package com.mopub.mobileads;

import android.text.TextUtils;
import com.mopub.common.util.DeviceUtils;
import com.mopub.mobileads.util.XmlUtils;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.mopub.mobileads.bi */
/* loaded from: classes.dex */
public final class VastXmlManager {

    /* renamed from: a */
    Document f20573a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final List<VastAdXmlManager> m2288a() {
        ArrayList arrayList = new ArrayList();
        Document document = this.f20573a;
        if (document == null) {
            return arrayList;
        }
        NodeList elementsByTagName = document.getElementsByTagName("Ad");
        for (int i = 0; i < elementsByTagName.getLength(); i++) {
            arrayList.add(new VastAdXmlManager(elementsByTagName.item(i)));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public final VastTracker m2287b() {
        Document document = this.f20573a;
        if (document == null) {
            return null;
        }
        String firstMatchingStringData = XmlUtils.getFirstMatchingStringData(document, "Error");
        if (TextUtils.isEmpty(firstMatchingStringData)) {
            return null;
        }
        return new VastTracker(firstMatchingStringData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public final List<VastTracker> m2286c() {
        List<String> stringDataAsList = XmlUtils.getStringDataAsList(this.f20573a, "MP_TRACKING_URL");
        ArrayList arrayList = new ArrayList(stringDataAsList.size());
        for (String str : stringDataAsList) {
            arrayList.add(new VastTracker(str));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public final String m2285d() {
        String firstMatchingStringData = XmlUtils.getFirstMatchingStringData(this.f20573a, "MoPubCtaText");
        if (firstMatchingStringData == null || firstMatchingStringData.length() > 15) {
            return null;
        }
        return firstMatchingStringData;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public final String m2284e() {
        String firstMatchingStringData = XmlUtils.getFirstMatchingStringData(this.f20573a, "MoPubSkipText");
        if (firstMatchingStringData == null || firstMatchingStringData.length() > 8) {
            return null;
        }
        return firstMatchingStringData;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public final String m2283f() {
        return XmlUtils.getFirstMatchingStringData(this.f20573a, "MoPubCloseIcon");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g */
    public final DeviceUtils.ForceOrientation m2282g() {
        return DeviceUtils.ForceOrientation.getForceOrientation(XmlUtils.getFirstMatchingStringData(this.f20573a, "MoPubForceOrientation"));
    }
}
