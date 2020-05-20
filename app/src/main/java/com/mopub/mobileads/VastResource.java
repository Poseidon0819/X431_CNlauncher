package com.mopub.mobileads;

import com.mopub.common.Preconditions;
import com.mopub.mobileads.util.XmlUtils;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.mopub.mobileads.at */
/* loaded from: classes.dex */
public final class VastResource implements Serializable {

    /* renamed from: a */
    private static final List<String> f20536a = Arrays.asList("image/jpeg", "image/png", "image/bmp", "image/gif");

    /* renamed from: b */
    private static final List<String> f20537b = Arrays.asList("application/x-javascript");
    private static final long serialVersionUID = 0;
    private EnumC3753a mCreativeType;
    private int mHeight;
    private String mResource;
    private EnumC3754b mType;
    private int mWidth;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VastResource.java */
    /* renamed from: com.mopub.mobileads.at$a */
    /* loaded from: classes.dex */
    public enum EnumC3753a {
        NONE,
        IMAGE,
        JAVASCRIPT
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VastResource.java */
    /* renamed from: com.mopub.mobileads.at$b */
    /* loaded from: classes.dex */
    public enum EnumC3754b {
        STATIC_RESOURCE,
        HTML_RESOURCE,
        IFRAME_RESOURCE
    }

    static VastResource fromVastResourceXmlManager(VastResourceXmlManager vastResourceXmlManager, int i, int i2) {
        for (EnumC3754b enumC3754b : EnumC3754b.values()) {
            VastResource fromVastResourceXmlManager = fromVastResourceXmlManager(vastResourceXmlManager, enumC3754b, i, i2);
            if (fromVastResourceXmlManager != null) {
                return fromVastResourceXmlManager;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static VastResource fromVastResourceXmlManager(VastResourceXmlManager vastResourceXmlManager, EnumC3754b enumC3754b, int i, int i2) {
        EnumC3753a enumC3753a;
        Preconditions.checkNotNull(vastResourceXmlManager);
        Preconditions.checkNotNull(enumC3754b);
        String m2376b = vastResourceXmlManager.m2376b();
        String m2375c = vastResourceXmlManager.m2375c();
        String m2377a = vastResourceXmlManager.m2377a();
        String attributeValue = XmlUtils.getAttributeValue(XmlUtils.getFirstMatchingChildNode(vastResourceXmlManager.f20416a, VastResourceXmlManager.STATIC_RESOURCE), VastResourceXmlManager.CREATIVE_TYPE);
        String lowerCase = attributeValue != null ? attributeValue.toLowerCase() : null;
        if (enumC3754b == EnumC3754b.STATIC_RESOURCE && m2377a != null && lowerCase != null && (f20536a.contains(lowerCase) || f20537b.contains(lowerCase))) {
            if (f20536a.contains(lowerCase)) {
                enumC3753a = EnumC3753a.IMAGE;
            } else {
                enumC3753a = EnumC3753a.JAVASCRIPT;
            }
        } else if (enumC3754b == EnumC3754b.HTML_RESOURCE && m2375c != null) {
            enumC3753a = EnumC3753a.NONE;
            m2377a = m2375c;
        } else if (enumC3754b != EnumC3754b.IFRAME_RESOURCE || m2376b == null) {
            return null;
        } else {
            enumC3753a = EnumC3753a.NONE;
            m2377a = m2376b;
        }
        return new VastResource(m2377a, enumC3754b, enumC3753a, i, i2);
    }

    VastResource(String str, EnumC3754b enumC3754b, EnumC3753a enumC3753a, int i, int i2) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(enumC3754b);
        Preconditions.checkNotNull(enumC3753a);
        this.mResource = str;
        this.mType = enumC3754b;
        this.mCreativeType = enumC3753a;
        this.mWidth = i;
        this.mHeight = i2;
    }

    public final String getResource() {
        return this.mResource;
    }

    public final EnumC3754b getType() {
        return this.mType;
    }

    public final EnumC3753a getCreativeType() {
        return this.mCreativeType;
    }

    public final void initializeWebView(VastWebView vastWebView) {
        Preconditions.checkNotNull(vastWebView);
        if (this.mType == EnumC3754b.IFRAME_RESOURCE) {
            vastWebView.m2290a("<iframe frameborder=\"0\" scrolling=\"no\" marginheight=\"0\" marginwidth=\"0\" style=\"border: 0px; margin: 0px;\" width=\"" + this.mWidth + "\" height=\"" + this.mHeight + "\" src=\"" + this.mResource + "\"></iframe>");
        } else if (this.mType == EnumC3754b.HTML_RESOURCE) {
            vastWebView.m2290a(this.mResource);
        } else if (this.mType == EnumC3754b.STATIC_RESOURCE) {
            if (this.mCreativeType == EnumC3753a.IMAGE) {
                vastWebView.m2290a("<html><head></head><body style=\"margin:0;padding:0\"><img src=\"" + this.mResource + "\" width=\"100%\" style=\"max-width:100%;max-height:100%;\" /></body></html>");
            } else if (this.mCreativeType == EnumC3753a.JAVASCRIPT) {
                vastWebView.m2290a("<script src=\"" + this.mResource + "\"></script>");
            }
        }
    }

    public final String getCorrectClickThroughUrl(String str, String str2) {
        switch (this.mType) {
            case STATIC_RESOURCE:
                if (EnumC3753a.IMAGE == this.mCreativeType) {
                    return str;
                }
                if (EnumC3753a.JAVASCRIPT == this.mCreativeType) {
                    return str2;
                }
                return null;
            case HTML_RESOURCE:
            case IFRAME_RESOURCE:
                return str2;
            default:
                return null;
        }
    }
}
