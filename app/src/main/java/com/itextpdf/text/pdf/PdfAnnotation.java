package com.itextpdf.text.pdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.error_messages.MessageLocalization;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import org.apache.http.conn.ssl.TokenParser;

/* loaded from: classes.dex */
public class PdfAnnotation extends PdfDictionary {
    public static final int FLAGS_HIDDEN = 2;
    public static final int FLAGS_INVISIBLE = 1;
    public static final int FLAGS_LOCKED = 128;
    public static final int FLAGS_NOROTATE = 16;
    public static final int FLAGS_NOVIEW = 32;
    public static final int FLAGS_NOZOOM = 8;
    public static final int FLAGS_PRINT = 4;
    public static final int FLAGS_READONLY = 64;
    public static final int FLAGS_TOGGLENOVIEW = 256;
    public static final int MARKUP_HIGHLIGHT = 0;
    public static final int MARKUP_SQUIGGLY = 3;
    public static final int MARKUP_STRIKEOUT = 2;
    public static final int MARKUP_UNDERLINE = 1;
    protected PdfIndirectReference reference;
    protected HashSet<PdfTemplate> templates;
    protected PdfWriter writer;
    public static final PdfName HIGHLIGHT_NONE = PdfName.f19739N;
    public static final PdfName HIGHLIGHT_INVERT = PdfName.f19729I;
    public static final PdfName HIGHLIGHT_OUTLINE = PdfName.f19746O;
    public static final PdfName HIGHLIGHT_PUSH = PdfName.f19752P;
    public static final PdfName HIGHLIGHT_TOGGLE = PdfName.f19772T;
    public static final PdfName APPEARANCE_NORMAL = PdfName.f19739N;
    public static final PdfName APPEARANCE_ROLLOVER = PdfName.f19760R;
    public static final PdfName APPEARANCE_DOWN = PdfName.f19699D;
    public static final PdfName AA_ENTER = PdfName.f19710E;
    public static final PdfName AA_EXIT = PdfName.f19796X;
    public static final PdfName AA_DOWN = PdfName.f19699D;
    public static final PdfName AA_UP = PdfName.f19783U;
    public static final PdfName AA_FOCUS = PdfName.f19718FO;
    public static final PdfName AA_BLUR = PdfName.f19687BL;
    public static final PdfName AA_JS_KEY = PdfName.f19734K;
    public static final PdfName AA_JS_FORMAT = PdfName.f19712F;
    public static final PdfName AA_JS_CHANGE = PdfName.f19787V;
    public static final PdfName AA_JS_OTHER_CHANGE = PdfName.f19690C;
    protected boolean form = false;
    protected boolean annotation = true;
    protected boolean used = false;
    private int placeInPage = -1;

    public PdfAnnotation(PdfWriter pdfWriter, Rectangle rectangle) {
        this.writer = pdfWriter;
        if (rectangle != null) {
            put(PdfName.RECT, new PdfRectangle(rectangle));
        }
    }

    public PdfAnnotation(PdfWriter pdfWriter, float f, float f2, float f3, float f4, PdfString pdfString, PdfString pdfString2) {
        this.writer = pdfWriter;
        put(PdfName.SUBTYPE, PdfName.TEXT);
        put(PdfName.f19772T, pdfString);
        put(PdfName.RECT, new PdfRectangle(f, f2, f3, f4));
        put(PdfName.CONTENTS, pdfString2);
    }

    public PdfAnnotation(PdfWriter pdfWriter, float f, float f2, float f3, float f4, PdfAction pdfAction) {
        this.writer = pdfWriter;
        put(PdfName.SUBTYPE, PdfName.LINK);
        put(PdfName.RECT, new PdfRectangle(f, f2, f3, f4));
        put(PdfName.f19679A, pdfAction);
        put(PdfName.BORDER, new PdfBorderArray(ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO));
        put(PdfName.f19690C, new PdfColor(0, 0, 255));
    }

