package com.cnlaunch.x431pro.module.p255e.p256a;

import android.content.Context;
import android.text.TextUtils;
import com.cnlaunch.p120d.p121a.KeyConstant;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p125c.p128c.SyncHttpTransportSE;
import com.cnlaunch.x431pro.module.p241a.BaseAction;
import com.cnlaunch.x431pro.module.p241a.SoapObjectParams;
import com.cnlaunch.x431pro.module.p255e.p257b.CardConsumeListResult;
import com.cnlaunch.x431pro.module.p255e.p257b.ProductUpgradeResult;
import com.cnlaunch.x431pro.module.p255e.p257b.SysCardInfoResult;
import com.mopub.mobileads.VastExtensionXmlManager;
import java.io.IOException;
import org.p388a.p389a.SoapObject;
import org.p388a.p389a.SoapSerializationEnvelope;
import org.xmlpull.p398v1.XmlPullParserException;

/* renamed from: com.cnlaunch.x431pro.module.e.a.b */
/* loaded from: classes.dex */
public final class PincardAction extends BaseAction {
    public PincardAction(Context context) {
        super(context);
    }

    /* renamed from: a */
    public final ProductUpgradeResult m5356a(String str, String str2) throws C1425f {
        String b = m5451b(KeyConstant.f6892bm);
        if (TextUtils.isEmpty(b)) {
            b = "http://mycar.test.x431.com:8000/services/productUpgradeService?wsdl";
        }
        SoapObjectParams d = m5447d("upgradeProduct");
        d.mo169a("serialNo", str);
        d.mo169a("password", str2);
        d.mo169a(VastExtensionXmlManager.TYPE, "1");
        try {
            SyncHttpTransportSE f = m5436f(b);
            SoapSerializationEnvelope a = m5437a(m5453a((SoapObject) d), d);
            f.m141a("", a);
            if (a != null) {
                return (ProductUpgradeResult) m5443a(ProductUpgradeResult.class, a);
            }
            return null;
        } catch (IOException e) {
            throw new C1425f(e);
        } catch (XmlPullParserException e2) {
            throw new C1425f(e2);
        }
    }

    /* renamed from: a */
    public final SysCardInfoResult m5357a(String str) throws C1425f {
        String b = m5451b(KeyConstant.f6892bm);
        if (TextUtils.isEmpty(b)) {
            b = "http://mycar.test.x431.com:8000/services/productUpgradeService?wsdl";
        }
        SoapObjectParams d = m5447d("getSysCardInfoByCardNo");
        d.mo169a("cardNo", str);
        try {
            SyncHttpTransportSE f = m5436f(b);
            SoapSerializationEnvelope a = m5437a(m5453a((SoapObject) d), d);
            f.m141a("", a);
            if (a != null) {
                return (SysCardInfoResult) m5443a(SysCardInfoResult.class, a);
            }
            return null;
        } catch (IOException e) {
            throw new C1425f(e);
        } catch (XmlPullParserException e2) {
            throw new C1425f(e2);
        }
    }

    /* renamed from: g */
    public final CardConsumeListResult m5355g(String str) throws C1425f {
        String b = m5451b(KeyConstant.f6892bm);
        if (TextUtils.isEmpty(b)) {
            b = "http://mycar.test.x431.com:8000/services/productUpgradeService?wsdl";
        }
        SoapObjectParams d = m5447d("getProductUpgradeRecord");
        d.mo169a("serialNo", str);
        try {
            SyncHttpTransportSE f = m5436f(b);
            SoapSerializationEnvelope a = m5437a(m5453a((SoapObject) d), d);
            f.m141a("", a);
            int i = 0;
            CardConsumeListResult cardConsumeListResult = a != null ? (CardConsumeListResult) m5442a(CardConsumeListResult.class, a, "cardConsumeRecordList") : null;
            while (cardConsumeListResult.getCardConsumeRecordList() != null && cardConsumeListResult.getCardConsumeRecordList().size() > 0 && i < cardConsumeListResult.getCardConsumeRecordList().size()) {
                if (cardConsumeListResult.getCardConsumeRecordList().get(i).isEmpty()) {
                    cardConsumeListResult.getCardConsumeRecordList().remove(i);
                } else {
                    i++;
                }
            }
            return cardConsumeListResult;
        } catch (IOException e) {
            throw new C1425f(e);
        } catch (XmlPullParserException e2) {
            throw new C1425f(e2);
        }
    }

    /* renamed from: h */
    public final ProductUpgradeResult m5354h(String str) throws C1425f {
        String b = m5451b(KeyConstant.f6892bm);
        if (TextUtils.isEmpty(b)) {
            b = "http://mycar.test.x431.com:8000/services/productUpgradeService?wsdl";
        }
        SoapObjectParams d = m5447d("checkProductToUpgrade");
        d.mo169a("serialNo", str);
        try {
            SyncHttpTransportSE f = m5436f(b);
            SoapSerializationEnvelope a = m5437a(m5453a((SoapObject) d), d);
            f.m141a("", a);
            if (a != null) {
                return (ProductUpgradeResult) m5443a(ProductUpgradeResult.class, a);
            }
            return null;
        } catch (IOException e) {
            throw new C1425f(e);
        } catch (XmlPullParserException e2) {
            throw new C1425f(e2);
        }
    }
}
