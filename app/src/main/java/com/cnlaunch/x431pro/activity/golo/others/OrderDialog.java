package com.cnlaunch.x431pro.activity.golo.others;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.cnlaunch.x431pro.widget.p290a.BaseDialog;
import com.ifoer.expedition.pro.R;

/* renamed from: com.cnlaunch.x431pro.activity.golo.others.h */
/* loaded from: classes.dex */
public final class OrderDialog extends BaseDialog {

    /* renamed from: a */
    private EditText f12682a;

    /* renamed from: b */
    private View f12683b;

    public OrderDialog(Context context, String str) {
        super(context);
        this.f12683b = null;
        this.f12683b = LayoutInflater.from(context).inflate(R.layout.layout_dialog_input, (ViewGroup) null);
        this.f12682a = (EditText) this.f12683b.findViewById(R.id.et_input);
        setTitle(R.string.order_remotediag);
        m4719a(R.string.btn_confirm, true, new View$OnClickListenerC2243i(this, context, str));
        m4717b(R.string.btn_canlce, true, new View$OnClickListenerC2244j(this));
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.BaseDialog
    /* renamed from: a */
    public final View mo4517a() {
        return this.f12683b;
    }
}
