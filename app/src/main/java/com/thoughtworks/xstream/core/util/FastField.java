package com.thoughtworks.xstream.core.util;

/* loaded from: classes2.dex */
public final class FastField {
    private final String declaringClass;
    private final String name;

    public FastField(String str, String str2) {
        this.name = str2;
        this.declaringClass = str;
    }

    public FastField(Class cls, String str) {
        this(cls == null ? null : cls.getName(), str);
    }

    public final String getName() {
        return this.name;
    }

    public final String getDeclaringClass() {
        return this.declaringClass;
    }

    public final boolean equals(Object obj) {
        String str;
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof FastField)) {
            FastField fastField = (FastField) obj;
            return (this.declaringClass != null || fastField.declaringClass == null) && (this.declaringClass == null || fastField.declaringClass != null) && this.name.equals(fastField.getName()) && ((str = this.declaringClass) == null || str.equals(fastField.getDeclaringClass()));
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.name.hashCode();
        String str = this.declaringClass;
        return hashCode ^ (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        if (this.declaringClass == null) {
            str = "";
        } else {
            str = this.declaringClass + ".";
        }
        sb.append(str);
        sb.append(this.name);
        return sb.toString();
    }
}
