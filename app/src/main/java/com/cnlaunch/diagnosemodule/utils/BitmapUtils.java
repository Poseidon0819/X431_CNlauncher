package com.cnlaunch.diagnosemodule.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.view.View;
import android.widget.ImageView;
import java.io.File;

/* loaded from: classes.dex */
public class BitmapUtils {
    public static View getShowBitmap(Context context, String str) {
        String[] split;
        ImageView imageView = new ImageView(context);
        String str2 = "";
        for (String str3 : str.split(",")) {
            if (str3.toUpperCase().contains(".BMP") || str3.toUpperCase().contains(".PNG") || str3.toUpperCase().contains(".JPG")) {
                str2 = str3;
                break;
            }
        }
        Bitmap bitmap = getBitmap(DiagnoseConstants.DIAGNOSE_LIB_PATH + "BMP/", str2);
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
            return imageView;
        }
        return null;
    }

    public static Bitmap getBitmap(String str, String str2) {
        if ("mounted".equals(Environment.getExternalStorageState()) && new File(str).exists()) {
            if (new File(str + "BMP/" + str2).exists()) {
                return BitmapFactory.decodeFile(str + "BMP/" + str2);
            }
            return null;
        }
        return null;
    }
}
