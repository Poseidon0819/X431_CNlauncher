package com.unionpay.mobile.android.nocard.views;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.mapapi.UIMsg;
import com.itextpdf.text.Annotation;
import com.mopub.mobileads.VastExtensionXmlManager;
import com.unionpay.mobile.android.global.C4149a;
import com.unionpay.mobile.android.languages.C4171c;
import com.unionpay.mobile.android.model.C4172a;
import com.unionpay.mobile.android.model.C4173b;
import com.unionpay.mobile.android.model.InterfaceC4174c;
import com.unionpay.mobile.android.model.InterfaceC4176e;
import com.unionpay.mobile.android.nocard.utils.C4185a;
import com.unionpay.mobile.android.nocard.utils.C4190f;
import com.unionpay.mobile.android.nocard.utils.UPPayEngine;
import com.unionpay.mobile.android.plugin.BaseActivity;
import com.unionpay.mobile.android.utils.C4382c;
import com.unionpay.mobile.android.utils.C4385f;
import com.unionpay.mobile.android.utils.C4389j;
import com.unionpay.mobile.android.utils.C4390k;
import com.unionpay.mobile.android.utils.C4394o;
import com.unionpay.mobile.android.utils.C4395p;
import com.unionpay.mobile.android.utils.PreferenceUtils;
import com.unionpay.mobile.android.utils.RunnableC4396q;
import com.unionpay.mobile.android.widgets.C4471m;
import com.unionpay.tsmservice.data.Constant;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.unionpay.mobile.android.nocard.views.l */
/* loaded from: classes2.dex */
public class C4242l extends AbstractC4219b implements RunnableC4396q.InterfaceC4397a {

    /* renamed from: A */
    private String f22656A;

    /* renamed from: B */
    private int f22657B;

    /* renamed from: C */
    private volatile int f22658C;

    /* renamed from: D */
    private boolean f22659D;

    /* renamed from: E */
    private boolean f22660E;

    /* renamed from: F */
    private JSONArray f22661F;

    /* renamed from: G */
    private InterfaceC4176e f22662G;

    /* renamed from: H */
    private long f22663H;

    /* renamed from: I */
    private Activity f22664I;

    /* renamed from: J */
    private boolean f22665J;

    /* renamed from: K */
    private boolean f22666K;

    /* renamed from: r */
    public List<InterfaceC4174c> f22667r;

    /* renamed from: s */
    public List<InterfaceC4174c> f22668s;

    /* renamed from: t */
    int f22669t;

    /* renamed from: u */
    String f22670u;

    /* renamed from: v */
    String f22671v;

    /* renamed from: w */
    String f22672w;

    /* renamed from: x */
    int f22673x;

    /* renamed from: y */
    int f22674y;

    /* renamed from: z */
    private ProgressBar f22675z;

    public C4242l(Context context) {
        super(context);
        this.f22675z = null;
        this.f22656A = null;
        this.f22657B = 0;
        this.f22658C = 0;
        this.f22667r = null;
        this.f22668s = null;
        this.f22659D = false;
        this.f22660E = false;
        this.f22666K = false;
        this.f22669t = 0;
        this.f22670u = "";
        this.f22671v = "";
        this.f22672w = "";
        this.f22673x = UIMsg.d_ResultType.SHORT_URL;
        this.f22674y = 5;
        this.f22595f = 1;
        this.f22606q = "init";
        mo1373d();
        this.f22664I = (Activity) context;
        try {
            this.f22665J = C4185a.m1488a(this.f22664I.getIntent(), this.f22590a);
        } catch (Exception unused) {
            this.f22665J = false;
        }
        if (this.f22590a.f22412aM) {
            setVisibility(8);
            this.f22591b.m635a(C4171c.f22227bD.f22337c);
        }
        m1371r();
    }

    /* renamed from: a */
    private void m1378a(String str, String str2, String str3) {
        C4471m c4471m;
        String str4;
        View$OnClickListenerC4243m view$OnClickListenerC4243m = new View$OnClickListenerC4243m(this, str3);
        View$OnClickListenerC4244n view$OnClickListenerC4244n = new View$OnClickListenerC4244n(this);
        if (!str.equalsIgnoreCase("01")) {
            this.f22591b.m636a(view$OnClickListenerC4243m, view$OnClickListenerC4244n);
            c4471m = this.f22591b;
            str4 = C4171c.f22227bD.f22285ae;
        } else {
            this.f22591b.m636a(view$OnClickListenerC4243m, view$OnClickListenerC4244n);
            c4471m = this.f22591b;
            str4 = C4171c.f22227bD.f22252Y;
        }
        c4471m.m633a(str4, str2, C4171c.f22227bD.f22286af, C4171c.f22227bD.f22287ag);
    }

