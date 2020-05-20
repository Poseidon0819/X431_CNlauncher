package com.mopub.common;

import com.cnlaunch.physics.PAD3DHCPForDoIP;
import com.itextpdf.text.html.HtmlTags;

/* loaded from: classes.dex */
public enum CreativeOrientation {
    PORTRAIT,
    LANDSCAPE,
    UNDEFINED;

    public static CreativeOrientation fromHeader(String str) {
        if (PAD3DHCPForDoIP.f10141a.equalsIgnoreCase(str)) {
            return LANDSCAPE;
        }
        if (HtmlTags.f19632P.equalsIgnoreCase(str)) {
            return PORTRAIT;
        }
        return UNDEFINED;
    }
}
