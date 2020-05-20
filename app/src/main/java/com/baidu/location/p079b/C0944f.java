package com.baidu.location.p079b;

import android.net.wifi.WifiConfiguration;
import android.os.Handler;
import android.os.Message;
import com.baidu.android.bbalbs.common.p077a.C0859b;
import com.baidu.location.Jni;
import com.baidu.location.p084g.AbstractC1011e;
import com.baidu.location.p084g.C1006b;
import com.baidu.location.p084g.C1016g;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.jivesoftware.smackx.bytestreams.ibb.packet.DataPacketExtension;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.baidu.location.b.f */
/* loaded from: classes.dex */
public class C0944f {

    /* renamed from: a */
    private static Object f4174a = new Object();

    /* renamed from: b */
    private static C0944f f4175b = null;

    /* renamed from: c */
    private Handler f4176c = null;

    /* renamed from: d */
    private String f4177d = null;

    /* renamed from: e */
    private int f4178e = 24;

    /* renamed from: f */
    private C0946a f4179f = null;

    /* renamed from: g */
    private long f4180g = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.location.b.f$a */
    /* loaded from: classes.dex */
    public class C0946a extends AbstractC1011e {

        /* renamed from: b */
        private boolean f4183b = false;

        /* renamed from: c */
        private int f4184c = 0;

        /* renamed from: d */
        private JSONArray f4185d = null;

        /* renamed from: e */
        private JSONArray f4186e = null;

        C0946a() {
            this.f4525k = new HashMap();
        }

        @Override // com.baidu.location.p084g.AbstractC1011e
        /* renamed from: a */
        public void mo11391a() {
            this.f4522h = C1016g.m11553e();
            this.f4525k.clear();
            this.f4525k.put("qt", "cltrw");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(DataPacketExtension.ELEMENT_NAME, this.f4185d);
                jSONObject.put("frt", this.f4184c);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.f4525k.put("cltr[0]", String.valueOf(Jni.encodeOfflineLocationUpdateRequest(jSONObject.toString())));
            this.f4525k.put("cfg", 1);
            this.f4525k.put("info", Jni.encode(C1006b.m11603a().m11597c()));
            this.f4525k.put("trtm", String.format(Locale.CHINA, "%d", Long.valueOf(System.currentTimeMillis())));
        }

        @Override // com.baidu.location.p084g.AbstractC1011e
        /* renamed from: a */
        public void mo11388a(boolean z) {
            JSONObject jSONObject;
            boolean z2;
            if (z && this.f4524j != null) {
                try {
                    jSONObject = new JSONObject(this.f4524j);
                    z2 = true;
                } catch (Exception unused) {
                    jSONObject = null;
                    z2 = false;
                }
                if (z2 && jSONObject != null) {
                    try {
                        jSONObject.put("tt", System.currentTimeMillis());
                        jSONObject.put(DataPacketExtension.ELEMENT_NAME, this.f4186e);
                        try {
                            File file = new File(C0944f.this.f4177d, "wcnf.dat");
                            if (!file.exists()) {
                                file.createNewFile();
                            }
                            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, false));
                            bufferedWriter.write(C0859b.m12430a(jSONObject.toString().getBytes(), "UTF-8"));
                            bufferedWriter.flush();
                            bufferedWriter.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } catch (Exception unused2) {
                    }
                }
            }
            this.f4183b = false;
        }

