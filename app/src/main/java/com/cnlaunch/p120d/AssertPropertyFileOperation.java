package com.cnlaunch.p120d;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

/* renamed from: com.cnlaunch.d.a */
/* loaded from: classes.dex */
public class AssertPropertyFileOperation {

    /* renamed from: a */
    public Properties f6740a;

    /* renamed from: b */
    private String f6741b;

    public AssertPropertyFileOperation(Context context, String str) {
        this.f6740a = new Properties();
        this.f6741b = str;
        try {
            InputStream open = context.getAssets().open(str);
            if (open != null) {
                this.f6740a.load(open);
                open.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
            this.f6740a = null;
        }
    }

    public String toString() {
        if (this.f6740a == null) {
            return String.format(" %s no property", this.f6741b);
        }
        StringBuilder sb = new StringBuilder();
        Enumeration<?> propertyNames = this.f6740a.propertyNames();
        while (propertyNames.hasMoreElements()) {
            String obj = propertyNames.nextElement().toString();
            sb.append(String.format("(%s=%s),", obj, this.f6740a.getProperty(obj)));
        }
        return sb.toString();
    }
}
