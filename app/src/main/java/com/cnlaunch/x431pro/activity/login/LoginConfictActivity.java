package com.cnlaunch.x431pro.activity.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.x431pro.module.p272k.p274b.User;
import com.ifoer.expedition.pro.R;

/* loaded from: classes.dex */
public class LoginConfictActivity extends Activity implements View.OnClickListener {

    /* renamed from: a */
    private Context f13101a;

    /* renamed from: b */
    private Button f13102b;

    /* renamed from: c */
    private Button f13103c;

    /* renamed from: d */
    private TextView f13104d;

    /* renamed from: e */
    private TextView f13105e;

    /* renamed from: f */
    private PreferencesManager f13106f;

    @Override // android.app.Activity
    public void onBackPressed() {
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_loginconfict);
        this.f13101a = this;
        this.f13106f = PreferencesManager.m9595a(this.f13101a);
        this.f13102b = (Button) findViewById(R.id.btn_confirm);
        this.f13102b.setOnClickListener(this);
        this.f13103c = (Button) findViewById(R.id.btn_cancel);
        this.f13103c.setOnClickListener(this);
        this.f13104d = (TextView) findViewById(R.id.tv_message);
        this.f13104d.setText(R.string.login_conflict_dialog_content);
        this.f13105e = (TextView) findViewById(R.id.tv_title);
        this.f13105e.setText(R.string.login_conflict_dialog_title);
        Log.i("LoginConfictActivity", "LoginConfictActivity oncreat end");
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id != R.id.btn_cancel) {
            if (id != R.id.btn_confirm) {
                return;
            }
            new LoginFunction(this.f13101a).m6583a(this.f13106f.m9591a("login_username"), this.f13106f.m9591a("login_password"));
            finish();
            return;
        }
        this.f13106f.m9588a("login_password", "");
        this.f13106f.m9588a("login_state", "0");
        this.f13106f.m9588a("if_auto_login", "0");
        this.f13106f.m9592a((PreferencesManager) new User());
        finish();
        sendBroadcast(new Intent("login_cancle"));
    }
}
