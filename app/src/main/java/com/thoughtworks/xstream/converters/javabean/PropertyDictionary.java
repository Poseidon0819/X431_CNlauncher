package com.thoughtworks.xstream.converters.javabean;

import com.thoughtworks.xstream.converters.reflection.MissingFieldException;
import com.thoughtworks.xstream.converters.reflection.ObjectAccessException;
import com.thoughtworks.xstream.core.Caching;
import com.thoughtworks.xstream.core.util.OrderRetainingMap;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public class PropertyDictionary implements Caching {
    private transient Map propertyNameCache;
    private final PropertySorter sorter;

    public PropertyDictionary() {
        this(new NativePropertySorter());
    }

    public PropertyDictionary(PropertySorter propertySorter) {
        this.propertyNameCache = Collections.synchronizedMap(new HashMap());
        this.sorter = propertySorter;
    }

    public Iterator serializablePropertiesFor(Class cls) {
        ArrayList arrayList = new ArrayList();
        for (PropertyDescriptor propertyDescriptor : buildMap(cls).values()) {
            if (propertyDescriptor.getReadMethod() != null && propertyDescriptor.getWriteMethod() != null) {
                arrayList.add(new BeanProperty(cls, propertyDescriptor.getName(), propertyDescriptor.getPropertyType()));
            }
        }
        return arrayList.iterator();
    }

    public BeanProperty property(Class cls, String str) {
        PropertyDescriptor propertyDescriptor = (PropertyDescriptor) buildMap(cls).get(str);
        if (propertyDescriptor == null) {
            throw new MissingFieldException(cls.getName(), str);
        }
        if (propertyDescriptor.getReadMethod() == null || propertyDescriptor.getWriteMethod() == null) {
            return null;
        }
        return new BeanProperty(cls, propertyDescriptor.getName(), propertyDescriptor.getPropertyType());
    }

    public Iterator propertiesFor(Class cls) {
        return buildMap(cls).values().iterator();
    }

    public PropertyDescriptor propertyDescriptor(Class cls, String str) {
        PropertyDescriptor propertyDescriptor = (PropertyDescriptor) buildMap(cls).get(str);
        if (propertyDescriptor != null) {
            return propertyDescriptor;
        }
        throw new MissingFieldException(cls.getName(), str);
    }

    private Map buildMap(Class cls) {
        PropertyDescriptor[] propertyDescriptors;
        Map map = (Map) this.propertyNameCache.get(cls);
        if (map == null) {
            try {
                BeanInfo beanInfo = Introspector.getBeanInfo(cls, Object.class);
                OrderRetainingMap orderRetainingMap = new OrderRetainingMap();
                for (PropertyDescriptor propertyDescriptor : beanInfo.getPropertyDescriptors()) {
                    orderRetainingMap.put(propertyDescriptor.getName(), propertyDescriptor);
                }
                Map sort = this.sorter.sort(cls, orderRetainingMap);
                this.propertyNameCache.put(cls, sort);
                return sort;
            } catch (IntrospectionException e) {
                throw new ObjectAccessException("Cannot get BeanInfo of type " + cls.getName(), e);
            }
        }
        return map;
    }

    @Override // com.thoughtworks.xstream.core.Caching
    public void flushCache() {
        this.propertyNameCache.clear();
    }
}
