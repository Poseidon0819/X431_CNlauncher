package com.cnlaunch.p169im;

import android.view.View;
import com.cnlaunch.diagnosemodule.wiget.NToast;
import com.cnlaunch.golo3.p160b.ApplicationConfig;
import com.cnlaunch.golo3.p165g.FileTool;
import java.io.File;
import java.io.IOException;
import message.p384g.MsgUtils;

/* compiled from: ShowImageDetailActivity.java */
/* renamed from: com.cnlaunch.im.h */
/* loaded from: classes.dex */
final class View$OnClickListenerC1743h implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ShowImageDetailActivity f9277a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1743h(ShowImageDetailActivity showImageDetailActivity) {
        this.f9277a = showImageDetailActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ShowImageDetailActivity showImageDetailActivity = this.f9277a;
        String str = showImageDetailActivity.f8869b.get(showImageDetailActivity.f8868a).f24085b;
        if (str != null) {
            File file = new File(str);
            File file2 = new File((ShowImageDetailActivity.f8867d + ApplicationConfig.m9181a() + "/share/image/") + str.substring(str.lastIndexOf("/") + 1));
            try {
                FileTool.m9142a(file, file2);
                MsgUtils.m221a(file2.getAbsolutePath(), showImageDetailActivity.f8871e);
                NToast.longToast(showImageDetailActivity.f8871e, "SAVE:" + file2.getAbsolutePath(), 48);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (showImageDetailActivity.f8870c != null) {
            File file3 = new File(showImageDetailActivity.f8870c);
            File file4 = new File(showImageDetailActivity.f8870c + ".jpg");
            try {
                FileTool.m9142a(file3, file4);
                MsgUtils.m221a(file4.getAbsolutePath(), showImageDetailActivity.f8871e);
                NToast.longToast(showImageDetailActivity.f8871e, "SAVE:" + file4.getAbsolutePath(), 48);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }
}
