package com.cnlaunch.x431pro.activity.diagnose.p223f;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.widget.TextView;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.physics.p195b.DownloadBinUpdate;
import com.cnlaunch.physics.p201g.OnDownloadBinListener;
import com.cnlaunch.physics.p205k.C1856n;
import com.cnlaunch.x431pro.activity.bluetooth.DownloadBinActivity;
import com.cnlaunch.x431pro.activity.diagnose.p222e.IFragmentCallback;
import com.cnlaunch.x431pro.utils.PathUtils;
import com.cnlaunch.x431pro.widget.p290a.WaitDialog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

@SuppressLint({"HandlerLeak"})
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.f.c */
/* loaded from: classes.dex */
public final class DiagnoseWaitDialog extends WaitDialog {

    /* renamed from: a */
    OnDownloadBinListener f12443a;

    /* renamed from: c */
    private String f12444c;

    /* renamed from: d */
    private DownloadBinUpdate f12445d;

    /* renamed from: e */
    private IFragmentCallback f12446e;

    /* renamed from: f */
    private int f12447f;

    /* renamed from: g */
    private Context f12448g;

    /* renamed from: h */
    private Handler f12449h;

    public DiagnoseWaitDialog(Context context, String str, IFragmentCallback iFragmentCallback) {
        super(context, str);
        this.f12445d = null;
        this.f12446e = null;
        this.f12447f = 0;
        this.f12443a = new C2189e(this);
        this.f12449h = new HandlerC2190f(this);
        this.f12446e = iFragmentCallback;
        this.f12448g = context;
    }

    /* renamed from: a */
    public final void m7059a(String str) {
        TextView textView = (TextView) findViewById(16908299);
        if (textView != null) {
            textView.setText(str);
        }
    }

    /* renamed from: a */
    public final void m7064a() {
        this.f12444c = PreferencesManager.m9595a(getContext()).m9591a("serialNo");
        new C2188d(this).start();
    }

    /* renamed from: a */
    public static void m7062a(Context context, String str, String str2, String str3) {
        Intent intent = new Intent();
        intent.setClass(context, DownloadBinActivity.class);
        if (C1856n.f10135a) {
            C1856n.m8130a("DiagnoseWaitDialog", "startDownloadBinActivity  downloadVersion =" + str + " deviceVersion= " + str2 + " downloadBinPath= " + str3);
        }
        intent.putExtra("DownloadBin_Ver", str);
        intent.putExtra("DownloadBin_Dev_Ver", str2);
        intent.putExtra("DownloadBin_Path", str3);
        context.startActivity(intent);
    }

    /* renamed from: a */
    public static String m7063a(Context context, String str) {
        String str2 = PathUtils.m4854d(context, str) + "Diagnostic/Configure/Download/DOWNLOAD.ini";
        if (C1856n.f10135a) {
            C1856n.m8130a("DiagnoseWaitDialog", "getDownloadBinPath  currentSerialNo =" + str + " DownloadBinPath= " + str2);
        }
        return str2;
    }

    /* renamed from: b */
    public static String m7058b(Context context, String str) {
        File file = new File(m7063a(context, str));
        if (file.isFile()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                Properties properties = new Properties();
                try {
                    properties.load(fileInputStream);
                    if (properties.get("Version") != null) {
                        StringBuffer stringBuffer = new StringBuffer(properties.get("Version").toString());
                        if (stringBuffer.length() > 0 && stringBuffer.charAt(0) != 'V' && stringBuffer.charAt(0) != 'v') {
                            stringBuffer.insert(0, 'V');
                        }
                        return stringBuffer.toString();
                    }
                    return null;
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m7057b(android.content.Context r6, java.lang.String r7, java.lang.String r8, java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 279
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.x431pro.activity.diagnose.p223f.DiagnoseWaitDialog.m7057b(android.content.Context, java.lang.String, java.lang.String, java.lang.String):boolean");
    }
}
