package com.thoughtworks.xstream.converters.reflection;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.WeakHashMap;
import sun.misc.Unsafe;

/* loaded from: classes2.dex */
public class Sun14ReflectionProvider extends PureJavaReflectionProvider {
    private static final Exception exception;
    private static final Unsafe unsafe;
    private transient Map fieldOffsetCache;

    @Override // com.thoughtworks.xstream.converters.reflection.PureJavaReflectionProvider
    protected void validateFieldAccess(Field field) {
    }

    static {
        Unsafe unsafe2 = null;
        try {
            Field declaredField = Unsafe.class.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            Unsafe unsafe3 = (Unsafe) declaredField.get(null);
            e = null;
            unsafe2 = unsafe3;
        } catch (IllegalAccessException e) {
            e = e;
        } catch (IllegalArgumentException e2) {
            e = e2;
        } catch (NoSuchFieldException e3) {
            e = e3;
        } catch (SecurityException e4) {
            e = e4;
        }
        exception = e;
        unsafe = unsafe2;
    }

    public Sun14ReflectionProvider() {
    }

    public Sun14ReflectionProvider(FieldDictionary fieldDictionary) {
        super(fieldDictionary);
    }

    @Override // com.thoughtworks.xstream.converters.reflection.PureJavaReflectionProvider, com.thoughtworks.xstream.converters.reflection.ReflectionProvider
    public Object newInstance(Class cls) {
        if (exception != null) {
            throw new ObjectAccessException("Cannot construct " + cls.getName(), exception);
        }
        try {
            return unsafe.allocateInstance(cls);
        } catch (IllegalArgumentException e) {
            throw new ObjectAccessException("Cannot construct " + cls.getName(), e);
        } catch (InstantiationException e2) {
            throw new ObjectAccessException("Cannot construct " + cls.getName(), e2);
        } catch (SecurityException e3) {
            throw new ObjectAccessException("Cannot construct " + cls.getName(), e3);
        }
    }

    @Override // com.thoughtworks.xstream.converters.reflection.PureJavaReflectionProvider, com.thoughtworks.xstream.converters.reflection.ReflectionProvider
    public void writeField(Object obj, String str, Object obj2, Class cls) {
        write(this.fieldDictionary.field(obj.getClass(), str, cls), obj, obj2);
    }

    private void write(Field field, Object obj, Object obj2) {
        if (exception != null) {
            throw new ObjectAccessException("Could not set field " + obj.getClass() + "." + field.getName(), exception);
        }
        try {
            long fieldOffset = getFieldOffset(field);
            Class<?> type = field.getType();
            if (type.isPrimitive()) {
                if (type.equals(Integer.TYPE)) {
                    unsafe.putInt(obj, fieldOffset, ((Integer) obj2).intValue());
                    return;
                } else if (type.equals(Long.TYPE)) {
                    unsafe.putLong(obj, fieldOffset, ((Long) obj2).longValue());
                    return;
                } else if (type.equals(Short.TYPE)) {
                    unsafe.putShort(obj, fieldOffset, ((Short) obj2).shortValue());
                    return;
                } else if (type.equals(Character.TYPE)) {
                    unsafe.putChar(obj, fieldOffset, ((Character) obj2).charValue());
                    return;
                } else if (type.equals(Byte.TYPE)) {
                    unsafe.putByte(obj, fieldOffset, ((Byte) obj2).byteValue());
                    return;
                } else if (type.equals(Float.TYPE)) {
                    unsafe.putFloat(obj, fieldOffset, ((Float) obj2).floatValue());
                    return;
                } else if (type.equals(Double.TYPE)) {
                    unsafe.putDouble(obj, fieldOffset, ((Double) obj2).doubleValue());
                    return;
                } else if (type.equals(Boolean.TYPE)) {
                    unsafe.putBoolean(obj, fieldOffset, ((Boolean) obj2).booleanValue());
                    return;
                } else {
                    throw new ObjectAccessException("Could not set field " + obj.getClass() + "." + field.getName() + ": Unknown type " + type);
                }
            }
            unsafe.putObject(obj, fieldOffset, obj2);
        } catch (IllegalArgumentException e) {
            throw new ObjectAccessException("Could not set field " + obj.getClass() + "." + field.getName(), e);
        }
    }

    private synchronized long getFieldOffset(Field field) {
        Long l;
        l = (Long) this.fieldOffsetCache.get(field);
        if (l == null) {
            l = new Long(unsafe.objectFieldOffset(field));
            this.fieldOffsetCache.put(field, l);
        }
        return l.longValue();
    }

    private Object readResolve() {
        init();
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.thoughtworks.xstream.converters.reflection.PureJavaReflectionProvider
    public void init() {
        super.init();
        this.fieldOffsetCache = new WeakHashMap();
    }
}
