package com.thoughtworks.xstream.p366io.binary;

import com.thoughtworks.xstream.p366io.AbstractDriver;
import com.thoughtworks.xstream.p366io.HierarchicalStreamReader;
import com.thoughtworks.xstream.p366io.HierarchicalStreamWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

/* renamed from: com.thoughtworks.xstream.io.binary.BinaryStreamDriver */
/* loaded from: classes2.dex */
public class BinaryStreamDriver extends AbstractDriver {
    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamDriver
    public HierarchicalStreamReader createReader(Reader reader) {
        throw new UnsupportedOperationException("The BinaryDriver cannot use character-oriented input streams.");
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamDriver
    public HierarchicalStreamReader createReader(InputStream inputStream) {
        return new BinaryStreamReader(inputStream);
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamDriver
    public HierarchicalStreamWriter createWriter(Writer writer) {
        throw new UnsupportedOperationException("The BinaryDriver cannot use character-oriented output streams.");
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamDriver
    public HierarchicalStreamWriter createWriter(OutputStream outputStream) {
        return new BinaryStreamWriter(outputStream);
    }
}
