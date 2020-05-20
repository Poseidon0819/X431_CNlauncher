package com.artifex.mupdflib;

/* compiled from: MuPDFPageView.java */
/* loaded from: classes.dex */
class PassClickResultText extends PassClickResult {
    public final String text;

    public PassClickResultText(boolean z, String str) {
        super(z);
        this.text = str;
    }

    @Override // com.artifex.mupdflib.PassClickResult
    public void acceptVisitor(PassClickResultVisitor passClickResultVisitor) {
        passClickResultVisitor.visitText(this);
    }
}
