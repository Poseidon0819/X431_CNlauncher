package com.unionpay.mobile.android.widgets;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.InputFilter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.unionpay.mobile.android.global.C4150b;
import com.unionpay.mobile.android.languages.C4171c;
import com.unionpay.mobile.android.utils.C4387h;
import org.json.JSONObject;

/* renamed from: com.unionpay.mobile.android.widgets.ap */
/* loaded from: classes2.dex */
public final class C4439ap extends AbstractC4420aa implements Handler.Callback {

    /* renamed from: c */
    private InterfaceC4440a f23368c;

    /* renamed from: o */
    private TextView f23369o;

    /* renamed from: p */
    private Handler f23370p;

    /* renamed from: q */
    private int f23371q;

    /* renamed from: com.unionpay.mobile.android.widgets.ap$a */
    /* loaded from: classes2.dex */
    public interface InterfaceC4440a {
        /* renamed from: a */
        void mo684a(AbstractC4486z abstractC4486z);
    }

    public C4439ap(Context context, int i, JSONObject jSONObject, String str) {
        super(context, i, jSONObject, str);
        this.f23368c = null;
        this.f23369o = null;
        this.f23370p = null;
        this.f23371q = 0;
        m685j();
        this.f23368c = null;
    }

    public C4439ap(Context context, int i, JSONObject jSONObject, String str, byte b) {
        super(context, i, jSONObject, str);
        this.f23368c = null;
        this.f23369o = null;
        this.f23370p = null;
        this.f23371q = 0;
        m685j();
    }

    /* renamed from: a */
    private void m687a(boolean z, String str) {
        this.f23369o.setText(str);
        this.f23369o.setEnabled(z);
    }

    /* renamed from: j */
    private void m685j() {
        this.f23323b.m608a(new InputFilter.LengthFilter(6));
        this.f23323b.m610a(2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, C4150b.f22151n);
        layoutParams.addRule(9, -1);
        layoutParams.addRule(15, -1);
        this.f23323b.setLayoutParams(layoutParams);
        LinearLayout linearLayout = new LinearLayout(this.f23397d);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(-3419943);
        new LinearLayout.LayoutParams(1, -1);
        this.f23369o = new TextView(getContext());
        this.f23369o.setGravity(17);
        this.f23369o.setText(C4171c.f22227bD.f22357w);
        this.f23369o.setTextColor(C4387h.m854a(-10705958, -5846275, -5846275, -6710887));
        this.f23369o.setTextSize(C4150b.f22148k);
        this.f23369o.setOnClickListener(new View$OnClickListenerC4441aq(this));
        this.f23323b.m606a(this.f23369o, new LinearLayout.LayoutParams(-2, -1));
    }

    /* renamed from: a */
    public final void m690a(int i) {
        this.f23370p = new Handler(this);
        C4442ar c4442ar = new C4442ar(this, i);
        m687a(false, String.format(C4171c.f22227bD.f22358x, Integer.valueOf(i)));
        c4442ar.start();
    }

    /* renamed from: a */
    public final void m689a(InterfaceC4440a interfaceC4440a) {
        this.f23368c = interfaceC4440a;
    }

    @Override // com.unionpay.mobile.android.widgets.AbstractC4453ba.InterfaceC4454a
    /* renamed from: b */
    public final boolean mo584b() {
        return this.f23402i || 6 == mo585a().length();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.unionpay.mobile.android.widgets.AbstractC4453ba
    /* renamed from: d */
    public final String mo613d() {
        return "_input_msg";
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message2) {
        switch (message2.what) {
            case 0:
                this.f23371q = message2.arg1;
                if (C4171c.f22227bD != null) {
                    m687a(false, String.format(C4171c.f22227bD.f22358x, Integer.valueOf(message2.arg1)));
                }
                return true;
            case 1:
                if (C4171c.f22227bD != null) {
                    m687a(true, C4171c.f22227bD.f22359y);
                }
                this.f23370p = null;
                return true;
            default:
                return false;
        }
    }
}
