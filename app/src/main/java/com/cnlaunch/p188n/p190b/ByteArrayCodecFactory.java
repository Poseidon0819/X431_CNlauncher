package com.cnlaunch.p188n.p190b;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;

/* renamed from: com.cnlaunch.n.b.c */
/* loaded from: classes.dex */
public final class ByteArrayCodecFactory implements ProtocolCodecFactory {

    /* renamed from: b */
    private ByteArrayEncoder f9580b = new ByteArrayEncoder();

    /* renamed from: a */
    private ByteArrayDecoder f9579a = new ByteArrayDecoder();

    @Override // org.apache.mina.filter.codec.ProtocolCodecFactory
    public final ProtocolDecoder getDecoder(IoSession ioSession) throws Exception {
        return this.f9579a;
    }

    @Override // org.apache.mina.filter.codec.ProtocolCodecFactory
    public final ProtocolEncoder getEncoder(IoSession ioSession) throws Exception {
        return this.f9580b;
    }
}
