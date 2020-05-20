package com.cnlaunch.gmap.map.p152d;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.cnlaunch.gmap.map.p150b.PoiSearchInfo;
import com.cnlaunch.gmap.map.p152d.MapSearchResultPop;

/* compiled from: MapSearchResultPop.java */
/* renamed from: com.cnlaunch.gmap.map.d.b */
/* loaded from: classes.dex */
final class View$OnClickListenerC1539b implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PoiSearchInfo f7613a;

    /* renamed from: b */
    final /* synthetic */ MapSearchResultPop.C1537b f7614b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1539b(MapSearchResultPop.C1537b c1537b, PoiSearchInfo poiSearchInfo) {
        this.f7614b = c1537b;
        this.f7613a = poiSearchInfo;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        MapSearchResultPop.InterfaceC1536a interfaceC1536a;
        int i;
        Context context;
        View view2;
        interfaceC1536a = MapSearchResultPop.this.f7608h;
        PoiSearchInfo poiSearchInfo = this.f7613a;
        i = MapSearchResultPop.this.f7603c;
        interfaceC1536a.mo9276a(poiSearchInfo, i);
        context = MapSearchResultPop.this.f7605e;
        view2 = MapSearchResultPop.this.f7604d;
        InputMethodManager inputMethodManager = (InputMethodManager) ((Activity) context).getSystemService("input_method");
        if (inputMethodManager.isActive()) {
            inputMethodManager.hideSoftInputFromWindow(view2.getWindowToken(), 0);
        }
        MapSearchResultPop.this.f7601a.dismiss();
    }
}
