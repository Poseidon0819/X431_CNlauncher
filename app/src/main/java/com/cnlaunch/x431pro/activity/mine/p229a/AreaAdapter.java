package com.cnlaunch.x431pro.activity.mine.p229a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SectionIndexer;
import android.widget.TextView;
import com.cnlaunch.x431pro.widget.sortlistview.SortModel;
import com.ifoer.expedition.pro.R;
import java.util.List;

@SuppressLint({"DefaultLocale"})
/* renamed from: com.cnlaunch.x431pro.activity.mine.a.a */
/* loaded from: classes.dex */
public final class AreaAdapter extends BaseAdapter implements SectionIndexer {

    /* renamed from: a */
    private List<SortModel> f13552a;

    /* renamed from: b */
    private Context f13553b;

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.SectionIndexer
    public final Object[] getSections() {
        return null;
    }

    public AreaAdapter(Context context, List<SortModel> list) {
        this.f13552a = null;
        this.f13553b = context;
        this.f13552a = list;
    }

    /* renamed from: a */
    public final void m6515a(List<SortModel> list) {
        this.f13552a = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.f13552a.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        return this.f13552a.get(i);
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        C2385a c2385a;
        SortModel sortModel = this.f13552a.get(i);
        if (view == null) {
            c2385a = new C2385a();
            view2 = LayoutInflater.from(this.f13553b).inflate(R.layout.mine_arealist_item, (ViewGroup) null);
            c2385a.f13555b = (TextView) view2.findViewById(R.id.tv_area_name);
            c2385a.f13554a = (TextView) view2.findViewById(R.id.tv_letter);
            view2.setTag(c2385a);
        } else {
            view2 = view;
            c2385a = (C2385a) view.getTag();
        }
        if (i == getPositionForSection(getSectionForPosition(i))) {
            c2385a.f13554a.setVisibility(0);
            c2385a.f13554a.setText(sortModel.f16812b);
        } else {
            c2385a.f13554a.setVisibility(8);
        }
        c2385a.f13555b.setText(this.f13552a.get(i).f16811a);
        return view2;
    }

    /* compiled from: AreaAdapter.java */
    /* renamed from: com.cnlaunch.x431pro.activity.mine.a.a$a */
    /* loaded from: classes.dex */
    static final class C2385a {

        /* renamed from: a */
        TextView f13554a;

        /* renamed from: b */
        TextView f13555b;

        C2385a() {
        }
    }

    @Override // android.widget.SectionIndexer
    public final int getSectionForPosition(int i) {
        return this.f13552a.get(i).f16812b.charAt(0);
    }

    @Override // android.widget.SectionIndexer
    public final int getPositionForSection(int i) {
        for (int i2 = 0; i2 < getCount(); i2++) {
            if (this.f13552a.get(i2).f16812b.toUpperCase().charAt(0) == i) {
                return i2;
            }
        }
        return -1;
    }
}
