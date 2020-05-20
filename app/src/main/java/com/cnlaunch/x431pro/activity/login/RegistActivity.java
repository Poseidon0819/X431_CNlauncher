package com.cnlaunch.x431pro.activity.login;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.p120d.p130d.p131a.LangManager;
import com.cnlaunch.x431pro.activity.ActivityC2004c;
import com.cnlaunch.x431pro.module.config.ConfigDBManager;
import com.cnlaunch.x431pro.module.p241a.CommonResponse;
import com.cnlaunch.x431pro.module.p272k.p273a.UserAction;
import com.cnlaunch.x431pro.module.p272k.p274b.Country;
import com.cnlaunch.x431pro.module.p272k.p274b.CountryListResponse;
import com.cnlaunch.x431pro.module.p272k.p274b.RegistResponse;
import com.cnlaunch.x431pro.module.p272k.p274b.UserAccountCheckedInfoResponse;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.utils.C2787z;
import com.cnlaunch.x431pro.utils.PathUtils;
import com.cnlaunch.x431pro.utils.p285e.FileUtils;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.cnlaunch.x431pro.widget.p290a.MessageDialog;
import com.ifoer.expedition.pro.R;
import com.itextpdf.text.pdf.PdfContentParser;
import com.mopub.common.Constants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

/* loaded from: classes.dex */
public class RegistActivity extends ActivityC2004c implements View.OnClickListener, View.OnFocusChangeListener {

    /* renamed from: aA */
    private LinearLayout f13131aA;

    /* renamed from: aB */
    private LinearLayout f13132aB;

    /* renamed from: aC */
    private LinearLayout f13133aC;

    /* renamed from: aD */
    private LinearLayout f13134aD;

    /* renamed from: aE */
    private LinearLayout f13135aE;

    /* renamed from: aF */
    private LinearLayout f13136aF;

    /* renamed from: aG */
    private LinearLayout f13137aG;

    /* renamed from: aH */
    private CheckBox f13138aH;

    /* renamed from: aI */
    private CheckBox f13139aI;

    /* renamed from: aJ */
    private CheckBox f13140aJ;

    /* renamed from: aK */
    private CheckBox f13141aK;

    /* renamed from: aL */
    private CheckBox f13142aL;

    /* renamed from: aM */
    private CheckBox f13143aM;

    /* renamed from: aN */
    private CheckBox f13144aN;

    /* renamed from: aO */
    private CheckBox f13145aO;

    /* renamed from: aP */
    private CheckBox f13146aP;

    /* renamed from: aQ */
    private CheckBox f13147aQ;

    /* renamed from: aR */
    private CheckBox f13148aR;

    /* renamed from: aS */
    private CheckBox f13149aS;

    /* renamed from: aT */
    private CheckBox f13150aT;

    /* renamed from: aU */
    private String f13151aU;

    /* renamed from: aV */
    private String f13152aV;

    /* renamed from: aW */
    private String f13153aW;

    /* renamed from: aX */
    private String f13154aX;

    /* renamed from: aY */
    private String f13155aY;

    /* renamed from: aZ */
    private String f13156aZ;

    /* renamed from: ab */
    private UserAction f13158ab;

    /* renamed from: ac */
    private EditText f13159ac;

    /* renamed from: ad */
    private EditText f13160ad;

    /* renamed from: ae */
    private EditText f13161ae;

    /* renamed from: af */
    private EditText f13162af;

    /* renamed from: ag */
    private Spinner f13163ag;

    /* renamed from: ah */
    private EditText f13164ah;

    /* renamed from: ai */
    private EditText f13165ai;

    /* renamed from: aj */
    private ImageView f13166aj;

    /* renamed from: ak */
    private Button f13167ak;

    /* renamed from: al */
    private Button f13168al;

    /* renamed from: am */
    private Button f13169am;

    /* renamed from: an */
    private EditText f13170an;

    /* renamed from: ao */
    private EditText f13171ao;

    /* renamed from: ap */
    private EditText f13172ap;

    /* renamed from: aq */
    private EditText f13173aq;

    /* renamed from: ar */
    private EditText f13174ar;

    /* renamed from: as */
    private EditText f13175as;

    /* renamed from: at */
    private EditText f13176at;

    /* renamed from: au */
    private TextView f13177au;

    /* renamed from: av */
    private TextView f13178av;

    /* renamed from: aw */
    private TextView f13179aw;

    /* renamed from: ax */
    private TextView f13180ax;

    /* renamed from: ay */
    private LinearLayout f13181ay;

    /* renamed from: az */
    private LinearLayout f13182az;

    /* renamed from: ba */
    private String f13183ba;

    /* renamed from: bb */
    private String f13184bb;

    /* renamed from: bc */
    private String f13185bc;

    /* renamed from: bd */
    private String f13186bd;

    /* renamed from: be */
    private String f13187be;

    /* renamed from: bf */
    private String f13188bf;

    /* renamed from: bg */
    private String f13189bg;

    /* renamed from: bh */
    private Drawable f13190bh;

    /* renamed from: bi */
    private String f13191bi;

    /* renamed from: bj */
    private ArrayList<Country> f13192bj;

    /* renamed from: bl */
    private ArrayAdapter<String> f13194bl;

    /* renamed from: bm */
    private String f13195bm;

    /* renamed from: bn */
    private String f13196bn;

    /* renamed from: bo */
    private String f13197bo;

    /* renamed from: bp */
    private Country f13198bp;

