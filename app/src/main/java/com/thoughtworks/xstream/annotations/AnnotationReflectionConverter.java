package com.thoughtworks.xstream.annotations;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.ConverterMatcher;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.SingleValueConverter;
import com.thoughtworks.xstream.converters.SingleValueConverterWrapper;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.converters.reflection.ObjectAccessException;
import com.thoughtworks.xstream.converters.reflection.ReflectionConverter;
import com.thoughtworks.xstream.converters.reflection.ReflectionProvider;
import com.thoughtworks.xstream.mapper.Mapper;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

@Deprecated
/* loaded from: classes2.dex */
public class AnnotationReflectionConverter extends ReflectionConverter {
    private final AnnotationProvider annotationProvider;
    private final Map<Class<? extends ConverterMatcher>, Converter> cachedConverters;

    @Deprecated
    public AnnotationReflectionConverter(Mapper mapper, ReflectionProvider reflectionProvider, AnnotationProvider annotationProvider) {
        super(mapper, reflectionProvider);
        this.annotationProvider = annotationProvider;
        this.cachedConverters = new HashMap();
    }

    @Override // com.thoughtworks.xstream.converters.reflection.AbstractReflectionConverter
    public void marshallField(MarshallingContext marshallingContext, Object obj, Field field) {
        XStreamConverter xStreamConverter = (XStreamConverter) this.annotationProvider.getAnnotation(field, XStreamConverter.class);
        if (xStreamConverter != null) {
            Class<? extends ConverterMatcher> value = xStreamConverter.value();
            ensureCache(value);
            marshallingContext.convertAnother(obj, this.cachedConverters.get(value));
            return;
        }
        marshallingContext.convertAnother(obj);
    }

    private void ensureCache(Class<? extends ConverterMatcher> cls) {
        if (this.cachedConverters.containsKey(cls)) {
            return;
        }
        this.cachedConverters.put(cls, newInstance(cls));
    }

    @Override // com.thoughtworks.xstream.converters.reflection.AbstractReflectionConverter
    public Object unmarshallField(UnmarshallingContext unmarshallingContext, Object obj, Class cls, Field field) {
        XStreamConverter xStreamConverter = (XStreamConverter) this.annotationProvider.getAnnotation(field, XStreamConverter.class);
        if (xStreamConverter != null) {
            Class<? extends ConverterMatcher> value = xStreamConverter.value();
            ensureCache(value);
            return unmarshallingContext.convertAnother(obj, cls, this.cachedConverters.get(value));
        }
        return unmarshallingContext.convertAnother(obj, cls);
    }

    private Converter newInstance(Class<? extends ConverterMatcher> cls) {
        try {
            if (SingleValueConverter.class.isAssignableFrom(cls)) {
                return new SingleValueConverterWrapper((SingleValueConverter) cls.getConstructor(new Class[0]).newInstance(new Object[0]));
            }
            return (Converter) cls.getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (IllegalAccessException e) {
            throw new ObjectAccessException("Cannot construct " + cls.getName(), e);
        } catch (InstantiationException e2) {
            throw new ObjectAccessException("Cannot construct " + cls.getName(), e2);
        } catch (NoSuchMethodException e3) {
            throw new ObjectAccessException("Cannot construct " + cls.getName(), e3);
        } catch (InvocationTargetException e4) {
            throw new ObjectAccessException("Cannot construct " + cls.getName(), e4.getCause());
        }
    }
}
