package com.itextpdf.text.log;

/* loaded from: classes.dex */
public class SysoLogger implements Logger {
    private String name;
    private final int shorten;

    @Override // com.itextpdf.text.log.Logger
    public boolean isLogging(Level level) {
        return true;
    }

    public SysoLogger() {
        this(1);
    }

    public SysoLogger(int i) {
        this.shorten = i;
    }

    protected SysoLogger(String str, int i) {
        this.shorten = i;
        this.name = str;
    }

    @Override // com.itextpdf.text.log.Logger
    public Logger getLogger(Class<?> cls) {
        return new SysoLogger(cls.getName(), this.shorten);
    }

    @Override // com.itextpdf.text.log.Logger
    public Logger getLogger(String str) {
        return new SysoLogger("[itext]", 0);
    }

    @Override // com.itextpdf.text.log.Logger
    public void warn(String str) {
        System.out.println(String.format("%s WARN  %s", shorten(this.name), str));
    }

    private String shorten(String str) {
        if (this.shorten != 0) {
            StringBuilder sb = new StringBuilder();
            int indexOf = str.indexOf(46);
            String str2 = str;
            while (indexOf != -1) {
                int i = this.shorten;
                if (indexOf < i) {
                    i = indexOf;
                }
                sb.append(str2.substring(0, i));
                sb.append('.');
                str2 = str2.substring(indexOf + 1);
                indexOf = str2.indexOf(46);
            }
            sb.append(str.substring(str.lastIndexOf(46) + 1));
            return sb.toString();
        }
        return str;
    }

    @Override // com.itextpdf.text.log.Logger
    public void trace(String str) {
        System.out.println(String.format("%s TRACE %s", shorten(this.name), str));
    }

    @Override // com.itextpdf.text.log.Logger
    public void debug(String str) {
        System.out.println(String.format("%s DEBUG %s", shorten(this.name), str));
    }

    @Override // com.itextpdf.text.log.Logger
    public void info(String str) {
        System.out.println(String.format("%s INFO  %s", shorten(this.name), str));
    }

    @Override // com.itextpdf.text.log.Logger
    public void error(String str) {
        System.out.println(String.format("%s ERROR %s", this.name, str));
    }

    @Override // com.itextpdf.text.log.Logger
    public void error(String str, Exception exc) {
        System.out.println(String.format("%s ERROR %s", this.name, str));
        exc.printStackTrace(System.out);
    }
}
