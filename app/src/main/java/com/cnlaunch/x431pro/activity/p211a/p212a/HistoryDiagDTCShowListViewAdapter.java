package com.cnlaunch.x431pro.activity.p211a.p212a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.cnlaunch.x431pro.module.history.model.HistoryDTCModel;
import com.ifoer.expedition.pro.R;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.activity.a.a.b */
/* loaded from: classes.dex */
public final class HistoryDiagDTCShowListViewAdapter extends BaseAdapter {

    /* renamed from: a */
    public List<HistoryDTCModel> f10796a;

    /* renamed from: b */
    public boolean f10797b = false;

    /* renamed from: c */
    private Context f10798c;

    /* renamed from: d */
    private LayoutInflater f10799d;

    /* renamed from: e */
    private C1970a f10800e;

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    public HistoryDiagDTCShowListViewAdapter(Context context) {
        this.f10798c = context;
        this.f10799d = LayoutInflater.from(this.f10798c);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        List<HistoryDTCModel> list = this.f10796a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        return this.f10796a.get(i);
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            this.f10800e = new C1970a();
            view = this.f10799d.inflate(R.layout.history_diag_show_dtc_listview_item, (ViewGroup) null);
            this.f10800e.f10802b = (TextView) view.findViewById(R.id.tv_show_dtc_des);
            this.f10800e.f10801a = (TextView) view.findViewById(R.id.tv_show_dtc_name);
            this.f10800e.f10803c = (TextView) view.findViewById(R.id.tv_show_dtc_status);
            this.f10800e.f10804d = (TextView) view.findViewById(R.id.tv_show_dtc_sys);
            view.setTag(this.f10800e);
        } else {
            this.f10800e = (C1970a) view.getTag();
        }
        List<HistoryDTCModel> list = this.f10796a;
        if (list != null) {
            String trim = list.get(i).getDescription().trim();
            if (trim.equals("CONSULT HANDBOOK")) {
                trim = this.f10798c.getString(R.string.diagnose_consult_handbook);
            }
            this.f10800e.f10802b.setText(trim);
            this.f10800e.f10801a.setText(this.f10796a.get(i).getDTC());
            this.f10800e.f10803c.setText(this.f10796a.get(i).getStatus());
            this.f10800e.f10804d.setText(this.f10796a.get(i).getSystemName());
        }
        if (this.f10797b) {
            this.f10800e.f10804d.setVisibility(0);
        } else {
            this.f10800e.f10804d.setVisibility(8);
        }
        return view;
    }

    /* compiled from: HistoryDiagDTCShowListViewAdapter.java */
    /* renamed from: com.cnlaunch.x431pro.activity.a.a.b$a */
    /* loaded from: classes.dex */
    public class C1970a {

        /* renamed from: a */
        public TextView f10801a;

        /* renamed from: b */
        public TextView f10802b;

        /* renamed from: c */
        public TextView f10803c;

        /* renamed from: d */
        public TextView f10804d;

        public C1970a() {
        }
    }
}
