package com.thoughtworks.xstream.converters.basic;

import com.thoughtworks.xstream.converters.ConversionException;
import java.net.URI;
import java.net.URISyntaxException;

/* loaded from: classes2.dex */
public class URIConverter extends AbstractSingleValueConverter {
    @Override // com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter, com.thoughtworks.xstream.converters.ConverterMatcher
    public boolean canConvert(Class cls) {
        return cls.equals(URI.class);
    }

    @Override // com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter, com.thoughtworks.xstream.converters.SingleValueConverter
    public Object fromString(String str) {
        try {
            return new URI(str);
        } catch (URISyntaxException e) {
            throw new ConversionException(e);
        }
    }
}
