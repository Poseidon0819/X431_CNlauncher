package com.cnlaunch.x431pro.activity.mine;

import android.content.Context;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.TextView;
import com.cnlaunch.x431pro.widget.ClearEditText;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.ifoer.expedition.pro.R;

/* compiled from: PinCardPayFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.cb */
/* loaded from: classes.dex */
final class C2453cb implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ PinCardPayFragment f14028a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2453cb(PinCardPayFragment pinCardPayFragment) {
        this.f14028a = pinCardPayFragment;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        ClearEditText clearEditText;
        ClearEditText clearEditText2;
        Context context;
        if (2 == i) {
            clearEditText = this.f14028a.f14010a;
            clearEditText.setClearIconVisible(true);
            clearEditText2 = this.f14028a.f14010a;
            if (TextUtils.isEmpty(clearEditText2.getText().toString())) {
                return false;
            }
            context = this.f14028a.mContext;
            LoadDialog.m4680b(context, this.f14028a.getString(R.string.refresh_txt));
            this.f14028a.request(1001);
            return false;
        }
        return false;
    }
}
