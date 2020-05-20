package com.itextpdf.text.pdf.hyphenation;

import java.util.ArrayList;

/* loaded from: classes.dex */
public interface PatternConsumer {
    void addClass(String str);

    void addException(String str, ArrayList<Object> arrayList);

    void addPattern(String str, String str2);
}
