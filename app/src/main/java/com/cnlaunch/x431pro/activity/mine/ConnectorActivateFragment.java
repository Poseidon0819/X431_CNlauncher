package com.cnlaunch.x431pro.activity.mine;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.mapapi.UIMsg;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.physics.p205k.DeviceUtils;
import com.cnlaunch.x431pro.activity.BaseFragment;
import com.cnlaunch.x431pro.activity.login.LoginFunction;
import com.cnlaunch.x431pro.module.p241a.CommonResponse;
import com.cnlaunch.x431pro.module.p255e.p256a.ConnectorAction;
import com.cnlaunch.x431pro.module.p255e.p257b.ProductsRegDateDTO;
import com.cnlaunch.x431pro.module.p255e.p257b.ProductsRegDateResponse;
import com.cnlaunch.x431pro.module.rtu.RegisterAndLoadInfomation;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.utils.C2787z;
import com.cnlaunch.x431pro.utils.p283db.SerialNumber;
import com.cnlaunch.x431pro.utils.p283db.SerialNumberDao;
import com.cnlaunch.x431pro.utils.p283db.p284a.DBManager;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.ifoer.expedition.pro.R;
import de.greenrobot.dao.query.WhereCondition;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.activity.mine.s */
/* loaded from: classes.dex */
public class ConnectorActivateFragment extends BaseFragment implements View.OnClickListener, View.OnFocusChangeListener {

    /* renamed from: A */
    private String f14283A;

    /* renamed from: C */
    private String f14285C;

    /* renamed from: D */
    private boolean f14286D;

    /* renamed from: q */
    private ConnectorAction f14303q;

    /* renamed from: r */
    private PreferencesManager f14304r;

    /* renamed from: s */
    private SerialNumberDao f14305s;

    /* renamed from: t */
    private EditText f14306t;

    /* renamed from: u */
    private EditText f14307u;

    /* renamed from: v */
    private Button f14308v;

    /* renamed from: w */
    private TextView f14309w;

    /* renamed from: x */
    private CheckBox f14310x;

    /* renamed from: y */
    private CheckBox f14311y;

    /* renamed from: z */
    private String f14312z;

    /* renamed from: a */
    private final int f14287a = 2301;

    /* renamed from: b */
    private final int f14288b = 2302;

    /* renamed from: c */
    private final int f14289c = 401;

    /* renamed from: d */
    private final int f14290d = 405;

    /* renamed from: e */
    private final int f14291e = UIMsg.d_ResultType.SHORT_URL;

    /* renamed from: f */
    private final int f14292f = 650;

    /* renamed from: g */
    private final int f14293g = 651;

    /* renamed from: h */
    private final int f14294h = 652;

    /* renamed from: i */
    private final int f14295i = 655;

    /* renamed from: j */
    private final int f14296j = 656;

    /* renamed from: k */
    private final int f14297k = 658;

    /* renamed from: l */
    private final int f14298l = 659;

    /* renamed from: m */
    private final int f14299m = 660;

    /* renamed from: n */
    private final int f14300n = 851;

    /* renamed from: o */
    private final int f14301o = 12;

    /* renamed from: p */
    private final int f14302p = 8;

