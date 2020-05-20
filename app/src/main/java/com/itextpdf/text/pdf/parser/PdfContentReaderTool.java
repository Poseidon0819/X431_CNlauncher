package com.itextpdf.text.pdf.parser;

import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStream;
import com.itextpdf.text.pdf.RandomAccessFileOrArray;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import org.codehaus.jackson.org.objectweb.asm.signature.SignatureVisitor;

/* loaded from: classes.dex */
public class PdfContentReaderTool {
    public static String getDictionaryDetail(PdfDictionary pdfDictionary) {
        return getDictionaryDetail(pdfDictionary, 0);
    }

    public static String getDictionaryDetail(PdfDictionary pdfDictionary, int i) {
        int i2;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('(');
        ArrayList<PdfName> arrayList = new ArrayList();
        for (PdfName pdfName : pdfDictionary.getKeys()) {
            PdfObject directObject = pdfDictionary.getDirectObject(pdfName);
            if (directObject.isDictionary()) {
                arrayList.add(pdfName);
            }
            stringBuffer.append(pdfName);
            stringBuffer.append(SignatureVisitor.INSTANCEOF);
            stringBuffer.append(directObject);
            stringBuffer.append(", ");
        }
        stringBuffer.setLength(stringBuffer.length() - 2);
        stringBuffer.append(')');
        for (PdfName pdfName2 : arrayList) {
            stringBuffer.append('\n');
            int i3 = 0;
            while (true) {
                i2 = i + 1;
                if (i3 < i2) {
                    stringBuffer.append('\t');
                    i3++;
                }
            }
            stringBuffer.append("Subdictionary ");
            stringBuffer.append(pdfName2);
            stringBuffer.append(" = ");
            stringBuffer.append(getDictionaryDetail(pdfDictionary.getAsDict(pdfName2), i2));
        }
        return stringBuffer.toString();
    }

    public static String getXObjectDetail(PdfDictionary pdfDictionary) throws IOException {
        StringBuilder sb = new StringBuilder();
        PdfDictionary asDict = pdfDictionary.getAsDict(PdfName.XOBJECT);
        if (asDict == null) {
            return "No XObjects";
        }
        for (PdfName pdfName : asDict.getKeys()) {
            PdfStream asStream = asDict.getAsStream(pdfName);
            sb.append("------ " + pdfName + " - subtype = " + asStream.get(PdfName.SUBTYPE) + " = " + asStream.getAsNumber(PdfName.LENGTH) + " bytes ------\n");
            if (!asStream.get(PdfName.SUBTYPE).equals(PdfName.IMAGE)) {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(ContentByteUtils.getContentBytesFromContentObject(asStream));
                while (true) {
                    int read = byteArrayInputStream.read();
                    if (read == -1) {
                        break;
                    }
                    sb.append((char) read);
                }
                sb.append("------ " + pdfName + " - subtype = " + asStream.get(PdfName.SUBTYPE) + "End of Content------\n");
            }
        }
        return sb.toString();
    }

    public static void listContentStreamForPage(PdfReader pdfReader, int i, PrintWriter printWriter) throws IOException {
        printWriter.println("==============Page " + i + "====================");
        printWriter.println("- - - - - Dictionary - - - - - -");
        PdfDictionary pageN = pdfReader.getPageN(i);
        printWriter.println(getDictionaryDetail(pageN));
        printWriter.println("- - - - - XObject Summary - - - - - -");
        printWriter.println(getXObjectDetail(pageN.getAsDict(PdfName.RESOURCES)));
        printWriter.println("- - - - - Content Stream - - - - - -");
        RandomAccessFileOrArray safeFile = pdfReader.getSafeFile();
        byte[] pageContent = pdfReader.getPageContent(i, safeFile);
        safeFile.close();
        printWriter.flush();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(pageContent);
        while (true) {
            int read = byteArrayInputStream.read();
            if (read == -1) {
                break;
            }
            printWriter.print((char) read);
        }
        printWriter.flush();
        printWriter.println("- - - - - Text Extraction - - - - - -");
        String textFromPage = PdfTextExtractor.getTextFromPage(pdfReader, i, new LocationTextExtractionStrategy());
        if (textFromPage.length() != 0) {
            printWriter.println(textFromPage);
        } else {
            printWriter.println("No text found on page ".concat(String.valueOf(i)));
        }
        printWriter.println();
    }

    public static void listContentStream(File file, PrintWriter printWriter) throws IOException {
        PdfReader pdfReader = new PdfReader(file.getCanonicalPath());
        int numberOfPages = pdfReader.getNumberOfPages();
        for (int i = 1; i <= numberOfPages; i++) {
            listContentStreamForPage(pdfReader, i, printWriter);
        }
    }

    public static void listContentStream(File file, int i, PrintWriter printWriter) throws IOException {
        listContentStreamForPage(new PdfReader(file.getCanonicalPath()), i, printWriter);
    }

    public static void main(String[] strArr) {
        try {
            if (strArr.length > 0 && strArr.length <= 3) {
                PrintWriter printWriter = new PrintWriter(System.out);
                if (strArr.length >= 2 && strArr[1].compareToIgnoreCase("stdout") != 0) {
                    PrintStream printStream = System.out;
                    printStream.println("Writing PDF content to " + strArr[1]);
                    printWriter = new PrintWriter(new FileOutputStream(new File(strArr[1])));
                }
                int parseInt = strArr.length >= 3 ? Integer.parseInt(strArr[2]) : -1;
                if (parseInt == -1) {
                    listContentStream(new File(strArr[0]), printWriter);
                } else {
                    listContentStream(new File(strArr[0]), parseInt, printWriter);
                }
                printWriter.flush();
                if (strArr.length >= 2) {
                    printWriter.close();
                    PrintStream printStream2 = System.out;
                    printStream2.println("Finished writing content to " + strArr[1]);
                    return;
                }
                return;
            }
            System.out.println("Usage:  PdfContentReaderTool <pdf file> [<output file>|stdout] [<page num>]");
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }
}
