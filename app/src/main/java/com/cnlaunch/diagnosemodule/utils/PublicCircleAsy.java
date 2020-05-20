package com.cnlaunch.diagnosemodule.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.text.TextUtils;
import com.cnlaunch.diagnosemodule.BluetoothStateStd;
import com.cnlaunch.diagnosemodule.DiagnoseBusiness;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.physics.p205k.C1856n;
import com.ifoer.expedition.cto.CToJava;
import com.ifoer.expedition.ndk.DiagGetAPKSwitch;
import com.ifoer.expedition.ndk.DynamicDepot;
import com.ifoer.expedition.ndk.DynamicEvent;
import com.ifoer.expedition.ndk.StdJni;
import com.ifoer.expedition.ndk.TPMSInfoEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

/* loaded from: classes.dex */
public class PublicCircleAsy extends AsyncTask<String, String, String> {
    private Context mContext;
    private String mDataDir;
    private String mPaths;
    private String mSdPaths;

    public static boolean getDDLLBoolean(String str) {
        try {
            String replaceAll = str.replaceAll("//", "/");
            FileInputStream fileInputStream = new FileInputStream(new File(replaceAll + "Funcfg.so"));
            String property = getProperty(fileInputStream, "DDLL");
            fileInputStream.close();
            if (TextUtils.isEmpty(property)) {
                return false;
            }
            return property.equals("1;");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean getDiagSoftSuppSecondPoolBoolean(String str) {
        try {
            String replaceAll = str.replaceAll("//", "/");
            FileInputStream fileInputStream = new FileInputStream(new File(replaceAll + "Funcfg.so"));
            String property = getProperty(fileInputStream, "SuppSecondPool");
            fileInputStream.close();
            return property.equals("1;");
        } catch (Exception unused) {
            return false;
        }
    }

    public static String getProperty(InputStream inputStream, String str) {
        try {
            Properties properties = new Properties();
            if (inputStream != null) {
                properties.load(inputStream);
                return properties.getProperty(str);
            }
            return "";
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public PublicCircleAsy(String str, Context context) {
        this.mPaths = "";
        this.mDataDir = "";
        DiagnoseConstants.LOAD_SO_LIST = "";
        this.mSdPaths = Environment.getExternalStorageDirectory() + str;
        if (Environment.isExternalStorageRemovable()) {
            String string = context.getSharedPreferences("SHARE_DATA", 0).getString("pdt_type", "0");
            if (string.equalsIgnoreCase("215") || string.equalsIgnoreCase("325") || string.equalsIgnoreCase("323")) {
                StorageManager storageManager = (StorageManager) context.getSystemService("storage");
                try {
                    String[] strArr = (String[]) storageManager.getClass().getMethod("getVolumePaths", new Class[0]).invoke(storageManager, new Object[0]);
                    if (strArr.length > 1) {
                        this.mSdPaths = strArr[1] + str;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        try {
            this.mDataDir = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).dataDir;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
        }
        this.mPaths = this.mDataDir + "/libs/" + str;
        DiagnoseConstants.APP_VEHICLE_VERSION_PATH = this.mPaths;
        this.mContext = context;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public String doInBackground(String... strArr) {
        int copySpecNameSo;
        if (!getDDLLBoolean(this.mSdPaths)) {
            copySpecNameSo = CopyFile.copySo(this.mSdPaths, this.mPaths);
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add("libCOMM_ABSTRACT_LAYER.so");
            arrayList.add("libSTD.so");
            arrayList.add("libDIAG.so");
            arrayList.add("libDEVICEID.so");
            copySpecNameSo = CopyFile.copySpecNameSo(this.mSdPaths, this.mPaths, arrayList);
        }
        if (copySpecNameSo == 0) {
            CopyFile.list = new ArrayList<>();
            CopyFile.findAllSoFile(this.mPaths);
            return null;
        } else if (copySpecNameSo != -1) {
            Intent intent = new Intent("NativeMethodNoFind");
            intent.setType("HadSoFileNotCopy");
            this.mContext.sendBroadcast(intent);
            return null;
        } else {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Type inference failed for: r8v11, types: [com.cnlaunch.diagnosemodule.utils.PublicCircleAsy$1] */
    @Override // android.os.AsyncTask
    public void onPostExecute(String str) {
        super.onPostExecute((PublicCircleAsy) str);
        if (CopyFile.list.size() > 0) {
            boolean dDLLBoolean = getDDLLBoolean(this.mSdPaths);
            for (int i = 0; i < CopyFile.list.size(); i++) {
                if (CopyFile.list.get(i).contains("libCOMM_ABSTRACT_LAYER") || CopyFile.list.get(i).contains("libSTD") || CopyFile.list.get(i).contains("libDIAG") || CopyFile.list.get(i).contains("libDEVICEID") || !dDLLBoolean) {
                    try {
                        System.load(CopyFile.list.get(i));
                        DiagnoseConstants.LOAD_SO_LIST += CopyFile.list.get(i) + "\\0";
                    } catch (UnsatisfiedLinkError e) {
                        this.mContext.sendBroadcast(new Intent("NativeMethodNoFind"));
                        e.printStackTrace();
                    }
                }
            }
        }
        boolean versionSupSomeFunBoolean = FuncfgUtil.getVersionSupSomeFunBoolean(this.mSdPaths, "BT_INT");
        C1856n.m8125d("PublicCircleAsy", "supportBluetoochInit = ".concat(String.valueOf(versionSupSomeFunBoolean)));
        if (versionSupSomeFunBoolean) {
            DiagnoseConstants.isLoadStded = true;
            new BluetoothStateStd().setBluetoochConnectState(1);
        }
        try {
            new StdJni().setCallbackEnv(this.mSdPaths);
            CToJava.setVehicleSdPath(this.mSdPaths);
            if (getDiagSoftSuppSecondPoolBoolean(this.mSdPaths)) {
                DiagnoseBusiness.getInstance(this.mContext).setDynamicEvent(new DynamicEvent());
            }
            startTpmsgunEvent();
            new Thread() { // from class: com.cnlaunch.diagnosemodule.utils.PublicCircleAsy.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        sleep(500L);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                    PublicCircleAsy.this.startDignoseMainFunction();
                }
            }.start();
        } catch (UnsatisfiedLinkError unused) {
            Intent intent = new Intent("NativeSoNotFind");
            intent.putExtra("softPath", this.mSdPaths);
            this.mContext.sendBroadcast(intent);
            this.mContext.sendBroadcast(new Intent("NativeMethodNoFind"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startDignoseMainFunction() {
        try {
            DiagGetAPKSwitch diagGetAPKSwitch = new DiagGetAPKSwitch();
            DiagnoseBusiness.getInstance(this.mContext);
            if (DiagnoseBusiness.isIsDiagGetSwitch()) {
                diagGetAPKSwitch.DiagGetAPKSwitch(DiagnoseBusiness.getInstance(this.mContext).getDiagSwitchData());
            }
        } catch (UnsatisfiedLinkError unused) {
        }
        try {
            new DynamicDepot().DiagnoseMain();
        } catch (UnsatisfiedLinkError unused2) {
            this.mContext.sendBroadcast(new Intent("NativeMethodNoFind"));
        }
    }

    private void startTpmsgunEvent() {
        if (PreferencesManager.m9595a(this.mContext).m9583b("is_support_connector_tpms", false)) {
            DiagnoseBusiness.getInstance(this.mContext).setTpmsInfoEvent(new TPMSInfoEvent());
        }
    }
}
