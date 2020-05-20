package com.baidu.mapsdkplatform.comapi.map;

import android.content.Context;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.NetworkUtil;
import com.baidu.mapapi.common.BaiduMapSDKException;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapsdkplatform.comapi.NativeLoader;
import com.baidu.mapsdkplatform.comapi.commonutils.C1190a;
import com.baidu.mapsdkplatform.comapi.commonutils.SysUpdateUtil;
import com.baidu.mapsdkplatform.comapi.util.SysUpdateObservable;
import com.baidu.mapsdkplatform.comjni.engine.AppEngine;
import com.baidu.mapsdkvi.VMsg;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;

/* renamed from: com.baidu.mapsdkplatform.comapi.map.i */
/* loaded from: classes.dex */
public class C1215i {

    /* renamed from: a */
    private static int f6042a;

    /* renamed from: b */
    private static Context f6043b = BMapManager.getContext();

    static {
        if (!com.baidu.mapapi.VersionInfo.getApiVersion().equals(VersionInfo.getApiVersion())) {
            throw new BaiduMapSDKException("the version of map is not match with base");
        }
        NativeLoader.getInstance().loadLibrary(VersionInfo.getKitName());
        VMsg.InitClass(VMsg.getInstance());
        AppEngine.InitClass();
        m10645a(BMapManager.getContext());
        SysUpdateObservable.getInstance().addObserver(new SysUpdateUtil());
        SysUpdateObservable.getInstance().init();
    }

    /* renamed from: a */
    public static void m10646a() {
        if (f6042a == 0) {
            if (f6043b == null) {
                throw new IllegalStateException("you have not supplyed the global app context info from SDKInitializer.initialize(Context) function.");
            }
            VMsg.init();
            AppEngine.InitEngine(f6043b);
            AppEngine.StartSocketProc();
            NetworkUtil.updateNetworkProxy(f6043b);
        }
        f6042a++;
    }

    /* renamed from: a */
    private static void m10645a(Context context) {
        if (context == null) {
            return;
        }
        try {
            File file = new File(SysOSUtil.getModuleFileName());
            if (!file.exists()) {
                file.mkdirs();
            }
            context.getAssets();
            boolean z = true;
            String[] strArr = {"cfg/a/mode_1/map.sdkrs", "cfg/a/mode_1/reduct.sdkrs", "cfg/a/mode_1/traffic.sdkrs", "cfg/a/mode_1/map.sty", "cfg/a/mode_1/reduct.sty", "cfg/a/mode_1/traffic.sty", "cfg/idrres/ResPackIndoorMap.sdkrs", "cfg/idrres/DVIndoor.cfg", "cfg/idrres/baseindoormap.sty", "cfg/a/DVDirectory.cfg", "cfg/a/DVHotcity.cfg", "cfg/a/DVHotMap.cfg", "cfg/a/DVSDirectory.cfg", "cfg/a/DVVersion.cfg", "cfg/a/CustomIndex"};
            String[] strArr2 = {"cfg/a/CustomIndex"};
            String[] strArr3 = {"cfg/a/mode_1/map.rs", "cfg/a/mode_1/reduct.rs", "cfg/a/mode_1/traffic.rs", "cfg/a/mode_1/map.sty", "cfg/a/mode_1/reduct.sty", "cfg/a/mode_1/traffic.sty", "cfg/idrres/ResPackIndoorMap.rs", "cfg/idrres/DVIndoor.cfg", "cfg/idrres/baseindoormap.sty", "cfg/a/DVDirectory.cfg", "cfg/a/DVHotcity.cfg", "cfg/a/DVHotMap.cfg", "cfg/a/DVSDirectory.cfg", "cfg/a/DVVersion.cfg", "cfg/a/CustomIndex"};
            String[] strArr4 = {"cfg/a/CustomIndex"};
            try {
                File file2 = new File(SysOSUtil.getModuleFileName() + "/ver.dat");
                byte[] bArr = {5, 2, 1, 0, 0, 0};
                if (file2.exists()) {
                    FileInputStream fileInputStream = new FileInputStream(file2);
                    byte[] bArr2 = new byte[fileInputStream.available()];
                    fileInputStream.read(bArr2);
                    fileInputStream.close();
                    if (Arrays.equals(bArr2, bArr)) {
                        File file3 = new File(SysOSUtil.getModuleFileName() + "/cfg/a/mode_1/map.sty");
                        if (file3.exists() && file3.length() > 0) {
                            z = false;
                        }
                    }
                }
                if (z) {
                    if (file2.exists()) {
                        file2.delete();
                    }
                    file2.createNewFile();
                    FileOutputStream fileOutputStream = new FileOutputStream(file2);
                    fileOutputStream.write(bArr);
                    fileOutputStream.close();
                    File file4 = new File(SysOSUtil.getModuleFileName() + "/cfg/a/mode_1");
                    if (!file4.exists()) {
                        file4.mkdirs();
                    }
                    File file5 = new File(SysOSUtil.getModuleFileName() + "/cfg/idrres");
                    if (!file5.exists()) {
                        file5.mkdirs();
                    }
                }
                for (int i = 0; i <= 0; i++) {
                    C1190a.m10819a(strArr2[0], strArr4[0], context);
                }
                if (z) {
                    for (int i2 = 0; i2 < 15; i2++) {
                        C1190a.m10819a(strArr[i2], strArr3[i2], context);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: a */
    public static void m10644a(boolean z) {
        C1210e.m10671l(z);
    }

    /* renamed from: b */
    public static void m10643b() {
        int i = f6042a - 1;
        f6042a = i;
        if (i == 0) {
            AppEngine.UnInitEngine();
            VMsg.destroy();
        }
    }
}
