package com.itextpdf.text.pdf;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class PdfTextArray {
    ArrayList<Object> arrayList = new ArrayList<>();
    private Float lastNum;
    private String lastStr;

    public PdfTextArray(String str) {
        add(str);
    }

    public PdfTextArray() {
    }

    public void add(PdfNumber pdfNumber) {
        add((float) pdfNumber.doubleValue());
    }

    public void add(float f) {
        if (f != ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
            Float f2 = this.lastNum;
            if (f2 != null) {
                this.lastNum = new Float(f + f2.floatValue());
                if (this.lastNum.floatValue() != ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
                    replaceLast(this.lastNum);
                } else {
                    ArrayList<Object> arrayList = this.arrayList;
                    arrayList.remove(arrayList.size() - 1);
                }
            } else {
                this.lastNum = Float.valueOf(f);
                this.arrayList.add(this.lastNum);
            }
            this.lastStr = null;
        }
    }

    public void add(String str) {
        if (str.length() > 0) {
            if (this.lastStr != null) {
                this.lastStr += str;
                replaceLast(this.lastStr);
            } else {
                this.lastStr = str;
                this.arrayList.add(this.lastStr);
            }
            this.lastNum = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<Object> getArrayList() {
        return this.arrayList;
    }

    private void replaceLast(Object obj) {
        ArrayList<Object> arrayList = this.arrayList;
        arrayList.set(arrayList.size() - 1, obj);
    }
}
