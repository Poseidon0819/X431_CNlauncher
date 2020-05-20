package com.artifex.mupdflib;

/* loaded from: classes.dex */
public abstract class LinkInfoVisitor {
    public abstract void visitExternal(LinkInfoExternal linkInfoExternal);

    public abstract void visitInternal(LinkInfoInternal linkInfoInternal);

    public abstract void visitRemote(LinkInfoRemote linkInfoRemote);
}
