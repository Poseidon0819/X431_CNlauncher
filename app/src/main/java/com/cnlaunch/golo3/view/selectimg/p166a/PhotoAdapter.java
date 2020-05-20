package com.cnlaunch.golo3.view.selectimg.p166a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import com.cnlaunch.golo3.p165g.WindowUtils;
import com.cnlaunch.p132e.p133a.C1464a;
import com.p297e.p298a.p306b.DisplayImageOptions;
import com.p297e.p298a.p306b.ImageLoader;
import com.p297e.p298a.p306b.p312e.ImageViewAware;
import java.util.List;

/* renamed from: com.cnlaunch.golo3.view.selectimg.a.b */
/* loaded from: classes.dex */
public final class PhotoAdapter extends BaseAdapter {

    /* renamed from: a */
    ImageLoader f8569a;

    /* renamed from: b */
    private LayoutInflater f8570b;

    /* renamed from: c */
    private List<PhotoInfo> f8571c;

    /* renamed from: d */
    private C1625a f8572d;

    /* renamed from: e */
    private GridView f8573e;

    /* renamed from: f */
    private int f8574f = WindowUtils.m9110a()[0] / 2;

    /* renamed from: g */
    private int f8575g = WindowUtils.m9110a()[1] / 2;

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    public PhotoAdapter(Context context, List<PhotoInfo> list, GridView gridView, ImageLoader imageLoader) {
        this.f8570b = LayoutInflater.from(context);
        this.f8571c = list;
        this.f8573e = gridView;
        this.f8569a = imageLoader;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.f8571c.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        return this.f8571c.get(i);
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            this.f8572d = new C1625a();
            view = this.f8570b.inflate(C1464a.C1469e.item_selectphoto, (ViewGroup) null);
            this.f8572d.f8576a = (ImageView) view.findViewById(C1464a.C1468d.imageView);
            this.f8572d.f8577b = (ImageView) view.findViewById(C1464a.C1468d.selectImage);
            view.setTag(this.f8572d);
        } else {
            this.f8572d = (C1625a) view.getTag();
        }
        if (this.f8571c.get(i).isChoose()) {
            this.f8572d.f8577b.setImageResource(C1464a.C1467c.gou_selected);
        } else {
            this.f8572d.f8577b.setImageResource(C1464a.C1467c.gou_normal);
        }
        ViewGroup.LayoutParams layoutParams = this.f8572d.f8576a.getLayoutParams();
        layoutParams.width = this.f8574f;
        layoutParams.height = this.f8575g;
        this.f8572d.f8576a.setLayoutParams(layoutParams);
        PhotoInfo photoInfo = this.f8571c.get(i);
        if (photoInfo != null && !TextUtils.isEmpty(photoInfo.getPath_file())) {
            this.f8569a.m4187a(photoInfo.getPath_file(), new ImageViewAware(this.f8572d.f8576a), (DisplayImageOptions) null);
        }
        return view;
    }

    /* compiled from: PhotoAdapter.java */
    /* renamed from: com.cnlaunch.golo3.view.selectimg.a.b$a */
    /* loaded from: classes.dex */
    public class C1625a {

        /* renamed from: a */
        public ImageView f8576a;

        /* renamed from: b */
        public ImageView f8577b;

        public C1625a() {
        }
    }
}
