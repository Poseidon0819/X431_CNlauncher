package com.cnlaunch.x431pro.widget.p290a;

import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.diagnosemodule.utils.DiagnoseInfo;
import com.cnlaunch.p118c.p119a.MyTools;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p125c.p126a.AsyncTaskManager;
import com.cnlaunch.p120d.p125c.p126a.OnDataListener;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.p188n.p191c.DiagCarInfo;
import com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment;
import com.cnlaunch.x431pro.module.cloud.model.CloudVINInfo;
import com.cnlaunch.x431pro.module.history.p266a.VINInfoDao;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.utils.C2787z;
import com.cnlaunch.x431pro.utils.PathUtils;
import com.cnlaunch.x431pro.utils.SelectPhotoUtils;
import com.cnlaunch.x431pro.utils.p282d.DiagnoseUtils;
import com.cnlaunch.x431pro.widget.ClearEditText;
import com.cnlaunch.x431pro.widget.TesterInfoDropdownEditText;
import com.ifoer.expedition.pro.R;
import com.p039a.p040a.Glide;
import com.p039a.p040a.p044d.p046b.DiskCacheStrategy;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.widget.a.ax */
/* loaded from: classes.dex */
public final class InputVehicleInfoDialog extends BaseDialog implements OnDataListener {

    /* renamed from: A */
    private BaseDiagnoseFragment f16222A;

    /* renamed from: B */
    private List<String> f16223B;

    /* renamed from: C */
    private String f16224C;

    /* renamed from: D */
    private SelectPhotoUtils f16225D;

    /* renamed from: E */
    private TesterInfoDropdownEditText f16226E;

    /* renamed from: a */
    ArrayList<String> f16227a;

    /* renamed from: b */
    private PreferencesManager f16228b;

    /* renamed from: c */
    private View f16229c;

    /* renamed from: g */
    private Context f16230g;

    /* renamed from: h */
    private ClearEditText f16231h;

    /* renamed from: i */
    private ClearEditText f16232i;

    /* renamed from: j */
    private ClearEditText f16233j;

    /* renamed from: k */
    private ClearEditText f16234k;

    /* renamed from: l */
    private ClearEditText f16235l;

    /* renamed from: m */
    private ClearEditText f16236m;

    /* renamed from: n */
    private ClearEditText f16237n;

    /* renamed from: o */
    private ClearEditText f16238o;

    /* renamed from: p */
    private ClearEditText f16239p;

    /* renamed from: q */
    private TextView f16240q;

    /* renamed from: r */
    private TextView f16241r;

    /* renamed from: s */
    private TextView f16242s;

    /* renamed from: t */
    private ImageView f16243t;

    /* renamed from: u */
    private Spinner f16244u;

    /* renamed from: v */
    private String f16245v;

    /* renamed from: w */
    private String f16246w;

    /* renamed from: x */
    private int f16247x;

    /* renamed from: y */
    private AsyncTaskManager f16248y;

    /* renamed from: z */
    private ScrollView f16249z;

