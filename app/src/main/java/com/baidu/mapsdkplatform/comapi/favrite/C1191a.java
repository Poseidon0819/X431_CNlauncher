package com.baidu.mapsdkplatform.comapi.favrite;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.mapapi.UIMsg;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapapi.model.inner.Point;
import com.baidu.mapsdkplatform.comjni.map.favorite.C1309a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Vector;
import org.jivesoftware.smackx.GroupChatInvitation;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.mapsdkplatform.comapi.favrite.a */
/* loaded from: classes.dex */
public class C1191a {

    /* renamed from: b */
    private static C1191a f5896b;

    /* renamed from: a */
    private C1309a f5897a = null;

    /* renamed from: c */
    private boolean f5898c = false;

    /* renamed from: d */
    private boolean f5899d = false;

    /* renamed from: e */
    private Vector<String> f5900e = null;

    /* renamed from: f */
    private Vector<String> f5901f = null;

    /* renamed from: g */
    private boolean f5902g = false;

    /* renamed from: h */
    private C1195c f5903h = new C1195c();

    /* renamed from: i */
    private C1194b f5904i = new C1194b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.mapsdkplatform.comapi.favrite.a$a */
    /* loaded from: classes.dex */
    public class C1193a implements Comparator<String> {
        C1193a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(String str, String str2) {
            return str2.compareTo(str);
        }
    }

    /* renamed from: com.baidu.mapsdkplatform.comapi.favrite.a$b */
    /* loaded from: classes.dex */
    class C1194b {

        /* renamed from: b */
        private long f5907b;

        /* renamed from: c */
        private long f5908c;

