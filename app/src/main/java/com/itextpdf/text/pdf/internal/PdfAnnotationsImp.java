package com.itextpdf.text.pdf.internal;

import com.itextpdf.text.Annotation;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfAcroForm;
import com.itextpdf.text.pdf.PdfAction;
import com.itextpdf.text.pdf.PdfAnnotation;
import com.itextpdf.text.pdf.PdfArray;
import com.itextpdf.text.pdf.PdfFileSpecification;
import com.itextpdf.text.pdf.PdfFormField;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfRectangle;
import com.itextpdf.text.pdf.PdfString;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;

/* loaded from: classes.dex */
public class PdfAnnotationsImp {
    protected PdfAcroForm acroForm;
    protected ArrayList<PdfAnnotation> annotations;
    protected ArrayList<PdfAnnotation> delayedAnnotations = new ArrayList<>();

    public PdfAnnotationsImp(PdfWriter pdfWriter) {
        this.acroForm = new PdfAcroForm(pdfWriter);
    }

    public boolean hasValidAcroForm() {
        return this.acroForm.isValid();
    }

    public PdfAcroForm getAcroForm() {
        return this.acroForm;
    }

    public void setSigFlags(int i) {
        this.acroForm.setSigFlags(i);
    }

    public void addCalculationOrder(PdfFormField pdfFormField) {
        this.acroForm.addCalculationOrder(pdfFormField);
    }

    public void addAnnotation(PdfAnnotation pdfAnnotation) {
        if (pdfAnnotation.isForm()) {
            PdfFormField pdfFormField = (PdfFormField) pdfAnnotation;
            if (pdfFormField.getParent() == null) {
                addFormFieldRaw(pdfFormField);
                return;
            }
            return;
        }
        this.annotations.add(pdfAnnotation);
    }

    public void addPlainAnnotation(PdfAnnotation pdfAnnotation) {
        this.annotations.add(pdfAnnotation);
    }

    void addFormFieldRaw(PdfFormField pdfFormField) {
        this.annotations.add(pdfFormField);
        ArrayList<PdfFormField> kids = pdfFormField.getKids();
        if (kids != null) {
            for (int i = 0; i < kids.size(); i++) {
                addFormFieldRaw(kids.get(i));
            }
        }
    }

    public boolean hasUnusedAnnotations() {
        return !this.annotations.isEmpty();
    }

    public void resetAnnotations() {
        this.annotations = this.delayedAnnotations;
        this.delayedAnnotations = new ArrayList<>();
    }

    public PdfArray rotateAnnotations(PdfWriter pdfWriter, Rectangle rectangle) {
        HashSet<PdfTemplate> templates;
        PdfArray pdfArray = new PdfArray();
        int rotation = rectangle.getRotation() % 360;
        int currentPageNumber = pdfWriter.getCurrentPageNumber();
        for (int i = 0; i < this.annotations.size(); i++) {
            PdfAnnotation pdfAnnotation = this.annotations.get(i);
            if (pdfAnnotation.getPlaceInPage() > currentPageNumber) {
                this.delayedAnnotations.add(pdfAnnotation);
            } else {
                if (pdfAnnotation.isForm()) {
                    if (!pdfAnnotation.isUsed() && (templates = pdfAnnotation.getTemplates()) != null) {
                        this.acroForm.addFieldTemplates(templates);
                    }
                    PdfFormField pdfFormField = (PdfFormField) pdfAnnotation;
                    if (pdfFormField.getParent() == null) {
                        this.acroForm.addDocumentField(pdfFormField.getIndirectReference());
                    }
                }
                if (pdfAnnotation.isAnnotation()) {
                    pdfArray.add(pdfAnnotation.getIndirectReference());
                    if (!pdfAnnotation.isUsed()) {
                        PdfArray asArray = pdfAnnotation.getAsArray(PdfName.RECT);
                        PdfRectangle pdfRectangle = new PdfRectangle(asArray.getAsNumber(0).floatValue(), asArray.getAsNumber(1).floatValue());
                        if (asArray.size() == 4) {
                            pdfRectangle.add(asArray.getAsNumber(2));
                            pdfRectangle.add(asArray.getAsNumber(3));
                        }
                        if (rotation == 90) {
                            pdfAnnotation.put(PdfName.RECT, new PdfRectangle(rectangle.getTop() - pdfRectangle.bottom(), pdfRectangle.left(), rectangle.getTop() - pdfRectangle.top(), pdfRectangle.right()));
                        } else if (rotation == 180) {
                            pdfAnnotation.put(PdfName.RECT, new PdfRectangle(rectangle.getRight() - pdfRectangle.left(), rectangle.getTop() - pdfRectangle.bottom(), rectangle.getRight() - pdfRectangle.right(), rectangle.getTop() - pdfRectangle.top()));
                        } else if (rotation == 270) {
                            pdfAnnotation.put(PdfName.RECT, new PdfRectangle(pdfRectangle.bottom(), rectangle.getRight() - pdfRectangle.left(), pdfRectangle.top(), rectangle.getRight() - pdfRectangle.right()));
                        }
                    }
                }
                if (pdfAnnotation.isUsed()) {
                    continue;
                } else {
                    pdfAnnotation.setUsed();
                    try {
                        pdfWriter.addToBody(pdfAnnotation, pdfAnnotation.getIndirectReference());
                    } catch (IOException e) {
                        throw new ExceptionConverter(e);
                    }
                }
            }
        }
        return pdfArray;
    }

