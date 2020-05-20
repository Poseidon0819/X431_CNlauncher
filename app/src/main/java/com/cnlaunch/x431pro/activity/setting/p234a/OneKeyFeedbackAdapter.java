package com.cnlaunch.x431pro.activity.setting.p234a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.cnlaunch.x431pro.activity.setting.OneKeyFeedbackFragment;
import com.cnlaunch.x431pro.utils.p282d.DiagnoseLogInfoSearchUtil;
import com.ifoer.expedition.pro.R;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Vector;

@SuppressLint({"SimpleDateFormat"})
/* renamed from: com.cnlaunch.x431pro.activity.setting.a.b */
/* loaded from: classes.dex */
public final class OneKeyFeedbackAdapter extends BaseAdapter {

    /* renamed from: a */
    public Vector<DiagnoseLogInfoSearchUtil.C2749a> f14526a = new Vector<>();

    /* renamed from: b */
    private Context f14527b;

    /* renamed from: c */
    private LayoutInflater f14528c;

    /* renamed from: d */
    private C2516a f14529d;

    /* renamed from: e */
    private OneKeyFeedbackFragment f14530e;

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @SuppressLint({"UseSparseArrays"})
    public OneKeyFeedbackAdapter(Context context, OneKeyFeedbackFragment oneKeyFeedbackFragment) {
        this.f14527b = context;
        this.f14530e = oneKeyFeedbackFragment;
        this.f14528c = LayoutInflater.from(this.f14527b);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        Vector<DiagnoseLogInfoSearchUtil.C2749a> vector = this.f14526a;
        if (vector != null) {
            return vector.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        Vector<DiagnoseLogInfoSearchUtil.C2749a> vector = this.f14526a;
        if (vector == null || vector.size() <= i) {
            return null;
        }
        return this.f14526a.get(i);
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        DiagnoseLogInfoSearchUtil.C2749a c2749a = this.f14526a.get(i);
        if (view == null) {
            this.f14529d = new C2516a();
            view = this.f14528c.inflate(R.layout.onekey_feedback_log_list_item, (ViewGroup) null);
            this.f14529d.f14531a = (CheckBox) view.findViewById(R.id.cb_feedback_logfile_choice);
            this.f14529d.f14532b = (TextView) view.findViewById(R.id.tv_feedback_log_name);
            this.f14529d.f14533c = (TextView) view.findViewById(R.id.tv_feedback_log_filename);
            this.f14529d.f14534d = (TextView) view.findViewById(R.id.tv_feedback_log_time);
            view.setTag(this.f14529d);
        } else {
            this.f14529d = (C2516a) view.getTag();
        }
        if (c2749a != null) {
            String filename = c2749a.getFilename();
            int indexOf = c2749a.getFilename().indexOf(".");
            if (indexOf != -1) {
                filename = c2749a.getFilename().substring(0, indexOf);
            }
            this.f14529d.f14532b.setText(c2749a.getVehicleName());
            this.f14529d.f14533c.setText(filename);
            this.f14529d.f14534d.setText(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).format(new Date(c2749a.getCreateDate())));
            this.f14529d.f14531a.setOnCheckedChangeListener(null);
            this.f14529d.f14531a.setChecked(c2749a.isChecked());
            this.f14529d.f14531a.setOnCheckedChangeListener(new C2517c(this, c2749a));
        }
        return view;
    }

    /* compiled from: OneKeyFeedbackAdapter.java */
    /* renamed from: com.cnlaunch.x431pro.activity.setting.a.b$a */
    /* loaded from: classes.dex */
    public class C2516a {

        /* renamed from: a */
        public CheckBox f14531a;

        /* renamed from: b */
        public TextView f14532b;

        /* renamed from: c */
        public TextView f14533c;

        /* renamed from: d */
        public TextView f14534d;

        public C2516a() {
        }
    }
}
