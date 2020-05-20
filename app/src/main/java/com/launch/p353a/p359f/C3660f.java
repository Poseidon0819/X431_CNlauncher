package com.launch.p353a.p359f;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.launch.p353a.p357d.BitmapCacheUtils;
import com.launch.p353a.p362i.IHttpFinishedListener;
import com.launch.p353a.p362i.ImageLoaderListener;
import com.launch.p353a.p364k.C3669j;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ImageManager.java */
/* renamed from: com.launch.a.f.f */
/* loaded from: classes.dex */
public final class C3660f implements IHttpFinishedListener {

    /* renamed from: a */
    final /* synthetic */ ImageView f19952a;

    /* renamed from: b */
    final /* synthetic */ String f19953b;

    /* renamed from: c */
    final /* synthetic */ File f19954c;

    /* renamed from: d */
    final /* synthetic */ ImageManager f19955d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3660f(ImageManager imageManager, ImageView imageView, String str, File file) {
        this.f19955d = imageManager;
        this.f19952a = imageView;
        this.f19953b = str;
        this.f19954c = file;
    }

    @Override // com.launch.p353a.p362i.IHttpFinishedListener
    /* renamed from: a */
    public final void mo2650a(Object obj) {
        ImageLoaderListener imageLoaderListener;
        FileOutputStream fileOutputStream;
        ImageLoaderListener imageLoaderListener2;
        Bitmap bitmap = (Bitmap) obj;
        imageLoaderListener = this.f19955d.f19949a;
        if (imageLoaderListener != null) {
            imageLoaderListener2 = this.f19955d.f19949a;
            imageLoaderListener2.mo2648a(bitmap);
        }
        BitmapCacheUtils.m2703a().m2701a(C3669j.m2621a(this.f19953b), bitmap);
        if (this.f19954c.exists()) {
            this.f19954c.delete();
        }
        File file = this.f19954c;
        FileOutputStream fileOutputStream2 = null;
        byte[] byteArray = null;
        try {
            if (file.exists()) {
                file.delete();
            }
            fileOutputStream = new FileOutputStream(file);
            if (bitmap != null) {
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                    byteArray = byteArrayOutputStream.toByteArray();
                } catch (Exception unused) {
                    fileOutputStream2 = fileOutputStream;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                            return;
                        } catch (Exception unused2) {
                            return;
                        }
                    }
                    return;
                } catch (Throwable th) {
                    th = th;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception unused3) {
                        }
                    }
                    throw th;
                }
            }
            fileOutputStream.write(byteArray);
            fileOutputStream.flush();
            try {
                fileOutputStream.close();
            } catch (Exception unused4) {
            }
        } catch (Exception unused5) {
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
        }
    }

    @Override // com.launch.p353a.p362i.IHttpFinishedListener
    /* renamed from: a */
    public final void mo2649a(String str, int i) {
        ImageLoaderListener imageLoaderListener;
        ImageLoaderListener imageLoaderListener2;
        imageLoaderListener = this.f19955d.f19949a;
        if (imageLoaderListener != null) {
            imageLoaderListener2 = this.f19955d.f19949a;
            imageLoaderListener2.mo2647a(this.f19953b, str);
        }
    }
}
