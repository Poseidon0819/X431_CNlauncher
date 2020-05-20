package com.unionpay.mobile.android.pro.pboc.engine;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.unionpay.mobile.android.fully.InterfaceC4148a;
import com.unionpay.mobile.android.model.C4173b;
import com.unionpay.mobile.android.model.InterfaceC4174c;
import com.unionpay.mobile.android.nocard.utils.UPPayEngine;
import com.unionpay.mobile.android.pboctransaction.AppIdentification;
import com.unionpay.mobile.android.pboctransaction.C4263d;
import com.unionpay.mobile.android.pboctransaction.InterfaceC4261b;
import com.unionpay.mobile.android.pboctransaction.InterfaceC4262c;
import com.unionpay.mobile.android.pboctransaction.icfcc.C4266a;
import com.unionpay.mobile.android.pboctransaction.remoteapdu.C4274a;
import com.unionpay.mobile.android.pboctransaction.samsung.C4279b;
import com.unionpay.mobile.android.pboctransaction.samsung.C4283f;
import com.unionpay.mobile.android.pboctransaction.sdapdu.C4287a;
import com.unionpay.mobile.android.pboctransaction.simapdu.C4291b;
import com.unionpay.mobile.android.plugin.BaseActivity;
import com.unionpay.mobile.android.utils.C4390k;
import java.util.ArrayList;
import java.util.HashMap;

/* renamed from: com.unionpay.mobile.android.pro.pboc.engine.b */
/* loaded from: classes2.dex */
public class C4298b implements Handler.Callback, C4283f.InterfaceC4284a {

    /* renamed from: g */
    private Context f22862g;

    /* renamed from: h */
    private Handler f22863h;

    /* renamed from: i */
    private ArrayList<InterfaceC4174c> f22864i;

    /* renamed from: n */
    private C4263d f22869n;

    /* renamed from: o */
    private InterfaceC4262c f22870o;

    /* renamed from: q */
    private C4263d f22872q;

    /* renamed from: r */
    private C4274a f22873r;

    /* renamed from: t */
    private C4263d f22875t;

    /* renamed from: u */
    private C4291b f22876u;

    /* renamed from: w */
    private C4263d f22878w;

    /* renamed from: x */
    private C4279b f22879x;

    /* renamed from: y */
    private C4283f f22880y;

    /* renamed from: a */
    private final int f22856a = 0;

    /* renamed from: b */
    private final int f22857b = 1;

    /* renamed from: c */
    private final int f22858c = 2;

    /* renamed from: d */
    private final int f22859d = 4;

    /* renamed from: e */
    private final int f22860e = 8;

    /* renamed from: f */
    private int f22861f = 0;

    /* renamed from: j */
    private ArrayList<InterfaceC4174c> f22865j = null;

    /* renamed from: k */
    private ArrayList<InterfaceC4174c> f22866k = null;

    /* renamed from: l */
    private ArrayList<InterfaceC4174c> f22867l = null;

    /* renamed from: m */
    private ArrayList<InterfaceC4174c> f22868m = null;

    /* renamed from: p */
    private final InterfaceC4261b f22871p = new C4299c(this);

    /* renamed from: s */
    private final InterfaceC4261b f22874s = new C4300d(this);

    /* renamed from: v */
    private final InterfaceC4261b f22877v = new C4301e(this);

    /* renamed from: z */
    private final InterfaceC4261b f22881z = new C4302f(this);

    /* renamed from: A */
    private InterfaceC4297a f22854A = null;

    /* renamed from: B */
    private boolean f22855B = false;

