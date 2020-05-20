package com.cnlaunch.x431pro.activity.mine;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cnlaunch.golo3.p165g.C1621v;
import com.cnlaunch.golo3.p165g.UserFaceUtils;
import com.cnlaunch.golo3.view.selectimg.ImgThumbBean;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.p120d.p130d.p131a.LangManager;
import com.cnlaunch.x431pro.activity.BaseFragment;
import com.cnlaunch.x431pro.activity.golo.p225b.InfaceFragmentParent;
import com.cnlaunch.x431pro.activity.golo.p225b.OnActivityResultListenter;
import com.cnlaunch.x431pro.activity.setting.DiagsoftRewardFragment;
import com.cnlaunch.x431pro.module.p241a.CommonResponse;
import com.cnlaunch.x431pro.module.p272k.p273a.UserAction;
import com.cnlaunch.x431pro.module.p272k.p274b.FaceSettingRespone;
import com.cnlaunch.x431pro.module.p272k.p274b.User;
import com.cnlaunch.x431pro.module.p272k.p274b.UserBaseInfo;
import com.cnlaunch.x431pro.module.p272k.p274b.UserBaseInfoResponse;
import com.cnlaunch.x431pro.module.p272k.p274b.UserSettingInfo;
import com.cnlaunch.x431pro.p210a.CommonTools;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.utils.C2778n;
import com.cnlaunch.x431pro.utils.C2787z;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.cnlaunch.x431pro.widget.p290a.LoginDialog;
import com.ifoer.expedition.pro.R;
import com.p297e.p298a.p306b.DisplayImageOptions;
import com.p297e.p298a.p306b.ImageLoader;
import com.p297e.p298a.p306b.p310c.RoundedBitmapDisplayer;
import java.util.Locale;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

/* renamed from: com.cnlaunch.x431pro.activity.mine.bt */
/* loaded from: classes.dex */
public class PersonInformationFragment extends BaseFragment implements View.OnClickListener, OnActivityResultListenter {

    /* renamed from: A */
    private RelativeLayout f13953A;

    /* renamed from: B */
    private RelativeLayout f13954B;

    /* renamed from: C */
    private RelativeLayout f13955C;

    /* renamed from: D */
    private RelativeLayout f13956D;

    /* renamed from: E */
    private RelativeLayout f13957E;

    /* renamed from: F */
    private RelativeLayout f13958F;

    /* renamed from: G */
    private RelativeLayout f13959G;

    /* renamed from: H */
    private RelativeLayout f13960H;

    /* renamed from: I */
    private RelativeLayout f13961I;

    /* renamed from: P */
    private UserAction f13968P;

    /* renamed from: Q */
    private UserBaseInfo f13969Q;

    /* renamed from: R */
    private String f13970R;

    /* renamed from: S */
    private String f13971S;

    /* renamed from: U */
    private UserAction f13973U;

    /* renamed from: V */
    private RadioButton f13974V;

    /* renamed from: W */
    private RadioButton f13975W;

    /* renamed from: X */
    private RadioGroup f13976X;

    /* renamed from: Z */
    private ImageView f13978Z;

    /* renamed from: b */
    DisplayImageOptions f13981b;

    /* renamed from: f */
    private TextView f13985f;

    /* renamed from: g */
    private TextView f13986g;

    /* renamed from: h */
    private TextView f13987h;

    /* renamed from: i */
    private TextView f13988i;

    /* renamed from: j */
    private TextView f13989j;

    /* renamed from: k */
    private TextView f13990k;

    /* renamed from: l */
    private TextView f13991l;

    /* renamed from: m */
    private TextView f13992m;

    /* renamed from: n */
    private TextView f13993n;

    /* renamed from: o */
    private TextView f13994o;

    /* renamed from: p */
    private TextView f13995p;

    /* renamed from: q */
    private TextView f13996q;

    /* renamed from: r */
    private TextView f13997r;

    /* renamed from: s */
    private TextView f13998s;

    /* renamed from: t */
    private TextView f13999t;

    /* renamed from: u */
    private TextView f14000u;

    /* renamed from: v */
    private TextView f14001v;

    /* renamed from: w */
    private RadioButton f14002w;

    /* renamed from: x */
    private LinearLayout f14003x;

    /* renamed from: y */
    private RelativeLayout f14004y;

    /* renamed from: z */
    private RelativeLayout f14005z;

    /* renamed from: e */
    private final int f13984e = 2104;

    /* renamed from: J */
    private String f13962J = "";

