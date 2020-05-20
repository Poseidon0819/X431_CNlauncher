package com.thoughtworks.xstream.converters.reflection;

import com.itextpdf.text.pdf.ColumnText;
import com.mopub.mobileads.VastExtensionXmlManager;
import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.converters.reflection.ReflectionProvider;
import com.thoughtworks.xstream.core.ClassLoaderReference;
import com.thoughtworks.xstream.mapper.CGLIBMapper;
import com.thoughtworks.xstream.mapper.Mapper;
import com.thoughtworks.xstream.p366io.ExtendedHierarchicalStreamWriterHelper;
import com.thoughtworks.xstream.p366io.HierarchicalStreamReader;
import com.thoughtworks.xstream.p366io.HierarchicalStreamWriter;
import com.unionpay.tsmservice.data.Constant;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.CallbackFilter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.Factory;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.NoOp;

/* loaded from: classes2.dex */
public class CGLIBEnhancedConverter extends SerializableConverter {
    private static String CALLBACK_MARKER = "CGLIB$CALLBACK_";
    private static String DEFAULT_NAMING_MARKER = "$$EnhancerByCGLIB$$";
    private transient Map fieldCache;

    public CGLIBEnhancedConverter(Mapper mapper, ReflectionProvider reflectionProvider, ClassLoaderReference classLoaderReference) {
        super(mapper, new CGLIBFilteringReflectionProvider(reflectionProvider), classLoaderReference);
        this.fieldCache = new HashMap();
    }

    public CGLIBEnhancedConverter(Mapper mapper, ReflectionProvider reflectionProvider, ClassLoader classLoader) {
        super(mapper, new CGLIBFilteringReflectionProvider(reflectionProvider), classLoader);
        this.fieldCache = new HashMap();
    }

    public CGLIBEnhancedConverter(Mapper mapper, ReflectionProvider reflectionProvider) {
        this(mapper, new CGLIBFilteringReflectionProvider(reflectionProvider), CGLIBEnhancedConverter.class.getClassLoader());
    }

    @Override // com.thoughtworks.xstream.converters.reflection.SerializableConverter, com.thoughtworks.xstream.converters.ConverterMatcher
    public boolean canConvert(Class cls) {
        return (Enhancer.isEnhanced(cls) && cls.getName().indexOf(DEFAULT_NAMING_MARKER) > 0) || cls == CGLIBMapper.Marker.class;
    }

