package com.cnlaunch.diagnosemodule.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.cnlaunch.diagnosemodule.bean.BasicSelectMenuBean;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class BaseSelectMenuListAdapter extends BaseAdapter {
    public ArrayList<BasicSelectMenuBean> list;
    private Context mContext;

    public String getFeedbackType() {
        return "1";
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }

    public BaseSelectMenuListAdapter(ArrayList<BasicSelectMenuBean> arrayList, Context context) {
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
