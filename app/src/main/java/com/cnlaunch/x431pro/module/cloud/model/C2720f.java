package com.cnlaunch.x431pro.module.cloud.model;

import android.util.Log;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.p135g.MyLocationLogic;
import com.cnlaunch.p135g.p136a.LocationInfo;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CloudDataManager.java */
/* renamed from: com.cnlaunch.x431pro.module.cloud.model.f */
/* loaded from: classes.dex */
public final class C2720f implements MyLocationLogic.InterfaceC1482a {

    /* renamed from: a */
    final /* synthetic */ CloudDataManager f15509a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2720f(CloudDataManager cloudDataManager) {
        this.f15509a = cloudDataManager;
    }

    @Override // com.cnlaunch.p135g.MyLocationLogic.InterfaceC1482a
    /* renamed from: a */
    public final void mo5399a(LocationInfo locationInfo) {
        String str;
        String str2;
        String str3;
        this.f15509a.f15505f = Double.toString(locationInfo.getLat());
        this.f15509a.f15506g = Double.toString(locationInfo.getLon());
        this.f15509a.f15507h = locationInfo.getLocationType();
        StringBuilder sb = new StringBuilder("loacation lat:");
        str = this.f15509a.f15505f;
        sb.append(str);
        sb.append(" lon:");
        str2 = this.f15509a.f15506g;
        sb.append(str2);
        sb.append(" gpsType:");
        str3 = this.f15509a.f15507h;
        sb.append(str3);
        NLog.m9452b("XEE", sb.toString());
    }

    @Override // com.cnlaunch.p135g.MyLocationLogic.InterfaceC1482a
    /* renamed from: a */
    public final void mo5400a() {
        Log.e("XEE", "loacation: err");
    }
}
