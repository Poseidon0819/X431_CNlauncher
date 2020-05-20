package com.itextpdf.text.pdf;

import com.itextpdf.text.DocWriter;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/* loaded from: classes.dex */
public class FdfWriter {
    private static final byte[] HEADER_FDF = DocWriter.getISOBytes("%FDF-1.4\n%âãÏÓ\n");
    HashMap<String, Object> fields = new HashMap<>();
    private String file;

    public void writeTo(OutputStream outputStream) throws IOException {
        new Wrt(outputStream, this).writeTo();
    }

    boolean setField(String str, PdfObject pdfObject) {
        HashMap<String, Object> hashMap = this.fields;
        StringTokenizer stringTokenizer = new StringTokenizer(str, ".");
        if (!stringTokenizer.hasMoreTokens()) {
            return false;
        }
        while (true) {
            String nextToken = stringTokenizer.nextToken();
            Object obj = hashMap.get(nextToken);
            if (!stringTokenizer.hasMoreTokens()) {
                if (obj instanceof HashMap) {
                    return false;
                }
                hashMap.put(nextToken, pdfObject);
                return true;
            } else if (obj == null) {
                HashMap<String, Object> hashMap2 = new HashMap<>();
                hashMap.put(nextToken, hashMap2);
                hashMap = hashMap2;
            } else if (!(obj instanceof HashMap)) {
                return false;
            } else {
                hashMap = (HashMap) obj;
            }
        }
    }

