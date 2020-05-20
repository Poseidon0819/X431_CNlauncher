package com.thoughtworks.xstream.core.util;

/* loaded from: classes2.dex */
public final class FastStack {
    private int pointer;
    private Object[] stack;

    public FastStack(int i) {
        this.stack = new Object[i];
    }

    public final Object push(Object obj) {
        int i = this.pointer + 1;
        Object[] objArr = this.stack;
        if (i >= objArr.length) {
            resizeStack(objArr.length * 2);
        }
        Object[] objArr2 = this.stack;
        int i2 = this.pointer;
        this.pointer = i2 + 1;
        objArr2[i2] = obj;
        return obj;
    }

    public final void popSilently() {
        Object[] objArr = this.stack;
        int i = this.pointer - 1;
        this.pointer = i;
        objArr[i] = null;
    }

    public final Object pop() {
        Object[] objArr = this.stack;
        int i = this.pointer - 1;
        this.pointer = i;
        Object obj = objArr[i];
        objArr[this.pointer] = null;
        return obj;
    }

    public final Object peek() {
        int i = this.pointer;
        if (i == 0) {
            return null;
        }
        return this.stack[i - 1];
    }

    public final Object replace(Object obj) {
        Object[] objArr = this.stack;
        int i = this.pointer;
        Object obj2 = objArr[i - 1];
        objArr[i - 1] = obj;
        return obj2;
    }

    public final void replaceSilently(Object obj) {
        this.stack[this.pointer - 1] = obj;
    }

    public final int size() {
        return this.pointer;
    }

    public final boolean hasStuff() {
        return this.pointer > 0;
    }

    public final Object get(int i) {
        return this.stack[i];
    }

    private void resizeStack(int i) {
        Object[] objArr = new Object[i];
        System.arraycopy(this.stack, 0, objArr, 0, Math.min(this.pointer, i));
        this.stack = objArr;
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer("[");
        for (int i = 0; i < this.pointer; i++) {
            if (i > 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(this.stack[i]);
        }
        stringBuffer.append(']');
        return stringBuffer.toString();
    }
}
