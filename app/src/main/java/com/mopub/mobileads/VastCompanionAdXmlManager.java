package com.mopub.mobileads;

import android.text.TextUtils;
import com.mopub.common.Preconditions;
import com.mopub.mobileads.util.XmlUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.w3c.dom.Node;

/* renamed from: com.mopub.mobileads.al */
/* loaded from: classes.dex */
final class VastCompanionAdXmlManager {

    /* renamed from: a */
    final Node f20526a;

    /* renamed from: b */
    final VastResourceXmlManager f20527b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public VastCompanionAdXmlManager(Node node) {
        Preconditions.checkNotNull(node, "companionNode cannot be null");
        this.f20526a = node;
        this.f20527b = new VastResourceXmlManager(node);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final Integer m2307a() {
        return XmlUtils.getAttributeValueAsInt(this.f20526a, "width");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public final Integer m2306b() {
        return XmlUtils.getAttributeValueAsInt(this.f20526a, "height");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public final String m2305c() {
        return XmlUtils.getNodeValue(XmlUtils.getFirstMatchingChildNode(this.f20526a, "CompanionClickThrough"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public final List<VastTracker> m2304d() {
        ArrayList arrayList = new ArrayList();
        List<Node> matchingChildNodes = XmlUtils.getMatchingChildNodes(this.f20526a, "CompanionClickTracking");
        if (matchingChildNodes == null) {
            return arrayList;
        }
        for (Node node : matchingChildNodes) {
            String nodeValue = XmlUtils.getNodeValue(node);
            if (!TextUtils.isEmpty(nodeValue)) {
                arrayList.add(new VastTracker(nodeValue));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public final List<VastTracker> m2303e() {
        ArrayList arrayList = new ArrayList();
        Node firstMatchingChildNode = XmlUtils.getFirstMatchingChildNode(this.f20526a, "TrackingEvents");
        if (firstMatchingChildNode == null) {
            return arrayList;
        }
        for (Node node : XmlUtils.getMatchingChildNodes(firstMatchingChildNode, "Tracking", "event", Collections.singletonList("creativeView"))) {
            arrayList.add(new VastTracker(XmlUtils.getNodeValue(node)));
        }
        return arrayList;
    }
}
