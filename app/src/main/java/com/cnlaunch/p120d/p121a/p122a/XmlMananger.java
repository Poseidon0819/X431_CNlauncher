package com.cnlaunch.p120d.p121a.p122a;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.p366io.xml.XppDriver;

/* renamed from: com.cnlaunch.d.a.a.c */
/* loaded from: classes.dex */
public class XmlMananger {

    /* renamed from: c */
    private static XmlMananger f6749c;

    /* renamed from: a */
    public XStream f6750a;

    /* renamed from: b */
    private final String f6751b = XmlMananger.class.getSimpleName();

    private XmlMananger() {
        if (this.f6750a == null) {
            this.f6750a = new C1414d(this, new XppDriver());
        }
    }

    /* renamed from: a */
    public static XmlMananger m9614a() {
        if (f6749c == null) {
            synchronized (XmlMananger.class) {
                if (f6749c == null) {
                    f6749c = new XmlMananger();
                }
            }
        }
        return f6749c;
    }
}
