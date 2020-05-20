package com.thoughtworks.xstream.p366io.xml;

import com.thoughtworks.xstream.core.util.FastStack;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.p366io.StreamException;
import com.thoughtworks.xstream.p366io.naming.NameCoder;
import java.io.Writer;
import org.apache.http.conn.ssl.TokenParser;
import org.codehaus.jackson.org.objectweb.asm.signature.SignatureVisitor;

/* renamed from: com.thoughtworks.xstream.io.xml.PrettyPrintWriter */
/* loaded from: classes2.dex */
public class PrettyPrintWriter extends AbstractXmlWriter {
    public static int XML_1_0 = 0;
    public static int XML_1_1 = 1;
    public static int XML_QUIRKS = -1;
    protected int depth;
    private final FastStack elementStack;
    private final char[] lineIndenter;
    private final int mode;
    private String newLine;
    private boolean readyForNewLine;
    private boolean tagInProgress;
    private boolean tagIsEmpty;
    private final QuickWriter writer;
    private static final char[] NULL = "&#x0;".toCharArray();
    private static final char[] AMP = "&amp;".toCharArray();

    /* renamed from: LT */
    private static final char[] f21377LT = "&lt;".toCharArray();

    /* renamed from: GT */
    private static final char[] f21376GT = "&gt;".toCharArray();

    /* renamed from: CR */
    private static final char[] f21375CR = "&#xd;".toCharArray();
    private static final char[] QUOT = "&quot;".toCharArray();
    private static final char[] APOS = "&apos;".toCharArray();
    private static final char[] CLOSE = "</".toCharArray();

    private PrettyPrintWriter(Writer writer, int i, char[] cArr, NameCoder nameCoder, String str) {
        super(nameCoder);
        this.elementStack = new FastStack(16);
        this.writer = new QuickWriter(writer);
        this.lineIndenter = cArr;
        this.newLine = str;
        this.mode = i;
        if (i < XML_QUIRKS || i > XML_1_1) {
            throw new IllegalArgumentException("Not a valid XML mode");
        }
    }

    public PrettyPrintWriter(Writer writer, char[] cArr, String str, XmlFriendlyReplacer xmlFriendlyReplacer) {
        this(writer, XML_QUIRKS, cArr, xmlFriendlyReplacer, str);
    }

    public PrettyPrintWriter(Writer writer, int i, char[] cArr, NameCoder nameCoder) {
        this(writer, i, cArr, nameCoder, "\n");
    }

    public PrettyPrintWriter(Writer writer, int i, char[] cArr, XmlFriendlyReplacer xmlFriendlyReplacer) {
        this(writer, i, cArr, xmlFriendlyReplacer, "\n");
    }

    public PrettyPrintWriter(Writer writer, char[] cArr, String str) {
        this(writer, cArr, str, new XmlFriendlyReplacer());
    }

    public PrettyPrintWriter(Writer writer, int i, char[] cArr) {
        this(writer, i, cArr, new XmlFriendlyNameCoder());
    }

    public PrettyPrintWriter(Writer writer, char[] cArr) {
        this(writer, XML_QUIRKS, cArr);
    }

    public PrettyPrintWriter(Writer writer, String str, String str2) {
        this(writer, str.toCharArray(), str2);
    }

    public PrettyPrintWriter(Writer writer, int i, String str) {
        this(writer, i, str.toCharArray());
    }

    public PrettyPrintWriter(Writer writer, String str) {
        this(writer, str.toCharArray());
    }

    public PrettyPrintWriter(Writer writer, int i, NameCoder nameCoder) {
        this(writer, i, new char[]{TokenParser.f24154SP, TokenParser.f24154SP}, nameCoder);
    }

    public PrettyPrintWriter(Writer writer, int i, XmlFriendlyReplacer xmlFriendlyReplacer) {
        this(writer, i, new char[]{TokenParser.f24154SP, TokenParser.f24154SP}, xmlFriendlyReplacer);
    }

    public PrettyPrintWriter(Writer writer, NameCoder nameCoder) {
        this(writer, XML_QUIRKS, new char[]{TokenParser.f24154SP, TokenParser.f24154SP}, nameCoder, "\n");
    }

    public PrettyPrintWriter(Writer writer, XmlFriendlyReplacer xmlFriendlyReplacer) {
        this(writer, new char[]{TokenParser.f24154SP, TokenParser.f24154SP}, "\n", xmlFriendlyReplacer);
    }

    public PrettyPrintWriter(Writer writer, int i) {
        this(writer, i, new char[]{TokenParser.f24154SP, TokenParser.f24154SP});
    }

