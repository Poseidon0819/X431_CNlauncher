package com.thoughtworks.xstream.p366io.json;

import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.p366io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.p366io.json.AbstractJsonWriter;
import com.thoughtworks.xstream.p366io.naming.NameCoder;
import com.thoughtworks.xstream.p366io.naming.NoNameCoder;
import com.unionpay.tsmservice.data.Constant;
import java.io.Writer;
import org.apache.http.conn.ssl.TokenParser;

/* renamed from: com.thoughtworks.xstream.io.json.JsonWriter */
/* loaded from: classes2.dex */
public class JsonWriter extends AbstractJsonWriter {
    private int depth;
    protected final Format format;
    private boolean newLineProposed;
    protected final QuickWriter writer;

    @Override // com.thoughtworks.xstream.p366io.AbstractWriter, com.thoughtworks.xstream.p366io.HierarchicalStreamWriter
    public HierarchicalStreamWriter underlyingWriter() {
        return this;
    }

    public JsonWriter(Writer writer, char[] cArr, String str) {
        this(writer, 0, new Format(cArr, str.toCharArray(), Format.SPACE_AFTER_LABEL | Format.COMPACT_EMPTY_ELEMENT));
    }

    public JsonWriter(Writer writer, char[] cArr) {
        this(writer, 0, new Format(cArr, new char[]{'\n'}, Format.SPACE_AFTER_LABEL | Format.COMPACT_EMPTY_ELEMENT));
    }

    public JsonWriter(Writer writer, String str, String str2) {
        this(writer, 0, new Format(str.toCharArray(), str2.toCharArray(), Format.SPACE_AFTER_LABEL | Format.COMPACT_EMPTY_ELEMENT));
    }

    public JsonWriter(Writer writer, String str) {
        this(writer, 0, new Format(str.toCharArray(), new char[]{'\n'}, Format.SPACE_AFTER_LABEL | Format.COMPACT_EMPTY_ELEMENT));
    }

    public JsonWriter(Writer writer) {
        this(writer, 0, new Format(new char[]{TokenParser.f24154SP, TokenParser.f24154SP}, new char[]{'\n'}, Format.SPACE_AFTER_LABEL | Format.COMPACT_EMPTY_ELEMENT));
    }

    public JsonWriter(Writer writer, char[] cArr, String str, int i) {
        this(writer, i, new Format(cArr, str.toCharArray(), Format.SPACE_AFTER_LABEL | Format.COMPACT_EMPTY_ELEMENT));
    }

    public JsonWriter(Writer writer, int i) {
        this(writer, i, new Format());
    }

    public JsonWriter(Writer writer, Format format) {
        this(writer, 0, format);
    }

    public JsonWriter(Writer writer, int i, Format format) {
        this(writer, i, format, 1024);
    }

