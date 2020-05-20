package com.cnlaunch.x431pro.activity.tools.p237a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.cnlaunch.x431pro.module.p267i.p268a.ToolBaseDataInfo;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.activity.tools.a.a */
/* loaded from: classes.dex */
public final class ToolsAdapter extends BaseAdapter {

    /* renamed from: a */
    public List<ToolBaseDataInfo> f14968a;

    /* renamed from: b */
    private Context f14969b;

    /* renamed from: c */
    private LayoutInflater f14970c;

    /* renamed from: d */
    private C2598a f14971d;

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    public ToolsAdapter(Context context, ArrayList<ToolBaseDataInfo> arrayList) {
        this.f14969b = context;
        this.f14968a = arrayList;
        this.f14970c = LayoutInflater.from(this.f14969b);
    }

    /* compiled from: ToolsAdapter.java */
    /* renamed from: com.cnlaunch.x431pro.activity.tools.a.a$a */
    /* loaded from: classes.dex */
    class C2598a {

        /* renamed from: a */
        ImageView f14972a;

        /* renamed from: b */
        TextView f14973b;

        C2598a() {
        }
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        List<ToolBaseDataInfo> list = this.f14968a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        return this.f14968a.get(i);
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            this.f14971d = new C2598a();
            view = this.f14970c.inflate(R.layout.tools_gridview_item, (ViewGroup) null);
            this.f14971d.f14972a = (ImageView) view.findViewById(R.id.img_icon);
            this.f14971d.f14973b = (TextView) view.findViewById(R.id.tv_title);
            view.setTag(this.f14971d);
        } else {
            this.f14971d = (C2598a) view.getTag();
        }
        this.f14971d.f14972a.setImageResource(this.f14968a.get(i).getImageResid());
        this.f14971d.f14973b.setText(this.f14968a.get(i).getTitleResid());
        return view;
    }
}
