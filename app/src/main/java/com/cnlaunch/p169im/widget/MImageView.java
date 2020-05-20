package com.cnlaunch.p169im.widget;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.cnlaunch.golo3.p160b.ApplicationConfig;
import java.io.File;

/* renamed from: com.cnlaunch.im.widget.MImageView */
/* loaded from: classes.dex */
public class MImageView extends ImageView {

    /* renamed from: a */
    private SharedPreferences f9402a;

    /* renamed from: b */
    private String f9403b;

    public MImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9402a = null;
        this.f9402a = ApplicationConfig.f7802a.getSharedPreferences("chat_bg", 2);
    }

    public void setRomId(String str) {
        this.f9403b = str;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        if (i4 != 0) {
            if (i2 > i4) {
                SharedPreferences sharedPreferences = this.f9402a;
                String string = sharedPreferences.getString(ApplicationConfig.m9181a() + this.f9403b, null);
                if (string != null) {
                    try {
                        int round = Math.round((float) ((new File(string).length() / 1024) / 400));
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        if (round <= 1) {
                            round = 1;
                        }
                        options.inSampleSize = round;
                        Bitmap decodeFile = BitmapFactory.decodeFile(string, options);
                        if (decodeFile != null) {
                            setImageBitmap(null);
                            setImageBitmap(decodeFile);
                        }
                    } catch (OutOfMemoryError e) {
                        e.printStackTrace();
                    }
                } else {
                    setImageBitmap(null);
                }
            } else {
                float f = i2 / i4;
                SharedPreferences sharedPreferences2 = this.f9402a;
                String string2 = sharedPreferences2.getString(ApplicationConfig.m9181a() + this.f9403b, null);
                if (string2 != null) {
                    try {
                        int round2 = Math.round((float) ((new File(string2).length() / 1024) / 400));
                        BitmapFactory.Options options2 = new BitmapFactory.Options();
                        if (round2 <= 1) {
                            round2 = 1;
                        }
                        options2.inSampleSize = round2;
                        Bitmap decodeFile2 = BitmapFactory.decodeFile(string2, options2);
                        if (decodeFile2 != null) {
                            setImageBitmap(null);
                            setImageBitmap(Bitmap.createBitmap(decodeFile2, 0, 0, decodeFile2.getWidth(), Integer.parseInt(String.valueOf(decodeFile2.getHeight() * f).substring(0, String.valueOf(decodeFile2.getHeight() * f).lastIndexOf(".")))));
                        }
                    } catch (OutOfMemoryError e2) {
                        e2.printStackTrace();
                    }
                } else {
                    setImageBitmap(null);
                }
            }
        }
        super.onSizeChanged(i, i2, i3, i4);
    }
}
