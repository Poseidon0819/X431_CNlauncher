package com.itextpdf.text.pdf;

import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.PRTokeniser;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class PdfContentParser {
    public static final int COMMAND_TYPE = 200;
    private PRTokeniser tokeniser;

    public PdfContentParser(PRTokeniser pRTokeniser) {
        this.tokeniser = pRTokeniser;
    }

    public ArrayList<PdfObject> parse(ArrayList<PdfObject> arrayList) throws IOException {
        PdfObject readPRObject;
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        } else {
            arrayList.clear();
        }
        do {
            readPRObject = readPRObject();
            if (readPRObject == null) {
                break;
            }
            arrayList.add(readPRObject);
        } while (readPRObject.type() != 200);
        return arrayList;
    }

    public PRTokeniser getTokeniser() {
        return this.tokeniser;
    }

    public void setTokeniser(PRTokeniser pRTokeniser) {
        this.tokeniser = pRTokeniser;
    }

    public PdfDictionary readDictionary() throws IOException {
        PdfDictionary pdfDictionary = new PdfDictionary();
        while (nextValidToken()) {
            if (this.tokeniser.getTokenType() == PRTokeniser.TokenType.END_DIC) {
                return pdfDictionary;
            }
            if (this.tokeniser.getTokenType() != PRTokeniser.TokenType.OTHER || !"def".equals(this.tokeniser.getStringValue())) {
                if (this.tokeniser.getTokenType() != PRTokeniser.TokenType.NAME) {
                    throw new IOException(MessageLocalization.getComposedMessage("dictionary.key.is.not.a.name", new Object[0]));
                }
                PdfName pdfName = new PdfName(this.tokeniser.getStringValue(), false);
                PdfObject readPRObject = readPRObject();
                int i = -readPRObject.type();
                if (i == PRTokeniser.TokenType.END_DIC.ordinal()) {
                    throw new IOException(MessageLocalization.getComposedMessage("unexpected.gt.gt", new Object[0]));
                }
                if (i == PRTokeniser.TokenType.END_ARRAY.ordinal()) {
                    throw new IOException(MessageLocalization.getComposedMessage("unexpected.close.bracket", new Object[0]));
                }
                pdfDictionary.put(pdfName, readPRObject);
            }
        }
        throw new IOException(MessageLocalization.getComposedMessage("unexpected.end.of.file", new Object[0]));
    }

    public PdfArray readArray() throws IOException {
        PdfArray pdfArray = new PdfArray();
        while (true) {
            PdfObject readPRObject = readPRObject();
            int i = -readPRObject.type();
            if (i == PRTokeniser.TokenType.END_ARRAY.ordinal()) {
                return pdfArray;
            }
            if (i == PRTokeniser.TokenType.END_DIC.ordinal()) {
                throw new IOException(MessageLocalization.getComposedMessage("unexpected.gt.gt", new Object[0]));
            }
            pdfArray.add(readPRObject);
        }
    }

    public PdfObject readPRObject() throws IOException {
        if (nextValidToken()) {
            PRTokeniser.TokenType tokenType = this.tokeniser.getTokenType();
            switch (tokenType) {
                case START_DIC:
                    return readDictionary();
                case START_ARRAY:
                    return readArray();
                case STRING:
                    return new PdfString(this.tokeniser.getStringValue(), null).setHexWriting(this.tokeniser.isHexString());
                case NAME:
                    return new PdfName(this.tokeniser.getStringValue(), false);
                case NUMBER:
                    return new PdfNumber(this.tokeniser.getStringValue());
                case OTHER:
                    return new PdfLiteral((int) COMMAND_TYPE, this.tokeniser.getStringValue());
                default:
                    return new PdfLiteral(-tokenType.ordinal(), this.tokeniser.getStringValue());
            }
        }
        return null;
    }

    public boolean nextValidToken() throws IOException {
        while (this.tokeniser.nextToken()) {
            if (this.tokeniser.getTokenType() != PRTokeniser.TokenType.COMMENT) {
                return true;
            }
        }
        return false;
    }
}
