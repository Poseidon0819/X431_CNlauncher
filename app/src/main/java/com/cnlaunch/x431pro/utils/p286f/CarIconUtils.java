package com.cnlaunch.x431pro.utils.p286f;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.text.TextUtils;
import com.cnlaunch.diagnosemodule.utils.AndroidToLan;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.p120d.p130d.p131a.LangManager;
import com.cnlaunch.x431pro.module.p252d.p254b.CarVersionInfo;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.utils.C2787z;
import com.cnlaunch.x431pro.utils.PathUtils;
import com.cnlaunch.x431pro.utils.p283db.CarIcon;
import com.cnlaunch.x431pro.utils.p283db.CarIconDao;
import com.cnlaunch.x431pro.utils.p283db.CarVersion;
import com.cnlaunch.x431pro.utils.p283db.CarVersionDao;
import com.cnlaunch.x431pro.utils.p283db.FavoritesCarIconDao;
import com.cnlaunch.x431pro.utils.p283db.p284a.DBManager;
import com.cnlaunch.x431pro.utils.p283db.p284a.DaoSession;
import com.cnlaunch.x431pro.utils.p283db.p284a.FavoritesDBManager;
import com.cnlaunch.x431pro.utils.p285e.FileUtils;
import de.greenrobot.dao.query.QueryBuilder;
import de.greenrobot.dao.query.WhereCondition;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@SuppressLint({"DefaultLocale"})
/* renamed from: com.cnlaunch.x431pro.utils.f.c */
/* loaded from: classes.dex */
public class CarIconUtils {

    /* renamed from: a */
    public static final String f15861a = "c";

    /* renamed from: b */
    public static String f15862b = "ASIA";

    /* renamed from: c */
    public static String f15863c = "CHINA";

    /* renamed from: d */
    public static String f15864d = "EUROPE";

    /* renamed from: e */
    public static String f15865e = "USA";

    /* renamed from: f */
    public static String f15866f = "RESET";

    /* renamed from: g */
    public static String f15867g = "COMMON";

    /* renamed from: h */
    public static String f15868h = "HEAVYDUTY";

    /* renamed from: i */
    public static String f15869i = "CARS";

    /* renamed from: j */
    public static String f15870j = "ENGINE";

    /* renamed from: k */
    public static String f15871k = "NEWENERGY";

    /* renamed from: l */
    public static String f15872l = "ELETRONICCONTROL";

    /* renamed from: m */
    public static String f15873m = "PROGRAMMING";

    /* renamed from: n */
    public static String f15874n = "CLA_ALL";

    /* renamed from: o */
    public static String f15875o = "CLA_TRUCK";

    /* renamed from: p */
    public static String f15876p = "CLA_PASSENGERCAR";

    /* renamed from: q */
    public static String f15877q = "CLA_MECHANICS";

    /* renamed from: r */
    public static Lock f15878r = new ReentrantLock();

    /* renamed from: y */
    private static CarIconUtils f15879y;

    /* renamed from: s */
    public Context f15880s;

    /* renamed from: t */
    public CarIconDao f15881t;

    /* renamed from: u */
    private CarIcon f15882u;

    /* renamed from: v */
    private DaoSession f15883v;

    /* renamed from: w */
    private CarVersionDao f15884w;

    /* renamed from: x */
    private List<List<HashMap<String, String>>> f15885x;

    /* renamed from: a */
    public static CarIconUtils m4977a(Context context) {
        synchronized (CarIconUtils.class) {
            if (f15879y == null) {
                f15879y = new CarIconUtils(context);
            }
        }
        return f15879y;
    }

    public CarIconUtils(Context context) {
        this.f15880s = context;
        this.f15883v = DBManager.m5036a(this.f15880s).f15794a;
        this.f15881t = this.f15883v.f15799b;
        this.f15884w = this.f15883v.f15800c;
    }

    /* renamed from: a */
    public final boolean m4978a() {
        return this.f15881t.count() <= 0;
    }

    /* renamed from: b */
    public final void m4967b() {
        NLog.m9456a(f15861a, "initCarIcon enter.");
        f15878r.lock();
        try {
            try {
            } catch (Exception e) {
                NLog.m9455a(e);
            }
            if (m4978a()) {
                this.f15885x = new ArrayList();
                List<HashMap<String, String>> m4940a = ChinaIcon.m4940a(this.f15880s);
                List<HashMap<String, String>> m4979a = AsiaIcon.m4979a(this.f15880s);
                List<HashMap<String, String>> m4939a = EuroIcon.m4939a(this.f15880s);
                List<HashMap<String, String>> m4980a = AmericaIcon.m4980a(this.f15880s);
                List<HashMap<String, String>> m4938a = ResetIcon.m4938a(this.f15880s);
                this.f15885x.add(m4940a);
                this.f15885x.add(m4979a);
                this.f15885x.add(m4939a);
                this.f15885x.add(m4980a);
                this.f15885x.add(m4938a);
                this.f15883v.runInTx(new RunnableC2767d(this));
            }
        } finally {
            f15878r.unlock();
        }
    }

    /* renamed from: a */
    public final void m4972a(String str, String str2) {
        String str3 = f15861a;
        NLog.m9456a(str3, "update enter, serialNo=" + str + ",heavydutySerialNo=" + str2);
        m4960c();
        m4955d(str);
        m4955d(str2);
    }

    /* renamed from: a */
    public final void m4973a(String str) {
        NLog.m9456a(f15861a, "update enter, serialNo=".concat(String.valueOf(str)));
        m4960c();
        m4955d(str);
    }

