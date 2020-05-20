package com.cnlaunch.gmap.map.p150b;

import android.content.Context;
import android.location.LocationManager;
import android.support.p012v4.app.AbstractC0094s;
import com.cnlaunch.gmap.map.p152d.NormalDialog;
import com.cnlaunch.x431pro.widget.p290a.GPSOpenDialog;
import com.ifoer.expedition.pro.R;

/* renamed from: com.cnlaunch.gmap.map.b.o */
/* loaded from: classes.dex */
public final class MapManager extends BaseMapManager {

    /* renamed from: t */
    private NormalDialog f7576t;

    /* renamed from: u */
    private Context f7577u;

    /* renamed from: v */
    private GPSOpenDialog f7578v;

    public MapManager(Context context) {
        super(context);
        this.f7577u = context;
    }

    /* renamed from: b */
    public final void m9291b(AbstractC0094s abstractC0094s) {
        if (!LocationLogic.m9298a(this.f7577u)) {
            m9289d();
        } else if (!m9293a(this.f7577u)) {
            m9290c();
        } else {
            m9316a(abstractC0094s);
        }
    }

    /* renamed from: c */
    private void m9290c() {
        if (this.f7578v == null) {
            this.f7578v = new GPSOpenDialog(this.f7577u);
        }
        this.f7578v.show();
    }

    /* renamed from: a */
    private static boolean m9293a(Context context) {
        LocationManager locationManager = (LocationManager) context.getSystemService("location");
        return locationManager.isProviderEnabled("gps") || locationManager.isProviderEnabled("network");
    }

    /* renamed from: d */
    private void m9289d() {
        if (this.f7576t == null) {
            Context context = this.f7577u;
            this.f7576t = new NormalDialog(context, context.getString(R.string.dialog_google_service_title), this.f7577u.getString(R.string.dialog_google_service_tip), null, this.f7577u.getString(R.string.confirm));
            this.f7576t.f7615a = new C1533p(this);
        }
        this.f7576t.show();
    }
}
