package com.cnlaunch.x431pro.p210a;

import android.content.Context;
import android.text.TextUtils;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p125c.p126a.AsyncTaskManager;
import com.cnlaunch.p120d.p125c.p126a.OnDataListener;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.physics.p205k.DeviceUtils;
import com.cnlaunch.x431pro.module.p241a.BaseResponse;
import com.cnlaunch.x431pro.module.p252d.p253a.DiagnoseAction;
import com.cnlaunch.x431pro.module.p252d.p254b.QuerySerialNosForbitFLagResponse;
import com.cnlaunch.x431pro.module.p252d.p254b.SerialNoForbitFlag;
import com.cnlaunch.x431pro.utils.ApkUpgradeUtils;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.utils.C2778n;
import com.cnlaunch.x431pro.utils.PathUtils;
import com.cnlaunch.x431pro.utils.SerialNoUtils;
import com.cnlaunch.x431pro.utils.p283db.SerialNumberDao;
import com.cnlaunch.x431pro.utils.p283db.p284a.DBManager;
import com.cnlaunch.x431pro.utils.p285e.FileUtils;
import com.cnlaunch.x431pro.utils.p286f.CarIconUtils;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.a.k */
/* loaded from: classes.dex */
public final class LaunchLogic implements OnDataListener {

    /* renamed from: a */
    public static LaunchLogic f10582a;

    /* renamed from: b */
    private Context f10583b;

    /* renamed from: c */
    private AsyncTaskManager f10584c;

    /* renamed from: d */
    private String f10585d;

