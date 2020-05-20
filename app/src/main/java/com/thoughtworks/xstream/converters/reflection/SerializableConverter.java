package com.thoughtworks.xstream.converters.reflection;

import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.converters.reflection.ReflectionProvider;
import com.thoughtworks.xstream.core.ClassLoaderReference;
import com.thoughtworks.xstream.core.util.CustomObjectInputStream;
import com.thoughtworks.xstream.core.util.CustomObjectOutputStream;
import com.thoughtworks.xstream.core.util.HierarchicalStreams;
import com.thoughtworks.xstream.mapper.Mapper;
import com.thoughtworks.xstream.p366io.ExtendedHierarchicalStreamWriterHelper;
import com.thoughtworks.xstream.p366io.HierarchicalStreamReader;
import com.thoughtworks.xstream.p366io.HierarchicalStreamWriter;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputValidation;
import java.io.ObjectStreamClass;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class SerializableConverter extends AbstractReflectionConverter {
    private static final String ATTRIBUTE_CLASS = "class";
    private static final String ATTRIBUTE_NAME = "name";
    private static final String ATTRIBUTE_SERIALIZATION = "serialization";
    private static final String ATTRIBUTE_VALUE_CUSTOM = "custom";
    private static final String ELEMENT_DEFAULT = "default";
    private static final String ELEMENT_FIELD = "field";
    private static final String ELEMENT_FIELDS = "fields";
    private static final String ELEMENT_NULL = "null";
    private static final String ELEMENT_UNSERIALIZABLE_PARENTS = "unserializable-parents";
    private final ClassLoaderReference classLoaderReference;

    public SerializableConverter(Mapper mapper, ReflectionProvider reflectionProvider, ClassLoaderReference classLoaderReference) {
        super(mapper, new UnserializableParentsReflectionProvider(reflectionProvider));
        this.classLoaderReference = classLoaderReference;
    }

    public SerializableConverter(Mapper mapper, ReflectionProvider reflectionProvider, ClassLoader classLoader) {
        this(mapper, reflectionProvider, new ClassLoaderReference(classLoader));
    }

    public SerializableConverter(Mapper mapper, ReflectionProvider reflectionProvider) {
        this(mapper, new UnserializableParentsReflectionProvider(reflectionProvider), new ClassLoaderReference(null));
    }

    @Override // com.thoughtworks.xstream.converters.ConverterMatcher
    public boolean canConvert(Class cls) {
        return isSerializable(cls);
    }

    private boolean isSerializable(Class cls) {
        if (Serializable.class.isAssignableFrom(cls)) {
            return this.serializationMethodInvoker.supportsReadObject(cls, true) || this.serializationMethodInvoker.supportsWriteObject(cls, true);
        }
        return false;
    }

    @Override // com.thoughtworks.xstream.converters.reflection.AbstractReflectionConverter
    public void doMarshal(final Object obj, final HierarchicalStreamWriter hierarchicalStreamWriter, final MarshallingContext marshallingContext) {
        String aliasForSystemAttribute;
        String aliasForSystemAttribute2;
        String aliasForSystemAttribute3 = this.mapper.aliasForSystemAttribute(ATTRIBUTE_SERIALIZATION);
        if (aliasForSystemAttribute3 != null) {
            hierarchicalStreamWriter.addAttribute(aliasForSystemAttribute3, "custom");
        }
        final Class[] clsArr = new Class[1];
        final boolean[] zArr = {false};
        CustomObjectOutputStream.StreamCallback streamCallback = new CustomObjectOutputStream.StreamCallback() { // from class: com.thoughtworks.xstream.converters.reflection.SerializableConverter.1
            @Override // com.thoughtworks.xstream.core.util.CustomObjectOutputStream.StreamCallback
            public void writeToStream(Object obj2) {
                if (obj2 == null) {
                    hierarchicalStreamWriter.startNode(SerializableConverter.ELEMENT_NULL);
                    hierarchicalStreamWriter.endNode();
                    return;
                }
                ExtendedHierarchicalStreamWriterHelper.startNode(hierarchicalStreamWriter, SerializableConverter.this.mapper.serializedClass(obj2.getClass()), obj2.getClass());
                marshallingContext.convertAnother(obj2);
                hierarchicalStreamWriter.endNode();
            }

            @Override // com.thoughtworks.xstream.core.util.CustomObjectOutputStream.StreamCallback
            public void writeFieldsToStream(Map map) {
                String aliasForSystemAttribute4;
                ObjectStreamClass lookup = ObjectStreamClass.lookup(clsArr[0]);
                hierarchicalStreamWriter.startNode(SerializableConverter.ELEMENT_DEFAULT);
                for (String str : map.keySet()) {
                    if (SerializableConverter.this.mapper.shouldSerializeMember(clsArr[0], str)) {
                        ObjectStreamField field = lookup.getField(str);
                        Object obj2 = map.get(str);
                        if (field == null) {
                            throw new ObjectAccessException("Class " + obj2.getClass().getName() + " may not write a field named '" + str + "'");
                        } else if (obj2 != null) {
                            ExtendedHierarchicalStreamWriterHelper.startNode(hierarchicalStreamWriter, SerializableConverter.this.mapper.serializedMember(obj.getClass(), str), obj2.getClass());
                            if (field.getType() != obj2.getClass() && !field.getType().isPrimitive() && (aliasForSystemAttribute4 = SerializableConverter.this.mapper.aliasForSystemAttribute("class")) != null) {
                                hierarchicalStreamWriter.addAttribute(aliasForSystemAttribute4, SerializableConverter.this.mapper.serializedClass(obj2.getClass()));
                            }
                            marshallingContext.convertAnother(obj2);
                            hierarchicalStreamWriter.endNode();
                        }
                    }
                }
                hierarchicalStreamWriter.endNode();
            }

            @Override // com.thoughtworks.xstream.core.util.CustomObjectOutputStream.StreamCallback
            public void defaultWriteObject() {
                ObjectStreamField[] fields;
                String aliasForSystemAttribute4;
                ObjectStreamClass lookup = ObjectStreamClass.lookup(clsArr[0]);
                if (lookup == null) {
                    return;
                }
                boolean z = false;
                for (ObjectStreamField objectStreamField : lookup.getFields()) {
                    Object readField = SerializableConverter.this.readField(objectStreamField, clsArr[0], obj);
                    if (readField != null) {
                        if (!zArr[0]) {
                            hierarchicalStreamWriter.startNode(SerializableConverter.this.mapper.serializedClass(clsArr[0]));
                            zArr[0] = true;
                        }
                        if (!z) {
                            hierarchicalStreamWriter.startNode(SerializableConverter.ELEMENT_DEFAULT);
                            z = true;
                        }
                        if (SerializableConverter.this.mapper.shouldSerializeMember(clsArr[0], objectStreamField.getName())) {
                            Class<?> cls = readField.getClass();
                            ExtendedHierarchicalStreamWriterHelper.startNode(hierarchicalStreamWriter, SerializableConverter.this.mapper.serializedMember(obj.getClass(), objectStreamField.getName()), cls);
                            if (!cls.equals(SerializableConverter.this.mapper.defaultImplementationOf(objectStreamField.getType())) && (aliasForSystemAttribute4 = SerializableConverter.this.mapper.aliasForSystemAttribute("class")) != null) {
                                hierarchicalStreamWriter.addAttribute(aliasForSystemAttribute4, SerializableConverter.this.mapper.serializedClass(cls));
                            }
                            marshallingContext.convertAnother(readField);
                            hierarchicalStreamWriter.endNode();
                        }
                    }
                }
                if (zArr[0] && !z) {
                    hierarchicalStreamWriter.startNode(SerializableConverter.ELEMENT_DEFAULT);
                    hierarchicalStreamWriter.endNode();
                } else if (z) {
                    hierarchicalStreamWriter.endNode();
                }
            }

            @Override // com.thoughtworks.xstream.core.util.CustomObjectOutputStream.StreamCallback
            public void flush() {
                hierarchicalStreamWriter.flush();
            }

            @Override // com.thoughtworks.xstream.core.util.CustomObjectOutputStream.StreamCallback
            public void close() {
                throw new UnsupportedOperationException("Objects are not allowed to call ObjectOutputStream.close() from writeObject()");
            }
        };
        try {
            boolean z = false;
            for (Class cls : hierarchyFor(obj.getClass())) {
                clsArr[0] = cls;
                if (Serializable.class.isAssignableFrom(clsArr[0])) {
                    if (z) {
                        marshalUnserializableParent(hierarchicalStreamWriter, marshallingContext, obj);
                        z = false;
                    }
                    if (this.serializationMethodInvoker.supportsWriteObject(clsArr[0], false)) {
                        zArr[0] = true;
                        hierarchicalStreamWriter.startNode(this.mapper.serializedClass(clsArr[0]));
                        if (clsArr[0] != this.mapper.defaultImplementationOf(clsArr[0]) && (aliasForSystemAttribute = this.mapper.aliasForSystemAttribute("class")) != null) {
                            hierarchicalStreamWriter.addAttribute(aliasForSystemAttribute, clsArr[0].getName());
                        }
                        CustomObjectOutputStream customObjectOutputStream = CustomObjectOutputStream.getInstance(marshallingContext, streamCallback);
                        this.serializationMethodInvoker.callWriteObject(clsArr[0], obj, customObjectOutputStream);
                        customObjectOutputStream.popCallback();
                        hierarchicalStreamWriter.endNode();
                    } else if (this.serializationMethodInvoker.supportsReadObject(clsArr[0], false)) {
                        zArr[0] = true;
                        hierarchicalStreamWriter.startNode(this.mapper.serializedClass(clsArr[0]));
                        if (clsArr[0] != this.mapper.defaultImplementationOf(clsArr[0]) && (aliasForSystemAttribute2 = this.mapper.aliasForSystemAttribute("class")) != null) {
                            hierarchicalStreamWriter.addAttribute(aliasForSystemAttribute2, clsArr[0].getName());
                        }
                        streamCallback.defaultWriteObject();
                        hierarchicalStreamWriter.endNode();
                    } else {
                        zArr[0] = false;
                        streamCallback.defaultWriteObject();
                        if (zArr[0]) {
                            hierarchicalStreamWriter.endNode();
                        }
                    }
                } else {
                    z = true;
                }
            }
        } catch (IOException e) {
            throw new ObjectAccessException("Could not call defaultWriteObject()", e);
        }
    }

    protected void marshalUnserializableParent(HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext, Object obj) {
        hierarchicalStreamWriter.startNode(ELEMENT_UNSERIALIZABLE_PARENTS);
        super.doMarshal(obj, hierarchicalStreamWriter, marshallingContext);
        hierarchicalStreamWriter.endNode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object readField(ObjectStreamField objectStreamField, Class cls, Object obj) {
        try {
            Field declaredField = cls.getDeclaredField(objectStreamField.getName());
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        } catch (IllegalAccessException e) {
            throw new ObjectAccessException("Could not get field " + objectStreamField.getClass() + "." + objectStreamField.getName(), e);
        } catch (IllegalArgumentException e2) {
            throw new ObjectAccessException("Could not get field " + objectStreamField.getClass() + "." + objectStreamField.getName(), e2);
        } catch (NoSuchFieldException e3) {
            throw new ObjectAccessException("Could not get field " + objectStreamField.getClass() + "." + objectStreamField.getName(), e3);
        } catch (SecurityException e4) {
            throw new ObjectAccessException("Could not get field " + objectStreamField.getClass() + "." + objectStreamField.getName(), e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List hierarchyFor(Class cls) {
        ArrayList arrayList = new ArrayList();
        while (cls != Object.class) {
            arrayList.add(cls);
            cls = cls.getSuperclass();
        }
        Collections.reverse(arrayList);
        return arrayList;
    }

    @Override // com.thoughtworks.xstream.converters.reflection.AbstractReflectionConverter
    public Object doUnmarshal(final Object obj, final HierarchicalStreamReader hierarchicalStreamReader, final UnmarshallingContext unmarshallingContext) {
        final Class[] clsArr = new Class[1];
        String aliasForSystemAttribute = this.mapper.aliasForSystemAttribute(ATTRIBUTE_SERIALIZATION);
        if (aliasForSystemAttribute != null && !"custom".equals(hierarchicalStreamReader.getAttribute(aliasForSystemAttribute))) {
            throw new ConversionException("Cannot deserialize object with new readObject()/writeObject() methods");
        }
        CustomObjectInputStream.StreamCallback streamCallback = new CustomObjectInputStream.StreamCallback() { // from class: com.thoughtworks.xstream.converters.reflection.SerializableConverter.2
            @Override // com.thoughtworks.xstream.core.util.CustomObjectInputStream.StreamCallback
            public Object readFromStream() {
                hierarchicalStreamReader.moveDown();
                Object convertAnother = unmarshallingContext.convertAnother(obj, HierarchicalStreams.readClassType(hierarchicalStreamReader, SerializableConverter.this.mapper));
                hierarchicalStreamReader.moveUp();
                return convertAnother;
            }

            @Override // com.thoughtworks.xstream.core.util.CustomObjectInputStream.StreamCallback
            public Map readFieldsFromStream() {
                Class type;
                HashMap hashMap = new HashMap();
                hierarchicalStreamReader.moveDown();
                if (hierarchicalStreamReader.getNodeName().equals(SerializableConverter.ELEMENT_FIELDS)) {
                    while (hierarchicalStreamReader.hasMoreChildren()) {
                        hierarchicalStreamReader.moveDown();
                        if (!hierarchicalStreamReader.getNodeName().equals(SerializableConverter.ELEMENT_FIELD)) {
                            throw new ConversionException("Expected <field/> element inside <field/>");
                        }
                        hashMap.put(hierarchicalStreamReader.getAttribute(SerializableConverter.ATTRIBUTE_NAME), unmarshallingContext.convertAnother(obj, SerializableConverter.this.mapper.realClass(hierarchicalStreamReader.getAttribute("class"))));
                        hierarchicalStreamReader.moveUp();
                    }
                } else if (hierarchicalStreamReader.getNodeName().equals(SerializableConverter.ELEMENT_DEFAULT)) {
                    ObjectStreamClass lookup = ObjectStreamClass.lookup(clsArr[0]);
                    while (hierarchicalStreamReader.hasMoreChildren()) {
                        hierarchicalStreamReader.moveDown();
                        String realMember = SerializableConverter.this.mapper.realMember(clsArr[0], hierarchicalStreamReader.getNodeName());
                        if (SerializableConverter.this.mapper.shouldSerializeMember(clsArr[0], realMember)) {
                            String readClassAttribute = HierarchicalStreams.readClassAttribute(hierarchicalStreamReader, SerializableConverter.this.mapper);
                            if (readClassAttribute != null) {
                                type = SerializableConverter.this.mapper.realClass(readClassAttribute);
                            } else {
                                ObjectStreamField field = lookup.getField(realMember);
                                if (field == null) {
                                    throw new MissingFieldException(clsArr[0].getName(), realMember);
                                }
                                type = field.getType();
                            }
                            hashMap.put(realMember, unmarshallingContext.convertAnother(obj, type));
                        }
                        hierarchicalStreamReader.moveUp();
                    }
                } else {
                    throw new ConversionException("Expected <fields/> or <default/> element when calling ObjectInputStream.readFields()");
                }
                hierarchicalStreamReader.moveUp();
                return hashMap;
            }

            @Override // com.thoughtworks.xstream.core.util.CustomObjectInputStream.StreamCallback
            public void defaultReadObject() {
                Class defaultImplementationOf;
                if (hierarchicalStreamReader.hasMoreChildren()) {
                    hierarchicalStreamReader.moveDown();
                    if (!hierarchicalStreamReader.getNodeName().equals(SerializableConverter.ELEMENT_DEFAULT)) {
                        throw new ConversionException("Expected <default/> element in readObject() stream");
                    }
                    while (hierarchicalStreamReader.hasMoreChildren()) {
                        hierarchicalStreamReader.moveDown();
                        String realMember = SerializableConverter.this.mapper.realMember(clsArr[0], hierarchicalStreamReader.getNodeName());
                        if (SerializableConverter.this.mapper.shouldSerializeMember(clsArr[0], realMember)) {
                            String readClassAttribute = HierarchicalStreams.readClassAttribute(hierarchicalStreamReader, SerializableConverter.this.mapper);
                            if (readClassAttribute != null) {
                                defaultImplementationOf = SerializableConverter.this.mapper.realClass(readClassAttribute);
                            } else {
                                defaultImplementationOf = SerializableConverter.this.mapper.defaultImplementationOf(SerializableConverter.this.reflectionProvider.getFieldType(obj, realMember, clsArr[0]));
                            }
                            SerializableConverter.this.reflectionProvider.writeField(obj, realMember, unmarshallingContext.convertAnother(obj, defaultImplementationOf), clsArr[0]);
                        }
                        hierarchicalStreamReader.moveUp();
                    }
                    hierarchicalStreamReader.moveUp();
                }
            }

            @Override // com.thoughtworks.xstream.core.util.CustomObjectInputStream.StreamCallback
            public void registerValidation(final ObjectInputValidation objectInputValidation, int i) {
                unmarshallingContext.addCompletionCallback(new Runnable() { // from class: com.thoughtworks.xstream.converters.reflection.SerializableConverter.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            objectInputValidation.validateObject();
                        } catch (InvalidObjectException e) {
                            throw new ObjectAccessException("Cannot validate object : " + e.getMessage(), e);
                        }
                    }
                }, i);
            }

            @Override // com.thoughtworks.xstream.core.util.CustomObjectInputStream.StreamCallback
            public void close() {
                throw new UnsupportedOperationException("Objects are not allowed to call ObjectInputStream.close() from readObject()");
            }
        };
        while (hierarchicalStreamReader.hasMoreChildren()) {
            hierarchicalStreamReader.moveDown();
            String nodeName = hierarchicalStreamReader.getNodeName();
            if (nodeName.equals(ELEMENT_UNSERIALIZABLE_PARENTS)) {
                super.doUnmarshal(obj, hierarchicalStreamReader, unmarshallingContext);
            } else {
                String readClassAttribute = HierarchicalStreams.readClassAttribute(hierarchicalStreamReader, this.mapper);
                if (readClassAttribute == null) {
                    clsArr[0] = this.mapper.defaultImplementationOf(this.mapper.realClass(nodeName));
                } else {
                    clsArr[0] = this.mapper.realClass(readClassAttribute);
                }
                if (this.serializationMethodInvoker.supportsReadObject(clsArr[0], false)) {
                    CustomObjectInputStream customObjectInputStream = CustomObjectInputStream.getInstance(unmarshallingContext, streamCallback, this.classLoaderReference);
                    this.serializationMethodInvoker.callReadObject(clsArr[0], obj, customObjectInputStream);
                    customObjectInputStream.popCallback();
                } else {
                    try {
                        streamCallback.defaultReadObject();
                    } catch (IOException e) {
                        throw new ObjectAccessException("Could not call defaultWriteObject()", e);
                    }
                }
            }
            hierarchicalStreamReader.moveUp();
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void doMarshalConditionally(Object obj, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {
        if (isSerializable(obj.getClass())) {
            doMarshal(obj, hierarchicalStreamWriter, marshallingContext);
        } else {
            super.doMarshal(obj, hierarchicalStreamWriter, marshallingContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object doUnmarshalConditionally(Object obj, HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
        return isSerializable(obj.getClass()) ? doUnmarshal(obj, hierarchicalStreamReader, unmarshallingContext) : super.doUnmarshal(obj, hierarchicalStreamReader, unmarshallingContext);
    }

    /* loaded from: classes2.dex */
    static class UnserializableParentsReflectionProvider extends ReflectionProviderWrapper {
        public UnserializableParentsReflectionProvider(ReflectionProvider reflectionProvider) {
            super(reflectionProvider);
        }

        @Override // com.thoughtworks.xstream.converters.reflection.ReflectionProviderWrapper, com.thoughtworks.xstream.converters.reflection.ReflectionProvider
        public void visitSerializableFields(Object obj, final ReflectionProvider.Visitor visitor) {
            this.wrapped.visitSerializableFields(obj, new ReflectionProvider.Visitor() { // from class: com.thoughtworks.xstream.converters.reflection.SerializableConverter.UnserializableParentsReflectionProvider.1
                @Override // com.thoughtworks.xstream.converters.reflection.ReflectionProvider.Visitor
                public void visit(String str, Class cls, Class cls2, Object obj2) {
                    if (Serializable.class.isAssignableFrom(cls2)) {
                        return;
                    }
                    visitor.visit(str, cls, cls2, obj2);
                }
            });
        }
    }
}
