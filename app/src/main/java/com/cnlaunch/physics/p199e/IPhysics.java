package com.cnlaunch.physics.p199e;

import android.content.Context;
import java.io.OutputStream;

/* renamed from: com.cnlaunch.physics.e.c */
/* loaded from: classes.dex */
public interface IPhysics {
    void closeDevice();

    String getCommand();

    boolean getCommand_wait();

    Context getContext();

    String getDeviceName();

    boolean getIsRemoteClientDiagnoseMode();

    boolean getIsSupportOneRequestMoreAnswerDiagnoseMode();

    OutputStream getOutputStream();

    String getSerialNo();

    int getState();

    boolean isTruckReset();

    void physicalCloseDevice();

    void setCommand(String str);

    void setCommand_wait(boolean z);

    void setIsFix(boolean z);

    void setIsTruckReset(boolean z);
}
