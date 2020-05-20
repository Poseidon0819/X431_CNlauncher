package com.launch.p353a.p364k;

import android.util.Log;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import org.codehaus.jackson.util.MinimalPrettyPrinter;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Utils.java */
/* renamed from: com.launch.a.k.j */
/* loaded from: classes.dex */
public final class C3669j {
    /* renamed from: a */
    private static String[] m2620a(String str, String str2) {
        Vector vector = new Vector();
        int indexOf = str.indexOf(str2);
        int i = 0;
        while (indexOf < str.length() && indexOf != -1) {
            String substring = str.substring(i, indexOf);
            System.out.println(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR.concat(String.valueOf(indexOf)));
            vector.addElement(substring);
            i = str2.length() + indexOf;
            indexOf = str.indexOf(str2, indexOf + str2.length());
        }
        vector.addElement(str.substring((i + 1) - str2.length()));
        String[] strArr = new String[vector.size()];
        for (int i2 = 0; i2 < vector.size(); i2++) {
            strArr[i2] = (String) vector.elementAt(i2);
        }
        return strArr;
    }

    /* renamed from: a */
    public static String m2621a(String str) {
        String[] m2620a = m2620a(str, "/");
        return m2620a[m2620a.length - 2];
    }

    /* renamed from: a */
    public static String m2622a() {
        String readLine;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("http://pv.sohu.com/cityjson?ie=utf-8").openConnection();
            if (httpURLConnection.getResponseCode() == 200) {
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                StringBuilder sb = new StringBuilder();
                while (true) {
                    readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine + "\n");
                }
                inputStream.close();
                String sb2 = sb.toString();
                Log.d("123", sb2);
                try {
                    readLine = new JSONObject(sb2.replace("var returnCitySN = ", "")).getString("cip");
                    return readLine == null ? "" : readLine;
                } catch (JSONException e) {
                    e.printStackTrace();
                    return readLine;
                }
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* renamed from: b */
    public static int m2619b(String str) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(Long.parseLong(str) * 1000));
        return calendar.get(5);
    }

    /* renamed from: c */
    public static int m2618c(String str) {
        Date date = new Date(Long.parseLong(str) * 1000);
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(2);
        calendar.set(7, 2);
        calendar.setMinimalDaysInFirstWeek(7);
        calendar.setTime(date);
        return calendar.get(3);
    }

    /* renamed from: d */
    public static int m2617d(String str) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(Long.parseLong(str) * 1000));
        return calendar.get(2) + 1;
    }

    /* renamed from: e */
    public static int m2616e(String str) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(Long.parseLong(str) * 1000));
        return calendar.get(1);
    }
}
