package com.baidu.mapapi.map.offline;

import com.baidu.mapsdkplatform.comapi.map.C1215i;
import com.baidu.mapsdkplatform.comapi.map.C1225p;
import com.baidu.mapsdkplatform.comapi.map.C1226q;
import com.baidu.mapsdkplatform.comapi.map.C1229s;
import com.baidu.mapsdkplatform.comapi.map.InterfaceC1230t;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class MKOfflineMap {
    public static final int TYPE_DOWNLOAD_UPDATE = 0;
    public static final int TYPE_NETWORK_ERROR = 2;
    public static final int TYPE_NEW_OFFLINE = 6;
    public static final int TYPE_VER_UPDATE = 4;

    /* renamed from: a */
    private static final String f5400a = "MKOfflineMap";

    /* renamed from: b */
    private C1226q f5401b;

    /* renamed from: c */
    private MKOfflineMapListener f5402c;

    public void destroy() {
        this.f5401b.m10579d(0);
        this.f5401b.m10583b((InterfaceC1230t) null);
        this.f5401b.m10585b();
        C1215i.m10643b();
    }

    public ArrayList<MKOLUpdateElement> getAllUpdateInfo() {
        ArrayList<C1229s> m10578e = this.f5401b.m10578e();
        if (m10578e == null) {
            return null;
        }
        ArrayList<MKOLUpdateElement> arrayList = new ArrayList<>();
        Iterator<C1229s> it = m10578e.iterator();
        while (it.hasNext()) {
            arrayList.add(OfflineMapUtil.getUpdatElementFromLocalMapElement(it.next().m10571a()));
        }
        return arrayList;
    }

    public ArrayList<MKOLSearchRecord> getHotCityList() {
        ArrayList<C1225p> m10582c = this.f5401b.m10582c();
        if (m10582c == null) {
            return null;
        }
        ArrayList<MKOLSearchRecord> arrayList = new ArrayList<>();
        Iterator<C1225p> it = m10582c.iterator();
        while (it.hasNext()) {
            arrayList.add(OfflineMapUtil.getSearchRecordFromLocalCityInfo(it.next()));
        }
        return arrayList;
    }

    public ArrayList<MKOLSearchRecord> getOfflineCityList() {
        ArrayList<C1225p> m10580d = this.f5401b.m10580d();
        if (m10580d == null) {
            return null;
        }
        ArrayList<MKOLSearchRecord> arrayList = new ArrayList<>();
        Iterator<C1225p> it = m10580d.iterator();
        while (it.hasNext()) {
            arrayList.add(OfflineMapUtil.getSearchRecordFromLocalCityInfo(it.next()));
        }
        return arrayList;
    }

    public MKOLUpdateElement getUpdateInfo(int i) {
        C1229s m10573g = this.f5401b.m10573g(i);
        if (m10573g == null) {
            return null;
        }
        return OfflineMapUtil.getUpdatElementFromLocalMapElement(m10573g.m10571a());
    }

    @Deprecated
    public int importOfflineData() {
        return importOfflineData(false);
    }

    @Deprecated
    public int importOfflineData(boolean z) {
        int i;
        ArrayList<C1229s> m10578e = this.f5401b.m10578e();
        int i2 = 0;
        if (m10578e != null) {
            i2 = m10578e.size();
            i = i2;
        } else {
            i = 0;
        }
        this.f5401b.m10586a(z, true);
        ArrayList<C1229s> m10578e2 = this.f5401b.m10578e();
        if (m10578e2 != null) {
            i = m10578e2.size();
        }
        return i - i2;
    }

    public boolean init(MKOfflineMapListener mKOfflineMapListener) {
        C1215i.m10646a();
        this.f5401b = C1226q.m10591a();
        C1226q c1226q = this.f5401b;
        if (c1226q == null) {
            return false;
        }
        c1226q.m10588a(new InterfaceC1230t() { // from class: com.baidu.mapapi.map.offline.MKOfflineMap.1
            @Override // com.baidu.mapsdkplatform.comapi.map.InterfaceC1230t
            /* renamed from: a */
            public void mo10569a(int i, int i2) {
                if (i == 4) {
                    ArrayList<MKOLUpdateElement> allUpdateInfo = MKOfflineMap.this.getAllUpdateInfo();
                    if (allUpdateInfo != null) {
                        for (MKOLUpdateElement mKOLUpdateElement : allUpdateInfo) {
                            if (mKOLUpdateElement.update) {
                                MKOfflineMap.this.f5402c.onGetOfflineMapState(4, mKOLUpdateElement.cityID);
                            }
                        }
                    }
                } else if (i == 6) {
                    MKOfflineMap.this.f5402c.onGetOfflineMapState(6, i2);
                } else if (i == 8) {
                    MKOfflineMap.this.f5402c.onGetOfflineMapState(0, i2 >> 8);
                } else if (i == 10) {
                    MKOfflineMap.this.f5402c.onGetOfflineMapState(2, i2);
                } else if (i == 12) {
                    MKOfflineMap.this.f5401b.m10586a(true, false);
                }
            }
        });
        this.f5402c = mKOfflineMapListener;
        return true;
    }

    public boolean pause(int i) {
        return this.f5401b.m10581c(i);
    }

    public boolean remove(int i) {
        return this.f5401b.m10577e(i);
    }

    public ArrayList<MKOLSearchRecord> searchCity(String str) {
        ArrayList<C1225p> m10587a = this.f5401b.m10587a(str);
        if (m10587a == null) {
            return null;
        }
        ArrayList<MKOLSearchRecord> arrayList = new ArrayList<>();
        Iterator<C1225p> it = m10587a.iterator();
        while (it.hasNext()) {
            arrayList.add(OfflineMapUtil.getSearchRecordFromLocalCityInfo(it.next()));
        }
        return arrayList;
    }

    public boolean start(int i) {
        C1226q c1226q = this.f5401b;
        if (c1226q == null) {
            return false;
        }
        if (c1226q.m10578e() != null) {
            Iterator<C1229s> it = this.f5401b.m10578e().iterator();
            while (it.hasNext()) {
                C1229s next = it.next();
                if (next.f6094a.f6082a == i) {
                    if (next.f6094a.f6091j || next.f6094a.f6093l == 2 || next.f6094a.f6093l == 3 || next.f6094a.f6093l == 6) {
                        return this.f5401b.m10584b(i);
                    }
                    return false;
                }
            }
        }
        return this.f5401b.m10590a(i);
    }

    public boolean update(int i) {
        C1226q c1226q = this.f5401b;
        if (c1226q != null && c1226q.m10578e() != null) {
            Iterator<C1229s> it = this.f5401b.m10578e().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                C1229s next = it.next();
                if (next.f6094a.f6082a == i) {
                    if (next.f6094a.f6091j) {
                        return this.f5401b.m10575f(i);
                    }
                }
            }
        }
        return false;
    }
}
