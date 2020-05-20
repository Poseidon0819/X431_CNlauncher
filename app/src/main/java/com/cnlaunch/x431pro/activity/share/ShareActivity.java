package com.cnlaunch.x431pro.activity.share;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.cnlaunch.x431pro.activity.BaseDialogActivity;
import com.cnlaunch.x431pro.activity.MainActivity;
import com.cnlaunch.x431pro.activity.share.p236a.ShareAdapter;
import com.cnlaunch.x431pro.utils.p285e.FileUtils;
import com.ifoer.expedition.pro.R;
import com.itextpdf.text.Meta;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/* loaded from: classes.dex */
public class ShareActivity extends BaseDialogActivity implements AdapterView.OnItemClickListener {

    /* renamed from: c */
    private String f14947c;

    /* renamed from: d */
    private Context f14948d;

    /* renamed from: a */
    private GridView f14945a = null;

    /* renamed from: b */
    private String f14946b = "";

    /* renamed from: e */
    private ArrayList<Intent> f14949e = new ArrayList<>();

    /* renamed from: f */
    private ArrayList<ResolveInfo> f14950f = new ArrayList<>();

    @Override // com.cnlaunch.x431pro.activity.BaseDialogActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_share);
        this.f14948d = this;
        m5824a();
        Intent intent = getIntent();
        if (intent != null) {
            this.f14946b = intent.getStringExtra("FilePath");
        }
        new ArrayList();
        try {
            this.f14947c = this.f14948d.getPackageManager().getPackageInfo(this.f14948d.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        Intent intent2 = new Intent("android.intent.action.SEND");
        intent2.setType("text/plain");
        String format = new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss").format(new Date());
        File file = new File(this.f14946b);
        if (file.getName().endsWith(".jpg")) {
            intent2.setType("image/*");
        } else if (file.getName().endsWith(".txt")) {
            intent2.setType("text/plain");
        } else if (file.getName().endsWith(".pdf")) {
            intent2.setType("application/pdf");
        } else if (file.getName().endsWith(".zip")) {
            intent2.setType("application/x-zip-compressed");
        } else {
            intent2.setType("application/octet-stream");
        }
        ArrayList arrayList = (ArrayList) getPackageManager().queryIntentActivities(intent2, 0);
        for (int i = 0; i < arrayList.size(); i++) {
            ResolveInfo resolveInfo = (ResolveInfo) arrayList.get(i);
            Intent intent3 = new Intent("android.intent.action.SEND");
            intent3.setType("text/plain");
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            if (((!MainActivity.m7907a() && !file.getName().endsWith(".zip")) || !activityInfo.packageName.contains("bluetooth")) && !activityInfo.packageName.contains("reader") && (!file.getName().endsWith(".zip") || !activityInfo.packageName.contains("brprint"))) {
                if (file.getName().endsWith(".jpg")) {
                    intent3.setType("image/*");
                } else if (file.getName().endsWith(".txt")) {
                    intent3.setType("text/plain");
                } else if (file.getName().endsWith(".pdf")) {
                    intent3.setType("application/pdf");
                } else if (file.getName().endsWith(".zip")) {
                    intent3.setType("application/x-zip-compressed");
                } else {
                    intent3.setType("application/octet-stream");
                }
                intent3.putExtra(Meta.SUBJECT, file.getName());
                if (file.getName().endsWith(".zip") || file.getName().endsWith(".pdf") || file.getName().endsWith(".jpg")) {
                    intent3.putExtra("android.intent.extra.TEXT", "V" + this.f14947c + "  DATE:" + format);
                } else {
                    intent3.putExtra("android.intent.extra.TEXT", FileUtils.m5002c(this.f14946b));
                }
                intent3.putExtra("android.intent.extra.SUBJECT", this.f14948d.getResources().getString(R.string.mine_tv_diagnosis_report));
                intent3.putExtra("android.intent.extra.STREAM", Uri.fromFile(file));
                if (activityInfo.packageName.contains("mms") || activityInfo.packageName.contains("email") || activityInfo.packageName.contains("weibo")) {
                    intent3.putExtra("android.intent.extra.STREAM", Uri.fromFile(file));
                } else {
                    activityInfo.packageName.contains("bluetooth");
                }
                intent3.setPackage(activityInfo.packageName);
                this.f14949e.add(intent3);
                this.f14950f.add(resolveInfo);
            }
        }
        this.f14945a = (GridView) findViewById(R.id.lv_share);
        this.f14945a.setAdapter((ListAdapter) new ShareAdapter(this.f14950f, this));
        this.f14945a.setOnItemClickListener(this);
        TextView textView = (TextView) findViewById(R.id.tv_shareisnull);
        ArrayList<ResolveInfo> arrayList2 = this.f14950f;
        if (arrayList2 == null || arrayList2.size() == 0) {
            textView.setVisibility(0);
            this.f14945a.setVisibility(8);
            return;
        }
        textView.setVisibility(8);
        this.f14945a.setVisibility(0);
    }

    /* renamed from: a */
    private void m5824a() {
        int integer = getResources().getInteger(R.integer.share_width_size);
        int integer2 = getResources().getInteger(R.integer.share_height_size);
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.flags = 2;
        attributes.dimAmount = 0.4f;
        window.setLayout((window.getWindowManager().getDefaultDisplay().getWidth() * integer) / 100, (window.getWindowManager().getDefaultDisplay().getHeight() * integer2) / 100);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        try {
            startActivity(this.f14949e.get(i));
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        finish();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m5824a();
    }
}
