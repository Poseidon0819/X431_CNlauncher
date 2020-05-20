package com.thoughtworks.xstream.core.util;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class ObjectIdDictionary {
    private final Map map = new HashMap();
    private final ReferenceQueue queue = new ReferenceQueue();

    /* loaded from: classes2.dex */
    interface Wrapper {
        boolean equals(Object obj);

        Object get();

        int hashCode();

        String toString();
    }

    /* loaded from: classes2.dex */
    static class IdWrapper implements Wrapper {
        private final int hashCode;
        private final Object obj;

        public IdWrapper(Object obj) {
            this.hashCode = System.identityHashCode(obj);
            this.obj = obj;
        }

        @Override // com.thoughtworks.xstream.core.util.ObjectIdDictionary.Wrapper
        public int hashCode() {
            return this.hashCode;
        }

        @Override // com.thoughtworks.xstream.core.util.ObjectIdDictionary.Wrapper
        public boolean equals(Object obj) {
            return this.obj == ((Wrapper) obj).get();
        }

        @Override // com.thoughtworks.xstream.core.util.ObjectIdDictionary.Wrapper
        public String toString() {
            return this.obj.toString();
        }

        @Override // com.thoughtworks.xstream.core.util.ObjectIdDictionary.Wrapper
        public Object get() {
            return this.obj;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class WeakIdWrapper extends WeakReference implements Wrapper {
        private final int hashCode;

        public WeakIdWrapper(Object obj) {
            super(obj, ObjectIdDictionary.this.queue);
            this.hashCode = System.identityHashCode(obj);
        }

        @Override // com.thoughtworks.xstream.core.util.ObjectIdDictionary.Wrapper
        public int hashCode() {
            return this.hashCode;
        }

        @Override // com.thoughtworks.xstream.core.util.ObjectIdDictionary.Wrapper
        public boolean equals(Object obj) {
            return get() == ((Wrapper) obj).get();
        }

        @Override // com.thoughtworks.xstream.core.util.ObjectIdDictionary.Wrapper
        public String toString() {
            Object obj = get();
            return obj == null ? "(null)" : obj.toString();
        }
    }

    public void associateId(Object obj, Object obj2) {
        this.map.put(new WeakIdWrapper(obj), obj2);
        cleanup();
    }

    public Object lookupId(Object obj) {
        return this.map.get(new IdWrapper(obj));
    }

    public boolean containsId(Object obj) {
        return this.map.containsKey(new IdWrapper(obj));
    }

    public void removeId(Object obj) {
        this.map.remove(new IdWrapper(obj));
        cleanup();
    }

    public int size() {
        cleanup();
        return this.map.size();
    }

    private void cleanup() {
        while (true) {
            WeakIdWrapper weakIdWrapper = (WeakIdWrapper) this.queue.poll();
            if (weakIdWrapper == null) {
                return;
            }
            this.map.remove(weakIdWrapper);
        }
    }
}
