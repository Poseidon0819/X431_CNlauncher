package com.cnlaunch.x431pro.activity.login;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.mapapi.UIMsg;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.activity.ActivityC2004c;
import com.cnlaunch.x431pro.module.p255e.p256a.ConnectorAction;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.utils.C2787z;
import com.cnlaunch.x431pro.utils.PathUtils;
import com.cnlaunch.x431pro.utils.p283db.SerialNumber;
import com.cnlaunch.x431pro.utils.p283db.SerialNumberDao;
import com.cnlaunch.x431pro.utils.p283db.p284a.DBManager;
import com.cnlaunch.x431pro.utils.p285e.FileUtils;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class ActivateJointActivity extends ActivityC2004c implements View.OnClickListener {

    /* renamed from: C */
    String f12976C;

    /* renamed from: E */
    String f12978E;

    /* renamed from: F */
    String f12979F;

    /* renamed from: U */
    private ConnectorAction f12994U;

    /* renamed from: V */
    private PreferencesManager f12995V;

    /* renamed from: W */
    private SerialNumberDao f12996W;

    /* renamed from: X */
    private TextView f12997X;

    /* renamed from: Y */
    private EditText f12998Y;

    /* renamed from: Z */
    private EditText f12999Z;

    /* renamed from: aa */
    private Button f13000aa;

    /* renamed from: ab */
    private TextView f13001ab;

    /* renamed from: ac */
    private LinearLayout f13002ac;

    /* renamed from: ad */
    private LinearLayout f13003ad;

    /* renamed from: ae */
    private String f13004ae;

    /* renamed from: af */
    private List<SerialNumber> f13005af;

    /* renamed from: ag */
    private List<SerialNumber> f13006ag;

    /* renamed from: ah */
    private boolean f13007ah;

    /* renamed from: n */
    String f13008n;

    /* renamed from: G */
    private final int f12980G = 2301;

    /* renamed from: H */
    private final int f12981H = 2302;

    /* renamed from: I */
    private final int f12982I = 401;

    /* renamed from: J */
    private final int f12983J = 405;

    /* renamed from: K */
    private final int f12984K = UIMsg.d_ResultType.SHORT_URL;

    /* renamed from: L */
    private final int f12985L = 650;

    /* renamed from: M */
    private final int f12986M = 651;

    /* renamed from: N */
    private final int f12987N = 652;

    /* renamed from: O */
    private final int f12988O = 655;

    /* renamed from: P */
    private final int f12989P = 656;

    /* renamed from: Q */
    private final int f12990Q = 658;

    /* renamed from: R */
    private final int f12991R = 659;

    /* renamed from: S */
    private final int f12992S = 660;

    /* renamed from: T */
    private final int f12993T = 851;

    /* renamed from: D */
    String f12977D = "86X";

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.support.p012v4.app.FragmentActivity, android.support.p012v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_activate_joint);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f13007ah = extras.getBoolean("FromRegister", false);
            this.f12978E = extras.getString("UserName", "");
            this.f12979F = extras.getString("PassWord", "");
        }
        this.f12994U = new ConnectorAction(this);
        this.f12995V = PreferencesManager.m9595a(this.f10981q);
        this.f12977D = this.f12995V.m9591a("venderCode");
        this.f12998Y = (EditText) findViewById(R.id.edit_serianumber);
        this.f12999Z = (EditText) findViewById(R.id.edit_verify_dcode);
        this.f13000aa = (Button) findViewById(R.id.bt_activate);
        this.f12997X = (TextView) findViewById(R.id.text_skip);
        if (!C2744aa.m5144h(this.f10981q)) {
            this.f12997X.setVisibility(8);
        }
        this.f13001ab = (TextView) findViewById(R.id.tv_veryficode);
        this.f13002ac = (LinearLayout) findViewById(R.id.layout_top);
        if (this.f13007ah) {
            m7743b();
            this.f13003ad = (LinearLayout) findViewById(R.id.merchant_title);
            if (!C2744aa.m5144h(this.f10981q)) {
                C2744aa.m5129p();
            }
            this.f13003ad.setVisibility(8);
            findViewById(R.id.editText4_0).setBackgroundResource(R.drawable.register_head_4);
        } else {
            this.f13002ac.setVisibility(8);
            setTitle(R.string.joint_activate);
            m7740c();
            m7737d(8);
        }
        this.f13004ae = this.f12995V.m9591a("serialNo");
        this.f12996W = DBManager.m5036a(this.f10981q).f15794a.f15798a;
        List<String> m4993i = FileUtils.m4993i(PathUtils.m4858c());
        if (m4993i != null) {
            m4993i.size();
        }
        this.f12997X.setOnClickListener(new View$OnClickListenerC2300a(this));
        this.f13000aa.setOnClickListener(this);
        this.f13001ab.setOnClickListener(new View$OnClickListenerC2328b(this));
        this.f12999Z.setOnEditorActionListener(new C2355c(this));
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.support.p012v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public Object doInBackground(int i) throws C1425f {
        switch (i) {
            case 2301:
                return this.f12994U.m5360a(this.f13008n, this.f12977D, this.f12976C);
            case 2302:
                ArrayList arrayList = new ArrayList();
                for (SerialNumber serialNumber : this.f13005af) {
                    arrayList.add(serialNumber.f15834d);
                }
                return this.f12994U.m5359a((List<String>) arrayList);
            default:
                return super.doInBackground(i);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0045  */
    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onSuccess(int r4, java.lang.Object r5) {
        /*
            Method dump skipped, instructions count: 680
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.x431pro.activity.login.ActivateJointActivity.onSuccess(int, java.lang.Object):void");
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onFailure(int i, int i2, Object obj) {
        super.onFailure(i, i2, obj);
        switch (i) {
            case 2301:
                LoadDialog.m4681b(this);
                return;
            case 2302:
                LoadDialog.m4681b(this);
                return;
            default:
                return;
        }
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 0) {
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != R.id.bt_activate) {
            return;
        }
        this.f13008n = this.f12998Y.getText().toString();
        this.f12976C = this.f12999Z.getText().toString();
        if (TextUtils.isEmpty(this.f13008n)) {
            NToast.m9450a(this, (int) R.string.connector_fill_in_serialno);
        } else if (TextUtils.isEmpty(this.f12976C)) {
            NToast.m9450a(this, (int) R.string.connector_fill_in_vercode);
        } else if (this.f13008n.length() != 12 || !C2787z.m4818b(this.f13008n) || (!C2744aa.m5168b(this.f13008n, this.f10981q) && !C2744aa.m5177a(this.f13008n, this.f10981q) && !C2744aa.m5161c(this.f13008n, this.f10981q))) {
            NToast.m9450a(this, (int) R.string.connector_serialno_wrong);
        } else {
            LoadDialog.m4686a(this);
            String m9584b = this.f12995V.m9584b("login_state", "0");
            if (m9584b == null || !m9584b.equals("1")) {
                NToast.m9450a(this, (int) R.string.login_tip);
                LoadDialog.m4681b(this);
                return;
            }
            m7739c(2301);
        }
    }
}