    public static PdfAnnotation createScreen(PdfWriter pdfWriter, Rectangle rectangle, String str, PdfFileSpecification pdfFileSpecification, String str2, boolean z) throws IOException {
        PdfAnnotation pdfAnnotation = new PdfAnnotation(pdfWriter, rectangle);
        pdfAnnotation.put(PdfName.SUBTYPE, PdfName.SCREEN);
        pdfAnnotation.put(PdfName.f19712F, new PdfNumber(4));
        pdfAnnotation.put(PdfName.TYPE, PdfName.ANNOT);
        pdfAnnotation.setPage();
        PdfIndirectReference indirectReference = pdfWriter.addToBody(PdfAction.rendition(str, pdfFileSpecification, str2, pdfAnnotation.getIndirectReference())).getIndirectReference();
        if (z) {
            PdfDictionary pdfDictionary = new PdfDictionary();
            pdfDictionary.put(new PdfName("PV"), indirectReference);
            pdfAnnotation.put(PdfName.f19680AA, pdfDictionary);
        }
        pdfAnnotation.put(PdfName.f19679A, indirectReference);
        return pdfAnnotation;
    }

    public PdfIndirectReference getIndirectReference() {
        if (this.reference == null) {
            this.reference = this.writer.getPdfIndirectReference();
        }
        return this.reference;
    }

    public static PdfAnnotation createText(PdfWriter pdfWriter, Rectangle rectangle, String str, String str2, boolean z, String str3) {
        PdfAnnotation pdfAnnotation = new PdfAnnotation(pdfWriter, rectangle);
        pdfAnnotation.put(PdfName.SUBTYPE, PdfName.TEXT);
        if (str != null) {
            pdfAnnotation.put(PdfName.f19772T, new PdfString(str, PdfObject.TEXT_UNICODE));
        }
        if (str2 != null) {
            pdfAnnotation.put(PdfName.CONTENTS, new PdfString(str2, PdfObject.TEXT_UNICODE));
        }
        if (z) {
            pdfAnnotation.put(PdfName.OPEN, PdfBoolean.PDFTRUE);
        }
        if (str3 != null) {
            pdfAnnotation.put(PdfName.NAME, new PdfName(str3));
        }
        return pdfAnnotation;
    }

    protected static PdfAnnotation createLink(PdfWriter pdfWriter, Rectangle rectangle, PdfName pdfName) {
        PdfAnnotation pdfAnnotation = new PdfAnnotation(pdfWriter, rectangle);
        pdfAnnotation.put(PdfName.SUBTYPE, PdfName.LINK);
        if (!pdfName.equals(HIGHLIGHT_INVERT)) {
            pdfAnnotation.put(PdfName.f19721H, pdfName);
        }
        return pdfAnnotation;
    }

    public static PdfAnnotation createLink(PdfWriter pdfWriter, Rectangle rectangle, PdfName pdfName, PdfAction pdfAction) {
        PdfAnnotation createLink = createLink(pdfWriter, rectangle, pdfName);
        createLink.putEx(PdfName.f19679A, pdfAction);
        return createLink;
    }

    public static PdfAnnotation createLink(PdfWriter pdfWriter, Rectangle rectangle, PdfName pdfName, String str) {
        PdfAnnotation createLink = createLink(pdfWriter, rectangle, pdfName);
        createLink.put(PdfName.DEST, new PdfString(str));
        return createLink;
    }

    public static PdfAnnotation createLink(PdfWriter pdfWriter, Rectangle rectangle, PdfName pdfName, int i, PdfDestination pdfDestination) {
        PdfAnnotation createLink = createLink(pdfWriter, rectangle, pdfName);
        pdfDestination.addPage(pdfWriter.getPageReference(i));
        createLink.put(PdfName.DEST, pdfDestination);
        return createLink;
    }

    public static PdfAnnotation createFreeText(PdfWriter pdfWriter, Rectangle rectangle, String str, PdfContentByte pdfContentByte) {
        PdfAnnotation pdfAnnotation = new PdfAnnotation(pdfWriter, rectangle);
        pdfAnnotation.put(PdfName.SUBTYPE, PdfName.FREETEXT);
        pdfAnnotation.put(PdfName.CONTENTS, new PdfString(str, PdfObject.TEXT_UNICODE));
        pdfAnnotation.setDefaultAppearanceString(pdfContentByte);
        return pdfAnnotation;
    }

