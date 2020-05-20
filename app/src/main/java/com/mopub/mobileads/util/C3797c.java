package com.mopub.mobileads.util;

import com.mopub.mobileads.util.XmlUtils;
import org.w3c.dom.Node;

/* compiled from: XmlUtils.java */
/* renamed from: com.mopub.mobileads.util.c */
/* loaded from: classes.dex */
final class C3797c implements XmlUtils.NodeProcessor<String> {
    @Override // com.mopub.mobileads.util.XmlUtils.NodeProcessor
    public final String process(Node node) {
        return XmlUtils.getNodeValue(node);
    }
}
