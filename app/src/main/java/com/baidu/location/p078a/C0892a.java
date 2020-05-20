package com.baidu.location.p078a;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import com.baidu.location.Address;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.LocationClientOption;
import com.baidu.location.Poi;
import com.baidu.location.ServiceC1002f;
import com.baidu.location.indoor.C1026d;
import com.baidu.location.p079b.C0934a;
import com.baidu.location.p079b.C0948g;
import com.baidu.location.p082e.C0991d;
import com.baidu.location.p082e.C0998f;
import com.baidu.location.p084g.C1006b;
import com.baidu.location.p084g.C1016g;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import com.cnlaunch.p181j.ExplainResult;
import com.mopub.nativeads.MoPubNativeAdPositioning;
import com.unionpay.tsmservice.data.Constant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jivesoftware.smackx.bytestreams.ibb.packet.DataPacketExtension;

/* renamed from: com.baidu.location.a.a */
/* loaded from: classes.dex */
public class C0892a {

    /* renamed from: c */
    public static long f3855c;

    /* renamed from: e */
    private static C0892a f3856e;

    /* renamed from: f */
    private ArrayList<C0893a> f3860f;

    /* renamed from: g */
    private boolean f3861g = false;

    /* renamed from: a */
    public boolean f3857a = false;

    /* renamed from: b */
    boolean f3858b = false;

    /* renamed from: h */
    private BDLocation f3862h = null;

    /* renamed from: i */
    private BDLocation f3863i = null;

    /* renamed from: j */
    private BDLocation f3864j = null;

    /* renamed from: d */
    int f3859d = 0;

    /* renamed from: k */
    private BDLocation f3865k = null;

    /* renamed from: l */
    private boolean f3866l = false;

    /* renamed from: m */
    private boolean f3867m = false;

    /* renamed from: n */
    private RunnableC0894b f3868n = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.location.a.a$a */
    /* loaded from: classes.dex */
    public class C0893a {

        /* renamed from: a */
        public String f3869a;

        /* renamed from: b */
        public Messenger f3870b;

        /* renamed from: c */
        public LocationClientOption f3871c = new LocationClientOption();

        /* renamed from: d */
        public int f3872d = 0;

