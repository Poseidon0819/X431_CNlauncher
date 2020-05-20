package com.cnlaunch.x431pro.activity.diagnose.p218a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.cnlaunch.diagnosemodule.bean.BasicCombineMenuBean;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;

/* renamed from: com.cnlaunch.x431pro.activity.diagnose.a.d */
/* loaded from: classes.dex */
public final class CombineMenuShowListAdapter extends BaseAdapter {

    /* renamed from: a */
    ArrayList<BasicCombineMenuBean> f11288a;

    /* renamed from: b */
    C2015a f11289b = null;

    /* renamed from: c */
    private LayoutInflater f11290c;

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    public CombineMenuShowListAdapter(ArrayList<BasicCombineMenuBean> arrayList, Context context) {
        this.f11290c = LayoutInflater.from(context);
        this.f11288a = arrayList;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.f11288a.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        return Integer.valueOf(i);
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            this.f11289b = new C2015a();
            view = this.f11290c.inflate(R.layout.item_list_combinemenu, (ViewGroup) null);
            this.f11289b.f11291a = (TextView) view.findViewById(R.id.title);
            this.f11289b.f11292b = (TextView) view.findViewById(R.id.value);
            view.setTag(this.f11289b);
        } else {
            this.f11289b = (C2015a) view.getTag();
        }
        this.f11289b.f11291a.setText(this.f11288a.get(i).getTitle());
        this.f11289b.f11292b.setText(this.f11288a.get(i).getValue());
        view.setId(i);
        return view;
    }

    /* compiled from: CombineMenuShowListAdapter.java */
    /* renamed from: com.cnlaunch.x431pro.activity.diagnose.a.d$a */
    /* loaded from: classes.dex */
    class C2015a {

        /* renamed from: a */
        TextView f11291a;

        /* renamed from: b */
        TextView f11292b;

        C2015a() {
        }
    }
}
