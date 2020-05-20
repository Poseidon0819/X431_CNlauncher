package com.cnlaunch.x431pro.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.ifoer.expedition.pro.R;
import com.p297e.p298a.p306b.DisplayImageOptions;
import com.p297e.p298a.p306b.ImageLoader;

/* renamed from: com.cnlaunch.x431pro.utils.ae */
/* loaded from: classes.dex */
public final class ViewFactory {

    /* renamed from: a */
    private DisplayImageOptions f15715a;

    public ViewFactory() {
        DisplayImageOptions.C3010a c3010a = new DisplayImageOptions.C3010a();
        c3010a.f17117a = R.drawable.advertise_default;
        c3010a.f17118b = R.drawable.advertise_default;
        c3010a.f17119c = R.drawable.advertise_default;
        c3010a.f17117a = R.drawable.advertise_default;
        c3010a.f17124h = true;
        c3010a.f17125i = true;
        this.f15715a = c3010a.m4193a();
    }

    /* renamed from: a */
    public final ImageView m5113a(Context context, String str) {
        ImageView imageView = (ImageView) LayoutInflater.from(context).inflate(R.layout.view_banner, (ViewGroup) null);
        ImageLoader.m4191a().m4188a(str, imageView, this.f15715a);
        return imageView;
    }
}
