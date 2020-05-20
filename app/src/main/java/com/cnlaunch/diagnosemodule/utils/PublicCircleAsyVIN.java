package com.cnlaunch.diagnosemodule.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.storage.StorageManager;
import com.cnlaunch.physics.p205k.C1856n;
import com.ifoer.expedition.cto.CToJava2;
import com.ifoer.expedition.ndk.VINDynamicDepot;
import com.ifoer.expedition.ndk.VINStdJni;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class PublicCircleAsyVIN extends AsyncTask<String, String, String> {
    private Context mContext;
    private String mDataDir;
    private String mPaths;
    private String mSdPaths;
    private int mType = 0;
    private String[] mVinArray;

    public void setType(int i) {
        this.mType = i;
    }

    public PublicCircleAsyVIN(String str, Context context) {
        this.mPaths = "";
        this.mDataDir = "";
        DiagnoseConstants.LOAD_SO_LIST = "";
        this.mSdPaths = Environment.getExternalStorageDirectory() + str;
        if (Environment.isExternalStorageRemovable()) {
            String string = context.getSharedPreferences("SHARE_DATA", 0).getString("pdt_type", "0");
            if (string.equalsIgnoreCase("215") || string.equalsIgnoreCase("325")) {
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
        this.mContext = context;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public String doInBackground(String... strArr) {
        if (CopyFile.copySo(this.mSdPaths, this.mPaths) == 0) {
            CopyFile.list = new ArrayList<>();
            CopyFile.findAllSoFile(this.mPaths);
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Type inference failed for: r4v8, types: [com.cnlaunch.diagnosemodule.utils.PublicCircleAsyVIN$1] */
    @Override // android.os.AsyncTask
    public void onPostExecute(String str) {
        super.onPostExecute((PublicCircleAsyVIN) str);
        if (CopyFile.list.size() > 0) {
            int i = 0;
            while (true) {
                if (i >= CopyFile.list.size()) {
                    break;
                } else if (CopyFile.list.get(i).contains("libAutoVinCOMM_ABSTRACT_LAYER")) {
                    System.load(CopyFile.list.get(i));
                    DiagnoseConstants.LOAD_SO_LIST += CopyFile.list.get(i) + "\\0";
                    break;
                } else {
                    i++;
                }
            }
            int i2 = 0;
            while (true) {
                if (i2 >= CopyFile.list.size()) {
                    break;
                } else if (CopyFile.list.get(i2).contains("libAutoVinSTD")) {
                    System.load(CopyFile.list.get(i2));
                    DiagnoseConstants.LOAD_SO_LIST += CopyFile.list.get(i2) + "\\0";
                    break;
                } else {
                    i2++;
                }
            }
            int i3 = 0;
            while (true) {
                if (i3 >= CopyFile.list.size()) {
                    break;
                } else if (CopyFile.list.get(i3).contains("libAutoVinDIAG")) {
                    System.load(CopyFile.list.get(i3));
                    DiagnoseConstants.LOAD_SO_LIST += CopyFile.list.get(i3) + "\\0";
                    break;
                } else {
                    i3++;
                }
            }
            for (int i4 = 0; i4 < CopyFile.list.size(); i4++) {
                if (!CopyFile.list.get(i4).contains("libAutoVinCOMM_ABSTRACT_LAYER") && !CopyFile.list.get(i4).contains("libAutoVinSTD") && !CopyFile.list.get(i4).contains("libAutoVinDIAG")) {
                    System.load(CopyFile.list.get(i4));
                    DiagnoseConstants.LOAD_SO_LIST += CopyFile.list.get(i4) + "\\0";
                }
            }
        }
        try {
            new VINStdJni().setVinCallbackEnv(this.mSdPaths);
            CToJava2.setVehicleSdPath(this.mSdPaths);
            new Thread() { // from class: com.cnlaunch.diagnosemodule.utils.PublicCircleAsyVIN.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        sleep(500L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    PublicCircleAsyVIN.this.vinDignoseMainFunction();
                }
            }.start();
        } catch (UnsatisfiedLinkError unused) {
            Intent intent = new Intent("NativeSoNotFind");
            intent.putExtra("softPath", this.mSdPaths);
            this.mContext.sendBroadcast(intent);
            this.mContext.sendBroadcast(new Intent("NativeMethodNoFind"));
            C1856n.m8127b("PublicCircleAsyVIN", "java.lang.UnsatisfiedLinkError:Native method not found->stdJni");
        }
    }

    void vinDignoseMainFunction() {
        VINDynamicDepot vINDynamicDepot = new VINDynamicDepot();
        vINDynamicDepot.VINDiagnoseMain();
        if (!DiagnoseConstants.DIAG_AutoSearchSetArgs.isEmpty()) {
            String AutoSearchSetArgs = vINDynamicDepot.AutoSearchSetArgs(DiagnoseConstants.DIAG_AutoSearchSetArgs);
            Intent intent = new Intent("CT_HEAD_RET_READVINCVN");
            intent.putExtra("RET_AutoSearchSetArgs", AutoSearchSetArgs);
            this.mContext.sendBroadcast(intent);
        } else if (this.mType == 1) {
            String ReadVinCvn = vINDynamicDepot.ReadVinCvn();
            Intent intent2 = new Intent("CT_HEAD_RET_READVINCVN");
            intent2.putExtra("VINCVN", ReadVinCvn);
            this.mContext.sendBroadcast(intent2);
        } else {
            if (DiagnoseConstants.INPUT_VIN != null && "" != DiagnoseConstants.INPUT_VIN) {
                String str = DiagnoseConstants.INPUT_VIN;
                DiagnoseConstants.VIN_CODE = DiagnoseConstants.INPUT_VIN;
                this.mVinArray = vINDynamicDepot.AutoSearchVehByVIN(str, str.length()).split(",");
            } else {
                int OBDReadVIN = vINDynamicDepot.OBDReadVIN();
                String str2 = DiagnoseConstants.VIN_CODE;
                C1856n.m8127b("PublicCircleAsyVIN", "DiagnoseConstants.VIN_CODE = " + DiagnoseConstants.VIN_CODE);
                if (OBDReadVIN == 0 && str2 != null) {
                    this.mVinArray = vINDynamicDepot.AutoSearchVehByVIN(str2, str2.length()).split(",");
                }
            }
            Intent intent3 = new Intent("VIN_CAR_ARRAY");
            intent3.putExtra("VinArray", this.mVinArray);
            intent3.putExtra("cur_vin_code", DiagnoseConstants.VIN_CODE);
            this.mContext.sendBroadcast(intent3);
        }
    }
}
