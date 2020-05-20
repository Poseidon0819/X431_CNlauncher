package com.thoughtworks.xstream.core.util;

/* loaded from: classes2.dex */
public class TypedNull {
    private final Class type;

    public TypedNull(Class cls) {
        this.type = cls;
    }

    public Class getType() {
        return this.type;
    }
}
