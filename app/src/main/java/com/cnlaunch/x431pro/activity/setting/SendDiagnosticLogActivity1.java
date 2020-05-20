package com.cnlaunch.x431pro.activity.setting;

import android.content.Context;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.p120d.p130d.p131a.Lang;
import com.cnlaunch.p120d.p130d.p131a.LangManager;
import com.cnlaunch.x431pro.activity.ActivityC2004c;
import com.cnlaunch.x431pro.activity.setting.p235b.DiagLogHistoryInfoManager;
import com.cnlaunch.x431pro.module.p263h.p264a.SettingAction;
import com.cnlaunch.x431pro.module.p263h.p265b.UploadDiagnosticLogResponse;
import com.cnlaunch.x431pro.utils.C2787z;
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
import org.apache.mina.proxy.handlers.http.HttpProxyConstants;

/* loaded from: classes.dex */
public class SendDiagnosticLogActivity1 extends ActivityC2004c implements View.OnClickListener {

    /* renamed from: C */
    private ArrayList<DiagnoseLogInfoSearchUtil.C2749a> f14469C;

    /* renamed from: D */
    private boolean f14470D;

    /* renamed from: E */
    private String f14471E;

    /* renamed from: F */
    private int f14472F;

    /* renamed from: G */
    private int f14473G;

    /* renamed from: H */
    private TextView f14474H;

    /* renamed from: I */
    private CheckBox f14475I;

    /* renamed from: J */
    private CheckBox f14476J;

    /* renamed from: K */
    private CheckBox f14477K;

    /* renamed from: L */
    private CheckBox f14478L;

    /* renamed from: M */
    private CheckBox f14479M;

    /* renamed from: N */
    private CheckBox f14480N;

    /* renamed from: O */
    private CheckBox f14481O;

    /* renamed from: P */
    private Spinner f14482P;

    /* renamed from: Q */
    private EditText f14483Q;

    /* renamed from: R */
    private EditText f14484R;

    /* renamed from: S */
    private Button f14485S;

    /* renamed from: T */
    private Button f14486T;

    /* renamed from: U */
    private ProgressBar f14487U;

    /* renamed from: n */
    private final int f14488n = 1211;

