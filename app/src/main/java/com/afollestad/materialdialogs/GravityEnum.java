package com.afollestad.materialdialogs;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build;

/* renamed from: com.afollestad.materialdialogs.a */
/* loaded from: classes.dex */
public enum GravityEnum {
    START,
    CENTER,
    END;
    

    /* renamed from: a */
    private static final boolean f3436a;

    static {
        f3436a = Build.VERSION.SDK_INT >= 17;
    }

    @SuppressLint({"RtlHardcoded"})
    public final int getGravityInt() {
        switch (this) {
            case START:
                return f3436a ? 8388611 : 3;
            case CENTER:
                return 1;
            case END:
                return f3436a ? 8388613 : 5;
            default:
                throw new IllegalStateException("Invalid gravity constant");
        }
    }

    @TargetApi(17)
    public final int getTextAlignment() {
        switch (this) {
            case CENTER:
                return 4;
            case END:
                return 6;
            default:
                return 5;
        }
    }
}
