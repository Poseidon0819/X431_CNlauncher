package com.cnlaunch.p120d.p125c.p128c;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.cookie.BasicClientCookie;

/* renamed from: com.cnlaunch.d.c.c.k */
/* loaded from: classes.dex */
public final class SerializableCookie implements Serializable {
    private static final long serialVersionUID = 6374381828722046732L;

    /* renamed from: a */
    private final transient Cookie f7147a;

    /* renamed from: b */
    private transient BasicClientCookie f7148b;

    public SerializableCookie(Cookie cookie) {
        this.f7147a = cookie;
    }

    public final Cookie getCookie() {
        Cookie cookie = this.f7147a;
        BasicClientCookie basicClientCookie = this.f7148b;
        return basicClientCookie != null ? basicClientCookie : cookie;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(this.f7147a.getName());
        objectOutputStream.writeObject(this.f7147a.getValue());
        objectOutputStream.writeObject(this.f7147a.getComment());
        objectOutputStream.writeObject(this.f7147a.getDomain());
        objectOutputStream.writeObject(this.f7147a.getExpiryDate());
        objectOutputStream.writeObject(this.f7147a.getPath());
        objectOutputStream.writeInt(this.f7147a.getVersion());
        objectOutputStream.writeBoolean(this.f7147a.isSecure());
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.f7148b = new BasicClientCookie((String) objectInputStream.readObject(), (String) objectInputStream.readObject());
        this.f7148b.setComment((String) objectInputStream.readObject());
        this.f7148b.setDomain((String) objectInputStream.readObject());
        this.f7148b.setExpiryDate((Date) objectInputStream.readObject());
        this.f7148b.setPath((String) objectInputStream.readObject());
        this.f7148b.setVersion(objectInputStream.readInt());
        this.f7148b.setSecure(objectInputStream.readBoolean());
    }
}
