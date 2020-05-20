package com.cnlaunch.physics.p200f;

import com.cnlaunch.physics.IPhysicsOutputStreamBufferWrapper;
import java.io.OutputStream;

/* renamed from: com.cnlaunch.physics.f.b */
/* loaded from: classes.dex */
public abstract class AbstractPhysicsOutputStream extends OutputStream {

    /* renamed from: d */
    protected IPhysicsOutputStreamBufferWrapper f9928d;

    public AbstractPhysicsOutputStream(IPhysicsOutputStreamBufferWrapper iPhysicsOutputStreamBufferWrapper) {
        this.f9928d = iPhysicsOutputStreamBufferWrapper;
    }
}
