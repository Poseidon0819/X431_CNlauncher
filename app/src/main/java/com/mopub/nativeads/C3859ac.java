package com.mopub.nativeads;

import com.itextpdf.text.pdf.PdfContentParser;
import com.mopub.common.logging.MoPubLog;
import com.mopub.nativeads.MoPubNativeAdPositioning;
import com.mopub.nativeads.PositioningSource;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MoPubStreamAdPlacer.java */
/* renamed from: com.mopub.nativeads.ac */
/* loaded from: classes2.dex */
public final class C3859ac implements PositioningSource.PositioningListener {

    /* renamed from: a */
    final /* synthetic */ MoPubStreamAdPlacer f21045a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3859ac(MoPubStreamAdPlacer moPubStreamAdPlacer) {
        this.f21045a = moPubStreamAdPlacer;
    }

    @Override // com.mopub.nativeads.PositioningSource.PositioningListener
    public final void onLoad(MoPubNativeAdPositioning.MoPubClientPositioning moPubClientPositioning) {
        MoPubStreamAdPlacer moPubStreamAdPlacer = this.f21045a;
        ArrayList<Integer> arrayList = moPubClientPositioning.f20876a;
        int i = moPubClientPositioning.f20877b;
        int size = i == Integer.MAX_VALUE ? arrayList.size() : PdfContentParser.COMMAND_TYPE;
        int[] iArr = new int[size];
        int i2 = 0;
        int i3 = 0;
        for (Integer num : arrayList) {
            i3 = num.intValue() - i2;
            iArr[i2] = i3;
            i2++;
        }
        while (i2 < size) {
            i3 = (i3 + i) - 1;
            iArr[i2] = i3;
            i2++;
        }
        PlacementData placementData = new PlacementData(iArr);
        if (moPubStreamAdPlacer.f20892c) {
            moPubStreamAdPlacer.m2130a(placementData);
        } else {
            moPubStreamAdPlacer.f20891b = placementData;
        }
        moPubStreamAdPlacer.f20890a = true;
    }

    @Override // com.mopub.nativeads.PositioningSource.PositioningListener
    public final void onFailed() {
        MoPubLog.m2498d("Unable to show ads because ad positions could not be loaded from the MoPub ad server.");
    }
}
