package com.thoughtworks.xstream.converters.extended;

import com.itextpdf.text.html.HtmlTags;
import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.ConverterLookup;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.SingleValueConverter;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.converters.collections.MapConverter;
import com.thoughtworks.xstream.core.JVM;
import com.thoughtworks.xstream.core.util.HierarchicalStreams;
import com.thoughtworks.xstream.mapper.Mapper;
import com.thoughtworks.xstream.p366io.ExtendedHierarchicalStreamWriterHelper;
import com.thoughtworks.xstream.p366io.HierarchicalStreamReader;
import com.thoughtworks.xstream.p366io.HierarchicalStreamWriter;
import java.util.Map;

/* loaded from: classes2.dex */
public class NamedMapConverter extends MapConverter {
    private final String entryName;
    private final Mapper enumMapper;
    private final boolean keyAsAttribute;
    private final String keyName;
    private final Class keyType;
    private final ConverterLookup lookup;
    private final boolean valueAsAttribute;
    private final String valueName;
    private final Class valueType;

    public NamedMapConverter(Mapper mapper, String str, String str2, Class cls, String str3, Class cls2) {
        this(mapper, str, str2, cls, str3, cls2, false, false, null);
    }

    public NamedMapConverter(Class cls, Mapper mapper, String str, String str2, Class cls2, String str3, Class cls3) {
        this(cls, mapper, str, str2, cls2, str3, cls3, false, false, null);
    }

    public NamedMapConverter(Mapper mapper, String str, String str2, Class cls, String str3, Class cls2, boolean z, boolean z2, ConverterLookup converterLookup) {
        this(null, mapper, str, str2, cls, str3, cls2, z, z2, converterLookup);
    }

    public NamedMapConverter(Class cls, Mapper mapper, String str, String str2, Class cls2, String str3, Class cls3, boolean z, boolean z2, ConverterLookup converterLookup) {
        super(mapper, cls);
        this.entryName = (str == null || str.length() != 0) ? str : null;
        this.keyName = (str2 == null || str2.length() != 0) ? str2 : null;
        this.keyType = cls2;
        this.valueName = (str3 == null || str3.length() != 0) ? str3 : null;
        this.valueType = cls3;
        this.keyAsAttribute = z;
        this.valueAsAttribute = z2;
        this.lookup = converterLookup;
        this.enumMapper = JVM.is15() ? UseAttributeForEnumMapper.createEnumMapper(mapper) : null;
        if (cls2 == null || cls3 == null) {
            throw new IllegalArgumentException("Class types of key and value are mandatory");
        }
        if (str == null) {
            if (z || z2) {
                throw new IllegalArgumentException("Cannot write attributes to map entry, if map entry must be omitted");
            }
            if (str3 == null) {
                throw new IllegalArgumentException("Cannot write value as text of entry, if entry must be omitted");
            }
        }
        if (str2 == null) {
            throw new IllegalArgumentException("Cannot write key without name");
        }
        if (str3 == null) {
            if (z2) {
                throw new IllegalArgumentException("Cannot write value as attribute without name");
            }
            if (!z) {
                throw new IllegalArgumentException("Cannot write value as text of entry, if key is also child element");
            }
        }
        if (z && z2 && str2.equals(str3)) {
            throw new IllegalArgumentException("Cannot write key and value with same attribute name");
        }
    }