    /* renamed from: B */
    private String f14284B = "86X";

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setTitle(R.string.mine_activation_title);
        setLeftImage(this.mContext.getResources().getDrawable(R.drawable.select_btn_menu_two));
        this.f14303q = new ConnectorAction(this.mContext);
        this.f14304r = PreferencesManager.m9595a(this.mContext);
        this.f14284B = this.f14304r.m9591a("venderCode");
        this.f14285C = this.f14304r.m9591a("serialNo");
        this.f14305s = DBManager.m5036a(this.mContext).f15794a.f15798a;
        this.f14306t = (EditText) getActivity().findViewById(R.id.edit_serialno);
        this.f14307u = (EditText) getActivity().findViewById(R.id.edit_password);
        this.f14309w = (TextView) getActivity().findViewById(R.id.tv_get_code);
        this.f14309w.setOnClickListener(this);
        this.f14310x = (CheckBox) getActivity().findViewById(R.id.cb_serialno);
        this.f14311y = (CheckBox) getActivity().findViewById(R.id.cb_password);
        this.f14308v = (Button) getActivity().findViewById(R.id.btn_activate);
        this.f14308v.setEnabled(m6107a());
        this.f14308v.setOnClickListener(this);
        this.f14307u.setOnEditorActionListener(new C2494t(this));
        this.f14306t.addTextChangedListener(new C2495u(this));
        this.f14307u.addTextChangedListener(new C2496v(this));
        this.f14307u.setOnFocusChangeListener(this);
        this.f14306t.setOnFocusChangeListener(this);
        this.f14286D = false;
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.mine_connector_activate, viewGroup, false);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public Object doInBackground(int i) throws C1425f {
        switch (i) {
            case 2301:
                return this.f14303q.m5360a(this.f14312z, this.f14284B, this.f14283A);
            case 2302:
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.f14304r.m9591a("serialNo"));
                return this.f14303q.m5359a((List<String>) arrayList);
            default:
                return super.doInBackground(i);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onSuccess(int i, Object obj) {
        switch (i) {
            case 2301:
                if (obj != null) {
                    CommonResponse commonResponse = (CommonResponse) obj;
                    if (isSuccess(commonResponse.getCode())) {
                        NToast.m9447b(this.mContext, (int) R.string.connector_activate_success);
                        NLog.m9451c("onSuccess", this.f14312z);
                        RegisterAndLoadInfomation registerAndLoadInfomation = new RegisterAndLoadInfomation(this.mContext, this.f14312z);
                        registerAndLoadInfomation.f15704a = this.f14304r.m9584b("login_username", "");
                        registerAndLoadInfomation.f15705b = this.f14304r.m9584b("login_password", "");
                        registerAndLoadInfomation.f15706c = true;
                        registerAndLoadInfomation.m5196a();
                        List<SerialNumber> list = this.f14305s.queryBuilder().where(SerialNumberDao.Properties.SerialNo.m321eq(this.f14285C), new WhereCondition[0]).list();
                        if (list.size() > 0) {
                            SerialNumber serialNumber = list.get(0);
                            serialNumber.f15833c = Boolean.FALSE;
                            this.f14305s.update(serialNumber);
                        }
                        List<SerialNumber> list2 = this.f14305s.queryBuilder().where(SerialNumberDao.Properties.SerialNo.m321eq(this.f14312z), new WhereCondition[0]).list();
                        if (list2.size() > 0) {
                            SerialNumber serialNumber2 = list2.get(0);
                            serialNumber2.f15835e = this.f14304r.m9591a("user_id");
                            serialNumber2.f15832b = Boolean.TRUE;
                            serialNumber2.f15833c = Boolean.TRUE;
                            this.f14305s.update(serialNumber2);
                        } else {
                            SerialNumber serialNumber3 = new SerialNumber();
                            serialNumber3.f15835e = this.f14304r.m9591a("user_id");
                            serialNumber3.f15832b = Boolean.TRUE;
                            serialNumber3.f15833c = Boolean.TRUE;
                            serialNumber3.f15834d = this.f14312z;
                            this.f14305s.insert(serialNumber3);
                        }
                        this.f14304r.m9588a("serialNo", this.f14312z);
                        this.f14304r.m9587a("need_refresh", true);
                        if (C2744aa.m5168b(this.f14312z, this.mContext)) {
                            this.f14304r.m9588a("carSerialNo", this.f14312z);
                            if (C2744aa.m5161c(this.f14304r.m9591a("heavydutySerialNo"), this.mContext)) {
                                this.f14304r.m9588a("heavydutySerialNo", "");
                            }
                            this.f14304r.m9588a("carAndHeavydutySerialNo", "");
                        } else if (C2744aa.m5177a(this.f14312z, this.mContext)) {
                            this.f14304r.m9588a("heavydutySerialNo", this.f14312z);
                            if (C2744aa.m5161c(this.f14304r.m9591a("carSerialNo"), this.mContext)) {
                                this.f14304r.m9588a("carSerialNo", "");
                            }
                            this.f14304r.m9588a("carAndHeavydutySerialNo", "");
                        } else if (C2744aa.m5161c(this.f14312z, this.mContext)) {
                            this.f14304r.m9588a("carAndHeavydutySerialNo", this.f14312z);
                            this.f14304r.m9588a("carSerialNo", this.f14312z);
                            this.f14304r.m9588a("heavydutySerialNo", this.f14312z);
                        }
                        this.f14306t.setText("");
                        this.f14307u.setText("");
                        request(2302);
                        new LoginFunction(this.mContext).m6553a(UIMsg.d_ResultType.NEWVERSION_DOWNLOAD);
                    } else {
                        int code = commonResponse.getCode();
                        String message2 = commonResponse.getMessage();
                        switch (code) {
                            case 405:
                                NToast.m9447b(this.mContext, (int) R.string.connector_product_notexists);
                                break;
                            case UIMsg.d_ResultType.SHORT_URL /* 500 */:
                                NToast.m9447b(this.mContext, (int) R.string.server_error);
                                break;
                            case 650:
                                NToast.m9447b(this.mContext, (int) R.string.connector_no_sales_record);
                                break;
                            case 651:
                                NToast.m9447b(this.mContext, (int) R.string.connector_registered);
                                break;
                            case 655:
                                NToast.m9447b(this.mContext, (int) R.string.connector_vercode_error);
                                break;
                            case 656:
                                NToast.m9447b(this.mContext, (int) R.string.vendercode_incorrect);
                                break;
                            case 659:
                                NToast.m9447b(this.mContext, (int) R.string.connector_registered_by_others);
                                break;
                            case 660:
                                NToast.m9447b(this.mContext, (int) R.string.connector_config_null);
                                break;
                            case 851:
                                NToast.m9446b(this.mContext, this.mContext.getString(R.string.activite_connector_failure_hd_model, getString(R.string.app_name)));
                                break;
                            default:
                                if (!C2787z.m4821a(message2)) {
                                    NToast.m9446b(this.mContext, message2);
                                    break;
                                }
                                break;
                        }
                    }
                }
                LoadDialog.m4681b(this.mContext);
                return;
            case 2302:
                if (obj != null) {
                    ProductsRegDateResponse productsRegDateResponse = (ProductsRegDateResponse) obj;
                    if (isSuccess(productsRegDateResponse.getCode())) {
                        List<ProductsRegDateDTO> productsRegDateDTOs = productsRegDateResponse.getProductsRegDateDTOs();
                        if (productsRegDateDTOs.size() > 0) {
                            ProductsRegDateDTO productsRegDateDTO = productsRegDateDTOs.get(0);
                            DeviceUtils.m8149a();
                            DeviceUtils.m8141c(productsRegDateDTO.getSerialNo(), productsRegDateDTO.getRegDate());
                        }
                        m6102b();
                        LoadDialog.m4681b(this.mContext);
                        return;
                    }
                }
                NToast.m9447b(this.mContext, (int) R.string.connector_getactivatetime_failure);
                m6102b();
                LoadDialog.m4681b(this.mContext);
                return;
            default:
                return;
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onFailure(int i, int i2, Object obj) {
        super.onFailure(i, i2, obj);
        switch (i) {
            case 2301:
                LoadDialog.m4681b(this.mContext);
                return;
            case 2302:
                m6102b();
                LoadDialog.m4681b(this.mContext);
                return;
            default:
                return;
        }
    }

    /* renamed from: b */
    private void m6102b() {
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStackImmediate((String) null, 1);
        }
        this.mainActivity.m7894b(R.id.btn_upgrade);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_activate) {
            m6099c();
        } else if (id != R.id.tv_get_code) {
        } else {
            InputMethodManager inputMethodManager = (InputMethodManager) this.mContext.getSystemService("input_method");
            if (((Activity) this.mContext).getCurrentFocus() != null) {
                inputMethodManager.hideSoftInputFromWindow(((Activity) this.mContext).getCurrentFocus().getWindowToken(), 2);
            }
            replaceFragment(VerificationCodeDetailFragment.class.getName(), 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m6099c() {
        this.f14312z = this.f14306t.getText().toString();
        this.f14283A = this.f14307u.getText().toString();
        if (TextUtils.isEmpty(this.f14312z)) {
            NToast.m9450a(this.mContext, (int) R.string.connector_fill_in_serialno);
        } else if (TextUtils.isEmpty(this.f14283A)) {
            NToast.m9450a(this.mContext, (int) R.string.connector_fill_in_vercode);
        } else if (this.f14312z.length() != 12 || !C2787z.m4818b(this.f14312z)) {
            NToast.m9450a(this.mContext, (int) R.string.connector_serialno_wrong);
        } else {
            LoadDialog.m4686a(this.mContext);
            String m9584b = this.f14304r.m9584b("login_state", "0");
            if (m9584b == null || !m9584b.equals("1")) {
                NToast.m9450a(this.mContext, (int) R.string.login_tip);
                LoadDialog.m4681b(this.mContext);
                return;
            }
            request(2301);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final boolean m6107a() {
        return this.f14310x.getVisibility() == 0 && this.f14310x.isChecked() && this.f14311y.getVisibility() == 0 && this.f14311y.isChecked();
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (this.f14286D) {
            return;
        }
        int id = view.getId();
        if (id == R.id.edit_password) {
            if (z || this.f14307u.getText().toString().length() == 8) {
                return;
            }
            int[] iArr = new int[2];
            this.f14307u.getLocationOnScreen(iArr);
            m6106a(this.mContext, R.string.connector_registcode_tips, iArr[0], iArr[1] + 40);
        } else if (id == R.id.edit_serialno && !z) {
            String obj = this.f14306t.getText().toString();
            if (this.f14310x.getVisibility() == 0 && !this.f14310x.isChecked()) {
                int[] iArr2 = new int[2];
                this.f14306t.getLocationOnScreen(iArr2);
                m6106a(this.mContext, R.string.connector_serialno_wrong, iArr2[0], iArr2[1] + 40);
            } else if (obj.length() != 12) {
                int[] iArr3 = new int[2];
                this.f14306t.getLocationOnScreen(iArr3);
                m6106a(this.mContext, R.string.connector_serial_tips, iArr3[0], iArr3[1] + 40);
            }
        }
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        this.f14286D = true;
    }

    /* renamed from: a */
    private static void m6106a(Context context, int i, int i2, int i3) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_register_toast, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.textView1)).setText(i);
        Toast makeText = Toast.makeText(context.getApplicationContext(), context.getResources().getString(i), 0);
        makeText.setGravity(51, i2, i3);
        makeText.setView(inflate);
        makeText.show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m6105a(CheckBox checkBox, int i, boolean z) {
        checkBox.setVisibility(i);
        checkBox.setChecked(z);
        checkBox.setClickable(false);
    }
}
