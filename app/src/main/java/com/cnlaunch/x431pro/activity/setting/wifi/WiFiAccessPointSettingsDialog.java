package com.cnlaunch.x431pro.activity.setting.wifi;

import android.content.Context;
import android.net.wifi.WifiConfiguration;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import com.cnlaunch.physics.DPULinkSettingsInformation;
import com.cnlaunch.x431pro.activity.setting.wifi.DPUWiFiLinkModeSettings;
import com.cnlaunch.x431pro.widget.p290a.BaseDialog;
import com.ifoer.expedition.pro.R;
import org.codehaus.jackson.org.objectweb.asm.Opcodes;

/* renamed from: com.cnlaunch.x431pro.activity.setting.wifi.o */
/* loaded from: classes.dex */
public final class WiFiAccessPointSettingsDialog extends BaseDialog implements TextWatcher, AdapterView.OnItemSelectedListener, CompoundButton.OnCheckedChangeListener {

    /* renamed from: a */
    private View f14891a;

    /* renamed from: b */
    private Spinner f14892b;

    /* renamed from: c */
    private TextView f14893c;

    /* renamed from: g */
    private TextView f14894g;

    /* renamed from: h */
    private Button f14895h;

    /* renamed from: i */
    private Button f14896i;

    /* renamed from: j */
    private Button f14897j;

    /* renamed from: k */
    private int f14898k;

    /* renamed from: l */
    private final Handler f14899l;

    /* renamed from: m */
    private DPUWiFiLinkModeSettings.InterfaceC2579a f14900m;

    /* renamed from: n */
    private String f14901n;

    /* renamed from: o */
    private View.OnClickListener f14902o;

    /* renamed from: p */
    private View.OnClickListener f14903p;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onNothingSelected(AdapterView<?> adapterView) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public WiFiAccessPointSettingsDialog(Context context, String str, DPUWiFiLinkModeSettings.InterfaceC2579a interfaceC2579a) {
        super(context);
        this.f14891a = null;
        this.f14902o = new View$OnClickListenerC2592q(this);
        this.f14903p = new View$OnClickListenerC2593r(this);
        this.f14891a = LayoutInflater.from(context).inflate(R.layout.layout_wifi_settings_add_wifi, (ViewGroup) null);
        this.f14891a.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.f14893c = (TextView) this.f14891a.findViewById(R.id.ssid);
        WifiConfiguration m8308d = DPULinkSettingsInformation.m8314a().m8308d(str);
        if (m8308d != null) {
            this.f14893c.setText(m8308d.SSID);
        }
        this.f14893c.addTextChangedListener(this);
        this.f14892b = (Spinner) this.f14891a.findViewById(R.id.security);
        this.f14892b.setOnItemSelectedListener(this);
        this.f14895h = (Button) findViewById(R.id.button1);
        this.f14896i = (Button) findViewById(R.id.button2);
        this.f14897j = (Button) findViewById(R.id.button3);
        setCancelable(true);
        m4719a(R.string.btn_confirm, true, this.f14902o);
        m4717b(R.string.btn_canlce, true, this.f14903p);
        this.f14899l = new Handler();
        this.f14894g = null;
        this.f14900m = interfaceC2579a;
        this.f14901n = str;
        this.f14898k = 0;
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.BaseDialog
    /* renamed from: a */
    public final View mo4517a() {
        return this.f14891a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public final void m5841b() {
        Button button = this.f14895h;
        if (button == null) {
            return;
        }
        TextView textView = this.f14894g;
        boolean z = false;
        boolean z2 = textView != null && ((this.f14898k == 1 && textView.length() == 0) || (this.f14898k == 2 && this.f14894g.length() < 8));
        TextView textView2 = this.f14893c;
        if ((textView2 == null || textView2.length() != 0) && !z2) {
            z = true;
        }
        button.setEnabled(z);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        if (adapterView == this.f14892b) {
            this.f14898k = i;
            if (this.f14898k == 0) {
                this.f14891a.findViewById(R.id.security_fields).setVisibility(8);
            } else {
                this.f14891a.findViewById(R.id.security_fields).setVisibility(0);
                if (this.f14894g == null) {
                    this.f14894g = (TextView) this.f14891a.findViewById(R.id.password);
                    this.f14894g.addTextChangedListener(this);
                    ((CheckBox) this.f14891a.findViewById(R.id.show_password)).setOnCheckedChangeListener(this);
                }
            }
        }
        m5841b();
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (compoundButton.getId() == R.id.show_password) {
            int selectionEnd = this.f14894g.getSelectionEnd();
            this.f14894g.setInputType((z ? Opcodes.D2F : 128) | 1);
            if (selectionEnd >= 0) {
                ((EditText) this.f14894g).setSelection(selectionEnd);
            }
        }
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        this.f14899l.post(new RunnableC2591p(this));
    }
}
