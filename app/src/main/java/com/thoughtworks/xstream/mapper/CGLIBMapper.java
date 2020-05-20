package com.thoughtworks.xstream.mapper;

import net.sf.cglib.proxy.Enhancer;

/* loaded from: classes2.dex */
public class CGLIBMapper extends MapperWrapper {
    private static String DEFAULT_NAMING_MARKER = "$$EnhancerByCGLIB$$";
    private final String alias;

    /* loaded from: classes2.dex */
    public interface Marker {
    }

    public CGLIBMapper(Mapper mapper) {
        this(mapper, "CGLIB-enhanced-proxy");
    }

    public CGLIBMapper(Mapper mapper, String str) {
        super(mapper);
        this.alias = str;
    }

    @Override // com.thoughtworks.xstream.mapper.MapperWrapper, com.thoughtworks.xstream.mapper.Mapper
    public String serializedClass(Class cls) {
        String serializedClass = super.serializedClass(cls);
        if (cls == null) {
            return serializedClass;
        }
        String name = cls.getName();
        return (name.equals(serializedClass) && name.indexOf(DEFAULT_NAMING_MARKER) > 0 && Enhancer.isEnhanced(cls)) ? this.alias : serializedClass;
    }

    @Override // com.thoughtworks.xstream.mapper.MapperWrapper, com.thoughtworks.xstream.mapper.Mapper
    public Class realClass(String str) {
        return str.equals(this.alias) ? Marker.class : super.realClass(str);
    }
}
