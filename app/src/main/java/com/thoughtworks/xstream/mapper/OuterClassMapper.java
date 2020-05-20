package com.thoughtworks.xstream.mapper;

/* loaded from: classes2.dex */
public class OuterClassMapper extends MapperWrapper {
    private final String alias;

    public OuterClassMapper(Mapper mapper) {
        this(mapper, "outer-class");
    }

    public OuterClassMapper(Mapper mapper, String str) {
        super(mapper);
        this.alias = str;
    }

    @Override // com.thoughtworks.xstream.mapper.MapperWrapper, com.thoughtworks.xstream.mapper.Mapper
    public String serializedMember(Class cls, String str) {
        if (str.equals("this$0")) {
            return this.alias;
        }
        return super.serializedMember(cls, str);
    }

    @Override // com.thoughtworks.xstream.mapper.MapperWrapper, com.thoughtworks.xstream.mapper.Mapper
    public String realMember(Class cls, String str) {
        return str.equals(this.alias) ? "this$0" : super.realMember(cls, str);
    }
}
