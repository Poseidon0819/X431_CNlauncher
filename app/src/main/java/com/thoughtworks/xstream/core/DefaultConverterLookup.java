package com.thoughtworks.xstream.core;

import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.ConverterLookup;
import com.thoughtworks.xstream.converters.ConverterRegistry;
import com.thoughtworks.xstream.core.util.PrioritizedList;
import com.thoughtworks.xstream.mapper.Mapper;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes2.dex */
public class DefaultConverterLookup implements ConverterLookup, ConverterRegistry, Caching {
    private final PrioritizedList converters = new PrioritizedList();
    private transient Map typeToConverterMap;

    public DefaultConverterLookup() {
        readResolve();
    }

    public DefaultConverterLookup(Mapper mapper) {
    }

    @Override // com.thoughtworks.xstream.converters.ConverterLookup
    public Converter lookupConverterForType(Class cls) {
        Converter converter = (Converter) this.typeToConverterMap.get(cls);
        if (converter != null) {
            return converter;
        }
        Iterator it = this.converters.iterator();
        while (it.hasNext()) {
            Converter converter2 = (Converter) it.next();
            if (converter2.canConvert(cls)) {
                this.typeToConverterMap.put(cls, converter2);
                return converter2;
            }
        }
        throw new ConversionException("No converter specified for ".concat(String.valueOf(cls)));
    }

    @Override // com.thoughtworks.xstream.converters.ConverterRegistry
    public void registerConverter(Converter converter, int i) {
        this.converters.add(converter, i);
        Iterator it = this.typeToConverterMap.keySet().iterator();
        while (it.hasNext()) {
            if (converter.canConvert((Class) it.next())) {
                it.remove();
            }
        }
    }

    @Override // com.thoughtworks.xstream.core.Caching
    public void flushCache() {
        this.typeToConverterMap.clear();
        Iterator it = this.converters.iterator();
        while (it.hasNext()) {
            Converter converter = (Converter) it.next();
            if (converter instanceof Caching) {
                ((Caching) converter).flushCache();
            }
        }
    }

    private Object readResolve() {
        this.typeToConverterMap = Collections.synchronizedMap(new WeakHashMap());
        return this;
    }
}
