package com.artifex.mupdflib;

/* compiled from: MuPDFPageView.java */
/* loaded from: classes.dex */
class PassClickResultSignature extends PassClickResult {
    public final SignatureState state;

    public PassClickResultSignature(boolean z, int i) {
        super(z);
        this.state = SignatureState.values()[i];
    }

    @Override // com.artifex.mupdflib.PassClickResult
    public void acceptVisitor(PassClickResultVisitor passClickResultVisitor) {
        passClickResultVisitor.visitSignature(this);
    }
}
