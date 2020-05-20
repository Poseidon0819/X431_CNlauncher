package com.thoughtworks.xstream.converters.extended;

import com.itextpdf.text.html.HtmlTags;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.converters.collections.CollectionConverter;
import com.thoughtworks.xstream.core.util.HierarchicalStreams;
import com.thoughtworks.xstream.mapper.Mapper;
import com.thoughtworks.xstream.p366io.ExtendedHierarchicalStreamWriterHelper;
import com.thoughtworks.xstream.p366io.HierarchicalStreamReader;
import com.thoughtworks.xstream.p366io.HierarchicalStreamWriter;

/* loaded from: classes2.dex */
public class NamedCollectionConverter extends CollectionConverter {
    private final String name;
    private final Class type;

    public NamedCollectionConverter(Mapper mapper, String str, Class cls) {
        this(null, mapper, str, cls);
    }

    public NamedCollectionConverter(Class cls, Mapper mapper, String str, Class cls2) {
        super(mapper, cls);
        this.name = str;
        this.type = cls2;
    }

    @Override // com.thoughtworks.xstream.converters.collections.AbstractCollectionConverter
    public void writeItem(Object obj, MarshallingContext marshallingContext, HierarchicalStreamWriter hierarchicalStreamWriter) {
        String aliasForSystemAttribute;
        Class cls = obj == null ? Mapper.Null.class : obj.getClass();
        ExtendedHierarchicalStreamWriterHelper.startNode(hierarchicalStreamWriter, this.name, cls);
        if (!cls.equals(this.type) && (aliasForSystemAttribute = mapper().aliasForSystemAttribute(HtmlTags.CLASS)) != null) {
            hierarchicalStreamWriter.addAttribute(aliasForSystemAttribute, mapper().serializedClass(cls));
        }
        if (obj != null) {
            marshallingContext.convertAnother(obj);
        }
        hierarchicalStreamWriter.endNode();
    }

    @Override // com.thoughtworks.xstream.converters.collections.AbstractCollectionConverter
    public Object readItem(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext, Object obj) {
        String readClassAttribute = HierarchicalStreams.readClassAttribute(hierarchicalStreamReader, mapper());
        Class realClass = readClassAttribute == null ? this.type : mapper().realClass(readClassAttribute);
        if (Mapper.Null.class.equals(realClass)) {
            return null;
        }
        return unmarshallingContext.convertAnother(obj, realClass);
    }
}
