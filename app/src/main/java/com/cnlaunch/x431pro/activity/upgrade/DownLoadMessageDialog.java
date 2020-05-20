package com.cnlaunch.x431pro.activity.upgrade;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.cnlaunch.x431pro.widget.p290a.BaseDialog;

/* renamed from: com.cnlaunch.x431pro.activity.upgrade.b */
/* loaded from: classes.dex */
public abstract class DownLoadMessageDialog extends BaseDialog {
    @Override // com.cnlaunch.x431pro.widget.p290a.BaseDialog
    /* renamed from: a */
    public final View mo4517a() {
        return null;
    }

    /* renamed from: b */
    public abstract void mo4523b();

    /* renamed from: c */
    public abstract void mo4522c();

    public DownLoadMessageDialog(Context context) {
        super(context);
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.BaseDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        setCanceledOnTouchOutside(false);
    }
}
