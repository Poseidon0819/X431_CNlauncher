package com.unionpay.mobile.android.widgets;

import android.content.Context;
import android.text.InputFilter;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.unionpay.mobile.android.global.C4150b;
import com.unionpay.mobile.android.utils.C4389j;
import org.json.JSONObject;

/* renamed from: com.unionpay.mobile.android.widgets.ah */
/* loaded from: classes2.dex */
public final class C4429ah extends AbstractC4420aa {

    /* renamed from: c */
    private InterfaceC4430a f23341c;

    /* renamed from: o */
    private String f23342o;

    /* renamed from: p */
    private String f23343p;

    /* renamed from: com.unionpay.mobile.android.widgets.ah$a */
    /* loaded from: classes2.dex */
    public interface InterfaceC4430a {
        /* renamed from: e */
        void mo708e(String str);
    }

    public C4429ah(Context context, int i, JSONObject jSONObject, String str) {
        this(context, i, jSONObject, str, (byte) 0);
    }

    private C4429ah(Context context, int i, JSONObject jSONObject, String str, byte b) {
        super(context, i, jSONObject, str);
        this.f23341c = null;
        this.f23342o = null;
        this.f23343p = null;
        this.f23342o = C4389j.m846a(jSONObject, "button_label");
        this.f23343p = C4389j.m846a(jSONObject, "button_action");
        this.f23323b.m608a(new InputFilter.LengthFilter(11));
        this.f23323b.m610a(2);
        String str2 = this.f23342o;
        if (str2 == null || str2.length() <= 0) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, C4150b.f22151n);
        layoutParams.addRule(9, -1);
        layoutParams.addRule(15, -1);
        this.f23323b.setLayoutParams(layoutParams);
        TextView textView = new TextView(getContext());
        textView.setGravity(17);
        textView.setText(this.f23342o);
        textView.setTextColor(-7829368);
        textView.setTextSize(C4150b.f22148k);
        textView.setOnClickListener(new View$OnClickListenerC4431ai(this));
        this.f23323b.m606a(textView, new LinearLayout.LayoutParams(-2, -1));
    }

    @Override // com.unionpay.mobile.android.widgets.AbstractC4420aa, com.unionpay.mobile.android.widgets.AbstractC4453ba.InterfaceC4454a
    /* renamed from: a */
    public final String mo585a() {
        return this.f23323b.m600b();
    }

    /* renamed from: a */
    public final void m711a(InterfaceC4430a interfaceC4430a) {
        this.f23341c = interfaceC4430a;
    }

    @Override // com.unionpay.mobile.android.widgets.AbstractC4453ba.InterfaceC4454a
    /* renamed from: b */
    public final boolean mo584b() {
        if (this.f23402i) {
            return true;
        }
        return (this.f23403j == null || TextUtils.isEmpty(this.f23403j)) ? 11 == mo585a().length() && mo585a().startsWith("1") : mo585a().matches(this.f23403j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.unionpay.mobile.android.widgets.AbstractC4453ba
    /* renamed from: d */
    public final String mo613d() {
        return "_input_phoneNO";
    }
}
