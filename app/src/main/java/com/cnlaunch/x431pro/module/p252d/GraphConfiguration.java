package com.cnlaunch.x431pro.module.p252d;

import android.graphics.Color;
import org.codehaus.jackson.org.objectweb.asm.Opcodes;

/* renamed from: com.cnlaunch.x431pro.module.d.a */
/* loaded from: classes.dex */
public final class GraphConfiguration {

    /* renamed from: a */
    private static int f15530a = 1440;

    /* renamed from: b */
    private static final int[] f15531b = {Color.argb(255, 76, 141, (int) Opcodes.FRETURN), Color.argb(255, 114, 94, 130), Color.argb(255, 59, (int) Opcodes.GETFIELD, 248), Color.argb(255, 240, 212, 58), Color.argb(255, 44, 128, 209), Color.argb(255, (int) Opcodes.JSR, 132, 98), Color.argb(255, 42, (int) Opcodes.IF_ICMPEQ, 132), Color.argb(255, 90, 204, 64), Color.argb(255, 245, 139, 0), Color.argb(255, 242, 53, 87), Color.argb(255, 5, 119, 72), Color.argb(255, 98, 81, 218), Color.argb(255, (int) Opcodes.ARETURN, 28, 50), Color.argb(255, 141, 75, (int) Opcodes.NEW), Color.argb(255, 254, 67, 0)};

    /* renamed from: a */
    public static int m5385a() {
        return Opcodes.GETFIELD;
    }

    /* renamed from: a */
    public static int m5384a(int i) {
        int[] iArr = f15531b;
        if (i < iArr.length) {
            return iArr[i];
        }
        return Color.argb(255, 0, 0, 0);
    }

    /* renamed from: b */
    public static int m5383b() {
        return f15530a;
    }
}
