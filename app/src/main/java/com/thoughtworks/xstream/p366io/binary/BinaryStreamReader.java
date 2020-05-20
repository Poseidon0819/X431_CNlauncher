package com.thoughtworks.xstream.p366io.binary;

import com.thoughtworks.xstream.converters.ErrorWriter;
import com.thoughtworks.xstream.p366io.ExtendedHierarchicalStreamReader;
import com.thoughtworks.xstream.p366io.HierarchicalStreamReader;
import com.thoughtworks.xstream.p366io.StreamException;
import com.thoughtworks.xstream.p366io.binary.Token;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.thoughtworks.xstream.io.binary.BinaryStreamReader */
/* loaded from: classes2.dex */
public class BinaryStreamReader implements ExtendedHierarchicalStreamReader {

    /* renamed from: in */
    private final DataInputStream f21372in;
    private Token pushback;
    private final ReaderDepthState depthState = new ReaderDepthState();
    private final IdRegistry idRegistry = new IdRegistry();
    private final Token.Formatter tokenFormatter = new Token.Formatter();

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamReader, com.thoughtworks.xstream.converters.ErrorReporter
    public void appendErrors(ErrorWriter errorWriter) {
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamReader
    public HierarchicalStreamReader underlyingReader() {
        return this;
    }

    public BinaryStreamReader(InputStream inputStream) {
        this.f21372in = new DataInputStream(inputStream);
        moveDown();
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamReader
    public boolean hasMoreChildren() {
        return this.depthState.hasMoreChildren();
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamReader
    public String getNodeName() {
        return this.depthState.getName();
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamReader
    public String getValue() {
        return this.depthState.getValue();
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamReader
    public String getAttribute(String str) {
        return this.depthState.getAttribute(str);
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamReader
    public String getAttribute(int i) {
        return this.depthState.getAttribute(i);
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamReader
    public int getAttributeCount() {
        return this.depthState.getAttributeCount();
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamReader
    public String getAttributeName(int i) {
        return this.depthState.getAttributeName(i);
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamReader
    public Iterator getAttributeNames() {
        return this.depthState.getAttributeNames();
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamReader
    public void moveDown() {
        this.depthState.push();
        Token readToken = readToken();
        if (readToken.getType() == 3) {
            this.depthState.setName(this.idRegistry.get(readToken.getId()));
            while (true) {
                Token readToken2 = readToken();
                switch (readToken2.getType()) {
                    case 3:
                        this.depthState.setHasMoreChildren(true);
                        pushBack(readToken2);
                        return;
                    case 4:
                        this.depthState.setHasMoreChildren(false);
                        pushBack(readToken2);
                        return;
                    case 5:
                        this.depthState.addAttribute(this.idRegistry.get(readToken2.getId()), readToken2.getValue());
                        break;
                    case 6:
                        this.depthState.setValue(readToken2.getValue());
                        break;
                    default:
                        throw new StreamException("Unexpected token ".concat(String.valueOf(readToken2)));
                }
            }
        } else {
            throw new StreamException("Expected StartNode");
        }
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamReader
    public void moveUp() {
        this.depthState.pop();
        int i = 0;
        while (true) {
            switch (readToken().getType()) {
                case 3:
                    i++;
                    break;
                case 4:
                    if (i == 0) {
                        Token readToken = readToken();
                        switch (readToken.getType()) {
                            case 3:
                                this.depthState.setHasMoreChildren(true);
                                break;
                            case 4:
                                this.depthState.setHasMoreChildren(false);
                                break;
                            default:
                                throw new StreamException("Unexpected token ".concat(String.valueOf(readToken)));
                        }
                        pushBack(readToken);
                        return;
                    }
                    i--;
                    break;
            }
        }
    }

    private Token readToken() {
        Token token = this.pushback;
        if (token == null) {
            try {
                Token read = this.tokenFormatter.read(this.f21372in);
                if (read.getType() != 2) {
                    return read;
                }
                this.idRegistry.put(read.getId(), read.getValue());
                return readToken();
            } catch (IOException e) {
                throw new StreamException(e);
            }
        }
        this.pushback = null;
        return token;
    }

    public void pushBack(Token token) {
        if (this.pushback == null) {
            this.pushback = token;
            return;
        }
        throw new Error("Cannot push more than one token back");
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamReader
    public void close() {
        try {
            this.f21372in.close();
        } catch (IOException e) {
            throw new StreamException(e);
        }
    }

    @Override // com.thoughtworks.xstream.p366io.ExtendedHierarchicalStreamReader
    public String peekNextChild() {
        if (this.depthState.hasMoreChildren()) {
            return this.idRegistry.get(this.pushback.getId());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.thoughtworks.xstream.io.binary.BinaryStreamReader$IdRegistry */
    /* loaded from: classes2.dex */
    public static class IdRegistry {
        private Map map;

        private IdRegistry() {
            this.map = new HashMap();
        }

        public void put(long j, String str) {
            this.map.put(new Long(j), str);
        }

        public String get(long j) {
            String str = (String) this.map.get(new Long(j));
            if (str != null) {
                return str;
            }
            throw new StreamException("Unknown ID : ".concat(String.valueOf(j)));
        }
    }
}
