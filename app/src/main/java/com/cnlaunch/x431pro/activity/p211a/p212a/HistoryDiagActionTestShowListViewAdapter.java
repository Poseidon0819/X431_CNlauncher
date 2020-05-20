package com.cnlaunch.x431pro.activity.p211a.p212a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.cnlaunch.x431pro.module.history.model.HistoryActionModel;
import com.ifoer.expedition.pro.R;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.activity.a.a.a */
/* loaded from: classes.dex */
public final class HistoryDiagActionTestShowListViewAdapter extends BaseAdapter {

    /* renamed from: a */
    public List<HistoryActionModel> f10789a;

    /* renamed from: b */
    private Context f10790b;

    /* renamed from: c */
    private LayoutInflater f10791c;

    /* renamed from: d */
    private C1969a f10792d;

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    public HistoryDiagActionTestShowListViewAdapter(Context context) {
        this.f10790b = context;
        this.f10791c = LayoutInflater.from(this.f10790b);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        List<HistoryActionModel> list = this.f10789a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        return this.f10789a.get(i);
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            this.f10792d = new C1969a();
            view = this.f10791c.inflate(R.layout.history_diag_show_action_test_listview_item, (ViewGroup) null);
            this.f10792d.f10793a = (TextView) view.findViewById(R.id.tv_show_dtc_name);
            this.f10792d.f10794b = (TextView) view.findViewById(R.id.tv_show_dtc_status);
            view.setTag(this.f10792d);
        } else {
            this.f10792d = (C1969a) view.getTag();
        }
        if (this.f10789a != null) {
            this.f10792d.f10793a.setText(this.f10789a.get(i).getName());
            this.f10792d.f10794b.setText(this.f10789a.get(i).getResult());
        }
        return view;
    }

    /* compiled from: HistoryDiagActionTestShowListViewAdapter.java */
    /* renamed from: com.cnlaunch.x431pro.activity.a.a.a$a */
    /* loaded from: classes.dex */
    public class C1969a {

        /* renamed from: a */
        public TextView f10793a;

        /* renamed from: b */
        public TextView f10794b;

        public C1969a() {
        }
    }
}
