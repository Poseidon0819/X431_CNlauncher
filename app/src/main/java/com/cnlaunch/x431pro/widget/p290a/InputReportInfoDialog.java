package com.cnlaunch.x431pro.widget.p290a;

import android.content.Context;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.diagnosemodule.utils.DiagnoseInfo;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.activity.BaseFragment;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.utils.C2778n;
import com.cnlaunch.x431pro.utils.C2787z;
import com.cnlaunch.x431pro.utils.PathUtils;
import com.cnlaunch.x431pro.widget.ClearEditText;
import com.ifoer.expedition.pro.R;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

/* renamed from: com.cnlaunch.x431pro.widget.a.as */
/* loaded from: classes.dex */
public final class InputReportInfoDialog extends BaseDialog {

    /* renamed from: A */
    private String f16164A;

    /* renamed from: B */
    private String f16165B;

    /* renamed from: C */
    private String f16166C;

    /* renamed from: D */
    private String f16167D;

    /* renamed from: E */
    private String f16168E;

    /* renamed from: F */
    private List<String> f16169F;

    /* renamed from: a */
    public String f16170a;

    /* renamed from: b */
    public BaseFragment f16171b;

    /* renamed from: c */
    public LinearLayout f16172c;

    /* renamed from: g */
    public int f16173g;

    /* renamed from: h */
    SpinnerPopupWindow f16174h;

    /* renamed from: i */
    private PreferencesManager f16175i;

    /* renamed from: j */
    private View f16176j;

    /* renamed from: k */
    private Button f16177k;

    /* renamed from: l */
    private Button f16178l;

    /* renamed from: m */
    private Context f16179m;

    /* renamed from: n */
    private ClearEditText f16180n;

    /* renamed from: o */
    private ClearEditText f16181o;

    /* renamed from: p */
    private ClearEditText f16182p;

    /* renamed from: q */
    private ClearEditText f16183q;

    /* renamed from: r */
    private TextView f16184r;

    /* renamed from: s */
    private ClearEditText f16185s;

    /* renamed from: t */
    private ClearEditText f16186t;

    /* renamed from: u */
    private ClearEditText f16187u;

    /* renamed from: v */
    private ClearEditText f16188v;

    /* renamed from: w */
    private ClearEditText f16189w;

    /* renamed from: x */
    private ClearEditText f16190x;

    /* renamed from: y */
    private String f16191y;

    /* renamed from: z */
    private int f16192z;

