package com.cnlaunch.gmap.map;

import android.widget.TextView;
import com.cnlaunch.gmap.map.logic.p153a.LocationResult;
import com.cnlaunch.gmap.map.p150b.MapManager;
import com.cnlaunch.gmap.p138a.p143e.PropertyListener;
import com.ifoer.expedition.pro.R;

/* compiled from: LocationSearchActivity.java */
/* renamed from: com.cnlaunch.gmap.map.c */
/* loaded from: classes.dex */
final class C1534c implements PropertyListener {

    /* renamed from: a */
    final /* synthetic */ LocationSearchActivity f7595a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1534c(LocationSearchActivity locationSearchActivity) {
        this.f7595a = locationSearchActivity;
    }

    @Override // com.cnlaunch.gmap.p138a.p143e.PropertyListener
    /* renamed from: a */
    public final void mo9288a(int i, Object... objArr) {
        LocationResult locationResult;
        LocationResult locationResult2;
        TextView textView;
        LocationResult locationResult3;
        if (i == 21 && objArr != null && objArr.length > 0) {
            this.f7595a.f7463Q = (LocationResult) objArr[0];
            this.f7595a.f7644E.m9307b();
            MapManager mapManager = this.f7595a.f7644E;
            locationResult = this.f7595a.f7463Q;
            mapManager.m9310a(locationResult.getLclatlng(), R.drawable.gmap_share_city_select);
            MapManager mapManager2 = this.f7595a.f7644E;
            locationResult2 = this.f7595a.f7463Q;
            mapManager2.m9311a(locationResult2.getLclatlng());
            textView = this.f7595a.f7464R;
            locationResult3 = this.f7595a.f7463Q;
            textView.setText(locationResult3.getAddress());
        }
    }
}
