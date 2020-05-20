package com.launch.rcu.socket;

import android.util.Log;
import com.cnlaunch.p181j.DiagSocketController;
import java.io.UnsupportedEncodingException;

/* loaded from: classes.dex */
public class SocketCall {
    private static int identify;
    private static SocketCall instance;
    private static boolean isStop;

    public native int getCurrentVersion();

    public native int send(byte[] bArr, int i);

    public native void start(String str, int i, int i2, String str2, int i3);

    public native void stop();

    static {
        System.loadLibrary("Socket");
        instance = null;
        identify = 0;
        isStop = false;
    }

    public static int getIdentify() {
        return identify;
    }

    public static void setIdentify(int i) {
        identify = i;
    }

    public static SocketCall getInstance() {
        if (instance == null) {
            instance = new SocketCall();
        }
        return instance;
    }

    public void StopRemoteDiag() {
        try {
            if (isStop) {
                return;
            }
            isStop = true;
            stop();
        } catch (Exception e) {
            Log.e("Sanda", "StopRemoteDiag:" + e.getMessage());
        }
    }

    public void StartRemoteDiag(String str, int i, int i2, String str2, int i3) {
        isStop = false;
        setIdentify(i2);
        getInstance().start(str, i, i2, str2, i3);
    }

    public void sendRemoteData(String str, int i) {
        try {
            send(str.getBytes("UTF-8"), i);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            Log.e("Sanda", "sendRemoteData e:" + e.toString());
        }
    }

    public static void receive(byte[] bArr) {
        String str;
        try {
            str = new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            Log.e("Sanda", "receive e" + e.toString());
            str = new String(bArr);
        }
        DiagSocketController.m8651a().m8647b(str);
    }

    public static void serverCMD(byte[] bArr) {
        Log.e("Sanda", "serverCMD：" + new String(bArr));
    }

    public static void state(byte b) {
        if (b > 6) {
            isStop = true;
        }
        DiagSocketController m8651a = DiagSocketController.m8651a();
        Log.i("Sanda", "------>changeStatus:".concat(String.valueOf((int) b)));
        if (b == 6 && !m8651a.f9471d) {
            m8651a.f9470c = getInstance().getCurrentVersion();
        }
        if (m8651a.f9473f != null) {
            m8651a.f9473f.mo8677a(b);
        }
    }
}
