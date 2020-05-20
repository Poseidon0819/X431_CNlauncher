package message.p382e;

import android.os.Handler;
import message.p378a.MessageParameters;
import message.p383f.ReceiveTask;
import message.p384g.LogUtilMsg;
import message.xmpp.XConnection;
import message.xmpp.p385iq.ReceiptIQ;

/* compiled from: GoloService.java */
/* renamed from: message.e.e */
/* loaded from: classes2.dex */
final class RunnableC4729e implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f23991a;

    /* renamed from: b */
    final /* synthetic */ int f23992b;

    /* renamed from: c */
    final /* synthetic */ C4728d f23993c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC4729e(C4728d c4728d, int i, int i2) {
        this.f23993c = c4728d;
        this.f23991a = i;
        this.f23992b = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        GoloService.f23972b = true;
        for (int i = 0; i < this.f23991a; i++) {
            if (!Thread.currentThread().isInterrupted()) {
                LogUtilMsg.m227a("deal_message", String.valueOf(i));
                if (i == this.f23991a - 1) {
                    LogUtilMsg.m227a("receive_offline_msg_end", "isShowUnReadMsg = true");
                    ReceiveTask.f23999c = true;
                }
                this.f23993c.f23990b.m278b(this.f23993c.f23990b.f23978e.get(i), true);
                if (GoloService.f23974d > 0) {
                    if (i == this.f23991a - 1) {
                        this.f23993c.f23990b.f23978e.get(i);
                    } else if (i != 0 && i % 50 == 0) {
                        this.f23993c.f23990b.f23978e.get(i);
                    }
                }
            }
        }
        MessageParameters.f23949n = true;
        int i2 = this.f23992b;
        if (i2 == 1) {
            if (!Thread.currentThread().isInterrupted()) {
                XConnection.getInstance().sendPacket(new ReceiptIQ(this.f23993c.f23990b.f23979f.get(0), this.f23993c.f23990b.f23978e.get(this.f23991a - 1).f24062g.longValue()));
            }
        } else if (i2 > 1) {
            StringBuffer stringBuffer = new StringBuffer();
            int i3 = 0;
            while (true) {
                int i4 = this.f23992b;
                if (i3 >= i4) {
                    break;
                }
                if (i3 == i4 - 1) {
                    LogUtilMsg.m227a("i==1", this.f23993c.f23990b.f23979f.get(0));
                    stringBuffer.append(this.f23993c.f23990b.f23979f.get(i3));
                } else {
                    stringBuffer.append(this.f23993c.f23990b.f23979f.get(i3));
                    stringBuffer.append(",");
                    LogUtilMsg.m227a("i>1", this.f23993c.f23990b.f23979f.get(i3));
                }
                i3++;
            }
            if (!Thread.currentThread().isInterrupted()) {
                XConnection.getInstance().sendPacket(new ReceiptIQ(stringBuffer.toString(), this.f23993c.f23990b.f23978e.get(this.f23991a - 1).f24062g.longValue()));
            }
        }
        handler = GoloService.f23975g;
        handler.sendEmptyMessage(256);
    }
}
