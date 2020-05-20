package com.cnlaunch.x431pro.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.x431pro.p210a.ApplicationTheme;

/* renamed from: com.cnlaunch.x431pro.activity.h */
/* loaded from: classes.dex */
public class BaseAloneActivity extends Activity {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        ApplicationTheme.m7974b(this);
        super.onCreate(bundle);
        if (PreferencesManager.m9595a((Context) this).m9583b("is_screen_switch", false) && PreferencesManager.m9595a((Context) this).m9585b("Orientation", 2) != 0) {
            if (PreferencesManager.m9595a((Context) this).m9585b("Orientation", 2) == 1) {
                setRequestedOrientation(1);
                return;
            } else {
                setRequestedOrientation(4);
                return;
            }
        }
        setRequestedOrientation(0);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        finish();
    }
}
