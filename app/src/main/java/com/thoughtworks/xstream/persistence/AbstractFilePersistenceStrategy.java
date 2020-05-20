package com.thoughtworks.xstream.persistence;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.ConverterLookup;
import com.thoughtworks.xstream.mapper.Mapper;
import com.thoughtworks.xstream.p366io.StreamException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class AbstractFilePersistenceStrategy implements PersistenceStrategy {
    private final File baseDirectory;
    private final String encoding;
    private final FilenameFilter filter = new ValidFilenameFilter();
    private final transient XStream xstream;

    protected abstract Object extractKey(String str);

    protected abstract String getName(Object obj);

    public AbstractFilePersistenceStrategy(File file, XStream xStream, String str) {
        this.baseDirectory = file;
        this.xstream = xStream;
        this.encoding = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ConverterLookup getConverterLookup() {
        return this.xstream.getConverterLookup();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Mapper getMapper() {
        return this.xstream.getMapper();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isValid(File file, String str) {
        return str.endsWith(".xml");
    }

    /* loaded from: classes2.dex */
    protected class ValidFilenameFilter implements FilenameFilter {
        protected ValidFilenameFilter() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return new File(file, str).isFile() && AbstractFilePersistenceStrategy.this.isValid(file, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public class XmlMapEntriesIterator implements Iterator {
        private final File[] files;
        private int position = -1;
        private File current = null;

        protected XmlMapEntriesIterator() {
            this.files = AbstractFilePersistenceStrategy.this.baseDirectory.listFiles(AbstractFilePersistenceStrategy.this.filter);
        }

        static /* synthetic */ int access$404(XmlMapEntriesIterator xmlMapEntriesIterator) {
            int i = xmlMapEntriesIterator.position + 1;
            xmlMapEntriesIterator.position = i;
            return i;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.position + 1 < this.files.length;
        }

        @Override // java.util.Iterator
        public void remove() {
            File file = this.current;
            if (file == null) {
                throw new IllegalStateException();
            }
            file.delete();
        }

        @Override // java.util.Iterator
        public Object next() {
            return new Map.Entry() { // from class: com.thoughtworks.xstream.persistence.AbstractFilePersistenceStrategy.XmlMapEntriesIterator.1
                private final File file;
                private final Object key;

                {
                    XmlMapEntriesIterator xmlMapEntriesIterator = XmlMapEntriesIterator.this;
                    this.file = xmlMapEntriesIterator.current = xmlMapEntriesIterator.files[XmlMapEntriesIterator.access$404(XmlMapEntriesIterator.this)];
                    this.key = AbstractFilePersistenceStrategy.this.extractKey(this.file.getName());
                }

                @Override // java.util.Map.Entry
                public Object getKey() {
                    return this.key;
                }

                @Override // java.util.Map.Entry
                public Object getValue() {
                    return AbstractFilePersistenceStrategy.this.readFile(this.file);
                }

                @Override // java.util.Map.Entry
                public Object setValue(Object obj) {
                    return AbstractFilePersistenceStrategy.this.put(this.key, obj);
                }

                @Override // java.util.Map.Entry
                public boolean equals(Object obj) {
                    if (obj instanceof Map.Entry) {
                        Object value = getValue();
                        Map.Entry entry = (Map.Entry) obj;
                        Object key = entry.getKey();
                        Object value2 = entry.getValue();
                        Object obj2 = this.key;
                        if (obj2 != null ? obj2.equals(key) : key == null) {
                            if (value == null) {
                                if (value2 == null) {
                                    return true;
                                }
                            } else if (getValue().equals(entry.getValue())) {
                                return true;
                            }
                        }
                        return false;
                    }
                    return false;
                }
            };
        }
    }

    private void writeFile(File file, Object obj) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            OutputStreamWriter outputStreamWriter = this.encoding != null ? new OutputStreamWriter(fileOutputStream, this.encoding) : new OutputStreamWriter(fileOutputStream);
            this.xstream.toXML(obj, outputStreamWriter);
            outputStreamWriter.close();
        } catch (IOException e) {
            throw new StreamException(e);
        }
    }

    private File getFile(String str) {
        return new File(this.baseDirectory, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object readFile(File file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = this.encoding != null ? new InputStreamReader(fileInputStream, this.encoding) : new InputStreamReader(fileInputStream);
            Object fromXML = this.xstream.fromXML(inputStreamReader);
            inputStreamReader.close();
            return fromXML;
        } catch (FileNotFoundException unused) {
            return null;
        } catch (IOException e) {
            throw new StreamException(e);
        }
    }

    @Override // com.thoughtworks.xstream.persistence.PersistenceStrategy
    public Object put(Object obj, Object obj2) {
        Object obj3 = get(obj);
        writeFile(new File(this.baseDirectory, getName(obj)), obj2);
        return obj3;
    }

    @Override // com.thoughtworks.xstream.persistence.PersistenceStrategy
    public Iterator iterator() {
        return new XmlMapEntriesIterator();
    }

    @Override // com.thoughtworks.xstream.persistence.PersistenceStrategy
    public int size() {
        return this.baseDirectory.list(this.filter).length;
    }

    public boolean containsKey(Object obj) {
        return getFile(getName(obj)).isFile();
    }

    @Override // com.thoughtworks.xstream.persistence.PersistenceStrategy
    public Object get(Object obj) {
        return readFile(getFile(getName(obj)));
    }

    @Override // com.thoughtworks.xstream.persistence.PersistenceStrategy
    public Object remove(Object obj) {
        File file = getFile(getName(obj));
        if (file.isFile()) {
            Object readFile = readFile(file);
            file.delete();
            return readFile;
        }
        return null;
    }
}
