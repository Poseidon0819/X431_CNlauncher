package com.cnlaunch.x431pro.module.p258f.p259a;

import android.content.Context;
import android.text.TextUtils;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p125c.p128c.C1426i;
import com.cnlaunch.p120d.p125c.p128c.SyncHttpTransportSE;
import com.cnlaunch.p120d.p130d.MD5Utils;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.x431pro.activity.GDApplication;
import com.cnlaunch.x431pro.module.p241a.BaseAction;
import com.cnlaunch.x431pro.module.p241a.BaseResponse;
import com.cnlaunch.x431pro.module.p241a.CommonResponse;
import com.cnlaunch.x431pro.module.p241a.SoapObjectParams;
import com.cnlaunch.x431pro.module.p258f.p260b.AlipayQrCodeCyResponse;
import com.cnlaunch.x431pro.module.p258f.p260b.ConfigPriceResponse;
import com.cnlaunch.x431pro.module.p258f.p260b.CyBaseResponse;
import com.cnlaunch.x431pro.module.p258f.p260b.CyOrderInfoResponse;
import com.cnlaunch.x431pro.module.p258f.p260b.CyOrderListResponse;
import com.cnlaunch.x431pro.module.p258f.p260b.CyOrderResponse;
import com.cnlaunch.x431pro.module.p258f.p260b.CyOrderTypeResponse;
import com.cnlaunch.x431pro.module.p258f.p260b.CyUserInfoResponse;
import com.cnlaunch.x431pro.module.p258f.p260b.OrderCreateResponse;
import com.cnlaunch.x431pro.module.p258f.p260b.UnionTradeResponse;
import com.cnlaunch.x431pro.module.p258f.p260b.UserOrderListInfoResponse;
import com.cnlaunch.x431pro.module.p258f.p260b.UserOrderResponse;
import com.cnlaunch.x431pro.module.p258f.p260b.WxPayResponse;
import com.cnlaunch.x431pro.p210a.C1947h;
import com.cnlaunch.x431pro.utils.C2778n;
import com.unionpay.tsmservice.data.Constant;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.jivesoftware.smackx.packet.MultipleAddresses;
import org.p388a.p389a.SoapObject;
import org.p388a.p389a.SoapSerializationEnvelope;
import org.xmlpull.p398v1.XmlPullParserException;

/* renamed from: com.cnlaunch.x431pro.module.f.a.a */
/* loaded from: classes.dex */
public final class PayAction extends BaseAction {
    public PayAction(Context context) {
        super(context);
    }

