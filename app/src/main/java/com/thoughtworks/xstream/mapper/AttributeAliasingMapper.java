package com.thoughtworks.xstream.mapper;

/* loaded from: classes2.dex */
public class AttributeAliasingMapper extends AbstractAttributeAliasingMapper {
    public AttributeAliasingMapper(Mapper mapper) {
        super(mapper);
    }

    @Override // com.thoughtworks.xstream.mapper.MapperWrapper, com.thoughtworks.xstream.mapper.Mapper
    public String aliasForAttribute(String str) {
        String str2 = (String) this.nameToAlias.get(str);
        return str2 == null ? super.aliasForAttribute(str) : str2;
    }

    @Override // com.thoughtworks.xstream.mapper.MapperWrapper, com.thoughtworks.xstream.mapper.Mapper
    public String attributeForAlias(String str) {
        String str2 = (String) this.aliasToName.get(str);
        return str2 == null ? super.attributeForAlias(str) : str2;
    }
}