    public C4298b(Context context, String str) {
        this.f22862g = null;
        this.f22863h = null;
        this.f22864i = null;
        this.f22869n = null;
        this.f22870o = null;
        this.f22872q = null;
        this.f22873r = null;
        this.f22875t = null;
        this.f22876u = null;
        this.f22878w = null;
        this.f22879x = null;
        this.f22880y = null;
        this.f22862g = context;
        this.f22863h = new Handler(this);
        this.f22864i = new ArrayList<>(1);
        InterfaceC4148a interfaceC4148a = (InterfaceC4148a) ((BaseActivity) context).mo476a(UPPayEngine.class.toString());
        this.f22870o = m1215a("cn.gov.pbc.tsm.client.mobile.andorid", 1) ? new C4266a() : new C4287a();
        this.f22869n = new C4263d(this.f22870o, interfaceC4148a, str);
        try {
            Class.forName("org.simalliance.openmobileapi.SEService");
            this.f22873r = new C4274a();
            this.f22872q = new C4263d(this.f22873r, interfaceC4148a, str);
            this.f22876u = C4291b.m1228e();
            this.f22875t = new C4263d(this.f22876u, interfaceC4148a, str);
            if (m1215a("com.unionpay.tsmservice", 18)) {
                this.f22880y = new C4283f(this);
                this.f22880y.m1268a(this.f22863h);
                this.f22878w = new C4263d(this.f22880y, interfaceC4148a, str);
                return;
            }
            C4173b.f22368aB = false;
            this.f22879x = new C4279b();
            this.f22878w = new C4263d(this.f22879x, interfaceC4148a, str);
            this.f22881z.mo1205b();
        } catch (ClassNotFoundException | Exception unused) {
            this.f22874s.mo1205b();
            this.f22877v.mo1205b();
            this.f22881z.mo1205b();
        }
    }

