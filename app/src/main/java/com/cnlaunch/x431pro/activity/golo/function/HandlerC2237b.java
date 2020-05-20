package com.cnlaunch.x431pro.activity.golo.function;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import com.cnlaunch.golo3.p165g.UserFaceUtils;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.x431pro.module.golo.model.GoloAppraiseInfo;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.ifoer.expedition.pro.R;
import com.p297e.p298a.p306b.DisplayImageOptions;
import com.p297e.p298a.p306b.ImageLoader;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AppraiseFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.golo.function.b */
/* loaded from: classes.dex */
public final class HandlerC2237b extends Handler {

    /* renamed from: a */
    final /* synthetic */ AppraiseFragment f12612a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC2237b(AppraiseFragment appraiseFragment) {
        this.f12612a = appraiseFragment;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message2) {
        TextView textView;
        GoloAppraiseInfo goloAppraiseInfo;
        TextView textView2;
        GoloAppraiseInfo goloAppraiseInfo2;
        TextView textView3;
        GoloAppraiseInfo goloAppraiseInfo3;
        TextView textView4;
        GoloAppraiseInfo goloAppraiseInfo4;
        RatingBar ratingBar;
        GoloAppraiseInfo goloAppraiseInfo5;
        TextView textView5;
        GoloAppraiseInfo goloAppraiseInfo6;
        TextView textView6;
        GoloAppraiseInfo goloAppraiseInfo7;
        TextView textView7;
        GoloAppraiseInfo goloAppraiseInfo8;
        GoloAppraiseInfo goloAppraiseInfo9;
        ImageView imageView;
        DisplayImageOptions displayImageOptions;
        GoloAppraiseInfo goloAppraiseInfo10;
        TextView textView8;
        GoloAppraiseInfo goloAppraiseInfo11;
        TextView textView9;
        GoloAppraiseInfo goloAppraiseInfo12;
        TextView textView10;
        GoloAppraiseInfo goloAppraiseInfo13;
        ImageView imageView2;
        Context context;
        GoloAppraiseInfo goloAppraiseInfo14;
        String str;
        ImageView imageView3;
        DisplayImageOptions displayImageOptions2;
        if (message2.what != 0) {
            return;
        }
        textView = this.f12612a.f12594i;
        goloAppraiseInfo = this.f12612a.f12604s;
        textView.setText(goloAppraiseInfo.getCar_plate());
        textView2 = this.f12612a.f12596k;
        goloAppraiseInfo2 = this.f12612a.f12604s;
        textView2.setText(goloAppraiseInfo2.getCar_name());
        textView3 = this.f12612a.f12595j;
        goloAppraiseInfo3 = this.f12612a.f12604s;
        textView3.setText(goloAppraiseInfo3.getCar_series());
        textView4 = this.f12612a.f12598m;
        goloAppraiseInfo4 = this.f12612a.f12604s;
        textView4.setText(goloAppraiseInfo4.getContent());
        ratingBar = this.f12612a.f12588c;
        goloAppraiseInfo5 = this.f12612a.f12604s;
        ratingBar.setProgress(goloAppraiseInfo5.getTotal());
        textView5 = this.f12612a.f12593h;
        goloAppraiseInfo6 = this.f12612a.f12604s;
        textView5.setText(goloAppraiseInfo6.getSignature());
        textView6 = this.f12612a.f12592g;
        goloAppraiseInfo7 = this.f12612a.f12604s;
        textView6.setText(goloAppraiseInfo7.getNick_name());
        textView7 = this.f12612a.f12597l;
        goloAppraiseInfo8 = this.f12612a.f12604s;
        textView7.setText(C2744aa.m5191a(goloAppraiseInfo8.getCreated() * 1000));
        ImageLoader m4191a = ImageLoader.m4191a();
        goloAppraiseInfo9 = this.f12612a.f12604s;
        String car_logo = goloAppraiseInfo9.getCar_logo();
        imageView = this.f12612a.f12591f;
        displayImageOptions = this.f12612a.f12605t;
        m4191a.m4188a(car_logo, imageView, displayImageOptions);
        goloAppraiseInfo10 = this.f12612a.f12604s;
        String sex = goloAppraiseInfo10.getSex();
        textView8 = this.f12612a.f12599n;
        AppraiseFragment appraiseFragment = this.f12612a;
        goloAppraiseInfo11 = appraiseFragment.f12604s;
        textView8.setText(AppraiseFragment.m7011a(appraiseFragment, 1, goloAppraiseInfo11.getAttitude()));
        textView9 = this.f12612a.f12600o;
        AppraiseFragment appraiseFragment2 = this.f12612a;
        goloAppraiseInfo12 = appraiseFragment2.f12604s;
        textView9.setText(AppraiseFragment.m7011a(appraiseFragment2, 2, goloAppraiseInfo12.getServe()));
        textView10 = this.f12612a.f12601p;
        AppraiseFragment appraiseFragment3 = this.f12612a;
        goloAppraiseInfo13 = appraiseFragment3.f12604s;
        textView10.setText(AppraiseFragment.m7011a(appraiseFragment3, 3, goloAppraiseInfo13.getSkill()));
        imageView2 = this.f12612a.f12590e;
        imageView2.setImageResource(sex.equals("1") ? R.drawable.sex_boy : R.drawable.sex_gril);
        context = this.f12612a.mContext;
        String m9591a = PreferencesManager.m9595a(context).m9591a("current_country");
        AppraiseFragment appraiseFragment4 = this.f12612a;
        goloAppraiseInfo14 = appraiseFragment4.f12604s;
        appraiseFragment4.f12609x = UserFaceUtils.m9114a(goloAppraiseInfo14.getUser_id(), null, m9591a.equalsIgnoreCase("CN") ? "1" : "2");
        ImageLoader m4191a2 = ImageLoader.m4191a();
        str = this.f12612a.f12609x;
        imageView3 = this.f12612a.f12589d;
        displayImageOptions2 = this.f12612a.f12605t;
        m4191a2.m4188a(str, imageView3, displayImageOptions2);
    }
}
