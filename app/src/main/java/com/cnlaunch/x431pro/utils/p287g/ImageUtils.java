package com.cnlaunch.x431pro.utils.p287g;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* renamed from: com.cnlaunch.x431pro.utils.g.a */
/* loaded from: classes.dex */
public final class ImageUtils {
    /* renamed from: a */
    public static int m4937a(String str, String str2) {
        try {
            Bitmap decodeFile = BitmapFactory.decodeFile(str);
            File file = new File(str2);
            if (file.exists()) {
                file.delete();
            } else {
                file.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(str2);
            decodeFile.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            return 1;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
