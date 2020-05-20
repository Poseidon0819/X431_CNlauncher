package com.itextpdf.text;

import com.itextpdf.text.factories.GreekAlphabetFactory;
import com.itextpdf.text.pdf.ColumnText;

/* loaded from: classes.dex */
public class GreekList extends List {
    public GreekList() {
        super(true);
        setGreekFont();
    }

    public GreekList(int i) {
        super(true, i);
        setGreekFont();
    }

    public GreekList(boolean z, int i) {
        super(true, i);
        this.lowercase = z;
        setGreekFont();
    }

    protected void setGreekFont() {
        this.symbol.setFont(FontFactory.getFont("Symbol", this.symbol.getFont().getSize(), 0));
    }

    @Override // com.itextpdf.text.List, com.itextpdf.text.TextElementArray
    public boolean add(Element element) {
        if (element instanceof ListItem) {
            ListItem listItem = (ListItem) element;
            Chunk chunk = new Chunk(this.preSymbol, this.symbol.getFont());
            chunk.setAttributes(this.symbol.getAttributes());
            chunk.append(GreekAlphabetFactory.getString(this.first + this.list.size(), this.lowercase));
            chunk.append(this.postSymbol);
            listItem.setListSymbol(chunk);
            listItem.setIndentationLeft(this.symbolIndent, this.autoindent);
            listItem.setIndentationRight(ColumnText.GLOBAL_SPACE_CHAR_RATIO);
            this.list.add(listItem);
            return false;
        } else if (element instanceof List) {
            List list = (List) element;
            list.setIndentationLeft(list.getIndentationLeft() + this.symbolIndent);
            this.first--;
            return this.list.add(list);
        } else {
            return false;
        }
    }
}
