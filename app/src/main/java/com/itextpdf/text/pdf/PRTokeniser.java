package com.itextpdf.text.pdf;

import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.exceptions.InvalidPdfException;
import java.io.IOException;
import org.codehaus.jackson.org.objectweb.asm.signature.SignatureVisitor;

/* loaded from: classes.dex */
public class PRTokeniser {
    static final String EMPTY = "";
    public static final boolean[] delims = {true, true, false, false, false, false, false, false, false, false, true, true, false, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, true, false, false, true, true, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, true, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};
    protected RandomAccessFileOrArray file;
    protected int generation;
    protected boolean hexString;
    protected int reference;
    protected String stringValue;
    protected TokenType type;

    /* loaded from: classes.dex */
    public enum TokenType {
        NUMBER,
        STRING,
        NAME,
        COMMENT,
        START_ARRAY,
        END_ARRAY,
        START_DIC,
        END_DIC,
        REF,
        OTHER,
        ENDOFFILE
    }

    public static int getHex(int i) {
        if (i < 48 || i > 57) {
            if (i < 65 || i > 70) {
                if (i < 97 || i > 102) {
                    return -1;
                }
                return (i - 97) + 10;
            }
            return (i - 65) + 10;
        }
        return i - 48;
    }

    public static final boolean isDelimiter(int i) {
        return i == 40 || i == 41 || i == 60 || i == 62 || i == 91 || i == 93 || i == 47 || i == 37;
    }

    public static final boolean isWhitespace(int i) {
        return i == 0 || i == 9 || i == 10 || i == 12 || i == 13 || i == 32;
    }

    public PRTokeniser(String str) throws IOException {
        this.file = new RandomAccessFileOrArray(str);
    }

    public PRTokeniser(byte[] bArr) {
        this.file = new RandomAccessFileOrArray(bArr);
    }

    public PRTokeniser(RandomAccessFileOrArray randomAccessFileOrArray) {
        this.file = randomAccessFileOrArray;
    }

    public void seek(long j) throws IOException {
        this.file.seek(j);
    }

    public long getFilePointer() throws IOException {
        return this.file.getFilePointer();
    }

    public void close() throws IOException {
        this.file.close();
    }

    public long length() throws IOException {
        return this.file.length();
    }

    public int read() throws IOException {
        return this.file.read();
    }

    public RandomAccessFileOrArray getSafeFile() {
        return new RandomAccessFileOrArray(this.file);
    }

    public RandomAccessFileOrArray getFile() {
        return this.file;
    }

    public String readString(int i) throws IOException {
        int read;
        StringBuilder sb = new StringBuilder();
        while (true) {
            int i2 = i - 1;
            if (i <= 0 || (read = this.file.read()) == -1) {
                break;
            }
            sb.append((char) read);
            i = i2;
        }
        return sb.toString();
    }

    public static final boolean isDelimiterWhitespace(int i) {
        return delims[i + 1];
    }

    public TokenType getTokenType() {
        return this.type;
    }

    public String getStringValue() {
        return this.stringValue;
    }

    public int getReference() {
        return this.reference;
    }

    public int getGeneration() {
        return this.generation;
    }

    public void backOnePosition(int i) {
        if (i != -1) {
            this.file.pushBack((byte) i);
        }
    }

    public void throwError(String str) throws IOException {
        throw new InvalidPdfException(MessageLocalization.getComposedMessage("1.at.file.pointer.2", str, String.valueOf(this.file.getFilePointer())));
    }

    public char checkPdfHeader() throws IOException {
        this.file.setStartOffset(0L);
        String readString = readString(1024);
        int indexOf = readString.indexOf("%PDF-");
        if (indexOf < 0) {
            throw new InvalidPdfException(MessageLocalization.getComposedMessage("pdf.header.not.found", new Object[0]));
        }
        this.file.setStartOffset(indexOf);
        return readString.charAt(indexOf + 7);
    }

    public void checkFdfHeader() throws IOException {
        this.file.setStartOffset(0L);
        int indexOf = readString(1024).indexOf("%FDF-");
        if (indexOf < 0) {
            throw new InvalidPdfException(MessageLocalization.getComposedMessage("fdf.header.not.found", new Object[0]));
        }
        this.file.setStartOffset(indexOf);
    }

    public long getStartxref() throws IOException {
        long length = this.file.length() - 1024;
        if (length < 1) {
            length = 1;
        }
        while (length > 0) {
            this.file.seek(length);
            int lastIndexOf = readString(1024).lastIndexOf("startxref");
            if (lastIndexOf >= 0) {
                return length + lastIndexOf;
            }
            length = (length - 1024) + 9;
        }
        throw new InvalidPdfException(MessageLocalization.getComposedMessage("pdf.startxref.not.found", new Object[0]));
    }

