package com.thoughtworks.xstream.annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

@Deprecated
/* loaded from: classes2.dex */
public class AnnotationProvider {
    @Deprecated
    public <T extends Annotation> T getAnnotation(Field field, Class<T> cls) {
        return (T) field.getAnnotation(cls);
    }
}
