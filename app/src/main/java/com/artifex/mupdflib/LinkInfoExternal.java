package com.artifex.mupdflib;

/* loaded from: classes.dex */
public class LinkInfoExternal extends LinkInfo {
    public final String url;

    public LinkInfoExternal(float f, float f2, float f3, float f4, String str) {
        super(f, f2, f3, f4);
        this.url = str;
    }

    @Override // com.artifex.mupdflib.LinkInfo
    public void acceptVisitor(LinkInfoVisitor linkInfoVisitor) {
        linkInfoVisitor.visitExternal(this);
    }
}
