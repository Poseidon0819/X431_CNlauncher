package com.itextpdf.text;

import com.itextpdf.text.error_messages.MessageLocalization;

/* loaded from: classes.dex */
public class ChapterAutoNumber extends Chapter {
    private static final long serialVersionUID = -9217457637987854167L;
    protected boolean numberSet;

    public ChapterAutoNumber(Paragraph paragraph) {
        super(paragraph, 0);
        this.numberSet = false;
    }

    public ChapterAutoNumber(String str) {
        super(str, 0);
        this.numberSet = false;
    }

    @Override // com.itextpdf.text.Section
    public Section addSection(String str) {
        if (isAddedCompletely()) {
            throw new IllegalStateException(MessageLocalization.getComposedMessage("this.largeelement.has.already.been.added.to.the.document", new Object[0]));
        }
        return addSection(str, 2);
    }

    @Override // com.itextpdf.text.Section
    public Section addSection(Paragraph paragraph) {
        if (isAddedCompletely()) {
            throw new IllegalStateException(MessageLocalization.getComposedMessage("this.largeelement.has.already.been.added.to.the.document", new Object[0]));
        }
        return addSection(paragraph, 2);
    }

    public int setAutomaticNumber(int i) {
        if (this.numberSet) {
            return i;
        }
        int i2 = i + 1;
        super.setChapterNumber(i2);
        this.numberSet = true;
        return i2;
    }
}
