package com.itextpdf.text;

import com.itextpdf.text.api.WriterOperation;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class WritableDirectElement implements Element, WriterOperation {
    @Override // com.itextpdf.text.Element
    public boolean isContent() {
        return false;
    }

    @Override // com.itextpdf.text.Element
    public int type() {
        return Element.WRITABLE_DIRECT;
    }

    @Override // com.itextpdf.text.Element
    public boolean process(ElementListener elementListener) {
        throw new UnsupportedOperationException();
    }

    @Override // com.itextpdf.text.Element
    public boolean isNestable() {
        throw new UnsupportedOperationException();
    }

    @Override // com.itextpdf.text.Element
    public java.util.List<Chunk> getChunks() {
        return new ArrayList(0);
    }
}