        /* renamed from: a */
        public void m11962a(boolean z, JSONArray jSONArray, JSONArray jSONArray2) {
            if (this.f4183b) {
                return;
            }
            this.f4183b = true;
            if (z) {
                this.f4184c = 1;
            } else {
                this.f4184c = 0;
            }
            this.f4185d = jSONArray;
            this.f4186e = jSONArray2;
            m11575c(C1016g.m11553e());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.location.b.f$b */
    /* loaded from: classes.dex */
    public class C0947b {

        /* renamed from: a */
        public String f4187a;

        /* renamed from: b */
        public int f4188b;

        C0947b(String str, int i) {
            this.f4187a = null;
            this.f4188b = 0;
            this.f4187a = str;
            this.f4188b = i;
        }
    }

    /* renamed from: a */
    public static C0944f m11971a() {
        C0944f c0944f;
        synchronized (f4174a) {
            if (f4175b == null) {
                f4175b = new C0944f();
            }
            c0944f = f4175b;
        }
        return c0944f;
    }

    /* renamed from: a */
    private Object m11969a(Object obj, String str) throws Exception {
        return obj.getClass().getField(str).get(obj);
    }

    /* renamed from: a */
    private List<C0947b> m11968a(List<WifiConfiguration> list) {
        int i;
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (WifiConfiguration wifiConfiguration : list) {
            String str = wifiConfiguration.SSID;
            try {
                i = ((Integer) m11969a(wifiConfiguration, "numAssociation")).intValue();
            } catch (Exception e) {
                e.printStackTrace();
                i = 0;
            }
            if (i > 0 && str != null) {
                arrayList.add(new C0947b(str, i));
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private void m11967a(boolean z, JSONArray jSONArray, JSONArray jSONArray2) {
        if (this.f4179f == null) {
            this.f4179f = new C0946a();
        }
        this.f4179f.m11962a(z, jSONArray, jSONArray2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(14:71|(2:73|(12:75|76|77|(2:79|(1:81))|82|(1:84)|85|(9:87|89|90|(3:92|(2:96|97)|98)|102|103|(1:11)|12|(3:14|(3:(4:19|(2:22|20)|23|24)|33|34)(3:(3:38|(4:42|(6:45|(3:50|(1:58)(4:52|(1:54)|55|56)|57)|59|(0)(0)|57|43)|60|61)|34)|33|34)|(1:31)(2:27|28))(1:62))|9|(0)|12|(0)(0)))|110|76|77|(0)|82|(0)|85|(0)|9|(0)|12|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00de, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00e2, code lost:
        r7 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01ac A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x016e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:114:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006a A[Catch: Exception -> 0x00de, TryCatch #1 {Exception -> 0x00de, blocks: (B:19:0x0062, B:21:0x006a, B:23:0x0078, B:24:0x0080, B:26:0x0088, B:27:0x008e, B:29:0x0096), top: B:97:0x0062 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0088 A[Catch: Exception -> 0x00de, TryCatch #1 {Exception -> 0x00de, blocks: (B:19:0x0062, B:21:0x006a, B:23:0x0078, B:24:0x0080, B:26:0x0088, B:27:0x008e, B:29:0x0096), top: B:97:0x0062 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0096 A[Catch: Exception -> 0x00de, TRY_LEAVE, TryCatch #1 {Exception -> 0x00de, blocks: (B:19:0x0062, B:21:0x006a, B:23:0x0078, B:24:0x0080, B:26:0x0088, B:27:0x008e, B:29:0x0096), top: B:97:0x0062 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ec A[Catch: Exception -> 0x01db, TryCatch #3 {Exception -> 0x01db, blocks: (B:4:0x0006, B:51:0x00ec, B:52:0x00f2, B:54:0x0104, B:57:0x0116, B:59:0x011c, B:60:0x012a, B:62:0x0130, B:90:0x01d7, B:65:0x0155, B:67:0x015b, B:69:0x0162, B:71:0x0168, B:72:0x016e, B:74:0x0174, B:76:0x0198, B:83:0x01ae, B:84:0x01b3, B:46:0x00e3), top: B:101:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0104 A[Catch: Exception -> 0x01db, TryCatch #3 {Exception -> 0x01db, blocks: (B:4:0x0006, B:51:0x00ec, B:52:0x00f2, B:54:0x0104, B:57:0x0116, B:59:0x011c, B:60:0x012a, B:62:0x0130, B:90:0x01d7, B:65:0x0155, B:67:0x015b, B:69:0x0162, B:71:0x0168, B:72:0x016e, B:74:0x0174, B:76:0x0198, B:83:0x01ae, B:84:0x01b3, B:46:0x00e3), top: B:101:0x0006 }] */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m11963d() {
        /*
            Method dump skipped, instructions count: 480
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p079b.C0944f.m11963d():void");
    }

    /* renamed from: b */
    public void m11966b() {
        if (this.f4176c == null) {
            this.f4176c = new Handler() { // from class: com.baidu.location.b.f.1
                @Override // android.os.Handler
                public void handleMessage(Message message2) {
                    if (message2.what != 1) {
                        return;
                    }
                    C0944f.this.m11963d();
                }
            };
        }
        this.f4177d = C1016g.m11550g();
    }

    /* renamed from: c */
    public void m11964c() {
        Handler handler;
        if (System.currentTimeMillis() - this.f4180g <= 3600000 || (handler = this.f4176c) == null) {
            return;
        }
        handler.sendEmptyMessage(1);
        this.f4180g = System.currentTimeMillis();
    }
}
