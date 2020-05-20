package com.cnlaunch.x431pro.activity.diagnose.p218a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.cnlaunch.diagnosemodule.bean.BasicDataStreamBean;
import com.cnlaunch.x431pro.module.p252d.p254b.SerializableMap;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.utils.p280b.MeasureConversion;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.activity.diagnose.a.e */
/* loaded from: classes.dex */
public final class DataStreamShowListAdapter extends BaseAdapter {

    /* renamed from: c */
    public SerializableMap f11296c;

    /* renamed from: d */
    private LayoutInflater f11297d;

    /* renamed from: g */
    private Context f11300g;

    /* renamed from: e */
    private List<Boolean> f11298e = new ArrayList();

    /* renamed from: a */
    public int f11294a = -1;

    /* renamed from: f */
    private List<BasicDataStreamBean> f11299f = new ArrayList();

    /* renamed from: b */
    public String f11295b = "0";

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    public DataStreamShowListAdapter(String str, Context context) {
        m7518a(str);
        this.f11297d = LayoutInflater.from(context);
        this.f11300g = context;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        List<BasicDataStreamBean> list = this.f11299f;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        return Integer.valueOf(i);
    }

    @Override // android.widget.Adapter
    public final synchronized View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        C2016a c2016a;
        if (view == null) {
            c2016a = new C2016a();
            view2 = this.f11297d.inflate(R.layout.item_list_datastream, (ViewGroup) null);
            c2016a.f11302b = (TextView) view2.findViewById(R.id.title);
            c2016a.f11303c = (TextView) view2.findViewById(R.id.value);
            c2016a.f11304d = (TextView) view2.findViewById(R.id.unit);
            c2016a.f11305e = (TextView) view2.findViewById(R.id.standValue);
            c2016a.f11306f = (CheckBox) view2.findViewById(R.id.cb_list_select);
            view2.setTag(c2016a);
        } else {
            view2 = view;
            c2016a = (C2016a) view.getTag();
        }
        c2016a.f11301a = this.f11299f.get(i).getId();
        String title = this.f11299f.get(i).getTitle();
        if (this.f11296c != null && this.f11296c.getMap() != null) {
            String str = this.f11296c.getMap().get(title);
            if (!TextUtils.isEmpty(str)) {
                c2016a.f11302b.setText(str);
            } else {
                c2016a.f11302b.setText(title);
            }
        } else {
            c2016a.f11302b.setText(title);
        }
        if (this.f11295b.compareToIgnoreCase("1") == 0) {
            c2016a.f11305e.setVisibility(0);
            c2016a.f11305e.setText(this.f11299f.get(i).getStandardvalue());
        } else {
            c2016a.f11305e.setVisibility(8);
        }
        if (this.f11299f.get(i).getValuestatus() != null && this.f11299f.get(i).getValuestatus().compareToIgnoreCase("1") == 0) {
            m7519a(c2016a, -65536);
        } else {
            m7519a(c2016a, new TextView(this.f11300g).getPaint().getColor());
        }
        c2016a.f11303c.setText(this.f11299f.get(i).getValue());
        c2016a.f11304d.setText(this.f11299f.get(i).getUnit());
        c2016a.f11306f.setVisibility(8);
        c2016a.f11306f.setChecked(m7514b(i));
        c2016a.f11306f.setClickable(false);
        if (this.f11294a == i) {
            view2.setActivated(true);
        } else {
            view2.setActivated(false);
        }
        return view2;
    }

    /* renamed from: a */
    private static void m7519a(C2016a c2016a, int i) {
        c2016a.f11302b.setTextColor(i);
        c2016a.f11302b.setTextColor(i);
        c2016a.f11303c.setTextColor(i);
        c2016a.f11304d.setTextColor(i);
        c2016a.f11305e.setTextColor(i);
    }

    /* renamed from: a */
    public final void m7517a(ArrayList<BasicDataStreamBean> arrayList) {
        this.f11299f = MeasureConversion.m5099a(C2744aa.m5158d(this.f11300g), arrayList);
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DataStreamShowListAdapter.java */
    /* renamed from: com.cnlaunch.x431pro.activity.diagnose.a.e$a */
    /* loaded from: classes.dex */
    public class C2016a {

        /* renamed from: a */
        String f11301a;

        /* renamed from: b */
        TextView f11302b;

        /* renamed from: c */
        TextView f11303c;

        /* renamed from: d */
        TextView f11304d;

        /* renamed from: e */
        TextView f11305e;

        /* renamed from: f */
        CheckBox f11306f;

        C2016a() {
        }
    }

    /* renamed from: a */
    public final void m7520a(int i) {
        if (this.f11299f.size() <= 0 || this.f11299f.get(i).equals("") || this.f11299f.size() <= i) {
            return;
        }
        this.f11294a = i;
        notifyDataSetChanged();
    }

    /* renamed from: a */
    private void m7518a(String str) {
        for (int i = 0; i < str.length(); i++) {
            this.f11298e.add(Boolean.valueOf(str.charAt(i) == '1'));
        }
    }

    /* renamed from: b */
    private boolean m7514b(int i) {
        List<Boolean> list = this.f11298e;
        if (list == null || list.size() <= 0) {
            return false;
        }
        try {
            return this.f11298e.get(i).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: a */
    public final void m7516a(boolean z) {
        List<Boolean> list = this.f11298e;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (int i = 0; i < this.f11298e.size(); i++) {
            this.f11298e.set(i, Boolean.valueOf(z));
        }
        notifyDataSetChanged();
    }

    /* renamed from: a */
    public final String m7521a() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.f11298e.size(); i++) {
            sb.append(m7514b(i) ? "1" : "0");
        }
        return sb.toString();
    }

    /* renamed from: b */
    public final void m7515b() {
        this.f11299f = MeasureConversion.m5099a(C2744aa.m5158d(this.f11300g), this.f11299f);
        notifyDataSetChanged();
    }
}
