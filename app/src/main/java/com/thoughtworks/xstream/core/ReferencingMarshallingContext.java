package com.thoughtworks.xstream.core;

import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.p366io.path.Path;

/* loaded from: classes2.dex */
public interface ReferencingMarshallingContext extends MarshallingContext {
    Path currentPath();

    Object lookupReference(Object obj);

    void registerImplicit(Object obj);

    void replace(Object obj, Object obj2);
}
