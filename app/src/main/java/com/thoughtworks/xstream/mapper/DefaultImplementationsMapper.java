package com.thoughtworks.xstream.mapper;

import com.thoughtworks.xstream.InitializationException;
import com.thoughtworks.xstream.mapper.Mapper;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class DefaultImplementationsMapper extends MapperWrapper {
    private transient Map implToType;
    private final Map typeToImpl;

    public DefaultImplementationsMapper(Mapper mapper) {
        super(mapper);
        this.typeToImpl = new HashMap();
        this.implToType = new HashMap();
        addDefaults();
    }

    protected void addDefaults() {
        addDefaultImplementation(null, Mapper.Null.class);
        addDefaultImplementation(Boolean.class, Boolean.TYPE);
        addDefaultImplementation(Character.class, Character.TYPE);
        addDefaultImplementation(Integer.class, Integer.TYPE);
        addDefaultImplementation(Float.class, Float.TYPE);
        addDefaultImplementation(Double.class, Double.TYPE);
        addDefaultImplementation(Short.class, Short.TYPE);
        addDefaultImplementation(Byte.class, Byte.TYPE);
        addDefaultImplementation(Long.class, Long.TYPE);
    }

    public void addDefaultImplementation(Class cls, Class cls2) {
        if (cls != null && cls.isInterface()) {
            throw new InitializationException("Default implementation is not a concrete class: " + cls.getName());
        }
        this.typeToImpl.put(cls2, cls);
        this.implToType.put(cls, cls2);
    }

    @Override // com.thoughtworks.xstream.mapper.MapperWrapper, com.thoughtworks.xstream.mapper.Mapper
    public String serializedClass(Class cls) {
        Class cls2 = (Class) this.implToType.get(cls);
        return cls2 == null ? super.serializedClass(cls) : super.serializedClass(cls2);
    }

    @Override // com.thoughtworks.xstream.mapper.MapperWrapper, com.thoughtworks.xstream.mapper.Mapper
    public Class defaultImplementationOf(Class cls) {
        if (this.typeToImpl.containsKey(cls)) {
            return (Class) this.typeToImpl.get(cls);
        }
        return super.defaultImplementationOf(cls);
    }

    private Object readResolve() {
        this.implToType = new HashMap();
        for (Object obj : this.typeToImpl.keySet()) {
            this.implToType.put(this.typeToImpl.get(obj), obj);
        }
        return this;
    }
}