    /* JADX WARN: Code restructure failed: missing block: B:8:0x00c8, code lost:
        if (com.cnlaunch.x431pro.utils.C2744aa.m5166c() != false) goto L19;
     */
    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.support.p012v4.app.FragmentActivity, android.support.p012v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreate(android.os.Bundle r5) {
        /*
            Method dump skipped, instructions count: 334
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.x431pro.activity.setting.SendDiagnosticLogActivity1.onCreate(android.os.Bundle):void");
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public Object doInBackground(int i) throws C1425f {
        if (i == 1211) {
            SettingAction settingAction = new SettingAction(this.f10981q);
            String upperCase = LangManager.m9469a().toUpperCase();
            String str = !upperCase.equalsIgnoreCase("zh") ? Lang.f7203a : upperCase;
            StringBuilder sb = new StringBuilder();
            for (int i2 = 1; i2 < 8; i2++) {
                switch (i2) {
                    case 1:
                        if (this.f14475I.isChecked()) {
                            sb.append(this.f14475I.getText());
                            break;
                        } else {
                            continue;
                        }
                    case 2:
                        if (this.f14476J.isChecked()) {
                            sb.append(this.f14476J.getText());
                            break;
                        } else {
                            continue;
                        }
                    case 3:
                        if (this.f14477K.isChecked()) {
                            sb.append(this.f14477K.getText());
                            break;
                        } else {
                            continue;
                        }
                    case 4:
                        if (this.f14478L.isChecked()) {
                            sb.append(this.f14478L.getText());
                            break;
                        } else {
                            continue;
                        }
                    case 5:
                        if (this.f14479M.isChecked()) {
                            sb.append(this.f14479M.getText());
                            break;
                        } else {
                            continue;
                        }
                    case 6:
                        if (this.f14480N.isChecked()) {
                            sb.append(this.f14480N.getText());
                            break;
                        } else {
                            continue;
                        }
                    case 7:
                        if (this.f14481O.isChecked()) {
                            sb.append(this.f14481O.getText());
                            break;
                        } else {
                            continue;
                        }
                }
                sb.append(HttpProxyConstants.CRLF);
            }
            String sb2 = sb.toString();
            if (!C2787z.m4821a(sb2)) {
                sb2 = sb2 + HttpProxyConstants.CRLF;
            }
            if (!C2787z.m4821a(this.f14483Q.getText().toString())) {
                sb2 = (sb2 + this.f14483Q.getText().toString()) + HttpProxyConstants.CRLF;
            }
            return settingAction.m5309a(this.f14469C.get(0), sb2 + this.f14484R.getText().toString(), "0", str, this.f14471E);
        }
        return super.doInBackground(i);
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onSuccess(int i, Object obj) {
        if (i == 1211 && obj != null) {
            UploadDiagnosticLogResponse uploadDiagnosticLogResponse = (UploadDiagnosticLogResponse) obj;
            if (uploadDiagnosticLogResponse.getCode() != 0) {
                if (uploadDiagnosticLogResponse.getCode() == 656) {
                    FileUtils.m4995g(PathUtils.m4849g());
                    MessageDialog messageDialog = new MessageDialog((Context) this, getString(R.string.common_title_tips), getString(R.string.feedback_error_tips_656, new Object[]{Integer.valueOf(this.f14473G), Integer.valueOf(this.f14472F - this.f14473G)}), false, (byte) 0);
                    messageDialog.m4719a(R.string.btn_confirm, true, new View$OnClickListenerC2537aw(this));
                    if (!isFinishing()) {
                        messageDialog.show();
                    }
                } else if (uploadDiagnosticLogResponse.getCode() == 658) {
                    FileUtils.m4995g(PathUtils.m4849g());
                    MessageDialog messageDialog2 = new MessageDialog((Context) this, (int) R.string.common_title_tips, (int) R.string.feedback_error_tips_658, false, (byte) 0);
                    messageDialog2.m4719a(R.string.btn_confirm, true, new View$OnClickListenerC2538ax(this));
                    if (!isFinishing()) {
                        messageDialog2.show();
                    }
                }
                FileUtils.m4995g(PathUtils.m4849g());
                return;
            }
            DiagLogHistoryInfoManager.m5973a(this.f10981q).f14637a = true;
            this.f14473G++;
            this.f14474H.setText(((this.f14472F - this.f14469C.size()) + 1) + "/" + this.f14472F);
            this.f14487U.setProgress((this.f14472F - this.f14469C.size()) + 1);
            FileUtils.m5000d(this.f14469C.get(0).getFullFilePath());
            if (this.f14469C.size() > 0) {
                this.f14469C.remove(0);
            }
            if (this.f14469C.size() <= 0) {
                FileUtils.m4995g(PathUtils.m4849g());
                MessageDialog messageDialog3 = new MessageDialog((Context) this, getString(R.string.common_title_tips), getString(R.string.setting_upload_log_tips, new Object[]{Integer.valueOf(this.f14473G), Integer.valueOf(this.f14472F - this.f14473G)}) + "\n\n" + getString(R.string.setting_upload_log_tips1), false, (byte) 0);
                messageDialog3.m4719a(R.string.btn_confirm, true, new View$OnClickListenerC2536av(this));
                if (isFinishing()) {
                    return;
                }
                messageDialog3.show();
                return;
            }
            m7739c(1211);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onFailure(int i, int i2, Object obj) {
        super.onFailure(i, i2, obj);
        this.f14487U.setVisibility(8);
        FileUtils.m4995g(PathUtils.m4849g());
        if (i == 1211) {
            if (this.f10981q != null) {
                NToast.m9446b(this.f10981q, getString(R.string.setting_upload_log_tips, new Object[]{Integer.valueOf(this.f14473G), Integer.valueOf(this.f14472F - this.f14473G)}));
                this.f14486T.setEnabled(true);
            }
        } else if (this.f10981q != null) {
            NToast.m9450a(this.f10981q, (int) R.string.setting_upload_log_failure);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (!this.f14486T.isEnabled()) {
                NToast.m9450a(this.f10981q, (int) R.string.send_diagnosticlog_back);
            }
            finish();
            return true;
        }
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_cancel) {
            if (!this.f14486T.isEnabled()) {
                NToast.m9450a(this.f10981q, (int) R.string.send_diagnosticlog_back);
            }
            finish();
        } else if (id == R.id.btn_submit_log) {
            if (!TextUtils.isEmpty(this.f14484R.getText().toString())) {
                if (this.f14475I.isChecked() || this.f14476J.isChecked() || this.f14477K.isChecked() || this.f14478L.isChecked() || this.f14479M.isChecked() || this.f14480N.isChecked() || this.f14481O.isChecked()) {
                    for (int i = 0; i < this.f14469C.size(); i++) {
                        try {
                            String str = PathUtils.m4849g() + "/" + this.f14469C.get(i).getDeviceSN() + this.f14469C.get(i).getVehicleSoftname() + new SimpleDateFormat("yyyyMMddHHmmss", Locale.ENGLISH).format(new Date(this.f14469C.get(i).getCreateDate())) + ".zip";
                            ZipFileUtils.m4983a(this.f14469C.get(i).getFullFilePath(), str);
                            this.f14469C.get(i).setZipFilePath(str);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    if (!new File(PathUtils.m4849g()).exists()) {
                        NToast.m9444c(this, (int) R.string.diagnosticLog_create_file_err);
                        finish();
                        return;
                    }
                    this.f14487U.setVisibility(0);
                    this.f14474H.setVisibility(0);
                    this.f14487U.setMax(this.f14472F);
                    this.f14474H.setText("0/" + this.f14472F);
                    this.f14486T.setEnabled(false);
                    m7739c(1211);
                    return;
                }
            }
            MessageDialog messageDialog = new MessageDialog((Context) this, (int) R.string.feedback_information_prompt, (int) R.string.feedback_question_description_tips, false, (byte) 0);
            messageDialog.m4719a(R.string.confirm, true, new View$OnClickListenerC2540az(this, messageDialog));
            messageDialog.show();
        }
    }
}
