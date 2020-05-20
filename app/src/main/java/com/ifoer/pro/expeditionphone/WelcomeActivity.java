package com.ifoer.pro.expeditionphone;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.x431pro.activity.AdvertiseShowActivity;
import com.cnlaunch.x431pro.activity.GuideActivity;
import com.cnlaunch.x431pro.activity.MainActivity;
import com.cnlaunch.x431pro.module.rtu.ProductInformation;
import com.cnlaunch.x431pro.module.rtu.RegisterAndLoadInfomation;
import com.cnlaunch.x431pro.p210a.C1947h;
import com.cnlaunch.x431pro.p210a.LaunchLogic;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.utils.C2778n;
import com.cnlaunch.x431pro.utils.PathUtils;
import com.cnlaunch.x431pro.utils.p283db.SerialNumber;
import com.cnlaunch.x431pro.utils.p283db.SerialNumberDao;
import com.cnlaunch.x431pro.utils.p283db.p284a.DBManager;
import com.cnlaunch.x431pro.utils.p285e.FileUtils;
import com.ifoer.expedition.pro.R;
import de.greenrobot.dao.query.WhereCondition;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class WelcomeActivity extends Activity {

    /* renamed from: e */
    private SerialNumberDao f19459e;

    /* renamed from: h */
    private HandlerThread f19462h;

    /* renamed from: i */
    private HandlerC3599a f19463i;

    /* renamed from: j */
    private Context f19464j;

    /* renamed from: k */
    private PreferencesManager f19465k;

    /* renamed from: a */
    private final String f19455a = WelcomeActivity.class.getSimpleName();

    /* renamed from: b */
    private final int f19456b = 1009;

    /* renamed from: c */
    private final int f19457c = 1008;

    /* renamed from: d */
    private final int f19458d = 1010;

    /* renamed from: f */
    private boolean f19460f = false;

    /* renamed from: g */
    private boolean f19461g = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ boolean m2769a(WelcomeActivity welcomeActivity) {
        welcomeActivity.f19460f = true;
        return true;
    }

    /* renamed from: d */
    static /* synthetic */ boolean m2764d(WelcomeActivity welcomeActivity) {
        welcomeActivity.f19461g = true;
        return true;
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        if ((getIntent().getFlags() & 4194304) == 4194304) {
            super.onCreate(bundle);
            finish();
            return;
        }
        if (PreferencesManager.m9595a((Context) this).m9583b("is_screen_switch", false) && PreferencesManager.m9595a((Context) this).m9585b("Orientation", 2) != 0) {
            if (PreferencesManager.m9595a((Context) this).m9585b("Orientation", 2) == 1) {
                setRequestedOrientation(1);
            } else {
                setRequestedOrientation(4);
            }
        } else {
            setRequestedOrientation(0);
        }
        this.f19464j = getApplicationContext();
        this.f19465k = PreferencesManager.m9595a(this.f19464j);
        this.f19462h = new HandlerThread("command");
        this.f19462h.start();
        this.f19463i = new HandlerC3599a(this.f19462h.getLooper());
        this.f19463i.sendMessage(this.f19463i.obtainMessage(1008));
        super.onCreate(bundle);
        setContentView(R.layout.layout_splash);
        new Timer(true).schedule(new C3600a(this), 1000L);
        this.f19465k = PreferencesManager.m9595a(this.f19464j);
    }

    /* renamed from: a */
    private static boolean m2770a(Context context) {
        String str;
        Cursor query;
        List<ProviderInfo> queryContentProviders;
        String str2 = null;
        try {
            PackageManager packageManager = context.getPackageManager();
            str = packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 128)).toString();
        } catch (Exception unused) {
            str = null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        PackageManager packageManager2 = context.getPackageManager();
        ResolveInfo resolveActivity = packageManager2.resolveActivity(intent, 0);
        if (resolveActivity != null && (queryContentProviders = packageManager2.queryContentProviders(resolveActivity.activityInfo.packageName, resolveActivity.activityInfo.applicationInfo.uid, 8)) != null) {
            int i = 0;
            while (true) {
                if (i >= queryContentProviders.size()) {
                    break;
                }
                ProviderInfo providerInfo = queryContentProviders.get(i);
                if (providerInfo.readPermission != null && Pattern.matches(".*launcher.*READ_SETTINGS", providerInfo.readPermission)) {
                    str2 = providerInfo.authority;
                    break;
                }
                i++;
            }
        }
        if (str2 == null) {
            return false;
        }
        Log.e("Finals", (System.currentTimeMillis() - currentTimeMillis) + "  eee");
        try {
            query = context.getContentResolver().query(Uri.parse("content://" + str2 + "/favorites?notify=true"), null, " title= ? ", new String[]{str}, null);
        } catch (Exception unused2) {
        }
        if (query == null || !query.moveToNext()) {
            Log.i("sarah", "WelcomeActivity hasShortcut ".concat(String.valueOf(query)));
            return false;
        }
        return true;
    }

    /* renamed from: b */
    private void m2768b() {
        Intent intent = new Intent();
        intent.setClass(this, WelcomeActivity.class);
        intent.setAction("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        Intent intent2 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        intent2.putExtra("android.intent.extra.shortcut.NAME", getString(R.string.app_name));
        intent2.putExtra("duplicate", false);
        intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
        intent2.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(this, R.drawable.ic_launcher));
        sendBroadcast(intent2);
    }

    /* renamed from: a */
    public final void m2771a() {
        ProductInformation productInformation;
        RegisterAndLoadInfomation registerAndLoadInfomation;
        boolean z;
        boolean z2 = true;
        if (C2744aa.m5166c()) {
            String m9591a = PreferencesManager.m9595a((Context) this).m9591a("serialNo");
            NLog.m9452b("WelcomeActivity", "serialNo=".concat(String.valueOf(m9591a)));
            this.f19465k = PreferencesManager.m9595a(this.f19464j);
            SharedPreferences sharedPreferences = getSharedPreferences("expedition", 0);
            String str = "";
            String str2 = "";
            String str3 = "";
            if (sharedPreferences != null) {
                str = sharedPreferences.getString("username", "");
                str2 = sharedPreferences.getString("password", "");
                str3 = sharedPreferences.getString("serialNoKey", "");
                NLog.m9452b("WelcomeActivity", "PADII 1.03.007 username=" + str + "password=" + str2 + "serialNoKey=" + str3);
            }
            if (!str.isEmpty() && !str2.isEmpty()) {
                this.f19465k.m9588a("login_username", str);
                this.f19465k.m9588a("login_password", str2);
                List<String> m4998e = FileUtils.m4998e(PathUtils.m4858c());
                if (m4998e.size() > 0) {
                    for (String str4 : m4998e) {
                        if (C2744aa.m5168b(str4, this.f19464j)) {
                            ProductInformation productInformation2 = new ProductInformation(this.f19464j, str4);
                            productInformation2.f15697b = false;
                            productInformation2.f15696a = false;
                            productInformation2.m5198a(str4);
                            productInformation2.m5197b(str4);
                        }
                    }
                }
                if (!str3.isEmpty() && C2744aa.m5168b(str3, this.f19464j)) {
                    if (!m9591a.equals(str3)) {
                        SerialNumberDao serialNumberDao = DBManager.m5036a(this.f19464j).f15794a.f15798a;
                        SerialNumber serialNumber = new SerialNumber();
                        serialNumber.f15835e = "";
                        serialNumber.f15832b = Boolean.TRUE;
                        serialNumber.f15833c = Boolean.TRUE;
                        serialNumber.f15834d = str3;
                        serialNumberDao.m5051a(serialNumber);
                        PreferencesManager.m9595a(this.f19464j).m9588a("serialNo", str3);
                        PreferencesManager.m9595a(this.f19464j).m9587a("need_refresh", true);
                        m9591a = str3;
                    }
                    ProductInformation productInformation3 = new ProductInformation(this.f19464j, str3);
                    productInformation3.f15697b = false;
                    productInformation3.f15696a = false;
                    productInformation3.m5198a(str3);
                    productInformation3.m5197b(str3);
                }
                if (sharedPreferences != null) {
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putString("username", "");
                    edit.putString("password", "");
                    edit.putString("serialNoKey", "");
                    edit.commit();
                }
            }
            if (TextUtils.isEmpty(m9591a)) {
                List<String> m4998e2 = FileUtils.m4998e(PathUtils.m4858c());
                ArrayList arrayList = new ArrayList();
                if (m4998e2.size() > 0) {
                    for (String str5 : m4998e2) {
                        if (C2744aa.m5168b(str5, this.f19464j)) {
                            arrayList.add(str5);
                        }
                    }
                }
                productInformation = null;
                if (arrayList.size() > 0) {
                    productInformation = new ProductInformation(this.f19464j, (String) arrayList.get(0));
                    registerAndLoadInfomation = new RegisterAndLoadInfomation(this, (String) arrayList.get(0));
                } else {
                    registerAndLoadInfomation = null;
                }
            } else {
                productInformation = new ProductInformation(this.f19464j, m9591a);
                registerAndLoadInfomation = new RegisterAndLoadInfomation(this, m9591a);
            }
            if (registerAndLoadInfomation == null || productInformation == null) {
                z = true;
            } else {
                z = (registerAndLoadInfomation.f15706c || !registerAndLoadInfomation.f15704a.isEmpty()) ? false : productInformation.f15697b;
                PreferencesManager.m9595a(this.f19464j).m9587a("NoDeviceWithIsFirstRun", false);
            }
            if (registerAndLoadInfomation == null && productInformation == null) {
                PreferencesManager.m9595a(this.f19464j).m9587a("NoDeviceWithIsFirstRun", true);
                z = true;
            }
            if (z) {
                PreferencesManager.m9595a(this.f19464j).m9588a("login_state", "0");
            } else {
                String m9584b = PreferencesManager.m9595a(this.f19464j).m9584b("login_username", "");
                String m9584b2 = PreferencesManager.m9595a(this.f19464j).m9584b("login_password", "");
                if (!m9584b.isEmpty() && !m9584b2.isEmpty()) {
                    this.f19459e = DBManager.m5036a(this.f19464j).f15794a.f15798a;
                    List<SerialNumber> list = this.f19459e.queryBuilder().where(SerialNumberDao.Properties.SerialNo.m321eq(m9591a), new WhereCondition[0]).list();
                    if (list.size() > 0 && !list.get(0).f15832b.booleanValue()) {
                        PreferencesManager.m9595a(this.f19464j).m9588a("login_state", "0");
                    }
                }
            }
            PreferencesManager.m9595a((Context) this).m9587a("isFirstRun", z);
        } else {
            m2766c();
            PreferencesManager.m9595a((Context) this).m9587a("isFirstRun", false);
        }
        boolean m9583b = PreferencesManager.m9595a(this.f19464j).m9583b("is_guide", false);
        if (PreferencesManager.m9595a((Context) this).m9583b("isFirstRunWithCache", true)) {
            PreferencesManager.m9595a((Context) this).m9587a("isFirstRunWithCache", false);
        } else {
            z2 = false;
        }
        if (m9583b && z2 && PreferencesManager.m9595a((Context) this).m9585b("guide_pages", 0) > 0) {
            startActivity(new Intent(this, GuideActivity.class));
            finish();
            return;
        }
        boolean m9583b2 = PreferencesManager.m9595a(this.f19464j).m9583b("advertises_readed", false);
        Intent intent = new Intent(this, MainActivity.class);
        if (C2744aa.m5137l() && !m9583b2 && C2778n.m4917a(this.f19464j)) {
            intent = new Intent(this, AdvertiseShowActivity.class);
        }
        startActivity(intent);
        finish();
    }

    /* renamed from: com.ifoer.pro.expeditionphone.WelcomeActivity$a */
    /* loaded from: classes.dex */
    class HandlerC3599a extends Handler {

        /* renamed from: b */
        private boolean f19467b;

        public HandlerC3599a(Looper looper) {
            super(looper);
            this.f19467b = false;
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message2) {
            super.handleMessage(message2);
            switch (message2.what) {
                case 1008:
                    WelcomeActivity.m2762f(WelcomeActivity.this);
                    NLog.m9452b("WelcomeActivity", "REQ_CREATE_SHORTCUT start");
                    WelcomeActivity.this.f19463i.sendMessage(WelcomeActivity.this.f19463i.obtainMessage(1010));
                    return;
                case 1009:
                    NLog.m9452b("WelcomeActivity", "REQ_INIT_CODE start");
                    LaunchLogic.m7947b(WelcomeActivity.this.f19464j);
                    WelcomeActivity.m2764d(WelcomeActivity.this);
                    NLog.m9452b("WelcomeActivity", "REQ_INIT_CODE end isTimeOut=" + WelcomeActivity.this.f19460f);
                    if (WelcomeActivity.this.f19460f) {
                        WelcomeActivity.this.m2771a();
                        return;
                    }
                    return;
                case 1010:
                    NLog.m9452b("WelcomeActivity", "REQ_CHECK_FIRST_RUN_WITH_CACHE start");
                    WelcomeActivity.this.f19463i.sendMessage(WelcomeActivity.this.f19463i.obtainMessage(1009));
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        HandlerThread handlerThread = this.f19462h;
        if (handlerThread != null) {
            handlerThread.quit();
        }
        super.onDestroy();
    }

    /* renamed from: c */
    private void m2766c() {
        String m9591a = PreferencesManager.m9595a((Context) this).m9591a("serialNo_Prefix");
        String m9591a2 = PreferencesManager.m9595a((Context) this).m9591a("serialNo");
        boolean z = true;
        NLog.m9452b("WelcomeActivity", "serialNo=".concat(String.valueOf(m9591a2)));
        this.f19465k = PreferencesManager.m9595a(this.f19464j);
        SharedPreferences sharedPreferences = getSharedPreferences("expedition", 0);
        String str = "";
        String str2 = "";
        String str3 = "";
        if (sharedPreferences != null) {
            str = sharedPreferences.getString("username", "");
            str2 = sharedPreferences.getString("password", "");
            str3 = sharedPreferences.getString("serialNoKey", "");
            NLog.m9452b("WelcomeActivity", "PADII 1.03.007 username=" + str + "password=" + str2 + "serialNoKey=" + str3);
        }
        if (!str.isEmpty() && !str2.isEmpty()) {
            this.f19465k.m9588a("login_username", str);
            this.f19465k.m9588a("login_password", str2);
            if (!str3.isEmpty() && str3.startsWith(m9591a)) {
                if (!m9591a2.equals(str3)) {
                    SerialNumberDao serialNumberDao = DBManager.m5036a(this.f19464j).f15794a.f15798a;
                    SerialNumber serialNumber = new SerialNumber();
                    serialNumber.f15835e = "";
                    serialNumber.f15832b = Boolean.TRUE;
                    serialNumber.f15833c = Boolean.TRUE;
                    serialNumber.f15834d = str3;
                    serialNumberDao.m5051a(serialNumber);
                    PreferencesManager.m9595a(this.f19464j).m9588a("serialNo", str3);
                    PreferencesManager.m9595a(this.f19464j).m9587a("need_refresh", true);
                    m9591a2 = str3;
                }
                if (sharedPreferences != null) {
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putString("username", "");
                    edit.putString("password", "");
                    edit.putString("serialNoKey", "");
                    edit.commit();
                }
            }
            z = false;
        } else if (!this.f19465k.m9584b("login_username", "").isEmpty()) {
            z = false;
        }
        if (TextUtils.isEmpty(m9591a2)) {
            List<String> m4998e = FileUtils.m4998e(PathUtils.m4858c());
            ArrayList arrayList = new ArrayList();
            if (m4998e.size() > 0) {
                for (String str4 : m4998e) {
                    if (str4.startsWith(m9591a)) {
                        arrayList.add(str4);
                    }
                }
            }
        }
        if (z) {
            PreferencesManager.m9595a(this.f19464j).m9588a("login_state", "0");
        } else {
            String m9584b = PreferencesManager.m9595a(this.f19464j).m9584b("login_username", "");
            String m9584b2 = PreferencesManager.m9595a(this.f19464j).m9584b("login_password", "");
            if (!m9584b.isEmpty() && !m9584b2.isEmpty()) {
                this.f19459e = DBManager.m5036a(this.f19464j).f15794a.f15798a;
                List<SerialNumber> list = this.f19459e.queryBuilder().where(SerialNumberDao.Properties.SerialNo.m321eq(m9591a2), new WhereCondition[0]).list();
                if (list.size() > 0 && !list.get(0).f15832b.booleanValue()) {
                    PreferencesManager.m9595a(this.f19464j).m9588a("login_state", "0");
                }
            }
        }
        PreferencesManager.m9595a((Context) this).m9587a("isFirstRun", z);
    }

    /* renamed from: f */
    static /* synthetic */ void m2762f(WelcomeActivity welcomeActivity) {
        String str;
        if (!TextUtils.isEmpty(PreferencesManager.m9595a((Context) welcomeActivity).m9591a(C1947h.f10557i)) && !welcomeActivity.getString(R.string.app_name).equals(PreferencesManager.m9595a((Context) welcomeActivity).m9591a(C1947h.f10557i))) {
            Intent intent = new Intent("com.android.launcher.action.UNINSTALL_SHORTCUT");
            intent.putExtra("android.intent.extra.shortcut.NAME", PreferencesManager.m9595a((Context) welcomeActivity).m9591a(C1947h.f10557i));
            intent.putExtra("android.intent.extra.shortcut.INTENT", new Intent().setAction("android.intent.action.MAIN").setComponent(new ComponentName(welcomeActivity.getPackageName(), welcomeActivity.getLocalClassName())).addCategory("android.intent.category.LAUNCHER"));
            welcomeActivity.sendBroadcast(intent);
        }
        Intent intent2 = new Intent("android.intent.action.MAIN");
        intent2.addCategory("android.intent.category.HOME");
        ResolveInfo resolveActivity = welcomeActivity.getPackageManager().resolveActivity(intent2, 0);
        if (resolveActivity.activityInfo == null) {
            str = "";
        } else {
            str = resolveActivity.activityInfo.packageName.equals("android") ? "" : resolveActivity.activityInfo.packageName;
        }
        if (!"com.lenovo.xlauncher".equals(str) && !"com.huawei.android.launcher".equals(str) && !m2770a((Context) welcomeActivity)) {
            if (str.startsWith("com.android.launcher")) {
                welcomeActivity.m2768b();
                Log.i("test", "X431_LAUNCHER_PACKAGENAME=".concat(String.valueOf(str)));
            } else {
                if (PreferencesManager.m9595a(welcomeActivity.f19464j).m9583b("isFirstRunWithCache", true)) {
                    welcomeActivity.m2768b();
                }
                Log.i("test", "!!!!!!!!!!!!!!!!!!X431_LAUNCHER_PACKAGENAME=".concat(String.valueOf(str)));
            }
            PreferencesManager.m9595a((Context) welcomeActivity).m9588a(C1947h.f10557i, welcomeActivity.getString(R.string.app_name));
        }
        FileUtils.m5026a(welcomeActivity);
    }
}
