package com.cnlaunch.x431pro.activity.setting.p234a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.cnlaunch.x431pro.module.p263h.p265b.DiagLogHistoryInfo;
import com.cnlaunch.x431pro.utils.C2787z;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.activity.setting.a.d */
/* loaded from: classes.dex */
public final class OneKeyFeedbackHistoryAdapter extends BaseAdapter {

    /* renamed from: a */
    public List<DiagLogHistoryInfo> f14538a = new ArrayList();

    /* renamed from: b */
    private Context f14539b;

    /* renamed from: c */
    private LayoutInflater f14540c;

    /* renamed from: d */
    private C2518a f14541d;

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    public OneKeyFeedbackHistoryAdapter(Context context) {
        this.f14539b = context;
        this.f14540c = LayoutInflater.from(this.f14539b);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        List<DiagLogHistoryInfo> list = this.f14538a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        List<DiagLogHistoryInfo> list = this.f14538a;
        if (list == null || list.size() <= i) {
            return null;
        }
        return this.f14538a.get(i);
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        this.f14541d = new C2518a();
        if (view == null) {
            view = this.f14540c.inflate(R.layout.onekey_feedback_log_history_list_item, (ViewGroup) null);
            this.f14541d.f14544c = (TextView) view.findViewById(R.id.tv_feedback_log_history_filename);
            this.f14541d.f14542a = (TextView) view.findViewById(R.id.tv_feedback_log_history_name);
            this.f14541d.f14545d = (TextView) view.findViewById(R.id.tv_feedback_log_history_remark);
            this.f14541d.f14543b = (TextView) view.findViewById(R.id.tv_feedback_log_history_time);
            this.f14541d.f14546e = (ImageView) view.findViewById(R.id.iv_tip);
            view.setTag(this.f14541d);
        } else {
            this.f14541d = (C2518a) view.getTag();
        }
        DiagLogHistoryInfo diagLogHistoryInfo = this.f14538a.get(i);
        if (diagLogHistoryInfo.getReaded() < diagLogHistoryInfo.getCurrentState()) {
            this.f14541d.f14546e.setVisibility(0);
        } else {
            this.f14541d.f14546e.setVisibility(8);
        }
        List<DiagLogHistoryInfo> list = this.f14538a;
        if (list != null && list.size() > 0 && !TextUtils.isEmpty(this.f14538a.get(i).getSerialNo())) {
            String feedbackTime = this.f14538a.get(i).getFeedbackTime();
            String logName = this.f14538a.get(i).getLogName();
            String substring = logName.substring(this.f14538a.get(i).getSerialNo().length(), logName.indexOf("."));
            String substring2 = substring.substring(0, substring.length() - 14);
            this.f14541d.f14544c.setText(substring);
            this.f14541d.f14542a.setText(substring2);
            this.f14541d.f14543b.setText(feedbackTime);
            this.f14541d.f14545d.setText(C2787z.m4821a(this.f14538a.get(i).getInputContent()) ? "" : this.f14538a.get(i).getInputContent().trim());
        }
        if (this.f14538a.get(i).getCurrentState() == 0) {
            this.f14541d.f14544c.setTextColor(this.f14539b.getResources().getColor(R.color.center_red));
            this.f14541d.f14542a.setTextColor(this.f14539b.getResources().getColor(R.color.center_red));
            this.f14541d.f14543b.setTextColor(this.f14539b.getResources().getColor(R.color.center_red));
            this.f14541d.f14545d.setTextColor(this.f14539b.getResources().getColor(R.color.center_red));
        } else if (this.f14538a.get(i).getCurrentState() == 2) {
            this.f14541d.f14544c.setTextColor(this.f14539b.getResources().getColor(R.color.black));
            this.f14541d.f14542a.setTextColor(this.f14539b.getResources().getColor(R.color.black));
            this.f14541d.f14543b.setTextColor(this.f14539b.getResources().getColor(R.color.black));
            this.f14541d.f14545d.setTextColor(this.f14539b.getResources().getColor(R.color.black));
        } else {
            this.f14541d.f14544c.setTextColor(this.f14539b.getResources().getColor(R.color.center_blue));
            this.f14541d.f14542a.setTextColor(this.f14539b.getResources().getColor(R.color.center_blue));
            this.f14541d.f14543b.setTextColor(this.f14539b.getResources().getColor(R.color.center_blue));
            this.f14541d.f14545d.setTextColor(this.f14539b.getResources().getColor(R.color.center_blue));
        }
        return view;
    }

    /* compiled from: OneKeyFeedbackHistoryAdapter.java */
    /* renamed from: com.cnlaunch.x431pro.activity.setting.a.d$a */
    /* loaded from: classes.dex */
    public class C2518a {

        /* renamed from: a */
        public TextView f14542a;

        /* renamed from: b */
        public TextView f14543b;

        /* renamed from: c */
        public TextView f14544c;

        /* renamed from: d */
        public TextView f14545d;

        /* renamed from: e */
        public ImageView f14546e;

        public C2518a() {
        }
    }
}
