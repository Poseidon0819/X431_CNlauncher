package com.thoughtworks.xstream.mapper;

/* loaded from: classes2.dex */
public class XmlFriendlyMapper extends AbstractXmlFriendlyMapper {
    public XmlFriendlyMapper(Mapper mapper) {
        super(mapper);
    }

    @Override // com.thoughtworks.xstream.mapper.MapperWrapper, com.thoughtworks.xstream.mapper.Mapper
    public String serializedClass(Class cls) {
        return escapeClassName(super.serializedClass(cls));
    }

    @Override // com.thoughtworks.xstream.mapper.MapperWrapper, com.thoughtworks.xstream.mapper.Mapper
    public Class realClass(String str) {
        return super.realClass(unescapeClassName(str));
    }

    @Override // com.thoughtworks.xstream.mapper.MapperWrapper, com.thoughtworks.xstream.mapper.Mapper
    public String serializedMember(Class cls, String str) {
        return escapeFieldName(super.serializedMember(cls, str));
    }

    @Override // com.thoughtworks.xstream.mapper.MapperWrapper, com.thoughtworks.xstream.mapper.Mapper
    public String realMember(Class cls, String str) {
        return unescapeFieldName(super.realMember(cls, str));
    }

    public String mapNameToXML(String str) {
        return escapeFieldName(str);
    }

    public String mapNameFromXML(String str) {
        return unescapeFieldName(str);
    }
}
