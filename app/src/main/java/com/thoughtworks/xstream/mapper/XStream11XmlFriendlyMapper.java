package com.thoughtworks.xstream.mapper;

/* loaded from: classes2.dex */
public class XStream11XmlFriendlyMapper extends AbstractXmlFriendlyMapper {
    public XStream11XmlFriendlyMapper(Mapper mapper) {
        super(mapper);
    }

    @Override // com.thoughtworks.xstream.mapper.MapperWrapper, com.thoughtworks.xstream.mapper.Mapper
    public Class realClass(String str) {
        return super.realClass(unescapeClassName(str));
    }

    @Override // com.thoughtworks.xstream.mapper.MapperWrapper, com.thoughtworks.xstream.mapper.Mapper
    public String realMember(Class cls, String str) {
        return unescapeFieldName(super.realMember(cls, str));
    }

    public String mapNameFromXML(String str) {
        return unescapeFieldName(str);
    }
}
