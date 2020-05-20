package com.thoughtworks.xstream.converters.extended;

import com.thoughtworks.xstream.converters.reflection.ReflectionConverter;
import com.thoughtworks.xstream.converters.reflection.ReflectionProvider;
import com.thoughtworks.xstream.mapper.Mapper;
import javax.swing.LookAndFeel;

/* loaded from: classes2.dex */
public class LookAndFeelConverter extends ReflectionConverter {
    public LookAndFeelConverter(Mapper mapper, ReflectionProvider reflectionProvider) {
        super(mapper, reflectionProvider);
    }

    @Override // com.thoughtworks.xstream.converters.reflection.ReflectionConverter, com.thoughtworks.xstream.converters.ConverterMatcher
    public boolean canConvert(Class cls) {
        return LookAndFeel.class.isAssignableFrom(cls);
    }
}
