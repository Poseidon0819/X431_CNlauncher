package com.artifex.mupdflib;

/* compiled from: PageView.java */
/* loaded from: classes.dex */
interface TextProcessor {
    void onEndLine();

    void onStartLine();

    void onWord(TextWord textWord);
}
