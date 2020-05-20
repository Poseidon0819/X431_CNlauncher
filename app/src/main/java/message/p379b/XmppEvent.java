package message.p379b;

import com.cnlaunch.golo3.p165g.AbstractC1613g;
import org.jivesoftware.smack.packet.Packet;

/* renamed from: message.b.a */
/* loaded from: classes2.dex */
public final class XmppEvent extends AbstractC1613g {

    /* renamed from: a */
    public EnumC4723a f23966a;

    /* renamed from: b */
    public Packet f23967b;

    /* compiled from: XmppEvent.java */
    /* renamed from: message.b.a$a */
    /* loaded from: classes2.dex */
    public enum EnumC4723a {
        connect_successfully,
        connect_failed,
        pwd_error,
        conflict,
        send_failed,
        receive_msg,
        ping_failed,
        receive_share,
        receive_upgrade_bin,
        receive_offline_msg_end,
        service_stop,
        start_noti,
        envent_notice,
        relogin_failed,
        connect_error
    }

    public XmppEvent(EnumC4723a enumC4723a) {
        this.f23966a = enumC4723a;
    }
}
