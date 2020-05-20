package com.cnlaunch.x431pro.activity.login;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.Base64;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.activity.LoginBaseActivity;
import com.cnlaunch.x431pro.utils.PathUtils;
import com.cnlaunch.x431pro.utils.p285e.FileUtils;
import com.cnlaunch.x431pro.widget.DropdownEditText;
import com.ifoer.expedition.pro.R;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes.dex */
public class LoginActivity extends LoginBaseActivity implements View.OnClickListener {

    /* renamed from: e */
    private PreferencesManager f13088e;

    /* renamed from: f */
    private DropdownEditText f13089f;

    /* renamed from: g */
    private EditText f13090g;

    /* renamed from: h */
    private Button f13091h;

    /* renamed from: i */
    private TextView f13092i;

    /* renamed from: j */
    private TextView f13093j;

    /* renamed from: k */
    private LinearLayout f13094k;

    /* renamed from: l */
    private String f13095l;

    /* renamed from: m */
    private String f13096m;

    /* renamed from: d */
    private final String f13087d = LoginActivity.class.getSimpleName();

    /* renamed from: n */
    private BroadcastReceiver f13097n = null;

    /* renamed from: o */
    private IntentFilter f13098o = null;

    /* renamed from: b */
    ArrayList<String> f13085b = new ArrayList<>();

    /* renamed from: c */
    HashMap<String, String> f13086c = new HashMap<>();

    /* renamed from: p */
    private Handler f13099p = new HandlerC2379v(this);

    /* renamed from: q */
    private BroadcastReceiver f13100q = new C2383z(this);

