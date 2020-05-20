package com.thoughtworks.xstream.converters;

/* loaded from: classes2.dex */
public interface SingleValueConverter extends ConverterMatcher {
    Object fromString(String str);

    String toString(Object obj);
}
