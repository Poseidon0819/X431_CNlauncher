package com.thoughtworks.xstream.annotations;

import com.thoughtworks.xstream.converters.ConverterMatcher;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.FIELD})
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes.dex */
public @interface XStreamConverter {
    boolean[] booleans() default {};

    byte[] bytes() default {};

    char[] chars() default {};

    double[] doubles() default {};

    float[] floats() default {};

    int[] ints() default {};

    long[] longs() default {};

    int priority() default 0;

    short[] shorts() default {};

    String[] strings() default {};

    Class<?>[] types() default {};

    boolean useImplicitType() default true;

    Class<? extends ConverterMatcher> value();
}
