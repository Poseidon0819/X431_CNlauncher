package com.thoughtworks.xstream.p366io.xml.xppdom;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/* renamed from: com.thoughtworks.xstream.io.xml.xppdom.XppDomComparator */
/* loaded from: classes2.dex */
public class XppDomComparator implements Comparator {
    private final ThreadLocal xpath;

    public XppDomComparator() {
        this(null);
    }

    public XppDomComparator(ThreadLocal threadLocal) {
        this.xpath = threadLocal;
    }

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        StringBuffer stringBuffer = new StringBuffer("/");
        int compareInternal = compareInternal((XppDom) obj, (XppDom) obj2, stringBuffer, -1);
        ThreadLocal threadLocal = this.xpath;
        if (threadLocal != null) {
            if (compareInternal != 0) {
                threadLocal.set(stringBuffer.toString());
            } else {
                threadLocal.set(null);
            }
        }
        return compareInternal;
    }

    private int compareInternal(XppDom xppDom, XppDom xppDom2, StringBuffer stringBuffer, int i) {
        int compareTo;
        int length = stringBuffer.length();
        String name = xppDom.getName();
        int compareTo2 = name.compareTo(xppDom2.getName());
        stringBuffer.append(name);
        if (i >= 0) {
            stringBuffer.append('[');
            stringBuffer.append(i);
            stringBuffer.append(']');
        }
        if (compareTo2 != 0) {
            stringBuffer.append('?');
            return compareTo2;
        }
        String[] attributeNames = xppDom.getAttributeNames();
        String[] attributeNames2 = xppDom2.getAttributeNames();
        int length2 = attributeNames.length;
        int length3 = attributeNames2.length - length2;
        if (length3 != 0) {
            stringBuffer.append("::count(@*)");
            return length3 < 0 ? 1 : -1;
        }
        Arrays.sort(attributeNames);
        Arrays.sort(attributeNames2);
        for (int i2 = 0; i2 < length2; i2++) {
            String str = attributeNames[i2];
            int compareTo3 = str.compareTo(attributeNames2[i2]);
            if (compareTo3 != 0) {
                stringBuffer.append("[@");
                stringBuffer.append(str);
                stringBuffer.append("?]");
                return compareTo3;
            }
            int compareTo4 = xppDom.getAttribute(str).compareTo(xppDom2.getAttribute(str));
            if (compareTo4 != 0) {
                stringBuffer.append("[@");
                stringBuffer.append(str);
                stringBuffer.append(']');
                return compareTo4;
            }
        }
        int childCount = xppDom.getChildCount();
        int childCount2 = xppDom2.getChildCount() - childCount;
        if (childCount2 != 0) {
            stringBuffer.append("::count(*)");
            return childCount2 < 0 ? 1 : -1;
        }
        if (childCount > 0) {
            if (xppDom.getValue() != null || xppDom2.getValue() != null) {
                throw new IllegalArgumentException("XppDom cannot handle mixed mode at " + ((Object) stringBuffer) + "::text()");
            }
            stringBuffer.append('/');
            HashMap hashMap = new HashMap();
            compareTo = childCount2;
            for (int i3 = 0; i3 < childCount; i3++) {
                XppDom child = xppDom.getChild(i3);
                XppDom child2 = xppDom2.getChild(i3);
                String name2 = child.getName();
                if (!hashMap.containsKey(name2)) {
                    hashMap.put(name2, new int[1]);
                }
                int[] iArr = (int[]) hashMap.get(name2);
                int i4 = iArr[0];
                iArr[0] = i4 + 1;
                compareTo = compareInternal(child, child2, stringBuffer, i4);
                if (compareTo != 0) {
                    return compareTo;
                }
            }
        } else {
            String value = xppDom2.getValue();
            String value2 = xppDom.getValue();
            if (value2 == null) {
                compareTo = value != null ? -1 : 0;
            } else {
                compareTo = value != null ? value2.compareTo(value) : 1;
            }
            if (compareTo != 0) {
                stringBuffer.append("::text()");
                return compareTo;
            }
        }
        stringBuffer.setLength(length);
        return compareTo;
    }
}
