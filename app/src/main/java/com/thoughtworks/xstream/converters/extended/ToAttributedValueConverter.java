package com.thoughtworks.xstream.converters.extended;

import com.itextpdf.text.html.HtmlTags;
import com.mopub.mobileads.VastExtensionXmlManager;
import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.ConverterLookup;
import com.thoughtworks.xstream.converters.ConverterMatcher;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.SingleValueConverter;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.converters.reflection.AbstractReflectionConverter;
import com.thoughtworks.xstream.converters.reflection.ReflectionProvider;
import com.thoughtworks.xstream.core.JVM;
import com.thoughtworks.xstream.core.util.FastField;
import com.thoughtworks.xstream.core.util.HierarchicalStreams;
import com.thoughtworks.xstream.core.util.Primitives;
import com.thoughtworks.xstream.mapper.Mapper;
import com.thoughtworks.xstream.p366io.HierarchicalStreamReader;
import com.thoughtworks.xstream.p366io.HierarchicalStreamWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class ToAttributedValueConverter implements Converter {
    private static final String STRUCTURE_MARKER = "";
    private final Mapper enumMapper;
    private final ConverterLookup lookup;
    private final Mapper mapper;
    private final ReflectionProvider reflectionProvider;
    private final Class type;
    private final Field valueField;

    public ToAttributedValueConverter(Class cls, Mapper mapper, ReflectionProvider reflectionProvider, ConverterLookup converterLookup, String str) {
        this(cls, mapper, reflectionProvider, converterLookup, str, null);
    }

    public ToAttributedValueConverter(Class cls, Mapper mapper, ReflectionProvider reflectionProvider, ConverterLookup converterLookup, String str, Class cls2) {
        this.type = cls;
        this.mapper = mapper;
        this.reflectionProvider = reflectionProvider;
        this.lookup = converterLookup;
        if (str == null) {
            this.valueField = null;
        } else {
            try {
                Field declaredField = (cls2 != null ? cls2 : cls).getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                this.valueField = declaredField;
            } catch (NoSuchFieldException e) {
                throw new IllegalArgumentException(e.getMessage() + ": " + str);
            }
        }
        this.enumMapper = JVM.is15() ? UseAttributeForEnumMapper.createEnumMapper(mapper) : null;
    }

    @Override // com.thoughtworks.xstream.converters.ConverterMatcher
    public boolean canConvert(Class cls) {
        return this.type == cls;
    }

    @Override // com.thoughtworks.xstream.converters.Converter
    public void marshal(Object obj, final HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {
        String aliasForSystemAttribute;
        final Class<?> cls = obj.getClass();
        final HashMap hashMap = new HashMap();
        final String[] strArr = new String[1];
        final Object[] objArr = new Object[1];
        final Class[] clsArr = new Class[1];
        final Class[] clsArr2 = new Class[1];
        this.reflectionProvider.visitSerializableFields(obj, new ReflectionProvider.Visitor() { // from class: com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter.1
            @Override // com.thoughtworks.xstream.converters.reflection.ReflectionProvider.Visitor
            public void visit(String str, Class cls2, Class cls3, Object obj2) {
                if (ToAttributedValueConverter.this.mapper.shouldSerializeMember(cls3, str)) {
                    FastField fastField = new FastField(cls3, str);
                    String serializedMember = ToAttributedValueConverter.this.mapper.serializedMember(cls3, str);
                    if (!hashMap.containsKey(serializedMember)) {
                        hashMap.put(serializedMember, ToAttributedValueConverter.this.reflectionProvider.getField(cls, str));
                    } else if (!ToAttributedValueConverter.this.fieldIsEqual(fastField)) {
                        ConversionException conversionException = new ConversionException("Cannot write attribute twice for object");
                        conversionException.add("alias", serializedMember);
                        conversionException.add(VastExtensionXmlManager.TYPE, cls.getName());
                        throw conversionException;
                    }
                    ConverterMatcher converterFromItemType = UseAttributeForEnumMapper.isEnum(cls2) ? ToAttributedValueConverter.this.enumMapper.getConverterFromItemType(null, cls2, null) : ToAttributedValueConverter.this.mapper.getLocalConverter(cls3, str);
                    if (converterFromItemType == null) {
                        converterFromItemType = ToAttributedValueConverter.this.lookup.lookupConverterForType(cls2);
                    }
                    if (obj2 != null) {
                        boolean z = ToAttributedValueConverter.this.valueField != null && ToAttributedValueConverter.this.fieldIsEqual(fastField);
                        if (z) {
                            clsArr2[0] = cls3;
                            clsArr[0] = cls2;
                            objArr[0] = obj2;
                            strArr[0] = "";
                        }
                        if (!(converterFromItemType instanceof SingleValueConverter)) {
                            if (z) {
                                return;
                            }
                            ConversionException conversionException2 = new ConversionException("Cannot write element as attribute");
                            conversionException2.add("alias", serializedMember);
                            conversionException2.add(VastExtensionXmlManager.TYPE, cls.getName());
                            throw conversionException2;
                        }
                        String singleValueConverter = ((SingleValueConverter) converterFromItemType).toString(obj2);
                        if (z) {
                            strArr[0] = singleValueConverter;
                        } else if (singleValueConverter != null) {
                            hierarchicalStreamWriter.addAttribute(serializedMember, singleValueConverter);
                        }
                    }
                }
            }
        });
        if (strArr[0] != null) {
            Class<?> cls2 = objArr[0].getClass();
            Class defaultImplementationOf = this.mapper.defaultImplementationOf(clsArr[0]);
            if (!cls2.equals(defaultImplementationOf)) {
                String serializedClass = this.mapper.serializedClass(cls2);
                if (!serializedClass.equals(this.mapper.serializedClass(defaultImplementationOf)) && (aliasForSystemAttribute = this.mapper.aliasForSystemAttribute(HtmlTags.CLASS)) != null) {
                    hierarchicalStreamWriter.addAttribute(aliasForSystemAttribute, serializedClass);
                }
            }
            if (strArr[0] == "") {
                marshallingContext.convertAnother(objArr[0]);
            } else {
                hierarchicalStreamWriter.setValue(strArr[0]);
            }
        }
    }

    @Override // com.thoughtworks.xstream.converters.Converter
    public Object unmarshal(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
        Class defaultImplementationOf;
        String realMember;
        Field fieldOrNull;
        Object newInstance = this.reflectionProvider.newInstance(unmarshallingContext.getRequiredType());
        Class<?> cls = newInstance.getClass();
        HashSet hashSet = new HashSet();
        Iterator attributeNames = hierarchicalStreamReader.getAttributeNames();
        HashSet hashSet2 = new HashSet();
        hashSet2.add(this.mapper.aliasForSystemAttribute(HtmlTags.CLASS));
        while (true) {
            if (attributeNames.hasNext()) {
                String str = (String) attributeNames.next();
                if (!hashSet2.contains(str) && (fieldOrNull = this.reflectionProvider.getFieldOrNull(cls, (realMember = this.mapper.realMember(cls, str)))) != null && !Modifier.isTransient(fieldOrNull.getModifiers())) {
                    Class<?> type = fieldOrNull.getType();
                    Class<?> declaringClass = fieldOrNull.getDeclaringClass();
                    ConverterMatcher converterFromItemType = UseAttributeForEnumMapper.isEnum(type) ? this.enumMapper.getConverterFromItemType(null, type, null) : this.mapper.getLocalConverter(declaringClass, realMember);
                    if (converterFromItemType == null) {
                        converterFromItemType = this.lookup.lookupConverterForType(type);
                    }
                    if (!(converterFromItemType instanceof SingleValueConverter)) {
                        ConversionException conversionException = new ConversionException("Cannot read field as a single value for object");
                        conversionException.add("field", realMember);
                        conversionException.add(VastExtensionXmlManager.TYPE, cls.getName());
                        throw conversionException;
                    } else if (converterFromItemType != null) {
                        Object fromString = ((SingleValueConverter) converterFromItemType).fromString(hierarchicalStreamReader.getAttribute(str));
                        if (type.isPrimitive()) {
                            type = Primitives.box(type);
                        }
                        if (fromString != null && !type.isAssignableFrom(fromString.getClass())) {
                            ConversionException conversionException2 = new ConversionException("Cannot assign object to type");
                            conversionException2.add("object type", fromString.getClass().getName());
                            conversionException2.add("target type", type.getName());
                            throw conversionException2;
                        }
                        this.reflectionProvider.writeField(newInstance, realMember, fromString, declaringClass);
                        if (!hashSet.add(new FastField(declaringClass, realMember))) {
                            throw new AbstractReflectionConverter.DuplicateFieldException(realMember + " [" + declaringClass.getName() + "]");
                        }
                    } else {
                        continue;
                    }
                }
            } else {
                Field field = this.valueField;
                if (field != null) {
                    Class<?> declaringClass2 = field.getDeclaringClass();
                    String name = this.valueField.getName();
                    Field field2 = name != null ? this.reflectionProvider.getField(declaringClass2, name) : null;
                    if (name == null || field2 == null) {
                        ConversionException conversionException3 = new ConversionException("Cannot assign value to field of type");
                        conversionException3.add("element", hierarchicalStreamReader.getNodeName());
                        conversionException3.add("field", name);
                        conversionException3.add("target type", unmarshallingContext.getRequiredType().getName());
                        throw conversionException3;
                    }
                    String readClassAttribute = HierarchicalStreams.readClassAttribute(hierarchicalStreamReader, this.mapper);
                    if (readClassAttribute != null) {
                        defaultImplementationOf = this.mapper.realClass(readClassAttribute);
                    } else {
                        defaultImplementationOf = this.mapper.defaultImplementationOf(this.reflectionProvider.getFieldType(newInstance, name, declaringClass2));
                    }
                    Object convertAnother = unmarshallingContext.convertAnother(newInstance, defaultImplementationOf, this.mapper.getLocalConverter(field2.getDeclaringClass(), field2.getName()));
                    Class fieldType = this.reflectionProvider.getFieldType(newInstance, name, declaringClass2);
                    if (!fieldType.isPrimitive()) {
                        defaultImplementationOf = fieldType;
                    }
                    if (convertAnother != null && !defaultImplementationOf.isAssignableFrom(convertAnother.getClass())) {
                        ConversionException conversionException4 = new ConversionException("Cannot assign object to type");
                        conversionException4.add("object type", convertAnother.getClass().getName());
                        conversionException4.add("target type", defaultImplementationOf.getName());
                        throw conversionException4;
                    }
                    this.reflectionProvider.writeField(newInstance, name, convertAnother, declaringClass2);
                    if (!hashSet.add(new FastField(declaringClass2, name))) {
                        throw new AbstractReflectionConverter.DuplicateFieldException(name + " [" + declaringClass2.getName() + "]");
                    }
                }
                return newInstance;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean fieldIsEqual(FastField fastField) {
        return this.valueField.getName().equals(fastField.getName()) && this.valueField.getDeclaringClass().getName().equals(fastField.getDeclaringClass());
    }
}