    /* renamed from: a */
    private final void m1222a(int i) {
        if (i == 4) {
            C4390k.m836c("UPCardEngine", "se");
            if (m1215a("com.unionpay.tsmservice", 18) && this.f22880y != null) {
                Log.e("uppay-spay", "type se  start init");
                this.f22880y.mo1239a(this.f22881z, this.f22862g);
            } else if (this.f22879x != null) {
                this.f22881z.mo1205b();
            }
        } else if (i != 8) {
            switch (i) {
                case 1:
                    C4390k.m836c("UPCardEngine", "cmcc");
                    if (!m1215a("com.unionpay.mobile.tsm", 12)) {
                        this.f22874s.mo1205b();
                        return;
                    }
                    C4274a c4274a = this.f22873r;
                    if (c4274a != null) {
                        c4274a.m1277a(this.f22855B);
                        this.f22873r.mo1239a(this.f22874s, this.f22862g);
                        return;
                    }
                    return;
                case 2:
                    C4390k.m836c("UPCardEngine", "ic");
                    if (this.f22876u != null) {
                        if (m1213b().contains("ZTE")) {
                            this.f22876u.mo1239a(this.f22877v, this.f22862g);
                            return;
                        } else {
                            this.f22877v.mo1205b();
                            return;
                        }
                    }
                    return;
                default:
                    C4390k.m836c("UPCardEngine", "sd");
                    InterfaceC4262c interfaceC4262c = this.f22870o;
                    if (interfaceC4262c != null) {
                        interfaceC4262c.mo1239a(this.f22871p, this.f22862g);
                        return;
                    }
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public boolean m1215a(String str, int i) {
        PackageInfo packageInfo = null;
        try {
            packageInfo = this.f22862g.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException | Exception unused) {
        }
        if (packageInfo != null) {
            C4390k.m838a("tsm-client", "tsm version code=" + packageInfo.versionCode);
            return packageInfo.versionCode >= i;
        }
        return false;
    }

    /* renamed from: b */
    private static String m1213b() {
        return Build.BRAND + "_" + Build.MODEL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m1212b(int i) {
        Thread thread;
        if (i == 1) {
            thread = new Thread(new RunnableC4303g(this));
        } else if (i == 2) {
            thread = new Thread(new RunnableC4304h(this));
        } else if (i != 4) {
            if (i == 8) {
                new Thread(new RunnableC4306j(this)).start();
                return;
            }
            return;
        } else if (!m1213b().contains("ZTE")) {
            return;
        } else {
            thread = new Thread(new RunnableC4305i(this));
        }
        thread.start();
    }

    /* renamed from: a */
    public final Bundle m1220a(InterfaceC4174c interfaceC4174c, String str, HashMap<String, String> hashMap, HashMap<String, String> hashMap2, String str2) {
        C4263d c4263d;
        if (interfaceC4174c == null) {
            return null;
        }
        int mo1541c = interfaceC4174c.mo1541c();
        int mo1540d = interfaceC4174c.mo1540d();
        if (mo1540d != 1) {
            if (mo1540d == 2) {
                return this.f22869n.m1329a(Integer.parseInt(interfaceC4174c.mo1544a()), str, hashMap2, str2);
            }
            return null;
        }
        AppIdentification appIdentification = new AppIdentification(interfaceC4174c.mo1544a(), null);
        String str3 = interfaceC4174c.mo1540d() == 1 ? "2" : "1";
        if (mo1541c == 8) {
            c4263d = this.f22869n;
        } else if (mo1541c == 4) {
            c4263d = this.f22872q;
        } else if (mo1541c == 16) {
            c4263d = this.f22875t;
        } else if (mo1541c == 1) {
            c4263d = this.f22878w;
        } else if (mo1541c != 32) {
            return null;
        } else {
            c4263d = this.f22878w;
            str3 = DiagnoseConstants.DATA_TYPE_FROM_APK_TO_SO_SET_MENUPATH;
        }
        return c4263d.m1327a(appIdentification, str, str3, hashMap, hashMap2, str2);
    }

    /* renamed from: a */
    public final void m1223a() {
        C4274a c4274a = this.f22873r;
        if (c4274a != null) {
            c4274a.mo1241a();
            this.f22873r = null;
        }
        InterfaceC4262c interfaceC4262c = this.f22870o;
        if (interfaceC4262c != null) {
            interfaceC4262c.mo1241a();
            this.f22870o = null;
        }
        C4291b c4291b = this.f22876u;
        if (c4291b != null) {
            c4291b.mo1241a();
            this.f22876u = null;
        }
        C4279b c4279b = this.f22879x;
        if (c4279b != null) {
            c4279b.mo1241a();
            this.f22879x = null;
        }
        C4283f c4283f = this.f22880y;
        if (c4283f != null) {
            c4283f.mo1241a();
            this.f22880y = null;
        }
        this.f22862g = null;
        this.f22854A = null;
        this.f22863h.removeCallbacksAndMessages(null);
        this.f22863h = null;
        this.f22878w = null;
        this.f22869n = null;
        this.f22872q = null;
        this.f22875t = null;
        this.f22861f = 0;
    }

    /* renamed from: a */
    public final void m1221a(Handler handler, String str, String str2) {
        if (C4173b.f22367aA && C4173b.f22368aB) {
            C4173b.f22374bo = true;
            C4283f c4283f = this.f22880y;
            if (c4283f == null || this.f22878w == null) {
                return;
            }
            c4283f.m1268a(handler);
            this.f22880y.m1258b(str);
            this.f22880y.m1255c(str2);
            Log.e("uppay-spay", "tsmservice  get spay card list");
            this.f22878w.m1320b();
        }
    }

    /* renamed from: a */
    public final void m1219a(InterfaceC4297a interfaceC4297a, boolean z) {
        this.f22855B = z;
        this.f22854A = interfaceC4297a;
        this.f22861f = 0;
        m1222a(0);
    }

    @Override // com.unionpay.mobile.android.pboctransaction.samsung.C4283f.InterfaceC4284a
    /* renamed from: a */
    public final void mo1214a(boolean z) {
        C4390k.m836c("uppay", "startReadList  spay");
        C4173b.f22368aB = z;
        m1212b(8);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message2) {
        C4390k.m836c("UPCardEngine", " msg.what = " + message2.what);
        if (message2.what == 1 || message2.what == 2 || message2.what == 4 || message2.what == 8) {
            this.f22861f ^= message2.what;
            C4390k.m836c("UPCardEngine", " mTag = " + this.f22861f);
            if (message2.obj != null) {
                if (message2.what == 1) {
                    this.f22865j = (ArrayList) message2.obj;
                } else if (message2.what == 2) {
                    this.f22866k = (ArrayList) message2.obj;
                } else if (message2.what == 4) {
                    this.f22867l = (ArrayList) message2.obj;
                } else if (message2.what == 8) {
                    this.f22868m = (ArrayList) message2.obj;
                }
            }
            m1222a(message2.what);
        }
        if (this.f22861f == 15 && this.f22854A != null) {
            ArrayList<InterfaceC4174c> arrayList = this.f22865j;
            if (arrayList != null && arrayList.size() > 0) {
                this.f22864i.addAll(this.f22865j);
            }
            ArrayList<InterfaceC4174c> arrayList2 = this.f22866k;
            if (arrayList2 != null && arrayList2.size() > 0) {
                this.f22864i.addAll(this.f22866k);
            }
            ArrayList<InterfaceC4174c> arrayList3 = this.f22867l;
            if (arrayList3 != null && arrayList3.size() > 0) {
                this.f22864i.addAll(this.f22867l);
            }
            ArrayList<InterfaceC4174c> arrayList4 = this.f22868m;
            if (arrayList4 != null && arrayList4.size() > 0) {
                this.f22864i.addAll(this.f22868m);
            }
            this.f22854A.mo1157a(this.f22864i);
        }
        return true;
    }
}
