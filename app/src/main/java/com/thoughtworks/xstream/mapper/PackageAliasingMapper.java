package com.thoughtworks.xstream.mapper;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes2.dex */
public class PackageAliasingMapper extends MapperWrapper implements Serializable {
    private static final Comparator REVERSE = new Comparator() { // from class: com.thoughtworks.xstream.mapper.PackageAliasingMapper.1
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return ((String) obj2).compareTo((String) obj);
        }
    };
    protected transient Map nameToPackage;
    private Map packageToName;

    public PackageAliasingMapper(Mapper mapper) {
        super(mapper);
        this.packageToName = new TreeMap(REVERSE);
        this.nameToPackage = new HashMap();
    }

    public void addPackageAlias(String str, String str2) {
        if (str.length() > 0 && str.charAt(str.length() - 1) != '.') {
            str = str + '.';
        }
        if (str2.length() > 0 && str2.charAt(str2.length() - 1) != '.') {
            str2 = str2 + '.';
        }
        this.nameToPackage.put(str, str2);
        this.packageToName.put(str2, str);
    }

    @Override // com.thoughtworks.xstream.mapper.MapperWrapper, com.thoughtworks.xstream.mapper.Mapper
    public String serializedClass(Class cls) {
        String name = cls.getName();
        int length = name.length();
        while (true) {
            int lastIndexOf = name.lastIndexOf(46, length);
            String str = (String) this.packageToName.get(lastIndexOf < 0 ? "" : name.substring(0, lastIndexOf + 1));
            if (str != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                if (lastIndexOf >= 0) {
                    name = name.substring(lastIndexOf + 1);
                }
                sb.append(name);
                return sb.toString();
            }
            int i = lastIndexOf - 1;
            if (lastIndexOf < 0) {
                return super.serializedClass(cls);
            }
            length = i;
        }
    }

    @Override // com.thoughtworks.xstream.mapper.MapperWrapper, com.thoughtworks.xstream.mapper.Mapper
    public Class realClass(String str) {
        String str2;
        int length = str.length();
        while (true) {
            int lastIndexOf = str.lastIndexOf(46, length);
            if (lastIndexOf < 0) {
                str2 = "";
            } else {
                str2 = str.substring(0, lastIndexOf) + '.';
            }
            String str3 = (String) this.nameToPackage.get(str2);
            if (str3 != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(str3);
                if (lastIndexOf >= 0) {
                    str = str.substring(lastIndexOf + 1);
                }
                sb.append(str);
                str = sb.toString();
            } else {
                int i = lastIndexOf - 1;
                if (lastIndexOf < 0) {
                    break;
                }
                length = i;
            }
        }
        return super.realClass(str);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(new HashMap(this.packageToName));
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.packageToName = new TreeMap(REVERSE);
        this.packageToName.putAll((Map) objectInputStream.readObject());
        this.nameToPackage = new HashMap();
        for (Object obj : this.packageToName.keySet()) {
            this.nameToPackage.put(this.packageToName.get(obj), obj);
        }
    }
}
