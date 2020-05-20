package com.cnlaunch.x431pro.activity.golo.function;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.RelativeLayout;
import com.cnlaunch.x431pro.activity.BaseAloneActivity;
import com.cnlaunch.x431pro.activity.golo.p225b.OnGoloKeyDownListener;
import com.cnlaunch.x431pro.activity.golo.p226c.WebHistoryReportFragment;
import com.ifoer.expedition.pro.R;
import com.itextpdf.text.Annotation;

/* loaded from: classes.dex */
public class GoloFunctionActivity extends BaseAloneActivity {

    /* renamed from: a */
    protected RelativeLayout f12575a;

    /* renamed from: b */
    private BroadcastReceiver f12576b = new C2238c(this);

    /* renamed from: c */
    private boolean f12577c = false;

    /* renamed from: d */
    private OnGoloKeyDownListener f12578d = null;

    @Override // com.cnlaunch.x431pro.activity.BaseAloneActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_base_alone);
        this.f12575a = (RelativeLayout) findViewById(R.id.layout_head);
        m7018a(getIntent());
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("ACTION_CLOSE_SOFT");
        registerReceiver(this.f12576b, intentFilter);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        m7018a(intent);
    }

    /* renamed from: a */
    private void m7020a() {
        RelativeLayout relativeLayout = this.f12575a;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        try {
            unregisterReceiver(this.f12576b);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7018a(Intent intent) {
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        if (action.equals("ACTION_REPORT")) {
            String stringExtra = intent.getStringExtra(Annotation.URL);
            WebHistoryReportFragment webHistoryReportFragment = new WebHistoryReportFragment();
            Bundle bundle = new Bundle();
            bundle.putString("urlkey", stringExtra);
            webHistoryReportFragment.setBundle(bundle);
            m7019a(webHistoryReportFragment);
        } else if (action.equals("ACTION_APPRAISE")) {
            String stringExtra2 = intent.getStringExtra("id");
            AppraiseFragment appraiseFragment = new AppraiseFragment();
            Bundle bundle2 = new Bundle();
            bundle2.putString("id", stringExtra2);
            appraiseFragment.setBundle(bundle2);
            m7019a(appraiseFragment);
        } else if (action.equals("ACTION_REPORTFILE")) {
            m7019a(new ReportFileFragment());
        } else if (action.equals("ACTION_LOCALFILE")) {
            m7019a(new LocalFileFragment());
        } else if (action.equals("ACTION_VIDEO_PLAY")) {
            VideoPlayFragment videoPlayFragment = new VideoPlayFragment();
            videoPlayFragment.setBundle(intent.getBundleExtra("BUNDLE"));
            m7019a(videoPlayFragment);
            this.f12578d = videoPlayFragment;
            m7020a();
        } else if (action.equals("ACTION_SELECT_SOFT")) {
            this.f12577c = true;
            SelectRemoteDiagSoftFragmentHD selectRemoteDiagSoftFragmentHD = new SelectRemoteDiagSoftFragmentHD();
            m7019a(selectRemoteDiagSoftFragmentHD);
            this.f12578d = selectRemoteDiagSoftFragmentHD;
        } else if (action.equals("ACTION_CLOSE_SOFT") && this.f12577c) {
            Log.i("Sanda", "关闭相关车型选择界面");
            finish();
        }
    }

    /* renamed from: a */
    private void m7019a(Fragment fragment) {
        FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
        beginTransaction.add(R.id.layout_container, fragment);
        beginTransaction.commitAllowingStateLoss();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        OnGoloKeyDownListener onGoloKeyDownListener = this.f12578d;
        if (onGoloKeyDownListener == null || !onGoloKeyDownListener.onKeyDown(i, keyEvent)) {
            if (i == 4) {
                finish();
                overridePendingTransition(R.anim.activity_left_to_right_in, R.anim.activity_left_to_right_out);
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }
}
