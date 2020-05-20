package com.cnlaunch.x431pro.activity.pay;

import android.widget.RadioGroup;
import com.ifoer.expedition.pro.R;

/* compiled from: ChoicePayModeActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.pay.d */
/* loaded from: classes.dex */
final class C2509d implements RadioGroup.OnCheckedChangeListener {

    /* renamed from: a */
    final /* synthetic */ ChoicePayModeActivity f14423a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2509d(ChoicePayModeActivity choicePayModeActivity) {
        this.f14423a = choicePayModeActivity;
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public final void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (i == R.id.radioAlipay) {
            this.f14423a.f14370V = 1;
        } else if (i == R.id.radioUnionpay) {
            this.f14423a.f14370V = 2;
        } else if (i == R.id.radioWechatPay) {
            this.f14423a.f14370V = 3;
        }
    }
}
