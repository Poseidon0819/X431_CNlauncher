package com.thoughtworks.xstream.mapper;

/* loaded from: classes2.dex */
public class SystemAttributeAliasingMapper extends AbstractAttributeAliasingMapper {
    public SystemAttributeAliasingMapper(Mapper mapper) {
        super(mapper);
    }

    @Override // com.thoughtworks.xstream.mapper.MapperWrapper, com.thoughtworks.xstream.mapper.Mapper
    public String aliasForSystemAttribute(String str) {
        String str2 = (String) this.nameToAlias.get(str);
        if (str2 != null || this.nameToAlias.containsKey(str)) {
            return str2;
        }
        String aliasForSystemAttribute = super.aliasForSystemAttribute(str);
        return aliasForSystemAttribute == str ? super.aliasForAttribute(str) : aliasForSystemAttribute;
    }
}
