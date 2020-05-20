package com.artifex.mupdflib;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.artifex.mupdflib.ChoosePDFItem;
import java.util.LinkedList;

/* loaded from: classes.dex */
public class ChoosePDFAdapter extends BaseAdapter {
    private final LayoutInflater mInflater;
    private final LinkedList<ChoosePDFItem> mItems = new LinkedList<>();

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    public ChoosePDFAdapter(LayoutInflater layoutInflater) {
        this.mInflater = layoutInflater;
    }

    public void clear() {
        this.mItems.clear();
    }

    public void add(ChoosePDFItem choosePDFItem) {
        this.mItems.add(choosePDFItem);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mItems.size();
    }

    private int iconForType(ChoosePDFItem.Type type) {
        switch (type) {
            case PARENT:
                return C0835R.drawable.ic_arrow_up;
            case DIR:
                return C0835R.drawable.ic_dir;
            case DOC:
                return C0835R.drawable.ic_doc;
            default:
                return 0;
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.mInflater.inflate(C0835R.layout.picker_entry, (ViewGroup) null);
        }
        ChoosePDFItem choosePDFItem = this.mItems.get(i);
        ((TextView) view.findViewById(C0835R.C0836id.name)).setText(choosePDFItem.name);
        ((ImageView) view.findViewById(C0835R.C0836id.icon)).setImageResource(iconForType(choosePDFItem.type));
        ((ImageView) view.findViewById(C0835R.C0836id.icon)).setColorFilter(Color.argb(255, 0, 0, 0));
        return view;
    }
}
