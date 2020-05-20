package com.itextpdf.text;

import com.itextpdf.text.factories.RomanNumberFactory;
import com.itextpdf.text.pdf.ColumnText;

/* loaded from: classes.dex */
public class RomanList extends List {
    public RomanList() {
        super(true);
    }

    public RomanList(int i) {
        super(true, i);
    }

    public RomanList(boolean z, int i) {
        super(true, i);
        this.lowercase = z;
    }

    @Override // com.itextpdf.text.List, com.itextpdf.text.TextElementArray
    public boolean add(Element element) {
        if (element instanceof ListItem) {
            ListItem listItem = (ListItem) element;
            Chunk chunk = new Chunk(this.preSymbol, this.symbol.getFont());
            chunk.setAttributes(this.symbol.getAttributes());
            chunk.append(RomanNumberFactory.getString(this.first + this.list.size(), this.lowercase));
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