    public void nextValidToken() throws IOException {
        String str = null;
        int i = 0;
        long j = 0;
        String str2 = null;
        while (nextToken()) {
            if (this.type != TokenType.COMMENT) {
                switch (i) {
                    case 0:
                        if (this.type != TokenType.NUMBER) {
                            return;
                        }
                        j = this.file.getFilePointer();
                        str = this.stringValue;
                        i++;
                        continue;
                    case 1:
                        if (this.type != TokenType.NUMBER) {
                            this.file.seek(j);
                            this.type = TokenType.NUMBER;
                            this.stringValue = str;
                            return;
                        }
                        str2 = this.stringValue;
                        i++;
                        continue;
                    default:
                        if (this.type != TokenType.OTHER || !this.stringValue.equals("R")) {
                            this.file.seek(j);
                            this.type = TokenType.NUMBER;
                            this.stringValue = str;
                            return;
                        }
                        this.type = TokenType.REF;
                        this.reference = Integer.parseInt(str);
                        this.generation = Integer.parseInt(str2);
                        return;
                }
            }
        }
    }

    public boolean nextToken() throws IOException {
        int read;
        int read2;
        int read3;
        int i;
        boolean z;
        int read4;
        do {
            read = this.file.read();
            if (read == -1) {
                break;
            }
        } while (isWhitespace(read));
        boolean z2 = false;
        if (read == -1) {
            this.type = TokenType.ENDOFFILE;
            return false;
        }
        StringBuffer stringBuffer = null;
        this.stringValue = "";
        if (read == 37) {
            this.type = TokenType.COMMENT;
            do {
                read2 = this.file.read();
                if (read2 == -1 || read2 == 13) {
                    break;
                }
            } while (read2 != 10);
        } else if (read == 40) {
            stringBuffer = new StringBuffer();
            this.type = TokenType.STRING;
            this.hexString = false;
            int i2 = 0;
            while (true) {
                read3 = this.file.read();
                if (read3 != -1) {
                    if (read3 == 40) {
                        i2++;
                    } else if (read3 == 41) {
                        i2--;
                    } else if (read3 == 92) {
                        int read5 = this.file.read();
                        if (read5 == 10) {
                            i = read5;
                            z = true;
                        } else if (read5 != 13) {
                            if (read5 != 92) {
                                if (read5 == 98) {
                                    z = false;
                                    i = 8;
                                } else if (read5 == 102) {
                                    z = false;
                                    i = 12;
                                } else if (read5 == 110) {
                                    z = false;
                                    i = 10;
                                } else if (read5 == 114) {
                                    z = false;
                                    i = 13;
                                } else if (read5 != 116) {
                                    switch (read5) {
                                        default:
                                            if (read5 >= 48 && read5 <= 55) {
                                                int i3 = read5 - 48;
                                                int read6 = this.file.read();
                                                if (read6 < 48 || read6 > 55) {
                                                    backOnePosition(read6);
                                                    i = i3;
                                                    z = false;
                                                    break;
                                                } else {
                                                    int i4 = ((i3 << 3) + read6) - 48;
                                                    int read7 = this.file.read();
                                                    if (read7 >= 48 && read7 <= 55) {
                                                        i = (((i4 << 3) + read7) - 48) & 255;
                                                        z = false;
                                                        break;
                                                    } else {
                                                        backOnePosition(read7);
                                                        i = i4;
                                                        z = false;
                                                        break;
                                                    }
                                                }
                                            }
                                            break;
                                        case 40:
                                        case 41:
                                            i = read5;
                                            z = false;
                                            break;
                                    }
                                } else {
                                    z = false;
                                    i = 9;
                                }
                            }
                            i = read5;
                            z = false;
                        } else {
                            int read8 = this.file.read();
                            if (read8 != 10) {
                                backOnePosition(read8);
                            }
                            i = read8;
                            z = true;
                        }
                        if (z) {
                            continue;
                        } else if (i >= 0) {
                            read3 = i;
                        } else {
                            read3 = i;
                        }
                    } else if (read3 == 13) {
                        read3 = this.file.read();
                        if (read3 >= 0) {
                            if (read3 != 10) {
                                backOnePosition(read3);
                                read3 = 10;
                            }
                        }
                    }
                    if (i2 != -1) {
                        stringBuffer.append((char) read3);
                    }
                }
            }
            if (read3 == -1) {
                throwError(MessageLocalization.getComposedMessage("error.reading.string", new Object[0]));
            }
        } else if (read == 47) {
            stringBuffer = new StringBuffer();
            this.type = TokenType.NAME;
            while (true) {
                read4 = this.file.read();
                if (delims[read4 + 1]) {
                    break;
                }
                if (read4 == 35) {
                    read4 = (getHex(this.file.read()) << 4) + getHex(this.file.read());
                }
                stringBuffer.append((char) read4);
            }
            backOnePosition(read4);
        } else if (read == 60) {
            int read9 = this.file.read();
            if (read9 == 60) {
                this.type = TokenType.START_DIC;
            } else {
                stringBuffer = new StringBuffer();
                this.type = TokenType.STRING;
                this.hexString = true;
                int i5 = 0;
                while (true) {
                    if (!isWhitespace(read9)) {
                        if (read9 == 62 || (read9 = getHex(read9)) < 0) {
                            break;
                        }
                        do {
                            i5 = this.file.read();
                        } while (isWhitespace(i5));
                        if (i5 == 62) {
                            stringBuffer.append((char) (read9 << 4));
                            break;
                        }
                        i5 = getHex(i5);
                        if (i5 < 0) {
                            break;
                        }
                        stringBuffer.append((char) ((read9 << 4) + i5));
                        read9 = this.file.read();
                    } else {
                        read9 = this.file.read();
                    }
                }
                if (read9 < 0 || i5 < 0) {
                    throwError(MessageLocalization.getComposedMessage("error.reading.string", new Object[0]));
                }
            }
        } else if (read == 62) {
            if (this.file.read() != 62) {
                throwError(MessageLocalization.getComposedMessage("greaterthan.not.expected", new Object[0]));
            }
            this.type = TokenType.END_DIC;
        } else if (read == 91) {
            this.type = TokenType.START_ARRAY;
        } else if (read == 93) {
            this.type = TokenType.END_ARRAY;
        } else {
            stringBuffer = new StringBuffer();
            if (read == 45 || read == 43 || read == 46 || (read >= 48 && read <= 57)) {
                this.type = TokenType.NUMBER;
                if (read == 45) {
                    do {
                        z2 = !z2;
                        read = this.file.read();
                    } while (read == 45);
                    if (z2) {
                        stringBuffer.append(SignatureVisitor.SUPER);
                    }
                } else {
                    stringBuffer.append((char) read);
                    read = this.file.read();
                }
                while (read != -1 && ((read >= 48 && read <= 57) || read == 46)) {
                    stringBuffer.append((char) read);
                    read = this.file.read();
                }
            } else {
                this.type = TokenType.OTHER;
                do {
                    stringBuffer.append((char) read);
                    read = this.file.read();
                } while (!delims[read + 1]);
            }
            backOnePosition(read);
        }
        if (stringBuffer != null) {
            this.stringValue = stringBuffer.toString();
        }
        return true;
    }