    public static PdfAnnotation createLine(PdfWriter pdfWriter, Rectangle rectangle, String str, float f, float f2, float f3, float f4) {
        PdfAnnotation pdfAnnotation = new PdfAnnotation(pdfWriter, rectangle);
        pdfAnnotation.put(PdfName.SUBTYPE, PdfName.LINE);
        pdfAnnotation.put(PdfName.CONTENTS, new PdfString(str, PdfObject.TEXT_UNICODE));
        PdfArray pdfArray = new PdfArray(new PdfNumber(f));
        pdfArray.add(new PdfNumber(f2));
        pdfArray.add(new PdfNumber(f3));
        pdfArray.add(new PdfNumber(f4));
        pdfAnnotation.put(PdfName.f19735L, pdfArray);
        return pdfAnnotation;
    }

    public static PdfAnnotation createSquareCircle(PdfWriter pdfWriter, Rectangle rectangle, String str, boolean z) {
        PdfAnnotation pdfAnnotation = new PdfAnnotation(pdfWriter, rectangle);
        if (z) {
            pdfAnnotation.put(PdfName.SUBTYPE, PdfName.SQUARE);
        } else {
            pdfAnnotation.put(PdfName.SUBTYPE, PdfName.CIRCLE);
        }
        pdfAnnotation.put(PdfName.CONTENTS, new PdfString(str, PdfObject.TEXT_UNICODE));
        return pdfAnnotation;
    }

    public static PdfAnnotation createMarkup(PdfWriter pdfWriter, Rectangle rectangle, String str, int i, float[] fArr) {
        PdfAnnotation pdfAnnotation = new PdfAnnotation(pdfWriter, rectangle);
        PdfName pdfName = PdfName.HIGHLIGHT;
        switch (i) {
            case 1:
                pdfName = PdfName.UNDERLINE;
                break;
            case 2:
                pdfName = PdfName.STRIKEOUT;
                break;
            case 3:
                pdfName = PdfName.SQUIGGLY;
                break;
        }
        pdfAnnotation.put(PdfName.SUBTYPE, pdfName);
        pdfAnnotation.put(PdfName.CONTENTS, new PdfString(str, PdfObject.TEXT_UNICODE));
        PdfArray pdfArray = new PdfArray();
        for (float f : fArr) {
            pdfArray.add(new PdfNumber(f));
        }
        pdfAnnotation.put(PdfName.QUADPOINTS, pdfArray);
        return pdfAnnotation;
    }

    public static PdfAnnotation createStamp(PdfWriter pdfWriter, Rectangle rectangle, String str, String str2) {
        PdfAnnotation pdfAnnotation = new PdfAnnotation(pdfWriter, rectangle);
        pdfAnnotation.put(PdfName.SUBTYPE, PdfName.STAMP);
        pdfAnnotation.put(PdfName.CONTENTS, new PdfString(str, PdfObject.TEXT_UNICODE));
        pdfAnnotation.put(PdfName.NAME, new PdfName(str2));
        return pdfAnnotation;
    }

    public static PdfAnnotation createInk(PdfWriter pdfWriter, Rectangle rectangle, String str, float[][] fArr) {
        PdfAnnotation pdfAnnotation = new PdfAnnotation(pdfWriter, rectangle);
        pdfAnnotation.put(PdfName.SUBTYPE, PdfName.INK);
        pdfAnnotation.put(PdfName.CONTENTS, new PdfString(str, PdfObject.TEXT_UNICODE));
        PdfArray pdfArray = new PdfArray();
        for (float[] fArr2 : fArr) {
            PdfArray pdfArray2 = new PdfArray();
            for (float f : fArr2) {
                pdfArray2.add(new PdfNumber(f));
            }
            pdfArray.add(pdfArray2);
        }
        pdfAnnotation.put(PdfName.INKLIST, pdfArray);
        return pdfAnnotation;
    }

