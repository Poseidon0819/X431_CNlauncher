package com.itextpdf.text.log;

/* loaded from: classes.dex */
public class LoggerFactory {
    private static LoggerFactory myself = new LoggerFactory();
    private Logger logger = new NoOpLogger();

    public static Logger getLogger(Class<?> cls) {
        return myself.logger.getLogger(cls);
    }

    public static Logger getLogger(String str) {
        return myself.logger.getLogger(str);
    }

    public static LoggerFactory getInstance() {
        return myself;
    }

    private LoggerFactory() {
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    public Logger logger() {
        return this.logger;
    }
}
