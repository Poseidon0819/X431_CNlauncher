package com.thoughtworks.xstream.converters.collections;

import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.core.util.HierarchicalStreams;
import com.thoughtworks.xstream.mapper.Mapper;
import com.thoughtworks.xstream.p366io.ExtendedHierarchicalStreamWriterHelper;
import com.thoughtworks.xstream.p366io.HierarchicalStreamReader;
import com.thoughtworks.xstream.p366io.HierarchicalStreamWriter;

/* loaded from: classes2.dex */
public abstract class AbstractCollectionConverter implements Converter {
    private final Mapper mapper;

    @Override // com.thoughtworks.xstream.converters.ConverterMatcher
    public abstract boolean canConvert(Class cls);

    @Override // com.thoughtworks.xstream.converters.Converter
    public abstract void marshal(Object obj, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext);

    @Override // com.thoughtworks.xstream.converters.Converter
    public abstract Object unmarshal(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext);

    public AbstractCollectionConverter(Mapper mapper) {
        this.mapper = mapper;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Mapper mapper() {
        return this.mapper;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void writeItem(Object obj, MarshallingContext marshallingContext, HierarchicalStreamWriter hierarchicalStreamWriter) {
        if (obj == null) {
            ExtendedHierarchicalStreamWriterHelper.startNode(hierarchicalStreamWriter, mapper().serializedClass(null), Mapper.Null.class);
            hierarchicalStreamWriter.endNode();
            return;
        }
        ExtendedHierarchicalStreamWriterHelper.startNode(hierarchicalStreamWriter, mapper().serializedClass(obj.getClass()), obj.getClass());
        marshallingContext.convertAnother(obj);
        hierarchicalStreamWriter.endNode();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object readItem(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext, Object obj) {
        return unmarshallingContext.convertAnother(obj, HierarchicalStreams.readClassType(hierarchicalStreamReader, mapper()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object createCollection(Class cls) {
        Class defaultImplementationOf = mapper().defaultImplementationOf(cls);
        try {
            return defaultImplementationOf.newInstance();
        } catch (IllegalAccessException e) {
            throw new ConversionException("Cannot instantiate " + defaultImplementationOf.getName(), e);
        } catch (InstantiationException e2) {
            throw new ConversionException("Cannot instantiate " + defaultImplementationOf.getName(), e2);
        }
    }
}
