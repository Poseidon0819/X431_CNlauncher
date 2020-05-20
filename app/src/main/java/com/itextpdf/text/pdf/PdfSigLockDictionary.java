package com.itextpdf.text.pdf;

/* loaded from: classes.dex */
public class PdfSigLockDictionary extends PdfDictionary {

    /* loaded from: classes.dex */
    public enum LockAction {
        ALL(PdfName.ALL),
        INCLUDE(PdfName.INCLUDE),
        EXCLUDE(PdfName.EXCLUDE);
        
        private PdfName name;

        LockAction(PdfName pdfName) {
            this.name = pdfName;
        }

        public final PdfName getValue() {
            return this.name;
        }
    }

    /* loaded from: classes.dex */
    public enum LockPermissions {
        NO_CHANGES_ALLOWED(1),
        FORM_FILLING(2),
        FORM_FILLING_AND_ANNOTATION(3);
        
        private PdfNumber number;

        LockPermissions(int i) {
            this.number = new PdfNumber(i);
        }

        public final PdfNumber getValue() {
            return this.number;
        }
    }

    public PdfSigLockDictionary() {
        super(PdfName.SIGFIELDLOCK);
        put(PdfName.ACTION, LockAction.ALL.getValue());
    }

    public PdfSigLockDictionary(LockPermissions lockPermissions) {
        this();
        put(PdfName.f19752P, lockPermissions.getValue());
    }

    public PdfSigLockDictionary(LockAction lockAction, String... strArr) {
        this(lockAction, null, strArr);
    }

    public PdfSigLockDictionary(LockAction lockAction, LockPermissions lockPermissions, String... strArr) {
        super(PdfName.SIGFIELDLOCK);
        put(PdfName.ACTION, lockAction.getValue());
        if (lockPermissions != null) {
            put(PdfName.f19752P, lockPermissions.getValue());
        }
        PdfArray pdfArray = new PdfArray();
        for (String str : strArr) {
            pdfArray.add(new PdfString(str));
        }
        put(PdfName.FIELDS, pdfArray);
    }
}
