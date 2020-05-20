package com.thoughtworks.xstream.converters.reflection;

import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter;
import com.thoughtworks.xstream.core.util.Fields;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.text.AttributedCharacterIterator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public class AbstractAttributedCharacterIteratorAttributeConverter extends AbstractSingleValueConverter {
    private static final Method getName;
    private static final Map instanceMaps = new HashMap();
    private transient Map attributeMap;
    private final Class type;

    static {
        Method method = null;
        try {
            method = AttributedCharacterIterator.Attribute.class.getDeclaredMethod("getName", null);
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
        } catch (NoSuchMethodException | SecurityException unused) {
        }
        getName = method;
    }

    public AbstractAttributedCharacterIteratorAttributeConverter(Class cls) {
        if (!AttributedCharacterIterator.Attribute.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException(cls.getName() + " is not a " + AttributedCharacterIterator.Attribute.class.getName());
        }
        this.type = cls;
        readResolve();
    }

    @Override // com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter, com.thoughtworks.xstream.converters.ConverterMatcher
    public boolean canConvert(Class cls) {
        return cls == this.type;
    }

    @Override // com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter, com.thoughtworks.xstream.converters.SingleValueConverter
    public String toString(Object obj) {
        return getName((AttributedCharacterIterator.Attribute) obj);
    }

    private String getName(AttributedCharacterIterator.Attribute attribute) {
        Method method = getName;
        IllegalAccessException illegalAccessException = null;
        if (method != null) {
            try {
                return (String) method.invoke(attribute, null);
            } catch (IllegalAccessException e) {
                illegalAccessException = e;
            } catch (InvocationTargetException e2) {
                illegalAccessException = e2;
            }
        }
        String attribute2 = attribute.toString();
        String name = attribute.getClass().getName();
        if (attribute2.startsWith(name)) {
            return attribute2.substring(name.length() + 1, attribute2.length() - 1);
        }
        throw new ConversionException("Cannot find name of attribute of type ".concat(String.valueOf(name)), illegalAccessException);
    }

    @Override // com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter, com.thoughtworks.xstream.converters.SingleValueConverter
    public Object fromString(String str) {
        if (this.attributeMap.containsKey(str)) {
            return this.attributeMap.get(str);
        }
        throw new ConversionException("Cannot find attribute of type " + this.type.getName() + " with name " + str);
    }

    private Object readResolve() {
        this.attributeMap = (Map) instanceMaps.get(this.type.getName());
        if (this.attributeMap == null) {
            this.attributeMap = new HashMap();
            Field locate = Fields.locate(this.type, Map.class, true);
            if (locate != null) {
                try {
                    Map map = (Map) Fields.read(locate, null);
                    if (map != null) {
                        Iterator it = map.entrySet().iterator();
                        boolean z = true;
                        while (z && it.hasNext()) {
                            Map.Entry entry = (Map.Entry) it.next();
                            z = entry.getKey().getClass() == String.class && entry.getValue().getClass() == this.type;
                        }
                        if (z) {
                            this.attributeMap.putAll(map);
                        }
                    }
                } catch (ObjectAccessException unused) {
                }
            }
            if (this.attributeMap.isEmpty()) {
                try {
                    Field[] declaredFields = this.type.getDeclaredFields();
                    for (int i = 0; i < declaredFields.length; i++) {
                        if ((declaredFields[i].getType() == this.type) == Modifier.isStatic(declaredFields[i].getModifiers())) {
                            AttributedCharacterIterator.Attribute attribute = (AttributedCharacterIterator.Attribute) Fields.read(declaredFields[i], null);
                            this.attributeMap.put(toString(attribute), attribute);
                        }
                    }
                } catch (ObjectAccessException unused2) {
                    this.attributeMap.clear();
                } catch (SecurityException unused3) {
                    this.attributeMap.clear();
                }
            }
        }
        return this;
    }
}
