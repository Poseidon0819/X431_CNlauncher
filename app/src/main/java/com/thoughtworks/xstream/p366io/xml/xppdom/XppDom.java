package com.thoughtworks.xstream.p366io.xml.xppdom;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.p398v1.XmlPullParser;
import org.xmlpull.p398v1.XmlPullParserException;

/* renamed from: com.thoughtworks.xstream.io.xml.xppdom.XppDom */
/* loaded from: classes2.dex */
public class XppDom implements Serializable {
    private static final long serialVersionUID = 1;
    private Map attributes;
    private List childList = new ArrayList();
    private transient Map childMap = new HashMap();
    private String name;
    private XppDom parent;
    private String value;

    public XppDom(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public String[] getAttributeNames() {
        Map map = this.attributes;
        if (map == null) {
            return new String[0];
        }
        return (String[]) map.keySet().toArray(new String[0]);
    }

    public String getAttribute(String str) {
        Map map = this.attributes;
        if (map != null) {
            return (String) map.get(str);
        }
        return null;
    }

    public void setAttribute(String str, String str2) {
        if (this.attributes == null) {
            this.attributes = new HashMap();
        }
        this.attributes.put(str, str2);
    }

    public XppDom getChild(int i) {
        return (XppDom) this.childList.get(i);
    }

    public XppDom getChild(String str) {
        return (XppDom) this.childMap.get(str);
    }

    public void addChild(XppDom xppDom) {
        xppDom.setParent(this);
        this.childList.add(xppDom);
        this.childMap.put(xppDom.getName(), xppDom);
    }

    public XppDom[] getChildren() {
        List list = this.childList;
        if (list == null) {
            return new XppDom[0];
        }
        return (XppDom[]) list.toArray(new XppDom[0]);
    }

    public XppDom[] getChildren(String str) {
        if (this.childList == null) {
            return new XppDom[0];
        }
        ArrayList arrayList = new ArrayList();
        int size = this.childList.size();
        for (int i = 0; i < size; i++) {
            XppDom xppDom = (XppDom) this.childList.get(i);
            if (str.equals(xppDom.getName())) {
                arrayList.add(xppDom);
            }
        }
        return (XppDom[]) arrayList.toArray(new XppDom[0]);
    }

    public int getChildCount() {
        List list = this.childList;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public XppDom getParent() {
        return this.parent;
    }

    public void setParent(XppDom xppDom) {
        this.parent = xppDom;
    }

    Object readResolve() {
        this.childMap = new HashMap();
        for (XppDom xppDom : this.childList) {
            this.childMap.put(xppDom.getName(), xppDom);
        }
        return this;
    }

    public static XppDom build(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int eventType = xmlPullParser.getEventType();
        XppDom xppDom = null;
        while (eventType != 1) {
            if (eventType == 2) {
                Xpp3Dom xpp3Dom = new Xpp3Dom(xmlPullParser.getName());
                int size = arrayList.size();
                if (size > 0) {
                    ((XppDom) arrayList.get(size - 1)).addChild(xpp3Dom);
                }
                arrayList.add(xpp3Dom);
                arrayList2.add(new StringBuffer());
                int attributeCount = xmlPullParser.getAttributeCount();
                for (int i = 0; i < attributeCount; i++) {
                    xpp3Dom.setAttribute(xmlPullParser.getAttributeName(i), xmlPullParser.getAttributeValue(i));
                }
            } else if (eventType == 4) {
                ((StringBuffer) arrayList2.get(arrayList2.size() - 1)).append(xmlPullParser.getText());
            } else if (eventType == 3) {
                int size2 = arrayList.size() - 1;
                XppDom xppDom2 = (XppDom) arrayList.remove(size2);
                String obj = arrayList2.remove(size2).toString();
                if (obj.length() == 0) {
                    obj = null;
                }
                xppDom2.setValue(obj);
                if (size2 == 0) {
                    xppDom = xppDom2;
                }
            }
            eventType = xmlPullParser.next();
        }
        return xppDom;
    }
}
