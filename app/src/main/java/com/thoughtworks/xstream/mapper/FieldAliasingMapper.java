package com.thoughtworks.xstream.mapper;

import com.thoughtworks.xstream.core.util.FastField;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class FieldAliasingMapper extends MapperWrapper {
    protected final Map aliasToFieldMap;
    protected final Map fieldToAliasMap;
    protected final Set fieldsToOmit;
    protected final Set unknownFieldsToIgnore;

    public FieldAliasingMapper(Mapper mapper) {
        super(mapper);
        this.fieldToAliasMap = new HashMap();
        this.aliasToFieldMap = new HashMap();
        this.fieldsToOmit = new HashSet();
        this.unknownFieldsToIgnore = new LinkedHashSet();
    }

    public void addFieldAlias(String str, Class cls, String str2) {
        this.fieldToAliasMap.put(key(cls, str2), str);
        this.aliasToFieldMap.put(key(cls, str), str2);
    }

    public void addFieldsToIgnore(Pattern pattern) {
        this.unknownFieldsToIgnore.add(pattern);
    }

    private Object key(Class cls, String str) {
        return new FastField(cls, str);
    }

    @Override // com.thoughtworks.xstream.mapper.MapperWrapper, com.thoughtworks.xstream.mapper.Mapper
    public String serializedMember(Class cls, String str) {
        String member = getMember(cls, str, this.fieldToAliasMap);
        return member == null ? super.serializedMember(cls, str) : member;
    }

    @Override // com.thoughtworks.xstream.mapper.MapperWrapper, com.thoughtworks.xstream.mapper.Mapper
    public String realMember(Class cls, String str) {
        String member = getMember(cls, str, this.aliasToFieldMap);
        return member == null ? super.realMember(cls, str) : member;
    }

    private String getMember(Class cls, String str, Map map) {
        String str2 = null;
        while (str2 == null && cls != Object.class) {
            str2 = (String) map.get(key(cls, str));
            cls = cls.getSuperclass();
        }
        return str2;
    }

    @Override // com.thoughtworks.xstream.mapper.MapperWrapper, com.thoughtworks.xstream.mapper.Mapper
    public boolean shouldSerializeMember(Class cls, String str) {
        if (this.fieldsToOmit.contains(key(cls, str))) {
            return false;
        }
        if (cls != Object.class || this.unknownFieldsToIgnore.isEmpty()) {
            return true;
        }
        for (Pattern pattern : this.unknownFieldsToIgnore) {
            if (pattern.matcher(str).matches()) {
                return false;
            }
        }
        return true;
    }

    public void omitField(Class cls, String str) {
        this.fieldsToOmit.add(key(cls, str));
    }
}
