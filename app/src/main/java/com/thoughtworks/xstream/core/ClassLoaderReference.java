package com.thoughtworks.xstream.core;

import com.thoughtworks.xstream.core.util.CompositeClassLoader;

/* loaded from: classes2.dex */
public final class ClassLoaderReference {
    private transient ClassLoader reference;

    public ClassLoaderReference(ClassLoader classLoader) {
        setReference(classLoader);
    }

    public final ClassLoader getReference() {
        return this.reference;
    }

    public final void setReference(ClassLoader classLoader) {
        if (classLoader instanceof com.thoughtworks.xstream.core.util.ClassLoaderReference) {
            classLoader = ((com.thoughtworks.xstream.core.util.ClassLoaderReference) classLoader).getReference();
        }
        this.reference = classLoader;
    }

    private Object readResolve() {
        this.reference = new CompositeClassLoader();
        return this;
    }
}
