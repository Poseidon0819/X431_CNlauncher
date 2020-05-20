package com.thoughtworks.xstream;

import com.thoughtworks.xstream.converters.ConverterLookup;
import com.thoughtworks.xstream.converters.DataHolder;
import com.thoughtworks.xstream.mapper.Mapper;
import com.thoughtworks.xstream.p366io.HierarchicalStreamReader;
import com.thoughtworks.xstream.p366io.HierarchicalStreamWriter;

/* loaded from: classes2.dex */
public interface MarshallingStrategy {
    void marshal(HierarchicalStreamWriter hierarchicalStreamWriter, Object obj, ConverterLookup converterLookup, Mapper mapper, DataHolder dataHolder);

    Object unmarshal(Object obj, HierarchicalStreamReader hierarchicalStreamReader, DataHolder dataHolder, ConverterLookup converterLookup, Mapper mapper);
}
