package com.itextpdf.text;

/* loaded from: classes.dex */
public interface LargeElement extends Element {
    void flushContent();

    boolean isComplete();

    void setComplete(boolean z);
}
