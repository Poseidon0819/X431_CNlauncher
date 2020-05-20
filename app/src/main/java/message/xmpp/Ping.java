package message.xmpp;

import org.jivesoftware.smack.packet.AbstractC4971IQ;

/* loaded from: classes2.dex */
public class Ping extends AbstractC4971IQ {
    @Override // org.jivesoftware.smack.packet.AbstractC4971IQ
    public String getChildElementXML() {
        return null;
    }

    public Ping() {
        setType(AbstractC4971IQ.Type.PING);
    }
}
