package com.cnlaunch.diagnosemodule.newinterface;

import java.util.List;

/* loaded from: classes.dex */
public interface ApkInterface {
    int appendLog(String str);

    int closeDbase(String str);

    byte[] comReceive(int i);

    int getConnectorLinkMode();

    boolean getConnectorReady();

    List<Integer> getDataVisibleRows();

    void notifyConnector(int i);

    int onDiagExit();

    int openDbase(String str, String str2);

    int removeMessageBox();

    String[] searchTextById(String str, String str2, long j, int i);

    byte[] sendReceive(byte[] bArr, int i);

    byte[] sendReceiveOnly(byte[] bArr, int i);

    String showInputBox(byte[] bArr);

    int showView(int i, byte[] bArr);

    byte[] stdCallApk(byte[] bArr);
}
