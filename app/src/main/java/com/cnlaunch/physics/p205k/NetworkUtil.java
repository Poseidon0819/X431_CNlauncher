package com.cnlaunch.physics.p205k;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.NetworkInfo;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.cnlaunch.p120d.p130d.SystemPropertiesInvoke;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;

/* renamed from: com.cnlaunch.physics.k.o */
/* loaded from: classes.dex */
public final class NetworkUtil {
    /* renamed from: a */
    public static boolean m8123a(Context context) {
        NetworkInfo activeNetworkInfo;
        return context != null && (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected() && activeNetworkInfo.getType() == 1;
    }

    /* renamed from: b */
    public static InetAddress m8118b(Context context) throws UnknownHostException {
        int i;
        String m8119b;
        if (m8117c(context).booleanValue()) {
            return InetAddress.getByName("192.168.43.255");
        }
        DhcpInfo dhcpInfo = ((WifiManager) context.getSystemService("wifi")).getDhcpInfo();
        C1856n.m8130a("NetworkUtil", "wifi.getDhcpInfo()" + dhcpInfo.toString());
        if (dhcpInfo == null) {
            return InetAddress.getByName("255.255.255.255");
        }
        if (dhcpInfo.netmask == 0) {
            if (!TextUtils.isEmpty(SystemPropertiesInvoke.m9430b("cnlaunch.product.type"))) {
                m8119b = SystemPropertiesInvoke.m9430b("dhcp.wlan0.mask");
                if (C1856n.f10135a) {
                    C1856n.m8130a("NetworkUtil", "dhcp.wlan0.mask netmasks = ".concat(String.valueOf(m8119b)));
                }
            } else {
                m8119b = m8119b();
                if (C1856n.f10135a) {
                    C1856n.m8130a("NetworkUtil", "android 6.0 or 7.0 netmasks = ".concat(String.valueOf(m8119b)));
                }
            }
            byte[] m8120a = m8120a(m8119b);
            if (C1856n.f10135a) {
                C1856n.m8130a("NetworkUtil", String.format("dhcp. mask netmasks = %d.%d.%d.%d", Integer.valueOf(m8120a[0] & 255), Integer.valueOf(m8120a[1] & 255), Integer.valueOf(m8120a[2] & 255), Integer.valueOf(m8120a[3] & 255)));
            }
            i = m8120a != null ? ((m8120a[3] & 255) << 24) | (m8120a[0] & 255) | ((m8120a[1] & 255) << 8) | ((m8120a[2] & 255) << 16) : 0;
        } else {
            i = dhcpInfo.netmask;
        }
        if (C1856n.f10135a) {
            C1856n.m8130a("NetworkUtil", String.format("dhcp.ipAddress int = %d,netmasks int = %d", Integer.valueOf(dhcpInfo.ipAddress), Integer.valueOf(i)));
        }
        int i2 = (dhcpInfo.ipAddress & i) | (i ^ (-1));
        byte[] bArr = new byte[4];
        for (int i3 = 0; i3 < 4; i3++) {
            bArr[i3] = (byte) ((i2 >> (i3 * 8)) & 255);
        }
        return InetAddress.getByAddress(bArr);
    }

    /* renamed from: a */
    private static byte[] m8120a(String str) {
        byte[] bArr = new byte[4];
        try {
            String[] split = str.split("\\.");
            if (split != null && split.length == 4) {
                bArr[0] = (byte) (Integer.parseInt(split[0]) & 255);
                bArr[1] = (byte) (Integer.parseInt(split[1]) & 255);
                bArr[2] = (byte) (Integer.parseInt(split[2]) & 255);
                bArr[3] = (byte) (Integer.parseInt(split[3]) & 255);
                return bArr;
            }
            return null;
        } catch (Exception unused) {
            C1856n.m8130a("NetworkUtil", str + " is invalid IP");
            return null;
        }
    }

    /* renamed from: b */
    private static String m8119b() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                if (nextElement.getDisplayName().contains("wlan")) {
                    for (InterfaceAddress interfaceAddress : nextElement.getInterfaceAddresses()) {
                        if (interfaceAddress.getAddress() instanceof Inet4Address) {
                            int networkPrefixLength = (-1) << (32 - interfaceAddress.getNetworkPrefixLength());
                            int[] iArr = new int[4];
                            for (int i = 0; i < 4; i++) {
                                iArr[3 - i] = (networkPrefixLength >> (i * 8)) & 255;
                            }
                            String str = "" + iArr[0];
                            for (int i2 = 1; i2 < 4; i2++) {
                                str = str + "." + iArr[i2];
                            }
                            return str;
                        }
                    }
                    continue;
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: c */
    public static Boolean m8117c(Context context) {
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            return (Boolean) wifiManager.getClass().getMethod("isWifiApEnabled", new Class[0]).invoke(wifiManager, new Object[0]);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return Boolean.FALSE;
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return Boolean.FALSE;
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
            return Boolean.FALSE;
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
            return Boolean.FALSE;
        }
    }

    /* renamed from: a */
    public static ArrayList<String> m8124a() {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/net/arp"));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                String[] split = readLine.split(" +");
                if (split != null && split.length >= 4) {
                    String str = split[0];
                    if (!str.equalsIgnoreCase("ip")) {
                        arrayList.add(str);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return arrayList;
    }

    /* renamed from: a */
    public static int m8122a(WifiConfiguration wifiConfiguration) {
        if (wifiConfiguration.allowedKeyManagement.get(1)) {
            return 2;
        }
        if (wifiConfiguration.allowedKeyManagement.get(2) || wifiConfiguration.allowedKeyManagement.get(3)) {
            return 3;
        }
        return wifiConfiguration.wepKeys[0] != null ? 1 : 0;
    }

    /* renamed from: a */
    public static String m8121a(WifiConfiguration wifiConfiguration, int i) {
        if (i == -1) {
            i = m8122a(wifiConfiguration);
        }
        switch (i) {
            case 0:
            default:
                return "";
            case 1:
                return wifiConfiguration.wepKeys[0];
            case 2:
                return wifiConfiguration.preSharedKey;
        }
    }
}
