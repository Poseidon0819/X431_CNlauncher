package com.thoughtworks.xstream.converters.extended;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.ConverterLookup;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.p366io.HierarchicalStreamReader;
import com.thoughtworks.xstream.p366io.HierarchicalStreamWriter;

/* loaded from: classes2.dex */
public class ThrowableConverter implements Converter {
    private Converter defaultConverter;
    private final ConverterLookup lookup;

    public ThrowableConverter(Converter converter) {
        this.defaultConverter = converter;
        this.lookup = null;
    }

    public ThrowableConverter(ConverterLookup converterLookup) {
        this.lookup = converterLookup;
    }

    @Override // com.thoughtworks.xstream.converters.ConverterMatcher
    public boolean canConvert(Class cls) {
        return Throwable.class.isAssignableFrom(cls);
    }

    @Override // com.thoughtworks.xstream.converters.Converter
    public void marshal(Object obj, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {
        Throwable th = (Throwable) obj;
        if (th.getCause() == null) {
            try {
                th.initCause(null);
            } catch (IllegalStateException unused) {
            }
        }
        th.getStackTrace();
        getConverter().marshal(th, hierarchicalStreamWriter, marshallingContext);
    }

    private Converter getConverter() {
        Converter converter = this.defaultConverter;
        return converter != null ? converter : this.lookup.lookupConverterForType(Object.class);
    }

    @Override // com.thoughtworks.xstream.converters.Converter
    public Object unmarshal(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
        return getConverter().unmarshal(hierarchicalStreamReader, unmarshallingContext);
    }
}
