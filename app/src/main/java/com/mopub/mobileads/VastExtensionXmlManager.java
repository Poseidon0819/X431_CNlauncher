package com.mopub.mobileads;

import com.mopub.common.Preconditions;
import org.w3c.dom.Node;

/* loaded from: classes.dex */
public class VastExtensionXmlManager {
    public static final String TYPE = "type";
    public static final String VIDEO_VIEWABILITY_TRACKER = "MoPubViewabilityTracker";

    /* renamed from: a */
    final Node f20405a;

    public VastExtensionXmlManager(Node node) {
        Preconditions.checkNotNull(node);
        this.f20405a = node;
    }
}
