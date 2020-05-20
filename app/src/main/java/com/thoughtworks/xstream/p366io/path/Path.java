package com.thoughtworks.xstream.p366io.path;

import com.thoughtworks.xstream.core.util.FastStack;
import java.util.ArrayList;

/* renamed from: com.thoughtworks.xstream.io.path.Path */
/* loaded from: classes2.dex */
public class Path {
    private static final Path DOT = new Path(new String[]{"."});
    private final String[] chunks;
    private transient String pathAsString;
    private transient String pathExplicit;

    public Path(String str) {
        ArrayList arrayList = new ArrayList();
        this.pathAsString = str;
        int i = 0;
        while (true) {
            int indexOf = str.indexOf(47, i);
            if (indexOf != -1) {
                arrayList.add(normalize(str, i, indexOf));
                i = indexOf + 1;
            } else {
                arrayList.add(normalize(str, i, str.length()));
                String[] strArr = new String[arrayList.size()];
                arrayList.toArray(strArr);
                this.chunks = strArr;
                return;
            }
        }
    }

    private String normalize(String str, int i, int i2) {
        if (i2 - i > 3) {
            int i3 = i2 - 3;
            if (str.charAt(i3) == '[' && str.charAt(i2 - 2) == '1' && str.charAt(i2 - 1) == ']') {
                this.pathAsString = null;
                return str.substring(i, i3);
            }
        }
        return str.substring(i, i2);
    }

    public Path(String[] strArr) {
        this.chunks = strArr;
    }

    public String toString() {
        if (this.pathAsString == null) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < this.chunks.length; i++) {
                if (i > 0) {
                    stringBuffer.append('/');
                }
                stringBuffer.append(this.chunks[i]);
            }
            this.pathAsString = stringBuffer.toString();
        }
        return this.pathAsString;
    }

    public String explicit() {
        char charAt;
        if (this.pathExplicit == null) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < this.chunks.length; i++) {
                if (i > 0) {
                    stringBuffer.append('/');
                }
                String str = this.chunks[i];
                stringBuffer.append(str);
                int length = str.length();
                if (length > 0 && (charAt = str.charAt(length - 1)) != ']' && charAt != '.') {
                    stringBuffer.append("[1]");
                }
            }
            this.pathExplicit = stringBuffer.toString();
        }
        return this.pathExplicit;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Path)) {
            return false;
        }
        Path path = (Path) obj;
        if (this.chunks.length != path.chunks.length) {
            return false;
        }
        int i = 0;
        while (true) {
            String[] strArr = this.chunks;
            if (i >= strArr.length) {
                return true;
            }
            if (!strArr[i].equals(path.chunks[i])) {
                return false;
            }
            i++;
        }
    }

    public int hashCode() {
        int i = 543645643;
        int i2 = 0;
        while (true) {
            String[] strArr = this.chunks;
            if (i2 >= strArr.length) {
                return i;
            }
            i = (i * 29) + strArr[i2].hashCode();
            i2++;
        }
    }

    public Path relativeTo(Path path) {
        int depthOfPathDivergence = depthOfPathDivergence(this.chunks, path.chunks);
        String[] strArr = new String[(this.chunks.length + path.chunks.length) - (depthOfPathDivergence * 2)];
        int i = depthOfPathDivergence;
        int i2 = 0;
        while (i < this.chunks.length) {
            strArr[i2] = "..";
            i++;
            i2++;
        }
        while (true) {
            String[] strArr2 = path.chunks;
            if (depthOfPathDivergence >= strArr2.length) {
                break;
            }
            strArr[i2] = strArr2[depthOfPathDivergence];
            depthOfPathDivergence++;
            i2++;
        }
        if (i2 == 0) {
            return DOT;
        }
        return new Path(strArr);
    }

    private int depthOfPathDivergence(String[] strArr, String[] strArr2) {
        int min = Math.min(strArr.length, strArr2.length);
        for (int i = 0; i < min; i++) {
            if (!strArr[i].equals(strArr2[i])) {
                return i;
            }
        }
        return min;
    }

    public Path apply(Path path) {
        FastStack fastStack = new FastStack(16);
        int i = 0;
        while (true) {
            String[] strArr = this.chunks;
            if (i >= strArr.length) {
                break;
            }
            fastStack.push(strArr[i]);
            i++;
        }
        int i2 = 0;
        while (true) {
            String[] strArr2 = path.chunks;
            if (i2 >= strArr2.length) {
                break;
            }
            String str = strArr2[i2];
            if (str.equals("..")) {
                fastStack.pop();
            } else if (!str.equals(".")) {
                fastStack.push(str);
            }
            i2++;
        }
        String[] strArr3 = new String[fastStack.size()];
        for (int i3 = 0; i3 < strArr3.length; i3++) {
            strArr3[i3] = (String) fastStack.get(i3);
        }
        return new Path(strArr3);
    }

    public boolean isAncestor(Path path) {
        if (path == null || path.chunks.length < this.chunks.length) {
            return false;
        }
        int i = 0;
        while (true) {
            String[] strArr = this.chunks;
            if (i >= strArr.length) {
                return true;
            }
            if (!strArr[i].equals(path.chunks[i])) {
                return false;
            }
            i++;
        }
    }
}
