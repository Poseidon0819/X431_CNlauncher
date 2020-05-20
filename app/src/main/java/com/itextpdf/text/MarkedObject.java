package com.itextpdf.text;

import java.util.Properties;

/* loaded from: classes.dex */
public class MarkedObject implements Element {
    protected Element element;
    protected Properties markupAttributes;

    @Override // com.itextpdf.text.Element
    public boolean isContent() {
        return true;
    }

    @Override // com.itextpdf.text.Element
    public boolean isNestable() {
        return true;
    }

    @Override // com.itextpdf.text.Element
    public int type() {
        return 50;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MarkedObject() {
        this.markupAttributes = new Properties();
        this.element = null;
    }

    public MarkedObject(Element element) {
        this.markupAttributes = new Properties();
        this.element = element;
    }

    @Override // com.itextpdf.text.Element
    public java.util.List<Chunk> getChunks() {
        return this.element.getChunks();
    }

    @Override // com.itextpdf.text.Element
    public boolean process(ElementListener elementListener) {
        try {
            return elementListener.add(this.element);
        } catch (DocumentException unused) {
            return false;
        }
    }

    public Properties getMarkupAttributes() {
        return this.markupAttributes;
    }

    public void setMarkupAttribute(String str, String str2) {
        this.markupAttributes.setProperty(str, str2);
    }
}
