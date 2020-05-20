package com.mopub.mraid;

/* renamed from: com.mopub.mraid.y */
/* loaded from: classes.dex */
enum MraidOrientation {
    PORTRAIT(1),
    LANDSCAPE(0),
    NONE(-1);
    
    private final int mActivityInfoOrientation;

    MraidOrientation(int i) {
        this.mActivityInfoOrientation = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int getActivityInfoOrientation() {
        return this.mActivityInfoOrientation;
    }
}
