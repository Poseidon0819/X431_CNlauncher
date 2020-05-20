package com.cnlaunch.x431pro.activity.login;

import android.os.CountDownTimer;
import android.widget.Button;
import com.ifoer.expedition.pro.R;

/* compiled from: FindPasswordActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.login.u */
/* loaded from: classes.dex */
final class CountDownTimerC2378u extends CountDownTimer {

    /* renamed from: a */
    final /* synthetic */ FindPasswordActivity f13534a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CountDownTimerC2378u(FindPasswordActivity findPasswordActivity) {
        super(60000L, 1000L);
        this.f13534a = findPasswordActivity;
    }

    @Override // android.os.CountDownTimer
    public final void onTick(long j) {
        Button button;
        Button button2;
        button = this.f13534a.f13071ab;
        button.setEnabled(false);
        int i = (int) (j / 1000);
        button2 = this.f13534a.f13071ab;
        button2.setText(this.f13534a.getString(R.string.set_verify_send, new Object[]{String.valueOf(i)}));
    }

    @Override // android.os.CountDownTimer
    public final void onFinish() {
        Button button;
        Button button2;
        button = this.f13534a.f13071ab;
        button.setEnabled(true);
        button2 = this.f13534a.f13071ab;
        button2.setText(this.f13534a.getString(R.string.set_verify_resend));
        if (this.f13534a.f13084n != null) {
            this.f13534a.f13084n.cancel();
        }
    }
}
