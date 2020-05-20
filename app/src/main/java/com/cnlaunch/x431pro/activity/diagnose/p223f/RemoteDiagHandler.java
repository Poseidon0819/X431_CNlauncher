package com.cnlaunch.x431pro.activity.diagnose.p223f;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.p181j.DealDiagMessageHandler;
import com.cnlaunch.x431pro.utils.C2778n;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.cnlaunch.x431pro.widget.p290a.MessageDialog;
import com.cnlaunch.x431pro.widget.p290a.WaitDialog;
import com.ifoer.expedition.pro.R;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.cnlaunch.x431pro.activity.diagnose.f.j */
/* loaded from: classes.dex */
public abstract class RemoteDiagHandler extends Handler {

    /* renamed from: a */
    private Context f12459a;

    /* renamed from: e */
    private MessageDialog f12463e = null;

    /* renamed from: f */
    private WaitDialog f12464f = null;

    /* renamed from: b */
    public int f12460b = 0;

    /* renamed from: g */
    private boolean f12465g = true;

    /* renamed from: c */
    protected Timer f12461c = new Timer();

    /* renamed from: d */
    protected TimerTask f12462d = null;

    /* renamed from: a */
    public abstract void mo7050a(int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ boolean m7049a(RemoteDiagHandler remoteDiagHandler) {
        remoteDiagHandler.f12465g = true;
        return true;
    }

    public RemoteDiagHandler(Context context) {
        this.f12459a = context;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message2) {
        int i = message2.what;
        if (i != 102) {
            switch (i) {
                case 0:
                    m7042d(R.string.dialog_remotediag_handler_00);
                    return;
                case 1:
                    m7046b(R.string.dialog_remotediag_handler_01);
                    return;
                case 2:
                    m7042d(R.string.dialog_remotediag_handler_02);
                    return;
                case 3:
                    m7046b(R.string.dialog_remotediag_handler_03);
                    return;
                case 4:
                    m7042d(R.string.dialog_remotediag_handler_04);
                    mo7050a(104);
                    return;
                case 5:
                    m7046b(R.string.dialog_remotediag_handler_05);
                    return;
                case 6:
                    m7042d(R.string.dialog_remotediag_handler_06);
                    mo7050a(101);
                    return;
                case 7:
                    if (C2778n.m4901c()) {
                        return;
                    }
                    m7046b(R.string.dialog_remotediag_handler_07);
                    return;
                case 8:
                    m7043c(R.string.dialog_remotediag_handler_08);
                    return;
                case 9:
                    m7043c(R.string.dialog_remotediag_handler_09);
                    return;
                case 10:
                    m7046b(R.string.dialog_remotediag_handler_0A);
                    return;
                case 11:
                    NToast.m9450a(this.f12459a, (int) R.string.dialog_remotediag_handler_0B);
                    return;
                default:
                    switch (i) {
                        case 105:
                            m7051a();
                            return;
                        case 106:
                            m7042d(R.string.remotediag_wait_for_other);
                            return;
                        case 107:
                            m7048a(true);
                            return;
                        case 108:
                            return;
                        default:
                            switch (i) {
                                case 110:
                                    m7048a(false);
                                    return;
                                case 111:
                                    mo7050a(103);
                                    return;
                                default:
                                    return;
                            }
                    }
            }
        }
        m7051a();
        this.f12465g = false;
        this.f12463e = new MessageDialog(this.f12459a, (int) R.string.dialog_remotediag_handler_title, (int) R.string.dialog_remotediag_handler_MSG_ExitTip, false, (byte) 0);
        this.f12463e.m4719a(R.string.btn_confirm, true, new View$OnClickListenerC2193k(this));
        this.f12463e.m4717b(R.string.btn_canlce, true, null);
        this.f12463e.show();
    }

    /* renamed from: b */
    private void m7046b(int i) {
        m7051a();
        this.f12465g = false;
        DealDiagMessageHandler.m8673a().m8666b();
        this.f12463e = new MessageDialog(this.f12459a, (int) R.string.dialog_remotediag_handler_title, i, false, (byte) 0);
        this.f12463e.m4719a(R.string.btn_confirm, true, new View$OnClickListenerC2194l(this));
        this.f12463e.show();
    }

    /* renamed from: c */
    private void m7043c(int i) {
        m7051a();
        this.f12465g = false;
        this.f12463e = new MessageDialog(this.f12459a, (int) R.string.dialog_remotediag_handler_title, i, false, (byte) 0);
        this.f12463e.m4719a(R.string.btn_confirm, true, new View$OnClickListenerC2195m(this));
        this.f12463e.show();
    }

    /* renamed from: a */
    private void m7048a(boolean z) {
        m7051a();
        this.f12463e = new MessageDialog(this.f12459a, (int) R.string.dialog_remotediag_handler_title, (int) R.string.dialog_long_time_wait_error, false, (byte) 0);
        this.f12463e.m4719a(R.string.btn_exit, true, new View$OnClickListenerC2196n(this));
        this.f12463e.m4717b(R.string.btn_wait_argin, true, new View$OnClickListenerC2197o(this, z));
        this.f12463e.show();
    }

    /* renamed from: a */
    public final void m7051a() {
        if (this.f12465g) {
            m7047b();
        }
    }

    /* renamed from: b */
    public final void m7047b() {
        LoadDialog.m4681b(this.f12459a);
        MessageDialog messageDialog = this.f12463e;
        if (messageDialog != null && messageDialog.isShowing()) {
            this.f12463e.dismiss();
            this.f12465g = true;
            this.f12463e = null;
        }
        WaitDialog waitDialog = this.f12464f;
        if (waitDialog != null && waitDialog.isShowing()) {
            this.f12464f.dismiss();
            this.f12464f = null;
        }
        m7044c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m7042d(int i) {
        WaitDialog waitDialog = this.f12464f;
        if (waitDialog != null && waitDialog.isShowing()) {
            this.f12464f.dismiss();
            this.f12464f = null;
        }
        this.f12464f = new WaitDialog(this.f12459a, i);
        this.f12464f.setCanceledOnTouchOutside(false);
        this.f12464f.show();
    }

    /* renamed from: c */
    public final synchronized void m7044c() {
        try {
            if (this.f12462d != null) {
                this.f12462d.cancel();
                this.f12462d = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
