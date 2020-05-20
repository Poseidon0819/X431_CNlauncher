package com.thoughtworks.xstream.core;

import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.ConverterLookup;
import com.thoughtworks.xstream.converters.DataHolder;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.core.util.ObjectIdDictionary;
import com.thoughtworks.xstream.mapper.Mapper;
import com.thoughtworks.xstream.p366io.ExtendedHierarchicalStreamWriterHelper;
import com.thoughtworks.xstream.p366io.HierarchicalStreamWriter;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class TreeMarshaller implements MarshallingContext {
    protected ConverterLookup converterLookup;
    private DataHolder dataHolder;
    private Mapper mapper;
    private ObjectIdDictionary parentObjects = new ObjectIdDictionary();
    protected HierarchicalStreamWriter writer;

    public TreeMarshaller(HierarchicalStreamWriter hierarchicalStreamWriter, ConverterLookup converterLookup, Mapper mapper) {
        this.writer = hierarchicalStreamWriter;
        this.converterLookup = converterLookup;
        this.mapper = mapper;
    }

    @Override // com.thoughtworks.xstream.converters.MarshallingContext
    public void convertAnother(Object obj) {
        convertAnother(obj, null);
    }

    @Override // com.thoughtworks.xstream.converters.MarshallingContext
    public void convertAnother(Object obj, Converter converter) {
        if (converter == null) {
            converter = this.converterLookup.lookupConverterForType(obj.getClass());
        } else if (!converter.canConvert(obj.getClass())) {
            ConversionException conversionException = new ConversionException("Explicit selected converter cannot handle item");
            conversionException.add("item-type", obj.getClass().getName());
            conversionException.add("converter-type", converter.getClass().getName());
            throw conversionException;
        }
        convert(obj, converter);
    }

    protected void convert(Object obj, Converter converter) {
        if (this.parentObjects.containsId(obj)) {
            CircularReferenceException circularReferenceException = new CircularReferenceException("Recursive reference to parent object");
            circularReferenceException.add("item-type", obj.getClass().getName());
            circularReferenceException.add("converter-type", converter.getClass().getName());
            throw circularReferenceException;
        }
        this.parentObjects.associateId(obj, "");
        converter.marshal(obj, this.writer, this);
        this.parentObjects.removeId(obj);
    }

    public void start(Object obj, DataHolder dataHolder) {
        this.dataHolder = dataHolder;
        if (obj == null) {
            this.writer.startNode(this.mapper.serializedClass(null));
            this.writer.endNode();
            return;
        }
        ExtendedHierarchicalStreamWriterHelper.startNode(this.writer, this.mapper.serializedClass(obj.getClass()), obj.getClass());
        convertAnother(obj);
        this.writer.endNode();
    }

    @Override // com.thoughtworks.xstream.converters.DataHolder
    public Object get(Object obj) {
        lazilyCreateDataHolder();
        return this.dataHolder.get(obj);
    }

    @Override // com.thoughtworks.xstream.converters.DataHolder
    public void put(Object obj, Object obj2) {
        lazilyCreateDataHolder();
        this.dataHolder.put(obj, obj2);
    }

    @Override // com.thoughtworks.xstream.converters.DataHolder
    public Iterator keys() {
        lazilyCreateDataHolder();
        return this.dataHolder.keys();
    }

    private void lazilyCreateDataHolder() {
        if (this.dataHolder == null) {
            this.dataHolder = new MapBackedDataHolder();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Mapper getMapper() {
        return this.mapper;
    }

    /* loaded from: classes2.dex */
    public static class CircularReferenceException extends ConversionException {
        public CircularReferenceException(String str) {
            super(str);
        }
    }
}
