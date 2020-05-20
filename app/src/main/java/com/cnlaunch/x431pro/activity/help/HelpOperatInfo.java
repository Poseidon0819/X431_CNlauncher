package com.cnlaunch.x431pro.activity.help;

import android.os.Environment;
import com.cnlaunch.x431pro.activity.help.IniEditor;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Locale;

/* renamed from: com.cnlaunch.x431pro.activity.help.i */
/* loaded from: classes.dex */
public final class HelpOperatInfo {

    /* renamed from: a */
    static String f12792a = Environment.getExternalStorageDirectory() + "/cnlaunch/mycar/help/";

    /* renamed from: a */
    public static boolean m6909a(String str, String str2) {
        return m6908a(Locale.getDefault().getLanguage(), str, str2);
    }

    /* renamed from: a */
    private static boolean m6908a(String str, String str2, String str3) {
        File file = new File(f12792a);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(f12792a + "/helpOperateInfo.ini");
        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (Exception unused) {
                return false;
            }
        }
        IniEditor iniEditor = new IniEditor();
        try {
            iniEditor.m6904a(file2);
            if (!iniEditor.m6900a(str)) {
                iniEditor.m6899b(str);
            }
            if (iniEditor.m6900a(str)) {
                iniEditor.m6898c(str).m6890a(str2, str3);
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file2);
                    iniEditor.m6901a(new OutputStreamWriter(fileOutputStream));
                    fileOutputStream.close();
                    return true;
                } catch (IOException unused2) {
                    return false;
                }
            }
            throw new IniEditor.C2262c(str);
        } catch (IOException unused3) {
            return false;
        }
    }

    /* renamed from: a */
    public static String m6910a(String str) {
        return m6907b(Locale.getDefault().getLanguage(), str);
    }

    /* renamed from: b */
    private static String m6907b(String str, String str2) {
        File file = new File(f12792a);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(f12792a + "/helpOperateInfo.ini");
        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (Exception unused) {
                return "";
            }
        }
        IniEditor iniEditor = new IniEditor();
        try {
            iniEditor.m6904a(file2);
            if (iniEditor.m6900a(str)) {
                IniEditor.C2265f m6898c = iniEditor.m6898c(str);
                if (m6898c.m6891a(str2)) {
                    return m6898c.m6888b(str2);
                }
                if (iniEditor.f12815a != null) {
                    return iniEditor.m6898c(iniEditor.f12815a).m6888b(str2);
                }
                return null;
            }
            return null;
        } catch (IOException unused2) {
            return "";
        }
    }
}
