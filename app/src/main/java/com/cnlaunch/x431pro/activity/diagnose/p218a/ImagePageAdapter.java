package com.cnlaunch.x431pro.activity.diagnose.p218a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.ifoer.expedition.pro.R;

/* renamed from: com.cnlaunch.x431pro.activity.diagnose.a.n */
/* loaded from: classes.dex */
public final class ImagePageAdapter extends BaseAdapter {

    /* renamed from: c */
    private LayoutInflater f11385c;

    /* renamed from: d */
    private int f11386d;

    /* renamed from: b */
    private int f11384b = 0;

    /* renamed from: a */
    C2025a f11383a = null;

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    public ImagePageAdapter(Context context, int i) {
        this.f11386d = 0;
        this.f11386d = i;
        this.f11385c = LayoutInflater.from(context);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.f11386d;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        return Integer.valueOf(i);
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            this.f11383a = new C2025a();
            view = this.f11385c.inflate(R.layout.item_grid_image, (ViewGroup) null);
            this.f11383a.f11387a = (ImageView) view.findViewById(R.id.image_page);
            view.setTag(this.f11383a);
        } else {
            this.f11383a = (C2025a) view.getTag();
        }
        this.f11383a.f11387a.setActivated(this.f11384b == i);
        return view;
    }

    /* compiled from: ImagePageAdapter.java */
    /* renamed from: com.cnlaunch.x431pro.activity.diagnose.a.n$a */
    /* loaded from: classes.dex */
    class C2025a {

        /* renamed from: a */
        ImageView f11387a;

        C2025a() {
        }
    }

    /* renamed from: a */
    public final void m7489a(int i) {
        this.f11384b = i;
        notifyDataSetChanged();
    }
}
