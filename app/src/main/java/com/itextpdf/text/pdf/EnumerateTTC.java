package com.itextpdf.text.pdf;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.error_messages.MessageLocalization;
import java.io.IOException;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class EnumerateTTC extends TrueTypeFont {
    protected String[] names;

    /* JADX INFO: Access modifiers changed from: package-private */
    public EnumerateTTC(String str) throws DocumentException, IOException {
        this.fileName = str;
        this.f19810rf = new RandomAccessFileOrArray(str);
        findNames();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public EnumerateTTC(byte[] bArr) throws DocumentException, IOException {
        this.fileName = "Byte array TTC";
        this.f19810rf = new RandomAccessFileOrArray(bArr);
        findNames();
    }

    void findNames() throws DocumentException, IOException {
        this.tables = new HashMap<>();
        try {
            if (!readStandardString(4).equals("ttcf")) {
                throw new DocumentException(MessageLocalization.getComposedMessage("1.is.not.a.valid.ttc.file", this.fileName));
            }
            this.f19810rf.skipBytes(4);
            int readInt = this.f19810rf.readInt();
            this.names = new String[readInt];
            int filePointer = (int) this.f19810rf.getFilePointer();
            for (int i = 0; i < readInt; i++) {
                this.tables.clear();
                this.f19810rf.seek(filePointer);
                this.f19810rf.skipBytes(i * 4);
                this.directoryOffset = this.f19810rf.readInt();
                this.f19810rf.seek(this.directoryOffset);
                if (this.f19810rf.readInt() != 65536) {
                    throw new DocumentException(MessageLocalization.getComposedMessage("1.is.not.a.valid.ttf.file", this.fileName));
                }
                int readUnsignedShort = this.f19810rf.readUnsignedShort();
                this.f19810rf.skipBytes(6);
                for (int i2 = 0; i2 < readUnsignedShort; i2++) {
                    String readStandardString = readStandardString(4);
                    this.f19810rf.skipBytes(4);
                    this.tables.put(readStandardString, new int[]{this.f19810rf.readInt(), this.f19810rf.readInt()});
                }
                this.names[i] = getBaseFont();
            }
        } finally {
            if (this.f19810rf != null) {
                this.f19810rf.close();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String[] getNames() {
        return this.names;
    }
}
