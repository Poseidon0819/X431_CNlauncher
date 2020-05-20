package com.thoughtworks.xstream;

import com.thoughtworks.xstream.core.BaseException;

/* loaded from: classes2.dex */
public class XStreamException extends BaseException {
    private Throwable cause;

    protected XStreamException() {
        this("", null);
    }

    public XStreamException(String str) {
        this(str, null);
    }

    public XStreamException(Throwable th) {
        this("", th);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public XStreamException(java.lang.String r3, java.lang.Throwable r4) {
        /*
            r2 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r3)
            if (r4 != 0) goto Ld
            java.lang.String r3 = ""
            goto L1f
        Ld:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r1 = " : "
            r3.<init>(r1)
            java.lang.String r1 = r4.getMessage()
            r3.append(r1)
            java.lang.String r3 = r3.toString()
        L1f:
            r0.append(r3)
            java.lang.String r3 = r0.toString()
            r2.<init>(r3)
            r2.cause = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.thoughtworks.xstream.XStreamException.<init>(java.lang.String, java.lang.Throwable):void");
    }

    @Override // com.thoughtworks.xstream.core.BaseException, java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }
}
