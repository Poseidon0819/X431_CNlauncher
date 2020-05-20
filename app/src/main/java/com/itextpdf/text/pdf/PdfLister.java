package com.itextpdf.text.pdf;

import java.io.IOException;
import java.io.PrintStream;
import java.util.ListIterator;
import org.apache.http.conn.ssl.TokenParser;

/* loaded from: classes.dex */
public class PdfLister {
    PrintStream out;

    public PdfLister(PrintStream printStream) {
        this.out = printStream;
    }

    public void listAnyObject(PdfObject pdfObject) {
        int type = pdfObject.type();
        if (type != 3) {
            switch (type) {
                case 5:
                    listArray((PdfArray) pdfObject);
                    return;
                case 6:
                    listDict((PdfDictionary) pdfObject);
                    return;
                default:
                    this.out.println(pdfObject.toString());
                    return;
            }
        }
        PrintStream printStream = this.out;
        printStream.println("(" + pdfObject.toString() + ")");
    }

    public void listDict(PdfDictionary pdfDictionary) {
        this.out.println("<<");
        for (PdfName pdfName : pdfDictionary.getKeys()) {
            PdfObject pdfObject = pdfDictionary.get(pdfName);
            this.out.print(pdfName.toString());
            this.out.print(TokenParser.f24154SP);
            listAnyObject(pdfObject);
        }
        this.out.println(">>");
    }

    public void listArray(PdfArray pdfArray) {
        this.out.println('[');
        ListIterator<PdfObject> listIterator = pdfArray.listIterator();
        while (listIterator.hasNext()) {
            listAnyObject(listIterator.next());
        }
        this.out.println(']');
    }

    public void listStream(PRStream pRStream, PdfReaderInstance pdfReaderInstance) {
        try {
            listDict(pRStream);
            this.out.println("startstream");
            byte[] streamBytes = PdfReader.getStreamBytes(pRStream);
            int length = streamBytes.length - 1;
            for (int i = 0; i < length; i++) {
                if (streamBytes[i] == 13 && streamBytes[i + 1] != 10) {
                    streamBytes[i] = 10;
                }
            }
            this.out.println(new String(streamBytes));
            this.out.println("endstream");
        } catch (IOException e) {
            System.err.println("I/O exception: ".concat(String.valueOf(e)));
        }
    }

    public void listPage(PdfImportedPage pdfImportedPage) {
        int pageNumber = pdfImportedPage.getPageNumber();
        PdfReaderInstance pdfReaderInstance = pdfImportedPage.getPdfReaderInstance();
        PdfDictionary pageN = pdfReaderInstance.getReader().getPageN(pageNumber);
        listDict(pageN);
        PdfObject pdfObject = PdfReader.getPdfObject(pageN.get(PdfName.CONTENTS));
        if (pdfObject == null) {
            return;
        }
        int i = pdfObject.type;
        if (i != 5) {
            if (i != 7) {
                return;
            }
            listStream((PRStream) pdfObject, pdfReaderInstance);
            return;
        }
        ListIterator<PdfObject> listIterator = ((PdfArray) pdfObject).listIterator();
        while (listIterator.hasNext()) {
            listStream((PRStream) PdfReader.getPdfObject(listIterator.next()), pdfReaderInstance);
            this.out.println("-----------");
        }
    }
}
