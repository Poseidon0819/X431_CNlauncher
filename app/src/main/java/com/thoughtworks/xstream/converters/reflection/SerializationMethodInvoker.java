package com.thoughtworks.xstream.converters.reflection;

import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.core.Caching;
import com.thoughtworks.xstream.core.util.FastField;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class SerializationMethodInvoker implements Caching {
    private Map cache = Collections.synchronizedMap(new HashMap());
    private static final Method NO_METHOD = new Object() { // from class: com.thoughtworks.xstream.converters.reflection.SerializationMethodInvoker.1
        private void noMethod() {
        }
    }.getClass().getDeclaredMethods()[0];
    private static final Object[] EMPTY_ARGS = new Object[0];
    private static final FastField[] OBJECT_TYPE_FIELDS = {new FastField(Object.class, "readResolve"), new FastField(Object.class, "writeReplace"), new FastField(Object.class, "readObject"), new FastField(Object.class, "writeObject")};

    public SerializationMethodInvoker() {
        int i = 0;
        while (true) {
            FastField[] fastFieldArr = OBJECT_TYPE_FIELDS;
            if (i >= fastFieldArr.length) {
                return;
            }
            this.cache.put(fastFieldArr[i], NO_METHOD);
            i++;
        }
    }

    public Object callReadResolve(Object obj) {
        if (obj == null) {
            return null;
        }
        Method method = getMethod(obj.getClass(), "readResolve", null, true);
        if (method != null) {
            try {
                return method.invoke(obj, EMPTY_ARGS);
            } catch (IllegalAccessException e) {
                throw new ObjectAccessException("Could not call " + obj.getClass().getName() + ".readResolve()", e);
            } catch (InvocationTargetException e2) {
                throw new ObjectAccessException("Could not call " + obj.getClass().getName() + ".readResolve()", e2.getTargetException());
            }
        }
        return obj;
    }

    public Object callWriteReplace(Object obj) {
        if (obj == null) {
            return null;
        }
        Method method = getMethod(obj.getClass(), "writeReplace", null, true);
        if (method != null) {
            try {
                return method.invoke(obj, EMPTY_ARGS);
            } catch (IllegalAccessException e) {
                throw new ObjectAccessException("Could not call " + obj.getClass().getName() + ".writeReplace()", e);
            } catch (InvocationTargetException e2) {
                throw new ObjectAccessException("Could not call " + obj.getClass().getName() + ".writeReplace()", e2.getTargetException());
            }
        }
        return obj;
    }

    public boolean supportsReadObject(Class cls, boolean z) {
        return getMethod(cls, "readObject", new Class[]{ObjectInputStream.class}, z) != null;
    }

    public void callReadObject(Class cls, Object obj, ObjectInputStream objectInputStream) {
        try {
            getMethod(cls, "readObject", new Class[]{ObjectInputStream.class}, false).invoke(obj, objectInputStream);
        } catch (IllegalAccessException e) {
            throw new ConversionException("Could not call " + obj.getClass().getName() + ".readObject()", e);
        } catch (InvocationTargetException e2) {
            throw new ConversionException("Could not call " + obj.getClass().getName() + ".readObject()", e2.getTargetException());
        }
    }

    public boolean supportsWriteObject(Class cls, boolean z) {
        return getMethod(cls, "writeObject", new Class[]{ObjectOutputStream.class}, z) != null;
    }

    public void callWriteObject(Class cls, Object obj, ObjectOutputStream objectOutputStream) {
        try {
            getMethod(cls, "writeObject", new Class[]{ObjectOutputStream.class}, false).invoke(obj, objectOutputStream);
        } catch (IllegalAccessException e) {
            throw new ConversionException("Could not call " + obj.getClass().getName() + ".writeObject()", e);
        } catch (InvocationTargetException e2) {
            throw new ConversionException("Could not call " + obj.getClass().getName() + ".writeObject()", e2.getTargetException());
        }
    }

    private Method getMethod(Class cls, String str, Class[] clsArr, boolean z) {
        Method method = getMethod(cls, str, clsArr);
        if (method != NO_METHOD) {
            if (z || method.getDeclaringClass().equals(cls)) {
                return method;
            }
            return null;
        }
        return null;
    }

    private Method getMethod(Class cls, String str, Class[] clsArr) {
        FastField fastField = new FastField(cls, str);
        Method method = (Method) this.cache.get(fastField);
        if (method == null) {
            try {
                method = cls.getDeclaredMethod(str, clsArr);
                if (!method.isAccessible()) {
                    method.setAccessible(true);
                }
            } catch (NoSuchMethodException unused) {
                method = getMethod(cls.getSuperclass(), str, clsArr);
            }
            this.cache.put(fastField, method);
        }
        return method;
    }

    @Override // com.thoughtworks.xstream.core.Caching
    public void flushCache() {
        this.cache.keySet().retainAll(Arrays.asList(OBJECT_TYPE_FIELDS));
    }
}
