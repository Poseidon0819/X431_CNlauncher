package com.cnlaunch.x431pro.activity.info;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import com.artifex.mupdflib.SearchTaskResult;
import com.cnlaunch.golo3.p165g.C1621v;
import com.cnlaunch.x431pro.activity.ActivityC2004c;
import com.cnlaunch.x431pro.activity.MainActivity;
import com.cnlaunch.x431pro.activity.diagnose.DiagnoseActivity;
import com.cnlaunch.x431pro.activity.upgrade.UpgradeActivity;
import com.ifoer.expedition.pro.R;
import com.mopub.mobileads.VastExtensionXmlManager;

/* loaded from: classes.dex */
public class PdfSearchActivity extends ActivityC2004c implements View.OnClickListener {

    /* renamed from: C */
    private PdfSearchFragment f12864C;

    /* renamed from: D */
    private Context f12865D;

    /* renamed from: E */
    private String f12866E;

    /* renamed from: F */
    private EditText f12867F;

    /* renamed from: G */
    private ImageButton f12868G;

    /* renamed from: n */
    boolean f12869n;

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.support.p012v4.app.FragmentActivity, android.support.p012v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_common_fragment);
        m7738d();
        setTitle(R.string.text_measurabecar);
        this.f12867F = (EditText) this.f10990z.findViewById(R.id.edit_search);
        this.f12867F.setVisibility(0);
        this.f12867F.addTextChangedListener(new C2284j(this));
        this.f12868G = (ImageButton) this.f10990z.findViewById(R.id.edit_search_btn);
        this.f12868G.setOnClickListener(this);
        this.f12865D = this;
        this.f12866E = getIntent().getStringExtra("file_path");
        this.f12864C = new PdfSearchFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putString("filepath", this.f12866E);
        this.f12864C.setArguments(bundle2);
        getFragmentManager().beginTransaction().add(R.id.layout_fragment_contanier, this.f12864C, PdfSearchFragment.class.getName()).commit();
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.support.p012v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        int i = getResources().getConfiguration().orientation;
        super.onConfigurationChanged(configuration);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != R.id.edit_search_btn) {
            return;
        }
        if (!C1621v.m9121a(this.f12867F.getText().toString())) {
            this.f12864C.m6836a(1, this.f12867F.getText().toString(), false);
        } else {
            Toast.makeText(this.f12865D, (int) R.string.please_input_key, 0).show();
        }
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.support.p012v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.support.p012v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        SearchTaskResult.set(new SearchTaskResult("", -1, new RectF[0], new RectF[0]));
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 0) {
            if (this.f12869n) {
                if (getIntent().getStringExtra(VastExtensionXmlManager.TYPE).equals("diag")) {
                    m6861a(this, DiagnoseActivity.class);
                } else {
                    m6861a(this, UpgradeActivity.class);
                }
                return true;
            }
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* renamed from: a */
    private static void m6861a(Activity activity, Class<?> cls) {
        ((MainActivity) activity.getParent()).m7898a(cls, (Intent) null);
    }
}
