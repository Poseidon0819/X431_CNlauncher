package com.thoughtworks.xstream.mapper;

import com.thoughtworks.xstream.InitializationException;
import com.thoughtworks.xstream.core.util.Primitives;
import com.thoughtworks.xstream.mapper.Mapper;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class ImplicitCollectionMapper extends MapperWrapper {
    private final Map classNameToMapper;

    public ImplicitCollectionMapper(Mapper mapper) {
        super(mapper);
        this.classNameToMapper = new HashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImplicitCollectionMapperForClass getMapper(Class cls) {
        while (cls != null) {
            ImplicitCollectionMapperForClass implicitCollectionMapperForClass = (ImplicitCollectionMapperForClass) this.classNameToMapper.get(cls);
            if (implicitCollectionMapperForClass != null) {
                return implicitCollectionMapperForClass;
            }
            cls = cls.getSuperclass();
        }
        return null;
    }

    private ImplicitCollectionMapperForClass getOrCreateMapper(Class cls) {
        ImplicitCollectionMapperForClass implicitCollectionMapperForClass = (ImplicitCollectionMapperForClass) this.classNameToMapper.get(cls);
        if (implicitCollectionMapperForClass == null) {
            ImplicitCollectionMapperForClass implicitCollectionMapperForClass2 = new ImplicitCollectionMapperForClass(cls);
            this.classNameToMapper.put(cls, implicitCollectionMapperForClass2);
            return implicitCollectionMapperForClass2;
        }
        return implicitCollectionMapperForClass;
    }

    @Override // com.thoughtworks.xstream.mapper.MapperWrapper, com.thoughtworks.xstream.mapper.Mapper
    public String getFieldNameForItemTypeAndName(Class cls, Class cls2, String str) {
        ImplicitCollectionMapperForClass mapper = getMapper(cls);
        if (mapper != null) {
            return mapper.getFieldNameForItemTypeAndName(cls2, str);
        }
        return null;
    }

    @Override // com.thoughtworks.xstream.mapper.MapperWrapper, com.thoughtworks.xstream.mapper.Mapper
    public Class getItemTypeForItemFieldName(Class cls, String str) {
        ImplicitCollectionMapperForClass mapper = getMapper(cls);
        if (mapper != null) {
            return mapper.getItemTypeForItemFieldName(str);
        }
        return null;
    }

    @Override // com.thoughtworks.xstream.mapper.MapperWrapper, com.thoughtworks.xstream.mapper.Mapper
    public Mapper.ImplicitCollectionMapping getImplicitCollectionDefForFieldName(Class cls, String str) {
        ImplicitCollectionMapperForClass mapper = getMapper(cls);
        if (mapper != null) {
            return mapper.getImplicitCollectionDefForFieldName(str);
        }
        return null;
    }

    public void add(Class cls, String str, Class cls2) {
        add(cls, str, null, cls2);
    }

    public void add(Class cls, String str, String str2, Class cls2) {
        add(cls, str, str2, cls2, null);
    }

    public void add(Class cls, String str, String str2, Class cls2, String str3) {
        Field field;
        Class cls3 = cls;
        while (true) {
            if (cls3 == Object.class) {
                field = null;
                break;
            }
            try {
                field = cls3.getDeclaredField(str);
                break;
            } catch (NoSuchFieldException unused) {
                cls3 = cls3.getSuperclass();
            } catch (SecurityException e) {
                throw new InitializationException("Access denied for field with implicit collection", e);
            }
        }
        if (field == null) {
            throw new InitializationException("No field \"" + str + "\" for implicit collection");
        }
        if (Map.class.isAssignableFrom(field.getType())) {
            if (str2 == null && str3 == null) {
                cls2 = Map.Entry.class;
            }
        } else if (!Collection.class.isAssignableFrom(field.getType())) {
            Class<?> type = field.getType();
            if (!type.isArray()) {
                throw new InitializationException("Field \"" + str + "\" declares no collection or array");
            }
            Class componentType = type.getComponentType();
            if (componentType.isPrimitive()) {
                componentType = Primitives.box(componentType);
            }
            if (cls2 == null) {
                cls2 = componentType;
            } else {
                if (cls2.isPrimitive()) {
                    cls2 = Primitives.box(cls2);
                }
                if (!componentType.isAssignableFrom(cls2)) {
                    throw new InitializationException("Field \"" + str + "\" declares an array, but the array type is not compatible with " + cls2.getName());
                }
            }
        }
        getOrCreateMapper(cls).add(new ImplicitCollectionMappingImpl(str, cls2, str2, str3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class ImplicitCollectionMapperForClass {
        private Class definedIn;
        private Map namedItemTypeToDef = new HashMap();
        private Map itemFieldNameToDef = new HashMap();
        private Map fieldNameToDef = new HashMap();

        ImplicitCollectionMapperForClass(Class cls) {
            this.definedIn = cls;
        }

        /* JADX WARN: Code restructure failed: missing block: B:24:0x0061, code lost:
            if (r2 == null) goto L42;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x0067, code lost:
            return r2.getFieldName();
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0068, code lost:
            r0 = r6.this$0.getMapper(r6.definedIn.getSuperclass());
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0074, code lost:
            if (r0 == null) goto L46;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x007a, code lost:
            return r0.getFieldNameForItemTypeAndName(r7, r8);
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x007b, code lost:
            return null;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.String getFieldNameForItemTypeAndName(java.lang.Class r7, java.lang.String r8) {
            /*
                r6 = this;
                java.util.Map r0 = r6.namedItemTypeToDef
                java.util.Set r0 = r0.keySet()
                java.util.Iterator r0 = r0.iterator()
                r1 = 0
                r2 = r1
            Lc:
                boolean r3 = r0.hasNext()
                if (r3 == 0) goto L61
                java.lang.Object r3 = r0.next()
                com.thoughtworks.xstream.mapper.ImplicitCollectionMapper$NamedItemType r3 = (com.thoughtworks.xstream.mapper.ImplicitCollectionMapper.NamedItemType) r3
                java.util.Map r4 = r6.namedItemTypeToDef
                java.lang.Object r4 = r4.get(r3)
                com.thoughtworks.xstream.mapper.ImplicitCollectionMapper$ImplicitCollectionMappingImpl r4 = (com.thoughtworks.xstream.mapper.ImplicitCollectionMapper.ImplicitCollectionMappingImpl) r4
                java.lang.Class<com.thoughtworks.xstream.mapper.Mapper$Null> r5 = com.thoughtworks.xstream.mapper.Mapper.Null.class
                if (r7 != r5) goto L26
                r2 = r4
                goto L61
            L26:
                java.lang.Class r3 = r3.itemType
                boolean r3 = r3.isAssignableFrom(r7)
                if (r3 == 0) goto Lc
                java.lang.String r3 = r4.getItemFieldName()
                if (r3 == 0) goto L43
                java.lang.String r3 = r4.getItemFieldName()
                boolean r3 = r3.equals(r8)
                if (r3 == 0) goto Lc
                java.lang.String r7 = r4.getFieldName()
                return r7
            L43:
                if (r2 == 0) goto L5f
                java.lang.Class r3 = r2.getItemType()
                if (r3 == 0) goto L5f
                java.lang.Class r3 = r4.getItemType()
                if (r3 == 0) goto Lc
                java.lang.Class r3 = r2.getItemType()
                java.lang.Class r5 = r4.getItemType()
                boolean r3 = r3.isAssignableFrom(r5)
                if (r3 == 0) goto Lc
            L5f:
                r2 = r4
                goto Lc
            L61:
                if (r2 == 0) goto L68
                java.lang.String r7 = r2.getFieldName()
                return r7
            L68:
                com.thoughtworks.xstream.mapper.ImplicitCollectionMapper r0 = com.thoughtworks.xstream.mapper.ImplicitCollectionMapper.this
                java.lang.Class r2 = r6.definedIn
                java.lang.Class r2 = r2.getSuperclass()
                com.thoughtworks.xstream.mapper.ImplicitCollectionMapper$ImplicitCollectionMapperForClass r0 = com.thoughtworks.xstream.mapper.ImplicitCollectionMapper.access$000(r0, r2)
                if (r0 == 0) goto L7b
                java.lang.String r7 = r0.getFieldNameForItemTypeAndName(r7, r8)
                return r7
            L7b:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.thoughtworks.xstream.mapper.ImplicitCollectionMapper.ImplicitCollectionMapperForClass.getFieldNameForItemTypeAndName(java.lang.Class, java.lang.String):java.lang.String");
        }

        public Class getItemTypeForItemFieldName(String str) {
            ImplicitCollectionMappingImpl implicitCollectionDefByItemFieldName = getImplicitCollectionDefByItemFieldName(str);
            if (implicitCollectionDefByItemFieldName == null) {
                ImplicitCollectionMapperForClass mapper = ImplicitCollectionMapper.this.getMapper(this.definedIn.getSuperclass());
                if (mapper != null) {
                    return mapper.getItemTypeForItemFieldName(str);
                }
                return null;
            }
            return implicitCollectionDefByItemFieldName.getItemType();
        }

        private ImplicitCollectionMappingImpl getImplicitCollectionDefByItemFieldName(String str) {
            ImplicitCollectionMapperForClass implicitCollectionMapperForClass = this;
            while (str != null) {
                ImplicitCollectionMappingImpl implicitCollectionMappingImpl = (ImplicitCollectionMappingImpl) implicitCollectionMapperForClass.itemFieldNameToDef.get(str);
                if (implicitCollectionMappingImpl != null) {
                    return implicitCollectionMappingImpl;
                }
                implicitCollectionMapperForClass = ImplicitCollectionMapper.this.getMapper(implicitCollectionMapperForClass.definedIn.getSuperclass());
                if (implicitCollectionMapperForClass == null) {
                    return null;
                }
            }
            return null;
        }

        public Mapper.ImplicitCollectionMapping getImplicitCollectionDefForFieldName(String str) {
            Mapper.ImplicitCollectionMapping implicitCollectionMapping = (Mapper.ImplicitCollectionMapping) this.fieldNameToDef.get(str);
            if (implicitCollectionMapping != null) {
                return implicitCollectionMapping;
            }
            ImplicitCollectionMapperForClass mapper = ImplicitCollectionMapper.this.getMapper(this.definedIn.getSuperclass());
            if (mapper != null) {
                return mapper.getImplicitCollectionDefForFieldName(str);
            }
            return null;
        }

        public void add(ImplicitCollectionMappingImpl implicitCollectionMappingImpl) {
            this.fieldNameToDef.put(implicitCollectionMappingImpl.getFieldName(), implicitCollectionMappingImpl);
            this.namedItemTypeToDef.put(implicitCollectionMappingImpl.createNamedItemType(), implicitCollectionMappingImpl);
            if (implicitCollectionMappingImpl.getItemFieldName() != null) {
                this.itemFieldNameToDef.put(implicitCollectionMappingImpl.getItemFieldName(), implicitCollectionMappingImpl);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class ImplicitCollectionMappingImpl implements Mapper.ImplicitCollectionMapping {
        private final String fieldName;
        private final String itemFieldName;
        private final Class itemType;
        private final String keyFieldName;

        ImplicitCollectionMappingImpl(String str, Class cls, String str2, String str3) {
            this.fieldName = str;
            this.itemFieldName = str2;
            this.itemType = cls;
            this.keyFieldName = str3;
        }

        public NamedItemType createNamedItemType() {
            return new NamedItemType(this.itemType, this.itemFieldName);
        }

        @Override // com.thoughtworks.xstream.mapper.Mapper.ImplicitCollectionMapping
        public String getFieldName() {
            return this.fieldName;
        }

        @Override // com.thoughtworks.xstream.mapper.Mapper.ImplicitCollectionMapping
        public String getItemFieldName() {
            return this.itemFieldName;
        }

        @Override // com.thoughtworks.xstream.mapper.Mapper.ImplicitCollectionMapping
        public Class getItemType() {
            return this.itemType;
        }

        @Override // com.thoughtworks.xstream.mapper.Mapper.ImplicitCollectionMapping
        public String getKeyFieldName() {
            return this.keyFieldName;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class NamedItemType {
        String itemFieldName;
        Class itemType;

        NamedItemType(Class cls, String str) {
            this.itemType = cls == null ? Object.class : cls;
            this.itemFieldName = str;
        }

        public boolean equals(Object obj) {
            if (obj instanceof NamedItemType) {
                NamedItemType namedItemType = (NamedItemType) obj;
                return this.itemType.equals(namedItemType.itemType) && isEquals(this.itemFieldName, namedItemType.itemFieldName);
            }
            return false;
        }

        private static boolean isEquals(Object obj, Object obj2) {
            if (obj == null) {
                return obj2 == null;
            }
            return obj.equals(obj2);
        }

        public int hashCode() {
            int hashCode = this.itemType.hashCode() << 7;
            String str = this.itemFieldName;
            return str != null ? hashCode + str.hashCode() : hashCode;
        }
    }
}
