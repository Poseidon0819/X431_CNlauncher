package com.thoughtworks.xstream.core.util;

/* loaded from: classes2.dex */
public class DependencyInjectionFactory {
    public static Object newInstance(Class cls, Object[] objArr) {
        return newInstance(cls, objArr, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0185  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.Object newInstance(java.lang.Class r24, java.lang.Object[] r25, java.util.BitSet r26) {
        /*
            Method dump skipped, instructions count: 607
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.thoughtworks.xstream.core.util.DependencyInjectionFactory.newInstance(java.lang.Class, java.lang.Object[], java.util.BitSet):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class TypedValue {
        final Class type;
        final Object value;

        public TypedValue(Class cls, Object obj) {
            this.type = cls;
            this.value = obj;
        }

        public String toString() {
            return this.type.getName() + ":" + this.value;
        }
    }
}
