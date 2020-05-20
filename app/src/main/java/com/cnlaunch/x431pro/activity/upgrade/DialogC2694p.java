package com.cnlaunch.x431pro.activity.upgrade;

import android.app.FragmentManager;
import android.content.Context;
import android.view.View;
import com.cnlaunch.x431pro.activity.MainActivity;
import com.cnlaunch.x431pro.activity.setting.SettingActivity;
import com.cnlaunch.x431pro.activity.setting.SettingFragment;
import com.cnlaunch.x431pro.activity.setting.View$OnClickListenerC2594z;
import com.cnlaunch.x431pro.widget.p290a.BaseDialog;
import com.ifoer.expedition.pro.R;

/* compiled from: DownloadFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.upgrade.p */
/* loaded from: classes.dex */
final class DialogC2694p extends BaseDialog {

    /* renamed from: a */
    final /* synthetic */ HandlerC2687i f15421a;

    @Override // com.cnlaunch.x431pro.widget.p290a.BaseDialog
    /* renamed from: a */
    public final View mo4517a() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialogC2694p(HandlerC2687i handlerC2687i, Context context) {
        super(context);
        this.f15421a = handlerC2687i;
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.BaseDialog
    /* renamed from: b */
    public final void mo4577b(View view, int i) {
        MainActivity mainActivity;
        MainActivity mainActivity2;
        MainActivity mainActivity3;
        FragmentManager fragmentManager;
        SettingFragment settingFragment;
        mainActivity = this.f15421a.f15414a.mainActivity;
        if (mainActivity != null) {
            mainActivity2 = this.f15421a.f15414a.mainActivity;
            mainActivity2.m7894b(R.id.btn_setting);
            mainActivity3 = this.f15421a.f15414a.mainActivity;
            SettingActivity settingActivity = (SettingActivity) mainActivity3.getLocalActivityManager().getActivity(SettingActivity.class.getSimpleName());
            if (settingActivity != null && (fragmentManager = settingActivity.getFragmentManager()) != null && (settingFragment = (SettingFragment) fragmentManager.findFragmentByTag(SettingFragment.class.getName())) != null) {
                settingFragment.replaceFragment(View$OnClickListenerC2594z.class.getName());
            }
        }
        super.mo4577b(view, i);
    }
}
