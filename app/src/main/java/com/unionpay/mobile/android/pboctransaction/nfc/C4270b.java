package com.unionpay.mobile.android.pboctransaction.nfc;

import android.nfc.tech.IsoDep;
import android.util.Log;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

/* renamed from: com.unionpay.mobile.android.pboctransaction.nfc.b */
/* loaded from: classes2.dex */
public class C4270b {

    /* renamed from: a */
    public static final byte[] f22754a = {0};

    /* renamed from: b */
    protected byte[] f22755b;

    /* renamed from: com.unionpay.mobile.android.pboctransaction.nfc.b$a */
    /* loaded from: classes2.dex */
    public static final class C4271a extends C4270b {

        /* renamed from: c */
        public static final byte[] f22756c = new byte[0];

        /* renamed from: d */
        public static final byte[] f22757d = {111, 0};

        public C4271a(byte[] bArr) {
            super((bArr == null || bArr.length < 2) ? f22757d : bArr);
        }

        @Override // com.unionpay.mobile.android.pboctransaction.nfc.C4270b
        /* renamed from: a */
        public final byte[] mo1286a() {
            return m1285b() ? Arrays.copyOfRange(this.f22755b, 0, this.f22755b.length - 2) : f22756c;
        }

        /* renamed from: b */
        public final boolean m1285b() {
            byte[] bArr = this.f22755b;
            int length = bArr.length;
            return ((short) ((bArr[length - 1] & 255) | (bArr[length + (-2)] << 8))) == -28672;
        }
    }

    /* renamed from: com.unionpay.mobile.android.pboctransaction.nfc.b$b */
    /* loaded from: classes2.dex */
    public static final class C4272b {

        /* renamed from: a */
        private final IsoDep f22758a;

        public C4272b(IsoDep isoDep) {
            this.f22758a = isoDep;
        }

        /* renamed from: c */
        public static String m1281c(byte[] bArr) {
            String str = "";
            for (byte b : bArr) {
                String hexString = Integer.toHexString(b & 255);
                if (hexString.length() == 1) {
                    hexString = "0".concat(String.valueOf(hexString));
                }
                str = str + hexString.toUpperCase() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
            }
            return str;
        }

        /* renamed from: a */
        public final C4271a m1283a(byte... bArr) {
            ByteBuffer allocate = ByteBuffer.allocate(bArr.length + 6);
            allocate.put((byte) 0).put((byte) -92).put((byte) 4).put((byte) 0).put((byte) bArr.length).put(bArr).put((byte) 0);
            Log.e("PBOC Transceive", m1281c(allocate.array()));
            C4271a c4271a = new C4271a(m1282b(allocate.array()));
            Log.e("PBOC receive", m1281c(c4271a.mo1286a()));
            return c4271a;
        }

        /* renamed from: a */
        public final void m1284a() {
            try {
                this.f22758a.connect();
            } catch (Exception unused) {
            }
        }

        /* renamed from: b */
        public final byte[] m1282b(byte[] bArr) {
            try {
                return this.f22758a.transceive(bArr);
            } catch (Exception unused) {
                return C4271a.f22757d;
            }
        }
    }

    protected C4270b(byte[] bArr) {
        this.f22755b = bArr == null ? f22754a : bArr;
    }

    /* renamed from: a */
    public byte[] mo1286a() {
        return this.f22755b;
    }

    public String toString() {
        byte[] bArr = this.f22755b;
        return C4273c.m1280a(bArr, bArr.length);
    }
}
