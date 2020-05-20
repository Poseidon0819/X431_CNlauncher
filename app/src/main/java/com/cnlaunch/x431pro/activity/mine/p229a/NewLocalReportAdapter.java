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
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.x431pro.module.p252d.p254b.DiagReportOrHistoryInfo;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.ifoer.expedition.pro.R;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

/* renamed from: com.cnlaunch.x431pro.activity.mine.a.e */
/* loaded from: classes.dex */
public final class NewLocalReportAdapter extends BaseAdapter {

    /* renamed from: a */
    public List<DiagReportOrHistoryInfo> f13573a;

    /* renamed from: b */
    private Context f13574b;

    /* renamed from: c */
    private LayoutInflater f13575c;

    /* renamed from: d */
    private C2389a f13576d;

    /* renamed from: e */
    private String f13577e;

    /* renamed from: f */
    private Handler f13578f;

    /* renamed from: g */
    private boolean f13579g = false;

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    public NewLocalReportAdapter(Context context, List<DiagReportOrHistoryInfo> list, Handler handler) {
        this.f13574b = context;
        this.f13575c = LayoutInflater.from(this.f13574b);
        this.f13573a = list;
        this.f13578f = handler;
    }

    /* renamed from: a */
    public final void m6504a(List<DiagReportOrHistoryInfo> list) {
        this.f13573a = list;
        notifyDataSetChanged();
    }

    /* compiled from: NewLocalReportAdapter.java */
    /* renamed from: com.cnlaunch.x431pro.activity.mine.a.e$a */
    /* loaded from: classes.dex */
    class C2389a {

        /* renamed from: a */
        TextView f13580a;

        /* renamed from: b */
        TextView f13581b;

        /* renamed from: c */
        TextView f13582c;

        /* renamed from: d */
        CheckBox f13583d;

        /* renamed from: e */
        RelativeLayout f13584e;

        /* renamed from: f */
        View f13585f;

        /* renamed from: g */
        TextView f13586g;

        C2389a() {
        }
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        List<DiagReportOrHistoryInfo> list = this.f13573a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        return this.f13573a.get(i);
    }

    /* renamed from: a */
    private boolean m6506a(int i) {
        List<DiagReportOrHistoryInfo> list = this.f13573a;
        if (list == null || list.size() <= 0) {
            return false;
        }
        return this.f13573a.get(i).isCheck();
    }

    /* renamed from: a */
    public final int m6507a() {
        int i = 0;
        for (int i2 = 0; i2 < this.f13573a.size(); i2++) {
            if (this.f13573a.get(i2).isCheck()) {
                i++;
            }
        }
        return i;
    }

    /* renamed from: b */
    public final String m6503b() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.f13573a.size(); i++) {
            sb.append(m6506a(i) ? "1" : "0");
        }
        return sb.toString();
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            this.f13576d = new C2389a();
            view = this.f13575c.inflate(R.layout.mine_myreport_list_item, (ViewGroup) null);
            this.f13576d.f13580a = (TextView) view.findViewById(R.id.tv_myreport_name);
            this.f13576d.f13581b = (TextView) view.findViewById(R.id.tv_repair_type);
            this.f13576d.f13581b.setVisibility(0);
            this.f13576d.f13583d = (CheckBox) view.findViewById(R.id.cb_list_select);
            this.f13576d.f13584e = (RelativeLayout) view.findViewById(R.id.cb_list_select_container);
            this.f13576d.f13582c = (TextView) view.findViewById(R.id.tv_myreport_time);
            this.f13576d.f13586g = (TextView) view.findViewById(R.id.tip_title);
            this.f13576d.f13585f = view.findViewById(R.id.tip);
            view.setTag(this.f13576d);
        } else {
            this.f13576d = (C2389a) view.getTag();
        }
        List<DiagReportOrHistoryInfo> list = this.f13573a;
        if (list != null) {
            DiagReportOrHistoryInfo diagReportOrHistoryInfo = list.get(i);
            this.f13577e = diagReportOrHistoryInfo.getPdfFileName();
            if (this.f13577e.endsWith(".x431") || this.f13577e.endsWith(".pdf")) {
                this.f13577e = this.f13577e.substring(this.f13573a.get(i).getPdfFileName().lastIndexOf("/") + 1, this.f13573a.get(i).getPdfFileName().lastIndexOf("."));
            }
            this.f13576d.f13580a.setText(this.f13577e);
            if (diagReportOrHistoryInfo.getType() == 5) {
                this.f13576d.f13581b.setText("");
            } else if (diagReportOrHistoryInfo.getRepairType() == 0) {
                this.f13576d.f13581b.setText(R.string.diagnostic);
            } else if (diagReportOrHistoryInfo.getRepairType() == 1) {
                this.f13576d.f13581b.setText(R.string.pre_repair);
            } else {
                this.f13576d.f13581b.setText(R.string.post_repair);
            }
            if (C2744aa.m5128p(this.f13574b)) {
                this.f13576d.f13582c.setText(diagReportOrHistoryInfo.getStrTime());
            } else {
                NLog.m9451c("msp", "reportOrHistoryInfo:" + diagReportOrHistoryInfo.toString());
                String[] split = diagReportOrHistoryInfo.getStrTime().split(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                if (C2744aa.m5166c()) {
                    Locale locale = Locale.ENGLISH;
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", locale);
                    Date date = new Date();
                    try {
                        date = simpleDateFormat.parse(split[0]);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("MM-dd-yyyy", locale);
                    TextView textView = this.f13576d.f13582c;
                    textView.setText(simpleDateFormat2.format(date) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + split[1]);
                } else {
                    this.f13576d.f13582c.setText(diagReportOrHistoryInfo.getStrTime());
                }
            }
        }
        this.f13576d.f13583d.setVisibility(0);
        this.f13576d.f13583d.setChecked(m6506a(i));
        this.f13576d.f13583d.setEnabled(false);
        this.f13576d.f13583d.setEnabled(true);
        this.f13576d.f13583d.setOnClickListener(new View$OnClickListenerC2390f(this, i));
        if (m6506a(i)) {
            view.setActivated(true);
        } else {
            view.setActivated(false);
        }
        if (i == 0) {
            this.f13576d.f13585f.setVisibility(0);
            this.f13576d.f13586g.setText(this.f13574b.getString(R.string.report_tip_title, Integer.valueOf(this.f13573a.size())));
        } else {
            this.f13576d.f13585f.setVisibility(8);
        }
        if (this.f13579g) {
            this.f13576d.f13583d.setVisibility(8);
        }
        view.setId(i);
        return view;
    }
}
