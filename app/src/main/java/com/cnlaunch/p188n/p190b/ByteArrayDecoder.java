package com.cnlaunch.p188n.p190b;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolDecoderAdapter;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;

/* renamed from: com.cnlaunch.n.b.d */
/* loaded from: classes.dex */
public final class ByteArrayDecoder extends ProtocolDecoderAdapter {
    @Override // org.apache.mina.filter.codec.ProtocolDecoder
    public final void decode(IoSession ioSession, IoBuffer ioBuffer, ProtocolDecoderOutput protocolDecoderOutput) throws Exception {
        byte[] bArr = new byte[ioBuffer.limit()];
        ioBuffer.get(bArr);
        protocolDecoderOutput.write(bArr);
    }
}
