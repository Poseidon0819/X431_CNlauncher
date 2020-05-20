package com.thoughtworks.xstream.mapper;

import com.thoughtworks.xstream.core.Caching;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class CachingMapper extends MapperWrapper implements Caching {
    private transient Map realClassCache;

    public CachingMapper(Mapper mapper) {
        super(mapper);
        readResolve();
    }

    @Override // com.thoughtworks.xstream.mapper.MapperWrapper, com.thoughtworks.xstream.mapper.Mapper
    public Class realClass(String str) {
        Object obj = this.realClassCache.get(str);
        if (obj != null) {
            if (obj instanceof Class) {
                return (Class) obj;
            }
            throw ((CannotResolveClassException) obj);
        }
        try {
            Class realClass = super.realClass(str);
            this.realClassCache.put(str, realClass);
            return realClass;
        } catch (CannotResolveClassException e) {
            this.realClassCache.put(str, e);
            throw e;
        }
    }

    @Override // com.thoughtworks.xstream.core.Caching
    public void flushCache() {
        this.realClassCache.clear();
    }

    private Object readResolve() {
        this.realClassCache = Collections.synchronizedMap(new HashMap(128));
        return this;
    }
}
