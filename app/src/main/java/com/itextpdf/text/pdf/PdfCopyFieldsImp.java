package com.itextpdf.text.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.exceptions.BadPasswordException;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfDocument;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.StringTokenizer;

/* loaded from: classes.dex */
class PdfCopyFieldsImp extends PdfWriter {
    private ArrayList<String> calculationOrder;
    private ArrayList<Object> calculationOrderRefs;
    boolean closing;
    HashMap<String, Object> fieldTree;
    ArrayList<AcroFields> fields;
    RandomAccessFileOrArray file;
    PdfDictionary form;
    private boolean hasSignature;

    /* renamed from: nd */
    Document f19674nd;
    ArrayList<PdfDictionary> pageDics;
    ArrayList<PdfIndirectReference> pageRefs;
    HashMap<PdfReader, IntHashtable> pages2intrefs;
    ArrayList<PdfReader> readers;
    HashMap<PdfReader, IntHashtable> readers2intrefs;
    PdfDictionary resources;
    private HashMap<PdfArray, ArrayList<Integer>> tabOrder;
    HashMap<PdfReader, IntHashtable> visited;
    private static final PdfName iTextTag = new PdfName("_iTextTag_");
    private static final Integer zero = 0;
    protected static final HashMap<PdfName, Integer> widgetKeys = new HashMap<>();
    protected static final HashMap<PdfName, Integer> fieldKeys = new HashMap<>();

