package com.mopub.mobileads;

import android.text.TextUtils;
import com.mopub.common.Preconditions;
import com.mopub.mobileads.util.XmlUtils;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Node;

/* renamed from: com.mopub.mobileads.aj */
/* loaded from: classes.dex */
abstract class VastBaseInLineWrapperXmlManager {

    /* renamed from: a */
    protected final Node f20521a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public VastBaseInLineWrapperXmlManager(Node node) {
        Preconditions.checkNotNull(node);
        this.f20521a = node;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final List<VastTracker> m2312a() {
        List<Node> matchingChildNodes = XmlUtils.getMatchingChildNodes(this.f20521a, "Impression");
        ArrayList arrayList = new ArrayList();
        for (Node node : matchingChildNodes) {
            String nodeValue = XmlUtils.getNodeValue(node);
            if (!TextUtils.isEmpty(nodeValue)) {
                arrayList.add(new VastTracker(nodeValue));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public final List<VastTracker> m2311b() {
        ArrayList arrayList = new ArrayList();
        List<Node> matchingChildNodes = XmlUtils.getMatchingChildNodes(this.f20521a, "Error");
        if (matchingChildNodes == null) {
            return arrayList;
        }
        for (Node node : matchingChildNodes) {
            String nodeValue = XmlUtils.getNodeValue(node);
            if (!TextUtils.isEmpty(nodeValue)) {
                arrayList.add(new VastTracker(nodeValue, true));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public final List<VastLinearXmlManager> m2310c() {
        List<Node> matchingChildNodes;
        ArrayList arrayList = new ArrayList();
        Node firstMatchingChildNode = XmlUtils.getFirstMatchingChildNode(this.f20521a, "Creatives");
        if (firstMatchingChildNode == null || (matchingChildNodes = XmlUtils.getMatchingChildNodes(firstMatchingChildNode, "Creative")) == null) {
            return arrayList;
        }
        for (Node node : matchingChildNodes) {
            Node firstMatchingChildNode2 = XmlUtils.getFirstMatchingChildNode(node, "Linear");
            if (firstMatchingChildNode2 != null) {
                arrayList.add(new VastLinearXmlManager(firstMatchingChildNode2));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public final List<VastCompanionAdXmlManager> m2309d() {
        List<Node> matchingChildNodes;
        List<Node> matchingChildNodes2;
        ArrayList arrayList = new ArrayList();
        Node firstMatchingChildNode = XmlUtils.getFirstMatchingChildNode(this.f20521a, "Creatives");
        if (firstMatchingChildNode == null || (matchingChildNodes = XmlUtils.getMatchingChildNodes(firstMatchingChildNode, "Creative")) == null) {
            return arrayList;
        }
        for (Node node : matchingChildNodes) {
            Node firstMatchingChildNode2 = XmlUtils.getFirstMatchingChildNode(node, "CompanionAds");
            if (firstMatchingChildNode2 != null && (matchingChildNodes2 = XmlUtils.getMatchingChildNodes(firstMatchingChildNode2, "Companion")) != null) {
                for (Node node2 : matchingChildNodes2) {
                    arrayList.add(new VastCompanionAdXmlManager(node2));
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public final VastExtensionParentXmlManager m2308e() {
        Node firstMatchingChildNode = XmlUtils.getFirstMatchingChildNode(this.f20521a, "Extensions");
        if (firstMatchingChildNode == null) {
            return null;
        }
        return new VastExtensionParentXmlManager(firstMatchingChildNode);
    }
}
