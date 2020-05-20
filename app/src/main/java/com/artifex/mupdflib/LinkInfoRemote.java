package com.artifex.mupdflib;

/* loaded from: classes.dex */
public class LinkInfoRemote extends LinkInfo {
    public final String fileSpec;
    public final boolean newWindow;
    public final int pageNumber;

    public LinkInfoRemote(float f, float f2, float f3, float f4, String str, int i, boolean z) {
        super(f, f2, f3, f4);
        this.fileSpec = str;
        this.pageNumber = i;
        this.newWindow = z;
    }

    @Override // com.artifex.mupdflib.LinkInfo
    public void acceptVisitor(LinkInfoVisitor linkInfoVisitor) {
        linkInfoVisitor.visitRemote(this);
    }
}
