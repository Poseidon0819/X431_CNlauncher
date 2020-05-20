package com.thoughtworks.xstream.core.util;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class Primitives {
    private static final Map BOX = new HashMap();
    private static final Map UNBOX = new HashMap();
    private static final Map NAMED_PRIMITIVE = new HashMap();
    private static final Map REPRESENTING_CHAR = new HashMap();

    static {
        Class[][] clsArr = {new Class[]{Byte.TYPE, Byte.class}, new Class[]{Character.TYPE, Character.class}, new Class[]{Short.TYPE, Short.class}, new Class[]{Integer.TYPE, Integer.class}, new Class[]{Long.TYPE, Long.class}, new Class[]{Float.TYPE, Float.class}, new Class[]{Double.TYPE, Double.class}, new Class[]{Boolean.TYPE, Boolean.class}, new Class[]{Void.TYPE, Void.class}};
        Character[] chArr = {'B', 'C', 'S', 'I', 'J', 'F', 'D', 'Z', null};
        for (int i = 0; i < 9; i++) {
            Class cls = clsArr[i][0];
            Class cls2 = clsArr[i][1];
            BOX.put(cls, cls2);
            UNBOX.put(cls2, cls);
            NAMED_PRIMITIVE.put(cls.getName(), cls);
            REPRESENTING_CHAR.put(cls, chArr[i]);
        }
    }

    public static Class box(Class cls) {
        return (Class) BOX.get(cls);
    }

    public static Class unbox(Class cls) {
        return (Class) UNBOX.get(cls);
    }

    public static boolean isBoxed(Class cls) {
        return UNBOX.containsKey(cls);
    }

    public static Class primitiveType(String str) {
        return (Class) NAMED_PRIMITIVE.get(str);
    }

    public static char representingChar(Class cls) {
        Character ch = (Character) REPRESENTING_CHAR.get(cls);
        if (ch == null) {
            return (char) 0;
        }
        return ch.charValue();
    }
}
