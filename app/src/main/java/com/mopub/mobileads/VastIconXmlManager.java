package com.mopub.mobileads;

import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Strings;
import com.mopub.mobileads.util.XmlUtils;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Node;

/* loaded from: classes.dex */
public class VastIconXmlManager {
    public static final String DURATION = "duration";
    public static final String HEIGHT = "height";
    public static final String ICON_CLICKS = "IconClicks";
    public static final String ICON_CLICK_THROUGH = "IconClickThrough";
    public static final String ICON_CLICK_TRACKING = "IconClickTracking";
    public static final String ICON_VIEW_TRACKING = "IconViewTracking";
    public static final String OFFSET = "offset";
    public static final String WIDTH = "width";

    /* renamed from: a */
    final VastResourceXmlManager f20406a;

    /* renamed from: b */
    private final Node f20407b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public VastIconXmlManager(Node node) {
        Preconditions.checkNotNull(node);
        this.f20407b = node;
        this.f20406a = new VastResourceXmlManager(node);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final Integer m2387a() {
        return XmlUtils.getAttributeValueAsInt(this.f20407b, "width");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public final Integer m2386b() {
        return XmlUtils.getAttributeValueAsInt(this.f20407b, "height");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public final Integer m2385c() {
        String attributeValue = XmlUtils.getAttributeValue(this.f20407b, OFFSET);
        try {
            return Strings.parseAbsoluteOffset(attributeValue);
        } catch (NumberFormatException unused) {
            MoPubLog.m2498d(String.format("Invalid VAST icon offset format: %s:", attributeValue));
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public final Integer m2384d() {
        String attributeValue = XmlUtils.getAttributeValue(this.f20407b, DURATION);
        try {
            return Strings.parseAbsoluteOffset(attributeValue);
        } catch (NumberFormatException unused) {
            MoPubLog.m2498d(String.format("Invalid VAST icon duration format: %s:", attributeValue));
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public final List<VastTracker> m2383e() {
        Node firstMatchingChildNode = XmlUtils.getFirstMatchingChildNode(this.f20407b, ICON_CLICKS);
        ArrayList arrayList = new ArrayList();
        if (firstMatchingChildNode == null) {
            return arrayList;
        }
        for (Node node : XmlUtils.getMatchingChildNodes(firstMatchingChildNode, ICON_CLICK_TRACKING)) {
            String nodeValue = XmlUtils.getNodeValue(node);
            if (nodeValue != null) {
                arrayList.add(new VastTracker(nodeValue));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public final String m2382f() {
        Node firstMatchingChildNode = XmlUtils.getFirstMatchingChildNode(this.f20407b, ICON_CLICKS);
        if (firstMatchingChildNode == null) {
            return null;
        }
        return XmlUtils.getNodeValue(XmlUtils.getFirstMatchingChildNode(firstMatchingChildNode, ICON_CLICK_THROUGH));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g */
    public final List<VastTracker> m2381g() {
        List<Node> matchingChildNodes = XmlUtils.getMatchingChildNodes(this.f20407b, ICON_VIEW_TRACKING);
        ArrayList arrayList = new ArrayList();
        for (Node node : matchingChildNodes) {
            String nodeValue = XmlUtils.getNodeValue(node);
            if (nodeValue != null) {
                arrayList.add(new VastTracker(nodeValue));
            }
        }
        return arrayList;
    }
}