    /* renamed from: a */
    public final WxPayResponse m5351a(String str) throws IOException, C1425f {
        InputStream inputStream;
        StringBuilder sb = new StringBuilder();
        boolean z = GDApplication.f10693a;
        sb.append("http://mycar.x431.com/rest/inner/cyUser/cyOrderWXPay.json");
        String sb2 = sb.toString();
        LinkedList linkedList = new LinkedList();
        linkedList.add(new BasicNameValuePair("launchOrderNo", str));
        URLEncodedUtils.format(linkedList, "UTF-8");
        try {
            inputStream = new DefaultHttpClient().execute(new HttpGet(m5347a(sb2, linkedList))).getEntity().getContent();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
            inputStream = null;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        String str2 = "";
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                str2 = str2 + readLine;
            } else {
                return (WxPayResponse) m5438a(str2, WxPayResponse.class);
            }
        }
    }

    /* renamed from: g */
    public final UnionTradeResponse m5342g(String str) throws C1425f, IOException {
        InputStream inputStream;
        StringBuilder sb = new StringBuilder();
        boolean z = GDApplication.f10693a;
        sb.append("http://mycar.x431.com/rest/inner/cyUser/cyOrderUnionPay.json");
        String sb2 = sb.toString();
        LinkedList linkedList = new LinkedList();
        linkedList.add(new BasicNameValuePair("launchOrderNo", str));
        URLEncodedUtils.format(linkedList, "UTF-8");
        try {
            inputStream = new DefaultHttpClient().execute(new HttpGet(m5347a(sb2, linkedList))).getEntity().getContent();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
            inputStream = null;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        String str2 = "";
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                str2 = str2 + readLine;
            } else {
                return (UnionTradeResponse) m5438a(str2, UnionTradeResponse.class);
            }
        }
    }

    /* renamed from: a */
    public final CyOrderResponse m5350a(String str, int i, double d) throws IOException, C1425f {
        InputStream inputStream;
        String m4889a = C2778n.C2783c.m4889a(C1947h.C1948a.f10574e);
        LinkedList linkedList = new LinkedList();
        linkedList.add(new BasicNameValuePair("serialNo", str));
        linkedList.add(new BasicNameValuePair("orderTypeId", String.valueOf(i)));
        linkedList.add(new BasicNameValuePair("orderTypePrice", String.valueOf(d)));
        URLEncodedUtils.format(linkedList, "UTF-8");
        try {
            inputStream = new DefaultHttpClient().execute(new HttpGet(m5347a(m4889a, linkedList))).getEntity().getContent();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
            inputStream = null;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        String str2 = "";
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                str2 = str2 + readLine;
            } else {
                return (CyOrderResponse) m5438a(str2, CyOrderResponse.class);
            }
        }
    }

    /* renamed from: h */
    public final CyUserInfoResponse m5341h(String str) throws IOException, C1425f {
        InputStream inputStream;
        String m4889a = C2778n.C2783c.m4889a(C1947h.C1948a.f10572c);
        LinkedList linkedList = new LinkedList();
        linkedList.add(new BasicNameValuePair("serialNo", str));
        URLEncodedUtils.format(linkedList, "UTF-8");
        try {
            inputStream = new DefaultHttpClient().execute(new HttpGet(m5347a(m4889a, linkedList))).getEntity().getContent();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
            inputStream = null;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        String str2 = "";
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                str2 = str2 + readLine;
            } else {
                CyUserInfoResponse cyUserInfoResponse = (CyUserInfoResponse) m5438a(str2, CyUserInfoResponse.class);
                new StringBuilder("getUserInfo---CyUserInfoResponse=").append(cyUserInfoResponse.toString());
                return cyUserInfoResponse;
            }
        }
    }

    /* renamed from: i */
    public final CyOrderListResponse m5340i(String str) throws IOException, C1425f {
        InputStream inputStream;
        String m4889a = C2778n.C2783c.m4889a(C1947h.C1948a.f10573d);
        LinkedList linkedList = new LinkedList();
        linkedList.add(new BasicNameValuePair("serialNo", str));
        URLEncodedUtils.format(linkedList, "UTF-8");
        try {
            inputStream = new DefaultHttpClient().execute(new HttpGet(m5347a(m4889a, linkedList))).getEntity().getContent();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
            inputStream = null;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        String str2 = "";
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                str2 = str2 + readLine;
            } else {
                return (CyOrderListResponse) m5438a(str2, CyOrderListResponse.class);
            }
        }
    }

    /* renamed from: j */
    public final CyOrderInfoResponse m5339j(String str) throws IOException, C1425f {
        InputStream inputStream;
        StringBuilder sb = new StringBuilder();
        boolean z = GDApplication.f10693a;
        sb.append("http://mycar.x431.com/rest/inner/cyUser/getCyOrderInfo.json");
        String sb2 = sb.toString();
        LinkedList linkedList = new LinkedList();
        linkedList.add(new BasicNameValuePair("launchOrderNo", str));
        URLEncodedUtils.format(linkedList, "UTF-8");
        try {
            inputStream = new DefaultHttpClient().execute(new HttpPost(m5347a(sb2, linkedList))).getEntity().getContent();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
            inputStream = null;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        String str2 = "";
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                str2 = str2 + readLine;
            } else {
                return (CyOrderInfoResponse) m5438a(str2, CyOrderInfoResponse.class);
            }
        }
    }

    /* renamed from: k */
    public final CyBaseResponse m5338k(String str) throws IOException, C1425f {
        InputStream inputStream;
        StringBuilder sb = new StringBuilder();
        boolean z = GDApplication.f10693a;
        sb.append("http://mycar.x431.com/rest/inner/cyUser/cancleCyOrder.json");
        String sb2 = sb.toString();
        LinkedList linkedList = new LinkedList();
        linkedList.add(new BasicNameValuePair("launchOrderNo", str));
        URLEncodedUtils.format(linkedList, "UTF-8");
        try {
            inputStream = new DefaultHttpClient().execute(new HttpGet(m5347a(sb2, linkedList))).getEntity().getContent();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
            inputStream = null;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        String str2 = "";
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                str2 = str2 + readLine;
            } else {
                return (CyBaseResponse) m5438a(str2, CyBaseResponse.class);
            }
        }
    }

    /* renamed from: a */
    public final CyOrderTypeResponse m5353a() throws IOException, C1425f {
        StringBuilder sb = new StringBuilder();
        boolean z = GDApplication.f10693a;
        sb.append("http://mycar.x431.com/rest/inner/cyUser/getCyOrderType.json");
        InputStream inputStream = null;
        try {
            inputStream = new DefaultHttpClient().execute(new HttpGet(m5347a(sb.toString(), (List<BasicNameValuePair>) null))).getEntity().getContent();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        String str = "";
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                str = str + readLine;
            } else {
                return (CyOrderTypeResponse) m5438a(str, CyOrderTypeResponse.class);
            }
        }
    }

    /* renamed from: a */
    public static BaseResponse m5348a(String str, String str2, String str3, String str4) throws C1425f {
        StringBuilder sb = new StringBuilder();
        boolean z = GDApplication.f10693a;
        sb.append("http://mycar.x431.com/rest/visa/pay");
        String sb2 = sb.toString();
        LinkedList linkedList = new LinkedList();
        linkedList.add(new BasicNameValuePair("cardNum", str));
        linkedList.add(new BasicNameValuePair(Constant.KEY_EXPIRATION_DATE, str2));
        linkedList.add(new BasicNameValuePair("cardCode", str3));
        linkedList.add(new BasicNameValuePair("orderSn", str4));
        URLEncodedUtils.format(linkedList, "UTF-8");
        String m5343b = m5343b(sb2, linkedList);
        NLog.m9452b("anqi", "payByCreditCard getUir=".concat(String.valueOf(m5343b)));
        try {
            HttpResponse execute = new DefaultHttpClient().execute(new HttpGet(m5343b));
            if (execute.getStatusLine().getStatusCode() == 200) {
                String entityUtils = EntityUtils.toString(execute.getEntity());
                NLog.m9452b("anqi", "payByCreditCard json=".concat(String.valueOf(entityUtils)));
                return (BaseResponse) m5438a(entityUtils, BaseResponse.class);
            }
            return null;
        } catch (ClientProtocolException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    private static int m5345a(BasicNameValuePair basicNameValuePair, BasicNameValuePair basicNameValuePair2) {
        return basicNameValuePair.getName().compareTo(basicNameValuePair2.getName());
    }

    /* renamed from: a */
    private static String m5346a(List<BasicNameValuePair> list) {
        if (list == null) {
            return "";
        }
        int i = 0;
        while (i < list.size()) {
            int i2 = i + 1;
            BasicNameValuePair basicNameValuePair = list.get(i);
            for (int i3 = i2; i3 < list.size(); i3++) {
                BasicNameValuePair basicNameValuePair2 = list.get(i3);
                if (m5345a(basicNameValuePair, basicNameValuePair2) > 0) {
                    list.set(i, basicNameValuePair2);
                    list.set(i3, basicNameValuePair);
                    basicNameValuePair = basicNameValuePair2;
                }
            }
            i = i2;
        }
        String str = "";
        String str2 = "";
        for (int i4 = 0; i4 < list.size(); i4++) {
            str2 = str2 + list.get(i4).getValue();
            str = str + list.get(i4).getName();
        }
        NLog.m9456a("weiwell", "signNames:".concat(String.valueOf(str)));
        NLog.m9456a("weiwell", "signValue:".concat(String.valueOf(str2)));
        return str2;
    }

    /* renamed from: a */
    private String m5347a(String str, List<BasicNameValuePair> list) throws C1425f {
        StringBuilder sb = new StringBuilder(str);
        C1426i c1426i = new C1426i();
        String m9591a = PreferencesManager.m9595a(this.f15439a).m9591a("user_id");
        String m9591a2 = PreferencesManager.m9595a(this.f15439a).m9591a("token");
        if (TextUtils.isEmpty(m9591a) || TextUtils.isEmpty(m9591a2)) {
            throw new C1425f("PayAction getSignUri method IllegalArgumentException.");
        }
        String str2 = "";
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                c1426i.m9506a(basicNameValuePair.getName(), basicNameValuePair.getValue());
            }
            str2 = m5346a(list);
        }
        NLog.m9456a("weiwell", "sign:".concat(String.valueOf(str2)));
        c1426i.m9506a(MultipleAddresses.f24412CC, m9591a);
        c1426i.m9506a("sign", MD5Utils.m9460a(str2 + m9591a2));
        sb.append("?");
        sb.append(c1426i.m9505b());
        NLog.m9456a("weiwell", "getUri:" + sb.toString());
        return sb.toString();
    }

    /* renamed from: b */
    private static String m5343b(String str, List<BasicNameValuePair> list) throws C1425f {
        StringBuilder sb = new StringBuilder(str);
        C1426i c1426i = new C1426i();
        String m9591a = PreferencesManager.m9595a(GDApplication.f10694b).m9591a("user_id");
        String m9591a2 = PreferencesManager.m9595a(GDApplication.f10694b).m9591a("token");
        if (TextUtils.isEmpty(m9591a) || TextUtils.isEmpty(m9591a2)) {
            throw new C1425f("PayAction getSignUri method IllegalArgumentException.");
        }
        for (BasicNameValuePair basicNameValuePair : list) {
            c1426i.m9506a(basicNameValuePair.getName(), basicNameValuePair.getValue());
        }
        int i = 0;
        while (i < list.size()) {
            int i2 = i + 1;
            BasicNameValuePair basicNameValuePair2 = list.get(i);
            for (int i3 = i2; i3 < list.size(); i3++) {
                BasicNameValuePair basicNameValuePair3 = list.get(i3);
                if (m5345a(basicNameValuePair2, basicNameValuePair3) > 0) {
                    list.set(i, basicNameValuePair3);
                    list.set(i3, basicNameValuePair2);
                    basicNameValuePair2 = basicNameValuePair3;
                }
            }
            i = i2;
        }
        String str2 = "";
        for (int i4 = 0; i4 < list.size(); i4++) {
            str2 = str2 + list.get(i4).getName() + "=" + list.get(i4).getValue();
            if (i4 != list.size() - 1) {
                str2 = str2 + "&";
            }
        }
        NLog.m9456a("anqi", "sign:".concat(String.valueOf(str2)));
        c1426i.m9506a(MultipleAddresses.f24412CC, m9591a);
        c1426i.m9506a("sign", MD5Utils.m9460a(str2 + m9591a2));
        sb.append("?");
        sb.append(c1426i.m9505b());
        NLog.m9456a("anqi", "getUri:" + sb.toString());
        return sb.toString();
    }

    /* renamed from: l */
    public final ConfigPriceResponse m5337l(String str) throws C1425f {
        String b = m5451b("createDiagSoftOrder");
        if (TextUtils.isEmpty(b)) {
            StringBuilder sb = new StringBuilder();
            boolean z = GDApplication.f10693a;
            sb.append("http://mycar.x431.com/services/userOrderService?wsdl");
            b = sb.toString();
        }
        SoapObjectParams d = m5447d("getConfigPriceBySn");
        d.mo169a("serialNo", str);
        try {
            SyncHttpTransportSE f = m5436f(b);
            SoapSerializationEnvelope a = m5437a(m5453a((SoapObject) d), d);
            f.m141a("", a);
            if (a != null) {
                return (ConfigPriceResponse) m5443a(ConfigPriceResponse.class, a);
            }
            return null;
        } catch (IOException e) {
            throw new C1425f(e);
        } catch (XmlPullParserException e2) {
            throw new C1425f(e2);
        }
    }

    /* renamed from: a */
    public final OrderCreateResponse m5349a(String str, String str2) throws C1425f {
        String b = m5451b("createDiagSoftOrder");
        if (TextUtils.isEmpty(b)) {
            StringBuilder sb = new StringBuilder();
            boolean z = GDApplication.f10693a;
            sb.append("http://mycar.x431.com/services/userOrderService?wsdl");
            b = sb.toString();
        }
        SoapObjectParams d = m5447d("createOrderByConfig");
        d.mo169a("serialNo", str);
        d.mo169a("lanCode", str2);
        try {
            SyncHttpTransportSE f = m5436f(b);
            SoapSerializationEnvelope a = m5437a(m5453a((SoapObject) d), d);
            f.m141a("", a);
            if (a != null) {
                return (OrderCreateResponse) m5442a(OrderCreateResponse.class, a, "orderInfoList");
            }
            return null;
        } catch (IOException e) {
            throw new C1425f(e);
        } catch (XmlPullParserException e2) {
            throw new C1425f(e2);
        }
    }

    /* renamed from: m */
    public final UserOrderResponse m5336m(String str) throws C1425f {
        String b = m5451b("createDiagSoftOrder");
        if (TextUtils.isEmpty(b)) {
            StringBuilder sb = new StringBuilder();
            boolean z = GDApplication.f10693a;
            sb.append("http://mycar.x431.com/services/userOrderService?wsdl");
            b = sb.toString();
        }
        SoapObjectParams d = m5447d("getUserOrder");
        d.mo169a("orderSn", str);
        try {
            SyncHttpTransportSE f = m5436f(b);
            SoapSerializationEnvelope a = m5437a(m5453a((SoapObject) d), d);
            f.m141a("", a);
            if (a != null) {
                return (UserOrderResponse) m5443a(UserOrderResponse.class, a);
            }
            return null;
        } catch (IOException e) {
            throw new C1425f(e);
        } catch (XmlPullParserException e2) {
            throw new C1425f(e2);
        }
    }

    /* renamed from: n */
    public static String m5335n(String str) throws C1425f {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String str2 = "";
        if (TextUtils.isEmpty("")) {
            StringBuilder sb = new StringBuilder();
            boolean z = GDApplication.f10693a;
            sb.append("http://mycar.x431.com/pad/paypal/enterPaypalForLaunch.action?landingpage=Login&orderId=");
            str2 = sb.toString();
        }
        return str2 + str;
    }

    /* renamed from: a */
    public final CommonResponse m5352a(int i) throws C1425f {
        String b = m5451b("createDiagSoftOrder");
        if (TextUtils.isEmpty(b)) {
            StringBuilder sb = new StringBuilder();
            boolean z = GDApplication.f10693a;
            sb.append("http://mycar.x431.com/services/userOrderService?wsdl");
            b = sb.toString();
        }
        SoapObjectParams d = m5447d("cancelOrder");
        d.mo169a("orderId", Integer.valueOf(i));
        return m5434a(b, d, m5453a((SoapObject) d));
    }

    /* renamed from: b */
    public final UserOrderListInfoResponse m5344b(String str, String str2) throws C1425f {
        String b = m5451b("createDiagSoftOrder");
        if (TextUtils.isEmpty(b)) {
            StringBuilder sb = new StringBuilder();
            boolean z = GDApplication.f10693a;
            sb.append("http://mycar.x431.com/services/userOrderService?wsdl");
            b = sb.toString();
        }
        SoapObjectParams d = m5447d("getUserOrderList");
        d.mo169a("CC", str);
        d.mo169a("serialNo", str2);
        try {
            SyncHttpTransportSE f = m5436f(b);
            SoapSerializationEnvelope a = m5437a(m5453a((SoapObject) d), d);
            f.m141a("", a);
            if (a != null) {
                return (UserOrderListInfoResponse) m5442a(UserOrderListInfoResponse.class, a, "orderList");
            }
            return null;
        } catch (IOException e) {
            throw new C1425f(e);
        } catch (XmlPullParserException e2) {
            throw new C1425f(e2);
        }
    }

    /* renamed from: o */
    public final AlipayQrCodeCyResponse m5334o(String str) throws IOException, C1425f {
        InputStream inputStream;
        try {
            inputStream = new DefaultHttpClient().execute(new HttpGet(C2778n.C2783c.m4886a(C2778n.C2783c.m4889a(C1947h.C1948a.f10571b), "orderNo", str, MultipleAddresses.f24412CC, PreferencesManager.m9595a(this.f15439a).m9591a("user_id"), "sign", MD5Utils.m9460a(str + PreferencesManager.m9595a(this.f15439a).m9591a("token"))))).getEntity().getContent();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
            inputStream = null;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        String str2 = "";
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                str2 = str2 + readLine;
            } else {
                return (AlipayQrCodeCyResponse) m5438a(str2, AlipayQrCodeCyResponse.class);
            }
        }
    }
}
