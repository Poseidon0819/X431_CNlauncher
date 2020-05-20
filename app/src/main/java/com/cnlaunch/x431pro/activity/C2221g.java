package com.cnlaunch.x431pro.activity;

import android.content.Intent;
import com.cnlaunch.newgolo.manager.GoloLightManager;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p167h.C1673a;
import com.cnlaunch.physics.DeviceFactoryManager;
import com.cnlaunch.x431pro.p210a.CommonTools;
import com.cnlaunch.x431pro.utils.PathUtils;
import com.cnlaunch.x431pro.utils.p281c.DateUtils;
import com.cnlaunch.x431pro.widget.p290a.SelectMessageDialog;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BaseActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.g */
/* loaded from: classes.dex */
public final class C2221g extends SelectMessageDialog {

    /* renamed from: a */
    final /* synthetic */ ActivityC2004c f12497a;

    @Override // com.cnlaunch.x431pro.widget.p290a.SelectMessageDialog
    /* renamed from: b */
    public final void mo4608b() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2221g(ActivityC2004c activityC2004c) {
        this.f12497a = activityC2004c;
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.SelectMessageDialog
    /* renamed from: a */
    public final void mo4611a() {
        try {
            GoloLightManager.m8495c();
            C1673a.m8965a().m8964a("-------Exit App-------");
            CommonTools.m7968a(PathUtils.m4841o() + "Golo_" + DateUtils.m5094a("YYYYMMDD_hh") + ".txt", C1673a.m8965a().m8962b());
            PreferencesManager.m9595a(this.f12497a.f10981q).m9587a("isRemindedAppUsageNum", false);
            this.f12497a.f10981q.sendBroadcast(new Intent("com.cnlaunch.golo.action.seller.pro.logout"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        DeviceFactoryManager.m8305a().m8283d(this.f12497a.f10981q);
        this.f12497a.finish();
    }
}
