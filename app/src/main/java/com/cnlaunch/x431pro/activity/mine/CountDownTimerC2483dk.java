package com.cnlaunch.x431pro.activity.mine;

import android.os.CountDownTimer;
import android.widget.Button;
import com.ifoer.expedition.pro.R;

/* compiled from: VerificationCodeFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.dk */
/* loaded from: classes.dex */
final class CountDownTimerC2483dk extends CountDownTimer {

    /* renamed from: a */
    final /* synthetic */ VerificationCodeFragment f14216a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CountDownTimerC2483dk(VerificationCodeFragment verificationCodeFragment) {
        super(60000L, 1000L);
        this.f14216a = verificationCodeFragment;
    }

    @Override // android.os.CountDownTimer
    public final void onTick(long j) {
        Button button;
        Button button2;
        int i;
        button = this.f14216a.f14210h;
        button.setEnabled(false);
        this.f14216a.f14213k = (int) (j / 1000);
        button2 = this.f14216a.f14210h;
        VerificationCodeFragment verificationCodeFragment = this.f14216a;
        i = verificationCodeFragment.f14213k;
        button2.setText(verificationCodeFragment.getString(R.string.set_verify_send, new Object[]{String.valueOf(i)}));
    }

    @Override // android.os.CountDownTimer
    public final void onFinish() {
        Button button;
        Button button2;
        button = this.f14216a.f14210h;
        button.setEnabled(true);
        button2 = this.f14216a.f14210h;
        button2.setText(this.f14216a.getString(R.string.set_verify_resend));
        if (this.f14216a.f14203a != null) {
            this.f14216a.f14203a.cancel();
        }
    }
}
