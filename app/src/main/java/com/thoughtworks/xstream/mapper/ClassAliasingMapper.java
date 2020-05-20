package com.thoughtworks.xstream.mapper;

import com.thoughtworks.xstream.core.util.Primitives;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class ClassAliasingMapper extends MapperWrapper {
    private final Map classToName;
    private transient Map nameToType;
    private final Map typeToName;

    public ClassAliasingMapper(Mapper mapper) {
        super(mapper);
        this.typeToName = new HashMap();
        this.classToName = new HashMap();
        this.nameToType = new HashMap();
    }

    public void addClassAlias(String str, Class cls) {
        this.nameToType.put(str, cls.getName());
        this.classToName.put(cls.getName(), str);
    }

    public void addClassAttributeAlias(String str, Class cls) {
        addClassAlias(str, cls);
    }

    public void addTypeAlias(String str, Class cls) {
        this.nameToType.put(str, cls.getName());
        this.typeToName.put(cls, str);
    }

    @Override // com.thoughtworks.xstream.mapper.MapperWrapper, com.thoughtworks.xstream.mapper.Mapper
    public String serializedClass(Class cls) {
        String str = (String) this.classToName.get(cls.getName());
        if (str != null) {
            return str;
        }
        for (Class cls2 : this.typeToName.keySet()) {
            if (cls2.isAssignableFrom(cls)) {
                return (String) this.typeToName.get(cls2);
            }
        }
        return super.serializedClass(cls);
    }

    @Override // com.thoughtworks.xstream.mapper.MapperWrapper, com.thoughtworks.xstream.mapper.Mapper
    public Class realClass(String str) {
        String str2 = (String) this.nameToType.get(str);
        if (str2 != null) {
            Class primitiveType = Primitives.primitiveType(str2);
            if (primitiveType != null) {
                return primitiveType;
            }
            str = str2;
        }
        return super.realClass(str);
    }

    public boolean itemTypeAsAttribute(Class cls) {
        return this.classToName.containsKey(cls);
    }

    public boolean aliasIsAttribute(String str) {
        return this.nameToType.containsKey(str);
    }

    private Object readResolve() {
        this.nameToType = new HashMap();
        for (Object obj : this.classToName.keySet()) {
            this.nameToType.put(this.classToName.get(obj), obj);
        }
        for (Class cls : this.typeToName.keySet()) {
            this.nameToType.put(this.typeToName.get(cls), cls.getName());
        }
        return this;
    }
}
