package com.thoughtworks.xstream.p366io.xml;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.xml.namespace.QName;

/* renamed from: com.thoughtworks.xstream.io.xml.QNameMap */
/* loaded from: classes2.dex */
public class QNameMap {
    private Map javaToQName;
    private Map qnameToJava;
    private String defaultPrefix = "";
    private String defaultNamespace = "";

    public String getJavaClassName(QName qName) {
        String str;
        Map map = this.qnameToJava;
        return (map == null || (str = (String) map.get(qName)) == null) ? qName.getLocalPart() : str;
    }

    public QName getQName(String str) {
        QName qName;
        Map map = this.javaToQName;
        return (map == null || (qName = (QName) map.get(str)) == null) ? new QName(this.defaultNamespace, str, this.defaultPrefix) : qName;
    }

    public synchronized void registerMapping(QName qName, String str) {
        if (this.javaToQName == null) {
            this.javaToQName = Collections.synchronizedMap(new HashMap());
        }
        if (this.qnameToJava == null) {
            this.qnameToJava = Collections.synchronizedMap(new HashMap());
        }
        this.javaToQName.put(str, qName);
        this.qnameToJava.put(qName, str);
    }

    public synchronized void registerMapping(QName qName, Class cls) {
        registerMapping(qName, cls.getName());
    }

    public String getDefaultNamespace() {
        return this.defaultNamespace;
    }

    public void setDefaultNamespace(String str) {
        this.defaultNamespace = str;
    }

    public String getDefaultPrefix() {
        return this.defaultPrefix;
    }

    public void setDefaultPrefix(String str) {
        this.defaultPrefix = str;
    }
}
