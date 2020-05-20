package com.cnlaunch.p120d.p121a.p122a;

import android.text.TextUtils;
import com.cnlaunch.p120d.p121a.CacheManager;
import com.cnlaunch.p120d.p130d.NLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.p388a.p389a.PropertyInfo;
import org.p388a.p389a.SoapObject;
import org.p388a.p389a.SoapPrimitive;

/* renamed from: com.cnlaunch.d.a.a.b */
/* loaded from: classes.dex */
public class SoapManager {

    /* renamed from: b */
    private static SoapManager f6747b;

    /* renamed from: a */
    private final String f6748a = SoapManager.class.getSimpleName();

    /* renamed from: a */
    public static SoapManager m9621a() {
        if (f6747b == null) {
            synchronized (SoapManager.class) {
                if (f6747b == null) {
                    f6747b = new SoapManager();
                }
            }
        }
        return f6747b;
    }

    /* renamed from: a */
    public final <T> String m9619a(SoapObject soapObject, Class<T> cls, String... strArr) {
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        HashSet<String> hashSet = new HashSet<>();
        m9617a(soapObject, jSONObject, hashSet);
        NLog.m9451c(this.f6748a, "jsonResult: ".concat(String.valueOf(jSONObject)));
        if (NLog.m9458a()) {
            Iterator<String> it = hashSet.iterator();
            while (it.hasNext()) {
                String str = this.f6748a;
                NLog.m9451c(str, "jsonResult:hashset" + it.next());
            }
        }
        String m9615a = m9615a(jSONObject, hashSet, strArr);
        String str2 = this.f6748a;
        NLog.m9451c(str2, "soapToJson: " + m9615a.toString());
        long currentTimeMillis2 = System.currentTimeMillis();
        String str3 = this.f6748a;
        NLog.m9451c(str3, "soapToJson take time : " + (currentTimeMillis2 - currentTimeMillis));
        if (NLog.m9458a()) {
            CacheManager.m9603a(m9615a, cls.getSimpleName() + ".txt");
        }
        return m9615a;
    }

