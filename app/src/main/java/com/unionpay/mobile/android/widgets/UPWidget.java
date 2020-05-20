package com.unionpay.mobile.android.widgets;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.text.InputFilter;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import com.unionpay.mobile.android.global.C4149a;
import com.unionpay.mobile.android.utils.C4390k;
import com.unionpay.mobile.android.widgets.View$OnClickListenerC4479u;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class UPWidget extends AbstractC4420aa implements View$OnClickListenerC4479u.InterfaceC4481b {

    /* renamed from: o */
    private static final int f23300o = C4149a.f22131t / 3;

    /* renamed from: c */
    protected int f23301c;

    /* renamed from: p */
    private long f23302p;

    /* renamed from: q */
    private boolean f23303q;

    /* renamed from: r */
    private String f23304r;

    /* renamed from: s */
    private boolean f23305s;

    /* renamed from: t */
    private ViewTreeObserver.OnGlobalLayoutListener f23306t;

    /* renamed from: u */
    private C4455bb f23307u;

    /* renamed from: v */
    private View.OnClickListener f23308v;

    public UPWidget(Context context, long j, int i, JSONObject jSONObject, String str) {
        super(context, i, jSONObject, str);
        this.f23303q = true;
        this.f23304r = null;
        this.f23301c = 0;
        this.f23305s = false;
        this.f23306t = new ViewTreeObserver$OnGlobalLayoutListenerC4447aw(this);
        this.f23307u = null;
        this.f23308v = new View$OnClickListenerC4448ax(this);
        this.f23302p = j;
        this.f23323b.m603a((View$OnClickListenerC4479u.InterfaceC4481b) this);
        this.f23323b.m608a(new InputFilter.LengthFilter(6));
        this.f23323b.m589f();
        this.f23323b.m593d();
        mo586e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native void appendOnce(long j, String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static /* synthetic */ void m738b(UPWidget uPWidget) {
        C4390k.m838a("kb", "pwdInputFinished() +++");
        C4390k.m838a("kb", "size = " + uPWidget.f23301c);
        uPWidget.m733k();
        C4390k.m838a("kb", "pwdInputFinished() ---");
    }

    private native void clearAll(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public native void deleteOnce(long j);

    private native String getMsg(long j);

    private native String getMsgExtra(long j, String str);

    /* renamed from: w */
    private void m730w() {
        if (m729x() != null) {
            m729x().getViewTreeObserver().removeGlobalOnLayoutListener(this.f23306t);
        }
        C4455bb c4455bb = this.f23307u;
        if (c4455bb == null || !c4455bb.m662b()) {
            return;
        }
        this.f23307u.m665a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x */
    public View m729x() {
        return ((Activity) this.f23397d).findViewById(8888);
    }

    @Override // com.unionpay.mobile.android.widgets.AbstractC4420aa, com.unionpay.mobile.android.widgets.AbstractC4453ba.InterfaceC4454a
    /* renamed from: a */
    public final String mo585a() {
        return this.f23303q ? getMsgExtra(this.f23302p, this.f23304r) : getMsg(this.f23302p);
    }

    /* renamed from: a */
    public final void m742a(long j) {
        this.f23302p = j;
    }

    @Override // com.unionpay.mobile.android.widgets.View$OnClickListenerC4479u.InterfaceC4480a
    /* renamed from: a */
    public final void mo588a(boolean z) {
        this.f23305s = z;
        if (!z) {
            m730w();
            return;
        }
        ((InputMethodManager) getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.f23323b.getWindowToken(), 0);
        int height = m729x().getRootView().getHeight() - m729x().getHeight();
        Rect rect = new Rect();
        getWindowVisibleDisplayFrame(rect);
        if (height == rect.top) {
            m732l();
        } else if (m734j()) {
        } else {
            C4390k.m838a("uppay", "key board is closing..");
            C4390k.m838a("uppay", "registerKeyboardDissmisslisner() +++");
            if (m729x() != null) {
                m729x().getViewTreeObserver().addOnGlobalLayoutListener(this.f23306t);
            }
            C4390k.m838a("uppay", "registerKeyboardDissmisslisner() ---");
        }
    }

    @Override // com.unionpay.mobile.android.widgets.View$OnClickListenerC4479u.InterfaceC4481b
    /* renamed from: a_ */
    public final void mo587a_() {
        if (!this.f23305s || m734j()) {
            return;
        }
        m732l();
    }

    /* renamed from: b */
    public final void m737b(String str) {
        this.f23304r = str;
    }

    /* renamed from: b */
    public final void m736b(boolean z) {
        this.f23303q = z;
    }

    @Override // com.unionpay.mobile.android.widgets.AbstractC4453ba.InterfaceC4454a
    /* renamed from: b */
    public final boolean mo584b() {
        return this.f23301c == 6;
    }

    @Override // com.unionpay.mobile.android.widgets.AbstractC4420aa, com.unionpay.mobile.android.widgets.AbstractC4453ba.InterfaceC4454a
    /* renamed from: c */
    public final boolean mo583c() {
        C4390k.m838a("uppay", "emptyCheck() +++ ");
        C4390k.m838a("uppay", "mPINCounts =  " + this.f23301c);
        C4390k.m838a("uppay", "emptyCheck() --- ");
        return this.f23301c != 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.unionpay.mobile.android.widgets.AbstractC4453ba
    /* renamed from: d */
    public final String mo613d() {
        return "_bank_pwd";
    }

    @Override // com.unionpay.mobile.android.widgets.View$OnClickListenerC4479u.InterfaceC4481b
    /* renamed from: e */
    public final void mo586e() {
        clearAll(this.f23302p);
        this.f23301c = 0;
    }

    /* renamed from: j */
    public final boolean m734j() {
        C4455bb c4455bb = this.f23307u;
        return c4455bb != null && c4455bb.m662b();
    }

    /* renamed from: k */
    public final void m733k() {
        C4390k.m838a("uppay", "closeCustomKeyboard() +++");
        if (m734j()) {
            m730w();
        }
        C4390k.m838a("uppay", "closeCustomKeyboard() ---");
    }

    /* renamed from: l */
    public final void m732l() {
        if (!this.f23305s || m734j()) {
            return;
        }
        this.f23307u = new C4455bb(getContext(), this.f23308v, this);
        this.f23307u.m664a(this);
        String str = "";
        for (int i = 0; i < this.f23301c; i++) {
            str = str + "*";
        }
        this.f23323b.m594c(str);
        this.f23323b.m599b(str.length());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m733k();
    }
}