    public long longValue() {
        return Long.parseLong(this.stringValue);
    }

    public int intValue() {
        return Integer.parseInt(this.stringValue);
    }

    public boolean readLineSegment(byte[] bArr) throws IOException {
        boolean z;
        int i;
        int i2;
        int read;
        int length = bArr.length;
        if (length > 0) {
            do {
                read = read();
            } while (isWhitespace(read));
            i2 = read;
            z = false;
            i = 0;
        } else {
            z = false;
            i = 0;
            i2 = -1;
        }
        while (!z && i < length) {
            if (i2 == -1 || i2 == 10) {
                z = true;
            } else if (i2 == 13) {
                long filePointer = getFilePointer();
                if (read() != 10) {
                    seek(filePointer);
                }
                z = true;
            } else {
                bArr[i] = (byte) i2;
                i++;
            }
            if (z || length <= i) {
                break;
            }
            i2 = read();
        }
        if (i >= length) {
            boolean z2 = false;
            while (!z2) {
                i2 = read();
                if (i2 == -1 || i2 == 10) {
                    z2 = true;
                } else if (i2 == 13) {
                    long filePointer2 = getFilePointer();
                    if (read() != 10) {
                        seek(filePointer2);
                    }
                    z2 = true;
                }
            }
        }
        if (i2 == -1 && i == 0) {
            return false;
        }
        if (i + 2 <= length) {
            bArr[i] = 32;
            bArr[i + 1] = 88;
        }
        return true;
    }

    public static long[] checkObjectStart(byte[] bArr) {
        try {
            PRTokeniser pRTokeniser = new PRTokeniser(bArr);
            if (pRTokeniser.nextToken() && pRTokeniser.getTokenType() == TokenType.NUMBER) {
                int intValue = pRTokeniser.intValue();
                if (pRTokeniser.nextToken() && pRTokeniser.getTokenType() == TokenType.NUMBER) {
                    int intValue2 = pRTokeniser.intValue();
                    if (pRTokeniser.nextToken() && pRTokeniser.getStringValue().equals("obj")) {
                        return new long[]{intValue, intValue2};
                    }
                    return null;
                }
                return null;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public boolean isHexString() {
        return this.hexString;
    }
}
