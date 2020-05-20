package com.thoughtworks.xstream.p366io.path;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.thoughtworks.xstream.io.path.PathTracker */
/* loaded from: classes2.dex */
public class PathTracker {
    private int capacity;
    private Path currentPath;
    private Map[] indexMapStack;
    private String[] pathStack;
    private int pointer;

    public PathTracker() {
        this(16);
    }

    public PathTracker(int i) {
        this.capacity = Math.max(1, i);
        int i2 = this.capacity;
        this.pathStack = new String[i2];
        this.indexMapStack = new Map[i2];
    }

    public void pushElement(String str) {
        int i = this.pointer + 1;
        int i2 = this.capacity;
        if (i >= i2) {
            resizeStacks(i2 * 2);
        }
        String[] strArr = this.pathStack;
        int i3 = this.pointer;
        strArr[i3] = str;
        Map map = this.indexMapStack[i3];
        if (map == null) {
            map = new HashMap();
            this.indexMapStack[this.pointer] = map;
        }
        if (map.containsKey(str)) {
            map.put(str, new Integer(((Integer) map.get(str)).intValue() + 1));
        } else {
            map.put(str, 1);
        }
        this.pointer++;
        this.currentPath = null;
    }

    public void popElement() {
        Map[] mapArr = this.indexMapStack;
        int i = this.pointer;
        mapArr[i] = null;
        this.pathStack[i] = null;
        this.currentPath = null;
        this.pointer = i - 1;
    }

    public String peekElement() {
        return peekElement(0);
    }

    public String peekElement(int i) {
        int i2 = this.pointer;
        if (i < (-i2) || i > 0) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        int i3 = (i2 + i) - 1;
        int intValue = ((Integer) this.indexMapStack[i3].get(this.pathStack[i3])).intValue();
        if (intValue > 1) {
            StringBuffer stringBuffer = new StringBuffer(this.pathStack[i3].length() + 6);
            stringBuffer.append(this.pathStack[i3]);
            stringBuffer.append('[');
            stringBuffer.append(intValue);
            stringBuffer.append(']');
            return stringBuffer.toString();
        }
        return this.pathStack[i3];
    }

    public int depth() {
        return this.pointer;
    }

    private void resizeStacks(int i) {
        String[] strArr = new String[i];
        Map[] mapArr = new Map[i];
        int min = Math.min(this.capacity, i);
        System.arraycopy(this.pathStack, 0, strArr, 0, min);
        System.arraycopy(this.indexMapStack, 0, mapArr, 0, min);
        this.pathStack = strArr;
        this.indexMapStack = mapArr;
        this.capacity = i;
    }

    public Path getPath() {
        if (this.currentPath == null) {
            int i = this.pointer;
            String[] strArr = new String[i + 1];
            strArr[0] = "";
            int i2 = -i;
            while (true) {
                i2++;
                if (i2 > 0) {
                    break;
                }
                strArr[this.pointer + i2] = peekElement(i2);
            }
            this.currentPath = new Path(strArr);
        }
        return this.currentPath;
    }
}
