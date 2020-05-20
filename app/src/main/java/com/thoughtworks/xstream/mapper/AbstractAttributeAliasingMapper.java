package com.thoughtworks.xstream.mapper;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class AbstractAttributeAliasingMapper extends MapperWrapper {
    protected final Map aliasToName;
    protected transient Map nameToAlias;

    public AbstractAttributeAliasingMapper(Mapper mapper) {
        super(mapper);
        this.aliasToName = new HashMap();
        this.nameToAlias = new HashMap();
    }

    public void addAliasFor(String str, String str2) {
        this.aliasToName.put(str2, str);
        this.nameToAlias.put(str, str2);
    }

    private Object readResolve() {
        this.nameToAlias = new HashMap();
        for (Object obj : this.aliasToName.keySet()) {
            this.nameToAlias.put(this.aliasToName.get(obj), obj);
        }
        return this;
    }
}
