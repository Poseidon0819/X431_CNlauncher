package com.thoughtworks.xstream.core;

import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.ConverterLookup;
import com.thoughtworks.xstream.core.util.FastStack;
import com.thoughtworks.xstream.mapper.Mapper;
import com.thoughtworks.xstream.p366io.HierarchicalStreamReader;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class AbstractReferenceUnmarshaller extends TreeUnmarshaller {
    private static final Object NULL = new Object();
    private FastStack parentStack;
    private Map values;

    protected abstract Object getCurrentReferenceKey();

    protected abstract Object getReferenceKey(String str);

    public AbstractReferenceUnmarshaller(Object obj, HierarchicalStreamReader hierarchicalStreamReader, ConverterLookup converterLookup, Mapper mapper) {
        super(obj, hierarchicalStreamReader, converterLookup, mapper);
        this.values = new HashMap();
        this.parentStack = new FastStack(16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.thoughtworks.xstream.core.TreeUnmarshaller
    public Object convert(Object obj, Class cls, Converter converter) {
        Object peek;
        if (this.parentStack.size() > 0 && (peek = this.parentStack.peek()) != null && !this.values.containsKey(peek)) {
            this.values.put(peek, obj);
        }
        String aliasForSystemAttribute = getMapper().aliasForSystemAttribute("reference");
        String attribute = aliasForSystemAttribute == null ? null : this.reader.getAttribute(aliasForSystemAttribute);
        if (attribute != null) {
            Object obj2 = this.values.get(getReferenceKey(attribute));
            if (obj2 == null) {
                ConversionException conversionException = new ConversionException("Invalid reference");
                conversionException.add("reference", attribute);
                throw conversionException;
            } else if (obj2 == NULL) {
                return null;
            } else {
                return obj2;
            }
        }
        Object currentReferenceKey = getCurrentReferenceKey();
        this.parentStack.push(currentReferenceKey);
        Object convert = super.convert(obj, cls, converter);
        if (currentReferenceKey != null) {
            this.values.put(currentReferenceKey, convert == null ? NULL : convert);
        }
        this.parentStack.popSilently();
        return convert;
    }
}
