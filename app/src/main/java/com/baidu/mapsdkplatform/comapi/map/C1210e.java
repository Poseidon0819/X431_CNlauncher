package com.baidu.mapsdkplatform.comapi.map;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import com.baidu.mapapi.UIMsg;
import com.baidu.mapapi.common.EnvironmentUtilities;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapBaseIndoorMapInfo;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapapi.model.ParcelItem;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapsdkplatform.comapi.map.GestureDetector$OnDoubleTapListenerC1216j;
import com.baidu.mapsdkplatform.comjni.map.basemap.BaseMapCallback;
import com.baidu.mapsdkplatform.comjni.map.basemap.C1306a;
import com.baidu.mapsdkplatform.comjni.map.basemap.InterfaceC1307b;
import com.baidu.mapsdkplatform.comjni.map.basemap.JNIBaseMap;
import com.itextpdf.text.html.HtmlTags;
import com.itextpdf.text.pdf.ColumnText;
import com.mopub.mobileads.VastExtensionXmlManager;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.jivesoftware.smackx.GroupChatInvitation;
import org.jivesoftware.smackx.bytestreams.ibb.packet.DataPacketExtension;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint({"NewApi"})
/* renamed from: com.baidu.mapsdkplatform.comapi.map.e */
/* loaded from: classes.dex */
public class C1210e implements InterfaceC1307b {

    /* renamed from: O */
    private static int f5953O;

    /* renamed from: P */
    private static int f5954P;

    /* renamed from: as */
    private static List<JNIBaseMap> f5955as;

    /* renamed from: C */
    private C1203G f5961C;

    /* renamed from: D */
    private InterfaceC1202F f5962D;

    /* renamed from: E */
    private Context f5963E;

    /* renamed from: F */
    private List<AbstractC1209d> f5964F;

    /* renamed from: G */
    private C1232v f5965G;

    /* renamed from: H */
    private C1213g f5966H;

    /* renamed from: I */
    private C1198B f5967I;

    /* renamed from: J */
    private C1201E f5968J;

    /* renamed from: K */
    private C1222m f5969K;

    /* renamed from: L */
    private C1206a f5970L;

    /* renamed from: M */
    private InterfaceC1223n f5971M;

    /* renamed from: N */
    private C1199C f5972N;

    /* renamed from: Q */
    private int f5973Q;

    /* renamed from: R */
    private int f5974R;

    /* renamed from: S */
    private int f5975S;

    /* renamed from: U */
    private VelocityTracker f5977U;

    /* renamed from: V */
    private long f5978V;

    /* renamed from: W */
    private long f5979W;

    /* renamed from: X */
    private long f5980X;

    /* renamed from: Y */
    private long f5981Y;

    /* renamed from: Z */
    private int f5982Z;

    /* renamed from: aa */
    private float f5984aa;

    /* renamed from: ab */
    private float f5985ab;

    /* renamed from: ac */
    private boolean f5986ac;

    /* renamed from: ad */
    private long f5987ad;

    /* renamed from: ae */
    private long f5988ae;

    /* renamed from: ah */
    private float f5991ah;

    /* renamed from: ai */
    private float f5992ai;

    /* renamed from: aj */
    private float f5993aj;

    /* renamed from: ak */
    private float f5994ak;

    /* renamed from: an */
    private C1212f f5997an;

    /* renamed from: ao */
    private String f5998ao;

    /* renamed from: ap */
    private int f5999ap;

    /* renamed from: aq */
    private C1207b f6000aq;

    /* renamed from: ar */
    private C1208c f6001ar;

    /* renamed from: i */
    C1306a f6010i;

    /* renamed from: j */
    long f6011j;

    /* renamed from: k */
    boolean f6012k;

    /* renamed from: l */
    int f6013l;

    /* renamed from: n */
    boolean f6014n;

    /* renamed from: o */
    boolean f6015o;

    /* renamed from: p */
    boolean f6016p;

    /* renamed from: q */
    public LatLngBounds f6017q;

    /* renamed from: r */
    public MapStatus f6018r;

    /* renamed from: t */
    private boolean f6019t;

    /* renamed from: u */
    private boolean f6020u;

    /* renamed from: s */
    private static final String f5958s = GestureDetector$OnDoubleTapListenerC1216j.class.getSimpleName();

    /* renamed from: d */
    public static float f5956d = 1096.0f;

    /* renamed from: m */
    static long f5957m = 0;

    /* renamed from: a */
    public float f5983a = 21.0f;

    /* renamed from: b */
    public float f6004b = 4.0f;

    /* renamed from: c */
    public float f6005c = 21.0f;

    /* renamed from: v */
    private boolean f6021v = true;

    /* renamed from: w */
    private boolean f6022w = false;

    /* renamed from: x */
    private boolean f6023x = false;

    /* renamed from: y */
    private boolean f6024y = false;

    /* renamed from: z */
    private boolean f6025z = true;

    /* renamed from: e */
    boolean f6006e = true;

    /* renamed from: f */
    boolean f6007f = true;

    /* renamed from: g */
    boolean f6008g = false;

    /* renamed from: A */
    private boolean f5959A = true;

    /* renamed from: B */
    private boolean f5960B = false;

    /* renamed from: T */
    private GestureDetector$OnDoubleTapListenerC1216j.C1218a f5976T = new GestureDetector$OnDoubleTapListenerC1216j.C1218a();

    /* renamed from: af */
    private boolean f5989af = false;

    /* renamed from: ag */
    private boolean f5990ag = false;

    /* renamed from: al */
    private long f5995al = 0;

    /* renamed from: am */
    private long f5996am = 0;

    /* renamed from: at */
    private boolean f6002at = false;

    /* renamed from: au */
    private Queue<C1211a> f6003au = new LinkedList();

    /* renamed from: h */
    List<InterfaceC1219k> f6009h = new ArrayList();

    /* renamed from: com.baidu.mapsdkplatform.comapi.map.e$a */
    /* loaded from: classes.dex */
    public static class C1211a {

        /* renamed from: a */
        public long f6026a;

        /* renamed from: b */
        public int f6027b;

