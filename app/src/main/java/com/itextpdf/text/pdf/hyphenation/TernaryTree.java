package com.itextpdf.text.pdf.hyphenation;

import java.io.PrintStream;
import java.io.Serializable;
import java.util.Enumeration;
import java.util.Stack;

/* loaded from: classes.dex */
public class TernaryTree implements Serializable, Cloneable {
    protected static final int BLOCK_SIZE = 2048;
    private static final long serialVersionUID = 5313366505322983510L;

    /* renamed from: eq */
    protected char[] f19847eq;
    protected char freenode;

    /* renamed from: hi */
    protected char[] f19848hi;

    /* renamed from: kv */
    protected CharVector f19849kv;
    protected int length;

    /* renamed from: lo */
    protected char[] f19850lo;
    protected char root;

    /* renamed from: sc */
    protected char[] f19851sc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TernaryTree() {
        init();
    }

    protected void init() {
        this.root = (char) 0;
        this.freenode = (char) 1;
        this.length = 0;
        this.f19850lo = new char[2048];
        this.f19848hi = new char[2048];
        this.f19847eq = new char[2048];
        this.f19851sc = new char[2048];
        this.f19849kv = new CharVector();
    }

    public void insert(String str, char c) {
        int length = str.length() + 1;
        int i = this.freenode + length;
        char[] cArr = this.f19847eq;
        if (i > cArr.length) {
            redimNodeArrays(cArr.length + 2048);
        }
        int i2 = length - 1;
        char[] cArr2 = new char[length];
        str.getChars(0, i2, cArr2, 0);
        cArr2[i2] = 0;
        this.root = insert(this.root, cArr2, 0, c);
    }

    public void insert(char[] cArr, int i, char c) {
        int strlen = this.freenode + strlen(cArr) + 1;
        char[] cArr2 = this.f19847eq;
        if (strlen > cArr2.length) {
            redimNodeArrays(cArr2.length + 2048);
        }
        this.root = insert(this.root, cArr, i, c);
    }

    private char insert(char c, char[] cArr, int i, char c2) {
        int strlen = strlen(cArr, i);
        if (c == 0) {
            char c3 = this.freenode;
            this.freenode = (char) (c3 + 1);
            this.f19847eq[c3] = c2;
            this.length++;
            this.f19848hi[c3] = 0;
            if (strlen > 0) {
                this.f19851sc[c3] = 65535;
                this.f19850lo[c3] = (char) this.f19849kv.alloc(strlen + 1);
                strcpy(this.f19849kv.getArray(), this.f19850lo[c3], cArr, i);
            } else {
                this.f19851sc[c3] = 0;
                this.f19850lo[c3] = 0;
            }
            return c3;
        }
        char[] cArr2 = this.f19851sc;
        if (cArr2[c] == 65535) {
            char c4 = this.freenode;
            this.freenode = (char) (c4 + 1);
            char[] cArr3 = this.f19850lo;
            cArr3[c4] = cArr3[c];
            char[] cArr4 = this.f19847eq;
            cArr4[c4] = cArr4[c];
            cArr3[c] = 0;
            if (strlen > 0) {
                cArr2[c] = this.f19849kv.get(cArr3[c4]);
                this.f19847eq[c] = c4;
                char[] cArr5 = this.f19850lo;
                cArr5[c4] = (char) (cArr5[c4] + 1);
                if (this.f19849kv.get(cArr5[c4]) == 0) {
                    this.f19850lo[c4] = 0;
                    this.f19851sc[c4] = 0;
                    this.f19848hi[c4] = 0;
                } else {
                    this.f19851sc[c4] = 65535;
                }
            } else {
                cArr2[c4] = 65535;
                this.f19848hi[c] = c4;
                cArr2[c] = 0;
                cArr4[c] = c2;
                this.length++;
                return c;
            }
        }
        char c5 = cArr[i];
        char[] cArr6 = this.f19851sc;
        if (c5 < cArr6[c]) {
            char[] cArr7 = this.f19850lo;
            cArr7[c] = insert(cArr7[c], cArr, i, c2);
        } else if (c5 != cArr6[c]) {
            char[] cArr8 = this.f19848hi;
            cArr8[c] = insert(cArr8[c], cArr, i, c2);
        } else if (c5 != 0) {
            char[] cArr9 = this.f19847eq;
            cArr9[c] = insert(cArr9[c], cArr, i + 1, c2);
        } else {
            this.f19847eq[c] = c2;
        }
        return c;
    }

    public static int strcmp(char[] cArr, int i, char[] cArr2, int i2) {
        while (cArr[i] == cArr2[i2]) {
            if (cArr[i] == 0) {
                return 0;
            }
            i++;
            i2++;
        }
        return cArr[i] - cArr2[i2];
    }

