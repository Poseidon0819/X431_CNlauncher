package com.thoughtworks.xstream.converters.reflection;

/* loaded from: classes2.dex */
public class FieldKey {
    private final Class declaringClass;
    private final int depth;
    private final String fieldName;
    private final int order;

    public FieldKey(String str, Class cls, int i) {
        if (str == null || cls == null) {
            throw new IllegalArgumentException("fieldName or declaringClass is null");
        }
        this.fieldName = str;
        this.declaringClass = cls;
        this.order = i;
        int i2 = 0;
        while (cls.getSuperclass() != null) {
            i2++;
            cls = cls.getSuperclass();
        }
        this.depth = i2;
    }

    public String getFieldName() {
        return this.fieldName;
    }

    public Class getDeclaringClass() {
        return this.declaringClass;
    }

    public int getDepth() {
        return this.depth;
    }

    public int getOrder() {
        return this.order;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FieldKey) {
            FieldKey fieldKey = (FieldKey) obj;
            return this.declaringClass.equals(fieldKey.declaringClass) && this.fieldName.equals(fieldKey.fieldName);
        }
        return false;
    }

    public int hashCode() {
        return (this.fieldName.hashCode() * 29) + this.declaringClass.hashCode();
    }

    public String toString() {
        return "FieldKey{order=" + this.order + ", writer=" + this.depth + ", declaringClass=" + this.declaringClass + ", fieldName='" + this.fieldName + "'}";
    }
}