    public JsonWriter(Writer writer, int i, Format format, int i2) {
        super(i, format.getNameCoder());
        this.writer = new QuickWriter(writer, i2);
        this.format = format;
        this.depth = (i & 1) == 0 ? -1 : 0;
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamWriter
    public void flush() {
        this.writer.flush();
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamWriter
    public void close() {
        this.writer.close();
    }

    @Override // com.thoughtworks.xstream.p366io.json.AbstractJsonWriter
    protected void startObject() {
        if (this.newLineProposed) {
            writeNewLine();
        }
        this.writer.write('{');
        startNewLine();
    }

    @Override // com.thoughtworks.xstream.p366io.json.AbstractJsonWriter
    protected void addLabel(String str) {
        if (this.newLineProposed) {
            writeNewLine();
        }
        this.writer.write(TokenParser.DQUOTE);
        writeText(str);
        this.writer.write("\":");
        if ((this.format.mode() & Format.SPACE_AFTER_LABEL) != 0) {
            this.writer.write(TokenParser.f24154SP);
        }
    }

    @Override // com.thoughtworks.xstream.p366io.json.AbstractJsonWriter
    protected void addValue(String str, AbstractJsonWriter.Type type) {
        if (this.newLineProposed) {
            writeNewLine();
        }
        if (type == AbstractJsonWriter.Type.STRING) {
            this.writer.write(TokenParser.DQUOTE);
        }
        writeText(str);
        if (type == AbstractJsonWriter.Type.STRING) {
            this.writer.write(TokenParser.DQUOTE);
        }
    }

    @Override // com.thoughtworks.xstream.p366io.json.AbstractJsonWriter
    protected void startArray() {
        if (this.newLineProposed) {
            writeNewLine();
        }
        this.writer.write("[");
        startNewLine();
    }

    @Override // com.thoughtworks.xstream.p366io.json.AbstractJsonWriter
    protected void nextElement() {
        this.writer.write(",");
        writeNewLine();
    }

    @Override // com.thoughtworks.xstream.p366io.json.AbstractJsonWriter
    protected void endArray() {
        endNewLine();
        this.writer.write("]");
    }

    @Override // com.thoughtworks.xstream.p366io.json.AbstractJsonWriter
    protected void endObject() {
        endNewLine();
        this.writer.write("}");
    }

    private void startNewLine() {
        int i = this.depth + 1;
        this.depth = i;
        if (i > 0) {
            this.newLineProposed = true;
        }
    }

    private void endNewLine() {
        int i = this.depth;
        this.depth = i - 1;
        if (i > 0) {
            if ((this.format.mode() & Format.COMPACT_EMPTY_ELEMENT) != 0 && this.newLineProposed) {
                this.newLineProposed = false;
            } else {
                writeNewLine();
            }
        }
    }

    private void writeNewLine() {
        int i = this.depth;
        this.writer.write(this.format.getNewLine());
        while (true) {
            int i2 = i - 1;
            if (i > 0) {
                this.writer.write(this.format.getLineIndenter());
                i = i2;
            } else {
                this.newLineProposed = false;
                return;
            }
        }
    }

    private void writeText(String str) {
        String str2;
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt != '\"') {
                if (charAt == '\\') {
                    this.writer.write("\\\\");
                } else {
                    switch (charAt) {
                        case '\b':
                            this.writer.write("\\b");
                            continue;
                        case '\t':
                            this.writer.write("\\t");
                            continue;
                        case '\n':
                            this.writer.write("\\n");
                            continue;
                        default:
                            switch (charAt) {
                                case '\f':
                                    this.writer.write("\\f");
                                    continue;
                                case '\r':
                                    this.writer.write("\\r");
                                    continue;
                                default:
                                    if (charAt > 31) {
                                        this.writer.write(charAt);
                                        continue;
                                        continue;
                                    } else {
                                        this.writer.write("\\u");
                                        this.writer.write((Constant.DEFAULT_CVN2 + Integer.toHexString(charAt)).substring(str2.length() - 4));
                                        break;
                                    }
                            }
                    }
                }
            } else {
                this.writer.write("\\\"");
            }
        }
    }

    /* renamed from: com.thoughtworks.xstream.io.json.JsonWriter$Format */
    /* loaded from: classes2.dex */
    public static class Format {
        public static int COMPACT_EMPTY_ELEMENT = 2;
        public static int SPACE_AFTER_LABEL = 1;
        private char[] lineIndenter;
        private final int mode;
        private final NameCoder nameCoder;
        private char[] newLine;

        public Format() {
            this(new char[]{TokenParser.f24154SP, TokenParser.f24154SP}, new char[]{'\n'}, SPACE_AFTER_LABEL | COMPACT_EMPTY_ELEMENT);
        }

        public Format(char[] cArr, char[] cArr2, int i) {
            this(cArr, cArr2, i, new NoNameCoder());
        }

        public Format(char[] cArr, char[] cArr2, int i, NameCoder nameCoder) {
            this.lineIndenter = cArr;
            this.newLine = cArr2;
            this.mode = i;
            this.nameCoder = nameCoder;
        }

        public char[] getLineIndenter() {
            return this.lineIndenter;
        }

        public char[] getNewLine() {
            return this.newLine;
        }

        public int mode() {
            return this.mode;
        }

        public NameCoder getNameCoder() {
            return this.nameCoder;
        }
    }
}
