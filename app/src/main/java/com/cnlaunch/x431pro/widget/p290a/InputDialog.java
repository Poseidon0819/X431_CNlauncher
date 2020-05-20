package com.cnlaunch.x431pro.widget.p290a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.ifoer.expedition.pro.R;

/* renamed from: com.cnlaunch.x431pro.widget.a.aj */
/* loaded from: classes.dex */
public abstract class InputDialog extends BaseDialog {

    /* renamed from: a */
    private EditText f16145a;

    /* renamed from: b */
    private View f16146b;

    /* renamed from: a */
    public abstract void mo4705a(String str);

    /* renamed from: e_ */
    public abstract void mo4701e_();

    private InputDialog(Context context) {
        super(context);
        this.f16146b = null;
        this.f16146b = LayoutInflater.from(context).inflate(R.layout.layout_dialog_input, (ViewGroup) null);
        this.f16145a = (EditText) this.f16146b.findViewById(R.id.et_input);
    }

    public InputDialog(Context context, String str, String str2) {
        this(context);
        try {
            if (!TextUtils.isEmpty(str2)) {
                this.f16145a.setText(str2);
                this.f16145a.setSelection(str2.length());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        m4716b(str);
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.BaseDialog
    /* renamed from: a */
    public final View mo4517a() {
        return this.f16146b;
    }

    /* renamed from: b */
    public final void m4704b() {
        m4719a(R.string.btn_confirm, true, new View$OnClickListenerC2812ak(this));
        m4717b(R.string.btn_canlce, true, new View$OnClickListenerC2813al(this));
        setCanceledOnTouchOutside(false);
        m4713f(2);
        show();
    }

    /* renamed from: c */
    public final void m4703c() {
        m4719a(R.string.btn_confirm, false, new View$OnClickListenerC2814am(this));
        m4717b(R.string.skip, false, new View$OnClickListenerC2815an(this));
        show();
    }

    /* renamed from: d */
    public final void m4702d() {
        m4719a(R.string.btn_confirm, false, new View$OnClickListenerC2816ao(this));
        m4717b(R.string.btn_canlce, true, new View$OnClickListenerC2817ap(this));
        setCanceledOnTouchOutside(false);
        m4713f(2);
        show();
    }
}
