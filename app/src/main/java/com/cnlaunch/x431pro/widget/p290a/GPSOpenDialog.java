package com.cnlaunch.x431pro.widget.p290a;

import android.content.Context;
import android.view.View;
import com.ifoer.expedition.pro.R;

/* renamed from: com.cnlaunch.x431pro.widget.a.ah */
/* loaded from: classes.dex */
public final class GPSOpenDialog extends BaseDialog {
    @Override // com.cnlaunch.x431pro.widget.p290a.BaseDialog
    /* renamed from: a */
    public final View mo4517a() {
        return null;
    }

    public GPSOpenDialog(Context context) {
        super(context);
        setTitle(R.string.dialog_title_default);
        m4714e(R.string.open_gps_tips);
        m4719a(R.string.cancel_img, true, null);
        m4717b(R.string.confirm, true, new View$OnClickListenerC2811ai(this));
    }
}
