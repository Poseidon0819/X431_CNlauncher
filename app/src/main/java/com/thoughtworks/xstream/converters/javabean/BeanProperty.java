package com.thoughtworks.xstream.converters.javabean;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.UndeclaredThrowableException;

/* loaded from: classes2.dex */
public class BeanProperty {
    private static final Object[] EMPTY_ARGS = new Object[0];
    protected Method getter;
    private Class memberClass;
    private String propertyName;
    private Method setter;
    private Class type;

    public BeanProperty(Class cls, String str, Class cls2) {
        this.memberClass = cls;
        this.propertyName = str;
        this.type = cls2;
    }

    public Class getBeanClass() {
        return this.memberClass;
    }

    public Class getType() {
        return this.type;
    }

    public String getName() {
        return this.propertyName;
    }

    public boolean isReadable() {
        return this.getter != null;
    }

    public boolean isWritable() {
        return this.setter != null;
    }

    public Object get(Object obj) throws IllegalArgumentException, IllegalAccessException {
        if (!isReadable()) {
            throw new IllegalStateException("Property " + this.propertyName + " of " + this.memberClass + " not readable");
        }
        try {
            return this.getter.invoke(obj, EMPTY_ARGS);
        } catch (InvocationTargetException e) {
            throw new UndeclaredThrowableException(e.getTargetException());
        }
    }

    public Object set(Object obj, Object obj2) throws IllegalArgumentException, IllegalAccessException {
        if (!isWritable()) {
            throw new IllegalStateException("Property " + this.propertyName + " of " + this.memberClass + " not writable");
        }
        try {
            return this.setter.invoke(obj, obj2);
        } catch (InvocationTargetException e) {
            throw new UndeclaredThrowableException(e.getTargetException());
        }
    }

    public void setGetterMethod(Method method) {
        this.getter = method;
    }

    public void setSetterMethod(Method method) {
        this.setter = method;
    }
}
