package com.thoughtworks.xstream.p366io.binary;

import com.thoughtworks.xstream.p366io.StreamException;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import org.apache.mina.proxy.handlers.http.ntlm.NTLMConstants;

/* renamed from: com.thoughtworks.xstream.io.binary.Token */
/* loaded from: classes2.dex */
public abstract class Token {
    private static final byte ID_EIGHT_BYTES = 32;
    private static final byte ID_FOUR_BYTES = 24;
    private static final byte ID_MASK = 56;
    private static final byte ID_ONE_BYTE = 8;
    private static final String ID_SPLITTED = "\u0000‡\u0000";
    private static final byte ID_TWO_BYTES = 16;
    private static final int MAX_UTF8_LENGTH = 65535;
    public static final byte TYPE_ATTRIBUTE = 5;
    public static final byte TYPE_END_NODE = 4;
    public static final byte TYPE_MAP_ID_TO_VALUE = 2;
    private static final byte TYPE_MASK = 7;
    public static final byte TYPE_START_NODE = 3;
    public static final byte TYPE_VALUE = 6;
    public static final byte TYPE_VERSION = 1;

    /* renamed from: id */
    protected long f21373id = -1;
    private final byte type;
    protected String value;

    public abstract void readFrom(DataInput dataInput, byte b) throws IOException;

    public abstract void writeTo(DataOutput dataOutput, byte b) throws IOException;

    public Token(byte b) {
        this.type = b;
    }

    public byte getType() {
        return this.type;
    }

    public long getId() {
        return this.f21373id;
    }

    public String getValue() {
        return this.value;
    }

    public String toString() {
        return getClass().getName() + " [id=" + this.f21373id + ", value='" + this.value + "']";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Token token = (Token) obj;
        if (this.f21373id == token.f21373id && this.type == token.type) {
            String str = this.value;
            return str == null ? token.value == null : str.equals(token.value);
        }
        return false;
    }

    public int hashCode() {
        long j = this.f21373id;
        int i = ((this.type * 29) + ((int) (j ^ (j >>> 32)))) * 29;
        String str = this.value;
        return i + (str != null ? str.hashCode() : 0);
    }

    protected void writeId(DataOutput dataOutput, long j, byte b) throws IOException {
        if (j < 0) {
            throw new IOException("id must not be negative ".concat(String.valueOf(j)));
        }
        if (b == 8) {
            dataOutput.writeByte(((byte) j) - 128);
        } else if (b == 16) {
            dataOutput.writeShort(((short) j) - 32768);
        } else if (b == 24) {
            dataOutput.writeInt(((int) j) + NTLMConstants.FLAG_NEGOTIATE_56_BIT_ENCRYPTION);
        } else if (b == 32) {
            dataOutput.writeLong(j - Long.MIN_VALUE);
        } else {
            throw new Error("Unknown idType ".concat(String.valueOf((int) b)));
        }
    }

    protected void writeString(DataOutput dataOutput, String str) throws IOException {
        byte[] bytes = str.length() > 16383 ? str.getBytes("utf-8") : new byte[0];
        if (bytes.length <= 65535) {
            dataOutput.writeUTF(str);
            return;
        }
        dataOutput.writeUTF(ID_SPLITTED);
        dataOutput.writeInt(bytes.length);
        dataOutput.write(bytes);
    }

    protected long readId(DataInput dataInput, byte b) throws IOException {
        if (b != 8) {
            if (b != 16) {
                if (b != 24) {
                    if (b == 32) {
                        return dataInput.readLong() - Long.MIN_VALUE;
                    }
                    throw new Error("Unknown idType ".concat(String.valueOf((int) b)));
                }
                return dataInput.readInt() - NTLMConstants.FLAG_NEGOTIATE_56_BIT_ENCRYPTION;
            }
            return dataInput.readShort() - Short.MIN_VALUE;
        }
        return dataInput.readByte() + 128;
    }

    protected String readString(DataInput dataInput) throws IOException {
        String readUTF = dataInput.readUTF();
        if (ID_SPLITTED.equals(readUTF)) {
            byte[] bArr = new byte[dataInput.readInt()];
            dataInput.readFully(bArr);
            return new String(bArr, "utf-8");
        }
        return readUTF;
    }

