package com.cnlaunch.x431pro.utils;

import android.app.Activity;
import android.app.Fragment;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import com.cnlaunch.golo3.view.selectimg.CropImageActivity;
import com.cnlaunch.golo3.view.selectimg.clip.ClipImageActivity;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.p210a.ApplicationTheme;
import com.ifoer.expedition.pro.R;
import com.itextpdf.text.Annotation;
import java.io.File;

/* renamed from: com.cnlaunch.x431pro.utils.w */
/* loaded from: classes.dex */
public final class SelectPhotoUtils {

    /* renamed from: a */
    public static Uri f15945a = null;

    /* renamed from: c */
    private static boolean f15946c = false;

    /* renamed from: b */
    private Context f15947b;

    /* renamed from: d */
    private Fragment f15948d;

    /* renamed from: e */
    private Activity f15949e;

    public SelectPhotoUtils(Context context, Fragment fragment) {
        this.f15947b = context;
        this.f15948d = fragment;
        f15946c = Build.VERSION.SDK_INT >= 19;
        this.f15949e = fragment.getActivity();
    }

    /* renamed from: a */
    public final void m4831a(String str) {
        try {
            Intent intent = new Intent();
            if (this.f15947b.getPackageManager().getLaunchIntentForPackage("com.android.camera") != null) {
                intent.setPackage("com.android.camera");
            }
            intent.setAction("android.media.action.IMAGE_CAPTURE");
            intent.putExtra("output", Uri.fromFile(new File(str)));
            m4832a(intent, 1);
        } catch (Exception e) {
            e.printStackTrace();
            Context context = this.f15947b;
            NToast.m9446b(context, context.getResources().getString(R.string.no_camera));
        }
    }

    /* renamed from: a */
    public final void m4835a(int i) {
        if (!f15946c) {
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.setType("image/*");
            m4832a(intent, i);
            return;
        }
        Intent intent2 = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent2.addCategory("android.intent.category.OPENABLE");
        intent2.setType("image/*");
        m4832a(intent2, i);
    }

    /* renamed from: a */
    public static String m4834a(Context context, Uri uri) {
        Uri uri2 = null;
        if (!f15946c || !DocumentsContract.isDocumentUri(context, uri)) {
            if (!"content".equalsIgnoreCase(uri.getScheme())) {
                if (Annotation.FILE.equalsIgnoreCase(uri.getScheme())) {
                    return uri.getPath();
                }
            } else if ("com.google.android.apps.photos.content".equals(uri.getAuthority())) {
                return uri.getLastPathSegment();
            } else {
                return m4833a(context, uri, null, null);
            }
        } else if ("com.android.externalstorage.documents".equals(uri.getAuthority())) {
            String[] split = DocumentsContract.getDocumentId(uri).split(":");
            if ("primary".equalsIgnoreCase(split[0])) {
                return Environment.getExternalStorageDirectory() + "/" + split[1];
            }
        } else if ("com.android.providers.downloads.documents".equals(uri.getAuthority())) {
            return m4833a(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(DocumentsContract.getDocumentId(uri)).longValue()), null, null);
        } else {
            if ("com.android.providers.media.documents".equals(uri.getAuthority())) {
                String[] split2 = DocumentsContract.getDocumentId(uri).split(":");
                String str = split2[0];
                if ("image".equals(str)) {
                    uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                } else if ("video".equals(str)) {
                    uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                } else if ("audio".equals(str)) {
                    uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                }
                return m4833a(context, uri2, "_id=?", new String[]{split2[1]});
            }
        }
        return null;
    }

    /* renamed from: a */
    private static String m4833a(Context context, Uri uri, String str, String[] strArr) {
        Cursor cursor;
        try {
            cursor = context.getContentResolver().query(uri, new String[]{"_data"}, str, strArr, null);
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        String string = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
                        if (cursor != null) {
                            cursor.close();
                        }
                        return string;
                    }
                } catch (Throwable th) {
                    th = th;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
    }

    /* renamed from: a */
    public final void m4830a(String str, String str2) {
        Intent intent = new Intent(this.f15947b, CropImageActivity.class);
        intent.putExtra("path", str);
        intent.putExtra("pathBack", str2);
        m4832a(intent, 4);
    }

    /* renamed from: b */
    public final void m4829b(String str, String str2) {
        Intent intent = new Intent(this.f15949e, ClipImageActivity.class);
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        intent.putExtra("inputPath", str);
        intent.putExtra("outputPath", str2);
        intent.putExtra("isCircle", false);
        intent.putExtra("theme", ApplicationTheme.m7977a(PreferencesManager.m9595a(this.f15947b).m9585b("theme_type", 0)));
        m4832a(intent, 4);
    }

    /* renamed from: a */
    private void m4832a(Intent intent, int i) {
        Activity activity = this.f15949e;
        if (activity != null) {
            activity.startActivityForResult(intent, i);
        } else {
            this.f15948d.startActivityForResult(intent, i);
        }
    }
}
