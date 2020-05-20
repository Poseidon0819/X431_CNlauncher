package com.thoughtworks.xstream.core;

import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.ConverterLookup;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.core.util.ObjectIdDictionary;
import com.thoughtworks.xstream.mapper.Mapper;
import com.thoughtworks.xstream.p366io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.p366io.path.Path;
import com.thoughtworks.xstream.p366io.path.PathTracker;
import com.thoughtworks.xstream.p366io.path.PathTrackingWriter;
import java.util.Iterator;

/* loaded from: classes2.dex */
public abstract class AbstractReferenceMarshaller extends TreeMarshaller implements MarshallingContext {
    private ObjectIdDictionary implicitElements;
    private Path lastPath;
    private PathTracker pathTracker;
    private ObjectIdDictionary references;

    protected abstract String createReference(Path path, Object obj);

    protected abstract Object createReferenceKey(Path path, Object obj);

    protected abstract void fireValidReference(Object obj);

    public AbstractReferenceMarshaller(HierarchicalStreamWriter hierarchicalStreamWriter, ConverterLookup converterLookup, Mapper mapper) {
        super(hierarchicalStreamWriter, converterLookup, mapper);
        this.references = new ObjectIdDictionary();
        this.implicitElements = new ObjectIdDictionary();
        this.pathTracker = new PathTracker();
        this.writer = new PathTrackingWriter(hierarchicalStreamWriter, this.pathTracker);
    }

    @Override // com.thoughtworks.xstream.core.TreeMarshaller
    public void convert(Object obj, Converter converter) {
        if (getMapper().isImmutableValueType(obj.getClass())) {
            converter.marshal(obj, this.writer, this);
            return;
        }
        final Path path = this.pathTracker.getPath();
        C3960Id c3960Id = (C3960Id) this.references.lookupId(obj);
        if (c3960Id != null && c3960Id.getPath() != path) {
            String aliasForSystemAttribute = getMapper().aliasForSystemAttribute("reference");
            if (aliasForSystemAttribute != null) {
                this.writer.addAttribute(aliasForSystemAttribute, createReference(path, c3960Id.getItem()));
                return;
            }
            return;
        }
        final Object createReferenceKey = c3960Id == null ? createReferenceKey(path, obj) : c3960Id.getItem();
        Path path2 = this.lastPath;
        if (path2 == null || !path.isAncestor(path2)) {
            fireValidReference(createReferenceKey);
            this.lastPath = path;
            this.references.associateId(obj, new C3960Id(createReferenceKey, path));
        }
        converter.marshal(obj, this.writer, new ReferencingMarshallingContext() { // from class: com.thoughtworks.xstream.core.AbstractReferenceMarshaller.1
            @Override // com.thoughtworks.xstream.converters.DataHolder
            public void put(Object obj2, Object obj3) {
                AbstractReferenceMarshaller.this.put(obj2, obj3);
            }

            @Override // com.thoughtworks.xstream.converters.DataHolder
            public Iterator keys() {
                return AbstractReferenceMarshaller.this.keys();
            }

            @Override // com.thoughtworks.xstream.converters.DataHolder
            public Object get(Object obj2) {
                return AbstractReferenceMarshaller.this.get(obj2);
            }

            @Override // com.thoughtworks.xstream.converters.MarshallingContext
            public void convertAnother(Object obj2, Converter converter2) {
                AbstractReferenceMarshaller.this.convertAnother(obj2, converter2);
            }

            @Override // com.thoughtworks.xstream.converters.MarshallingContext
            public void convertAnother(Object obj2) {
                AbstractReferenceMarshaller.this.convertAnother(obj2);
            }

            @Override // com.thoughtworks.xstream.core.ReferencingMarshallingContext
            public void replace(Object obj2, Object obj3) {
                AbstractReferenceMarshaller.this.references.associateId(obj3, new C3960Id(createReferenceKey, path));
            }

            @Override // com.thoughtworks.xstream.core.ReferencingMarshallingContext
            public Object lookupReference(Object obj2) {
                return ((C3960Id) AbstractReferenceMarshaller.this.references.lookupId(obj2)).getItem();
            }

            @Override // com.thoughtworks.xstream.core.ReferencingMarshallingContext
            public Path currentPath() {
                return AbstractReferenceMarshaller.this.pathTracker.getPath();
            }

            @Override // com.thoughtworks.xstream.core.ReferencingMarshallingContext
            public void registerImplicit(Object obj2) {
                if (!AbstractReferenceMarshaller.this.implicitElements.containsId(obj2)) {
                    AbstractReferenceMarshaller.this.implicitElements.associateId(obj2, createReferenceKey);
                    return;
                }
                throw new ReferencedImplicitElementException(obj2, path);
            }
        });
    }

    /* renamed from: com.thoughtworks.xstream.core.AbstractReferenceMarshaller$Id */
    /* loaded from: classes2.dex */
    static class C3960Id {
        private Object item;
        private Path path;

        public C3960Id(Object obj, Path path) {
            this.item = obj;
            this.path = path;
        }

        protected Object getItem() {
            return this.item;
        }

        protected Path getPath() {
            return this.path;
        }
    }

    /* loaded from: classes2.dex */
    public static class ReferencedImplicitElementException extends ConversionException {
        public ReferencedImplicitElementException(Object obj, Path path) {
            super("Cannot reference implicit element");
            add("implicit-element", obj.toString());
            add("referencing-element", path.toString());
        }
    }
}
