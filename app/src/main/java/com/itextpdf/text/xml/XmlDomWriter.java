package com.itextpdf.text.xml;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import org.apache.http.conn.ssl.TokenParser;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

/* loaded from: classes.dex */
public class XmlDomWriter {
    protected boolean fCanonical;
    protected PrintWriter fOut;
    protected boolean fXML11;

    public XmlDomWriter() {
    }

    public XmlDomWriter(boolean z) {
        this.fCanonical = z;
    }

    public void setCanonical(boolean z) {
        this.fCanonical = z;
    }

    public void setOutput(OutputStream outputStream, String str) throws UnsupportedEncodingException {
        if (str == null) {
            str = "UTF8";
        }
        this.fOut = new PrintWriter(new OutputStreamWriter(outputStream, str));
    }

    public void setOutput(Writer writer) {
        this.fOut = writer instanceof PrintWriter ? (PrintWriter) writer : new PrintWriter(writer);
    }

    public void write(Node node) {
        Attr[] sortAttributes;
        if (node == null) {
            return;
        }
        short nodeType = node.getNodeType();
        switch (nodeType) {
            case 1:
                this.fOut.print('<');
                this.fOut.print(node.getNodeName());
                for (Attr attr : sortAttributes(node.getAttributes())) {
                    this.fOut.print(TokenParser.f24154SP);
                    this.fOut.print(attr.getNodeName());
                    this.fOut.print("=\"");
                    normalizeAndPrint(attr.getNodeValue(), true);
                    this.fOut.print(TokenParser.DQUOTE);
                }
                this.fOut.print('>');
                this.fOut.flush();
                for (Node firstChild = node.getFirstChild(); firstChild != null; firstChild = firstChild.getNextSibling()) {
                    write(firstChild);
                }
                break;
            case 3:
                normalizeAndPrint(node.getNodeValue(), false);
                this.fOut.flush();
                break;
            case 4:
                if (this.fCanonical) {
                    normalizeAndPrint(node.getNodeValue(), false);
                } else {
                    this.fOut.print("<![CDATA[");
                    this.fOut.print(node.getNodeValue());
                    this.fOut.print("]]>");
                }
                this.fOut.flush();
                break;
            case 5:
                if (this.fCanonical) {
                    for (Node firstChild2 = node.getFirstChild(); firstChild2 != null; firstChild2 = firstChild2.getNextSibling()) {
                        write(firstChild2);
                    }
                    break;
                } else {
                    this.fOut.print('&');
                    this.fOut.print(node.getNodeName());
                    this.fOut.print(';');
                    this.fOut.flush();
                    break;
                }
            case 7:
                this.fOut.print("<?");
                this.fOut.print(node.getNodeName());
                String nodeValue = node.getNodeValue();
                if (nodeValue != null && nodeValue.length() > 0) {
                    this.fOut.print(TokenParser.f24154SP);
                    this.fOut.print(nodeValue);
                }
                this.fOut.print("?>");
                this.fOut.flush();
                break;
            case 8:
                if (!this.fCanonical) {
                    this.fOut.print("<!--");
                    String nodeValue2 = node.getNodeValue();
                    if (nodeValue2 != null && nodeValue2.length() > 0) {
                        this.fOut.print(nodeValue2);
                    }
                    this.fOut.print("-->");
                    this.fOut.flush();
                    break;
                }
                break;
            case 9:
                Document document = (Document) node;
                this.fXML11 = false;
                if (!this.fCanonical) {
                    if (this.fXML11) {
                        this.fOut.println("<?xml version=\"1.1\" encoding=\"UTF-8\"?>");
                    } else {
                        this.fOut.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
                    }
                    this.fOut.flush();
                    write(document.getDoctype());
                }
                write(document.getDocumentElement());
                break;
            case 10:
                DocumentType documentType = (DocumentType) node;
                this.fOut.print("<!DOCTYPE ");
                this.fOut.print(documentType.getName());
                String publicId = documentType.getPublicId();
                String systemId = documentType.getSystemId();
                if (publicId != null) {
                    this.fOut.print(" PUBLIC '");
                    this.fOut.print(publicId);
                    this.fOut.print("' '");
                    this.fOut.print(systemId);
                    this.fOut.print('\'');
                } else if (systemId != null) {
                    this.fOut.print(" SYSTEM '");
                    this.fOut.print(systemId);
                    this.fOut.print('\'');
                }
                String internalSubset = documentType.getInternalSubset();
                if (internalSubset != null) {
                    this.fOut.println(" [");
                    this.fOut.print(internalSubset);
                    this.fOut.print(']');
                }
                this.fOut.println('>');
                break;
        }
        if (nodeType == 1) {
            this.fOut.print("</");
            this.fOut.print(node.getNodeName());
            this.fOut.print('>');
            this.fOut.flush();
        }
    }

    protected Attr[] sortAttributes(NamedNodeMap namedNodeMap) {
        int i = 0;
        int length = namedNodeMap != null ? namedNodeMap.getLength() : 0;
        Attr[] attrArr = new Attr[length];
        for (int i2 = 0; i2 < length; i2++) {
            attrArr[i2] = (Attr) namedNodeMap.item(i2);
        }
        while (i < length - 1) {
            int i3 = i + 1;
            String nodeName = attrArr[i].getNodeName();
            int i4 = i;
            for (int i5 = i3; i5 < length; i5++) {
                String nodeName2 = attrArr[i5].getNodeName();
                if (nodeName2.compareTo(nodeName) < 0) {
                    i4 = i5;
                    nodeName = nodeName2;
                }
            }
            if (i4 != i) {
                Attr attr = attrArr[i];
                attrArr[i] = attrArr[i4];
                attrArr[i4] = attr;
            }
            i = i3;
        }
        return attrArr;
    }

    protected void normalizeAndPrint(String str, boolean z) {
        int length = str != null ? str.length() : 0;
        for (int i = 0; i < length; i++) {
            normalizeAndPrint(str.charAt(i), z);
        }
    }

    protected void normalizeAndPrint(char c, boolean z) {
        if (c != '\n') {
            if (c == '\r') {
                this.fOut.print("&#xD;");
                return;
            } else if (c == '\"') {
                if (z) {
                    this.fOut.print("&quot;");
                    return;
                } else {
                    this.fOut.print("\"");
                    return;
                }
            } else if (c == '&') {
                this.fOut.print("&amp;");
                return;
            } else if (c == '<') {
                this.fOut.print("&lt;");
                return;
            } else if (c == '>') {
                this.fOut.print("&gt;");
                return;
            }
        } else if (this.fCanonical) {
            this.fOut.print("&#xA;");
            return;
        }
        if ((this.fXML11 && ((c > 0 && c <= 31 && c != '\t' && c != '\n') || ((c >= 127 && c <= 159) || c == 8232))) || (z && (c == '\t' || c == '\n'))) {
            this.fOut.print("&#x");
            this.fOut.print(Integer.toHexString(c).toUpperCase());
            this.fOut.print(";");
            return;
        }
        this.fOut.print(c);
    }
}
