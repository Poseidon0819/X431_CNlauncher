package com.thoughtworks.xstream.converters.reflection;

import com.thoughtworks.xstream.mapper.Mapper;

/* loaded from: classes2.dex */
public class ReflectionConverter extends AbstractReflectionConverter {
    @Override // com.thoughtworks.xstream.converters.ConverterMatcher
    public boolean canConvert(Class cls) {
        return true;
    }

    public ReflectionConverter(Mapper mapper, ReflectionProvider reflectionProvider) {
        super(mapper, reflectionProvider);
    }
}
