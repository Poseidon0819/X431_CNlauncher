package com.itextpdf.text.pdf.parser;

/* loaded from: classes.dex */
public class FilteredTextRenderListener extends FilteredRenderListener implements TextExtractionStrategy {
    private final TextExtractionStrategy delegate;

    public FilteredTextRenderListener(TextExtractionStrategy textExtractionStrategy, RenderFilter... renderFilterArr) {
        super(textExtractionStrategy, renderFilterArr);
        this.delegate = textExtractionStrategy;
    }

    @Override // com.itextpdf.text.pdf.parser.TextExtractionStrategy
    public String getResultantText() {
        return this.delegate.getResultantText();
    }
}
