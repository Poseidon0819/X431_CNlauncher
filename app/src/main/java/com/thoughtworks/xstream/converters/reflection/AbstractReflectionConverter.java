package com.thoughtworks.xstream.converters.reflection;

import com.itextpdf.text.html.HtmlTags;
import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.SingleValueConverter;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.converters.reflection.ReflectionProvider;
import com.thoughtworks.xstream.core.Caching;
import com.thoughtworks.xstream.core.ReferencingMarshallingContext;
import com.thoughtworks.xstream.core.util.ArrayIterator;
import com.thoughtworks.xstream.mapper.Mapper;
import com.thoughtworks.xstream.p366io.ExtendedHierarchicalStreamWriterHelper;
import com.thoughtworks.xstream.p366io.HierarchicalStreamReader;
import com.thoughtworks.xstream.p366io.HierarchicalStreamWriter;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public abstract class AbstractReflectionConverter implements Converter, Caching {
    protected final Mapper mapper;
    private transient ReflectionProvider pureJavaReflectionProvider;
    protected final ReflectionProvider reflectionProvider;
    protected transient SerializationMethodInvoker serializationMethodInvoker = new SerializationMethodInvoker();

    protected boolean shouldUnmarshalTransientFields() {
        return false;
    }

    public AbstractReflectionConverter(Mapper mapper, ReflectionProvider reflectionProvider) {
        this.mapper = mapper;
        this.reflectionProvider = reflectionProvider;
    }

    @Override // com.thoughtworks.xstream.converters.Converter
    public void marshal(Object obj, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {
        Object callWriteReplace = this.serializationMethodInvoker.callWriteReplace(obj);
        if (callWriteReplace != obj && (marshallingContext instanceof ReferencingMarshallingContext)) {
            ((ReferencingMarshallingContext) marshallingContext).replace(obj, callWriteReplace);
        }
        if (callWriteReplace.getClass() != obj.getClass()) {
            String aliasForSystemAttribute = this.mapper.aliasForSystemAttribute("resolves-to");
            if (aliasForSystemAttribute != null) {
                hierarchicalStreamWriter.addAttribute(aliasForSystemAttribute, this.mapper.serializedClass(callWriteReplace.getClass()));
            }
            marshallingContext.convertAnother(callWriteReplace);
            return;
        }
        doMarshal(callWriteReplace, hierarchicalStreamWriter, marshallingContext);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void doMarshal(final Object obj, final HierarchicalStreamWriter hierarchicalStreamWriter, final MarshallingContext marshallingContext) {
        final ArrayList arrayList = new ArrayList();
        final HashMap hashMap = new HashMap();
        this.reflectionProvider.visitSerializableFields(obj, new ReflectionProvider.Visitor() { // from class: com.thoughtworks.xstream.converters.reflection.AbstractReflectionConverter.1
            final Set writtenAttributes = new HashSet();

            @Override // com.thoughtworks.xstream.converters.reflection.ReflectionProvider.Visitor
            public void visit(String str, Class cls, Class cls2, Object obj2) {
                if (AbstractReflectionConverter.this.mapper.shouldSerializeMember(cls2, str)) {
                    if (!hashMap.containsKey(str)) {
                        Class<?> cls3 = obj.getClass();
                        if (cls2 != obj.getClass() && !AbstractReflectionConverter.this.mapper.shouldSerializeMember(cls3, str)) {
                            cls3 = cls2;
                        }
                        hashMap.put(str, AbstractReflectionConverter.this.reflectionProvider.getField(cls3, str));
                    }
                    SingleValueConverter converterFromItemType = AbstractReflectionConverter.this.mapper.getConverterFromItemType(str, cls, cls2);
                    if (converterFromItemType != null) {
                        String aliasForAttribute = AbstractReflectionConverter.this.mapper.aliasForAttribute(AbstractReflectionConverter.this.mapper.serializedMember(cls2, str));
                        if (obj2 != null) {
                            if (this.writtenAttributes.contains(str)) {
                                throw new ConversionException("Cannot write field with name '" + str + "' twice as attribute for object of type " + obj.getClass().getName());
                            }
                            String singleValueConverter = converterFromItemType.toString(obj2);
                            if (singleValueConverter != null) {
                                hierarchicalStreamWriter.addAttribute(aliasForAttribute, singleValueConverter);
                            }
                        }
                        this.writtenAttributes.add(str);
                        return;
                    }
                    arrayList.add(new FieldInfo(str, cls, cls2, obj2));
                }
            }
        });
        new Object() { // from class: com.thoughtworks.xstream.converters.reflection.AbstractReflectionConverter.2
            {
                Collection values;
                Iterator it;
                Class<?> cls;
                String serializedClass;
                for (FieldInfo fieldInfo : arrayList) {
                    if (fieldInfo.value != null) {
                        Mapper.ImplicitCollectionMapping implicitCollectionDefForFieldName = AbstractReflectionConverter.this.mapper.getImplicitCollectionDefForFieldName(obj.getClass(), fieldInfo.fieldName);
                        if (implicitCollectionDefForFieldName != null) {
                            if ((marshallingContext instanceof ReferencingMarshallingContext) && fieldInfo.value != Collections.EMPTY_LIST && fieldInfo.value != Collections.EMPTY_SET && fieldInfo.value != Collections.EMPTY_MAP) {
                                ((ReferencingMarshallingContext) marshallingContext).registerImplicit(fieldInfo.value);
                            }
                            boolean z = fieldInfo.value instanceof Collection;
                            boolean z2 = (fieldInfo.value instanceof Map) && implicitCollectionDefForFieldName.getKeyFieldName() == null;
                            if (fieldInfo.value.getClass().isArray()) {
                                it = new ArrayIterator(fieldInfo.value);
                            } else {
                                if (z) {
                                    values = (Collection) fieldInfo.value;
                                } else if (z2) {
                                    it = ((Map) fieldInfo.value).entrySet().iterator();
                                } else {
                                    values = ((Map) fieldInfo.value).values();
                                }
                                it = values.iterator();
                            }
                            while (it.hasNext()) {
                                Object next = it.next();
                                if (next == null) {
                                    cls = Object.class;
                                    serializedClass = AbstractReflectionConverter.this.mapper.serializedClass(null);
                                } else if (z2) {
                                    Map.Entry entry = (Map.Entry) next;
                                    ExtendedHierarchicalStreamWriterHelper.startNode(hierarchicalStreamWriter, implicitCollectionDefForFieldName.getItemFieldName() != null ? implicitCollectionDefForFieldName.getItemFieldName() : AbstractReflectionConverter.this.mapper.serializedClass(Map.Entry.class), entry.getClass());
                                    writeItem(entry.getKey(), marshallingContext, hierarchicalStreamWriter);
                                    writeItem(entry.getValue(), marshallingContext, hierarchicalStreamWriter);
                                    hierarchicalStreamWriter.endNode();
                                } else if (implicitCollectionDefForFieldName.getItemFieldName() != null) {
                                    cls = implicitCollectionDefForFieldName.getItemType();
                                    serializedClass = implicitCollectionDefForFieldName.getItemFieldName();
                                } else {
                                    cls = next.getClass();
                                    serializedClass = AbstractReflectionConverter.this.mapper.serializedClass(cls);
                                }
                                writeField(fieldInfo.fieldName, serializedClass, cls, fieldInfo.definedIn, next);
                            }
                        } else {
                            writeField(fieldInfo.fieldName, null, fieldInfo.type, fieldInfo.definedIn, fieldInfo.value);
                        }
                    }
                }
            }

            void writeField(String str, String str2, Class cls, Class cls2, Object obj2) {
                String aliasForSystemAttribute;
                String aliasForSystemAttribute2;
                Class<?> cls3 = obj2 != null ? obj2.getClass() : cls;
                HierarchicalStreamWriter hierarchicalStreamWriter2 = hierarchicalStreamWriter;
                if (str2 == null) {
                    str2 = AbstractReflectionConverter.this.mapper.serializedMember(obj.getClass(), str);
                }
                ExtendedHierarchicalStreamWriterHelper.startNode(hierarchicalStreamWriter2, str2, cls3);
                if (obj2 != null) {
                    Class defaultImplementationOf = AbstractReflectionConverter.this.mapper.defaultImplementationOf(cls);
                    if (!cls3.equals(defaultImplementationOf)) {
                        String serializedClass = AbstractReflectionConverter.this.mapper.serializedClass(cls3);
                        if (!serializedClass.equals(AbstractReflectionConverter.this.mapper.serializedClass(defaultImplementationOf)) && (aliasForSystemAttribute2 = AbstractReflectionConverter.this.mapper.aliasForSystemAttribute(HtmlTags.CLASS)) != null) {
                            hierarchicalStreamWriter.addAttribute(aliasForSystemAttribute2, serializedClass);
                        }
                    }
                    if (((Field) hashMap.get(str)).getDeclaringClass() != cls2 && (aliasForSystemAttribute = AbstractReflectionConverter.this.mapper.aliasForSystemAttribute("defined-in")) != null) {
                        hierarchicalStreamWriter.addAttribute(aliasForSystemAttribute, AbstractReflectionConverter.this.mapper.serializedClass(cls2));
                    }
                    AbstractReflectionConverter.this.marshallField(marshallingContext, obj2, AbstractReflectionConverter.this.reflectionProvider.getField(cls2, str));
                }
                hierarchicalStreamWriter.endNode();
            }

            void writeItem(Object obj2, MarshallingContext marshallingContext2, HierarchicalStreamWriter hierarchicalStreamWriter2) {
                if (obj2 == null) {
                    ExtendedHierarchicalStreamWriterHelper.startNode(hierarchicalStreamWriter2, AbstractReflectionConverter.this.mapper.serializedClass(null), Mapper.Null.class);
                    hierarchicalStreamWriter2.endNode();
                    return;
                }
                ExtendedHierarchicalStreamWriterHelper.startNode(hierarchicalStreamWriter2, AbstractReflectionConverter.this.mapper.serializedClass(obj2.getClass()), obj2.getClass());
                marshallingContext2.convertAnother(obj2);
                hierarchicalStreamWriter2.endNode();
            }
        };
    }

    protected void marshallField(MarshallingContext marshallingContext, Object obj, Field field) {
        marshallingContext.convertAnother(obj, this.mapper.getLocalConverter(field.getDeclaringClass(), field.getName()));
    }

    @Override // com.thoughtworks.xstream.converters.Converter
    public Object unmarshal(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
        return this.serializationMethodInvoker.callReadResolve(doUnmarshal(instantiateNewInstance(hierarchicalStreamReader, unmarshallingContext), hierarchicalStreamReader, unmarshallingContext));
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0231  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object doUnmarshal(java.lang.Object r13, com.thoughtworks.xstream.p366io.HierarchicalStreamReader r14, com.thoughtworks.xstream.converters.UnmarshallingContext r15) {
        /*
            Method dump skipped, instructions count: 648
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.thoughtworks.xstream.converters.reflection.AbstractReflectionConverter.doUnmarshal(java.lang.Object, com.thoughtworks.xstream.io.HierarchicalStreamReader, com.thoughtworks.xstream.converters.UnmarshallingContext):java.lang.Object");
    }

    protected Object unmarshallField(UnmarshallingContext unmarshallingContext, Object obj, Class cls, Field field) {
        return unmarshallingContext.convertAnother(obj, cls, this.mapper.getLocalConverter(field.getDeclaringClass(), field.getName()));
    }

    protected boolean shouldUnmarshalField(Field field) {
        return !Modifier.isTransient(field.getModifiers()) || shouldUnmarshalTransientFields();
    }

    private void handleUnknownField(Class cls, String str, Class cls2, String str2) {
        if (cls == null) {
            for (Class cls3 = cls2; cls3 != null; cls3 = cls3.getSuperclass()) {
                if (!this.mapper.shouldSerializeMember(cls3, str2)) {
                    return;
                }
            }
        }
        throw new UnknownFieldException(cls2.getName(), str);
    }

    private void writeValueToImplicitCollection(Object obj, Map map, Object obj2, String str) {
        Collection mappingList;
        Collection collection = (Collection) map.get(str);
        if (collection == null) {
            Class fieldType = this.reflectionProvider.getFieldType(obj2, str, null);
            if (fieldType.isArray()) {
                collection = new ArraysList(fieldType);
            } else {
                Class defaultImplementationOf = this.mapper.defaultImplementationOf(fieldType);
                if (!Collection.class.isAssignableFrom(defaultImplementationOf) && !Map.class.isAssignableFrom(defaultImplementationOf)) {
                    throw new ObjectAccessException("Field " + str + " of " + obj2.getClass().getName() + " is configured for an implicit Collection or Map, but field is of type " + defaultImplementationOf.getName());
                }
                if (this.pureJavaReflectionProvider == null) {
                    this.pureJavaReflectionProvider = new PureJavaReflectionProvider();
                }
                Object newInstance = this.pureJavaReflectionProvider.newInstance(defaultImplementationOf);
                if (newInstance instanceof Collection) {
                    mappingList = (Collection) newInstance;
                } else {
                    mappingList = new MappingList((Map) newInstance, this.mapper.getImplicitCollectionDefForFieldName(obj2.getClass(), str).getKeyFieldName());
                }
                this.reflectionProvider.writeField(obj2, str, newInstance, null);
                collection = mappingList;
            }
            map.put(str, collection);
        }
        collection.add(obj);
    }

    private Class readDeclaringClass(HierarchicalStreamReader hierarchicalStreamReader) {
        String aliasForSystemAttribute = this.mapper.aliasForSystemAttribute("defined-in");
        String attribute = aliasForSystemAttribute == null ? null : hierarchicalStreamReader.getAttribute(aliasForSystemAttribute);
        if (attribute == null) {
            return null;
        }
        return this.mapper.realClass(attribute);
    }

    protected Object instantiateNewInstance(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
        String aliasForSystemAttribute = this.mapper.aliasForSystemAttribute("resolves-to");
        String attribute = aliasForSystemAttribute == null ? null : hierarchicalStreamReader.getAttribute(aliasForSystemAttribute);
        Object currentObject = unmarshallingContext.currentObject();
        if (currentObject != null) {
            return currentObject;
        }
        if (attribute != null) {
            return this.reflectionProvider.newInstance(this.mapper.realClass(attribute));
        }
        return this.reflectionProvider.newInstance(unmarshallingContext.getRequiredType());
    }

    @Override // com.thoughtworks.xstream.core.Caching
    public void flushCache() {
        this.serializationMethodInvoker.flushCache();
    }

    private Object readResolve() {
        this.serializationMethodInvoker = new SerializationMethodInvoker();
        return this;
    }

    /* loaded from: classes2.dex */
    public static class DuplicateFieldException extends ConversionException {
        public DuplicateFieldException(String str) {
            super("Duplicate field ".concat(String.valueOf(str)));
            add("field", str);
        }
    }

    /* loaded from: classes2.dex */
    public static class UnknownFieldException extends ConversionException {
        public UnknownFieldException(String str, String str2) {
            super("No such field " + str + "." + str2);
            add("field", str2);
        }
    }

    /* loaded from: classes2.dex */
    static class FieldInfo {
        final Class definedIn;
        final String fieldName;
        final Class type;
        final Object value;

        FieldInfo(String str, Class cls, Class cls2, Object obj) {
            this.fieldName = str;
            this.type = cls;
            this.definedIn = cls2;
            this.value = obj;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class ArraysList extends ArrayList {
        final Class physicalFieldType;

        ArraysList(Class cls) {
            this.physicalFieldType = cls;
        }

        Object toPhysicalArray() {
            Object[] array = toArray();
            Object newInstance = Array.newInstance(this.physicalFieldType.getComponentType(), array.length);
            if (this.physicalFieldType.getComponentType().isPrimitive()) {
                for (int i = 0; i < array.length; i++) {
                    Array.set(newInstance, i, Array.get(array, i));
                }
            } else {
                System.arraycopy(array, 0, newInstance, 0, array.length);
            }
            return newInstance;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class MappingList extends AbstractList {
        private final Map fieldCache = new HashMap();
        private final String keyFieldName;
        private final Map map;

        public MappingList(Map map, String str) {
            this.map = map;
            this.keyFieldName = str;
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean add(Object obj) {
            if (obj == null) {
                boolean z = !this.map.containsKey(null);
                this.map.put(null, null);
                return z;
            }
            Class<?> cls = obj.getClass();
            if (this.keyFieldName != null) {
                Field field = (Field) this.fieldCache.get(cls);
                if (field == null) {
                    field = AbstractReflectionConverter.this.reflectionProvider.getField(cls, this.keyFieldName);
                    this.fieldCache.put(cls, field);
                }
                if (field != null) {
                    try {
                        return this.map.put(field.get(obj), obj) == null;
                    } catch (IllegalAccessException e) {
                        throw new ObjectAccessException("Could not get field " + field.getClass() + "." + field.getName(), e);
                    } catch (IllegalArgumentException e2) {
                        throw new ObjectAccessException("Could not get field " + field.getClass() + "." + field.getName(), e2);
                    }
                }
            } else if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                return this.map.put(entry.getKey(), entry.getValue()) == null;
            }
            throw new ConversionException("Element of type " + obj.getClass().getName() + " is not defined as entry for map of type " + this.map.getClass().getName());
        }

        @Override // java.util.AbstractList, java.util.List
        public Object get(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.map.size();
        }
    }
}
