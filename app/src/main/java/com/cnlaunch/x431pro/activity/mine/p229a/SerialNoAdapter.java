package com.cnlaunch.x431pro.activity.mine.p229a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.x431pro.activity.mine.SerialNumberFragment;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.utils.p283db.SerialNumber;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.activity.mine.a.h */
/* loaded from: classes.dex */
public class SerialNoAdapter extends BaseAdapter {

    /* renamed from: a */
    private static final String f13599a = "h";

    /* renamed from: b */
    private LayoutInflater f13600b;

    /* renamed from: c */
    private Context f13601c;

    /* renamed from: d */
    private List<SerialNumber> f13602d;

    /* renamed from: e */
    private SerialNumberFragment f13603e;

    /* renamed from: f */
    private String f13604f;

    /* renamed from: g */
    private String f13605g;

    /* renamed from: h */
    private String f13606h;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public SerialNoAdapter(List<SerialNumber> list, Context context, SerialNumberFragment serialNumberFragment) {
        this.f13602d = new ArrayList();
        this.f13602d = list;
        this.f13601c = context;
        this.f13603e = serialNumberFragment;
        this.f13600b = LayoutInflater.from(context);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<SerialNumber> list = this.f13602d;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f13602d.get(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        C2392a c2392a;
        if (view == null) {
            c2392a = new C2392a();
            view2 = this.f13600b.inflate(R.layout.mine_serialno_item, (ViewGroup) null);
            c2392a.f13607a = (TextView) view2.findViewById(R.id.tv_serial_number);
            c2392a.f13608b = (ImageView) view2.findViewById(R.id.iv_checkbox);
            c2392a.f13609c = (ImageButton) view2.findViewById(R.id.btn_spinner_down);
            c2392a.f13610d = (RelativeLayout) view2.findViewById(R.id.relat_item_root);
            view2.setTag(c2392a);
        } else {
            view2 = view;
            c2392a = (C2392a) view.getTag();
        }
        SerialNumber serialNumber = this.f13602d.get(i);
        if (serialNumber != null && !TextUtils.isEmpty(serialNumber.f15834d)) {
            c2392a.f13607a.setText(serialNumber.f15834d);
        }
        this.f13604f = PreferencesManager.m9595a(this.f13601c).m9591a("carSerialNo");
        this.f13605g = PreferencesManager.m9595a(this.f13601c).m9591a("heavydutySerialNo");
        this.f13606h = PreferencesManager.m9595a(this.f13601c).m9591a("carAndHeavydutySerialNo");
        if (C2744aa.m5161c(serialNumber.f15834d, this.f13601c)) {
            if (!TextUtils.isEmpty(this.f13606h) && this.f13606h.equals(serialNumber.f15834d)) {
                c2392a.f13608b.setImageResource(R.drawable.checkbox_red_cheched);
            } else {
                c2392a.f13608b.setImageResource(R.drawable.checkbox_red_normal);
            }
        } else if (!TextUtils.isEmpty(this.f13604f) && this.f13604f.equals(serialNumber.f15834d)) {
            c2392a.f13608b.setImageResource(R.drawable.checkbox_red_cheched);
        } else if (!TextUtils.isEmpty(this.f13605g) && this.f13605g.equals(serialNumber.f15834d)) {
            c2392a.f13608b.setImageResource(R.drawable.checkbox_red_cheched);
        } else {
            c2392a.f13608b.setImageResource(R.drawable.checkbox_red_normal);
        }
        c2392a.f13609c.setOnClickListener(new View$OnClickListenerC2393i(this, c2392a, i));
        return view2;
    }

    /* compiled from: SerialNoAdapter.java */
    /* renamed from: com.cnlaunch.x431pro.activity.mine.a.h$a */
    /* loaded from: classes.dex */
    class C2392a {

        /* renamed from: a */
        TextView f13607a;

        /* renamed from: b */
        ImageView f13608b;

        /* renamed from: c */
        ImageButton f13609c;

        /* renamed from: d */
        RelativeLayout f13610d;

        C2392a() {
        }
    }
}
