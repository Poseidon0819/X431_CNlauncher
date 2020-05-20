package com.mopub.nativeads;

import android.view.View;
import com.mopub.nativeads.VisibilityTracker;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ImpressionTracker.java */
/* renamed from: com.mopub.nativeads.d */
/* loaded from: classes2.dex */
public final class C3886d implements VisibilityTracker.InterfaceC3884d {

    /* renamed from: a */
    final /* synthetic */ ImpressionTracker f21140a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3886d(ImpressionTracker impressionTracker) {
        this.f21140a = impressionTracker;
    }

    @Override // com.mopub.nativeads.VisibilityTracker.InterfaceC3884d
    public final void onVisibilityChanged(List<View> list, List<View> list2) {
        Map map;
        for (View view : list) {
            map = this.f21140a.f20770b;
            ImpressionInterface impressionInterface = (ImpressionInterface) map.get(view);
            if (impressionInterface != null) {
                TimestampWrapper timestampWrapper = (TimestampWrapper) this.f21140a.f20771c.get(view);
                if (timestampWrapper == null || !impressionInterface.equals(timestampWrapper.f21119a)) {
                    this.f21140a.f20771c.put(view, new TimestampWrapper(impressionInterface));
                }
            } else {
                this.f21140a.removeView(view);
            }
        }
        for (View view2 : list2) {
            this.f21140a.f20771c.remove(view2);
        }
        this.f21140a.m2195a();
    }
}
