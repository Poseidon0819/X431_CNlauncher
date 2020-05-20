package com.cnlaunch.x431pro.activity.setting;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.activity.BaseFragment;
import com.cnlaunch.x431pro.activity.golo.p225b.InfaceFragmentParent;
import com.cnlaunch.x431pro.activity.golo.p225b.OnActivityResultListenter;
import com.cnlaunch.x431pro.module.p241a.BaseResponse;
import com.cnlaunch.x431pro.module.p272k.p273a.UserAction;
import com.cnlaunch.x431pro.module.p272k.p274b.ShopInfo;
import com.cnlaunch.x431pro.module.p272k.p274b.ShopInfoResponse;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.utils.C2778n;
import com.cnlaunch.x431pro.utils.C2787z;
import com.cnlaunch.x431pro.utils.PrintInfoProperties;
import com.cnlaunch.x431pro.utils.SelectPhotoUtils;
import com.cnlaunch.x431pro.utils.p285e.FileUtils;
import com.cnlaunch.x431pro.utils.p287g.ImageUtils;
import com.ifoer.expedition.pro.R;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* renamed from: com.cnlaunch.x431pro.activity.setting.ap */
/* loaded from: classes.dex */
public class PrintEditInfoFragment extends BaseFragment implements View.OnClickListener, View.OnFocusChangeListener, OnActivityResultListenter {

    /* renamed from: A */
    private static final String f14587A = Environment.getExternalStorageDirectory() + File.separator + "DCIM" + File.separator + "report_logo";

    /* renamed from: B */
    private static final String f14588B;

    /* renamed from: C */
    private static final String f14589C;

    /* renamed from: D */
    private static final String f14590D;

    /* renamed from: v */
    private static String f14591v = "";

    /* renamed from: w */
    private static PopupWindow f14592w;

    /* renamed from: E */
    private long f14593E = 0;

    /* renamed from: F */
    private InfaceFragmentParent f14594F = null;

    /* renamed from: G */
    private SelectPhotoUtils f14595G;

    /* renamed from: H */
    private String f14596H;

    /* renamed from: I */
    private UserAction f14597I;

    /* renamed from: a */
    RelativeLayout f14598a;

    /* renamed from: b */
    private PreferencesManager f14599b;

    /* renamed from: c */
    private PrintInfoProperties f14600c;

    /* renamed from: d */
    private EditText f14601d;

    /* renamed from: e */
    private EditText f14602e;

    /* renamed from: f */
    private EditText f14603f;

    /* renamed from: g */
    private EditText f14604g;

    /* renamed from: h */
    private EditText f14605h;

    /* renamed from: i */
    private EditText f14606i;

    /* renamed from: j */
    private Button f14607j;

    /* renamed from: k */
    private CheckBox f14608k;

    /* renamed from: l */
    private CheckBox f14609l;

    /* renamed from: m */
    private CheckBox f14610m;

    /* renamed from: n */
    private CheckBox f14611n;

    /* renamed from: o */
    private CheckBox f14612o;

    /* renamed from: p */
    private CheckBox f14613p;

    /* renamed from: q */
    private String f14614q;

    /* renamed from: r */
    private String f14615r;

    /* renamed from: s */
    private String f14616s;

    /* renamed from: t */
    private String f14617t;

    /* renamed from: u */
    private String f14618u;

    /* renamed from: x */
    private Bitmap f14619x;

    /* renamed from: y */
    private ImageView f14620y;

