package com.cnlaunch.x431pro.activity.login;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.baidu.mapapi.UIMsg;
import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceConstant;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.p120d.p130d.p131a.LangManager;
import com.cnlaunch.x431pro.activity.ActivityC2004c;
import com.cnlaunch.x431pro.module.p241a.CommonResponse;
import com.cnlaunch.x431pro.module.p272k.p273a.UserAction;
import com.cnlaunch.x431pro.module.p272k.p274b.UserBaseInfo;
import com.cnlaunch.x431pro.module.p272k.p274b.UserBaseInfoResponse;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.utils.C2787z;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class FindPasswordActivity extends ActivityC2004c implements View.OnClickListener {

    /* renamed from: G */
    private long f13050G;

    /* renamed from: U */
    private UserAction f13064U;

    /* renamed from: V */
    private EditText f13065V;

    /* renamed from: W */
    private EditText f13066W;

    /* renamed from: X */
    private EditText f13067X;

    /* renamed from: Y */
    private EditText f13068Y;

    /* renamed from: Z */
    private Spinner f13069Z;

    /* renamed from: aa */
    private TextView f13070aa;

    /* renamed from: ab */
    private Button f13071ab;

    /* renamed from: ac */
    private Button f13072ac;

    /* renamed from: ad */
    private String f13073ad;

    /* renamed from: ae */
    private String f13074ae;

    /* renamed from: af */
    private String f13075af;

    /* renamed from: ag */
    private String f13076ag;

    /* renamed from: ah */
    private String f13077ah;

    /* renamed from: ai */
    private int f13078ai;

    /* renamed from: aj */
    private UserBaseInfo f13079aj;

    /* renamed from: ak */
    private ArrayList<String> f13080ak;

    /* renamed from: al */
    private ArrayAdapter<String> f13081al;

    /* renamed from: am */
    private boolean f13082am;

    /* renamed from: an */
    private boolean f13083an;

    /* renamed from: C */
    private final int f13046C = 201;

    /* renamed from: D */
    private final int f13047D = 202;

    /* renamed from: E */
    private final int f13048E = 203;

    /* renamed from: F */
    private final int f13049F = 1;

    /* renamed from: H */
    private final int f13051H = 1022;

    /* renamed from: I */
    private final int f13052I = 1023;

    /* renamed from: J */
    private final int f13053J = HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_QUERY_OPTIONS_NULL;

    /* renamed from: K */
    private final int f13054K = 0;

    /* renamed from: L */
    private final int f13055L = 110001;

    /* renamed from: M */
    private final int f13056M = 110002;

    /* renamed from: N */
    private final int f13057N = 30009;

    /* renamed from: O */
    private final int f13058O = 110003;

    /* renamed from: P */
    private final int f13059P = 30031;

    /* renamed from: Q */
    private final int f13060Q = UIMsg.f_FUN.FUN_ID_SCH_POI_OPTION;

    /* renamed from: R */
    private final int f13061R = 0;

    /* renamed from: S */
    private final int f13062S = 1;

    /* renamed from: T */
    private final int f13063T = 12;

    /* renamed from: n */
    CountDownTimer f13084n = new CountDownTimerC2378u(this);

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.support.p012v4.app.FragmentActivity, android.support.p012v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_findpassword);
        this.f13064U = new UserAction(this);
        this.f13073ad = getIntent().getExtras().getString("username");
        this.f13080ak = new ArrayList<>();
        this.f13080ak.add(0, getString(R.string.retrieve_password_phone_way));
        this.f13080ak.add(1, getString(R.string.retrieve_password_email_way));
        if (!C2744aa.m5125r()) {
            this.f13078ai = 1;
        } else {
            this.f13078ai = 0;
        }
        this.f13082am = false;
        this.f13082am = false;
        this.f13081al = new ArrayAdapter<>(this.f10981q, (int) R.layout.spinner_checked, this.f13080ak);
        this.f13081al.setDropDownViewResource(R.layout.spinner_dropdown);
        this.f13079aj = null;
        this.f10985u.setVisibility(8);
        this.f13071ab = (Button) findViewById(R.id.btn_getvcode);
        this.f13071ab.setOnClickListener(this);
        this.f13072ac = (Button) findViewById(R.id.btn_findpass);
        this.f13072ac.setOnClickListener(this);
        this.f13072ac.setEnabled(false);
        this.f13065V = (EditText) findViewById(R.id.edit_sn);
        this.f13065V.addTextChangedListener(new C2374q(this));
        this.f13070aa = (TextView) findViewById(R.id.tips);
        if (!"CN".equals(LangManager.m9466b())) {
            this.f13070aa.setText(R.string.retrieve_password_tips_oversea);
        } else {
            this.f13070aa.setText(R.string.retrieve_password_tips);
        }
        this.f13066W = (EditText) findViewById(R.id.edit_username);
        this.f13067X = (EditText) findViewById(R.id.edit_phoneoremail);
        this.f13068Y = (EditText) findViewById(R.id.edit_retrieve_code);
        this.f13068Y.setEnabled(false);
        this.f13068Y.addTextChangedListener(new C2375r(this));
        this.f13069Z = (Spinner) findViewById(R.id.spinner_retrieve_way);
        this.f13069Z.setAdapter((SpinnerAdapter) this.f13081al);
        this.f13069Z.setOnItemSelectedListener(new C2376s(this));
        if (!C2744aa.m5125r()) {
            this.f13069Z.setVisibility(8);
            this.f13067X.setText(R.string.retrieve_password_email);
            this.f13071ab.setText(R.string.retrieve_password_get_code_email);
        }
        this.f13065V.setOnEditorActionListener(new C2377t(this));
        m7743b();
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public Object doInBackground(int i) throws C1425f {
        UserAction userAction = this.f13064U;
        if (userAction != null) {
            switch (i) {
                case 201:
                    return userAction.m5253d(LangManager.m9469a(), this.f13074ae);
                case 202:
                    return userAction.m5266a(this.f13076ag, LangManager.m9469a(), "3", null);
                case 203:
                    return userAction.m5268a(this.f13076ag, this.f13077ah);
            }
        }
        return super.doInBackground(i);
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onSuccess(int i, Object obj) {
        switch (i) {
            case 201:
                if (obj != null) {
                    UserBaseInfoResponse userBaseInfoResponse = (UserBaseInfoResponse) obj;
                    if (userBaseInfoResponse.getCode() == 0) {
                        this.f13079aj = userBaseInfoResponse.getData();
                        UserBaseInfo userBaseInfo = this.f13079aj;
                        if (userBaseInfo != null) {
                            if (userBaseInfo.getIs_bind_mobile().intValue() == 1) {
                                this.f13083an = true;
                            } else {
                                this.f13083an = false;
                            }
                            if (this.f13079aj.getIs_bind_email().intValue() == 1) {
                                this.f13082am = true;
                            } else {
                                this.f13082am = false;
                            }
                            if (this.f13083an || this.f13082am) {
                                NToast.m9450a(this.f10981q, (int) R.string.retrieve_password_phone_or_email_got);
                            } else {
                                NToast.m9450a(this.f10981q, (int) R.string.retrieve_password_phone_and_email_null);
                            }
                            if (this.f13078ai == 0) {
                                if (this.f13083an) {
                                    this.f13067X.setText(this.f13079aj.getMobile());
                                } else {
                                    this.f13067X.setText(R.string.retrieve_password_phone);
                                }
                            } else if (this.f13082am) {
                                this.f13067X.setText(this.f13079aj.getEmail());
                            } else {
                                this.f13067X.setText(R.string.retrieve_password_email);
                            }
                            if (!C2787z.m4821a(this.f13079aj.getUser_name())) {
                                this.f13066W.setText(this.f13079aj.getUser_name());
                                return;
                            } else {
                                this.f13066W.setText("");
                                return;
                            }
                        } else if (this.f13078ai == 0) {
                            this.f13067X.setText(R.string.retrieve_password_phone);
                            return;
                        } else {
                            this.f13067X.setText(R.string.retrieve_password_email);
                            return;
                        }
                    }
                    this.f13079aj = null;
                    if (this.f13078ai == 0) {
                        this.f13067X.setText(R.string.retrieve_password_phone);
                    } else {
                        this.f13067X.setText(R.string.retrieve_password_email);
                    }
                    this.f13066W.setText("");
                    return;
                }
                return;
            case 202:
                LoadDialog.m4681b(this);
                if (obj != null) {
                    CommonResponse commonResponse = (CommonResponse) obj;
                    if (commonResponse.getCode() == 0) {
                        CountDownTimer countDownTimer = this.f13084n;
                        if (countDownTimer != null) {
                            countDownTimer.start();
                        }
                        if (this.f13078ai == 1) {
                            NToast.m9447b(this, (int) R.string.identify_send_to_email);
                            return;
                        } else {
                            NToast.m9446b(this, getString(R.string.mine_set_verify_phone_tips, new Object[]{this.f13076ag}));
                            return;
                        }
                    }
                    int code = commonResponse.getCode();
                    if (code == 10001) {
                        NToast.m9450a(this, (int) R.string.get_identify_code_fail_prompt_10001);
                        return;
                    } else if (code == 30009) {
                        NToast.m9450a(this, (int) R.string.get_identify_code_fail_prompt_30009);
                        return;
                    } else if (code == 30031) {
                        NToast.m9450a(this.f10981q, (int) R.string.retrieve_password_operate_frequently);
                        return;
                    } else if (code != 30040) {
                        switch (code) {
                            case 110001:
                                NToast.m9450a(this, (int) R.string.get_identify_code_fail_prompt_110001);
                                return;
                            case 110002:
                                NToast.m9450a(this, (int) R.string.get_identify_code_fail_prompt_110002);
                                return;
                            default:
                                NToast.m9450a(this, (int) R.string.get_identify_code_fail_prompt);
                                return;
                        }
                    } else {
                        NToast.m9450a(this.f10981q, (int) R.string.more_than_sending_number);
                        return;
                    }
                }
                return;
            case 203:
                LoadDialog.m4681b(this);
                if (obj != null) {
                    CommonResponse commonResponse2 = (CommonResponse) obj;
                    if (commonResponse2.getCode() == 0) {
                        this.f13072ac.setEnabled(true);
                        return;
                    } else if (commonResponse2.getCode() != 110101) {
                        return;
                    } else {
                        NToast.m9450a(this, (int) R.string.reset_password_fail_prompt_110101);
                        return;
                    }
                }
                return;
            default:
                return;
        }
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onFailure(int i, int i2, Object obj) {
        super.onFailure(i, i2, obj);
        switch (i) {
            case 201:
                this.f13079aj = null;
                if (this.f13078ai == 0) {
                    this.f13067X.setText(R.string.retrieve_password_phone);
                } else {
                    this.f13067X.setText(R.string.retrieve_password_email);
                }
                this.f13066W.setText("");
                return;
            case 202:
                LoadDialog.m4681b(this);
                return;
            case 203:
                LoadDialog.m4681b(this);
                return;
            default:
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_findpass) {
            this.f13075af = this.f13066W.getText().toString();
            this.f13076ag = this.f13067X.getText().toString();
            this.f13077ah = this.f13068Y.getText().toString();
            if (TextUtils.isEmpty(this.f13076ag) || TextUtils.isEmpty(this.f13077ah)) {
                return;
            }
            Intent intent = new Intent(this, ResetPasswordActivity.class);
            intent.putExtra("username", this.f13075af);
            intent.putExtra("phone_or_mail", this.f13076ag);
            intent.putExtra("Vcode", this.f13077ah);
            startActivity(intent);
            finish();
        } else if (id != R.id.btn_getvcode) {
        } else {
            this.f13068Y.setEnabled(true);
            this.f13076ag = this.f13067X.getText().toString();
            if (C2787z.m4816c(this.f13076ag) || C2787z.m4811h(this.f13076ag)) {
                LoadDialog.m4686a(this.f10981q);
                m7739c(202);
                return;
            }
            int i = this.f13078ai;
            if (1 == i) {
                NToast.m9450a(this, (int) R.string.retrieve_password_email_null);
            } else if (i == 0) {
                NToast.m9450a(this, (int) R.string.retrieve_password_phone_null);
            }
        }
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.support.p012v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 0) {
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