    void iterateFields(HashMap<String, Object> hashMap, HashMap<String, Object> hashMap2, String str) {
        for (Map.Entry<String, Object> entry : hashMap2.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof HashMap) {
                iterateFields(hashMap, (HashMap) value, str + "." + key);
            } else {
                hashMap.put((str + "." + key).substring(1), value);
            }
        }
    }

    public boolean removeField(String str) {
        HashMap<String, Object> hashMap = this.fields;
        StringTokenizer stringTokenizer = new StringTokenizer(str, ".");
        if (!stringTokenizer.hasMoreTokens()) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        while (true) {
            String nextToken = stringTokenizer.nextToken();
            Object obj = hashMap.get(nextToken);
            if (obj == null) {
                return false;
            }
            arrayList.add(hashMap);
            arrayList.add(nextToken);
            if (stringTokenizer.hasMoreTokens()) {
                if (!(obj instanceof HashMap)) {
                    return false;
                }
                hashMap = (HashMap) obj;
            } else if (obj instanceof HashMap) {
                return false;
            } else {
                for (int size = arrayList.size() - 2; size >= 0; size -= 2) {
                    HashMap hashMap2 = (HashMap) arrayList.get(size);
                    hashMap2.remove((String) arrayList.get(size + 1));
                    if (!hashMap2.isEmpty()) {
                        return true;
                    }
                }
                return true;
            }
        }
    }

    public HashMap<String, Object> getFields() {
        HashMap<String, Object> hashMap = new HashMap<>();
        iterateFields(hashMap, this.fields, "");
        return hashMap;
    }

    public String getField(String str) {
        HashMap<String, Object> hashMap = this.fields;
        StringTokenizer stringTokenizer = new StringTokenizer(str, ".");
        if (!stringTokenizer.hasMoreTokens()) {
            return null;
        }
        while (true) {
            Object obj = hashMap.get(stringTokenizer.nextToken());
            if (obj == null) {
                return null;
            }
            if (stringTokenizer.hasMoreTokens()) {
                if (!(obj instanceof HashMap)) {
                    return null;
                }
                hashMap = (HashMap) obj;
            } else if (obj instanceof HashMap) {
                return null;
            } else {
                if (((PdfObject) obj).isString()) {
                    return ((PdfString) obj).toUnicodeString();
                }
                return PdfName.decodeName(obj.toString());
            }
        }
    }

    public boolean setFieldAsName(String str, String str2) {
        return setField(str, new PdfName(str2));
    }

    public boolean setFieldAsString(String str, String str2) {
        return setField(str, new PdfString(str2, PdfObject.TEXT_UNICODE));
    }

    public boolean setFieldAsAction(String str, PdfAction pdfAction) {
        return setField(str, pdfAction);
    }

    public void setFields(FdfReader fdfReader) {
        for (Map.Entry<String, PdfDictionary> entry : fdfReader.getFields().entrySet()) {
            String key = entry.getKey();
            PdfDictionary value = entry.getValue();
            PdfObject pdfObject = value.get(PdfName.f19787V);
            if (pdfObject != null) {
                setField(key, pdfObject);
            }
            PdfObject pdfObject2 = value.get(PdfName.f19679A);
            if (pdfObject2 != null) {
                setField(key, pdfObject2);
            }
        }
    }

    public void setFields(PdfReader pdfReader) {
        setFields(pdfReader.getAcroFields());
    }

    public void setFields(AcroFields acroFields) {
        PdfObject pdfObjectRelease;
        for (Map.Entry<String, AcroFields.Item> entry : acroFields.getFields().entrySet()) {
            String key = entry.getKey();
            PdfDictionary merged = entry.getValue().getMerged(0);
            PdfObject pdfObjectRelease2 = PdfReader.getPdfObjectRelease(merged.get(PdfName.f19787V));
            if (pdfObjectRelease2 != null && (pdfObjectRelease = PdfReader.getPdfObjectRelease(merged.get(PdfName.f19720FT))) != null && !PdfName.SIG.equals(pdfObjectRelease)) {
                setField(key, pdfObjectRelease2);
            }
        }
    }

    public String getFile() {
        return this.file;
    }

    public void setFile(String str) {
        this.file = str;
    }

    /* loaded from: classes.dex */
    static class Wrt extends PdfWriter {
        private FdfWriter fdf;

        Wrt(OutputStream outputStream, FdfWriter fdfWriter) throws IOException {
            super(new PdfDocument(), outputStream);
            this.fdf = fdfWriter;
            this.f19587os.write(FdfWriter.HEADER_FDF);
            this.body = new PdfWriter.PdfBody(this);
        }

        void writeTo() throws IOException {
            PdfDictionary pdfDictionary = new PdfDictionary();
            pdfDictionary.put(PdfName.FIELDS, calculate(this.fdf.fields));
            if (this.fdf.file != null) {
                pdfDictionary.put(PdfName.f19712F, new PdfString(this.fdf.file, PdfObject.TEXT_UNICODE));
            }
            PdfDictionary pdfDictionary2 = new PdfDictionary();
            pdfDictionary2.put(PdfName.FDF, pdfDictionary);
            PdfIndirectReference indirectReference = addToBody(pdfDictionary2).getIndirectReference();
            this.f19587os.write(getISOBytes("trailer\n"));
            PdfDictionary pdfDictionary3 = new PdfDictionary();
            pdfDictionary3.put(PdfName.ROOT, indirectReference);
            pdfDictionary3.toPdf(null, this.f19587os);
            this.f19587os.write(getISOBytes("\n%%EOF\n"));
            this.f19587os.close();
        }

        PdfArray calculate(HashMap<String, Object> hashMap) throws IOException {
            PdfArray pdfArray = new PdfArray();
            for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
                Object value = entry.getValue();
                PdfDictionary pdfDictionary = new PdfDictionary();
                pdfDictionary.put(PdfName.f19772T, new PdfString(entry.getKey(), PdfObject.TEXT_UNICODE));
                if (value instanceof HashMap) {
                    pdfDictionary.put(PdfName.KIDS, calculate((HashMap) value));
                } else if (value instanceof PdfAction) {
                    pdfDictionary.put(PdfName.f19679A, (PdfAction) value);
                } else {
                    pdfDictionary.put(PdfName.f19787V, (PdfObject) value);
                }
                pdfArray.add(pdfDictionary);
            }
            return pdfArray;
        }
    }
}
