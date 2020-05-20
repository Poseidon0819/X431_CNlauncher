package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapsdkplatform.comapi.map.EnumC1214h;
import com.itextpdf.text.html.HtmlTags;
import com.mopub.mobileads.VastExtensionXmlManager;
import java.util.List;

/* loaded from: classes.dex */
public abstract class Overlay {
    protected InterfaceC1076a listener;
    public EnumC1214h type;

    /* renamed from: v */
    String f5201v = System.currentTimeMillis() + "_" + hashCode();

    /* renamed from: w */
    int f5202w;

    /* renamed from: x */
    boolean f5203x;

    /* renamed from: y */
    Bundle f5204y;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.mapapi.map.Overlay$a */
    /* loaded from: classes.dex */
    public interface InterfaceC1076a {
        /* renamed from: a */
        void mo11152a(Overlay overlay);

        /* renamed from: b */
        void mo11151b(Overlay overlay);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m11154a(int i, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putFloat("red", ((i >> 16) & 255) / 255.0f);
        bundle2.putFloat("green", ((i >> 8) & 255) / 255.0f);
        bundle2.putFloat("blue", (i & 255) / 255.0f);
        bundle2.putFloat("alpha", (i >>> 24) / 255.0f);
        bundle.putBundle(HtmlTags.COLOR, bundle2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m11153a(List<LatLng> list, Bundle bundle) {
        int size = list.size();
        double[] dArr = new double[size];
        double[] dArr2 = new double[size];
        for (int i = 0; i < size; i++) {
            GeoPoint ll2mc = CoordUtil.ll2mc(list.get(i));
            dArr[i] = ll2mc.getLongitudeE6();
            dArr2[i] = ll2mc.getLatitudeE6();
        }
        bundle.putDoubleArray("x_array", dArr);
        bundle.putDoubleArray("y_array", dArr2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public Bundle mo11139a() {
        Bundle bundle = new Bundle();
        bundle.putString("id", this.f5201v);
        bundle.putInt(VastExtensionXmlManager.TYPE, this.type.ordinal());
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public Bundle mo11138a(Bundle bundle) {
        bundle.putString("id", this.f5201v);
        bundle.putInt(VastExtensionXmlManager.TYPE, this.type.ordinal());
        bundle.putInt("visibility", this.f5203x ? 1 : 0);
        bundle.putInt("z_index", this.f5202w);
        return bundle;
    }

    public Bundle getExtraInfo() {
        return this.f5204y;
    }

    public int getZIndex() {
        return this.f5202w;
    }

    public boolean isVisible() {
        return this.f5203x;
    }

    public void remove() {
        this.listener.mo11152a(this);
    }

    public void setExtraInfo(Bundle bundle) {
        this.f5204y = bundle;
    }

    public void setVisible(boolean z) {
        this.f5203x = z;
        this.listener.mo11151b(this);
    }

    public void setZIndex(int i) {
        this.f5202w = i;
        this.listener.mo11151b(this);
    }
}
