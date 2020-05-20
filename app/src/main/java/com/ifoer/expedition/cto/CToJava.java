package com.ifoer.expedition.cto;

import android.content.Context;
import android.os.Messenger;
import com.cnlaunch.diagnosemodule.DiagnoseBusiness;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.p120d.p130d.SystemPropertiesInvoke;
import com.cnlaunch.physics.p205k.Tools;
import com.ifoer.expedition.ndk.StdJni;
import java.net.SocketException;

/* loaded from: classes.dex */
public class CToJava {
    private static CToJava instance = null;
    private static CToJavaImplementsExtends mCToJavaImplementsExtends = null;
    private static Context mContext = null;
    private static DiagnoseBusiness mDiag = null;
    private static boolean mIsHeavy = false;
    private static Messenger mMessenger;
    private static StdJni stdJni;

    public CToJava(Context context, Messenger messenger) {
        mContext = context;
        mMessenger = messenger;
        stdJni = new StdJni();
        mDiag = DiagnoseBusiness.getInstance(mContext);
        mIsHeavy = Tools.m8112a(mContext, DiagnoseConstants.DEVICE_SERIALNO);
        if (Tools.m8095d(mContext, DiagnoseConstants.DEVICE_SERIALNO)) {
            mCToJavaImplementsExtends = new CToJavaImplementsExtendsForEasyDiag30Logic();
        } else if (Tools.m8105a(DiagnoseConstants.DEVICE_SERIALNO)) {
            mCToJavaImplementsExtends = new CToJavaImplementsExtendsForEasyDiag40Logic();
        } else {
            mCToJavaImplementsExtends = new CToJavaImplementsExtendsForDefaultLogic();
        }
    }

    public static void setVehicleSdPath(String str) {
        CToJavaImplements.setVehicleSdPath(str);
    }

    public static String getVehicleSdPath() {
        return CToJavaImplements.getVehicleSdPath();
    }

    static int GetNetWorkType() {
        return CToJavaImplements.GetNetWorkType(mContext);
    }

    static String GetEthernetIp() {
        try {
            return CToJavaImplements.GetEthernetIp(mContext);
        } catch (SocketException e) {
            e.printStackTrace();
            return "";
        }
    }

    static String getAvailableExternalStorage() {
        return CToJavaImplements.getAvailableExternalStorage(mContext);
    }

    static boolean IsSetEthNetAttrSuccess() {
        return CToJavaImplements.IsSetEthNetAttrSuccess();
    }

    static void UnBindEthService() {
        CToJavaImplements.UnBindEthService(mContext);
    }

    static void SetEthNetAttr(String str, String str2, String str3) {
        CToJavaImplements.SetMessageInfo(mMessenger);
        CToJavaImplements.SetEthNetAttr(mContext, str, str2, str3);
    }

    static void SetEthNetState(boolean z) {
        CToJavaImplements.SetMessageInfo(mMessenger);
        CToJavaImplements.SetEthNetState(mContext, z);
    }

    static void SetWifiState(boolean z) {
        CToJavaImplements.SetMessageInfo(mMessenger);
        CToJavaImplements.SetWifiState(mContext, z);
    }

    static boolean GetWifiState() {
        return CToJavaImplements.GetWifiState(mContext);
    }

    static int OpenTcpConnect(String str, int i) {
        return CToJavaImplements.OpenTcpConnect(str, i);
    }

    static int CloseTcpConnect() {
        return CToJavaImplements.CloseTcpConnect();
    }

    static int SendDataByTcp(byte[] bArr, int i) {
        return CToJavaImplements.SendDataByTcp(bArr, i);
    }

    static byte[] ReceiveDataByTcp(byte[] bArr, int i, int i2) {
        return CToJavaImplements.ReceiveDataByTcp(bArr, i, i2);
    }

    static byte[] SendAndReceiveUdpData(byte[] bArr, int i, int i2) {
        String str = "";
        if (Tools.m8094e(mContext, DiagnoseConstants.DEVICE_SERIALNO)) {
            str = "192.168.100.255";
        } else if (SystemPropertiesInvoke.m9431a("ro.support_lan_dhcp")) {
            str = "192.168.25.255";
        }
        return CToJavaImplements.SendAndReceiveUdpData(bArr, i, i2, str);
    }

    static byte[] ReceiveUdpData(int i, int i2) {
        return CToJavaImplements.ReceiveUdpData(i, i2);
    }

    static String GetServerIP() {
        return CToJavaImplements.GetServerIP();
    }

    static int GetServerPort() {
        return CToJavaImplements.GetServerPort();
    }

    static void NotifyNotQuitCar(boolean z) {
        CToJavaImplements.NotifyNotQuitCar(z, mContext);
    }

    public static String GetAppVehicleVersionPath() {
        return CToJavaImplements.GetAppVehicleVersionPath();
    }

    public static int GetConnectorLinkMode() {
        return CToJavaImplements.GetConnectorLinkMode(mContext);
    }

    public static boolean GetConnectorReady() {
        return CToJavaImplements.GetConnectorReady(mContext);
    }

    public static void NotifyConnector(int i) {
        CToJavaImplements.NotifyConnector(i, mContext);
    }

    public static void init(Context context, Messenger messenger) {
        if (instance == null) {
            instance = new CToJava(context, messenger);
        }
    }

    public static byte[] getProtData(byte[] bArr) {
        return CToJavaImplements.getProtData(bArr, mDiag, mContext, false);
    }

    public static void Write(byte[] bArr, int i) {
        CToJavaImplements.Write(bArr, i, mContext);
    }

    public static byte[] WriteAndRead(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        return CToJavaImplements.WriteAndRead(bArr, i, bArr2, i2, i3, mIsHeavy, false, stdJni, null, mCToJavaImplementsExtends, mContext);
    }

    public static byte[] WriteAndRead2701(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        return CToJavaImplements.WriteAndRead2701(bArr, i, bArr2, i2, i3, mIsHeavy, false, stdJni, null, mContext);
    }

    public static byte[] ReceiveDataByTime(byte[] bArr, int i, int i2) {
        return CToJavaImplements.ReceiveDataByTime(bArr, i, i2, mIsHeavy, false, stdJni, null, mContext);
    }

    public static int GetLocalLanguage() {
        return CToJavaImplements.GetLocalLanguage();
    }

    public static void getGGPname(String str) {
        CToJavaImplements.getGGPname(str);
    }

    public static void notifyError(int i) {
        CToJavaImplements.notifyError(i);
    }

    static int OpenTcpConnectEx(String str, int i) {
        return CToJavaImplements.openTcpConnectEx(str, i);
    }

    static int CloseTcpConnectEx(int i) {
        return CToJavaImplements.closeTcpConnectEx(i);
    }

    static int SendDataByTcpEx(int i, byte[] bArr, int i2) {
        return CToJavaImplements.sendDataByTcpEx(i, bArr, i2);
    }

    static byte[] ReceiveDataByTcpEx(int i, byte[] bArr, int i2, int i3) {
        return CToJavaImplements.receiveDataByTcpEx(i, bArr, i2, i3);
    }
}
