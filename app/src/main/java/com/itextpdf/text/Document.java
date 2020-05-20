package com.itextpdf.text;

import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.ColumnText;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/* loaded from: classes.dex */
public class Document implements DocListener {
    public static boolean compress = true;
    public static boolean plainRandomAccess = false;
    public static float wmfFontCorrection = 0.86f;
    protected int chapternumber;
    protected boolean close;
    protected String htmlStyleClass;
    protected String javaScript_onLoad;
    protected String javaScript_onUnLoad;
    protected ArrayList<DocListener> listeners;
    protected float marginBottom;
    protected float marginLeft;
    protected boolean marginMirroring;
    protected boolean marginMirroringTopBottom;
    protected float marginRight;
    protected float marginTop;
    protected boolean open;
    protected int pageN;
    protected Rectangle pageSize;

    public Document() {
        this(PageSize.f19601A4);
    }

    public Document(Rectangle rectangle) {
        this(rectangle, 36.0f, 36.0f, 36.0f, 36.0f);
    }

    public Document(Rectangle rectangle, float f, float f2, float f3, float f4) {
        this.listeners = new ArrayList<>();
        this.marginLeft = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.marginRight = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.marginTop = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.marginBottom = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.marginMirroring = false;
        this.marginMirroringTopBottom = false;
        this.javaScript_onLoad = null;
        this.javaScript_onUnLoad = null;
        this.htmlStyleClass = null;
        this.pageN = 0;
        this.chapternumber = 0;
        this.pageSize = rectangle;
        this.marginLeft = f;
        this.marginRight = f2;
        this.marginTop = f3;
        this.marginBottom = f4;
    }

    public void addDocListener(DocListener docListener) {
        this.listeners.add(docListener);
    }

    public void removeDocListener(DocListener docListener) {
        this.listeners.remove(docListener);
    }

