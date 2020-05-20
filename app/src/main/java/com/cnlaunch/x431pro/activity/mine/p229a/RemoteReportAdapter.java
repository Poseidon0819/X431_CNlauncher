package com.cnlaunch.x431pro.activity.mine.p229a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.cnlaunch.x431pro.module.report.p277b.DownLoadReportInfo;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.ifoer.expedition.pro.R;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

/* renamed from: com.cnlaunch.x431pro.activity.mine.a.g */
/* loaded from: classes.dex */
public final class RemoteReportAdapter extends BaseAdapter {

    /* renamed from: a */
    public ArrayList<DownLoadReportInfo> f13590a;

    /* renamed from: b */
    private Context f13591b;

    /* renamed from: c */
    private LayoutInflater f13592c;

    /* renamed from: d */
    private C2391a f13593d = null;

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    public RemoteReportAdapter(Context context, ArrayList<DownLoadReportInfo> arrayList) {
        this.f13590a = null;
        this.f13591b = context;
        this.f13590a = arrayList;
        this.f13592c = LayoutInflater.from(context);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        ArrayList<DownLoadReportInfo> arrayList = this.f13590a;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        return Integer.valueOf(i);
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            this.f13593d = new C2391a();
            view = this.f13592c.inflate(R.layout.item_list_remote_report, (ViewGroup) null);
            this.f13593d.f13596c = (TextView) view.findViewById(R.id.tv_report_name);
            this.f13593d.f13597d = (TextView) view.findViewById(R.id.tv_diagnose_time);
            this.f13593d.f13595b = (TextView) view.findViewById(R.id.tip_title);
            this.f13593d.f13594a = view.findViewById(R.id.tip);
            view.setTag(this.f13593d);
        } else {
            this.f13593d = (C2391a) view.getTag();
        }
        if (i == 0) {
            this.f13593d.f13594a.setVisibility(0);
            this.f13593d.f13595b.setText(this.f13591b.getString(R.string.report_tip_title, Integer.valueOf(this.f13590a.size())));
        } else {
            this.f13593d.f13594a.setVisibility(8);
        }
        this.f13593d.f13596c.setText(this.f13590a.get(i).getTheme());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        try {
            if (C2744aa.m5166c()) {
                this.f13593d.f13597d.setText(simpleDateFormat.format(simpleDateFormat.parse(this.f13590a.get(i).getDiagnosis_time())));
            } else {
                this.f13593d.f13597d.setText(simpleDateFormat2.format(simpleDateFormat.parse(this.f13590a.get(i).getDiagnosis_time())));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return view;
    }

    /* compiled from: RemoteReportAdapter.java */
    /* renamed from: com.cnlaunch.x431pro.activity.mine.a.g$a */
    /* loaded from: classes.dex */
    class C2391a {

        /* renamed from: a */
        View f13594a;

        /* renamed from: b */
        TextView f13595b;

        /* renamed from: c */
        TextView f13596c;

        /* renamed from: d */
        TextView f13597d;

        C2391a() {
        }
    }
}
