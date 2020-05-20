package com.thoughtworks.xstream.core.util;

/* loaded from: classes2.dex */
public class ClassLoaderReference extends ClassLoader {
    private transient ClassLoader reference;

    public ClassLoaderReference(ClassLoader classLoader) {
        this.reference = classLoader;
    }

    @Override // java.lang.ClassLoader
    public Class loadClass(String str) throws ClassNotFoundException {
        return this.reference.loadClass(str);
    }

    public ClassLoader getReference() {
        return this.reference;
    }

    public void setReference(ClassLoader classLoader) {
        this.reference = classLoader;
    }

    private Object writeReplace() {
        return new Replacement();
    }

    /* loaded from: classes2.dex */
    static class Replacement {
        Replacement() {
        }

        private Object readResolve() {
            return new ClassLoaderReference(new CompositeClassLoader());
        }
    }
}
