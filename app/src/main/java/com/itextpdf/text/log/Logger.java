package com.itextpdf.text.log;

/* loaded from: classes.dex */
public interface Logger {
    void debug(String str);

    void error(String str);

    void error(String str, Exception exc);

    Logger getLogger(Class<?> cls);

    Logger getLogger(String str);

    void info(String str);

    boolean isLogging(Level level);

    void trace(String str);

    void warn(String str);
}
