package com.cnlaunch.x431pro.widget.p290a;

import android.content.Context;
import android.text.Html;
import android.view.View;
import com.ifoer.expedition.pro.R;

/* renamed from: com.cnlaunch.x431pro.widget.a.bo */
/* loaded from: classes.dex */
public final class PrinterFailrueDialog extends BaseDialog {

    /* renamed from: a */
    Context f16320a;

    @Override // com.cnlaunch.x431pro.widget.p290a.BaseDialog
    /* renamed from: a */
    public final View mo4517a() {
        return null;
    }

    public PrinterFailrueDialog(Context context) {
        super(context);
        this.f16320a = context;
        setTitle(R.string.print_failure_dialog_title);
        this.f16127d.setText(Html.fromHtml(getContext().getResources().getString(R.string.print_failure_dialog_content)));
        m4719a(R.string.print_launch_set_onestep_setbutton, true, new View$OnClickListenerC2833bp(this));
        m4720a(R.string.reset_password_button_confirm, new View$OnClickListenerC2834bq(this));
    }
}
