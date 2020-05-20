package com.artifex.mupdflib;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/* loaded from: classes.dex */
public class OutlineAdapter extends BaseAdapter {
    private final LayoutInflater mInflater;
    private final OutlineItem[] mItems;

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    public OutlineAdapter(LayoutInflater layoutInflater, OutlineItem[] outlineItemArr) {
        this.mInflater = layoutInflater;
        this.mItems = outlineItemArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mItems.length;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.mInflater.inflate(C0835R.layout.outline_entry, (ViewGroup) null);
        }
        int i2 = this.mItems[i].level;
        if (i2 > 8) {
            i2 = 8;
        }
        String str = "";
        for (int i3 = 0; i3 < i2; i3++) {
            str = str + "   ";
        }
        ((TextView) view.findViewById(C0835R.C0836id.title)).setText(str + this.mItems[i].title);
        ((TextView) view.findViewById(C0835R.C0836id.page)).setText(String.valueOf(this.mItems[i].page + 1));
        return view;
    }
}
