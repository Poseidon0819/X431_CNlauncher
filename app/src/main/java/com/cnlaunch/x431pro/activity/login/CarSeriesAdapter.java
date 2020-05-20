package com.cnlaunch.x431pro.activity.login;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.cnlaunch.x431pro.activity.p213b.p215b.CarSeriesInfo;
import com.ifoer.expedition.pro.R;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.activity.login.g */
/* loaded from: classes.dex */
public final class CarSeriesAdapter extends BaseExpandableListAdapter {

    /* renamed from: c */
    private static HashMap<Integer, Boolean> f13490c = new HashMap<>();

    /* renamed from: a */
    private Context f13491a;

    /* renamed from: b */
    private List<CarSeriesInfo> f13492b;

    @Override // android.widget.ExpandableListAdapter
    public final long getChildId(int i, int i2) {
        return i2;
    }

    @Override // android.widget.ExpandableListAdapter
    public final long getGroupId(int i) {
        return i;
    }

    @Override // android.widget.ExpandableListAdapter
    public final boolean hasStableIds() {
        return true;
    }

    @Override // android.widget.ExpandableListAdapter
    public final boolean isChildSelectable(int i, int i2) {
        return true;
    }

    public CarSeriesAdapter(Context context, List<CarSeriesInfo> list) {
        this.f13491a = context;
        this.f13492b = list;
        m6535c();
    }

    /* renamed from: c */
    private void m6535c() {
        for (int i = 0; i < this.f13492b.size(); i++) {
            f13490c.put(Integer.valueOf(i), Boolean.FALSE);
        }
    }

    @Override // android.widget.ExpandableListAdapter
    public final int getGroupCount() {
        return this.f13492b.size();
    }

    @Override // android.widget.ExpandableListAdapter
    public final int getChildrenCount(int i) {
        if (this.f13492b.get(i).getSubList() == null) {
            return 0;
        }
        return this.f13492b.get(i).getSubList().size();
    }

    @Override // android.widget.ExpandableListAdapter
    public final Object getGroup(int i) {
        return this.f13492b.get(i);
    }

    @Override // android.widget.ExpandableListAdapter
    public final Object getChild(int i, int i2) {
        return this.f13492b.get(i).getSubList().get(i2);
    }

    @Override // android.widget.ExpandableListAdapter
    public final View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        C2365a c2365a;
        if (view == null) {
            c2365a = new C2365a();
            view = ((LayoutInflater) this.f13491a.getSystemService("layout_inflater")).inflate(R.layout.item_carseries_parent, (ViewGroup) null);
            c2365a.f13493a = (TextView) view.findViewById(R.id.text_carName_parent);
            c2365a.f13494b = (CheckBox) view.findViewById(R.id.checkbox_parent);
            view.setTag(c2365a);
        } else {
            c2365a = (C2365a) view.getTag();
        }
        c2365a.f13493a.setText(this.f13492b.get(i).getCarSeriesName());
        c2365a.f13494b.setOnCheckedChangeListener(new C2366h(this, i));
        c2365a.f13494b.setChecked(f13490c.get(Integer.valueOf(i)).booleanValue());
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public final View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        Log.i("test", "getChildView" + this.f13492b.get(i).getSubList().get(i2).getCarSeriesName());
        if (view == null) {
            view = ((LayoutInflater) this.f13491a.getSystemService("layout_inflater")).inflate(R.layout.item_carseries_children, (ViewGroup) null);
        }
        ((TextView) view.findViewById(R.id.text_carName_childern)).setText(this.f13492b.get(i).getSubList().get(i2).getCarSeriesName());
        return view;
    }

    /* compiled from: CarSeriesAdapter.java */
    /* renamed from: com.cnlaunch.x431pro.activity.login.g$a */
    /* loaded from: classes.dex */
    public class C2365a {

        /* renamed from: a */
        TextView f13493a;

        /* renamed from: b */
        CheckBox f13494b;

        public C2365a() {
        }
    }

    /* renamed from: a */
    public static HashMap<Integer, Boolean> m6537a() {
        return f13490c;
    }
}
