package com.cnlaunch.physics.wifi.p208a;

import android.content.Context;
import android.text.TextUtils;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.physics.p205k.C1856n;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/* renamed from: com.cnlaunch.physics.wifi.a.d */
/* loaded from: classes.dex */
public final class SecondWiFiUtil {

    /* renamed from: a */
    private static String f10190a = "/sys/usb_switch/usbwifi";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static boolean m8063a(String str) {
        return (TextUtils.isEmpty(str) || str.equals("null") || !str.equals("OK")) ? false : true;
    }

    /* renamed from: a */
    public static void m8064a(Context context) {
        m8062a("1", context);
    }

    /* renamed from: b */
    public static void m8061b(Context context) {
        m8062a("0", context);
    }

    /* renamed from: a */
    private static boolean m8065a() {
        StringBuffer stringBuffer = new StringBuffer("");
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(f10190a)), "UTF-8"));
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine != null) {
                            stringBuffer.append(readLine);
                        } else {
                            try {
                                break;
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        bufferedReader = bufferedReader2;
                        e.printStackTrace();
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        String stringBuffer2 = stringBuffer.toString();
                        if (C1856n.f10135a) {
                            C1856n.m8130a("SecondWiFiUtil", "isPowerOn  power_state_string=".concat(String.valueOf(stringBuffer2)));
                        }
                        return stringBuffer2 != null && stringBuffer2.equals("1");
                    } catch (Throwable unused) {
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        String stringBuffer3 = stringBuffer.toString();
                        if (C1856n.f10135a) {
                            C1856n.m8130a("SecondWiFiUtil", "isPowerOn  power_state_string=".concat(String.valueOf(stringBuffer3)));
                        }
                        return stringBuffer3 != null && stringBuffer3.equals("1");
                    }
                }
                bufferedReader2.close();
                String stringBuffer4 = stringBuffer.toString();
                if (C1856n.f10135a) {
                    C1856n.m8130a("SecondWiFiUtil", "isPowerOn  power_state_string=".concat(String.valueOf(stringBuffer4)));
                }
                return stringBuffer4 != null && stringBuffer4.equals("1");
            } catch (Throwable unused2) {
            }
        } catch (Exception e5) {
            e = e5;
        }
    }

    /* renamed from: a */
    private static boolean m8062a(String str, Context context) {
        if (!PreferencesManager.m9595a(context).m9583b("is_new_dual_wifi_support", false)) {
            return false;
        }
        if (str.equals("1") && m8065a()) {
            return true;
        }
        if (str.equals("0") && !m8065a()) {
            return true;
        }
        if (C1856n.f10135a) {
            C1856n.m8130a("SecondWiFiUtil", "powerOperation start state=".concat(String.valueOf(str)));
        }
        FileWriter fileWriter = null;
        try {
            try {
                FileWriter fileWriter2 = new FileWriter(new File(f10190a));
                try {
                    fileWriter2.write(str);
                    fileWriter2.close();
                    try {
                        fileWriter2.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return true;
                } catch (Exception e2) {
                    e = e2;
                    fileWriter = fileWriter2;
                    e.printStackTrace();
                    if (fileWriter != null) {
                        try {
                            fileWriter.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    fileWriter = fileWriter2;
                    if (fileWriter != null) {
                        try {
                            fileWriter.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
