package com.cnlaunch.x431pro.activity.pay.p232a;

import android.content.Context;
import android.view.View;
import com.cnlaunch.x431pro.widget.p290a.BaseDialog;
import com.ifoer.expedition.pro.R;

/* renamed from: com.cnlaunch.x431pro.activity.pay.a.a */
/* loaded from: classes.dex */
public abstract class TrialDialog extends BaseDialog {

    /* renamed from: a */
    private View f14417a;

    @Override // com.cnlaunch.x431pro.widget.p290a.BaseDialog
    /* renamed from: a */
    public final View mo4517a() {
        return null;
    }

    /* renamed from: b */
    public abstract void mo6057b();

    /* renamed from: c */
    public abstract void mo6056c();

    public TrialDialog(Context context, String str) {
        super(context);
        this.f14417a = null;
        m4716b(str);
    }

    /* renamed from: a */
    public final void m6058a(String str, boolean z) {
        if (z) {
            m4719a(R.string.cy_buy, true, new View$OnClickListenerC2504b(this));
        } else {
            m4717b(R.string.cy_buy, true, new View$OnClickListenerC2505c(this));
            m4719a(R.string.cy_trial, true, new View$OnClickListenerC2506d(this));
            m4713f(2);
        }
        m4715c(str);
        show();
    }
}
