package message.p380c;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* renamed from: message.c.a */
/* loaded from: classes2.dex */
public abstract class BaseHandler {

    /* renamed from: a */
    private Handler f23969a;

    /* renamed from: b */
    private Handler.Callback f23970b = new C4724b(this);

    /* renamed from: a */
    public abstract boolean mo300a(Message message2);

    public BaseHandler(Looper looper) {
        this.f23969a = new Handler(looper, this.f23970b);
    }

    /* renamed from: a */
    public final void m301a(int i, int i2, Object obj) {
        this.f23969a.obtainMessage(i, i2, 0, obj).sendToTarget();
    }
}
