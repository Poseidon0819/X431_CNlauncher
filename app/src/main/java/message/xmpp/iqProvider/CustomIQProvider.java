package message.xmpp.iqProvider;

import com.mopub.mobileads.VastExtensionXmlManager;
import org.jivesoftware.smack.packet.AbstractC4971IQ;
import org.jivesoftware.smack.packet.CustomIQ;
import org.jivesoftware.smack.provider.IQProvider;
import org.xmlpull.p398v1.XmlPullParser;

/* loaded from: classes2.dex */
public class CustomIQProvider implements IQProvider {
    @Override // org.jivesoftware.smack.provider.IQProvider
    public AbstractC4971IQ parseIQ(XmlPullParser xmlPullParser) throws Exception {
        String attributeValue = xmlPullParser.getAttributeValue("", VastExtensionXmlManager.TYPE);
        CustomIQ customIQ = new CustomIQ();
        customIQ.setShareType(attributeValue);
        customIQ.customType = CustomIQ.Type.SHARE;
        return customIQ;
    }
}
