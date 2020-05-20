package com.cnlaunch.x431pro.utils.p279a;

import android.graphics.Bitmap;
import com.cnlaunch.x431pro.utils.C2787z;
import com.google.p322a.BarcodeFormat;
import com.google.p322a.EncodeHintType;
import com.google.p322a.WriterException;
import com.google.p322a.p323a.BitMatrix;
import com.google.p322a.p325b.QRCodeWriter;
import com.google.p322a.p325b.p326a.ErrorCorrectionLevel;
import com.google.p322a.p325b.p327b.C3102c;
import java.util.Hashtable;

/* renamed from: com.cnlaunch.x431pro.utils.a.a */
/* loaded from: classes.dex */
public final class QRCodeUtils {
    /* renamed from: a */
    public static Bitmap m5194a(String str) {
        if (C2787z.m4821a(str)) {
            return null;
        }
        try {
            new QRCodeWriter();
            Hashtable hashtable = new Hashtable();
            hashtable.put(EncodeHintType.CHARACTER_SET, "utf-8");
            new QRCodeWriter();
            BarcodeFormat barcodeFormat = BarcodeFormat.QR_CODE;
            if (str.isEmpty()) {
                throw new IllegalArgumentException("Found empty contents");
            }
            if (barcodeFormat != BarcodeFormat.QR_CODE) {
                throw new IllegalArgumentException("Can only encode QR_CODE, but got ".concat(String.valueOf(barcodeFormat)));
            }
            ErrorCorrectionLevel errorCorrectionLevel = ErrorCorrectionLevel.L;
            if (hashtable.containsKey(EncodeHintType.ERROR_CORRECTION)) {
                errorCorrectionLevel = ErrorCorrectionLevel.valueOf(hashtable.get(EncodeHintType.ERROR_CORRECTION).toString());
            }
            BitMatrix m3948a = QRCodeWriter.m3948a(C3102c.m3930a(str, errorCorrectionLevel, hashtable), hashtable.containsKey(EncodeHintType.MARGIN) ? Integer.parseInt(hashtable.get(EncodeHintType.MARGIN).toString()) : 4);
            int[] iArr = new int[160000];
            for (int i = 0; i < 400; i++) {
                for (int i2 = 0; i2 < 400; i2++) {
                    if (m3948a.m3950a(i2, i)) {
                        iArr[(i * 400) + i2] = -16777216;
                    } else {
                        iArr[(i * 400) + i2] = -1;
                    }
                }
            }
            Bitmap createBitmap = Bitmap.createBitmap(400, 400, Bitmap.Config.ARGB_8888);
            createBitmap.setPixels(iArr, 0, 400, 0, 0, 400, 400);
            return createBitmap;
        } catch (WriterException e) {
            e.printStackTrace();
            return null;
        }
    }
}
