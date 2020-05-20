package com.thoughtworks.xstream.core;

/* loaded from: classes2.dex */
public abstract class BaseException extends RuntimeException {
    @Override // java.lang.Throwable
    public abstract Throwable getCause();

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseException(String str) {
        super(str);
    }
}