    public static int strcmp(String str, char[] cArr, int i) {
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            int i3 = i + i2;
            int charAt = str.charAt(i2) - cArr[i3];
            if (charAt != 0 || cArr[i3] == 0) {
                return charAt;
            }
            i2++;
        }
        int i4 = i + i2;
        if (cArr[i4] != 0) {
            return -cArr[i4];
        }
        return 0;
    }

    public static void strcpy(char[] cArr, int i, char[] cArr2, int i2) {
        while (cArr2[i2] != 0) {
            cArr[i] = cArr2[i2];
            i++;
            i2++;
        }
        cArr[i] = 0;
    }

    public static int strlen(char[] cArr, int i) {
        int i2 = 0;
        while (i < cArr.length && cArr[i] != 0) {
            i2++;
            i++;
        }
        return i2;
    }

    public static int strlen(char[] cArr) {
        return strlen(cArr, 0);
    }

    public int find(String str) {
        int length = str.length();
        char[] cArr = new char[length + 1];
        str.getChars(0, length, cArr, 0);
        cArr[length] = 0;
        return find(cArr, 0);
    }

    public int find(char[] cArr, int i) {
        char c = this.root;
        while (c != 0) {
            char[] cArr2 = this.f19851sc;
            if (cArr2[c] == 65535) {
                if (strcmp(cArr, i, this.f19849kv.getArray(), this.f19850lo[c]) == 0) {
                    return this.f19847eq[c];
                }
                return -1;
            }
            char c2 = cArr[i];
            int i2 = c2 - cArr2[c];
            if (i2 == 0) {
                if (c2 == 0) {
                    return this.f19847eq[c];
                }
                i++;
                c = this.f19847eq[c];
            } else if (i2 < 0) {
                c = this.f19850lo[c];
            } else {
                c = this.f19848hi[c];
            }
        }
        return -1;
    }

    public boolean knows(String str) {
        return find(str) >= 0;
    }

    private void redimNodeArrays(int i) {
        char[] cArr = this.f19850lo;
        int length = i < cArr.length ? i : cArr.length;
        char[] cArr2 = new char[i];
        System.arraycopy(this.f19850lo, 0, cArr2, 0, length);
        this.f19850lo = cArr2;
        char[] cArr3 = new char[i];
        System.arraycopy(this.f19848hi, 0, cArr3, 0, length);
        this.f19848hi = cArr3;
        char[] cArr4 = new char[i];
        System.arraycopy(this.f19847eq, 0, cArr4, 0, length);
        this.f19847eq = cArr4;
        char[] cArr5 = new char[i];
        System.arraycopy(this.f19851sc, 0, cArr5, 0, length);
        this.f19851sc = cArr5;
    }

    public int size() {
        return this.length;
    }

    public Object clone() {
        TernaryTree ternaryTree = new TernaryTree();
        ternaryTree.f19850lo = (char[]) this.f19850lo.clone();
        ternaryTree.f19848hi = (char[]) this.f19848hi.clone();
        ternaryTree.f19847eq = (char[]) this.f19847eq.clone();
        ternaryTree.f19851sc = (char[]) this.f19851sc.clone();
        ternaryTree.f19849kv = (CharVector) this.f19849kv.clone();
        ternaryTree.root = this.root;
        ternaryTree.freenode = this.freenode;
        ternaryTree.length = this.length;
        return ternaryTree;
    }

    protected void insertBalanced(String[] strArr, char[] cArr, int i, int i2) {
        if (i2 <= 0) {
            return;
        }
        int i3 = i2 >> 1;
        int i4 = i3 + i;
        insert(strArr[i4], cArr[i4]);
        insertBalanced(strArr, cArr, i, i3);
        insertBalanced(strArr, cArr, i4 + 1, (i2 - i3) - 1);
    }

    public void balance() {
        int i = this.length;
        String[] strArr = new String[i];
        char[] cArr = new char[i];
        Iterator iterator = new Iterator();
        int i2 = 0;
        while (iterator.hasMoreElements()) {
            cArr[i2] = iterator.getValue();
            strArr[i2] = iterator.nextElement();
            i2++;
        }
        init();
        insertBalanced(strArr, cArr, 0, i);
    }

    public void trimToSize() {
        balance();
        redimNodeArrays(this.freenode);
        CharVector charVector = new CharVector();
        charVector.alloc(1);
        compact(charVector, new TernaryTree(), this.root);
        this.f19849kv = charVector;
        this.f19849kv.trimToSize();
    }

    private void compact(CharVector charVector, TernaryTree ternaryTree, char c) {
        while (c != 0) {
            if (this.f19851sc[c] == 65535) {
                int find = ternaryTree.find(this.f19849kv.getArray(), this.f19850lo[c]);
                if (find < 0) {
                    find = charVector.alloc(strlen(this.f19849kv.getArray(), this.f19850lo[c]) + 1);
                    strcpy(charVector.getArray(), find, this.f19849kv.getArray(), this.f19850lo[c]);
                    ternaryTree.insert(charVector.getArray(), find, (char) find);
                }
                this.f19850lo[c] = (char) find;
                return;
            }
            compact(charVector, ternaryTree, this.f19850lo[c]);
            if (this.f19851sc[c] != 0) {
                compact(charVector, ternaryTree, this.f19847eq[c]);
            }
            c = this.f19848hi[c];
        }
    }

    public Enumeration<String> keys() {
        return new Iterator();
    }

    /* loaded from: classes.dex */
    public class Iterator implements Enumeration<String> {
        String curkey;
        int cur = -1;

        /* renamed from: ns */
        Stack<Item> f19853ns = new Stack<>();

        /* renamed from: ks */
        StringBuffer f19852ks = new StringBuffer();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class Item implements Cloneable {
            char child;
            char parent;

            public Item() {
                this.parent = (char) 0;
                this.child = (char) 0;
            }

            public Item(char c, char c2) {
                this.parent = c;
                this.child = c2;
            }

            /* renamed from: clone */
            public Item m15314clone() {
                return new Item(this.parent, this.child);
            }
        }

        public Iterator() {
            rewind();
        }

        public void rewind() {
            this.f19853ns.removeAllElements();
            this.f19852ks.setLength(0);
            this.cur = TernaryTree.this.root;
            run();
        }

        @Override // java.util.Enumeration
        public String nextElement() {
            String str = this.curkey;
            this.cur = m2712up();
            run();
            return str;
        }

        public char getValue() {
            if (this.cur >= 0) {
                return TernaryTree.this.f19847eq[this.cur];
            }
            return (char) 0;
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return this.cur != -1;
        }

        /* renamed from: up */
        private int m2712up() {
            new Item();
            if (this.f19853ns.empty()) {
                return -1;
            }
            if (this.cur == 0 || TernaryTree.this.f19851sc[this.cur] != 0) {
                boolean z = true;
                char c = 0;
                while (z) {
                    Item pop = this.f19853ns.pop();
                    pop.child = (char) (pop.child + 1);
                    switch (pop.child) {
                        case 1:
                            if (TernaryTree.this.f19851sc[pop.parent] != 0) {
                                c = TernaryTree.this.f19847eq[pop.parent];
                                this.f19853ns.push(pop.m15314clone());
                                this.f19852ks.append(TernaryTree.this.f19851sc[pop.parent]);
                            } else {
                                pop.child = (char) (pop.child + 1);
                                this.f19853ns.push(pop.m15314clone());
                                c = TernaryTree.this.f19848hi[pop.parent];
                            }
                            z = false;
                            break;
                        case 2:
                            c = TernaryTree.this.f19848hi[pop.parent];
                            this.f19853ns.push(pop.m15314clone());
                            if (this.f19852ks.length() > 0) {
                                StringBuffer stringBuffer = this.f19852ks;
                                stringBuffer.setLength(stringBuffer.length() - 1);
                            }
                            z = false;
                            break;
                        default:
                            if (!this.f19853ns.empty()) {
                                z = true;
                                break;
                            } else {
                                return -1;
                            }
                    }
                }
                return c;
            }
            return TernaryTree.this.f19850lo[this.cur];
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v1, types: [int] */
        private int run() {
            if (this.cur == -1) {
                return -1;
            }
            boolean z = false;
            while (true) {
                if (this.cur != 0) {
                    char[] cArr = TernaryTree.this.f19851sc;
                    int i = this.cur;
                    if (cArr[i] == 65535) {
                        z = true;
                    } else {
                        this.f19853ns.push(new Item((char) i, (char) 0));
                        if (TernaryTree.this.f19851sc[this.cur] == 0) {
                            z = true;
                        } else {
                            this.cur = TernaryTree.this.f19850lo[this.cur];
                        }
                    }
                }
                if (!z) {
                    this.cur = m2712up();
                    if (this.cur == -1) {
                        return -1;
                    }
                } else {
                    StringBuffer stringBuffer = new StringBuffer(this.f19852ks.toString());
                    if (TernaryTree.this.f19851sc[this.cur] == 65535) {
                        for (char c = TernaryTree.this.f19850lo[this.cur]; TernaryTree.this.f19849kv.get(c) != 0; c++) {
                            stringBuffer.append(TernaryTree.this.f19849kv.get(c));
                        }
                    }
                    this.curkey = stringBuffer.toString();
                    return 0;
                }
            }
        }
    }

    public void printStats() {
        PrintStream printStream = System.out;
        printStream.println("Number of keys = " + Integer.toString(this.length));
        PrintStream printStream2 = System.out;
        printStream2.println("Node count = " + Integer.toString(this.freenode));
        PrintStream printStream3 = System.out;
        printStream3.println("Key Array length = " + Integer.toString(this.f19849kv.length()));
    }
}
