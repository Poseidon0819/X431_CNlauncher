package com.thoughtworks.xstream.converters.reflection;

/* loaded from: classes2.dex */
public class MissingFieldException extends ObjectAccessException {
    private final String className;
    private final String fieldName;

    public MissingFieldException(String str, String str2) {
        super("No field '" + str2 + "' found in class '" + str + "'");
        this.className = str;
        this.fieldName = str2;
    }

    public String getFieldName() {
        return this.fieldName;
    }

    protected String getClassName() {
        return this.className;
    }
}
