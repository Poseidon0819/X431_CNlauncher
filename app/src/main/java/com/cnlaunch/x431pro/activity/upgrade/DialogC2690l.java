package com.cnlaunch.x431pro.activity.upgrade;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.cnlaunch.x431pro.activity.MainActivity;
import com.cnlaunch.x431pro.widget.button.IconButton;
import com.ifoer.expedition.pro.R;

/* compiled from: DownloadFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.upgrade.l */
/* loaded from: classes.dex */
final class DialogC2690l extends DownLoadMessageDialog {

    /* renamed from: a */
    final /* synthetic */ HandlerC2687i f15417a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialogC2690l(HandlerC2687i handlerC2687i, Context context) {
        super(context);
        this.f15417a = handlerC2687i;
    }

    @Override // com.cnlaunch.x431pro.activity.upgrade.DownLoadMessageDialog
    /* renamed from: b */
    public final void mo4523b() {
        IconButton iconButton;
        MainActivity mainActivity;
        MainActivity mainActivity2;
        MainActivity mainActivity3;
        MainActivity mainActivity4;
        IconButton iconButton2;
        Integer num;
        IconButton iconButton3;
        iconButton = this.f15417a.f15414a.f15350B;
        iconButton.setText(R.string.down_retry_txt);
        if (this.f15417a.f15414a.getActivity() != null) {
            Drawable drawable = this.f15417a.f15414a.getResources().getDrawable(R.drawable.select_btn_update_retry);
            drawable.setBounds(0, 0, 50, 50);
            iconButton2 = this.f15417a.f15414a.f15350B;
            iconButton2.setImage(drawable);
            num = this.f15417a.f15414a.f15355G;
            if (num.intValue() >= this.f15417a.f15414a.f15352D.size()) {
                iconButton3 = this.f15417a.f15414a.f15350B;
                iconButton3.setEnabled(false);
            }
        }
        mainActivity = this.f15417a.f15414a.mainActivity;
        if (mainActivity != null) {
            mainActivity4 = this.f15417a.f15414a.mainActivity;
            mainActivity4.m7894b(R.id.btn_diagnose);
        }
        mainActivity2 = this.f15417a.f15414a.mainActivity;
        if (mainActivity2 != null) {
            mainActivity3 = this.f15417a.f15414a.mainActivity;
            mainActivity3.getLocalActivityManager().destroyActivity(UpgradeActivity.class.getSimpleName(), true);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.upgrade.DownLoadMessageDialog
    /* renamed from: c */
    public final void mo4522c() {
        MainActivity mainActivity;
        MainActivity mainActivity2;
        mainActivity = this.f15417a.f15414a.mainActivity;
        if (mainActivity != null && !this.f15417a.f15414a.isVisible()) {
            mainActivity2 = this.f15417a.f15414a.mainActivity;
            mainActivity2.m7894b(R.id.btn_upgrade);
        }
        this.f15417a.f15414a.popBackStack();
    }
}
