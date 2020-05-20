package com.baidu.platform.core.p096d;

import com.baidu.mapapi.search.route.BikingRoutePlanOption;
import com.baidu.mapapi.search.route.DrivingRoutePlanOption;
import com.baidu.mapapi.search.route.IndoorRoutePlanOption;
import com.baidu.mapapi.search.route.MassTransitRoutePlanOption;
import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.mapapi.search.route.TransitRoutePlanOption;
import com.baidu.mapapi.search.route.WalkingRoutePlanOption;
import com.baidu.platform.base.AbstractC1319a;
import com.baidu.platform.base.SearchType;

/* renamed from: com.baidu.platform.core.d.j */
/* loaded from: classes.dex */
public class C1361j extends AbstractC1319a implements InterfaceC1356e {

    /* renamed from: b */
    private OnGetRoutePlanResultListener f6519b = null;

    @Override // com.baidu.platform.core.p096d.InterfaceC1356e
    /* renamed from: a */
    public void mo9835a() {
        this.f6477a.lock();
        this.f6519b = null;
        this.f6477a.unlock();
    }

    @Override // com.baidu.platform.core.p096d.InterfaceC1356e
    /* renamed from: a */
    public void mo9830a(OnGetRoutePlanResultListener onGetRoutePlanResultListener) {
        this.f6477a.lock();
        this.f6519b = onGetRoutePlanResultListener;
        this.f6477a.unlock();
    }

    @Override // com.baidu.platform.core.p096d.InterfaceC1356e
    /* renamed from: a */
    public boolean mo9834a(BikingRoutePlanOption bikingRoutePlanOption) {
        C1352a c1352a = new C1352a();
        c1352a.m9940a(SearchType.BIKE_ROUTE);
        return m9946a(new C1353b(bikingRoutePlanOption), this.f6519b, c1352a);
    }

    @Override // com.baidu.platform.core.p096d.InterfaceC1356e
    /* renamed from: a */
    public boolean mo9833a(DrivingRoutePlanOption drivingRoutePlanOption) {
        C1354c c1354c = new C1354c();
        c1354c.m9940a(SearchType.DRIVE_ROUTE);
        return m9946a(new C1355d(drivingRoutePlanOption), this.f6519b, c1354c);
    }

    @Override // com.baidu.platform.core.p096d.InterfaceC1356e
    /* renamed from: a */
    public boolean mo9832a(IndoorRoutePlanOption indoorRoutePlanOption) {
        C1357f c1357f = new C1357f();
        c1357f.m9940a(SearchType.INDOOR_ROUTE);
        return m9946a(new C1358g(indoorRoutePlanOption), this.f6519b, c1357f);
    }

    @Override // com.baidu.platform.core.p096d.InterfaceC1356e
    /* renamed from: a */
    public boolean mo9831a(MassTransitRoutePlanOption massTransitRoutePlanOption) {
        C1359h c1359h = new C1359h();
        c1359h.m9940a(SearchType.MASS_TRANSIT_ROUTE);
        return m9946a(new C1360i(massTransitRoutePlanOption), this.f6519b, c1359h);
    }

    @Override // com.baidu.platform.core.p096d.InterfaceC1356e
    /* renamed from: a */
    public boolean mo9829a(TransitRoutePlanOption transitRoutePlanOption) {
        C1364l c1364l = new C1364l();
        c1364l.m9940a(SearchType.TRANSIT_ROUTE);
        return m9946a(new C1365m(transitRoutePlanOption), this.f6519b, c1364l);
    }

    @Override // com.baidu.platform.core.p096d.InterfaceC1356e
    /* renamed from: a */
    public boolean mo9828a(WalkingRoutePlanOption walkingRoutePlanOption) {
        C1366n c1366n = new C1366n();
        c1366n.m9940a(SearchType.WALK_ROUTE);
        return m9946a(new C1367o(walkingRoutePlanOption), this.f6519b, c1366n);
    }
}
