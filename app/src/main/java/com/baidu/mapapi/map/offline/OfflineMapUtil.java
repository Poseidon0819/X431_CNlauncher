package com.baidu.mapapi.map.offline;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapsdkplatform.comapi.map.C1225p;
import com.baidu.mapsdkplatform.comapi.map.C1228r;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class OfflineMapUtil {
    public static MKOLSearchRecord getSearchRecordFromLocalCityInfo(C1225p c1225p) {
        C1225p next;
        if (c1225p == null) {
            return null;
        }
        MKOLSearchRecord mKOLSearchRecord = new MKOLSearchRecord();
        mKOLSearchRecord.cityID = c1225p.f6071a;
        mKOLSearchRecord.cityName = c1225p.f6072b;
        mKOLSearchRecord.cityType = c1225p.f6074d;
        long j = 0;
        if (c1225p.m10593a() != null) {
            ArrayList<MKOLSearchRecord> arrayList = new ArrayList<>();
            Iterator<C1225p> it = c1225p.m10593a().iterator();
            while (it.hasNext()) {
                arrayList.add(getSearchRecordFromLocalCityInfo(it.next()));
                j += next.f6073c;
                mKOLSearchRecord.childCities = arrayList;
            }
        }
        if (mKOLSearchRecord.cityType != 1) {
            j = c1225p.f6073c;
        }
        mKOLSearchRecord.dataSize = j;
        return mKOLSearchRecord;
    }

    public static MKOLUpdateElement getUpdatElementFromLocalMapElement(C1228r c1228r) {
        if (c1228r == null) {
            return null;
        }
        MKOLUpdateElement mKOLUpdateElement = new MKOLUpdateElement();
        mKOLUpdateElement.cityID = c1228r.f6082a;
        mKOLUpdateElement.cityName = c1228r.f6083b;
        if (c1228r.f6088g != null) {
            mKOLUpdateElement.geoPt = CoordUtil.mc2ll(c1228r.f6088g);
        }
        mKOLUpdateElement.level = c1228r.f6086e;
        mKOLUpdateElement.ratio = c1228r.f6090i;
        mKOLUpdateElement.serversize = c1228r.f6089h;
        mKOLUpdateElement.size = c1228r.f6090i == 100 ? c1228r.f6089h : (c1228r.f6089h / 100) * c1228r.f6090i;
        mKOLUpdateElement.status = c1228r.f6093l;
        mKOLUpdateElement.update = c1228r.f6091j;
        return mKOLUpdateElement;
    }
}
