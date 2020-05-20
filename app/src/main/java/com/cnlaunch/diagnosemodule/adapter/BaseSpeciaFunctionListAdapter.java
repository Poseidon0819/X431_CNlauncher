package com.cnlaunch.diagnosemodule.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.cnlaunch.diagnosemodule.bean.BasicSpeciaFunctionBean;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class BaseSpeciaFunctionListAdapter extends BaseAdapter {
    public int colums;
    public ArrayList<BasicSpeciaFunctionBean> list;
    private Context mContext;

    public String getFeedbackType() {
        return DiagnoseConstants.FEEDBACK_SPECIA_FUNCTION;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return view;
    }

    public BaseSpeciaFunctionListAdapter(ArrayList<BasicSpeciaFunctionBean> arrayList, Context context, int i) {
        this.colums = 2;
        this.list = arrayList;
        this.mContext = context;
        this.colums = i;
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
        return String.valueOf((i / this.colums) + 80);
    }
}
