package com.artifex.mupdflib;

/* compiled from: MuPDFPageView.java */
/* loaded from: classes.dex */
abstract class PassClickResultVisitor {
    public abstract void visitChoice(PassClickResultChoice passClickResultChoice);

    public abstract void visitSignature(PassClickResultSignature passClickResultSignature);

    public abstract void visitText(PassClickResultText passClickResultText);
}