    /* renamed from: bq */
    private TextView f13199bq;

    /* renamed from: br */
    private TextView f13200br;

    /* renamed from: bt */
    private ArrayAdapter<String> f13202bt;

    /* renamed from: n */
    protected ConfigDBManager f13209n;

    /* renamed from: E */
    private final int f13109E = PdfContentParser.COMMAND_TYPE;

    /* renamed from: F */
    private final int f13110F = 201;

    /* renamed from: G */
    private final int f13111G = 2011;

    /* renamed from: H */
    private final int f13112H = 202;

    /* renamed from: I */
    private final int f13113I = 203;

    /* renamed from: J */
    private final int f13114J = 2031;

    /* renamed from: K */
    private final int f13115K = 204;

    /* renamed from: L */
    private final int f13116L = 0;

    /* renamed from: M */
    private final int f13117M = 1024;

    /* renamed from: N */
    private final int f13118N = 1025;

    /* renamed from: O */
    private final int f13119O = 30001;

    /* renamed from: P */
    private final int f13120P = 30002;

    /* renamed from: Q */
    private final int f13121Q = 30003;

    /* renamed from: R */
    private final int f13122R = 30006;

    /* renamed from: S */
    private final int f13123S = 30007;

    /* renamed from: T */
    private final int f13124T = 30009;

    /* renamed from: U */
    private final int f13125U = 30010;

    /* renamed from: V */
    private final int f13126V = 30011;

    /* renamed from: W */
    private final int f13127W = 30012;

    /* renamed from: X */
    private final int f13128X = 30013;

    /* renamed from: Y */
    private final int f13129Y = 30014;

    /* renamed from: Z */
    private final int f13130Z = 30015;

    /* renamed from: aa */
    private final int f13157aa = 30027;

    /* renamed from: bk */
    private ArrayList<String> f13193bk = new ArrayList<>();

    /* renamed from: bs */
    private ArrayList<String> f13201bs = new ArrayList<>();

    /* renamed from: bu */
    private int f13203bu = -1;

    /* renamed from: C */
    HashMap<String, String> f13107C = new HashMap<>();

    /* renamed from: bv */
    private final int f13204bv = 1;

    /* renamed from: bw */
    private final int f13205bw = 2;

    /* renamed from: bx */
    private final int f13206bx = 3;

    /* renamed from: by */
    private final int f13207by = 4;
    @SuppressLint({"HandlerLeak"})

    /* renamed from: bz */
    private Handler f13208bz = new HandlerC2306ae(this);

