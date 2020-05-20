package com.cnlaunch.x431pro.activity.diagnose.p218a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.cnlaunch.diagnosemodule.bean.BasicMenuBean;
import com.ifoer.expedition.pro.R;
import java.util.List;
import java.util.Locale;

@SuppressLint({"DefaultLocale"})
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.a.q */
/* loaded from: classes.dex */
public class ResetCarIconAdapter extends BaseAdapter {

    /* renamed from: b */
    private static final String f11407b = "q";

    /* renamed from: a */
    public List<BasicMenuBean> f11408a;

    /* renamed from: c */
    private Context f11409c;

    /* renamed from: d */
    private LayoutInflater f11410d;

    /* renamed from: e */
    private C2028a f11411e;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public ResetCarIconAdapter(Context context) {
        this.f11409c = context;
        this.f11410d = LayoutInflater.from(this.f11409c);
    }

    /* compiled from: ResetCarIconAdapter.java */
    /* renamed from: com.cnlaunch.x431pro.activity.diagnose.a.q$a */
    /* loaded from: classes.dex */
    class C2028a {

        /* renamed from: a */
        TextView f11412a;

        C2028a() {
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<BasicMenuBean> list = this.f11408a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f11408a.get(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        BasicMenuBean basicMenuBean;
        if (view == null) {
            this.f11411e = new C2028a();
            view = this.f11410d.inflate(R.layout.diagnose_reset_caricon_item, viewGroup, false);
            this.f11411e.f11412a = (TextView) view.findViewById(R.id.car_name);
            view.setTag(this.f11411e);
        } else {
            this.f11411e = (C2028a) view.getTag();
        }
        try {
            basicMenuBean = this.f11408a.get(i);
        } catch (Exception e) {
            e.printStackTrace();
            basicMenuBean = null;
        }
        if (basicMenuBean != null) {
            this.f11411e.f11412a.setText(basicMenuBean.getTitle().toUpperCase(Locale.getDefault()));
        }
        return view;
    }
}
