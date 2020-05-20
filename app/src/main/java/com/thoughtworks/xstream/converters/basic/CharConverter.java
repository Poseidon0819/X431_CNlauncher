package com.thoughtworks.xstream.converters.basic;

import com.itextpdf.text.pdf.PdfBoolean;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.SingleValueConverter;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.p366io.HierarchicalStreamReader;
import com.thoughtworks.xstream.p366io.HierarchicalStreamWriter;

/* loaded from: classes2.dex */
public class CharConverter implements Converter, SingleValueConverter {
    @Override // com.thoughtworks.xstream.converters.ConverterMatcher
    public boolean canConvert(Class cls) {
        return cls.equals(Character.TYPE) || cls.equals(Character.class);
    }

    @Override // com.thoughtworks.xstream.converters.Converter
    public void marshal(Object obj, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {
        hierarchicalStreamWriter.setValue(toString(obj));
    }

    @Override // com.thoughtworks.xstream.converters.Converter
    public Object unmarshal(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
        String attribute = hierarchicalStreamReader.getAttribute("null");
        if (attribute != null && attribute.equals(PdfBoolean.TRUE)) {
            return (char) 0;
        }
        return fromString(hierarchicalStreamReader.getValue());
    }

    @Override // com.thoughtworks.xstream.converters.SingleValueConverter
    public Object fromString(String str) {
        if (str.length() == 0) {
            return (char) 0;
        }
        return new Character(str.charAt(0));
    }

    @Override // com.thoughtworks.xstream.converters.SingleValueConverter
    public String toString(Object obj) {
        return ((Character) obj).charValue() == 0 ? "" : obj.toString();
    }
}
