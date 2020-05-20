package com.itextpdf.text.pdf;

import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.collection.PdfTargetDictionary;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class PdfAction extends PdfDictionary {
    public static final int FIRSTPAGE = 1;
    public static final int LASTPAGE = 4;
    public static final int NEXTPAGE = 3;
    public static final int PREVPAGE = 2;
    public static final int PRINTDIALOG = 5;
    public static final int RESET_EXCLUDE = 1;
    public static final int SUBMIT_CANONICAL_FORMAT = 512;
    public static final int SUBMIT_COORDINATES = 16;
    public static final int SUBMIT_EMBED_FORM = 8196;
    public static final int SUBMIT_EXCLUDE = 1;
    public static final int SUBMIT_EXCL_F_KEY = 2048;
    public static final int SUBMIT_EXCL_NON_USER_ANNOTS = 1024;
    public static final int SUBMIT_HTML_FORMAT = 4;
    public static final int SUBMIT_HTML_GET = 8;
    public static final int SUBMIT_INCLUDE_ANNOTATIONS = 128;
    public static final int SUBMIT_INCLUDE_APPEND_SAVES = 64;
    public static final int SUBMIT_INCLUDE_NO_VALUE_FIELDS = 2;
    public static final int SUBMIT_PDF = 256;
    public static final int SUBMIT_XFDF = 32;

    public PdfAction() {
    }

    public PdfAction(URL url) {
        this(url.toExternalForm());
    }

    public PdfAction(URL url, boolean z) {
        this(url.toExternalForm(), z);
    }

    public PdfAction(String str) {
        this(str, false);
    }

    public PdfAction(String str, boolean z) {
        put(PdfName.f19767S, PdfName.URI);
        put(PdfName.URI, new PdfString(str));
        if (z) {
            put(PdfName.ISMAP, PdfBoolean.PDFTRUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PdfAction(PdfIndirectReference pdfIndirectReference) {
        put(PdfName.f19767S, PdfName.GOTO);
        put(PdfName.f19699D, pdfIndirectReference);
    }

    public PdfAction(String str, String str2) {
        put(PdfName.f19767S, PdfName.GOTOR);
        put(PdfName.f19712F, new PdfString(str));
        put(PdfName.f19699D, new PdfString(str2));
    }

    public PdfAction(String str, int i) {
        put(PdfName.f19767S, PdfName.GOTOR);
        put(PdfName.f19712F, new PdfString(str));
        PdfName pdfName = PdfName.f19699D;
        StringBuilder sb = new StringBuilder("[");
        sb.append(i - 1);
        sb.append(" /FitH 10000]");
        put(pdfName, new PdfLiteral(sb.toString()));
    }

    public PdfAction(int i) {
        put(PdfName.f19767S, PdfName.NAMED);
        switch (i) {
            case 1:
                put(PdfName.f19739N, PdfName.FIRSTPAGE);
                return;
            case 2:
                put(PdfName.f19739N, PdfName.PREVPAGE);
                return;
            case 3:
                put(PdfName.f19739N, PdfName.NEXTPAGE);
                return;
            case 4:
                put(PdfName.f19739N, PdfName.LASTPAGE);
                return;
            case 5:
                put(PdfName.f19767S, PdfName.JAVASCRIPT);
                put(PdfName.f19733JS, new PdfString("this.print(true);\r"));
                return;
            default:
                throw new RuntimeException(MessageLocalization.getComposedMessage("invalid.named.action", new Object[0]));
        }
    }

    public PdfAction(String str, String str2, String str3, String str4) {
        put(PdfName.f19767S, PdfName.LAUNCH);
        if (str2 == null && str3 == null && str4 == null) {
            put(PdfName.f19712F, new PdfString(str));
            return;
        }
        PdfDictionary pdfDictionary = new PdfDictionary();
        pdfDictionary.put(PdfName.f19712F, new PdfString(str));
        if (str2 != null) {
            pdfDictionary.put(PdfName.f19752P, new PdfString(str2));
        }
        if (str3 != null) {
            pdfDictionary.put(PdfName.f19746O, new PdfString(str3));
        }
        if (str4 != null) {
            pdfDictionary.put(PdfName.f19699D, new PdfString(str4));
        }
        put(PdfName.WIN, pdfDictionary);
    }

    public static PdfAction createLaunch(String str, String str2, String str3, String str4) {
        return new PdfAction(str, str2, str3, str4);
    }

    public static PdfAction rendition(String str, PdfFileSpecification pdfFileSpecification, String str2, PdfIndirectReference pdfIndirectReference) throws IOException {
        PdfAction pdfAction = new PdfAction();
        pdfAction.put(PdfName.f19767S, PdfName.RENDITION);
        pdfAction.put(PdfName.f19760R, new PdfRendition(str, pdfFileSpecification, str2));
        pdfAction.put(new PdfName("OP"), new PdfNumber(0));
        pdfAction.put(new PdfName("AN"), pdfIndirectReference);
        return pdfAction;
    }

    public static PdfAction javaScript(String str, PdfWriter pdfWriter, boolean z) {
        PdfAction pdfAction = new PdfAction();
        pdfAction.put(PdfName.f19767S, PdfName.JAVASCRIPT);
        if (z && str.length() < 50) {
            pdfAction.put(PdfName.f19733JS, new PdfString(str, PdfObject.TEXT_UNICODE));
        } else if (!z && str.length() < 100) {
            pdfAction.put(PdfName.f19733JS, new PdfString(str));
        } else {
            try {
                PdfStream pdfStream = new PdfStream(PdfEncodings.convertToBytes(str, z ? PdfObject.TEXT_UNICODE : PdfObject.TEXT_PDFDOCENCODING));
                pdfStream.flateCompress(pdfWriter.getCompressionLevel());
                pdfAction.put(PdfName.f19733JS, pdfWriter.addToBody(pdfStream).getIndirectReference());
            } catch (Exception unused) {
                pdfAction.put(PdfName.f19733JS, new PdfString(str));
            }
        }
        return pdfAction;
    }

    public static PdfAction javaScript(String str, PdfWriter pdfWriter) {
        return javaScript(str, pdfWriter, false);
    }

    static PdfAction createHide(PdfObject pdfObject, boolean z) {
        PdfAction pdfAction = new PdfAction();
        pdfAction.put(PdfName.f19767S, PdfName.HIDE);
        pdfAction.put(PdfName.f19772T, pdfObject);
        if (!z) {
            pdfAction.put(PdfName.f19721H, PdfBoolean.PDFFALSE);
        }
        return pdfAction;
    }

    public static PdfAction createHide(PdfAnnotation pdfAnnotation, boolean z) {
        return createHide(pdfAnnotation.getIndirectReference(), z);
    }

    public static PdfAction createHide(String str, boolean z) {
        return createHide(new PdfString(str), z);
    }

    static PdfArray buildArray(Object[] objArr) {
        PdfArray pdfArray = new PdfArray();
        for (Object obj : objArr) {
            if (obj instanceof String) {
                pdfArray.add(new PdfString((String) obj));
            } else if (obj instanceof PdfAnnotation) {
                pdfArray.add(((PdfAnnotation) obj).getIndirectReference());
            } else {
                throw new RuntimeException(MessageLocalization.getComposedMessage("the.array.must.contain.string.or.pdfannotation", new Object[0]));
            }
        }
        return pdfArray;
    }

    public static PdfAction createHide(Object[] objArr, boolean z) {
        return createHide(buildArray(objArr), z);
    }

    public static PdfAction createSubmitForm(String str, Object[] objArr, int i) {
        PdfAction pdfAction = new PdfAction();
        pdfAction.put(PdfName.f19767S, PdfName.SUBMITFORM);
        PdfDictionary pdfDictionary = new PdfDictionary();
        pdfDictionary.put(PdfName.f19712F, new PdfString(str));
        pdfDictionary.put(PdfName.f19719FS, PdfName.URL);
        pdfAction.put(PdfName.f19712F, pdfDictionary);
        if (objArr != null) {
            pdfAction.put(PdfName.FIELDS, buildArray(objArr));
        }
        pdfAction.put(PdfName.FLAGS, new PdfNumber(i));
        return pdfAction;
    }

    public static PdfAction createResetForm(Object[] objArr, int i) {
        PdfAction pdfAction = new PdfAction();
        pdfAction.put(PdfName.f19767S, PdfName.RESETFORM);
        if (objArr != null) {
            pdfAction.put(PdfName.FIELDS, buildArray(objArr));
        }
        pdfAction.put(PdfName.FLAGS, new PdfNumber(i));
        return pdfAction;
    }

    public static PdfAction createImportData(String str) {
        PdfAction pdfAction = new PdfAction();
        pdfAction.put(PdfName.f19767S, PdfName.IMPORTDATA);
        pdfAction.put(PdfName.f19712F, new PdfString(str));
        return pdfAction;
    }

    public void next(PdfAction pdfAction) {
        PdfObject pdfObject = get(PdfName.NEXT);
        if (pdfObject == null) {
            put(PdfName.NEXT, pdfAction);
        } else if (pdfObject.isDictionary()) {
            PdfArray pdfArray = new PdfArray(pdfObject);
            pdfArray.add(pdfAction);
            put(PdfName.NEXT, pdfArray);
        } else {
            ((PdfArray) pdfObject).add(pdfAction);
        }
    }

    public static PdfAction gotoLocalPage(int i, PdfDestination pdfDestination, PdfWriter pdfWriter) {
        pdfDestination.addPage(pdfWriter.getPageReference(i));
        PdfAction pdfAction = new PdfAction();
        pdfAction.put(PdfName.f19767S, PdfName.GOTO);
        pdfAction.put(PdfName.f19699D, pdfDestination);
        return pdfAction;
    }

    public static PdfAction gotoLocalPage(String str, boolean z) {
        PdfAction pdfAction = new PdfAction();
        pdfAction.put(PdfName.f19767S, PdfName.GOTO);
        if (z) {
            pdfAction.put(PdfName.f19699D, new PdfName(str));
        } else {
            pdfAction.put(PdfName.f19699D, new PdfString(str, null));
        }
        return pdfAction;
    }

    public static PdfAction gotoRemotePage(String str, String str2, boolean z, boolean z2) {
        PdfAction pdfAction = new PdfAction();
        pdfAction.put(PdfName.f19712F, new PdfString(str));
        pdfAction.put(PdfName.f19767S, PdfName.GOTOR);
        if (z) {
            pdfAction.put(PdfName.f19699D, new PdfName(str2));
        } else {
            pdfAction.put(PdfName.f19699D, new PdfString(str2, null));
        }
        if (z2) {
            pdfAction.put(PdfName.NEWWINDOW, PdfBoolean.PDFTRUE);
        }
        return pdfAction;
    }

    public static PdfAction gotoEmbedded(String str, PdfTargetDictionary pdfTargetDictionary, String str2, boolean z, boolean z2) {
        if (z) {
            return gotoEmbedded(str, pdfTargetDictionary, new PdfName(str2), z2);
        }
        return gotoEmbedded(str, pdfTargetDictionary, new PdfString(str2, null), z2);
    }

    public static PdfAction gotoEmbedded(String str, PdfTargetDictionary pdfTargetDictionary, PdfObject pdfObject, boolean z) {
        PdfAction pdfAction = new PdfAction();
        pdfAction.put(PdfName.f19767S, PdfName.GOTOE);
        pdfAction.put(PdfName.f19772T, pdfTargetDictionary);
        pdfAction.put(PdfName.f19699D, pdfObject);
        pdfAction.put(PdfName.NEWWINDOW, new PdfBoolean(z));
        if (str != null) {
            pdfAction.put(PdfName.f19712F, new PdfString(str));
        }
        return pdfAction;
    }

    public static PdfAction setOCGstate(ArrayList<Object> arrayList, boolean z) {
        PdfName pdfName;
        PdfAction pdfAction = new PdfAction();
        pdfAction.put(PdfName.f19767S, PdfName.SETOCGSTATE);
        PdfArray pdfArray = new PdfArray();
        for (int i = 0; i < arrayList.size(); i++) {
            Object obj = arrayList.get(i);
            if (obj != null) {
                if (obj instanceof PdfIndirectReference) {
                    pdfArray.add((PdfIndirectReference) obj);
                } else if (obj instanceof PdfLayer) {
                    pdfArray.add(((PdfLayer) obj).getRef());
                } else if (obj instanceof PdfName) {
                    pdfArray.add((PdfName) obj);
                } else if (obj instanceof String) {
                    String str = (String) obj;
                    if (str.equalsIgnoreCase("on")) {
                        pdfName = PdfName.f19749ON;
                    } else if (str.equalsIgnoreCase("off")) {
                        pdfName = PdfName.OFF;
                    } else if (str.equalsIgnoreCase("toggle")) {
                        pdfName = PdfName.TOGGLE;
                    } else {
                        throw new IllegalArgumentException(MessageLocalization.getComposedMessage("a.string.1.was.passed.in.state.only.on.off.and.toggle.are.allowed", str));
                    }
                    pdfArray.add(pdfName);
                } else {
                    throw new IllegalArgumentException(MessageLocalization.getComposedMessage("invalid.type.was.passed.in.state.1", obj.getClass().getName()));
                }
            }
        }
        pdfAction.put(PdfName.STATE, pdfArray);
        if (!z) {
            pdfAction.put(PdfName.PRESERVERB, PdfBoolean.PDFFALSE);
        }
        return pdfAction;
    }
}