    @Override // com.thoughtworks.xstream.converters.collections.MapConverter, com.thoughtworks.xstream.converters.collections.AbstractCollectionConverter, com.thoughtworks.xstream.converters.Converter
    public void marshal(Object obj, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {
        Map map = (Map) obj;
        SingleValueConverter singleValueConverter = this.keyAsAttribute ? getSingleValueConverter(this.keyType) : null;
        SingleValueConverter singleValueConverter2 = (this.valueAsAttribute || this.valueName == null) ? getSingleValueConverter(this.valueType) : null;
        for (Map.Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            String str = this.entryName;
            if (str != null) {
                ExtendedHierarchicalStreamWriterHelper.startNode(hierarchicalStreamWriter, str, entry.getClass());
                if (singleValueConverter != null && key != null) {
                    hierarchicalStreamWriter.addAttribute(this.keyName, singleValueConverter.toString(key));
                }
                String str2 = this.valueName;
                if (str2 != null && singleValueConverter2 != null && value != null) {
                    hierarchicalStreamWriter.addAttribute(str2, singleValueConverter2.toString(value));
                }
            }
            if (singleValueConverter == null) {
                writeItem(this.keyName, this.keyType, key, marshallingContext, hierarchicalStreamWriter);
            }
            if (singleValueConverter2 == null) {
                writeItem(this.valueName, this.valueType, value, marshallingContext, hierarchicalStreamWriter);
            } else if (this.valueName == null) {
                hierarchicalStreamWriter.setValue(singleValueConverter2.toString(value));
            }
            if (this.entryName != null) {
                hierarchicalStreamWriter.endNode();
            }
        }
    }

    @Override // com.thoughtworks.xstream.converters.collections.MapConverter
    public void populateMap(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext, Map map, Map map2) {
        Object obj;
        Object obj2;
        String attribute;
        String attribute2;
        SingleValueConverter singleValueConverter = this.keyAsAttribute ? getSingleValueConverter(this.keyType) : null;
        SingleValueConverter singleValueConverter2 = (this.valueAsAttribute || this.valueName == null) ? getSingleValueConverter(this.valueType) : null;
        while (hierarchicalStreamReader.hasMoreChildren()) {
            if (this.entryName != null) {
                hierarchicalStreamReader.moveDown();
                obj = (singleValueConverter == null || (attribute2 = hierarchicalStreamReader.getAttribute(this.keyName)) == null) ? null : singleValueConverter.fromString(attribute2);
                obj2 = (!this.valueAsAttribute || singleValueConverter2 == null || (attribute = hierarchicalStreamReader.getAttribute(this.valueName)) == null) ? null : singleValueConverter2.fromString(attribute);
            } else {
                obj = null;
                obj2 = null;
            }
            if (singleValueConverter == null) {
                hierarchicalStreamReader.moveDown();
                if (singleValueConverter2 == null && !this.keyName.equals(this.valueName) && hierarchicalStreamReader.getNodeName().equals(this.valueName)) {
                    obj2 = readItem(this.valueType, hierarchicalStreamReader, unmarshallingContext, map);
                } else {
                    obj = readItem(this.keyType, hierarchicalStreamReader, unmarshallingContext, map);
                }
                hierarchicalStreamReader.moveUp();
            }
            if (singleValueConverter2 == null) {
                hierarchicalStreamReader.moveDown();
                if (singleValueConverter == null && obj == null && obj2 != null) {
                    obj = readItem(this.keyType, hierarchicalStreamReader, unmarshallingContext, map);
                } else {
                    obj2 = readItem(this.valueType, hierarchicalStreamReader, unmarshallingContext, map);
                }
                hierarchicalStreamReader.moveUp();
            } else if (!this.valueAsAttribute) {
                obj2 = hierarchicalStreamReader.getValue();
            }
            map2.put(obj, obj2);
            if (this.entryName != null) {
                hierarchicalStreamReader.moveUp();
            }
        }
    }

    private SingleValueConverter getSingleValueConverter(Class cls) {
        SingleValueConverter converterFromItemType = (UseAttributeForEnumMapper.isEnum(cls) ? this.enumMapper : mapper()).getConverterFromItemType(null, cls, null);
        if (converterFromItemType == null) {
            Converter lookupConverterForType = this.lookup.lookupConverterForType(cls);
            if (lookupConverterForType instanceof SingleValueConverter) {
                return (SingleValueConverter) lookupConverterForType;
            }
            throw new ConversionException("No SingleValueConverter for key available");
        }
        return converterFromItemType;
    }

    protected void writeItem(String str, Class cls, Object obj, MarshallingContext marshallingContext, HierarchicalStreamWriter hierarchicalStreamWriter) {
        String aliasForSystemAttribute;
        Class cls2 = obj == null ? Mapper.Null.class : obj.getClass();
        ExtendedHierarchicalStreamWriterHelper.startNode(hierarchicalStreamWriter, str, cls2);
        if (!cls2.equals(cls) && (aliasForSystemAttribute = mapper().aliasForSystemAttribute(HtmlTags.CLASS)) != null) {
            hierarchicalStreamWriter.addAttribute(aliasForSystemAttribute, mapper().serializedClass(cls2));
        }
        if (obj != null) {
            marshallingContext.convertAnother(obj);
        }
        hierarchicalStreamWriter.endNode();
    }

    protected Object readItem(Class cls, HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext, Object obj) {
        String readClassAttribute = HierarchicalStreams.readClassAttribute(hierarchicalStreamReader, mapper());
        if (readClassAttribute != null) {
            cls = mapper().realClass(readClassAttribute);
        }
        if (Mapper.Null.class.equals(cls)) {
            return null;
        }
        return unmarshallingContext.convertAnother(obj, cls);
    }
}
