package com.thoughtworks.xstream.converters.reflection;

import com.thoughtworks.xstream.core.Caching;
import com.thoughtworks.xstream.core.JVM;
import com.thoughtworks.xstream.core.util.OrderRetainingMap;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public class FieldDictionary implements Caching {
    private transient Map keyedByFieldKeyCache;
    private transient Map keyedByFieldNameCache;
    private final FieldKeySorter sorter;

    public FieldDictionary() {
        this(new ImmutableFieldKeySorter());
    }

    public FieldDictionary(FieldKeySorter fieldKeySorter) {
        this.sorter = fieldKeySorter;
        init();
    }

    private void init() {
        this.keyedByFieldNameCache = new HashMap();
        this.keyedByFieldKeyCache = new HashMap();
        this.keyedByFieldNameCache.put(Object.class, Collections.EMPTY_MAP);
        this.keyedByFieldKeyCache.put(Object.class, Collections.EMPTY_MAP);
    }

    public Iterator serializableFieldsFor(Class cls) {
        return fieldsFor(cls);
    }

    public Iterator fieldsFor(Class cls) {
        return buildMap(cls, true).values().iterator();
    }

    public Field field(Class cls, String str, Class cls2) {
        Field fieldOrNull = fieldOrNull(cls, str, cls2);
        if (fieldOrNull != null) {
            return fieldOrNull;
        }
        throw new MissingFieldException(cls.getName(), str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.thoughtworks.xstream.converters.reflection.FieldKey] */
    public Field fieldOrNull(Class cls, String str, Class cls2) {
        Map buildMap = buildMap(cls, cls2 != null);
        if (cls2 != null) {
            str = new FieldKey(str, cls2, -1);
        }
        return (Field) buildMap.get(str);
    }

    private Map buildMap(Class cls, boolean z) {
        synchronized (this) {
            if (this.keyedByFieldNameCache.containsKey(cls)) {
                return (Map) (z ? this.keyedByFieldKeyCache : this.keyedByFieldNameCache).get(cls);
            }
            ArrayList<Class> arrayList = new ArrayList();
            while (!Object.class.equals(cls)) {
                arrayList.add(0, cls);
                cls = cls.getSuperclass();
            }
            Map map = Collections.EMPTY_MAP;
            Map map2 = Collections.EMPTY_MAP;
            for (Class cls2 : arrayList) {
                if (!this.keyedByFieldNameCache.containsKey(cls2)) {
                    HashMap hashMap = new HashMap(map);
                    OrderRetainingMap orderRetainingMap = new OrderRetainingMap(map2);
                    Field[] declaredFields = cls2.getDeclaredFields();
                    if (JVM.reverseFieldDefinition()) {
                        int length = declaredFields.length >> 1;
                        while (true) {
                            int i = length - 1;
                            if (length <= 0) {
                                break;
                            }
                            int length2 = (declaredFields.length - i) - 1;
                            Field field = declaredFields[i];
                            declaredFields[i] = declaredFields[length2];
                            declaredFields[length2] = field;
                            length = i;
                        }
                    }
                    for (int i2 = 0; i2 < declaredFields.length; i2++) {
                        Field field2 = declaredFields[i2];
                        if (!field2.isAccessible()) {
                            field2.setAccessible(true);
                        }
                        FieldKey fieldKey = new FieldKey(field2.getName(), field2.getDeclaringClass(), i2);
                        Field field3 = (Field) hashMap.get(field2.getName());
                        if (field3 == null || (field3.getModifiers() & 8) != 0 || (field3 != null && (field2.getModifiers() & 8) == 0)) {
                            hashMap.put(field2.getName(), field2);
                        }
                        orderRetainingMap.put(fieldKey, field2);
                    }
                    map2 = this.sorter.sort(cls2, orderRetainingMap);
                    this.keyedByFieldNameCache.put(cls2, hashMap);
                    this.keyedByFieldKeyCache.put(cls2, map2);
                    map = hashMap;
                } else {
                    map = (Map) this.keyedByFieldNameCache.get(cls2);
                    map2 = (Map) this.keyedByFieldKeyCache.get(cls2);
                }
            }
            if (z) {
                map = map2;
            }
            return map;
        }
    }

    @Override // com.thoughtworks.xstream.core.Caching
    public synchronized void flushCache() {
        Set singleton = Collections.singleton(Object.class);
        this.keyedByFieldNameCache.keySet().retainAll(singleton);
        this.keyedByFieldKeyCache.keySet().retainAll(singleton);
        if (this.sorter instanceof Caching) {
            ((Caching) this.sorter).flushCache();
        }
    }

    protected Object readResolve() {
        init();
        return this;
    }
}
