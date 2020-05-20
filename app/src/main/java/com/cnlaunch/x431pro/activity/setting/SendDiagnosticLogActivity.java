package com.cnlaunch.x431pro.activity.setting;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cnlaunch.p120d.p125c.p126a.AsyncTaskManager;
import com.cnlaunch.p120d.p125c.p126a.OnDataListener;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.p120d.p130d.p131a.Lang;
import com.cnlaunch.p120d.p130d.p131a.LangManager;
import com.cnlaunch.x431pro.activity.BaseDialogActivity;
import com.cnlaunch.x431pro.module.p263h.p264a.SettingAction;
import com.cnlaunch.x431pro.module.p263h.p265b.UploadDiagnosticLogResponse;
import com.cnlaunch.x431pro.utils.PathUtils;
import com.cnlaunch.x431pro.utils.p282d.DiagnoseLogInfoSearchUtil;
import com.cnlaunch.x431pro.utils.p285e.FileUtils;
import com.cnlaunch.x431pro.utils.p285e.ZipFileUtils;
import com.cnlaunch.x431pro.widget.p290a.MessageDialog;
import com.ifoer.expedition.pro.R;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes.dex */
public class SendDiagnosticLogActivity extends BaseDialogActivity implements View.OnClickListener, OnDataListener {

    /* renamed from: b */
    private ArrayList<DiagnoseLogInfoSearchUtil.C2749a> f14457b;

    /* renamed from: c */
    private AsyncTaskManager f14458c;

    /* renamed from: d */
    private Context f14459d;

    /* renamed from: e */
    private Button f14460e;

    /* renamed from: f */
    private EditText f14461f;

    /* renamed from: g */
    private ProgressBar f14462g;

    /* renamed from: h */
    private TextView f14463h;

    /* renamed from: i */
    private TextView f14464i;

    /* renamed from: l */
    private RelativeLayout f14467l;

    /* renamed from: a */
    private final int f14456a = 1211;

    /* renamed from: j */
    private String f14465j = "";

    /* renamed from: k */
    private int f14466k = 0;

    /* renamed from: m */
    private Boolean f14468m = Boolean.TRUE;

