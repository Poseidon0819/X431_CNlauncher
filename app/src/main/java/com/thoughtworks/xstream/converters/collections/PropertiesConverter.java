package com.thoughtworks.xstream.converters.collections;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.core.util.Fields;
import com.thoughtworks.xstream.p366io.HierarchicalStreamReader;
import com.thoughtworks.xstream.p366io.HierarchicalStreamWriter;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

/* loaded from: classes2.dex */
public class PropertiesConverter implements Converter {
    private static final Field defaultsField = Fields.locate(Properties.class, Properties.class, false);
    private final boolean sort;

    public PropertiesConverter() {
        this(false);
    }

    public PropertiesConverter(boolean z) {
        this.sort = z;
    }

    @Override // com.thoughtworks.xstream.converters.ConverterMatcher
    public boolean canConvert(Class cls) {
        return Properties.class == cls;
    }

    @Override // com.thoughtworks.xstream.converters.Converter
    public void marshal(Object obj, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {
        Properties properties;
        Properties properties2 = (Properties) obj;
        for (Map.Entry entry : (this.sort ? new TreeMap(properties2) : properties2).entrySet()) {
            hierarchicalStreamWriter.startNode("property");
            hierarchicalStreamWriter.addAttribute("name", entry.getKey().toString());
            hierarchicalStreamWriter.addAttribute("value", entry.getValue().toString());
            hierarchicalStreamWriter.endNode();
        }
        Field field = defaultsField;
        if (field == null || (properties = (Properties) Fields.read(field, properties2)) == null) {
            return;
        }
        hierarchicalStreamWriter.startNode("defaults");
        marshal(properties, hierarchicalStreamWriter, marshallingContext);
        hierarchicalStreamWriter.endNode();
    }

    @Override // com.thoughtworks.xstream.converters.Converter
    public Object unmarshal(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
        Properties properties = new Properties();
        Properties properties2 = null;
        while (hierarchicalStreamReader.hasMoreChildren()) {
            hierarchicalStreamReader.moveDown();
            if (hierarchicalStreamReader.getNodeName().equals("defaults")) {
                properties2 = (Properties) unmarshal(hierarchicalStreamReader, unmarshallingContext);
            } else {
                properties.setProperty(hierarchicalStreamReader.getAttribute("name"), hierarchicalStreamReader.getAttribute("value"));
            }
            hierarchicalStreamReader.moveUp();
        }
        if (properties2 == null) {
            return properties;
        }
        Properties properties3 = new Properties(properties2);
        properties3.putAll(properties);
        return properties3;
    }
}
