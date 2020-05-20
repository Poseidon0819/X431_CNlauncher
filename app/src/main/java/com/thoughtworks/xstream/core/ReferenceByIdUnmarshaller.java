package com.thoughtworks.xstream.core;

import com.thoughtworks.xstream.converters.ConverterLookup;
import com.thoughtworks.xstream.mapper.Mapper;
import com.thoughtworks.xstream.p366io.HierarchicalStreamReader;

/* loaded from: classes2.dex */
public class ReferenceByIdUnmarshaller extends AbstractReferenceUnmarshaller {
    @Override // com.thoughtworks.xstream.core.AbstractReferenceUnmarshaller
    protected Object getReferenceKey(String str) {
        return str;
    }

    public ReferenceByIdUnmarshaller(Object obj, HierarchicalStreamReader hierarchicalStreamReader, ConverterLookup converterLookup, Mapper mapper) {
        super(obj, hierarchicalStreamReader, converterLookup, mapper);
    }

    @Override // com.thoughtworks.xstream.core.AbstractReferenceUnmarshaller
    protected Object getCurrentReferenceKey() {
        String aliasForSystemAttribute = getMapper().aliasForSystemAttribute("id");
        if (aliasForSystemAttribute == null) {
            return null;
        }
        return this.reader.getAttribute(aliasForSystemAttribute);
    }
}