    static {
        widgetKeys.put(PdfName.SUBTYPE, 1);
        widgetKeys.put(PdfName.CONTENTS, 1);
        widgetKeys.put(PdfName.RECT, 1);
        widgetKeys.put(PdfName.f19745NM, 1);
        widgetKeys.put(PdfName.f19737M, 1);
        widgetKeys.put(PdfName.f19712F, 1);
        widgetKeys.put(PdfName.f19689BS, 1);
        widgetKeys.put(PdfName.BORDER, 1);
        widgetKeys.put(PdfName.f19682AP, 1);
        widgetKeys.put(PdfName.f19683AS, 1);
        widgetKeys.put(PdfName.f19690C, 1);
        widgetKeys.put(PdfName.f19679A, 1);
        widgetKeys.put(PdfName.STRUCTPARENT, 1);
        widgetKeys.put(PdfName.f19747OC, 1);
        widgetKeys.put(PdfName.f19721H, 1);
        widgetKeys.put(PdfName.f19738MK, 1);
        widgetKeys.put(PdfName.f19700DA, 1);
        widgetKeys.put(PdfName.f19759Q, 1);
        widgetKeys.put(PdfName.f19752P, 1);
        fieldKeys.put(PdfName.f19680AA, 1);
        fieldKeys.put(PdfName.f19720FT, 1);
        fieldKeys.put(PdfName.f19781TU, 1);
        fieldKeys.put(PdfName.f19778TM, 1);
        fieldKeys.put(PdfName.f19715FF, 1);
        fieldKeys.put(PdfName.f19787V, 1);
        fieldKeys.put(PdfName.f19708DV, 1);
        fieldKeys.put(PdfName.f19707DS, 1);
        fieldKeys.put(PdfName.f19766RV, 1);
        fieldKeys.put(PdfName.OPT, 1);
        fieldKeys.put(PdfName.MAXLEN, 1);
        fieldKeys.put(PdfName.f19776TI, 1);
        fieldKeys.put(PdfName.f19729I, 1);
        fieldKeys.put(PdfName.LOCK, 1);
        fieldKeys.put(PdfName.f19770SV, 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PdfCopyFieldsImp(OutputStream outputStream) throws DocumentException {
        this(outputStream, (char) 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PdfCopyFieldsImp(OutputStream outputStream, char c) throws DocumentException {
        super(new PdfDocument(), outputStream);
        this.readers = new ArrayList<>();
        this.readers2intrefs = new HashMap<>();
        this.pages2intrefs = new HashMap<>();
        this.visited = new HashMap<>();
        this.fields = new ArrayList<>();
        this.fieldTree = new HashMap<>();
        this.pageRefs = new ArrayList<>();
        this.pageDics = new ArrayList<>();
        this.resources = new PdfDictionary();
        this.closing = false;
        this.calculationOrder = new ArrayList<>();
        this.pdf.addWriter(this);
        if (c != 0) {
            super.setPdfVersion(c);
        }
        this.f19674nd = new Document();
        this.f19674nd.addDocListener(this.pdf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addDocument(PdfReader pdfReader, List<Integer> list) throws DocumentException, IOException {
        if (!this.readers2intrefs.containsKey(pdfReader) && pdfReader.isTampered()) {
            throw new DocumentException(MessageLocalization.getComposedMessage("the.document.was.reused", new Object[0]));
        }
        PdfReader pdfReader2 = new PdfReader(pdfReader);
        pdfReader2.selectPages(list);
        if (pdfReader2.getNumberOfPages() == 0) {
            return;
        }
        pdfReader2.setTampered(false);
        addDocument(pdfReader2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addDocument(PdfReader pdfReader) throws DocumentException, IOException {
        if (!pdfReader.isOpenedWithFullPermissions()) {
            throw new BadPasswordException(MessageLocalization.getComposedMessage("pdfreader.not.opened.with.owner.password", new Object[0]));
        }
        openDoc();
        if (this.readers2intrefs.containsKey(pdfReader)) {
            pdfReader = new PdfReader(pdfReader);
        } else if (pdfReader.isTampered()) {
            throw new DocumentException(MessageLocalization.getComposedMessage("the.document.was.reused", new Object[0]));
        } else {
            pdfReader.consolidateNamedDestinations();
            pdfReader.setTampered(true);
        }
        pdfReader.shuffleSubsetNames();
        this.readers2intrefs.put(pdfReader, new IntHashtable());
        this.readers.add(pdfReader);
        int numberOfPages = pdfReader.getNumberOfPages();
        IntHashtable intHashtable = new IntHashtable();
        for (int i = 1; i <= numberOfPages; i++) {
            intHashtable.put(pdfReader.getPageOrigRef(i).getNumber(), 1);
            pdfReader.releasePage(i);
        }
        this.pages2intrefs.put(pdfReader, intHashtable);
        this.visited.put(pdfReader, new IntHashtable());
        this.fields.add(pdfReader.getAcroFields());
        updateCalculationOrder(pdfReader);
    }

    private static String getCOName(PdfReader pdfReader, PRIndirectReference pRIndirectReference) {
        PdfString asString;
        String str = "";
        while (pRIndirectReference != null) {
            PdfObject pdfObject = PdfReader.getPdfObject(pRIndirectReference);
            if (pdfObject == null || pdfObject.type() != 6) {
                break;
            }
            PdfDictionary pdfDictionary = (PdfDictionary) pdfObject;
            if (pdfDictionary.getAsString(PdfName.f19772T) != null) {
                str = asString.toUnicodeString() + "." + str;
            }
            pRIndirectReference = (PRIndirectReference) pdfDictionary.get(PdfName.PARENT);
        }
        return str.endsWith(".") ? str.substring(0, str.length() - 1) : str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateCalculationOrder(PdfReader pdfReader) {
        PdfArray asArray;
        PdfDictionary asDict = pdfReader.getCatalog().getAsDict(PdfName.ACROFORM);
        if (asDict == null || (asArray = asDict.getAsArray(PdfName.f19697CO)) == null || asArray.size() == 0) {
            return;
        }
        AcroFields acroFields = pdfReader.getAcroFields();
        for (int i = 0; i < asArray.size(); i++) {
            PdfObject pdfObject = asArray.getPdfObject(i);
            if (pdfObject != null && pdfObject.isIndirect()) {
                String cOName = getCOName(pdfReader, (PRIndirectReference) pdfObject);
                if (acroFields.getFieldItem(cOName) != null) {
                    String concat = ".".concat(String.valueOf(cOName));
                    if (!this.calculationOrder.contains(concat)) {
                        this.calculationOrder.add(concat);
                    }
                }
            }
        }
    }

    void propagate(PdfObject pdfObject, PdfIndirectReference pdfIndirectReference, boolean z) throws IOException {
        if (pdfObject == null || (pdfObject instanceof PdfIndirectReference)) {
            return;
        }
        int type = pdfObject.type();
        if (type != 10) {
            switch (type) {
                case 5:
                    ListIterator<PdfObject> listIterator = ((PdfArray) pdfObject).listIterator();
                    while (listIterator.hasNext()) {
                        PdfObject next = listIterator.next();
                        if (next != null && next.isIndirect()) {
                            PRIndirectReference pRIndirectReference = (PRIndirectReference) next;
                            if (!isVisited(pRIndirectReference) && !isPage(pRIndirectReference)) {
                                propagate(PdfReader.getPdfObjectRelease(pRIndirectReference), getNewReference(pRIndirectReference), z);
                            }
                        } else {
                            propagate(next, null, z);
                        }
                    }
                    return;
                case 6:
                case 7:
                    PdfDictionary pdfDictionary = (PdfDictionary) pdfObject;
                    for (PdfName pdfName : pdfDictionary.getKeys()) {
                        if (!z || (!pdfName.equals(PdfName.PARENT) && !pdfName.equals(PdfName.KIDS))) {
                            PdfObject pdfObject2 = pdfDictionary.get(pdfName);
                            if (pdfObject2 != null && pdfObject2.isIndirect()) {
                                PRIndirectReference pRIndirectReference2 = (PRIndirectReference) pdfObject2;
                                if (!setVisited(pRIndirectReference2) && !isPage(pRIndirectReference2)) {
                                    propagate(PdfReader.getPdfObjectRelease(pRIndirectReference2), getNewReference(pRIndirectReference2), z);
                                }
                            } else {
                                propagate(pdfObject2, null, z);
                            }
                        }
                    }
                    return;
                default:
                    return;
            }
        }
        throw new RuntimeException(MessageLocalization.getComposedMessage("reference.pointing.to.reference", new Object[0]));
    }

    private void adjustTabOrder(PdfArray pdfArray, PdfIndirectReference pdfIndirectReference, PdfNumber pdfNumber) {
        int intValue = pdfNumber.intValue();
        ArrayList<Integer> arrayList = this.tabOrder.get(pdfArray);
        if (arrayList == null) {
            ArrayList<Integer> arrayList2 = new ArrayList<>();
            int size = pdfArray.size() - 1;
            for (int i = 0; i < size; i++) {
                arrayList2.add(zero);
            }
            arrayList2.add(Integer.valueOf(intValue));
            this.tabOrder.put(pdfArray, arrayList2);
            pdfArray.add(pdfIndirectReference);
            return;
        }
        int size2 = arrayList.size() - 1;
        int i2 = size2;
        while (true) {
            if (i2 < 0) {
                break;
            } else if (arrayList.get(i2).intValue() <= intValue) {
                int i3 = i2 + 1;
                arrayList.add(i3, Integer.valueOf(intValue));
                pdfArray.add(i3, pdfIndirectReference);
                size2 = -2;
                break;
            } else {
                i2--;
            }
        }
        if (size2 != -2) {
            arrayList.add(0, Integer.valueOf(intValue));
            pdfArray.add(0, pdfIndirectReference);
        }
    }

    protected PdfArray branchForm(HashMap<String, Object> hashMap, PdfIndirectReference pdfIndirectReference, String str) throws IOException {
        PdfArray pdfArray = new PdfArray();
        for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            PdfIndirectReference pdfIndirectReference2 = getPdfIndirectReference();
            PdfDictionary pdfDictionary = new PdfDictionary();
            if (pdfIndirectReference != null) {
                pdfDictionary.put(PdfName.PARENT, pdfIndirectReference);
            }
            pdfDictionary.put(PdfName.f19772T, new PdfString(key, PdfObject.TEXT_UNICODE));
            String str2 = str + "." + key;
            int indexOf = this.calculationOrder.indexOf(str2);
            if (indexOf >= 0) {
                this.calculationOrderRefs.set(indexOf, pdfIndirectReference2);
            }
            if (value instanceof HashMap) {
                pdfDictionary.put(PdfName.KIDS, branchForm((HashMap) value, pdfIndirectReference2, str2));
                pdfArray.add(pdfIndirectReference2);
                addToBody(pdfDictionary, pdfIndirectReference2);
            } else {
                ArrayList arrayList = (ArrayList) value;
                pdfDictionary.mergeDifferent((PdfDictionary) arrayList.get(0));
                int i = 1;
                if (arrayList.size() == 3) {
                    pdfDictionary.mergeDifferent((PdfDictionary) arrayList.get(2));
                    PdfDictionary pdfDictionary2 = this.pageDics.get(((Integer) arrayList.get(1)).intValue() - 1);
                    PdfArray asArray = pdfDictionary2.getAsArray(PdfName.ANNOTS);
                    if (asArray == null) {
                        asArray = new PdfArray();
                        pdfDictionary2.put(PdfName.ANNOTS, asArray);
                    }
                    pdfDictionary.remove(iTextTag);
                    adjustTabOrder(asArray, pdfIndirectReference2, (PdfNumber) pdfDictionary.get(iTextTag));
                } else {
                    PdfArray pdfArray2 = new PdfArray();
                    int i2 = 1;
                    while (i2 < arrayList.size()) {
                        PdfDictionary pdfDictionary3 = this.pageDics.get(((Integer) arrayList.get(i2)).intValue() - i);
                        PdfArray asArray2 = pdfDictionary3.getAsArray(PdfName.ANNOTS);
                        if (asArray2 == null) {
                            asArray2 = new PdfArray();
                            pdfDictionary3.put(PdfName.ANNOTS, asArray2);
                        }
                        PdfDictionary pdfDictionary4 = new PdfDictionary();
                        pdfDictionary4.merge((PdfDictionary) arrayList.get(i2 + 1));
                        pdfDictionary4.put(PdfName.PARENT, pdfIndirectReference2);
                        pdfDictionary4.remove(iTextTag);
                        PdfIndirectReference indirectReference = addToBody(pdfDictionary4).getIndirectReference();
                        adjustTabOrder(asArray2, indirectReference, (PdfNumber) pdfDictionary4.get(iTextTag));
                        pdfArray2.add(indirectReference);
                        propagate(pdfDictionary4, null, false);
                        i2 += 2;
                        i = 1;
                    }
                    pdfDictionary.put(PdfName.KIDS, pdfArray2);
                }
                pdfArray.add(pdfIndirectReference2);
                addToBody(pdfDictionary, pdfIndirectReference2);
                propagate(pdfDictionary, null, false);
            }
        }
        return pdfArray;
    }

    protected void createAcroForms() throws IOException {
        if (this.fieldTree.isEmpty()) {
            return;
        }
        this.form = new PdfDictionary();
        this.form.put(PdfName.f19706DR, this.resources);
        propagate(this.resources, null, false);
        this.form.put(PdfName.f19700DA, new PdfString("/Helv 0 Tf 0 g "));
        this.tabOrder = new HashMap<>();
        this.calculationOrderRefs = new ArrayList<>(this.calculationOrder);
        this.form.put(PdfName.FIELDS, branchForm(this.fieldTree, null, ""));
        if (this.hasSignature) {
            this.form.put(PdfName.SIGFLAGS, new PdfNumber(3));
        }
        PdfArray pdfArray = new PdfArray();
        for (int i = 0; i < this.calculationOrderRefs.size(); i++) {
            Object obj = this.calculationOrderRefs.get(i);
            if (obj instanceof PdfIndirectReference) {
                pdfArray.add((PdfIndirectReference) obj);
            }
        }
        if (pdfArray.size() > 0) {
            this.form.put(PdfName.f19697CO, pdfArray);
        }
    }

    @Override // com.itextpdf.text.pdf.PdfWriter, com.itextpdf.text.DocWriter, com.itextpdf.text.DocListener
    public void close() {
        if (this.closing) {
            super.close();
            return;
        }
        this.closing = true;
        try {
            closeIt();
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    protected void closeIt() throws IOException {
        for (int i = 0; i < this.readers.size(); i++) {
            this.readers.get(i).removeFields();
        }
        int i2 = 0;
        while (true) {
            if (i2 >= this.readers.size()) {
                break;
            }
            PdfReader pdfReader = this.readers.get(i2);
            for (int i3 = 1; i3 <= pdfReader.getNumberOfPages(); i3++) {
                this.pageRefs.add(getNewReference(pdfReader.getPageOrigRef(i3)));
                this.pageDics.add(pdfReader.getPageN(i3));
            }
            i2++;
        }
        mergeFields();
        createAcroForms();
        for (int i4 = 0; i4 < this.readers.size(); i4++) {
            PdfReader pdfReader2 = this.readers.get(i4);
            for (int i5 = 1; i5 <= pdfReader2.getNumberOfPages(); i5++) {
                PdfDictionary pageN = pdfReader2.getPageN(i5);
                PdfIndirectReference newReference = getNewReference(pdfReader2.getPageOrigRef(i5));
                pageN.put(PdfName.PARENT, this.root.addPageRef(newReference));
                propagate(pageN, newReference, false);
            }
        }
        for (Map.Entry<PdfReader, IntHashtable> entry : this.readers2intrefs.entrySet()) {
            PdfReader key = entry.getKey();
            try {
                this.file = key.getSafeFile();
                this.file.reOpen();
                IntHashtable value = entry.getValue();
                int[] orderedKeys = value.toOrderedKeys();
                for (int i6 = 0; i6 < orderedKeys.length; i6++) {
                    addToBody(PdfReader.getPdfObjectRelease(new PRIndirectReference(key, orderedKeys[i6])), value.get(orderedKeys[i6]));
                }
            } finally {
                try {
                    this.file.close();
                    key.close();
                } catch (Exception unused) {
                }
            }
        }
        this.pdf.close();
    }

    void addPageOffsetToField(Map<String, AcroFields.Item> map, int i) {
        if (i == 0) {
            return;
        }
        for (AcroFields.Item item : map.values()) {
            for (int i2 = 0; i2 < item.size(); i2++) {
                item.forcePage(i2, item.getPage(i2).intValue() + i);
            }
        }
    }

    void createWidgets(ArrayList<Object> arrayList, AcroFields.Item item) {
        for (int i = 0; i < item.size(); i++) {
            arrayList.add(item.getPage(i));
            PdfDictionary merged = item.getMerged(i);
            PdfObject pdfObject = merged.get(PdfName.f19706DR);
            if (pdfObject != null) {
                PdfFormField.mergeResources(this.resources, (PdfDictionary) PdfReader.getPdfObject(pdfObject));
            }
            PdfDictionary pdfDictionary = new PdfDictionary();
            for (PdfName pdfName : merged.getKeys()) {
                if (widgetKeys.containsKey(pdfName)) {
                    pdfDictionary.put(pdfName, merged.get(pdfName));
                }
            }
            pdfDictionary.put(iTextTag, new PdfNumber(item.getTabOrder(i).intValue() + 1));
            arrayList.add(pdfDictionary);
        }
    }

    void mergeField(String str, AcroFields.Item item) {
        HashMap<String, Object> hashMap = this.fieldTree;
        StringTokenizer stringTokenizer = new StringTokenizer(str, ".");
        if (!stringTokenizer.hasMoreTokens()) {
            return;
        }
        while (true) {
            String nextToken = stringTokenizer.nextToken();
            Object obj = hashMap.get(nextToken);
            if (!stringTokenizer.hasMoreTokens()) {
                if (obj instanceof HashMap) {
                    return;
                }
                int i = 0;
                PdfDictionary merged = item.getMerged(0);
                if (obj == null) {
                    PdfDictionary pdfDictionary = new PdfDictionary();
                    if (PdfName.SIG.equals(merged.get(PdfName.f19720FT))) {
                        this.hasSignature = true;
                    }
                    for (PdfName pdfName : merged.getKeys()) {
                        if (fieldKeys.containsKey(pdfName)) {
                            pdfDictionary.put(pdfName, merged.get(pdfName));
                        }
                    }
                    ArrayList<Object> arrayList = new ArrayList<>();
                    arrayList.add(pdfDictionary);
                    createWidgets(arrayList, item);
                    hashMap.put(nextToken, arrayList);
                    return;
                }
                ArrayList<Object> arrayList2 = (ArrayList) obj;
                PdfDictionary pdfDictionary2 = (PdfDictionary) arrayList2.get(0);
                PdfName pdfName2 = (PdfName) pdfDictionary2.get(PdfName.f19720FT);
                PdfName pdfName3 = (PdfName) merged.get(PdfName.f19720FT);
                if (pdfName2 == null || !pdfName2.equals(pdfName3)) {
                    return;
                }
                PdfObject pdfObject = pdfDictionary2.get(PdfName.f19715FF);
                int intValue = (pdfObject == null || !pdfObject.isNumber()) ? 0 : ((PdfNumber) pdfObject).intValue();
                PdfObject pdfObject2 = merged.get(PdfName.f19715FF);
                if (pdfObject2 != null && pdfObject2.isNumber()) {
                    i = ((PdfNumber) pdfObject2).intValue();
                }
                if (pdfName2.equals(PdfName.BTN)) {
                    int i2 = intValue ^ i;
                    if ((i2 & 65536) != 0) {
                        return;
                    }
                    if ((intValue & 65536) == 0 && (32768 & i2) != 0) {
                        return;
                    }
                } else if (pdfName2.equals(PdfName.f19695CH) && ((intValue ^ i) & 131072) != 0) {
                    return;
                }
                createWidgets(arrayList2, item);
                return;
            } else if (obj == null) {
                HashMap<String, Object> hashMap2 = new HashMap<>();
                hashMap.put(nextToken, hashMap2);
                hashMap = hashMap2;
            } else if (!(obj instanceof HashMap)) {
                return;
            } else {
                hashMap = (HashMap) obj;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void mergeWithMaster(Map<String, AcroFields.Item> map) {
        for (Map.Entry<String, AcroFields.Item> entry : map.entrySet()) {
            mergeField(entry.getKey(), entry.getValue());
        }
    }

    void mergeFields() {
        int i = 0;
        for (int i2 = 0; i2 < this.fields.size(); i2++) {
            Map<String, AcroFields.Item> fields = this.fields.get(i2).getFields();
            addPageOffsetToField(fields, i);
            mergeWithMaster(fields);
            i += this.readers.get(i2).getNumberOfPages();
        }
    }

    @Override // com.itextpdf.text.pdf.PdfWriter
    public PdfIndirectReference getPageReference(int i) {
        return this.pageRefs.get(i - 1);
    }

    @Override // com.itextpdf.text.pdf.PdfWriter
    protected PdfDictionary getCatalog(PdfIndirectReference pdfIndirectReference) {
        try {
            PdfDocument.PdfCatalog catalog = this.pdf.getCatalog(pdfIndirectReference);
            if (this.form != null) {
                catalog.put(PdfName.ACROFORM, addToBody(this.form).getIndirectReference());
            }
            return catalog;
        } catch (IOException e) {
            throw new ExceptionConverter(e);
        }
    }

    protected PdfIndirectReference getNewReference(PRIndirectReference pRIndirectReference) {
        return new PdfIndirectReference(0, getNewObjectNumber(pRIndirectReference.getReader(), pRIndirectReference.getNumber(), 0));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.itextpdf.text.pdf.PdfWriter
    public int getNewObjectNumber(PdfReader pdfReader, int i, int i2) {
        IntHashtable intHashtable = this.readers2intrefs.get(pdfReader);
        int i3 = intHashtable.get(i);
        if (i3 == 0) {
            int indirectReferenceNumber = getIndirectReferenceNumber();
            intHashtable.put(i, indirectReferenceNumber);
            return indirectReferenceNumber;
        }
        return i3;
    }

    protected boolean setVisited(PRIndirectReference pRIndirectReference) {
        IntHashtable intHashtable = this.visited.get(pRIndirectReference.getReader());
        return (intHashtable == null || intHashtable.put(pRIndirectReference.getNumber(), 1) == 0) ? false : true;
    }

    protected boolean isVisited(PRIndirectReference pRIndirectReference) {
        IntHashtable intHashtable = this.visited.get(pRIndirectReference.getReader());
        if (intHashtable != null) {
            return intHashtable.containsKey(pRIndirectReference.getNumber());
        }
        return false;
    }

    protected boolean isVisited(PdfReader pdfReader, int i, int i2) {
        return this.readers2intrefs.get(pdfReader).containsKey(i);
    }

    protected boolean isPage(PRIndirectReference pRIndirectReference) {
        IntHashtable intHashtable = this.pages2intrefs.get(pRIndirectReference.getReader());
        if (intHashtable != null) {
            return intHashtable.containsKey(pRIndirectReference.getNumber());
        }
        return false;
    }

    @Override // com.itextpdf.text.pdf.PdfWriter
    RandomAccessFileOrArray getReaderFile(PdfReader pdfReader) {
        return this.file;
    }

    public void openDoc() {
        if (this.f19674nd.isOpen()) {
            return;
        }
        this.f19674nd.open();
    }
}
