package com.cnlaunch.x431pro.activity.mine.p229a;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cnlaunch.x431pro.module.p255e.p257b.ReportFileInfo;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.ifoer.expedition.pro.R;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

/* renamed from: com.cnlaunch.x431pro.activity.mine.a.b */
/* loaded from: classes.dex */
public final class MyReportAdapter extends BaseAdapter {

    /* renamed from: a */
    public List<ReportFileInfo> f13556a;

    /* renamed from: b */
    private Context f13557b;

    /* renamed from: c */
    private LayoutInflater f13558c;

    /* renamed from: d */
    private C2386a f13559d;

    /* renamed from: e */
    private String f13560e;

    /* renamed from: f */
    private Handler f13561f;

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    public MyReportAdapter(Context context, List<ReportFileInfo> list, Handler handler) {
        this.f13557b = context;
        this.f13558c = LayoutInflater.from(this.f13557b);
        this.f13556a = list;
        this.f13561f = handler;
    }

    /* renamed from: a */
    public final void m6511a(List<ReportFileInfo> list) {
        this.f13556a = list;
        notifyDataSetChanged();
        this.f13561f.sendEmptyMessage(0);
    }

    /* compiled from: MyReportAdapter.java */
    /* renamed from: com.cnlaunch.x431pro.activity.mine.a.b$a */
    /* loaded from: classes.dex */
    class C2386a {

        /* renamed from: a */
        TextView f13562a;

        /* renamed from: b */
        TextView f13563b;

        /* renamed from: c */
        CheckBox f13564c;

        /* renamed from: d */
        RelativeLayout f13565d;

        /* renamed from: e */
        View f13566e;

        /* renamed from: f */
        TextView f13567f;

        C2386a() {
        }
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        List<ReportFileInfo> list = this.f13556a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        return this.f13556a.get(i);
    }

    /* renamed from: b */
    private boolean m6509b(int i) {
        List<ReportFileInfo> list = this.f13556a;
        if (list == null || list.size() <= 0) {
            return false;
        }
        return this.f13556a.get(i).isCheck();
    }

    /* renamed from: a */
    public final boolean m6513a(int i) {
        boolean z = !this.f13556a.get(i).isCheck();
        this.f13556a.get(i).setCheck(z);
        notifyDataSetChanged();
        return z;
    }

    /* renamed from: a */
    public final int m6514a() {
        int i = 0;
        for (int i2 = 0; i2 < this.f13556a.size(); i2++) {
            if (this.f13556a.get(i2).isCheck()) {
                i++;
            }
        }
        return i;
    }

    /* renamed from: b */
    public final String m6510b() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.f13556a.size(); i++) {
            sb.append(m6509b(i) ? "1" : "0");
        }
        return sb.toString();
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        SimpleDateFormat simpleDateFormat;
        if (view == null) {
            this.f13559d = new C2386a();
            view = this.f13558c.inflate(R.layout.mine_myreport_list_item, (ViewGroup) null);
            this.f13559d.f13562a = (TextView) view.findViewById(R.id.tv_myreport_name);
            this.f13559d.f13564c = (CheckBox) view.findViewById(R.id.cb_list_select);
            this.f13559d.f13565d = (RelativeLayout) view.findViewById(R.id.cb_list_select_container);
            this.f13559d.f13563b = (TextView) view.findViewById(R.id.tv_myreport_time);
            this.f13559d.f13567f = (TextView) view.findViewById(R.id.tip_title);
            this.f13559d.f13566e = view.findViewById(R.id.tip);
            view.setTag(this.f13559d);
        } else {
            this.f13559d = (C2386a) view.getTag();
        }
        List<ReportFileInfo> list = this.f13556a;
        if (list != null) {
            if (list.get(i).getReportName().endsWith(".x431")) {
                this.f13560e = this.f13556a.get(i).getReportName().substring(0, this.f13556a.get(i).getReportName().lastIndexOf("."));
            } else {
                this.f13560e = this.f13556a.get(i).getReportName();
            }
            this.f13559d.f13562a.setText(this.f13560e);
            if (C2744aa.m5166c()) {
                simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss", Locale.ENGLISH);
            } else {
                simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
            }
            this.f13559d.f13563b.setText(simpleDateFormat.format(this.f13556a.get(i).getReportTime()));
        }
        this.f13559d.f13564c.setVisibility(0);
        this.f13559d.f13564c.setChecked(m6509b(i));
        this.f13559d.f13564c.setEnabled(false);
        this.f13559d.f13565d.setVisibility(0);
        this.f13559d.f13565d.setEnabled(false);
        this.f13559d.f13564c.setEnabled(true);
        this.f13559d.f13564c.setOnClickListener(new View$OnClickListenerC2387c(this, i));
        this.f13559d.f13565d.setEnabled(true);
        this.f13559d.f13565d.setOnClickListener(new View$OnClickListenerC2388d(this, i));
        if (i == 0) {
            this.f13559d.f13566e.setVisibility(0);
            this.f13559d.f13567f.setText(this.f13557b.getString(R.string.report_tip_title, Integer.valueOf(this.f13556a.size())));
        } else {
            this.f13559d.f13566e.setVisibility(8);
        }
        view.setId(i);
        return view;
    }
}
