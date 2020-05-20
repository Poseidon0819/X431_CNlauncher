package com.cnlaunch.golo3.view.selectimg;

import android.content.Intent;
import com.cnlaunch.golo3.p164f.Event;
import com.cnlaunch.golo3.p164f.EventListener;
import com.cnlaunch.golo3.p165g.GoloActivityManager;
import com.cnlaunch.golo3.view.GoloProgressDialog;
import java.util.ArrayList;

/* compiled from: SelectPicActivity.java */
/* renamed from: com.cnlaunch.golo3.view.selectimg.q */
/* loaded from: classes.dex */
final class C1655q extends EventListener {

    /* renamed from: a */
    final /* synthetic */ SelectPicActivity f8738a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1655q(SelectPicActivity selectPicActivity) {
        this.f8738a = selectPicActivity;
    }

    @Override // com.cnlaunch.golo3.p164f.EventListener
    /* renamed from: a */
    public final void mo6055a(Event<?> event) {
        GoloProgressDialog.m9106a();
        Intent intent = new Intent();
        intent.putExtra("paths", (ArrayList) event.f8437a);
        this.f8738a.setResult(-1, intent);
        GoloActivityManager.m9138a();
        GoloActivityManager.m9135b(this.f8738a);
    }
}
