package com.thoughtworks.xstream.converters.javabean;

import com.thoughtworks.xstream.converters.javabean.JavaBeanProvider;
import com.thoughtworks.xstream.converters.reflection.ObjectAccessException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class BeanProvider implements JavaBeanProvider {
    protected static final Object[] NO_PARAMS = new Object[0];
    protected PropertyDictionary propertyDictionary;

    /* loaded from: classes2.dex */
    public interface Visitor extends JavaBeanProvider.Visitor {
    }

    public BeanProvider() {
        this(new PropertyDictionary(new NativePropertySorter()));
    }

    public BeanProvider(Comparator comparator) {
        this(new PropertyDictionary(new ComparingPropertySorter(comparator)));
    }

    public BeanProvider(PropertyDictionary propertyDictionary) {
        this.propertyDictionary = propertyDictionary;
    }

    @Override // com.thoughtworks.xstream.converters.javabean.JavaBeanProvider
    public Object newInstance(Class cls) {
        try {
            return getDefaultConstrutor(cls).newInstance(NO_PARAMS);
        } catch (IllegalAccessException e) {
            throw new ObjectAccessException("Cannot construct " + cls.getName(), e);
        } catch (InstantiationException e2) {
            throw new ObjectAccessException("Cannot construct " + cls.getName(), e2);
        } catch (InvocationTargetException e3) {
            if (e3.getTargetException() instanceof RuntimeException) {
                throw ((RuntimeException) e3.getTargetException());
            }
            if (e3.getTargetException() instanceof Error) {
                throw ((Error) e3.getTargetException());
            }
            throw new ObjectAccessException("Constructor for " + cls.getName() + " threw an exception", e3);
        }
    }

    @Override // com.thoughtworks.xstream.converters.javabean.JavaBeanProvider
    public void visitSerializableProperties(Object obj, JavaBeanProvider.Visitor visitor) {
        PropertyDescriptor[] serializableProperties;
        for (PropertyDescriptor propertyDescriptor : getSerializableProperties(obj)) {
            try {
                Method readMethod = propertyDescriptor.getReadMethod();
                String name = propertyDescriptor.getName();
                Class<?> declaringClass = readMethod.getDeclaringClass();
                if (visitor.shouldVisit(name, declaringClass)) {
                    visitor.visit(name, propertyDescriptor.getPropertyType(), declaringClass, readMethod.invoke(obj, new Object[0]));
                }
            } catch (IllegalAccessException e) {
                throw new ObjectAccessException("Could not get property " + obj.getClass() + "." + propertyDescriptor.getName(), e);
            } catch (IllegalArgumentException e2) {
                throw new ObjectAccessException("Could not get property " + obj.getClass() + "." + propertyDescriptor.getName(), e2);
            } catch (InvocationTargetException e3) {
                throw new ObjectAccessException("Could not get property " + obj.getClass() + "." + propertyDescriptor.getName(), e3);
            }
        }
    }

    @Override // com.thoughtworks.xstream.converters.javabean.JavaBeanProvider
    public void writeProperty(Object obj, String str, Object obj2) {
        PropertyDescriptor property = getProperty(str, obj.getClass());
        try {
            property.getWriteMethod().invoke(obj, obj2);
        } catch (IllegalAccessException e) {
            throw new ObjectAccessException("Could not set property " + obj.getClass() + "." + property.getName(), e);
        } catch (IllegalArgumentException e2) {
            throw new ObjectAccessException("Could not set property " + obj.getClass() + "." + property.getName(), e2);
        } catch (InvocationTargetException e3) {
            throw new ObjectAccessException("Could not set property " + obj.getClass() + "." + property.getName(), e3);
        }
    }

    @Override // com.thoughtworks.xstream.converters.javabean.JavaBeanProvider
    public Class getPropertyType(Object obj, String str) {
        return getProperty(str, obj.getClass()).getPropertyType();
    }

    @Override // com.thoughtworks.xstream.converters.javabean.JavaBeanProvider
    public boolean propertyDefinedInClass(String str, Class cls) {
        return getProperty(str, cls) != null;
    }

    @Override // com.thoughtworks.xstream.converters.javabean.JavaBeanProvider
    public boolean canInstantiate(Class cls) {
        return getDefaultConstrutor(cls) != null;
    }

    protected Constructor getDefaultConstrutor(Class cls) {
        Constructor<?>[] constructors;
        for (Constructor<?> constructor : cls.getConstructors()) {
            if (constructor.getParameterTypes().length == 0 && Modifier.isPublic(constructor.getModifiers())) {
                return constructor;
            }
        }
        return null;
    }

    protected PropertyDescriptor[] getSerializableProperties(Object obj) {
        ArrayList arrayList = new ArrayList();
        Iterator propertiesFor = this.propertyDictionary.propertiesFor(obj.getClass());
        while (propertiesFor.hasNext()) {
            PropertyDescriptor propertyDescriptor = (PropertyDescriptor) propertiesFor.next();
            if (canStreamProperty(propertyDescriptor)) {
                arrayList.add(propertyDescriptor);
            }
        }
        return (PropertyDescriptor[]) arrayList.toArray(new PropertyDescriptor[arrayList.size()]);
    }

    protected boolean canStreamProperty(PropertyDescriptor propertyDescriptor) {
        return (propertyDescriptor.getReadMethod() == null || propertyDescriptor.getWriteMethod() == null) ? false : true;
    }

    public boolean propertyWriteable(String str, Class cls) {
        return getProperty(str, cls).getWriteMethod() != null;
    }

    protected PropertyDescriptor getProperty(String str, Class cls) {
        return this.propertyDictionary.propertyDescriptor(cls, str);
    }
}
