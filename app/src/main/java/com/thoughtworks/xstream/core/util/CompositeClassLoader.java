package com.thoughtworks.xstream.core.util;

import com.thoughtworks.xstream.core.JVM;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class CompositeClassLoader extends ClassLoader {
    private final ReferenceQueue queue = new ReferenceQueue();
    private final List classLoaders = new ArrayList();

    static {
        if (JVM.is17()) {
            try {
                Method declaredMethod = ClassLoader.class.getDeclaredMethod("registerAsParallelCapable", null);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(null, null);
            } catch (Exception unused) {
            }
        }
    }

    public CompositeClassLoader() {
        addInternal(Object.class.getClassLoader());
        addInternal(getClass().getClassLoader());
    }

    public synchronized void add(ClassLoader classLoader) {
        cleanup();
        if (classLoader != null) {
            addInternal(classLoader);
        }
    }

    private void addInternal(ClassLoader classLoader) {
        Iterator it = this.classLoaders.iterator();
        WeakReference weakReference = null;
        while (it.hasNext()) {
            WeakReference weakReference2 = (WeakReference) it.next();
            ClassLoader classLoader2 = (ClassLoader) weakReference2.get();
            if (classLoader2 == null) {
                it.remove();
            } else if (classLoader2 == classLoader) {
                it.remove();
                weakReference = weakReference2;
            }
        }
        List list = this.classLoaders;
        if (weakReference == null) {
            weakReference = new WeakReference(classLoader, this.queue);
        }
        list.add(0, weakReference);
    }

    @Override // java.lang.ClassLoader
    public Class loadClass(String str) throws ClassNotFoundException {
        ArrayList<ClassLoader> arrayList = new ArrayList(this.classLoaders.size()) { // from class: com.thoughtworks.xstream.core.util.CompositeClassLoader.1
            @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
            public boolean addAll(Collection collection) {
                boolean z = false;
                for (Object obj : collection) {
                    z |= add(obj);
                }
                return z;
            }

            @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
            public boolean add(Object obj) {
                Object obj2 = ((WeakReference) obj).get();
                if (obj2 != null) {
                    return super.add(obj2);
                }
                return false;
            }
        };
        synchronized (this) {
            cleanup();
            arrayList.addAll(this.classLoaders);
        }
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        for (ClassLoader classLoader : arrayList) {
            if (classLoader == contextClassLoader) {
                contextClassLoader = null;
            }
            try {
                continue;
                return classLoader.loadClass(str);
            } catch (ClassNotFoundException unused) {
            }
        }
        if (contextClassLoader != null) {
            return contextClassLoader.loadClass(str);
        }
        throw new ClassNotFoundException(str);
    }

    private void cleanup() {
        while (true) {
            WeakReference weakReference = (WeakReference) this.queue.poll();
            if (weakReference == null) {
                return;
            }
            this.classLoaders.remove(weakReference);
        }
    }
}
