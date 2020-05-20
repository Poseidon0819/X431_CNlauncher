package com.itextpdf.text.log;

/* loaded from: classes.dex */
public final class NoOpLogger implements Logger {
    @Override // com.itextpdf.text.log.Logger
    public final void debug(String str) {
    }

    @Override // com.itextpdf.text.log.Logger
    public final void error(String str) {
    }

    @Override // com.itextpdf.text.log.Logger
    public final void error(String str, Exception exc) {
    }

    @Override // com.itextpdf.text.log.Logger
    public final Logger getLogger(Class<?> cls) {
        return this;
    }

    @Override // com.itextpdf.text.log.Logger
    public final Logger getLogger(String str) {
        return this;
    }

    @Override // com.itextpdf.text.log.Logger
    public final void info(String str) {
    }

    @Override // com.itextpdf.text.log.Logger
    public final boolean isLogging(Level level) {
        return false;
    }

    @Override // com.itextpdf.text.log.Logger
    public final void trace(String str) {
    }

    @Override // com.itextpdf.text.log.Logger
    public final void warn(String str) {
    }
}
