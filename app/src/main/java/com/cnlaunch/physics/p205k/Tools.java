package com.cnlaunch.physics.p205k;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mapapi.UIMsg;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.physics.DPUDeviceType;
import com.cnlaunch.physics.DeviceFactoryManager;
import com.cnlaunch.physics.p195b.DownloadBinUpdate;
import com.cnlaunch.physics.p195b.p196a.Analysis;
import com.cnlaunch.physics.p195b.p196a.MyFactory;
import com.cnlaunch.physics.p197c.AnalysisData;
import com.cnlaunch.physics.p199e.IPhysics;
import com.cnlaunch.physics.p201g.OnDownloadBinListener;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Locale;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* renamed from: com.cnlaunch.physics.k.q */
/* loaded from: classes.dex */
public class Tools {

    /* renamed from: a */
    private static final String f10140a = "q";

    @Deprecated
    /* renamed from: a */
    public static boolean m8114a() {
        return m8112a((Context) null, (String) null);
    }

    /* renamed from: a */
    public static boolean m8112a(Context context, String str) {
        boolean m8111a = m8111a(context, str, "heavyduty_serialNo_Prefix");
        C1856n.m8130a(f10140a, "isTruck.result=".concat(String.valueOf(m8111a)));
        return m8111a;
    }

    @Deprecated
    /* renamed from: b */
    public static boolean m8101b() {
        return m8099b(null, null);
    }

    /* renamed from: b */
    public static boolean m8099b(Context context, String str) {
        boolean m8111a = m8111a(context, str, "car_and_heavyduty_prefix");
        C1856n.m8130a(f10140a, "isCarAndHeavyduty.result=".concat(String.valueOf(m8111a)));
        return m8111a;
    }

    /* renamed from: c */
    public static boolean m8096c(Context context, String str) {
        boolean m8111a = m8111a(context, str, "wifi_support_serialno_prefix");
        C1856n.m8130a(f10140a, "isWiFiSupportDPU.result=".concat(String.valueOf(m8111a)));
        return m8111a;
    }

    /* renamed from: b */
    private static void m8098b(byte[] bArr, IPhysics iPhysics, int i) {
        try {
            iPhysics.setCommand_wait(true);
            iPhysics.setCommand("");
            OutputStream outputStream = iPhysics.getOutputStream();
            if (C1856n.f10135a) {
                C1856n.m8130a(f10140a, "writeDPUCommand write start");
            }
            outputStream.write(bArr);
            if (C1856n.f10135a) {
                C1856n.m8130a(f10140a, "writeDPUCommand write end");
            }
            long time = new Date().getTime();
            while (!m8109a(iPhysics, time, i)) {
                String command = iPhysics.getCommand();
                if (!TextUtils.isEmpty(command)) {
                    byte[] m8183a = ByteHexHelper.m8183a(command);
                    if (C1856n.f10135a) {
                        C1856n.m8130a(f10140a, String.format("writeDPUCommand sendOrder[6]=%x  request[6]=%x ", Byte.valueOf(bArr[6]), Byte.valueOf(m8183a[6])));
                    }
                    if (bArr[6] == m8183a[6]) {
                        return;
                    }
                }
                iPhysics.setCommand_wait(true);
                iPhysics.setCommand("");
            }
        } catch (Exception e) {
            e.printStackTrace();
            iPhysics.setCommand_wait(false);
            iPhysics.setCommand("");
        }
    }

