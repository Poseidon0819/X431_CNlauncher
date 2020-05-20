package com.thoughtworks.xstream.converters;

import com.thoughtworks.xstream.p366io.HierarchicalStreamReader;
import com.thoughtworks.xstream.p366io.HierarchicalStreamWriter;

/* loaded from: classes2.dex */
public class SingleValueConverterWrapper implements Converter, ErrorReporter, SingleValueConverter {
    private final SingleValueConverter wrapped;

    public SingleValueConverterWrapper(SingleValueConverter singleValueConverter) {
        this.wrapped = singleValueConverter;
    }

    @Override // com.thoughtworks.xstream.converters.ConverterMatcher
    public boolean canConvert(Class cls) {
        return this.wrapped.canConvert(cls);
    }

    @Override // com.thoughtworks.xstream.converters.SingleValueConverter
    public String toString(Object obj) {
        return this.wrapped.toString(obj);
    }

    @Override // com.thoughtworks.xstream.converters.SingleValueConverter
    public Object fromString(String str) {
        return this.wrapped.fromString(str);
    }

    @Override // com.thoughtworks.xstream.converters.Converter
    public void marshal(Object obj, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {
        hierarchicalStreamWriter.setValue(toString(obj));
    }

    @Override // com.thoughtworks.xstream.converters.Converter
    public Object unmarshal(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
        return fromString(hierarchicalStreamReader.getValue());
    }

    @Override // com.thoughtworks.xstream.converters.ErrorReporter
    public void appendErrors(ErrorWriter errorWriter) {
        errorWriter.add("wrapped-converter", this.wrapped.getClass().getName());
        SingleValueConverter singleValueConverter = this.wrapped;
        if (singleValueConverter instanceof ErrorReporter) {
            ((ErrorReporter) singleValueConverter).appendErrors(errorWriter);
        }
    }
}
