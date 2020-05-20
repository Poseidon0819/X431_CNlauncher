package com.itextpdf.text;

import com.itextpdf.text.pdf.ColumnText;
import org.codehaus.jackson.org.objectweb.asm.Opcodes;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

/* loaded from: classes.dex */
public class ZapfDingbatsNumberList extends List {
    protected int type;

    public ZapfDingbatsNumberList(int i) {
        super(true);
        this.type = i;
        this.symbol.setFont(FontFactory.getFont("ZapfDingbats", this.symbol.getFont().getSize(), 0));
        this.postSymbol = MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
    }

    public ZapfDingbatsNumberList(int i, int i2) {
        super(true, i2);
        this.type = i;
        this.symbol.setFont(FontFactory.getFont("ZapfDingbats", this.symbol.getFont().getSize(), 0));
        this.postSymbol = MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
    }

    public void setType(int i) {
        this.type = i;
    }

    public int getType() {
        return this.type;
    }

    @Override // com.itextpdf.text.List, com.itextpdf.text.TextElementArray
    public boolean add(Element element) {
        if (element instanceof ListItem) {
            ListItem listItem = (ListItem) element;
            Chunk chunk = new Chunk(this.preSymbol, this.symbol.getFont());
            chunk.setAttributes(this.symbol.getAttributes());
            switch (this.type) {
                case 0:
                    chunk.append(String.valueOf((char) (this.first + this.list.size() + Opcodes.LOOKUPSWITCH)));
                    break;
                case 1:
                    chunk.append(String.valueOf((char) (this.first + this.list.size() + Opcodes.PUTFIELD)));
                    break;
                case 2:
                    chunk.append(String.valueOf((char) (this.first + this.list.size() + Opcodes.ATHROW)));
                    break;
                default:
                    chunk.append(String.valueOf((char) (this.first + this.list.size() + 201)));
                    break;
            }
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
