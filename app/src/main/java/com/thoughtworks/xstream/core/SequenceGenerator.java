package com.thoughtworks.xstream.core;

import com.thoughtworks.xstream.core.ReferenceByIdMarshaller;

/* loaded from: classes2.dex */
public class SequenceGenerator implements ReferenceByIdMarshaller.IDGenerator {
    private int counter;

    public SequenceGenerator(int i) {
        this.counter = i;
    }

    @Override // com.thoughtworks.xstream.core.ReferenceByIdMarshaller.IDGenerator
    public String next(Object obj) {
        int i = this.counter;
        this.counter = i + 1;
        return String.valueOf(i);
    }
}
