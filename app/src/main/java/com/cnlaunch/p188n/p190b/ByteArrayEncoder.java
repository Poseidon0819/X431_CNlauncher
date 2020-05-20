package com.cnlaunch.p188n.p190b;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoderAdapter;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;

/* renamed from: com.cnlaunch.n.b.e */
/* loaded from: classes.dex */
public final class ByteArrayEncoder extends ProtocolEncoderAdapter {
    @Override // org.apache.mina.filter.codec.ProtocolEncoder
    public final void encode(IoSession ioSession, Object obj, ProtocolEncoderOutput protocolEncoderOutput) throws Exception {
        protocolEncoderOutput.write(obj);
        protocolEncoderOutput.flush();
    }
}