        /* renamed from: c */
        public int f6028c;

        /* renamed from: d */
        public int f6029d;

        /* renamed from: e */
        public Bundle f6030e;

        public C1211a(long j, int i, int i2, int i3) {
            this.f6026a = j;
            this.f6027b = i;
            this.f6028c = i2;
            this.f6029d = i3;
        }

        public C1211a(Bundle bundle) {
            this.f6030e = bundle;
        }
    }

    public C1210e(Context context, String str, int i) {
        this.f5963E = context;
        this.f5998ao = str;
        this.f5999ap = i;
    }

    /* renamed from: Q */
    private void m10741Q() {
        if (!this.f6023x && !this.f6020u && !this.f6019t && !this.f6024y) {
            this.f5983a = this.f6005c;
            return;
        }
        if (this.f5983a > 20.0f) {
            this.f5983a = 20.0f;
        }
        if (m10753E().f6114a > 20.0f) {
            C1236z m10753E = m10753E();
            m10753E.f6114a = 20.0f;
            m10717a(m10753E);
        }
    }

    /* renamed from: R */
    private void m10740R() {
        if (this.f6014n) {
            return;
        }
        this.f6014n = true;
        this.f6015o = false;
        List<InterfaceC1219k> list = this.f6009h;
        if (list != null) {
            for (InterfaceC1219k interfaceC1219k : list) {
                if (interfaceC1219k != null) {
                    interfaceC1219k.mo10618a(m10753E());
                }
            }
        }
    }

