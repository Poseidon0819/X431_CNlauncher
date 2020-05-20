package com.thoughtworks.xstream.core;

import com.thoughtworks.xstream.converters.ConverterLookup;
import com.thoughtworks.xstream.mapper.Mapper;
import com.thoughtworks.xstream.p366io.HierarchicalStreamReader;
import com.thoughtworks.xstream.p366io.HierarchicalStreamWriter;

/* loaded from: classes2.dex */
public class ReferenceByIdMarshallingStrategy extends AbstractTreeMarshallingStrategy {
    @Override // com.thoughtworks.xstream.core.AbstractTreeMarshallingStrategy
    protected TreeUnmarshaller createUnmarshallingContext(Object obj, HierarchicalStreamReader hierarchicalStreamReader, ConverterLookup converterLookup, Mapper mapper) {
        return new ReferenceByIdUnmarshaller(obj, hierarchicalStreamReader, converterLookup, mapper);
    }

    @Override // com.thoughtworks.xstream.core.AbstractTreeMarshallingStrategy
    protected TreeMarshaller createMarshallingContext(HierarchicalStreamWriter hierarchicalStreamWriter, ConverterLookup converterLookup, Mapper mapper) {
        return new ReferenceByIdMarshaller(hierarchicalStreamWriter, converterLookup, mapper);
    }
}
