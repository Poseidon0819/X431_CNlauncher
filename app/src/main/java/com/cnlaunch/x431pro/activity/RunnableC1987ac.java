package com.cnlaunch.x431pro.activity;

import android.os.AsyncTask;
import com.cnlaunch.p120d.p125c.p126a.AsyncTaskManager;
import com.cnlaunch.physics.p205k.C1856n;
import com.cnlaunch.x431pro.utils.C2778n;
import com.cnlaunch.x431pro.utils.PathUtils;
import com.itextpdf.text.pdf.PdfContentParser;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MainActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.ac */
/* loaded from: classes.dex */
public final class RunnableC1987ac implements Runnable {

    /* renamed from: a */
    final /* synthetic */ MainActivity f10882a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1987ac(MainActivity mainActivity) {
        this.f10882a = mainActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (C2778n.m4917a(this.f10882a.f10736a)) {
            String[] list = new File(PathUtils.m4848h()).list();
            if (list == null || list.length == 0) {
                C1856n.m8125d(this.f10882a.f10738d, "特殊功能诊断日志文件不存在");
                return;
            }
            AsyncTaskManager.m9574a(this.f10882a.f10736a);
            AsyncTask.Status m9577a = AsyncTaskManager.m9577a();
            if (m9577a == null || m9577a == AsyncTask.Status.FINISHED) {
                if (m9577a == null) {
                    C1856n.m8125d(this.f10882a.f10738d, "SPACIAL_DIAGNOSE_LOG_FEEDBACK status is null");
                }
                C1856n.m8125d(this.f10882a.f10738d, "AUTO SPACIAL_DIAGNOSE_LOG_FEEDBACK ");
                this.f10882a.m7906a(PdfContentParser.COMMAND_TYPE, true);
            }
        }
    }
}
