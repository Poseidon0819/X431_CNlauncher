package message.p382e;

import android.util.Log;
import message.xmpp.p385iq.ActivityIQ;
import org.jivesoftware.smack.filter.PacketFilter;
import org.jivesoftware.smack.packet.Packet;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GoloService.java */
/* renamed from: message.e.f */
/* loaded from: classes2.dex */
public final class C4730f implements PacketFilter {

    /* renamed from: a */
    final /* synthetic */ GoloService f23994a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4730f(GoloService goloService) {
        this.f23994a = goloService;
    }

    @Override // org.jivesoftware.smack.filter.PacketFilter
    public final boolean accept(Packet packet) {
        if (packet instanceof ActivityIQ) {
            StringBuilder sb = new StringBuilder("packet type= ");
            ActivityIQ activityIQ = (ActivityIQ) packet;
            sb.append(activityIQ.getActivityType());
            sb.append(", ring = ");
            sb.append(activityIQ.getRing());
            Log.i("anqi", sb.toString());
        }
        GoloService.m282a(packet);
        return false;
    }
}
