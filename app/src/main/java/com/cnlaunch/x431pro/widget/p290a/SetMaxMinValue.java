package com.cnlaunch.x431pro.widget.p290a;

import android.content.Context;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import com.cnlaunch.x431pro.activity.diagnose.p221d.GraphGridFragment;
import com.ifoer.expedition.pro.R;

/* renamed from: com.cnlaunch.x431pro.widget.a.cp */
/* loaded from: classes.dex */
public final class SetMaxMinValue extends BaseDialog {

    /* renamed from: a */
    public GraphGridFragment f16364a;

    /* renamed from: b */
    private View f16365b;

    /* renamed from: c */
    private Button f16366c;

    /* renamed from: g */
    private double f16367g;

    /* renamed from: h */
    private double f16368h;

    /* renamed from: i */
    private boolean f16369i;

    /* renamed from: j */
    private boolean f16370j;

    /* renamed from: k */
    private Context f16371k;

    /* renamed from: l */
    private EditText f16372l;

    /* renamed from: m */
    private EditText f16373m;

    /* renamed from: n */
    private boolean f16374n;

    /* renamed from: o */
    private String f16375o;

    /* renamed from: p */
    private InputFilter[] f16376p;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: k */
    public static /* synthetic */ boolean m4584k(SetMaxMinValue setMaxMinValue) {
        setMaxMinValue.f16374n = true;
        return true;
    }

    /* compiled from: SetMaxMinValue.java */
    /* renamed from: com.cnlaunch.x431pro.widget.a.cp$a */
    /* loaded from: classes.dex */
    class C2856a implements InputFilter {
        C2856a() {
        }

        @Override // android.text.InputFilter
        public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            StringBuilder sb = new StringBuilder(spanned);
            sb.insert(i3, charSequence);
            return sb.toString().matches(SetMaxMinValue.this.f16375o) ? charSequence : "";
        }
    }

    public SetMaxMinValue(Context context) {
        super(context);
        this.f16365b = null;
        this.f16369i = false;
        this.f16370j = false;
        this.f16364a = null;
        this.f16374n = false;
        this.f16375o = "^([1-9]\\d{0,6}|(-|-[1-9]\\d{0,6})|-?0)(\\.|\\.\\d{0,2})?$";
        this.f16376p = new InputFilter[]{new C2856a()};
        this.f16371k = context;
        setTitle(R.string.btn_set_max_min);
        this.f16365b = LayoutInflater.from(context).inflate(R.layout.setting_max_min_value, (ViewGroup) null);
        this.f16372l = (EditText) this.f16365b.findViewById(R.id.edit_setMaxValue);
        this.f16373m = (EditText) this.f16365b.findViewById(R.id.edit_setMinValue);
        this.f16372l.addTextChangedListener(new C2857cq(this));
        this.f16372l.setFilters(this.f16376p);
        this.f16373m.setFilters(this.f16376p);
        this.f16373m.addTextChangedListener(new C2858cr(this));
        m4719a(R.string.common_confirm, true, new View$OnClickListenerC2859cs(this));
        m4717b(R.string.common_cancel, true, new View$OnClickListenerC2860ct(this));
        this.f16366c = (Button) findViewById(R.id.button1);
        this.f16366c.setEnabled(false);
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.BaseDialog
    /* renamed from: a */
    public final View mo4517a() {
        return this.f16365b;
    }

    /* renamed from: a */
    public final void m4600a(float f) {
        this.f16367g = f;
        this.f16372l.setText(String.valueOf(f));
    }

    /* renamed from: b */
    public final void m4596b(float f) {
        this.f16368h = f;
        this.f16373m.setText(String.valueOf(f));
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        if (this.f16374n) {
            super.dismiss();
        }
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        this.f16374n = true;
        return super.onKeyDown(i, keyEvent);
    }
}
