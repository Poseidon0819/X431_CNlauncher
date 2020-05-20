package com.mopub.mobileads;

import android.os.Handler;
import com.mopub.common.Preconditions;
import com.mopub.network.TrackingRequest;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class VastVideoViewProgressRunnable extends RepeatingHandlerRunnable {

    /* renamed from: c */
    private final VastVideoViewController f20485c;

    /* renamed from: d */
    private final VastVideoConfig f20486d;

    public VastVideoViewProgressRunnable(VastVideoViewController vastVideoViewController, VastVideoConfig vastVideoConfig, Handler handler) {
        super(handler);
        Preconditions.checkNotNull(vastVideoViewController);
        Preconditions.checkNotNull(vastVideoConfig);
        this.f20485c = vastVideoViewController;
        this.f20486d = vastVideoConfig;
    }

    @Override // com.mopub.mobileads.RepeatingHandlerRunnable
    public void doWork() {
        int duration = this.f20485c.f20457a.getDuration();
        int currentPosition = this.f20485c.f20457a.getCurrentPosition();
        VastVideoViewController vastVideoViewController = this.f20485c;
        vastVideoViewController.f20458b.updateProgress(vastVideoViewController.f20457a.getCurrentPosition());
        if (duration > 0) {
            List<VastTracker> untriggeredTrackersBefore = this.f20486d.getUntriggeredTrackersBefore(currentPosition, duration);
            if (!untriggeredTrackersBefore.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (VastTracker vastTracker : untriggeredTrackersBefore) {
                    arrayList.add(vastTracker.getTrackingUrl());
                    vastTracker.setTracked();
                }
                TrackingRequest.makeTrackingHttpRequest(new VastMacroHelper(arrayList).withAssetUri(this.f20485c.m2360b()).withContentPlayHead(Integer.valueOf(currentPosition)).getUris(), this.f20485c.mContext);
            }
            VastVideoViewController vastVideoViewController2 = this.f20485c;
            if (vastVideoViewController2.f20460d == null || currentPosition < vastVideoViewController2.f20460d.getOffsetMS()) {
                return;
            }
            vastVideoViewController2.f20462f.setVisibility(0);
            vastVideoViewController2.f20460d.handleImpression(vastVideoViewController2.mContext, currentPosition, vastVideoViewController2.m2360b());
            if (vastVideoViewController2.f20460d.getDurationMS() == null || currentPosition < vastVideoViewController2.f20460d.getOffsetMS() + vastVideoViewController2.f20460d.getDurationMS().intValue()) {
                return;
            }
            vastVideoViewController2.f20462f.setVisibility(8);
        }
    }
}
