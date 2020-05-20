package com.mopub.mobileads;

import com.cnlaunch.p181j.ExplainResult;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Strings;
import com.mopub.mobileads.util.XmlUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.w3c.dom.Node;

/* renamed from: com.mopub.mobileads.ap */
/* loaded from: classes.dex */
final class VastLinearXmlManager {
    public static final String ICON = "Icon";
    public static final String ICONS = "Icons";

    /* renamed from: a */
    final Node f20531a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public VastLinearXmlManager(Node node) {
        Preconditions.checkNotNull(node);
        this.f20531a = node;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final List<VastFractionalProgressTracker> m2302a() {
        ArrayList arrayList = new ArrayList();
        m2300a(arrayList, m2298b("firstQuartile"), 0.25f);
        m2300a(arrayList, m2298b("midpoint"), 0.5f);
        m2300a(arrayList, m2298b("thirdQuartile"), 0.75f);
        Node firstMatchingChildNode = XmlUtils.getFirstMatchingChildNode(this.f20531a, "TrackingEvents");
        if (firstMatchingChildNode != null) {
            for (Node node : XmlUtils.getMatchingChildNodes(firstMatchingChildNode, "Tracking", "event", Collections.singletonList("progress"))) {
                String attributeValue = XmlUtils.getAttributeValue(node, VastIconXmlManager.OFFSET);
                if (attributeValue != null) {
                    String trim = attributeValue.trim();
                    if (Strings.isPercentageTracker(trim)) {
                        try {
                            arrayList.add(new VastFractionalProgressTracker(XmlUtils.getNodeValue(node), Float.parseFloat(trim.replace("%", "")) / 100.0f));
                        } catch (NumberFormatException unused) {
                            MoPubLog.m2498d(String.format("Failed to parse VAST progress tracker %s", trim));
                        }
                    }
                }
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public final List<VastAbsoluteProgressTracker> m2299b() {
        ArrayList arrayList = new ArrayList();
        for (String str : m2298b(ExplainResult.START)) {
            arrayList.add(new VastAbsoluteProgressTracker(str, 0));
        }
        Node firstMatchingChildNode = XmlUtils.getFirstMatchingChildNode(this.f20531a, "TrackingEvents");
        if (firstMatchingChildNode != null) {
            for (Node node : XmlUtils.getMatchingChildNodes(firstMatchingChildNode, "Tracking", "event", Collections.singletonList("progress"))) {
                String attributeValue = XmlUtils.getAttributeValue(node, VastIconXmlManager.OFFSET);
                if (attributeValue != null) {
                    String trim = attributeValue.trim();
                    if (Strings.isAbsoluteTracker(trim)) {
                        String nodeValue = XmlUtils.getNodeValue(node);
                        try {
                            Integer parseAbsoluteOffset = Strings.parseAbsoluteOffset(trim);
                            if (parseAbsoluteOffset != null) {
                                arrayList.add(new VastAbsoluteProgressTracker(nodeValue, parseAbsoluteOffset.intValue()));
                            }
                        } catch (NumberFormatException unused) {
                            MoPubLog.m2498d(String.format("Failed to parse VAST progress tracker %s", trim));
                        }
                    }
                }
            }
            for (Node node2 : XmlUtils.getMatchingChildNodes(firstMatchingChildNode, "Tracking", "event", Collections.singletonList("creativeView"))) {
                String nodeValue2 = XmlUtils.getNodeValue(node2);
                if (nodeValue2 != null) {
                    arrayList.add(new VastAbsoluteProgressTracker(nodeValue2, 0));
                }
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public final List<VastTracker> m2297c() {
        List<String> m2298b = m2298b("pause");
        ArrayList arrayList = new ArrayList();
        for (String str : m2298b) {
            arrayList.add(new VastTracker(str, true));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public final List<VastTracker> m2296d() {
        List<String> m2298b = m2298b("resume");
        ArrayList arrayList = new ArrayList();
        for (String str : m2298b) {
            arrayList.add(new VastTracker(str, true));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public final List<VastTracker> m2295e() {
        List<VastTracker> m2301a = m2301a("close");
        m2301a.addAll(m2301a("closeLinear"));
        return m2301a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public final List<VastTracker> m2294f() {
        ArrayList arrayList = new ArrayList();
        Node firstMatchingChildNode = XmlUtils.getFirstMatchingChildNode(this.f20531a, "VideoClicks");
        if (firstMatchingChildNode == null) {
            return arrayList;
        }
        for (Node node : XmlUtils.getMatchingChildNodes(firstMatchingChildNode, "ClickTracking")) {
            String nodeValue = XmlUtils.getNodeValue(node);
            if (nodeValue != null) {
                arrayList.add(new VastTracker(nodeValue));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g */
    public final String m2293g() {
        String attributeValue = XmlUtils.getAttributeValue(this.f20531a, "skipoffset");
        if (attributeValue == null || attributeValue.trim().isEmpty()) {
            return null;
        }
        return attributeValue.trim();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: h */
    public final List<VastIconXmlManager> m2292h() {
        ArrayList arrayList = new ArrayList();
        Node firstMatchingChildNode = XmlUtils.getFirstMatchingChildNode(this.f20531a, ICONS);
        if (firstMatchingChildNode == null) {
            return arrayList;
        }
        for (Node node : XmlUtils.getMatchingChildNodes(firstMatchingChildNode, ICON)) {
            arrayList.add(new VastIconXmlManager(node));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final List<VastTracker> m2301a(String str) {
        List<String> m2298b = m2298b(str);
        ArrayList arrayList = new ArrayList(m2298b.size());
        for (String str2 : m2298b) {
            arrayList.add(new VastTracker(str2));
        }
        return arrayList;
    }

    /* renamed from: b */
    private List<String> m2298b(String str) {
        Preconditions.checkNotNull(str);
        ArrayList arrayList = new ArrayList();
        Node firstMatchingChildNode = XmlUtils.getFirstMatchingChildNode(this.f20531a, "TrackingEvents");
        if (firstMatchingChildNode == null) {
            return arrayList;
        }
        for (Node node : XmlUtils.getMatchingChildNodes(firstMatchingChildNode, "Tracking", "event", Collections.singletonList(str))) {
            String nodeValue = XmlUtils.getNodeValue(node);
            if (nodeValue != null) {
                arrayList.add(nodeValue);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private static void m2300a(List<VastFractionalProgressTracker> list, List<String> list2, float f) {
        Preconditions.checkNotNull(list, "trackers cannot be null");
        Preconditions.checkNotNull(list2, "urls cannot be null");
        for (String str : list2) {
            list.add(new VastFractionalProgressTracker(str, f));
        }
    }
}
