package com.itextpdf.text.pdf;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/* loaded from: classes.dex */
public class SequenceList {
    protected static final int COMMA = 1;
    private static final int DIGIT = 1;
    private static final int DIGIT2 = 3;
    protected static final int END = 6;
    protected static final char EOT = 65535;
    private static final int FIRST = 0;
    protected static final int MINUS = 2;
    protected static final int NOT = 3;
    private static final String NOT_OTHER = "-,!0123456789";
    protected static final int NUMBER = 5;
    private static final int OTHER = 2;
    protected static final int TEXT = 4;
    protected boolean even;
    protected int high;
    protected boolean inverse;
    protected int low;
    protected int number;
    protected boolean odd;
    protected String other;
    protected int ptr = 0;
    protected char[] text;

    protected SequenceList(String str) {
        this.text = str.toCharArray();
    }

    protected char nextChar() {
        char c;
        do {
            int i = this.ptr;
            char[] cArr = this.text;
            if (i >= cArr.length) {
                return EOT;
            }
            this.ptr = i + 1;
            c = cArr[i];
        } while (c <= ' ');
        return c;
    }

    protected void putBack() {
        this.ptr--;
        if (this.ptr < 0) {
            this.ptr = 0;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x005b, code lost:
        putBack();
        r0 = r0.toString();
        r9.other = r0;
        r9.number = java.lang.Integer.parseInt(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x006a, code lost:
        return 5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected int getType() {
        /*
            r9 = this;
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            r1 = 2
            r2 = 1
            r3 = 0
        L8:
            char r4 = r9.nextChar()
            r5 = 65535(0xffff, float:9.1834E-41)
            r6 = 4
            r7 = 5
            if (r4 != r5) goto L31
            if (r3 != r2) goto L22
            java.lang.String r0 = r0.toString()
            r9.other = r0
            int r0 = java.lang.Integer.parseInt(r0)
            r9.number = r0
            return r7
        L22:
            if (r3 != r1) goto L2f
            java.lang.String r0 = r0.toString()
            java.lang.String r0 = r0.toLowerCase()
            r9.other = r0
            return r6
        L2f:
            r0 = 6
            return r0
        L31:
            r5 = 57
            r8 = 48
            switch(r3) {
                case 0: goto L6b;
                case 1: goto L53;
                case 2: goto L39;
                default: goto L38;
            }
        L38:
            goto L8
        L39:
            java.lang.String r5 = "-,!0123456789"
            int r5 = r5.indexOf(r4)
            if (r5 >= 0) goto L45
            r0.append(r4)
            goto L8
        L45:
            r9.putBack()
            java.lang.String r0 = r0.toString()
            java.lang.String r0 = r0.toLowerCase()
            r9.other = r0
            return r6
        L53:
            if (r4 < r8) goto L5b
            if (r4 > r5) goto L5b
            r0.append(r4)
            goto L8
        L5b:
            r9.putBack()
            java.lang.String r0 = r0.toString()
            r9.other = r0
            int r0 = java.lang.Integer.parseInt(r0)
            r9.number = r0
            return r7
        L6b:
            r3 = 33
            if (r4 == r3) goto L7f
            switch(r4) {
                case 44: goto L7e;
                case 45: goto L7d;
                default: goto L72;
            }
        L72:
            r0.append(r4)
            if (r4 < r8) goto L7b
            if (r4 > r5) goto L7b
            r3 = 1
            goto L8
        L7b:
            r3 = 2
            goto L8
        L7d:
            return r1
        L7e:
            return r2
        L7f:
            r0 = 3
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.SequenceList.getType():int");
    }

    private void otherProc() {
        if (this.other.equals("odd") || this.other.equals("o")) {
            this.odd = true;
            this.even = false;
        } else if (this.other.equals("even") || this.other.equals("e")) {
            this.odd = false;
            this.even = true;
        }
    }

    protected boolean getAttributes() {
        int type;
        this.low = -1;
        this.high = -1;
        this.inverse = false;
        this.even = false;
        this.odd = false;
        char c = 2;
        while (true) {
            type = getType();
            if (type != 6 && type != 1) {
                switch (c) {
                    case 1:
                        switch (type) {
                            case 2:
                                c = 3;
                                break;
                            case 3:
                                this.inverse = true;
                                this.high = this.low;
                                c = 2;
                                continue;
                            default:
                                this.high = this.low;
                                break;
                        }
                    case 2:
                        switch (type) {
                            case 2:
                                c = 3;
                                continue;
                            case 3:
                                this.inverse = true;
                                continue;
                                continue;
                            default:
                                if (type == 5) {
                                    this.low = this.number;
                                    c = 1;
                                    break;
                                } else {
                                    otherProc();
                                    continue;
                                }
                        }
                    case 3:
                        if (type != 5) {
                            switch (type) {
                                case 3:
                                    this.inverse = true;
                                    c = 2;
                                    break;
                            }
                        } else {
                            this.high = this.number;
                            c = 2;
                            continue;
                        }
                        break;
                }
                otherProc();
                c = 2;
            }
        }
        if (c == 1) {
            this.high = this.low;
        }
        return type == 6;
    }

    public static List<Integer> expand(String str, int i) {
        int i2;
        SequenceList sequenceList = new SequenceList(str);
        LinkedList linkedList = new LinkedList();
        boolean z = false;
        while (!z) {
            z = sequenceList.getAttributes();
            int i3 = -1;
            if (sequenceList.low != -1 || sequenceList.high != -1 || sequenceList.even || sequenceList.odd) {
                if (sequenceList.low <= 0) {
                    sequenceList.low = 1;
                }
                int i4 = sequenceList.high;
                if (i4 <= 0 || i4 > i) {
                    sequenceList.high = i;
                }
                if (sequenceList.low > i) {
                    sequenceList.low = i;
                }
                if (sequenceList.inverse) {
                    int i5 = sequenceList.low;
                    int i6 = sequenceList.high;
                    if (i5 > i6) {
                        sequenceList.low = i6;
                        sequenceList.high = i5;
                    }
                    ListIterator listIterator = linkedList.listIterator();
                    while (listIterator.hasNext()) {
                        int intValue = ((Integer) listIterator.next()).intValue();
                        if (!sequenceList.even || (intValue & 1) != 1) {
                            if (!sequenceList.odd || (intValue & 1) != 0) {
                                if (intValue >= sequenceList.low && intValue <= sequenceList.high) {
                                    listIterator.remove();
                                }
                            }
                        }
                    }
                } else if (sequenceList.low > sequenceList.high) {
                    if (sequenceList.odd || sequenceList.even) {
                        if (sequenceList.even) {
                            sequenceList.low &= -2;
                        } else {
                            int i7 = sequenceList.low;
                            sequenceList.low = i7 - ((i7 & 1) == 1 ? 0 : 1);
                        }
                        i3 = -2;
                    }
                    for (int i8 = sequenceList.low; i8 >= sequenceList.high; i8 += i3) {
                        linkedList.add(Integer.valueOf(i8));
                    }
                } else {
                    if (sequenceList.odd || sequenceList.even) {
                        i2 = 2;
                        if (sequenceList.odd) {
                            sequenceList.low |= 1;
                        } else {
                            int i9 = sequenceList.low;
                            sequenceList.low = i9 + ((i9 & 1) != 1 ? 0 : 1);
                        }
                    } else {
                        i2 = 1;
                    }
                    for (int i10 = sequenceList.low; i10 <= sequenceList.high; i10 += i2) {
                        linkedList.add(Integer.valueOf(i10));
                    }
                }
            }
        }
        return linkedList;
    }
}