    public static PdfAnnotation createFileAttachment(PdfWriter pdfWriter, Rectangle rectangle, String str, byte[] bArr, String str2, String str3) throws IOException {
        return createFileAttachment(pdfWriter, rectangle, str, PdfFileSpecification.fileEmbedded(pdfWriter, str2, str3, bArr));
    }

    public static PdfAnnotation createFileAttachment(PdfWriter pdfWriter, Rectangle rectangle, String str, PdfFileSpecification pdfFileSpecification) throws IOException {
        PdfAnnotation pdfAnnotation = new PdfAnnotation(pdfWriter, rectangle);
        pdfAnnotation.put(PdfName.SUBTYPE, PdfName.FILEATTACHMENT);
        if (str != null) {
            pdfAnnotation.put(PdfName.CONTENTS, new PdfString(str, PdfObject.TEXT_UNICODE));
        }
        pdfAnnotation.put(PdfName.f19719FS, pdfFileSpecification.getReference());
        return pdfAnnotation;
    }

    public static PdfAnnotation createPopup(PdfWriter pdfWriter, Rectangle rectangle, String str, boolean z) {
        PdfAnnotation pdfAnnotation = new PdfAnnotation(pdfWriter, rectangle);
        pdfAnnotation.put(PdfName.SUBTYPE, PdfName.POPUP);
        if (str != null) {
            pdfAnnotation.put(PdfName.CONTENTS, new PdfString(str, PdfObject.TEXT_UNICODE));
        }
        if (z) {
            pdfAnnotation.put(PdfName.OPEN, PdfBoolean.PDFTRUE);
        }
        return pdfAnnotation;
    }

    public static PdfAnnotation createPolygonPolyline(PdfWriter pdfWriter, Rectangle rectangle, String str, boolean z, PdfArray pdfArray) {
        PdfAnnotation pdfAnnotation = new PdfAnnotation(pdfWriter, rectangle);
        if (z) {
            pdfAnnotation.put(PdfName.SUBTYPE, PdfName.POLYGON);
        } else {
            pdfAnnotation.put(PdfName.SUBTYPE, PdfName.POLYLINE);
        }
        pdfAnnotation.put(PdfName.CONTENTS, new PdfString(str, PdfObject.TEXT_UNICODE));
        pdfAnnotation.put(PdfName.VERTICES, new PdfArray(pdfArray));
        return pdfAnnotation;
    }

    public void setDefaultAppearanceString(PdfContentByte pdfContentByte) {
        byte[] byteArray = pdfContentByte.getInternalBuffer().toByteArray();
        int length = byteArray.length;
        for (int i = 0; i < length; i++) {
            if (byteArray[i] == 10) {
                byteArray[i] = 32;
            }
        }
        put(PdfName.f19700DA, new PdfString(byteArray));
    }

    public void setFlags(int i) {
        if (i == 0) {
            remove(PdfName.f19712F);
        } else {
            put(PdfName.f19712F, new PdfNumber(i));
        }
    }

    public void setBorder(PdfBorderArray pdfBorderArray) {
        put(PdfName.BORDER, pdfBorderArray);
    }

    public void setBorderStyle(PdfBorderDictionary pdfBorderDictionary) {
        put(PdfName.f19689BS, pdfBorderDictionary);
    }

    public void setHighlighting(PdfName pdfName) {
        if (pdfName.equals(HIGHLIGHT_INVERT)) {
            remove(PdfName.f19721H);
        } else {
            put(PdfName.f19721H, pdfName);
        }
    }

    public void setAppearance(PdfName pdfName, PdfTemplate pdfTemplate) {
        PdfDictionary pdfDictionary = (PdfDictionary) get(PdfName.f19682AP);
        if (pdfDictionary == null) {
            pdfDictionary = new PdfDictionary();
        }
        pdfDictionary.put(pdfName, pdfTemplate.getIndirectReference());
        put(PdfName.f19682AP, pdfDictionary);
        if (this.form) {
            if (this.templates == null) {
                this.templates = new HashSet<>();
            }
            this.templates.add(pdfTemplate);
        }
    }

