package com.thoughtworks.xstream.core;

import com.thoughtworks.xstream.converters.ConverterLookup;
import com.thoughtworks.xstream.mapper.Mapper;
import com.thoughtworks.xstream.p366io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.p366io.path.Path;

/* loaded from: classes2.dex */
public class ReferenceByIdMarshaller extends AbstractReferenceMarshaller {
    private final IDGenerator idGenerator;

    /* loaded from: classes2.dex */
    public interface IDGenerator {
        String next(Object obj);
    }

    public ReferenceByIdMarshaller(HierarchicalStreamWriter hierarchicalStreamWriter, ConverterLookup converterLookup, Mapper mapper, IDGenerator iDGenerator) {
        super(hierarchicalStreamWriter, converterLookup, mapper);
        this.idGenerator = iDGenerator;
    }

    public ReferenceByIdMarshaller(HierarchicalStreamWriter hierarchicalStreamWriter, ConverterLookup converterLookup, Mapper mapper) {
        this(hierarchicalStreamWriter, converterLookup, mapper, new SequenceGenerator(1));
    }

    @Override // com.thoughtworks.xstream.core.AbstractReferenceMarshaller
    protected String createReference(Path path, Object obj) {
        return obj.toString();
    }

    @Override // com.thoughtworks.xstream.core.AbstractReferenceMarshaller
    protected Object createReferenceKey(Path path, Object obj) {
        return this.idGenerator.next(obj);
    }

    @Override // com.thoughtworks.xstream.core.AbstractReferenceMarshaller
    protected void fireValidReference(Object obj) {
        String aliasForSystemAttribute = getMapper().aliasForSystemAttribute("id");
        if (aliasForSystemAttribute != null) {
            this.writer.addAttribute(aliasForSystemAttribute, obj.toString());
        }
    }
}
