package com.thoughtworks.xstream.converters.reflection;

import java.lang.reflect.Field;

/* loaded from: classes2.dex */
public interface ReflectionProvider {

    /* loaded from: classes2.dex */
    public interface Visitor {
        void visit(String str, Class cls, Class cls2, Object obj);
    }

    boolean fieldDefinedInClass(String str, Class cls);

    Field getField(Class cls, String str);

    Field getFieldOrNull(Class cls, String str);

    Class getFieldType(Object obj, String str, Class cls);

    Object newInstance(Class cls);

    void visitSerializableFields(Object obj, Visitor visitor);

    void writeField(Object obj, String str, Object obj2, Class cls);
}
