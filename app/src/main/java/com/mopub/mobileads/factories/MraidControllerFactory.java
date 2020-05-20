package com.mopub.mobileads.factories;

import android.content.Context;
import com.mopub.common.AdReport;
import com.mopub.common.VisibleForTesting;
import com.mopub.mraid.MraidController;
import com.mopub.mraid.PlacementType;

/* loaded from: classes.dex */
public class MraidControllerFactory {

    /* renamed from: a */
    protected static MraidControllerFactory f20591a = new MraidControllerFactory();

    @VisibleForTesting
    public static void setInstance(MraidControllerFactory mraidControllerFactory) {
        f20591a = mraidControllerFactory;
    }

    public static MraidController create(Context context, AdReport adReport, PlacementType placementType) {
        return new MraidController(context, adReport, placementType);
    }
}
