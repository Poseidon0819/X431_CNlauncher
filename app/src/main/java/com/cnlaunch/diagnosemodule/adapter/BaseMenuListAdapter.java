package com.cnlaunch.diagnosemodule.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.cnlaunch.diagnosemodule.bean.BasicMenuBean;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class BaseMenuListAdapter extends BaseAdapter {
    public ArrayList<BasicMenuBean> list;
    private Context mContext;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public String getMenuListType() {
        return "1";
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return view;
    }

    public BaseMenuListAdapter(ArrayList<BasicMenuBean> arrayList, Context context) {
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

    public String getFeedbackCmd(int i) {
        return String.valueOf(i);
    }
}
