package com.cnlaunch.x431pro.activity.setting;

import android.content.Intent;
import com.cnlaunch.x431pro.activity.GDApplication;
import com.cnlaunch.x431pro.activity.upgrade.p239b.SimpleOnDownloadListener;
import com.cnlaunch.x431pro.widget.p290a.MessageDialog;
import com.ifoer.expedition.pro.R;

/* compiled from: DiagnosticLogVehicleListFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.setting.k */
/* loaded from: classes.dex */
final class C2565k extends SimpleOnDownloadListener {

    /* renamed from: a */
    final /* synthetic */ DiagnosticLogVehicleListFragment f14834a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2565k(DiagnosticLogVehicleListFragment diagnosticLogVehicleListFragment) {
        this.f14834a = diagnosticLogVehicleListFragment;
    }

    @Override // com.cnlaunch.x431pro.activity.upgrade.p239b.SimpleOnDownloadListener, com.cnlaunch.x431pro.activity.upgrade.p239b.OnDownloadListener
    /* renamed from: a */
    public final void mo5615a(String str) {
        if (!this.f14834a.getActivity().isFinishing() && str.equals(DiagnosticLogVehicleListFragment.m5913a(this.f14834a))) {
            DiagnosticLogVehicleListFragment.m5909b(this.f14834a).m4627a(R.string.down_state_1);
            DiagnosticLogVehicleListFragment.m5909b(this.f14834a).m4619c(R.drawable.progressbar_mini_downloading);
            DiagnosticLogVehicleListFragment.m5909b(this.f14834a).m4617d(R.color.downloading);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.upgrade.p239b.SimpleOnDownloadListener, com.cnlaunch.x431pro.activity.upgrade.p239b.OnDownloadListener
    /* renamed from: a */
    public final void mo5614a(String str, int i) {
        if (!this.f14834a.getActivity().isFinishing() && str.equals(DiagnosticLogVehicleListFragment.m5907c(this.f14834a))) {
            DiagnosticLogVehicleListFragment.m5909b(this.f14834a).m4627a(R.string.down_state_1);
            DiagnosticLogVehicleListFragment.m5909b(this.f14834a).m4619c(R.drawable.progressbar_mini_downloading);
            DiagnosticLogVehicleListFragment.m5909b(this.f14834a).m4617d(R.color.downloading);
            DiagnosticLogVehicleListFragment.m5909b(this.f14834a).m4623b(i);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.upgrade.p239b.SimpleOnDownloadListener, com.cnlaunch.x431pro.activity.upgrade.p239b.OnDownloadListener
    /* renamed from: b */
    public final void mo4930b(String str, int i) {
        if (!this.f14834a.getActivity().isFinishing() && str.equals(DiagnosticLogVehicleListFragment.m5907c(this.f14834a))) {
            if (i == 0) {
                DiagnosticLogVehicleListFragment.m5909b(this.f14834a).m4627a(R.string.down_state_2);
                return;
            }
            DiagnosticLogVehicleListFragment.m5909b(this.f14834a).m4627a(R.string.down_state_3);
            DiagnosticLogVehicleListFragment.m5909b(this.f14834a).m4617d(R.color.download_fail);
            DiagnosticLogVehicleListFragment.m5909b(this.f14834a).m4619c(R.drawable.progressbar_mini_fail);
            DiagnosticLogVehicleListFragment.m5909b(this.f14834a).m4620c();
            DiagnosticLogVehicleListFragment.m5909b(this.f14834a).m4624b();
            if (i == -10) {
                DiagnosticLogVehicleListFragment.m5906d(this.f14834a);
            } else if (i == 645 && !this.f14834a.getActivity().isFinishing()) {
                new MessageDialog(DiagnosticLogVehicleListFragment.m5905e(this.f14834a)).m4670a(R.string.tab_menu_upgrade, R.string.out_dealer_area);
            } else {
                this.f14834a.getActivity().runOnUiThread(new RunnableC2566l(this));
            }
        }
    }

    @Override // com.cnlaunch.x431pro.activity.upgrade.p239b.SimpleOnDownloadListener, com.cnlaunch.x431pro.activity.upgrade.p239b.OnDownloadListener
    /* renamed from: b */
    public final void mo5613b(String str) {
        if (!this.f14834a.getActivity().isFinishing() && str.equals(DiagnosticLogVehicleListFragment.m5907c(this.f14834a))) {
            DiagnosticLogVehicleListFragment.m5909b(this.f14834a).m4627a(R.string.down_state_7);
            DiagnosticLogVehicleListFragment.m5909b(this.f14834a).m4617d(R.color.installing);
            DiagnosticLogVehicleListFragment.m5909b(this.f14834a).m4619c(R.drawable.progressbar_mini_installing);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.upgrade.p239b.SimpleOnDownloadListener, com.cnlaunch.x431pro.activity.upgrade.p239b.OnDownloadListener
    /* renamed from: c */
    public final void mo5612c(String str, int i) {
        if (!this.f14834a.getActivity().isFinishing() && str.equals(DiagnosticLogVehicleListFragment.m5907c(this.f14834a))) {
            DiagnosticLogVehicleListFragment.m5909b(this.f14834a).m4627a(R.string.down_state_7);
            DiagnosticLogVehicleListFragment.m5909b(this.f14834a).m4617d(R.color.installing);
            DiagnosticLogVehicleListFragment.m5909b(this.f14834a).m4619c(R.drawable.progressbar_mini_installing);
            DiagnosticLogVehicleListFragment.m5909b(this.f14834a).m4623b(i);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.upgrade.p239b.SimpleOnDownloadListener, com.cnlaunch.x431pro.activity.upgrade.p239b.OnDownloadListener
    /* renamed from: d */
    public final void mo4929d(String str, int i) {
        if (!this.f14834a.getActivity().isFinishing() && str.equals(DiagnosticLogVehicleListFragment.m5907c(this.f14834a))) {
            DiagnosticLogVehicleListFragment.m5909b(this.f14834a).m4620c();
            if (i == 0) {
                if (DiagnosticLogVehicleListFragment.m5903g(this.f14834a) != null) {
                    DiagnosticLogVehicleListFragment.m5902h(this.f14834a).sendBroadcast(new Intent("softs_added"));
                }
                DiagnosticLogVehicleListFragment.m5909b(this.f14834a).m4627a(R.string.down_state_4);
                DiagnosticLogVehicleListFragment.m5909b(this.f14834a).m4617d(R.color.install_success);
                GDApplication.m7908c();
                DiagnosticLogVehicleListFragment.m5909b(this.f14834a).m4619c(R.drawable.progressbar_mini);
                this.f14834a.getActivity().runOnUiThread(new RunnableC2567m(this));
            } else {
                DiagnosticLogVehicleListFragment.m5909b(this.f14834a).m4627a(R.string.down_state_5);
                DiagnosticLogVehicleListFragment.m5909b(this.f14834a).m4617d(R.color.download_fail);
                DiagnosticLogVehicleListFragment.m5909b(this.f14834a).m4619c(R.drawable.progressbar_mini_fail);
                this.f14834a.getActivity().runOnUiThread(new RunnableC2571q(this));
            }
            DiagnosticLogVehicleListFragment.m5909b(this.f14834a).m4624b();
        }
    }
}
