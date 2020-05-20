package com.mopub.mraid;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MraidJavascriptCommand.java */
/* renamed from: com.mopub.mraid.q */
/* loaded from: classes.dex */
public enum C3830q extends MraidJavascriptCommand {
    /* JADX INFO: Access modifiers changed from: package-private */
    public C3830q(String str, int i, String str2) {
        super(str, i, str2, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.mopub.mraid.MraidJavascriptCommand
    public final boolean requiresClick(PlacementType placementType) {
        return placementType == PlacementType.INLINE;
    }
}
