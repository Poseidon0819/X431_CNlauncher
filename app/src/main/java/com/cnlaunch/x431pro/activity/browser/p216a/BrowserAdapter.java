package com.cnlaunch.x431pro.activity.browser.p216a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.cnlaunch.x431pro.module.p243b.p244a.BrowserWebSiteInfo;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.activity.browser.a.a */
/* loaded from: classes.dex */
public final class BrowserAdapter extends BaseAdapter {

    /* renamed from: a */
    private Context f10963a;

    /* renamed from: b */
    private LayoutInflater f10964b;

    /* renamed from: c */
    private C2003a f10965c;

    /* renamed from: d */
    private List<BrowserWebSiteInfo> f10966d;

    /* compiled from: BrowserAdapter.java */
    /* renamed from: com.cnlaunch.x431pro.activity.browser.a.a$a */
    /* loaded from: classes.dex */
    public static class C2003a {

        /* renamed from: a */
        public ImageView f10967a;

        /* renamed from: b */
        public String f10968b;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    public BrowserAdapter(Context context, ArrayList<BrowserWebSiteInfo> arrayList) {
        this.f10963a = context;
        this.f10966d = arrayList;
        this.f10964b = LayoutInflater.from(this.f10963a);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        List<BrowserWebSiteInfo> list = this.f10966d;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        return this.f10966d.get(i);
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            this.f10965c = new C2003a();
            view = this.f10964b.inflate(R.layout.browser_gridview_item, (ViewGroup) null);
            this.f10965c.f10967a = (ImageView) view.findViewById(R.id.img_icon);
            this.f10965c.f10968b = this.f10966d.get(i).getWebSite();
            view.setTag(this.f10965c);
        } else {
            this.f10965c = (C2003a) view.getTag();
        }
        this.f10965c.f10967a.setImageResource(this.f10966d.get(i).getImageResid());
        this.f10965c.f10968b = this.f10966d.get(i).getWebSite();
        return view;
    }
}
