package com.cnlaunch.x431pro.activity.diagnose;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.activity.BaseDialogActivity;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.utils.C2778n;
import com.cnlaunch.x431pro.utils.p283db.CarIcon;
import com.cnlaunch.x431pro.utils.p286f.CarIconUtils;
import com.ifoer.expedition.pro.R;

/* loaded from: classes.dex */
public class VINSelectDialogActivity extends BaseDialogActivity implements View.OnClickListener {

    /* renamed from: b */
    private Context f11134b;

    /* renamed from: c */
    private LinearLayout f11135c;

    /* renamed from: d */
    private LinearLayout f11136d;

    /* renamed from: e */
    private LinearLayout f11137e;

    /* renamed from: f */
    private CarIconUtils f11138f;

    /* renamed from: g */
    private String f11139g;

    /* renamed from: h */
    private TextView f11140h;

    /* renamed from: a */
    private final int f11133a = 769;

    /* renamed from: i */
    private boolean f11141i = false;

    /* renamed from: j */
    private boolean f11142j = false;

    @Override // com.cnlaunch.x431pro.activity.BaseDialogActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_vinscan_main);
        this.f11134b = this;
        this.f11138f = new CarIconUtils(this.f11134b);
        this.f11139g = PreferencesManager.m9595a(this.f11134b).m9591a("serialNo");
        boolean m5147g = C2744aa.m5147g(this.f11134b);
        if (!PreferencesManager.m9595a((Context) this).m9583b("is_screen_switch", false)) {
            setRequestedOrientation(6);
        } else if (m5147g) {
            setRequestedOrientation(7);
        } else {
            setRequestedOrientation(6);
        }
        m7594a();
        this.f11140h = (TextView) findViewById(R.id.vinscan_title);
        this.f11135c = (LinearLayout) findViewById(R.id.vin_obd_l);
        this.f11137e = (LinearLayout) findViewById(R.id.vin_scan);
        this.f11136d = (LinearLayout) findViewById(R.id.vin_input_l);
        this.f11135c.setOnClickListener(this);
        this.f11136d.setOnClickListener(this);
        this.f11137e.setOnClickListener(this);
        this.f11142j = PreferencesManager.m9595a(this.f11134b).m9583b("is_select_heavyduty_area", false);
        if (this.f11142j) {
            if (C2744aa.m5177a(PreferencesManager.m9595a(this.f11134b).m9591a("heavydutySerialNo"), this.f11134b)) {
                this.f11142j = true;
            } else {
                this.f11142j = false;
            }
        } else {
            String m9591a = PreferencesManager.m9595a(this.f11134b).m9591a("carSerialNo");
            String m9591a2 = PreferencesManager.m9595a(this.f11134b).m9591a("heavydutySerialNo");
            if (TextUtils.isEmpty(m9591a) && !TextUtils.isEmpty(m9591a2)) {
                if (C2744aa.m5177a(m9591a2, this.f11134b)) {
                    this.f11142j = true;
                } else {
                    this.f11142j = false;
                }
            }
        }
        this.f11141i = Boolean.parseBoolean(C2778n.m4916a(this.f11134b, "is_heavyduty"));
        if (this.f11141i) {
            this.f11140h.setText(R.string.vinscanTitle);
        } else {
            this.f11140h.setText(R.string.vinscan);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseDialogActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        setRequestedOrientation(4);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.vin_input_l) {
            if (this.f11142j) {
                NToast.m9450a(this.f11134b, (int) R.string.heavyduty_not_support);
            } else {
                sendBroadcast(new Intent("InputVinFragment"));
            }
            finish();
        } else if (id != R.id.vin_obd_l) {
            if (id != R.id.vin_scan) {
                return;
            }
            if (this.f11142j) {
                NToast.m9450a(this.f11134b, (int) R.string.heavyduty_not_support);
                finish();
            } else if (!C2744aa.m5185a((Context) this, "com.cnlaunch.x431pro.scanner.vin")) {
                Intent intent = new Intent("NEED_DOWN_LOAD_VEHICLES");
                intent.putExtra("vehicles", getString(R.string.vin_scanapk));
                sendBroadcast(intent);
                finish();
            } else {
                ComponentName componentName = new ComponentName("com.cnlaunch.x431pro.scanner.vin", "com.cnlaunch.x431pro.scanner.vin.activity.CaptureActivity");
                try {
                    Intent intent2 = new Intent();
                    intent2.setComponent(componentName);
                    startActivityForResult(intent2, 769);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            if (this.f11142j) {
                NToast.m9450a(this.f11134b, (int) R.string.heavyduty_not_support);
            } else {
                this.f11139g = PreferencesManager.m9595a(this.f11134b).m9591a("serialNo");
                CarIcon m4951e = this.f11138f.m4951e(this.f11139g, "AUTOSEARCH");
                if (m4951e != null) {
                    if (m4951e.f15787k.booleanValue()) {
                        Bundle bundle = new Bundle();
                        bundle.putString("versionlist", m4951e.f15786j);
                        bundle.putString("carname", m4951e.f15779c);
                        bundle.putString("carname_zh", m4951e.m5038a(this.f11134b));
                        bundle.putString("softpackageid", m4951e.f15778b);
                        Intent intent3 = new Intent("startDiagnoseWithoutSelectVersion");
                        intent3.putExtras(bundle);
                        sendBroadcast(intent3);
                    } else {
                        Intent intent4 = new Intent("NEED_DOWN_LOAD_VEHICLES");
                        intent4.putExtra("vehicles", "AUTOSEARCH");
                        sendBroadcast(intent4);
                    }
                } else {
                    Intent intent5 = new Intent("NEED_DOWN_LOAD_VEHICLES");
                    intent5.putExtra("vehicles", "AUTOSEARCH");
                    sendBroadcast(intent5);
                }
            }
            finish();
        }
    }

    /* renamed from: a */
    private void m7594a() {
        int integer = getResources().getInteger(R.integer.bluetoothlist_width_size);
        int integer2 = getResources().getInteger(R.integer.bluetoothlist_height_size);
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.flags = 2;
        attributes.dimAmount = 0.4f;
        window.setLayout((window.getWindowManager().getDefaultDisplay().getWidth() * integer) / 100, (window.getWindowManager().getDefaultDisplay().getHeight() * integer2) / 100);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f11134b = this;
        m7594a();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        Bundle extras;
        super.onActivityResult(i, i2, intent);
        if (i != 769) {
            return;
        }
        if (i2 == -1 && (extras = intent.getExtras()) != null) {
            C2744aa.m5172b((Activity) this, extras.getString("result"));
        }
        finish();
    }
}
