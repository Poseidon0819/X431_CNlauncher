package message.xmpp.iqProvider;

import com.mopub.mobileads.VastExtensionXmlManager;
import message.xmpp.p385iq.UpgradeIQ;
import org.jivesoftware.smack.packet.AbstractC4971IQ;
import org.jivesoftware.smack.provider.IQProvider;
import org.xmlpull.p398v1.XmlPullParser;

/* loaded from: classes2.dex */
public class UpgradeIQProvider implements IQProvider {
    @Override // org.jivesoftware.smack.provider.IQProvider
    public AbstractC4971IQ parseIQ(XmlPullParser xmlPullParser) throws Exception {
        String attributeValue = xmlPullParser.getAttributeValue("", VastExtensionXmlManager.TYPE);
        String attributeValue2 = xmlPullParser.getAttributeValue("", "version");
        String attributeValue3 = xmlPullParser.getAttributeValue("", "serialNo");
        String attributeValue4 = xmlPullParser.getAttributeValue("", "updateTime");
        UpgradeIQ upgradeIQ = new UpgradeIQ();
        upgradeIQ.setUpgradeType(attributeValue);
        upgradeIQ.setVersion(attributeValue2);
        upgradeIQ.setSerialNo(attributeValue3);
        upgradeIQ.setUpdateTime(attributeValue4);
        return upgradeIQ;
    }
}
