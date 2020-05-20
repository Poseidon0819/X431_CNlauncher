package com.itextpdf.text;

import java.io.PrintStream;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public class ExceptionConverter extends RuntimeException {
    private static final long serialVersionUID = 8657630363395849399L;

    /* renamed from: ex */
    private Exception f19588ex;
    private String prefix;

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        return this;
    }

    public ExceptionConverter(Exception exc) {
        super(exc);
        this.f19588ex = exc;
        this.prefix = exc instanceof RuntimeException ? "" : "ExceptionConverter: ";
    }

    public static final RuntimeException convertException(Exception exc) {
        if (exc instanceof RuntimeException) {
            return (RuntimeException) exc;
        }
        return new ExceptionConverter(exc);
    }

    public Exception getException() {
        return this.f19588ex;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.f19588ex.getMessage();
    }

    @Override // java.lang.Throwable
    public String getLocalizedMessage() {
        return this.f19588ex.getLocalizedMessage();
    }

    @Override // java.lang.Throwable
    public String toString() {
        return this.prefix + this.f19588ex;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        synchronized (printStream) {
            printStream.print(this.prefix);
            this.f19588ex.printStackTrace(printStream);
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        synchronized (printWriter) {
            printWriter.print(this.prefix);
            this.f19588ex.printStackTrace(printWriter);
        }
    }
}