    /* renamed from: K */
    private String f13963K = "";

    /* renamed from: L */
    private String f13964L = "";

    /* renamed from: M */
    private String f13965M = "";

    /* renamed from: N */
    private String f13966N = "";

    /* renamed from: O */
    private String f13967O = "";

    /* renamed from: T */
    private LoginDialog f13972T = null;

    /* renamed from: Y */
    private String f13977Y = "0";

    /* renamed from: a */
    BroadcastReceiver f13979a = new C2446bu(this);

    /* renamed from: c */
    InfaceFragmentParent f13982c = null;

    /* renamed from: aa */
    private String f13980aa = "";

    /* renamed from: d */
    ImgThumbBean f13983d = null;

    @Override // com.cnlaunch.x431pro.activity.golo.p225b.OnActivityResultListenter
    /* renamed from: a */
    public final long mo5997a() {
        return 0L;
    }

    @Override // com.cnlaunch.x431pro.activity.golo.p225b.OnActivityResultListenter
    /* renamed from: a */
    public final boolean mo5995a(KeyEvent keyEvent) {
        return false;
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f13973U = new UserAction(this.mContext);
        IntentFilter intentFilter = new IntentFilter("login");
        intentFilter.addAction("logout");
        this.mContext.registerReceiver(this.f13979a, intentFilter);
        if (this.f13981b == null) {
            DisplayImageOptions.C3010a c3010a = new DisplayImageOptions.C3010a();
            c3010a.f17117a = R.drawable.login_default;
            c3010a.f17118b = R.drawable.login_default;
            c3010a.f17119c = R.drawable.login_default;
            c3010a.f17129m = true;
            c3010a.f17133q = new RoundedBitmapDisplayer(90);
            this.f13981b = c3010a.m4193a();
        }
        try {
            this.f13982c = (InfaceFragmentParent) getActivity();
            if (this.f13982c != null) {
                this.f13982c.mo6035a(this);
            }
        } catch (Exception e) {
            Log.e("Sanda", "infaceFragmentParent Error:" + e.toString());
        }
        setTitle(R.string.mine_title_information);
        setLeftImage(this.mContext.getResources().getDrawable(R.drawable.select_btn_menu_two));
        this.f13978Z = (ImageView) getActivity().findViewById(R.id.img_face);
        this.f13978Z.setOnClickListener(this);
        this.f13985f = (TextView) getActivity().findViewById(R.id.tv_mine_name);
        this.f13986g = (TextView) getActivity().findViewById(R.id.tv_mine_nickname);
        this.f13953A = (RelativeLayout) getActivity().findViewById(R.id.rl_mine_nickname);
        this.f13953A.setOnClickListener(this);
        this.f13987h = (TextView) getActivity().findViewById(R.id.tv_mine_email);
        this.f13988i = (TextView) getActivity().findViewById(R.id.tv_mine_phone);
        this.f13989j = (TextView) getActivity().findViewById(R.id.tv_mine_areas);
        this.f14000u = (TextView) getActivity().findViewById(R.id.tv_bind_email_state);
        this.f14001v = (TextView) getActivity().findViewById(R.id.tv_bind_phone_state);
        this.f13990k = (TextView) getActivity().findViewById(R.id.tv_mine_company);
        this.f13991l = (TextView) getActivity().findViewById(R.id.tv_mine_address);
        this.f13992m = (TextView) getActivity().findViewById(R.id.tv_mine_contact);
        this.f13993n = (TextView) getActivity().findViewById(R.id.tv_mine_qq);
        this.f13994o = (TextView) getActivity().findViewById(R.id.tv_mine_weixin);
        this.f13995p = (TextView) getActivity().findViewById(R.id.company_red);
        this.f13996q = (TextView) getActivity().findViewById(R.id.address_red);
        this.f13997r = (TextView) getActivity().findViewById(R.id.contact_red);
        this.f13998s = (TextView) getActivity().findViewById(R.id.qq_red);
        this.f13999t = (TextView) getActivity().findViewById(R.id.weixin_red);
        this.f14005z = (RelativeLayout) getActivity().findViewById(R.id.rl_mine_sex);
        this.f14005z.setOnClickListener(this);
        this.f13954B = (RelativeLayout) getActivity().findViewById(R.id.rl_mine_email);
        if (C2744aa.m5151f() && Locale.getDefault().getLanguage().equalsIgnoreCase("ja")) {
            this.f13954B.setClickable(false);
        } else {
            this.f13954B.setOnClickListener(this);
        }
        this.f13955C = (RelativeLayout) getActivity().findViewById(R.id.rl_mine_phone);
        this.f13955C.setOnClickListener(this);
        this.f13956D = (RelativeLayout) getActivity().findViewById(R.id.rl_mine_areas);
        this.f13956D.setOnClickListener(this);
        this.f13974V = (RadioButton) getActivity().findViewById(R.id.radio_male);
        this.f13974V.setOnClickListener(this);
        this.f13975W = (RadioButton) getActivity().findViewById(R.id.radio_female);
        this.f13975W.setOnClickListener(this);
        this.f13976X = (RadioGroup) getActivity().findViewById(R.id.radiogroup_sex_setting);
        this.f13976X.setVisibility(8);
        this.f13957E = (RelativeLayout) getActivity().findViewById(R.id.rl_mine_company);
        this.f13957E.setOnClickListener(this);
        this.f13958F = (RelativeLayout) getActivity().findViewById(R.id.rl_mine_address);
        this.f13958F.setOnClickListener(this);
        this.f13959G = (RelativeLayout) getActivity().findViewById(R.id.rl_mine_contact);
        this.f13959G.setOnClickListener(this);
        this.f13960H = (RelativeLayout) getActivity().findViewById(R.id.rl_mine_qq);
        this.f13960H.setOnClickListener(this);
        this.f13961I = (RelativeLayout) getActivity().findViewById(R.id.rl_mine_weixin);
        this.f13961I.setOnClickListener(this);
        this.f14004y = (RelativeLayout) getActivity().findViewById(R.id.rl_mine_reward);
        this.f14002w = (RadioButton) getActivity().findViewById(R.id.btn_diagsoft_reward);
        this.f14002w.setOnClickListener(this);
        if (C2744aa.m5125r()) {
            this.f14004y.setVisibility(8);
        }
        this.f14003x = (LinearLayout) getActivity().findViewById(R.id.linear_contact_info);
        if (!C2744aa.m5125r()) {
            this.f14003x.setVisibility(8);
            this.f13955C.setVisibility(8);
        }
        if (!CommonTools.m7969a(getActivity())) {
            LoadDialog.m4681b(this.mContext);
            return;
        }
        NLog.m9456a("Sanda", "onResume");
        request(2104);
        LoadDialog.m4686a(this.mContext);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.person_information_fragment, viewGroup, false);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.mContext.unregisterReceiver(this.f13979a);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public Object doInBackground(int i) throws C1425f {
        if (i == 2104) {
            this.f13968P = new UserAction(this.mContext);
            return this.f13968P.m5256c(LangManager.m9469a(), (String) null);
        } else if (i == 30002) {
            return this.f13973U.m5248h(this.f13977Y);
        } else {
            switch (i) {
                case 30004:
                    UserSettingInfo userSettingInfo = new UserSettingInfo();
                    userSettingInfo.setNickname(this.f13980aa);
                    userSettingInfo.setCompany(this.f13962J);
                    userSettingInfo.setAddress(this.f13963K);
                    userSettingInfo.setContact(this.f13964L);
                    userSettingInfo.setQq(this.f13965M);
                    userSettingInfo.setWeixin(this.f13966N);
                    return this.f13968P.m5270a(userSettingInfo);
                case 30005:
                    UserSettingInfo userSettingInfo2 = new UserSettingInfo();
                    userSettingInfo2.setPic(this.f13983d.getImg());
                    PreferencesManager.m9595a((Context) getActivity()).m9584b("user_id", "");
                    return this.f13968P.m5262b(userSettingInfo2);
                default:
                    return super.doInBackground(i);
            }
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onSuccess(int i, Object obj) {
        String str;
        String str2;
        super.onSuccess(i, obj);
        if (i != 2104) {
            if (i == 30002) {
                LoadDialog.m4681b(this.mContext);
                return;
            }
            switch (i) {
                case 30004:
                    LoadDialog.m4681b(getActivity());
                    if (((CommonResponse) obj).getCode() == 0) {
                        this.f13986g.setText(this.f13980aa);
                        this.f13990k.setText(this.f13962J);
                        this.f13991l.setText(this.f13963K);
                        this.f13992m.setText(this.f13964L);
                        this.f13993n.setText(this.f13965M);
                        this.f13994o.setText(this.f13966N);
                        User user = (User) PreferencesManager.m9595a((Context) getActivity()).m9593a(User.class);
                        user.setNick_name(this.f13980aa);
                        PreferencesManager.m9595a((Context) getActivity()).m9592a((PreferencesManager) user);
                        m6271b();
                        return;
                    }
                    return;
                case 30005:
                    if (obj != null) {
                        if (isSuccess(((FaceSettingRespone) obj).getCode())) {
                            ImageLoader.m4191a().m4186b();
                            ImageLoader.m4191a().m4184c();
                            UserFaceUtils.m9114a(PreferencesManager.m9595a(this.mContext).m9591a("user_id"), null, PreferencesManager.m9595a(this.mContext).m9591a("current_country").equalsIgnoreCase("CN") ? "1" : "2");
                            this.f13978Z.setImageBitmap(BitmapFactory.decodeFile(this.f13983d.getImgthumb()));
                            try {
                                this.mContext.sendBroadcast(new Intent("changeFace"));
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } else {
                            NToast.m9446b(this.mContext, getString(R.string.personal_infomation_update_failed));
                        }
                        LoadDialog.m4681b(getActivity());
                        return;
                    }
                    NToast.m9446b(this.mContext, getString(R.string.personal_infomation_update_failed));
                    LoadDialog.m4681b(getActivity());
                    return;
                default:
                    return;
            }
        }
        if (obj != null) {
            UserBaseInfoResponse userBaseInfoResponse = (UserBaseInfoResponse) obj;
            if (isSuccess(userBaseInfoResponse.getCode())) {
                this.f13969Q = userBaseInfoResponse.getData();
                ImageLoader.m4191a().m4185b(UserFaceUtils.m9114a(PreferencesManager.m9595a(this.mContext).m9591a("user_id"), null, PreferencesManager.m9595a(this.mContext).m9591a("current_country").equalsIgnoreCase("CN") ? "1" : "2"), this.f13978Z, this.f13981b);
                this.f13985f.setText(this.f13969Q.getUser_name());
                this.f13987h.setText(this.f13969Q.getEmail());
                this.f13988i.setText(this.f13969Q.getMobile());
                StringBuilder sb = new StringBuilder();
                sb.append(this.f13969Q.getIs_bind_mobile());
                this.f13970R = sb.toString();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.f13969Q.getIs_bind_email());
                this.f13971S = sb2.toString();
                if (this.f13969Q.getIs_bind_mobile().intValue() == 0) {
                    this.f14001v.setText(R.string.mine_not_bind);
                } else {
                    this.f14001v.setText(R.string.mine_bind);
                }
                if (this.f13969Q.getIs_bind_email().intValue() == 0) {
                    this.f14000u.setText(R.string.mine_not_bind);
                } else {
                    this.f14000u.setText(R.string.mine_bind);
                }
                this.f13986g.setText(this.f13969Q.getNick_name());
                StringBuilder sb3 = new StringBuilder();
                sb3.append(this.f13969Q.getCountry());
                if (TextUtils.isEmpty(this.f13969Q.getProvince())) {
                    str = "";
                } else {
                    str = MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.f13969Q.getProvince();
                }
                sb3.append(str);
                if (TextUtils.isEmpty(this.f13969Q.getCity())) {
                    str2 = "";
                } else {
                    str2 = MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.f13969Q.getCity();
                }
                sb3.append(str2);
                this.f13989j.setText(sb3.toString());
                StringBuilder sb4 = new StringBuilder();
                sb4.append(this.f13969Q.getSex());
                this.f13977Y = sb4.toString();
                this.f13962J = this.f13969Q.getCompany();
                this.f13963K = this.f13969Q.getAddress();
                this.f13964L = this.f13969Q.getContact();
                this.f13965M = this.f13969Q.getQq();
                this.f13966N = this.f13969Q.getWeixin();
                this.f13980aa = this.f13969Q.getNick_name();
                m6271b();
                this.f13990k.setText(this.f13969Q.getCompany());
                this.f13992m.setText(this.f13969Q.getContact());
                this.f13991l.setText(this.f13969Q.getAddress());
                this.f13993n.setText(this.f13969Q.getQq());
                this.f13994o.setText(this.f13969Q.getWeixin());
                m6273a(this.f13977Y);
            }
        }
        LoadDialog.m4681b(this.mContext);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onFailure(int i, int i2, Object obj) {
        super.onFailure(i, i2, obj);
        if (i == 2104) {
            LoadDialog.m4681b(this.mContext);
            if (-300 == i2) {
                LoginDialog loginDialog = this.f13972T;
                if (loginDialog == null || !loginDialog.isShowing()) {
                    this.f13972T = new C2447bv(this, this.mContext).m6572d();
                }
            }
        } else if (i == 30002) {
            LoadDialog.m4681b(this.mContext);
        } else {
            switch (i) {
                case 30004:
                    LoadDialog.m4681b(getActivity());
                    return;
                case 30005:
                    LoadDialog.m4681b(getActivity());
                    NToast.m9446b(this.mContext, getString(R.string.personal_infomation_update_failed));
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_diagsoft_reward /* 2131296439 */:
                replaceFragment(DiagsoftRewardFragment.class.getName(), 1);
                return;
            case R.id.img_face /* 2131297152 */:
                if (CommonTools.m7969a(getActivity())) {
                    replaceFragment(ChangeFaceFragment.class.getName());
                    return;
                }
                return;
            case R.id.radio_female /* 2131297684 */:
            case R.id.radio_male /* 2131297688 */:
            case R.id.rl_mine_sex /* 2131297781 */:
                if (!CommonTools.m7969a(getActivity())) {
                    m6273a(this.f13977Y);
                    return;
                }
                this.f13977Y = this.f13977Y.equalsIgnoreCase("1") ? "0" : "1";
                m6273a(this.f13977Y);
                LoadDialog.m4686a(this.mContext);
                request(30002);
                return;
            case R.id.rl_mine_address /* 2131297771 */:
                this.f13967O = getString(R.string.register_hint_address);
                this.f13963K = this.f13991l.getText().toString();
                m6272a(this.f13967O, this.f13963K);
                return;
            case R.id.rl_mine_areas /* 2131297772 */:
                if (CommonTools.m7969a(getActivity())) {
                    if (!C2778n.m4917a(this.mContext)) {
                        NToast.m9450a(this.mContext, (int) R.string.common_network_unavailable);
                        return;
                    } else {
                        replaceFragment(CountryFragment.class.getName());
                        return;
                    }
                }
                return;
            case R.id.rl_mine_company /* 2131297773 */:
                this.f13967O = getString(R.string.register_hint_company);
                this.f13962J = this.f13990k.getText().toString();
                m6272a(this.f13967O, this.f13962J);
                return;
            case R.id.rl_mine_contact /* 2131297774 */:
                this.f13967O = getString(R.string.register_hint_contact);
                this.f13964L = this.f13992m.getText().toString();
                m6272a(this.f13967O, this.f13964L);
                return;
            case R.id.rl_mine_email /* 2131297775 */:
                if (CommonTools.m7969a(getActivity())) {
                    if (!C2778n.m4917a(this.mContext)) {
                        NToast.m9450a(this.mContext, (int) R.string.common_network_unavailable);
                        return;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putString("email", this.f13987h.getText().toString());
                    bundle.putString("is_bind_email", this.f13971S);
                    replaceFragment(ChangeEmailFragment.class.getName(), bundle);
                    return;
                }
                return;
            case R.id.rl_mine_nickname /* 2131297777 */:
                this.f13967O = getString(R.string.personal_infomation_nickname);
                this.f13980aa = this.f13986g.getText().toString();
                m6272a(this.f13967O, this.f13980aa);
                return;
            case R.id.rl_mine_phone /* 2131297778 */:
                if (CommonTools.m7969a(getActivity())) {
                    if (!C2778n.m4917a(this.mContext)) {
                        NToast.m9450a(this.mContext, (int) R.string.common_network_unavailable);
                        return;
                    }
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("phone_number", this.f13988i.getText().toString());
                    bundle2.putString("is_bind_mobile", this.f13970R);
                    replaceFragment(ChangePhoneFragment.class.getName(), bundle2);
                    return;
                }
                return;
            case R.id.rl_mine_qq /* 2131297779 */:
                this.f13967O = getString(R.string.register_hint_qq);
                this.f13965M = this.f13993n.getText().toString();
                m6272a(this.f13967O, this.f13965M);
                return;
            case R.id.rl_mine_weixin /* 2131297782 */:
                this.f13967O = getString(R.string.register_hint_weixin);
                this.f13966N = this.f13994o.getText().toString();
                m6272a(this.f13967O, this.f13966N);
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    private void m6273a(String str) {
        if ("1".equals(str)) {
            this.f13974V.setChecked(true);
            this.f13974V.setText(R.string.mine_tv_male);
            this.f13975W.setText(R.string.mine_tv_female);
            this.f13976X.setBackgroundResource(R.drawable.bg_radio_setting_blue);
            this.f13976X.setVisibility(0);
            return;
        }
        this.f13975W.setChecked(true);
        this.f13974V.setText(R.string.mine_tv_male);
        this.f13975W.setText(R.string.mine_tv_female);
        this.f13976X.setBackgroundResource(R.drawable.bg_radio_setting_pink);
        this.f13976X.setVisibility(0);
    }

    /* renamed from: b */
    private void m6271b() {
        if (C1621v.m9121a(this.f13962J)) {
            this.f13995p.setVisibility(0);
        } else {
            this.f13995p.setVisibility(8);
        }
        if (C1621v.m9121a(this.f13963K)) {
            this.f13996q.setVisibility(0);
        } else {
            this.f13996q.setVisibility(8);
        }
        if (C1621v.m9121a(this.f13964L)) {
            this.f13997r.setVisibility(0);
        } else {
            this.f13997r.setVisibility(8);
        }
        if (C1621v.m9121a(this.f13965M)) {
            this.f13998s.setVisibility(0);
        } else {
            this.f13998s.setVisibility(8);
        }
        if (C1621v.m9121a(this.f13966N)) {
            this.f13999t.setVisibility(0);
        } else {
            this.f13999t.setVisibility(8);
        }
    }

    /* renamed from: a */
    private void m6272a(String str, String str2) {
        DialogC2448bw dialogC2448bw = new DialogC2448bw(this, getActivity(), str, str2, str);
        getActivity();
        dialogC2448bw.m4702d();
    }

    @Override // com.cnlaunch.x431pro.activity.golo.p225b.OnActivityResultListenter
    /* renamed from: a */
    public final void mo5996a(int i, int i2, Intent intent) {
        Log.i("Sanda", "Mine onActivityResult" + i + "   " + i2);
        if (intent != null && i == 11 && i2 == -1) {
            this.f13983d = (ImgThumbBean) intent.getSerializableExtra("imgPath");
            Log.i("Sanda", this.f13983d.getImg());
            Log.e("Sanda", this.f13983d.getImgthumb());
            if (this.f13983d != null) {
                LoadDialog.m4686a(getActivity());
                request(30005);
            }
        }
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        InfaceFragmentParent infaceFragmentParent = this.f13982c;
        if (infaceFragmentParent != null) {
            infaceFragmentParent.mo6035a((OnActivityResultListenter) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m6274a(PersonInformationFragment personInformationFragment, String str) {
        boolean z = true;
        if (personInformationFragment.f13967O.equalsIgnoreCase(personInformationFragment.getString(R.string.register_hint_company))) {
            if (!personInformationFragment.f13962J.equalsIgnoreCase(str)) {
                personInformationFragment.f13962J = str;
            }
            z = false;
        } else if (personInformationFragment.f13967O.equalsIgnoreCase(personInformationFragment.getString(R.string.personal_infomation_nickname))) {
            if (!personInformationFragment.f13980aa.equalsIgnoreCase(str)) {
                personInformationFragment.f13980aa = str;
            }
            z = false;
        } else if (personInformationFragment.f13967O.equalsIgnoreCase(personInformationFragment.getString(R.string.register_hint_address))) {
            if (!personInformationFragment.f13963K.equalsIgnoreCase(str)) {
                personInformationFragment.f13963K = str;
            }
            z = false;
        } else if (personInformationFragment.f13967O.equalsIgnoreCase(personInformationFragment.getString(R.string.register_hint_contact))) {
            if (!personInformationFragment.f13964L.equalsIgnoreCase(str)) {
                personInformationFragment.f13964L = str;
            }
            z = false;
        } else if (personInformationFragment.f13967O.equalsIgnoreCase(personInformationFragment.getString(R.string.register_hint_qq))) {
            if (!personInformationFragment.f13965M.equalsIgnoreCase(str)) {
                personInformationFragment.f13965M = str;
                if (!C2787z.m4815d(personInformationFragment.f13965M)) {
                    NToast.m9450a(personInformationFragment.mContext, (int) R.string.qq_invalid);
                    personInformationFragment.f13965M = "";
                    return;
                }
            }
            z = false;
        } else {
            if (personInformationFragment.f13967O.equalsIgnoreCase(personInformationFragment.getString(R.string.register_hint_weixin)) && !personInformationFragment.f13966N.equalsIgnoreCase(str)) {
                personInformationFragment.f13966N = str;
            }
            z = false;
        }
        if (z) {
            personInformationFragment.request(30004);
            LoadDialog.m4686a(personInformationFragment.mContext);
        }
    }
}
