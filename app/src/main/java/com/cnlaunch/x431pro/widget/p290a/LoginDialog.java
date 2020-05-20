package com.cnlaunch.x431pro.widget.p290a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.InputFilter;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.x431pro.activity.login.FindPasswordActivity;
import com.cnlaunch.x431pro.activity.login.LoginActivity;
import com.cnlaunch.x431pro.activity.login.LoginFunction;
import com.cnlaunch.x431pro.activity.login.RegistActivity;
import com.cnlaunch.x431pro.activity.login.RegisterInfoRecord;
import com.cnlaunch.x431pro.activity.login.RegisterInstructionActivity;
import com.cnlaunch.x431pro.widget.DropdownEditText;
import com.ifoer.expedition.pro.R;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* renamed from: com.cnlaunch.x431pro.widget.a.az */
/* loaded from: classes.dex */
public abstract class LoginDialog extends BaseDialog {

    /* renamed from: a */
    private View f16251a;

    /* renamed from: b */
    Context f16252b;

    /* renamed from: c */
    ArrayList<String> f16253c;

    /* renamed from: g */
    HashMap<String, String> f16254g;

    /* renamed from: h */
    public LoginFunction.InterfaceC2302b f16255h;

    /* renamed from: i */
    private PreferencesManager f16256i;

    /* renamed from: j */
    private DropdownEditText f16257j;

    /* renamed from: k */
    private EditText f16258k;

    /* renamed from: l */
    private Button f16259l;

    /* renamed from: m */
    private TextView f16260m;

    /* renamed from: n */
    private TextView f16261n;

    /* renamed from: o */
    private LinearLayout f16262o;

    /* renamed from: p */
    private String f16263p;

    /* renamed from: q */
    private String f16264q;

    /* renamed from: r */
    private BroadcastReceiver f16265r;

    /* renamed from: a */
    public abstract void mo4676a(String str, String str2);

    public LoginDialog(Context context) {
        super(context);
        this.f16251a = null;
        this.f16265r = null;
        this.f16252b = null;
        this.f16253c = new ArrayList<>();
        this.f16254g = new HashMap<>();
        this.f16252b = context;
        setTitle(R.string.common_login);
        this.f16256i = PreferencesManager.m9595a(getContext());
        this.f16256i.m9587a("REGIST_SHOWTIPS", true);
        this.f16251a = LayoutInflater.from(context).inflate(R.layout.login_relogin, (ViewGroup) null);
        m4712g();
        this.f16257j = (DropdownEditText) this.f16251a.findViewById(R.id.edit_username);
        this.f16257j.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        this.f16257j.setText(this.f16256i.m9591a("login_username"));
        this.f16258k = (EditText) this.f16251a.findViewById(R.id.edit_password);
        this.f16258k.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        this.f16258k.setText(this.f16256i.m9591a("login_password"));
        String m9591a = this.f16256i.m9591a("username_list");
        if (m9591a != null && !m9591a.equals("")) {
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(Base64.decode(m9591a.getBytes(), 0)));
                objectInputStream.close();
                this.f16253c = (ArrayList) ((List) objectInputStream.readObject());
            } catch (StreamCorruptedException e) {
                e.printStackTrace();
            } catch (IOException e2) {
                e2.printStackTrace();
            } catch (ClassNotFoundException e3) {
                e3.printStackTrace();
            }
        }
        this.f16254g = new RegisterInfoRecord().m6546a();
        if (this.f16254g.size() != 0) {
            for (Map.Entry<String, String> entry : this.f16254g.entrySet()) {
                String key = entry.getKey();
                this.f16256i.m9588a(key, entry.getValue());
                if (!this.f16253c.contains(key)) {
                    this.f16253c.add(key);
                    try {
                        this.f16256i.m9588a("username_list", LoginActivity.m6763a(this.f16253c));
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
            }
        }
        this.f16257j.setList(this.f16253c);
        this.f16257j.setPasswordText(this.f16258k);
        this.f16257j.addTextChangedListener(new C2822ba(this));
        this.f16259l = (Button) this.f16251a.findViewById(R.id.btn_login);
        this.f16259l.setOnClickListener(this);
        this.f16260m = (TextView) this.f16251a.findViewById(R.id.tv_regist);
        this.f16260m.getPaint().setFlags(8);
        this.f16260m.getPaint().setAntiAlias(true);
        this.f16262o = (LinearLayout) this.f16251a.findViewById(R.id.ll_register);
        this.f16262o.setOnClickListener(this);
        this.f16261n = (TextView) this.f16251a.findViewById(R.id.tv_forget);
        this.f16261n.getPaint().setFlags(8);
        this.f16261n.getPaint().setAntiAlias(true);
        this.f16261n.setOnClickListener(this);
        IntentFilter intentFilter = new IntentFilter("login");
        intentFilter.addAction("RESET_PASSWORD");
        this.f16265r = new C2823bb(this);
        this.f16252b.registerReceiver(this.f16265r, intentFilter);
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.BaseDialog, android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent;
        int id = view.getId();
        if (id == R.id.btn_login) {
            this.f16263p = this.f16257j.getText().toString();
            this.f16264q = this.f16258k.getText().toString();
            mo4676a(this.f16263p, this.f16264q);
        } else if (id == R.id.ll_register) {
            if (Locale.getDefault().getLanguage().equalsIgnoreCase("ja")) {
                intent = new Intent(this.f16252b, RegisterInstructionActivity.class);
            } else {
                intent = new Intent(this.f16252b, RegistActivity.class);
            }
            getContext().startActivity(intent);
            cancel();
        } else if (id != R.id.tv_forget) {
        } else {
            Intent intent2 = new Intent(getContext(), FindPasswordActivity.class);
            this.f16263p = this.f16257j.getText().toString();
            intent2.putExtra("username", this.f16263p);
            getContext().startActivity(intent2);
            cancel();
        }
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.BaseDialog
    /* renamed from: a */
    public final View mo4517a() {
        return this.f16251a;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        LoginFunction.m6579b(this.f16255h);
        super.dismiss();
    }
}