    public static PdfAnnotation convertAnnotation(PdfWriter pdfWriter, Annotation annotation, Rectangle rectangle) throws IOException {
        PdfFileSpecification fileExtern;
        switch (annotation.annotationType()) {
            case 1:
                return new PdfAnnotation(pdfWriter, annotation.llx(), annotation.lly(), annotation.urx(), annotation.ury(), new PdfAction((URL) annotation.attributes().get(Annotation.URL)));
            case 2:
                return new PdfAnnotation(pdfWriter, annotation.llx(), annotation.lly(), annotation.urx(), annotation.ury(), new PdfAction((String) annotation.attributes().get(Annotation.FILE)));
            case 3:
                return new PdfAnnotation(pdfWriter, annotation.llx(), annotation.lly(), annotation.urx(), annotation.ury(), new PdfAction((String) annotation.attributes().get(Annotation.FILE), (String) annotation.attributes().get(Annotation.DESTINATION)));
            case 4:
                return new PdfAnnotation(pdfWriter, annotation.llx(), annotation.lly(), annotation.urx(), annotation.ury(), new PdfAction((String) annotation.attributes().get(Annotation.FILE), ((Integer) annotation.attributes().get(Annotation.PAGE)).intValue()));
            case 5:
                return new PdfAnnotation(pdfWriter, annotation.llx(), annotation.lly(), annotation.urx(), annotation.ury(), new PdfAction(((Integer) annotation.attributes().get(Annotation.NAMED)).intValue()));
            case 6:
                return new PdfAnnotation(pdfWriter, annotation.llx(), annotation.lly(), annotation.urx(), annotation.ury(), new PdfAction((String) annotation.attributes().get(Annotation.APPLICATION), (String) annotation.attributes().get(Annotation.PARAMETERS), (String) annotation.attributes().get(Annotation.OPERATION), (String) annotation.attributes().get(Annotation.DEFAULTDIR)));
            case 7:
                boolean[] zArr = (boolean[]) annotation.attributes().get(Annotation.PARAMETERS);
                String str = (String) annotation.attributes().get(Annotation.FILE);
                String str2 = (String) annotation.attributes().get(Annotation.MIMETYPE);
                if (zArr[0]) {
                    fileExtern = PdfFileSpecification.fileEmbedded(pdfWriter, str, str, null);
                } else {
                    fileExtern = PdfFileSpecification.fileExtern(pdfWriter, str);
                }
                return PdfAnnotation.createScreen(pdfWriter, new Rectangle(annotation.llx(), annotation.lly(), annotation.urx(), annotation.ury()), str, fileExtern, str2, zArr[1]);
            default:
                return new PdfAnnotation(pdfWriter, rectangle.getLeft(), rectangle.getBottom(), rectangle.getRight(), rectangle.getTop(), new PdfString(annotation.title(), PdfObject.TEXT_UNICODE), new PdfString(annotation.content(), PdfObject.TEXT_UNICODE));
        }
    }
}
