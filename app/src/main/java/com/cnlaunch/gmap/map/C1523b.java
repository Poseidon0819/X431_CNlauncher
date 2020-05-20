package com.cnlaunch.gmap.map;

import android.widget.TextView;
import com.cnlaunch.gmap.map.logic.p153a.LocationResult;
import com.cnlaunch.gmap.map.p145a.p146a.LocationSearch;

/* compiled from: LocationSearchActivity.java */
/* renamed from: com.cnlaunch.gmap.map.b */
/* loaded from: classes.dex */
final class C1523b implements LocationSearch.InterfaceC1517a {

    /* renamed from: a */
    final /* synthetic */ LocationSearchActivity f7526a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1523b(LocationSearchActivity locationSearchActivity) {
        this.f7526a = locationSearchActivity;
    }

    @Override // com.cnlaunch.gmap.map.p145a.p146a.LocationSearch.InterfaceC1517a
    /* renamed from: a */
    public final void mo6551a(LocationResult locationResult) {
        TextView textView;
        if (this.f7526a.isFinishing() || locationResult == null) {
            return;
        }
        textView = this.f7526a.f7464R;
        textView.setText(locationResult.getAddress());
        this.f7526a.f7469W = locationResult.getCityName();
        this.f7526a.f7463Q = locationResult;
    }
}
