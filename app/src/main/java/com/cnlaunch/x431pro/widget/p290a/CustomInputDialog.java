package com.cnlaunch.x431pro.widget.p290a;

import android.content.Context;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.ifoer.expedition.pro.R;

/* renamed from: com.cnlaunch.x431pro.widget.a.e */
/* loaded from: classes.dex */
public abstract class CustomInputDialog extends BaseDialog {

    /* renamed from: a */
    private EditText f16398a;

    /* renamed from: b */
    private View f16399b;

    /* renamed from: c */
    private EditText f16400c;

    /* renamed from: g */
    private int f16401g;

    /* renamed from: h */
    private int f16402h;

    /* renamed from: i */
    private int f16403i;

    /* renamed from: j */
    private String f16404j;

    /* renamed from: k */
    private Button f16405k;

    /* renamed from: l */
    private TextView f16406l;

    /* renamed from: a */
    public abstract void mo4574a(String str);

    /* renamed from: g_ */
    public abstract void mo4567g_();

    public CustomInputDialog(Context context, String str, String str2, int i, int i2, int i3, String str3) {
        super(context);
        this.f16399b = null;
        this.f16401g = -1;
        this.f16402h = -1;
        this.f16403i = -1;
        this.f16404j = "";
        m4716b(str);
        m4715c(str2);
        setCancelable(false);
        this.f16401g = i;
        this.f16402h = i2;
        this.f16403i = i3;
        this.f16404j = str3;
        this.f16405k = (Button) findViewById(R.id.button1);
        this.f16399b = LayoutInflater.from(context).inflate(R.layout.layout_dialog_custom_input, (ViewGroup) null);
        this.f16398a = (EditText) this.f16399b.findViewById(R.id.et_input);
        this.f16400c = (EditText) this.f16399b.findViewById(R.id.et_input_show);
        this.f16406l = (TextView) this.f16399b.findViewById(R.id.tv_message);
        this.f16400c.setKeyListener(null);
        int i4 = this.f16401g;
        if (i4 == 0) {
            this.f16405k.setEnabled(true);
        } else {
            this.f16398a.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i4)});
            this.f16405k.setEnabled(false);
        }
        if (str2 != null && !str2.isEmpty()) {
            this.f16406l.setVisibility(0);
            this.f16406l.setText(str2);
        }
        this.f16398a.addTextChangedListener(new C2863f(this));
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.BaseDialog
    /* renamed from: a */
    public final View mo4517a() {
        return this.f16399b;
    }
}