    @Override // com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public final void onFailure(int i, int i2, Object obj) {
    }

    /* renamed from: a */
    public static synchronized LaunchLogic m7949a(Context context) {
        LaunchLogic launchLogic;
        synchronized (LaunchLogic.class) {
            if (f10582a == null) {
                f10582a = new LaunchLogic(context.getApplicationContext());
            }
            launchLogic = f10582a;
        }
        return launchLogic;
    }

    private LaunchLogic(Context context) {
        this.f10583b = context.getApplicationContext();
        this.f10584c = AsyncTaskManager.m9574a(this.f10583b);
    }

    /* renamed from: b */
    public static void m7947b(Context context) {
        PreferencesManager m9595a = PreferencesManager.m9595a(context);
        SerialNumberDao serialNumberDao = DBManager.m5036a(context).f15794a.f15798a;
        String m9591a = m9595a.m9591a("serialNo");
        if (!TextUtils.isEmpty(m9591a)) {
            String m9591a2 = m9595a.m9591a("carSerialNo");
            String m9591a3 = m9595a.m9591a("heavydutySerialNo");
            if (!C2744aa.m5161c(m9591a, context) && TextUtils.isEmpty(m9591a2) && TextUtils.isEmpty(m9591a3)) {
                if (C2744aa.m5168b(m9591a, context)) {
                    m9595a.m9588a("carSerialNo", m9591a);
                } else if (C2744aa.m5177a(m9591a, context)) {
                    m9595a.m9588a("heavydutySerialNo", m9591a);
                }
                m9595a.m9588a("carAndHeavydutySerialNo", "");
            }
        }
        if (TextUtils.isEmpty(m9591a)) {
            C2744aa.m5134m(context);
        }
        CarIconUtils m4977a = CarIconUtils.m4977a(context);
        if (!TextUtils.isEmpty(m9591a) && m4977a.m4978a()) {
            m9595a.m9587a("need_refresh", true);
        }
        C2744aa.m5120t(context);
        if (TextUtils.isEmpty(m9591a)) {
            List<String> m4993i = FileUtils.m4993i(PathUtils.m4858c());
            ArrayList<String> arrayList = new ArrayList();
            if (m4993i != null && m4993i.size() > 0) {
                for (String str : m4993i) {
                    if (C2744aa.m5168b(str, context) || C2744aa.m5177a(str, context) || C2744aa.m5161c(str, context)) {
                        arrayList.add(str);
                    }
                }
            }
            if (PreferencesManager.m9595a(context).m9583b("enable_delete_png", false) && !arrayList.isEmpty()) {
                for (String str2 : arrayList) {
                    FileUtils.m4991k(PathUtils.m4861b(context, str2));
                }
            }
            serialNumberDao.m5049a(arrayList);
            if (arrayList.size() > 0) {
                if (arrayList.size() == 1) {
                    PreferencesManager.m9595a(context).m9588a("serialNo", arrayList.get(0));
                    if (C2744aa.m5168b(arrayList.get(0), context)) {
                        PreferencesManager.m9595a(context).m9588a("carSerialNo", arrayList.get(0));
                        PreferencesManager.m9595a(context).m9588a("carAndHeavydutySerialNo", "");
                        if (C2744aa.m5161c(m9595a.m9591a("heavydutySerialNo"), context)) {
                            m9595a.m9588a("heavydutySerialNo", "");
                        }
                    } else if (C2744aa.m5177a(arrayList.get(0), context)) {
                        PreferencesManager.m9595a(context).m9588a("heavydutySerialNo", arrayList.get(0));
                        PreferencesManager.m9595a(context).m9588a("carAndHeavydutySerialNo", "");
                        if (C2744aa.m5161c(m9595a.m9591a("carSerialNo"), context)) {
                            m9595a.m9588a("carSerialNo", "");
                        }
                    } else if (C2744aa.m5161c(arrayList.get(0), context)) {
                        PreferencesManager.m9595a(context).m9588a("carAndHeavydutySerialNo", arrayList.get(0));
                        PreferencesManager.m9595a(context).m9588a("carSerialNo", arrayList.get(0));
                        PreferencesManager.m9595a(context).m9588a("heavydutySerialNo", arrayList.get(0));
                    }
                } else {
                    String m9591a4 = m9595a.m9591a("carAndHeavydutySerialNo");
                    String m9591a5 = m9595a.m9591a("carSerialNo");
                    String m9591a6 = m9595a.m9591a("heavydutySerialNo");
                    boolean z = false;
                    boolean z2 = false;
                    boolean z3 = false;
                    boolean z4 = false;
                    for (String str3 : arrayList) {
                        if (C2744aa.m5161c(str3, context)) {
                            z = true;
                        } else if (!TextUtils.isEmpty(m9591a5) && m9591a5.equals(str3)) {
                            z2 = true;
                        } else if (!TextUtils.isEmpty(m9591a6) && m9591a6.equals(str3)) {
                            z3 = true;
                        } else if (!TextUtils.isEmpty(m9591a4) && m9591a4.equals(str3)) {
                            z4 = true;
                        }
                    }
                    if (z && !z2 && !z3 && !z4) {
                        boolean z5 = false;
                        for (String str4 : arrayList) {
                            if (C2744aa.m5161c(str4, context) && !z5) {
                                m9595a.m9588a("carAndHeavydutySerialNo", str4);
                                m9595a.m9588a("serialNo", str4);
                                m9595a.m9588a("carSerialNo", str4);
                                m9595a.m9588a("heavydutySerialNo", str4);
                                z5 = true;
                            }
                        }
                    }
                    if (!z || (z && (z2 || z3))) {
                        m9595a.m9588a("carAndHeavydutySerialNo", "");
                        boolean z6 = true;
                        boolean z7 = true;
                        for (String str5 : arrayList) {
                            if (C2744aa.m5168b(str5, context)) {
                                if (z2) {
                                    z6 = false;
                                } else if (z6) {
                                    m9595a.m9588a("carSerialNo", str5);
                                    z6 = false;
                                }
                            } else if (C2744aa.m5177a(str5, context)) {
                                if (z3) {
                                    z7 = false;
                                } else if (z7) {
                                    m9595a.m9588a("heavydutySerialNo", str5);
                                    z7 = false;
                                }
                            }
                        }
                        if (z6) {
                            if (!TextUtils.isEmpty(m9595a.m9591a("carSerialNo"))) {
                                m9595a.m9588a("carSerialNo", "");
                            }
                            if (!z7) {
                                m9595a.m9588a("serialNo", m9595a.m9591a("heavydutySerialNo"));
                            } else {
                                m9595a.m9588a("serialNo", "");
                                if (!TextUtils.isEmpty(m9595a.m9591a("heavydutySerialNo"))) {
                                    m9595a.m9588a("heavydutySerialNo", "");
                                }
                            }
                        } else {
                            m9595a.m9588a("serialNo", m9595a.m9591a("carSerialNo"));
                            if (z7) {
                                if (!TextUtils.isEmpty(m9595a.m9591a("heavydutySerialNo"))) {
                                    m9595a.m9588a("heavydutySerialNo", "");
                                }
                            } else {
                                String m9591a7 = m9595a.m9591a("carSerialNo");
                                String m9591a8 = m9595a.m9591a("heavydutySerialNo");
                                if (TextUtils.isEmpty(m9591a)) {
                                    m9595a.m9588a("serialNo", m9591a7);
                                } else if (!m9591a5.equals(m9591a7) && !m9591a.equals(m9591a8)) {
                                    m9595a.m9588a("serialNo", m9591a7);
                                }
                            }
                        }
                    }
                    String m9591a9 = m9595a.m9591a("serialNo");
                    if (!TextUtils.isEmpty(m9591a9)) {
                        serialNumberDao.m5047b(m9591a9);
                    }
                }
                m9595a.m9587a("need_refresh", true);
            }
        }
        if (C2778n.m4917a(context)) {
            ConfigUtils.m7963a(context).m7964a();
            if (!TextUtils.isEmpty(PreferencesManager.m9595a(context).m9591a("apk_soft_name"))) {
                ApkUpgradeUtils.m5103c(context);
            }
            if (PreferencesManager.m9595a(context).m9583b("enable_blacklist", true)) {
                m7949a(context).m7950a(90001);
            }
        }
    }

    @Override // com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public final Object doInBackground(int i) throws C1425f {
        switch (i) {
            case 90001:
                return new DiagnoseAction(this.f10583b).m5364g(SerialNoUtils.m4825b(this.f10583b));
            case 90002:
                return new DiagnoseAction(this.f10583b).m5363h(this.f10585d);
            default:
                return null;
        }
    }

    @Override // com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public final void onSuccess(int i, Object obj) {
        QuerySerialNosForbitFLagResponse querySerialNosForbitFLagResponse;
        List<SerialNoForbitFlag> sysPdtForbitBlackList;
        BaseResponse baseResponse;
        switch (i) {
            case 90001:
                if (obj == null || (querySerialNosForbitFLagResponse = (QuerySerialNosForbitFLagResponse) obj) == null || !querySerialNosForbitFLagResponse.isSuccess() || (sysPdtForbitBlackList = querySerialNosForbitFLagResponse.getSysPdtForbitBlackList()) == null || sysPdtForbitBlackList.isEmpty()) {
                    return;
                }
                for (SerialNoForbitFlag serialNoForbitFlag : sysPdtForbitBlackList) {
                    if (serialNoForbitFlag != null && serialNoForbitFlag.isUnForbidden() && SerialNoUtils.m4824b(this.f10583b, serialNoForbitFlag.getSerialNo())) {
                        m7948a(serialNoForbitFlag.getSerialNo());
                        serialNoForbitFlag.setForbitFlag("2");
                    }
                    if (serialNoForbitFlag.isInBlackList()) {
                        DeviceUtils.m8149a();
                        DeviceUtils.m8139e(serialNoForbitFlag.getSerialNo(), serialNoForbitFlag.getForbitFlag());
                    }
                }
                DBManager.m5036a(this.f10583b).f15794a.f15798a.m5044c(sysPdtForbitBlackList);
                return;
            case 90002:
                if (obj == null || (baseResponse = (BaseResponse) obj) == null || !baseResponse.isSuccess()) {
                    return;
                }
                NLog.m9456a("yhx", "update Serial state success.");
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    public final void m7948a(String str) {
        this.f10585d = str;
        m7950a(90002);
        DBManager.m5036a(this.f10583b).f15794a.f15798a.m5043d(str);
        DeviceUtils.m8149a();
        DeviceUtils.m8139e(str, "2");
    }

    /* renamed from: a */
    public final void m7950a(int i) {
        this.f10584c.m9575a(i, true, this);
    }
}
