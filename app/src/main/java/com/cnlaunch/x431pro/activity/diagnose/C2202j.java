package com.cnlaunch.x431pro.activity.diagnose;

import android.content.Context;
import com.cnlaunch.newgolo.manager.GoloLightManager;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p130d.DevRecordLog;
import com.cnlaunch.physics.DeviceFactoryManager;
import com.cnlaunch.x431pro.p210a.CommonTools;
import com.cnlaunch.x431pro.utils.PathUtils;
import com.cnlaunch.x431pro.utils.p281c.DateUtils;
import com.cnlaunch.x431pro.widget.p290a.SelectMessageDialog;

/* compiled from: CarIconFragmentForAll.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.j */
/* loaded from: classes.dex */
final class C2202j extends SelectMessageDialog {

    /* renamed from: a */
    final /* synthetic */ CarIconFragmentForAll f12476a;

    @Override // com.cnlaunch.x431pro.widget.p290a.SelectMessageDialog
    /* renamed from: b */
    public final void mo4608b() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2202j(CarIconFragmentForAll carIconFragmentForAll) {
        this.f12476a = carIconFragmentForAll;
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.SelectMessageDialog
    /* renamed from: a */
    public final void mo4611a() {
        Context context;
        Context context2;
        try {
            GoloLightManager.m8495c();
            DevRecordLog.m9472a().m9471a("-------Exit App-------");
            CommonTools.m7968a(PathUtils.m4841o() + "Golo_" + DateUtils.m5094a("YYYYMMDD_hh") + ".txt", DevRecordLog.m9472a().m9470b());
            context2 = this.f12476a.mContext;
            PreferencesManager.m9595a(context2).m9587a("isRemindedAppUsageNum", false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        DeviceFactoryManager m8305a = DeviceFactoryManager.m8305a();
        context = this.f12476a.mContext;
        m8305a.m8283d(context);
        System.exit(0);
    }
}
