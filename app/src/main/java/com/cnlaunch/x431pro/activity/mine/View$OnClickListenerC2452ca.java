package com.cnlaunch.x431pro.activity.mine;

import android.content.Context;
import android.view.View;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.p210a.LoginTools;
import com.cnlaunch.x431pro.widget.ClearEditText;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.ifoer.expedition.pro.R;
import java.util.regex.Pattern;

/* compiled from: PinCardPayFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.ca */
/* loaded from: classes.dex */
final class View$OnClickListenerC2452ca implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PinCardPayFragment f14027a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2452ca(PinCardPayFragment pinCardPayFragment) {
        this.f14027a = pinCardPayFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Context context;
        ClearEditText clearEditText;
        Context context2;
        Context context3;
        context = this.f14027a.mContext;
        if (LoginTools.m7945a(context, 2)) {
            clearEditText = this.f14027a.f14010a;
            if (Pattern.compile("^\\d{24}$").matcher(clearEditText.getText().toString()).matches()) {
                context3 = this.f14027a.mContext;
                LoadDialog.m4680b(context3, this.f14027a.getString(R.string.refresh_txt));
                this.f14027a.request(1001);
                return;
            }
            context2 = this.f14027a.mContext;
            NToast.m9450a(context2, (int) R.string.mine_hint_card_code);
        }
    }
}