    public PrettyPrintWriter(Writer writer) {
        this(writer, new char[]{TokenParser.f24154SP, TokenParser.f24154SP});
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamWriter
    public void startNode(String str) {
        String encodeNode = encodeNode(str);
        this.tagIsEmpty = false;
        finishTag();
        this.writer.write('<');
        this.writer.write(encodeNode);
        this.elementStack.push(encodeNode);
        this.tagInProgress = true;
        this.depth++;
        this.readyForNewLine = true;
        this.tagIsEmpty = true;
    }

    @Override // com.thoughtworks.xstream.p366io.AbstractWriter, com.thoughtworks.xstream.p366io.ExtendedHierarchicalStreamWriter
    public void startNode(String str, Class cls) {
        startNode(str);
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamWriter
    public void setValue(String str) {
        this.readyForNewLine = false;
        this.tagIsEmpty = false;
        finishTag();
        writeText(this.writer, str);
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamWriter
    public void addAttribute(String str, String str2) {
        this.writer.write(TokenParser.f24154SP);
        this.writer.write(encodeAttribute(str));
        this.writer.write(SignatureVisitor.INSTANCEOF);
        this.writer.write(TokenParser.DQUOTE);
        writeAttributeValue(this.writer, str2);
        this.writer.write(TokenParser.DQUOTE);
    }

    protected void writeAttributeValue(QuickWriter quickWriter, String str) {
        writeText(str, true);
    }

    protected void writeText(QuickWriter quickWriter, String str) {
        writeText(str, false);
    }

    private void writeText(String str, boolean z) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt != 0) {
                if (charAt != '\r') {
                    if (charAt != '\"') {
                        if (charAt != '<') {
                            if (charAt == '>') {
                                this.writer.write(f21376GT);
                            } else {
                                switch (charAt) {
                                    case '\t':
                                    case '\n':
                                        if (!z) {
                                            this.writer.write(charAt);
                                            break;
                                        }
                                        if (!Character.isDefined(charAt) && !Character.isISOControl(charAt)) {
                                            if (this.mode != XML_QUIRKS && charAt > 55295 && charAt < 57344) {
                                                throw new StreamException("Invalid character 0x" + Integer.toHexString(charAt) + " in XML stream");
                                            }
                                            this.writer.write(charAt);
                                            break;
                                        } else if (this.mode != XML_1_0 && (charAt < '\t' || charAt == 11 || charAt == '\f' || charAt == 14 || (charAt >= 15 && charAt <= 31))) {
                                            throw new StreamException("Invalid character 0x" + Integer.toHexString(charAt) + " in XML 1.0 stream");
                                        } else if (this.mode == XML_QUIRKS && (charAt == 65534 || charAt == 65535)) {
                                            throw new StreamException("Invalid character 0x" + Integer.toHexString(charAt) + " in XML stream");
                                        } else {
                                            this.writer.write("&#x");
                                            this.writer.write(Integer.toHexString(charAt));
                                            this.writer.write(';');
                                            break;
                                        }
                                        break;
                                    default:
                                        switch (charAt) {
                                            case '&':
                                                this.writer.write(AMP);
                                                break;
                                            case '\'':
                                                this.writer.write(APOS);
                                                break;
                                            default:
                                                if (!Character.isDefined(charAt)) {
                                                    break;
                                                }
                                                if (this.mode != XML_1_0) {
                                                    break;
                                                }
                                                if (this.mode == XML_QUIRKS) {
                                                    break;
                                                }
                                                this.writer.write("&#x");
                                                this.writer.write(Integer.toHexString(charAt));
                                                this.writer.write(';');
                                                break;
                                        }
                                }
                            }
                        } else {
                            this.writer.write(f21377LT);
                        }
                    } else {
                        this.writer.write(QUOT);
                    }
                } else {
                    this.writer.write(f21375CR);
                }
            } else if (this.mode == XML_QUIRKS) {
                this.writer.write(NULL);
            } else {
                throw new StreamException("Invalid character 0x0 in XML stream");
            }
        }
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamWriter
    public void endNode() {
        this.depth--;
        if (this.tagIsEmpty) {
            this.writer.write('/');
            this.readyForNewLine = false;
            finishTag();
            this.elementStack.popSilently();
        } else {
            finishTag();
            this.writer.write(CLOSE);
            this.writer.write((String) this.elementStack.pop());
            this.writer.write('>');
        }
        this.readyForNewLine = true;
        if (this.depth == 0) {
            this.writer.flush();
        }
    }

    private void finishTag() {
        if (this.tagInProgress) {
            this.writer.write('>');
        }
        this.tagInProgress = false;
        if (this.readyForNewLine) {
            endOfLine();
        }
        this.readyForNewLine = false;
        this.tagIsEmpty = false;
    }

    protected void endOfLine() {
        this.writer.write(getNewLine());
        for (int i = 0; i < this.depth; i++) {
            this.writer.write(this.lineIndenter);
        }
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamWriter
    public void flush() {
        this.writer.flush();
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamWriter
    public void close() {
        this.writer.close();
    }

    protected String getNewLine() {
        return this.newLine;
    }
}