    public void setAppearance(PdfName pdfName, String str, PdfTemplate pdfTemplate) {
        PdfDictionary pdfDictionary;
        PdfDictionary pdfDictionary2 = (PdfDictionary) get(PdfName.f19682AP);
        if (pdfDictionary2 == null) {
            pdfDictionary2 = new PdfDictionary();
        }
        PdfObject pdfObject = pdfDictionary2.get(pdfName);
        if (pdfObject != null && pdfObject.isDictionary()) {
            pdfDictionary = (PdfDictionary) pdfObject;
        } else {
            pdfDictionary = new PdfDictionary();
        }
        pdfDictionary.put(new PdfName(str), pdfTemplate.getIndirectReference());
        pdfDictionary2.put(pdfName, pdfDictionary);
        put(PdfName.f19682AP, pdfDictionary2);
        if (this.form) {
            if (this.templates == null) {
                this.templates = new HashSet<>();
            }
            this.templates.add(pdfTemplate);
        }
    }

    public void setAppearanceState(String str) {
        if (str == null) {
            remove(PdfName.f19683AS);
        } else {
            put(PdfName.f19683AS, new PdfName(str));
        }
    }

    public void setColor(BaseColor baseColor) {
        put(PdfName.f19690C, new PdfColor(baseColor));
    }

    public void setTitle(String str) {
        if (str == null) {
            remove(PdfName.f19772T);
        } else {
            put(PdfName.f19772T, new PdfString(str, PdfObject.TEXT_UNICODE));
        }
    }

    public void setPopup(PdfAnnotation pdfAnnotation) {
        put(PdfName.POPUP, pdfAnnotation.getIndirectReference());
        pdfAnnotation.put(PdfName.PARENT, getIndirectReference());
    }

    public void setAction(PdfAction pdfAction) {
        put(PdfName.f19679A, pdfAction);
    }

    public void setAdditionalActions(PdfName pdfName, PdfAction pdfAction) {
        PdfDictionary pdfDictionary;
        PdfObject pdfObject = get(PdfName.f19680AA);
        if (pdfObject != null && pdfObject.isDictionary()) {
            pdfDictionary = (PdfDictionary) pdfObject;
        } else {
            pdfDictionary = new PdfDictionary();
        }
        pdfDictionary.put(pdfName, pdfAction);
        put(PdfName.f19680AA, pdfDictionary);
    }

    public boolean isUsed() {
        return this.used;
    }

    public void setUsed() {
        this.used = true;
    }

    public HashSet<PdfTemplate> getTemplates() {
        return this.templates;
    }

    public boolean isForm() {
        return this.form;
    }

    public boolean isAnnotation() {
        return this.annotation;
    }

    public void setPage(int i) {
        put(PdfName.f19752P, this.writer.getPageReference(i));
    }

    public void setPage() {
        put(PdfName.f19752P, this.writer.getCurrentPage());
    }

    public int getPlaceInPage() {
        return this.placeInPage;
    }

    public void setPlaceInPage(int i) {
        this.placeInPage = i;
    }

    public void setRotate(int i) {
        put(PdfName.ROTATE, new PdfNumber(i));
    }

    PdfDictionary getMK() {
        PdfDictionary pdfDictionary = (PdfDictionary) get(PdfName.f19738MK);
        if (pdfDictionary == null) {
            PdfDictionary pdfDictionary2 = new PdfDictionary();
            put(PdfName.f19738MK, pdfDictionary2);
            return pdfDictionary2;
        }
        return pdfDictionary;
    }

    public void setMKRotation(int i) {
        getMK().put(PdfName.f19760R, new PdfNumber(i));
    }