    @Override // com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public final Object doInBackground(int i) throws C1425f {
        return null;
    }

    @Override // com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public final void onFailure(int i, int i2, Object obj) {
    }

    @Override // com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public final void onSuccess(int i, Object obj) {
    }

    public InputVehicleInfoDialog(Context context, int i) {
        super(context);
        String vin;
        this.f16229c = null;
        this.f16245v = "";
        this.f16246w = "";
        this.f16222A = null;
        this.f16223B = new ArrayList();
        this.f16227a = new ArrayList<>();
        this.f16247x = i;
        this.f16230g = context;
        setTitle(R.string.diagnose_report_add_information);
        this.f16248y = AsyncTaskManager.m9574a(this.f16230g);
        DiagCarInfo m5077e = DiagnoseUtils.m5086a().m5077e();
        if (m5077e != null) {
            vin = TextUtils.isEmpty(m5077e.getVin()) ? DiagnoseInfo.getInstance().getVin() : m5077e.getVin();
        } else {
            vin = DiagnoseInfo.getInstance().getVin();
        }
        this.f16228b = PreferencesManager.m9595a(context);
        this.f16229c = LayoutInflater.from(context).inflate(R.layout.layout_input_vehicle_info, (ViewGroup) null);
        this.f16128e.setVisibility(0);
        this.f16128e.setText(R.string.common_confirm);
        this.f16231h = (ClearEditText) this.f16229c.findViewById(R.id.edit_car_vin_name);
        this.f16232i = (ClearEditText) this.f16229c.findViewById(R.id.edit_car_licence);
        this.f16233j = (ClearEditText) this.f16229c.findViewById(R.id.edit_car_make);
        this.f16234k = (ClearEditText) this.f16229c.findViewById(R.id.edit_car_model);
        this.f16235l = (ClearEditText) this.f16229c.findViewById(R.id.edit_car_year);
        this.f16236m = (ClearEditText) this.f16229c.findViewById(R.id.edit_car_milage);
        this.f16237n = (ClearEditText) this.f16229c.findViewById(R.id.edit_report_notes);
        this.f16249z = (ScrollView) this.f16229c.findViewById(R.id.scrollview);
        this.f16244u = (Spinner) this.f16229c.findViewById(R.id.sp_repair_type);
        this.f16239p = (ClearEditText) this.f16229c.findViewById(R.id.edit_report_name);
        this.f16226E = (TesterInfoDropdownEditText) this.f16229c.findViewById(R.id.edit_tester);
        TesterInfoDropdownEditText testerInfoDropdownEditText = this.f16226E;
        testerInfoDropdownEditText.setView(testerInfoDropdownEditText);
        this.f16238o = (ClearEditText) this.f16229c.findViewById(R.id.edit_engine_size);
        this.f16240q = (TextView) this.f16229c.findViewById(R.id.btn_sensing);
        this.f16240q.setOnClickListener(this);
        this.f16241r = (TextView) this.f16229c.findViewById(R.id.tv_sensing);
        this.f16242s = (TextView) this.f16229c.findViewById(R.id.tv_load_image);
        this.f16242s.setOnClickListener(this);
        this.f16243t = (ImageView) this.f16229c.findViewById(R.id.iv_load_image);
        this.f16243t.setOnClickListener(this);
        this.f16223B.add(this.f16230g.getResources().getString(R.string.diagnostic));
        this.f16223B.add(this.f16230g.getResources().getString(R.string.pre_repair));
        this.f16223B.add(this.f16230g.getResources().getString(R.string.post_repair));
        ArrayAdapter arrayAdapter = new ArrayAdapter(this.f16230g, (int) R.layout.layout_report_spinner_checked_view, this.f16223B);
        this.f16244u.setAdapter((SpinnerAdapter) arrayAdapter);
        arrayAdapter.setDropDownViewResource(R.layout.item_repair_type);
        if (!TextUtils.isEmpty(vin)) {
            this.f16231h.setText(vin);
            this.f16231h.setTextIsSelectable(true);
            this.f16231h.setKeyListener(null);
            this.f16231h.setOnFocusChangeListener(null);
            this.f16231h.setClearIconVisible(false);
        } else {
            this.f16231h.setText(this.f16228b.m9591a("car_vin"));
        }
        String m9591a = this.f16228b.m9591a("licensePlateNumberDiagnew");
        if (!TextUtils.isEmpty(m9591a)) {
            this.f16232i.setText(m9591a);
            DiagnoseConstants.LICENSEPLATE = m9591a;
        } else {
            this.f16232i.setText(DiagnoseConstants.LICENSEPLATE);
        }
        String car_series = m5077e != null ? m5077e.getCar_series() : "";
        car_series = C2787z.m4821a(car_series) ? DiagnoseInfo.getInstance().getMake() : car_series;
        if (!TextUtils.isEmpty(car_series)) {
            this.f16233j.setText(car_series);
            this.f16233j.setEnabled(false);
            this.f16233j.setClearIconVisible(false);
        }
        String model = m5077e != null ? m5077e.getModel() : "";
        model = C2787z.m4821a(model) ? DiagnoseInfo.getInstance().getModel() : model;
        if (!TextUtils.isEmpty(model)) {
            this.f16234k.setText(model);
            this.f16234k.setEnabled(false);
            this.f16234k.setClearIconVisible(false);
        }
        String year = m5077e != null ? m5077e.getYear() : "";
        year = C2787z.m4821a(year) ? DiagnoseInfo.getInstance().getYear() : year;
        if (!TextUtils.isEmpty(year)) {
            this.f16235l.setText(year);
            this.f16235l.setEnabled(false);
            this.f16235l.setClearIconVisible(false);
        }
        this.f16236m.setText(C2744aa.m5184a(this.f16230g, DiagnoseConstants.DIAG_ODO_DATA, Boolean.FALSE));
        this.f16236m.setFilters(new InputFilter[]{new InputFilter.LengthFilter(12)});
        if (!TextUtils.isEmpty(vin) && MyTools.m9636a(DiagnoseConstants.LICENSEPLATE)) {
            CloudVINInfo m5284a = VINInfoDao.m5286a(this.f16230g).m5284a(vin);
            if (!MyTools.m9636a(m5284a.getPlate())) {
                String plate = m5284a.getPlate();
                this.f16232i.setText(plate);
                DiagnoseConstants.LICENSEPLATE = plate;
            }
        }
        this.f16237n.setText(this.f16228b.m9591a("car_remark"));
        this.f16226E.setText(this.f16228b.m9591a("last_tester"));
        String m9591a2 = this.f16228b.m9591a("testers");
        if (!C2787z.m4821a(m9591a2)) {
            try {
                this.f16227a = (ArrayList) C2787z.m4802q(m9591a2);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e2) {
                e2.printStackTrace();
            }
        }
        this.f16226E.setList(this.f16227a);
        String engine = DiagnoseInfo.getInstance().getEngine();
        if (engine != null) {
            this.f16238o.setText(engine);
        }
        String m9584b = this.f16228b.m9584b("report_select_image_path", "");
        if (C2787z.m4821a(m9584b)) {
            this.f16242s.setVisibility(0);
            this.f16243t.setVisibility(8);
        } else {
            this.f16242s.setVisibility(4);
            this.f16243t.setVisibility(0);
            this.f16242s.setVisibility(4);
            this.f16243t.setVisibility(0);
            Glide.m12699b(this.f16230g).m12667a("file://".concat(String.valueOf(m9584b))).m12974a(DiskCacheStrategy.NONE).m12970c().mo12915a(this.f16243t);
        }
        m4688a(this.f16228b.m9591a("report_sensing_html"));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.cnlaunch.x431pro.widget.p290a.BaseDialog, android.app.Dialog
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    /* renamed from: a */
    public final void m4689a(BaseDiagnoseFragment baseDiagnoseFragment, String str) {
        this.f16222A = baseDiagnoseFragment;
        BaseDiagnoseFragment baseDiagnoseFragment2 = this.f16222A;
        if (baseDiagnoseFragment2 != null) {
            this.f16239p.setText(baseDiagnoseFragment2.m7124a(this.f16247x, str));
        }
        this.f16225D = new SelectPhotoUtils(this.f16230g, this.f16222A);
    }

    /* renamed from: a */
    public final void m4688a(String str) {
        TextView textView = this.f16241r;
        if (textView != null) {
            textView.setText(Html.fromHtml(str));
        }
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.BaseDialog
    /* renamed from: a */
    public final View mo4517a() {
        return this.f16229c;
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.BaseDialog, android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_sensing /* 2131296556 */:
                this.f16222A.showInputReportDialog(3);
                return;
            case R.id.button1 /* 2131296605 */:
                if (m4687b()) {
                    dismiss();
                    this.f16222A.onSelectReportFormatBack(this.f16224C);
                    return;
                }
                return;
            case R.id.button2 /* 2131296606 */:
                dismiss();
                this.f16222A.onSelectReportFormatBack(this.f16224C);
                return;
            case R.id.iv_load_image /* 2131297205 */:
            case R.id.tv_load_image /* 2131298141 */:
                this.f16225D.m4835a(100);
                return;
            default:
                return;
        }
    }

    /* renamed from: b */
    private boolean m4687b() {
        if (!C2787z.m4821a(this.f16236m.getText().toString()) && TextUtils.isDigitsOnly(DiagnoseConstants.DIAG_ODO_DATA) && !C2787z.m4801r(this.f16236m.getText().toString())) {
            NToast.m9450a(this.f16230g, (int) R.string.report_error_mileage);
            this.f16236m.requestFocus();
            int[] iArr = new int[2];
            this.f16236m.getLocationOnScreen(iArr);
            this.f16249z.scrollTo(0, iArr[1]);
            return false;
        }
        this.f16224C = this.f16239p.getText().toString();
        if (C2787z.m4821a(this.f16224C) || !MyTools.m9635b(this.f16224C)) {
            Context context = this.f16230g;
            NToast.m9443c(context, context.getString(R.string.invalid_rename));
            return false;
        }
        if (new File(PathUtils.m4855d() + "/" + this.f16224C + ".pdf").exists()) {
            Context context2 = this.f16230g;
            NToast.m9443c(context2, context2.getString(R.string.duplicate_rename));
            return false;
        }
        this.f16228b.m9590a("repair_type", this.f16244u.getSelectedItemPosition());
        if (!TextUtils.isEmpty(this.f16233j.getText())) {
            DiagnoseInfo.getInstance().setMake(this.f16233j.getText().toString());
        } else {
            DiagnoseInfo.getInstance().setMake("");
        }
        if (!TextUtils.isEmpty(this.f16234k.getText())) {
            DiagnoseInfo.getInstance().setModel(this.f16234k.getText().toString());
        } else {
            DiagnoseInfo.getInstance().setModel("");
        }
        if (!TextUtils.isEmpty(this.f16235l.getText())) {
            DiagnoseInfo.getInstance().setYear(this.f16235l.getText().toString());
        } else {
            DiagnoseInfo.getInstance().setYear("");
        }
        DiagnoseConstants.DIAG_ODO_DATA = C2744aa.m5157d(this.f16230g, this.f16236m.getText().toString());
        this.f16245v = this.f16231h.getText().toString();
        this.f16246w = this.f16232i.getText().toString();
        DiagnoseConstants.LICENSEPLATE = this.f16246w;
        DiagnoseInfo.getInstance().setVin(this.f16245v);
        this.f16228b.m9588a("car_vin", this.f16245v);
        this.f16228b.m9588a("licensePlateNumberDiagnew", this.f16246w);
        this.f16228b.m9588a("car_remark", this.f16237n.getText().toString());
        String obj = this.f16226E.getText().toString();
        this.f16228b.m9588a("last_tester", obj);
        if (!this.f16227a.contains(obj)) {
            this.f16227a.add(obj);
            try {
                this.f16228b.m9588a("testers", C2787z.m4817b(this.f16227a));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(this.f16238o.getText().toString())) {
            DiagnoseInfo.getInstance().setEngine(this.f16238o.getText().toString());
        }
        return true;
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }
}
