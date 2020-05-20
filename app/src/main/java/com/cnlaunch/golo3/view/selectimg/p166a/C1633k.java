package com.cnlaunch.golo3.view.selectimg.p166a;

import android.content.Intent;
import com.cnlaunch.golo3.p164f.Event;
import com.cnlaunch.golo3.p164f.EventListener;
import com.cnlaunch.golo3.p165g.GoloActivityManager;
import com.cnlaunch.golo3.view.GoloProgressDialog;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SelectMoreImagesActivity.java */
/* renamed from: com.cnlaunch.golo3.view.selectimg.a.k */
/* loaded from: classes.dex */
public final class C1633k extends EventListener {

    /* renamed from: a */
    final /* synthetic */ SelectMoreImagesActivity f8617a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1633k(SelectMoreImagesActivity selectMoreImagesActivity) {
        this.f8617a = selectMoreImagesActivity;
    }

    @Override // com.cnlaunch.golo3.p164f.EventListener
    /* renamed from: a */
    public final void mo6055a(Event<?> event) {
        GoloProgressDialog.m9106a();
        Intent intent = new Intent();
        intent.putExtra("paths", (ArrayList) event.f8437a);
        this.f8617a.setResult(-1, intent);
        GoloActivityManager.m9138a();
        GoloActivityManager.m9135b(this.f8617a);
    }
}
