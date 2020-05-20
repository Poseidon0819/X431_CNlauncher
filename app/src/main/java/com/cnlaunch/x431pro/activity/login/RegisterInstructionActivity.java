package com.cnlaunch.x431pro.activity.login;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;
import com.cnlaunch.x431pro.activity.ActivityC2004c;
import com.ifoer.expedition.pro.R;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.apache.mina.proxy.handlers.http.HttpProxyConstants;

/* loaded from: classes.dex */
public class RegisterInstructionActivity extends ActivityC2004c {

    /* renamed from: C */
    private TextView f13329C;

    /* renamed from: D */
    private Button f13330D;

    /* renamed from: E */
    private Button f13331E;

    /* renamed from: F */
    private String f13332F;

    /* renamed from: G */
    private String f13333G;

    /* renamed from: H */
    private Handler f13334H = new HandlerC2358cd(this);

    /* renamed from: n */
    private TextView f13335n;

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.support.p012v4.app.FragmentActivity, android.support.p012v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.register_instruction);
        m7743b();
        this.f13330D = (Button) findViewById(R.id.btn_agree);
        this.f13331E = (Button) findViewById(R.id.btn_no);
        this.f13335n = (TextView) findViewById(R.id.tv_statement_content);
        this.f13329C = (TextView) findViewById(R.id.tv_statement_title);
        this.f13332F = "";
        this.f13333G = "";
        this.f13330D.setOnClickListener(new View$OnClickListenerC2359ce(this));
        this.f13331E.setOnClickListener(new View$OnClickListenerC2360cf(this));
        m6601c("registerinstruction.txt");
    }

    /* renamed from: c */
    private String m6601c(String str) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(getResources().getAssets().open(str), "UTF-8"));
            int i = 0;
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    this.f13334H.sendEmptyMessage(1);
                    return null;
                } else if (i < 2) {
                    this.f13332F += readLine;
                    i++;
                } else {
                    this.f13333G += readLine + HttpProxyConstants.CRLF;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