    /* renamed from: b */
    private void m1376b(int i, String str) {
        if (str != null && str.length() > 0) {
            this.f22590a.f22383I.f22848f = str;
        }
        this.f22675z.setVisibility(4);
        mo1138a(m1413c(i), true);
    }

    /* renamed from: c */
    private void m1374c(String str, String str2) {
        if (str2.length() > 0) {
            this.f22590a.f22383I.f22848f = str2;
        }
        this.f22675z.setVisibility(4);
        mo1138a(str, true);
    }

    /* renamed from: f */
    private boolean m1372f(int i) {
        if ((i & 2) != 0) {
            this.f22590a.f22448aw = true;
            return true;
        }
        return false;
    }

    /* renamed from: y */
    private final boolean m1367y() {
        try {
            String string = this.f22661F != null ? this.f22661F.getString(3) : null;
            if (string == null || string.length() <= 0) {
                return false;
            }
            return !"null".equalsIgnoreCase(string);
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:81:0x012a A[Catch: all -> 0x028d, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x001d, B:9:0x0024, B:11:0x0028, B:13:0x0034, B:15:0x003e, B:20:0x0049, B:28:0x0058, B:32:0x005e, B:34:0x0066, B:35:0x006b, B:37:0x007b, B:39:0x0081, B:86:0x0141, B:88:0x014d, B:90:0x0153, B:92:0x015d, B:94:0x0163, B:97:0x016e, B:99:0x017a, B:101:0x017e, B:103:0x0189, B:105:0x018d, B:107:0x0198, B:109:0x019c, B:111:0x01a7, B:113:0x01ad, B:115:0x01b9, B:117:0x01bf, B:118:0x01c7, B:120:0x01cd, B:122:0x01d9, B:135:0x01f4, B:114:0x01b5, B:110:0x01a3, B:106:0x0194, B:102:0x0185, B:139:0x01fc, B:141:0x0200, B:143:0x0204, B:150:0x0217, B:152:0x021d, B:154:0x0223, B:156:0x0229, B:158:0x022f, B:159:0x023f, B:161:0x0245, B:163:0x024b, B:165:0x0251, B:178:0x0284, B:166:0x0257, B:168:0x025d, B:170:0x0263, B:172:0x0267, B:174:0x026b, B:176:0x0273, B:177:0x027f, B:145:0x0208, B:147:0x020c, B:138:0x01f9, B:40:0x0088, B:41:0x0090, B:43:0x0094, B:45:0x0098, B:47:0x009c, B:49:0x00a0, B:51:0x00a8, B:52:0x00ae, B:54:0x00b4, B:56:0x00c0, B:57:0x00c4, B:59:0x00d0, B:60:0x00d4, B:74:0x010c, B:76:0x0112, B:78:0x011c, B:79:0x0124, B:81:0x012a, B:83:0x0136, B:85:0x013d, B:61:0x00d7, B:63:0x00dd, B:64:0x00e2, B:66:0x00e6, B:68:0x00ee, B:69:0x00f7, B:71:0x00fb, B:73:0x0103), top: B:187:0x0001, inners: #0 }] */
    /* renamed from: z */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final synchronized void m1366z() {
        /*
            Method dump skipped, instructions count: 657
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unionpay.mobile.android.nocard.views.C4242l.m1366z():void");
    }

    /* renamed from: a */
    public void mo1156a(int i, int i2, String str, String str2, int i3, String str3) {
    }

    @Override // com.unionpay.mobile.android.utils.RunnableC4396q.InterfaceC4397a
    /* renamed from: a */
    public final void mo831a(int i, byte[] bArr) {
        m1407i();
        if (i != 0) {
            m1376b(i, (String) null);
        }
        C4390k.m838a("uppay", "status = ".concat(String.valueOf(i)));
        if (bArr != null) {
            if (!"mounted".equals(Environment.getExternalStorageState())) {
                m1376b(9, (String) null);
            } else if (!C4395p.m832a(bArr)) {
                m1376b(21, (String) null);
            } else {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                String str = Environment.getExternalStorageDirectory() + File.separator + "UPPay" + File.separator + "UPPayPluginEx.apk";
                C4390k.m838a("uppay", "apk path:".concat(String.valueOf(str)));
                intent.setDataAndType(Uri.fromFile(new File(str)), "application/vnd.android.package-archive");
                ((BaseActivity) this.f22593d).startActivityForResult(intent, 100);
            }
        }
    }

    @Override // com.unionpay.mobile.android.nocard.views.InterfaceC4191a
    /* renamed from: a */
    public final void mo1077a(JSONObject jSONObject) {
        String m846a;
        C4390k.m838a("uppay", "init.parserParamJsonObj() +++");
        if (jSONObject == null) {
            mo1137b(2);
            return;
        }
        switch (this.f22657B) {
            case 1:
                String m846a2 = C4389j.m846a(jSONObject, "secret");
                C4389j.m846a(jSONObject, "sec_sign");
                this.f22594e.m1504d(m846a2);
                String m846a3 = C4389j.m846a(jSONObject, "talking_data_flag");
                if (!TextUtils.isEmpty(m846a3)) {
                    C4149a.f22108L = "0".equals(m846a3);
                }
                String m846a4 = C4389j.m846a(jSONObject, "mer_id");
                TextUtils.isEmpty(m846a4);
                String[] strArr = C4394o.f23198a;
                new String[1][0] = this.f22590a.f22452b;
                String[] strArr2 = C4394o.f23199b;
                new String[1][0] = m846a4;
                String[] strArr3 = C4394o.f23200c;
                new String[1][0] = C4171c.f22227bD.f22254a;
                JSONObject m843c = C4389j.m843c(jSONObject, "upgrade_info");
                this.f22656A = C4389j.m846a(m843c, VastExtensionXmlManager.TYPE);
                String m846a5 = C4389j.m846a(m843c, "desc");
                String m846a6 = C4389j.m846a(m843c, Annotation.URL);
                if (!this.f22656A.equalsIgnoreCase("02")) {
                    this.f22590a.f22479o = C4389j.m846a(jSONObject, "title");
                    this.f22590a.f22474j = C4389j.m843c(jSONObject, "init_button");
                    this.f22590a.f22472h = C4389j.m842d(jSONObject, "order");
                    HashMap hashMap = new HashMap();
                    for (int i = 0; i < this.f22590a.f22472h.length(); i++) {
                        Object m845b = C4389j.m845b(this.f22590a.f22472h, i);
                        if (m845b != null) {
                            JSONObject jSONObject2 = (JSONObject) m845b;
                            hashMap.put(C4389j.m846a(jSONObject2, "label"), C4389j.m846a(jSONObject2, "value"));
                        }
                    }
                    String[] strArr4 = C4394o.f23201d;
                    new String[1][0] = hashMap.toString();
                    this.f22590a.f22473i = C4389j.m843c(jSONObject, "risk_info");
                    List<JSONArray> m841e = C4389j.m841e(jSONObject, "cards");
                    if (m841e.size() > 0) {
                        this.f22667r = new ArrayList(m841e.size());
                    }
                    for (int i2 = 0; i2 < m841e.size(); i2++) {
                        this.f22667r.add(new C4172a(C4389j.m847a(m841e.get(i2), 0), C4389j.m847a(m841e.get(i2), 1), C4389j.m847a(m841e.get(i2), 2), (byte) 0));
                    }
                    this.f22590a.f22483s = C4389j.m846a(jSONObject, "bank_url");
                    this.f22590a.f22484t = C4389j.m842d(jSONObject, "input_info");
                    this.f22590a.f22486v = C4389j.m843c(jSONObject, "account_info");
                    this.f22590a.f22487w = C4389j.m843c(jSONObject, "other_card_info");
                    this.f22590a.f22485u = C4389j.m846a(jSONObject, "user_id");
                    this.f22594e.m1510b(C4389j.m846a(jSONObject, "sid"));
                    this.f22594e.m1507c(C4389j.m846a(jSONObject, "secret"));
                    String m846a7 = C4389j.m846a(jSONObject, "sid");
                    if (!TextUtils.isEmpty(m846a7)) {
                        this.f22590a.f22475k = this.f22594e.m1496h(C4382c.m881b(m846a7));
                    }
                    String m846a8 = C4389j.m846a(jSONObject, "secret");
                    if (!TextUtils.isEmpty(m846a8)) {
                        this.f22590a.f22476l = this.f22594e.m1496h(C4382c.m881b(m846a8));
                        this.f22590a.f22477m = m846a8;
                    }
                    String m846a9 = C4389j.m846a(jSONObject, "uid");
                    if (m846a9 != null && !TextUtils.isEmpty(m846a9)) {
                        PreferenceUtils.m899b(this.f22593d, m846a9);
                    }
                    if (mo1154t()) {
                        if (mo1155s()) {
                            this.f22590a.f22488x = C4389j.m843c(jSONObject, "kalefu_info");
                            this.f22590a.f22489y = C4389j.m846a(jSONObject, "kalefu_button_label");
                            if ((this.f22590a.f22489y == null || this.f22590a.f22489y.length() <= 0) && C4171c.f22227bD != null) {
                                this.f22590a.f22489y = C4171c.f22227bD.f22293am;
                            }
                        }
                        this.f22661F = C4389j.m842d(jSONObject, "cards_desc");
                        this.f22590a.f22439an = C4389j.m846a(jSONObject, "trade_privilege");
                        this.f22590a.f22441ap = C4389j.m846a(jSONObject, "upcard_msg");
                        this.f22590a.f22440ao = 0;
                        String m846a10 = C4389j.m846a(jSONObject, "upcard_support_type");
                        if (!"1".equalsIgnoreCase(this.f22590a.f22439an) && m846a10 != null && m846a10.length() > 0) {
                            this.f22590a.f22440ao = Integer.parseInt(m846a10, 2);
                        }
                        m1372f(this.f22590a.f22440ao);
                    }
                    this.f22590a.f22443ar = C4389j.m846a(jSONObject, "ad");
                    this.f22590a.f22445at = C4389j.m846a(jSONObject, "pay_tip");
                    String m846a11 = C4389j.m846a(jSONObject, "sup_pay_method");
                    if (!TextUtils.isEmpty(m846a11)) {
                        this.f22590a.f22402aC = "01".equals(m846a11);
                        this.f22590a.f22403aD = "001".equals(m846a11);
                    }
                    String m846a12 = C4389j.m846a(jSONObject, "default_pay_type");
                    if (!TextUtils.isEmpty(m846a12)) {
                        this.f22590a.f22404aE = "0501".equals(m846a12);
                    }
                    this.f22590a.f22446au = C4389j.m843c(jSONObject, "find_pwd_url");
                    this.f22590a.f22399Y = C4389j.m843c(jSONObject, "reg_url");
                    this.f22590a.f22450ay = "1".equals(C4389j.m846a(jSONObject, "sup_nfc"));
                    this.f22590a.f22451az = "1".equals(C4389j.m846a(jSONObject, "sup_hce"));
                    C4173b.f22367aA = "1".equals(C4389j.m846a(jSONObject, "sup_samsung_pay"));
                    this.f22590a.f22458bh = C4389j.m846a(jSONObject, "hce_introduction_url");
                    if (mo1155s() && this.f22590a.f22450ay && !this.f22590a.f22402aC) {
                        String m846a13 = C4389j.m846a(jSONObject, "nfc_title");
                        if (!TextUtils.isEmpty(m846a13)) {
                            C4171c.f22227bD.f22325bo = m846a13;
                        }
                        JSONObject m843c2 = C4389j.m843c(jSONObject, "nfc_button");
                        if (m843c2 != null && (m846a = C4389j.m846a(m843c2, "label")) != null && !TextUtils.isEmpty(m846a)) {
                            C4171c.f22227bD.f22326bp = m846a;
                        }
                    }
                    if (mo1155s() && this.f22590a.f22451az && !this.f22590a.f22402aC && !this.f22590a.f22403aD) {
                        String m846a14 = C4389j.m846a(jSONObject, "hce_title");
                        this.f22669t = C4389j.m844b(jSONObject, "hce_page_size");
                        JSONObject m843c3 = C4389j.m843c(jSONObject, "hce_button");
                        String m846a15 = C4389j.m846a(m843c3, "label");
                        String m846a16 = C4389j.m846a(m843c3, "htmlLabel");
                        if (TextUtils.isEmpty(m846a14)) {
                            C4171c.f22227bD.f22327bq = m846a15;
                        } else {
                            C4171c.f22227bD.f22327bq = m846a14;
                        }
                        if (TextUtils.isEmpty(m846a16)) {
                            C4171c.f22227bD.f22328br = m846a15;
                        } else {
                            C4171c.f22227bD.f22328br = m846a16;
                        }
                        this.f22670u = C4389j.m846a(m843c3, "action");
                        this.f22671v = C4389j.m846a(m843c3, "reserved");
                        this.f22672w = C4389j.m846a(jSONObject, "iss_ins_code");
                        this.f22673x = C4389j.m844b(jSONObject, "hce_bank_timeout");
                        this.f22674y = C4389j.m844b(jSONObject, "hce_concurrent_count");
                        int m844b = C4389j.m844b(jSONObject, "hce_pay_timeout");
                        if (m844b != 0) {
                            this.f22590a.f22455be = m844b;
                        } else {
                            this.f22590a.f22455be = UIMsg.m_AppUI.MSG_APP_GPS;
                        }
                        this.f22590a.f22459bi = C4389j.m846a(jSONObject, "no_hce_card_msg");
                    }
                    C4173b c4173b = this.f22590a;
                    c4173b.f22480p = new HashMap<>();
                    JSONObject m843c4 = C4389j.m843c(jSONObject, "f55");
                    String m846a17 = C4389j.m846a(m843c4, "order_amount");
                    c4173b.f22480p.put("trans_amt", (m846a17 == null || m846a17.length() <= 0) ? Constant.DEFAULT_BALANCE : m846a17);
                    c4173b.f22462bp = C4382c.m880c(m846a17);
                    String m846a18 = C4389j.m846a(m843c4, "order_currency");
                    c4173b.f22480p.put("trans currcy code", (m846a18 == null || m846a18.length() <= 0) ? "0156" : m846a18);
                    c4173b.f22463bq = m846a18;
                    String m846a19 = C4389j.m846a(m843c4, "trans_type");
                    c4173b.f22480p.put("trans_type", (m846a19 == null || m846a19.length() <= 0) ? "00" : "00");
                    String m846a20 = C4389j.m846a(m843c4, "mer_name");
                    c4173b.f22480p.put("mer_name", (m846a20 == null || m846a20.length() <= 0) ? "" : "");
                    if (this.f22590a.f22403aD) {
                        this.f22590a.f22485u = "";
                    }
                    if (this.f22656A.equalsIgnoreCase("00")) {
                        if (m1416b(this.f22590a.f22485u)) {
                            this.f22657B = 2;
                            this.f22594e.m1490m(String.format("\"user_id\":\"%s\"", this.f22590a.f22485u));
                            break;
                        }
                        m1370u();
                        break;
                    }
                }
                m1378a(this.f22656A, m846a5, m846a6);
                break;
            case 2:
                C4190f.m1474c(this.f22590a, jSONObject);
                int m1475b = C4190f.m1475b(this.f22590a, jSONObject);
                if (m1475b != 0) {
                    mo1137b(m1475b);
                    break;
                } else {
                    String m846a21 = C4389j.m846a(jSONObject, "userId");
                    if (!TextUtils.isEmpty(m846a21)) {
                        String[] strArr5 = C4394o.f23202e;
                        new Object[1][0] = m846a21;
                    }
                    this.f22662G = C4190f.m1476a(jSONObject);
                    m1370u();
                    break;
                }
        }
        C4390k.m838a("uppay", "init.parserParamJsonObj() ---");
    }

    /* renamed from: a */
    public final void m1377a(boolean z) {
        this.f22590a.f22449ax = z;
    }

    @Override // com.unionpay.mobile.android.nocard.views.AbstractC4219b
    /* renamed from: b */
    public final void mo1137b(int i) {
        C4390k.m838a("uppay", toString() + "doErrHappended() +++");
        m1376b(i, "fail");
        C4390k.m838a("uppay", toString() + "doErrHappended() ---");
    }

    /* renamed from: c */
    public final void m1375c(String str) {
        this.f22591b.m635a(C4171c.f22227bD.f22248U);
        new Thread(new RunnableC4396q(this.f22593d, str, this)).start();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.unionpay.mobile.android.nocard.views.AbstractC4219b
    /* renamed from: d */
    public final void mo1373d() {
        super.mo1373d();
        this.f22602m.setBackgroundColor(-1);
        setBackgroundDrawable(this.f22592c.m1037a(3008, -1, -1));
        int i = C4149a.f22105I / 2;
        ImageView imageView = new ImageView(getContext());
        imageView.setImageDrawable(this.f22592c.m1037a(1027, i, -1));
        imageView.setId(imageView.hashCode());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, -2);
        layoutParams.addRule(14);
        layoutParams.leftMargin = C4149a.f22121j;
        layoutParams.topMargin = (int) (C4149a.f22131t * 0.3f);
        addView(imageView, layoutParams);
        this.f22675z = new ProgressBar(getContext(), null, 16843399);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(14, -1);
        layoutParams2.addRule(3, imageView.getId());
        layoutParams2.topMargin = C4149a.f22115d * 3;
        addView(this.f22675z, layoutParams2);
        LinearLayout linearLayout = new LinearLayout(this.f22593d);
        linearLayout.setOrientation(1);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(14, -1);
        layoutParams3.addRule(12, -1);
        layoutParams3.bottomMargin = C4149a.f22113b;
        addView(linearLayout, layoutParams3);
        TextView textView = new TextView(this.f22593d);
        textView.setText(C4171c.f22227bD.f22254a);
        textView.setTextColor(-1);
        textView.setTextSize(14.0f);
        textView.setGravity(1);
        new LinearLayout.LayoutParams(-2, -2).gravity = 14;
        linearLayout.addView(textView, layoutParams3);
        TextView textView2 = new TextView(getContext());
        textView2.setText(C4171c.f22227bD.f22307b);
        textView2.setTextColor(-1);
        textView2.setTextSize(16.0f);
        textView2.setGravity(1);
        new LinearLayout.LayoutParams(-2, -2).gravity = 14;
        linearLayout.addView(textView2, layoutParams3);
    }

    @Override // com.unionpay.mobile.android.nocard.views.AbstractC4219b
    /* renamed from: k */
    public final void mo1056k() {
    }

    /* renamed from: r */
    public final void m1371r() {
        int i;
        UPPayEngine uPPayEngine;
        String str;
        if (this.f22666K) {
            return;
        }
        this.f22666K = true;
        mo1158v();
        this.f22660E = false;
        Activity activity = this.f22664I;
        boolean z = this.f22665J;
        this.f22594e.m1518a();
        try {
            i = Integer.parseInt(this.f22590a.f22383I.f22845c);
        } catch (NumberFormatException unused) {
            i = 0;
        }
        this.f22663H = this.f22594e.initJNIEnv(activity, this.f22590a.f22470f ? 2 : this.f22590a.f22467c ? 1 : 0, i, !"com.unionpay.uppay".equals(C4385f.m869b(this.f22593d)), this.f22590a.f22401a, this.f22590a.f22414aO, C4382c.m881b(this.f22590a.f22470f ? this.f22590a.f22468d : this.f22590a.f22452b));
        if (z) {
            long j = this.f22663H;
            if (j != 0 && j != -1) {
                this.f22657B = 1;
                this.f22594e.m1517a(this.f22663H);
                if (this.f22590a.f22470f) {
                    uPPayEngine = this.f22594e;
                    str = this.f22590a.f22469e;
                } else {
                    uPPayEngine = this.f22594e;
                    str = this.f22590a.f22452b;
                }
                uPPayEngine.m1509b(str, Constant.DEFAULT_CVN2);
                this.f22594e.m1515a(this);
                return;
            }
        }
        if (this.f22663H == -1) {
            m1376b(7, (String) null);
        } else if (z) {
        } else {
            m1376b(5, (String) null);
        }
    }

    /* renamed from: s */
    public boolean mo1155s() {
        return false;
    }

    /* renamed from: t */
    public boolean mo1154t() {
        return false;
    }

    /* renamed from: u */
    public final void m1370u() {
        if (this.f22656A.equalsIgnoreCase("02")) {
            m1406j();
            return;
        }
        this.f22658C++;
        this.f22660E = true;
        m1366z();
    }

    /* renamed from: v */
    public void mo1158v() {
        m1369w();
    }

    /* renamed from: w */
    public final void m1369w() {
        this.f22658C++;
        m1366z();
    }

    /* renamed from: x */
    public final void m1368x() {
        removeAllViews();
        this.f22675z = null;
    }
}