    /* renamed from: a */
    public static String m6763a(List<String> list) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(list);
        String str = new String(Base64.encode(byteArrayOutputStream.toByteArray(), 0));
        objectOutputStream.close();
        return str;
    }

    /* renamed from: a */
    public static List<String> m6764a(String str) throws StreamCorruptedException, IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(Base64.decode(str.getBytes(), 0)));
        List<String> list = (List) objectInputStream.readObject();
        objectInputStream.close();
        return list;
    }

    @Override // com.cnlaunch.x431pro.activity.LoginBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_login);
        if (PreferencesManager.m9595a((Context) this).m9583b("is_screen_switch", false) && PreferencesManager.m9595a((Context) this).m9585b("Orientation", 2) != 0) {
            if (PreferencesManager.m9595a((Context) this).m9585b("Orientation", 2) == 1) {
                setRequestedOrientation(1);
            } else {
                setRequestedOrientation(4);
            }
        } else {
            setRequestedOrientation(0);
        }
        this.f13088e = PreferencesManager.m9595a(this.f14348a);
        this.f13089f = (DropdownEditText) findViewById(R.id.edit_username);
        this.f13089f.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        this.f13090g = (EditText) findViewById(R.id.edit_password);
        this.f13090g.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        this.f13091h = (Button) findViewById(R.id.btn_login);
        this.f13091h.setOnClickListener(this);
        this.f13092i = (TextView) findViewById(R.id.tv_regist);
        this.f13094k = (LinearLayout) findViewById(R.id.ll_register);
        this.f13094k.setOnClickListener(this);
        this.f13093j = (TextView) findViewById(R.id.tv_forget);
        this.f13093j.setOnClickListener(this);
        this.f13093j.getPaint().setFlags(8);
        this.f13093j.getPaint().setAntiAlias(true);
        this.f13092i.getPaint().setFlags(8);
        this.f13092i.getPaint().setAntiAlias(true);
        this.f13089f.setText(this.f13088e.m9591a("login_username"));
        this.f13090g.setText(this.f13088e.m9591a("login_password"));
        DropdownEditText dropdownEditText = this.f13089f;
        dropdownEditText.setSelection(dropdownEditText.getText().toString().length());
        EditText editText = this.f13090g;
        editText.setSelection(editText.getText().toString().length());
        String stringExtra = getIntent().getStringExtra("ISRTULOGIN");
        if (stringExtra != null && stringExtra.equals("RTU")) {
            findViewById(R.id.tv_regist).setVisibility(8);
            findViewById(R.id.iv_to_regist).setVisibility(8);
            getWindow().setSoftInputMode(5);
        } else {
            findViewById(R.id.tv_regist).setVisibility(0);
            findViewById(R.id.iv_to_regist).setVisibility(0);
        }
        String m9591a = this.f13088e.m9591a("username_list");
        if (m9591a != null && !m9591a.equals("")) {
            try {
                this.f13085b = (ArrayList) m6764a(m9591a);
            } catch (StreamCorruptedException e) {
                e.printStackTrace();
            } catch (IOException e2) {
                e2.printStackTrace();
            } catch (ClassNotFoundException e3) {
                e3.printStackTrace();
            }
        }
        this.f13086c = new RegisterInfoRecord().m6546a();
        if (this.f13086c.size() != 0) {
            for (Map.Entry<String, String> entry : this.f13086c.entrySet()) {
                String key = entry.getKey();
                this.f13088e.m9588a(key, entry.getValue());
                if (!this.f13085b.contains(key)) {
                    this.f13085b.add(key);
                    try {
                        this.f13088e.m9588a("username_list", m6763a(this.f13085b));
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
            }
        }
        this.f13089f.setList(this.f13085b);
        this.f13089f.setPasswordText(this.f13090g);
        this.f13090g.setOnEditorActionListener(new C2380w(this));
        this.f13089f.addTextChangedListener(new C2381x(this));
        this.f13097n = new C2382y(this);
        this.f13098o = new IntentFilter("RESET_PASSWORD");
        this.f13098o.addAction("android.intent.action.LOCALE_CHANGED");
        this.f14348a.registerReceiver(this.f13097n, this.f13098o);
        this.f13088e.m9587a("REGIST_SHOWTIPS", true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent;
        int id = view.getId();
        if (id == R.id.btn_login) {
            this.f13095l = this.f13089f.getText().toString();
            this.f13096m = this.f13090g.getText().toString();
            if (TextUtils.isEmpty(this.f13095l)) {
                NToast.m9450a(this.f14348a, (int) R.string.login_input_username);
            } else if (TextUtils.isEmpty(this.f13096m)) {
                NToast.m9450a(this.f14348a, (int) R.string.login_input_password);
            } else {
                LoginFunction loginFunction = new LoginFunction(this.f14348a);
                loginFunction.f13385c = this.f13099p;
                loginFunction.m6583a(this.f13095l, this.f13096m);
            }
        } else if (id != R.id.ll_register) {
            if (id != R.id.tv_forget) {
                return;
            }
            Intent intent2 = new Intent(this.f14348a, FindPasswordActivity.class);
            this.f13095l = this.f13089f.getText().toString();
            intent2.putExtra("username", this.f13095l);
            intent2.setFlags(67108864);
            startActivity(intent2);
        } else {
            if (Locale.getDefault().getLanguage().equalsIgnoreCase("ja")) {
                intent = new Intent(this.f14348a, RegisterInstructionActivity.class);
            } else {
                intent = new Intent(this.f14348a, RegistActivity.class);
            }
            startActivity(intent);
            String str = PathUtils.m4846j() + "codepic.png";
            if (new File(str).exists()) {
                FileUtils.m5000d(str);
            }
            String str2 = PathUtils.m4846j() + "nation.dat";
            if (new File(str2).exists()) {
                FileUtils.m5000d(str2);
            }
            finish();
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
    }

    @Override // com.cnlaunch.x431pro.activity.LoginBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.f13097n == null || this.f14348a == null) {
            return;
        }
        this.f14348a.unregisterReceiver(this.f13097n);
        this.f13097n = null;
    }

    @Override // com.cnlaunch.x431pro.activity.LoginBaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 0) {
            sendBroadcast(new Intent("LoginActivityKeyBack"));
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m6766a(LoginActivity loginActivity, int i) {
        if (i == 0) {
            loginActivity.setResult(-1);
        } else {
            loginActivity.setResult(0);
        }
    }
}
