package com.cnlaunch.golo3.p165g;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/* compiled from: Utils.java */
/* renamed from: com.cnlaunch.golo3.g.y */
/* loaded from: classes.dex */
public final class C1622y {
    /* renamed from: a */
    public static boolean m9112a(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return false;
            }
            return activeNetworkInfo.isConnected();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: a */
    public static Properties m9111a(InputStream inputStream) {
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
