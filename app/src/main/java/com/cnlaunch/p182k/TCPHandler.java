package com.cnlaunch.p182k;

/* renamed from: com.cnlaunch.k.b */
/* loaded from: classes.dex */
public interface TCPHandler {
    void connectClosed();

    void connectFailed();

    void connectSuccess();

    void socketTimeOut();
}
