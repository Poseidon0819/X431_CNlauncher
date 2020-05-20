package com.cnlaunch.x431pro.activity.help;

import android.os.Bundle;
import com.cnlaunch.x431pro.activity.ActivityC2004c;
import com.ifoer.expedition.pro.R;

/* loaded from: classes.dex */
public class HelpActivity extends ActivityC2004c {

    /* renamed from: n */
    private String f12717n = null;

    /* renamed from: C */
    private String f12715C = null;

    /* renamed from: D */
    private boolean f12716D = false;

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.support.p012v4.app.FragmentActivity, android.support.p012v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_common_fragment);
        this.f10984t.setVisibility(8);
        this.f10985u.setVisibility(8);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f12717n = extras.getString(HelpStringConstant.f12801b);
            this.f12715C = extras.getString(HelpStringConstant.f12800a);
            if (this.f12717n != null && this.f12715C != null) {
                this.f12716D = true;
            }
        }
        if (bundle == null) {
            if (this.f12716D) {
                mo5888b(HelpShowFileFragment.class.getName(), extras);
            } else {
                mo5888b(HelpFragment.class.getName(), null);
            }
        }
    }
}
