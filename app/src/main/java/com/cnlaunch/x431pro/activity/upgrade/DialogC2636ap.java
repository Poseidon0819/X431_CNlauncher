package com.cnlaunch.x431pro.activity.upgrade;

import android.app.FragmentManager;
import android.content.Context;
import android.view.View;
import com.cnlaunch.x431pro.activity.MainActivity;
import com.cnlaunch.x431pro.activity.mine.ConnectorActivateFragment;
import com.cnlaunch.x431pro.activity.mine.MineActivity;
import com.cnlaunch.x431pro.activity.mine.MineFragment;
import com.cnlaunch.x431pro.widget.p290a.MessageDialog;
import com.ifoer.expedition.pro.R;

/* compiled from: UpgradeFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.upgrade.ap */
/* loaded from: classes.dex */
final class DialogC2636ap extends MessageDialog {

    /* renamed from: a */
    final /* synthetic */ HandlerC2633am f15133a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialogC2636ap(HandlerC2633am handlerC2633am, Context context) {
        super(context);
        this.f15133a = handlerC2633am;
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.BaseDialog
    /* renamed from: a */
    public final void mo4579a(View view, int i) {
        MainActivity mainActivity;
        MainActivity mainActivity2;
        MainActivity mainActivity3;
        FragmentManager fragmentManager;
        mainActivity = this.f15133a.f15130a.mainActivity;
        if (mainActivity != null) {
            mainActivity2 = this.f15133a.f15130a.mainActivity;
            mainActivity2.m7894b(R.id.btn_mine);
            mainActivity3 = this.f15133a.f15130a.mainActivity;
            MineActivity mineActivity = (MineActivity) mainActivity3.getLocalActivityManager().getActivity(MineActivity.class.getSimpleName());
            if (mineActivity != null && (fragmentManager = mineActivity.getFragmentManager()) != null) {
                int backStackEntryCount = fragmentManager.getBackStackEntryCount();
                if (backStackEntryCount > 0) {
                    for (int i2 = 0; i2 < backStackEntryCount; i2++) {
                        fragmentManager.popBackStackImmediate((String) null, 1);
                    }
                }
                MineFragment mineFragment = (MineFragment) fragmentManager.findFragmentByTag(MineFragment.class.getName());
                if (mineFragment != null) {
                    mineFragment.replaceFragment(ConnectorActivateFragment.class.getName());
                }
            }
        }
        super.mo4579a(view, i);
    }
}
