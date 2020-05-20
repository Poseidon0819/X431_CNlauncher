package com.itextpdf.text.xml.simpleparser.handler;

import com.itextpdf.text.html.HtmlTags;
import com.itextpdf.text.xml.simpleparser.NewLineHandler;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class HTMLNewLineHandler implements NewLineHandler {
    private final Set<String> newLineTags = new HashSet();

    public HTMLNewLineHandler() {
        this.newLineTags.add(HtmlTags.f19632P);
        this.newLineTags.add(HtmlTags.BLOCKQUOTE);
        this.newLineTags.add(HtmlTags.f19620BR);
    }

    @Override // com.itextpdf.text.xml.simpleparser.NewLineHandler
    public boolean isNewLineTag(String str) {
        return this.newLineTags.contains(str);
    }
}
