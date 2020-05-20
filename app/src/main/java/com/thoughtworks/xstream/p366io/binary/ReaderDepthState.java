package com.thoughtworks.xstream.p366io.binary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.thoughtworks.xstream.io.binary.ReaderDepthState */
/* loaded from: classes2.dex */
class ReaderDepthState {
    private static final String EMPTY_STRING = "";
    private State current;

    /* renamed from: com.thoughtworks.xstream.io.binary.ReaderDepthState$State */
    /* loaded from: classes2.dex */
    static class State {
        List attributes;
        boolean hasMoreChildren;
        String name;
        State parent;
        String value;

        private State() {
        }
    }

    /* renamed from: com.thoughtworks.xstream.io.binary.ReaderDepthState$Attribute */
    /* loaded from: classes2.dex */
    static class Attribute {
        String name;
        String value;

        private Attribute() {
        }
    }

    public void push() {
        State state = new State();
        state.parent = this.current;
        this.current = state;
    }

    public void pop() {
        this.current = this.current.parent;
    }

    public String getName() {
        return this.current.name;
    }

    public void setName(String str) {
        this.current.name = str;
    }

    public String getValue() {
        return this.current.value == null ? "" : this.current.value;
    }

    public void setValue(String str) {
        this.current.value = str;
    }

    public boolean hasMoreChildren() {
        return this.current.hasMoreChildren;
    }

    public void setHasMoreChildren(boolean z) {
        this.current.hasMoreChildren = z;
    }

    public void addAttribute(String str, String str2) {
        Attribute attribute = new Attribute();
        attribute.name = str;
        attribute.value = str2;
        if (this.current.attributes == null) {
            this.current.attributes = new ArrayList();
        }
        this.current.attributes.add(attribute);
    }

    public String getAttribute(String str) {
        if (this.current.attributes == null) {
            return null;
        }
        for (Attribute attribute : this.current.attributes) {
            if (attribute.name.equals(str)) {
                return attribute.value;
            }
        }
        return null;
    }

    public String getAttribute(int i) {
        if (this.current.attributes == null) {
            return null;
        }
        return ((Attribute) this.current.attributes.get(i)).value;
    }

    public String getAttributeName(int i) {
        if (this.current.attributes == null) {
            return null;
        }
        return ((Attribute) this.current.attributes.get(i)).name;
    }

    public int getAttributeCount() {
        if (this.current.attributes == null) {
            return 0;
        }
        return this.current.attributes.size();
    }

    public Iterator getAttributeNames() {
        if (this.current.attributes == null) {
            return Collections.EMPTY_SET.iterator();
        }
        final Iterator it = this.current.attributes.iterator();
        return new Iterator() { // from class: com.thoughtworks.xstream.io.binary.ReaderDepthState.1
            @Override // java.util.Iterator
            public boolean hasNext() {
                return it.hasNext();
            }

            @Override // java.util.Iterator
            public Object next() {
                return ((Attribute) it.next()).name;
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
