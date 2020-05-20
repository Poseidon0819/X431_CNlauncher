package com.cnlaunch.x431pro.module.p241a;

import android.content.Context;
import android.text.TextUtils;
import com.cnlaunch.p120d.p121a.p122a.JsonMananger;
import com.cnlaunch.p120d.p121a.p122a.SoapManager;
import com.cnlaunch.p120d.p121a.p122a.XmlMananger;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p125c.p128c.SyncHttpClient;
import com.cnlaunch.p120d.p125c.p128c.SyncHttpTransportSE;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.x431pro.p210a.CertificadoAceptar;
import com.thoughtworks.xstream.XStream;
import org.codehaus.jackson.map.ObjectMapper;
import org.p388a.SoapFault;
import org.p388a.p389a.PropertyInfo;
import org.p388a.p389a.SoapObject;
import org.p388a.p389a.SoapPrimitive;
import org.p388a.p389a.SoapSerializationEnvelope;
import org.p393b.p395b.C4920a;

/* renamed from: com.cnlaunch.x431pro.module.a.b */
/* loaded from: classes.dex */
public abstract class BaseManager {

    /* renamed from: a */
    private final String f15444a;

    /* renamed from: e */
    protected Context f15445e;

    /* renamed from: f */
    public SyncHttpClient f15446f;

    /* renamed from: g */
    protected SyncHttpTransportSE f15447g;

    /* renamed from: h */
    protected SoapSerializationEnvelope f15448h;

    /* renamed from: i */
    protected ObjectMapper f15449i;

    /* renamed from: j */
    protected XStream f15450j;

    public BaseManager(Context context) {
        this(context, (byte) 0);
    }

    private BaseManager(Context context, byte b) {
        this.f15444a = BaseManager.class.getSimpleName();
        this.f15445e = context;
        this.f15446f = SyncHttpClient.m9481a(context);
        JsonMananger.m9626a();
        this.f15449i = JsonMananger.m9623b();
        this.f15450j = XmlMananger.m9614a().f6750a;
    }

    /* renamed from: f */
    public final SyncHttpTransportSE m5436f(String str) {
        NLog.m9451c(this.f15444a, "url: ".concat(String.valueOf(str)));
        return m5439a(str.split("\\?")[0], 30000);
    }

    /* renamed from: a */
    public final SyncHttpTransportSE m5439a(String str, int i) {
        new CertificadoAceptar();
        CertificadoAceptar.m7971a();
        this.f15447g = new SyncHttpTransportSE(str, i);
        if (NLog.m9458a()) {
            this.f15447g.f24137d = true;
        }
        return this.f15447g;
    }

    /* renamed from: a */
    public final SoapSerializationEnvelope m5437a(C4920a[] c4920aArr, SoapObject soapObject) {
        this.f15448h = new SoapSerializationEnvelope();
        SoapSerializationEnvelope soapSerializationEnvelope = this.f15448h;
        soapSerializationEnvelope.f24125d = c4920aArr;
        soapSerializationEnvelope.f24123b = soapObject;
        soapSerializationEnvelope.f24123b = soapObject;
        NLog.m9451c(this.f15444a, this.f15447g.f24138e);
        return this.f15448h;
    }

    /* renamed from: a */
    public static <T> T m5438a(String str, Class<T> cls) throws C1425f {
        JsonMananger.m9626a();
        return (T) JsonMananger.m9624a(str, cls);
    }

    /* renamed from: a */
    public static String m5440a(Object obj) throws C1425f {
        JsonMananger.m9626a();
        return JsonMananger.m9625a(obj);
    }

    /* renamed from: a */
    public final <T> T m5444a(Class<T> cls) throws SoapFault, C1425f {
        return (T) m5441a(cls, new String[0]);
    }

    /* renamed from: a */
    public static <T> T m5443a(Class<T> cls, SoapSerializationEnvelope soapSerializationEnvelope) throws SoapFault, C1425f {
        return (T) m5442a(cls, soapSerializationEnvelope, new String[0]);
    }

