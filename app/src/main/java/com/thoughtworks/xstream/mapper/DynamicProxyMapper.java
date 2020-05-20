package com.thoughtworks.xstream.mapper;

import java.lang.reflect.Proxy;

/* loaded from: classes2.dex */
public class DynamicProxyMapper extends MapperWrapper {
    private String alias;

    /* loaded from: classes2.dex */
    public static class DynamicProxy {
    }

    public DynamicProxyMapper(Mapper mapper) {
        this(mapper, "dynamic-proxy");
    }

    public DynamicProxyMapper(Mapper mapper, String str) {
        super(mapper);
        this.alias = str;
    }

    public String getAlias() {
        return this.alias;
    }

    public void setAlias(String str) {
        this.alias = str;
    }

    @Override // com.thoughtworks.xstream.mapper.MapperWrapper, com.thoughtworks.xstream.mapper.Mapper
    public String serializedClass(Class cls) {
        if (Proxy.isProxyClass(cls)) {
            return this.alias;
        }
        return super.serializedClass(cls);
    }

    @Override // com.thoughtworks.xstream.mapper.MapperWrapper, com.thoughtworks.xstream.mapper.Mapper
    public Class realClass(String str) {
        if (str.equals(this.alias)) {
            return DynamicProxy.class;
        }
        return super.realClass(str);
    }
}
