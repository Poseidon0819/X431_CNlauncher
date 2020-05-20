package com.cnlaunch.x431pro.activity.login;

import android.widget.ImageView;
import android.widget.TextView;
import com.cnlaunch.gmap.map.logic.p153a.LocationResult;
import com.cnlaunch.gmap.map.p145a.p146a.LocationSearch;
import com.cnlaunch.gmap.p138a.FinalBitmap;

/* compiled from: RegistMerchantActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.login.bl */
/* loaded from: classes.dex */
final class C2340bl implements LocationSearch.InterfaceC1517a {

    /* renamed from: a */
    final /* synthetic */ C2339bk f13447a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2340bl(C2339bk c2339bk) {
        this.f13447a = c2339bk;
    }

    @Override // com.cnlaunch.gmap.map.p145a.p146a.LocationSearch.InterfaceC1517a
    /* renamed from: a */
    public final void mo6551a(LocationResult locationResult) {
        TextView textView;
        TextView textView2;
        LocationResult locationResult2;
        LocationResult locationResult3;
        LocationResult locationResult4;
        FinalBitmap finalBitmap;
        ImageView imageView;
        if (this.f13447a.f13446a.isFinishing() || locationResult == null) {
            return;
        }
        this.f13447a.f13446a.f13301aa = locationResult;
        textView = this.f13447a.f13446a.f13297W;
        textView.setText(locationResult.getAddress());
        textView2 = this.f13447a.f13446a.f13296V;
        locationResult2 = this.f13447a.f13446a.f13301aa;
        textView2.setText(locationResult2.getAddress());
        locationResult3 = this.f13447a.f13446a.f13301aa;
        double latitude = locationResult3.getLclatlng().getLatitude();
        locationResult4 = this.f13447a.f13446a.f13301aa;
        double longitude = locationResult4.getLclatlng().getLongitude();
        this.f13447a.f13446a.f13291Q = String.valueOf(longitude);
        this.f13447a.f13446a.f13292R = String.valueOf(latitude);
        finalBitmap = this.f13447a.f13446a.f13303ac;
        imageView = this.f13447a.f13446a.f13300Z;
        finalBitmap.m9409a(imageView, "http://maps.google.com/maps/api/staticmap?zoom=10&size=360x160&scale=2&markers=icon:http://file.us.api.dbscar.com/face/def/shop%7C" + latitude + "," + longitude);
    }
}
