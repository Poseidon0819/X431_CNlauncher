package com.cnlaunch.x431pro.activity.login;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.p120d.p130d.p131a.LangManager;
import com.cnlaunch.x431pro.activity.ActivityC2004c;
import com.cnlaunch.x431pro.module.config.ConfigDBManager;
import com.cnlaunch.x431pro.module.p241a.CommonResponse;
import com.cnlaunch.x431pro.module.p272k.p273a.UserAction;
import com.cnlaunch.x431pro.module.p272k.p274b.RegistResponse;
import com.cnlaunch.x431pro.module.p272k.p274b.X431UserDTO_ja;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.utils.C2787z;
import com.cnlaunch.x431pro.utils.PathUtils;
import com.cnlaunch.x431pro.utils.p285e.FileUtils;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.ifoer.expedition.pro.R;
import com.itextpdf.text.pdf.PdfContentParser;
import com.mopub.common.Constants;
import java.io.File;

/* loaded from: classes.dex */
public class RegistActivity_ja extends ActivityC2004c implements View.OnClickListener, View.OnFocusChangeListener {

    /* renamed from: C */
    String f13210C;

    /* renamed from: D */
    String f13211D;

    /* renamed from: E */
    String f13212E;

    /* renamed from: F */
    protected ConfigDBManager f13213F;

    /* renamed from: V */
    private UserAction f13229V;

    /* renamed from: W */
    private EditText f13230W;

    /* renamed from: X */
    private EditText f13231X;

    /* renamed from: Y */
    private EditText f13232Y;

    /* renamed from: Z */
    private EditText f13233Z;

    /* renamed from: aA */
    private String f13234aA;

    /* renamed from: aB */
    private String f13235aB;

    /* renamed from: aC */
    private String f13236aC;

    /* renamed from: aD */
    private String f13237aD;

    /* renamed from: aE */
    private String f13238aE;

    /* renamed from: aF */
    private long f13239aF;

    /* renamed from: aG */
    private String f13240aG;

    /* renamed from: aH */
    private String f13241aH;

    /* renamed from: aI */
    private String f13242aI;

    /* renamed from: aJ */
    private String f13243aJ;

    /* renamed from: aK */
    private String f13244aK;

    /* renamed from: aL */
    private Drawable f13245aL;

    /* renamed from: aM */
    private ImageView f13246aM;

    /* renamed from: aN */
    private TextView f13247aN;

    /* renamed from: aO */
    private TextView f13248aO;

    /* renamed from: aa */
    private EditText f13250aa;

    /* renamed from: ab */
    private EditText f13251ab;

    /* renamed from: ac */
    private EditText f13252ac;

    /* renamed from: ad */
    private EditText f13253ad;

    /* renamed from: ae */
    private EditText f13254ae;

    /* renamed from: af */
    private EditText f13255af;

    /* renamed from: ag */
    private EditText f13256ag;

    /* renamed from: ah */
    private EditText f13257ah;

    /* renamed from: ai */
    private EditText f13258ai;

    /* renamed from: aj */
    private Button f13259aj;

    /* renamed from: ak */
    private Button f13260ak;

    /* renamed from: al */
    private RadioGroup f13261al;

    /* renamed from: an */
    private CheckBox f13263an;

    /* renamed from: ao */
    private CheckBox f13264ao;

    /* renamed from: ap */
    private CheckBox f13265ap;

    /* renamed from: aq */
    private CheckBox f13266aq;

    /* renamed from: ar */
    private CheckBox f13267ar;

    /* renamed from: as */
    private CheckBox f13268as;

    /* renamed from: at */
    private CheckBox f13269at;

    /* renamed from: au */
    private CheckBox f13270au;

    /* renamed from: av */
    private CheckBox f13271av;

    /* renamed from: aw */
    private LinearLayout f13272aw;

    /* renamed from: ax */
    private String f13273ax;

    /* renamed from: ay */
    private String f13274ay;

    /* renamed from: az */
    private String f13275az;

    /* renamed from: n */
    X431UserDTO_ja f13276n;