        private C1194b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m10801a() {
            this.f5907b = System.currentTimeMillis();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public void m10799b() {
            this.f5908c = System.currentTimeMillis();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c */
        public boolean m10797c() {
            return this.f5908c - this.f5907b > 1000;
        }
    }

    /* renamed from: com.baidu.mapsdkplatform.comapi.favrite.a$c */
    /* loaded from: classes.dex */
    class C1195c {

        /* renamed from: b */
        private String f5910b;

        /* renamed from: c */
        private long f5911c;

        /* renamed from: d */
        private long f5912d;

        private C1195c() {
            this.f5911c = 5000L;
            this.f5912d = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public String m10795a() {
            return this.f5910b;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m10792a(String str) {
            this.f5910b = str;
            this.f5912d = System.currentTimeMillis();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public boolean m10791b() {
            return TextUtils.isEmpty(this.f5910b);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c */
        public boolean m10789c() {
            return true;
        }
    }

    private C1191a() {
    }

    /* renamed from: a */
    public static C1191a m10817a() {
        if (f5896b == null) {
            synchronized (C1191a.class) {
                if (f5896b == null) {
                    C1191a c1191a = new C1191a();
                    f5896b = c1191a;
                    c1191a.m10805h();
                }
            }
        }
        return f5896b;
    }

    /* renamed from: g */
    public static boolean m10806g() {
        C1309a c1309a;
        C1191a c1191a = f5896b;
        return (c1191a == null || (c1309a = c1191a.f5897a) == null || !c1309a.m9969d()) ? false : true;
    }

    /* renamed from: h */
    private boolean m10805h() {
        if (this.f5897a == null) {
            this.f5897a = new C1309a();
            if (this.f5897a.m9980a() == 0) {
                this.f5897a = null;
                return false;
            }
            m10803j();
            m10804i();
        }
        return true;
    }

    /* renamed from: i */
    private boolean m10804i() {
        if (this.f5897a == null) {
            return false;
        }
        String str = SysOSUtil.getModuleFileName() + "/";
        this.f5897a.m9979a(1);
        return this.f5897a.m9975a(str, "fav_poi", "fifo", 10, UIMsg.d_ResultType.VERSION_CHECK, -1);
    }

    /* renamed from: j */
    private void m10803j() {
        this.f5898c = false;
        this.f5899d = false;
    }

    /* renamed from: a */
    public synchronized int m10815a(String str, FavSyncPoi favSyncPoi) {
        if (this.f5897a == null) {
            return 0;
        }
        if (str != null && !str.equals("") && favSyncPoi != null) {
            m10803j();
            ArrayList<String> m10808e = m10808e();
            if ((m10808e != null ? m10808e.size() : 0) + 1 > 500) {
                return -2;
            }
            if (m10808e != null && m10808e.size() > 0) {
                Iterator<String> it = m10808e.iterator();
                while (it.hasNext()) {
                    FavSyncPoi m10813b = m10813b(it.next());
                    if (m10813b != null && str.equals(m10813b.f5887b)) {
                        return -1;
                    }
                }
            }
            try {
                JSONObject jSONObject = new JSONObject();
                favSyncPoi.f5887b = str;
                String valueOf = String.valueOf(System.currentTimeMillis());
                String str2 = valueOf + "_" + favSyncPoi.hashCode();
                favSyncPoi.f5893h = valueOf;
                favSyncPoi.f5886a = str2;
                jSONObject.put("bdetail", favSyncPoi.f5894i);
                jSONObject.put("uspoiname", favSyncPoi.f5887b);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(GroupChatInvitation.ELEMENT_NAME, favSyncPoi.f5888c.getmPtx());
                jSONObject2.put("y", favSyncPoi.f5888c.getmPty());
                jSONObject.put("pt", jSONObject2);
                jSONObject.put("ncityid", favSyncPoi.f5890e);
                jSONObject.put("npoitype", favSyncPoi.f5892g);
                jSONObject.put("uspoiuid", favSyncPoi.f5891f);
                jSONObject.put("addr", favSyncPoi.f5889d);
                jSONObject.put("addtimesec", favSyncPoi.f5893h);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("Fav_Sync", jSONObject);
                jSONObject3.put("Fav_Content", favSyncPoi.f5895j);
                if (this.f5897a.m9976a(str2, jSONObject3.toString())) {
                    m10803j();
                    return 1;
                }
                return 0;
            } catch (JSONException unused) {
                return 0;
            } finally {
                m10806g();
            }
        }
        return -1;
    }

    /* renamed from: a */
    public synchronized boolean m10816a(String str) {
        if (this.f5897a == null) {
            return false;
        }
        if (str != null && !str.equals("")) {
            if (m10810c(str)) {
                m10803j();
                return this.f5897a.m9977a(str);
            }
            return false;
        }
        return false;
    }

    /* renamed from: b */
    public FavSyncPoi m10813b(String str) {
        if (this.f5897a != null && str != null && !str.equals("")) {
            try {
                if (m10810c(str)) {
                    FavSyncPoi favSyncPoi = new FavSyncPoi();
                    String m9973b = this.f5897a.m9973b(str);
                    if (m9973b != null && !m9973b.equals("")) {
                        JSONObject jSONObject = new JSONObject(m9973b);
                        JSONObject optJSONObject = jSONObject.optJSONObject("Fav_Sync");
                        String optString = jSONObject.optString("Fav_Content");
                        favSyncPoi.f5887b = optJSONObject.optString("uspoiname");
                        JSONObject optJSONObject2 = optJSONObject.optJSONObject("pt");
                        favSyncPoi.f5888c = new Point(optJSONObject2.optInt(GroupChatInvitation.ELEMENT_NAME), optJSONObject2.optInt("y"));
                        favSyncPoi.f5890e = optJSONObject.optString("ncityid");
                        favSyncPoi.f5891f = optJSONObject.optString("uspoiuid");
                        favSyncPoi.f5892g = optJSONObject.optInt("npoitype");
                        favSyncPoi.f5889d = optJSONObject.optString("addr");
                        favSyncPoi.f5893h = optJSONObject.optString("addtimesec");
                        favSyncPoi.f5894i = optJSONObject.optBoolean("bdetail");
                        favSyncPoi.f5895j = optString;
                        favSyncPoi.f5886a = str;
                        return favSyncPoi;
                    }
                    return null;
                }
                return null;
            } catch (NullPointerException e) {
                e.printStackTrace();
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return null;
    }

    /* renamed from: b */
    public void m10814b() {
        C1191a c1191a = f5896b;
        if (c1191a != null) {
            C1309a c1309a = c1191a.f5897a;
            if (c1309a != null) {
                c1309a.m9974b();
                f5896b.f5897a = null;
            }
            f5896b = null;
        }
    }

    /* renamed from: b */
    public synchronized boolean m10812b(String str, FavSyncPoi favSyncPoi) {
        if (this.f5897a != null && str != null && !str.equals("") && favSyncPoi != null) {
            if (m10810c(str)) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("uspoiname", favSyncPoi.f5887b);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(GroupChatInvitation.ELEMENT_NAME, favSyncPoi.f5888c.getmPtx());
                    jSONObject2.put("y", favSyncPoi.f5888c.getmPty());
                    jSONObject.put("pt", jSONObject2);
                    jSONObject.put("ncityid", favSyncPoi.f5890e);
                    jSONObject.put("npoitype", favSyncPoi.f5892g);
                    jSONObject.put("uspoiuid", favSyncPoi.f5891f);
                    jSONObject.put("addr", favSyncPoi.f5889d);
                    favSyncPoi.f5893h = String.valueOf(System.currentTimeMillis());
                    jSONObject.put("addtimesec", favSyncPoi.f5893h);
                    jSONObject.put("bdetail", false);
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("Fav_Sync", jSONObject);
                    jSONObject3.put("Fav_Content", favSyncPoi.f5895j);
                    m10803j();
                    if (this.f5897a != null) {
                        if (this.f5897a.m9972b(str, jSONObject3.toString())) {
                            return true;
                        }
                    }
                    return false;
                } catch (JSONException unused) {
                    return false;
                }
            }
            return false;
        }
        return false;
    }

    /* renamed from: c */
    public synchronized boolean m10811c() {
        if (this.f5897a == null) {
            return false;
        }
        m10803j();
        boolean m9971c = this.f5897a.m9971c();
        m10806g();
        return m9971c;
    }

    /* renamed from: c */
    public boolean m10810c(String str) {
        return (this.f5897a == null || str == null || str.equals("") || !this.f5897a.m9970c(str)) ? false : true;
    }

    /* renamed from: d */
    public ArrayList<String> m10809d() {
        String m9973b;
        Vector<String> vector;
        if (this.f5897a == null) {
            return null;
        }
        if (!this.f5899d || (vector = this.f5901f) == null) {
            try {
                Bundle bundle = new Bundle();
                this.f5897a.m9978a(bundle);
                String[] stringArray = bundle.getStringArray("rstString");
                if (stringArray != null) {
                    if (this.f5901f == null) {
                        this.f5901f = new Vector<>();
                    } else {
                        this.f5901f.clear();
                    }
                    for (int i = 0; i < stringArray.length; i++) {
                        if (!stringArray[i].equals("data_version") && (m9973b = this.f5897a.m9973b(stringArray[i])) != null && !m9973b.equals("")) {
                            this.f5901f.add(stringArray[i]);
                        }
                    }
                    if (this.f5901f.size() > 0) {
                        try {
                            Collections.sort(this.f5901f, new C1193a());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        this.f5899d = true;
                    }
                } else if (this.f5901f != null) {
                    this.f5901f.clear();
                    this.f5901f = null;
                }
                if (this.f5901f != null && !this.f5901f.isEmpty()) {
                    return new ArrayList<>(this.f5901f);
                }
            } catch (Exception unused) {
            }
            return null;
        }
        return new ArrayList<>(vector);
    }

    /* renamed from: e */
    public ArrayList<String> m10808e() {
        Vector<String> vector;
        if (this.f5897a == null) {
            return null;
        }
        if (!this.f5898c || (vector = this.f5900e) == null) {
            try {
                Bundle bundle = new Bundle();
                this.f5897a.m9978a(bundle);
                String[] stringArray = bundle.getStringArray("rstString");
                if (stringArray != null) {
                    if (this.f5900e == null) {
                        this.f5900e = new Vector<>();
                    } else {
                        this.f5900e.clear();
                    }
                    for (String str : stringArray) {
                        if (!str.equals("data_version")) {
                            this.f5900e.add(str);
                        }
                    }
                    if (this.f5900e.size() > 0) {
                        try {
                            Collections.sort(this.f5900e, new C1193a());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        this.f5898c = true;
                    }
                } else if (this.f5900e != null) {
                    this.f5900e.clear();
                    this.f5900e = null;
                }
                Vector<String> vector2 = this.f5900e;
                if (vector2 != null && vector2.size() != 0) {
                    return new ArrayList<>(this.f5900e);
                }
            } catch (Exception unused) {
            }
            return null;
        }
        return new ArrayList<>(vector);
    }

    /* renamed from: f */
    public String m10807f() {
        String m9973b;
        if (!this.f5904i.m10797c() || this.f5903h.m10789c() || this.f5903h.m10791b()) {
            this.f5904i.m10801a();
            if (this.f5897a == null) {
                return null;
            }
            ArrayList<String> m10809d = m10809d();
            JSONObject jSONObject = new JSONObject();
            if (m10809d != null) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    int i = 0;
                    Iterator<String> it = m10809d.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (next != null && !next.equals("data_version") && (m9973b = this.f5897a.m9973b(next)) != null && !m9973b.equals("")) {
                            JSONObject optJSONObject = new JSONObject(m9973b).optJSONObject("Fav_Sync");
                            optJSONObject.put("key", next);
                            jSONArray.put(i, optJSONObject);
                            i++;
                        }
                    }
                    if (i > 0) {
                        jSONObject.put("favcontents", jSONArray);
                        jSONObject.put("favpoinum", i);
                    }
                } catch (JSONException unused) {
                    return null;
                }
            }
            this.f5904i.m10799b();
            this.f5903h.m10792a(jSONObject.toString());
            return this.f5903h.m10795a();
        }
        return this.f5903h.m10795a();
    }
}