    /* renamed from: d */
    private void m4955d(String str) {
        CarIconUtils carIconUtils;
        ArrayList arrayList;
        String str2;
        String[] strArr;
        ArrayList arrayList2;
        int i;
        int i2;
        Iterator<Map.Entry<String, Properties>> it;
        boolean z;
        ArrayList arrayList3;
        CarIconUtils carIconUtils2 = this;
        f15878r.lock();
        try {
            int i3 = 1;
            int i4 = 0;
            if (TextUtils.isEmpty(str)) {
                NLog.m9452b(f15861a, "serial number is empty.");
                f15878r.unlock();
                return;
            }
            String m4861b = PathUtils.m4861b(carIconUtils2.f15880s, str);
            File file = new File(m4861b);
            ArrayList arrayList4 = new ArrayList();
            if (file.exists()) {
                String[] list = file.list();
                if (list == null || list.length <= 0) {
                    carIconUtils = carIconUtils2;
                    arrayList = arrayList4;
                } else {
                    ArrayList arrayList5 = new ArrayList();
                    int length = list.length;
                    int i5 = 0;
                    while (i5 < length) {
                        try {
                            String str3 = list[i5];
                            String[] strArr2 = new String[2];
                            strArr2[i4] = m4861b;
                            strArr2[i3] = str3;
                            String m4863a = PathUtils.m4863a(strArr2);
                            String m4946h = m4946h(m4863a);
                            if (TextUtils.isEmpty(m4946h)) {
                                str2 = m4861b;
                                strArr = list;
                                arrayList2 = arrayList4;
                                i = length;
                                i2 = i5;
                            } else {
                                QueryBuilder<CarIcon> queryBuilder = carIconUtils2.f15881t.queryBuilder();
                                queryBuilder.where(CarIconDao.Properties.SoftPackageId.m321eq(str3), new WhereCondition[i4]);
                                List<CarIcon> list2 = queryBuilder.list();
                                String m4948g = m4948g(m4863a);
                                String m4943i = m4943i(m4863a, m4946h);
                                if (list2 != null && list2.size() > 0) {
                                    CarIcon carIcon = null;
                                    str2 = m4861b;
                                    Object[] objArr = new Object[i3];
                                    strArr = list;
                                    objArr[0] = "queryList.size()=" + list2.size();
                                    NLog.m9456a("yhx", objArr);
                                    int i6 = 0;
                                    boolean z2 = false;
                                    while (true) {
                                        if (i6 >= list2.size()) {
                                            i = length;
                                            i2 = i5;
                                            break;
                                        }
                                        CarIcon carIcon2 = list2.get(i6);
                                        String str4 = carIcon2.f15790n;
                                        boolean z3 = z2;
                                        i = length;
                                        if (carIcon2.f15778b.equalsIgnoreCase("AUTOSEARCH")) {
                                            if (!TextUtils.isEmpty(str4)) {
                                                i2 = i5;
                                                NLog.m9456a("yhx", "itemSerialNo=".concat(String.valueOf(str4)));
                                                if (!str.equals(str4)) {
                                                    z2 = true;
                                                    if (i6 == list2.size() - 1 && z2) {
                                                        CarIcon carIcon3 = new CarIcon();
                                                        carIcon3.f15778b = str3;
                                                        carIcon3.f15781e = carIcon2.f15781e;
                                                        carIcon3.f15779c = carIcon2.f15779c;
                                                        carIcon3.f15780d = carIcon2.f15780d;
                                                        carIcon3.f15784h = carIcon2.f15784h;
                                                        carIcon3.f15783g = carIcon2.f15783g;
                                                        carIcon3.f15782f = carIcon2.f15782f;
                                                        carIcon3.f15787k = Boolean.TRUE;
                                                        carIcon3.f15790n = str;
                                                        carIcon3.f15787k = Boolean.TRUE;
                                                        carIcon3.f15785i = m4948g;
                                                        carIcon3.f15786j = m4946h;
                                                        carIcon3.f15788l = m4943i;
                                                        carIcon3.m5037a(m4863a);
                                                        arrayList4.add(carIcon3);
                                                        NLog.m9456a("yhx", "inser item carIcon=".concat(String.valueOf(carIcon3)));
                                                    }
                                                    i6++;
                                                    carIcon = carIcon2;
                                                    length = i;
                                                    i5 = i2;
                                                } else {
                                                    carIcon2.f15790n = str;
                                                    carIcon2.f15787k = Boolean.TRUE;
                                                    carIcon2.f15785i = m4948g;
                                                    carIcon2.f15786j = m4946h;
                                                    carIcon2.f15788l = m4943i;
                                                    carIcon2.m5037a(m4863a);
                                                    arrayList5.add(carIcon2);
                                                    break;
                                                }
                                            } else {
                                                i2 = i5;
                                            }
                                        } else {
                                            i2 = i5;
                                        }
                                        if (m4976a(carIcon2) && m4863a.contains(str3)) {
                                            NLog.m9456a("yhx", "deleteDirectory versionPath=".concat(String.valueOf(m4863a)));
                                            FileUtils.m4995g(m4863a);
                                            break;
                                        }
                                        carIcon2.f15790n = str;
                                        carIcon2.f15787k = Boolean.TRUE;
                                        carIcon2.f15785i = m4948g;
                                        carIcon2.f15786j = m4946h;
                                        carIcon2.f15788l = m4943i;
                                        carIcon2.m5037a(m4863a);
                                        arrayList5.add(carIcon2);
                                        carIcon2 = carIcon;
                                        z2 = z3;
                                        if (i6 == list2.size() - 1) {
                                            CarIcon carIcon32 = new CarIcon();
                                            carIcon32.f15778b = str3;
                                            carIcon32.f15781e = carIcon2.f15781e;
                                            carIcon32.f15779c = carIcon2.f15779c;
                                            carIcon32.f15780d = carIcon2.f15780d;
                                            carIcon32.f15784h = carIcon2.f15784h;
                                            carIcon32.f15783g = carIcon2.f15783g;
                                            carIcon32.f15782f = carIcon2.f15782f;
                                            carIcon32.f15787k = Boolean.TRUE;
                                            carIcon32.f15790n = str;
                                            carIcon32.f15787k = Boolean.TRUE;
                                            carIcon32.f15785i = m4948g;
                                            carIcon32.f15786j = m4946h;
                                            carIcon32.f15788l = m4943i;
                                            carIcon32.m5037a(m4863a);
                                            arrayList4.add(carIcon32);
                                            NLog.m9456a("yhx", "inser item carIcon=".concat(String.valueOf(carIcon32)));
                                        }
                                        i6++;
                                        carIcon = carIcon2;
                                        length = i;
                                        i5 = i2;
                                    }
                                } else {
                                    str2 = m4861b;
                                    strArr = list;
                                    i = length;
                                    i2 = i5;
                                }
                                String str5 = m4863a + File.separator + "ICON.INI";
                                File file2 = new File(str5);
                                C2744aa.m5135m();
                                if (file2.exists()) {
                                    boolean equalsIgnoreCase = LangManager.m9466b().equalsIgnoreCase("CN");
                                    Iterator<Map.Entry<String, Properties>> it2 = FileUtils.m4996f(str5).entrySet().iterator();
                                    while (it2.hasNext()) {
                                        Map.Entry<String, Properties> next = it2.next();
                                        if (next != null) {
                                            String key = next.getKey();
                                            Properties value = next.getValue();
                                            if (!TextUtils.isEmpty(key) && !key.equals("MAKE") && value != null) {
                                                String m4804o = C2787z.m4804o(value.getProperty("Chinese"));
                                                String m4804o2 = C2787z.m4804o(value.getProperty("English"));
                                                String m4804o3 = C2787z.m4804o(value.getProperty("HKChinese"));
                                                String m4804o4 = C2787z.m4804o(value.getProperty("ChnAbbr"));
                                                String m4804o5 = C2787z.m4804o(value.getProperty("EngAbbr"));
                                                it = it2;
                                                String m4804o6 = C2787z.m4804o(value.getProperty("Area"));
                                                CarIcon carIcon4 = new CarIcon();
                                                carIcon4.f15778b = key;
                                                carIcon4.f15779c = m4804o2;
                                                if (equalsIgnoreCase) {
                                                    carIcon4.f15780d = m4804o;
                                                } else {
                                                    carIcon4.f15780d = m4804o3;
                                                }
                                                carIcon4.f15783g = m4804o5;
                                                carIcon4.f15784h = m4804o4;
                                                carIcon4.f15782f = m4804o6;
                                                carIcon4.f15790n = str;
                                                carIcon4.f15787k = Boolean.TRUE;
                                                carIcon4.f15785i = m4948g;
                                                carIcon4.f15786j = m4946h;
                                                carIcon4.f15788l = m4943i;
                                                carIcon4.m5037a(m4863a);
                                                StringBuilder sb = new StringBuilder();
                                                sb.append(key);
                                                z = equalsIgnoreCase;
                                                sb.append(".PNG");
                                                String sb2 = sb.toString();
                                                ArrayList arrayList6 = arrayList4;
                                                String str6 = m4952e(m4863a) + File.separator + sb2;
                                                carIcon4.f15781e = str6;
                                                QueryBuilder<CarIcon> queryBuilder2 = this.f15881t.queryBuilder();
                                                queryBuilder2.where(CarIconDao.Properties.SoftPackageId.m321eq(key), new WhereCondition[0]);
                                                List<CarIcon> list3 = queryBuilder2.list();
                                                if (list3 != null && !list3.isEmpty()) {
                                                    for (CarIcon carIcon5 : list3) {
                                                        carIcon5.f15790n = str;
                                                        carIcon5.f15787k = Boolean.TRUE;
                                                        carIcon5.f15785i = m4948g;
                                                        carIcon5.f15786j = m4946h;
                                                        carIcon5.f15788l = m4943i;
                                                        carIcon5.m5037a(m4863a);
                                                        carIcon5.f15779c = m4804o2;
                                                        carIcon5.f15780d = m4804o;
                                                        carIcon5.f15783g = m4804o5;
                                                        carIcon5.f15784h = m4804o4;
                                                        carIcon5.f15782f = m4804o6;
                                                        carIcon5.f15781e = str6;
                                                        arrayList5.add(carIcon5);
                                                    }
                                                    arrayList3 = arrayList6;
                                                }
                                                arrayList6.add(carIcon4);
                                                arrayList4 = arrayList6;
                                                it2 = it;
                                                equalsIgnoreCase = z;
                                            }
                                        } else {
                                            it = it2;
                                            z = equalsIgnoreCase;
                                            arrayList3 = arrayList4;
                                        }
                                        arrayList4 = arrayList3;
                                        it2 = it;
                                        equalsIgnoreCase = z;
                                    }
                                    arrayList2 = arrayList4;
                                } else {
                                    arrayList2 = arrayList4;
                                }
                            }
                            i5 = i2 + 1;
                            arrayList4 = arrayList2;
                            m4861b = str2;
                            list = strArr;
                            length = i;
                            carIconUtils2 = this;
                            i3 = 1;
                            i4 = 0;
                        } catch (Throwable th) {
                            th = th;
                            f15878r.unlock();
                            throw th;
                        }
                    }
                    arrayList = arrayList4;
                    if (arrayList5.isEmpty()) {
                        carIconUtils = this;
                    } else {
                        carIconUtils = this;
                        try {
                            carIconUtils.f15881t.updateInTx(arrayList5);
                            carIconUtils.m4961b(arrayList5);
                        } catch (Throwable th2) {
                            th = th2;
                            f15878r.unlock();
                            throw th;
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        carIconUtils.f15881t.insertInTx(arrayList);
                        carIconUtils.m4961b(arrayList);
                    }
                }
            } else {
                carIconUtils = carIconUtils2;
                arrayList = arrayList4;
            }
            carIconUtils.m4969a(str, f15862b, arrayList);
            carIconUtils.m4969a(str, f15863c, arrayList);
            carIconUtils.m4969a(str, f15864d, arrayList);
            carIconUtils.m4969a(str, f15865e, arrayList);
            carIconUtils.m4969a(str, f15868h, arrayList);
            carIconUtils.m4969a(str, f15866f, arrayList);
            f15878r.unlock();
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* renamed from: a */
    public final void m4971a(String str, String str2, String str3) {
        String str4;
        String str5;
        String str6;
        Iterator<Map.Entry<String, Properties>> it;
        boolean z;
        String str7;
        String str8;
        boolean z2;
        int i = 1;
        NLog.m9456a(f15861a, "serialNo=" + str + ",softPackageId=" + str2 + ",versionPath=" + str3);
        if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        File file = new File(str3);
        if (file.exists()) {
            if (m4944i(str3 + File.separator + "LICENSE.DAT")) {
                String absolutePath = file.getParentFile().getAbsolutePath();
                String m4946h = m4946h(absolutePath);
                if (TextUtils.isEmpty(m4946h)) {
                    return;
                }
                String name = file.getName();
                String m4950f = m4950f(str3);
                QueryBuilder<CarIcon> queryBuilder = this.f15881t.queryBuilder();
                String str9 = "";
                if (TextUtils.isEmpty(m4950f)) {
                    queryBuilder.where(CarIconDao.Properties.SoftPackageId.m321eq(str2), new WhereCondition[0]);
                } else {
                    queryBuilder.where(CarIconDao.Properties.SoftPackageId.m321eq(str2), CarIconDao.Properties.AreaId.m321eq(m4950f));
                    str9 = m4952e(absolutePath) + File.separator + "ICONCN.PNG";
                }
                List<CarIcon> list = queryBuilder.list();
                if (list != null && list.size() > 0) {
                    String m4948g = m4948g(absolutePath);
                    String m4943i = m4943i(absolutePath, m4946h);
                    CarIcon carIcon = null;
                    int i2 = 0;
                    boolean z3 = false;
                    while (true) {
                        if (i2 >= list.size()) {
                            str6 = name;
                            break;
                        }
                        CarIcon carIcon2 = list.get(i2);
                        String str10 = carIcon2.f15790n;
                        boolean z4 = z3;
                        CarIcon carIcon3 = carIcon;
                        Object[] objArr = new Object[i];
                        str6 = name;
                        objArr[0] = "itemSerialNo=".concat(String.valueOf(str10));
                        NLog.m9456a("yhx", objArr);
                        if (carIcon2.f15778b.equalsIgnoreCase("AUTOSEARCH") && !TextUtils.isEmpty(str10)) {
                            if (str.equals(str10)) {
                                carIcon2.f15790n = str;
                                carIcon2.f15787k = Boolean.TRUE;
                                carIcon2.f15785i = m4948g;
                                carIcon2.f15786j = m4946h;
                                carIcon2.f15788l = m4943i;
                                carIcon2.m5037a(absolutePath);
                                this.f15881t.update(carIcon2);
                                break;
                            }
                            carIcon = carIcon2;
                            z3 = true;
                        } else if (m4976a(carIcon2) && absolutePath.contains(str2)) {
                            NLog.m9456a("yhx", "deleteDirectory vehiclePath=".concat(String.valueOf(absolutePath)));
                            FileUtils.m4995g(absolutePath);
                            return;
                        } else {
                            carIcon2.f15790n = str;
                            carIcon2.f15787k = Boolean.TRUE;
                            carIcon2.f15785i = m4948g;
                            carIcon2.f15786j = m4946h;
                            carIcon2.f15788l = m4943i;
                            carIcon2.m5037a(absolutePath);
                            if (!TextUtils.isEmpty(str9)) {
                                carIcon2.f15781e = str9;
                            }
                            this.f15881t.update(carIcon2);
                            z3 = z4;
                            carIcon = carIcon3;
                        }
                        if (i2 == list.size() - 1 && z3) {
                            CarIcon carIcon4 = new CarIcon();
                            carIcon4.f15778b = str2;
                            carIcon4.f15781e = carIcon.f15781e;
                            carIcon4.f15779c = carIcon.f15779c;
                            carIcon4.f15780d = carIcon.f15780d;
                            carIcon4.f15784h = carIcon.f15784h;
                            carIcon4.f15783g = carIcon.f15783g;
                            carIcon4.f15782f = carIcon.f15782f;
                            carIcon4.f15787k = Boolean.TRUE;
                            carIcon4.f15790n = str;
                            carIcon4.f15787k = Boolean.TRUE;
                            carIcon4.f15785i = m4948g;
                            carIcon4.f15786j = m4946h;
                            carIcon4.f15788l = m4943i;
                            carIcon4.m5037a(absolutePath);
                            this.f15881t.insert(carIcon4);
                            NLog.m9456a("yhx", "insert carIcon carIcon =".concat(String.valueOf(carIcon4)));
                        }
                        i2++;
                        name = str6;
                        i = 1;
                    }
                    String str11 = absolutePath + File.separator + "ICON.INI";
                    File file2 = new File(str11);
                    C2744aa.m5135m();
                    if (file2.exists()) {
                        boolean equalsIgnoreCase = LangManager.m9466b().equalsIgnoreCase("CN");
                        Iterator<Map.Entry<String, Properties>> it2 = FileUtils.m4996f(str11).entrySet().iterator();
                        while (it2.hasNext()) {
                            Map.Entry<String, Properties> next = it2.next();
                            if (next != null) {
                                String key = next.getKey();
                                Properties value = next.getValue();
                                if (!TextUtils.isEmpty(key) && !key.equals("MAKE") && value != null) {
                                    QueryBuilder<CarIcon> queryBuilder2 = this.f15881t.queryBuilder();
                                    queryBuilder2.where(CarIconDao.Properties.SoftPackageId.m321eq(key), new WhereCondition[0]);
                                    List<CarIcon> list2 = queryBuilder2.list();
                                    String m4804o = C2787z.m4804o(value.getProperty("Chinese"));
                                    String m4804o2 = C2787z.m4804o(value.getProperty("English"));
                                    String m4804o3 = C2787z.m4804o(value.getProperty("HKChinese"));
                                    String m4804o4 = C2787z.m4804o(value.getProperty("ChnAbbr"));
                                    it = it2;
                                    String m4804o5 = C2787z.m4804o(value.getProperty("EngAbbr"));
                                    String m4804o6 = C2787z.m4804o(value.getProperty("Area"));
                                    if (list2 == null || list2.isEmpty()) {
                                        z = equalsIgnoreCase;
                                        str8 = m4804o3;
                                        z2 = true;
                                    } else {
                                        Iterator<CarIcon> it3 = list2.iterator();
                                        boolean z5 = true;
                                        while (it3.hasNext()) {
                                            Iterator<CarIcon> it4 = it3;
                                            CarIcon next2 = it3.next();
                                            boolean z6 = z5;
                                            String str12 = next2.f15789m;
                                            if (!TextUtils.isEmpty(str12) && str12.contains(key)) {
                                                FileUtils.m4995g(PathUtils.m4858c() + str12);
                                                this.f15881t.delete(next2);
                                                m4945h(next2.f15790n, next2.f15778b);
                                                z5 = z6;
                                                it3 = it4;
                                                m4804o3 = m4804o3;
                                                equalsIgnoreCase = equalsIgnoreCase;
                                            } else {
                                                boolean z7 = equalsIgnoreCase;
                                                next2.f15790n = str;
                                                next2.f15787k = Boolean.TRUE;
                                                next2.f15785i = m4948g;
                                                next2.f15786j = m4946h;
                                                next2.f15788l = m4943i;
                                                next2.m5037a(absolutePath);
                                                next2.f15782f = m4804o6;
                                                next2.f15779c = m4804o2;
                                                next2.f15780d = m4804o;
                                                next2.f15783g = m4804o5;
                                                next2.f15784h = m4804o4;
                                                String m4952e = m4952e(absolutePath);
                                                next2.f15781e = m4952e + File.separator + (key + ".PNG");
                                                this.f15881t.update(next2);
                                                it3 = it4;
                                                m4804o3 = m4804o3;
                                                equalsIgnoreCase = z7;
                                                z5 = false;
                                            }
                                        }
                                        z = equalsIgnoreCase;
                                        z2 = z5;
                                        str8 = m4804o3;
                                    }
                                    if (z2) {
                                        CarIcon carIcon5 = new CarIcon();
                                        carIcon5.f15778b = key;
                                        carIcon5.f15779c = m4804o2;
                                        if (z) {
                                            carIcon5.f15780d = m4804o;
                                        } else {
                                            carIcon5.f15780d = str8;
                                        }
                                        carIcon5.f15783g = m4804o5;
                                        carIcon5.f15784h = m4804o4;
                                        carIcon5.f15782f = m4804o6;
                                        carIcon5.f15790n = str;
                                        carIcon5.f15787k = Boolean.TRUE;
                                        carIcon5.f15785i = m4948g;
                                        carIcon5.f15786j = m4946h;
                                        carIcon5.f15788l = m4943i;
                                        carIcon5.m5037a(absolutePath);
                                        String m4952e2 = m4952e(absolutePath);
                                        carIcon5.f15781e = m4952e2 + File.separator + (key + ".PNG");
                                        this.f15881t.insert(carIcon5);
                                        str7 = str6;
                                    } else {
                                        str7 = str6;
                                    }
                                    m4962b(str, key, absolutePath, str7);
                                }
                            } else {
                                it = it2;
                                z = equalsIgnoreCase;
                                str7 = str6;
                            }
                            it2 = it;
                            str6 = str7;
                            equalsIgnoreCase = z;
                        }
                        str4 = str6;
                    } else {
                        str4 = str6;
                    }
                    str5 = str2;
                } else {
                    str4 = name;
                    CarIcon carIcon6 = new CarIcon();
                    carIcon6.f15790n = str;
                    carIcon6.f15782f = m4950f;
                    carIcon6.f15787k = Boolean.TRUE;
                    str5 = str2;
                    carIcon6.f15778b = str5;
                    carIcon6.f15781e = "";
                    String m4948g2 = m4948g(absolutePath);
                    String m4943i2 = m4943i(absolutePath, m4946h);
                    carIcon6.f15785i = m4948g2;
                    carIcon6.f15786j = m4946h;
                    carIcon6.f15788l = m4943i2;
                    carIcon6.m5037a(absolutePath);
                    Map<String, Properties> m4996f = FileUtils.m4996f(absolutePath + File.separator + "VEHICLE.INI");
                    String m5008a = FileUtils.m5008a(m4996f, "Name", "English");
                    String m5008a2 = FileUtils.m5008a(m4996f, "Name", "Chinese");
                    String m5008a3 = FileUtils.m5008a(m4996f, "AbbrName", "English");
                    String m5008a4 = FileUtils.m5008a(m4996f, "AbbrName", "Chinese");
                    carIcon6.f15779c = m5008a;
                    carIcon6.f15780d = m5008a2;
                    carIcon6.f15783g = m5008a3;
                    carIcon6.f15784h = m5008a4;
                    carIcon6.f15781e = m4952e(absolutePath) + File.separator + "ICONCN.PNG";
                    this.f15881t.insert(carIcon6);
                }
                m4962b(str, str5, absolutePath, str4);
            }
        }
    }

    /* renamed from: e */
    private static String m4952e(String str) {
        return (TextUtils.isEmpty(str) || !str.contains(PathUtils.m4858c())) ? "" : str.replace(PathUtils.m4858c(), "");
    }

    /* renamed from: a */
    public final void m4970a(String str, String str2, String str3, String str4) {
        boolean z;
        String str5 = f15861a;
        NLog.m9456a(str5, "deleteOrUpdateTheCar serialNo=" + str + ",softPackageId=" + str2 + ",theCarVersionPath=" + str3 + ",versionNo=" + str4);
        if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str4)) {
            return;
        }
        String str6 = null;
        File parentFile = new File(str3).getParentFile();
        String absolutePath = parentFile.getAbsolutePath();
        if (parentFile.exists()) {
            str6 = m4946h(absolutePath);
            z = TextUtils.isEmpty(str6);
        } else {
            z = true;
        }
        QueryBuilder<CarIcon> queryBuilder = this.f15881t.queryBuilder();
        queryBuilder.where(CarIconDao.Properties.SoftPackageId.m321eq(str2), CarIconDao.Properties.SerialNo.m321eq(str), CarIconDao.Properties.IsDownload.m321eq(Boolean.TRUE));
        List<CarIcon> list = queryBuilder.list();
        if (list != null && list.size() > 0) {
            if (z) {
                for (CarIcon carIcon : list) {
                    carIcon.f15787k = Boolean.FALSE;
                    carIcon.f15785i = "";
                    carIcon.f15786j = "";
                    carIcon.f15788l = "";
                    carIcon.m5037a("");
                    carIcon.f15790n = "";
                    this.f15881t.update(carIcon);
                    NLog.m9456a(f15861a, "update carIcon item =".concat(String.valueOf(carIcon)));
                    if (PreferencesManager.m9595a(this.f15880s).m9583b("is_enable_favorites", false)) {
                        try {
                            FavoritesCarIconDao favoritesCarIconDao = FavoritesDBManager.m5033a(this.f15880s).f15810a.f15814a;
                            QueryBuilder<CarIcon> queryBuilder2 = favoritesCarIconDao.queryBuilder();
                            queryBuilder2.where(FavoritesCarIconDao.Properties.SoftPackageId.m321eq(str2), FavoritesCarIconDao.Properties.SerialNo.m321eq(str), FavoritesCarIconDao.Properties.IsDownload.m321eq(Boolean.TRUE));
                            List<CarIcon> list2 = queryBuilder2.list();
                            NLog.m9456a(f15861a, "favoriteList =".concat(String.valueOf(list2)));
                            if (list2 != null && !list2.isEmpty()) {
                                favoritesCarIconDao.deleteInTx(list2);
                            }
                        } catch (Exception e) {
                            NLog.m9456a(f15861a, e);
                        }
                    }
                }
            } else {
                for (CarIcon carIcon2 : list) {
                    carIcon2.f15790n = str;
                    carIcon2.f15787k = Boolean.TRUE;
                    carIcon2.f15785i = m4948g(absolutePath);
                    carIcon2.f15786j = str6;
                    carIcon2.f15788l = m4943i(absolutePath, str6);
                    carIcon2.m5037a(absolutePath);
                    this.f15881t.update(carIcon2);
                    NLog.m9456a(f15861a, "update carIcon item =".concat(String.valueOf(carIcon2)));
                }
            }
        }
        if (z) {
            m4945h(str, str2);
        } else {
            m4956c(str, str2, str4);
        }
    }

    /* renamed from: h */
    private void m4945h(String str, String str2) {
        NLog.m9456a(f15861a, "removeTheCarAllVersion enter.");
        QueryBuilder<CarVersion> queryBuilder = this.f15884w.queryBuilder();
        queryBuilder.where(CarVersionDao.Properties.SerialNo.m321eq(str), CarVersionDao.Properties.SoftPackageId.m321eq(str2));
        List<CarVersion> list = queryBuilder.list();
        NLog.m9456a(f15861a, "result=".concat(String.valueOf(list)));
        if (list == null || list.isEmpty()) {
            return;
        }
        this.f15884w.deleteInTx(list);
    }

    /* renamed from: f */
    private static String m4950f(String str) {
        String[] split;
        if (TextUtils.isEmpty(str) || (split = str.split(File.separator)) == null || split.length == 0) {
            return "";
        }
        for (String str2 : split) {
            if (f15862b.equals(str2) || f15863c.equals(str2) || f15864d.equals(str2) || f15865e.equals(str2) || f15868h.equals(str2) || f15866f.equals(str2)) {
                return str2;
            }
        }
        return "";
    }

    /* renamed from: b */
    private void m4961b(List<CarIcon> list) {
        if (list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<CarIcon> it = list.iterator();
        while (true) {
            char c = 1;
            if (!it.hasNext()) {
                break;
            }
            CarIcon next = it.next();
            String str = next.f15790n;
            String str2 = next.f15778b;
            String str3 = next.f15789m;
            String[] m4942j = m4942j(next.f15786j);
            if (m4942j != null && m4942j.length > 0) {
                int length = m4942j.length;
                int i = 0;
                while (i < length) {
                    String str4 = m4942j[i];
                    String[] strArr = new String[3];
                    strArr[0] = PathUtils.m4858c();
                    strArr[c] = str3;
                    strArr[2] = str4;
                    String m4941k = m4941k(PathUtils.m4863a(strArr));
                    QueryBuilder<CarVersion> queryBuilder = this.f15884w.queryBuilder();
                    Iterator<CarIcon> it2 = it;
                    queryBuilder.where(CarVersionDao.Properties.SerialNo.m321eq(str), CarVersionDao.Properties.SoftPackageId.m321eq(str2), CarVersionDao.Properties.VersionNo.m321eq(str4));
                    List<CarVersion> list2 = queryBuilder.list();
                    if (list2 == null || list2.isEmpty()) {
                        CarVersion carVersion = new CarVersion();
                        carVersion.f15826b = str;
                        carVersion.f15827c = str2;
                        carVersion.f15828d = str4;
                        carVersion.f15830f = m4941k;
                        carVersion.f15829e = Boolean.TRUE;
                        arrayList.add(carVersion);
                    } else {
                        CarVersion carVersion2 = list2.get(0);
                        carVersion2.f15830f = m4941k;
                        carVersion2.f15829e = Boolean.TRUE;
                        arrayList2.add(carVersion2);
                    }
                    i++;
                    it = it2;
                    c = 1;
                }
            }
            it = it;
        }
        if (!arrayList.isEmpty()) {
            HashSet hashSet = new HashSet();
            hashSet.addAll(arrayList);
            NLog.m9456a(f15861a, "insertSet=".concat(String.valueOf(hashSet)));
            this.f15884w.insertInTx(hashSet);
        }
        if (arrayList2.isEmpty()) {
            return;
        }
        HashSet hashSet2 = new HashSet();
        hashSet2.addAll(arrayList2);
        NLog.m9456a(f15861a, "updateSet=".concat(String.valueOf(hashSet2)));
        this.f15884w.updateInTx(hashSet2);
    }

    /* renamed from: c */
    private void m4960c() {
        List<CarIcon> loadAll = this.f15881t.loadAll();
        if (loadAll != null && loadAll.size() > 0) {
            for (CarIcon carIcon : loadAll) {
                carIcon.f15787k = Boolean.FALSE;
            }
            this.f15881t.updateInTx(loadAll);
        }
        List<CarVersion> loadAll2 = this.f15884w.loadAll();
        if (loadAll2 == null || loadAll2.isEmpty()) {
            return;
        }
        for (CarVersion carVersion : loadAll2) {
            carVersion.f15829e = Boolean.FALSE;
        }
        this.f15884w.updateInTx(loadAll2);
    }

    /* renamed from: b */
    private void m4962b(String str, String str2, String str3, String str4) {
        String[] m4942j;
        if (TextUtils.isEmpty(str4) || (m4942j = m4942j(str4)) == null || m4942j.length <= 0) {
            return;
        }
        for (String str5 : m4942j) {
            String m4941k = m4941k(str3 + File.separator + str5);
            QueryBuilder<CarVersion> queryBuilder = this.f15884w.queryBuilder();
            queryBuilder.where(CarVersionDao.Properties.SerialNo.m321eq(str), CarVersionDao.Properties.SoftPackageId.m321eq(str2), CarVersionDao.Properties.VersionNo.m321eq(str5));
            List<CarVersion> list = queryBuilder.list();
            if (list == null || list.isEmpty()) {
                CarVersion carVersion = new CarVersion();
                carVersion.f15826b = str;
                carVersion.f15827c = str2;
                carVersion.f15828d = str5;
                carVersion.f15830f = m4941k;
                carVersion.f15829e = Boolean.TRUE;
                this.f15884w.insert(carVersion);
            } else {
                CarVersion carVersion2 = list.get(0);
                carVersion2.f15830f = m4941k;
                carVersion2.f15829e = Boolean.TRUE;
                this.f15884w.update(carVersion2);
            }
        }
    }

    /* renamed from: a */
    private void m4969a(String str, String str2, List<CarIcon> list) {
        String[] list2;
        boolean z;
        String str3;
        String[] strArr;
        int i;
        String str4 = PathUtils.m4861b(this.f15880s, str) + File.separator + str2;
        try {
            File file = new File(str4);
            if (!file.exists() || (list2 = file.list()) == null || list2.length <= 0) {
                return;
            }
            int length = list2.length;
            char c = 0;
            int i2 = 0;
            while (i2 < length) {
                String str5 = list2[i2];
                String[] strArr2 = new String[2];
                strArr2[c] = str4;
                strArr2[1] = str5;
                String m4863a = PathUtils.m4863a(strArr2);
                if (!list.isEmpty()) {
                    for (CarIcon carIcon : list) {
                        if (carIcon != null && str5.equals(carIcon.f15778b)) {
                            FileUtils.m4995g(m4863a);
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
                if (z) {
                    str3 = str4;
                    strArr = list2;
                    i = length;
                } else {
                    String m4946h = m4946h(m4863a);
                    if (TextUtils.isEmpty(m4946h)) {
                        str3 = str4;
                        strArr = list2;
                        i = length;
                    } else {
                        CarIcon carIcon2 = new CarIcon();
                        carIcon2.f15790n = str;
                        carIcon2.f15782f = str2;
                        carIcon2.f15787k = Boolean.TRUE;
                        carIcon2.f15778b = str5;
                        carIcon2.f15781e = "";
                        String m4948g = m4948g(m4863a);
                        String m4943i = m4943i(m4863a, m4946h);
                        carIcon2.f15785i = m4948g;
                        carIcon2.f15786j = m4946h;
                        carIcon2.f15788l = m4943i;
                        carIcon2.m5037a(m4863a);
                        Map<String, Properties> m4996f = FileUtils.m4996f(m4863a + File.separator + "VEHICLE.INI");
                        String m5008a = FileUtils.m5008a(m4996f, "Name", "English");
                        str3 = str4;
                        String m5008a2 = FileUtils.m5008a(m4996f, "Name", "Chinese");
                        strArr = list2;
                        String m5008a3 = FileUtils.m5008a(m4996f, "AbbrName", "English");
                        i = length;
                        String m5008a4 = FileUtils.m5008a(m4996f, "AbbrName", "Chinese");
                        carIcon2.f15779c = m5008a;
                        carIcon2.f15780d = m5008a2;
                        carIcon2.f15783g = m5008a3;
                        carIcon2.f15784h = m5008a4;
                        String str6 = m4952e(m4863a) + File.separator + "ICONCN.PNG";
                        NLog.m9456a(f15861a, "iconPath=".concat(String.valueOf(str6)));
                        carIcon2.f15781e = str6;
                        QueryBuilder<CarIcon> queryBuilder = this.f15881t.queryBuilder();
                        queryBuilder.where(CarIconDao.Properties.SoftPackageId.m321eq(str5), CarIconDao.Properties.AreaId.m321eq(str2));
                        CarIcon unique = queryBuilder.unique();
                        if (unique == null) {
                            this.f15881t.insert(carIcon2);
                        } else {
                            unique.f15790n = str;
                            unique.f15787k = Boolean.TRUE;
                            unique.f15785i = m4948g;
                            unique.f15786j = m4946h;
                            unique.f15788l = m4943i;
                            unique.m5037a(m4863a);
                            unique.f15781e = str6;
                            this.f15881t.update(unique);
                        }
                        m4962b(str, str5, m4863a, m4946h);
                    }
                }
                i2++;
                str4 = str3;
                list2 = strArr;
                length = i;
                c = 0;
            }
        } catch (Exception e) {
            NLog.m9455a(e);
        }
    }

    /* renamed from: b */
    public final String m4963b(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        String str4 = "%" + C2744aa.m5131o() + "%";
        if (!str3.isEmpty()) {
            str4 = "%" + str3 + "%";
        }
        f15878r.lock();
        try {
            QueryBuilder<CarVersion> queryBuilder = this.f15884w.queryBuilder();
            queryBuilder.where(CarVersionDao.Properties.SerialNo.m321eq(str), CarVersionDao.Properties.SoftPackageId.m321eq(str2), CarVersionDao.Properties.IsExist.m321eq(Boolean.TRUE), CarVersionDao.Properties.Languagelist.like(str4));
            List<CarVersion> list = queryBuilder.list();
            if (list == null || list.isEmpty()) {
                return "";
            }
            Collections.sort(list, new C2768e(this));
            return list.get(0).f15828d;
        } finally {
            f15878r.unlock();
        }
    }

    /* renamed from: b */
    public final String m4964b(String str, String str2) {
        CarIcon carIcon;
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        QueryBuilder<CarIcon> queryBuilder = this.f15881t.queryBuilder();
        queryBuilder.where(CarIconDao.Properties.SoftPackageId.m321eq(str2), CarIconDao.Properties.SerialNo.m321eq(str), CarIconDao.Properties.IsDownload.m321eq(Boolean.TRUE));
        List<CarIcon> list = queryBuilder.list();
        return (list == null || list.size() <= 0 || (carIcon = list.get(0)) == null) ? "" : carIcon.f15789m;
    }

    /* renamed from: g */
    private static String m4948g(String str) {
        File[] listFiles;
        String str2 = "";
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (file.exists()) {
                for (File file2 : file.listFiles()) {
                    String name = file2.getName();
                    if (file2.isDirectory() && name.startsWith("V") && name.compareToIgnoreCase(str2) > 0) {
                        str2 = name;
                    }
                }
            }
        }
        return str2;
    }

    /* renamed from: h */
    private static String m4946h(String str) {
        File[] listFiles;
        StringBuilder sb = new StringBuilder();
        try {
            if (!TextUtils.isEmpty(str)) {
                File file = new File(str);
                if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
                    for (File file2 : listFiles) {
                        String name = file2.getName();
                        if (file2.isDirectory() && name.startsWith("V")) {
                            String str2 = file2.getAbsolutePath() + File.separator + "LICENSE.DAT";
                            NLog.m9456a(f15861a, "licenseFilePath=".concat(String.valueOf(str2)));
                            if (m4944i(str2)) {
                                sb.append(name);
                                sb.append("#");
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String sb2 = sb.toString();
        return sb2.indexOf("#") >= 0 ? sb2.substring(0, sb.length() - 1) : sb2;
    }

    /* renamed from: i */
    private static boolean m4944i(String str) {
        File file = new File(str);
        boolean z = file.exists() && file.length() > 0;
        NLog.m9456a(f15861a, "isLicenseNormal.result=".concat(String.valueOf(z)));
        return z;
    }

    /* renamed from: j */
    private static String[] m4942j(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str.split("#");
    }

    /* renamed from: i */
    private static String m4943i(String str, String str2) {
        String[] split;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str2)) {
            for (String str3 : str2.split("#")) {
                String m4941k = m4941k(str + File.separator + str3);
                if (!TextUtils.isEmpty(m4941k)) {
                    sb.append(m4941k);
                    sb.append("$");
                }
            }
        }
        String sb2 = sb.toString();
        if (sb2.indexOf("$") >= 0) {
            sb2 = sb2.substring(0, sb.length() - 1);
        }
        NLog.m9456a(f15861a, "getAllLanguageListOfTheCar exit, result=".concat(String.valueOf(sb2)));
        return sb2;
    }

    /* renamed from: k */
    private static String m4941k(String str) {
        File[] listFiles;
        StringBuilder sb = new StringBuilder();
        try {
            if (!TextUtils.isEmpty(str)) {
                File file = new File(str);
                if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
                    for (File file2 : listFiles) {
                        String name = file2.getName();
                        if (name.startsWith("INI_")) {
                            sb.append(name.split("_")[1]);
                            sb.append("#");
                        }
                    }
                }
            }
        } catch (Exception e) {
            NLog.m9454a(e, f15861a, e.getMessage());
        }
        String sb2 = sb.toString();
        return sb2.indexOf("#") >= 0 ? sb2.substring(0, sb.length() - 1) : sb2;
    }

    /* renamed from: c */
    public final List<CarIcon> m4957c(String str, String str2) {
        if (f15868h.equals(str)) {
            CarIcon unique = this.f15881t.queryBuilder().where(CarIconDao.Properties.Sname.m321eq("DEMO"), CarIconDao.Properties.AreaId.m321eq(str), CarIconDao.Properties.SerialNo.m321eq(str2)).build().unique();
            CarIcon unique2 = this.f15881t.queryBuilder().where(CarIconDao.Properties.Sname.m321eq("HD_OBD"), CarIconDao.Properties.AreaId.m321eq(str), CarIconDao.Properties.SerialNo.m321eq(str2)).build().unique();
            if (unique != null) {
                unique.f15783g = "A09";
                unique.f15784h = "09";
                this.f15881t.update(unique);
            }
            if (unique2 != null) {
                unique2.f15783g = "A10";
                unique2.f15784h = DiagnoseConstants.DATA_TYPE_FROM_APK_TO_SO_SET_MENUPATH;
                this.f15881t.update(unique2);
            }
        }
        QueryBuilder<CarIcon> queryBuilder = this.f15881t.queryBuilder();
        String m5131o = C2744aa.m5131o();
        String str3 = "%" + m5131o + "%";
        if (m5131o.equals("CN")) {
            queryBuilder.where(CarIconDao.Properties.AreaId.m321eq(str), CarIconDao.Properties.IsDownload.m321eq(Boolean.TRUE), CarIconDao.Properties.Languagelist.like(str3), CarIconDao.Properties.SerialNo.m321eq(str2), CarIconDao.Properties.SoftPackageId.notEq("AUTOSEARCH"));
            queryBuilder.orderAsc(CarIconDao.Properties.Sname_zh);
            return queryBuilder.list();
        } else if (m5131o.equals("EN")) {
            queryBuilder.where(CarIconDao.Properties.AreaId.m321eq(str), CarIconDao.Properties.IsDownload.m321eq(Boolean.TRUE), CarIconDao.Properties.Languagelist.like(str3), CarIconDao.Properties.SerialNo.m321eq(str2), CarIconDao.Properties.SoftPackageId.notEq("AUTOSEARCH"));
            queryBuilder.orderAsc(CarIconDao.Properties.Sname);
            return queryBuilder.list();
        } else {
            queryBuilder.where(CarIconDao.Properties.AreaId.m321eq(str), CarIconDao.Properties.IsDownload.m321eq(Boolean.TRUE), CarIconDao.Properties.Languagelist.like(str3), CarIconDao.Properties.SerialNo.m321eq(str2), CarIconDao.Properties.SoftPackageId.notEq("AUTOSEARCH"));
            queryBuilder.orderAsc(CarIconDao.Properties.Sname);
            List<CarIcon> list = queryBuilder.list();
            QueryBuilder<CarIcon> queryBuilder2 = this.f15881t.queryBuilder();
            queryBuilder2.where(CarIconDao.Properties.AreaId.m321eq(str), CarIconDao.Properties.IsDownload.m321eq(Boolean.TRUE), CarIconDao.Properties.Languagelist.like("%EN%"), CarIconDao.Properties.SerialNo.m321eq(str2), CarIconDao.Properties.SoftPackageId.notEq("AUTOSEARCH"));
            queryBuilder2.orderAsc(CarIconDao.Properties.Sname);
            List<CarIcon> list2 = queryBuilder2.list();
            if (list == null || list.isEmpty()) {
                return list2;
            }
            if (list2 != null && !list2.isEmpty()) {
                for (CarIcon carIcon : list2) {
                    if (!list.contains(carIcon)) {
                        list.add(carIcon);
                    }
                }
                Collections.sort(list, new C2769f(this));
            }
            return list;
        }
    }

    /* renamed from: b */
    public final List<CarIcon> m4965b(String str) {
        List<CarIcon> list;
        boolean z;
        ArrayList<CarIcon> arrayList = new ArrayList();
        QueryBuilder<CarIcon> queryBuilder = this.f15881t.queryBuilder();
        String m5131o = C2744aa.m5131o();
        String str2 = "%" + m5131o + "%";
        Object[] objArr = {"ASIA", "CHINA", "EUROPE", "USA", "COMMON", "HEAVYDUTY"};
        if (!C2744aa.m5143i()) {
            objArr = new Object[]{"ASIA", "EUROPE", "USA", "COMMON", "HEAVYDUTY"};
        }
        if (m5131o.equals("CN")) {
            queryBuilder.where(CarIconDao.Properties.IsDownload.m321eq(Boolean.TRUE), CarIconDao.Properties.Languagelist.like(str2), CarIconDao.Properties.SerialNo.m321eq(str), CarIconDao.Properties.AreaId.m317in(objArr));
            queryBuilder.orderAsc(CarIconDao.Properties.Sname_zh);
            list = queryBuilder.list();
        } else if (m5131o.equals("EN")) {
            queryBuilder.where(CarIconDao.Properties.IsDownload.m321eq(Boolean.TRUE), CarIconDao.Properties.Languagelist.like(str2), CarIconDao.Properties.SerialNo.m321eq(str), CarIconDao.Properties.AreaId.m317in(objArr));
            queryBuilder.orderAsc(CarIconDao.Properties.Sname);
            list = queryBuilder.list();
        } else {
            queryBuilder.where(CarIconDao.Properties.IsDownload.m321eq(Boolean.TRUE), CarIconDao.Properties.Languagelist.like(str2), CarIconDao.Properties.SerialNo.m321eq(str), CarIconDao.Properties.AreaId.m317in(objArr));
            queryBuilder.orderAsc(CarIconDao.Properties.Sname);
            List<CarIcon> list2 = queryBuilder.list();
            QueryBuilder<CarIcon> queryBuilder2 = this.f15881t.queryBuilder();
            queryBuilder2.where(CarIconDao.Properties.IsDownload.m321eq(Boolean.TRUE), CarIconDao.Properties.Languagelist.like("%EN%"), CarIconDao.Properties.SerialNo.m321eq(str), CarIconDao.Properties.AreaId.m317in(objArr));
            queryBuilder2.orderAsc(CarIconDao.Properties.Sname);
            list = queryBuilder2.list();
            if (list2 != null && !list2.isEmpty()) {
                if (list != null && !list.isEmpty()) {
                    for (CarIcon carIcon : list) {
                        if (!list2.contains(carIcon)) {
                            list2.add(carIcon);
                        }
                    }
                    Collections.sort(list2, new C2770g(this));
                }
                list = list2;
            }
        }
        if (list != null && !list.isEmpty()) {
            for (CarIcon carIcon2 : list) {
                if (!carIcon2.f15778b.equalsIgnoreCase("AUTOSEARCH")) {
                    if (!arrayList.isEmpty()) {
                        for (CarIcon carIcon3 : arrayList) {
                            if (carIcon2.f15778b.equals(carIcon3.f15778b)) {
                                z = true;
                                break;
                            }
                        }
                    }
                    z = false;
                    if (!z) {
                        arrayList.add(carIcon2);
                    }
                }
            }
        }
        NLog.m9456a(f15861a, "queryList.size=" + list.size() + ",result.size=" + arrayList.size());
        return arrayList;
    }

    /* renamed from: d */
    public final List<CarVersion> m4954d(String str, String str2) {
        List<CarVersion> list;
        NLog.m9456a(f15861a, "getMatchedVersionListByLanguage enter,serialNo=" + str + ",softPackageId=" + str2);
        HashSet hashSet = new HashSet();
        QueryBuilder<CarVersion> queryBuilder = this.f15884w.queryBuilder();
        String m5131o = C2744aa.m5131o();
        String str3 = "%" + m5131o + "%";
        NLog.m9456a(f15861a, "languageCondition=".concat(String.valueOf(str3)));
        if (m5131o.equals("CN")) {
            queryBuilder.where(CarVersionDao.Properties.SerialNo.m321eq(str), CarVersionDao.Properties.SoftPackageId.m321eq(str2), CarVersionDao.Properties.Languagelist.like(str3), CarVersionDao.Properties.IsExist.m321eq(Boolean.TRUE));
            list = queryBuilder.list();
        } else if (m5131o.equals("EN")) {
            queryBuilder.where(CarVersionDao.Properties.SerialNo.m321eq(str), CarVersionDao.Properties.SoftPackageId.m321eq(str2), CarVersionDao.Properties.IsExist.m321eq(Boolean.TRUE), CarVersionDao.Properties.Languagelist.like(str3));
            list = queryBuilder.list();
        } else {
            queryBuilder.where(CarVersionDao.Properties.SerialNo.m321eq(str), CarVersionDao.Properties.SoftPackageId.m321eq(str2), CarVersionDao.Properties.IsExist.m321eq(Boolean.TRUE), CarVersionDao.Properties.Languagelist.like(str3));
            List<CarVersion> list2 = queryBuilder.list();
            if (list2 == null || list2.isEmpty()) {
                QueryBuilder<CarVersion> queryBuilder2 = this.f15884w.queryBuilder();
                queryBuilder2.where(CarVersionDao.Properties.SerialNo.m321eq(str), CarVersionDao.Properties.SoftPackageId.m321eq(str2), CarVersionDao.Properties.IsExist.m321eq(Boolean.TRUE), CarVersionDao.Properties.Languagelist.like("%EN%"));
                list = queryBuilder2.list();
            } else {
                list = list2;
            }
        }
        if (list != null && !list.isEmpty()) {
            for (CarVersion carVersion : list) {
                hashSet.add(carVersion.f15828d);
            }
        }
        NLog.m9456a(f15861a, "getMatchedVersionListByLanguage exit,matchedVersionList=".concat(String.valueOf(hashSet)));
        return list;
    }

    /* compiled from: CarIconUtils.java */
    /* renamed from: com.cnlaunch.x431pro.utils.f.c$a */
    /* loaded from: classes.dex */
    public class C2766a implements Comparator<CarVersionInfo> {
        public C2766a() {
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(CarVersionInfo carVersionInfo, CarVersionInfo carVersionInfo2) {
            return Double.parseDouble(carVersionInfo2.getVersion().replace("V", "")) > Double.parseDouble(carVersionInfo.getVersion().replace("V", "")) ? 1 : -1;
        }
    }

    /* renamed from: a */
    public static ArrayList<CarVersionInfo> m4968a(List<CarVersion> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList<CarVersionInfo> arrayList = new ArrayList<>();
        for (CarVersion carVersion : list) {
            if (!C2787z.m4821a(carVersion.f15827c)) {
                CarVersionInfo carVersionInfo = new CarVersionInfo();
                carVersionInfo.setVersion(carVersion.f15828d);
                carVersionInfo.setLanguage(carVersion.f15830f);
                arrayList.add(carVersionInfo);
            }
        }
        return arrayList;
    }

    /* renamed from: c */
    public final void m4956c(String str, String str2, String str3) {
        QueryBuilder<CarVersion> queryBuilder = this.f15884w.queryBuilder();
        queryBuilder.where(CarVersionDao.Properties.SerialNo.m321eq(str), CarVersionDao.Properties.SoftPackageId.m321eq(str2), CarVersionDao.Properties.VersionNo.m321eq(str3));
        List<CarVersion> list = queryBuilder.list();
        NLog.m9456a(f15861a, "result=".concat(String.valueOf(list)));
        if (list == null || list.isEmpty()) {
            return;
        }
        this.f15884w.deleteInTx(list);
    }

    /* renamed from: e */
    public final CarIcon m4951e(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        QueryBuilder<CarIcon> queryBuilder = this.f15881t.queryBuilder();
        queryBuilder.where(CarIconDao.Properties.SoftPackageId.m321eq(str2), CarIconDao.Properties.SerialNo.m321eq(str));
        List<CarIcon> list = queryBuilder.list();
        if (list == null || list.size() <= 0) {
            return null;
        }
        return list.get(0);
    }

    /* renamed from: c */
    public final List<CarIcon> m4958c(String str) {
        FavoritesCarIconDao favoritesCarIconDao;
        List<CarIcon> list;
        boolean z;
        ArrayList<CarIcon> arrayList = new ArrayList();
        try {
            favoritesCarIconDao = FavoritesDBManager.m5033a(this.f15880s).f15810a.f15814a;
        } catch (SQLiteCantOpenDatabaseException e) {
            NLog.m9456a(f15861a, e);
            favoritesCarIconDao = null;
        }
        if (favoritesCarIconDao == null) {
            return arrayList;
        }
        QueryBuilder<CarIcon> queryBuilder = favoritesCarIconDao.queryBuilder();
        String upperCase = LangManager.m9466b().toUpperCase();
        String str2 = "%" + AndroidToLan.toLan(upperCase) + "%";
        if (upperCase.equals("CN")) {
            queryBuilder.where(FavoritesCarIconDao.Properties.IsDownload.m321eq(Boolean.TRUE), FavoritesCarIconDao.Properties.Languagelist.like(str2), FavoritesCarIconDao.Properties.SerialNo.m321eq(str), FavoritesCarIconDao.Properties.isFavorites.m321eq(Boolean.TRUE));
            queryBuilder.orderAsc(FavoritesCarIconDao.Properties.Sname_zh);
            list = queryBuilder.list();
        } else if (upperCase.equals("EN")) {
            queryBuilder.where(FavoritesCarIconDao.Properties.IsDownload.m321eq(Boolean.TRUE), FavoritesCarIconDao.Properties.Languagelist.like(str2), FavoritesCarIconDao.Properties.SerialNo.m321eq(str), FavoritesCarIconDao.Properties.isFavorites.m321eq(Boolean.TRUE));
            queryBuilder.orderAsc(FavoritesCarIconDao.Properties.Sname);
            list = queryBuilder.list();
        } else {
            queryBuilder.where(FavoritesCarIconDao.Properties.IsDownload.m321eq(Boolean.TRUE), FavoritesCarIconDao.Properties.Languagelist.like(str2), FavoritesCarIconDao.Properties.SerialNo.m321eq(str), FavoritesCarIconDao.Properties.isFavorites.m321eq(Boolean.TRUE));
            queryBuilder.orderAsc(FavoritesCarIconDao.Properties.Sname);
            List<CarIcon> list2 = queryBuilder.list();
            QueryBuilder<CarIcon> queryBuilder2 = favoritesCarIconDao.queryBuilder();
            queryBuilder2.where(FavoritesCarIconDao.Properties.IsDownload.m321eq(Boolean.TRUE), FavoritesCarIconDao.Properties.Languagelist.like("%EN%"), FavoritesCarIconDao.Properties.SerialNo.m321eq(str), FavoritesCarIconDao.Properties.isFavorites.m321eq(Boolean.TRUE));
            queryBuilder2.orderAsc(FavoritesCarIconDao.Properties.Sname);
            list = queryBuilder2.list();
            if (list2 != null && !list2.isEmpty()) {
                if (list != null && !list.isEmpty()) {
                    for (CarIcon carIcon : list) {
                        if (!list2.contains(carIcon)) {
                            list2.add(carIcon);
                        }
                    }
                    Collections.sort(list2, new C2771h(this));
                }
                list = list2;
            }
        }
        if (list != null && !list.isEmpty()) {
            for (CarIcon carIcon2 : list) {
                if (!arrayList.isEmpty()) {
                    for (CarIcon carIcon3 : arrayList) {
                        if (carIcon2.f15778b.equals(carIcon3.f15778b)) {
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
                if (!z) {
                    arrayList.add(carIcon2);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: f */
    public final void m4949f(String str, String str2) {
        String str3 = f15861a;
        NLog.m9456a(str3, "removeTheCar softPackageId=" + str2 + ",serialNo=" + str);
        QueryBuilder<CarIcon> queryBuilder = this.f15881t.queryBuilder();
        queryBuilder.where(CarIconDao.Properties.SoftPackageId.m321eq(str2), CarIconDao.Properties.SerialNo.m321eq(str), CarIconDao.Properties.IsDownload.m321eq(Boolean.TRUE));
        List<CarIcon> list = queryBuilder.list();
        if (list != null && list.size() > 0) {
            for (CarIcon carIcon : list) {
                carIcon.f15787k = Boolean.FALSE;
                carIcon.f15785i = "";
                carIcon.f15786j = "";
                carIcon.f15788l = "";
                carIcon.m5037a("");
                carIcon.f15790n = "";
                this.f15881t.update(carIcon);
                NLog.m9456a(f15861a, "update carIcon item =".concat(String.valueOf(carIcon)));
            }
        }
        m4945h(str, str2);
    }

    /* renamed from: g */
    public final void m4947g(String str, String str2) {
        File[] listFiles;
        NLog.m9456a("yhx", "deleteAllChildVehicle enter,softPath=".concat(String.valueOf(str)));
        if (TextUtils.isEmpty(str)) {
            return;
        }
        File file = new File(str);
        if (file.exists()) {
            for (File file2 : file.listFiles()) {
                if (file2.isFile() && file2.getName().equalsIgnoreCase("ICON.INI")) {
                    Map<String, Properties> m4996f = FileUtils.m4996f(file2.getAbsolutePath());
                    NLog.m9456a("yhx", "sections=".concat(String.valueOf(m4996f)));
                    for (Map.Entry<String, Properties> entry : m4996f.entrySet()) {
                        if (entry != null) {
                            String key = entry.getKey();
                            Properties value = entry.getValue();
                            if (!TextUtils.isEmpty(key) && !key.equals("MAKE") && value != null) {
                                QueryBuilder<CarIcon> queryBuilder = this.f15881t.queryBuilder();
                                if (TextUtils.isEmpty(str2)) {
                                    queryBuilder.where(CarIconDao.Properties.SoftPackageId.m321eq(key), new WhereCondition[0]);
                                } else {
                                    queryBuilder.where(CarIconDao.Properties.SoftPackageId.m321eq(key), CarIconDao.Properties.SerialNo.m321eq(str2));
                                }
                                List<CarIcon> list = queryBuilder.list();
                                NLog.m9456a("yhx", "deleteAllChildVehicle enter,queryChildList=".concat(String.valueOf(list)));
                                if (list != null && !list.isEmpty()) {
                                    for (CarIcon carIcon : list) {
                                        this.f15881t.delete(carIcon);
                                        m4945h(carIcon.f15790n, carIcon.f15778b);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* renamed from: d */
    public final List<CarIcon> m4953d(String str, String str2, String str3) {
        List<CarIcon> list;
        NLog.m9456a("yhx", "theFunc=" + str + ",areaId=" + str2 + ",serialNo=" + str3);
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) {
            return arrayList;
        }
        String str4 = "";
        if (str.equals(f15869i)) {
            str4 = "____1";
        } else if (str.equals(f15870j)) {
            str4 = "___1_";
        } else if (str.equals(f15871k)) {
            str4 = "__1__";
        } else if (str.equals(f15872l)) {
            str4 = "_1___";
        } else if (str.equals(f15873m)) {
            str4 = "1____";
        }
        NLog.m9456a("yhx", "func_cla_Like=".concat(String.valueOf(str4)));
        QueryBuilder<CarIcon> queryBuilder = this.f15881t.queryBuilder();
        String m5131o = C2744aa.m5131o();
        String str5 = "%" + m5131o + "%";
        if (m5131o.equals("CN")) {
            queryBuilder.where(CarIconDao.Properties.AreaId.m321eq(str2), CarIconDao.Properties.IsDownload.m321eq(Boolean.TRUE), CarIconDao.Properties.Languagelist.like(str5), CarIconDao.Properties.SerialNo.m321eq(str3), CarIconDao.Properties.SoftPackageId.notEq("AUTOSEARCH"));
            queryBuilder.orderAsc(CarIconDao.Properties.Sname_zh);
            list = queryBuilder.list();
            NLog.m9456a("yhx", "cn,result=".concat(String.valueOf(list)));
        } else if (m5131o.equals("EN")) {
            queryBuilder.where(CarIconDao.Properties.AreaId.m321eq(str2), CarIconDao.Properties.IsDownload.m321eq(Boolean.TRUE), CarIconDao.Properties.Languagelist.like(str5), CarIconDao.Properties.SerialNo.m321eq(str3), CarIconDao.Properties.SoftPackageId.notEq("AUTOSEARCH"));
            queryBuilder.orderAsc(CarIconDao.Properties.Sname);
            list = queryBuilder.list();
        } else {
            queryBuilder.where(CarIconDao.Properties.AreaId.m321eq(str2), CarIconDao.Properties.IsDownload.m321eq(Boolean.TRUE), CarIconDao.Properties.Languagelist.like(str5), CarIconDao.Properties.SerialNo.m321eq(str3), CarIconDao.Properties.SoftPackageId.notEq("AUTOSEARCH"));
            queryBuilder.orderAsc(CarIconDao.Properties.Sname);
            list = queryBuilder.list();
            QueryBuilder<CarIcon> queryBuilder2 = this.f15881t.queryBuilder();
            queryBuilder2.where(CarIconDao.Properties.AreaId.m321eq(str2), CarIconDao.Properties.IsDownload.m321eq(Boolean.TRUE), CarIconDao.Properties.Languagelist.like("%EN%"), CarIconDao.Properties.SerialNo.m321eq(str3), CarIconDao.Properties.SoftPackageId.notEq("AUTOSEARCH"));
            queryBuilder2.orderAsc(CarIconDao.Properties.Sname);
            List<CarIcon> list2 = queryBuilder2.list();
            if (list == null || list.isEmpty()) {
                list = list2;
            } else if (list2 != null && !list2.isEmpty()) {
                for (CarIcon carIcon : list2) {
                    if (!list.contains(carIcon)) {
                        list.add(carIcon);
                    }
                }
                Collections.sort(list, new C2772i(this));
            }
        }
        NLog.m9456a("yhx", "getTheFuncClaVehicles exit,result=".concat(String.valueOf(list)));
        return list;
    }

    /* renamed from: a */
    private static boolean m4976a(CarIcon carIcon) {
        return (carIcon == null || TextUtils.isEmpty(carIcon.f15789m) || carIcon.f15789m.contains(carIcon.f15778b)) ? false : true;
    }
}
