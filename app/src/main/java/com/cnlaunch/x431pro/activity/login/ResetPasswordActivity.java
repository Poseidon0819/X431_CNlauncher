package com.cnlaunch.x431pro.activity.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.mapapi.UIMsg;
import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceConstant;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.activity.ActivityC2004c;
import com.cnlaunch.x431pro.module.p241a.CommonResponse;
import com.cnlaunch.x431pro.module.p272k.p273a.UserAction;
import com.cnlaunch.x431pro.utils.C2787z;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.ifoer.expedition.pro.R;
import com.itextpdf.text.pdf.PdfContentParser;
import java.util.HashMap;

/* loaded from: classes.dex */
public class ResetPasswordActivity extends ActivityC2004c implements View.OnFocusChangeListener {

    /* renamed from: C */
    EditText f13336C;

    /* renamed from: D */
    EditText f13337D;

    /* renamed from: E */
    Button f13338E;

    /* renamed from: F */
    String f13339F;

    /* renamed from: G */
    String f13340G;

    /* renamed from: H */
    String f13341H;

    /* renamed from: I */
    String f13342I;

    /* renamed from: J */
    String f13343J;

    /* renamed from: S */
    private PreferencesManager f13352S;

    /* renamed from: n */
    UserAction f13354n;

    /* renamed from: K */
    private final int f13344K = PdfContentParser.COMMAND_TYPE;

    /* renamed from: L */
    private final int f13345L = 0;

    /* renamed from: M */
    private final int f13346M = 1022;

    /* renamed from: N */
    private final int f13347N = 1023;

    /* renamed from: O */
    private final int f13348O = HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_QUERY_OPTIONS_NULL;

    /* renamed from: P */
    private final int f13349P = UIMsg.f_FUN.FUN_ID_SCH_NAV_OPTION;

    /* renamed from: Q */
    private final int f13350Q = UIMsg.f_FUN.FUN_ID_SCH_POI_OPTION;

    /* renamed from: R */
    private final int f13351R = UIMsg.f_FUN.FUN_ID_SCH_NAV_ACTION;

