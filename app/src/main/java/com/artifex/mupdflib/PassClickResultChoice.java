package com.artifex.mupdflib;

/* compiled from: MuPDFPageView.java */
/* loaded from: classes.dex */
class PassClickResultChoice extends PassClickResult {
    public final String[] options;
    public final String[] selected;

    public PassClickResultChoice(boolean z, String[] strArr, String[] strArr2) {
        super(z);
        this.options = strArr;
        this.selected = strArr2;
    }

    @Override // com.artifex.mupdflib.PassClickResult
    public void acceptVisitor(PassClickResultVisitor passClickResultVisitor) {
        passClickResultVisitor.visitChoice(this);
    }
}
