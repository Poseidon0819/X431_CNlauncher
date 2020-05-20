package com.cnlaunch.golo3.view.selectimg;

import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.cnlaunch.golo3.p161c.BaseActivity;
import com.cnlaunch.golo3.p165g.CompressImgManager;
import com.cnlaunch.golo3.p165g.GoloActivityManager;
import com.cnlaunch.golo3.p165g.GoloLog;
import com.cnlaunch.golo3.view.GoloProgressDialog;
import com.cnlaunch.golo3.view.selectimg.p166a.SelectMoreImagesActivity;
import com.cnlaunch.golo3.view.selectimg.p166a.ThumbnailsUtil;
import com.cnlaunch.p132e.p133a.C1464a;
import com.itextpdf.text.Annotation;
import com.unionpay.tsmservice.data.Constant;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;

/* loaded from: classes.dex */
public class SelectPicActivity extends BaseActivity implements View.OnClickListener {

    /* renamed from: A */
    private Button f8544A;

    /* renamed from: B */
    private Button f8545B;

    /* renamed from: C */
    private Button f8546C;

    /* renamed from: z */
    int f8554z = 0;

    /* renamed from: D */
    private final int f8547D = 11;

    /* renamed from: E */
    private final int f8548E = 12;

    /* renamed from: F */
    private final int f8549F = 13;

    /* renamed from: G */
    private final int f8550G = 14;

    /* renamed from: H */
    private final int f8551H = 400;

    /* renamed from: I */
    private int f8552I = 2;

    /* renamed from: J */
    private String f8553J = FileConstant.f8692d + "selectImg";

