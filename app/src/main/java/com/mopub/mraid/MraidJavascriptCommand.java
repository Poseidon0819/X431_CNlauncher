package com.mopub.mraid;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public class MraidJavascriptCommand {
    private final String mJavascriptString;
    public static final MraidJavascriptCommand CLOSE = new MraidJavascriptCommand("CLOSE", 0, "close");
    public static final MraidJavascriptCommand EXPAND = new C3830q("EXPAND", 1, "expand");
    public static final MraidJavascriptCommand USE_CUSTOM_CLOSE = new MraidJavascriptCommand("USE_CUSTOM_CLOSE", 2, "usecustomclose");
    public static final MraidJavascriptCommand OPEN = new MraidJavascriptCommand("OPEN", 3, "open") { // from class: com.mopub.mraid.r
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.mopub.mraid.MraidJavascriptCommand
        public final boolean requiresClick(PlacementType placementType) {
            return true;
        }
    };
    public static final MraidJavascriptCommand RESIZE = new MraidJavascriptCommand("RESIZE", 4, "resize") { // from class: com.mopub.mraid.s
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.mopub.mraid.MraidJavascriptCommand
        public final boolean requiresClick(PlacementType placementType) {
            return true;
        }
    };
    public static final MraidJavascriptCommand SET_ORIENTATION_PROPERTIES = new MraidJavascriptCommand("SET_ORIENTATION_PROPERTIES", 5, "setOrientationProperties");
    public static final MraidJavascriptCommand PLAY_VIDEO = new MraidJavascriptCommand("PLAY_VIDEO", 6, "playVideo") { // from class: com.mopub.mraid.t
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.mopub.mraid.MraidJavascriptCommand
        public final boolean requiresClick(PlacementType placementType) {
            return placementType == PlacementType.INLINE;
        }
    };
    public static final MraidJavascriptCommand STORE_PICTURE = new MraidJavascriptCommand("STORE_PICTURE", 7, "storePicture") { // from class: com.mopub.mraid.u
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.mopub.mraid.MraidJavascriptCommand
        public final boolean requiresClick(PlacementType placementType) {
            return true;
        }
    };
    public static final MraidJavascriptCommand CREATE_CALENDAR_EVENT = new MraidJavascriptCommand("CREATE_CALENDAR_EVENT", 8, "createCalendarEvent") { // from class: com.mopub.mraid.v
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.mopub.mraid.MraidJavascriptCommand
        public final boolean requiresClick(PlacementType placementType) {
            return true;
        }
    };
    public static final MraidJavascriptCommand UNSPECIFIED = new MraidJavascriptCommand("UNSPECIFIED", 9, "");

    /* renamed from: a */
    private static final /* synthetic */ MraidJavascriptCommand[] f20693a = {CLOSE, EXPAND, USE_CUSTOM_CLOSE, OPEN, RESIZE, SET_ORIENTATION_PROPERTIES, PLAY_VIDEO, STORE_PICTURE, CREATE_CALENDAR_EVENT, UNSPECIFIED};

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean requiresClick(PlacementType placementType) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ MraidJavascriptCommand(String str, int i, String str2, C3830q c3830q) {
        this(str, i, str2);
    }

    public static MraidJavascriptCommand valueOf(String str) {
        return (MraidJavascriptCommand) Enum.valueOf(MraidJavascriptCommand.class, str);
    }

    public static MraidJavascriptCommand[] values() {
        return (MraidJavascriptCommand[]) f20693a.clone();
    }

    private MraidJavascriptCommand(String str, int i, String str2) {
        this.mJavascriptString = str2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MraidJavascriptCommand fromJavascriptString(String str) {
        MraidJavascriptCommand[] values;
        for (MraidJavascriptCommand mraidJavascriptCommand : values()) {
            if (mraidJavascriptCommand.mJavascriptString.equals(str)) {
                return mraidJavascriptCommand;
            }
        }
        return UNSPECIFIED;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String toJavascriptString() {
        return this.mJavascriptString;
    }
}
