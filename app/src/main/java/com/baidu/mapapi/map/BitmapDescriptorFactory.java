package com.baidu.mapapi.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapsdkplatform.comapi.commonutils.C1190a;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* loaded from: classes.dex */
public class BitmapDescriptorFactory {

    /* renamed from: a */
    static final /* synthetic */ boolean f4984a = !BitmapDescriptorFactory.class.desiredAssertionStatus();

    public static BitmapDescriptor fromAsset(String str) {
        Context context = BMapManager.getContext();
        if (context == null) {
            return null;
        }
        try {
            Bitmap m10820a = C1190a.m10820a(str, context);
            BitmapDescriptor fromBitmap = fromBitmap(m10820a);
            if (!f4984a && m10820a == null) {
                throw new AssertionError();
            }
            m10820a.recycle();
            return fromBitmap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0061 A[Catch: Exception -> 0x0065, TRY_LEAVE, TryCatch #0 {Exception -> 0x0065, blocks: (B:5:0x0008, B:8:0x000f, B:10:0x0017, B:11:0x0031, B:17:0x005c, B:19:0x0061, B:15:0x003c, B:16:0x0057), top: B:24:0x0008 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.baidu.mapapi.map.BitmapDescriptor fromAssetWithDpi(java.lang.String r9) {
        /*
            android.content.Context r0 = com.baidu.mapapi.BMapManager.getContext()
            r1 = 0
            if (r0 != 0) goto L8
            return r1
        L8:
            android.graphics.Bitmap r9 = com.baidu.mapsdkplatform.comapi.commonutils.C1190a.m10820a(r9, r0)     // Catch: java.lang.Exception -> L65
            if (r9 != 0) goto Lf
            return r1
        Lf:
            int r0 = com.baidu.mapapi.common.SysOSUtil.getDensityDpi()     // Catch: java.lang.Exception -> L65
            r2 = 480(0x1e0, float:6.73E-43)
            if (r0 <= r2) goto L36
            android.graphics.Matrix r7 = new android.graphics.Matrix     // Catch: java.lang.Exception -> L65
            r7.<init>()     // Catch: java.lang.Exception -> L65
            r0 = 1073741824(0x40000000, float:2.0)
            r7.postScale(r0, r0)     // Catch: java.lang.Exception -> L65
            r3 = 0
            r4 = 0
            int r5 = r9.getWidth()     // Catch: java.lang.Exception -> L65
            int r6 = r9.getHeight()     // Catch: java.lang.Exception -> L65
            r8 = 1
            r2 = r9
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Exception -> L65
        L31:
            com.baidu.mapapi.map.BitmapDescriptor r2 = fromBitmap(r0)     // Catch: java.lang.Exception -> L65
            goto L5c
        L36:
            r3 = 320(0x140, float:4.48E-43)
            if (r0 <= r3) goto L57
            if (r0 > r2) goto L57
            android.graphics.Matrix r7 = new android.graphics.Matrix     // Catch: java.lang.Exception -> L65
            r7.<init>()     // Catch: java.lang.Exception -> L65
            r0 = 1069547520(0x3fc00000, float:1.5)
            r7.postScale(r0, r0)     // Catch: java.lang.Exception -> L65
            r3 = 0
            r4 = 0
            int r5 = r9.getWidth()     // Catch: java.lang.Exception -> L65
            int r6 = r9.getHeight()     // Catch: java.lang.Exception -> L65
            r8 = 1
            r2 = r9
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Exception -> L65
            goto L31
        L57:
            com.baidu.mapapi.map.BitmapDescriptor r2 = fromBitmap(r9)     // Catch: java.lang.Exception -> L65
            r0 = r1
        L5c:
            r9.recycle()     // Catch: java.lang.Exception -> L65
            if (r0 == 0) goto L64
            r0.recycle()     // Catch: java.lang.Exception -> L65
        L64:
            return r2
        L65:
            r9 = move-exception
            r9.printStackTrace()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapapi.map.BitmapDescriptorFactory.fromAssetWithDpi(java.lang.String):com.baidu.mapapi.map.BitmapDescriptor");
    }

    public static BitmapDescriptor fromBitmap(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return new BitmapDescriptor(bitmap);
    }

    public static BitmapDescriptor fromFile(String str) {
        if (str != null && !str.equals("")) {
            try {
                Context context = BMapManager.getContext();
                if (context != null) {
                    FileInputStream openFileInput = context.openFileInput(str);
                    Bitmap decodeStream = BitmapFactory.decodeStream(openFileInput);
                    openFileInput.close();
                    if (decodeStream != null) {
                        BitmapDescriptor fromBitmap = fromBitmap(decodeStream);
                        decodeStream.recycle();
                        return fromBitmap;
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public static BitmapDescriptor fromPath(String str) {
        Bitmap decodeFile = BitmapFactory.decodeFile(str);
        if (decodeFile == null || decodeFile == null) {
            return null;
        }
        BitmapDescriptor fromBitmap = fromBitmap(decodeFile);
        decodeFile.recycle();
        return fromBitmap;
    }

    public static BitmapDescriptor fromResource(int i) {
        Bitmap decodeResource;
        Context context = BMapManager.getContext();
        if (context == null || (decodeResource = BitmapFactory.decodeResource(context.getResources(), i)) == null) {
            return null;
        }
        BitmapDescriptor fromBitmap = fromBitmap(decodeResource);
        decodeResource.recycle();
        return fromBitmap;
    }

    public static BitmapDescriptor fromView(View view) {
        if (view == null) {
            return null;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        view.buildDrawingCache();
        Bitmap drawingCache = view.getDrawingCache();
        BitmapDescriptor fromBitmap = fromBitmap(drawingCache);
        if (drawingCache != null) {
            drawingCache.recycle();
        }
        view.destroyDrawingCache();
        return fromBitmap;
    }
}
