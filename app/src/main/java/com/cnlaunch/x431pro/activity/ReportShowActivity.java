package com.cnlaunch.x431pro.activity;

import android.app.Fragment;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.KeyEvent;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.p181j.RemotePerformClick;
import com.cnlaunch.x431pro.activity.diagnose.DiagnoseActivity;
import com.cnlaunch.x431pro.activity.diagnose.ReportShowFragment;
import com.cnlaunch.x431pro.activity.diagnose.p222e.IFragmentCallback;
import com.cnlaunch.x431pro.activity.diagnose.p222e.OnDiagnoseDataUpdateListenter;
import com.cnlaunch.x431pro.activity.diagnose.p222e.OnKeyDownListenter;
import com.cnlaunch.x431pro.activity.golo.p225b.InfaceFragmentParent;
import com.cnlaunch.x431pro.activity.golo.p225b.OnActivityResultListenter;
import com.cnlaunch.x431pro.module.p252d.p254b.DiagnoseRunningInfo;
import com.cnlaunch.x431pro.module.p252d.p254b.RemoteDiagRunningInfo;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class ReportShowActivity extends ActivityC2004c implements IFragmentCallback, InfaceFragmentParent {

    /* renamed from: C */
    private BroadcastReceiver f10759C = new C1989ae(this);

    /* renamed from: D */
    private DiagnoseRunningInfo f10760D = null;

    /* renamed from: n */
    private BaseFragment f10761n;

    @Override // com.cnlaunch.x431pro.activity.diagnose.p222e.IFragmentCallback
    /* renamed from: a */
    public final void mo7099a(int i, byte[] bArr) {
    }

    @Override // com.cnlaunch.x431pro.activity.golo.p225b.InfaceFragmentParent
    /* renamed from: a */
    public final void mo6036a(long j) {
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p222e.IFragmentCallback
    /* renamed from: a */
    public final void mo7098a(Fragment fragment, String str, boolean z) {
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p222e.IFragmentCallback
    /* renamed from: a */
    public final void mo7097a(OnDiagnoseDataUpdateListenter onDiagnoseDataUpdateListenter) {
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p222e.IFragmentCallback
    /* renamed from: a */
    public final void mo7096a(OnKeyDownListenter onKeyDownListenter) {
    }

    @Override // com.cnlaunch.x431pro.activity.golo.p225b.InfaceFragmentParent
    /* renamed from: a */
    public final void mo6035a(OnActivityResultListenter onActivityResultListenter) {
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p222e.IFragmentCallback
    /* renamed from: a */
    public final void mo7095a(DiagnoseRunningInfo diagnoseRunningInfo) {
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p222e.IFragmentCallback
    /* renamed from: a */
    public final void mo7094a(String str, String str2) {
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p222e.IFragmentCallback
    /* renamed from: a */
    public final void mo7093a(String str, String str2, int i) {
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p222e.IFragmentCallback
    /* renamed from: a */
    public final void mo7092a(String str, String str2, int i, int i2) {
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p222e.IFragmentCallback
    /* renamed from: a */
    public final void mo7091a(String str, String str2, String str3, String str4) {
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p222e.IFragmentCallback
    /* renamed from: a */
    public final void mo7090a(String str, ArrayList<String> arrayList) {
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p222e.IFragmentCallback
    /* renamed from: a */
    public final void mo7089a(String str, byte[] bArr) {
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p222e.IFragmentCallback
    /* renamed from: b */
    public final void mo7088b(String str, String str2) {
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p222e.IFragmentCallback
    /* renamed from: b */
    public final void mo7087b(boolean z) {
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p222e.IFragmentCallback
    /* renamed from: c */
    public final int mo7086c(String str) {
        return 0;
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p222e.IFragmentCallback
    /* renamed from: f */
    public final void mo7085f(int i) {
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p222e.IFragmentCallback
    /* renamed from: h */
    public final void mo7084h() {
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p222e.IFragmentCallback
    /* renamed from: j */
    public final void mo7082j() {
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p222e.IFragmentCallback
    /* renamed from: k */
    public final RemoteDiagRunningInfo mo7081k() {
        return null;
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p222e.IFragmentCallback
    /* renamed from: l */
    public final RemotePerformClick mo7080l() {
        return null;
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.support.p012v4.app.FragmentActivity, android.support.p012v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main_remotediag);
        this.f10984t.setVisibility(8);
        this.f10988x = false;
        m7735e(8);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f10761n = new ReportShowFragment();
            this.f10761n.setArguments(extras);
            getFragmentManager().beginTransaction().add(R.id.layout_fragment_contanier, this.f10761n, "ReportShow").commit();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("clos_report_show");
        registerReceiver(this.f10759C, intentFilter);
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.support.p012v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        DiagnoseConstants.FAULTCODE_REFRESH = true;
        unregisterReceiver(this.f10759C);
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        super.onBackPressed();
        return true;
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p222e.IFragmentCallback
    /* renamed from: i */
    public final DiagnoseRunningInfo mo7083i() {
        this.f10760D = DiagnoseActivity.f11012C;
        if (this.f10760D == null) {
            this.f10760D = new DiagnoseRunningInfo();
            try {
                StringBuffer stringBuffer = new StringBuffer(getPackageManager().getPackageInfo(getPackageName(), 0).versionName);
                if (stringBuffer.charAt(0) != 'V' && stringBuffer.charAt(0) != 'v') {
                    stringBuffer.insert(0, 'V');
                }
                this.f10760D.setAppVersion(stringBuffer.toString());
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        }
        return this.f10760D;
    }
}
