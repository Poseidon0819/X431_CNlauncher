package com.itextpdf.text.pdf.events;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfFormField;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPCellEvent;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfRectangle;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.TextField;
import java.io.IOException;
import java.util.HashMap;

/* loaded from: classes.dex */
public class FieldPositioningEvents extends PdfPageEventHelper implements PdfPCellEvent {
    protected PdfFormField cellField;
    protected PdfWriter fieldWriter;
    protected HashMap<String, PdfFormField> genericChunkFields;
    public float padding;
    protected PdfFormField parent;

    public FieldPositioningEvents() {
        this.genericChunkFields = new HashMap<>();
        this.cellField = null;
        this.fieldWriter = null;
        this.parent = null;
    }

    public void addField(String str, PdfFormField pdfFormField) {
        this.genericChunkFields.put(str, pdfFormField);
    }

    public FieldPositioningEvents(PdfWriter pdfWriter, PdfFormField pdfFormField) {
        this.genericChunkFields = new HashMap<>();
        this.cellField = null;
        this.fieldWriter = null;
        this.parent = null;
        this.cellField = pdfFormField;
        this.fieldWriter = pdfWriter;
    }

    public FieldPositioningEvents(PdfFormField pdfFormField, PdfFormField pdfFormField2) {
        this.genericChunkFields = new HashMap<>();
        this.cellField = null;
        this.fieldWriter = null;
        this.parent = null;
        this.cellField = pdfFormField2;
        this.parent = pdfFormField;
    }

    public FieldPositioningEvents(PdfWriter pdfWriter, String str) throws IOException, DocumentException {
        this.genericChunkFields = new HashMap<>();
        this.cellField = null;
        this.fieldWriter = null;
        this.parent = null;
        this.fieldWriter = pdfWriter;
        TextField textField = new TextField(pdfWriter, new Rectangle(ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO), str);
        textField.setFontSize(14.0f);
        this.cellField = textField.getTextField();
    }

    public FieldPositioningEvents(PdfWriter pdfWriter, PdfFormField pdfFormField, String str) throws IOException, DocumentException {
        this.genericChunkFields = new HashMap<>();
        this.cellField = null;
        this.fieldWriter = null;
        this.parent = null;
        this.parent = pdfFormField;
        TextField textField = new TextField(pdfWriter, new Rectangle(ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO), str);
        textField.setFontSize(14.0f);
        this.cellField = textField.getTextField();
    }

    public void setPadding(float f) {
        this.padding = f;
    }

    public void setParent(PdfFormField pdfFormField) {
        this.parent = pdfFormField;
    }

    @Override // com.itextpdf.text.pdf.PdfPageEventHelper, com.itextpdf.text.pdf.PdfPageEvent
    public void onGenericTag(PdfWriter pdfWriter, Document document, Rectangle rectangle, String str) {
        rectangle.setBottom(rectangle.getBottom() - 3.0f);
        PdfFormField pdfFormField = this.genericChunkFields.get(str);
        if (pdfFormField == null) {
            TextField textField = new TextField(pdfWriter, new Rectangle(rectangle.getLeft(this.padding), rectangle.getBottom(this.padding), rectangle.getRight(this.padding), rectangle.getTop(this.padding)), str);
            textField.setFontSize(14.0f);
            try {
                pdfFormField = textField.getTextField();
            } catch (Exception e) {
                throw new ExceptionConverter(e);
            }
        } else {
            pdfFormField.put(PdfName.RECT, new PdfRectangle(rectangle.getLeft(this.padding), rectangle.getBottom(this.padding), rectangle.getRight(this.padding), rectangle.getTop(this.padding)));
        }
        PdfFormField pdfFormField2 = this.parent;
        if (pdfFormField2 == null) {
            pdfWriter.addAnnotation(pdfFormField);
        } else {
            pdfFormField2.addKid(pdfFormField);
        }
    }

    @Override // com.itextpdf.text.pdf.PdfPCellEvent
    public void cellLayout(PdfPCell pdfPCell, Rectangle rectangle, PdfContentByte[] pdfContentByteArr) {
        if (this.cellField == null || (this.fieldWriter == null && this.parent == null)) {
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("you.have.used.the.wrong.constructor.for.this.fieldpositioningevents.class", new Object[0]));
        }
        this.cellField.put(PdfName.RECT, new PdfRectangle(rectangle.getLeft(this.padding), rectangle.getBottom(this.padding), rectangle.getRight(this.padding), rectangle.getTop(this.padding)));
        PdfFormField pdfFormField = this.parent;
        if (pdfFormField == null) {
            this.fieldWriter.addAnnotation(this.cellField);
        } else {
            pdfFormField.addKid(this.cellField);
        }
    }
}
