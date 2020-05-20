package com.cnlaunch.wifiprinter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.cnlaunch.wifiprinter.C1900at;

/* renamed from: com.cnlaunch.wifiprinter.au */
/* loaded from: classes.dex */
public final class TestArrayAdapter extends ArrayAdapter<String> {

    /* renamed from: a */
    private Context f10407a;

    /* renamed from: b */
    private String[] f10408b;

    public TestArrayAdapter(Context context, String[] strArr) {
        super(context, 17367048, strArr);
        this.f10407a = context;
        this.f10408b = strArr;
    }

    @Override // android.widget.ArrayAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public final View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.f10407a).inflate(17367049, viewGroup, false);
        }
        TextView textView = (TextView) view.findViewById(16908308);
        textView.setText(this.f10408b[i]);
        textView.setTextSize(this.f10407a.getResources().getDimension(C1900at.C1903c.marginpx1));
        textView.setTextColor(this.f10407a.getResources().getColor(C1900at.C1902b.black));
        return view;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.f10407a).inflate(17367048, viewGroup, false);
        }
        TextView textView = (TextView) view.findViewById(16908308);
        textView.setText(this.f10408b[i]);
        textView.setTextSize(this.f10407a.getResources().getDimension(C1900at.C1903c.marginpx1));
        textView.setTextColor(-16777216);
        return view;
    }
}
