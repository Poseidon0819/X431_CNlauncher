package com.mopub.mobileads;

import com.mopub.common.Preconditions;
import com.mopub.mobileads.util.XmlUtils;
import org.w3c.dom.Node;

/* loaded from: classes.dex */
public class VastResourceXmlManager {
    public static final String CREATIVE_TYPE = "creativeType";
    public static final String HTML_RESOURCE = "HTMLResource";
    public static final String IFRAME_RESOURCE = "IFrameResource";
    public static final String STATIC_RESOURCE = "StaticResource";

    /* renamed from: a */
    final Node f20416a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public VastResourceXmlManager(Node node) {
        Preconditions.checkNotNull(node);
        this.f20416a = node;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final String m2377a() {
        return XmlUtils.getNodeValue(XmlUtils.getFirstMatchingChildNode(this.f20416a, STATIC_RESOURCE));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public final String m2376b() {
        return XmlUtils.getNodeValue(XmlUtils.getFirstMatchingChildNode(this.f20416a, IFRAME_RESOURCE));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public final String m2375c() {
        return XmlUtils.getNodeValue(XmlUtils.getFirstMatchingChildNode(this.f20416a, HTML_RESOURCE));
    }
}
