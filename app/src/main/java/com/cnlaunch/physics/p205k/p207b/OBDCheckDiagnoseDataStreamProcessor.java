package com.cnlaunch.physics.p205k.p207b;

import com.cnlaunch.physics.p199e.IPhysics;
import com.cnlaunch.physics.p205k.ByteHexHelper;
import com.cnlaunch.physics.p205k.C1856n;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.cnlaunch.physics.k.b.b */
/* loaded from: classes.dex */
public class OBDCheckDiagnoseDataStreamProcessor extends CommonDiagnoseDataStreamProcessor {

    /* renamed from: r */
    private static final String f10073r = "b";

    public OBDCheckDiagnoseDataStreamProcessor(ReadByteDataStream readByteDataStream, IPhysics iPhysics, InputStream inputStream, OutputStream outputStream) {
        super(readByteDataStream, iPhysics, inputStream, outputStream);
    }

    @Override // com.cnlaunch.physics.p205k.p207b.CommonDiagnoseDataStreamProcessor
    /* renamed from: c */
    protected final void mo8197c() {
        if (this.f10072q + this.f10071p.f10075a <= this.f10071p.f10079e) {
            System.arraycopy(this.f10071p.f10077c, 0, this.f10071p.f10078d, this.f10072q, this.f10071p.f10075a);
            return;
        }
        if (C1856n.f10135a) {
            String str = f10073r;
            C1856n.m8130a(str, "allocation totalBuffer totalBytes=" + (this.f10072q + this.f10071p.f10075a));
        }
        byte[] bArr = this.f10071p.f10078d;
        this.f10071p.f10078d = new byte[this.f10072q + this.f10071p.f10075a];
        System.arraycopy(bArr, 0, this.f10071p.f10078d, 0, this.f10072q);
        System.arraycopy(this.f10071p.f10077c, 0, this.f10071p.f10078d, this.f10072q, this.f10071p.f10075a);
    }

    @Override // com.cnlaunch.physics.p205k.p207b.CommonDiagnoseDataStreamProcessor
    /* renamed from: e */
    protected final void mo8196e() {
        int i;
        int i2;
        if (C1856n.f10135a) {
            C1856n.m8130a(f10073r, "OBDCheckDiagnoseDataStreamProcessor  carOrCarAndHeavydutyDataProcess()");
        }
        this.f10070o = false;
        while (true) {
            int m8177a = ByteHexHelper.m8177a(this.f10071p.f10078d, this.f10061f, 0, this.f10072q);
            if (C1856n.f10135a) {
                C1856n.m8130a(f10073r, "totalBuffer totalBytes=" + this.f10072q + " index =" + m8177a);
            }
            if (m8177a >= 0) {
                this.f10070o = true;
            } else {
                m8177a = ByteHexHelper.m8177a(this.f10071p.f10078d, this.f10062g, 0, this.f10072q);
                if (m8177a >= 0) {
                    this.f10070o = true;
                }
            }
            if (!this.f10070o) {
                return;
            }
            if (m8177a > 0) {
                int i3 = this.f10072q - m8177a;
                System.arraycopy(this.f10071p.f10078d, m8177a, this.f10071p.f10078d, 0, i3);
                this.f10072q = i3;
            }
            if (this.f10072q < 6 || this.f10072q < (i = ((this.f10071p.f10078d[4] & 255) * 256) + (this.f10071p.f10078d[5] & 255) + 7)) {
                return;
            }
            byte b = this.f10071p.f10078d[2];
            int i4 = 3;
            while (true) {
                i2 = i - 1;
                if (i4 >= i2) {
                    break;
                }
                b = (byte) (b ^ this.f10071p.f10078d[i4]);
                i4++;
            }
            if (b == this.f10071p.f10078d[i2]) {
                String m8179a = ByteHexHelper.m8179a(this.f10071p.f10078d, i);
                this.f10056a.setCommand(m8179a);
                if (C1856n.f10135a) {
                    C1856n.m8127b(f10073r, "valid command=".concat(String.valueOf(m8179a)));
                }
                this.f10056a.setCommand_wait(false);
            }
            this.f10072q -= i;
            if (this.f10072q <= 0) {
                return;
            }
            System.arraycopy(this.f10071p.f10078d, i, this.f10071p.f10078d, 0, this.f10072q);
        }
    }
}
