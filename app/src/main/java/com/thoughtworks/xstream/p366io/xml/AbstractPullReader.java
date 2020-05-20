package com.thoughtworks.xstream.p366io.xml;

import com.thoughtworks.xstream.core.util.FastStack;
import com.thoughtworks.xstream.p366io.AttributeNameIterator;
import com.thoughtworks.xstream.p366io.naming.NameCoder;
import java.util.Iterator;

/* renamed from: com.thoughtworks.xstream.io.xml.AbstractPullReader */
/* loaded from: classes2.dex */
public abstract class AbstractPullReader extends AbstractXmlReader {
    protected static final int COMMENT = 4;
    protected static final int END_NODE = 2;
    protected static final int OTHER = 0;
    protected static final int START_NODE = 1;
    protected static final int TEXT = 3;
    private final FastStack elementStack;
    private final FastStack lookahead;
    private final FastStack lookback;
    private boolean marked;
    private final FastStack pool;

    protected abstract String pullElementName();

    protected abstract int pullNextEvent();

    protected abstract String pullText();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.thoughtworks.xstream.io.xml.AbstractPullReader$Event */
    /* loaded from: classes2.dex */
    public static class Event {
        int type;
        String value;

        private Event() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractPullReader(NameCoder nameCoder) {
        super(nameCoder);
        this.elementStack = new FastStack(16);
        this.pool = new FastStack(16);
        this.lookahead = new FastStack(4);
        this.lookback = new FastStack(4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractPullReader(XmlFriendlyReplacer xmlFriendlyReplacer) {
        this((NameCoder) xmlFriendlyReplacer);
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamReader
    public boolean hasMoreChildren() {
        mark();
        while (true) {
            switch (readEvent().type) {
                case 1:
                    reset();
                    return true;
                case 2:
                    reset();
                    return false;
            }
        }
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamReader
    public void moveDown() {
        int size = this.elementStack.size();
        while (this.elementStack.size() <= size) {
            move();
            if (this.elementStack.size() < size) {
                throw new RuntimeException();
            }
        }
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamReader
    public void moveUp() {
        int size = this.elementStack.size();
        while (this.elementStack.size() >= size) {
            move();
        }
    }

    private void move() {
        Event readEvent = readEvent();
        this.pool.push(readEvent);
        switch (readEvent.type) {
            case 1:
                this.elementStack.push(pullElementName());
                return;
            case 2:
                this.elementStack.pop();
                return;
            default:
                return;
        }
    }

    private Event readEvent() {
        if (this.marked) {
            if (this.lookback.hasStuff()) {
                return (Event) this.lookahead.push(this.lookback.pop());
            }
            return (Event) this.lookahead.push(readRealEvent());
        } else if (this.lookback.hasStuff()) {
            return (Event) this.lookback.pop();
        } else {
            return readRealEvent();
        }
    }

    private Event readRealEvent() {
        Event event = this.pool.hasStuff() ? (Event) this.pool.pop() : new Event();
        event.type = pullNextEvent();
        if (event.type == 3) {
            event.value = pullText();
        } else if (event.type == 1) {
            event.value = pullElementName();
        } else {
            event.value = null;
        }
        return event;
    }

    public void mark() {
        this.marked = true;
    }

    public void reset() {
        while (this.lookahead.hasStuff()) {
            this.lookback.push(this.lookahead.pop());
        }
        this.marked = false;
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamReader
    public String getValue() {
        mark();
        Event readEvent = readEvent();
        StringBuffer stringBuffer = null;
        String str = null;
        while (true) {
            if (readEvent.type == 3) {
                String str2 = readEvent.value;
                if (str2 != null && str2.length() > 0) {
                    if (str == null) {
                        str = str2;
                    } else {
                        if (stringBuffer == null) {
                            stringBuffer = new StringBuffer(str);
                        }
                        stringBuffer.append(str2);
                    }
                }
            } else if (readEvent.type != 4) {
                break;
            }
            readEvent = readEvent();
        }
        reset();
        if (stringBuffer != null) {
            return stringBuffer.toString();
        }
        return str == null ? "" : str;
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamReader
    public Iterator getAttributeNames() {
        return new AttributeNameIterator(this);
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamReader
    public String getNodeName() {
        return unescapeXmlName((String) this.elementStack.peek());
    }

    @Override // com.thoughtworks.xstream.p366io.AbstractReader, com.thoughtworks.xstream.p366io.ExtendedHierarchicalStreamReader
    public String peekNextChild() {
        mark();
        while (true) {
            Event readEvent = readEvent();
            switch (readEvent.type) {
                case 1:
                    reset();
                    return readEvent.value;
                case 2:
                    reset();
                    return null;
            }
        }
    }
}
