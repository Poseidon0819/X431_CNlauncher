package com.cnlaunch.x431pro.utils.p283db;

import android.content.Context;
import android.text.TextUtils;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.p120d.p130d.p131a.LangManager;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.utils.PathUtils;
import com.cnlaunch.x431pro.utils.p285e.FileUtils;
import com.cnlaunch.x431pro.utils.p286f.CarIconUtils;
import java.io.File;

/* renamed from: com.cnlaunch.x431pro.utils.db.a */
/* loaded from: classes.dex */
public class CarIcon {

    /* renamed from: a */
    Long f15777a;

    /* renamed from: b */
    public String f15778b;

    /* renamed from: c */
    public String f15779c;

    /* renamed from: d */
    public String f15780d;

    /* renamed from: e */
    public String f15781e;

    /* renamed from: f */
    public String f15782f;

    /* renamed from: g */
    public String f15783g;

    /* renamed from: h */
    public String f15784h;

    /* renamed from: i */
    public String f15785i;

    /* renamed from: j */
    public String f15786j;

    /* renamed from: k */
    public Boolean f15787k;

    /* renamed from: l */
    public String f15788l;

    /* renamed from: m */
    public String f15789m;

    /* renamed from: n */
    public String f15790n;

    /* renamed from: o */
    public Boolean f15791o;

    /* renamed from: p */
    public String f15792p = "";

    public CarIcon() {
    }

    public CarIcon(Long l, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, Boolean bool, String str10, String str11, String str12, Boolean bool2) {
        this.f15777a = l;
        this.f15778b = str;
        this.f15779c = str2;
        this.f15780d = str3;
        this.f15781e = str4;
        this.f15782f = str5;
        this.f15783g = str6;
        this.f15784h = str7;
        this.f15785i = str8;
        this.f15786j = str9;
        this.f15787k = bool;
        this.f15788l = str10;
        this.f15789m = str11;
        this.f15790n = str12;
        this.f15791o = bool2;
    }

    /* renamed from: a */
    public final void m5037a(String str) {
        if (!TextUtils.isEmpty(str)) {
            String replaceAll = str.replaceAll("//", "/");
            String replaceAll2 = PathUtils.m4858c().replaceAll("//", "/");
            if (replaceAll.contains(replaceAll2)) {
                str = replaceAll.replace(replaceAll2, "");
            }
        }
        this.f15789m = str;
    }

    /* renamed from: a */
    public final String m5038a(Context context) {
        try {
            return context.getString(Integer.valueOf(this.f15780d).intValue());
        } catch (NumberFormatException unused) {
            if (LangManager.m9469a().equals("zh")) {
                if (LangManager.m9466b().equalsIgnoreCase("CN")) {
                    return this.f15780d;
                }
                String str = PathUtils.m4858c() + this.f15789m + File.separator + "VEHICLE.INI";
                if (new File(str).exists()) {
                    String m5008a = FileUtils.m5008a(FileUtils.m4996f(str), "Name", "HKChinese");
                    return TextUtils.isEmpty(m5008a) ? this.f15779c : m5008a;
                }
                String str2 = PathUtils.m4858c() + this.f15789m + File.separator + "ICON.INI";
                if (new File(str2).exists()) {
                    String m5008a2 = FileUtils.m5008a(FileUtils.m4996f(str2), this.f15778b, "HKChinese");
                    return !TextUtils.isEmpty(m5008a2) ? m5008a2 : this.f15779c;
                }
                return this.f15779c;
            }
            if (CarIconUtils.f15866f.equals(this.f15782f)) {
                String str3 = this.f15789m + File.separator + "VEHICLE.INI";
                if (new File(str3).exists()) {
                    String m5008a3 = FileUtils.m5008a(FileUtils.m4996f(str3), "Name", C2744aa.m5131o());
                    return TextUtils.isEmpty(m5008a3) ? this.f15779c : m5008a3;
                }
            }
            return "";
        } catch (Exception e) {
            NLog.m9455a(e);
            return this.f15780d;
        }
    }

    public String toString() {
        return "CarIcon [id=" + this.f15777a + ", softPackageId=" + this.f15778b + ", name=" + this.f15779c + ", name_zh=" + this.f15780d + ", icon=" + this.f15781e + ", areaId=" + this.f15782f + ", sname=" + this.f15783g + ", sname_zh=" + this.f15784h + ", maxversion=" + this.f15785i + ", versionlist=" + this.f15786j + ", isDownload=" + this.f15787k + ", languageList=" + this.f15788l + ", vehiclePath=" + this.f15789m + ", serialNo=" + this.f15790n + ", isFavorites=" + this.f15791o + "]";
    }

    public boolean equals(Object obj) {
        return (obj instanceof CarIcon) && toString().equals(((CarIcon) obj).toString());
    }
}
