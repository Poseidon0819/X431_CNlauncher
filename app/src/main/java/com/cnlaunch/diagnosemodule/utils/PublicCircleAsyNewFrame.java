package com.cnlaunch.diagnosemodule.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.storage.StorageManager;
import com.cnlaunch.diagnosemodule.newinterface.NewFrameUtil;

/* loaded from: classes.dex */
public class PublicCircleAsyNewFrame extends AsyncTask<String, String, String> {
    private Context mContext;
    private String mDataDir;
    private String mPaths;
    private String mSdPaths;
    private NewFrameUtil newFrameDiagUtil;

    public PublicCircleAsyNewFrame(String str, Context context) {
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public String doInBackground(String... strArr) {
        this.newFrameDiagUtil = NewFrameUtil.getInstance(this.mContext, this.mPaths, this.mDataDir);
        this.newFrameDiagUtil.setSDPaths(this.mSdPaths);
        this.newFrameDiagUtil.dynLoadJAR();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onPostExecute(String str) {
        super.onPostExecute((PublicCircleAsyNewFrame) str);
    }
}
