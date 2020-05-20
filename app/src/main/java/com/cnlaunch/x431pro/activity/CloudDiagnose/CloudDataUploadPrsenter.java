package com.cnlaunch.x431pro.activity.CloudDiagnose;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.x431pro.module.cloud.model.CloudData;
import com.cnlaunch.x431pro.module.cloud.p247a.CloudAction;
import com.cnlaunch.x431pro.module.p241a.BasePresenter;
import com.cnlaunch.x431pro.module.p241a.PresenterCallback;
import com.cnlaunch.x431pro.utils.p285e.FileUtils;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.activity.CloudDiagnose.c */
/* loaded from: classes.dex */
public final class CloudDataUploadPrsenter extends BasePresenter {

    /* renamed from: d */
    private List<CloudData> f10613d;

    /* renamed from: e */
    private final int f10614e;

    /* renamed from: f */
    private int f10615f;

    /* renamed from: g */
    private String f10616g;

    public CloudDataUploadPrsenter(Context context) {
        super(context);
        this.f10614e = 3;
        this.f10615f = 3;
    }

    /* renamed from: a */
    public final void m7932a(List<CloudData> list, PresenterCallback presenterCallback) {
        this.f15453c = presenterCallback;
        this.f10613d = list;
        this.f10616g = this.f10613d.get(0).f15496f;
        m5435a();
    }

    @Override // com.cnlaunch.x431pro.module.p241a.BasePresenter, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public final Object doInBackground(int i) throws C1425f {
        if (i == 100 && this.f10613d.size() > 0) {
            return Boolean.valueOf(new CloudAction(this.f15451a).m5423a(this.f10613d.get(0)));
        }
        return Boolean.TRUE;
    }

    @Override // com.cnlaunch.x431pro.module.p241a.BasePresenter, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public final void onSuccess(int i, Object obj) {
        if (i != 100) {
            return;
        }
        if (((Boolean) obj).booleanValue()) {
            this.f10615f = 3;
            this.f10613d.remove(0);
            if (this.f10613d.size() > 0) {
                m5435a();
                return;
            }
            NLog.m9452b("XEE", "*********所有数据上传成功********");
            m7931b();
            this.f15453c.mo5115a((Bundle) null);
            return;
        }
        this.f10615f--;
        if (this.f10615f == 0) {
            NLog.m9451c("XEE", "*********所有数据上传失败********");
            m7931b();
            this.f15453c.mo5116a(1);
            return;
        }
        try {
            Thread.sleep(5000L);
            m5435a();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override // com.cnlaunch.x431pro.module.p241a.BasePresenter, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public final void onFailure(int i, int i2, Object obj) {
        if (i == 100 && this.f15453c != null) {
            this.f15453c.mo5116a(1);
        }
    }

    /* renamed from: b */
    private void m7931b() {
        if (TextUtils.isEmpty(this.f10616g)) {
            return;
        }
        FileUtils.m5000d(this.f10616g);
        NLog.m9452b("XEE", "删除文件:" + this.f10616g);
    }
}
