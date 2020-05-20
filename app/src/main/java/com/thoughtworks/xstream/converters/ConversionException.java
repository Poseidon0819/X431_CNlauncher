package com.thoughtworks.xstream.converters;

import com.cnlaunch.p169im.p174db.MessageDao;
import com.thoughtworks.xstream.XStreamException;
import com.thoughtworks.xstream.core.util.OrderRetainingMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public class ConversionException extends XStreamException implements ErrorWriter {
    private static final String SEPARATOR = "\n-------------------------------";
    private Map stuff;

    public ConversionException(String str, Throwable th) {
        super(str, th);
        this.stuff = new OrderRetainingMap();
        if (str != null) {
            add(MessageDao.TABLENAME, str);
        }
        if (th != null) {
            add("cause-exception", th.getClass().getName());
            add("cause-message", th instanceof ConversionException ? ((ConversionException) th).getShortMessage() : th.getMessage());
        }
    }

    public ConversionException(String str) {
        super(str);
        this.stuff = new OrderRetainingMap();
    }

    public ConversionException(Throwable th) {
        this(th.getMessage(), th);
    }

    @Override // com.thoughtworks.xstream.converters.ErrorWriter
    public String get(String str) {
        return (String) this.stuff.get(str);
    }

    @Override // com.thoughtworks.xstream.converters.ErrorWriter
    public void add(String str, String str2) {
        String str3 = str;
        int i = 0;
        while (this.stuff.containsKey(str3)) {
            if (str2.equals((String) this.stuff.get(str3))) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("[");
            i++;
            sb.append(i);
            sb.append("]");
            str3 = sb.toString();
        }
        this.stuff.put(str3, str2);
    }

    @Override // com.thoughtworks.xstream.converters.ErrorWriter
    public void set(String str, String str2) {
        this.stuff.put(str, str2);
        String str3 = str;
        int i = 0;
        while (this.stuff.containsKey(str3)) {
            if (i != 0) {
                this.stuff.remove(str3);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("[");
            i++;
            sb.append(i);
            sb.append("]");
            str3 = sb.toString();
        }
    }

    @Override // com.thoughtworks.xstream.converters.ErrorWriter
    public Iterator keys() {
        return this.stuff.keySet().iterator();
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        StringBuffer stringBuffer = new StringBuffer();
        if (super.getMessage() != null) {
            stringBuffer.append(super.getMessage());
        }
        if (!stringBuffer.toString().endsWith(SEPARATOR)) {
            stringBuffer.append("\n---- Debugging information ----");
        }
        Iterator keys = keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            String str2 = get(str);
            stringBuffer.append('\n');
            stringBuffer.append(str);
            stringBuffer.append("                    ".substring(Math.min(20, str.length())));
            stringBuffer.append(": ");
            stringBuffer.append(str2);
        }
        stringBuffer.append(SEPARATOR);
        return stringBuffer.toString();
    }

    public String getShortMessage() {
        return super.getMessage();
    }
}
