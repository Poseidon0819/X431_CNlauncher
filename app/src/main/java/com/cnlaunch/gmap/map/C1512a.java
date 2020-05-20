package com.cnlaunch.gmap.map;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;
import com.cnlaunch.gmap.map.logic.p153a.LcLatlng;
import com.cnlaunch.gmap.map.logic.p153a.LocationResult;
import com.cnlaunch.gmap.map.p145a.p147b.SuggestionSearch;
import com.cnlaunch.gmap.map.p145a.p147b.p148a.RunnableC1520b;
import com.cnlaunch.gmap.map.p145a.p147b.p148a.SuggestionInterface;
import com.cnlaunch.gmap.map.p150b.MapManager;
import com.google.android.gms.maps.model.LatLng;

/* compiled from: LocationSearchActivity.java */
/* renamed from: com.cnlaunch.gmap.map.a */
/* loaded from: classes.dex */
final class C1512a implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ LocationSearchActivity f7478a;

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1512a(LocationSearchActivity locationSearchActivity) {
        this.f7478a = locationSearchActivity;
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f7478a.f7473aa = charSequence.toString();
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        boolean z;
        String str;
        ImageView imageView;
        ImageView imageView2;
        boolean z2;
        boolean z3;
        LocationResult locationResult;
        String str2;
        String str3;
        String unused;
        z = this.f7478a.f7474ab;
        if (!z) {
            LocationSearchActivity.m9340b(this.f7478a);
            return;
        }
        String obj = editable.toString();
        str = this.f7478a.f7473aa;
        if (str != null) {
            str3 = this.f7478a.f7473aa;
            if (str3.contains(obj)) {
                LocationSearchActivity.m9337d(this.f7478a);
            }
        }
        if (obj == null || obj.length() <= 0) {
            imageView = this.f7478a.f7468V;
            imageView.setVisibility(8);
            return;
        }
        imageView2 = this.f7478a.f7468V;
        imageView2.setVisibility(0);
        z2 = this.f7478a.f7471Y;
        if (z2) {
            z3 = this.f7478a.f7472Z;
            if (z3) {
                return;
            }
            unused = this.f7478a.f7469W;
            return;
        }
        MapManager mapManager = this.f7478a.f7644E;
        locationResult = this.f7478a.f7463Q;
        str2 = this.f7478a.f7469W;
        if (locationResult == null || locationResult.getLclatlng() == null || str2 == null || obj == null) {
            return;
        }
        SuggestionSearch.C1519b c1519b = new SuggestionSearch.C1519b();
        c1519b.f7504a = str2;
        c1519b.f7505b = obj;
        LcLatlng lclatlng = locationResult.getLclatlng();
        c1519b.f7506c = new LatLng(lclatlng.latitude, lclatlng.longitude);
        SuggestionSearch suggestionSearch = mapManager.f7545m;
        Context context = mapManager.f7535b;
        suggestionSearch.f7501d = c1519b.f7504a;
        suggestionSearch.f7502e = c1519b.f7505b;
        suggestionSearch.f7503f = c1519b.f7506c;
        if (context != null) {
            if (suggestionSearch.f7500c == null) {
                suggestionSearch.f7500c = new SuggestionInterface(context);
            }
            new Thread(new RunnableC1520b(suggestionSearch.f7500c, suggestionSearch.f7503f, suggestionSearch.f7501d, suggestionSearch.f7502e, suggestionSearch.f7499b)).start();
        }
    }
}
