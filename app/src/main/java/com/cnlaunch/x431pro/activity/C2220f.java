package com.cnlaunch.x431pro.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;
import com.cnlaunch.golo3.p165g.UserFaceUtils;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.ifoer.expedition.pro.R;
import com.p297e.p298a.p306b.DisplayImageOptions;
import com.p297e.p298a.p306b.ImageLoader;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BaseActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.f */
/* loaded from: classes.dex */
public final class C2220f extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ ActivityC2004c f12496a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2220f(ActivityC2004c activityC2004c) {
        this.f12496a = activityC2004c;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        ImageView imageView;
        DisplayImageOptions m7730i;
        ImageView imageView2;
        ImageView imageView3;
        ImageView imageView4;
        DisplayImageOptions m7730i2;
        String action = intent.getAction();
        if (action.equalsIgnoreCase("login")) {
            this.f12496a.f10985u.setVisibility(8);
            imageView3 = this.f12496a.f10977I;
            imageView3.setVisibility(0);
            String m9114a = UserFaceUtils.m9114a(PreferencesManager.m9595a(this.f12496a.f10981q).m9591a("user_id"), null, PreferencesManager.m9595a(this.f12496a.f10981q).m9591a("current_country").equalsIgnoreCase("CN") ? "1" : "2");
            ImageLoader m4191a = ImageLoader.m4191a();
            imageView4 = this.f12496a.f10977I;
            m7730i2 = this.f12496a.m7730i();
            m4191a.m4188a(m9114a, imageView4, m7730i2);
        } else if (action.equalsIgnoreCase("logout")) {
            this.f12496a.f10985u.setVisibility(0);
            imageView2 = this.f12496a.f10977I;
            imageView2.setVisibility(8);
            this.f12496a.f10985u.setText(R.string.login_right);
            this.f12496a.f10985u.setClickable(true);
        } else if (action.equalsIgnoreCase("changeFace")) {
            String m9114a2 = UserFaceUtils.m9114a(PreferencesManager.m9595a(this.f12496a.f10981q).m9591a("user_id"), null, PreferencesManager.m9595a(this.f12496a.f10981q).m9591a("current_country").equalsIgnoreCase("CN") ? "1" : "2");
            ImageLoader m4191a2 = ImageLoader.m4191a();
            imageView = this.f12496a.f10977I;
            m7730i = this.f12496a.m7730i();
            m4191a2.m4188a(m9114a2, imageView, m7730i);
        } else if (action.equals("unupgradeSoftNumChanged")) {
            if (PreferencesManager.m9595a(this.f12496a.f10981q).m9585b("unupdateSoftwareNum", 0) + PreferencesManager.m9595a(this.f12496a.f10981q).m9585b("unupdateSoftwareNumForHeavyduty", 0) > 0) {
                this.f12496a.m7735e(0);
            } else {
                this.f12496a.m7735e(8);
            }
        }
    }
}