    @Override // com.cnlaunch.x431pro.activity.BaseDialogActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.send_diagnostic_log_feedback);
        this.f14459d = this;
        this.f14458c = AsyncTaskManager.m9574a(this.f14459d);
        Intent intent = getIntent();
        this.f14457b = new ArrayList<>();
        if (intent != null) {
            this.f14457b = (ArrayList) intent.getSerializableExtra("ListFile");
        }
        if (this.f14457b.size() > 0) {
            this.f14466k = this.f14457b.size();
        }
        m6038a();
    }

    /* renamed from: a */
    private void m6038a() {
        this.f14460e = (Button) findViewById(R.id.btn_feed_back_sure);
        this.f14461f = (EditText) findViewById(R.id.et_feed_back_remark);
        this.f14463h = (TextView) findViewById(R.id.tv__commit_log_cartname);
        for (int i = 0; i < this.f14457b.size(); i++) {
            this.f14465j += "     " + this.f14457b.get(i).getVehicleSoftname();
        }
        this.f14463h.setText(this.f14465j);
        this.f14462g = (ProgressBar) findViewById(R.id.pb_feed_back_progressBar);
        this.f14464i = (TextView) findViewById(R.id.tv__commit_log_num);
        this.f14467l = (RelativeLayout) findViewById(R.id.linearnumber);
        this.f14460e.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    @SuppressLint({"SimpleDateFormat"})
    public void onClick(View view) {
        if (view.getId() != R.id.btn_feed_back_sure) {
            return;
        }
        for (int i = 0; i < this.f14457b.size(); i++) {
            try {
                String str = PathUtils.m4849g() + "/" + this.f14457b.get(i).getDeviceSN() + this.f14457b.get(i).getVehicleSoftname() + new SimpleDateFormat("yyyyMMddHHmmss", Locale.ENGLISH).format(new Date(this.f14457b.get(i).getCreateDate())) + ".zip";
                ZipFileUtils.m4983a(this.f14457b.get(i).getFullFilePath(), str);
                this.f14457b.get(i).setZipFilePath(str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (!new File(PathUtils.m4849g()).exists()) {
            NToast.m9444c(this, (int) R.string.diagnosticLog_create_file_err);
            finish();
            return;
        }
        this.f14462g.setVisibility(0);
        this.f14467l.setVisibility(0);
        this.f14464i.setText("0/" + this.f14466k);
        this.f14460e.setEnabled(false);
        this.f14461f.setEnabled(false);
        this.f14458c.m9575a(1211, true, this);
    }

    @Override // com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public Object doInBackground(int i) throws C1425f {
        if (i == 1211) {
            SettingAction settingAction = new SettingAction(this.f14459d);
            String upperCase = LangManager.m9469a().toUpperCase();
            return settingAction.m5309a(this.f14457b.get(0), this.f14461f.getText().toString(), "0", !upperCase.equalsIgnoreCase("zh") ? Lang.f7203a : upperCase, "");
        }
        return Integer.valueOf(i);
    }

    @Override // com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onSuccess(int i, Object obj) {
        if (i != 1211) {
            return;
        }
        String str = "";
        if (obj != null) {
            if (((UploadDiagnosticLogResponse) obj).getCode() == 0) {
                str = "0";
                this.f14464i.setText(((this.f14466k - this.f14457b.size()) + 1) + "/" + this.f14466k);
                FileUtils.m5000d(this.f14457b.get(0).getFullFilePath());
            } else {
                str = "1";
                this.f14468m = Boolean.FALSE;
            }
        }
        if (this.f14457b.size() > 0) {
            this.f14457b.remove(0);
        }
        if (this.f14457b.size() > 0) {
            this.f14458c.m9575a(1211, true, this);
        } else if (str.indexOf("1") == -1) {
            FileUtils.m4995g(PathUtils.m4849g());
            this.f14462g.setVisibility(8);
            this.f14467l.setVisibility(8);
            MessageDialog messageDialog = new MessageDialog((Context) this, (int) R.string.feedback_information_prompt, (int) R.string.setting_upload_log_success, false, (byte) 0);
            messageDialog.m4719a(R.string.btn_confirm, true, new View$OnClickListenerC2532ar(this));
            if (isFinishing()) {
                return;
            }
            messageDialog.show();
        } else if (str.indexOf("0") == -1) {
            FileUtils.m4995g(PathUtils.m4849g());
            this.f14462g.setVisibility(8);
            this.f14467l.setVisibility(8);
            if (this.f14466k > 1) {
                MessageDialog messageDialog2 = new MessageDialog((Context) this, (int) R.string.feedback_information_prompt, (int) R.string.setting_upload_log_failure2, false, (byte) 0);
                messageDialog2.m4719a(R.string.btn_confirm, true, new View$OnClickListenerC2533as(this));
                if (isFinishing()) {
                    return;
                }
                messageDialog2.show();
                return;
            }
            MessageDialog messageDialog3 = new MessageDialog((Context) this, (int) R.string.feedback_information_prompt, (int) R.string.setting_upload_log_failure3, false, (byte) 0);
            messageDialog3.m4719a(R.string.btn_confirm, true, new View$OnClickListenerC2534at(this));
            if (isFinishing()) {
                return;
            }
            messageDialog3.show();
        } else if (str.indexOf("0") == -1 || str.indexOf("1") == -1) {
        } else {
            String[] split = str.split("0");
            this.f14462g.setVisibility(8);
            this.f14467l.setVisibility(8);
            FileUtils.m4995g(PathUtils.m4849g());
            MessageDialog messageDialog4 = new MessageDialog((Context) this, getString(R.string.feedback_information_prompt), getString(R.string.setting_upload_log_succ_fail, new Object[]{Integer.valueOf(split.length - 1), Integer.valueOf(str.length() - split.length)}), false, (byte) 0);
            messageDialog4.m4719a(R.string.btn_confirm, true, new View$OnClickListenerC2535au(this));
            if (isFinishing()) {
                return;
            }
            messageDialog4.show();
        }
    }

    @Override // com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onFailure(int i, int i2, Object obj) {
        this.f14462g.setVisibility(8);
        this.f14467l.setVisibility(8);
        FileUtils.m4995g(PathUtils.m4849g());
        if (i == -999) {
            this.f14468m = Boolean.FALSE;
        } else if (i == -400) {
            Context context = this.f14459d;
            if (context != null) {
                NToast.m9450a(context, (int) R.string.common_network_unavailable);
            }
            this.f14468m = Boolean.FALSE;
        } else if (i == -200) {
            Context context2 = this.f14459d;
            if (context2 != null) {
                NToast.m9450a(context2, (int) R.string.common_network_error);
            }
            this.f14468m = Boolean.FALSE;
        } else if (i == 1211) {
            NToast.m9446b(this.f14459d, getResources().getString(R.string.setting_upload_log_failure));
            this.f14468m = Boolean.FALSE;
        } else {
            NToast.m9450a(this.f14459d, (int) R.string.setting_upload_log_failure);
            this.f14468m = Boolean.FALSE;
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (!this.f14460e.isEnabled() && this.f14468m.booleanValue()) {
                NToast.m9450a(this.f14459d, (int) R.string.send_diagnosticlog_back);
            }
            finish();
            return true;
        }
        return true;
    }
}
