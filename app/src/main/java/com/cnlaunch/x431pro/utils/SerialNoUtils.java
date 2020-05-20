package com.cnlaunch.x431pro.utils;

import android.content.Context;
import android.text.TextUtils;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.physics.p205k.DeviceUtils;
import com.cnlaunch.x431pro.p210a.LaunchLogic;
import com.cnlaunch.x431pro.utils.p283db.SerialNumber;
import com.cnlaunch.x431pro.utils.p283db.SerialNumberDao;
import com.cnlaunch.x431pro.utils.p283db.p284a.DBManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.utils.x */
/* loaded from: classes.dex */
public class SerialNoUtils {

    /* renamed from: f */
    private static SerialNoUtils f15950f;

    /* renamed from: a */
    public String f15951a;

    /* renamed from: b */
    private Context f15952b;

    /* renamed from: c */
    private PreferencesManager f15953c;

    /* renamed from: d */
    private SerialNumberDao f15954d;

    /* renamed from: e */
    private List<SerialNumber> f15955e;

    /* renamed from: a */
    public static SerialNoUtils m4827a(Context context) {
        if (f15950f == null) {
            synchronized (SerialNoUtils.class) {
                if (f15950f == null) {
                    f15950f = new SerialNoUtils(context);
                }
            }
        }
        return f15950f;
    }

    private SerialNoUtils(Context context) {
        this.f15952b = context;
        this.f15953c = PreferencesManager.m9595a(this.f15952b);
        this.f15954d = DBManager.m5036a(this.f15952b).f15794a.f15798a;
    }

    /* renamed from: a */
    public final void m4828a() {
        if (this.f15954d == null) {
            this.f15954d = DBManager.m5036a(this.f15952b).f15794a.f15798a;
        }
        if (this.f15953c == null) {
            this.f15953c = PreferencesManager.m9595a(this.f15952b);
        }
        String m9591a = this.f15953c.m9591a("serialNo");
        if (TextUtils.isEmpty(m9591a)) {
            m9591a = this.f15953c.m9591a("carSerialNo");
            String m9591a2 = this.f15953c.m9591a("heavydutySerialNo");
            if (TextUtils.isEmpty(m9591a)) {
                m9591a = m9591a2;
            }
            this.f15953c.m9588a("serialNo", m9591a);
        }
        this.f15951a = m9591a;
        List<SerialNumber> loadAll = this.f15954d.loadAll();
        this.f15955e = new ArrayList();
        for (SerialNumber serialNumber : loadAll) {
            if (C2744aa.m5168b(serialNumber.f15834d, this.f15952b) || C2744aa.m5177a(serialNumber.f15834d, this.f15952b) || C2744aa.m5161c(serialNumber.f15834d, this.f15952b)) {
                if (serialNumber.f15832b.booleanValue()) {
                    this.f15955e.add(serialNumber);
                }
            }
        }
        if (this.f15955e.size() == 0) {
            this.f15951a = "";
        }
    }

    /* renamed from: b */
    public static String m4825b(Context context) {
        Iterator<SerialNumber> it;
        String str = "";
        List<SerialNumber> m5054a = DBManager.m5036a(context).f15794a.f15798a.m5054a();
        if (m5054a != null && !m5054a.isEmpty()) {
            while (m5054a.iterator().hasNext()) {
                str = str + it.next().f15834d + ",";
            }
            str = str.substring(0, str.length() - 1);
        }
        NLog.m9456a("yhx", "getSerialNoString.serialNos=".concat(String.valueOf(str)));
        return str;
    }

    /* renamed from: a */
    public static boolean m4826a(Context context, String str) {
        String m8143b;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (DBManager.m5036a(context).f15794a.f15798a.count() > 0) {
            m8143b = DBManager.m5036a(context).f15794a.f15798a.m5045c(str);
        } else {
            DeviceUtils.m8149a();
            m8143b = DeviceUtils.m8143b(str);
        }
        if (TextUtils.isEmpty(m8143b)) {
            return false;
        }
        return "1".equals(m8143b) || "2".equals(m8143b);
    }

    /* renamed from: b */
    public static boolean m4824b(Context context, String str) {
        String m8143b;
        if (!TextUtils.isEmpty(str)) {
            if (DBManager.m5036a(context).f15794a.f15798a.count() > 0) {
                m8143b = DBManager.m5036a(context).f15794a.f15798a.m5045c(str);
            } else {
                DeviceUtils.m8149a();
                m8143b = DeviceUtils.m8143b(str);
            }
            if (!TextUtils.isEmpty(m8143b)) {
                return "2".equals(m8143b);
            }
        }
        return false;
    }

    /* renamed from: c */
    public static void m4823c(Context context, String str) {
        LaunchLogic.m7949a(context).m7948a(str);
    }
}
