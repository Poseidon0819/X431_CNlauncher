package com.cnlaunch.gmap.map.p145a.p146a;

import com.cnlaunch.gmap.map.p145a.p146a.LocationSearch;
import com.google.android.gms.maps.model.LatLng;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LocationInterface.java */
/* renamed from: com.cnlaunch.gmap.map.a.a.b */
/* loaded from: classes.dex */
public final class RunnableC1513b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ LatLng f7481a;

    /* renamed from: b */
    final /* synthetic */ LocationSearch.InterfaceC1517a f7482b;

    /* renamed from: c */
    final /* synthetic */ LocationInterface f7483c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1513b(LocationInterface locationInterface, LatLng latLng, LocationSearch.InterfaceC1517a interfaceC1517a) {
        this.f7483c = locationInterface;
        this.f7481a = latLng;
        this.f7482b = interfaceC1517a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000a, code lost:
        r0 = r8.f7483c.m9325a(r8.f7481a);
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            r8 = this;
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            boolean r0 = r0.isInterrupted()
            if (r0 != 0) goto Lac
            com.cnlaunch.gmap.map.a.a.a r0 = r8.f7483c
            com.google.android.gms.maps.model.LatLng r1 = r8.f7481a
            android.location.Address r0 = com.cnlaunch.gmap.map.p145a.p146a.LocationInterface.m9327a(r0, r1)
            if (r0 != 0) goto L15
            return
        L15:
            java.lang.String r1 = r0.getFeatureName()
            r2 = 0
            if (r1 == 0) goto L82
            java.lang.String r1 = r0.getFeatureName()
            java.lang.String r3 = ""
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L29
            goto L82
        L29:
            java.lang.String r1 = r0.getThoroughfare()
            boolean r1 = com.cnlaunch.gmap.map.p151c.StringUtils.m9282a(r1)
            r3 = 2
            r4 = 1
            r5 = 3
            if (r1 != 0) goto L67
            java.lang.String r1 = r0.getFeatureName()
            java.lang.String r6 = r0.getThoroughfare()
            boolean r1 = r1.contains(r6)
            if (r1 == 0) goto L45
            goto L67
        L45:
            java.lang.String r1 = "%s%s%s%s"
            r6 = 4
            java.lang.Object[] r6 = new java.lang.Object[r6]
            java.lang.String r7 = r0.getAdminArea()
            r6[r2] = r7
            java.lang.String r2 = r0.getLocality()
            r6[r4] = r2
            java.lang.String r2 = r0.getThoroughfare()
            r6[r3] = r2
            java.lang.String r2 = r0.getFeatureName()
            r6[r5] = r2
            java.lang.String r1 = java.lang.String.format(r1, r6)
            goto L86
        L67:
            java.lang.String r1 = "%s%s%s"
            java.lang.Object[] r5 = new java.lang.Object[r5]
            java.lang.String r6 = r0.getAdminArea()
            r5[r2] = r6
            java.lang.String r2 = r0.getLocality()
            r5[r4] = r2
            java.lang.String r2 = r0.getFeatureName()
            r5[r3] = r2
            java.lang.String r1 = java.lang.String.format(r1, r5)
            goto L86
        L82:
            java.lang.String r1 = r0.getAddressLine(r2)
        L86:
            com.cnlaunch.gmap.map.logic.a.d r2 = new com.cnlaunch.gmap.map.logic.a.d
            r2.<init>()
            com.cnlaunch.gmap.map.logic.a.c r3 = new com.cnlaunch.gmap.map.logic.a.c
            com.google.android.gms.maps.model.LatLng r4 = r8.f7481a
            double r4 = r4.f19310c
            com.google.android.gms.maps.model.LatLng r6 = r8.f7481a
            double r6 = r6.f19311d
            r3.<init>(r4, r6)
            r2.setLclatlng(r3)
            java.lang.String r0 = r0.getLocality()
            r2.setCityName(r0)
            r2.setAddress(r1)
            com.cnlaunch.gmap.map.a.a.a r0 = r8.f7483c
            com.cnlaunch.gmap.map.a.a.f$a r1 = r8.f7482b
            com.cnlaunch.gmap.map.p145a.p146a.LocationInterface.m9328a(r0, r1, r2)
        Lac:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.gmap.map.p145a.p146a.RunnableC1513b.run():void");
    }
}
