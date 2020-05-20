package com.thoughtworks.xstream.mapper;

import java.util.HashSet;
import java.util.Set;

/* loaded from: classes2.dex */
public class ImmutableTypesMapper extends MapperWrapper {
    private final Set immutableTypes;

    public ImmutableTypesMapper(Mapper mapper) {
        super(mapper);
        this.immutableTypes = new HashSet();
    }

    public void addImmutableType(Class cls) {
        this.immutableTypes.add(cls);
    }

    @Override // com.thoughtworks.xstream.mapper.MapperWrapper, com.thoughtworks.xstream.mapper.Mapper
    public boolean isImmutableValueType(Class cls) {
        if (this.immutableTypes.contains(cls)) {
            return true;
        }
        return super.isImmutableValueType(cls);
    }
}
