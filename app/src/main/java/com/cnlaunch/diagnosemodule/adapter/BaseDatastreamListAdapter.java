package com.cnlaunch.diagnosemodule.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.cnlaunch.diagnosemodule.bean.BasicDataStreamBean;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class BaseDatastreamListAdapter extends BaseAdapter {
    public ArrayList<BasicDataStreamBean> list;
    private Context mContext;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return view;
    }

    public BaseDatastreamListAdapter(ArrayList<BasicDataStreamBean> arrayList, Context context) {
        this.list = arrayList;
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.list.get(i);
    }
}