    /* renamed from: S */
    private boolean m10739S() {
        if (this.f6010i == null || !this.f6012k) {
            return true;
        }
        this.f5990ag = false;
        if (this.f6006e) {
            float f = (float) (this.f5996am - this.f5995al);
            float abs = (Math.abs(this.f5993aj - this.f5991ah) * 1000.0f) / f;
            float abs2 = (Math.abs(this.f5994ak - this.f5992ai) * 1000.0f) / f;
            float sqrt = (float) Math.sqrt((abs * abs) + (abs2 * abs2));
            if (sqrt <= 500.0f) {
                return false;
            }
            m10757A();
            m10733a(34, (int) (sqrt * 0.6f), (((int) this.f5994ak) << 16) | ((int) this.f5993aj));
            m10746L();
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private Activity m10730a(Context context) {
        while (context != null) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            if (!(context instanceof ContextWrapper)) {
                return null;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }

    /* renamed from: a */
    private void m10721a(AbstractC1209d abstractC1209d) {
        C1306a c1306a = this.f6010i;
        if (c1306a == null) {
            return;
        }
        abstractC1209d.f5949a = c1306a.m10045a(abstractC1209d.f5951c, abstractC1209d.f5952d, abstractC1209d.f5950b);
        this.f5964F.add(abstractC1209d);
    }

    /* renamed from: a */
    private void m10713a(String str, String str2, long j) {
        try {
            Class<?> cls = Class.forName(str);
            cls.getMethod(str2, Long.TYPE).invoke(cls.newInstance(), Long.valueOf(j));
        } catch (Exception unused) {
        }
    }

    /* renamed from: b */
    private void m10704b(MotionEvent motionEvent) {
        if (this.f5976T.f6056e) {
            return;
        }
        this.f5988ae = motionEvent.getDownTime();
        long j = this.f5988ae;
        if (j - this.f5987ad < 400) {
            j = (Math.abs(motionEvent.getX() - this.f5984aa) >= 120.0f || Math.abs(motionEvent.getY() - this.f5985ab) >= 120.0f) ? this.f5988ae : 0L;
        }
        this.f5987ad = j;
        this.f5984aa = motionEvent.getX();
        this.f5985ab = motionEvent.getY();
        m10733a(4, 0, (((int) motionEvent.getY()) << 16) | ((int) motionEvent.getX()));
        this.f5986ac = true;
    }

    /* renamed from: b */
    private void m10703b(String str, Bundle bundle) {
        if (this.f6010i == null) {
            return;
        }
        this.f5966H.m10774a(str);
        this.f5966H.m10775a(bundle);
        this.f6010i.m10023b(this.f5966H.f5949a);
    }

    /* renamed from: c */
    private boolean m10697c(MotionEvent motionEvent) {
        double density;
        if (!this.f5976T.f6056e && System.currentTimeMillis() - f5957m >= 300) {
            if (this.f6016p) {
                List<InterfaceC1219k> list = this.f6009h;
                if (list != null) {
                    for (InterfaceC1219k interfaceC1219k : list) {
                        GeoPoint m10707b = m10707b((int) motionEvent.getX(), (int) motionEvent.getY());
                        if (interfaceC1219k != null) {
                            interfaceC1219k.mo10606d(m10707b);
                        }
                    }
                }
                return true;
            }
            float abs = Math.abs(motionEvent.getX() - this.f5984aa);
            float abs2 = Math.abs(motionEvent.getY() - this.f5985ab);
            if (SysOSUtil.getDensity() > 1.5d) {
                double density2 = SysOSUtil.getDensity();
                Double.isNaN(density2);
                density = density2 * 1.5d;
            } else {
                density = SysOSUtil.getDensity();
            }
            float f = (float) density;
            if (!this.f5986ac || abs / f > 3.0f || abs2 / f > 3.0f) {
                this.f5986ac = false;
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (x < 0) {
                    x = 0;
                }
                if (y < 0) {
                    y = 0;
                }
                if (this.f6006e) {
                    BaiduMap.mapStatusReason = 1 | BaiduMap.mapStatusReason;
                    m10740R();
                    m10733a(3, 0, (y << 16) | x);
                }
                return false;
            }
            return true;
        }
        return true;
    }

    /* renamed from: d */
    private boolean m10692d(MotionEvent motionEvent) {
        if (this.f6016p) {
            List<InterfaceC1219k> list = this.f6009h;
            if (list != null) {
                for (InterfaceC1219k interfaceC1219k : list) {
                    GeoPoint m10707b = m10707b((int) motionEvent.getX(), (int) motionEvent.getY());
                    if (interfaceC1219k != null) {
                        interfaceC1219k.mo10604e(m10707b);
                    }
                }
            }
            this.f6016p = false;
            return true;
        }
        boolean z = !this.f5976T.f6056e && motionEvent.getEventTime() - this.f5988ae < 400 && Math.abs(motionEvent.getX() - this.f5984aa) < 10.0f && Math.abs(motionEvent.getY() - this.f5985ab) < 10.0f;
        m10746L();
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (z) {
            return false;
        }
        if (x < 0) {
            x = 0;
        }
        if (y < 0) {
            y = 0;
        }
        m10733a(5, 0, (y << 16) | x);
        return true;
    }

    /* renamed from: e */
    private boolean m10689e(float f, float f2) {
        if (this.f6010i == null || !this.f6012k) {
            return true;
        }
        this.f5989af = false;
        GeoPoint m10707b = m10707b((int) f, (int) f2);
        if (m10707b != null) {
            List<InterfaceC1219k> list = this.f6009h;
            if (list != null) {
                for (InterfaceC1219k interfaceC1219k : list) {
                    if (interfaceC1219k != null) {
                        interfaceC1219k.mo10613b(m10707b);
                    }
                }
            }
            if (this.f6007f) {
                C1236z m10753E = m10753E();
                m10753E.f6114a += 1.0f;
                m10753E.f6117d = m10707b.getLongitudeE6();
                m10753E.f6118e = m10707b.getLatitudeE6();
                m10716a(m10753E, 300);
                f5957m = System.currentTimeMillis();
                return true;
            }
        }
        return false;
    }

    /* renamed from: e */
    private boolean m10688e(Bundle bundle) {
        C1306a c1306a = this.f6010i;
        if (c1306a == null) {
            return false;
        }
        return c1306a.m10006e(bundle);
    }

    /* renamed from: f */
    private boolean m10685f(Bundle bundle) {
        C1306a c1306a;
        if (bundle == null || (c1306a = this.f6010i) == null) {
            return false;
        }
        boolean m10011d = c1306a.m10011d(bundle);
        if (m10011d) {
            m10687e(m10011d);
            this.f6010i.m10023b(this.f5961C.f5949a);
        }
        return m10011d;
    }

    /* renamed from: g */
    private void m10682g(Bundle bundle) {
        int i;
        int i2;
        if (bundle.get("param") == null ? !((i = bundle.getInt(VastExtensionXmlManager.TYPE)) == EnumC1214h.ground.ordinal() || i >= EnumC1214h.arc.ordinal()) : !((i2 = (bundle = (Bundle) bundle.get("param")).getInt(VastExtensionXmlManager.TYPE)) == EnumC1214h.ground.ordinal() || i2 >= EnumC1214h.arc.ordinal())) {
            EnumC1214h.popup.ordinal();
        }
        bundle.putLong("layer_addr", this.f5968J.f5949a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: l */
    public static void m10671l(boolean z) {
        List<JNIBaseMap> m10028b = C1306a.m10028b();
        f5955as = m10028b;
        if (m10028b == null || f5955as.size() == 0) {
            C1306a.m10022b(0L, z);
            return;
        }
        C1306a.m10022b(f5955as.get(0).f6434a, z);
        for (JNIBaseMap jNIBaseMap : f5955as) {
            if (jNIBaseMap != null) {
                jNIBaseMap.ClearLayer(jNIBaseMap.f6434a, -1L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: A */
    public void m10757A() {
        if (this.f6014n || this.f6015o) {
            return;
        }
        this.f6015o = true;
        List<InterfaceC1219k> list = this.f6009h;
        if (list == null) {
            return;
        }
        for (InterfaceC1219k interfaceC1219k : list) {
            if (interfaceC1219k != null) {
                interfaceC1219k.mo10618a(m10753E());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: B */
    public void m10756B() {
        this.f6015o = false;
        this.f6014n = false;
        List<InterfaceC1219k> list = this.f6009h;
        if (list == null) {
            return;
        }
        for (InterfaceC1219k interfaceC1219k : list) {
            if (interfaceC1219k != null) {
                interfaceC1219k.mo10608c(m10753E());
            }
        }
    }

    /* renamed from: C */
    public boolean m10755C() {
        C1306a c1306a = this.f6010i;
        if (c1306a != null) {
            return c1306a.m10042a(this.f5967I.f5949a);
        }
        return false;
    }

    /* renamed from: D */
    public boolean m10754D() {
        C1306a c1306a = this.f6010i;
        if (c1306a != null) {
            return c1306a.m10042a(this.f6001ar.f5949a);
        }
        return false;
    }

    /* renamed from: E */
    public C1236z m10753E() {
        C1306a c1306a = this.f6010i;
        if (c1306a == null) {
            return null;
        }
        Bundle m10000h = c1306a.m10000h();
        C1236z c1236z = new C1236z();
        c1236z.m10558a(m10000h);
        return c1236z;
    }

    /* renamed from: F */
    public LatLngBounds m10752F() {
        C1306a c1306a = this.f6010i;
        if (c1306a == null) {
            return null;
        }
        Bundle m9998i = c1306a.m9998i();
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        int i = m9998i.getInt("maxCoorx");
        int i2 = m9998i.getInt("minCoorx");
        builder.include(CoordUtil.mc2ll(new GeoPoint(m9998i.getInt("minCoory"), i))).include(CoordUtil.mc2ll(new GeoPoint(m9998i.getInt("maxCoory"), i2)));
        return builder.build();
    }

    /* renamed from: G */
    public int m10751G() {
        return this.f5973Q;
    }

    /* renamed from: H */
    public int m10750H() {
        return this.f5974R;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: I */
    public C1236z m10749I() {
        C1306a c1306a = this.f6010i;
        if (c1306a == null) {
            return null;
        }
        Bundle m9997j = c1306a.m9997j();
        C1236z c1236z = new C1236z();
        c1236z.m10558a(m9997j);
        return c1236z;
    }

    /* renamed from: J */
    public double m10748J() {
        return m10753E().f6126m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: K */
    public void m10747K() {
        List<InterfaceC1219k> list;
        this.f6014n = false;
        if (this.f6015o || (list = this.f6009h) == null) {
            return;
        }
        for (InterfaceC1219k interfaceC1219k : list) {
            if (interfaceC1219k != null) {
                interfaceC1219k.mo10608c(m10753E());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: L */
    public void m10746L() {
        this.f5975S = 0;
        GestureDetector$OnDoubleTapListenerC1216j.C1218a c1218a = this.f5976T;
        c1218a.f6056e = false;
        c1218a.f6059h = 0.0d;
    }

    /* renamed from: M */
    public float[] m10745M() {
        C1306a c1306a = this.f6010i;
        if (c1306a == null) {
            return null;
        }
        return c1306a.m9986u();
    }

    /* renamed from: N */
    public float[] m10744N() {
        C1306a c1306a = this.f6010i;
        if (c1306a == null) {
            return null;
        }
        return c1306a.m9985v();
    }

    /* renamed from: O */
    public Queue<C1211a> m10743O() {
        return this.f6003au;
    }

    /* renamed from: P */
    public void m10742P() {
        if (this.f6003au.isEmpty()) {
            return;
        }
        C1211a poll = this.f6003au.poll();
        if (poll.f6030e == null) {
            C1306a.m10041a(poll.f6026a, poll.f6027b, poll.f6028c, poll.f6029d);
        } else if (this.f6010i != null) {
            m10757A();
            this.f6010i.m10037a(poll.f6030e);
        }
    }

    /* renamed from: a */
    public float m10732a(int i, int i2, int i3, int i4, int i5, int i6) {
        if (this.f6012k) {
            if (this.f6010i == null) {
                return ColumnText.GLOBAL_SPACE_CHAR_RATIO;
            }
            Bundle bundle = new Bundle();
            bundle.putInt(HtmlTags.ALIGN_LEFT, i);
            bundle.putInt(HtmlTags.ALIGN_RIGHT, i3);
            bundle.putInt(HtmlTags.ALIGN_BOTTOM, i4);
            bundle.putInt(HtmlTags.ALIGN_TOP, i2);
            bundle.putInt("hasHW", 1);
            bundle.putInt("width", i5);
            bundle.putInt("height", i6);
            return this.f6010i.m10016c(bundle);
        }
        return 12.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public int m10733a(int i, int i2, int i3) {
        if (this.f6002at) {
            this.f6003au.add(new C1211a(this.f6011j, i, i2, i3));
            return 0;
        }
        return C1306a.m10041a(this.f6011j, i, i2, i3);
    }

    @Override // com.baidu.mapsdkplatform.comjni.map.basemap.InterfaceC1307b
    /* renamed from: a */
    public int mo9983a(Bundle bundle, long j, int i, Bundle bundle2) {
        if (j == this.f5966H.f5949a) {
            bundle.putString("jsondata", this.f5966H.m10776a());
            bundle.putBundle("param", this.f5966H.m10773b());
            return this.f5966H.f5927g;
        } else if (j == this.f5965G.f5949a) {
            bundle.putString("jsondata", this.f5965G.m10776a());
            bundle.putBundle("param", this.f5965G.m10773b());
            return this.f5965G.f5927g;
        } else if (j == this.f5969K.f5949a) {
            bundle.putBundle("param", this.f5971M.mo10594a(bundle2.getInt(GroupChatInvitation.ELEMENT_NAME), bundle2.getInt("y"), bundle2.getInt("zoom")));
            return this.f5969K.f5927g;
        } else if (j == this.f5961C.f5949a) {
            bundle.putBundle("param", this.f5962D.mo10772a(bundle2.getInt(GroupChatInvitation.ELEMENT_NAME), bundle2.getInt("y"), bundle2.getInt("zoom"), this.f5963E));
            return this.f5961C.f5927g;
        } else {
            return 0;
        }
    }

    /* renamed from: a */
    public Point m10723a(GeoPoint geoPoint) {
        return this.f5972N.m10777a(geoPoint);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m10738a() {
        this.f5964F = new ArrayList();
        this.f5997an = new C1212f();
        m10721a(this.f5997an);
        this.f6000aq = new C1207b();
        m10721a(this.f6000aq);
        this.f5969K = new C1222m();
        m10721a(this.f5969K);
        this.f5970L = new C1206a();
        m10721a(this.f5970L);
        m10721a(new C1224o());
        this.f5967I = new C1198B();
        m10721a(this.f5967I);
        this.f6001ar = new C1208c();
        m10721a(this.f6001ar);
        C1306a c1306a = this.f6010i;
        if (c1306a != null) {
            c1306a.m10005e(false);
        }
        this.f5968J = new C1201E();
        m10721a(this.f5968J);
        this.f5966H = new C1213g();
        m10721a(this.f5966H);
        this.f5965G = new C1232v();
        m10721a(this.f5965G);
    }

    /* renamed from: a */
    public void m10737a(float f, float f2) {
        this.f5983a = f;
        this.f6005c = f;
        this.f6004b = f2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m10735a(int i) {
        this.f6010i = new C1306a();
        this.f6010i.m10048a(i);
        this.f6011j = this.f6010i.m10049a();
        m10713a("com.baidu.platform.comapi.wnplatform.walkmap.WNaviBaiduMap", "setId", this.f6011j);
        this.f6013l = SysOSUtil.getDensityDpi() < 180 ? 18 : SysOSUtil.getDensityDpi() < 240 ? 25 : SysOSUtil.getDensityDpi() < 320 ? 37 : 50;
        String moduleFileName = SysOSUtil.getModuleFileName();
        String appSDCardPath = EnvironmentUtilities.getAppSDCardPath();
        String appCachePath = EnvironmentUtilities.getAppCachePath();
        String appSecondCachePath = EnvironmentUtilities.getAppSecondCachePath();
        int mapTmpStgMax = EnvironmentUtilities.getMapTmpStgMax();
        int domTmpStgMax = EnvironmentUtilities.getDomTmpStgMax();
        int itsTmpStgMax = EnvironmentUtilities.getItsTmpStgMax();
        String str = SysOSUtil.getDensityDpi() >= 180 ? "/h/" : "/l/";
        String str2 = moduleFileName + "/cfg";
        String str3 = appSDCardPath + "/vmp";
        String str4 = str2 + "/a/";
        String str5 = str2 + "/a/";
        String str6 = str2 + "/idrres/";
        String str7 = str3 + str;
        String str8 = str3 + str;
        String str9 = appCachePath + "/tmp/";
        String str10 = appSecondCachePath + "/tmp/";
        Activity m10730a = m10730a(this.f5963E);
        if (m10730a == null) {
            throw new RuntimeException("Please give the right context.");
        }
        Display defaultDisplay = m10730a.getWindowManager().getDefaultDisplay();
        this.f6010i.m10033a(str4, str7, str9, str10, str8, str5, this.f5998ao, this.f5999ap, str6, defaultDisplay.getWidth(), defaultDisplay.getHeight(), SysOSUtil.getDensityDpi(), mapTmpStgMax, domTmpStgMax, itsTmpStgMax, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m10734a(int i, int i2) {
        this.f5973Q = i;
        this.f5974R = i2;
    }

    /* renamed from: a */
    public void m10731a(long j, long j2, long j3, long j4, boolean z) {
        this.f6010i.m10039a(j, j2, j3, j4, z);
    }

    /* renamed from: a */
    public void m10729a(Bitmap bitmap) {
        Bundle bundle;
        if (this.f6010i == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put(VastExtensionXmlManager.TYPE, 0);
            jSONObject2.put(GroupChatInvitation.ELEMENT_NAME, f5953O);
            jSONObject2.put("y", f5954P);
            jSONObject2.put("hidetime", 1000);
            jSONArray.put(jSONObject2);
            jSONObject.put(DataPacketExtension.ELEMENT_NAME, jSONArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (bitmap == null) {
            bundle = null;
        } else {
            Bundle bundle2 = new Bundle();
            ArrayList arrayList = new ArrayList();
            ParcelItem parcelItem = new ParcelItem();
            Bundle bundle3 = new Bundle();
            ByteBuffer allocate = ByteBuffer.allocate(bitmap.getWidth() * bitmap.getHeight() * 4);
            bitmap.copyPixelsToBuffer(allocate);
            bundle3.putByteArray("imgdata", allocate.array());
            bundle3.putInt("imgindex", bitmap.hashCode());
            bundle3.putInt("imgH", bitmap.getHeight());
            bundle3.putInt("imgW", bitmap.getWidth());
            bundle3.putInt("hasIcon", 1);
            parcelItem.setBundle(bundle3);
            arrayList.add(parcelItem);
            if (arrayList.size() > 0) {
                ParcelItem[] parcelItemArr = new ParcelItem[arrayList.size()];
                for (int i = 0; i < arrayList.size(); i++) {
                    parcelItemArr[i] = (ParcelItem) arrayList.get(i);
                }
                bundle2.putParcelableArray("icondata", parcelItemArr);
            }
            bundle = bundle2;
        }
        m10703b(jSONObject.toString(), bundle);
        this.f6010i.m10023b(this.f5966H.f5949a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m10726a(Handler handler) {
        MessageCenter.registMessage(UIMsg.m_AppUI.MSG_APP_SAVESCREEN, handler);
        MessageCenter.registMessage(39, handler);
        MessageCenter.registMessage(41, handler);
        MessageCenter.registMessage(49, handler);
        MessageCenter.registMessage(UIMsg.m_AppUI.V_WM_VDATAENGINE, handler);
        MessageCenter.registMessage(50, handler);
        MessageCenter.registMessage(999, handler);
        BaseMapCallback.addLayerDataInterface(this.f6011j, this);
    }

    /* renamed from: a */
    public void m10724a(LatLngBounds latLngBounds) {
        if (latLngBounds == null || this.f6010i == null) {
            return;
        }
        LatLng latLng = latLngBounds.northeast;
        LatLng latLng2 = latLngBounds.southwest;
        GeoPoint ll2mc = CoordUtil.ll2mc(latLng);
        GeoPoint ll2mc2 = CoordUtil.ll2mc(latLng2);
        int longitudeE6 = (int) ll2mc2.getLongitudeE6();
        int latitudeE6 = (int) ll2mc.getLatitudeE6();
        Bundle bundle = new Bundle();
        bundle.putInt("maxCoorx", (int) ll2mc.getLongitudeE6());
        bundle.putInt("minCoory", (int) ll2mc2.getLatitudeE6());
        bundle.putInt("minCoorx", longitudeE6);
        bundle.putInt("maxCoory", latitudeE6);
        this.f6010i.m10021b(bundle);
    }

    /* renamed from: a */
    public void m10722a(InterfaceC1202F interfaceC1202F) {
        this.f5962D = interfaceC1202F;
    }

    /* renamed from: a */
    public void m10720a(InterfaceC1219k interfaceC1219k) {
        if (interfaceC1219k == null) {
            return;
        }
        this.f6009h.add(interfaceC1219k);
    }

    /* renamed from: a */
    public void m10719a(InterfaceC1223n interfaceC1223n) {
        this.f5971M = interfaceC1223n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m10718a(C1234x c1234x) {
        new C1236z();
        if (c1234x == null) {
            c1234x = new C1234x();
        }
        C1236z c1236z = c1234x.f6102a;
        this.f6025z = c1234x.f6107f;
        this.f5959A = c1234x.f6105d;
        this.f6006e = c1234x.f6106e;
        this.f6007f = c1234x.f6108g;
        this.f6010i.m10037a(c1236z.m10557a(this));
        this.f6010i.m10018c(EnumC1233w.DEFAULT.ordinal());
        this.f6021v = c1234x.f6103b;
        if (c1234x.f6103b) {
            f5953O = (int) (SysOSUtil.getDensity() * 40.0f);
            f5954P = (int) (SysOSUtil.getDensity() * 40.0f);
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(GroupChatInvitation.ELEMENT_NAME, f5953O);
                jSONObject2.put("y", f5954P);
                jSONObject2.put("hidetime", 1000);
                jSONArray.put(jSONObject2);
                jSONObject.put(DataPacketExtension.ELEMENT_NAME, jSONArray);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.f5966H.m10774a(jSONObject.toString());
            this.f6010i.m10038a(this.f5966H.f5949a, true);
        } else {
            this.f6010i.m10038a(this.f5966H.f5949a, false);
        }
        int i = c1234x.f6104c;
        if (i == 2) {
            m10711a(true);
        }
        if (i == 3) {
            this.f6010i.m10038a(this.f5997an.f5949a, false);
            this.f6010i.m10038a(this.f6001ar.f5949a, false);
            this.f6010i.m10038a(this.f5967I.f5949a, false);
            this.f6010i.m10005e(false);
        }
    }

    /* renamed from: a */
    public void m10717a(C1236z c1236z) {
        if (this.f6010i == null || c1236z == null) {
            return;
        }
        Bundle m10557a = c1236z.m10557a(this);
        m10557a.putInt("animation", 0);
        m10557a.putInt("animatime", 0);
        this.f6010i.m10037a(m10557a);
    }

    /* renamed from: a */
    public void m10716a(C1236z c1236z, int i) {
        if (this.f6010i == null) {
            return;
        }
        Bundle m10557a = c1236z.m10557a(this);
        m10557a.putInt("animation", 1);
        m10557a.putInt("animatime", i);
        if (this.f6002at) {
            this.f6003au.add(new C1211a(m10557a));
            return;
        }
        m10757A();
        this.f6010i.m10037a(m10557a);
    }

    /* renamed from: a */
    public void m10715a(String str, Bundle bundle) {
        if (this.f6010i == null) {
            return;
        }
        this.f5965G.m10774a(str);
        this.f5965G.m10775a(bundle);
        this.f6010i.m10023b(this.f5965G.f5949a);
    }

    /* renamed from: a */
    public void m10712a(List<Bundle> list) {
        if (this.f6010i == null || list == null) {
            return;
        }
        int size = list.size();
        Bundle[] bundleArr = new Bundle[list.size()];
        for (int i = 0; i < size; i++) {
            m10682g(list.get(i));
            bundleArr[i] = list.get(i);
        }
        this.f6010i.m10029a(bundleArr);
    }

    /* renamed from: a */
    public void m10711a(boolean z) {
        C1306a c1306a = this.f6010i;
        if (c1306a == null) {
            return;
        }
        if (!c1306a.m10042a(this.f5997an.f5949a)) {
            this.f6010i.m10038a(this.f5997an.f5949a, true);
        }
        this.f6020u = z;
        m10741Q();
        this.f6010i.m10032a(this.f6020u);
    }

    /* JADX WARN: Removed duplicated region for block: B:84:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:92:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m10736a(float r23, float r24, float r25, float r26) {
        /*
            Method dump skipped, instructions count: 662
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapsdkplatform.comapi.map.C1210e.m10736a(float, float, float, float):boolean");
    }

    @Override // com.baidu.mapsdkplatform.comjni.map.basemap.InterfaceC1307b
    /* renamed from: a */
    public boolean mo9984a(long j) {
        Iterator<AbstractC1209d> it = this.f5964F.iterator();
        while (it.hasNext()) {
            if (it.next().f5949a == j) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public boolean m10728a(Point point) {
        if (point != null && this.f6010i != null && point.x >= 0 && point.y >= 0) {
            f5953O = point.x;
            f5954P = point.y;
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(GroupChatInvitation.ELEMENT_NAME, f5953O);
                jSONObject2.put("y", f5954P);
                jSONObject2.put("hidetime", 1000);
                jSONArray.put(jSONObject2);
                jSONObject.put(DataPacketExtension.ELEMENT_NAME, jSONArray);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.f5966H.m10774a(jSONObject.toString());
            this.f6010i.m10023b(this.f5966H.f5949a);
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public boolean m10727a(Bundle bundle) {
        if (this.f6010i == null) {
            return false;
        }
        this.f5961C = new C1203G();
        long m10045a = this.f6010i.m10045a(this.f5961C.f5951c, this.f5961C.f5952d, this.f5961C.f5950b);
        if (m10045a != 0) {
            C1203G c1203g = this.f5961C;
            c1203g.f5949a = m10045a;
            this.f5964F.add(c1203g);
            bundle.putLong("sdktileaddr", m10045a);
            if (m10688e(bundle) && m10685f(bundle)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:135:0x035a  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x036c  */
    /* JADX WARN: Removed duplicated region for block: B:152:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0119  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m10725a(android.view.MotionEvent r23) {
        /*
            Method dump skipped, instructions count: 1006
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapsdkplatform.comapi.map.C1210e.m10725a(android.view.MotionEvent):boolean");
    }

    /* renamed from: a */
    public boolean m10714a(String str, String str2) {
        return this.f6010i.m10034a(str, str2);
    }

    /* renamed from: b */
    public GeoPoint m10707b(int i, int i2) {
        return this.f5972N.m10778a(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m10709b(float f, float f2) {
        if (this.f5976T.f6056e) {
            return;
        }
        this.f5988ae = System.currentTimeMillis();
        long j = this.f5988ae;
        if (j - this.f5987ad < 400) {
            if (Math.abs(f - this.f5984aa) < 120.0f && Math.abs(f2 - this.f5985ab) < 120.0f) {
                this.f5987ad = 0L;
                this.f5989af = true;
                this.f5984aa = f;
                this.f5985ab = f2;
                m10733a(4, 0, ((int) f) | (((int) f2) << 16));
                this.f5986ac = true;
            }
            j = this.f5988ae;
        }
        this.f5987ad = j;
        this.f5984aa = f;
        this.f5985ab = f2;
        m10733a(4, 0, ((int) f) | (((int) f2) << 16));
        this.f5986ac = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m10708b(int i) {
        C1306a c1306a = this.f6010i;
        if (c1306a != null) {
            c1306a.m10027b(i);
            this.f6010i = null;
        }
    }

    /* renamed from: b */
    public void m10706b(Bundle bundle) {
        if (this.f6010i == null) {
            return;
        }
        m10682g(bundle);
        this.f6010i.m10003f(bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m10705b(Handler handler) {
        MessageCenter.unregistMessage(UIMsg.m_AppUI.MSG_APP_SAVESCREEN, handler);
        MessageCenter.unregistMessage(41, handler);
        MessageCenter.unregistMessage(49, handler);
        MessageCenter.unregistMessage(39, handler);
        MessageCenter.unregistMessage(UIMsg.m_AppUI.V_WM_VDATAENGINE, handler);
        MessageCenter.unregistMessage(50, handler);
        MessageCenter.unregistMessage(999, handler);
        BaseMapCallback.removeLayerDataInterface(this.f6011j);
    }

    /* renamed from: b */
    public void m10702b(boolean z) {
        this.f5960B = z;
    }

    /* renamed from: b */
    public boolean m10710b() {
        return this.f5960B;
    }

    /* renamed from: c */
    public void m10701c() {
        if (this.f6010i == null) {
            return;
        }
        for (AbstractC1209d abstractC1209d : this.f5964F) {
            this.f6010i.m10038a(abstractC1209d.f5949a, false);
        }
    }

    /* renamed from: c */
    public void m10698c(Bundle bundle) {
        if (this.f6010i == null) {
            return;
        }
        m10682g(bundle);
        this.f6010i.m10001g(bundle);
    }

    /* renamed from: c */
    public void m10696c(boolean z) {
        C1306a c1306a;
        long j;
        long j2;
        if (z) {
            c1306a = this.f6010i;
            j = this.f5968J.f5949a;
            j2 = this.f5965G.f5949a;
        } else {
            c1306a = this.f6010i;
            j = this.f5965G.f5949a;
            j2 = this.f5968J.f5949a;
        }
        c1306a.m10040a(j, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean m10700c(float f, float f2) {
        double density;
        if (!this.f5976T.f6056e && System.currentTimeMillis() - f5957m >= 300) {
            if (this.f6016p) {
                List<InterfaceC1219k> list = this.f6009h;
                if (list != null) {
                    for (InterfaceC1219k interfaceC1219k : list) {
                        GeoPoint m10707b = m10707b((int) f, (int) f2);
                        if (interfaceC1219k != null) {
                            interfaceC1219k.mo10606d(m10707b);
                        }
                    }
                }
                return true;
            }
            float abs = Math.abs(f - this.f5984aa);
            float abs2 = Math.abs(f2 - this.f5985ab);
            if (SysOSUtil.getDensity() > 1.5d) {
                double density2 = SysOSUtil.getDensity();
                Double.isNaN(density2);
                density = density2 * 1.5d;
            } else {
                density = SysOSUtil.getDensity();
            }
            float f3 = (float) density;
            if (!this.f5986ac || abs / f3 > 3.0f || abs2 / f3 > 3.0f) {
                this.f5986ac = false;
                int i = (int) f;
                int i2 = (int) f2;
                if (i < 0) {
                    i = 0;
                }
                if (i2 < 0) {
                    i2 = 0;
                }
                if (this.f6006e) {
                    this.f5991ah = this.f5993aj;
                    this.f5992ai = this.f5994ak;
                    this.f5993aj = f;
                    this.f5994ak = f2;
                    this.f5995al = this.f5996am;
                    this.f5996am = System.currentTimeMillis();
                    this.f5990ag = true;
                    m10740R();
                    m10733a(3, 0, (i2 << 16) | i);
                }
                return false;
            }
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean m10699c(int i, int i2) {
        return i >= 0 && i <= this.f5973Q + 0 && i2 >= 0 && i2 <= this.f5974R + 0;
    }

    /* renamed from: d */
    public void m10695d() {
        if (this.f6010i == null) {
            return;
        }
        for (AbstractC1209d abstractC1209d : this.f5964F) {
            if ((abstractC1209d instanceof C1232v) || (abstractC1209d instanceof C1206a) || (abstractC1209d instanceof C1222m)) {
                this.f6010i.m10038a(abstractC1209d.f5949a, false);
            } else {
                this.f6010i.m10038a(abstractC1209d.f5949a, true);
            }
        }
        this.f6010i.m10015c(false);
    }

    /* renamed from: d */
    public void m10693d(Bundle bundle) {
        if (this.f6010i == null) {
            return;
        }
        m10682g(bundle);
        this.f6010i.m9999h(bundle);
    }

    /* renamed from: d */
    public void m10691d(boolean z) {
        C1306a c1306a = this.f6010i;
        if (c1306a == null) {
            return;
        }
        c1306a.m10038a(this.f5966H.f5949a, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public boolean m10694d(float f, float f2) {
        if (this.f6016p) {
            List<InterfaceC1219k> list = this.f6009h;
            if (list != null) {
                for (InterfaceC1219k interfaceC1219k : list) {
                    GeoPoint m10707b = m10707b((int) f, (int) f2);
                    if (interfaceC1219k != null) {
                        interfaceC1219k.mo10604e(m10707b);
                    }
                }
            }
            this.f6016p = false;
            return true;
        }
        if (!this.f5976T.f6056e) {
            if (this.f5989af) {
                return m10689e(f, f2);
            }
            if (this.f5990ag) {
                return m10739S();
            }
            if (System.currentTimeMillis() - this.f5988ae < 400 && Math.abs(f - this.f5984aa) < 10.0f && Math.abs(f2 - this.f5985ab) < 10.0f) {
                m10746L();
                return true;
            }
        }
        m10746L();
        int i = (int) f;
        int i2 = (int) f2;
        if (i < 0) {
            i = 0;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        m10733a(5, 0, i | (i2 << 16));
        return true;
    }

    /* renamed from: e */
    public void m10687e(boolean z) {
        C1306a c1306a = this.f6010i;
        if (c1306a == null) {
            return;
        }
        c1306a.m10038a(this.f5961C.f5949a, z);
    }

    /* renamed from: e */
    public boolean m10690e() {
        C1306a c1306a;
        C1203G c1203g = this.f5961C;
        if (c1203g == null || (c1306a = this.f6010i) == null) {
            return false;
        }
        return c1306a.m10017c(c1203g.f5949a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public void m10686f() {
        C1306a c1306a = this.f6010i;
        if (c1306a == null) {
            return;
        }
        this.f5972N = new C1199C(c1306a);
    }

    /* renamed from: f */
    public void m10684f(boolean z) {
        C1306a c1306a = this.f6010i;
        if (c1306a == null) {
            return;
        }
        c1306a.m10038a(this.f5997an.f5949a, z);
    }

    /* renamed from: g */
    public void m10681g(boolean z) {
        C1306a c1306a = this.f6010i;
        if (c1306a == null) {
            return;
        }
        this.f6024y = z;
        c1306a.m10020b(this.f6024y);
    }

    /* renamed from: g */
    public boolean m10683g() {
        return this.f6019t;
    }

    /* renamed from: h */
    public String m10680h() {
        C1306a c1306a = this.f6010i;
        if (c1306a == null) {
            return null;
        }
        return c1306a.m10007e(this.f5966H.f5949a);
    }

    /* renamed from: h */
    public void m10679h(boolean z) {
        C1306a c1306a = this.f6010i;
        if (c1306a == null) {
            return;
        }
        this.f6019t = z;
        c1306a.m10015c(this.f6019t);
    }

    /* renamed from: i */
    public void m10677i(boolean z) {
        C1306a c1306a = this.f6010i;
        if (c1306a == null) {
            return;
        }
        c1306a.m10010d(z);
    }

    /* renamed from: i */
    public boolean m10678i() {
        return this.f6024y;
    }

    /* renamed from: j */
    public void m10675j(boolean z) {
        C1306a c1306a = this.f6010i;
        if (c1306a == null) {
            return;
        }
        this.f6021v = z;
        c1306a.m10038a(this.f5966H.f5949a, z);
    }

    /* renamed from: j */
    public boolean m10676j() {
        C1306a c1306a = this.f6010i;
        if (c1306a == null) {
            return false;
        }
        return c1306a.m9996k();
    }

    /* renamed from: k */
    public void m10673k(boolean z) {
        float f = z ? 22.0f : 21.0f;
        this.f5983a = f;
        this.f6005c = f;
        this.f6010i.m10005e(z);
        this.f6010i.m10012d(this.f6000aq.f5949a);
        this.f6010i.m10012d(this.f6001ar.f5949a);
    }

    /* renamed from: k */
    public boolean m10674k() {
        return this.f6020u;
    }

    /* renamed from: l */
    public boolean m10672l() {
        return this.f6010i.m10042a(this.f5997an.f5949a);
    }

    /* renamed from: m */
    public void m10669m(boolean z) {
        C1306a c1306a = this.f6010i;
        if (c1306a == null) {
            return;
        }
        this.f6022w = z;
        c1306a.m10038a(this.f5965G.f5949a, z);
    }

    /* renamed from: m */
    public boolean m10670m() {
        C1306a c1306a = this.f6010i;
        if (c1306a == null) {
            return false;
        }
        return c1306a.m9992o();
    }

    /* renamed from: n */
    public void m10668n() {
        C1306a c1306a = this.f6010i;
        if (c1306a == null) {
            return;
        }
        c1306a.m10012d(this.f5968J.f5949a);
    }

    /* renamed from: n */
    public void m10667n(boolean z) {
        C1306a c1306a = this.f6010i;
        if (c1306a == null) {
            return;
        }
        this.f6023x = z;
        c1306a.m10038a(this.f5969K.f5949a, z);
    }

    /* renamed from: o */
    public void m10666o() {
        C1306a c1306a = this.f6010i;
        if (c1306a == null) {
            return;
        }
        c1306a.m9991p();
        this.f6010i.m10023b(this.f5969K.f5949a);
    }

    /* renamed from: o */
    public void m10665o(boolean z) {
        this.f6006e = z;
    }

    /* renamed from: p */
    public MapBaseIndoorMapInfo m10664p() {
        return this.f6010i.m9990q();
    }

    /* renamed from: p */
    public void m10663p(boolean z) {
        this.f6007f = z;
    }

    /* renamed from: q */
    public void m10661q(boolean z) {
        this.f6008g = z;
    }

    /* renamed from: q */
    public boolean m10662q() {
        return this.f6010i.m9989r();
    }

    /* renamed from: r */
    public void m10659r(boolean z) {
        this.f5959A = z;
    }

    /* renamed from: r */
    public boolean m10660r() {
        return this.f6021v;
    }

    /* renamed from: s */
    public void m10657s(boolean z) {
        this.f6025z = z;
    }

    /* renamed from: s */
    public boolean m10658s() {
        return this.f6022w;
    }

    /* renamed from: t */
    public void m10656t() {
        C1306a c1306a = this.f6010i;
        if (c1306a == null) {
            return;
        }
        c1306a.m10023b(this.f5969K.f5949a);
    }

    /* renamed from: t */
    public void m10655t(boolean z) {
        C1306a c1306a = this.f6010i;
        if (c1306a != null) {
            c1306a.m10038a(this.f5967I.f5949a, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: u */
    public void m10654u() {
        C1306a c1306a = this.f6010i;
        if (c1306a == null) {
            return;
        }
        c1306a.m10009e();
    }

    /* renamed from: u */
    public void m10653u(boolean z) {
        C1306a c1306a = this.f6010i;
        if (c1306a != null) {
            c1306a.m10038a(this.f6001ar.f5949a, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: v */
    public void m10652v() {
        C1306a c1306a = this.f6010i;
        if (c1306a == null) {
            return;
        }
        c1306a.m10004f();
    }

    /* renamed from: v */
    public void m10651v(boolean z) {
        this.f6002at = z;
    }

    /* renamed from: w */
    public boolean m10650w() {
        return this.f6006e;
    }

    /* renamed from: x */
    public boolean m10649x() {
        return this.f6007f;
    }

    /* renamed from: y */
    public boolean m10648y() {
        return this.f5959A;
    }

    /* renamed from: z */
    public boolean m10647z() {
        return this.f6025z;
    }
}