    /* renamed from: G */
    private final int f13214G = PdfContentParser.COMMAND_TYPE;

    /* renamed from: H */
    private final int f13215H = 201;

    /* renamed from: I */
    private final int f13216I = 202;

    /* renamed from: J */
    private final int f13217J = 203;

    /* renamed from: K */
    private final int f13218K = 0;

    /* renamed from: L */
    private final int f13219L = 1024;

    /* renamed from: M */
    private final int f13220M = 1025;

    /* renamed from: N */
    private final int f13221N = 300001;

    /* renamed from: O */
    private final int f13222O = 300009;

    /* renamed from: P */
    private final int f13223P = 300010;

    /* renamed from: Q */
    private final int f13224Q = 300011;

    /* renamed from: R */
    private final int f13225R = 300012;

    /* renamed from: S */
    private final int f13226S = 300013;

    /* renamed from: T */
    private final int f13227T = 300014;

    /* renamed from: U */
    private final int f13228U = 300015;

    /* renamed from: am */
    private int f13262am = 0;
    @SuppressLint({"HandlerLeak"})

    /* renamed from: aP */
    private Handler f13249aP = new HandlerC2324aw(this);

    /* renamed from: a */
    private void m6681a(Context context, int i, int i2, int i3) {
        View inflate = LayoutInflater.from(this).inflate(R.layout.layout_register_toast, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.textView1)).setText(i);
        Toast makeText = Toast.makeText(getApplicationContext(), context.getResources().getString(i), 0);
        makeText.setGravity(51, i2, i3);
        makeText.setView(inflate);
        makeText.show();
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.support.p012v4.app.FragmentActivity, android.support.p012v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_regist_ja);
        m7743b();
        this.f13211D = "codepic.png";
        this.f13229V = new UserAction(this);
        this.f13230W = (EditText) findViewById(R.id.edit_username);
        this.f13231X = (EditText) findViewById(R.id.edit_password);
        this.f13232Y = (EditText) findViewById(R.id.edit_confirmpass);
        this.f13233Z = (EditText) findViewById(R.id.edit_email);
        this.f13250aa = (EditText) findViewById(R.id.edit_company_name);
        this.f13251ab = (EditText) findViewById(R.id.edit_zipcode);
        this.f13252ac = (EditText) findViewById(R.id.edit_address);
        this.f13253ad = (EditText) findViewById(R.id.edit_realname);
        this.f13258ai = (EditText) findViewById(R.id.edit_identifycode);
        this.f13258ai.setFilters(new InputFilter[]{new InputFilter.LengthFilter(4)});
        this.f13254ae = (EditText) findViewById(R.id.edit_birthday);
        this.f13255af = (EditText) findViewById(R.id.edit_phonenum);
        this.f13256ag = (EditText) findViewById(R.id.edit_fax);
        this.f13257ah = (EditText) findViewById(R.id.edit_cellphone);
        this.f13246aM = (ImageView) findViewById(R.id.image_identifycode);
        String str = PathUtils.m4846j() + this.f13211D;
        if (new File(str).exists()) {
            this.f13245aL = Drawable.createFromPath(str);
        } else {
            try {
                this.f13245aL = Drawable.createFromStream(getAssets().open(this.f13211D), null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.f13246aM.setImageDrawable(this.f13245aL);
        this.f13263an = (CheckBox) findViewById(R.id.iv_username);
        this.f13264ao = (CheckBox) findViewById(R.id.iv_password);
        this.f13265ap = (CheckBox) findViewById(R.id.iv_confirm_password);
        this.f13266aq = (CheckBox) findViewById(R.id.iv_email);
        this.f13267ar = (CheckBox) findViewById(R.id.iv_company_name);
        this.f13268as = (CheckBox) findViewById(R.id.iv_zipcode);
        this.f13269at = (CheckBox) findViewById(R.id.iv_address);
        this.f13271av = (CheckBox) findViewById(R.id.iv_idenfifycode);
        this.f13270au = (CheckBox) findViewById(R.id.iv_phonenum);
        this.f13261al = (RadioGroup) findViewById(R.id.reg_radioGroup);
        this.f13261al.setVisibility(0);
        this.f13261al.setOnCheckedChangeListener(new C2329ba(this));
        this.f13272aw = (LinearLayout) findViewById(R.id.merchant_title);
        if (!C2744aa.m5144h(this.f10981q)) {
            C2744aa.m5129p();
        }
        this.f13272aw.setVisibility(8);
        if (!this.f13263an.isChecked()) {
            m6675b(this.f13263an, 4, false);
        }
        if (!this.f13264ao.isChecked()) {
            m6675b(this.f13264ao, 4, false);
        }
        if (!this.f13265ap.isChecked()) {
            m6675b(this.f13265ap, 4, false);
        }
        if (!this.f13266aq.isChecked()) {
            m6675b(this.f13266aq, 4, false);
        }
        if (!this.f13268as.isChecked()) {
            m6675b(this.f13268as, 4, false);
        }
        if (!this.f13267ar.isChecked()) {
            m6675b(this.f13267ar, 4, false);
        }
        if (!this.f13269at.isChecked()) {
            m6675b(this.f13269at, 4, false);
        }
        if (!this.f13271av.isChecked()) {
            m6675b(this.f13271av, 4, false);
        }
        if (!this.f13270au.isChecked()) {
            m6675b(this.f13270au, 4, false);
        }
        this.f13260ak = (Button) findViewById(R.id.btn_regist);
        this.f13260ak.setEnabled(false);
        this.f13260ak.setOnClickListener(this);
        this.f13259aj = (Button) findViewById(R.id.bt_refresh);
        this.f13259aj.setOnClickListener(this);
        this.f13246aM.setOnClickListener(this);
        this.f13258ai.setOnClickListener(this);
        this.f13230W.setOnFocusChangeListener(this);
        this.f13231X.setOnFocusChangeListener(this);
        this.f13232Y.setOnFocusChangeListener(this);
        this.f13233Z.setOnFocusChangeListener(this);
        this.f13250aa.setOnFocusChangeListener(this);
        this.f13251ab.setOnFocusChangeListener(this);
        this.f13252ac.setOnFocusChangeListener(this);
        this.f13255af.setOnFocusChangeListener(this);
        this.f13230W.addTextChangedListener(new C2330bb(this));
        this.f13231X.addTextChangedListener(new C2331bc(this));
        this.f13232Y.addTextChangedListener(new C2332bd(this));
        this.f13233Z.addTextChangedListener(new C2333be(this));
        this.f13250aa.addTextChangedListener(new C2334bf(this));
        this.f13251ab.addTextChangedListener(new C2335bg(this));
        this.f13252ac.addTextChangedListener(new C2336bh(this));
        this.f13258ai.addTextChangedListener(new C2326ay(this));
        this.f13255af.addTextChangedListener(new C2327az(this));
        this.f13260ak.setEnabled(m6659h());
        this.f13247aN = (TextView) findViewById(R.id.tv_service_agreement);
        this.f13247aN.setOnClickListener(this);
        this.f13247aN.getPaint().setFlags(8);
        this.f13248aO = (TextView) findViewById(R.id.tv_privacy_policy);
        this.f13248aO.setOnClickListener(this);
        this.f13248aO.getPaint().setFlags(8);
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.support.p012v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: h */
    public final boolean m6659h() {
        return this.f13263an.isChecked() && this.f13264ao.isChecked() && this.f13265ap.isChecked() && this.f13266aq.isChecked() && this.f13267ar.isChecked() && this.f13268as.isChecked() && this.f13269at.isChecked() && this.f13271av.isChecked() && this.f13270au.isChecked();
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public Object doInBackground(int i) throws C1425f {
        switch (i) {
            case PdfContentParser.COMMAND_TYPE /* 200 */:
                return this.f13229V.m5264a(this.f13243aJ, this.f13244aK, this.f13274ay, "6021", "nickname", this.f13276n);
            case 201:
                return this.f13229V.m5267a(this.f13273ax, LangManager.m9469a(), "2");
            case 202:
            default:
                return super.doInBackground(i);
            case 203:
                return this.f13229V.m5268a(this.f13273ax, this.f13244aK);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onSuccess(int i, Object obj) {
        switch (i) {
            case PdfContentParser.COMMAND_TYPE /* 200 */:
                LoadDialog.m4681b(this);
                if (obj != null) {
                    RegistResponse registResponse = (RegistResponse) obj;
                    if (registResponse.getCode() == 0) {
                        NToast.m9450a(this, (int) R.string.register_ok);
                        LoginFunction loginFunction = new LoginFunction(this);
                        LoginFunction.m6570e();
                        loginFunction.m6583a(this.f13273ax, this.f13274ay);
                        Intent intent = new Intent(this, ActivateJointActivity.class);
                        intent.putExtra("UserName", this.f13273ax);
                        intent.putExtra("PassWord", this.f13274ay);
                        intent.putExtra("FromRegister", true);
                        startActivity(intent);
                        setResult(-1);
                        if (!C2744aa.m5166c()) {
                            FileUtils.m5000d(PathUtils.m4846j() + this.f13212E);
                        }
                        finish();
                        return;
                    }
                    switch (registResponse.getCode()) {
                        case 1024:
                            NToast.m9450a(this, (int) R.string.register_fail_prompt_1024);
                            break;
                        case 1025:
                            NToast.m9450a(this, (int) R.string.register_fail_prompt_1025);
                            break;
                        case 300001:
                            NToast.m9450a(this, (int) R.string.register_fail_prompt_30001);
                            break;
                        case 300009:
                            NToast.m9450a(this, (int) R.string.register_fail_prompt_30009);
                            break;
                        case 300011:
                            NToast.m9450a(this, (int) R.string.register_fail_prompt_300011);
                        default:
                            NToast.m9450a(this, (int) R.string.register_fail);
                            break;
                    }
                    setResult(0);
                    return;
                }
                return;
            case 201:
                LoadDialog.m4681b(this);
                if (obj != null) {
                    CommonResponse commonResponse = (CommonResponse) obj;
                    if (commonResponse.getCode() == 0) {
                        m6675b(this.f13263an, 0, true);
                        this.f13210C = commonResponse.getData().toString().substring(commonResponse.getData().toString().indexOf(Constants.HTTP), commonResponse.getData().toString().length() - 1);
                        this.f13249aP.sendEmptyMessage(2);
                        return;
                    }
                    int code = commonResponse.getCode();
                    if (code == 10001) {
                        m6675b(this.f13263an, 0, false);
                        this.f13230W.setFocusableInTouchMode(true);
                        this.f13230W.requestFocusFromTouch();
                        int[] iArr = new int[2];
                        this.f13230W.getLocationOnScreen(iArr);
                        m6681a(this, R.string.get_identify_code_fail_prompt_10001, iArr[0], iArr[1] + 40);
                    } else if (code == 30040) {
                        NToast.m9450a(this.f10981q, (int) R.string.more_than_sending_number);
                    } else if (code == 110001) {
                        m6675b(this.f13263an, 0, false);
                        this.f13230W.setFocusableInTouchMode(true);
                        this.f13230W.requestFocusFromTouch();
                        int[] iArr2 = new int[2];
                        this.f13230W.getLocationOnScreen(iArr2);
                        m6681a(this, R.string.get_identify_code_fail_prompt_110001, iArr2[0], iArr2[1] + 40);
                    } else {
                        NToast.m9450a(this, (int) R.string.get_identify_code_fail_prompt);
                    }
                    m6675b(this.f13263an, 0, false);
                    return;
                }
                return;
            case 202:
            default:
                return;
            case 203:
                LoadDialog.m4681b(this);
                if (((CommonResponse) obj).getCode() == 0) {
                    m6675b(this.f13271av, 0, true);
                } else {
                    m6675b(this.f13271av, 0, false);
                    m7739c(201);
                    int[] iArr3 = new int[2];
                    this.f13258ai.getLocationOnScreen(iArr3);
                    m6681a(this, R.string.register_fail_prompt_1025, iArr3[0], iArr3[1] + 40);
                }
                this.f13260ak.setEnabled(m6659h());
                return;
        }
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onFailure(int i, int i2, Object obj) {
        super.onFailure(i, i2, obj);
        switch (i) {
            case PdfContentParser.COMMAND_TYPE /* 200 */:
                setResult(0);
                LoadDialog.m4681b(this);
                return;
            case 201:
                LoadDialog.m4681b(this);
                return;
            case 202:
            default:
                return;
            case 203:
                LoadDialog.m4681b(this);
                m6675b(this.f13271av, 0, false);
                this.f13260ak.setEnabled(m6659h());
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.bt_refresh) {
            this.f13273ax = this.f13230W.getText().toString();
            if (TextUtils.isEmpty(this.f13273ax)) {
                NToast.m9450a(this, (int) R.string.register_input_null);
            } else {
                m7739c(201);
            }
        } else if (id != R.id.btn_regist) {
            if (id == R.id.tv_privacy_policy) {
                m6664f(1);
            } else if (id != R.id.tv_service_agreement) {
            } else {
                m6664f(0);
            }
        } else {
            this.f13243aJ = "207";
            this.f13273ax = this.f13230W.getText().toString();
            this.f13274ay = this.f13231X.getText().toString();
            this.f13275az = this.f13232Y.getText().toString();
            this.f13234aA = this.f13233Z.getText().toString();
            this.f13236aC = this.f13250aa.getText().toString();
            this.f13235aB = this.f13251ab.getText().toString();
            this.f13237aD = this.f13252ac.getText().toString();
            this.f13244aK = this.f13258ai.getText().toString();
            this.f13240aG = this.f13255af.getText().toString();
            this.f13241aH = this.f13256ag.getText().toString();
            this.f13238aE = this.f13253ad.getText().toString();
            this.f13242aI = this.f13257ah.getText().toString();
            String str = this.f13273ax;
            String str2 = this.f13234aA;
            String str3 = this.f13242aI;
            String str4 = this.f13238aE;
            int i = this.f13262am;
            long j = this.f13239aF;
            String str5 = this.f13240aG;
            this.f13276n = new X431UserDTO_ja(str, str2, str3, str4, "", i, j, str5, str5, this.f13241aH, this.f13236aC, this.f13237aD, this.f13235aB);
            if (TextUtils.isEmpty(this.f13273ax)) {
                NToast.m9450a(this, (int) R.string.register_input_null);
            } else if (TextUtils.isEmpty(this.f13274ay)) {
                NToast.m9450a(this, (int) R.string.register_input_null);
            } else if (TextUtils.isEmpty(this.f13275az)) {
                NToast.m9450a(this, (int) R.string.register_input_null);
            } else if (!this.f13274ay.equals(this.f13275az)) {
                NToast.m9450a(this, (int) R.string.register_password_not_match);
            } else if (TextUtils.isEmpty(this.f13234aA)) {
                NToast.m9450a(this, (int) R.string.register_input_null);
            } else if (TextUtils.isEmpty(this.f13236aC)) {
                NToast.m9450a(this, (int) R.string.register_input_null);
            } else if (TextUtils.isEmpty(this.f13235aB)) {
                NToast.m9450a(this, (int) R.string.register_input_null);
            } else if (TextUtils.isEmpty(this.f13237aD)) {
                NToast.m9450a(this, (int) R.string.register_input_null);
            } else if (TextUtils.isEmpty(this.f13244aK)) {
                NToast.m9450a(this, (int) R.string.register_input_null);
            } else if (TextUtils.isEmpty(this.f13240aG)) {
                NToast.m9450a(this, (int) R.string.register_input_null);
            } else {
                LoadDialog.m4686a(this);
                m7739c(PdfContentParser.COMMAND_TYPE);
            }
        }
    }

    /* renamed from: f */
    private void m6664f(int i) {
        String string;
        Intent intent = new Intent(this.f10981q, WebActivity.class);
        if (this.f13213F == null) {
            this.f13213F = ConfigDBManager.m5398a(this.f10981q);
        }
        String str = "";
        if (i == 0) {
            try {
                if (C2744aa.m5160d()) {
                    str = this.f13213F.m5396a("agreement_eu");
                } else if (C2744aa.m5144h(this.f10981q)) {
                    str = this.f13213F.m5396a("agreement_cn");
                } else {
                    str = this.f13213F.m5396a("agreement_all");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (C2787z.m4821a(str)) {
                str = "https://cnzdmycar.x431.com/static/agree/agreemen.html";
            }
            string = getString(R.string.service_agreement);
        } else {
            try {
                if (C2744aa.m5160d()) {
                    str = this.f13213F.m5396a("privacy_policy_eu");
                } else if (C2744aa.m5144h(this.f10981q)) {
                    str = this.f13213F.m5396a("privacy_policy_cn");
                } else {
                    str = this.f13213F.m5396a("privacy_policy_all");
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (C2787z.m4821a(str)) {
                str = "https://cnzdmycar.x431.com/static/agree/privacy_policy.html";
            }
            string = getString(R.string.privacy_policy);
        }
        intent.putExtra("title", string);
        intent.putExtra("urlkey", str);
        startActivity(intent);
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
        switch (view.getId()) {
            case R.id.edit_address /* 2131296910 */:
                if (z) {
                    return;
                }
                this.f13237aD = this.f13252ac.getText().toString();
                String str = this.f13237aD;
                if (str == null || str.equals("")) {
                    int[] iArr = new int[2];
                    this.f13252ac.getLocationOnScreen(iArr);
                    m6681a(this, R.string.register_address_notnull, iArr[0], iArr[1] + 40);
                    return;
                }
                return;
            case R.id.edit_company_name /* 2131296925 */:
                if (z) {
                    return;
                }
                this.f13236aC = this.f13250aa.getText().toString();
                String str2 = this.f13236aC;
                if (str2 == null || str2.equals("")) {
                    int[] iArr2 = new int[2];
                    this.f13250aa.getLocationOnScreen(iArr2);
                    m6681a(this, R.string.register_companyname_notnull, iArr2[0], iArr2[1] + 40);
                    return;
                }
                return;
            case R.id.edit_confirmpass /* 2131296926 */:
                if (z) {
                    return;
                }
                this.f13274ay = this.f13231X.getText().toString();
                this.f13275az = this.f13232Y.getText().toString();
                if (!C2787z.m4813f(this.f13274ay)) {
                    int[] iArr3 = new int[2];
                    this.f13231X.getLocationOnScreen(iArr3);
                    m6681a(this, R.string.register_password_char_error, iArr3[0], iArr3[1] + 40);
                    return;
                } else if (this.f13275az.equals(this.f13274ay)) {
                    return;
                } else {
                    int[] iArr4 = new int[2];
                    this.f13232Y.getLocationOnScreen(iArr4);
                    m6681a(this, R.string.register_password_not_match, iArr4[0], iArr4[1] + 40);
                    return;
                }
            case R.id.edit_email /* 2131296930 */:
                if (z) {
                    return;
                }
                this.f13234aA = this.f13233Z.getText().toString();
                String str3 = this.f13234aA;
                if (str3 == null || str3.equals("") || C2787z.m4816c(this.f13234aA)) {
                    return;
                }
                int[] iArr5 = new int[2];
                this.f13233Z.getLocationOnScreen(iArr5);
                m6681a(this, R.string.register_fail_prompt_30009, iArr5[0], iArr5[1] + 40);
                return;
            case R.id.edit_password /* 2131296949 */:
                if (z) {
                    return;
                }
                this.f13274ay = this.f13231X.getText().toString();
                this.f13275az = this.f13232Y.getText().toString();
                if (this.f13274ay.isEmpty() || this.f13274ay.equals("")) {
                    return;
                }
                if (!C2787z.m4813f(this.f13274ay)) {
                    int[] iArr6 = new int[2];
                    this.f13231X.getLocationOnScreen(iArr6);
                    if (this.f13274ay.length() > 0 && this.f13274ay.length() < 6) {
                        m6681a(this, R.string.register_password_is_short, iArr6[0], iArr6[1] + 40);
                        return;
                    } else {
                        m6681a(this, R.string.register_password_char_error, iArr6[0], iArr6[1] + 40);
                        return;
                    }
                }
                String str4 = this.f13275az;
                if (str4 == null || str4.equals("")) {
                    return;
                }
                if (!this.f13275az.equals(this.f13274ay) && !this.f13232Y.isFocused()) {
                    int[] iArr7 = new int[2];
                    this.f13232Y.getLocationOnScreen(iArr7);
                    m6681a(this, R.string.register_password_not_match, iArr7[0], iArr7[1] + 40);
                    return;
                } else if (this.f13274ay.equals(this.f13275az)) {
                    return;
                } else {
                    return;
                }
            case R.id.edit_phonenum /* 2131296952 */:
                if (z) {
                    return;
                }
                this.f13240aG = this.f13255af.getText().toString();
                String str5 = this.f13240aG;
                if (str5 == null || str5.equals("")) {
                    int[] iArr8 = new int[2];
                    this.f13255af.getLocationOnScreen(iArr8);
                    m6681a(this, R.string.register_phonenum_notnull, iArr8[0], iArr8[1] + 40);
                    return;
                }
                return;
            case R.id.edit_username /* 2131296976 */:
                if (z) {
                    return;
                }
                String obj = this.f13230W.getText().toString();
                if (C2787z.m4809j(obj).booleanValue()) {
                    this.f13273ax = obj;
                    if (this.f13271av.isChecked()) {
                        return;
                    }
                    m7739c(201);
                    return;
                } else if (obj.length() == 0) {
                    int[] iArr9 = new int[2];
                    this.f13230W.getLocationOnScreen(iArr9);
                    m6681a(this, R.string.login_input_username, iArr9[0], iArr9[1] + 40);
                    return;
                } else if (obj.length() < 5) {
                    int[] iArr10 = new int[2];
                    this.f13230W.getLocationOnScreen(iArr10);
                    m6681a(this, R.string.register_username_short, iArr10[0], iArr10[1] + 40);
                    return;
                } else {
                    int[] iArr11 = new int[2];
                    this.f13230W.getLocationOnScreen(iArr11);
                    m6681a(this, R.string.register_username_format, iArr11[0], iArr11[1] + 40);
                    return;
                }
            case R.id.edit_zipcode /* 2131296980 */:
                if (z) {
                    return;
                }
                this.f13235aB = this.f13251ab.getText().toString();
                if (this.f13235aB.length() == 0) {
                    int[] iArr12 = new int[2];
                    this.f13251ab.getLocationOnScreen(iArr12);
                    m6681a(this, R.string.register_input_zipcode, iArr12[0], iArr12[1] + 40);
                    return;
                } else if (this.f13235aB.length() < 7) {
                    int[] iArr13 = new int[2];
                    this.f13251ab.getLocationOnScreen(iArr13);
                    m6681a(this, R.string.register_fail_prompt_300011, iArr13[0], iArr13[1] + 40);
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m6675b(CheckBox checkBox, int i, boolean z) {
        checkBox.setVisibility(i);
        checkBox.setChecked(z);
        checkBox.setClickable(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public static /* synthetic */ boolean m6670c(String str) {
        Boolean bool = Boolean.FALSE;
        return str.matches("^(\\d{3}[ -]\\d{4})$") || str.matches("^(\\d{7})$");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public static /* synthetic */ boolean m6667d(String str) {
        Boolean bool = Boolean.FALSE;
        return str.matches("^(\\(\\d{3}\\)\\d{3}-?\\d{4})|([0]\\d{1,3}-\\d{4}-\\d{4})|(\\d{9,12})|([\\d\\-]{10,12})$");
    }
}
