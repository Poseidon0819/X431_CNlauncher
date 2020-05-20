package com.cnlaunch.golo3.view.selectimg.p166a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.cnlaunch.golo3.p154a.C1551a;
import com.cnlaunch.p132e.p133a.C1464a;
import java.util.List;

/* renamed from: com.cnlaunch.golo3.view.selectimg.a.c */
/* loaded from: classes.dex */
public final class PhotoFolderAdapter extends BaseAdapter {

    /* renamed from: a */
    C1551a f8579a;

    /* renamed from: b */
    private LayoutInflater f8580b;

    /* renamed from: c */
    private List<AlbumInfo> f8581c;

    /* renamed from: d */
    private C1626a f8582d;

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    public PhotoFolderAdapter(Context context, List<AlbumInfo> list, C1551a c1551a) {
        this.f8580b = LayoutInflater.from(context);
        this.f8581c = list;
        this.f8579a = c1551a;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.f8581c.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        return this.f8581c.get(i);
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            this.f8582d = new C1626a();
            view = this.f8580b.inflate(C1464a.C1469e.item_photofolder, (ViewGroup) null);
            this.f8582d.f8583a = (ImageView) view.findViewById(C1464a.C1468d.imageView);
            this.f8582d.f8584b = (TextView) view.findViewById(C1464a.C1468d.info);
            this.f8582d.f8585c = (TextView) view.findViewById(C1464a.C1468d.num);
            view.setTag(this.f8582d);
        } else {
            this.f8582d = (C1626a) view.getTag();
        }
        AlbumInfo albumInfo = this.f8581c.get(i);
        if (albumInfo != null && !TextUtils.isEmpty(albumInfo.getPath_absolute())) {
            C1551a c1551a = this.f8579a;
            int i2 = C1464a.C1467c.select_default_img;
            c1551a.f7664a.f7684d.f7744e = c1551a.f7670g.getResources().getDrawable(i2);
            this.f8579a.m9255a(this.f8582d.f8583a, albumInfo.getPath_file(), null);
        }
        this.f8582d.f8584b.setText(albumInfo.getName_album());
        TextView textView = this.f8582d.f8585c;
        textView.setText("(" + this.f8581c.get(i).getList().size() + ")");
        return view;
    }

    /* compiled from: PhotoFolderAdapter.java */
    /* renamed from: com.cnlaunch.golo3.view.selectimg.a.c$a */
    /* loaded from: classes.dex */
    public class C1626a {

        /* renamed from: a */
        public ImageView f8583a;

        /* renamed from: b */
        public TextView f8584b;

        /* renamed from: c */
        public TextView f8585c;

        public C1626a() {
        }
    }
}
