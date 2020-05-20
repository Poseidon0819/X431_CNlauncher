package com.cnlaunch.x431pro.activity.login;

import android.content.Context;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.cnlaunch.p120d.p125c.p126a.AsyncTaskManager;
import com.cnlaunch.p120d.p125c.p126a.OnDataListener;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.p120d.p130d.p131a.LangManager;
import com.cnlaunch.x431pro.module.p241a.CommonResponse;
import com.cnlaunch.x431pro.module.p272k.p273a.UserAction;
import com.cnlaunch.x431pro.module.p272k.p274b.UserBaseInfo;
import com.cnlaunch.x431pro.module.p272k.p274b.UserSettingInfo;
import com.cnlaunch.x431pro.utils.C2787z;
import com.cnlaunch.x431pro.widget.p290a.BaseDialog;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.ifoer.expedition.pro.R;

/* renamed from: com.cnlaunch.x431pro.activity.login.i */
/* loaded from: classes.dex */
public final class CompleteUserInfoDialog extends BaseDialog implements View.OnFocusChangeListener, OnDataListener {

    /* renamed from: A */
    private boolean f13498A;

    /* renamed from: B */
    private UserAction f13499B;

    /* renamed from: a */
    UserSettingInfo f13500a;

    /* renamed from: b */
    private final int f13501b;

    /* renamed from: c */
    private final int f13502c;

    /* renamed from: g */
    private final int f13503g;

    /* renamed from: h */
    private final int f13504h;

    /* renamed from: i */
    private final int f13505i;

    /* renamed from: j */
    private UserBaseInfo f13506j;

    /* renamed from: k */
    private Context f13507k;

    /* renamed from: l */
    private AsyncTaskManager f13508l;

    /* renamed from: m */
    private EditText f13509m;

    /* renamed from: n */
    private EditText f13510n;

    /* renamed from: o */
    private EditText f13511o;

    /* renamed from: p */
    private EditText f13512p;

    /* renamed from: q */
    private EditText f13513q;

    /* renamed from: r */
    private Button f13514r;

    /* renamed from: s */
    private Button f13515s;

    /* renamed from: t */
    private LinearLayout f13516t;

    /* renamed from: u */
    private View f13517u;

    /* renamed from: v */
    private String f13518v;

    /* renamed from: w */
    private String f13519w;

    /* renamed from: x */
    private String f13520x;

    /* renamed from: y */
    private String f13521y;

    /* renamed from: z */
    private String f13522z;

    public CompleteUserInfoDialog(Context context, UserBaseInfo userBaseInfo) {
        super(context);
        this.f13501b = 201;
        this.f13502c = 2011;
        this.f13503g = 202;
        this.f13504h = 2021;
        this.f13505i = 203;
        this.f13506j = null;
        this.f13517u = null;
        m4712g();
        this.f13506j = userBaseInfo;
        this.f13507k = context;
        this.f13498A = false;
        this.f13499B = new UserAction(this.f13507k);
        setTitle(R.string.complete_user_info_title);
        this.f13517u = LayoutInflater.from(context).inflate(R.layout.complete_userinfo, (ViewGroup) null);
        this.f13516t = (LinearLayout) this.f13517u.findViewById(R.id.identifycode_linearlayout);
        this.f13509m = (EditText) this.f13517u.findViewById(R.id.edit_qq);
        this.f13510n = (EditText) this.f13517u.findViewById(R.id.edit_weixin);
        this.f13511o = (EditText) this.f13517u.findViewById(R.id.edit_mobile);
        this.f13512p = (EditText) this.f13517u.findViewById(R.id.edit_email);
        this.f13513q = (EditText) this.f13517u.findViewById(R.id.edit_identifycode);
        this.f13509m.setOnFocusChangeListener(this);
        this.f13510n.setOnFocusChangeListener(this);
        this.f13511o.setOnFocusChangeListener(this);
        this.f13512p.setOnFocusChangeListener(this);
        this.f13509m.addTextChangedListener(new C2367j(this));
        this.f13510n.addTextChangedListener(new C2368k(this));
        this.f13511o.addTextChangedListener(new C2369l(this));
        this.f13512p.addTextChangedListener(new C2370m(this));
        this.f13513q.addTextChangedListener(new C2371n(this));
        this.f13514r = (Button) this.f13517u.findViewById(R.id.btn_getidentifycode);
        this.f13514r.setOnClickListener(this);
        this.f13515s = (Button) this.f13517u.findViewById(R.id.btn_complete);
        this.f13515s.setOnClickListener(this);
        this.f13515s.setEnabled(false);
        if (C2787z.m4821a(this.f13506j.getEmail())) {
            this.f13512p.setVisibility(0);
            this.f13514r.setText(R.string.retrieve_password_get_code_email);
        }
        if (C2787z.m4821a(this.f13506j.getMobile())) {
            this.f13511o.setVisibility(0);
            this.f13514r.setText(R.string.retrieve_password_get_code_phone);
        }
        if (!C2787z.m4821a(this.f13506j.getMobile()) && !C2787z.m4821a(this.f13506j.getEmail())) {
            this.f13516t.setVisibility(8);
        } else {
            this.f13516t.setVisibility(0);
        }
        this.f13508l = AsyncTaskManager.m9574a(this.f13507k);
        setCancelable(false);
    }

