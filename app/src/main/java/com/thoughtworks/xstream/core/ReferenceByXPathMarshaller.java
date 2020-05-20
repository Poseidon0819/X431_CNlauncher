package com.thoughtworks.xstream.core;

import com.thoughtworks.xstream.converters.ConverterLookup;
import com.thoughtworks.xstream.mapper.Mapper;
import com.thoughtworks.xstream.p366io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.p366io.path.Path;

/* loaded from: classes2.dex */
public class ReferenceByXPathMarshaller extends AbstractReferenceMarshaller {
    private final int mode;

    @Override // com.thoughtworks.xstream.core.AbstractReferenceMarshaller
    protected Object createReferenceKey(Path path, Object obj) {
        return path;
    }

    @Override // com.thoughtworks.xstream.core.AbstractReferenceMarshaller
    protected void fireValidReference(Object obj) {
    }

    public ReferenceByXPathMarshaller(HierarchicalStreamWriter hierarchicalStreamWriter, ConverterLookup converterLookup, Mapper mapper, int i) {
        super(hierarchicalStreamWriter, converterLookup, mapper);
        this.mode = i;
    }

    @Override // com.thoughtworks.xstream.core.AbstractReferenceMarshaller
    protected String createReference(Path path, Object obj) {
        Path path2 = (Path) obj;
        if ((this.mode & ReferenceByXPathMarshallingStrategy.ABSOLUTE) <= 0) {
            path2 = path.relativeTo(path2);
        }
        return (this.mode & ReferenceByXPathMarshallingStrategy.SINGLE_NODE) > 0 ? path2.explicit() : path2.toString();
    }
}
