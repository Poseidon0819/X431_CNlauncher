package com.itextpdf.text.pdf.parser;

import com.itextpdf.text.pdf.PRTokeniser;
import com.itextpdf.text.pdf.PdfArray;
import com.itextpdf.text.pdf.PdfContentParser;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfNumber;
import com.itextpdf.text.pdf.PdfObject;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class InlineImageUtils {
    private static final Map<PdfName, PdfName> inlineImageColorSpaceAbbreviationMap;
    private static final Map<PdfName, PdfName> inlineImageEntryAbbreviationMap;
    private static final Map<PdfName, PdfName> inlineImageFilterAbbreviationMap;

    private InlineImageUtils() {
    }

    /* loaded from: classes.dex */
    public static class InlineImageParseException extends IOException {
        private static final long serialVersionUID = 233760879000268548L;

        public InlineImageParseException(String str) {
            super(str);
        }
    }

    static {
        HashMap hashMap = new HashMap();
        inlineImageEntryAbbreviationMap = hashMap;
        PdfName pdfName = PdfName.BITSPERCOMPONENT;
        hashMap.put(pdfName, pdfName);
        Map<PdfName, PdfName> map = inlineImageEntryAbbreviationMap;
        PdfName pdfName2 = PdfName.COLORSPACE;
        map.put(pdfName2, pdfName2);
        Map<PdfName, PdfName> map2 = inlineImageEntryAbbreviationMap;
        PdfName pdfName3 = PdfName.DECODE;
        map2.put(pdfName3, pdfName3);
        Map<PdfName, PdfName> map3 = inlineImageEntryAbbreviationMap;
        PdfName pdfName4 = PdfName.DECODEPARMS;
        map3.put(pdfName4, pdfName4);
        Map<PdfName, PdfName> map4 = inlineImageEntryAbbreviationMap;
        PdfName pdfName5 = PdfName.FILTER;
        map4.put(pdfName5, pdfName5);
        Map<PdfName, PdfName> map5 = inlineImageEntryAbbreviationMap;
        PdfName pdfName6 = PdfName.HEIGHT;
        map5.put(pdfName6, pdfName6);
        Map<PdfName, PdfName> map6 = inlineImageEntryAbbreviationMap;
        PdfName pdfName7 = PdfName.IMAGEMASK;
        map6.put(pdfName7, pdfName7);
        Map<PdfName, PdfName> map7 = inlineImageEntryAbbreviationMap;
        PdfName pdfName8 = PdfName.INTENT;
        map7.put(pdfName8, pdfName8);
        Map<PdfName, PdfName> map8 = inlineImageEntryAbbreviationMap;
        PdfName pdfName9 = PdfName.INTERPOLATE;
        map8.put(pdfName9, pdfName9);
        Map<PdfName, PdfName> map9 = inlineImageEntryAbbreviationMap;
        PdfName pdfName10 = PdfName.WIDTH;
        map9.put(pdfName10, pdfName10);
        inlineImageEntryAbbreviationMap.put(new PdfName("BPC"), PdfName.BITSPERCOMPONENT);
        inlineImageEntryAbbreviationMap.put(new PdfName("CS"), PdfName.COLORSPACE);
        inlineImageEntryAbbreviationMap.put(new PdfName("D"), PdfName.DECODE);
        inlineImageEntryAbbreviationMap.put(new PdfName("DP"), PdfName.DECODEPARMS);
        inlineImageEntryAbbreviationMap.put(new PdfName("F"), PdfName.FILTER);
        inlineImageEntryAbbreviationMap.put(new PdfName("H"), PdfName.HEIGHT);
        inlineImageEntryAbbreviationMap.put(new PdfName("IM"), PdfName.IMAGEMASK);
        inlineImageEntryAbbreviationMap.put(new PdfName("I"), PdfName.INTERPOLATE);
        inlineImageEntryAbbreviationMap.put(new PdfName("W"), PdfName.WIDTH);
        HashMap hashMap2 = new HashMap();
        inlineImageColorSpaceAbbreviationMap = hashMap2;
        hashMap2.put(new PdfName("G"), PdfName.DEVICEGRAY);
        inlineImageColorSpaceAbbreviationMap.put(new PdfName("RGB"), PdfName.DEVICERGB);
        inlineImageColorSpaceAbbreviationMap.put(new PdfName("CMYK"), PdfName.DEVICECMYK);
        inlineImageColorSpaceAbbreviationMap.put(new PdfName("I"), PdfName.INDEXED);
        HashMap hashMap3 = new HashMap();
        inlineImageFilterAbbreviationMap = hashMap3;
        hashMap3.put(new PdfName("AHx"), PdfName.ASCIIHEXDECODE);
        inlineImageFilterAbbreviationMap.put(new PdfName("A85"), PdfName.ASCII85DECODE);
        inlineImageFilterAbbreviationMap.put(new PdfName("LZW"), PdfName.LZWDECODE);
        inlineImageFilterAbbreviationMap.put(new PdfName("Fl"), PdfName.FLATEDECODE);
        inlineImageFilterAbbreviationMap.put(new PdfName("RL"), PdfName.RUNLENGTHDECODE);
        inlineImageFilterAbbreviationMap.put(new PdfName("CCF"), PdfName.CCITTFAXDECODE);
        inlineImageFilterAbbreviationMap.put(new PdfName("DCT"), PdfName.DCTDECODE);
    }

    public static InlineImageInfo parseInlineImage(PdfContentParser pdfContentParser, PdfDictionary pdfDictionary) throws IOException {
        PdfDictionary parseInlineImageDictionary = parseInlineImageDictionary(pdfContentParser);
        return new InlineImageInfo(parseInlineImageSamples(parseInlineImageDictionary, pdfDictionary, pdfContentParser), parseInlineImageDictionary);
    }

    private static PdfDictionary parseInlineImageDictionary(PdfContentParser pdfContentParser) throws IOException {
        PdfDictionary pdfDictionary = new PdfDictionary();
        while (true) {
            PdfObject readPRObject = pdfContentParser.readPRObject();
            if (readPRObject == null || "ID".equals(readPRObject.toString())) {
                break;
            }
            PdfObject readPRObject2 = pdfContentParser.readPRObject();
            PdfName pdfName = inlineImageEntryAbbreviationMap.get(readPRObject);
            if (pdfName == null) {
                pdfName = (PdfName) readPRObject;
            }
            pdfDictionary.put(pdfName, getAlternateValue(pdfName, readPRObject2));
        }
        int read = pdfContentParser.getTokeniser().read();
        if (PRTokeniser.isWhitespace(read)) {
            return pdfDictionary;
        }
        throw new IOException("Unexpected character " + read + " found after ID in inline image");
    }

    private static PdfObject getAlternateValue(PdfName pdfName, PdfObject pdfObject) {
        PdfName pdfName2;
        if (pdfName == PdfName.FILTER) {
            if (pdfObject instanceof PdfName) {
                PdfName pdfName3 = inlineImageFilterAbbreviationMap.get(pdfObject);
                if (pdfName3 != null) {
                    return pdfName3;
                }
            } else if (pdfObject instanceof PdfArray) {
                PdfArray pdfArray = (PdfArray) pdfObject;
                PdfArray pdfArray2 = new PdfArray();
                int size = pdfArray.size();
                for (int i = 0; i < size; i++) {
                    pdfArray2.add(getAlternateValue(pdfName, pdfArray.getPdfObject(i)));
                }
                return pdfArray2;
            }
        } else if (pdfName == PdfName.COLORSPACE && (pdfName2 = inlineImageColorSpaceAbbreviationMap.get(pdfObject)) != null) {
            return pdfName2;
        }
        return pdfObject;
    }

    private static int getComponentsPerPixel(PdfName pdfName, PdfDictionary pdfDictionary) {
        PdfArray asArray;
        if (pdfName == null || pdfName.equals(PdfName.DEVICEGRAY)) {
            return 1;
        }
        if (pdfName.equals(PdfName.DEVICERGB)) {
            return 3;
        }
        if (pdfName.equals(PdfName.DEVICECMYK)) {
            return 4;
        }
        if (pdfDictionary == null || (asArray = pdfDictionary.getAsArray(pdfName)) == null || !PdfName.INDEXED.equals(asArray.getAsName(0))) {
            throw new IllegalArgumentException("Unexpected color space ".concat(String.valueOf(pdfName)));
        }
        return 1;
    }

    private static int computeBytesPerRow(PdfDictionary pdfDictionary, PdfDictionary pdfDictionary2) {
        PdfNumber asNumber = pdfDictionary.getAsNumber(PdfName.WIDTH);
        PdfNumber asNumber2 = pdfDictionary.getAsNumber(PdfName.BITSPERCOMPONENT);
        return (((asNumber.intValue() * (asNumber2 != null ? asNumber2.intValue() : 1)) * getComponentsPerPixel(pdfDictionary.getAsName(PdfName.COLORSPACE), pdfDictionary2)) + 7) / 8;
    }

    private static byte[] parseUnfilteredSamples(PdfDictionary pdfDictionary, PdfDictionary pdfDictionary2, PdfContentParser pdfContentParser) throws IOException {
        if (pdfDictionary.contains(PdfName.FILTER)) {
            throw new IllegalArgumentException("Dictionary contains filters");
        }
        int computeBytesPerRow = computeBytesPerRow(pdfDictionary, pdfDictionary2) * pdfDictionary.getAsNumber(PdfName.HEIGHT).intValue();
        byte[] bArr = new byte[computeBytesPerRow];
        PRTokeniser tokeniser = pdfContentParser.getTokeniser();
        int read = tokeniser.read();
        int i = 0;
        if (!PRTokeniser.isWhitespace(read) || read == 0) {
            bArr[0] = (byte) read;
            i = 1;
        }
        while (i < computeBytesPerRow) {
            int read2 = tokeniser.read();
            if (read2 == -1) {
                throw new InlineImageParseException("End of content stream reached before end of image data");
            }
            bArr[i] = (byte) read2;
            i++;
        }
        if (pdfContentParser.readPRObject().toString().equals("EI")) {
            return bArr;
        }
        throw new InlineImageParseException("EI not found after end of image data");
    }

    private static byte[] parseInlineImageSamples(PdfDictionary pdfDictionary, PdfDictionary pdfDictionary2, PdfContentParser pdfContentParser) throws IOException {
        if (!pdfDictionary.contains(PdfName.FILTER)) {
            return parseUnfilteredSamples(pdfDictionary, pdfDictionary2, pdfContentParser);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        PRTokeniser tokeniser = pdfContentParser.getTokeniser();
        int i = 0;
        while (true) {
            int read = tokeniser.read();
            if (read != -1) {
                if (i == 0 && PRTokeniser.isWhitespace(read)) {
                    i++;
                    byteArrayOutputStream2.write(read);
                } else if (i == 1 && read == 69) {
                    i++;
                    byteArrayOutputStream2.write(read);
                } else if (i == 1 && PRTokeniser.isWhitespace(read)) {
                    byteArrayOutputStream.write(byteArrayOutputStream2.toByteArray());
                    byteArrayOutputStream2.reset();
                    byteArrayOutputStream2.write(read);
                } else if (i == 2 && read == 73) {
                    i++;
                    byteArrayOutputStream2.write(read);
                } else if (i == 3 && PRTokeniser.isWhitespace(read)) {
                    return byteArrayOutputStream.toByteArray();
                } else {
                    byteArrayOutputStream.write(byteArrayOutputStream2.toByteArray());
                    byteArrayOutputStream2.reset();
                    byteArrayOutputStream.write(read);
                    i = 0;
                }
            } else {
                throw new InlineImageParseException("Could not find image data or EI");
            }
        }
    }
}
