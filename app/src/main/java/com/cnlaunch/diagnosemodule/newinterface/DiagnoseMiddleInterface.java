package com.cnlaunch.diagnosemodule.newinterface;

import java.util.List;

/* loaded from: classes.dex */
public class DiagnoseMiddleInterface {
    public static boolean getConnectorReady() {
        return DiagnoseDataSrc.getInstance(null).getConnectorReady();
    }

    public static void notifyConnector(int i) {
        DiagnoseDataSrc.getInstance(null).notifyConnector(i);
    }

    public static int getConnectorLinkMode() {
        return DiagnoseDataSrc.getInstance(null).getConnectorLinkMode();
    }

    public static byte[] stdCallApk(byte[] bArr) {
        return DiagnoseDataSrc.getInstance(null).stdCallApk(bArr);
    }

    public static int showView(int i, byte[] bArr) {
        return DiagnoseDataSrc.getInstance(null).showView(i, bArr);
    }

    public static String showInputBox(byte[] bArr) {
        return DiagnoseDataSrc.getInstance(null).showInputBox(bArr);
    }

    public static List<Integer> getDataVisibleRows() {
        return DiagnoseDataSrc.getInstance(null).getDataVisibleRows();
    }

    public static int removeMessageBox() {
        return DiagnoseDataSrc.getInstance(null).removeMessageBox();
    }

    public static byte[] sendReceiveOnly(byte[] bArr, int i) {
        return DiagnoseDataSrc.getInstance(null).sendReceiveOnly(bArr, i);
    }

    public static byte[] sendReceive(byte[] bArr, int i) {
        return DiagnoseDataSrc.getInstance(null).sendReceive(bArr, i);
    }

    public static byte[] comReceive(int i) {
        return DiagnoseDataSrc.getInstance(null).comReceive(i);
    }

    public static int appendLog(String str) {
        return DiagnoseDataSrc.getInstance(null).appendLog(str);
    }

    public static int onDiagExit() {
        return DiagnoseDataSrc.getInstance(null).onDiagExit();
    }

    public static int openDbase(String str, String str2) {
        return DiagnoseDataSrc.getInstance(null).openDbase(str, str2);
    }

    public static int closeDbase(String str) {
        return DiagnoseDataSrc.getInstance(null).closeDbase(str);
    }

    public static String[] searchTextById(String str, String str2, long j, int i) {
        return DiagnoseDataSrc.getInstance(null).searchTextById(str, str2, j, i);
    }
}
