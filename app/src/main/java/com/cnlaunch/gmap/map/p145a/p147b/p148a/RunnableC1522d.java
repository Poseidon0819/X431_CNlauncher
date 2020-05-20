package com.cnlaunch.gmap.map.p145a.p147b.p148a;

import com.cnlaunch.gmap.map.p145a.p147b.SuggestionSearch;
import com.cnlaunch.gmap.map.p145a.p147b.p149b.SuggestionResult;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SuggestionInterface.java */
/* renamed from: com.cnlaunch.gmap.map.a.b.a.d */
/* loaded from: classes.dex */
public final class RunnableC1522d implements Runnable {

    /* renamed from: a */
    final /* synthetic */ SuggestionSearch.InterfaceC1518a f7517a;

    /* renamed from: b */
    final /* synthetic */ SuggestionResult f7518b;

    /* renamed from: c */
    final /* synthetic */ SuggestionInterface f7519c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1522d(SuggestionInterface suggestionInterface, SuggestionSearch.InterfaceC1518a interfaceC1518a, SuggestionResult suggestionResult) {
        this.f7519c = suggestionInterface;
        this.f7517a = interfaceC1518a;
        this.f7518b = suggestionResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SuggestionSearch.InterfaceC1518a interfaceC1518a = this.f7517a;
        if (interfaceC1518a != null) {
            interfaceC1518a.mo9314a(this.f7518b);
        }
    }
}
