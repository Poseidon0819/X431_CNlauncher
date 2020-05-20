package com.cnlaunch.x431pro.activity.diagnose.p218a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.cnlaunch.diagnosemodule.bean.BasicFaultCodeBean;
import com.cnlaunch.diagnosemodule.bean.BasicSystemStatusBean;
import com.ifoer.expedition.pro.R;
import java.util.List;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

/* renamed from: com.cnlaunch.x431pro.activity.diagnose.a.w */
/* loaded from: classes.dex */
public final class SystemContentsTableAdapter extends BaseAdapter {

    /* renamed from: a */
    private Context f11441a;

    /* renamed from: b */
    private LayoutInflater f11442b;

    /* renamed from: c */
    private List<BasicSystemStatusBean> f11443c;

    /* renamed from: d */
    private C2035a f11444d;

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    public SystemContentsTableAdapter(Context context, List<BasicSystemStatusBean> list) {
        this.f11441a = context;
        this.f11442b = LayoutInflater.from(this.f11441a);
        this.f11443c = list;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.f11443c.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        return this.f11443c.get(i);
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f11442b.inflate(R.layout.system_contents_table_list_item, (ViewGroup) null);
            this.f11444d = new C2035a();
            this.f11444d.f11445a = (TextView) view.findViewById(R.id.tv_item_name);
            this.f11444d.f11446b = (TextView) view.findViewById(R.id.tv_item_status);
            this.f11444d.f11447c = (TextView) view.findViewById(R.id.tv_item_description);
            view.setTag(this.f11444d);
        } else {
            this.f11444d = (C2035a) view.getTag();
        }
        BasicSystemStatusBean basicSystemStatusBean = this.f11443c.get(i);
        String trim = basicSystemStatusBean.getSystemName().trim();
        String str = "";
        String string = this.f11441a.getString(R.string.report_codes);
        String concat = "0 ".concat(String.valueOf(string));
        if (basicSystemStatusBean.getSystemFaultCodeBean() != null && !basicSystemStatusBean.getSystemFaultCodeBean().isEmpty()) {
            if (basicSystemStatusBean.getSystemFaultCodeBean().size() == 1) {
                concat = "1 ".concat(String.valueOf(string));
            } else {
                concat = basicSystemStatusBean.getSystemFaultCodeBean().size() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + string;
            }
            int i2 = 0;
            while (i2 < basicSystemStatusBean.getSystemFaultCodeBean().size()) {
                BasicFaultCodeBean basicFaultCodeBean = basicSystemStatusBean.getSystemFaultCodeBean().get(i2);
                StringBuilder sb = new StringBuilder();
                int i3 = i2 + 1;
                sb.append(i3);
                sb.append(".");
                sb.append(basicFaultCodeBean.getTitle());
                sb.append(": ");
                sb.append(basicFaultCodeBean.getContext());
                str = str.concat(sb.toString());
                if (i2 != basicSystemStatusBean.getSystemFaultCodeBean().size() - 1) {
                    str = str.concat("\n");
                }
                i2 = i3;
            }
            this.f11444d.f11445a.setTextColor(-65536);
        } else {
            str = "";
            this.f11444d.f11445a.setTextColor(-16777216);
        }
        this.f11444d.f11445a.setText(trim);
        this.f11444d.f11446b.setText(concat);
        this.f11444d.f11447c.setText(str);
        return view;
    }

    /* compiled from: SystemContentsTableAdapter.java */
    /* renamed from: com.cnlaunch.x431pro.activity.diagnose.a.w$a */
    /* loaded from: classes.dex */
    class C2035a {

        /* renamed from: a */
        TextView f11445a;

        /* renamed from: b */
        TextView f11446b;

        /* renamed from: c */
        TextView f11447c;

        C2035a() {
        }
    }
}