    /* renamed from: com.thoughtworks.xstream.io.binary.Token$Formatter */
    /* loaded from: classes2.dex */
    public static class Formatter {
        public void write(DataOutput dataOutput, Token token) throws IOException {
            long id = token.getId();
            byte b = id <= 255 ? (byte) 8 : id <= 65535 ? (byte) 16 : id <= 4294967295L ? Token.ID_FOUR_BYTES : (byte) 32;
            dataOutput.write(token.getType() + b);
            token.writeTo(dataOutput, b);
        }

        public Token read(DataInput dataInput) throws IOException {
            byte readByte = dataInput.readByte();
            Token contructToken = contructToken((byte) (readByte & 7));
            contructToken.readFrom(dataInput, (byte) (readByte & Token.ID_MASK));
            return contructToken;
        }

        private Token contructToken(byte b) {
            switch (b) {
                case 2:
                    return new MapIdToValue();
                case 3:
                    return new StartNode();
                case 4:
                    return new EndNode();
                case 5:
                    return new Attribute();
                case 6:
                    return new Value();
                default:
                    throw new StreamException("Unknown token type");
            }
        }
    }

    /* renamed from: com.thoughtworks.xstream.io.binary.Token$MapIdToValue */
    /* loaded from: classes2.dex */
    public static class MapIdToValue extends Token {
        public MapIdToValue(long j, String str) {
            super((byte) 2);
            this.f21373id = j;
            this.value = str;
        }

        public MapIdToValue() {
            super((byte) 2);
        }

        @Override // com.thoughtworks.xstream.p366io.binary.Token
        public void writeTo(DataOutput dataOutput, byte b) throws IOException {
            writeId(dataOutput, this.f21373id, b);
            writeString(dataOutput, this.value);
        }

        @Override // com.thoughtworks.xstream.p366io.binary.Token
        public void readFrom(DataInput dataInput, byte b) throws IOException {
            this.f21373id = readId(dataInput, b);
            this.value = readString(dataInput);
        }
    }

    /* renamed from: com.thoughtworks.xstream.io.binary.Token$StartNode */
    /* loaded from: classes2.dex */
    public static class StartNode extends Token {
        public StartNode(long j) {
            super((byte) 3);
            this.f21373id = j;
        }

        public StartNode() {
            super((byte) 3);
        }

        @Override // com.thoughtworks.xstream.p366io.binary.Token
        public void writeTo(DataOutput dataOutput, byte b) throws IOException {
            writeId(dataOutput, this.f21373id, b);
        }

        @Override // com.thoughtworks.xstream.p366io.binary.Token
        public void readFrom(DataInput dataInput, byte b) throws IOException {
            this.f21373id = readId(dataInput, b);
        }
    }

    /* renamed from: com.thoughtworks.xstream.io.binary.Token$EndNode */
    /* loaded from: classes2.dex */
    public static class EndNode extends Token {
        @Override // com.thoughtworks.xstream.p366io.binary.Token
        public void readFrom(DataInput dataInput, byte b) {
        }

        @Override // com.thoughtworks.xstream.p366io.binary.Token
        public void writeTo(DataOutput dataOutput, byte b) {
        }

        public EndNode() {
            super((byte) 4);
        }
    }

    /* renamed from: com.thoughtworks.xstream.io.binary.Token$Attribute */
    /* loaded from: classes2.dex */
    public static class Attribute extends Token {
        public Attribute(long j, String str) {
            super((byte) 5);
            this.f21373id = j;
            this.value = str;
        }

        public Attribute() {
            super((byte) 5);
        }

        @Override // com.thoughtworks.xstream.p366io.binary.Token
        public void writeTo(DataOutput dataOutput, byte b) throws IOException {
            writeId(dataOutput, this.f21373id, b);
            writeString(dataOutput, this.value);
        }

        @Override // com.thoughtworks.xstream.p366io.binary.Token
        public void readFrom(DataInput dataInput, byte b) throws IOException {
            this.f21373id = readId(dataInput, b);
            this.value = readString(dataInput);
        }
    }

    /* renamed from: com.thoughtworks.xstream.io.binary.Token$Value */
    /* loaded from: classes2.dex */
    public static class Value extends Token {
        public Value(String str) {
            super((byte) 6);
            this.value = str;
        }

        public Value() {
            super((byte) 6);
        }

        @Override // com.thoughtworks.xstream.p366io.binary.Token
        public void writeTo(DataOutput dataOutput, byte b) throws IOException {
            writeString(dataOutput, this.value);
        }

        @Override // com.thoughtworks.xstream.p366io.binary.Token
        public void readFrom(DataInput dataInput, byte b) throws IOException {
            this.value = readString(dataInput);
        }
    }
}
