package com.cnlaunch.x431pro.activity.diagnose.p221d;

import android.view.View;
import android.widget.TextView;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.x431pro.activity.diagnose.p222e.IFragmentCallback;
import java.io.File;

/* compiled from: ChooseFileFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.q */
/* loaded from: classes.dex */
final class View$OnClickListenerC2178q implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChooseFileFragment f12374a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2178q(ChooseFileFragment chooseFileFragment) {
        this.f12374a = chooseFileFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        StringBuilder sb = new StringBuilder("confirm exit,mPath=");
        textView = this.f12374a.f12371m;
        sb.append(textView.getText().toString());
        NLog.m9456a("ChooseFileFragment", sb.toString());
        textView2 = this.f12374a.f12371m;
        String charSequence = textView2.getText().toString();
        if (new File(charSequence).isDirectory()) {
            this.f12374a.m7114b(charSequence);
            return;
        }
        IFragmentCallback iFragmentCallback = this.f12374a.f12357d;
        StringBuilder sb2 = new StringBuilder("01");
        textView3 = this.f12374a.f12371m;
        sb2.append(textView3.getText().toString());
        iFragmentCallback.mo7093a(DiagnoseConstants.FEEDBACK_SELECT_FILEDIALOG, sb2.toString(), 3);
    }
}
