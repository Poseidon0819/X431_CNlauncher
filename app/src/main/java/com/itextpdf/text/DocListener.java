package com.itextpdf.text;

/* loaded from: classes.dex */
public interface DocListener extends ElementListener {
    void close();

    boolean newPage();

    void open();

    void resetPageCount();

    boolean setMarginMirroring(boolean z);

    boolean setMarginMirroringTopBottom(boolean z);

    boolean setMargins(float f, float f2, float f3, float f4);

    void setPageCount(int i);

    boolean setPageSize(Rectangle rectangle);
}
