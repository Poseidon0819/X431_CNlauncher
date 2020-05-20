package com.itextpdf.text;

import com.itextpdf.text.pdf.ColumnText;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

/* loaded from: classes.dex */
public class ZapfDingbatsList extends List {

    /* renamed from: zn */
    protected int f19617zn;

    public ZapfDingbatsList(int i) {
        super(true);
        this.f19617zn = i;
        this.symbol.setFont(FontFactory.getFont("ZapfDingbats", this.symbol.getFont().getSize(), 0));
        this.postSymbol = MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
    }

    public ZapfDingbatsList(int i, int i2) {
        super(true, i2);
        this.f19617zn = i;
        this.symbol.setFont(FontFactory.getFont("ZapfDingbats", this.symbol.getFont().getSize(), 0));
        this.postSymbol = MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
    }

    public ZapfDingbatsList(int i, int i2, BaseColor baseColor) {
        super(true, i2);
        this.f19617zn = i;
        this.symbol.setFont(FontFactory.getFont("ZapfDingbats", this.symbol.getFont().getSize(), 0, baseColor));
        this.postSymbol = MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
    }

    public void setDingbatColor(BaseColor baseColor) {
        this.symbol.setFont(FontFactory.getFont("ZapfDingbats", this.symbol.getFont().getSize(), 0, baseColor));
    }

    public void setCharNumber(int i) {
        this.f19617zn = i;
    }

    public int getCharNumber() {
        return this.f19617zn;
    }

    @Override // com.itextpdf.text.List, com.itextpdf.text.TextElementArray
    public boolean add(Element element) {
        if (element instanceof ListItem) {
            ListItem listItem = (ListItem) element;
            Chunk chunk = new Chunk(this.preSymbol, this.symbol.getFont());
            chunk.setAttributes(this.symbol.getAttributes());
            chunk.append(String.valueOf((char) this.f19617zn));
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
