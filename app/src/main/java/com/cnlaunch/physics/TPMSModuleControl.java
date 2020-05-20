package com.cnlaunch.physics;

import android.text.TextUtils;
import com.cnlaunch.physics.p205k.C1856n;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;

/* renamed from: com.cnlaunch.physics.p */
/* loaded from: classes.dex */
public class TPMSModuleControl {

    /* renamed from: a */
    private static final String f10154a = "p";

    /* renamed from: a */
    public static boolean m8084a() {
        String str = "";
        Process process = null;
        try {
            process = Runtime.getRuntime().exec("sh");
            DataOutputStream dataOutputStream = new DataOutputStream(process.getOutputStream());
            dataOutputStream.writeBytes("/system/bin/cat /sys/devices/platform/voltage_detect/voltage\n");
            dataOutputStream.writeBytes("\n");
            dataOutputStream.writeBytes("exit\n");
            dataOutputStream.flush();
            dataOutputStream.close();
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                StringBuilder sb = new StringBuilder("");
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                }
                str = sb.toString();
                bufferedReader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            process.waitFor();
            if (C1856n.f10135a) {
                C1856n.m8130a(f10154a, "voltage =".concat(String.valueOf(str)));
            }
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                return Integer.parseInt(str) > 6500;
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        } catch (Exception e3) {
            e3.printStackTrace();
            if (process != null) {
                try {
                    process.destroy();
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
            return false;
        }
    }
}
