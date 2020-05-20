package com.cnlaunch.x431pro.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.x431pro.module.p252d.p253a.DiagnoseAction;
import com.cnlaunch.x431pro.module.p252d.p254b.AdvertiseResponse;
import com.cnlaunch.x431pro.utils.ViewFactory;
import com.cnlaunch.x431pro.widget.cycleviewpager.CycleViewPager;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class AdvertiseShowActivity extends ActivityC2004c {

    /* renamed from: C */
    private CycleViewPager f10600C;

    /* renamed from: E */
    private ViewFactory f10602E;

    /* renamed from: F */
    private RelativeLayout f10603F;

    /* renamed from: n */
    private List<ImageView> f10605n = new ArrayList();

    /* renamed from: D */
    private AdvertiseResponse[] f10601D = null;

    /* renamed from: G */
    private CycleViewPager.InterfaceC2900a f10604G = new C1990b(this);

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.support.p012v4.app.FragmentActivity, android.support.p012v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_advertise);
        m7743b();
        this.f10600C = (CycleViewPager) getFragmentManager().findFragmentById(R.id.fragment_cycle_viewpager_content);
        this.f10602E = new ViewFactory();
        this.f10603F = (RelativeLayout) findViewById(R.id.button_jump);
        this.f10603F.setOnClickListener(new View$OnClickListenerC1968a(this));
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.support.p012v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        NLog.m9456a("yhx", "loadDefaultAdvertisePic enter.");
        this.f10605n.clear();
        ImageView imageView = (ImageView) getLayoutInflater().inflate(R.layout.view_banner, (ViewGroup) null);
        imageView.setImageResource(R.drawable.advertise_default);
        this.f10605n.add(imageView);
        this.f10600C.m4494a(false);
        CycleViewPager cycleViewPager = this.f10600C;
        cycleViewPager.f16552b = false;
        cycleViewPager.m4496a(this.f10605n, (AdvertiseResponse[]) null, (CycleViewPager.InterfaceC2900a) null);
        m7739c(60007);
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public Object doInBackground(int i) throws C1425f {
        if (i == 60007) {
            return new DiagnoseAction(this.f10981q).m5365c(getResources().getConfiguration().orientation == 2 ? "3" : "4", "X-431 Pro");
        }
        return super.doInBackground(i);
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onSuccess(int i, Object obj) {
        if (i == 60007 && obj != null) {
            this.f10601D = (AdvertiseResponse[]) obj;
            AdvertiseResponse[] advertiseResponseArr = this.f10601D;
            if (advertiseResponseArr != null) {
                int length = advertiseResponseArr.length;
                NLog.m9456a("yhx", "len=".concat(String.valueOf(length)));
                if (length <= 1) {
                    for (int i2 = 0; i2 < length; i2++) {
                        NLog.m9456a("yhx", "advertiseResponses[i]=" + this.f10601D[i2]);
                        if (!TextUtils.isEmpty(this.f10601D[i2].getPicUrl())) {
                            this.f10605n.clear();
                            this.f10605n.add(this.f10602E.m5113a(this, this.f10601D[i2].getPicUrl()));
                        }
                    }
                    this.f10600C.m4494a(false);
                    this.f10600C.f16552b = false;
                } else {
                    int i3 = length - 1;
                    if (!TextUtils.isEmpty(this.f10601D[i3].getPicUrl())) {
                        this.f10605n.clear();
                        this.f10605n.add(this.f10602E.m5113a(this, this.f10601D[i3].getPicUrl()));
                    }
                    for (int i4 = 0; i4 < length; i4++) {
                        if (!TextUtils.isEmpty(this.f10601D[i4].getPicUrl())) {
                            this.f10605n.add(this.f10602E.m5113a(this, this.f10601D[i4].getPicUrl()));
                        }
                    }
                    if (!TextUtils.isEmpty(this.f10601D[0].getPicUrl())) {
                        this.f10605n.add(this.f10602E.m5113a(this, this.f10601D[0].getPicUrl()));
                    }
                    this.f10600C.m4494a(true);
                    CycleViewPager cycleViewPager = this.f10600C;
                    cycleViewPager.f16551a = 2000;
                    cycleViewPager.f16552b = true;
                }
                if (this.f10605n.isEmpty()) {
                    return;
                }
                this.f10600C.m4496a(this.f10605n, this.f10601D, this.f10604G);
            }
        }
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 0) {
            startActivity(new Intent(this.f10981q, MainActivity.class));
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