    /* renamed from: a */
    public static <T> T m5442a(Class<T> cls, SoapSerializationEnvelope soapSerializationEnvelope, String... strArr) throws SoapFault, C1425f {
        String m9620a;
        SoapObject soapObject = new SoapObject();
        C4920a[] c4920aArr = soapSerializationEnvelope.f24124c;
        boolean z = true;
        if (c4920aArr != null && c4920aArr.length > 0) {
            String valueOf = String.valueOf(((C4920a) c4920aArr[0].m102a(0)).m102a(0));
            String valueOf2 = String.valueOf(((C4920a) c4920aArr[0].m102a(1)).m102a(0));
            PropertyInfo propertyInfo = new PropertyInfo();
            propertyInfo.setType(SoapPrimitive.class);
            propertyInfo.setName("code");
            propertyInfo.setValue(valueOf);
            soapObject.m168a(propertyInfo);
            PropertyInfo propertyInfo2 = new PropertyInfo();
            propertyInfo2.setType(SoapPrimitive.class);
            propertyInfo2.setName("msg");
            propertyInfo2.setValue(valueOf2);
            soapObject.m168a(propertyInfo2);
        } else if (soapSerializationEnvelope != null && soapSerializationEnvelope.m163a() != null) {
            soapObject = (SoapObject) soapSerializationEnvelope.m163a();
        }
        int length = strArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = false;
                break;
            } else if (strArr[i].equals("productDTOs")) {
                break;
            } else {
                i++;
            }
        }
        if (z) {
            m9620a = SoapManager.m9621a().m9619a(soapObject, cls, strArr);
        } else {
            m9620a = SoapManager.m9621a().m9620a(soapObject);
        }
        if (TextUtils.isEmpty(m9620a)) {
            return null;
        }
        return (T) m5438a(m9620a, cls);
    }

    /* renamed from: a */
    public final <T> T m5441a(Class<T> cls, String... strArr) throws SoapFault, C1425f {
        String m9620a;
        String str = this.f15444a;
        boolean z = true;
        NLog.m9451c(str, "responseDump: " + this.f15447g.f24139f);
        SoapObject soapObject = new SoapObject();
        C4920a[] c4920aArr = this.f15448h.f24124c;
        if (c4920aArr != null && c4920aArr.length > 0) {
            String valueOf = String.valueOf(((C4920a) c4920aArr[0].m102a(0)).m102a(0));
            String valueOf2 = String.valueOf(((C4920a) c4920aArr[0].m102a(1)).m102a(0));
            PropertyInfo propertyInfo = new PropertyInfo();
            propertyInfo.setType(SoapPrimitive.class);
            propertyInfo.setName("code");
            propertyInfo.setValue(valueOf);
            soapObject.m168a(propertyInfo);
            PropertyInfo propertyInfo2 = new PropertyInfo();
            propertyInfo2.setType(SoapPrimitive.class);
            propertyInfo2.setName("msg");
            propertyInfo2.setValue(valueOf2);
            soapObject.m168a(propertyInfo2);
        } else {
            SoapSerializationEnvelope soapSerializationEnvelope = this.f15448h;
            if (soapSerializationEnvelope != null && soapSerializationEnvelope.m163a() != null) {
                soapObject = (SoapObject) this.f15448h.m163a();
            }
        }
        int length = strArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = false;
                break;
            } else if (strArr[i].equals("productDTOs")) {
                break;
            } else {
                i++;
            }
        }
        if (z) {
            m9620a = SoapManager.m9621a().m9619a(soapObject, cls, strArr);
        } else {
            m9620a = SoapManager.m9621a().m9620a(soapObject);
        }
        if (TextUtils.isEmpty(m9620a)) {
            return null;
        }
        return (T) m5438a(m9620a, cls);
    }
}
