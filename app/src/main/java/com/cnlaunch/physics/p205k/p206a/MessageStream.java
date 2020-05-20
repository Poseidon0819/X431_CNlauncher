package com.cnlaunch.physics.p205k.p206a;

import com.cnlaunch.physics.p205k.ByteBufferStream;
import com.cnlaunch.physics.p205k.C1856n;

/* renamed from: com.cnlaunch.physics.k.a.d */
/* loaded from: classes.dex */
public final class MessageStream extends ByteBufferStream {
    @Override // com.cnlaunch.physics.p205k.ByteBufferStream
    /* renamed from: a */
    public final synchronized void mo8192a(byte[] bArr, int i, int i2) {
        super.mo8192a(bArr, i, i2);
    }

    /* renamed from: a */
    public final synchronized RemoteMessage m8210a() {
        RemoteMessage remoteMessage;
        int i;
        this.f10093e = 0;
        remoteMessage = null;
        if (this.f10094f > 6) {
            RemoteMessage remoteMessage2 = new RemoteMessage();
            remoteMessage2.m8208a((byte) m8191b());
            remoteMessage2.m8204b((byte) m8191b());
            int i2 = this.f10093e + 4;
            this.f10093e = i2;
            if (i2 > this.f10094f) {
                this.f10093e = this.f10094f;
                i = -1;
            } else {
                byte[] bArr = this.f10092d;
                int i3 = this.f10093e - 4;
                i = ((bArr[i3 + 3] & 255) << 24) | ((bArr[i3 + 2] & 255) << 16) | (bArr[i3 + 0] & 255) | ((bArr[i3 + 1] & 255) << 8);
            }
            remoteMessage2.m8207a(i);
            if (C1856n.f10135a) {
                C1856n.m8130a("MessageStream", "readMessage()=" + remoteMessage2.m8209a() + " this.length =" + this.f10094f + " this.position =" + this.f10093e);
            }
            if (remoteMessage2.m8209a() <= 0 || remoteMessage2.m8209a() <= this.f10094f - this.f10093e) {
                if (remoteMessage2.m8209a() > 0) {
                    remoteMessage2.m8206a(m8193a(remoteMessage2.m8209a()));
                }
                m8190b(remoteMessage2.m8209a() + 6);
                remoteMessage = remoteMessage2;
            }
        }
        return remoteMessage;
    }
}
