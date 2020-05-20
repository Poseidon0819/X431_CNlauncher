package com.artifex.mupdflib;

/* loaded from: classes.dex */
public class LinkInfoInternal extends LinkInfo {
    public final int pageNumber;

    public LinkInfoInternal(float f, float f2, float f3, float f4, int i) {
        super(f, f2, f3, f4);
        this.pageNumber = i;
    }

    @Override // com.artifex.mupdflib.LinkInfo
    public void acceptVisitor(LinkInfoVisitor linkInfoVisitor) {
        linkInfoVisitor.visitInternal(this);
    }
}