    /* renamed from: T */
    private HashMap<String, String> f13353T = new HashMap<>();

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.support.p012v4.app.FragmentActivity, android.support.p012v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_reset_password);
        m7743b();
        Bundle extras = getIntent().getExtras();
        this.f13339F = extras.getString("phone_or_mail");
        this.f13343J = extras.getString("Vcode");
        this.f13340G = extras.getString("username");
        this.f13352S = PreferencesManager.m9595a(this.f10981q);
        this.f13354n = new UserAction(this);
        this.f13336C = (EditText) findViewById(R.id.editText_password);
        this.f13336C.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        this.f13337D = (EditText) findViewById(R.id.editText_comfirm_password);
        this.f13337D.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        this.f13336C.requestFocus();
        this.f13336C.setOnFocusChangeListener(this);
        this.f13337D.setOnFocusChangeListener(this);
        this.f13338E = (Button) findViewById(R.id.button_comfirm);
        this.f13338E.setOnClickListener(new View$OnClickListenerC2361cg(this));
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.support.p012v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public Object doInBackground(int i) throws C1425f {
        if (i == 200) {
            return this.f13354n.m5259b(this.f13339F, this.f13341H, this.f13342I, this.f13343J);
        }
        return super.doInBackground(i);
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onSuccess(int i, Object obj) {
        boolean z;
        if (i == 200) {
            LoadDialog.m4681b(this);
            if (obj != null) {
                CommonResponse commonResponse = (CommonResponse) obj;
                if (commonResponse.getCode() == 0) {
                    NToast.m9450a(this, (int) R.string.reset_password_succeed);
                    PreferencesManager preferencesManager = this.f13352S;
                    if (preferencesManager != null) {
                        preferencesManager.m9588a("token", "");
                        this.f13352S.m9588a("login_state", "0");
                        this.f13352S.m9588a("if_auto_login", "0");
                        this.f13352S.m9588a("login_password", "");
                        if (!C2787z.m4821a(this.f13340G)) {
                            this.f13352S.m9588a(this.f13340G, "");
                        }
                        this.f13352S.m9588a(this.f13339F, "");
                    }
                    if (this.f10981q != null) {
                        Intent intent = new Intent("RESET_PASSWORD");
                        intent.putExtra("username", this.f13340G);
                        this.f10981q.sendBroadcast(intent);
                    }
                    RegisterInfoRecord registerInfoRecord = new RegisterInfoRecord();
                    this.f13353T = registerInfoRecord.m6546a();
                    if (!this.f13353T.containsKey(this.f13340G) || this.f13341H.equals(this.f13353T.get(this.f13340G))) {
                        z = false;
                    } else {
                        this.f13353T.put(this.f13340G, "");
                        z = true;
                    }
                    if (this.f13353T.containsKey(this.f13339F) && !this.f13341H.equals(this.f13353T.get(this.f13339F))) {
                        this.f13353T.put(this.f13339F, "");
                        z = true;
                    }
                    if (z) {
                        try {
                            NLog.m9451c("weiwell register_onsuccess_map", this.f13353T);
                            String m6543a = RegisterInfoRecord.m6543a(this.f13353T);
                            NLog.m9451c("weiwell register_onsuccess", m6543a);
                            registerInfoRecord.m6544a(m6543a);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    finish();
                } else {
                    int code = commonResponse.getCode();
                    if (code == 110101) {
                        NToast.m9450a(this, (int) R.string.reset_password_fail_prompt_110101);
                    } else if (code == 110201) {
                        NToast.m9450a(this, (int) R.string.reset_password_fail_prompt_110201);
                    } else {
                        NToast.m9450a(this, (int) R.string.reset_password_fail);
                    }
                }
            }
        }
        super.onSuccess(i, obj);
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onFailure(int i, int i2, Object obj) {
        LoadDialog.m4681b(this.f10981q);
        NToast.m9450a(this, (int) R.string.reset_password_fail);
        super.onFailure(i, i2, obj);
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 0) {
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        int id = view.getId();
        if (id == R.id.editText_comfirm_password) {
            if (z) {
                return;
            }
            this.f13341H = this.f13336C.getText().toString();
            this.f13342I = this.f13337D.getText().toString();
            if (!C2787z.m4813f(this.f13341H)) {
                int[] iArr = new int[2];
                this.f13336C.getLocationOnScreen(iArr);
                m6599a(this.f10981q, R.string.register_password_char_error, iArr[0], iArr[1] + 40);
            } else if (this.f13342I.equals(this.f13341H)) {
            } else {
                int[] iArr2 = new int[2];
                this.f13337D.getLocationOnScreen(iArr2);
                m6599a(this.f10981q, R.string.register_password_not_match, iArr2[0], iArr2[1] + 40);
            }
        } else if (id == R.id.editText_password && !z) {
            this.f13341H = this.f13336C.getText().toString();
            this.f13342I = this.f13337D.getText().toString();
            if (this.f13341H.isEmpty() || this.f13341H.equals("")) {
                return;
            }
            if (!C2787z.m4813f(this.f13341H)) {
                int[] iArr3 = new int[2];
                this.f13336C.getLocationOnScreen(iArr3);
                if (this.f13341H.length() > 0 && this.f13341H.length() < 6) {
                    m6599a(this.f10981q, R.string.register_password_is_short, iArr3[0], iArr3[1] + 40);
                    return;
                } else {
                    m6599a(this.f10981q, R.string.register_password_char_error, iArr3[0], iArr3[1] + 40);
                    return;
                }
            }
            String str = this.f13342I;
            if (str == null || str.equals("")) {
                return;
            }
            if (!this.f13342I.equals(this.f13341H) && !this.f13337D.isFocused()) {
                int[] iArr4 = new int[2];
                this.f13337D.getLocationOnScreen(iArr4);
                m6599a(this.f10981q, R.string.register_password_not_match, iArr4[0], iArr4[1] + 40);
            } else if (this.f13341H.equals(this.f13342I)) {
            }
        }
    }

    /* renamed from: a */
    private void m6599a(Context context, int i, int i2, int i3) {
        View inflate = LayoutInflater.from(this).inflate(R.layout.layout_register_toast, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.textView1)).setText(i);
        Toast makeText = Toast.makeText(getApplicationContext(), context.getResources().getString(i), 0);
        makeText.setGravity(51, i2, i3);
        makeText.setView(inflate);
        makeText.show();
    }
}
