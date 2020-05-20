package com.cnlaunch.diagnosemodule.utils;

import android.content.Context;
import android.os.storage.StorageManager;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class StorageUtil {
    public static String getAvailableExternalStorage(Context context) {
        String str = "";
        for (StorageInfo storageInfo : listAvaliableStorage(context)) {
            if (storageInfo.isRemovable()) {
                if (!str.isEmpty()) {
                    str = str + ",";
                }
                str = str + storageInfo.getPath();
            }
        }
        return str;
    }

    private static List<StorageInfo> listAvaliableStorage(Context context) {
        ArrayList arrayList = new ArrayList();
        StorageManager storageManager = (StorageManager) context.getSystemService("storage");
        try {
            Method method = StorageManager.class.getMethod("getVolumeList", new Class[0]);
            method.setAccessible(true);
            Object[] objArr = (Object[]) method.invoke(storageManager, new Object[0]);
            if (objArr != null) {
                for (Object obj : objArr) {
                    StorageInfo storageInfo = new StorageInfo((String) obj.getClass().getMethod("getPath", new Class[0]).invoke(obj, new Object[0]));
                    File file = new File(storageInfo.getPath());
                    if (file.exists() && file.isDirectory() && file.canWrite()) {
                        Method method2 = obj.getClass().getMethod("isRemovable", new Class[0]);
                        try {
                            storageInfo.setState((String) StorageManager.class.getMethod("getVolumeState", String.class).invoke(storageManager, storageInfo.getPath()));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if (storageInfo.isMounted()) {
                            storageInfo.setRemovable(((Boolean) method2.invoke(obj, new Object[0])).booleanValue());
                            arrayList.add(storageInfo);
                        }
                    }
                }
            }
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (IllegalArgumentException e3) {
            e3.printStackTrace();
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
        }
        arrayList.trimToSize();
        return arrayList;
    }
}
