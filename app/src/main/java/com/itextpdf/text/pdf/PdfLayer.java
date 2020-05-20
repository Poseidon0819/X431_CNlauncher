package com.itextpdf.text.pdf;

import com.itextpdf.text.error_messages.MessageLocalization;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class PdfLayer extends PdfDictionary implements PdfOCG {
    protected ArrayList<PdfLayer> children;

    /* renamed from: on */
    private boolean f19678on;
    private boolean onPanel;
    protected PdfLayer parent;
    protected PdfIndirectReference ref;
    protected String title;

    @Override // com.itextpdf.text.pdf.PdfOCG
    public PdfObject getPdfObject() {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PdfLayer(String str) {
        this.f19678on = true;
        this.onPanel = true;
        this.title = str;
    }

    public static PdfLayer createTitle(String str, PdfWriter pdfWriter) {
        if (str == null) {
            throw new NullPointerException(MessageLocalization.getComposedMessage("title.cannot.be.null", new Object[0]));
        }
        PdfLayer pdfLayer = new PdfLayer(str);
        pdfWriter.registerLayer(pdfLayer);
        return pdfLayer;
    }

    public PdfLayer(String str, PdfWriter pdfWriter) throws IOException {
        super(PdfName.OCG);
        this.f19678on = true;
        this.onPanel = true;
        setName(str);
        if (pdfWriter instanceof PdfStamperImp) {
            this.ref = pdfWriter.addToBody(this).getIndirectReference();
        } else {
            this.ref = pdfWriter.getPdfIndirectReference();
        }
        pdfWriter.registerLayer(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getTitle() {
        return this.title;
    }

    public void addChild(PdfLayer pdfLayer) {
        if (pdfLayer.parent != null) {
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("the.layer.1.already.has.a.parent", pdfLayer.getAsString(PdfName.NAME).toUnicodeString()));
        }
        pdfLayer.parent = this;
        if (this.children == null) {
            this.children = new ArrayList<>();
        }
        this.children.add(pdfLayer);
    }

    public PdfLayer getParent() {
        return this.parent;
    }

    public ArrayList<PdfLayer> getChildren() {
        return this.children;
    }

    @Override // com.itextpdf.text.pdf.PdfOCG
    public PdfIndirectReference getRef() {
        return this.ref;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setRef(PdfIndirectReference pdfIndirectReference) {
        this.ref = pdfIndirectReference;
    }

    public void setName(String str) {
        put(PdfName.NAME, new PdfString(str, PdfObject.TEXT_UNICODE));
    }

    public boolean isOn() {
        return this.f19678on;
    }

    public void setOn(boolean z) {
        this.f19678on = z;
    }

    private PdfDictionary getUsage() {
        PdfDictionary asDict = getAsDict(PdfName.USAGE);
        if (asDict == null) {
            PdfDictionary pdfDictionary = new PdfDictionary();
            put(PdfName.USAGE, pdfDictionary);
            return pdfDictionary;
        }
        return asDict;
    }

    public void setCreatorInfo(String str, String str2) {
        PdfDictionary usage = getUsage();
        PdfDictionary pdfDictionary = new PdfDictionary();
        pdfDictionary.put(PdfName.CREATOR, new PdfString(str, PdfObject.TEXT_UNICODE));
        pdfDictionary.put(PdfName.SUBTYPE, new PdfName(str2));
        usage.put(PdfName.CREATORINFO, pdfDictionary);
    }

    public void setLanguage(String str, boolean z) {
        PdfDictionary usage = getUsage();
        PdfDictionary pdfDictionary = new PdfDictionary();
        pdfDictionary.put(PdfName.LANG, new PdfString(str, PdfObject.TEXT_UNICODE));
        if (z) {
            pdfDictionary.put(PdfName.PREFERRED, PdfName.f19749ON);
        }
        usage.put(PdfName.LANGUAGE, pdfDictionary);
    }

    public void setExport(boolean z) {
        PdfDictionary usage = getUsage();
        PdfDictionary pdfDictionary = new PdfDictionary();
        pdfDictionary.put(PdfName.EXPORTSTATE, z ? PdfName.f19749ON : PdfName.OFF);
        usage.put(PdfName.EXPORT, pdfDictionary);
    }

    public void setZoom(float f, float f2) {
        if (f > ColumnText.GLOBAL_SPACE_CHAR_RATIO || f2 >= ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
            PdfDictionary usage = getUsage();
            PdfDictionary pdfDictionary = new PdfDictionary();
            if (f > ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
                pdfDictionary.put(PdfName.MIN_LOWER_CASE, new PdfNumber(f));
            }
            if (f2 >= ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
                pdfDictionary.put(PdfName.MAX_LOWER_CASE, new PdfNumber(f2));
            }
            usage.put(PdfName.ZOOM, pdfDictionary);
        }
    }

    public void setPrint(String str, boolean z) {
        PdfDictionary usage = getUsage();
        PdfDictionary pdfDictionary = new PdfDictionary();
        pdfDictionary.put(PdfName.SUBTYPE, new PdfName(str));
        pdfDictionary.put(PdfName.PRINTSTATE, z ? PdfName.f19749ON : PdfName.OFF);
        usage.put(PdfName.PRINT, pdfDictionary);
    }

    public void setView(boolean z) {
        PdfDictionary usage = getUsage();
        PdfDictionary pdfDictionary = new PdfDictionary();
        pdfDictionary.put(PdfName.VIEWSTATE, z ? PdfName.f19749ON : PdfName.OFF);
        usage.put(PdfName.VIEW, pdfDictionary);
    }

    public void setPageElement(String str) {
        PdfDictionary usage = getUsage();
        PdfDictionary pdfDictionary = new PdfDictionary();
        pdfDictionary.put(PdfName.SUBTYPE, new PdfName(str));
        usage.put(PdfName.PAGEELEMENT, pdfDictionary);
    }

    public void setUser(String str, String... strArr) {
        PdfDictionary usage = getUsage();
        PdfDictionary pdfDictionary = new PdfDictionary();
        pdfDictionary.put(PdfName.TYPE, new PdfName(str));
        PdfArray pdfArray = new PdfArray();
        for (String str2 : strArr) {
            pdfArray.add(new PdfString(str2, PdfObject.TEXT_UNICODE));
        }
        usage.put(PdfName.NAME, pdfArray);
        usage.put(PdfName.USER, pdfDictionary);
    }

    public boolean isOnPanel() {
        return this.onPanel;
    }

    public void setOnPanel(boolean z) {
        this.onPanel = z;
    }
}