        public C0893a(Message message2) {
            this.f3869a = null;
            this.f3870b = null;
            this.f3870b = message2.replyTo;
            this.f3869a = message2.getData().getString("packName");
            this.f3871c.prodName = message2.getData().getString("prodName");
            C1006b.m11603a().m11601a(this.f3871c.prodName, this.f3869a);
            this.f3871c.coorType = message2.getData().getString("coorType");
            this.f3871c.addrType = message2.getData().getString("addrType");
            this.f3871c.enableSimulateGps = message2.getData().getBoolean("enableSimulateGps", false);
            boolean z = true;
            C1016g.f4602l = C1016g.f4602l || this.f3871c.enableSimulateGps;
            if (!C1016g.f4597g.equals("all")) {
                C1016g.f4597g = this.f3871c.addrType;
            }
            this.f3871c.openGps = message2.getData().getBoolean("openGPS");
            this.f3871c.scanSpan = message2.getData().getInt("scanSpan");
            this.f3871c.timeOut = message2.getData().getInt("timeOut");
            this.f3871c.priority = message2.getData().getInt("priority");
            this.f3871c.location_change_notify = message2.getData().getBoolean("location_change_notify");
            this.f3871c.mIsNeedDeviceDirect = message2.getData().getBoolean("needDirect", false);
            this.f3871c.isNeedAltitude = message2.getData().getBoolean("isneedaltitude", false);
            C1016g.f4598h = C1016g.f4598h || message2.getData().getBoolean("isneedaptag", false);
            if (!C1016g.f4599i && !message2.getData().getBoolean("isneedaptagd", false)) {
                z = false;
            }
            C1016g.f4599i = z;
            C1016g.f4553Q = message2.getData().getFloat("autoNotifyLocSensitivity", 0.5f);
            int i = message2.getData().getInt("wifitimeout", MoPubNativeAdPositioning.MoPubClientPositioning.NO_REPEAT);
            if (i < C1016g.f4570ae) {
                C1016g.f4570ae = i;
            }
            int i2 = message2.getData().getInt("autoNotifyMaxInterval", 0);
            if (i2 >= C1016g.f4558V) {
                C1016g.f4558V = i2;
            }
            int i3 = message2.getData().getInt("autoNotifyMinDistance", 0);
            if (i3 >= C1016g.f4560X) {
                C1016g.f4560X = i3;
            }
            int i4 = message2.getData().getInt("autoNotifyMinTimeInterval", 0);
            if (i4 >= C1016g.f4559W) {
                C1016g.f4559W = i4;
            }
            if (this.f3871c.scanSpan >= 1000) {
                C0948g.m11961a().m11958b();
            }
            if (this.f3871c.mIsNeedDeviceDirect || this.f3871c.isNeedAltitude) {
                C0924l.m12078a().m12077a(this.f3871c.mIsNeedDeviceDirect);
                C0924l.m12078a().m12076b();
            }
            C0892a.this.f3858b |= this.f3871c.isNeedAltitude;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m12237a(int i) {
            Message obtain = Message.obtain((Handler) null, i);
            try {
                if (this.f3870b != null) {
                    this.f3870b.send(obtain);
                }
                this.f3872d = 0;
            } catch (Exception e) {
                if (e instanceof DeadObjectException) {
                    this.f3872d++;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m12236a(int i, Bundle bundle) {
            Message obtain = Message.obtain((Handler) null, i);
            obtain.setData(bundle);
            try {
                if (this.f3870b != null) {
                    this.f3870b.send(obtain);
                }
                this.f3872d = 0;
            } catch (Exception e) {
                if (e instanceof DeadObjectException) {
                    this.f3872d++;
                }
                e.printStackTrace();
            }
        }

        /* renamed from: a */
        private void m12235a(int i, String str, BDLocation bDLocation) {
            Bundle bundle = new Bundle();
            bundle.putParcelable(str, bDLocation);
            bundle.setClassLoader(BDLocation.class.getClassLoader());
            Message obtain = Message.obtain((Handler) null, i);
            obtain.setData(bundle);
            try {
                if (this.f3870b != null) {
                    this.f3870b.send(obtain);
                }
                this.f3872d = 0;
            } catch (Exception e) {
                if (e instanceof DeadObjectException) {
                    this.f3872d++;
                }
            }
        }

        /* renamed from: a */
        public void m12238a() {
            m12237a(111);
        }

        /* renamed from: a */
        public void m12234a(BDLocation bDLocation) {
            m12233a(bDLocation, 21);
        }

        /* renamed from: a */
        public void m12233a(BDLocation bDLocation, int i) {
            String str;
            BDLocation bDLocation2 = new BDLocation(bDLocation);
            if (C1026d.m11499a().m11457f()) {
                bDLocation2.setIndoorLocMode(true);
            }
            if (i == 21) {
                m12235a(27, "locStr", bDLocation2);
            }
            if (this.f3871c.coorType != null && !this.f3871c.coorType.equals(CoordinateType.GCJ02)) {
                double longitude = bDLocation2.getLongitude();
                double latitude = bDLocation2.getLatitude();
                if (longitude != Double.MIN_VALUE && latitude != Double.MIN_VALUE) {
                    if ((bDLocation2.getCoorType() != null && bDLocation2.getCoorType().equals(CoordinateType.GCJ02)) || bDLocation2.getCoorType() == null) {
                        double[] coorEncrypt = Jni.coorEncrypt(longitude, latitude, this.f3871c.coorType);
                        bDLocation2.setLongitude(coorEncrypt[0]);
                        bDLocation2.setLatitude(coorEncrypt[1]);
                        str = this.f3871c.coorType;
                    } else if (bDLocation2.getCoorType() != null && bDLocation2.getCoorType().equals(CoordinateType.WGS84) && !this.f3871c.coorType.equals("bd09ll")) {
                        double[] coorEncrypt2 = Jni.coorEncrypt(longitude, latitude, "wgs842mc");
                        bDLocation2.setLongitude(coorEncrypt2[0]);
                        bDLocation2.setLatitude(coorEncrypt2[1]);
                        str = "wgs84mc";
                    }
                    bDLocation2.setCoorType(str);
                }
            }
            m12235a(i, "locStr", bDLocation2);
        }

        /* renamed from: b */
        public void m12230b() {
            if (this.f3871c.location_change_notify) {
                if (C1016g.f4592b) {
                    m12237a(54);
                } else {
                    m12237a(55);
                }
            }
        }
    }

    /* renamed from: com.baidu.location.a.a$b */
    /* loaded from: classes.dex */
    class RunnableC0894b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C0892a f3874a;

        /* renamed from: b */
        private int f3875b;

        /* renamed from: c */
        private boolean f3876c;

        @Override // java.lang.Runnable
        public void run() {
            if (this.f3876c) {
                return;
            }
            this.f3875b++;
            this.f3874a.f3867m = false;
        }
    }

    private C0892a() {
        this.f3860f = null;
        this.f3860f = new ArrayList<>();
    }

    /* renamed from: a */
    private C0893a m12258a(Messenger messenger) {
        ArrayList<C0893a> arrayList = this.f3860f;
        if (arrayList == null) {
            return null;
        }
        Iterator<C0893a> it = arrayList.iterator();
        while (it.hasNext()) {
            C0893a next = it.next();
            if (next.f3870b.equals(messenger)) {
                return next;
            }
        }
        return null;
    }

    /* renamed from: a */
    public static C0892a m12261a() {
        if (f3856e == null) {
            f3856e = new C0892a();
        }
        return f3856e;
    }

    /* renamed from: a */
    private void m12256a(C0893a c0893a) {
        int i;
        if (c0893a == null) {
            return;
        }
        if (m12258a(c0893a.f3870b) != null) {
            i = 14;
        } else {
            this.f3860f.add(c0893a);
            i = 13;
        }
        c0893a.m12237a(i);
    }

    /* renamed from: b */
    private void m12250b(String str) {
        Intent intent = new Intent("com.baidu.location.flp.log");
        intent.setPackage("com.baidu.baidulocationdemo");
        intent.putExtra(DataPacketExtension.ELEMENT_NAME, str);
        intent.putExtra("pack", C1006b.f4490d);
        intent.putExtra(Constant.KEY_TAG, "state");
        ServiceC1002f.getServiceContext().sendBroadcast(intent);
    }

    /* renamed from: h */
    private void m12240h() {
        m12239i();
        m12241g();
    }

    /* renamed from: i */
    private void m12239i() {
        Iterator<C0893a> it = this.f3860f.iterator();
        boolean z = false;
        boolean z2 = false;
        while (it.hasNext()) {
            C0893a next = it.next();
            if (next.f3871c.openGps) {
                z2 = true;
            }
            if (next.f3871c.location_change_notify) {
                z = true;
            }
        }
        C1016g.f4563a = z;
        if (this.f3861g != z2) {
            this.f3861g = z2;
            C0991d.m11704a().m11690a(this.f3861g);
        }
    }

    /* renamed from: a */
    public void m12260a(Bundle bundle, int i) {
        Iterator<C0893a> it = this.f3860f.iterator();
        while (it.hasNext()) {
            try {
                C0893a next = it.next();
                next.m12236a(i, bundle);
                if (next.f3872d > 4) {
                    it.remove();
                }
            } catch (Exception unused) {
                return;
            }
        }
    }

    /* renamed from: a */
    public void m12259a(Message message2) {
        if (message2 == null || message2.replyTo == null) {
            return;
        }
        f3855c = System.currentTimeMillis();
        this.f3857a = true;
        C0998f.m11640a().m11635b();
        m12256a(new C0893a(message2));
        m12240h();
        if (this.f3866l) {
            m12250b(ExplainResult.START);
            this.f3859d = 0;
        }
    }

    /* renamed from: a */
    public void m12257a(BDLocation bDLocation) {
        m12251b(bDLocation);
    }

    /* renamed from: a */
    public void m12254a(String str) {
        m12247c(new BDLocation(str));
    }

    /* renamed from: b */
    public void m12253b() {
        this.f3860f.clear();
        this.f3862h = null;
        m12240h();
    }

    /* renamed from: b */
    public void m12252b(Message message2) {
        C0893a m12258a = m12258a(message2.replyTo);
        if (m12258a != null) {
            this.f3860f.remove(m12258a);
        }
        C0948g.m11961a().m11956c();
        C0924l.m12078a().m12074c();
        m12240h();
        if (this.f3866l) {
            m12250b(ExplainResult.STOP);
            this.f3859d = 0;
        }
    }

    /* renamed from: b */
    public void m12251b(BDLocation bDLocation) {
        BDLocation bDLocation2;
        if (C1026d.m11499a().m11455g() && bDLocation.getFloor() != null) {
            this.f3864j = null;
            this.f3864j = new BDLocation(bDLocation);
        }
        if (bDLocation.getFloor() == null) {
            this.f3864j = null;
        }
        boolean z = C0919j.f4019h;
        if (z) {
            C0919j.f4019h = false;
        }
        if (C1016g.f4558V >= 10000 && (bDLocation.getLocType() == 61 || bDLocation.getLocType() == 161 || bDLocation.getLocType() == 66)) {
            BDLocation bDLocation3 = this.f3862h;
            if (bDLocation3 != null) {
                float[] fArr = new float[1];
                Location.distanceBetween(bDLocation3.getLatitude(), this.f3862h.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
                if (fArr[0] <= C1016g.f4560X && !z) {
                    return;
                }
                this.f3862h = null;
                bDLocation2 = new BDLocation(bDLocation);
            } else {
                bDLocation2 = new BDLocation(bDLocation);
            }
            this.f3862h = bDLocation2;
        }
        if (bDLocation != null && bDLocation.getLocType() == 161 && !C0910h.m12149a().m12147b()) {
            if (this.f3863i == null) {
                this.f3863i = new BDLocation();
                this.f3863i.setLocType(505);
            }
            Iterator<C0893a> it = this.f3860f.iterator();
            while (it.hasNext()) {
                try {
                    C0893a next = it.next();
                    next.m12234a(this.f3863i);
                    if (next.f3872d > 4) {
                        it.remove();
                    }
                } catch (Exception unused) {
                    return;
                }
            }
            return;
        }
        if (!bDLocation.hasAltitude() && this.f3858b && (bDLocation.getLocType() == 161 || bDLocation.getLocType() == 66)) {
            double m12026a = C0934a.m12027a().m12026a(bDLocation.getLongitude(), bDLocation.getLatitude());
            if (m12026a != Double.MAX_VALUE) {
                bDLocation.setAltitude(m12026a);
            }
        }
        if (bDLocation.getLocType() == 61) {
            bDLocation.setGpsAccuracyStatus(C0934a.m12027a().m12024a(bDLocation));
        }
        Iterator<C0893a> it2 = this.f3860f.iterator();
        while (it2.hasNext()) {
            try {
                C0893a next2 = it2.next();
                next2.m12234a(bDLocation);
                if (next2.f3872d > 4) {
                    it2.remove();
                }
            } catch (Exception unused2) {
                return;
            }
        }
    }

    /* renamed from: c */
    public void m12249c() {
        BDLocation bDLocation = this.f3864j;
        if (bDLocation != null) {
            m12257a(bDLocation);
        }
    }

    /* renamed from: c */
    public void m12247c(BDLocation bDLocation) {
        Address m12117a = C0919j.m12105c().m12117a(bDLocation);
        String m12094f = C0919j.m12105c().m12094f();
        List<Poi> m12092g = C0919j.m12105c().m12092g();
        if (m12117a != null) {
            bDLocation.setAddr(m12117a);
        }
        if (m12094f != null) {
            bDLocation.setLocationDescribe(m12094f);
        }
        if (m12092g != null) {
            bDLocation.setPoiList(m12092g);
        }
        if (C1026d.m11499a().m11455g() && C1026d.m11499a().m11453h() != null) {
            bDLocation.setFloor(C1026d.m11499a().m11453h());
            bDLocation.setIndoorLocMode(true);
            if (C1026d.m11499a().m11451i() != null) {
                bDLocation.setBuildingID(C1026d.m11499a().m11451i());
            }
        }
        C0919j.m12105c().m12098d(bDLocation);
        m12257a(bDLocation);
    }

    /* renamed from: c */
    public boolean m12248c(Message message2) {
        C0893a m12258a = m12258a(message2.replyTo);
        boolean z = false;
        if (m12258a == null) {
            return false;
        }
        int i = m12258a.f3871c.scanSpan;
        m12258a.f3871c.scanSpan = message2.getData().getInt("scanSpan", m12258a.f3871c.scanSpan);
        if (m12258a.f3871c.scanSpan < 1000) {
            C0948g.m11961a().m11952e();
            C0924l.m12078a().m12074c();
            this.f3857a = false;
        } else {
            C0948g.m11961a().m11954d();
            this.f3857a = true;
        }
        if (m12258a.f3871c.scanSpan > 999 && i < 1000) {
            if (m12258a.f3871c.mIsNeedDeviceDirect || m12258a.f3871c.isNeedAltitude) {
                C0924l.m12078a().m12077a(m12258a.f3871c.mIsNeedDeviceDirect);
                C0924l.m12078a().m12076b();
            }
            this.f3858b |= m12258a.f3871c.isNeedAltitude;
            z = true;
        }
        m12258a.f3871c.openGps = message2.getData().getBoolean("openGPS", m12258a.f3871c.openGps);
        String string = message2.getData().getString("coorType");
        LocationClientOption locationClientOption = m12258a.f3871c;
        if (string == null || string.equals("")) {
            string = m12258a.f3871c.coorType;
        }
        locationClientOption.coorType = string;
        String string2 = message2.getData().getString("addrType");
        LocationClientOption locationClientOption2 = m12258a.f3871c;
        if (string2 == null || string2.equals("")) {
            string2 = m12258a.f3871c.addrType;
        }
        locationClientOption2.addrType = string2;
        if (!C1016g.f4597g.equals(m12258a.f3871c.addrType)) {
            C0919j.m12105c().m12087j();
        }
        m12258a.f3871c.timeOut = message2.getData().getInt("timeOut", m12258a.f3871c.timeOut);
        m12258a.f3871c.location_change_notify = message2.getData().getBoolean("location_change_notify", m12258a.f3871c.location_change_notify);
        m12258a.f3871c.priority = message2.getData().getInt("priority", m12258a.f3871c.priority);
        int i2 = message2.getData().getInt("wifitimeout", MoPubNativeAdPositioning.MoPubClientPositioning.NO_REPEAT);
        if (i2 < C1016g.f4570ae) {
            C1016g.f4570ae = i2;
        }
        m12240h();
        return z;
    }

    /* renamed from: d */
    public int m12245d(Message message2) {
        C0893a m12258a;
        if (message2 == null || message2.replyTo == null || (m12258a = m12258a(message2.replyTo)) == null || m12258a.f3871c == null) {
            return 1;
        }
        return m12258a.f3871c.priority;
    }

    /* renamed from: d */
    public void m12246d() {
        if (this.f3864j != null) {
            this.f3864j = null;
        }
    }

    /* renamed from: e */
    public int m12243e(Message message2) {
        C0893a m12258a;
        if (message2 == null || message2.replyTo == null || (m12258a = m12258a(message2.replyTo)) == null || m12258a.f3871c == null) {
            return 1000;
        }
        return m12258a.f3871c.scanSpan;
    }

    /* renamed from: e */
    public void m12244e() {
        if (this.f3864j != null) {
            this.f3864j = null;
        }
        Iterator<C0893a> it = this.f3860f.iterator();
        while (it.hasNext()) {
            it.next().m12238a();
        }
    }

    /* renamed from: f */
    public String m12242f() {
        StringBuffer stringBuffer = new StringBuffer(256);
        if (this.f3860f.isEmpty()) {
            return "&prod=" + C1006b.f4491e + ":" + C1006b.f4490d;
        }
        C0893a c0893a = this.f3860f.get(0);
        if (c0893a.f3871c.prodName != null) {
            stringBuffer.append(c0893a.f3871c.prodName);
        }
        if (c0893a.f3869a != null) {
            stringBuffer.append(":");
            stringBuffer.append(c0893a.f3869a);
            stringBuffer.append("|");
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 == null || stringBuffer2.equals("")) {
            return null;
        }
        return "&prod=".concat(String.valueOf(stringBuffer2));
    }

    /* renamed from: g */
    public void m12241g() {
        Iterator<C0893a> it = this.f3860f.iterator();
        while (it.hasNext()) {
            it.next().m12230b();
        }
    }
}
