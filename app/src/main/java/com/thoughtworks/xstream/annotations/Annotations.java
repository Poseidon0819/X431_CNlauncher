package com.thoughtworks.xstream.annotations;

import com.thoughtworks.xstream.XStream;

@Deprecated
/* loaded from: classes2.dex */
public class Annotations {
    private Annotations() {
    }

    @Deprecated
    public static synchronized void configureAliases(XStream xStream, Class<?>... clsArr) {
        synchronized (Annotations.class) {
            xStream.processAnnotations(clsArr);
        }
    }
}
