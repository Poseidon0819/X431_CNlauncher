package com.cnlaunch.x431pro.activity.bluetooth;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.cnlaunch.physics.p197c.BluetoothListDto;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;

/* renamed from: com.cnlaunch.x431pro.activity.bluetooth.e */
/* loaded from: classes.dex */
public final class BluetoothListAdapter extends BaseAdapter {

    /* renamed from: a */
    int f10942a = 0;

    /* renamed from: b */
    C1995a f10943b = null;

    /* renamed from: c */
    private ArrayList<BluetoothListDto> f10944c;

    /* renamed from: d */
    private LayoutInflater f10945d;

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    public BluetoothListAdapter(ArrayList<BluetoothListDto> arrayList, Context context) {
        this.f10944c = arrayList;
        this.f10945d = LayoutInflater.from(context);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.f10944c.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        return this.f10944c.get(i);
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            this.f10943b = new C1995a();
            view = this.f10945d.inflate(R.layout.item_list_bluetooth, (ViewGroup) null);
            this.f10943b.f10950e = (ImageView) view.findViewById(R.id.bluetootn_status_img);
            this.f10943b.f10946a = (TextView) view.findViewById(R.id.bluetooth_name);
            this.f10943b.f10947b = (TextView) view.findViewById(R.id.bluetooth_address);
            this.f10943b.f10948c = (TextView) view.findViewById(R.id.bluetooth_pair_status);
            this.f10943b.f10949d = (TextView) view.findViewById(R.id.bluetooth_conn_status);
            view.setTag(this.f10943b);
        } else {
            this.f10943b = (C1995a) view.getTag();
        }
        this.f10943b.f10946a.setText(this.f10944c.get(i).f9844a);
        this.f10943b.f10947b.setText(this.f10944c.get(i).f9845b);
        this.f10943b.f10949d.setText(this.f10944c.get(i).f9846c);
        this.f10943b.f10948c.setText(this.f10944c.get(i).f9848e ? R.string.tv_paired : R.string.tv_unpair);
        if (this.f10944c.get(i).f9848e || this.f10944c.get(i).f9847d) {
            this.f10943b.f10946a.setTextColor(-65536);
            this.f10943b.f10950e.setImageResource(R.drawable.icon_bluetooth_blue);
        } else {
            this.f10943b.f10946a.setTextColor(-16777216);
            this.f10943b.f10950e.setImageResource(R.drawable.icon_bluetooth_disable);
        }
        return view;
    }

    /* compiled from: BluetoothListAdapter.java */
    /* renamed from: com.cnlaunch.x431pro.activity.bluetooth.e$a */
    /* loaded from: classes.dex */
    class C1995a {

        /* renamed from: a */
        TextView f10946a;

        /* renamed from: b */
        TextView f10947b;

        /* renamed from: c */
        TextView f10948c;

        /* renamed from: d */
        TextView f10949d;

        /* renamed from: e */
        ImageView f10950e;

        C1995a() {
        }
    }
}
