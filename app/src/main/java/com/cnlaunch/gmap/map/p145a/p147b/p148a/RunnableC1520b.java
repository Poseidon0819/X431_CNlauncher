package com.cnlaunch.gmap.map.p145a.p147b.p148a;

import com.cnlaunch.gmap.map.p145a.p147b.SuggestionSearch;
import com.google.android.gms.maps.model.LatLng;

/* compiled from: SuggestionInterface.java */
/* renamed from: com.cnlaunch.gmap.map.a.b.a.b */
/* loaded from: classes.dex */
public final class RunnableC1520b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ LatLng f7509a;

    /* renamed from: b */
    final /* synthetic */ String f7510b;

    /* renamed from: c */
    final /* synthetic */ String f7511c;

    /* renamed from: d */
    final /* synthetic */ SuggestionSearch.InterfaceC1518a f7512d;

    /* renamed from: e */
    final /* synthetic */ SuggestionInterface f7513e;

    public RunnableC1520b(SuggestionInterface suggestionInterface, LatLng latLng, String str, String str2, SuggestionSearch.InterfaceC1518a interfaceC1518a) {
        this.f7513e = suggestionInterface;
        this.f7509a = latLng;
        this.f7510b = str;
        this.f7511c = str2;
        this.f7512d = interfaceC1518a;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (Thread.currentThread().isInterrupted()) {
            return;
        }
        SuggestionInterface.m9320a(this.f7513e, this.f7509a, this.f7510b, this.f7511c, this.f7512d);
    }
}
