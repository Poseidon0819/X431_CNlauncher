package com.cnlaunch.p120d.p125c.p128c;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.client.CookieStore;
import org.apache.http.cookie.Cookie;

/* renamed from: com.cnlaunch.d.c.c.g */
/* loaded from: classes.dex */
public final class PersistentCookieStore implements CookieStore {

    /* renamed from: a */
    private final ConcurrentHashMap<String, Cookie> f7134a = new ConcurrentHashMap<>();

    /* renamed from: b */
    private final SharedPreferences f7135b;

    public PersistentCookieStore(Context context) {
        String[] split;
        Cookie m9513a;
        this.f7135b = context.getSharedPreferences("CookiePrefsFile", 0);
        String string = this.f7135b.getString("names", null);
        if (string != null) {
            for (String str : TextUtils.split(string, ",")) {
                String string2 = this.f7135b.getString("cookie_".concat(String.valueOf(str)), null);
                if (string2 != null && (m9513a = m9513a(string2)) != null) {
                    this.f7134a.put(str, m9513a);
                }
            }
            clearExpired(new Date());
        }
    }

    public final void addCookie(Cookie cookie) {
        String str = cookie.getName() + cookie.getDomain();
        if (!cookie.isExpired(new Date())) {
            this.f7134a.put(str, cookie);
        } else {
            this.f7134a.remove(str);
        }
        SharedPreferences.Editor edit = this.f7135b.edit();
        edit.putString("names", TextUtils.join(",", this.f7134a.keySet()));
        edit.putString("cookie_".concat(String.valueOf(str)), m9514a(new SerializableCookie(cookie)));
        edit.commit();
    }

    public final void clear() {
        SharedPreferences.Editor edit = this.f7135b.edit();
        for (String str : this.f7134a.keySet()) {
            edit.remove("cookie_".concat(String.valueOf(str)));
        }
        edit.remove("names");
        edit.commit();
        this.f7134a.clear();
    }

    public final boolean clearExpired(Date date) {
        SharedPreferences.Editor edit = this.f7135b.edit();
        boolean z = false;
        for (Map.Entry<String, Cookie> entry : this.f7134a.entrySet()) {
            String key = entry.getKey();
            if (entry.getValue().isExpired(date)) {
                this.f7134a.remove(key);
                edit.remove("cookie_".concat(String.valueOf(key)));
                z = true;
            }
        }
        if (z) {
            edit.putString("names", TextUtils.join(",", this.f7134a.keySet()));
        }
        edit.commit();
        return z;
    }

    public final List<Cookie> getCookies() {
        return new ArrayList(this.f7134a.values());
    }

    /* renamed from: a */
    private static String m9514a(SerializableCookie serializableCookie) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            new ObjectOutputStream(byteArrayOutputStream).writeObject(serializableCookie);
            return m9512a(byteArrayOutputStream.toByteArray());
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    private static String m9512a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            int i = b & 255;
            if (i < 16) {
                sb.append('0');
            }
            sb.append(Integer.toHexString(i));
        }
        return sb.toString().toUpperCase();
    }

    /* renamed from: a */
    private static Cookie m9513a(String str) {
        int length = str.length();
        byte[] bArr = new byte[length / 2];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        try {
            return ((SerializableCookie) new ObjectInputStream(new ByteArrayInputStream(bArr)).readObject()).getCookie();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
