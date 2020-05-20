package com.thoughtworks.xstream.p366io;

import com.thoughtworks.xstream.p366io.naming.NameCoder;
import com.thoughtworks.xstream.p366io.naming.NoNameCoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

/* renamed from: com.thoughtworks.xstream.io.AbstractDriver */
/* loaded from: classes2.dex */
public abstract class AbstractDriver implements HierarchicalStreamDriver {
    private NameCoder replacer;

    public AbstractDriver() {
        this(new NoNameCoder());
    }

    public AbstractDriver(NameCoder nameCoder) {
        this.replacer = nameCoder;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public NameCoder getNameCoder() {
        return this.replacer;
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamDriver
    public HierarchicalStreamReader createReader(URL url) {
        try {
            return createReader(url.openStream());
        } catch (IOException e) {
            throw new StreamException(e);
        }
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamDriver
    public HierarchicalStreamReader createReader(File file) {
        try {
            return createReader(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            throw new StreamException(e);
        }
    }
}
