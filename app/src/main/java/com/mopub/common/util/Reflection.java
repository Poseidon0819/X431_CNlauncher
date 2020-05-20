package com.mopub.common.util;

import com.mopub.common.Preconditions;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class Reflection {

    /* loaded from: classes.dex */
    public static class MethodBuilder {

        /* renamed from: a */
        private final Object f20229a;

        /* renamed from: b */
        private final String f20230b;

        /* renamed from: c */
        private Class<?> f20231c;

        /* renamed from: d */
        private List<Class<?>> f20232d = new ArrayList();

        /* renamed from: e */
        private List<Object> f20233e = new ArrayList();

        /* renamed from: f */
        private boolean f20234f;

        /* renamed from: g */
        private boolean f20235g;

        public MethodBuilder(Object obj, String str) {
            this.f20229a = obj;
            this.f20230b = str;
            this.f20231c = obj != null ? obj.getClass() : null;
        }

        public <T> MethodBuilder addParam(Class<T> cls, T t) {
            this.f20232d.add(cls);
            this.f20233e.add(t);
            return this;
        }

        public MethodBuilder setAccessible() {
            this.f20234f = true;
            return this;
        }

        public MethodBuilder setStatic(Class<?> cls) {
            this.f20235g = true;
            this.f20231c = cls;
            return this;
        }

        public Object execute() throws Exception {
            List<Class<?>> list = this.f20232d;
            Method declaredMethodWithTraversal = Reflection.getDeclaredMethodWithTraversal(this.f20231c, this.f20230b, (Class[]) list.toArray(new Class[this.f20232d.size()]));
            if (this.f20234f) {
                declaredMethodWithTraversal.setAccessible(true);
            }
            Object[] array = this.f20233e.toArray();
            if (this.f20235g) {
                return declaredMethodWithTraversal.invoke(null, array);
            }
            return declaredMethodWithTraversal.invoke(this.f20229a, array);
        }
    }

    public static Method getDeclaredMethodWithTraversal(Class<?> cls, String str, Class<?>... clsArr) throws NoSuchMethodException {
        while (cls != null) {
            try {
                return cls.getDeclaredMethod(str, clsArr);
            } catch (NoSuchMethodException unused) {
                cls = cls.getSuperclass();
            }
        }
        throw new NoSuchMethodException();
    }

    public static boolean classFound(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static <T> T instantiateClassWithEmptyConstructor(String str, Class<? extends T> cls) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NullPointerException {
        Preconditions.checkNotNull(str);
        Constructor declaredConstructor = Class.forName(str).asSubclass(cls).getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        return (T) declaredConstructor.newInstance(new Object[0]);
    }

    public static <T> T instantiateClassWithConstructor(String str, Class<? extends T> cls, Class[] clsArr, Object[] objArr) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(cls);
        Preconditions.checkNotNull(clsArr);
        Preconditions.checkNotNull(objArr);
        Constructor declaredConstructor = Class.forName(str).asSubclass(cls).getDeclaredConstructor(clsArr);
        declaredConstructor.setAccessible(true);
        return (T) declaredConstructor.newInstance(objArr);
    }
}
