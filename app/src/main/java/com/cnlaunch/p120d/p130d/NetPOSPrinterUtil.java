package com.cnlaunch.p120d.p130d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.net.DhcpInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Looper;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.format.Formatter;
import com.itextpdf.text.pdf.ColumnText;
import com.launch.p365b.C3671a;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import org.codehaus.jackson.smile.SmileConstants;

/* renamed from: com.cnlaunch.d.d.e */
/* loaded from: classes.dex */
public class NetPOSPrinterUtil {

    /* renamed from: a */
    private static int f7240a;

    /* renamed from: b */
    private static Socket f7241b;

    /* renamed from: c */
    private static DataOutputStream f7242c;

    /* renamed from: d */
    private static DataInputStream f7243d;

    /* renamed from: e */
    private static int f7244e;

    /* renamed from: f */
    private static TextPaint f7245f;

    /* renamed from: g */
    private static Bitmap f7246g;

    /* renamed from: h */
    private static Bitmap f7247h;

    /* renamed from: a */
    public static int m9438a(Context context, Bitmap bitmap) {
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        DhcpInfo dhcpInfo = wifiManager.getDhcpInfo();
        WifiInfo connectionInfo = wifiManager.getConnectionInfo();
        if (connectionInfo == null || connectionInfo.getSSID() == null || connectionInfo.getSSID().startsWith("X-431PRINTER") || connectionInfo.getSSID().startsWith("\"X-431PRINTER")) {
            int i = dhcpInfo.serverAddress;
            f7244e = i;
            try {
                f7241b = new Socket(Formatter.formatIpAddress(i), 7001);
                f7242c = new DataOutputStream(f7241b.getOutputStream());
                f7243d = new DataInputStream(f7241b.getInputStream());
                DataOutputStream dataOutputStream = f7242c;
                if (dataOutputStream == null || f7243d == null) {
                    return 4095;
                }
                byte[] bArr = {27, 51, 0};
                try {
                    dataOutputStream.write(bArr, 0, 3);
                    bArr[0] = 0;
                    bArr[1] = 0;
                    bArr[2] = 0;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                byte[] bArr2 = {27, 74, 0};
                byte[] bArr3 = {29, 114, 73};
                int i2 = 5;
                byte[] bArr4 = {27, 42, 0, 0, 0};
                bArr4[2] = SmileConstants.TOKEN_LITERAL_NULL;
                bArr4[3] = (byte) (bitmap.getWidth() % 256);
                bArr4[4] = (byte) (bitmap.getWidth() / 256);
                int i3 = 0;
                while (i3 < (bitmap.getHeight() / 24) + 1) {
                    try {
                        f7242c.write(bArr4, 0, i2);
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    for (int i4 = 0; i4 < bitmap.getWidth(); i4++) {
                        for (int i5 = 0; i5 < 24; i5++) {
                            int i6 = (i3 * 24) + i5;
                            if (i6 < bitmap.getHeight() && Color.red(bitmap.getPixel(i4, i6)) == 0) {
                                int i7 = i5 / 8;
                                bArr[i7] = (byte) (bArr[i7] + ((byte) (128 >> (i5 % 8))));
                            }
                        }
                        try {
                            f7242c.write(bArr, 0, 3);
                            bArr[0] = 0;
                            bArr[1] = 0;
                            bArr[2] = 0;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    try {
                        if (i3 % 10 == 0) {
                            f7242c.write(bArr3);
                            if (f7243d.readByte() == 0) {
                                f7242c.write(bArr2, 0, 3);
                            }
                        } else {
                            f7242c.write(bArr2, 0, 3);
                        }
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                    i3++;
                    i2 = 5;
                }
                byte[] bArr5 = {27, 74, 64};
                try {
                    f7242c.write(new byte[]{29, 122, 49});
                    f7242c.write(bArr5);
                    f7240a = f7243d.readByte();
                    try {
                        f7242c.close();
                        f7243d.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                    return f7240a;
                } catch (IOException unused) {
                    return 4095;
                }
            } catch (UnknownHostException e6) {
                e6.printStackTrace();
                return 4095;
            } catch (IOException e7) {
                e7.printStackTrace();
                return 4095;
            }
        }
        return 4095;
    }

    /* renamed from: a */
    public static int m9435a(Bitmap bitmap, String str) {
        if (TextUtils.isEmpty(str)) {
            return 4095;
        }
        try {
            f7241b = new Socket();
            f7241b.connect(new InetSocketAddress(str, 7001), 10000);
            f7242c = new DataOutputStream(f7241b.getOutputStream());
            f7243d = new DataInputStream(f7241b.getInputStream());
            DataOutputStream dataOutputStream = f7242c;
            if (dataOutputStream == null || f7243d == null) {
                return 4095;
            }
            byte[] bArr = {27, 51, 0};
            try {
                dataOutputStream.write(bArr, 0, 3);
                bArr[0] = 0;
                bArr[1] = 0;
                bArr[2] = 0;
            } catch (IOException e) {
                e.printStackTrace();
            }
            byte[] bArr2 = {27, 74, 0};
            byte[] bArr3 = {29, 114, 73};
            int i = 5;
            byte[] bArr4 = {27, 42, 0, 0, 0};
            bArr4[2] = SmileConstants.TOKEN_LITERAL_NULL;
            bArr4[3] = (byte) (bitmap.getWidth() % 256);
            bArr4[4] = (byte) (bitmap.getWidth() / 256);
            int i2 = 0;
            while (i2 < (bitmap.getHeight() / 24) + 1) {
                try {
                    f7242c.write(bArr4, 0, i);
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                for (int i3 = 0; i3 < bitmap.getWidth(); i3++) {
                    for (int i4 = 0; i4 < 24; i4++) {
                        int i5 = (i2 * 24) + i4;
                        if (i5 < bitmap.getHeight() && Color.red(bitmap.getPixel(i3, i5)) == 0) {
                            int i6 = i4 / 8;
                            bArr[i6] = (byte) (bArr[i6] + ((byte) (128 >> (i4 % 8))));
                        }
                    }
                    try {
                        f7242c.write(bArr, 0, 3);
                        bArr[0] = 0;
                        bArr[1] = 0;
                        bArr[2] = 0;
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                try {
                    if (i2 % 10 == 0) {
                        f7242c.write(bArr3);
                        if (f7243d.readByte() == 0) {
                            f7242c.write(bArr2, 0, 3);
                        }
                    } else {
                        f7242c.write(bArr2, 0, 3);
                    }
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
                i2++;
                i = 5;
            }
            byte[] bArr5 = {27, 74, 64};
            try {
                f7242c.write(new byte[]{29, 122, 49});
                f7242c.write(bArr5);
                f7240a = f7243d.readByte();
                try {
                    f7242c.close();
                    f7243d.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
                return f7240a;
            } catch (IOException unused) {
                return 4095;
            }
        } catch (SocketException unused2) {
            return 4095;
        } catch (SocketTimeoutException unused3) {
            return 4095;
        } catch (UnknownHostException e6) {
            e6.printStackTrace();
            return 4095;
        } catch (IOException e7) {
            e7.printStackTrace();
            return 4095;
        }
    }

    /* renamed from: a */
    public static Bitmap m9440a(Context context) {
        f7246g = Bitmap.createBitmap(384, 85, Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(f7246g);
        canvas.drawColor(-1);
        Paint paint = new Paint();
        paint.setColor(-16777216);
        paint.setTextSize(20.0f);
        canvas.drawText(context.getResources().getString(C3671a.C3674c.print_launch), ColumnText.GLOBAL_SPACE_CHAR_RATIO, 20.0f, paint);
        canvas.drawLine(ColumnText.GLOBAL_SPACE_CHAR_RATIO, 40.0f, 384.0f, 40.0f, paint);
        canvas.drawText(context.getResources().getString(C3671a.C3674c.print_automobile_fault_diagnosis_test_report), 20.0f, 70.0f, paint);
        canvas.drawLine(ColumnText.GLOBAL_SPACE_CHAR_RATIO, 80.0f, 384.0f, 80.0f, paint);
        return f7246g;
    }

    /* renamed from: b */
    public static Bitmap m9433b(Context context) {
        f7246g = Bitmap.createBitmap(384, 45, Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(f7246g);
        canvas.drawColor(-1);
        Paint paint = new Paint();
        paint.setColor(-16777216);
        paint.setTextSize(20.0f);
        canvas.drawText(context.getResources().getString(C3671a.C3674c.print_launch), ColumnText.GLOBAL_SPACE_CHAR_RATIO, 20.0f, paint);
        canvas.drawLine(ColumnText.GLOBAL_SPACE_CHAR_RATIO, 25.0f, 384.0f, 25.0f, paint);
        return f7246g;
    }

    /* renamed from: a */
    public static Bitmap m9434a(String str) {
        TextPaint textPaint = new TextPaint();
        f7245f = textPaint;
        textPaint.setColor(-16777216);
        f7245f.setTextSize(20.0f);
        StaticLayout staticLayout = new StaticLayout(str, f7245f, 384, Layout.Alignment.ALIGN_NORMAL, 1.0f, ColumnText.GLOBAL_SPACE_CHAR_RATIO, true);
        f7247h = Bitmap.createBitmap(384, staticLayout.getHeight(), Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(f7247h);
        canvas.drawColor(-1);
        staticLayout.draw(canvas);
        return f7247h;
    }

    /* renamed from: a */
    public static Bitmap m9436a(Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap == null || bitmap2 == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(384, bitmap.getHeight() + bitmap2.getHeight(), Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, (Paint) null);
        canvas.drawBitmap(bitmap2, ColumnText.GLOBAL_SPACE_CHAR_RATIO, bitmap.getHeight(), (Paint) null);
        return createBitmap;
    }

    /* renamed from: a */
    public static void m9439a(Context context, int i) {
        Handler handler = new Handler(Looper.getMainLooper());
        if (context != null) {
            handler.post(new RunnableC1435f(i, context));
        }
    }

    /* renamed from: a */
    public static Bitmap m9437a(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(384.0f / width, ((height * 384) / width) / height);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        bitmap.recycle();
        return createBitmap;
    }

    /* renamed from: b */
    public static Bitmap m9432b(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        bitmap.getPixels(new int[width * height], 0, width, 0, 0, width, height);
        for (int i = 0; i < height; i++) {
            for (int i2 = 0; i2 < width; i2++) {
                int pixel = bitmap.getPixel(i2, i);
                if (((((16711680 & pixel) >> 16) + ((65280 & pixel) >> 8)) + (pixel & 255)) / 3 < 100) {
                    bitmap.setPixel(i2, i, -16777216);
                } else {
                    bitmap.setPixel(i2, i, -1);
                }
            }
        }
        return bitmap;
    }
}
