package com.mopub.mobileads;

import com.mopub.common.Preconditions;
import com.mopub.mobileads.util.XmlUtils;
import org.w3c.dom.Node;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.mopub.mobileads.bh */
/* loaded from: classes.dex */
public final class VastWrapperXmlManager extends VastBaseInLineWrapperXmlManager {
    /* JADX INFO: Access modifiers changed from: package-private */
    public VastWrapperXmlManager(Node node) {
        super(node);
        Preconditions.checkNotNull(node);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public final String m2289f() {
        return XmlUtils.getNodeValue(XmlUtils.getFirstMatchingChildNode(this.f20521a, "VASTAdTagURI"));
    }
}
