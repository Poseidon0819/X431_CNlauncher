package com.cnlaunch.golo3.view.selectimg.p166a;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import com.cnlaunch.golo3.p165g.BitmapTool;
import com.cnlaunch.golo3.p165g.C1621v;
import com.cnlaunch.golo3.view.selectimg.FileConstant;
import com.cnlaunch.golo3.view.selectimg.ImgThumbBean;
import com.itextpdf.text.pdf.codec.TIFFConstants;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import org.codehaus.jackson.org.objectweb.asm.Opcodes;

/* renamed from: com.cnlaunch.golo3.view.selectimg.a.l */
/* loaded from: classes.dex */
public final class ThumbnailsUtil {
    @SuppressLint({"UseSparseArrays"})

    /* renamed from: a */
    private static HashMap<Integer, String> f8618a = new HashMap<>();

    /* renamed from: a */
    public static void m9061a(Integer num, String str) {
        f8618a.put(num, str);
    }

    /* renamed from: a */
    public static void m9063a() {
        f8618a.clear();
    }

    /* renamed from: a */
    public static ImgThumbBean m9060a(String str) {
        String str2;
        if (C1621v.m9121a(str)) {
            return null;
        }
        ImgThumbBean imgThumbBean = new ImgThumbBean();
        File file = new File(str);
        if ((file.exists() ? file.length() / 1024 : 0L) > 400) {
            Bitmap m9153a = BitmapTool.m9153a(str);
            StringBuilder sb = new StringBuilder();
            sb.append(new Date().getTime());
            str2 = FileConstant.f8692d + "scale" + sb.toString() + ".jpg";
            Bitmap m9062a = m9062a(m9153a, str);
            boolean m9059b = m9059b(m9062a, str2);
            if (m9062a != null && !m9062a.isRecycled()) {
                m9062a.recycle();
            }
            if (!m9059b) {
                str2 = str;
            }
        } else {
            str2 = str;
        }
        imgThumbBean.setImg(str2);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPurgeable = true;
        options.inInputShareable = true;
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inJustDecodeBounds = false;
        int i = options.outHeight;
        int i2 = (options.outWidth / 150) + 1;
        int i3 = (i / 150) + 1;
        if (i2 < i3) {
            i3 = i2;
        }
        if (i3 <= 0) {
            i3 = 1;
        }
        options.inSampleSize = i3;
        Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
        str.substring(str.lastIndexOf("/") + 1, str.length());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(new Date().getTime());
        String str3 = FileConstant.f8692d + "thumb" + sb2.toString() + ".jpg";
        Bitmap m9062a2 = m9062a(decodeFile, str);
        boolean m9059b2 = m9059b(m9062a2, str3);
        if (m9062a2 != null && !m9062a2.isRecycled()) {
            m9062a2.recycle();
        }
        if (m9059b2) {
            str = str3;
        }
        imgThumbBean.setImgthumb(str);
        return imgThumbBean;
    }

    /* renamed from: a */
    private static Bitmap m9062a(Bitmap bitmap, String str) {
        ExifInterface exifInterface;
        try {
            exifInterface = new ExifInterface(str);
        } catch (IOException e) {
            e.printStackTrace();
            exifInterface = null;
        }
        int i = 0;
        if (exifInterface != null) {
            int attributeInt = exifInterface.getAttributeInt("Orientation", 0);
            if (attributeInt == 3) {
                i = Opcodes.GETFIELD;
            } else if (attributeInt == 6) {
                i = 90;
            } else if (attributeInt == 8) {
                i = TIFFConstants.TIFFTAG_IMAGEDESCRIPTION;
            }
        }
        if (i != 0) {
            Matrix matrix = new Matrix();
            matrix.postRotate(i);
            return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        }
        return bitmap;
    }

    /* renamed from: b */
    private static boolean m9059b(Bitmap bitmap, String str) {
        if (bitmap == null || str == null) {
            return false;
        }
        File file = new File(str);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            if (bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream)) {
                fileOutputStream.flush();
                fileOutputStream.close();
                return true;
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
