package com.cnlaunch.x431pro.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import com.cnlaunch.p120d.p121a.ActivityPageManager;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p125c.p126a.AsyncTaskManager;
import com.cnlaunch.p120d.p125c.p126a.OnDataListener;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.p210a.ApplicationTheme;
import com.ifoer.expedition.pro.R;

/* renamed from: com.cnlaunch.x431pro.activity.p */
/* loaded from: classes.dex */
public class LoginBaseActivity extends Activity implements OnDataListener {

    /* renamed from: a */
    protected Context f14348a;

    /* renamed from: b */
    private final String f14349b = LoginBaseActivity.class.getSimpleName();

    /* renamed from: c */
    private AsyncTaskManager f14350c;

    @Override // com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public Object doInBackground(int i) throws C1425f {
        return null;
    }

    @Override // com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onSuccess(int i, Object obj) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        this.f14348a = this;
        ApplicationTheme.m7973c(this);
        if (PreferencesManager.m9595a((Context) this).m9583b("is_screen_switch", false) && PreferencesManager.m9595a((Context) this).m9585b("Orientation", 2) != 0) {
            if (PreferencesManager.m9595a((Context) this).m9585b("Orientation", 2) == 1) {
                setRequestedOrientation(1);
            } else {
                setRequestedOrientation(4);
            }
        } else {
            setRequestedOrientation(0);
        }
        super.onCreate(bundle);
        ActivityPageManager.m9634a();
        ActivityPageManager.m9633a((Activity) this);
        this.f14350c = AsyncTaskManager.m9574a(this.f14348a);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 0 && getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onFailure(int i, int i2, Object obj) {
        if (i2 != -999) {
            if (i2 == -400) {
                NToast.m9450a(this.f14348a, (int) R.string.common_network_unavailable);
                return;
            } else if (i2 != -200) {
                return;
            }
        }
        NToast.m9450a(this.f14348a, (int) R.string.common_network_error);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ActivityPageManager.m9634a();
        ActivityPageManager.m9628b(this);
    }
}