    @Override // com.cnlaunch.golo3.p161c.BaseActivity, android.support.p012v4.app.FragmentActivity, android.support.p012v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Log.i(Constant.KEY_TAG, "SelectPicActivity onCreate");
        setContentView(C1464a.C1469e.layout_pic_menu);
        this.f8544A = (Button) findViewById(C1464a.C1468d.photograph_btn2);
        this.f8545B = (Button) findViewById(C1464a.C1468d.localPhotos_btn2);
        this.f8546C = (Button) findViewById(C1464a.C1468d.cancel_btn2);
        this.f8544A.setOnClickListener(this);
        this.f8545B.setOnClickListener(this);
        this.f8546C.setOnClickListener(this);
        String packageName = getPackageName();
        if (packageName != null && "com.cnlaunch.x431.diag".equals(packageName)) {
            this.f8544A.setBackgroundResource(C1464a.C1467c.classic_yellow_btn_bg);
            this.f8545B.setBackgroundResource(C1464a.C1467c.classic_yellow_btn_bg);
        }
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("getPicType")) {
            this.f8552I = intent.getIntExtra("getPicType", 1);
        }
        this.f8553J += new Date().getTime() + ".jpg";
    }

    @Override // android.support.p012v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // com.cnlaunch.golo3.p161c.BaseActivity, android.support.p012v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Log.i(Constant.KEY_TAG, "SelectPicActivity onDestroy");
    }

    @Override // com.cnlaunch.golo3.p161c.BaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == C1464a.C1468d.photograph_btn2) {
            if (!Environment.getExternalStorageState().equals("mounted")) {
                Toast.makeText(this, C1464a.C1470f.notSdCard, 0).show();
                return;
            }
            File file = new File(FileConstant.f8692d);
            if (!file.exists()) {
                file.mkdirs();
            }
            try {
                Intent intent = new Intent();
                if (getPackageManager().getLaunchIntentForPackage("com.android.camera") != null) {
                    intent.setPackage("com.android.camera");
                }
                intent.setAction("android.media.action.IMAGE_CAPTURE");
                intent.putExtra("output", Uri.fromFile(new File(this.f8553J)));
                startActivityForResult(intent, 11);
            } catch (Exception unused) {
                Toast.makeText(this, getString(C1464a.C1470f.no_camera), 0).show();
            }
        } else if (id == C1464a.C1468d.localPhotos_btn2) {
            Intent intent2 = new Intent("android.intent.action.GET_CONTENT");
            intent2.addCategory("android.intent.category.OPENABLE");
            intent2.setType("image/*");
            File file2 = new File(FileConstant.f8692d);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            if (this.f8552I == 2) {
                Intent intent3 = getIntent();
                intent3.setClass(this, SelectMoreImagesActivity.class);
                startActivityForResult(intent3, 14);
                return;
            }
            startActivityForResult(intent2, 12);
        } else if (id == C1464a.C1468d.cancel_btn2) {
            GoloActivityManager.m9138a();
            GoloActivityManager.m9135b(this);
        }
    }

    /* renamed from: a */
    private String m9095a(Uri uri) {
        Cursor managedQuery = managedQuery(uri, new String[]{"_data"}, null, null, null);
        int columnIndexOrThrow = managedQuery.getColumnIndexOrThrow("_data");
        managedQuery.moveToFirst();
        return managedQuery.getString(columnIndexOrThrow);
    }

    /* renamed from: a */
    private static String m9096a(Context context, Uri uri, String str, String[] strArr) {
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

    @Override // android.support.p012v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        String[] split;
        if (3 == i) {
            if (i2 == -1) {
                Intent intent2 = new Intent();
                intent2.putExtra("imgPath", ThumbnailsUtil.m9060a(this.f8553J));
                setResult(-1, intent2);
                GoloActivityManager.m9138a();
                GoloActivityManager.m9135b(this);
            }
        } else if (11 == i) {
            if (i2 == -1) {
                int i3 = this.f8552I;
                if (i3 == 0) {
                    Intent intent3 = new Intent();
                    intent3.putExtra("imgPath", ThumbnailsUtil.m9060a(this.f8553J));
                    setResult(-1, intent3);
                    GoloLog.m9133a();
                    GoloActivityManager.m9138a();
                    GoloActivityManager.m9135b(this);
                } else if (i3 == 1) {
                    Intent intent4 = new Intent(this, CropImageActivity.class);
                    intent4.putExtra("path", this.f8553J);
                    intent4.putExtra("pathBack", this.f8553J);
                    startActivityForResult(intent4, 3);
                } else {
                    ArrayList<String> arrayList = new ArrayList<>();
                    arrayList.add(this.f8553J);
                    CompressImgManager compressImgManager = new CompressImgManager();
                    GoloProgressDialog.m9105a(this, getString(C1464a.C1470f.string_loading));
                    compressImgManager.m9147a(arrayList, new C1655q(this));
                }
            }
        } else if (12 == i) {
            if (i2 == -1 && intent != null) {
                Uri data = intent.getData();
                if (!TextUtils.isEmpty(data.getAuthority())) {
                    String m9095a = m9095a(data);
                    if (Build.VERSION.SDK_INT < 19) {
                        m9095a(data);
                    } else {
                        Uri uri = null;
                        if (!(Build.VERSION.SDK_INT >= 19) || !DocumentsContract.isDocumentUri(this, data)) {
                            if (!"content".equalsIgnoreCase(data.getScheme())) {
                                if (Annotation.FILE.equalsIgnoreCase(data.getScheme())) {
                                    m9095a = data.getPath();
                                }
                                m9095a = null;
                            } else if ("com.google.android.apps.photos.content".equals(data.getAuthority())) {
                                m9095a = data.getLastPathSegment();
                            } else {
                                m9095a = m9096a(this, data, (String) null, (String[]) null);
                            }
                        } else if ("com.android.externalstorage.documents".equals(data.getAuthority())) {
                            if ("primary".equalsIgnoreCase(DocumentsContract.getDocumentId(data).split(":")[0])) {
                                m9095a = Environment.getExternalStorageDirectory() + "/" + split[1];
                            }
                            m9095a = null;
                        } else if ("com.android.providers.downloads.documents".equals(data.getAuthority())) {
                            m9095a = m9096a(this, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(DocumentsContract.getDocumentId(data)).longValue()), (String) null, (String[]) null);
                        } else {
                            if ("com.android.providers.media.documents".equals(data.getAuthority())) {
                                String[] split2 = DocumentsContract.getDocumentId(data).split(":");
                                String str = split2[0];
                                if ("image".equals(str)) {
                                    uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                                } else if ("video".equals(str)) {
                                    uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                                } else if ("audio".equals(str)) {
                                    uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                                }
                                m9095a = m9096a(this, uri, "_id=?", new String[]{split2[1]});
                            }
                            m9095a = null;
                        }
                    }
                    StringBuilder sb = new StringBuilder("uri url==");
                    sb.append(m9095a);
                    sb.append("//");
                    GoloLog.m9133a();
                    Intent intent5 = new Intent(this, CropImageActivity.class);
                    if (this.f8552I == 0) {
                        intent5.putExtra("imgPath", ThumbnailsUtil.m9060a(m9095a));
                        setResult(-1, intent5);
                        GoloActivityManager.m9138a();
                        GoloActivityManager.m9135b(this);
                    } else {
                        intent5.putExtra("path", m9095a);
                        intent5.putExtra("pathBack", this.f8553J);
                        startActivityForResult(intent5, 3);
                    }
                } else {
                    Intent intent6 = new Intent(this, CropImageActivity.class);
                    intent6.putExtra("path", data.getPath());
                    intent6.putExtra("pathBack", this.f8553J);
                    startActivityForResult(intent6, 3);
                }
            }
        } else if (14 == i && i2 == -1 && intent != null) {
            setResult(-1, intent);
            GoloActivityManager.m9138a();
            GoloActivityManager.m9135b(this);
        }
        if (intent == null) {
        }
    }
}
