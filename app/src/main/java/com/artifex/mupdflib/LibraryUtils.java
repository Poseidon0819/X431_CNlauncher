package com.artifex.mupdflib;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.preference.PreferenceManager;
import java.util.Locale;

/* loaded from: classes.dex */
public class LibraryUtils {
    private static String PREF_APP_LANGUAGE = "prefKeyLanguage";
    private static Locale locale;

    public static void reloadLocale(Context context) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
        String string = defaultSharedPreferences.getString(PREF_APP_LANGUAGE, Locale.getDefault().getLanguage());
        if (defaultSharedPreferences.getString(PREF_APP_LANGUAGE, "").equalsIgnoreCase("")) {
            defaultSharedPreferences.edit().putString(PREF_APP_LANGUAGE, string).commit();
        }
        Configuration configuration = context.getResources().getConfiguration();
        if (!configuration.locale.getLanguage().equals(string)) {
            locale = new Locale(string);
        }
        Locale locale2 = locale;
        if (locale2 != null) {
            Locale.setDefault(locale2);
            configuration.locale = locale;
            context.getResources().updateConfiguration(configuration, context.getResources().getDisplayMetrics());
        }
    }
}
