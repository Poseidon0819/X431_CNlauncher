package com.cnlaunch.x431pro.activity.p211a.p212a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.ifoer.expedition.pro.R;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.activity.a.a.g */
/* loaded from: classes.dex */
public final class HistoryListViewAdapter extends BaseAdapter {

    /* renamed from: b */
    public View f10829b;

    /* renamed from: d */
    public HashMap<String, Integer> f10831d;

    /* renamed from: e */
    private Context f10832e;

    /* renamed from: f */
    private LayoutInflater f10833f;

    /* renamed from: g */
    private C1975a f10834g;

    /* renamed from: c */
    public int f10830c = -1;

    /* renamed from: a */
    public List<String> f10828a = null;

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    public HistoryListViewAdapter(Context context) {
        this.f10832e = context;
        this.f10833f = LayoutInflater.from(this.f10832e);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        List<String> list = this.f10828a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        return this.f10828a.get(i);
    }

    @Override // android.widget.Adapter
    @SuppressLint({"SimpleDateFormat"})
    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            this.f10834g = new C1975a();
            view = this.f10833f.inflate(R.layout.history_first_menu_list_item, (ViewGroup) null);
            this.f10834g.f10835a = (TextView) view.findViewById(R.id.tv_show_date);
            this.f10834g.f10836b = (TextView) view.findViewById(R.id.tv_show_number);
            if (this.f10828a != null) {
                this.f10834g.f10835a.setText(this.f10828a.size() > i ? this.f10828a.get(i) : "");
                TextView textView = this.f10834g.f10836b;
                textView.setText("(" + this.f10831d.get(this.f10828a.get(i)) + ")");
            }
            view.setTag(this.f10834g);
        } else {
            this.f10834g = (C1975a) view.getTag();
            String str = this.f10828a.size() > i ? this.f10828a.get(i) : "";
            this.f10834g.f10835a.setText(str);
            TextView textView2 = this.f10834g.f10836b;
            textView2.setText("(" + this.f10831d.get(str) + ")");
        }
        if (this.f10830c == i) {
            view.setBackgroundColor(-14540254);
            this.f10829b = view;
        } else {
            view.setBackgroundColor(0);
        }
        return view;
    }

    /* compiled from: HistoryListViewAdapter.java */
    /* renamed from: com.cnlaunch.x431pro.activity.a.a.g$a */
    /* loaded from: classes.dex */
    public class C1975a {

        /* renamed from: a */
        public TextView f10835a;

        /* renamed from: b */
        public TextView f10836b;

        public C1975a() {
        }
    }
}