    @Override // com.thoughtworks.xstream.converters.reflection.AbstractReflectionConverter, com.thoughtworks.xstream.converters.Converter
    public void marshal(Object obj, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {
        Class<?> cls = obj.getClass();
        boolean isAssignableFrom = Factory.class.isAssignableFrom(cls);
        ExtendedHierarchicalStreamWriterHelper.startNode(hierarchicalStreamWriter, VastExtensionXmlManager.TYPE, cls);
        marshallingContext.convertAnother(cls.getSuperclass());
        hierarchicalStreamWriter.endNode();
        hierarchicalStreamWriter.startNode("interfaces");
        Class<?>[] interfaces = cls.getInterfaces();
        for (int i = 0; i < interfaces.length; i++) {
            if (interfaces[i] != Factory.class) {
                ExtendedHierarchicalStreamWriterHelper.startNode(hierarchicalStreamWriter, this.mapper.serializedClass(interfaces[i].getClass()), interfaces[i].getClass());
                marshallingContext.convertAnother(interfaces[i]);
                hierarchicalStreamWriter.endNode();
            }
        }
        hierarchicalStreamWriter.endNode();
        hierarchicalStreamWriter.startNode("hasFactory");
        hierarchicalStreamWriter.setValue(String.valueOf(isAssignableFrom));
        hierarchicalStreamWriter.endNode();
        Callback[] callbacks = isAssignableFrom ? ((Factory) obj).getCallbacks() : getCallbacks(obj);
        if (callbacks.length > 1) {
            if (isAssignableFrom) {
                Map createCallbackIndexMap = createCallbackIndexMap((Factory) obj);
                hierarchicalStreamWriter.startNode("callbacks");
                hierarchicalStreamWriter.startNode("mapping");
                marshallingContext.convertAnother(createCallbackIndexMap);
                hierarchicalStreamWriter.endNode();
            } else {
                ConversionException conversionException = new ConversionException("Cannot handle CGLIB enhanced proxies without factory that have multiple callbacks");
                conversionException.add("proxy superclass", cls.getSuperclass().getName());
                conversionException.add("number of callbacks", String.valueOf(callbacks.length));
                throw conversionException;
            }
        }
        boolean z = false;
        for (Callback callback : callbacks) {
            if (callback == null) {
                hierarchicalStreamWriter.startNode(this.mapper.serializedClass(null));
                hierarchicalStreamWriter.endNode();
            } else {
                z = z || MethodInterceptor.class.isAssignableFrom(callback.getClass());
                ExtendedHierarchicalStreamWriterHelper.startNode(hierarchicalStreamWriter, this.mapper.serializedClass(callback.getClass()), callback.getClass());
                marshallingContext.convertAnother(callback);
                hierarchicalStreamWriter.endNode();
            }
        }
        if (callbacks.length > 1) {
            hierarchicalStreamWriter.endNode();
        }
        try {
            Field declaredField = cls.getDeclaredField("serialVersionUID");
            declaredField.setAccessible(true);
            long j = declaredField.getLong(null);
            ExtendedHierarchicalStreamWriterHelper.startNode(hierarchicalStreamWriter, "serialVersionUID", String.class);
            hierarchicalStreamWriter.setValue(String.valueOf(j));
            hierarchicalStreamWriter.endNode();
        } catch (IllegalAccessException e) {
            throw new ObjectAccessException("Access to serialVersionUID of " + cls.getName() + " not allowed", e);
        } catch (NoSuchFieldException unused) {
            if (z) {
                hierarchicalStreamWriter.startNode("instance");
                super.doMarshalConditionally(obj, hierarchicalStreamWriter, marshallingContext);
                hierarchicalStreamWriter.endNode();
            }
        }
    }

    private Callback[] getCallbacks(Object obj) {
        Class<?> cls = obj.getClass();
        List list = (List) this.fieldCache.get(cls.getName());
        if (list == null) {
            list = new ArrayList();
            this.fieldCache.put(cls.getName(), list);
            int i = 0;
            while (true) {
                try {
                    Field declaredField = cls.getDeclaredField(CALLBACK_MARKER + i);
                    declaredField.setAccessible(true);
                    list.add(declaredField);
                    i++;
                } catch (NoSuchFieldException unused) {
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            try {
                arrayList.add(((Field) list.get(i2)).get(obj));
            } catch (IllegalAccessException e) {
                throw new ObjectAccessException("Access to " + cls.getName() + "." + CALLBACK_MARKER + i2 + " not allowed", e);
            }
        }
        return (Callback[]) arrayList.toArray(new Callback[arrayList.size()]);
    }

    private Map createCallbackIndexMap(Factory factory) {
        Method method;
        Callback[] callbacks = factory.getCallbacks();
        Callback[] callbackArr = new Callback[callbacks.length];
        Map hashMap = new HashMap();
        int i = -1;
        for (int i2 = 0; i2 < callbacks.length; i2++) {
            Callback callback = callbacks[i2];
            if (callback == null) {
                callbackArr[i2] = null;
            } else if (NoOp.class.isAssignableFrom(callback.getClass())) {
                callbackArr[i2] = NoOp.INSTANCE;
                i = i2;
            } else {
                callbackArr[i2] = createReverseEngineeredCallbackOfProperType(callback, i2, hashMap);
            }
        }
        try {
            factory.setCallbacks(callbackArr);
            HashSet<Class<?>> hashSet = new HashSet();
            HashSet<Object> hashSet2 = new HashSet();
            r5 = factory.getClass();
            do {
                hashSet2.addAll(Arrays.asList(r5.getDeclaredMethods()));
                hashSet2.addAll(Arrays.asList(r5.getMethods()));
                hashSet.addAll(Arrays.asList(r5.getInterfaces()));
                r5 = r5.getSuperclass();
            } while (r5 != null);
            for (Class<?> cls : hashSet) {
                hashSet2.addAll(Arrays.asList(cls.getDeclaredMethods()));
            }
            Iterator it = hashSet2.iterator();
            while (it.hasNext()) {
                Method method2 = (Method) it.next();
                method2.setAccessible(true);
                if (!Factory.class.isAssignableFrom(method2.getDeclaringClass()) && (method2.getModifiers() & 24) <= 0) {
                    Class[] parameterTypes = method2.getParameterTypes();
                    try {
                        try {
                            method = (method2.getModifiers() & 1024) > 0 ? factory.getClass().getMethod(method2.getName(), method2.getParameterTypes()) : method2;
                        } catch (NoSuchMethodException unused) {
                            ConversionException conversionException = new ConversionException("CGLIB enhanced proxies wit abstract nethod that has not been implemented");
                            conversionException.add("proxy superclass", cls.getSuperclass().getName());
                            conversionException.add(Constant.KEY_METHOD, method2.toString());
                            throw conversionException;
                        } catch (InvocationTargetException unused2) {
                        }
                    } catch (IllegalAccessException e) {
                        e = e;
                    }
                    try {
                        hashMap.put(null, method2);
                        method.invoke(factory, parameterTypes == null ? null : createNullArguments(parameterTypes));
                        if (hashMap.containsKey(method2)) {
                            it.remove();
                        }
                    } catch (IllegalAccessException e2) {
                        e = e2;
                        method2 = method;
                        throw new ObjectAccessException("Access to " + method2 + " not allowed", e);
                    }
                }
                it.remove();
            }
            if (i >= 0) {
                Integer valueOf = Integer.valueOf(i);
                for (Object obj : hashSet2) {
                    hashMap.put(obj, valueOf);
                }
            }
            factory.setCallbacks(callbacks);
            hashMap.remove(null);
            return hashMap;
        } catch (Throwable th) {
            factory.setCallbacks(callbacks);
            throw th;
        }
    }

    private Object[] createNullArguments(Class[] clsArr) {
        Object[] objArr = new Object[clsArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Class cls = clsArr[i];
            if (cls.isPrimitive()) {
                if (cls == Byte.TYPE) {
                    objArr[i] = (byte) 0;
                } else if (cls == Short.TYPE) {
                    objArr[i] = (short) 0;
                } else if (cls == Integer.TYPE) {
                    objArr[i] = 0;
                } else if (cls == Long.TYPE) {
                    objArr[i] = 0L;
                } else if (cls == Float.TYPE) {
                    objArr[i] = Float.valueOf((float) ColumnText.GLOBAL_SPACE_CHAR_RATIO);
                } else if (cls == Double.TYPE) {
                    objArr[i] = Double.valueOf(0.0d);
                } else if (cls == Character.TYPE) {
                    objArr[i] = (char) 0;
                } else {
                    objArr[i] = Boolean.FALSE;
                }
            }
        }
        return objArr;
    }

    private Callback createReverseEngineeredCallbackOfProperType(Callback callback, int i, Map map) {
        Class<?> cls = null;
        Class<?>[] interfaces = callback.getClass().getInterfaces();
        int i2 = 0;
        while (i2 < interfaces.length) {
            if (Callback.class.isAssignableFrom(interfaces[i2])) {
                cls = interfaces[i2];
                if (cls == Callback.class) {
                    ConversionException conversionException = new ConversionException("Cannot handle CGLIB callback");
                    conversionException.add("CGLIB callback type", callback.getClass().getName());
                    throw conversionException;
                }
                Class<?>[] interfaces2 = cls.getInterfaces();
                if (Arrays.asList(interfaces2).contains(Callback.class)) {
                    break;
                }
                interfaces = interfaces2;
                i2 = -1;
            }
            i2++;
        }
        return (Callback) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new ReverseEngineeringInvocationHandler(i, map));
    }

    @Override // com.thoughtworks.xstream.converters.reflection.AbstractReflectionConverter, com.thoughtworks.xstream.converters.Converter
    public Object unmarshal(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
        Map map;
        Enhancer enhancer = new Enhancer();
        hierarchicalStreamReader.moveDown();
        Object obj = null;
        enhancer.setSuperclass((Class) unmarshallingContext.convertAnother(null, Class.class));
        hierarchicalStreamReader.moveUp();
        hierarchicalStreamReader.moveDown();
        ArrayList arrayList = new ArrayList();
        while (hierarchicalStreamReader.hasMoreChildren()) {
            hierarchicalStreamReader.moveDown();
            arrayList.add(unmarshallingContext.convertAnother(null, this.mapper.realClass(hierarchicalStreamReader.getNodeName())));
            hierarchicalStreamReader.moveUp();
        }
        enhancer.setInterfaces((Class[]) arrayList.toArray(new Class[arrayList.size()]));
        hierarchicalStreamReader.moveUp();
        hierarchicalStreamReader.moveDown();
        boolean booleanValue = Boolean.valueOf(hierarchicalStreamReader.getValue()).booleanValue();
        enhancer.setUseFactory(booleanValue);
        hierarchicalStreamReader.moveUp();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        hierarchicalStreamReader.moveDown();
        if ("callbacks".equals(hierarchicalStreamReader.getNodeName())) {
            hierarchicalStreamReader.moveDown();
            map = (Map) unmarshallingContext.convertAnother(null, HashMap.class);
            hierarchicalStreamReader.moveUp();
            while (hierarchicalStreamReader.hasMoreChildren()) {
                hierarchicalStreamReader.moveDown();
                readCallback(hierarchicalStreamReader, unmarshallingContext, arrayList2, arrayList3);
                hierarchicalStreamReader.moveUp();
            }
        } else {
            readCallback(hierarchicalStreamReader, unmarshallingContext, arrayList2, arrayList3);
            map = null;
        }
        enhancer.setCallbacks((Callback[]) arrayList2.toArray(new Callback[arrayList2.size()]));
        if (map != null) {
            enhancer.setCallbackFilter(new ReverseEngineeredCallbackFilter(map));
        }
        hierarchicalStreamReader.moveUp();
        while (hierarchicalStreamReader.hasMoreChildren()) {
            hierarchicalStreamReader.moveDown();
            if (hierarchicalStreamReader.getNodeName().equals("serialVersionUID")) {
                enhancer.setSerialVersionUID(Long.valueOf(hierarchicalStreamReader.getValue()));
            } else if (hierarchicalStreamReader.getNodeName().equals("instance")) {
                obj = create(enhancer, arrayList3, booleanValue);
                super.doUnmarshalConditionally(obj, hierarchicalStreamReader, unmarshallingContext);
            }
            hierarchicalStreamReader.moveUp();
        }
        if (obj == null) {
            obj = create(enhancer, arrayList3, booleanValue);
        }
        return this.serializationMethodInvoker.callReadResolve(obj);
    }

    private void readCallback(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext, List list, List list2) {
        Callback callback = (Callback) unmarshallingContext.convertAnother(null, this.mapper.realClass(hierarchicalStreamReader.getNodeName()));
        list2.add(callback);
        if (callback == null) {
            list.add(NoOp.INSTANCE);
        } else {
            list.add(callback);
        }
    }

    private Object create(Enhancer enhancer, List list, boolean z) {
        Object create = enhancer.create();
        if (z) {
            ((Factory) create).setCallbacks((Callback[]) list.toArray(new Callback[list.size()]));
        }
        return create;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.thoughtworks.xstream.converters.reflection.SerializableConverter
    public List hierarchyFor(Class cls) {
        List hierarchyFor = super.hierarchyFor(cls);
        hierarchyFor.remove(hierarchyFor.size() - 1);
        return hierarchyFor;
    }

    private Object readResolve() {
        this.fieldCache = new HashMap();
        return this;
    }

    /* loaded from: classes2.dex */
    static class CGLIBFilteringReflectionProvider extends ReflectionProviderWrapper {
        public CGLIBFilteringReflectionProvider(ReflectionProvider reflectionProvider) {
            super(reflectionProvider);
        }

        @Override // com.thoughtworks.xstream.converters.reflection.ReflectionProviderWrapper, com.thoughtworks.xstream.converters.reflection.ReflectionProvider
        public void visitSerializableFields(Object obj, final ReflectionProvider.Visitor visitor) {
            this.wrapped.visitSerializableFields(obj, new ReflectionProvider.Visitor() { // from class: com.thoughtworks.xstream.converters.reflection.CGLIBEnhancedConverter.CGLIBFilteringReflectionProvider.1
                @Override // com.thoughtworks.xstream.converters.reflection.ReflectionProvider.Visitor
                public void visit(String str, Class cls, Class cls2, Object obj2) {
                    if (str.startsWith("CGLIB$")) {
                        return;
                    }
                    visitor.visit(str, cls, cls2, obj2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class ReverseEngineeringInvocationHandler implements InvocationHandler {
        private final Integer index;
        private final Map indexMap;

        public ReverseEngineeringInvocationHandler(int i, Map map) {
            this.indexMap = map;
            this.index = Integer.valueOf(i);
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            Map map = this.indexMap;
            map.put(map.get(null), this.index);
            return null;
        }
    }

    /* loaded from: classes2.dex */
    static class ReverseEngineeredCallbackFilter implements CallbackFilter {
        private final Map callbackIndexMap;

        public ReverseEngineeredCallbackFilter(Map map) {
            this.callbackIndexMap = map;
        }

        public int accept(Method method) {
            if (!this.callbackIndexMap.containsKey(method)) {
                ConversionException conversionException = new ConversionException("CGLIB callback not detected in reverse engineering");
                conversionException.add("CGLIB callback", method.toString());
                throw conversionException;
            }
            return ((Integer) this.callbackIndexMap.get(method)).intValue();
        }
    }
}