    /* renamed from: a */
    public final void m6534a(int i) {
        this.f13508l.m9575a(i, true, this);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public final Object doInBackground(int i) throws C1425f {
        if (i == 2011) {
            return this.f13499B.m5268a(this.f13511o.getText().toString(), this.f13513q.getText().toString());
        } else if (i != 2021) {
            switch (i) {
                case 201:
                    this.f13518v = this.f13511o.getText().toString();
                    if (!C2787z.m4821a(this.f13518v)) {
                        return this.f13499B.m5267a(this.f13518v, LangManager.m9469a(), "3");
                    }
                    break;
                case 202:
                    break;
                case 203:
                    return this.f13499B.m5270a(this.f13500a);
                default:
                    return null;
            }
            this.f13521y = this.f13512p.getText().toString();
            if (C2787z.m4821a(this.f13521y)) {
                return null;
            }
            return this.f13499B.m5267a(this.f13521y, LangManager.m9469a(), "3");
        } else {
            this.f13521y = this.f13512p.getText().toString();
            return this.f13499B.m5268a(this.f13521y, this.f13513q.getText().toString());
        }
    }

    @Override // com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public final void onSuccess(int i, Object obj) {
        if (i == 2011) {
            LoadDialog.m4681b(this.f13507k);
            if (obj != null) {
                if (((CommonResponse) obj).getCode() == 0) {
                    this.f13498A = true;
                    this.f13515s.setEnabled(m6530b());
                    return;
                }
                NToast.m9450a(this.f13507k, (int) R.string.reset_password_fail_prompt_110101);
            }
        } else if (i == 2021) {
            LoadDialog.m4681b(this.f13507k);
            if (obj != null) {
                if (((CommonResponse) obj).getCode() == 0) {
                    this.f13498A = true;
                    this.f13515s.setEnabled(m6530b());
                    return;
                }
                NToast.m9450a(this.f13507k, (int) R.string.reset_password_fail_prompt_110101);
            }
        } else {
            switch (i) {
                case 201:
                    if (obj != null) {
                        CommonResponse commonResponse = (CommonResponse) obj;
                        if (commonResponse.getCode() == 0) {
                            Context context = this.f13507k;
                            NToast.m9449a(context, context.getString(R.string.mine_set_verify_phone_tips, this.f13518v));
                            return;
                        }
                        m6533a(commonResponse.getCode(), 1);
                        return;
                    }
                    return;
                case 202:
                    if (obj != null) {
                        CommonResponse commonResponse2 = (CommonResponse) obj;
                        if (commonResponse2.getCode() == 0) {
                            NToast.m9450a(this.f13507k, (int) R.string.mine_set_verify_email_tips);
                            return;
                        } else {
                            m6533a(commonResponse2.getCode(), 0);
                            return;
                        }
                    }
                    return;
                case 203:
                    if (obj != null) {
                        CommonResponse commonResponse3 = (CommonResponse) obj;
                        if (commonResponse3.getCode() == 0) {
                            NToast.m9450a(this.f13507k, (int) R.string.complete_user_info_success);
                            dismiss();
                            return;
                        }
                        Context context2 = this.f13507k;
                        NToast.m9449a(context2, context2.getString(R.string.complete_user_info_failed, String.valueOf(commonResponse3.getCode())));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public boolean m6530b() {
        if (this.f13509m.getVisibility() != 8) {
            this.f13519w = this.f13509m.getText().toString();
            if (C2787z.m4821a(this.f13519w) || !C2787z.m4815d(this.f13519w)) {
                return false;
            }
        }
        if (this.f13510n.getVisibility() != 8) {
            this.f13520x = this.f13510n.getText().toString();
            if (C2787z.m4821a(this.f13520x)) {
                return false;
            }
        }
        if (this.f13511o.getVisibility() != 8) {
            this.f13518v = this.f13511o.getText().toString();
            this.f13522z = this.f13513q.getText().toString();
            if (!C2787z.m4810i(this.f13518v) || !this.f13498A) {
                return false;
            }
        }
        if (this.f13512p.getVisibility() != 8) {
            this.f13521y = this.f13512p.getText().toString();
            return !C2787z.m4821a(this.f13521y) && C2787z.m4816c(this.f13521y) && this.f13498A;
        }
        return true;
    }

    @Override // com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public final void onFailure(int i, int i2, Object obj) {
        if (i2 != -999) {
            if (i2 == -400) {
                Context context = this.f13507k;
                if (context != null) {
                    NToast.m9450a(context, (int) R.string.common_network_unavailable);
                    return;
                }
                return;
            } else if (i2 != -200) {
                return;
            }
        }
        Context context2 = this.f13507k;
        if (context2 != null) {
            NToast.m9447b(context2, (int) R.string.common_network_error);
        }
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.BaseDialog, android.view.View.OnClickListener
    public final void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_complete) {
            if (this.f13500a != null) {
                this.f13500a = null;
            }
            this.f13500a = new UserSettingInfo();
            this.f13518v = this.f13511o.getText().toString();
            this.f13521y = this.f13512p.getText().toString();
            this.f13522z = this.f13513q.getText().toString();
            this.f13500a.setMobile(this.f13518v);
            this.f13500a.setEmail(this.f13521y);
            this.f13500a.setVcode(this.f13522z);
            m6534a(203);
        } else if (id != R.id.btn_getidentifycode) {
        } else {
            this.f13518v = this.f13511o.getText().toString();
            this.f13521y = this.f13512p.getText().toString();
            if (this.f13511o.getVisibility() != 8) {
                if (C2787z.m4810i(this.f13518v)) {
                    m6534a(201);
                } else {
                    NToast.m9450a(this.f13507k, (int) R.string.complete_user_info_mobile_format_error);
                }
            } else if (this.f13512p.getVisibility() != 8) {
                if (C2787z.m4816c(this.f13521y)) {
                    m6534a(202);
                } else {
                    NToast.m9450a(this.f13507k, (int) R.string.mine_bind_email_error);
                }
            }
        }
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 0) {
            dismiss();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.BaseDialog
    /* renamed from: a */
    public final View mo4517a() {
        return this.f13517u;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z) {
        if (z) {
            return;
        }
        int id = view.getId();
        if (id == R.id.edit_email) {
            this.f13521y = this.f13512p.getText().toString();
            if (C2787z.m4821a(this.f13521y)) {
                NToast.m9450a(this.f13507k, (int) R.string.reset_password_input_email);
            } else if (C2787z.m4816c(this.f13521y)) {
            } else {
                NToast.m9450a(this.f13507k, (int) R.string.reset_password_email_error);
            }
        } else if (id == R.id.edit_mobile) {
            this.f13518v = this.f13511o.getText().toString();
            if (C2787z.m4821a(this.f13518v)) {
                NToast.m9450a(this.f13507k, (int) R.string.mine_et_mobile_phone_Prompt);
            } else if (C2787z.m4810i(this.f13518v)) {
            } else {
                NToast.m9450a(this.f13507k, (int) R.string.complete_user_info_mobile_format_error);
            }
        } else if (id == R.id.edit_qq) {
            this.f13519w = this.f13509m.getText().toString();
            if (C2787z.m4821a(this.f13519w) || !C2787z.m4815d(this.f13519w)) {
                NToast.m9450a(this.f13507k, (int) R.string.qq_invalid);
            }
        } else if (id != R.id.edit_weixin) {
        } else {
            this.f13520x = this.f13510n.getText().toString();
            if (C2787z.m4821a(this.f13520x)) {
                NToast.m9450a(this.f13507k, (int) R.string.complete_user_info_weixin_null);
            }
        }
    }

    /* renamed from: a */
    private void m6533a(int i, int i2) {
        if (i == 30040) {
            NToast.m9450a(this.f13507k, (int) R.string.more_than_sending_number);
        } else if (i == 110001) {
            if (i2 == 0) {
                NToast.m9447b(this.f13507k, (int) R.string.mine_toast_bind_already);
            } else {
                NToast.m9447b(this.f13507k, (int) R.string.register_fail_prompt_30007);
            }
        } else {
            switch (i) {
                case 30030:
                    return;
                case 30031:
                    NToast.m9450a(this.f13507k, (int) R.string.retrieve_password_operate_frequently);
                    return;
                default:
                    NToast.m9450a(this.f13507k, (int) R.string.get_identify_code_fail_prompt);
                    return;
            }
        }
    }
}