    /* renamed from: z */
    private TextView f14621z;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(f14587A);
        sb.append(File.separator);
        sb.append("report_logo.png");
        f14588B = sb.toString();
        f14589C = f14587A + File.separator + "report_logo_tmp2.png";
        f14590D = f14587A + File.separator + "report_logo_tmp.png";
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        File file = new File(f14587A);
        if (!file.exists()) {
            file.mkdirs();
        }
        setTitle(R.string.setting_printinfo_txt);
        setLeftImage(this.mContext.getResources().getDrawable(R.drawable.select_btn_menu_two));
        this.f14599b = PreferencesManager.m9595a(this.mContext);
        this.f14600c = PrintInfoProperties.m4838a();
        this.f14601d = (EditText) getActivity().findViewById(R.id.edit_garage_name);
        this.f14601d.setOnClickListener(this);
        this.f14602e = (EditText) getActivity().findViewById(R.id.edit_company_address);
        this.f14602e.setOnClickListener(this);
        this.f14603f = (EditText) getActivity().findViewById(R.id.edit_telephone);
        this.f14603f.setOnClickListener(this);
        this.f14605h = (EditText) getActivity().findViewById(R.id.edit_email);
        this.f14605h.setOnClickListener(this);
        this.f14604g = (EditText) getActivity().findViewById(R.id.edit_fax);
        this.f14604g.setOnClickListener(this);
        this.f14606i = (EditText) getActivity().findViewById(R.id.edit_license_plate_number);
        this.f14606i.setOnClickListener(this);
        this.f14607j = (Button) getActivity().findViewById(R.id.btn_save);
        this.f14607j.setOnClickListener(this);
        this.f14598a = (RelativeLayout) getActivity().findViewById(R.id.btn_logo_image);
        this.f14598a.setOnClickListener(this);
        this.f14620y = (ImageView) getActivity().findViewById(R.id.pop_iv01);
        this.f14621z = (TextView) getActivity().findViewById(R.id.pop_tv01);
        if (new File(f14588B).exists()) {
            this.f14599b.m9588a("report_logo_path", f14588B);
        }
        String m9591a = this.f14599b.m9591a("report_logo_path");
        f14591v = m9591a;
        if (m9591a.isEmpty()) {
            this.f14620y.setVisibility(8);
            this.f14621z.setVisibility(0);
        } else if (new File(f14591v).exists()) {
            this.f14619x = BitmapFactory.decodeFile(f14591v);
            this.f14620y.setImageBitmap(this.f14619x);
            this.f14620y.setVisibility(0);
            this.f14621z.setVisibility(8);
        }
        this.f14608k = (CheckBox) getActivity().findViewById(R.id.cb_garage_name);
        this.f14601d.setOnFocusChangeListener(this);
        this.f14609l = (CheckBox) getActivity().findViewById(R.id.cb_company_address);
        this.f14602e.setOnFocusChangeListener(this);
        this.f14610m = (CheckBox) getActivity().findViewById(R.id.cb_telephone);
        this.f14603f.setOnFocusChangeListener(this);
        this.f14611n = (CheckBox) getActivity().findViewById(R.id.cb_fax);
        this.f14604g.setOnFocusChangeListener(this);
        this.f14613p = (CheckBox) getActivity().findViewById(R.id.cb_plate_number);
        this.f14606i.setOnFocusChangeListener(this);
        this.f14605h.setOnFocusChangeListener(this);
        this.f14612o = (CheckBox) getActivity().findViewById(R.id.cb_email);
        this.f14601d.addTextChangedListener(new C2530a(R.id.edit_garage_name));
        this.f14602e.addTextChangedListener(new C2530a(R.id.edit_company_address));
        this.f14603f.addTextChangedListener(new C2530a(R.id.edit_telephone));
        this.f14604g.addTextChangedListener(new C2530a(R.id.edit_fax));
        this.f14606i.addTextChangedListener(new C2530a(R.id.edit_license_plate_number));
        this.f14604g.setOnEditorActionListener(new C2531aq(this));
        this.f14618u = this.f14599b.m9591a("serialNo");
        this.f14614q = this.f14600c.m4837a("companyName");
        if (!C2787z.m4821a(this.f14614q)) {
            m5991a((ShopInfo) null);
        }
        this.f14595G = new SelectPhotoUtils(getActivity(), this);
        this.f14593E = System.currentTimeMillis();
        try {
            this.f14594F = (InfaceFragmentParent) getActivity();
            if (this.f14594F != null) {
                this.f14594F.mo6035a(this);
            }
        } catch (Exception e) {
            NLog.m9451c("EE", "infaceFragmentParent Error:" + e.toString());
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.mine_printeditinfo, viewGroup, false);
    }

    /* renamed from: a */
    private void m5991a(ShopInfo shopInfo) {
        if (shopInfo == null) {
            this.f14601d.setText(this.f14600c.m4837a("companyName"));
            this.f14602e.setText(this.f14600c.m4837a("companyAddress"));
            this.f14603f.setText(this.f14600c.m4837a("companyPhoneNumber"));
            this.f14605h.setText(this.f14600c.m4837a("companyEmail"));
            return;
        }
        if (!C2787z.m4821a(shopInfo.getCompany_fullname())) {
            this.f14601d.setText(shopInfo.getCompany_fullname() == null ? "" : shopInfo.getCompany_fullname());
        }
        if (!C2787z.m4821a(shopInfo.getCompany_address())) {
            this.f14602e.setText(shopInfo.getCompany_address() == null ? "" : shopInfo.getCompany_address());
        }
        if (!C2787z.m4821a(shopInfo.getTelephone())) {
            this.f14603f.setText(shopInfo.getTelephone() == null ? "" : shopInfo.getTelephone());
        }
        if (C2787z.m4821a(shopInfo.getEmail())) {
            return;
        }
        this.f14605h.setText(shopInfo.getEmail() == null ? "" : shopInfo.getEmail());
    }

    /* renamed from: b */
    private void m5990b() {
        int dimension = (int) getActivity().getResources().getDimension(R.dimen.report_item_logo);
        int i = getResources().getDisplayMetrics().widthPixels;
        int[] iArr = new int[2];
        this.f14598a.getLocationOnScreen(iArr);
        PopupWindow popupWindow = f14592w;
        if (popupWindow != null) {
            popupWindow.showAtLocation(this.f14598a, 0, (i - popupWindow.getWidth()) / 2, iArr[1] + dimension);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_logo_image) {
            PopupWindow popupWindow = f14592w;
            if (popupWindow != null) {
                if (popupWindow.isShowing()) {
                    f14592w.dismiss();
                    f14592w = null;
                } else {
                    m5990b();
                }
            } else {
                m5984e();
            }
            m5990b();
            C2778n.m4918a(getActivity());
        } else if (id == R.id.btn_save) {
            if (C2778n.m4905b()) {
                return;
            }
            ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
            m5988c();
        } else {
            switch (id) {
                case R.id.pop_btnCamera /* 2131297613 */:
                    this.f14595G.m4831a(f14590D);
                    break;
                case R.id.pop_btnCancel /* 2131297614 */:
                    break;
                case R.id.pop_btnLocalImage /* 2131297615 */:
                    this.f14595G.m4835a(2);
                    break;
                default:
                    return;
            }
            m5986d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m5988c() {
        if (FileUtils.m5017a(f14589C)) {
            f14591v = f14588B;
            if (ImageUtils.m4937a(f14589C, f14591v) == 1) {
                FileUtils.m5000d(f14589C);
                this.f14599b.m9588a("report_logo_path", f14591v);
            }
        }
        this.f14614q = this.f14601d.getText().toString();
        if (C2787z.m4821a(this.f14614q)) {
            Context context = this.mContext;
            NToast.m9449a(context, this.mContext.getString(R.string.print_garage_name_txt) + this.mContext.getString(R.string.content_can_not_null));
            return;
        }
        this.f14615r = this.f14602e.getText().toString();
        if (C2787z.m4821a(this.f14615r)) {
            Context context2 = this.mContext;
            NToast.m9449a(context2, this.mContext.getString(R.string.print_company_address_txt) + this.mContext.getString(R.string.content_can_not_null));
            return;
        }
        this.f14616s = this.f14603f.getText().toString();
        if (C2744aa.m5127q() && C2787z.m4821a(this.f14616s)) {
            NToast.m9450a(this.mContext, (int) R.string.mine_et_mobile_phone_Prompt);
            return;
        }
        this.f14617t = this.f14605h.getText().toString();
        if (!C2787z.m4816c(this.f14617t)) {
            NToast.m9450a(this.mContext, (int) R.string.mine_bind_email_error);
            return;
        }
        ShopInfo shopInfo = new ShopInfo();
        shopInfo.setSerial_number(C2787z.m4821a(this.f14618u) ? "" : this.f14618u);
        shopInfo.setCompany_fullname(this.f14614q);
        shopInfo.setCompany_address(this.f14615r);
        shopInfo.setTelephone(this.f14616s);
        shopInfo.setEmail(this.f14617t);
        C2744aa.m5181a(shopInfo);
        NToast.m9447b(this.mContext, (int) R.string.print_save_info_success_txt);
        if (C2787z.m4821a(this.f14618u)) {
            return;
        }
        request(100);
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        switch (view.getId()) {
            case R.id.edit_company_address /* 2131296924 */:
                if (z) {
                    return;
                }
                if (C2787z.m4821a(this.f14602e.getText().toString())) {
                    m5993a(this.f14609l, 4, true);
                    return;
                } else {
                    m5993a(this.f14609l, 0, true);
                    return;
                }
            case R.id.edit_email /* 2131296930 */:
                this.f14617t = this.f14605h.getText().toString();
                if (z) {
                    return;
                }
                if (C2787z.m4816c(this.f14617t) || C2787z.m4821a(this.f14617t)) {
                    if (C2787z.m4821a(this.f14617t)) {
                        m5993a(this.f14612o, 4, true);
                        return;
                    } else {
                        m5993a(this.f14612o, 0, true);
                        return;
                    }
                }
                m5993a(this.f14612o, 0, false);
                NToast.m9447b(this.mContext, (int) R.string.mine_bind_email_error);
                return;
            case R.id.edit_fax /* 2131296932 */:
                if (z) {
                    return;
                }
                if (C2787z.m4821a(this.f14604g.getText().toString())) {
                    m5993a(this.f14611n, 4, true);
                    return;
                } else {
                    m5993a(this.f14611n, 0, true);
                    return;
                }
            case R.id.edit_garage_name /* 2131296935 */:
                if (z) {
                    return;
                }
                if (C2787z.m4821a(this.f14601d.getText().toString())) {
                    m5993a(this.f14608k, 4, true);
                    return;
                } else {
                    m5993a(this.f14608k, 0, true);
                    return;
                }
            case R.id.edit_license_plate_number /* 2131296938 */:
                if (C2787z.m4821a(this.f14606i.getText().toString())) {
                    m5993a(this.f14613p, 4, true);
                    return;
                } else {
                    m5993a(this.f14613p, 0, true);
                    return;
                }
            case R.id.edit_telephone /* 2131296974 */:
                this.f14616s = this.f14603f.getText().toString();
                if (z) {
                    return;
                }
                if (C2787z.m4821a(this.f14616s)) {
                    m5993a(this.f14610m, 4, true);
                    return;
                } else {
                    m5993a(this.f14610m, 0, true);
                    return;
                }
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public static void m5993a(CheckBox checkBox, int i, boolean z) {
        checkBox.setVisibility(i);
        checkBox.setChecked(z);
        checkBox.setClickable(false);
    }

    /* compiled from: PrintEditInfoFragment.java */
    /* renamed from: com.cnlaunch.x431pro.activity.setting.ap$a */
    /* loaded from: classes.dex */
    class C2530a implements TextWatcher {

        /* renamed from: a */
        int f14622a;

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public C2530a(int i) {
            this.f14622a = i;
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            switch (this.f14622a) {
                case R.id.edit_company_address /* 2131296924 */:
                    if (C2787z.m4821a(PrintEditInfoFragment.this.f14602e.getText().toString())) {
                        PrintEditInfoFragment.m5993a(PrintEditInfoFragment.this.f14609l, 4, true);
                        return;
                    }
                    return;
                case R.id.edit_email /* 2131296930 */:
                    if (C2787z.m4821a(PrintEditInfoFragment.this.f14605h.getText().toString())) {
                        PrintEditInfoFragment.m5993a(PrintEditInfoFragment.this.f14612o, 4, true);
                        return;
                    } else {
                        PrintEditInfoFragment.m5993a(PrintEditInfoFragment.this.f14612o, 0, true);
                        return;
                    }
                case R.id.edit_fax /* 2131296932 */:
                    if (C2787z.m4821a(PrintEditInfoFragment.this.f14604g.getText().toString())) {
                        PrintEditInfoFragment.m5993a(PrintEditInfoFragment.this.f14611n, 4, true);
                        return;
                    }
                    return;
                case R.id.edit_garage_name /* 2131296935 */:
                    if (C2787z.m4821a(PrintEditInfoFragment.this.f14601d.getText().toString())) {
                        PrintEditInfoFragment.m5993a(PrintEditInfoFragment.this.f14608k, 4, true);
                        return;
                    }
                    return;
                case R.id.edit_license_plate_number /* 2131296938 */:
                    if (C2787z.m4821a(PrintEditInfoFragment.this.f14606i.getText().toString())) {
                        PrintEditInfoFragment.m5993a(PrintEditInfoFragment.this.f14613p, 4, true);
                        return;
                    } else {
                        PrintEditInfoFragment.m5993a(PrintEditInfoFragment.this.f14613p, 0, true);
                        return;
                    }
                case R.id.edit_telephone /* 2131296974 */:
                    if (C2787z.m4821a(PrintEditInfoFragment.this.f14603f.getText().toString())) {
                        PrintEditInfoFragment.m5993a(PrintEditInfoFragment.this.f14610m, 4, true);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: d */
    private static void m5986d() {
        PopupWindow popupWindow = f14592w;
        if (popupWindow != null) {
            popupWindow.dismiss();
            f14592w = null;
        }
    }

    /* renamed from: e */
    private void m5984e() {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int i = displayMetrics.heightPixels;
        int i2 = displayMetrics.widthPixels;
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.layout_report_logo_popup_dialog, (ViewGroup) null);
        ((Button) inflate.findViewById(R.id.pop_btnCamera)).setOnClickListener(this);
        ((Button) inflate.findViewById(R.id.pop_btnLocalImage)).setOnClickListener(this);
        ((Button) inflate.findViewById(R.id.pop_btnCancel)).setOnClickListener(this);
        if (i > i2) {
            f14592w = new PopupWindow(inflate, i2 / 2, i / 3);
        } else {
            f14592w = new PopupWindow(inflate, i2 / 2, i / 2);
        }
        f14592w.setFocusable(true);
        f14592w.setOutsideTouchable(true);
        f14592w.setBackgroundDrawable(new BitmapDrawable());
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        PopupWindow popupWindow = f14592w;
        if (popupWindow != null && popupWindow.isShowing()) {
            f14592w.dismiss();
            m5984e();
            if (f14592w != null) {
                m5990b();
            }
        }
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        try {
            if (this.f14594F != null && !getActivity().isFinishing()) {
                this.f14594F.mo6036a(this.f14593E);
                m5986d();
            }
        } catch (Exception unused) {
        }
        InfaceFragmentParent infaceFragmentParent = this.f14594F;
        if (infaceFragmentParent != null) {
            infaceFragmentParent.mo6035a((OnActivityResultListenter) null);
        }
    }

    @Override // android.app.Fragment
    public void onPause() {
        m5986d();
        super.onPause();
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // android.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        getActivity();
        if (i2 == -1) {
            switch (i) {
                case 1:
                    if (C2744aa.m5193a()) {
                        this.f14595G.m4830a(f14590D, f14589C);
                        return;
                    }
                    return;
                case 2:
                    this.f14596H = SelectPhotoUtils.m4834a(getActivity(), intent.getData());
                    this.f14595G.m4830a(this.f14596H, f14589C);
                    return;
                case 3:
                    try {
                        Bitmap decodeStream = BitmapFactory.decodeStream(getActivity().getContentResolver().openInputStream(SelectPhotoUtils.f15945a));
                        this.f14620y.setScaleType(ImageView.ScaleType.FIT_XY);
                        this.f14620y.setImageBitmap(decodeStream);
                        this.f14620y.setVisibility(0);
                        this.f14621z.setVisibility(8);
                        if (decodeStream != null) {
                            try {
                                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(f14589C)));
                                decodeStream.compress(Bitmap.CompressFormat.PNG, 100, bufferedOutputStream);
                                bufferedOutputStream.flush();
                                bufferedOutputStream.close();
                                return;
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                                return;
                            } catch (IOException e2) {
                                e2.printStackTrace();
                                return;
                            }
                        }
                        return;
                    } catch (FileNotFoundException e3) {
                        e3.printStackTrace();
                        return;
                    }
                case 4:
                    Bitmap bitmap = this.f14619x;
                    if (bitmap != null) {
                        bitmap.recycle();
                    }
                    this.f14619x = BitmapFactory.decodeFile(f14589C);
                    this.f14620y.setScaleType(ImageView.ScaleType.FIT_XY);
                    this.f14620y.setImageBitmap(this.f14619x);
                    this.f14620y.setVisibility(0);
                    this.f14621z.setVisibility(8);
                    return;
                default:
                    return;
            }
        }
        FileUtils.m5000d(f14590D);
        FileUtils.m5000d(f14589C);
    }

    @Override // com.cnlaunch.x431pro.activity.golo.p225b.OnActivityResultListenter
    /* renamed from: a */
    public final void mo5996a(int i, int i2, Intent intent) {
        onActivityResult(i, i2, intent);
    }

    @Override // com.cnlaunch.x431pro.activity.golo.p225b.OnActivityResultListenter
    /* renamed from: a */
    public final boolean mo5995a(KeyEvent keyEvent) {
        if (this.f14593E == 4 && keyEvent.getRepeatCount() == 0) {
            m5986d();
            return false;
        }
        return false;
    }

    @Override // com.cnlaunch.x431pro.activity.golo.p225b.OnActivityResultListenter
    /* renamed from: a */
    public final long mo5997a() {
        return this.f14593E;
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public Object doInBackground(int i) throws C1425f {
        switch (i) {
            case 100:
                if (this.f14597I == null) {
                    this.f14597I = new UserAction(this.mContext);
                }
                return this.f14597I.m5258b(this.f14618u, this.f14614q, this.f14615r, this.f14616s, this.f14617t);
            case 101:
                if (this.f14597I == null) {
                    this.f14597I = new UserAction(this.mContext);
                }
                return this.f14597I.m5246j(this.f14618u);
            default:
                return null;
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onSuccess(int i, Object obj) {
        switch (i) {
            case 100:
                if (((BaseResponse) obj).getCode() == 0) {
                    this.f14599b.m9587a("sava_print_info_result", true);
                    return;
                } else {
                    this.f14599b.m9587a("sava_print_info_result", false);
                    return;
                }
            case 101:
                if (this.mContentView == null) {
                    return;
                }
                ShopInfoResponse shopInfoResponse = (ShopInfoResponse) obj;
                if (shopInfoResponse.getCode() != 0 || shopInfoResponse.getData() == null) {
                    return;
                }
                m5991a(shopInfoResponse.getData());
                C2744aa.m5181a(shopInfoResponse.getData());
                return;
            default:
                return;
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onFailure(int i, int i2, Object obj) {
        if (i != 100) {
            return;
        }
        NToast.m9450a(this.mContext, (int) R.string.shopinfo_save_local);
        this.f14599b.m9587a("sava_print_info_result", false);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onDestroy() {
        Bitmap bitmap = this.f14619x;
        if (bitmap != null) {
            bitmap.recycle();
        }
        this.f14619x = null;
        super.onDestroy();
    }
}