    public static PdfArray getMKColor(BaseColor baseColor) {
        PdfArray pdfArray = new PdfArray();
        switch (ExtendedColor.getType(baseColor)) {
            case 1:
                pdfArray.add(new PdfNumber(((GrayColor) baseColor).getGray()));
                break;
            case 2:
                CMYKColor cMYKColor = (CMYKColor) baseColor;
                pdfArray.add(new PdfNumber(cMYKColor.getCyan()));
                pdfArray.add(new PdfNumber(cMYKColor.getMagenta()));
                pdfArray.add(new PdfNumber(cMYKColor.getYellow()));
                pdfArray.add(new PdfNumber(cMYKColor.getBlack()));
                break;
            case 3:
            case 4:
            case 5:
                throw new RuntimeException(MessageLocalization.getComposedMessage("separations.patterns.and.shadings.are.not.allowed.in.mk.dictionary", new Object[0]));
            default:
                pdfArray.add(new PdfNumber(baseColor.getRed() / 255.0f));
                pdfArray.add(new PdfNumber(baseColor.getGreen() / 255.0f));
                pdfArray.add(new PdfNumber(baseColor.getBlue() / 255.0f));
                break;
        }
        return pdfArray;
    }

    public void setMKBorderColor(BaseColor baseColor) {
        if (baseColor == null) {
            getMK().remove(PdfName.f19685BC);
        } else {
            getMK().put(PdfName.f19685BC, getMKColor(baseColor));
        }
    }

    public void setMKBackgroundColor(BaseColor baseColor) {
        if (baseColor == null) {
            getMK().remove(PdfName.f19686BG);
        } else {
            getMK().put(PdfName.f19686BG, getMKColor(baseColor));
        }
    }

    public void setMKNormalCaption(String str) {
        getMK().put(PdfName.f19693CA, new PdfString(str, PdfObject.TEXT_UNICODE));
    }

    public void setMKRolloverCaption(String str) {
        getMK().put(PdfName.f19761RC, new PdfString(str, PdfObject.TEXT_UNICODE));
    }

    public void setMKAlternateCaption(String str) {
        getMK().put(PdfName.f19681AC, new PdfString(str, PdfObject.TEXT_UNICODE));
    }

    public void setMKNormalIcon(PdfTemplate pdfTemplate) {
        getMK().put(PdfName.f19729I, pdfTemplate.getIndirectReference());
    }

    public void setMKRolloverIcon(PdfTemplate pdfTemplate) {
        getMK().put(PdfName.f19763RI, pdfTemplate.getIndirectReference());
    }

    public void setMKAlternateIcon(PdfTemplate pdfTemplate) {
        getMK().put(PdfName.f19732IX, pdfTemplate.getIndirectReference());
    }

    public void setMKIconFit(PdfName pdfName, PdfName pdfName2, float f, float f2, boolean z) {
        PdfDictionary pdfDictionary = new PdfDictionary();
        if (!pdfName.equals(PdfName.f19679A)) {
            pdfDictionary.put(PdfName.f19771SW, pdfName);
        }
        if (!pdfName2.equals(PdfName.f19752P)) {
            pdfDictionary.put(PdfName.f19767S, pdfName2);
        }
        if (f != 0.5f || f2 != 0.5f) {
            PdfArray pdfArray = new PdfArray(new PdfNumber(f));
            pdfArray.add(new PdfNumber(f2));
            pdfDictionary.put(PdfName.f19679A, pdfArray);
        }
        if (z) {
            pdfDictionary.put(PdfName.f19713FB, PdfBoolean.PDFTRUE);
        }
        getMK().put(PdfName.f19731IF, pdfDictionary);
    }

    public void setMKTextPosition(int i) {
        getMK().put(PdfName.f19779TP, new PdfNumber(i));
    }

    public void setLayer(PdfOCG pdfOCG) {
        put(PdfName.f19747OC, pdfOCG.getRef());
    }

    public void setName(String str) {
        put(PdfName.f19745NM, new PdfString(str));
    }

    /* loaded from: classes.dex */
    public static class PdfImportedLink {
        PdfArray destination;
        float llx;
        float lly;
        float urx;
        float ury;
        HashMap<PdfName, PdfObject> parameters = new HashMap<>();
        int newPage = 0;