    /* renamed from: a */
    public final <T> String m9620a(SoapObject soapObject) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        m9616a(soapObject, jSONObject, arrayList);
        return jSONObject.toString();
    }

    /* renamed from: a */
    private void m9616a(SoapObject soapObject, JSONObject jSONObject, List<String> list) {
        boolean z;
        if (soapObject != null) {
            try {
                int mo173a = soapObject.mo173a();
                for (int i = 0; i < mo173a; i++) {
                    PropertyInfo propertyInfo = new PropertyInfo();
                    soapObject.m166b(i, propertyInfo);
                    String name = propertyInfo.getName();
                    if (SoapPrimitive.class != propertyInfo.getType() && (list == null || !list.contains(name))) {
                        if (SoapObject.class == propertyInfo.getType()) {
                            SoapObject soapObject2 = (SoapObject) soapObject.mo172a(i);
                            if (soapObject2 != null) {
                                ArrayList arrayList = new ArrayList();
                                int mo173a2 = soapObject2.mo173a();
                                int i2 = 0;
                                while (true) {
                                    if (i2 < mo173a2) {
                                        PropertyInfo propertyInfo2 = new PropertyInfo();
                                        soapObject2.m166b(i2, propertyInfo2);
                                        if (SoapPrimitive.class == propertyInfo2.getType()) {
                                            break;
                                        }
                                        if (SoapObject.class == propertyInfo2.getType()) {
                                            arrayList.add(propertyInfo2.getName());
                                        }
                                        i2++;
                                    } else if (arrayList.size() > 0) {
                                        int size = arrayList.size();
                                        String str = (String) arrayList.get(0);
                                        if (mo173a2 == size) {
                                            Iterator it = arrayList.iterator();
                                            while (it.hasNext()) {
                                                if (((String) it.next()).equals(str)) {
                                                    size--;
                                                }
                                            }
                                            if (size == 0) {
                                                z = true;
                                            }
                                        }
                                    }
                                }
                            }
                            z = false;
                            if (!z) {
                                JSONObject jSONObject2 = new JSONObject();
                                m9616a(soapObject2, jSONObject2, list);
                                jSONObject.put(name, jSONObject2);
                            } else {
                                JSONArray jSONArray = new JSONArray();
                                m9618a(soapObject2, jSONArray, list);
                                jSONObject.put(name, jSONArray);
                            }
                        }
                    }
                    Object value = propertyInfo.getValue();
                    if (list != null && list.contains(name) && "anyType{}".equals(value.toString())) {
                        value = "";
                    }
                    jSONObject.put(name, value);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private void m9618a(SoapObject soapObject, JSONArray jSONArray, List<String> list) {
        if (soapObject != null) {
            int mo173a = soapObject.mo173a();
            for (int i = 0; i < mo173a; i++) {
                PropertyInfo propertyInfo = new PropertyInfo();
                soapObject.m166b(i, propertyInfo);
                if (SoapObject.class == propertyInfo.getType()) {
                    JSONObject jSONObject = new JSONObject();
                    m9616a((SoapObject) soapObject.mo172a(i), jSONObject, list);
                    jSONArray.put(jSONObject);
                }
            }
        }
    }

    /* renamed from: a */
    private void m9617a(SoapObject soapObject, JSONObject jSONObject, HashSet<String> hashSet) {
        if (soapObject != null) {
            try {
                int mo173a = soapObject.mo173a();
                for (int i = 0; i < mo173a; i++) {
                    PropertyInfo propertyInfo = new PropertyInfo();
                    soapObject.m166b(i, propertyInfo);
                    String name = propertyInfo.getName();
                    if (SoapPrimitive.class == propertyInfo.getType()) {
                        jSONObject.put(name, propertyInfo.getValue());
                    } else if (SoapObject.class == propertyInfo.getType()) {
                        JSONObject jSONObject2 = new JSONObject();
                        SoapObject soapObject2 = (SoapObject) soapObject.mo172a(i);
                        if (jSONObject.has(name)) {
                            hashSet.add(name);
                            name = name + i;
                            hashSet.add(name);
                        }
                        m9617a(soapObject2, jSONObject2, hashSet);
                        jSONObject.put(name, jSONObject2);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private String m9615a(JSONObject jSONObject, HashSet<String> hashSet, String... strArr) {
        try {
            JSONArray jSONArray = new JSONArray();
            if (strArr != null && strArr.length > 0) {
                Iterator<String> keys = new JSONObject(jSONObject.toString()).keys();
                int i = 1;
                char c = 0;
                NLog.m9456a(this.f6748a, "it=".concat(String.valueOf(keys)));
                int length = strArr.length;
                int i2 = 0;
                while (i2 < length) {
                    String str = strArr[i2];
                    while (keys.hasNext()) {
                        String obj = keys.next().toString();
                        String replace = obj.replace(str, "");
                        String str2 = this.f6748a;
                        Object[] objArr = new Object[i];
                        objArr[c] = "nodeName=" + str + ",jsonKey=" + obj + ",index=" + replace;
                        NLog.m9456a(str2, objArr);
                        if (str.equals(obj)) {
                            JSONObject jSONObject2 = (JSONObject) jSONObject.remove(obj);
                            String str3 = this.f6748a;
                            Object[] objArr2 = new Object[i];
                            objArr2[c] = "itemObj=".concat(String.valueOf(jSONObject2));
                            NLog.m9456a(str3, objArr2);
                            Iterator<String> keys2 = jSONObject2.keys();
                            String str4 = this.f6748a;
                            Object[] objArr3 = new Object[i];
                            objArr3[c] = "itemIt=".concat(String.valueOf(keys2));
                            NLog.m9456a(str4, objArr3);
                            boolean z = true;
                            while (keys2.hasNext()) {
                                String obj2 = keys2.next().toString();
                                String str5 = this.f6748a;
                                Object[] objArr4 = new Object[i];
                                c = 0;
                                objArr4[0] = "itemkey=".concat(String.valueOf(obj2));
                                NLog.m9456a(str5, objArr4);
                                if (hashSet.isEmpty() && (obj2.equals("x431PadSoft") || obj2.equals("diagLogBasicDTO") || obj2.equals("orderInfo") || obj2.equals("normalBillInfo") || obj2.equals("postAddressInfoDTO") || obj2.equals("userOrder") || obj2.equals("valueAddedTaxBillInfo") || obj2.equals("diagSoftSubPack") || obj2.equals("systemFunction") || obj2.equals("diagSoftBaseInfoList"))) {
                                    jSONArray.put((JSONObject) jSONObject2.get(obj2));
                                    z = false;
                                    break;
                                }
                                Iterator<String> it = hashSet.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        i = 1;
                                        break;
                                    } else if (obj2.equals(it.next().toString())) {
                                        jSONArray.put((JSONObject) jSONObject2.get(obj2));
                                        i = 1;
                                        z = false;
                                        break;
                                    }
                                }
                            }
                            if (z) {
                                jSONArray.put(jSONObject2);
                            }
                            i = 1;
                        } else {
                            if (obj.indexOf(str) >= 0 && !TextUtils.isEmpty(replace) && TextUtils.isDigitsOnly(replace) && Integer.parseInt(replace) > 0) {
                                jSONArray.put((JSONObject) jSONObject.remove(obj));
                            }
                            i = 1;
                        }
                    }
                    jSONObject.put(str, jSONArray);
                    i2++;
                    i = 1;
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
