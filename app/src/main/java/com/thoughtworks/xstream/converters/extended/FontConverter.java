package com.thoughtworks.xstream.converters.extended;

import com.itextpdf.text.html.HtmlTags;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.SingleValueConverter;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.core.JVM;
import com.thoughtworks.xstream.mapper.Mapper;
import com.thoughtworks.xstream.p366io.ExtendedHierarchicalStreamWriterHelper;
import com.thoughtworks.xstream.p366io.HierarchicalStreamReader;
import com.thoughtworks.xstream.p366io.HierarchicalStreamWriter;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.plaf.FontUIResource;

/* loaded from: classes2.dex */
public class FontConverter implements Converter {
    private final Mapper mapper;
    private final SingleValueConverter textAttributeConverter;

    public FontConverter() {
        this(null);
    }

    public FontConverter(Mapper mapper) {
        this.mapper = mapper;
        if (mapper == null) {
            this.textAttributeConverter = null;
        } else {
            this.textAttributeConverter = new TextAttributeConverter();
        }
    }

    @Override // com.thoughtworks.xstream.converters.ConverterMatcher
    public boolean canConvert(Class cls) {
        return cls.getName().equals("java.awt.Font") || cls.getName().equals("javax.swing.plaf.FontUIResource");
    }

    @Override // com.thoughtworks.xstream.converters.Converter
    public void marshal(Object obj, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {
        Map attributes = ((Font) obj).getAttributes();
        Mapper mapper = this.mapper;
        if (mapper != null) {
            String aliasForSystemAttribute = mapper.aliasForSystemAttribute(HtmlTags.CLASS);
            for (Map.Entry entry : attributes.entrySet()) {
                String singleValueConverter = this.textAttributeConverter.toString(entry.getKey());
                Object value = entry.getValue();
                Class cls = value != null ? value.getClass() : Mapper.Null.class;
                ExtendedHierarchicalStreamWriterHelper.startNode(hierarchicalStreamWriter, singleValueConverter, cls);
                hierarchicalStreamWriter.addAttribute(aliasForSystemAttribute, this.mapper.serializedClass(cls));
                if (value != null) {
                    marshallingContext.convertAnother(value);
                }
                hierarchicalStreamWriter.endNode();
            }
            return;
        }
        hierarchicalStreamWriter.startNode("attributes");
        marshallingContext.convertAnother(attributes);
        hierarchicalStreamWriter.endNode();
    }

    @Override // com.thoughtworks.xstream.converters.Converter
    public Object unmarshal(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
        Map map;
        if (hierarchicalStreamReader.hasMoreChildren()) {
            hierarchicalStreamReader.moveDown();
            if (!hierarchicalStreamReader.getNodeName().equals("attributes")) {
                String aliasForSystemAttribute = this.mapper.aliasForSystemAttribute(HtmlTags.CLASS);
                map = new HashMap();
                do {
                    if (!map.isEmpty()) {
                        hierarchicalStreamReader.moveDown();
                    }
                    Class realClass = this.mapper.realClass(hierarchicalStreamReader.getAttribute(aliasForSystemAttribute));
                    map.put((TextAttribute) this.textAttributeConverter.fromString(hierarchicalStreamReader.getNodeName()), realClass == Mapper.Null.class ? null : unmarshallingContext.convertAnother(null, realClass));
                    hierarchicalStreamReader.moveUp();
                } while (hierarchicalStreamReader.hasMoreChildren());
            } else {
                map = (Map) unmarshallingContext.convertAnother(null, Map.class);
                hierarchicalStreamReader.moveUp();
            }
        } else {
            map = Collections.EMPTY_MAP;
        }
        if (!JVM.is16()) {
            Iterator it = map.values().iterator();
            while (it.hasNext()) {
                if (it.next() == null) {
                    it.remove();
                }
            }
        }
        Font font = Font.getFont(map);
        return unmarshallingContext.getRequiredType() == FontUIResource.class ? new FontUIResource(font) : font;
    }
}
