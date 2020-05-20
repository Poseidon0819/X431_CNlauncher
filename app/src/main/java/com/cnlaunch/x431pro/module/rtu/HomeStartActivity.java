package com.cnlaunch.x431pro.module.rtu;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.activity.MainActivity;
import com.cnlaunch.x431pro.activity.login.LoginActivity;
import com.cnlaunch.x431pro.activity.login.RegistActivity;
import com.cnlaunch.x431pro.module.rtu.BaseSelectFragment;
import com.cnlaunch.x431pro.p210a.C1947h;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.utils.PathUtils;
import com.cnlaunch.x431pro.utils.p285e.FileUtils;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* loaded from: classes.dex */
public class HomeStartActivity extends Activity implements BaseSelectFragment.InterfaceC2737a {

    /* renamed from: a */
    private final String f15674a = "rtuFragmentTag";

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return true;
    }

    /* renamed from: a */
    private boolean m5213a() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    /* renamed from: a */
    private void m5211a(String str) {
        m5210a(str, new Bundle());
    }

    /* renamed from: a */
    private void m5210a(String str, Bundle bundle) {
        FragmentManager fragmentManager = getFragmentManager();
        Fragment findFragmentByTag = fragmentManager.findFragmentByTag("rtuFragmentTag");
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        NLog.m9452b("BaseFragment", "Fragment Tag=".concat(String.valueOf(str)));
        if (findFragmentByTag != null) {
            beginTransaction.remove(findFragmentByTag);
            NLog.m9452b("BaseFragment", "Fragment is not find");
        } else {
            NLog.m9452b("BaseFragment", "Fragment is  find");
        }
        beginTransaction.add(R.id.fragment_navigation, Fragment.instantiate(getApplicationContext(), str, bundle), "rtuFragmentTag");
        beginTransaction.addToBackStack(str);
        beginTransaction.commit();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1 || i == 2) {
            NLog.m9452b("HomeStartActivity", "onActivityResult requestCode=" + i + " resultCode=" + i2);
            if (m5213a()) {
                startActivityForResult(new Intent(this, RegistActivity.class), 3);
            } else {
                m5211a(CustomerSelectFragment.class.getName());
            }
        } else if (i == 3) {
            if (i2 == -1) {
                finish();
            } else {
                m5211a(CustomerSelectFragment.class.getName());
            }
        } else if (i == 4) {
            if (i2 == -1) {
                finish();
            } else {
                m5211a(CustomerSelectFragment.class.getName());
            }
        }
    }

    @Override // com.cnlaunch.x431pro.module.rtu.BaseSelectFragment.InterfaceC2737a
    /* renamed from: a */
    public final void mo5199a(int i) {
        switch (i) {
            case 1:
                m5210a(InternetTypeSelectFragment.class.getName(), null);
                return;
            case 2:
                Bundle bundle = new Bundle();
                bundle.putString("prompt", getResources().getString(R.string.trial_ask));
                m5210a(TrialSelectFragment.class.getName(), bundle);
                return;
            case 3:
                startActivityForResult(new Intent("android.settings.WIFI_SETTINGS"), 1);
                return;
            case 4:
                Intent intent = new Intent("android.settings.ETHERNET_SETTINGS");
                intent.setPackage("com.android.settings");
                List<ResolveInfo> queryIntentActivities = getPackageManager().queryIntentActivities(intent, 0);
                if (queryIntentActivities == null) {
                    queryIntentActivities = new ArrayList<>();
                }
                if (queryIntentActivities.size() <= 0) {
                    startActivityForResult(new Intent("android.settings.WIFI_SETTINGS"), 2);
                    return;
                }
                ComponentName resolveActivity = intent.resolveActivity(getPackageManager());
                NLog.m9452b("HomeStartActivity", "CONFIRM_INTERNET_TYPE_CABLE componentName=" + resolveActivity.toString());
                startActivityForResult(new Intent("android.settings.ETHERNET_SETTINGS"), 2);
                return;
            case 5:
                m5212a(this);
                finish();
                return;
            case 6:
                setResult(-1, new Intent(this, MainActivity.class));
                finish();
                return;
            case 7:
                NLog.m9452b("HomeStartActivity", "CONFIRM_FACTORY_PATTERN");
                C1947h.f10551c = true;
                setResult(115);
                finish();
                return;
            case 8:
                if (m5213a()) {
                    PreferencesManager.m9595a((Context) this).m9587a("REGIST_SHOWTIPS", true);
                    Intent intent2 = new Intent(this, RegistActivity.class);
                    intent2.setFlags(67108864);
                    startActivityForResult(intent2, 3);
                    return;
                }
                m5210a(InternetTypeSelectFragment.class.getName(), null);
                return;
            case 9:
                if (m5213a()) {
                    Intent intent3 = new Intent(this, LoginActivity.class);
                    intent3.putExtra("ISRTULOGIN", "RTU");
                    intent3.setFlags(67108864);
                    startActivityForResult(intent3, 4);
                    return;
                }
                Bundle bundle2 = new Bundle();
                bundle2.putString("prompt", getResources().getString(R.string.trial_ask));
                m5210a(TrialSelectFragment.class.getName(), bundle2);
                return;
            case 10:
                Bundle bundle3 = new Bundle();
                bundle3.putString("prompt", getResources().getString(R.string.trial_ask));
                m5210a(TrialSelectFragment.class.getName(), bundle3);
                return;
            case 11:
                m5212a(this);
                finish();
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    private static void m5212a(Context context) {
        String m9591a = PreferencesManager.m9595a(context).m9591a("serialNo");
        if (TextUtils.isEmpty(m9591a)) {
            List<String> m4993i = FileUtils.m4993i(PathUtils.m4858c());
            ArrayList arrayList = new ArrayList();
            if (m4993i != null && m4993i.size() > 0) {
                for (String str : m4993i) {
                    if (C2744aa.m5168b(str, context) || C2744aa.m5177a(str, context) || C2744aa.m5161c(str, context)) {
                        arrayList.add(str);
                    }
                }
                if (arrayList.size() > 0) {
                    if (arrayList.size() == 1) {
                        ProductInformation productInformation = new ProductInformation(context, (String) arrayList.get(0));
                        productInformation.f15697b = false;
                        productInformation.f15696a = true;
                        productInformation.f15698c = new Date().getTime();
                        productInformation.f15699d = new Date().getTime();
                        productInformation.m5198a((String) arrayList.get(0));
                        PreferencesManager.m9595a(context).m9587a("tryFlag", true);
                        PreferencesManager.m9595a(context).m9587a("isFirstRun", false);
                        productInformation.m5197b((String) arrayList.get(0));
                        return;
                    }
                    for (int i = 0; i < arrayList.size(); i++) {
                        ProductInformation productInformation2 = new ProductInformation(context, (String) arrayList.get(i));
                        productInformation2.f15697b = false;
                        productInformation2.f15696a = true;
                        productInformation2.f15698c = new Date().getTime();
                        productInformation2.f15699d = new Date().getTime();
                        productInformation2.m5198a((String) arrayList.get(i));
                        PreferencesManager.m9595a(context).m9587a("tryFlag", true);
                        PreferencesManager.m9595a(context).m9587a("isFirstRun", false);
                        productInformation2.m5197b((String) arrayList.get(i));
                    }
                    return;
                }
                NToast.m9447b(context, (int) R.string.connector_need_activate);
                return;
            }
            NToast.m9447b(context, (int) R.string.connector_need_activate);
            return;
        }
        ProductInformation productInformation3 = new ProductInformation(context, m9591a);
        productInformation3.f15697b = false;
        productInformation3.f15696a = true;
        productInformation3.f15698c = new Date().getTime();
        productInformation3.f15699d = new Date().getTime();
        productInformation3.m5198a(m9591a);
        PreferencesManager.m9595a(context).m9587a("tryFlag", true);
        PreferencesManager.m9595a(context).m9587a("isFirstRun", false);
        productInformation3.m5197b(m9591a);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        int i = 2131755280;
        switch (PreferencesManager.m9595a((Context) this).m9585b("theme_type", 0)) {
            case 1:
            case 2:
                break;
            case 3:
                i = 2131755281;
                break;
            default:
                i = 2131755279;
                break;
        }
        setTheme(i);
        super.onCreate(bundle);
        if (PreferencesManager.m9595a((Context) this).m9583b("is_screen_switch", false) && PreferencesManager.m9595a((Context) this).m9585b("Orientation", 2) != 0) {
            if (PreferencesManager.m9595a((Context) this).m9585b("Orientation", 2) == 1) {
                setRequestedOrientation(1);
            } else {
                setRequestedOrientation(4);
            }
        } else {
            setRequestedOrientation(0);
        }
        setContentView(R.layout.activity_rtu_home_start);
        getFragmentManager().beginTransaction().add(R.id.fragment_navigation, Fragment.instantiate(getApplicationContext(), CustomerSelectFragment.class.getName(), null), "rtuFragmentTag").commit();
    }
}
