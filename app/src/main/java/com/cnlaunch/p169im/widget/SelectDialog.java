package com.cnlaunch.p169im.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.WindowManager;
import com.ifoer.expedition.pro.R;

/* renamed from: com.cnlaunch.im.widget.c */
/* loaded from: classes.dex */
public final class SelectDialog extends Dialog {
    public SelectDialog(Context context) {
        super(context, R.style.dialog_full);
    }

    @Override // android.app.Dialog
    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.gravity = 80;
        attributes.width = -1;
        attributes.height = -2;
        getWindow().setAttributes(attributes);
    }
}
