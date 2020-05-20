package com.thoughtworks.xstream.mapper;

import com.thoughtworks.xstream.core.util.Primitives;

/* loaded from: classes2.dex */
public class ArrayMapper extends MapperWrapper {
    public ArrayMapper(Mapper mapper) {
        super(mapper);
    }

    @Override // com.thoughtworks.xstream.mapper.MapperWrapper, com.thoughtworks.xstream.mapper.Mapper
    public String serializedClass(Class cls) {
        String str;
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            str = null;
            if (!cls.isArray()) {
                break;
            }
            str = super.serializedClass(cls);
            if (!cls.getName().equals(str)) {
                break;
            }
            cls = cls.getComponentType();
            stringBuffer.append("-array");
        }
        if (str == null) {
            str = boxedTypeName(cls);
        }
        if (str == null) {
            str = super.serializedClass(cls);
        }
        if (stringBuffer.length() > 0) {
            return str + ((Object) stringBuffer);
        }
        return str;
    }

    @Override // com.thoughtworks.xstream.mapper.MapperWrapper, com.thoughtworks.xstream.mapper.Mapper
    public Class realClass(String str) {
        int i = 0;
        while (str.endsWith("-array")) {
            str = str.substring(0, str.length() - 6);
            i++;
        }
        if (i > 0) {
            Class<?> primitiveType = Primitives.primitiveType(str);
            if (primitiveType == null) {
                primitiveType = super.realClass(str);
            }
            while (primitiveType.isArray()) {
                primitiveType = primitiveType.getComponentType();
                i++;
            }
            return super.realClass(arrayType(i, primitiveType));
        }
        return super.realClass(str);
    }

    private String arrayType(int i, Class cls) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < i; i2++) {
            stringBuffer.append('[');
        }
        if (cls.isPrimitive()) {
            stringBuffer.append(Primitives.representingChar(cls));
            return stringBuffer.toString();
        }
        stringBuffer.append('L');
        stringBuffer.append(cls.getName());
        stringBuffer.append(';');
        return stringBuffer.toString();
    }

    private String boxedTypeName(Class cls) {
        if (Primitives.isBoxed(cls)) {
            return cls.getName();
        }
        return null;
    }
}