    @Override // com.itextpdf.text.ElementListener
    public boolean add(Element element) throws DocumentException {
        boolean z = false;
        if (this.close) {
            throw new DocumentException(MessageLocalization.getComposedMessage("the.document.has.been.closed.you.can.t.add.any.elements", new Object[0]));
        }
        if (!this.open && element.isContent()) {
            throw new DocumentException(MessageLocalization.getComposedMessage("the.document.is.not.open.yet.you.can.only.add.meta.information", new Object[0]));
        }
        if (element instanceof ChapterAutoNumber) {
            this.chapternumber = ((ChapterAutoNumber) element).setAutomaticNumber(this.chapternumber);
        }
        Iterator<DocListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            z |= it.next().add(element);
        }
        if (element instanceof LargeElement) {
            LargeElement largeElement = (LargeElement) element;
            if (!largeElement.isComplete()) {
                largeElement.flushContent();
            }
        }
        return z;
    }

    @Override // com.itextpdf.text.DocListener
    public void open() {
        if (!this.close) {
            this.open = true;
        }
        Iterator<DocListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            DocListener next = it.next();
            next.setPageSize(this.pageSize);
            next.setMargins(this.marginLeft, this.marginRight, this.marginTop, this.marginBottom);
            next.open();
        }
    }

    @Override // com.itextpdf.text.DocListener
    public boolean setPageSize(Rectangle rectangle) {
        this.pageSize = rectangle;
        Iterator<DocListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().setPageSize(rectangle);
        }
        return true;
    }

    @Override // com.itextpdf.text.DocListener
    public boolean setMargins(float f, float f2, float f3, float f4) {
        this.marginLeft = f;
        this.marginRight = f2;
        this.marginTop = f3;
        this.marginBottom = f4;
        Iterator<DocListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().setMargins(f, f2, f3, f4);
        }
        return true;
    }

    @Override // com.itextpdf.text.DocListener
    public boolean newPage() {
        if (!this.open || this.close) {
            return false;
        }
        Iterator<DocListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().newPage();
        }
        return true;
    }

    @Override // com.itextpdf.text.DocListener
    public void resetPageCount() {
        this.pageN = 0;
        Iterator<DocListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().resetPageCount();
        }
    }

    @Override // com.itextpdf.text.DocListener
    public void setPageCount(int i) {
        this.pageN = i;
        Iterator<DocListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().setPageCount(i);
        }
    }

    public int getPageNumber() {
        return this.pageN;
    }

    @Override // com.itextpdf.text.DocListener
    public void close() {
        if (!this.close) {
            this.open = false;
            this.close = true;
        }
        Iterator<DocListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().close();
        }
    }

    public boolean addHeader(String str, String str2) {
        try {
            return add(new Header(str, str2));
        } catch (DocumentException e) {
            throw new ExceptionConverter(e);
        }
    }

    public boolean addTitle(String str) {
        try {
            return add(new Meta(1, str));
        } catch (DocumentException e) {
            throw new ExceptionConverter(e);
        }
    }

    public boolean addSubject(String str) {
        try {
            return add(new Meta(2, str));
        } catch (DocumentException e) {
            throw new ExceptionConverter(e);
        }
    }

    public boolean addKeywords(String str) {
        try {
            return add(new Meta(3, str));
        } catch (DocumentException e) {
            throw new ExceptionConverter(e);
        }
    }

    public boolean addAuthor(String str) {
        try {
            return add(new Meta(4, str));
        } catch (DocumentException e) {
            throw new ExceptionConverter(e);
        }
    }

    public boolean addCreator(String str) {
        try {
            return add(new Meta(7, str));
        } catch (DocumentException e) {
            throw new ExceptionConverter(e);
        }
    }

    public boolean addProducer() {
        try {
            return add(new Meta(5, Version.getInstance().getVersion()));
        } catch (DocumentException e) {
            throw new ExceptionConverter(e);
        }
    }

    public boolean addCreationDate() {
        try {
            return add(new Meta(6, new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").format(new Date())));
        } catch (DocumentException e) {
            throw new ExceptionConverter(e);
        }
    }

    public float leftMargin() {
        return this.marginLeft;
    }

    public float rightMargin() {
        return this.marginRight;
    }

    public float topMargin() {
        return this.marginTop;
    }

    public float bottomMargin() {
        return this.marginBottom;
    }

    public float left() {
        return this.pageSize.getLeft(this.marginLeft);
    }

    public float right() {
        return this.pageSize.getRight(this.marginRight);
    }

    public float top() {
        return this.pageSize.getTop(this.marginTop);
    }

    public float bottom() {
        return this.pageSize.getBottom(this.marginBottom);
    }

    public float left(float f) {
        return this.pageSize.getLeft(this.marginLeft + f);
    }

    public float right(float f) {
        return this.pageSize.getRight(this.marginRight + f);
    }

    public float top(float f) {
        return this.pageSize.getTop(this.marginTop + f);
    }

    public float bottom(float f) {
        return this.pageSize.getBottom(this.marginBottom + f);
    }

    public Rectangle getPageSize() {
        return this.pageSize;
    }

    public boolean isOpen() {
        return this.open;
    }

    public void setJavaScript_onLoad(String str) {
        this.javaScript_onLoad = str;
    }

    public String getJavaScript_onLoad() {
        return this.javaScript_onLoad;
    }

    public void setJavaScript_onUnLoad(String str) {
        this.javaScript_onUnLoad = str;
    }

    public String getJavaScript_onUnLoad() {
        return this.javaScript_onUnLoad;
    }

    public void setHtmlStyleClass(String str) {
        this.htmlStyleClass = str;
    }

    public String getHtmlStyleClass() {
        return this.htmlStyleClass;
    }

    @Override // com.itextpdf.text.DocListener
    public boolean setMarginMirroring(boolean z) {
        this.marginMirroring = z;
        Iterator<DocListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().setMarginMirroring(z);
        }
        return true;
    }

    @Override // com.itextpdf.text.DocListener
    public boolean setMarginMirroringTopBottom(boolean z) {
        this.marginMirroringTopBottom = z;
        Iterator<DocListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().setMarginMirroringTopBottom(z);
        }
        return true;
    }

    public boolean isMarginMirroring() {
        return this.marginMirroring;
    }
}