        /* JADX INFO: Access modifiers changed from: package-private */
        public PdfImportedLink(PdfDictionary pdfDictionary) {
            this.destination = null;
            this.parameters.putAll(pdfDictionary.hashMap);
            try {
                this.destination = (PdfArray) this.parameters.remove(PdfName.DEST);
                PdfArray pdfArray = this.destination;
                if (pdfArray != null) {
                    this.destination = new PdfArray(pdfArray);
                }
                PdfArray pdfArray2 = (PdfArray) this.parameters.remove(PdfName.RECT);
                this.llx = pdfArray2.getAsNumber(0).floatValue();
                this.lly = pdfArray2.getAsNumber(1).floatValue();
                this.urx = pdfArray2.getAsNumber(2).floatValue();
                this.ury = pdfArray2.getAsNumber(3).floatValue();
            } catch (ClassCastException unused) {
                throw new IllegalArgumentException(MessageLocalization.getComposedMessage("you.have.to.consolidate.the.named.destinations.of.your.reader", new Object[0]));
            }
        }

        public boolean isInternal() {
            return this.destination != null;
        }

        public int getDestinationPage() {
            if (isInternal()) {
                PRIndirectReference pRIndirectReference = (PRIndirectReference) this.destination.getAsIndirectObject(0);
                PdfReader reader = pRIndirectReference.getReader();
                for (int i = 1; i <= reader.getNumberOfPages(); i++) {
                    PRIndirectReference pageOrigRef = reader.getPageOrigRef(i);
                    if (pageOrigRef.getGeneration() == pRIndirectReference.getGeneration() && pageOrigRef.getNumber() == pRIndirectReference.getNumber()) {
                        return i;
                    }
                }
                throw new IllegalArgumentException(MessageLocalization.getComposedMessage("page.not.found", new Object[0]));
            }
            return 0;
        }

        public void setDestinationPage(int i) {
            if (!isInternal()) {
                throw new IllegalArgumentException(MessageLocalization.getComposedMessage("cannot.change.destination.of.external.link", new Object[0]));
            }
            this.newPage = i;
        }

        public void transformDestination(float f, float f2, float f3, float f4, float f5, float f6) {
            if (!isInternal()) {
                throw new IllegalArgumentException(MessageLocalization.getComposedMessage("cannot.change.destination.of.external.link", new Object[0]));
            }
            if (this.destination.getAsName(1).equals(PdfName.XYZ)) {
                float floatValue = this.destination.getAsNumber(2).floatValue();
                float floatValue2 = this.destination.getAsNumber(3).floatValue();
                this.destination.set(2, new PdfNumber((f * floatValue) + (f3 * floatValue2) + f5));
                this.destination.set(3, new PdfNumber((floatValue * f2) + (floatValue2 * f4) + f6));
            }
        }

        public void transformRect(float f, float f2, float f3, float f4, float f5, float f6) {
            float f7 = this.llx;
            float f8 = this.lly;
            this.llx = (f7 * f) + (f8 * f3) + f5;
            this.lly = (f7 * f2) + (f8 * f4) + f6;
            float f9 = this.urx;
            float f10 = this.ury;
            this.urx = (f * f9) + (f3 * f10) + f5;
            this.ury = (f9 * f2) + (f10 * f4) + f6;
        }

        public PdfAnnotation createAnnotation(PdfWriter pdfWriter) {
            PdfAnnotation pdfAnnotation = new PdfAnnotation(pdfWriter, new Rectangle(this.llx, this.lly, this.urx, this.ury));
            int i = this.newPage;
            if (i != 0) {
                this.destination.set(0, pdfWriter.getPageReference(i));
            }
            if (this.destination != null) {
                pdfAnnotation.put(PdfName.DEST, this.destination);
            }
            pdfAnnotation.hashMap.putAll(this.parameters);
            return pdfAnnotation;
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer("Imported link: location [");
            stringBuffer.append(this.llx);
            stringBuffer.append(TokenParser.f24154SP);
            stringBuffer.append(this.lly);
            stringBuffer.append(TokenParser.f24154SP);
            stringBuffer.append(this.urx);
            stringBuffer.append(TokenParser.f24154SP);
            stringBuffer.append(this.ury);
            stringBuffer.append("] destination ");
            stringBuffer.append(this.destination);
            stringBuffer.append(" parameters ");
            stringBuffer.append(this.parameters);
            return stringBuffer.toString();
        }
    }
}
