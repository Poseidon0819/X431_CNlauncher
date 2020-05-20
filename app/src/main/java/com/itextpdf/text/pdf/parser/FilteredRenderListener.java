package com.itextpdf.text.pdf.parser;

/* loaded from: classes.dex */
public class FilteredRenderListener implements RenderListener {
    private final RenderListener delegate;
    private final RenderFilter[] filters;

    public FilteredRenderListener(RenderListener renderListener, RenderFilter... renderFilterArr) {
        this.delegate = renderListener;
        this.filters = renderFilterArr;
    }

    @Override // com.itextpdf.text.pdf.parser.RenderListener
    public void renderText(TextRenderInfo textRenderInfo) {
        for (RenderFilter renderFilter : this.filters) {
            if (!renderFilter.allowText(textRenderInfo)) {
                return;
            }
        }
        this.delegate.renderText(textRenderInfo);
    }

    @Override // com.itextpdf.text.pdf.parser.RenderListener
    public void beginTextBlock() {
        this.delegate.beginTextBlock();
    }

    @Override // com.itextpdf.text.pdf.parser.RenderListener
    public void endTextBlock() {
        this.delegate.endTextBlock();
    }

    @Override // com.itextpdf.text.pdf.parser.RenderListener
    public void renderImage(ImageRenderInfo imageRenderInfo) {
        for (RenderFilter renderFilter : this.filters) {
            if (!renderFilter.allowImage(imageRenderInfo)) {
                return;
            }
        }
        this.delegate.renderImage(imageRenderInfo);
    }
}
