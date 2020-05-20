package com.baidu.location.indoor.mapversion.p085a;

import com.baidu.location.BDLocation;
import com.baidu.location.indoor.mapversion.IndoorJni;
import com.baidu.location.indoor.mapversion.p086b.C1052a;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.baidu.location.indoor.mapversion.a.a */
/* loaded from: classes.dex */
public class C1051a {

    /* renamed from: a */
    private static Lock f4832a = new ReentrantLock();

    /* renamed from: a */
    public static boolean m11309a() {
        return IndoorJni.f4830a;
    }

    /* renamed from: a */
    public static synchronized boolean m11308a(BDLocation bDLocation) {
        Lock lock;
        synchronized (C1051a.class) {
            if (m11309a()) {
                C1052a.C1057d m11290b = C1052a.m11304a().m11290b(bDLocation.getFloor());
                if (m11290b != null) {
                    double m11277a = m11290b.m11277a(bDLocation.getLongitude());
                    double m11275b = m11290b.m11275b(bDLocation.getLatitude());
                    double[] dArr = {0.0d, 0.0d};
                    f4832a.lock();
                    try {
                        dArr = IndoorJni.setPfWf(m11277a, m11275b);
                        lock = f4832a;
                    } catch (Exception e) {
                        e.printStackTrace();
                        lock = f4832a;
                    }
                    lock.unlock();
                    if (dArr[0] > 0.0d && dArr[1] > 0.0d) {
                        double m11273c = m11290b.m11273c(dArr[0]);
                        double m11272d = m11290b.m11272d(dArr[1]);
                        bDLocation.setLongitude(m11273c);
                        bDLocation.setLatitude(m11272d);
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
    }

    /* renamed from: a */
    public static synchronized boolean m11307a(String str) {
        Lock lock;
        synchronized (C1051a.class) {
            if (m11309a()) {
                C1052a.C1057d m11290b = C1052a.m11304a().m11290b(str);
                if (m11290b == null) {
                    return false;
                }
                m11290b.m11276a(CoordinateType.GCJ02);
                short[][] sArr = m11290b.f4860g;
                double d = m11290b.m11278a().f4843a;
                double d2 = m11290b.m11278a().f4844b;
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < sArr.length; i++) {
                    short s = sArr[i][0];
                    int i2 = 1;
                    for (int i3 = 1; i3 < sArr[i].length; i3++) {
                        if (s != sArr[i][i3]) {
                            sb.append(i2);
                            sb.append("*");
                            sb.append((int) s);
                            sb.append(";");
                            s = sArr[i][i3];
                            i2 = 1;
                        } else {
                            i2++;
                        }
                    }
                    sb.append(i2);
                    sb.append("*");
                    sb.append((int) s);
                    sb.append(";");
                    if (i != sArr.length - 1) {
                        sb.append("|");
                    }
                }
                f4832a.lock();
                try {
                    IndoorJni.setRdnt(str, sArr, d, d2, (int) m11290b.f4859f.f4849g, (int) m11290b.f4859f.f4850h);
                    lock = f4832a;
                } catch (Exception e) {
                    e.printStackTrace();
                    lock = f4832a;
                }
                lock.unlock();
                return true;
            }
            return false;
        }
    }

    /* renamed from: a */
    public static synchronized double[] m11306a(String str, double d, double d2) {
        Lock lock;
        synchronized (C1051a.class) {
            if (m11309a()) {
                C1052a.C1057d m11290b = C1052a.m11304a().m11290b(str);
                if (m11290b != null) {
                    f4832a.lock();
                    double[] dArr = {0.0d, 0.0d};
                    try {
                        dArr = IndoorJni.getPfFr(d2, d);
                        lock = f4832a;
                    } catch (Exception e) {
                        e.printStackTrace();
                        lock = f4832a;
                    }
                    lock.unlock();
                    if (dArr[0] > 0.0d && dArr[1] > 0.0d) {
                        return new double[]{m11290b.m11272d(dArr[1]), m11290b.m11273c(dArr[0])};
                    }
                }
                return null;
            }
            return null;
        }
    }

    /* renamed from: b */
    public static void m11305b() {
        if (m11309a()) {
            try {
                IndoorJni.resetPf();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
