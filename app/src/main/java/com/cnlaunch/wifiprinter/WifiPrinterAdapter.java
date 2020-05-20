package com.cnlaunch.wifiprinter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.cnlaunch.wifiprinter.C1900at;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.cnlaunch.wifiprinter.ax */
/* loaded from: classes.dex */
public final class WifiPrinterAdapter extends BaseAdapter {

    /* renamed from: a */
    private LayoutInflater f10417a;

    /* renamed from: b */
    private List<PrinterWifiInfo> f10418b;

    /* renamed from: c */
    private Context f10419c;

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    /* compiled from: WifiPrinterAdapter.java */
    /* renamed from: com.cnlaunch.wifiprinter.ax$a */
    /* loaded from: classes.dex */
    class C1912a {

        /* renamed from: a */
        TextView f10420a;

        C1912a() {
        }
    }

    public WifiPrinterAdapter(List<PrinterWifiInfo> list, Context context) {
        this.f10418b = new ArrayList();
        this.f10418b = list;
        this.f10419c = context;
        this.f10417a = LayoutInflater.from(context);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        List<PrinterWifiInfo> list = this.f10418b;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        return this.f10418b.get(i);
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        C1912a c1912a;
        if (view == null) {
            c1912a = new C1912a();
            view2 = this.f10417a.inflate(C1900at.C1906f.wifi_list, (ViewGroup) null);
            c1912a.f10420a = (TextView) view2.findViewById(C1900at.C1905e.ssid);
            view2.setTag(c1912a);
        } else {
            view2 = view;
            c1912a = (C1912a) view.getTag();
        }
        if (!"".equals(this.f10418b.get(i).f10405a) && this.f10418b.get(i).f10405a != null) {
            c1912a.f10420a.setText(this.f10418b.get(i).f10405a.toString());
        }
        return view2;
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
    }
}
