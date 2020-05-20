package com.thoughtworks.xstream.p366io.naming;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.thoughtworks.xstream.io.naming.StaticNameCoder */
/* loaded from: classes2.dex */
public class StaticNameCoder implements NameCoder {
    private transient Map attribute2Java;
    private final Map java2Attribute;
    private final Map java2Node;
    private transient Map node2Java;

    public StaticNameCoder(Map map, Map map2) {
        this.java2Node = new HashMap(map);
        if (map == map2 || map2 == null) {
            this.java2Attribute = this.java2Node;
        } else {
            this.java2Attribute = new HashMap(map2);
        }
        readResolve();
    }

    @Override // com.thoughtworks.xstream.p366io.naming.NameCoder
    public String decodeAttribute(String str) {
        String str2 = (String) this.attribute2Java.get(str);
        return str2 == null ? str : str2;
    }

    @Override // com.thoughtworks.xstream.p366io.naming.NameCoder
    public String decodeNode(String str) {
        String str2 = (String) this.node2Java.get(str);
        return str2 == null ? str : str2;
    }

    @Override // com.thoughtworks.xstream.p366io.naming.NameCoder
    public String encodeAttribute(String str) {
        String str2 = (String) this.java2Attribute.get(str);
        return str2 == null ? str : str2;
    }

    @Override // com.thoughtworks.xstream.p366io.naming.NameCoder
    public String encodeNode(String str) {
        String str2 = (String) this.java2Node.get(str);
        return str2 == null ? str : str2;
    }

    private Object readResolve() {
        this.node2Java = invertMap(this.java2Node);
        Map map = this.java2Node;
        Map map2 = this.java2Attribute;
        if (map == map2) {
            this.attribute2Java = this.node2Java;
        } else {
            this.attribute2Java = invertMap(map2);
        }
        return this;
    }

    private Map invertMap(Map map) {
        HashMap hashMap = new HashMap(map.size());
        for (Map.Entry entry : map.entrySet()) {
            hashMap.put((String) entry.getValue(), (String) entry.getKey());
        }
        return hashMap;
    }
}
