package com.cnlaunch.x431pro.activity.CloudDiagnose;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cnlaunch.x431pro.module.cloud.model.CloudReportListInfo;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.ifoer.expedition.pro.R;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.activity.CloudDiagnose.f */
/* loaded from: classes.dex */
public final class CloudHistoryAdapter extends BaseAdapter {

    /* renamed from: a */
    CloudHistoryFragment f10621a;

    /* renamed from: b */
    private LayoutInflater f10622b;

    /* renamed from: c */
    private Context f10623c;

    /* renamed from: d */
    private List<CloudReportListInfo> f10624d;

    /* renamed from: e */
    private C1955b f10625e;

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    /* compiled from: CloudHistoryAdapter.java */
    /* renamed from: com.cnlaunch.x431pro.activity.CloudDiagnose.f$a */
    /* loaded from: classes.dex */
    public enum EnumC1954a {
        A,
        R,
        X,
        G,
        T,
        NOVALUE;

        public static EnumC1954a toType(String str) {
            try {
                return valueOf(str);
            } catch (Exception unused) {
                return NOVALUE;
            }
        }
    }

    public CloudHistoryAdapter(Context context) {
        this.f10622b = LayoutInflater.from(context);
        this.f10623c = context;
    }

    /* renamed from: a */
    public final void m7928a(List<CloudReportListInfo> list) {
        this.f10624d = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        List<CloudReportListInfo> list = this.f10624d;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        List<CloudReportListInfo> list = this.f10624d;
        if (list == null) {
            return null;
        }
        return list.get(i);
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f10622b.inflate(R.layout.item_cloud_history, (ViewGroup) null);
            this.f10625e = new C1955b();
            this.f10625e.f10632a = (ImageView) view.findViewById(R.id.image_report_type);
            this.f10625e.f10639h = (Button) view.findViewById(R.id.btn_diagnose);
            this.f10625e.f10633b = (TextView) view.findViewById(R.id.tv_time_year);
            this.f10625e.f10634c = (TextView) view.findViewById(R.id.tv_time_data);
            this.f10625e.f10635d = (TextView) view.findViewById(R.id.tv_report_type);
            this.f10625e.f10636e = (TextView) view.findViewById(R.id.tv_repair);
            this.f10625e.f10637f = (TextView) view.findViewById(R.id.tv_address);
            this.f10625e.f10638g = (TextView) view.findViewById(R.id.tv_code_number);
            this.f10625e.f10640i = (LinearLayout) view.findViewById(R.id.btn_click);
            view.setTag(this.f10625e);
        } else {
            this.f10625e = (C1955b) view.getTag();
        }
        CloudReportListInfo cloudReportListInfo = this.f10624d.get(i);
        TextView textView = this.f10625e.f10638g;
        StringBuilder sb = new StringBuilder();
        sb.append(cloudReportListInfo.getDtcnumber());
        textView.setText(sb.toString());
        switch (EnumC1954a.toType(cloudReportListInfo.getReport_type())) {
            case X:
                this.f10625e.f10635d.setText(R.string.x431_type);
                break;
            case A:
                this.f10625e.f10635d.setText(R.string.ait_type);
                break;
            case G:
                this.f10625e.f10635d.setText(R.string.golo_type);
                break;
            case T:
                this.f10625e.f10635d.setText(R.string.remote_help_type);
                break;
            case R:
                this.f10625e.f10635d.setText(R.string.red_type);
                break;
        }
        long intValue = Integer.valueOf(cloudReportListInfo.getRec_date()).intValue();
        this.f10625e.f10633b.setText(C2744aa.m5173b(intValue, "yyyy"));
        this.f10625e.f10634c.setText(C2744aa.m5173b(intValue, "MM/dd"));
        this.f10625e.f10637f.setText(C2744aa.m5173b(intValue, "HH:mm"));
        this.f10625e.f10639h.setOnClickListener(new View$OnClickListenerC1956g(this, cloudReportListInfo));
        this.f10625e.f10640i.setOnClickListener(new View$OnClickListenerC1957h(this, i));
        return view;
    }

    /* compiled from: CloudHistoryAdapter.java */
    /* renamed from: com.cnlaunch.x431pro.activity.CloudDiagnose.f$b */
    /* loaded from: classes.dex */
    class C1955b {

        /* renamed from: a */
        ImageView f10632a;

        /* renamed from: b */
        TextView f10633b;

        /* renamed from: c */
        TextView f10634c;

        /* renamed from: d */
        TextView f10635d;

        /* renamed from: e */
        TextView f10636e;

        /* renamed from: f */
        TextView f10637f;

        /* renamed from: g */
        TextView f10638g;

        /* renamed from: h */
        Button f10639h;

        /* renamed from: i */
        LinearLayout f10640i;

        C1955b() {
        }
    }
}
