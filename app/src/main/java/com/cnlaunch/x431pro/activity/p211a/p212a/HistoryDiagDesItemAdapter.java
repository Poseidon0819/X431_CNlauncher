package com.cnlaunch.x431pro.activity.p211a.p212a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cnlaunch.x431pro.activity.p211a.HistoryFragment;
import com.cnlaunch.x431pro.module.history.model.VehicleInfo;
import com.ifoer.expedition.pro.R;
import java.util.List;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

/* renamed from: com.cnlaunch.x431pro.activity.a.a.c */
/* loaded from: classes.dex */
public final class HistoryDiagDesItemAdapter extends BaseAdapter {

    /* renamed from: c */
    public HistoryFragment f10808c;

    /* renamed from: d */
    private Context f10809d;

    /* renamed from: e */
    private LayoutInflater f10810e;

    /* renamed from: f */
    private C1971a f10811f;

    /* renamed from: b */
    public int f10807b = -1;

    /* renamed from: g */
    private boolean f10812g = false;

    /* renamed from: a */
    public List<VehicleInfo> f10806a = null;

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    /* renamed from: a */
    public final void m7844a(boolean z) {
        this.f10812g = z;
        if (!z) {
            m7847a();
        }
        notifyDataSetChanged();
    }

    public HistoryDiagDesItemAdapter(Context context) {
        this.f10809d = context;
        this.f10810e = LayoutInflater.from(this.f10809d);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        List<VehicleInfo> list = this.f10806a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        return this.f10806a.get(i);
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        VehicleInfo vehicleInfo = (VehicleInfo) getItem(i);
        if (vehicleInfo == null) {
            return null;
        }
        if (view == null) {
            this.f10811f = new C1971a();
            view = this.f10810e.inflate(R.layout.history_diag_information_gridview_item, (ViewGroup) null);
            this.f10811f.f10813a = (LinearLayout) view.findViewById(R.id.layout_history_diag_item);
            this.f10811f.f10818f = (CheckBox) view.findViewById(R.id.cb_item_select);
            this.f10811f.f10815c = (TextView) view.findViewById(R.id.tv_show_date);
            this.f10811f.f10814b = (TextView) view.findViewById(R.id.tv_show_engine);
            this.f10811f.f10816d = (TextView) view.findViewById(R.id.tv_show_DTC_number);
            this.f10811f.f10817e = (TextView) view.findViewById(R.id.btn_goto_Diagnose);
            view.setTag(this.f10811f);
        } else {
            this.f10811f = (C1971a) view.getTag();
        }
        this.f10811f.f10817e.setOnClickListener(new View$OnClickListenerC1972d(this, i, vehicleInfo));
        C1971a c1971a = this.f10811f;
        c1971a.f10819g = i;
        c1971a.f10813a.setOnClickListener(new View$OnClickListenerC1973e(this, i));
        this.f10811f.f10818f.setOnClickListener(new View$OnClickListenerC1974f(this, i));
        boolean z = false;
        this.f10811f.f10818f.setVisibility(this.f10812g ? 0 : 8);
        CheckBox checkBox = this.f10811f.f10818f;
        List<VehicleInfo> list = this.f10806a;
        if (list != null && list.size() > 0 && this.f10806a.get(i).getSelectState() == 1) {
            z = true;
        }
        checkBox.setChecked(z);
        if (vehicleInfo != null) {
            this.f10811f.f10815c.setText(vehicleInfo.getTimeStamp());
            String trim = TextUtils.isEmpty(vehicleInfo.getCar_name()) ? vehicleInfo.getVehicleUID().trim() : vehicleInfo.getCar_name();
            if ("BENZ".equalsIgnoreCase(trim)) {
                trim = "MERCEDES";
            }
            TextView textView = this.f10811f.f10814b;
            textView.setText(trim.toUpperCase() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + vehicleInfo.getModel() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + vehicleInfo.getYear());
            TextView textView2 = this.f10811f.f10816d;
            StringBuilder sb = new StringBuilder();
            sb.append(this.f10809d.getString(R.string.Historical_records_DTC_Num_txt));
            sb.append(vehicleInfo.getNumDTC());
            textView2.setText(sb.toString());
            if (vehicleInfo.getNumDTC().equalsIgnoreCase("0")) {
                view.setBackgroundResource(R.drawable.history_item_press);
            } else {
                view.setBackgroundResource(R.drawable.history_item_normal);
            }
        }
        return view;
    }

    /* renamed from: a */
    public final boolean m7846a(int i) {
        int i2 = this.f10806a.get(i).getSelectState() == 0 ? 1 : 0;
        this.f10806a.get(i).setSelectState(i2);
        notifyDataSetChanged();
        return i2 == 1;
    }

    /* renamed from: a */
    public final void m7847a() {
        List<VehicleInfo> list = this.f10806a;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (int i = 0; i < this.f10806a.size(); i++) {
            this.f10806a.get(i).setSelectState(0);
        }
        notifyDataSetChanged();
    }

    /* compiled from: HistoryDiagDesItemAdapter.java */
    /* renamed from: com.cnlaunch.x431pro.activity.a.a.c$a */
    /* loaded from: classes.dex */
    public class C1971a {

        /* renamed from: a */
        public LinearLayout f10813a;

        /* renamed from: b */
        public TextView f10814b;

        /* renamed from: c */
        public TextView f10815c;

        /* renamed from: d */
        public TextView f10816d;

        /* renamed from: e */
        public TextView f10817e;

        /* renamed from: f */
        public CheckBox f10818f;

        /* renamed from: g */
        public int f10819g;

        public C1971a() {
        }
    }
}
