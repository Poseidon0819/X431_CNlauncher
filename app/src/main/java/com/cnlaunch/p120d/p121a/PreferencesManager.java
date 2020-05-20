package com.cnlaunch.p120d.p121a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@SuppressLint({"SdCardPath", "DefaultLocale"})
/* renamed from: com.cnlaunch.d.a.j */
/* loaded from: classes.dex */
public class PreferencesManager {

    /* renamed from: f */
    private static String f7019f = "SHARE_DATA";

    /* renamed from: g */
    private static PreferencesManager f7020g;

    /* renamed from: a */
    public SharedPreferences f7021a;

    /* renamed from: c */
    private Context f7023c;

    /* renamed from: b */
    private final String f7022b = PreferencesManager.class.getSimpleName();

    /* renamed from: d */
    private String f7024d = "/data/data/";

    /* renamed from: e */
    private String f7025e = "/shared_prefs";

    private PreferencesManager(Context context, String str) {
        this.f7023c = context;
        this.f7021a = context.getSharedPreferences(str, 0);
    }

    /* renamed from: a */
    public static PreferencesManager m9595a(Context context) {
        return m9594a(context, f7019f);
    }

    /* renamed from: a */
    private static PreferencesManager m9594a(Context context, String str) {
        if (f7020g == null) {
            synchronized (PreferencesManager.class) {
                if (f7020g == null) {
                    f7020g = new PreferencesManager(context, str);
                }
            }
        }
        return f7020g;
    }

    /* renamed from: a */
    public final void m9587a(String str, boolean z) {
        SharedPreferences.Editor edit = this.f7021a.edit();
        if (edit != null) {
            if (!TextUtils.isEmpty(str)) {
                str = str.toLowerCase();
            }
            edit.putBoolean(str, z);
            edit.commit();
        }
    }

    /* renamed from: a */
    public final void m9588a(String str, String str2) {
        SharedPreferences.Editor edit = this.f7021a.edit();
        if (edit != null) {
            if (!TextUtils.isEmpty(str)) {
                str = str.toLowerCase();
            }
            edit.putString(str, str2);
            edit.commit();
        }
    }

    /* renamed from: a */
    public final void m9590a(String str, int i) {
        SharedPreferences.Editor edit = this.f7021a.edit();
        if (edit != null) {
            if (!TextUtils.isEmpty(str)) {
                str = str.toLowerCase();
            }
            edit.putInt(str, i);
            edit.commit();
        }
    }

    /* renamed from: a */
    public final void m9589a(String str, long j) {
        SharedPreferences.Editor edit = this.f7021a.edit();
        if (edit != null) {
            if (!TextUtils.isEmpty(str)) {
                str = str.toLowerCase();
            }
            edit.putLong(str, j);
            edit.commit();
        }
    }

    /* renamed from: a */
    public final <T> void m9592a(T t) {
        Method[] declaredMethods;
        try {
            SharedPreferences.Editor edit = this.f7021a.edit();
            Class<?> cls = t.getClass();
            if (edit != null) {
                String str = "";
                for (Method method : cls.getDeclaredMethods()) {
                    String name = method.getName();
                    if (name != null && name.startsWith("get")) {
                        Object invoke = method.invoke(t, new Object[0]);
                        if (!TextUtils.isEmpty(String.valueOf(invoke))) {
                            str = String.valueOf(invoke);
                        }
                        edit.putString(name.replace("get", "").toLowerCase(), str);
                    }
                }
                edit.commit();
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
        }
    }

    /* renamed from: a */
    public final String m9591a(String str) {
        if (!TextUtils.isEmpty(str)) {
            str = str.toLowerCase();
        }
        return this.f7021a.getString(str, "");
    }

    /* renamed from: b */
    public final String m9584b(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            str = str.toLowerCase();
        }
        return this.f7021a.getString(str, str2);
    }

    /* renamed from: b */
    public final boolean m9583b(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            str = str.toLowerCase();
        }
        return this.f7021a.getBoolean(str, z);
    }

    /* renamed from: b */
    public final int m9585b(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            str = str.toLowerCase();
        }
        return this.f7021a.getInt(str, i);
    }

    /* renamed from: b */
    public final long m9586b(String str) {
        if (!TextUtils.isEmpty(str)) {
            str = str.toLowerCase();
        }
        return this.f7021a.getLong(str, 0L);
    }

    /* renamed from: a */
    public final <T> Object m9593a(Class<T> cls) {
        Field[] declaredFields;
        T t = null;
        try {
            t = cls.newInstance();
            for (Field field : cls.getDeclaredFields()) {
                if (!"serialVersionUID".equals(field.getName())) {
                    field.getGenericType();
                    field.setAccessible(true);
                    if (field.getGenericType().toString().equals("class java.lang.String")) {
                        field.set(t, m9591a(field.getName()));
                    } else if (field.getGenericType().toString().equals("int")) {
                        field.set(t, Integer.valueOf(Integer.parseInt(m9584b(field.getName(), "0"))));
                    }
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
        } catch (InstantiationException e3) {
            e3.printStackTrace();
        }
        return t;
    }
}
