package com.cnlaunch.x431pro.activity.setting;

import android.widget.Button;
import com.cnlaunch.p120d.p125c.p127b.DownLoadCallback;
import com.cnlaunch.p120d.p125c.p127b.DownloadManager;
import com.cnlaunch.x431pro.activity.setting.CheckServerFragment;
import com.cnlaunch.x431pro.module.p269j.p271b.X431PadDtoSoft;
import java.util.Date;
import java.util.List;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

/* compiled from: CheckServerFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.setting.g */
/* loaded from: classes.dex */
final class HandlerC2563g extends DownLoadCallback {

    /* renamed from: a */
    int f14796a = 0;

    /* renamed from: b */
    final /* synthetic */ CheckServerFragment f14797b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC2563g(CheckServerFragment checkServerFragment) {
        this.f14797b = checkServerFragment;
    }

    @Override // com.cnlaunch.p120d.p125c.p127b.DownLoadCallback
    /* renamed from: a */
    public final void mo4520a(String str, int i, int i2) {
        List<CheckServerFragment.C2558a> list;
        super.mo4520a(str, i, i2);
        list = this.f14797b.f14772q;
        for (CheckServerFragment.C2558a c2558a : list) {
            if (str.equals(c2558a.f14782a)) {
                c2558a.f14785d = i2;
            }
        }
    }

    @Override // com.cnlaunch.p120d.p125c.p127b.DownLoadCallback
    /* renamed from: a */
    public final void mo4519a(String str, String str2) {
        List<CheckServerFragment.C2558a> list;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        Button button;
        Button button2;
        DownloadManager downloadManager;
        super.mo4519a(str, str2);
        list = this.f14797b.f14772q;
        for (CheckServerFragment.C2558a c2558a : list) {
            if (str.equals(c2558a.f14782a)) {
                c2558a.f14784c = new Date(System.currentTimeMillis());
                StringBuilder sb = new StringBuilder();
                str3 = this.f14797b.f14746ai;
                sb.append(str3);
                sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                sb.append(str);
                sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                str4 = this.f14797b.f14749al;
                sb.append(str4);
                String sb2 = sb.toString();
                CheckServerFragment checkServerFragment = this.f14797b;
                str5 = checkServerFragment.f14743af;
                checkServerFragment.m5942a(sb2, str5);
                for (X431PadDtoSoft x431PadDtoSoft : this.f14797b.f14737Z) {
                    if (str.equals(x431PadDtoSoft.getFileName())) {
                        long j = c2558a.f14785d;
                        double d = 0.0d;
                        if (j > 0) {
                            double d2 = j / 1024;
                            double m5920a = c2558a.m5920a();
                            Double.isNaN(d2);
                            double round = Math.round((d2 / m5920a) * 1000.0d);
                            Double.isNaN(round);
                            d = round / 1000.0d;
                        }
                        CheckServerFragment.m5938b(this.f14797b.f14780y, ("CN".equals(this.f14797b.f14779x) || "TW".equals(this.f14797b.f14779x)) ? "\n文件下载测试：\n返回结果：文件名称:" + str + ",下载结果:成功,下载耗时" + c2558a.m5920a() + "秒,下载速度:" + d + "kb/s\n" : "\nTesting file downloading：\nResults：File name:" + str + ",Download Results:Success,Time of " + c2558a.m5920a() + "seconds,Speed of " + d + "kb/s\n");
                        CheckServerFragment checkServerFragment2 = this.f14797b;
                        x431PadDtoSoft.getSoftPackageID();
                        new CheckServerFragment.C2560c(str, str2).start();
                        downloadManager = this.f14797b.f14734W;
                        downloadManager.m9545c(str);
                    }
                }
                this.f14796a++;
                if (this.f14796a == this.f14797b.f14737Z.size()) {
                    if ("CN".equals(this.f14797b.f14779x) || "TW".equals(this.f14797b.f14779x)) {
                        CheckServerFragment.m5938b(this.f14797b.f14780y, "\n检测完毕。\n");
                    } else {
                        CheckServerFragment.m5938b(this.f14797b.f14780y, "\nServer test is done. \n");
                    }
                    CheckServerFragment checkServerFragment3 = this.f14797b;
                    StringBuilder sb3 = new StringBuilder();
                    str6 = this.f14797b.f14745ah;
                    sb3.append(str6);
                    sb3.append("\n");
                    str7 = this.f14797b.f14744ag;
                    sb3.append(str7);
                    checkServerFragment3.m5942a(sb3.toString(), "");
                    button = this.f14797b.f14759d;
                    button.setEnabled(true);
                    button2 = this.f14797b.f14760e;
                    button2.setEnabled(true);
                }
            }
        }
    }

    @Override // com.cnlaunch.p120d.p125c.p127b.DownLoadCallback
    /* renamed from: b */
    public final void mo4518b(String str, String str2) {
        List list;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        Button button;
        Button button2;
        super.mo4518b(str, str2);
        CheckServerFragment.C2559b c2559b = new CheckServerFragment.C2559b();
        c2559b.m5918a(1206, -1, str + ":" + str2);
        list = this.f14797b.f14773r;
        list.add(c2559b);
        StringBuilder sb = new StringBuilder();
        str3 = this.f14797b.f14746ai;
        sb.append(str3);
        sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        sb.append(str);
        sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        str4 = this.f14797b.f14749al;
        sb.append(str4);
        String sb2 = sb.toString();
        CheckServerFragment checkServerFragment = this.f14797b;
        str5 = checkServerFragment.f14747aj;
        checkServerFragment.m5942a(sb2, str5);
        if ("CN".equals(this.f14797b.f14779x) || "TW".equals(this.f14797b.f14779x)) {
            str6 = "文件名称:" + str + ",下载结果:失败,失败信息" + str2 + "\n";
        } else {
            str6 = "File name:" + str + ",Download Results:Failed,Error message:" + str2 + "\n";
        }
        CheckServerFragment.m5938b(this.f14797b.f14780y, str6);
        this.f14796a++;
        if (this.f14796a == this.f14797b.f14737Z.size()) {
            if ("CN".equals(this.f14797b.f14779x) || "TW".equals(this.f14797b.f14779x)) {
                CheckServerFragment.m5938b(this.f14797b.f14780y, "\n检测完毕。\n");
            } else {
                CheckServerFragment.m5938b(this.f14797b.f14780y, "\nServer test is done. \n");
            }
            CheckServerFragment checkServerFragment2 = this.f14797b;
            StringBuilder sb3 = new StringBuilder();
            str7 = this.f14797b.f14745ah;
            sb3.append(str7);
            sb3.append("\n");
            str8 = this.f14797b.f14744ag;
            sb3.append(str8);
            checkServerFragment2.m5942a(sb3.toString(), "");
            button = this.f14797b.f14759d;
            button.setEnabled(true);
            button2 = this.f14797b.f14760e;
            button2.setEnabled(true);
        }
    }
}
