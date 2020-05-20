package com.cnlaunch.physics.p195b.p196a;

import com.cnlaunch.physics.p205k.ByteHexHelper;
import com.cnlaunch.physics.p205k.DPU_Long;
import com.cnlaunch.physics.p205k.DPU_Short;
import com.cnlaunch.physics.p205k.DPU_String;
import java.io.File;
import java.util.Locale;

/* renamed from: com.cnlaunch.physics.b.a.d */
/* loaded from: classes.dex */
public final class DpuOrderUtils {
    /* renamed from: b */
    private static byte[] m8343b(byte[] bArr) {
        int i;
        if (bArr.length > 0) {
            boolean z = true;
            if (((bArr[0] == 85 && bArr[1] == -86) ? false : false) && (i = ((bArr[5] & 255) | ((bArr[4] & 255) << 8)) + 7) < bArr.length) {
                byte[] bArr2 = new byte[i];
                for (int i2 = 0; i2 < i; i2++) {
                    bArr2[i2] = bArr[i2];
                }
                return bArr2;
            }
        }
        return bArr;
    }

    /* renamed from: a */
    public static byte[] m8344a(byte[] bArr) {
        byte[] m8343b = m8343b(bArr);
        int i = 0;
        int length = ((m8343b.length - 2) - 0) + 1;
        byte[] bArr2 = new byte[length];
        int i2 = 0;
        while (i < length) {
            bArr2[i] = m8343b[i2];
            i++;
            i2++;
        }
        return bArr2;
    }

    /* renamed from: a */
    public static byte[] m8345a(String str, File file) {
        if (str == null || file == null) {
            throw new NullPointerException("file name and file obj should not be null!");
        }
        DPU_String dPU_String = new DPU_String(str.toUpperCase(Locale.US));
        return ByteHexHelper.m8178a(DPU_String.m8161a(DPU_String.m8161a(new byte[]{(byte) (dPU_String.f10107c >> 8), (byte) dPU_String.f10107c}, dPU_String.f10108d.getBytes()), "\u0000".getBytes()), new DPU_Long(file.length()).m8163a());
    }

    /* renamed from: a */
    public static byte[] m8346a(int i, byte[] bArr, int i2) {
        return ByteHexHelper.m8178a(ByteHexHelper.m8178a(new DPU_Long(i).m8163a(), new DPU_Short((short) i2).m8162a()), bArr);
    }
}
