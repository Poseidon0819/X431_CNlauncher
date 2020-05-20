package com.cnlaunch.x431pro.activity.login;

import android.os.CountDownTimer;
import android.widget.Button;
import com.ifoer.expedition.pro.R;

/* compiled from: RegistActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.login.an */
/* loaded from: classes.dex */
final class CountDownTimerC2315an extends CountDownTimer {

    /* renamed from: a */
    final /* synthetic */ RegistActivity f13422a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CountDownTimerC2315an(RegistActivity registActivity) {
        super(60000L, 1000L);
        this.f13422a = registActivity;
    }

    @Override // android.os.CountDownTimer
    public final void onTick(long j) {
        Button button;
        Button button2;
        button = this.f13422a.f13169am;
        button.setEnabled(false);
        int i = (int) (j / 1000);
        button2 = this.f13422a.f13169am;
        button2.setText(this.f13422a.getString(R.string.set_verify_send, new Object[]{String.valueOf(i)}));
    }

    @Override // android.os.CountDownTimer
    public final void onFinish() {
        Button button;
        Button button2;
        button = this.f13422a.f13169am;
        button.setEnabled(true);
        button2 = this.f13422a.f13169am;
        button2.setText(this.f13422a.getString(R.string.set_verify_resend));
        if (this.f13422a.f13108D != null) {
            this.f13422a.f13108D.cancel();
        }
    }
}