    /* renamed from: D */
    CountDownTimer f13108D = new CountDownTimerC2315an(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m6734a(Context context, int i, int i2, int i3) {
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
        setContentView(R.layout.layout_regist);
        m7743b();
        this.f13158ab = new UserAction(this.f10981q);
        this.f13196bn = "codepic.png";
        this.f13197bo = "countryInfo.ini";
        this.f13159ac = (EditText) findViewById(R.id.edit_username);
        this.f13164ah = (EditText) findViewById(R.id.edit_zipcode);
        this.f13162af = (EditText) findViewById(R.id.edit_email);
        this.f13160ad = (EditText) findViewById(R.id.edit_password);
        this.f13161ae = (EditText) findViewById(R.id.edit_confirmpass);
        this.f13165ai = (EditText) findViewById(R.id.edit_identifycode);
        this.f13165ai.setFilters(new InputFilter[]{new InputFilter.LengthFilter(4)});
        this.f13163ag = (Spinner) findViewById(R.id.country);
        this.f13198bp = null;
        this.f13170an = (EditText) findViewById(R.id.edit_company);
        this.f13171ao = (EditText) findViewById(R.id.edit_contact);
        this.f13172ap = (EditText) findViewById(R.id.edit_address);
        this.f13173aq = (EditText) findViewById(R.id.edit_phone);
        this.f13174ar = (EditText) findViewById(R.id.edit_qq);
        this.f13175as = (EditText) findViewById(R.id.edit_weixin);
        this.f13176at = (EditText) findViewById(R.id.edit_phoneidentifycode);
        this.f13177au = (TextView) findViewById(R.id.tv_phone);
        this.f13178av = (TextView) findViewById(R.id.tv_qq);
        this.f13179aw = (TextView) findViewById(R.id.tv_weixin);
        this.f13180ax = (TextView) findViewById(R.id.tv_phoneidentifycode);
        this.f13181ay = (LinearLayout) findViewById(R.id.linearl_company);
        this.f13182az = (LinearLayout) findViewById(R.id.linearl_contact);
        this.f13131aA = (LinearLayout) findViewById(R.id.linearl_address);
        this.f13132aB = (LinearLayout) findViewById(R.id.linearl_phone);
        this.f13133aC = (LinearLayout) findViewById(R.id.linearl_qq);
        this.f13134aD = (LinearLayout) findViewById(R.id.linearl_weixin);
        this.f13135aE = (LinearLayout) findViewById(R.id.linearl_phoneidentifycode);
        this.f13136aF = (LinearLayout) findViewById(R.id.linearl_identifycode);
        this.f13137aG = (LinearLayout) findViewById(R.id.merchant_title);
        if (!C2744aa.m5144h(this.f10981q)) {
            C2744aa.m5129p();
        }
        this.f13137aG.setVisibility(8);
        if (!C2744aa.m5166c() || C2744aa.m5145h()) {
            this.f13164ah.setVisibility(8);
            String str = PathUtils.m4846j() + this.f13197bo;
            if (new File(str).exists()) {
                this.f13198bp = m6722c(str);
                this.f13201bs.clear();
                this.f13201bs.add(this.f13198bp.getDisplay());
                this.f13188bf = this.f13198bp.getNcode();
            }
        }
        this.f13208bz.sendEmptyMessage(4);
        this.f13138aH = (CheckBox) findViewById(R.id.iv_username);
        this.f13139aI = (CheckBox) findViewById(R.id.iv_password);
        this.f13140aJ = (CheckBox) findViewById(R.id.iv_confirm_password);
        this.f13141aK = (CheckBox) findViewById(R.id.iv_email);
        this.f13142aL = (CheckBox) findViewById(R.id.iv_zipcode);
        this.f13143aM = (CheckBox) findViewById(R.id.iv_idenfifycode);
        this.f13166aj = (ImageView) findViewById(R.id.image_identifycode);
        String str2 = PathUtils.m4846j() + this.f13196bn;
        if (new File(str2).exists()) {
            this.f13190bh = Drawable.createFromPath(str2);
        } else {
            try {
                this.f13190bh = Drawable.createFromStream(getAssets().open(this.f13196bn), null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.f13166aj.setImageDrawable(this.f13190bh);
        this.f13144aN = (CheckBox) findViewById(R.id.iv_company);
        this.f13146aP = (CheckBox) findViewById(R.id.iv_address);
        this.f13145aO = (CheckBox) findViewById(R.id.iv_contact);
        this.f13147aQ = (CheckBox) findViewById(R.id.iv_phone);
        this.f13148aR = (CheckBox) findViewById(R.id.iv_qq);
        this.f13149aS = (CheckBox) findViewById(R.id.iv_weixin);
        this.f13150aT = (CheckBox) findViewById(R.id.iv_phoneidenfifycode);
        if (!this.f13138aH.isChecked()) {
            m6728b(this.f13138aH, 4, false);
        }
        if (!this.f13139aI.isChecked()) {
            m6728b(this.f13139aI, 4, false);
        }
        if (!this.f13140aJ.isChecked()) {
            m6728b(this.f13140aJ, 4, false);
        }
        if (!this.f13141aK.isChecked()) {
            m6728b(this.f13141aK, 4, false);
        }
        if (!this.f13142aL.isChecked()) {
            m6728b(this.f13142aL, 4, false);
        }
        if (!this.f13143aM.isChecked()) {
            m6728b(this.f13143aM, 4, false);
        }
        if (!this.f13144aN.isChecked()) {
            m6728b(this.f13144aN, 4, false);
        }
        if (!this.f13146aP.isChecked()) {
            m6728b(this.f13146aP, 4, false);
        }
        if (!this.f13145aO.isChecked()) {
            m6728b(this.f13145aO, 4, false);
        }
        if (!this.f13147aQ.isChecked()) {
            m6728b(this.f13147aQ, 4, false);
        }
        if (!this.f13148aR.isChecked()) {
            m6728b(this.f13148aR, 4, false);
        }
        if (!this.f13149aS.isChecked()) {
            m6728b(this.f13149aS, 4, false);
        }
        if (!this.f13150aT.isChecked()) {
            m6728b(this.f13150aT, 4, false);
        }
        this.f13167ak = (Button) findViewById(R.id.bt_refresh);
        this.f13167ak.setOnClickListener(this);
        this.f13168al = (Button) findViewById(R.id.btn_regist);
        this.f13168al.setEnabled(false);
        this.f13168al.setOnClickListener(this);
        this.f13169am = (Button) findViewById(R.id.bt_getcode);
        this.f13169am.setOnClickListener(this);
        this.f13166aj.setOnClickListener(this);
        this.f13165ai.setOnClickListener(this);
        this.f13159ac.setOnFocusChangeListener(this);
        this.f13160ad.setOnFocusChangeListener(this);
        this.f13161ae.setOnFocusChangeListener(this);
        this.f13162af.setOnFocusChangeListener(this);
        this.f13164ah.setOnFocusChangeListener(this);
        this.f13165ai.setOnFocusChangeListener(this);
        this.f13176at.setOnFocusChangeListener(this);
        this.f13151aU = this.f13159ac.getText().toString();
        this.f13152aV = this.f13160ad.getText().toString();
        this.f13153aW = this.f13161ae.getText().toString();
        this.f13154aX = this.f13162af.getText().toString();
        this.f13155aY = this.f13164ah.getText().toString();
        this.f13159ac.addTextChangedListener(new C2316ao(this));
        this.f13160ad.addTextChangedListener(new C2317ap(this));
        this.f13161ae.addTextChangedListener(new C2318aq(this));
        this.f13162af.addTextChangedListener(new C2319ar(this));
        this.f13164ah.addTextChangedListener(new C2320as(this));
        this.f13165ai.addTextChangedListener(new C2321at(this));
        this.f13176at.addTextChangedListener(new C2322au(this));
        this.f13170an.addTextChangedListener(new C2323av(this));
        this.f13172ap.addTextChangedListener(new C2308ag(this));
        this.f13171ao.addTextChangedListener(new C2309ah(this));
        this.f13173aq.addTextChangedListener(new C2310ai(this));
        this.f13174ar.addTextChangedListener(new C2311aj(this));
        this.f13175as.addTextChangedListener(new C2312ak(this));
        this.f13163ag.setOnItemSelectedListener(new C2313al(this));
        this.f13163ag.setOnTouchListener(new View$OnTouchListenerC2314am(this));
        if (C2744aa.m5125r()) {
            this.f13136aF.setVisibility(8);
            this.f13143aM.setChecked(true);
        } else {
            this.f13181ay.setVisibility(8);
            this.f13182az.setVisibility(8);
            this.f13131aA.setVisibility(8);
            this.f13132aB.setVisibility(8);
            this.f13133aC.setVisibility(8);
            this.f13134aD.setVisibility(8);
            this.f13135aE.setVisibility(8);
            this.f13177au.setVisibility(4);
            this.f13178av.setVisibility(4);
            this.f13179aw.setVisibility(4);
            this.f13147aQ.setChecked(true);
            this.f13148aR.setChecked(true);
            this.f13149aS.setChecked(true);
            this.f13150aT.setChecked(true);
        }
        this.f13168al.setEnabled(m6712h());
        if (PreferencesManager.m9595a(this.f10981q).m9583b("REGIST_SHOWTIPS", false)) {
            new MessageDialog(this.f10981q).m4670a(R.string.common_title_tips, R.string.register_tips);
            PreferencesManager.m9595a(this.f10981q).m9587a("REGIST_SHOWTIPS", false);
        }
        if (C2744aa.m5151f() && !TextUtils.isEmpty(this.f13188bf) && (this.f13188bf.equalsIgnoreCase("325") || this.f13188bf.equalsIgnoreCase("235") || this.f13188bf.equalsIgnoreCase("137"))) {
            this.f13164ah.setVisibility(0);
            m6709i();
        }
        this.f13199bq = (TextView) findViewById(R.id.tv_service_agreement);
        this.f13199bq.setOnClickListener(this);
        this.f13199bq.getPaint().setFlags(8);
        this.f13199bq.getPaint().setAntiAlias(true);
        this.f13200br = (TextView) findViewById(R.id.tv_privacy_policy);
        this.f13200br.setOnClickListener(this);
        this.f13200br.getPaint().setFlags(8);
        this.f13200br.getPaint().setAntiAlias(true);
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.support.p012v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (C2744aa.m5166c()) {
            m7739c(202);
        }
        this.f13203bu = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public boolean m6712h() {
        if (this.f13138aH.isChecked() && this.f13139aI.isChecked() && this.f13140aJ.isChecked() && this.f13141aK.isChecked()) {
            return (!C2744aa.m5166c() || C2744aa.m5145h() || this.f13142aL.isChecked()) && this.f13143aM.isChecked() && this.f13147aQ.isChecked() && this.f13150aT.isChecked();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m6709i() {
        this.f13155aY = this.f13164ah.getText().toString();
        if (this.f13155aY.length() >= 6 && !C2787z.m4807l(this.f13155aY)) {
            String str = this.f13155aY.substring(0, 3) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.f13155aY.substring(3);
            if (C2787z.m4807l(str)) {
                this.f13164ah.setText(str);
            }
        }
        this.f13155aY = this.f13164ah.getText().toString();
        if (this.f13155aY.length() == 0) {
            m6728b(this.f13142aL, 4, false);
        } else if (this.f13155aY.length() > 0 && !TextUtils.isEmpty(this.f13188bf)) {
            if (this.f13188bf.equalsIgnoreCase("137") && C2787z.m4807l(this.f13155aY)) {
                m6728b(this.f13142aL, 0, true);
            } else if ((this.f13188bf.equalsIgnoreCase("235") || this.f13188bf.equalsIgnoreCase("325")) && C2787z.m4808k(this.f13155aY)) {
                m6728b(this.f13142aL, 0, true);
            } else {
                m6728b(this.f13142aL, 0, false);
            }
        } else {
            m6728b(this.f13142aL, 0, false);
        }
        this.f13168al.setEnabled(m6712h());
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public Object doInBackground(int i) throws C1425f {
        if (i != 2011) {
            if (i != 2031) {
                switch (i) {
                    case PdfContentParser.COMMAND_TYPE /* 200 */:
                        String str = this.f13151aU;
                        if (C2744aa.m5125r()) {
                            UserAction userAction = this.f13158ab;
                            String str2 = this.f13188bf;
                            String str3 = this.f13151aU;
                            String str4 = this.f13185bc;
                            return userAction.m5263a(str2, "", str3, str4, "", this.f13191bi, this.f13152aV, "6021", str, this.f13154aX, this.f13155aY, this.f13156aZ, this.f13184bb, this.f13183ba, str4, this.f13186bd, this.f13187be);
                        }
                        return this.f13158ab.m5263a(this.f13188bf, this.f13151aU, "", "", "", this.f13189bg, this.f13152aV, "6021", str, this.f13154aX, this.f13155aY, this.f13156aZ, this.f13184bb, this.f13183ba, this.f13185bc, this.f13186bd, this.f13187be);
                    case 201:
                        return this.f13158ab.m5267a(this.f13151aU, LangManager.m9469a(), "2");
                    case 202:
                        return this.f13158ab.m5250g(LangManager.m9469a());
                    case 203:
                        return this.f13158ab.m5268a(this.f13151aU, this.f13189bg);
                    case 204:
                        return this.f13158ab.m5269a(this.f13151aU);
                    default:
                        return super.doInBackground(i);
                }
            }
            return this.f13158ab.m5268a(this.f13185bc, this.f13191bi);
        }
        return this.f13158ab.m5266a(this.f13185bc, LangManager.m9469a(), "3", "1");
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onSuccess(int i, Object obj) {
        if (i == 2011) {
            LoadDialog.m4681b(this.f10981q);
            if (obj != null) {
                CommonResponse commonResponse = (CommonResponse) obj;
                if (commonResponse.getCode() == 0) {
                    CountDownTimer countDownTimer = this.f13108D;
                    if (countDownTimer != null) {
                        countDownTimer.start();
                    }
                    NToast.m9449a(this.f10981q, this.f10981q.getString(R.string.mine_set_verify_phone_tips, this.f13185bc));
                    return;
                }
                int code = commonResponse.getCode();
                if (code == 30040) {
                    NToast.m9450a(this.f10981q, (int) R.string.more_than_sending_number);
                } else if (code == 110001) {
                    m6728b(this.f13147aQ, 0, false);
                    this.f13173aq.setFocusableInTouchMode(true);
                    this.f13173aq.requestFocusFromTouch();
                    int[] iArr = new int[2];
                    this.f13173aq.getLocationOnScreen(iArr);
                    m6734a(this.f10981q, R.string.register_fail_prompt_phone_regist, iArr[0], iArr[1] + 40);
                } else {
                    switch (code) {
                        case 30030:
                            return;
                        case 30031:
                            NToast.m9450a(this.f10981q, (int) R.string.retrieve_password_operate_frequently);
                            return;
                        default:
                            NToast.m9450a(this.f10981q, (int) R.string.get_identify_code_fail_prompt);
                            return;
                    }
                }
            }
        } else if (i != 2031) {
            switch (i) {
                case PdfContentParser.COMMAND_TYPE /* 200 */:
                    LoadDialog.m4681b(this.f10981q);
                    if (obj != null) {
                        RegistResponse registResponse = (RegistResponse) obj;
                        if (registResponse.getCode() == 0) {
                            if (C2744aa.m5125r()) {
                                RegisterInfoRecord registerInfoRecord = new RegisterInfoRecord();
                                this.f13107C = registerInfoRecord.m6546a();
                                this.f13107C.put(this.f13151aU, this.f13152aV);
                                try {
                                    NLog.m9451c("weiwell register_onsuccess_map", this.f13107C);
                                    String m6543a = RegisterInfoRecord.m6543a(this.f13107C);
                                    NLog.m9451c("weiwell register_onsuccess", m6543a);
                                    registerInfoRecord.m6544a(m6543a);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                            NToast.m9450a(this.f10981q, (int) R.string.register_ok);
                            LoginFunction loginFunction = new LoginFunction(this.f10981q);
                            LoginFunction.m6570e();
                            loginFunction.m6583a(this.f13151aU, this.f13152aV);
                            Intent intent = new Intent(this.f10981q, ActivateJointActivity.class);
                            intent.putExtra("UserName", this.f13151aU);
                            intent.putExtra("PassWord", this.f13152aV);
                            intent.putExtra("FromRegister", true);
                            startActivity(intent);
                            setResult(-1);
                            if (!C2744aa.m5166c()) {
                                FileUtils.m5000d(PathUtils.m4846j() + this.f13197bo);
                            }
                            String str = PathUtils.m4846j() + this.f13196bn;
                            if (new File(str).exists()) {
                                FileUtils.m5000d(str);
                            }
                            finish();
                            return;
                        }
                        switch (registResponse.getCode()) {
                            case 1024:
                                NToast.m9450a(this.f10981q, (int) R.string.register_fail_prompt_1024);
                                break;
                            case 1025:
                                NToast.m9450a(this.f10981q, (int) R.string.register_fail_prompt_1025);
                                break;
                            case 30001:
                                NToast.m9450a(this.f10981q, (int) R.string.register_fail_prompt_30001);
                                break;
                            case 30006:
                                NToast.m9450a(this.f10981q, (int) R.string.register_fail_prompt_30006);
                                break;
                            case 30007:
                                NToast.m9450a(this.f10981q, (int) R.string.register_fail_prompt_30007);
                                break;
                            case 30009:
                                NToast.m9450a(this.f10981q, (int) R.string.register_fail_prompt_30009);
                                break;
                            case 30011:
                                NToast.m9450a(this.f10981q, (int) R.string.register_fail_prompt_300011);
                                break;
                            case 30027:
                                NToast.m9450a(this.f10981q, (int) R.string.register_fail_prompt_30027);
                                break;
                            default:
                                NToast.m9450a(this.f10981q, (int) R.string.register_fail);
                                break;
                        }
                        setResult(0);
                        return;
                    }
                    return;
                case 201:
                    LoadDialog.m4681b(this.f10981q);
                    if (obj != null) {
                        CommonResponse commonResponse2 = (CommonResponse) obj;
                        if (commonResponse2.getCode() == 0) {
                            this.f13195bm = commonResponse2.getData().toString().substring(commonResponse2.getData().toString().indexOf(Constants.HTTP), commonResponse2.getData().toString().length() - 1);
                            this.f13208bz.sendEmptyMessage(2);
                            return;
                        }
                        int code2 = commonResponse2.getCode();
                        if (code2 == 10001) {
                            m6728b(this.f13138aH, 0, false);
                            this.f13159ac.setFocusableInTouchMode(true);
                            this.f13159ac.requestFocusFromTouch();
                            int[] iArr2 = new int[2];
                            this.f13159ac.getLocationOnScreen(iArr2);
                            m6734a(this.f10981q, R.string.get_identify_code_fail_prompt_10001, iArr2[0], iArr2[1] + 40);
                            return;
                        } else if (code2 == 30040) {
                            NToast.m9450a(this.f10981q, (int) R.string.more_than_sending_number);
                            return;
                        } else if (code2 == 110001) {
                            m6728b(this.f13138aH, 0, false);
                            this.f13159ac.setFocusableInTouchMode(true);
                            this.f13159ac.requestFocusFromTouch();
                            int[] iArr3 = new int[2];
                            this.f13159ac.getLocationOnScreen(iArr3);
                            m6734a(this.f10981q, R.string.get_identify_code_fail_prompt_110001, iArr3[0], iArr3[1] + 40);
                            return;
                        } else {
                            NToast.m9450a(this.f10981q, (int) R.string.get_identify_code_fail_prompt);
                            return;
                        }
                    }
                    return;
                case 202:
                    if (obj != null) {
                        CountryListResponse countryListResponse = (CountryListResponse) obj;
                        if (countryListResponse.getCode() == 0) {
                            this.f13192bj = (ArrayList) countryListResponse.getData();
                            this.f13208bz.sendEmptyMessage(1);
                            return;
                        }
                        return;
                    }
                    this.f13208bz.sendEmptyMessage(4);
                    return;
                case 203:
                    LoadDialog.m4681b(this.f10981q);
                    if (((CommonResponse) obj).getCode() == 0) {
                        m6728b(this.f13143aM, 0, true);
                    } else {
                        m6728b(this.f13143aM, 0, false);
                        if (!this.f13138aH.isChecked()) {
                            int[] iArr4 = new int[2];
                            this.f13159ac.getLocationOnScreen(iArr4);
                            m6734a(this.f10981q, R.string.register_username_format, iArr4[0], iArr4[1] + 40);
                        } else {
                            m7739c(201);
                            int[] iArr5 = new int[2];
                            this.f13165ai.getLocationOnScreen(iArr5);
                            m6734a(this.f10981q, R.string.register_fail_prompt_1025, iArr5[0], iArr5[1] + 40);
                        }
                    }
                    this.f13168al.setEnabled(m6712h());
                    return;
                case 204:
                    if (obj != null) {
                        UserAccountCheckedInfoResponse userAccountCheckedInfoResponse = (UserAccountCheckedInfoResponse) obj;
                        if (userAccountCheckedInfoResponse.getCode() == 0) {
                            if (userAccountCheckedInfoResponse.getData().getIs_exists() == 0) {
                                m6728b(this.f13138aH, 0, true);
                                if (C2744aa.m5125r() || this.f13143aM.isChecked()) {
                                    return;
                                }
                                m7739c(201);
                                return;
                            }
                            m6728b(this.f13138aH, 0, false);
                            m6728b(this.f13138aH, 0, false);
                            this.f13159ac.setFocusableInTouchMode(true);
                            this.f13159ac.requestFocusFromTouch();
                            int[] iArr6 = new int[2];
                            this.f13159ac.getLocationOnScreen(iArr6);
                            m6734a(this.f10981q, R.string.get_identify_code_fail_prompt_110001, iArr6[0], iArr6[1] + 40);
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else {
            LoadDialog.m4681b(this.f10981q);
            if (((CommonResponse) obj).getCode() == 0) {
                m6728b(this.f13150aT, 0, true);
            } else {
                m6728b(this.f13150aT, 0, false);
            }
            this.f13168al.setEnabled(m6712h());
        }
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onFailure(int i, int i2, Object obj) {
        super.onFailure(i, i2, obj);
        if (i != 2011) {
            switch (i) {
                case PdfContentParser.COMMAND_TYPE /* 200 */:
                    setResult(0);
                    LoadDialog.m4681b(this.f10981q);
                    return;
                case 201:
                    LoadDialog.m4681b(this.f10981q);
                    return;
                case 202:
                    this.f13208bz.sendEmptyMessage(4);
                    return;
                case 203:
                    LoadDialog.m4681b(this.f10981q);
                    m6728b(this.f13143aM, 0, false);
                    this.f13168al.setEnabled(m6712h());
                    return;
                case 204:
                    LoadDialog.m4681b(this.f10981q);
                    return;
                default:
                    return;
            }
        }
        LoadDialog.m4681b(this.f10981q);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Log.d("HZS", "onClick");
        switch (view.getId()) {
            case R.id.bt_getcode /* 2131296382 */:
                this.f13185bc = this.f13173aq.getText().toString();
                if (C2787z.m4810i(this.f13185bc)) {
                    m7739c(2011);
                    return;
                }
                return;
            case R.id.bt_refresh /* 2131296383 */:
                this.f13151aU = this.f13159ac.getText().toString();
                if (TextUtils.isEmpty(this.f13151aU)) {
                    NToast.m9450a(this.f10981q, (int) R.string.register_input_null);
                    return;
                } else if (!this.f13138aH.isChecked()) {
                    int[] iArr = new int[2];
                    this.f13159ac.getLocationOnScreen(iArr);
                    m6734a(this.f10981q, R.string.register_username_format, iArr[0], iArr[1] + 40);
                    return;
                } else {
                    m7739c(201);
                    return;
                }
            case R.id.btn_regist /* 2131296527 */:
                this.f13151aU = this.f13159ac.getText().toString();
                this.f13152aV = this.f13160ad.getText().toString();
                this.f13153aW = this.f13161ae.getText().toString();
                this.f13154aX = this.f13162af.getText().toString();
                this.f13156aZ = this.f13170an.getText().toString();
                this.f13184bb = this.f13172ap.getText().toString();
                this.f13183ba = this.f13171ao.getText().toString();
                this.f13185bc = this.f13173aq.getText().toString();
                this.f13186bd = this.f13174ar.getText().toString();
                this.f13187be = this.f13175as.getText().toString();
                if (!C2744aa.m5166c()) {
                    this.f13155aY = "";
                } else {
                    this.f13155aY = this.f13164ah.getText().toString();
                }
                this.f13189bg = this.f13165ai.getText().toString();
                this.f13191bi = this.f13176at.getText().toString();
                LoadDialog.m4686a(this.f10981q);
                m7739c(PdfContentParser.COMMAND_TYPE);
                return;
            case R.id.tv_privacy_policy /* 2131298183 */:
                m6717f(1);
                return;
            case R.id.tv_service_agreement /* 2131298248 */:
                m6717f(0);
                return;
            default:
                return;
        }
    }

    /* renamed from: f */
    private void m6717f(int i) {
        String string;
        if (this.f13203bu == i || C2744aa.m5119u()) {
            return;
        }
        Intent intent = new Intent(this.f10981q, WebActivity.class);
        if (this.f13209n == null) {
            this.f13209n = ConfigDBManager.m5398a(this.f10981q);
        }
        String str = "";
        String m9591a = PreferencesManager.m9595a(this.f10981q).m9591a("agreement_cus");
        if (i == 0) {
            try {
                if (!TextUtils.isEmpty(m9591a) && "mkat".equals(m9591a)) {
                    str = this.f13209n.m5396a("agreement_all");
                } else if (C2744aa.m5160d()) {
                    str = this.f13209n.m5396a("agreement_eu");
                } else if (C2744aa.m5144h(this.f10981q)) {
                    str = this.f13209n.m5396a("agreement_cn");
                } else {
                    str = this.f13209n.m5396a("agreement_all");
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
                if (!TextUtils.isEmpty(m9591a) && "mkat".equals(m9591a)) {
                    str = this.f13209n.m5396a("privacy_policy_all");
                } else if (C2744aa.m5160d()) {
                    str = this.f13209n.m5396a("privacy_policy_eu");
                } else if (C2744aa.m5144h(this.f10981q)) {
                    str = this.f13209n.m5396a("privacy_policy_cn");
                } else {
                    str = this.f13209n.m5396a("privacy_policy_all");
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
        this.f13203bu = i;
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 0) {
            sendBroadcast(new Intent("LoginActivityKeyBack"));
            if (!C2744aa.m5166c()) {
                FileUtils.m5000d(PathUtils.m4846j() + this.f13197bo);
            }
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        switch (view.getId()) {
            case R.id.edit_confirmpass /* 2131296926 */:
                if (z) {
                    return;
                }
                this.f13152aV = this.f13160ad.getText().toString();
                this.f13153aW = this.f13161ae.getText().toString();
                if (!C2787z.m4813f(this.f13152aV)) {
                    int[] iArr = new int[2];
                    this.f13160ad.getLocationOnScreen(iArr);
                    m6734a(this.f10981q, R.string.register_password_char_error, iArr[0], iArr[1] + 40);
                    return;
                } else if (this.f13153aW.equals(this.f13152aV)) {
                    return;
                } else {
                    int[] iArr2 = new int[2];
                    this.f13161ae.getLocationOnScreen(iArr2);
                    m6734a(this.f10981q, R.string.register_password_not_match, iArr2[0], iArr2[1] + 40);
                    m6728b(this.f13140aJ, 0, false);
                    return;
                }
            case R.id.edit_email /* 2131296930 */:
                if (z) {
                    return;
                }
                this.f13154aX = this.f13162af.getText().toString();
                String str = this.f13154aX;
                if (str == null || str.equals("") || C2787z.m4816c(this.f13154aX)) {
                    return;
                }
                int[] iArr3 = new int[2];
                this.f13162af.getLocationOnScreen(iArr3);
                m6734a(this.f10981q, R.string.register_fail_prompt_30009, iArr3[0], iArr3[1] + 40);
                m6728b(this.f13141aK, 0, false);
                return;
            case R.id.edit_password /* 2131296949 */:
                if (z) {
                    return;
                }
                this.f13152aV = this.f13160ad.getText().toString();
                this.f13153aW = this.f13161ae.getText().toString();
                if (this.f13152aV.isEmpty() || this.f13152aV.equals("")) {
                    m6728b(this.f13139aI, 0, false);
                    return;
                } else if (!C2787z.m4813f(this.f13152aV)) {
                    int[] iArr4 = new int[2];
                    this.f13160ad.getLocationOnScreen(iArr4);
                    if (this.f13152aV.length() > 0 && this.f13152aV.length() < 6) {
                        m6734a(this.f10981q, R.string.register_password_is_short, iArr4[0], iArr4[1] + 40);
                    } else {
                        m6734a(this.f10981q, R.string.register_password_char_error, iArr4[0], iArr4[1] + 40);
                    }
                    m6728b(this.f13139aI, 0, false);
                    return;
                } else {
                    m6728b(this.f13139aI, 0, true);
                    String str2 = this.f13153aW;
                    if (str2 == null || str2.equals("")) {
                        return;
                    }
                    if (!this.f13153aW.equals(this.f13152aV) && !this.f13161ae.isFocused()) {
                        int[] iArr5 = new int[2];
                        this.f13161ae.getLocationOnScreen(iArr5);
                        m6734a(this.f10981q, R.string.register_password_not_match, iArr5[0], iArr5[1] + 40);
                        return;
                    } else if (this.f13152aV.equals(this.f13153aW)) {
                        return;
                    } else {
                        return;
                    }
                }
            case R.id.edit_username /* 2131296976 */:
                if (z) {
                    return;
                }
                String obj = this.f13159ac.getText().toString();
                if (C2787z.m4809j(obj).booleanValue()) {
                    this.f13151aU = obj;
                    m7739c(204);
                    return;
                }
                if (obj.length() == 0) {
                    int[] iArr6 = new int[2];
                    this.f13159ac.getLocationOnScreen(iArr6);
                    m6734a(this.f10981q, R.string.login_input_username, iArr6[0], iArr6[1] + 40);
                } else if (obj.length() < 5) {
                    int[] iArr7 = new int[2];
                    this.f13159ac.getLocationOnScreen(iArr7);
                    m6734a(this.f10981q, R.string.register_username_short, iArr7[0], iArr7[1] + 40);
                } else {
                    int[] iArr8 = new int[2];
                    this.f13159ac.getLocationOnScreen(iArr8);
                    m6734a(this.f10981q, R.string.register_username_format, iArr8[0], iArr8[1] + 40);
                }
                m6728b(this.f13138aH, 0, false);
                return;
            case R.id.edit_zipcode /* 2131296980 */:
                if (z) {
                    return;
                }
                this.f13155aY = this.f13164ah.getText().toString();
                if (this.f13155aY.length() == 0) {
                    int[] iArr9 = new int[2];
                    this.f13164ah.getLocationOnScreen(iArr9);
                    m6734a(this.f10981q, R.string.register_input_zipcode, iArr9[0], iArr9[1] + 40);
                    return;
                } else if (C2787z.m4808k(this.f13155aY) || C2787z.m4807l(this.f13155aY)) {
                    return;
                } else {
                    int[] iArr10 = new int[2];
                    this.f13164ah.getLocationOnScreen(iArr10);
                    m6734a(this.f10981q, R.string.register_fail_prompt_300011, iArr10[0], iArr10[1] + 40);
                    return;
                }
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m6728b(CheckBox checkBox, int i, boolean z) {
        checkBox.setVisibility(i);
        checkBox.setChecked(z);
        checkBox.setClickable(false);
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.support.p012v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Log.d("weizewei", "RegistActivity onConfigurationChanged");
    }

    @Override // android.support.p012v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1 && i2 == 1) {
            this.f13198bp = new Country();
            Bundle extras = intent.getExtras();
            this.f13198bp.setDisplay(extras.getString("display"));
            this.f13198bp.setNcode(extras.getString("ncode"));
            this.f13198bp.setIs_sms(Integer.parseInt(extras.getString("is_sms")));
            this.f13198bp.setPre_code(Integer.parseInt(extras.getString("pre_code")));
            FileUtils.m5016a((((this.f13198bp.getDisplay() + "|") + this.f13198bp.getNcode() + "|") + this.f13198bp.getIs_sms() + "|") + this.f13198bp.getPre_code() + "|", PathUtils.m4846j() + this.f13197bo);
            this.f13201bs.clear();
            this.f13201bs.add(this.f13198bp.getDisplay());
            this.f13188bf = this.f13198bp.getNcode();
            this.f13208bz.sendEmptyMessage(4);
            m6728b(this.f13142aL, 0, true);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v12, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14, types: [int] */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* renamed from: c */
    private static Country m6722c(String str) {
        BufferedReader bufferedReader;
        Country country = new Country();
        BufferedReader bufferedReader2 = 0;
        try {
        } catch (IOException e) {
            NLog.m9455a(e);
        }
        try {
            try {
                bufferedReader = new BufferedReader(new FileReader(str));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        bufferedReader2 = "\\|";
                        String[] split = readLine.split("\\|");
                        if (split != null && (bufferedReader2 = split.length) == 4) {
                            country.setDisplay(split[0]);
                            country.setNcode(split[1]);
                            country.setIs_sms(Integer.parseInt(split[2]));
                            bufferedReader2 = 3;
                            country.setPre_code(Integer.parseInt(split[3]));
                        }
                    } catch (FileNotFoundException e2) {
                        e = e2;
                        bufferedReader2 = bufferedReader;
                        NLog.m9455a(e);
                        if (bufferedReader2 != null) {
                            bufferedReader2.close();
                        }
                        return country;
                    } catch (IOException e3) {
                        e = e3;
                        bufferedReader2 = bufferedReader;
                        NLog.m9455a(e);
                        if (bufferedReader2 != null) {
                            bufferedReader2.close();
                        }
                        return country;
                    } catch (Exception e4) {
                        e = e4;
                        bufferedReader2 = bufferedReader;
                        NLog.m9455a(e);
                        if (bufferedReader2 != null) {
                            bufferedReader2.close();
                        }
                        return country;
                    } catch (Throwable th) {
                        th = th;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e5) {
                                NLog.m9455a(e5);
                            }
                        }
                        throw th;
                    }
                }
                bufferedReader.close();
            } catch (FileNotFoundException e6) {
                e = e6;
            } catch (IOException e7) {
                e = e7;
            } catch (Exception e8) {
                e = e8;
            }
            return country;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = bufferedReader2;
        }
    }
}
