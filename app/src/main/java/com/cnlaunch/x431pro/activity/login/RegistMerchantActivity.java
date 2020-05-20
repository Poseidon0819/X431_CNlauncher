package com.cnlaunch.x431pro.activity.login;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cnlaunch.diagnosemodule.wiget.NToast;
import com.cnlaunch.gmap.map.logic.p153a.LocationResult;
import com.cnlaunch.gmap.map.p150b.MapLocation;
import com.cnlaunch.gmap.p138a.FinalBitmap;
import com.cnlaunch.golo3.view.selectimg.ImgThumbBean;
import com.cnlaunch.golo3.view.selectimg.SelectPicActivity;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.x431pro.activity.ActivityC2004c;
import com.cnlaunch.x431pro.activity.login.RegistMerchantClass;
import com.cnlaunch.x431pro.utils.C2787z;
import com.ifoer.expedition.pro.R;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public class RegistMerchantActivity extends ActivityC2004c implements View.OnFocusChangeListener {

    /* renamed from: C */
    private CheckBox f13277C;

    /* renamed from: D */
    private ImageView f13278D;

    /* renamed from: F */
    private EditText f13280F;

    /* renamed from: G */
    private EditText f13281G;

    /* renamed from: H */
    private EditText f13282H;

    /* renamed from: I */
    private EditText f13283I;

    /* renamed from: J */
    private EditText f13284J;

    /* renamed from: K */
    private String f13285K;

    /* renamed from: L */
    private String f13286L;

    /* renamed from: M */
    private String f13287M;

    /* renamed from: N */
    private String f13288N;

    /* renamed from: P */
    private String f13290P;

    /* renamed from: S */
    private String f13293S;

    /* renamed from: T */
    private LinearLayout f13294T;

    /* renamed from: U */
    private boolean f13295U;

    /* renamed from: V */
    private TextView f13296V;

    /* renamed from: W */
    private TextView f13297W;

    /* renamed from: X */
    private TextView f13298X;

    /* renamed from: Y */
    private TextView f13299Y;

    /* renamed from: Z */
    private ImageView f13300Z;

    /* renamed from: aa */
    private LocationResult f13301aa;

    /* renamed from: ab */
    private MapLocation f13302ab;

    /* renamed from: ac */
    private FinalBitmap f13303ac;

    /* renamed from: ae */
    private LinearLayout f13305ae;

    /* renamed from: af */
    private TextView f13306af;

    /* renamed from: ag */
    private TextView f13307ag;

    /* renamed from: ah */
    private ArrayList<String> f13308ah;

    /* renamed from: n */
    private Button f13311n;

    /* renamed from: E */
    private ImgThumbBean f13279E = null;

    /* renamed from: O */
    private String f13289O = "";

    /* renamed from: Q */
    private String f13291Q = "";

    /* renamed from: R */
    private String f13292R = "";

    /* renamed from: ad */
    private HashMap<String, String> f13304ad = new HashMap<>();

    /* renamed from: ai */
    private RegistMerchantClass.InterfaceC2349a f13309ai = new C2341bm(this);

    /* renamed from: aj */
    private Handler f13310aj = new HandlerC2338bj(this);

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.support.p012v4.app.FragmentActivity, android.support.p012v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_registmerchant_regist);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f13295U = extras.getBoolean("FromRegister", false);
        }
        RegistMerchantClass.m6549a(this.f13309ai);
        this.f13280F = (EditText) findViewById(R.id.edit_merchant_account);
        this.f13281G = (EditText) findViewById(R.id.edit_merchant_companyname);
        this.f13282H = (EditText) findViewById(R.id.edit_merchant_companycontact);
        this.f13283I = (EditText) findViewById(R.id.edit_merchant_companymobile);
        this.f13284J = (EditText) findViewById(R.id.edit_regist_merchant_company_intro);
        this.f13280F.setOnFocusChangeListener(this);
        this.f13281G.setOnFocusChangeListener(this);
        this.f13282H.setOnFocusChangeListener(this);
        this.f13283I.setOnFocusChangeListener(this);
        this.f13300Z = (ImageView) findViewById(R.id.img_map_view);
        this.f13296V = (TextView) findViewById(R.id.seller_addres);
        this.f13297W = (TextView) findViewById(R.id.edit_merchant_companyaddress);
        this.f13299Y = (TextView) findViewById(R.id.text_protocol);
        this.f13306af = (TextView) findViewById(R.id.text_regist_merchant_repairmodel);
        this.f13307ag = (TextView) findViewById(R.id.text_carseries);
        this.f13277C = (CheckBox) findViewById(R.id.checkBox_select);
        this.f13277C.setOnCheckedChangeListener(new C2342bn(this));
        this.f13311n = (Button) findViewById(R.id.btn_submit);
        this.f13294T = (LinearLayout) findViewById(R.id.layout_top);
        if (this.f13295U) {
            m7743b();
        } else {
            this.f13294T.setVisibility(8);
            setTitle(R.string.regist_merchant_complete_info);
            m7740c();
            m7737d(8);
        }
        this.f13311n.setOnClickListener(new View$OnClickListenerC2343bo(this));
        this.f13299Y.setOnClickListener(new View$OnClickListenerC2344bp(this));
        this.f13278D = (ImageView) findViewById(R.id.img_merchant);
        this.f13278D.setOnClickListener(new View$OnClickListenerC2345bq(this));
        this.f13305ae = (LinearLayout) findViewById(R.id.layout_regist_merchant_repairmodel);
        this.f13305ae.setOnClickListener(new View$OnClickListenerC2346br(this));
        this.f13307ag.setOnClickListener(new View$OnClickListenerC2347bs(this));
        this.f13303ac = new FinalBitmap(this);
        this.f13298X = (TextView) findViewById(R.id.set_map);
        this.f13298X.setOnClickListener(new View$OnClickListenerC2348bt(this));
        new C2337bi(this).start();
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 0) {
            Intent intent = new Intent(this.f10981q, RegistMerchantHomePageActivity.class);
            intent.setFlags(67108864);
            intent.putExtra("FromRegister", this.f13295U);
            startActivity(intent);
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.support.p012v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (intent == null) {
            return;
        }
        switch (i) {
            case 16:
                if (i2 == -1) {
                    this.f13301aa = (LocationResult) intent.getSerializableExtra("result");
                    LocationResult locationResult = this.f13301aa;
                    if (locationResult != null) {
                        this.f13296V.setText(locationResult.getAddress());
                        double latitude = this.f13301aa.getLclatlng().getLatitude();
                        double longitude = this.f13301aa.getLclatlng().getLongitude();
                        this.f13291Q = String.valueOf(longitude);
                        this.f13292R = String.valueOf(latitude);
                        FinalBitmap finalBitmap = this.f13303ac;
                        ImageView imageView = this.f13300Z;
                        finalBitmap.m9409a(imageView, "http://maps.google.com/maps/api/staticmap?zoom=10&size=360x160&scale=2&markers=icon:http://file.us.api.dbscar.com/face/def/shop%7C" + latitude + "," + longitude);
                    }
                    this.f13297W.setText(this.f13301aa.getAddress());
                    return;
                }
                return;
            case 17:
                if (i2 == -1) {
                    this.f13279E = (ImgThumbBean) intent.getSerializableExtra("imgPath");
                    Log.i("weiwell", this.f13279E.getImg());
                    Log.e("weiwell", this.f13279E.getImgthumb());
                    ImgThumbBean imgThumbBean = this.f13279E;
                    if (imgThumbBean != null) {
                        this.f13278D.setImageURI(Uri.fromFile(new File(imgThumbBean.getImgthumb())));
                        return;
                    }
                    return;
                }
                return;
            case 18:
                if (i2 == -1) {
                    this.f13308ah = intent.getStringArrayListExtra("selectCarSeriesList");
                    StringBuilder sb = new StringBuilder();
                    if (this.f13308ah != null) {
                        for (int i3 = 0; i3 < this.f13308ah.size(); i3++) {
                            sb.append(this.f13308ah.get(i3));
                            if (this.f13308ah.size() - i3 > 1) {
                                sb.append(",");
                            }
                        }
                    }
                    this.f13307ag.setText(sb);
                    this.f13307ag.getPaint().setFlags(8);
                    this.f13307ag.getPaint().setAntiAlias(true);
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.support.p012v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        RegistMerchantClass.m6548b(this.f13309ai);
        super.onDestroy();
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.support.p012v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    /* renamed from: a */
    private boolean m6637a(EditText editText, String str) {
        int length = editText.getText().toString().length();
        if (length < 4 || length > 100) {
            NToast.shortToast(this.f10981q, getString(R.string.regist_merchant_input_tips_item, new Object[]{str}));
            return false;
        }
        return true;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        switch (view.getId()) {
            case R.id.edit_merchant_account /* 2131296939 */:
                if (z) {
                    return;
                }
                m6637a((EditText) view, getString(R.string.regist_merchant_merchantaccount));
                return;
            case R.id.edit_merchant_companyaddress /* 2131296940 */:
            default:
                return;
            case R.id.edit_merchant_companycontact /* 2131296941 */:
                if (z) {
                    return;
                }
                m6637a((EditText) view, getString(R.string.regist_merchant_companycontact));
                return;
            case R.id.edit_merchant_companymobile /* 2131296942 */:
                if (z) {
                    return;
                }
                m6637a((EditText) view, getString(R.string.regist_merchant_companymobile));
                return;
            case R.id.edit_merchant_companyname /* 2131296943 */:
                if (z) {
                    return;
                }
                m6637a((EditText) view, getString(R.string.regist_merchant_companyname));
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g */
    public static /* synthetic */ boolean m6627g(RegistMerchantActivity registMerchantActivity) {
        ImgThumbBean imgThumbBean = registMerchantActivity.f13279E;
        if (imgThumbBean != null) {
            String img = imgThumbBean.getImg();
            String m9591a = PreferencesManager.m9595a(registMerchantActivity.f10981q).m9591a("user_id");
            registMerchantActivity.f13285K = registMerchantActivity.f13280F.getText().toString();
            if (registMerchantActivity.m6637a(registMerchantActivity.f13280F, registMerchantActivity.getString(R.string.regist_merchant_merchantaccount))) {
                registMerchantActivity.f13286L = registMerchantActivity.f13281G.getText().toString();
                if (registMerchantActivity.m6637a(registMerchantActivity.f13281G, registMerchantActivity.getString(R.string.regist_merchant_companyname))) {
                    registMerchantActivity.f13287M = registMerchantActivity.f13282H.getText().toString();
                    if (registMerchantActivity.m6637a(registMerchantActivity.f13282H, registMerchantActivity.getString(R.string.regist_merchant_companycontact))) {
                        registMerchantActivity.f13288N = registMerchantActivity.f13283I.getText().toString();
                        if (registMerchantActivity.m6637a(registMerchantActivity.f13283I, registMerchantActivity.getString(R.string.regist_merchant_companymobile))) {
                            registMerchantActivity.f13289O = registMerchantActivity.f13297W.getText().toString();
                            registMerchantActivity.f13293S = registMerchantActivity.f13307ag.getText().toString();
                            if (C2787z.m4821a(registMerchantActivity.f13293S)) {
                                NToast.shortToast(registMerchantActivity.f10981q, registMerchantActivity.f10981q.getString(R.string.regist_merchant_input_tips_model, registMerchantActivity.f13306af.getText().toString()));
                                return false;
                            }
                            registMerchantActivity.f13290P = registMerchantActivity.f13284J.getText().toString();
                            registMerchantActivity.f13304ad.put("uid", m9591a);
                            registMerchantActivity.f13304ad.put("public_type", "2");
                            registMerchantActivity.f13304ad.put("public_name", registMerchantActivity.f13285K);
                            registMerchantActivity.f13304ad.put("company_name", registMerchantActivity.f13286L);
                            registMerchantActivity.f13304ad.put("nation", "325");
                            registMerchantActivity.f13304ad.put("address", registMerchantActivity.f13289O);
                            registMerchantActivity.f13304ad.put("longitude", registMerchantActivity.f13291Q);
                            registMerchantActivity.f13304ad.put("latitude", registMerchantActivity.f13292R);
                            registMerchantActivity.f13304ad.put("contact_person", registMerchantActivity.f13287M);
                            registMerchantActivity.f13304ad.put("contact_phone", registMerchantActivity.f13288N);
                            registMerchantActivity.f13304ad.put("car_brand", registMerchantActivity.f13293S);
                            registMerchantActivity.f13304ad.put("company_face", img);
                            registMerchantActivity.f13304ad.put("company_intro", registMerchantActivity.f13290P);
                            return true;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        NToast.shortToast(registMerchantActivity.f10981q, (int) R.string.regist_merchant_input_tips_pic);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: l */
    public static /* synthetic */ void m6622l(RegistMerchantActivity registMerchantActivity) {
        if (Environment.getExternalStorageState().equals("mounted")) {
            Intent intent = new Intent(registMerchantActivity, SelectPicActivity.class);
            intent.putExtra("getPicType", 1);
            intent.putExtra("maxNum", 1);
            intent.setFlags(67108864);
            registMerchantActivity.startActivityForResult(intent, 17);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: p */
    public static /* synthetic */ void m6618p(RegistMerchantActivity registMerchantActivity) {
        registMerchantActivity.f13302ab = new MapLocation();
        registMerchantActivity.f13302ab.f7566e = new C2339bk(registMerchantActivity);
        MapLocation mapLocation = registMerchantActivity.f13302ab;
        mapLocation.f7564c = registMerchantActivity;
        mapLocation.m9299a();
    }
}
