package com.cnlaunch.diagnosemodule.newinterface;

import android.content.Context;
import android.content.Intent;
import com.cnlaunch.diagnosemodule.DiagnoseBusiness;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.physics.p205k.C1856n;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfBoolean;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class NewFrameUtil {
    private static String MID_JAR_NAME = "/NewInterface4j.jar";
    private static String MID_JAR_PATH = "LUDC";
    private static final String TAG = "NewFrameUtil";
    private static final String VEHICLES = "/VEHICLES/";
    private static String clsName = "com.cnlaunch.diagnosemodule.newinterface.NewInterfaceMain";
    private static NewFrameUtil newFrameDiagUtil = null;
    private static String retDiagByteDataMethodName = "onElementClicked";
    private static String startDiagMethodName = "newInterfaceMain";
    private Context mContext;
    private Method mMethodRetDiagData;
    private String mPackagePath;
    private String mRuntimePath;
    private String mSDPaths = "";
    private Class<?> clazz = null;

    private NewFrameUtil(Context context, String str, String str2) {
        this.mRuntimePath = "";
        this.mPackagePath = "";
        this.mContext = context;
        this.mRuntimePath = str;
        this.mPackagePath = str2;
    }

    public static NewFrameUtil getInstance() {
        return newFrameDiagUtil;
    }

    public static NewFrameUtil getInstance(Context context, String str, String str2) {
        if (newFrameDiagUtil == null) {
            synchronized (NewFrameUtil.class) {
                if (newFrameDiagUtil == null) {
                    newFrameDiagUtil = new NewFrameUtil(context, str, str2);
                }
            }
        }
        return newFrameDiagUtil;
    }

    public void setSDPaths(String str) {
        this.mSDPaths = str;
    }

    public void dynLoadJAR() {
        String str;
        String str2;
        int lastIndexOf = this.mSDPaths.lastIndexOf(VEHICLES);
        if (lastIndexOf > 0) {
            File[] listFiles = new File(this.mSDPaths.substring(0, lastIndexOf + 10) + "LUDC").listFiles();
            File file = null;
            float f = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
            for (int i = 0; i < listFiles.length; i++) {
                if (listFiles[i].isDirectory()) {
                    String name = listFiles[i].getName();
                    float floatValue = Float.valueOf(name.substring(1, name.length())).floatValue();
                    if (floatValue > f) {
                        file = listFiles[i];
                        f = floatValue;
                    }
                }
            }
            if (file == null) {
                this.mContext.sendBroadcast(new Intent("NativeMethodNoFind"));
                return;
            }
            str = file.getAbsolutePath();
            str2 = str + MID_JAR_NAME;
            C1856n.m8125d(TAG, "midJarPath=".concat(String.valueOf(str)));
        } else {
            str = null;
            str2 = null;
        }
        DiagnoseBusiness.getInstance(this.mContext).setDataFromUI2So(12, PdfBoolean.TRUE);
        DiagnoseDataSrc.getInstance(this.mContext);
        if (str2 == null) {
            this.mContext.sendBroadcast(new Intent("NativeMethodNoFind"));
            return;
        }
        DexClassLoader dexClassLoader = new DexClassLoader(str2, this.mPackagePath, null, getClass().getClassLoader());
        try {
            this.clazz = dexClassLoader.loadClass(clsName);
            this.mMethodRetDiagData = this.clazz.getMethod(retDiagByteDataMethodName, Integer.TYPE, byte[].class);
            this.mMethodRetDiagData.setAccessible(true);
            Method method = this.clazz.getMethod(startDiagMethodName, ClassLoader.class, String.class, String.class, String.class, String.class, Integer.TYPE);
            method.setAccessible(true);
            method.invoke(null, dexClassLoader, this.mRuntimePath, this.mSDPaths, str, DiagnoseConstants.DIAGNOSE_LANGUAGE, Integer.valueOf(Integer.parseInt(DiagnoseConstants.DIAG_INPUT_TYPE)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void returnDiagData(String str, int[] iArr) {
        if (DiagnoseConstants.UI_TYPE_DATASTREAM_SHOW_POS.equals(str)) {
            DiagnoseDataSrc.getInstance(this.mContext).notifyUnLock(iArr);
        }
    }

    public void returnDiagData(int i, byte[] bArr) {
        Method method = this.mMethodRetDiagData;
        if (method == null) {
            return;
        }
        try {
            method.invoke(null, Integer.valueOf(i), bArr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void returnDiagData(String str, String str2) {
        String str3 = null;
        int i = -1;
        if ("200".equals(str)) {
            try {
                i = Integer.parseInt(str2);
            } catch (Exception unused) {
            }
            DiagnoseDataSrc.getInstance(this.mContext).notifyUnLock(i, null);
        } else if ("16".equals(str) || DiagnoseConstants.FEEDBACK_INPUT_NUMBER.equals(str)) {
            if (str2 != null && str2.length() > 1 && '1' == str2.charAt(0)) {
                str3 = str2.substring(1, str2.length());
            }
            DiagnoseDataSrc.getInstance(this.mContext).notifyUnLock(-1, str3);
        } else if ("00000100".equals(str2)) {
            returnDiagData(-1, new byte[0]);
        }
    }
}
