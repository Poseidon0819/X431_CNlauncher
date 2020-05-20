package com.thoughtworks.xstream.mapper;

import com.thoughtworks.xstream.InitializationException;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAliasType;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.annotations.XStreamConverters;
import com.thoughtworks.xstream.annotations.XStreamImplicitCollection;
import com.thoughtworks.xstream.annotations.XStreamInclude;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.ConverterLookup;
import com.thoughtworks.xstream.converters.ConverterMatcher;
import com.thoughtworks.xstream.converters.ConverterRegistry;
import com.thoughtworks.xstream.converters.SingleValueConverter;
import com.thoughtworks.xstream.converters.SingleValueConverterWrapper;
import com.thoughtworks.xstream.converters.reflection.ReflectionProvider;
import com.thoughtworks.xstream.core.ClassLoaderReference;
import com.thoughtworks.xstream.core.JVM;
import com.thoughtworks.xstream.core.util.DependencyInjectionFactory;
import com.thoughtworks.xstream.core.util.TypedNull;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public class AnnotationMapper extends MapperWrapper implements AnnotationConfiguration {
    private final Set<Class<?>> annotatedTypes;
    private transient Object[] arguments;
    private transient AttributeMapper attributeMapper;
    private transient ClassAliasingMapper classAliasingMapper;
    private final Map<Class<?>, Map<List<Object>, Converter>> converterCache;
    private final ConverterRegistry converterRegistry;
    private transient DefaultImplementationsMapper defaultImplementationsMapper;
    private transient FieldAliasingMapper fieldAliasingMapper;
    private transient ImplicitCollectionMapper implicitCollectionMapper;
    private transient LocalConversionMapper localConversionMapper;
    private boolean locked;

    public AnnotationMapper(Mapper mapper, ConverterRegistry converterRegistry, ConverterLookup converterLookup, ClassLoaderReference classLoaderReference, ReflectionProvider reflectionProvider) {
        super(mapper);
        this.converterCache = new HashMap();
        this.annotatedTypes = Collections.synchronizedSet(new HashSet());
        this.converterRegistry = converterRegistry;
        this.annotatedTypes.add(Object.class);
        setupMappers();
        this.locked = true;
        Object reference = classLoaderReference.getReference();
        Object[] objArr = new Object[6];
        objArr[0] = this;
        objArr[1] = classLoaderReference;
        objArr[2] = reflectionProvider;
        objArr[3] = converterLookup;
        objArr[4] = new JVM();
        objArr[5] = reference == null ? new TypedNull(ClassLoader.class) : reference;
        this.arguments = objArr;
    }

    public AnnotationMapper(Mapper mapper, ConverterRegistry converterRegistry, ConverterLookup converterLookup, ClassLoader classLoader, ReflectionProvider reflectionProvider, JVM jvm) {
        this(mapper, converterRegistry, converterLookup, new ClassLoaderReference(classLoader), reflectionProvider);
    }

    @Override // com.thoughtworks.xstream.mapper.MapperWrapper, com.thoughtworks.xstream.mapper.Mapper
    public String realMember(Class cls, String str) {
        if (!this.locked) {
            processAnnotations(cls);
        }
        return super.realMember(cls, str);
    }

    @Override // com.thoughtworks.xstream.mapper.MapperWrapper, com.thoughtworks.xstream.mapper.Mapper
    public String serializedClass(Class cls) {
        if (!this.locked) {
            processAnnotations(cls);
        }
        return super.serializedClass(cls);
    }

    @Override // com.thoughtworks.xstream.mapper.MapperWrapper, com.thoughtworks.xstream.mapper.Mapper
    public Class defaultImplementationOf(Class cls) {
        if (!this.locked) {
            processAnnotations(cls);
        }
        Class defaultImplementationOf = super.defaultImplementationOf(cls);
        if (!this.locked) {
            processAnnotations(defaultImplementationOf);
        }
        return defaultImplementationOf;
    }

    @Override // com.thoughtworks.xstream.mapper.MapperWrapper, com.thoughtworks.xstream.mapper.Mapper
    public Converter getLocalConverter(Class cls, String str) {
        if (!this.locked) {
            processAnnotations(cls);
        }
        return super.getLocalConverter(cls, str);
    }

    @Override // com.thoughtworks.xstream.mapper.AnnotationConfiguration
    public void autodetectAnnotations(boolean z) {
        this.locked = !z;
    }

    @Override // com.thoughtworks.xstream.mapper.AnnotationConfiguration
    public void processAnnotations(Class[] clsArr) {
        if (clsArr == null || clsArr.length == 0) {
            return;
        }
        this.locked = true;
        Set<Class<?>> unprocessedTypesSet = new UnprocessedTypesSet();
        for (Class cls : clsArr) {
            unprocessedTypesSet.add(cls);
        }
        processTypes(unprocessedTypesSet);
    }

    private void processAnnotations(Class cls) {
        if (cls == null) {
            return;
        }
        UnprocessedTypesSet unprocessedTypesSet = new UnprocessedTypesSet();
        unprocessedTypesSet.add((UnprocessedTypesSet) cls);
        processTypes(unprocessedTypesSet);
    }

    private void processTypes(Set<Class<?>> set) {
        Field[] declaredFields;
        while (!set.isEmpty()) {
            Iterator<Class<?>> it = set.iterator();
            Class<?> next = it.next();
            it.remove();
            synchronized (next) {
                if (!this.annotatedTypes.contains(next)) {
                    if (next.isPrimitive()) {
                        this.annotatedTypes.add(next);
                    } else {
                        addParametrizedTypes(next, set);
                        processConverterAnnotations(next);
                        processAliasAnnotation(next, set);
                        processAliasTypeAnnotation(next);
                        if (next.isInterface()) {
                            this.annotatedTypes.add(next);
                        } else {
                            processImplicitCollectionAnnotation(next);
                            for (Field field : next.getDeclaredFields()) {
                                if (!field.isEnumConstant() && (field.getModifiers() & 136) <= 0) {
                                    addParametrizedTypes(field.getGenericType(), set);
                                    if (!field.isSynthetic()) {
                                        processFieldAliasAnnotation(field);
                                        processAsAttributeAnnotation(field);
                                        processImplicitAnnotation(field);
                                        processOmitFieldAnnotation(field);
                                        processLocalConverterAnnotation(field);
                                    }
                                }
                            }
                            this.annotatedTypes.add(next);
                        }
                    }
                }
            }
        }
    }

    private void addParametrizedTypes(Type type, final Set<Class<?>> set) {
        final HashSet hashSet = new HashSet();
        LinkedHashSet<Type> linkedHashSet = new LinkedHashSet<Type>() { // from class: com.thoughtworks.xstream.mapper.AnnotationMapper.1
            @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean add(Type type2) {
                if (type2 instanceof Class) {
                    return set.add((Class) type2);
                }
                if (type2 == null || hashSet.contains(type2)) {
                    return false;
                }
                return super.add((C39821) type2);
            }
        };
        while (type != null) {
            hashSet.add(type);
            int i = 0;
            if (type instanceof Class) {
                Class<?> cls = (Class) type;
                set.add(cls);
                if (!cls.isPrimitive()) {
                    for (TypeVariable<Class<?>> typeVariable : cls.getTypeParameters()) {
                        linkedHashSet.add(typeVariable);
                    }
                    linkedHashSet.add(cls.getGenericSuperclass());
                    Type[] genericInterfaces = cls.getGenericInterfaces();
                    int length = genericInterfaces.length;
                    while (i < length) {
                        linkedHashSet.add(genericInterfaces[i]);
                        i++;
                    }
                }
            } else if (type instanceof TypeVariable) {
                Type[] bounds = ((TypeVariable) type).getBounds();
                int length2 = bounds.length;
                while (i < length2) {
                    linkedHashSet.add(bounds[i]);
                    i++;
                }
            } else if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                linkedHashSet.add(parameterizedType.getRawType());
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                int length3 = actualTypeArguments.length;
                while (i < length3) {
                    linkedHashSet.add(actualTypeArguments[i]);
                    i++;
                }
            } else if (type instanceof GenericArrayType) {
                linkedHashSet.add(((GenericArrayType) type).getGenericComponentType());
            }
            if (linkedHashSet.isEmpty()) {
                type = null;
            } else {
                Iterator<Type> it = linkedHashSet.iterator();
                it.remove();
                type = it.next();
            }
        }
    }

    private void processConverterAnnotations(Class<?> cls) {
        if (this.converterRegistry != null) {
            XStreamConverters xStreamConverters = (XStreamConverters) cls.getAnnotation(XStreamConverters.class);
            XStreamConverter xStreamConverter = (XStreamConverter) cls.getAnnotation(XStreamConverter.class);
            ArrayList<XStreamConverter> arrayList = xStreamConverters != null ? new ArrayList(Arrays.asList(xStreamConverters.value())) : new ArrayList();
            if (xStreamConverter != null) {
                arrayList.add(xStreamConverter);
            }
            for (XStreamConverter xStreamConverter2 : arrayList) {
                Converter cacheConverter = cacheConverter(xStreamConverter2, xStreamConverter != null ? cls : null);
                if (cacheConverter != null) {
                    if (xStreamConverter != null || cacheConverter.canConvert(cls)) {
                        this.converterRegistry.registerConverter(cacheConverter, xStreamConverter2.priority());
                    } else {
                        throw new InitializationException("Converter " + xStreamConverter2.value().getName() + " cannot handle annotated class " + cls.getName());
                    }
                }
            }
        }
    }

    private void processAliasAnnotation(Class<?> cls, Set<Class<?>> set) {
        XStreamAlias xStreamAlias = (XStreamAlias) cls.getAnnotation(XStreamAlias.class);
        if (xStreamAlias != null) {
            ClassAliasingMapper classAliasingMapper = this.classAliasingMapper;
            if (classAliasingMapper == null) {
                throw new InitializationException("No " + ClassAliasingMapper.class.getName() + " available");
            }
            classAliasingMapper.addClassAlias(xStreamAlias.value(), cls);
            if (xStreamAlias.impl() != Void.class) {
                this.defaultImplementationsMapper.addDefaultImplementation(xStreamAlias.impl(), cls);
                if (cls.isInterface()) {
                    set.add(xStreamAlias.impl());
                }
            }
        }
    }

    private void processAliasTypeAnnotation(Class<?> cls) {
        XStreamAliasType xStreamAliasType = (XStreamAliasType) cls.getAnnotation(XStreamAliasType.class);
        if (xStreamAliasType != null) {
            ClassAliasingMapper classAliasingMapper = this.classAliasingMapper;
            if (classAliasingMapper == null) {
                throw new InitializationException("No " + ClassAliasingMapper.class.getName() + " available");
            }
            classAliasingMapper.addTypeAlias(xStreamAliasType.value(), cls);
        }
    }

    @Deprecated
    private void processImplicitCollectionAnnotation(Class<?> cls) {
        XStreamImplicitCollection xStreamImplicitCollection = (XStreamImplicitCollection) cls.getAnnotation(XStreamImplicitCollection.class);
        if (xStreamImplicitCollection != null) {
            if (this.implicitCollectionMapper == null) {
                throw new InitializationException("No " + ImplicitCollectionMapper.class.getName() + " available");
            }
            String value = xStreamImplicitCollection.value();
            String item = xStreamImplicitCollection.item();
            try {
                Type genericType = cls.getDeclaredField(value).getGenericType();
                Class<?> cls2 = genericType instanceof ParameterizedType ? getClass(((ParameterizedType) genericType).getActualTypeArguments()[0]) : null;
                if (cls2 == null) {
                    this.implicitCollectionMapper.add(cls, value, null, Object.class);
                } else if (item.equals("")) {
                    this.implicitCollectionMapper.add(cls, value, null, cls2);
                } else {
                    this.implicitCollectionMapper.add(cls, value, item, cls2);
                }
            } catch (NoSuchFieldException unused) {
                throw new InitializationException(cls.getName() + " does not have a field named '" + value + "' as required by " + XStreamImplicitCollection.class.getName());
            }
        }
    }

    private void processFieldAliasAnnotation(Field field) {
        XStreamAlias xStreamAlias = (XStreamAlias) field.getAnnotation(XStreamAlias.class);
        if (xStreamAlias != null) {
            FieldAliasingMapper fieldAliasingMapper = this.fieldAliasingMapper;
            if (fieldAliasingMapper == null) {
                throw new InitializationException("No " + FieldAliasingMapper.class.getName() + " available");
            }
            fieldAliasingMapper.addFieldAlias(xStreamAlias.value(), field.getDeclaringClass(), field.getName());
        }
    }

    private void processAsAttributeAnnotation(Field field) {
        if (((XStreamAsAttribute) field.getAnnotation(XStreamAsAttribute.class)) != null) {
            AttributeMapper attributeMapper = this.attributeMapper;
            if (attributeMapper == null) {
                throw new InitializationException("No " + AttributeMapper.class.getName() + " available");
            }
            attributeMapper.addAttributeFor(field);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void processImplicitAnnotation(java.lang.reflect.Field r9) {
        /*
            r8 = this;
            java.lang.Class<com.thoughtworks.xstream.annotations.XStreamImplicit> r0 = com.thoughtworks.xstream.annotations.XStreamImplicit.class
            java.lang.annotation.Annotation r0 = r9.getAnnotation(r0)
            com.thoughtworks.xstream.annotations.XStreamImplicit r0 = (com.thoughtworks.xstream.annotations.XStreamImplicit) r0
            if (r0 == 0) goto La9
            com.thoughtworks.xstream.mapper.ImplicitCollectionMapper r1 = r8.implicitCollectionMapper
            if (r1 == 0) goto L8a
            java.lang.String r4 = r9.getName()
            java.lang.String r1 = r0.itemFieldName()
            java.lang.String r0 = r0.keyFieldName()
            java.lang.Class<java.util.Map> r2 = java.util.Map.class
            java.lang.Class r3 = r9.getType()
            boolean r2 = r2.isAssignableFrom(r3)
            java.lang.Class r3 = r9.getType()
            boolean r3 = r3.isArray()
            r5 = 0
            if (r3 != 0) goto L45
            java.lang.reflect.Type r3 = r9.getGenericType()
            boolean r6 = r3 instanceof java.lang.reflect.ParameterizedType
            if (r6 == 0) goto L45
            java.lang.reflect.ParameterizedType r3 = (java.lang.reflect.ParameterizedType) r3
            java.lang.reflect.Type[] r3 = r3.getActualTypeArguments()
            r3 = r3[r2]
            java.lang.Class r3 = r8.getClass(r3)
            r6 = r3
            goto L46
        L45:
            r6 = r5
        L46:
            if (r2 == 0) goto L6c
            com.thoughtworks.xstream.mapper.ImplicitCollectionMapper r2 = r8.implicitCollectionMapper
            java.lang.Class r3 = r9.getDeclaringClass()
            if (r1 == 0) goto L59
            java.lang.String r9 = ""
            boolean r9 = r9.equals(r1)
            if (r9 != 0) goto L59
            goto L5a
        L59:
            r1 = r5
        L5a:
            if (r0 == 0) goto L66
            java.lang.String r9 = ""
            boolean r9 = r9.equals(r0)
            if (r9 != 0) goto L66
            r7 = r0
            goto L67
        L66:
            r7 = r5
        L67:
            r5 = r1
            r2.add(r3, r4, r5, r6, r7)
            return
        L6c:
            if (r1 == 0) goto L80
            java.lang.String r0 = ""
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L80
            com.thoughtworks.xstream.mapper.ImplicitCollectionMapper r0 = r8.implicitCollectionMapper
            java.lang.Class r9 = r9.getDeclaringClass()
            r0.add(r9, r4, r1, r6)
            return
        L80:
            com.thoughtworks.xstream.mapper.ImplicitCollectionMapper r0 = r8.implicitCollectionMapper
            java.lang.Class r9 = r9.getDeclaringClass()
            r0.add(r9, r4, r6)
            goto La9
        L8a:
            com.thoughtworks.xstream.InitializationException r9 = new com.thoughtworks.xstream.InitializationException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "No "
            r0.<init>(r1)
            java.lang.Class<com.thoughtworks.xstream.mapper.ImplicitCollectionMapper> r1 = com.thoughtworks.xstream.mapper.ImplicitCollectionMapper.class
            java.lang.String r1 = r1.getName()
            r0.append(r1)
            java.lang.String r1 = " available"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r9.<init>(r0)
            throw r9
        La9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.thoughtworks.xstream.mapper.AnnotationMapper.processImplicitAnnotation(java.lang.reflect.Field):void");
    }

    private void processOmitFieldAnnotation(Field field) {
        if (((XStreamOmitField) field.getAnnotation(XStreamOmitField.class)) != null) {
            FieldAliasingMapper fieldAliasingMapper = this.fieldAliasingMapper;
            if (fieldAliasingMapper == null) {
                throw new InitializationException("No " + FieldAliasingMapper.class.getName() + " available");
            }
            fieldAliasingMapper.omitField(field.getDeclaringClass(), field.getName());
        }
    }

    private void processLocalConverterAnnotation(Field field) {
        Converter cacheConverter;
        XStreamConverter xStreamConverter = (XStreamConverter) field.getAnnotation(XStreamConverter.class);
        if (xStreamConverter == null || (cacheConverter = cacheConverter(xStreamConverter, field.getType())) == null) {
            return;
        }
        LocalConversionMapper localConversionMapper = this.localConversionMapper;
        if (localConversionMapper == null) {
            throw new InitializationException("No " + LocalConversionMapper.class.getName() + " available");
        }
        localConversionMapper.registerLocalConverter(field.getDeclaringClass(), field.getName(), cacheConverter);
    }

    private Converter cacheConverter(XStreamConverter xStreamConverter, Class cls) {
        Object[] objArr;
        ArrayList arrayList = new ArrayList();
        if (cls != null && xStreamConverter.useImplicitType()) {
            arrayList.add(cls);
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(xStreamConverter.booleans());
        arrayList2.add(xStreamConverter.bytes());
        arrayList2.add(xStreamConverter.chars());
        arrayList2.add(xStreamConverter.doubles());
        arrayList2.add(xStreamConverter.floats());
        arrayList2.add(xStreamConverter.ints());
        arrayList2.add(xStreamConverter.longs());
        arrayList2.add(xStreamConverter.shorts());
        arrayList2.add(xStreamConverter.strings());
        arrayList2.add(xStreamConverter.types());
        Iterator it = arrayList2.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (next != null) {
                int length = Array.getLength(next);
                for (int i = 0; i < length; i++) {
                    Object obj = Array.get(next, i);
                    if (!arrayList.contains(obj)) {
                        arrayList.add(obj);
                    }
                }
            }
        }
        Class<? extends ConverterMatcher> value = xStreamConverter.value();
        Map<List<Object>, Converter> map = this.converterCache.get(value);
        Converter converter = map != null ? map.get(arrayList) : null;
        if (converter == null) {
            int size = arrayList.size();
            if (size > 0) {
                Object[] objArr2 = this.arguments;
                objArr = new Object[objArr2.length + size];
                System.arraycopy(objArr2, 0, objArr, size, objArr2.length);
                System.arraycopy(arrayList.toArray(new Object[size]), 0, objArr, 0, size);
            } else {
                objArr = this.arguments;
            }
            try {
                if (SingleValueConverter.class.isAssignableFrom(value) && !Converter.class.isAssignableFrom(value)) {
                    converter = new SingleValueConverterWrapper((SingleValueConverter) DependencyInjectionFactory.newInstance(value, objArr));
                } else {
                    converter = (Converter) DependencyInjectionFactory.newInstance(value, objArr);
                }
                if (map == null) {
                    map = new HashMap<>();
                    this.converterCache.put(value, map);
                }
                map.put(arrayList, converter);
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder("Cannot instantiate converter ");
                sb.append(value.getName());
                sb.append(cls != null ? " for type " + cls.getName() : "");
                throw new InitializationException(sb.toString(), e);
            }
        }
        return converter;
    }

    private Class<?> getClass(Type type) {
        if (type instanceof ParameterizedType) {
            return (Class) ((ParameterizedType) type).getRawType();
        }
        if (type instanceof Class) {
            return (Class) type;
        }
        return null;
    }

    private void setupMappers() {
        this.classAliasingMapper = (ClassAliasingMapper) lookupMapperOfType(ClassAliasingMapper.class);
        this.defaultImplementationsMapper = (DefaultImplementationsMapper) lookupMapperOfType(DefaultImplementationsMapper.class);
        this.implicitCollectionMapper = (ImplicitCollectionMapper) lookupMapperOfType(ImplicitCollectionMapper.class);
        this.fieldAliasingMapper = (FieldAliasingMapper) lookupMapperOfType(FieldAliasingMapper.class);
        this.attributeMapper = (AttributeMapper) lookupMapperOfType(AttributeMapper.class);
        this.localConversionMapper = (LocalConversionMapper) lookupMapperOfType(LocalConversionMapper.class);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        int length = this.arguments.length - 2;
        objectOutputStream.writeInt(length);
        for (int i = 0; i < length; i++) {
            objectOutputStream.writeObject(this.arguments[i]);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        setupMappers();
        int readInt = objectInputStream.readInt();
        this.arguments = new Object[readInt + 2];
        for (int i = 0; i < readInt; i++) {
            this.arguments[i] = objectInputStream.readObject();
            Object[] objArr = this.arguments;
            if (objArr[i] instanceof ClassLoaderReference) {
                objArr[readInt + 1] = ((ClassLoaderReference) objArr[i]).getReference();
            }
        }
        this.arguments[readInt] = new JVM();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class UnprocessedTypesSet extends LinkedHashSet<Class<?>> {
        private UnprocessedTypesSet() {
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean add(Class<?> cls) {
            XStreamInclude xStreamInclude;
            Class<?>[] value;
            if (cls == null) {
                return false;
            }
            while (cls.isArray()) {
                cls = cls.getComponentType();
            }
            String name = cls.getName();
            if (name.startsWith("java.") || name.startsWith("javax.")) {
                return false;
            }
            boolean add = AnnotationMapper.this.annotatedTypes.contains(cls) ? false : super.add((UnprocessedTypesSet) cls);
            if (add && (xStreamInclude = (XStreamInclude) cls.getAnnotation(XStreamInclude.class)) != null && (value = xStreamInclude.value()) != null) {
                for (Class<?> cls2 : value) {
                    add(cls2);
                }
            }
            return add;
        }
    }
}
