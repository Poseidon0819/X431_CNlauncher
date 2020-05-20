package message.xmpp.p385iq;

import org.jivesoftware.smack.packet.AbstractC4971IQ;

/* renamed from: message.xmpp.iq.UpgradeIQ */
/* loaded from: classes2.dex */
public class UpgradeIQ extends AbstractC4971IQ {
    private String serialNo;
    private String updateTime;
    private String upgradeType;
    private String version;

    @Override // org.jivesoftware.smack.packet.AbstractC4971IQ
    public String getChildElementXML() {
        return null;
    }

    public String getUpgradeType() {
        return this.upgradeType;
    }

    public void setUpgradeType(String str) {
        this.upgradeType = str;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public String getSerialNo() {
        return this.serialNo;
    }

    public void setSerialNo(String str) {
        this.serialNo = str;
    }

    public String getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(String str) {
        this.updateTime = str;
    }
}