    /* renamed from: a */
    private static boolean m8109a(IPhysics iPhysics, long j, int i) {
        while (iPhysics.getCommand_wait()) {
            if (new Date().getTime() - j > i) {
                iPhysics.setCommand_wait(false);
                iPhysics.setCommand("");
                return true;
            }
            try {
                Thread.sleep(10L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002e, code lost:
        if (r5.startsWith(r6) != false) goto L16;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003c  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean m8104a(java.lang.String r5, java.lang.String r6) {
        /*
            r0 = 1
            r1 = 0
            boolean r2 = android.text.TextUtils.isEmpty(r6)     // Catch: java.lang.Exception -> L33
            if (r2 != 0) goto L31
            java.lang.String r2 = ","
            boolean r2 = r6.contains(r2)     // Catch: java.lang.Exception -> L33
            if (r2 == 0) goto L2a
            java.lang.String r2 = ","
            java.lang.String[] r6 = r6.split(r2)     // Catch: java.lang.Exception -> L33
            if (r6 == 0) goto L28
            int r2 = r6.length     // Catch: java.lang.Exception -> L33
            r3 = 0
        L1a:
            if (r3 >= r2) goto L28
            r4 = r6[r3]     // Catch: java.lang.Exception -> L33
            boolean r4 = r5.startsWith(r4)     // Catch: java.lang.Exception -> L33
            if (r4 == 0) goto L25
            goto L38
        L25:
            int r3 = r3 + 1
            goto L1a
        L28:
            r0 = 0
            goto L38
        L2a:
            boolean r5 = r5.startsWith(r6)     // Catch: java.lang.Exception -> L33
            if (r5 == 0) goto L31
            goto L38
        L31:
            r0 = 0
            goto L38
        L33:
            r5 = move-exception
            r5.printStackTrace()
            r0 = 0
        L38:
            boolean r5 = com.cnlaunch.physics.p205k.C1856n.f10135a
            if (r5 == 0) goto L4b
            java.lang.String r5 = com.cnlaunch.physics.p205k.Tools.f10140a
            java.lang.String r6 = "isMatchCommonPrefixRule.result="
            java.lang.String r1 = java.lang.String.valueOf(r0)
            java.lang.String r6 = r6.concat(r1)
            com.cnlaunch.physics.p205k.C1856n.m8130a(r5, r6)
        L4b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.physics.p205k.Tools.m8104a(java.lang.String, java.lang.String):boolean");
    }

    /* renamed from: a */
    private static boolean m8111a(Context context, String str, String str2) {
        if (context == null) {
            DeviceFactoryManager m8305a = DeviceFactoryManager.m8305a();
            context = m8305a.f9901a != null ? m8305a.f9901a.getContext() : null;
        }
        try {
            if (context == null) {
                if (C1856n.f10135a) {
                    C1856n.m8130a(f10140a, "isMatchConfigKeyPrefix myContext=null");
                }
                return false;
            }
            String m8115a = PhysicsCommonUtils.m8115a(context, str2);
            if (C1856n.f10135a) {
                C1856n.m8130a(f10140a, String.format("isMatchConfigKeyPrefix configKey = %s configValue =%s", str2, m8115a));
            }
            if (str == null) {
                str = DeviceFactoryManager.m8305a().m8280e();
            }
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return m8104a(str, m8115a);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: d */
    public static boolean m8095d(Context context, String str) {
        boolean m8111a = m8111a(context, str, "easydiag30_and_master30_serialno_prefix");
        if (!m8111a) {
            m8111a = m8104a(str, "97699,97709,98981");
        }
        C1856n.m8130a(f10140a, "isMatchEasyDiag30AndMasterEncryptPrefix.result=".concat(String.valueOf(m8111a)));
        return m8111a;
    }

    /* renamed from: a */
    public static boolean m8105a(String str) {
        boolean m8104a = m8104a(str, "98942,97986,97974,97977,98926,98927");
        if (C1856n.f10135a) {
            C1856n.m8130a(f10140a, "isMatchEasyDiag40AndMasterEncryptPrefix.result=".concat(String.valueOf(m8104a)));
        }
        return m8104a;
    }

    /* renamed from: e */
    public static boolean m8094e(Context context, String str) {
        boolean m8111a = m8111a(context, str, "smartbox30_support_serialno_prefix");
        C1856n.m8130a(f10140a, "isMatchSmartbox30SupportSerialnoPrefix.result=".concat(String.valueOf(m8111a)));
        return m8111a;
    }

    /* renamed from: a */
    public static byte[] m8108a(IPhysics iPhysics, byte[] bArr) {
        return m8107a(iPhysics, bArr, (int) UIMsg.m_AppUI.MSG_APP_GPS);
    }

    /* renamed from: a */
    public static byte[] m8107a(IPhysics iPhysics, byte[] bArr, int i) {
        return m8106a(iPhysics, bArr, i, DPUDeviceType.f9692b);
    }

    /* renamed from: a */
    private static byte[] m8106a(IPhysics iPhysics, byte[] bArr, int i, int i2) {
        AnalysisData mo8358a;
        if (C1856n.f10135a) {
            String str = f10140a;
            C1856n.m8130a(str, "dpuCommandOperation .sendOrder = " + ByteHexHelper.m8180a(bArr));
        }
        int i3 = 0;
        byte[] bArr2 = null;
        if (bArr.length <= 0) {
            return null;
        }
        while (true) {
            if (i3 >= 3) {
                break;
            }
            m8102a(bArr, iPhysics, i);
            String command = iPhysics.getCommand();
            if (TextUtils.isEmpty(command)) {
                i3++;
            } else {
                if (C1856n.f10135a) {
                    C1856n.m8130a(f10140a, "dpuCommandOperation.backOrder = ".concat(String.valueOf(command)));
                }
                byte[] m8183a = ByteHexHelper.m8183a(command);
                Analysis m8341b = MyFactory.m8341b();
                if (i2 == DPUDeviceType.f9692b) {
                    mo8358a = m8341b.mo8355b(bArr, m8183a);
                } else {
                    mo8358a = m8341b.mo8358a(bArr, m8183a);
                }
                if (mo8358a.f9843d.booleanValue()) {
                    bArr2 = mo8358a.f9842c;
                    if (C1856n.f10135a) {
                        String str2 = f10140a;
                        C1856n.m8130a(str2, "dpuCommandOperation .data receiveBuffer = " + ByteHexHelper.m8180a(bArr2));
                    }
                } else {
                    i3++;
                }
            }
        }
        return bArr2;
    }

    /* renamed from: a */
    public static boolean m8113a(Context context) {
        String m8115a = PhysicsCommonUtils.m8115a(context, "is_support_dual_wifi");
        boolean parseBoolean = !TextUtils.isEmpty(m8115a) ? Boolean.parseBoolean(m8115a) : false;
        C1856n.m8130a(f10140a, "isSupportDualWiFi.result=".concat(String.valueOf(parseBoolean)));
        return parseBoolean;
    }

    /* renamed from: b */
    public static boolean m8100b(Context context) {
        String m8115a = PhysicsCommonUtils.m8115a(context, "is_support_wifi_priority");
        boolean parseBoolean = !TextUtils.isEmpty(m8115a) ? Boolean.parseBoolean(m8115a) : false;
        C1856n.m8130a(f10140a, "isSupportWiFiPriority.result=".concat(String.valueOf(parseBoolean)));
        return parseBoolean;
    }

    /* renamed from: f */
    public static boolean m8093f(Context context, String str) {
        boolean z = false;
        try {
            InputStream open = context.getResources().getAssets().open("DOWNLOAD_BLKLIST.zip");
            ZipInputStream zipInputStream = new ZipInputStream(open);
            byte[] bArr = new byte[1024];
            while (true) {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry == null) {
                    break;
                }
                String name = nextEntry.getName();
                if (C1856n.f10135a) {
                    C1856n.m8130a(f10140a, "copyDownloadBlklistFromAssert .zipEntry Name=".concat(String.valueOf(name)));
                }
                if (name != null && name.contains("DOWNLOAD_BLKLIST.bin")) {
                    File file = new File(str);
                    if (file.exists()) {
                        if (file.delete()) {
                            if (C1856n.f10135a) {
                                String str2 = f10140a;
                                C1856n.m8130a(str2, "copyDownloadBlklistFromAssert .vaildDownload=" + str + " delete successful");
                            }
                        } else if (C1856n.f10135a) {
                            String str3 = f10140a;
                            C1856n.m8130a(str3, "copyDownloadBlklistFromAssert .vaildDownload=" + str + " delete fail");
                        }
                    } else if (!file.getParentFile().exists()) {
                        file.getParentFile().mkdirs();
                    }
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str));
                    while (true) {
                        int read = zipInputStream.read(bArr, 0, 1024);
                        if (read == -1) {
                            break;
                        }
                        bufferedOutputStream.write(bArr, 0, read);
                    }
                    bufferedOutputStream.flush();
                    bufferedOutputStream.close();
                    if (C1856n.f10135a) {
                        C1856n.m8130a(f10140a, "copyDownloadBlklistFromAssert zipEntry read successful");
                    }
                    z = true;
                }
            }
            zipInputStream.close();
            open.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return z;
    }

    /* renamed from: c */
    public static boolean m8097c(Context context) {
        String m9584b = PreferencesManager.m9595a(context).m9584b("productType", "");
        return m9584b.toUpperCase(Locale.ENGLISH).contains("PROLITE") || m9584b.toUpperCase(Locale.ENGLISH).contains("MAXLITE");
    }

    /* renamed from: a */
    public static void m8103a(byte[] bArr, IPhysics iPhysics) {
        m8098b(bArr, iPhysics, UIMsg.m_AppUI.MSG_APP_GPS);
    }

    /* renamed from: a */
    public static void m8102a(byte[] bArr, IPhysics iPhysics, int i) {
        m8098b(bArr, iPhysics, i);
    }

    /* renamed from: a */
    public static boolean m8110a(IPhysics iPhysics) {
        boolean z = true;
        if (!DownloadBinUpdate.m8378a(iPhysics, (OnDownloadBinListener) null).equalsIgnoreCase("00")) {
            if (!DownloadBinUpdate.m8365c(iPhysics).booleanValue()) {
                C1856n.m8127b(f10140a, "复位失败");
                z = false;
            }
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return z;
    }
}
