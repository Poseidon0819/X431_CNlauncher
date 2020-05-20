package com.cnlaunch.gmap.map.p152d;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.cnlaunch.gmap.map.p150b.PoiSearchInfo;
import com.cnlaunch.gmap.map.p151c.StringUtils;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.cnlaunch.gmap.map.d.a */
/* loaded from: classes.dex */
public final class MapSearchResultPop extends PopupWindow {

    /* renamed from: a */
    public PopupWindow f7601a;

    /* renamed from: b */
    public C1537b f7602b;

    /* renamed from: c */
    public int f7603c;

    /* renamed from: d */
    public View f7604d;

    /* renamed from: e */
    private Context f7605e;

    /* renamed from: f */
    private ListView f7606f;

    /* renamed from: g */
    private LayoutInflater f7607g;

    /* renamed from: h */
    private InterfaceC1536a f7608h;

    /* compiled from: MapSearchResultPop.java */
    /* renamed from: com.cnlaunch.gmap.map.d.a$a */
    /* loaded from: classes.dex */
    public interface InterfaceC1536a {
        /* renamed from: a */
        void mo9276a(PoiSearchInfo poiSearchInfo, int i);
    }

    public MapSearchResultPop(View view, Context context, InterfaceC1536a interfaceC1536a) {
        super(context);
        this.f7608h = interfaceC1536a;
        this.f7604d = view;
        this.f7605e = context;
        this.f7607g = LayoutInflater.from(this.f7605e);
        if (this.f7601a == null) {
            this.f7601a = new PopupWindow(view);
        }
        View inflate = this.f7607g.inflate(R.layout.gmap_map_search_match_pop, (ViewGroup) null);
        this.f7606f = (ListView) inflate.findViewById(R.id.map_search_match_list);
        this.f7602b = new C1537b();
        this.f7606f.setAdapter((ListAdapter) this.f7602b);
        this.f7601a.setWidth(view.getWidth());
        this.f7601a.setHeight(-2);
        this.f7601a.setBackgroundDrawable(new BitmapDrawable());
        this.f7601a.setOutsideTouchable(true);
        this.f7601a.setFocusable(false);
        this.f7601a.setContentView(inflate);
        this.f7601a.setInputMethodMode(1);
        this.f7601a.setSoftInputMode(16);
    }

    /* compiled from: MapSearchResultPop.java */
    /* renamed from: com.cnlaunch.gmap.map.d.a$b */
    /* loaded from: classes.dex */
    public class C1537b extends BaseAdapter {

        /* renamed from: a */
        public List<PoiSearchInfo> f7609a = new ArrayList();

        @Override // android.widget.Adapter
        public final long getItemId(int i) {
            return i;
        }

        C1537b() {
        }

        @Override // android.widget.Adapter
        public final int getCount() {
            return this.f7609a.size();
        }

        @Override // android.widget.Adapter
        public final Object getItem(int i) {
            return this.f7609a.get(i);
        }

        @Override // android.widget.Adapter
        public final View getView(int i, View view, ViewGroup viewGroup) {
            View view2;
            C1538c c1538c;
            PoiSearchInfo poiSearchInfo = this.f7609a.get(i);
            if (view == null) {
                c1538c = new C1538c();
                view2 = MapSearchResultPop.this.f7607g.inflate(R.layout.gmap_map_search_efence_item, (ViewGroup) null);
                c1538c.f7611a = (TextView) view2.findViewById(R.id.efence_key);
                view2.setTag(c1538c);
            } else {
                view2 = view;
                c1538c = (C1538c) view.getTag();
            }
            c1538c.f7611a.setText(poiSearchInfo.f7589a);
            if (StringUtils.m9282a(poiSearchInfo.f7589a)) {
                c1538c.f7611a.setText(poiSearchInfo.f7593e);
            }
            view2.setOnClickListener(new View$OnClickListenerC1539b(this, poiSearchInfo));
            return view2;
        }
    }

    /* compiled from: MapSearchResultPop.java */
    /* renamed from: com.cnlaunch.gmap.map.d.a$c */
    /* loaded from: classes.dex */
    class C1538c {

        /* renamed from: a */
        TextView f7611a;

        C1538c() {
        }
    }
}
