package message.xmpp.p385iq;

import org.jivesoftware.smack.packet.AbstractC4971IQ;

/* renamed from: message.xmpp.iq.ReceiptIQ */
/* loaded from: classes2.dex */
public class ReceiptIQ extends AbstractC4971IQ {
    private String receiptId;
    private long stamp;

    public ReceiptIQ() {
        setType(AbstractC4971IQ.Type.SET);
    }

    public ReceiptIQ(String str, long j) {
        setType(AbstractC4971IQ.Type.SET);
        this.receiptId = str;
        this.stamp = j;
    }

    public String getReceiptId() {
        return this.receiptId;
    }

    public void setReceiptId(String str) {
        this.receiptId = str;
    }

    @Override // org.jivesoftware.smack.packet.AbstractC4971IQ
    public String getChildElementXML() {
        return String.format("<receipt id=\"%s\" stamp=\"%s\"/>", this.receiptId, Long.valueOf(this.stamp));
    }
}