    public InputReportInfoDialog(Context context, String str) {
        super(context);
        this.f16176j = null;
        this.f16191y = "";
        this.f16192z = 0;
        this.f16164A = "";
        this.f16165B = "";
        this.f16166C = "";
        this.f16167D = "";
        this.f16168E = "";
        this.f16169F = new ArrayList();
        this.f16171b = null;
        this.f16170a = str;
        this.f16179m = context;
        setTitle(R.string.diagnose_report_add_information);
        String vin = DiagnoseInfo.getInstance().getVin();
        this.f16175i = PreferencesManager.m9595a(context);
        this.f16176j = LayoutInflater.from(context).inflate(R.layout.layout_input_report_info, (ViewGroup) null);
        this.f16177k = (Button) this.f16176j.findViewById(R.id.btn_info_save);
        this.f16177k.setOnClickListener(this);
        this.f16178l = (Button) this.f16176j.findViewById(R.id.btn_info_skip);
        this.f16178l.setOnClickListener(this);
        this.f16172c = (LinearLayout) this.f16176j.findViewById(R.id.linespace);
        if (this.f16179m.getResources().getConfiguration().orientation == 2) {
            this.f16173g = C2778n.m4900c(this.f16179m);
            if (this.f16173g < 650) {
                this.f16172c.setVisibility(0);
            }
        } else {
            this.f16172c.setVisibility(8);
        }
        this.f16183q = (ClearEditText) this.f16176j.findViewById(R.id.edit_file_name);
        this.f16184r = (TextView) this.f16176j.findViewById(R.id.tv_report_type);
        this.f16185s = (ClearEditText) this.f16176j.findViewById(R.id.edit_car_vin_name);
        this.f16186t = (ClearEditText) this.f16176j.findViewById(R.id.edit_car_year);
        this.f16187u = (ClearEditText) this.f16176j.findViewById(R.id.edit_car_make);
        this.f16188v = (ClearEditText) this.f16176j.findViewById(R.id.edit_car_model);
        this.f16189w = (ClearEditText) this.f16176j.findViewById(R.id.edit_car_odo);
        this.f16190x = (ClearEditText) this.f16176j.findViewById(R.id.edit_car_licence);
        this.f16180n = (ClearEditText) this.f16176j.findViewById(R.id.edit_car_owner_name);
        this.f16181o = (ClearEditText) this.f16176j.findViewById(R.id.edit_car_tester_name);
        this.f16182p = (ClearEditText) this.f16176j.findViewById(R.id.edit_car_remark);
        String m5131o = C2744aa.m5131o();
        if (!m5131o.equalsIgnoreCase("AR") && !m5131o.equalsIgnoreCase("FA")) {
            this.f16185s.setSingleLine(true);
            this.f16190x.setSingleLine(true);
            this.f16180n.setSingleLine(true);
            this.f16181o.setSingleLine(true);
            this.f16182p.setSingleLine(true);
        }
        this.f16182p.setImeOptions(6);
        if (!C2787z.m4821a(str)) {
            this.f16183q.setText(str);
        }
        this.f16169F.add(this.f16179m.getResources().getString(R.string.diagnostic));
        this.f16169F.add(this.f16179m.getResources().getString(R.string.pre_repair));
        this.f16169F.add(this.f16179m.getResources().getString(R.string.post_repair));
        this.f16184r.setOnClickListener(new View$OnClickListenerC2819at(this));
        if (!TextUtils.isEmpty(vin)) {
            this.f16185s.setText(vin);
            this.f16185s.setEnabled(false);
            this.f16185s.setClearIconVisible(false);
        } else {
            this.f16185s.setText(this.f16175i.m9591a("car_vin"));
        }
        this.f16180n.setText(this.f16175i.m9591a("car_owner_name"));
        this.f16181o.setText(this.f16175i.m9591a("last_tester"));
        this.f16182p.setText(this.f16175i.m9591a("car_remark"));
        this.f16190x.setText(this.f16175i.m9591a("licensePlateNumberDiagnew"));
        this.f16182p.setOnEditorActionListener(new C2821av(this));
        String make = C2787z.m4821a("") ? DiagnoseInfo.getInstance().getMake() : "";
        if (!TextUtils.isEmpty(make)) {
            this.f16187u.setText(make);
            this.f16187u.setEnabled(false);
            this.f16187u.setClearIconVisible(false);
        }
        String model = C2787z.m4821a("") ? DiagnoseInfo.getInstance().getModel() : "";
        if (!TextUtils.isEmpty(model)) {
            this.f16188v.setText(model);
            this.f16188v.setEnabled(false);
            this.f16188v.setClearIconVisible(false);
        }
        String year = C2787z.m4821a("") ? DiagnoseInfo.getInstance().getYear() : "";
        if (!TextUtils.isEmpty(year)) {
            this.f16186t.setText(year);
            this.f16186t.setEnabled(false);
            this.f16186t.setClearIconVisible(false);
        }
        this.f16189w.setText(C2744aa.m5184a(this.f16179m, DiagnoseConstants.DIAG_ODO_DATA, Boolean.FALSE));
        this.f16189w.setFilters(new InputFilter[]{new InputFilter.LengthFilter(12)});
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.cnlaunch.x431pro.widget.p290a.BaseDialog, android.app.Dialog
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setSoftInputMode(16);
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.BaseDialog
    /* renamed from: a */
    public final View mo4517a() {
        return this.f16176j;
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.BaseDialog, android.view.View.OnClickListener
    public final void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_info_save) {
            this.f16191y = this.f16183q.getText().toString();
            if (C2787z.m4821a(this.f16191y) || !C2744aa.m5146g(this.f16191y)) {
                Context context = this.f16179m;
                NToast.m9443c(context, context.getString(R.string.invalid_report_name));
                return;
            }
            if (new File(PathUtils.m4855d() + "/" + this.f16191y + ".pdf").exists()) {
                Context context2 = this.f16179m;
                NToast.m9443c(context2, context2.getString(R.string.duplicate_rename));
                return;
            } else if ((!C2787z.m4821a(this.f16189w.getText().toString()) || C2744aa.m5125r()) && ((TextUtils.isDigitsOnly(DiagnoseConstants.DIAG_ODO_DATA) || C2787z.m4821a(DiagnoseConstants.DIAG_ODO_DATA) || MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR.equals(DiagnoseConstants.DIAG_ODO_DATA)) && (C2787z.m4799t(this.f16189w.getText().toString()) || !C2787z.m4801r(this.f16189w.getText().toString())))) {
                NToast.m9450a(this.f16179m, (int) R.string.report_error_mileage);
                this.f16189w.requestFocus();
                return;
            } else {
                if (this.f16189w.getText().toString().toLowerCase().contains("miles")) {
                    String trim = this.f16189w.getText().toString().toLowerCase().replace("miles", "").trim();
                    if (!C2787z.m4821a(trim) && C2787z.m4818b(trim)) {
                        try {
                            if (Long.parseLong(trim) > 999999999) {
                                this.f16189w.setText("999999999");
                                NToast.m9450a(this.f16179m, (int) R.string.report_biggest_milage);
                                return;
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    String trim2 = this.f16189w.getText().toString().toLowerCase().replace("km", "").trim();
                    if (!C2787z.m4821a(trim2) && C2787z.m4818b(trim2)) {
                        try {
                            if (Long.parseLong(trim2) > 999999999) {
                                this.f16189w.setText("999999999");
                                NToast.m9450a(this.f16179m, (int) R.string.report_biggest_milage);
                                return;
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }
                this.f16164A = this.f16180n.getText().toString();
                this.f16165B = this.f16181o.getText().toString();
                this.f16166C = this.f16182p.getText().toString();
                this.f16168E = this.f16190x.getText().toString();
                this.f16167D = this.f16185s.getText().toString();
                this.f16175i.m9590a("repair_type", this.f16192z);
                this.f16175i.m9588a("car_owner_name", this.f16164A);
                this.f16175i.m9588a("last_tester", this.f16165B);
                this.f16175i.m9588a("car_remark", this.f16166C);
                this.f16175i.m9588a("licensePlateNumberDiagnew", this.f16168E);
                this.f16175i.m9588a("car_vin", this.f16167D);
                if (!TextUtils.isEmpty(this.f16187u.getText())) {
                    DiagnoseInfo.getInstance().setMake(this.f16187u.getText().toString());
                } else {
                    DiagnoseInfo.getInstance().setMake("");
                }
                if (!TextUtils.isEmpty(this.f16188v.getText())) {
                    DiagnoseInfo.getInstance().setModel(this.f16188v.getText().toString());
                } else {
                    DiagnoseInfo.getInstance().setModel("");
                }
                if (!TextUtils.isEmpty(this.f16186t.getText())) {
                    DiagnoseInfo.getInstance().setYear(this.f16186t.getText().toString());
                } else {
                    DiagnoseInfo.getInstance().setYear("");
                }
                DiagnoseConstants.DIAG_ODO_DATA = C2744aa.m5157d(this.f16179m, this.f16189w.getText().toString());
                BaseFragment baseFragment = this.f16171b;
                if (baseFragment == null) {
                    return;
                }
                baseFragment.onSelectReportFormatBack(this.f16191y);
                dismiss();
            }
        }
        if (id == R.id.btn_info_skip) {
            BaseFragment baseFragment2 = this.f16171b;
            if (baseFragment2 == null) {
                return;
            }
            baseFragment2.onSelectReportFormatBack(this.f16191y);
            dismiss();
        }
        super.onClick(view);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    /* renamed from: b */
    public final void m4695b() {
        SpinnerPopupWindow spinnerPopupWindow = this.f16174h;
        if (spinnerPopupWindow != null) {
            spinnerPopupWindow.m4583a();
            this.f16174h = null;
        }
    }
}
